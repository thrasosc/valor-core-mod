package net.pixeldreamstudios.valor_core.registry;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.pixeldreamstudios.valor_core.ValorCore;

public class CompatRegistry {
  private static void registerScorchfulCompat() {
    if (FabricLoader.getInstance().isModLoaded("scorchful")) {
      ResourceManagerHelper.registerBuiltinResourcePack(
          ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "scorchful_levelz_compat"),
          FabricLoader.getInstance().getModContainer(ValorCore.MOD_ID).orElseThrow(),
          ResourcePackActivationType.DEFAULT_ENABLED);
    }
  }

  private static void registerFrostifulCompat() {
    if (FabricLoader.getInstance().isModLoaded("frostiful")) {
      ResourceManagerHelper.registerBuiltinResourcePack(
          ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "frostiful_levelz_compat"),
          FabricLoader.getInstance().getModContainer(ValorCore.MOD_ID).orElseThrow(),
          ResourcePackActivationType.DEFAULT_ENABLED);
    }
  }

  private static void registerDungeonZTweaks() {
    if (FabricLoader.getInstance().isModLoaded("dungeonz")) {
      ResourceManagerHelper.registerBuiltinResourcePack(
              ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "dungeonza_tweaks"),
              FabricLoader.getInstance().getModContainer(ValorCore.MOD_ID).orElseThrow(),
              ResourcePackActivationType.DEFAULT_ENABLED);
    }
  }

  public static void init() {
    ValorCore.LOGGER.info("Registering compatibilities");
    registerScorchfulCompat();
    registerFrostifulCompat();
    registerDungeonZTweaks();
  }
}
