package dev.qpixel.helios.api;


import dev.qpixel.helios.api.util.PropertiesReader;
import org.bukkit.plugin.Plugin;

import java.io.IOException;

public class HeliosAPI {
    private PropertiesReader reader;
    private Plugin plugin;
    protected static String version;
    public void init(Plugin plugin) {
        this.plugin = plugin;
        try {
            reader = new PropertiesReader("build-info.properties");
            version = reader.getProperty("helios.version");
        } catch (IOException e) {
            plugin.getLogger().warning("Unable to read internal properties");
            version = "1.0.0-SNAPSHOT-error";
        }
    }
    public static String getVersion() {
        return version;
    }

    public HeliosAPI() {

    }
}
