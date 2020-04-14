plugins {
    kotlin("jvm") version "1.3.71"
    kotlin("kapt") version "1.3.71"
}

group = "nl.marc"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/arrow-kt/arrow-kt/")
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.github.vincenzopalazzo", "material-ui-swing", "1.0.6")

    implementation("io.arrow-kt", "arrow-core", "0.10.4")
    implementation("io.arrow-kt", "arrow-syntax", "0.10.4")
    kapt("io.arrow-kt", "arrow-meta", "0.10.4")

    testImplementation(kotlin("test-junit5"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}