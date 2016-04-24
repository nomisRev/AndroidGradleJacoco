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
* First we're going to `collect` all the `buildTypes` and `productFlavors` into a `List<T>`. In case there were no product flavors defined, we'll add an empty string element to the list.
```
def buildTypes = android.buildTypes.collect { type -> type.name }
def productFlavors = android.productFlavors.collect { flavor -> flavor.name }
if (!productFlavors) productFlavors.add('')
```
**In our example we used the default build types (debug & release), and we defined a product flavor free and paid**
* So we end up with 4 different build variants in AS:
	* freeDebug
	* paidDebug
	* freeRelease
	* paidRelease
* Because AS defines them productFlavorBuildType we'll be doing the same. So we'll have double `foreach` loop that loops through our `productFlavors` and `buildTypes`. And since our source paths follow the same pattern we can define these at once as well. so we get `freeDebug` and `free/debug`on our first iteration, we need to do some more stuff in this iteration beside just defining it's name and path so let's do that!
```
productFlavors.each { productFlavorName ->
        buildTypes.each { buildTypeName ->

            def sourceName, sourcePath
            if (!productFlavorName) {
                sourceName = sourcePath = "${buildTypeName}"
            } else {
                sourceName = "${productFlavorName}${buildTypeName.capitalize()}"
                sourcePath = "${productFlavorName}/${buildTypeName}"
            }
        }
    }
```
* For each `build variant` we want to create a gradle task that generates the jacoco coverage report. So let's define a name for the gradle task first. The result being a task named testFreeDebugUnitTest in our first iteration.
```
def testTaskName = "test${sourceName.capitalize()}UnitTest"

 task "${testTaskName}Coverage"(type: JacocoReport, dependsOn: "$testTaskName") {
     //task code
 }
```

