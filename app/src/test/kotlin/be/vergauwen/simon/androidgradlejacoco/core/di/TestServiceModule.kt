package be.vergauwen.simon.androidgradlejacoco.core.di

import be.vergauwen.simon.androidgradlejacoco.core.service.GithubAPI
import be.vergauwen.simon.androidgradlejacoco.core.service.MockGithubAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class TestServiceModule : ServiceModule() {

  @ApplicationScope
  @Provides
  override fun provideRestAdapter(): Retrofit {
    return Retrofit.Builder().baseUrl(URI).addConverterFactory(
        GsonConverterFactory.create()).addCallAdapterFactory(
        RxJavaCallAdapterFactory.create()).build()
  }

  @ApplicationScope
  @Provides
  override  fun provideGithubAPI(retrofit: Retrofit): GithubAPI {
    return MockGithubAPI()
  }
}