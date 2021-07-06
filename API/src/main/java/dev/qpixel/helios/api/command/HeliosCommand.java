package dev.qpixel.helios.api.command;

import dev.qpixel.helios.api.HeliosAPI;
import dev.qpixel.helios.api.HeliosPlugin;
import dev.qpixel.helios.api.senders.MessageSender;
import org.bukkit.plugin.Plugin;

public class HeliosCommand {
    public HeliosPlugin plugin;
    public HeliosAPI heliosAPI;
    public MessageSender sender;

    public HeliosCommand(HeliosPlugin plugin) {
        this.plugin = plugin;
        this.heliosAPI = plugin.getHeliosAPI();
        this.sender = new MessageSender(this.heliosAPI);
    }

    public Plugin getPlugin() {
        return plugin;
    }
}
