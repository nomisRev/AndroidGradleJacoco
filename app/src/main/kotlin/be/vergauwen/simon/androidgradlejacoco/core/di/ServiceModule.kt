package be.vergauwen.simon.androidgradlejacoco.core.di

import be.vergauwen.simon.androidgradlejacoco.BuildConfig
import be.vergauwen.simon.androidgradlejacoco.core.service.GithubAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
open class ServiceModule {

//  val URI = "https://api.github.com"
  val URI = BuildConfig.URI

  @ApplicationScope
  @Provides
  open fun provideRestAdapter(): Retrofit {


    return Retrofit.Builder().baseUrl(URI).addConverterFactory(
        GsonConverterFactory.create()).addCallAdapterFactory(
        RxJavaCallAdapterFactory.create()).build()
  }

  @ApplicationScope
  @Provides
  open fun provideGithubAPI(retrofit: Retrofit): GithubAPI {
    return retrofit.create(GithubAPI::class.java)
  }
}