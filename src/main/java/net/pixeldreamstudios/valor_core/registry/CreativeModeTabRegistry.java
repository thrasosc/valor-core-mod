package net.pixeldreamstudios.valor_core.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.pixeldreamstudios.valor_core.ValorCore;

public class CreativeModeTabRegistry {
  public static final ResourceKey<CreativeModeTab> VALOR_CORE_GROUP_KEY =
      ResourceKey.create(
          BuiltInRegistries.CREATIVE_MODE_TAB.key(),
          ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "creative_mode_tab"));
  public static final CreativeModeTab VALOR_CORE_CREATIVE_MODE_TAB =
      FabricItemGroup.builder()
          .icon(() -> new ItemStack(ItemRegistry.VALOR_GUIDE))
          .title(Component.translatable("creative_mode_tab." + ValorCore.MOD_ID))
          .build();

  public static void init() {
    ValorCore.LOGGER.info("Registering creative mode tabs");
    Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB, VALOR_CORE_GROUP_KEY, VALOR_CORE_CREATIVE_MODE_TAB);
    ItemGroupEvents.modifyEntriesEvent(VALOR_CORE_GROUP_KEY)
        .register(
            creativeModeTab -> {
              creativeModeTab.accept(ItemRegistry.VALOR_GUIDE);
            });
  }
}
