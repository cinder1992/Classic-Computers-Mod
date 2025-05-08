package dev.titanite.retrocompy;

import dev.titanite.retrocompy.blocks.ClassicComputersBlocks;
import dev.titanite.retrocompy.items.ClassicComputersItems;
import dev.titanite.retrocompy.tabs.ClassicComputersCreativeTab;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClassicComputers {
    public static final String MOD_ID = "classic_computers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Minecraft MINECRAFT = Minecraft.getInstance();

    public static void init() {
        LOGGER.info("Hello from ClassicComputers!");
        ClassicComputersBlocks.init();
        ClassicComputersCreativeTab.init();
        ClassicComputersItems.init();
    }
}
