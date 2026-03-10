package com.mystyk.minecraftmystyk.item.custom;

import com.mystyk.minecraftmystyk.block.ModBlocks;
import com.mystyk.minecraftmystyk.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class MidasWand extends Item {
    public static final Map<Block, Block> MIDASIZER =
            Map.of(
                    Blocks.EMERALD_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.IRON_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.DIAMOND_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.EMERALD_ORE, Blocks.GOLD_ORE,
                    Blocks.IRON_ORE, Blocks.GOLD_ORE,
                    Blocks.DIAMOND_ORE, Blocks.GOLD_ORE,
                    Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                    Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                    Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_GOLD_ORE
            );
    public MidasWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(MIDASIZER.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), MIDASIZER.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }
}
