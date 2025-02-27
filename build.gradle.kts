plugins {
    kotlin("jvm") version "2.0.21"
}

group = "me.void"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        name = "spigotmc-repo"
        url = project.uri ("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        name="dmulloy2-repo"
        url = project.uri ("https://repo.dmulloy2.net/repository/public/")
    }
    maven {
        name = "sonatype"
        url = project.uri ("https://oss.sonatype.org/content/groups/public/")
    }
}

dependencies {
    compileOnly ("org.spigotmc:spigot:1.12.2-R0.1-SNAPSHOT")
    compileOnly ("com.comphenix.protocol:ProtocolLib:4.8.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks {
    jar {
        from(
            configurations.runtimeClasspath.get()
                .map { if (it.isDirectory) it else zipTree(it) }
        )

        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        archiveFileName = "PluginTest.jar"
    }
}