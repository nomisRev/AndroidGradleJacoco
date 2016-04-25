package be.vergauwen.simon.himurakotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MVPActivity<V : MVPContract.View, P : MVPContract.Presenter<V>> : AppCompatActivity(), MVPContract.View {

  protected val presenter: P by lazy { createPresenter() }
  protected abstract fun createPresenter(): P

  //This happens under the hood in java.
  @Suppress("UNCHECKED_CAST")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this as V)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}