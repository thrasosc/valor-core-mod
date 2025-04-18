package net.pixeldreamstudios.valor_core;

import net.fabricmc.api.ModInitializer;
import net.pixeldreamstudios.valor_core.registry.CompatRegistry;
import net.pixeldreamstudios.valor_core.registry.CreativeModeTabRegistry;
import net.pixeldreamstudios.valor_core.registry.ItemRegistry;
import net.pixeldreamstudios.valor_core.util.ClientSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValorCore implements ModInitializer {
  public static final String MOD_ID = "valor_core";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Initialising Valor Core");
    ClientSetup.createGuideBookButton();
    CreativeModeTabRegistry.init();
    ItemRegistry.init();
    CompatRegistry.init();
  }
}
