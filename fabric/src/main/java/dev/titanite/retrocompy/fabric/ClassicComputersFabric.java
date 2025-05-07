package dev.titanite.retrocompy.fabric;

import net.fabricmc.api.ModInitializer;

import dev.titanite.retrocompy.ClassicComputers;

public final class ClassicComputersFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ClassicComputers.init();
    }
}
