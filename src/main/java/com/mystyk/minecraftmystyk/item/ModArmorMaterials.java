package com.mystyk.minecraftmystyk.item;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final  RegistryKey<EquipmentAsset> ENDER_SHARD_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard"));
    public static final  RegistryKey<EquipmentAsset> ADVANCED_ECHO_SHARD_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(MinecraftMystyk.MOD_ID, "advanced_echo_shard"));



    public static final ArmorMaterial ENDER_SHARD_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }), 35, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,3,0, ModTags.Items.ENDER_SHARD_REPAIR
            , ENDER_SHARD_KEY);
    public static final ArmorMaterial ADVANCED_ECHO_SHARD_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 11);
            }), 35, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,3,0, ModTags.Items.ADVANCED_ECHO_SHARD_REPAIR
            , ADVANCED_ECHO_SHARD_KEY);


}
