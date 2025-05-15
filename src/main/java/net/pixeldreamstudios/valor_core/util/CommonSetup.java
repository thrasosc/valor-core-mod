package net.pixeldreamstudios.valor_core.util;

import net.pixeldreamstudios.valor_core.ValorCore;
import net.pixeldreamstudios.valor_core.mixin.CommonLinksAccessor;

import java.net.URI;

public class CommonSetup {
    public static void init() {
        ValorCore.LOGGER.info("Initialising common setup");
        CommonLinksAccessor.setLink(URI.create("https://legacy.curseforge.com/minecraft/modpacks/valor-rpg/issues"));
    }
}
