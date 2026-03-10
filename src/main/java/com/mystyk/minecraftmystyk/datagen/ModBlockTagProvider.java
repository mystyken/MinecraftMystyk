package com.mystyk.minecraftmystyk.datagen;

import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ENDER_SHARD_BLOCK)
                .add(ModBlocks.ENDER_SHARD_ORE);
        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.ADVANCED_SCULK_CATALYST)
                .add(ModBlocks.ECHOING_ORE);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ENDER_SHARD_ORE)
                .add(ModBlocks.ENDER_SHARD_BLOCK)
                .add(ModBlocks.ADVANCED_SCULK_CATALYST)
                .add(ModBlocks.ECHOING_ORE);

        valueLookupBuilder(ModTags.Blocks.NEEDS_ENDER_INFUSED_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        valueLookupBuilder(ModTags.Blocks.NEEDS_ECHOING_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
