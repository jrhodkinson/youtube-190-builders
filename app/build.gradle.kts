import org.gradle.api.tasks.testing.logging.TestLogging

plugins {
    java
    idea
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation("org.assertj:assertj-core:3.25.1")
}

tasks.named<Test>("test") {
    useJUnitPlatform()

    afterTest(KotlinClosure2({ descriptor: TestDescriptor, result: TestResult ->
        println("[${descriptor.className}] > ${descriptor.displayName}: ${result.resultType}")
    }))
}
