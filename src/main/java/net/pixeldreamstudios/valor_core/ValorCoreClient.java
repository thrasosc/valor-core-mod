package net.pixeldreamstudios.valor_core;

import net.fabricmc.api.ClientModInitializer;
import net.pixeldreamstudios.valor_core.util.ClientSetup;

public class ValorCoreClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSetup.init();
    }
}
