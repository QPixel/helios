package dev.qpixel.helios.messages;

import dev.qpixel.helios.api.HeliosPlugin;
import dev.qpixel.helios.api.message.MessageCreation;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;

import static net.kyori.adventure.text.Component.space;
import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.*;
import static net.kyori.adventure.text.format.TextDecoration.BOLD;

public interface CoreMessageCreation {
    Component PREFIX = text()
            .color(GRAY)
            .append(text('['))
            .append(text()
                    .decoration(BOLD, true)
                    .append(text("Helios", GOLD)
                            .append(text("Core", AQUA)
                            )
                    )
            )
            .append(text(']'))
            .build();
    static TextComponent prefixedString(ComponentLike component) {
        return text()
                .append(PREFIX)
                .append(space())
                .append(component)
                .build();
    }

    MessageCreation.Args0 STARTUP = () -> text("\n" +
            "██╗  ██╗███████╗██╗     ██╗ ██████╗ ███████╗\n" +
            "██║  ██║██╔════╝██║     ██║██╔═══██╗██╔════╝\n" +
            "███████║█████╗  ██║     ██║██║   ██║███████╗\n" +
            "██╔══██║██╔══╝  ██║     ██║██║   ██║╚════██║\n" +
            "██║  ██║███████╗███████╗██║╚██████╔╝███████║\n" +
            "╚═╝  ╚═╝╚══════╝╚══════╝╚═╝ ╚═════╝ ╚══════╝");

    MessageCreation.Args1<HeliosPlugin> PluginVersion = plugin ->
            prefixedString(text("HeliosCore Version ")
            .append(text(plugin.getVersion()))
            .color(DARK_AQUA));
    MessageCreation.Args0 SHUTDOWN = () -> prefixedString(text("HeliosCore is now shutting down!"));
}
