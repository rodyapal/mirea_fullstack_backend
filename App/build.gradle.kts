val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val ktorm_version: String by project
val koin_version: String by project

plugins {
	kotlin("jvm") version "1.8.21"
	id("io.ktor.plugin") version "2.3.0"
	id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

group = "com.rodyapal"
version = "0.0.1"
application {
	mainClass.set("com.rodyapal.ApplicationKt")

	val isDevelopment: Boolean = project.ext.has("development")
	applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-openapi:$ktor_version")
	implementation("io.ktor:ktor-server-swagger:$ktor_version")
	implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
	implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
	implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
	implementation("ch.qos.logback:logback-classic:$logback_version")
	testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

	// Ktorm
	implementation("org.ktorm:ktorm-core:$ktorm_version")
	implementation("org.ktorm:ktorm-support-postgresql:$ktorm_version")
	implementation("org.postgresql:postgresql:42.2.27")

	// Koin-ktor
	implementation("io.insert-koin:koin-ktor:$koin_version")
}