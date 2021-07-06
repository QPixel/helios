package dev.qpixel.helios.api.senders;

import dev.qpixel.helios.api.HeliosAPI;

import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public class MessageSender {
    private HeliosAPI heliosAPI;
    public MessageSender(HeliosAPI api) {
        heliosAPI = api;
    }

    public void sendMessage(Component component, CommandSender sender) {
        if (heliosAPI.isSpigot()) {
            HeliosAPI.adventure().sender(sender).sendMessage(component);
            return;
        } else {
            sender.sendMessage(component);
        }
    }
}
