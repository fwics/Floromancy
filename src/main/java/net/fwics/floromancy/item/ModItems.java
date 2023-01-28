package net.fwics.floromancy.item;

import net.fwics.floromancy.Floromancy;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Floromancy.MOD_ID);

    public static final RegistryObject<Item> SCULK_LOCK = ITEMS.register( "sculk_lock",
            () -> new Item( new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
