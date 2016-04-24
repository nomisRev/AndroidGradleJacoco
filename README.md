# Android Gradle Jacoco (Test coverage)

## Setting up Jacoco

* First of all we'll have to setup Jacoco in Gradle. In order to avoid creating an enourmous gradle file, we'll create a gradle file seperately for Jacoco. This can be than be copied to any project and be imported into any build.gradle you need it.

* By default there is a gradle folder in the root of your android project. This folder contains the Gradle wrapper, a little bit more about this in the Robolectric setup below. Within this folder we'll create a `jacoco.gradle` file. Don't worry if you don't have a lot of experience with gradle or groovy, it will all be explained below. If you don't require the extra explanation just checkout the code in this repo, `/gradle/jacoco.gradle`.

## jacoco.gradle

* `apply plugin: 'jacoco'`, if we apply the plugin here it automatically gets applied to the `build.gradle` we import this script into. You don't have to worry about dependencies, the android gradle plugin takes care of this for us!

* I like to specify what jacoco is used because there can be some weird side-effects with jacoco versions. The version shown here should work fine! But more about this in the Jenkins/Robolectric setup.
```
jacoco {
    toolVersion = "0.7.2.201409121644"
}
```

* Now for the real gradle work!
* We want the `jacoco` tasks to run after after the project is `evaluated`.
>  Such a listener gets notified when the build file belonging to this project has been executed.
```
project.afterEvaluate {
	// Where we'll do all our work!
}
```
* First we're going to `collect` all the `buildTypes` and `productFlavors` into a `List<T>`

```
def buildTypes = android.buildTypes.collect { type -> type.name }
def productFlavors = android.productFlavors.collect { flavor -> flavor.name }
```