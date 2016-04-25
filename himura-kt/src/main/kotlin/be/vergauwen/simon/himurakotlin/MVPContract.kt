package be.vergauwen.simon.himurakotlin

interface MVPContract {
  interface View

  interface Presenter<V : View> {
    fun getView(): V?
    fun attachView(view: V)
    fun detachView()
  }

  interface Component<V : View, P : Presenter<V>> {
    fun presenter(): P
  }
}