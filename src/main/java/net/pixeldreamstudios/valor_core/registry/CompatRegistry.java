package net.pixeldreamstudios.valor_core.registry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
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
          ResourceLocation.fromNamespaceAndPath(ValorCore.MOD_ID, "dungeonz_tweaks"),
          FabricLoader.getInstance().getModContainer(ValorCore.MOD_ID).orElseThrow(),
          ResourcePackActivationType.DEFAULT_ENABLED);
    }
  }

  public static boolean isMacOS() {
    String osName = System.getProperty("os.name").toLowerCase();
    return osName.contains("mac") || osName.contains("darwin");
  }

  // Use this hack until this issue is fixed: https://github.com/Gaming32/mod-loading-screen/issues/34
  private static void disableModLoadingScreen() {
    if (!isMacOS()) {
      return;
    }

    Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("mod-loading-screen");

    if (!modContainer.isPresent()) {
      return; // Mod not loaded, nothing to do
    }

    ValorCore.LOGGER.warn("Incompatible mod {} detected on macOS", modContainer.get().getMetadata().getName());

    ModContainer mod = modContainer.get();
    Path modPath = mod.getOrigin().getPaths().get(0);
    Path modsDir = FabricLoader.getInstance().getGameDir().resolve("mods");

    if (!modPath.startsWith(modsDir)) {
      // Mod is bundled or in an unusual location
      ValorCore.LOGGER.error("Incompatible mod '{}' detected on macOS but cannot be auto-disabled (not in mods folder)",
          mod.getMetadata().getName());
      System.exit(1);
      return;
    }

    Path disabledPath = modPath.resolveSibling(modPath.getFileName() + ".disabled");

    try {
      Files.move(modPath, disabledPath);
      ValorCore.LOGGER.warn(
          "Incompatible mod '{}' has been disabled on macOS. Please restart the modpack for the changes to take effect.",
          mod.getMetadata().getName());
      throw new ReportedException(new CrashReport(
          "Incompatible mod '" + mod.getMetadata().getName() + "' disabled on macOS",
          new Throwable(
              "Incompatible mod '" + mod.getMetadata().getName() + "' has been disabled on macOS. Please restart the modpack for the changes to take effect.")));
    } catch (IOException e) {
      ValorCore.LOGGER.error(
          "Failed to disable incompatible mod '{}': {}. Please manually remove or rename this file, then restart Minecraft.",
          mod.getMetadata().getName(), e.getMessage(), modPath);
      throw new ReportedException(new CrashReport("Failed to disable incompatible mod '" + mod.getMetadata().getName() + "' on macOS", new Throwable(
          "Failed to disable incompatible mod '" + mod.getMetadata().getName() + "' on macOS. Please manually remove or rename this file, then restart Minecraft.")));
    }
  }

  public static void init() {
    ValorCore.LOGGER.info("Registering compatibilities");
    registerScorchfulCompat();
    registerFrostifulCompat();
    registerDungeonZTweaks();
    disableModLoadingScreen();
  }
}
