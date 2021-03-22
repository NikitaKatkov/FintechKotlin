plugins {
    kotlin("jvm") version "1.4.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.hsqldb:hsqldb:2.3.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.0")
}
