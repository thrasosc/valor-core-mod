package net.pixeldreamstudios.valor_core.registry;

import io.wispforest.lavender.book.LavenderBookItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.pixeldreamstudios.valor_core.ValorCore;

public class ItemRegistry {
    public static final Item VALOR_GUIDE = LavenderBookItem.registerForBook(ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "valor_guide"), ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "valor_guide"), new Item.Properties().stacksTo(1));
    public static final Item SEASONS_ICON = register(new Item(new Item.Properties().stacksTo(1)), "seasons_icon");
    public static final Item SKILLS_ICON = register(new Item(new Item.Properties().stacksTo(1)), "skills_icon");
    public static final Item PROFESSIONS_ICON = register(new Item(new Item.Properties().stacksTo(1)), "professions_icon");
    public static final Item PARTIES_ICON = register(new Item(new Item.Properties().stacksTo(1)), "parties_icon");

    public static Item register(Item item, String id) {
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, id);
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

        return registeredItem;
    }

    public static void init() {
        ValorCore.LOGGER.info("Registering items");
    }
}
