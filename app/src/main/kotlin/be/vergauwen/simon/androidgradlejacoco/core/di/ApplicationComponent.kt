package be.vergauwen.simon.androidgradlejacoco.core.di

import android.content.Context
import be.vergauwen.simon.androidgradlejacoco.core.rx.Transformers
import be.vergauwen.simon.androidgradlejacoco.core.service.GithubAPI
import dagger.Component

@ApplicationScope
@Component(modules = arrayOf(ApplicationModule::class,ServiceModule::class))
interface ApplicationComponent {
  val applicationContext: Context
  val transformers : Transformers
  val githubAPI : GithubAPI
}