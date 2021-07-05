package dev.qpixel.plugins.helios;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class Helios extends JavaPlugin {
    public static Helios instance;
    public Logger log = getLogger();

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        showLoadingMessage();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void showLoadingMessage() {
        log.info("██╗  ██╗███████╗██╗     ██╗ ██████╗ ███████╗\n" +
                "██║  ██║██╔════╝██║     ██║██╔═══██╗██╔════╝\n" +
                "███████║█████╗  ██║     ██║██║   ██║███████╗\n" +
                "██╔══██║██╔══╝  ██║     ██║██║   ██║╚════██║\n" +
                "██║  ██║███████╗███████╗██║╚██████╔╝███████║\n" +
                "╚═╝  ╚═╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚══════╝");
        log.info(String.format("Helios version %s has been loaded", getDescription().getVersion()));
    }
}
