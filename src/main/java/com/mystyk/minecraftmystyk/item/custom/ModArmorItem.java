package com.mystyk.minecraftmystyk.item.custom;

import com.google.common.collect.ImmutableMap;
import com.mystyk.minecraftmystyk.item.ModArmorMaterials;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends Item {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.ENDER_SHARD_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 1, false, false), new StatusEffectInstance(StatusEffects.RESISTANCE, 10, 1, false, false)))
                    .put(ModArmorMaterials.ADVANCED_ECHO_SHARD_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.DARKNESS, 200, 1, false, false), new StatusEffectInstance(StatusEffects.STRENGTH, 10, 1, false, false)))
                    .put(ArmorMaterials.NETHERITE,
                            List.of(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 10, 0, false, false)))
                    .build();

    public ModArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getStack(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getStack(EquipmentSlot.LEGS.getIndex());
        ItemStack breastplate = player.getInventory().getStack(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getStack(EquipmentSlot.HEAD.getIndex());

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        EquippableComponent equippableComponentBoots = player.getEquippedStack(EquipmentSlot.FEET).getItem().getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = player.getEquippedStack(EquipmentSlot.LEGS).getItem().getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentBreastplate = player.getEquippedStack(EquipmentSlot.CHEST).getItem().getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = player.getEquippedStack(EquipmentSlot.HEAD).getItem().getComponents().get(DataComponentTypes.EQUIPPABLE);

        return equippableComponentBoots.assetId().get().equals(material.assetId()) && equippableComponentLeggings.assetId().get().equals(material.assetId()) &&
                equippableComponentBreastplate.assetId().get().equals(material.assetId()) && equippableComponentHelmet.assetId().get().equals(material.assetId());
    }
}
