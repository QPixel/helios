package dev.qpixel.helios;

import dev.qpixel.helios.api.HeliosPlugin;
import dev.qpixel.helios.api.message.MessageCreation;
import dev.qpixel.helios.commands.CommandHelios;
import dev.qpixel.helios.messages.CoreMessageCreation;
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

        heliosCommand = new CommandHelios(this);
        PluginAnnotations.COMMAND.load(this, heliosCommand);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        heliosAPI.unload();
    }

    private void showLoadingMessage() {
        // Send Helios Logo
        CoreMessageCreation.STARTUP.send(this.getConsoleSender());
        // Send Plugin Version
        CoreMessageCreation.PluginVersion.send(this.getConsoleSender(), this);
        // Send API Build String
        MessageCreation.API_BUILD.send(this.getConsoleSender(), this.heliosAPI);
    }

}
