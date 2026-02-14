plugins {
    id("conventions.java-common")
    id("org.springframework.boot")
}

description = "application"

dependencies {
    implementation(project(":library"))

    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
