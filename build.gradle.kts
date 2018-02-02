plugins {
    application
    kotlin("jvm") version "1.2.20"
}

application {
    mainClassName = "RunnerKt"
}

dependencies {
    compile(kotlin("stdlib"))
}

repositories {
    jcenter()
}