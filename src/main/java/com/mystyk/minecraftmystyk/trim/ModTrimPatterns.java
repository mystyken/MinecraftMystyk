package com.mystyk.minecraftmystyk.trim;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> FENDER = RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(MinecraftMystyk.MOD_ID, "fender"));
    public static final RegistryKey<ArmorTrimPattern> PULSE = RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(MinecraftMystyk.MOD_ID, "pulse"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.FENDER_SMITHING_TEMPLATE, FENDER);
        register(context, ModItems.PULSE_SMITHING_TEMPLATE, PULSE);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        context.register(key, trimPattern);
    }

}
