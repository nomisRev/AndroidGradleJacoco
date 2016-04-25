package be.vergauwen.simon.androidgradlejacoco

import be.vergauwen.simon.androidgradlejacoco.core.di.ApplicationComponent
import be.vergauwen.simon.androidgradlejacoco.core.di.DaggerApplicationComponent
import be.vergauwen.simon.androidgradlejacoco.core.di.TestApplicationModule
import be.vergauwen.simon.androidgradlejacoco.core.di.TestServiceModule

class TestExampleApp : ExampleApp() {
  override fun createComponent(): ApplicationComponent = DaggerApplicationComponent.builder().applicationModule(
      TestApplicationModule(this)).serviceModule(TestServiceModule()).build()
}