package dev.qpixel.helios.api;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class HeliosPlugin extends JavaPlugin {
    protected HeliosAPI heliosAPI = new HeliosAPI();
    public Logger log = getLogger();

    public HeliosAPI getHeliosAPI() {
        return heliosAPI;
    }
}
