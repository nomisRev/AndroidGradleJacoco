package be.vergauwen.simon.androidgradlejacoco.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import be.vergauwen.simon.androidgradlejacoco.ExampleApp
import be.vergauwen.simon.androidgradlejacoco.R
import be.vergauwen.simon.himurakotlin.MVPDaggerActivity

class ExampleActivity : MVPDaggerActivity<ExampleContract.View, ExamplePresenter, ExampleComponent>(), ExampleContract.View {

  val githubRepo by lazy { findViewById(R.id.github_repos) as TextView}

  override fun createComponent(): ExampleComponent =
      DaggerExampleComponent.builder().applicationComponent((application as ExampleApp).component).build()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.example_activity)
    githubRepo.text = "Github repo = \n"
  }

  override fun printRepo(repoName: String) {
    Log.e("ExampleActivity", repoName)
    githubRepo.text = githubRepo.text.toString() + repoName + "\n"
  }

  override fun showError() {
    Log.e("ExampleActivity", "showError(")
    githubRepo.text = "error"
  }
}