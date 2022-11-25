plugins {
	`java-library-conventions`
}

description = "JUnit Platform Reporting"

dependencies {
	api(platform(project(":junit-bom")))

	api("org.apiguardian:apiguardian-api:${Versions.apiGuardian}")

	api(project(":junit-platform-launcher"))
}
