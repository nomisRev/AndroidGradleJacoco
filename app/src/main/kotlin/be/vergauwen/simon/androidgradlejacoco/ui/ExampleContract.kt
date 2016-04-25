package be.vergauwen.simon.androidgradlejacoco.ui

import be.vergauwen.simon.himurakotlin.MVPContract

interface ExampleContract {
  interface View : MVPContract.View {
    fun printRepo(repoName: String)
    fun showError()
  }

  interface Presenter<V : MVPContract.View> : MVPContract.Presenter<V> {
    fun getRepos()
  }

  interface Component<V : MVPContract.View, P : MVPContract.Presenter<V>> : MVPContract.Component<V, P>
}