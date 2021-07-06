package dev.qpixel.helios.api;

import dev.qpixel.helios.api.senders.AbstractSender;
import dev.qpixel.helios.api.senders.ConsoleSender;
import dev.qpixel.helios.api.senders.Sender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class HeliosPlugin extends JavaPlugin {
    protected final HeliosAPI heliosAPI = new HeliosAPI();
    private final Logger logger;
    private final ConsoleCommandSender console;

    public HeliosPlugin() {
        this.console = this.getServer().getConsoleSender();
        this.logger = this.getLogger();
    }

    public Logger log() {
        return this.logger;
    }

    // Returns formattable console sender
    public Sender getConsoleSender() {
        return new AbstractSender(this, this.getConsole());
    }

    // Returns raw console sender
    public ConsoleCommandSender getConsole() {
        return this.console;
    }

    public String getVersion() {
        return this.getDescription().getVersion();
    }

    public HeliosAPI getHeliosAPI() {
        return heliosAPI;
    }

}
