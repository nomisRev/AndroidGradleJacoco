package be.vergauwen.simon.androidgradlejacoco.ui

import android.widget.TextView
import be.vergauwen.simon.androidgradlejacoco.BuildConfig
import be.vergauwen.simon.androidgradlejacoco.R
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class ExampleActivityTestDemo {

  @Test
  fun testString() {
    val activity = Robolectric.buildActivity(
        ExampleActivity::class.java).create().start().resume().visible().get()

    val string = activity.getString(R.string.hello_world)
    assertEquals(string, "Free version only.")
    assertEquals(string,(activity.findViewById(R.id.hello_world) as TextView).text)
  }
}