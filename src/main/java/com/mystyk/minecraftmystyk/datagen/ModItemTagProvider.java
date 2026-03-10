package com.mystyk.minecraftmystyk.datagen;

import com.mystyk.minecraftmystyk.item.ModItems;
import com.mystyk.minecraftmystyk.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.ENDER_INFUSED_SWORD)
                .add(ModItems.ECHOING_SWORD);
        /*valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.ENDER_INFUSED_SPEAR)
                .add(ModItems.ECHOING_SPEAR);*/
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.ENDER_INFUSED_PICKAXE)
                .add(ModItems.ECHOING_PICKAXE);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.ENDER_INFUSED_AXE)
                .add(ModItems.ECHOING_AXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.ENDER_INFUSED_SHOVEL)
                .add(ModItems.ECHOING_SHOVEL);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.ENDER_INFUSED_HOE)
                .add(ModItems.ECHOING_HOE);
        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.ENDER_INFUSED_HELM)
                .add(ModItems.ECHOING_HELM);
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.ENDER_INFUSED_BRACERS)
                .add(ModItems.ECHOING_BRACERS);
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.ENDER_INFUSED_GREAVES)
                .add(ModItems.ECHOING_GREAVES);
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.ENDER_INFUSED_HEELS)
                .add(ModItems.ECHOING_HEELS);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.MIDAS_WAND);

        /*valueLookupBuilder()(ItemTags.MACE_ENCHANTABLE)
                .add(ModItems.ENDER_MACE);*/


        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ENDER_INFUSED_HELM)
                .add(ModItems.ENDER_INFUSED_BRACERS)
                .add(ModItems.ENDER_INFUSED_GREAVES)
                .add(ModItems.ENDER_INFUSED_HEELS)
                .add(ModItems.ECHOING_HELM)
                .add(ModItems.ECHOING_BRACERS)
                .add(ModItems.ECHOING_GREAVES)
                .add(ModItems.ECHOING_HEELS);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ENDER_SHARD)
                .add(ModItems.ADVANCED_ECHO_SHARD);

        valueLookupBuilder(ModTags.Items.ENDER_SHARD_REPAIR)
                .add(ModItems.ENDER_SHARD);

        valueLookupBuilder(ModTags.Items.ADVANCED_ECHO_SHARD_REPAIR)
                .add(ModItems.ADVANCED_ECHO_SHARD);

        valueLookupBuilder(ModTags.Items.SUPER_SWORD)
                .add(ModItems.ENDER_INFUSED_SWORD)
                .add(ModItems.ECHOING_SWORD)
                .add(Items.NETHERITE_SWORD);

    }
}
