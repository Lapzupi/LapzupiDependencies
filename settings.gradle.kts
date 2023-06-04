rootProject.name = "dependencies"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("paper-api", "io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
            library("acf-commands", "co.aikar:acf-paper:0.5.1-SNAPSHOT")
            library("nbt-api", "de.tr7zw:item-nbt-api:2.11.2")
            library("triumph-gui", "com.github.Lapzupi:triumph-gui:3.1.5")
            library("lapzupi-connection","com.github.Lapzupi:LapzupiConnection:1.0.2")
            library("lapzupi-config","com.github.Lapzupi:LapzupiConfig:1.1.1")
            library("lapzupi-files", "com.github.Lapzupi:LapzupiFiles:1c7a837b53")
        }
    }
}