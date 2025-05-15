package net.pixeldreamstudios.valor_core.util;

import io.wispforest.lavender.book.BookLoader;
import io.wispforest.lavender.client.LavenderBookScreen;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.valor_core.ValorCore;

import java.util.List;

public class ClientSetup {
    public static void createGuideBookButton() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof InventoryScreen) {
                List<? extends GuiEventListener> widgets = screen.children();
                for (GuiEventListener widget : widgets) {
                    if (widget instanceof ImageButton) {
                        try {
                            ImageButton texturedButtonWidget = (ImageButton) widget;
                            if (texturedButtonWidget.getWidth() == 20 && texturedButtonWidget.getHeight() == 18) {
                                texturedButtonWidget.active = false;
                                texturedButtonWidget.visible = false;
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
                Screens.getButtons(screen).add(Button.builder(Component.literal("Guide Book"), p -> client.setScreen(new LavenderBookScreen(BookLoader.get(ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "valor_guide"))))).pos(scaledWidth / 2 + 8, scaledHeight / 2 - 98).size(80, 16).build());
            }
            else if (screen instanceof CraftingScreen) {
                List<? extends GuiEventListener> widgets = screen.children();
                for (GuiEventListener widget : widgets) {
                    if (widget instanceof ImageButton) {
                        try {
                            ImageButton texturedButtonWidget = (ImageButton) widget;
                            if (texturedButtonWidget.getWidth() == 20 && texturedButtonWidget.getHeight() == 18) {
                                texturedButtonWidget.active = false;
                                texturedButtonWidget.visible = false;
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static void init() {
        ValorCore.LOGGER.info("Initialising client setup");
        createGuideBookButton();
    }
}
