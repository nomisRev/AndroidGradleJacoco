package be.vergauwen.simon.androidgradlejacoco.core.service

import be.vergauwen.simon.androidgradlejacoco.core.model.GitHubRepo
import rx.Observable

class MockGithubAPI() : GithubAPI {

  val repos = listOf(GitHubRepo("test", "www.test.com", "test_desc"))
  var throwError = false

  override fun getRepos(): Observable<List<GitHubRepo>> {
    return if (throwError) Observable.error(Exception("exception")) else Observable.just(repos)
  }
}