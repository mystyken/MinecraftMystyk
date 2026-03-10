package com.mystyk.minecraftmystyk.item;

import com.google.common.base.Suppliers;
import com.mystyk.minecraftmystyk.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public class ModToolMaterials{
    public static final ToolMaterial ENDER_SHARD = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ENDER_INFUSED_TOOL,
            2031, 9.0F, 4.0F, 35, ModTags.Items.ENDER_SHARD_REPAIR);
    public static final ToolMaterial ADVANCED_ECHO_SHARD = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ECHOING_TOOL,
            2031, 9.0F, 4.0F, 35, ModTags.Items.ADVANCED_ECHO_SHARD_REPAIR);
    public static final ToolMaterial MIDAS_MATERIAL = new ToolMaterial(null, 500, 9.0F, 4.0F, 1, ItemTags.GOLD_TOOL_MATERIALS);
}
