package com.lapzupi.dev.dependencies;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author sarhatabaot
 */
public class LapzupiDependencies extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(() -> "Dependencies loaded.");
    }
}
