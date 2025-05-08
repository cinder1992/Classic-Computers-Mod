package dev.titanite.retrocompy.tabs;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.titanite.retrocompy.ClassicComputers;
import dev.titanite.retrocompy.items.ClassicComputersItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ClassicComputersCreativeTab {
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ClassicComputers.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> CLASSIC_COMPUTERS_TAB =
            TABS.register("classic_computers_tab",
                    () -> CreativeTabRegistry.create(Component.translatable("itemGroup.classic_computers.classic_computers_tab"),
                    () -> new ItemStack(ClassicComputersItems.DEBUGGER_ITEM.get())));

    public static void init() {
        TABS.register();
    }
}
