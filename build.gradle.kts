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
    implementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    implementation("org.junit.jupiter:junit-jupiter-params:5.2.0")
    implementation("io.mockk:mockk:1.10.6")
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
}