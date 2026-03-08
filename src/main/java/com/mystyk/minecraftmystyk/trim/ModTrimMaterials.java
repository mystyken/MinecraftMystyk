package com.mystyk.minecraftmystyk.trim;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> ENDER_SHARD = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MinecraftMystyk.MOD_ID, "ender_shard"));
    public static final RegistryKey<ArmorTrimMaterial> ADVANCED_ECHO_SHARD = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(MinecraftMystyk.MOD_ID, "advanced_echo_shard"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, ENDER_SHARD, Registries.ITEM.getEntry(ModItems.ENDER_SHARD),
                Style.EMPTY.withColor(TextColor.parse("#fc039d").getOrThrow()));
        register(registerable, ADVANCED_ECHO_SHARD, Registries.ITEM.getEntry(ModItems.ADVANCED_ECHO_SHARD),
                Style.EMPTY.withColor(TextColor.parse("#19628a").getOrThrow()));

    }



    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
