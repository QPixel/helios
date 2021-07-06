package dev.qpixel.helios.api.senders;

import dev.qpixel.helios.api.HeliosAPI;
import dev.qpixel.helios.api.HeliosPlugin;
import dev.qpixel.helios.api.util.SenderHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public final class AbstractSender implements Sender {
    private final HeliosPlugin plugin;
    private final HeliosAPI heliosAPI;
    private final CommandSender sender;
    private final boolean isConsole;

    public AbstractSender(HeliosPlugin plugin, CommandSender sender) {
        this.plugin = plugin;
        this.heliosAPI = plugin.getHeliosAPI();
        this.isConsole = SenderHelper.isConsole(sender);
        this.sender = sender;
    }

    @Override
    public HeliosPlugin getPlugin() {
        return this.plugin;
    }

    @Override
    public HeliosAPI getAPI() {
        return this.heliosAPI;
    }

    @Override
    public void sendMessage(Component message) {
        try {
            this.sender.sendMessage(message);
        } catch (NoClassDefFoundError e) {
            this.getAPI().getAudience().sender(this.sender).sendMessage(message);
        }
    }

    @Override
    public void sendMessage(Component message, CommandSender sender) {
        try {
            sender.sendMessage(message);
        } catch (NoClassDefFoundError e) {
            this.getAPI().getAudience().sender(sender).sendMessage(message);
        }
    }

    @Override
    public boolean isConsole() {
        return isConsole;
    }
}
