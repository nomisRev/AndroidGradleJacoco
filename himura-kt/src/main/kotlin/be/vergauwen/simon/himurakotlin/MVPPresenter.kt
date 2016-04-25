package be.vergauwen.simon.himurakotlin

import java.lang.ref.WeakReference


abstract class MVPPresenter<V : MVPContract.View> : MVPContract.Presenter<V> {
  private var viewRef: WeakReference<V>? = null

  override fun getView(): V? = if (viewRef == null) null else viewRef?.get()

  override fun attachView(view: V) {
    viewRef = WeakReference(view)
  }

  override fun detachView() {
    viewRef?.clear()
    viewRef = null
  }
}