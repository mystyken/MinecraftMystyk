package com.mystyk.minecraftmystyk.datagen;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.SmithingTransformRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> ENDER_SHARD_SMELTABLES = List.of(ModBlocks.ENDER_SHARD_ORE);

        offerSmelting(exporter, ENDER_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.ENDER_SHARD_FRAGMENT, .5f, 200, "ender_shard");
        offerBlasting(exporter, ENDER_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.ENDER_SHARD_FRAGMENT, .5f, 100, "ender_shard");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ENDER_SHARD, RecipeCategory.DECORATIONS, ModBlocks.ENDER_SHARD_BLOCK);

        offerSmithingTrimRecipe(exporter, ModItems.FENDER_SMITHING_TEMPLATE, Identifier.of(MinecraftMystyk.MOD_ID, "fender"));

        offerSmithingTemplateCopyingRecipe(exporter, ModItems.FENDER_SMITHING_TEMPLATE, ModItems.ENDER_SHARD_FRAGMENT);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ENDER_SHARD_BLOCK)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ENDER_SHARD)
                .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_block_from_shards"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MIDAS_WAND)
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .input('G', Items.GOLD_BLOCK)
                .input('S', Items.NETHERITE_SWORD)
                .criterion(hasItem(Items.NETHERITE_SWORD), conditionsFromItem(Items.NETHERITE_SWORD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "midas_wand"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MIDAS_WAND)
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .input('G', Items.GOLD_BLOCK)
                .input('S', ModItems.ENDER_INFUSED_SWORD)
                .criterion(hasItem(ModItems.ENDER_INFUSED_SWORD), conditionsFromItem(ModItems.ENDER_INFUSED_SWORD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "midas_wand_from_ender"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDER_SHARD)
                .pattern("ESE")
                .pattern("S S")
                .pattern("ESE")
                .input('S', ModItems.ENDER_SHARD_FRAGMENT)
                .input('E', Items.EMERALD)
                .criterion(hasItem(ModItems.ENDER_SHARD_FRAGMENT), conditionsFromItem(ModItems.ENDER_SHARD_FRAGMENT))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_from_emeralds"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDER_SHARD, 9)
                .input(ModBlocks.ENDER_SHARD_BLOCK)
                .criterion(hasItem(ModBlocks.ENDER_SHARD_BLOCK), conditionsFromItem(ModBlocks.ENDER_SHARD_BLOCK))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_from_block"));


    }
}
