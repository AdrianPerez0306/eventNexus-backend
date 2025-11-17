plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.jpa") version "1.9.25"
	kotlin("plugin.serialization") version "1.6.0"
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.25" // ESTE es el que necesitas
	war
}

group = "ar.edu.unsam.proyecto-de-sofware"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

val mockkVersion = "1.13.9"
val kotestVersion = "5.8.0"

dependencies {

//	basic spring boot
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-web")

//	DB CONNECTION
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql")
//	SECURITY
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.bouncycastle:bcprov-jdk15on:1.70")
	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
	implementation("com.auth0:java-jwt:4.4.0")
	implementation("io.jsonwebtoken:jjwt-jackson:0.12.6")

//	TESTING
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("io.mockk:mockk:${mockkVersion}")
	testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
	testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")


	//mail
	implementation("org.springframework.boot:spring-boot-starter-mail")
}


