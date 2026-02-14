plugins {
    id("conventions.java-common")
}

description = "library"

dependencies {
    implementation("org.springframework:spring-context")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
