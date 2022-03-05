plugins {
    java
    kotlin("jvm").version(Dependencies.Kotlin.version)
    kotlin("kapt").version(Dependencies.Kotlin.version)
    application
    id("com.github.johnrengelman.shadow").version("7.1.2").apply(true)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

group = "com.reyadayer"
val pluginName = "DiscordSign"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("net.kunmc.lab.discordsign.DiscordSign")
}

repositories {
    jcenter()
    mavenCentral()
    maven(Dependencies.Spigot.repository)
}

dependencies {
    api(Dependencies.Spigot.api)
    compileOnly(Dependencies.Spigot.annotations)
    kapt(Dependencies.Spigot.annotations)
    api(Dependencies.Kotlin.stdlib)
    api(Dependencies.Kotlin.Coroutines.core)
    api(Dependencies.Retrofit.core)
    testImplementation(Dependencies.JUnit.core)
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Kotlin.classpath)
    }
}

tasks {
    shadowJar {
        archiveBaseName.set(pluginName)
        archiveClassifier.set("")
        archiveVersion.set(version)
        mergeServiceFiles()
        dependencies {
            exclude(dependency(Dependencies.Spigot.api))
            exclude(dependency(Dependencies.Kotlin.stdlib))
        }
    }

    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}