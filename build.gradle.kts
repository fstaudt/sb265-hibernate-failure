import org.gradle.kotlin.dsl.*
import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.BIN
import org.springframework.boot.gradle.tasks.run.BootRun

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    java
    id("org.springframework.boot") version "2.6.5"
}

apply {
    plugin("io.spring.dependency-management")
}

group = "com.spring.reproducer"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("com.h2database:h2")
}

tasks.withType<Wrapper>().configureEach {
    gradleVersion = "7.4"
    distributionType = BIN
}

tasks.withType<Test> { useJUnitPlatform() }

tasks.withType<BootRun> {
    args("--spring.profiles.active=dev")
}
