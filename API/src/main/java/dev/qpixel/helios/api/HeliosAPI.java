package dev.qpixel.helios.api;


import dev.qpixel.helios.api.util.PropertiesReader;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HeliosAPI {
    private PropertiesReader reader;
    private HeliosPlugin plugin;
    private static BukkitAudiences adventure;
    protected static String version;
    protected static boolean Spigot;

    private static List<String> loadedPlugins = new ArrayList();

    public static @NotNull BukkitAudiences adventure() {
        if (adventure == null) {
            throw new IllegalStateException("Tried to access adventure while disabled");
        }
        return adventure;
    }

    public void init(HeliosPlugin plugin) {
        this.plugin = plugin;
        if (plugin.getServer().getVersion().toLowerCase(Locale.ROOT).contains("spigot")) {
            Spigot = true;
            plugin.getLogger().info("plugin is running on spigot");
            adventure = BukkitAudiences.create(plugin);
        } else {
//            this.adventure = this.plugin.getServer()
            plugin.getLogger().info("is this being ran instead");
        }
        registerPlugin(String.format("%s %s",plugin.getName(), plugin.getDescription().getVersion()));
        try {
            reader = new PropertiesReader("build-info.properties");
            version = reader.getProperty("helios.version");
        } catch (IOException e) {
            plugin.getLogger().warning("Unable to read internal properties");
            version = "1.0.0-SNAPSHOT-error";
        }
    }
    public void unload() {
        if (adventure != null) {
            adventure.close();
            adventure = null;
        }
        unregisterPlugins();
    }
    public static String getVersion() {
        return version;
    }

    public static boolean isSpigot() {
        return Spigot;
    }

    private void registerPlugin(String pluginName) {
        loadedPlugins.add(pluginName);
    }
    private void unregisterPlugins() {
        loadedPlugins.clear();
    }
    public ArrayList<String> getIterablePlugin() {
        return (ArrayList<String>) loadedPlugins;
    }
    public HeliosAPI() {

    }
}
