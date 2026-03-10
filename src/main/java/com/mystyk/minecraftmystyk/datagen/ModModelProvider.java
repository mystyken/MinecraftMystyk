package com.mystyk.minecraftmystyk.datagen;

import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.item.ModArmorMaterials;
import com.mystyk.minecraftmystyk.item.ModItems;
import com.mystyk.minecraftmystyk.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TextureMap;

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
        //itemModelGenerator.register(ModItems.ENDER_INFUSED_HANDLE, Models.GENERATED);
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


        itemModelGenerator.registerArmor(ModItems.ENDER_INFUSED_HELM, ModArmorMaterials.ENDER_SHARD_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ENDER_INFUSED_BRACERS, ModArmorMaterials.ENDER_SHARD_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ENDER_INFUSED_GREAVES, ModArmorMaterials.ENDER_SHARD_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ENDER_INFUSED_HEELS, ModArmorMaterials.ENDER_SHARD_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        itemModelGenerator.register(ModItems.ECHOING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOING_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.ECHOING_HELM, ModArmorMaterials.ADVANCED_ECHO_SHARD_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ECHOING_BRACERS, ModArmorMaterials.ADVANCED_ECHO_SHARD_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ECHOING_GREAVES, ModArmorMaterials.ADVANCED_ECHO_SHARD_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.ECHOING_HEELS, ModArmorMaterials.ADVANCED_ECHO_SHARD_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
