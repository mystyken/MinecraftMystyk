package com.mystyk.minecraftmystyk.datagen;

import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_SHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_SHARD_BLOCK);
        blockStateModelGenerator.registerGeneric(ModBlocks.ADVANCED_SCULK_CATALYST);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ECHOING_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ENDER_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_SHARD_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_INFUSED_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADVANCED_ECHO_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADVANCED_ECHO_FRAGMENT, Models.GENERATED);

        itemModelGenerator.register(ModItems.FENDER_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PULSE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        //itemModelGenerator.register(ModItems.ENDER_MACE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MIDAS_WAND, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ENDER_INFUSED_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_INFUSED_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_INFUSED_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_INFUSED_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDER_INFUSED_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDER_INFUSED_HELM));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDER_INFUSED_BRACERS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDER_INFUSED_GREAVES));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDER_INFUSED_HEELS));

        itemModelGenerator.register(ModItems.ECHOING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOING_HELM));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOING_BRACERS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOING_GREAVES));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOING_HEELS));
    }
}
