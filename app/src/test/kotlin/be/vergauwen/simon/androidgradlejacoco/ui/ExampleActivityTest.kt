package be.vergauwen.simon.androidgradlejacoco.ui

import android.widget.TextView
import be.vergauwen.simon.androidgradlejacoco.BuildConfig
import be.vergauwen.simon.androidgradlejacoco.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class ExampleActivityTest {

  @Before
  fun setUp() {
  }

  @Test
  fun preConditions() {
    val activity = Robolectric.buildActivity(ExampleActivity::class.java).get()
    assertNotNull(activity)
  }

  @Test
  fun testTextView() {
    val activity = Robolectric.buildActivity(
        ExampleActivity::class.java).create().start().resume().visible().get()
    val githubRepos : TextView = activity.findViewById(R.id.github_repos) as TextView
    assertNotNull(githubRepos)
  }

  @Test
  fun testPrintRepos() {
    val activity = Robolectric.buildActivity(
        ExampleActivity::class.java).create().start().resume().visible().get()
    activity.printRepo("text")
    val githubRepos : TextView = activity.findViewById(R.id.github_repos) as TextView
    assertTrue(githubRepos.text.toString().contains("text"))
  }

  @Test
  fun testShowError() {
    val activity = Robolectric.buildActivity(
        ExampleActivity::class.java).create().start().resume().visible().get()
    activity.showError()
    val githubRepos : TextView = activity.findViewById(R.id.github_repos) as TextView
    assertTrue(githubRepos.text.toString().contains("error"))
  }
}