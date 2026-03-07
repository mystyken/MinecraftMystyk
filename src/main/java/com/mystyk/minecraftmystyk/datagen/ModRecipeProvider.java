package com.mystyk.minecraftmystyk.datagen;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.mixin.item.ItemSettingsMixin;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
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

        offerSmithingTrimRecipe(exporter, ModItems.PULSE_SMITHING_TEMPLATE, Identifier.of(MinecraftMystyk.MOD_ID, "pulse"));
        offerSmithingTemplateCopyingRecipe(exporter, ModItems.PULSE_SMITHING_TEMPLATE, ModItems.ADVANCED_ECHO_SHARD);


        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_PICKAXE),
                Ingredient.ofItems(ModItems.ENDER_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ENDER_INFUSED_PICKAXE
        )

        .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_pick_to_ender"));
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_AXE),
                Ingredient.ofItems(ModItems.ENDER_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ENDER_INFUSED_AXE
        )
        .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_axe_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_SHOVEL),
                Ingredient.ofItems(ModItems.ENDER_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ENDER_INFUSED_SHOVEL
        )
        .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_shovel_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_HOE),
                Ingredient.ofItems(ModItems.ENDER_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ENDER_INFUSED_HOE
        )
        .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_hoe_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_SWORD),
                Ingredient.ofItems(ModItems.ENDER_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ENDER_INFUSED_SWORD
        )
        .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_sword_to_ender"));





        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_PICKAXE),
                Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ECHOING_PICKAXE
        )
        .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_pick_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_AXE),
                Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ECHOING_AXE
        )
        .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_axe_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_SHOVEL),
                Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ECHOING_SHOVEL
        )
        .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_shovel_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_HOE),
                Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ECHOING_HOE
        )
        .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_hoe_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(Items.DIAMOND_SWORD),
                Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                RecipeCategory.TOOLS,
                ModItems.ECHOING_SWORD
        )
        .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
        .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_sword_to_echo"));



        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(ModItems.ENDER_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ENDER_INFUSED_HELM
                )
                .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_helm_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(ModItems.ENDER_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ENDER_INFUSED_BRACERS
                )
                .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_chest_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(ModItems.ENDER_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ENDER_INFUSED_GREAVES
                )
                .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_legs_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ENDER_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(ModItems.ENDER_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ENDER_INFUSED_HEELS
                )
                .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_boots_to_ender"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ECHOING_HELM
                )
                .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_helm_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ECHOING_BRACERS
                )
                .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_chest_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ECHOING_GREAVES
                )
                .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_legs_to_echo"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.ECHO_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(ModItems.ADVANCED_ECHO_SHARD),
                        RecipeCategory.TOOLS,
                        ModItems.ECHOING_HEELS
                )
                .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "diamond_boots_to_echo"));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ENDER_SHARD_BLOCK)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ENDER_SHARD)
                .criterion(hasItem(ModItems.ENDER_SHARD), conditionsFromItem(ModItems.ENDER_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_block_from_shards"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SCULK_CATALYST)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ADVANCED_ECHO_SHARD)
                .criterion(hasItem(ModItems.ADVANCED_ECHO_SHARD), conditionsFromItem(ModItems.ADVANCED_ECHO_SHARD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "catalyst_from_shards"));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MIDAS_WAND)
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .input('G', Items.GOLD_BLOCK)
                .input('S', ModItems.ECHOING_SWORD)
                .criterion(hasItem(ModItems.ECHOING_SWORD), conditionsFromItem(ModItems.ECHOING_SWORD))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "midas_wand_from_echo"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDER_SHARD)
                .pattern("ESE")
                .pattern("S S")
                .pattern("ESE")
                .input('S', ModItems.ENDER_SHARD_FRAGMENT)
                .input('E', Items.EMERALD)
                .criterion(hasItem(ModItems.ENDER_SHARD_FRAGMENT), conditionsFromItem(ModItems.ENDER_SHARD_FRAGMENT))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_from_emeralds"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_ECHO_SHARD)
                .pattern("QSQ")
                .pattern("SCS")
                .pattern("QSQ")
                .input('S', ModItems.ADVANCED_ECHO_FRAGMENT)
                .input('Q', Items.QUARTZ)
                .input('C', Items.SCULK_CATALYST)
                .criterion(hasItem(ModItems.ADVANCED_ECHO_FRAGMENT), conditionsFromItem(ModItems.ADVANCED_ECHO_FRAGMENT))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "advanced_echo_shard"));


        /*ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDER_MACE)
                .pattern("   ")
                .pattern(" C ")
                .pattern(" R ")
                .input('C', Items.HEAVY_CORE)
                .input('R', ModItems.ENDER_INFUSED_HANDLE)
                .criterion(hasItem(ModItems.ENDER_INFUSED_HANDLE), conditionsFromItem(ModItems.ENDER_INFUSED_HANDLE))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_mace"));*/

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ENDER_INFUSED_HANDLE)
                .pattern(" F ")
                .pattern("FBF")
                .pattern(" F ")
                .input('B', Items.BREEZE_ROD)
                .input('F', ModItems.ENDER_SHARD_FRAGMENT)
                .criterion(hasItem(ModItems.ENDER_SHARD_FRAGMENT), conditionsFromItem(ModItems.ENDER_SHARD_FRAGMENT))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_handle"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ENDER_SHARD, 9)
                .input(ModBlocks.ENDER_SHARD_BLOCK)
                .criterion(hasItem(ModBlocks.ENDER_SHARD_BLOCK), conditionsFromItem(ModBlocks.ENDER_SHARD_BLOCK))
                .offerTo(exporter, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard_from_block"));


    }
}
