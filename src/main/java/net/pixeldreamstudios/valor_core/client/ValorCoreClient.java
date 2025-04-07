package net.pixeldreamstudios.valor_core.client;

import net.fabricmc.api.ClientModInitializer;
import net.pixeldreamstudios.valor_core.registry.CreativeModeTabRegistry;
import net.pixeldreamstudios.valor_core.registry.ItemRegistry;

public class ValorCoreClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CreativeModeTabRegistry.init();
        ItemRegistry.init();
    }
}
