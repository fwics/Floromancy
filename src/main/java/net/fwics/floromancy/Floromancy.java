package net.fwics.floromancy;

import com.mojang.logging.LogUtils;
import net.fwics.floromancy.block.ModBlocks;
import net.fwics.floromancy.item.ModCreativeModeTabs;
import net.fwics.floromancy.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Floromancy.MOD_ID)
public class Floromancy {
    public static final String MOD_ID = "floromancy";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Floromancy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register( modEventBus );

        ModBlocks.register( modEventBus );

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if( event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS ) {
            event.accept(ModBlocks.BLOOMING_PEDESTAL);
        }
        if( event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS ) {
            event.accept(ModBlocks.BLOOMING_PEDESTAL);
        }
        if( event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.SCULK_LOCK);
        }
        if( event.getTab() == ModCreativeModeTabs.BLOOMED_PLANTS) {
            event.accept(ModItems.SCULK_LOCK);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
