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
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ENDER_SHARD_BLOCK)
                .add(ModBlocks.ENDER_SHARD_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ENDER_SHARD_ORE)
                .add(ModBlocks.ENDER_SHARD_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ENDER_INFUSED_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
