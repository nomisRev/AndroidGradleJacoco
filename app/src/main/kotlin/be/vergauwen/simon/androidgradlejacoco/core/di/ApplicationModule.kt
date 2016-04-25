package be.vergauwen.simon.androidgradlejacoco.core.di

import android.app.Application
import android.content.Context
import be.vergauwen.simon.androidgradlejacoco.core.rx.RxUtil
import be.vergauwen.simon.androidgradlejacoco.core.rx.Transformers
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule(private val application: Application) {

  @ApplicationScope
  @Provides
  open fun provideApplicationContext(): Context {
    return application
  }

  @ApplicationScope
  @Provides
  open fun provideTransformers(): Transformers {
    return RxUtil()
  }
}