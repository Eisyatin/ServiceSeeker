buildscript {
    ext.kotlin_version = '1.7.10'
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath 'com.google.gms:google-services:4.3.15'
        classpath 'com.android.tools.build:gradle:7.3.0'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
       
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.buildDir = '../build'
subprojects {
    project.buildDir = "${rootProject.buildDir}/${project.name}"
}
subprojects {
    project.evaluationDependsOn(':app')
}

tasks.register("clean", Delete) {
    delete rootProject.buildDir
}

plugins {
  // ...
  id("com.android.application")

  // Add the dependency for the Google services Gradle plugin
  id("com.google.gms.google-services") version "4.3.15" apply false

}

dependencies {
  // Import the Firebase BoM
  implementation(platform("com.google.firebase:firebase-bom:32.2.0"))


  // TODO: Add the dependencies for Firebase products you want to use
  // When using the BoM, don't specify versions in Firebase dependencies
  // https://firebase.google.com/docs/android/setup#available-libraries
}