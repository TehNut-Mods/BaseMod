package main.basemod.blocks;

// General place to register all your blocks.

import main.basemod.util.InventoryRender;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

    // Blocks
    public static Block quisqueLapisBlock;
    public static Block quisqueLapisOre;

    public static void registerBlocks() {
        quisqueLapisOre = new BlockQuisqueLapisOre();
        GameRegistry.registerBlock(quisqueLapisOre, "BlockQuisqueLapisOre");

        quisqueLapisBlock = new BlockQuisqueLapis();
        GameRegistry.registerBlock(quisqueLapisBlock, "BlockQuisqueLapis");
    }

    public static void registerInventoryRender() {

        InventoryRender.inventoryBlockRender(quisqueLapisOre, "BlockQuisqueLapisOre");
        InventoryRender.inventoryBlockRender(quisqueLapisBlock, "BlockQuisqueLapis");
    }
}
