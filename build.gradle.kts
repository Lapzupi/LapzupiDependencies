plugins {
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
}

group = "com.lapzupi.dev"
version = "1.0.3"

description = "Dependencies for the Lapzupi Project."

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.aikar.co/content/groups/aikar/")
    maven("https://jitpack.io")
    maven("https://repo.codemc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper.api)
    api(libs.acf.commands)
    api(libs.nbt.api)
    api(libs.triumph.gui)

    api(libs.lapzupi.config)
    api(libs.lapzupi.connection)
    api(libs.lapzupi.files)
}

bukkit {
    name = "LapzupiDependencies"
    authors = listOf("Lapzupi Development Team", "sarhatabaot")
    main = "com.lapzupi.dev.dependencies.DependenciesPlugin"
    version = project.version.toString()
    website = "https://github.com/Lapzupi/LapzupiDependencies"

    apiVersion = "1.20"
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        minimize()

        dependencies {
            exclude(dependency("net.kyori:.*:.*"))
        }
        archiveFileName.set("LapzupiDependencies-${project.version}.jar")
        archiveClassifier.set("shadow")

        relocate("de.tr7zw", "com.lapzupi.dev.dependencies.nbt")
        relocate("co.aikar.commands", "com.lapzupi.dev.dependencies.acf")
        relocate("co.aikar.locales", "com.lapzupi.dev.dependencies.locales")
        relocate("dev.triumphteam.gui", "com.lapzupi.dev.dependencies.gui")
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = groupId
            artifactId = artifactId
            version = version

            from(components["java"])
        }
    }
}