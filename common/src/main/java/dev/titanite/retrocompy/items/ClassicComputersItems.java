package dev.titanite.retrocompy.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.titanite.retrocompy.ClassicComputers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ClassicComputersItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ClassicComputers.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> DEBUGGER_ITEM = registerItem("debugger", ItemDebugger::new);

    public static void init() {
        ITEMS.register();
    }

    public static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(ClassicComputers.MOD_ID, name), item);
    }
}
