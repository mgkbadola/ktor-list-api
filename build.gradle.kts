import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val ktor_version: String by project
val kotlin_version: String by project
val mssql_jdbc_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}
tasks.withType<ShadowJar>{
    manifest{
        attributes["Main-Class"] = "me.mgkbadola.ApplicationKt"
    }
}
group = "me.mgkbadola"
version = "0.0.1"
application {
    mainClass.set("me.mgkbadola.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment", "-opt-in=kotlin.RequiresOptIn")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-java:$ktor_version")
    implementation("com.microsoft.sqlserver:mssql-jdbc:$mssql_jdbc_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}