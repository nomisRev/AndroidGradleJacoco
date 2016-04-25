package be.vergauwen.simon.androidgradlejacoco.ui

import be.vergauwen.simon.androidgradlejacoco.core.model.GitHubRepo
import be.vergauwen.simon.androidgradlejacoco.core.rx.Transformers
import be.vergauwen.simon.androidgradlejacoco.core.service.GithubAPI
import be.vergauwen.simon.himurakotlin.MVPPresenter
import rx.Observable
import rx.Subscriber
import javax.inject.Inject

class ExamplePresenter @Inject constructor(private val githubAPI: GithubAPI, private val transfomers: Transformers)
: MVPPresenter<ExampleContract.View>(), ExampleContract.Presenter<ExampleContract.View> {

  override fun getRepos() {
    githubAPI.getRepos()
        .flatMap { Observable.from(it) }
        .compose (transfomers.applyIOSchedulers<GitHubRepo>())
        .filter { it != null }
        .subscribe(object : Subscriber<GitHubRepo>() {
          override fun onCompleted() {
          }

          override fun onError(e: Throwable?) {
            getView()?.showError()
          }

          override fun onNext(t: GitHubRepo) {
            getView()?.printRepo(t.name)
          }
        })
  }
}