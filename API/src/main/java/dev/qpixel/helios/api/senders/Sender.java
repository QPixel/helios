package dev.qpixel.helios.api.senders;

import dev.qpixel.helios.api.HeliosAPI;
import dev.qpixel.helios.api.HeliosPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public interface Sender {
    HeliosPlugin getPlugin();
    HeliosAPI  getAPI();

    void sendMessage(Component message);

    void sendMessage(Component message, CommandSender sender);

    boolean isConsole();
}

