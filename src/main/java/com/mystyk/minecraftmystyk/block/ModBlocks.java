package com.mystyk.minecraftmystyk.block;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block ENDER_SHARD_BLOCK = registerBlock("ender_shard_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ENDER_SHARD_ORE = registerBlock("ender_shard_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));

    public static final Block ADVANCED_SCULK_CATALYST = registerBlock("advanced_sculk_catalyst", new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.SCULK_CATALYST)));
    public static final Block ECHOING_ORE = registerBlock("echoing_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 1),AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.SCULK_SHRIEKER)));

    //public static final Block ENCHANTED_GOLDEN_WITHER_SKELETON_SKULL = registerBlock("enchanted_golden_wither_skeleton_skull",
    //        new SkullBlock((SkullBlock.SkullType) Blocks.WITHER_SKELETON_SKULL.getDefaultState(),
    //                AbstractBlock.Settings.create().strength(2f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MinecraftMystyk.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MinecraftMystyk.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MinecraftMystyk.LOGGER.info("Registering Mod Blocks for "+ MinecraftMystyk.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
        //    entries.add(ENCHANTED_GOLDEN_WITHER_SKELETON_SKULL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ENDER_SHARD_BLOCK);
            entries.add(ModBlocks.ENDER_SHARD_ORE);
            entries.add(ModBlocks.ADVANCED_SCULK_CATALYST);
            entries.add(ModBlocks.ECHOING_ORE);
        });
    }
}
