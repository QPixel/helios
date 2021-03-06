package dev.qpixel.helios.api.senders;

import dev.qpixel.helios.api.HeliosAPI;

import dev.qpixel.helios.api.HeliosPlugin;
import dev.qpixel.helios.api.util.SenderHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class MessageSender implements Sender {
    private final HeliosPlugin plugin;
    private final HeliosAPI heliosAPI;

    public MessageSender(HeliosPlugin plugin) {
        this.plugin = plugin;
        this.heliosAPI = plugin.getHeliosAPI();
    }


    @Override
    public HeliosPlugin getPlugin() {
        return null;
    }

    @Override
    public HeliosAPI getAPI() {
        return null;
    }

    @Override
    public void sendMessage(Component message, CommandSender sender) {
        try {
            sender.sendMessage(message);
        } catch (NoClassDefFoundError e) {
            this.getAPI().getAudience().sender(sender).sendMessage(message);
        }
    }

    // Since we don't have sender we don't support using this option, TODO look into being able to get the sender property back
    @Override public void sendMessage(Component message) {throw new UnsupportedOperationException();}

    // Is console
    // is unable to be gotten since sender is not known
     @Override public boolean isConsole() {throw new UnsupportedOperationException();}
}
