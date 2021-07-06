package dev.qpixel.helios.commands;

import dev.qpixel.helios.Helios;
import dev.qpixel.helios.api.command.HeliosCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.pluginannotations.command.Command;
import org.inventivetalent.pluginannotations.command.Permission;

public class CommandHelios extends HeliosCommand {

    public CommandHelios(Helios plg) {
        super(plg);
    }

    @Command(
            name = "helios",
            description = "Checks the version and lists the plugins hooked into helios"
    )
    @Permission("helios.command.main")
    public void helios(CommandSender sender) {
        this.sender.sendMessage(Component.text("Helios")
                .decoration(TextDecoration.BOLD, true)
                .color(NamedTextColor.GOLD), sender);

        this.sender.sendMessage(Component.text("a plugin made by ")
                .append(Component.text("QPIXEL")

                        .clickEvent(ClickEvent.openUrl("https://qpixel.me"))
                .decoration(TextDecoration.BOLD, true))
                .color(NamedTextColor.GOLD), sender);
        this.sender.sendMessage(Component.text("\nHeliosAPI Version ")
                .append(Component.text(heliosAPI.getVersion())
                        .decoration(TextDecoration.ITALIC, true)).color(NamedTextColor.DARK_AQUA), sender);
        final TextComponent.Builder component = Component.text().content("Plugins loaded: \n");
        for (String string : heliosAPI.getIterablePlugin()) {
            component.append(Component.text(string + "\n"));
        }
        this.sender.sendMessage(component.color(NamedTextColor.AQUA).build(), sender);
        return;
    }
}
