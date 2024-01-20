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
        // descriptor.className is either youtube.builders._problem.PersonTest or youtube.builders.levelN.PersonTest
        // where N is an integer

        val testRegex = ".*((_problem)|(level\\d+)|(sorcery\\d+))\\.PersonTest".toRegex()

        if (!descriptor.className!!.matches(testRegex)) {
            println("[${descriptor.className}] > ${descriptor.displayName}: ${result.resultType}")
            return@KotlinClosure2
        }

        // descriptor.className is either youtube.builders._problem.PersonTest or youtube.builders.levelN.PersonTest

        // extract the problem or level number from the test class name
        val problemOrLevel = testRegex.find(descriptor.className!!)!!.groupValues[1]
        var personType = ""

        if (problemOrLevel == "_problem") {
            personType = "Person"
        } else if (problemOrLevel.startsWith("level")) {
            personType = "Level ${problemOrLevel.substring("level".length)}"
        } else if (problemOrLevel.startsWith("sorcery")) {
            personType = "Dark arts level ${problemOrLevel.substring("sorcery".length)}"
        } else {
            throw IllegalStateException("Unexpected test class name: ${descriptor.className}")
        }

        println("[$personType] > ${descriptor.displayName}: ${result.resultType}")
    }))
}
