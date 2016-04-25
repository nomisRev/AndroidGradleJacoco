package be.vergauwen.simon.androidgradlejacoco.ui

import be.vergauwen.simon.androidgradlejacoco.core.di.ActivityScope
import be.vergauwen.simon.androidgradlejacoco.core.di.ApplicationComponent
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ExampleComponent : ExampleContract.Component<ExampleContract.View,ExamplePresenter>