package com.mystyk.minecraftmystyk.world;

import com.mystyk.minecraftmystyk.MinecraftMystyk;
import com.mystyk.minecraftmystyk.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_ORE_KEY = registryKey("ender_shard_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ECHO_ORE_KEY = registryKey("echo_shard_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);
        RuleTest sculkReplacables = new BlockMatchRuleTest(Blocks.SCULK);

        List<OreFeatureConfig.Target> endMMOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.ENDER_SHARD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldMMOres =
                List.of(OreFeatureConfig.createTarget(sculkReplacables, ModBlocks.ECHOING_ORE.getDefaultState()));

        register(context, ENDER_ORE_KEY, Feature.ORE, new OreFeatureConfig(endMMOres, 3));
        register(context, ECHO_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMMOres, 3));

    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MinecraftMystyk.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
