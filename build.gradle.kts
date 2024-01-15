import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.5"
    id("io.spring.dependency-management") version "1.1.4"

    // kotlin
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
    kotlin("kapt") version "1.6.10"

    id("org.openapi.generator") version "6.0.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation ("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // swagger 3.0
    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    implementation("io.swagger.core.v3:swagger-annotations-jakarta:2.2.11")

    // openapi generator
    implementation("org.openapitools:openapi-generator:5.1.1") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }

    implementation("org.openapitools:openapi-generator-gradle-plugin:5.1.1") {
        exclude(group = "org.slf4j", module = "slf4j-simple")
    }
}

// kotlin 컴파일러
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    println("rootDir : $rootDir")
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
    dependsOn("openApiGenerate")
}

sourceSets {
    main {
        java.srcDirs("src/main/kotlin", "build/generated-sources/kotlin")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}



openApiGenerate {
    println("openapiGenerate start!")
    verbose.set(true)
    generatorName.set("kotlin-spring")
    library.set("spring-boot")
    inputSpec.set("$rootDir/src/main/resources/specs/petstore.yaml")
    outputDir.set("$buildDir/generated-sources")
    apiPackage.set("com.example.redoctest.api")
    invokerPackage.set("com.example.redoctest.invoker")
    modelPackage.set("com.example.redoctest.model")
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8"
        )
    )
}

//tasks.bootBuildImage {
//    builder.set("paketobuildpacks/builder-jammy-base:latest")
//}
