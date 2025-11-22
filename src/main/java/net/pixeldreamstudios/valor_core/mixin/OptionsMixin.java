package net.pixeldreamstudios.valor_core.mixin;

import net.minecraft.client.Options;
import net.pixeldreamstudios.valor_core.ValorCore;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
public class OptionsMixin {

    @Inject(method = "load", at = @At("HEAD"))
    private void beforeLoadOptions(CallbackInfo ci) {
        // Modify options.txt before it's read
        modifyOptionsFile();
    }

    private void modifyOptionsFile() {
        try {
            java.nio.file.Path optionsPath = net.fabricmc.loader.api.FabricLoader.getInstance()
                    .getGameDir().resolve("options.txt");

            if (!java.nio.file.Files.exists(optionsPath)) {
                return;
            }

            java.util.List<String> lines = java.nio.file.Files.readAllLines(optionsPath);
            java.util.List<String> modifiedLines = new java.util.ArrayList<>();

            for (String line : lines) {
                if (line.startsWith("resourcePacks:")) {
                    modifiedLines.add("resourcePacks:[]");
                } else if (line.startsWith("incompatibleResourcePacks:")) {
                    modifiedLines.add("incompatibleResourcePacks:[]");
                } else {
                    modifiedLines.add(line);
                }
            }

            java.nio.file.Files.write(optionsPath, modifiedLines);
            ValorCore.LOGGER.info("Successfully reset resource packs");
        } catch (Exception e) {
            ValorCore.LOGGER.error("Failed to reset resource packs: " + e.getMessage());
        }
    }
}