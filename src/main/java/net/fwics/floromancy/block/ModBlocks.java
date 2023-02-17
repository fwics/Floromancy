package net.fwics.floromancy.block;

import net.fwics.floromancy.Floromancy;
import net.fwics.floromancy.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister< Block > BLOCKS =
            DeferredRegister.create( ForgeRegistries.BLOCKS, Floromancy.MOD_ID );

    public static final RegistryObject< Block > BLOOMING_PEDESTAL = registerBlock( "blooming_pedestal",
            () -> new Block( BlockBehaviour.Properties.of( Material.STONE )
                    .strength( 50f, 1200f )
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .isRedstoneConductor( ( bs, br, bp ) -> false)
            )
    );

    private static < T extends Block > RegistryObject<T> registerBlock( String name, Supplier<T> block ){
        RegistryObject<T> toReturn = BLOCKS.register( name, block );
        registerBlockItem( name, toReturn );
        return toReturn;
    }
    private static < T extends Block > RegistryObject< Item > registerBlockItem( String name, RegistryObject<T> block ){
        return ModItems.ITEMS.register( name, () -> new BlockItem( block.get(),
                new Item.Properties() ) );
    }

    public static void register( IEventBus eventBus ) {
        BLOCKS.register( eventBus );
    }
}
