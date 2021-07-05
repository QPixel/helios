package dev.qpixel.helios.commands;

import dev.qpixel.helios.Helios;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.pluginannotations.command.Command;
import org.inventivetalent.pluginannotations.command.Permission;

public class HeliosCommand {
    private Helios plugin;

    public HeliosCommand(Helios plg) {
        this.plugin = plg;
    }
    @Command(
            name = "helios",
            description = "Checks the version and lists the plugins hooked into helios"
    )
    @Permission("helios.command.main")
    public void helios(Player player) {
        player.sendMessage(plugin.heliosAPI.getVersion());
        player.sendMessage(ChatColor.BLUE + "Test");
        return;
    }
}
