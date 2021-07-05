package dev.qpixel.plugins.helios.commands;

import dev.qpixel.plugins.helios.Helios;
import org.bukkit.command.CommandSender;
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
    public void helios(CommandSender sender) {

    }
}
