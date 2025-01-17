plugins {
    id("java-library")
    id("net.ltgt.apt-eclipse")
    id("net.ltgt.apt-idea")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
applyPlatformAndCoreConfiguration()
applyShadowConfiguration()
tasks.withType<Test> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<Javadoc>{
    options.encoding = "UTF-8"
}


dependencies {
    "api"(project(":worldguard-libs:core"))
    "api"("com.sk89q.worldedit:worldedit-core:${Versions.WORLDEDIT}")
    "implementation"("org.flywaydb:flyway-core:3.0")
    "implementation"("org.yaml:snakeyaml:1.9")
    "implementation"("com.google.guava:guava:${Versions.GUAVA}")

    "compileOnly"("com.google.code.findbugs:jsr305:1.3.9")
    "testImplementation"("org.hamcrest:hamcrest-library:1.2.1")
}

tasks.withType<JavaCompile>().configureEach {
    dependsOn(":worldguard-libs:build")
}

sourceSets {
    main {
        java {
            srcDir("src/main/java")
        }
        resources {
            srcDir("src/main/resources")
        }
    }
}
