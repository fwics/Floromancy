package net.fwics.floromancy.item;

import net.fwics.floromancy.Floromancy;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber( modid = Floromancy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModCreativeModeTabs {
    public static CreativeModeTab BLOOMED_PLANTS;

    @SubscribeEvent
    public static void registerCreativeModeTabs( CreativeModeTabEvent.Register event ) {
        BLOOMED_PLANTS = event.registerCreativeModeTab( new ResourceLocation( Floromancy.MOD_ID, "bloomed_plants" ),
                builder -> builder.icon( () -> new ItemStack( ModItems.SCULK_LOCK.get() ) ).title( Component.translatable( "creativemodetab.bloomed_plants" ) ) );
    }
}
