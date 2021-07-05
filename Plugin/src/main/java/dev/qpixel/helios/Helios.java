package dev.qpixel.helios;

import dev.qpixel.helios.api.HeliosAPI;
import dev.qpixel.helios.commands.HeliosCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.pluginannotations.PluginAnnotations;

import java.util.logging.Logger;


public final class Helios extends JavaPlugin {
    public static Helios instance;
    public HeliosAPI heliosAPI = new HeliosAPI();
    public Logger log = getLogger();

    public HeliosCommand heliosCommand;

    @Override
    public void onEnable() {
        instance = this;
        heliosAPI.init(this);
        // Plugin startup logic
        showLoadingMessage();
        heliosCommand = new HeliosCommand(this);
        PluginAnnotations.COMMAND.load(this, heliosCommand);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Helios is shutting down");
    }
    private void showLoadingMessage() {
        log.info("\n" +
                "██╗  ██╗███████╗██╗     ██╗ ██████╗ ███████╗\n" +
                "██║  ██║██╔════╝██║     ██║██╔═══██╗██╔════╝\n" +
                "███████║█████╗  ██║     ██║██║   ██║███████╗\n" +
                "██╔══██║██╔══╝  ██║     ██║██║   ██║╚════██║\n" +
                "██║  ██║███████╗███████╗██║╚██████╔╝███████║\n" +
                "╚═╝  ╚═╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚══════╝");
        log.info(String.format("Helios Version %s has been loaded", getDescription().getVersion()));
        log.info(String.format("Helios API v%s", heliosAPI.getVersion()));
    }

}
