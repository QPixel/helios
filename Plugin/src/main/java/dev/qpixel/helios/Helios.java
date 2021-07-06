package dev.qpixel.helios;

import dev.qpixel.helios.api.HeliosAPI;
import dev.qpixel.helios.api.HeliosPlugin;
import dev.qpixel.helios.commands.CommandHelios;
import org.inventivetalent.pluginannotations.PluginAnnotations;


public final class Helios extends HeliosPlugin {
    public static HeliosPlugin instance;

    public CommandHelios heliosCommand;

    @Override
    public void onEnable() {
        instance = this;
        heliosAPI.init(this);
        // Plugin startup logic
        showLoadingMessage();
        getLogger().info(getServer().getVersion());
        heliosCommand = new CommandHelios(this);
        PluginAnnotations.COMMAND.load(this, heliosCommand);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Helios is shutting down");
        heliosAPI.unload();
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
        log.info(String.format("Helios API v%s", HeliosAPI.getVersion()));
    }

}
