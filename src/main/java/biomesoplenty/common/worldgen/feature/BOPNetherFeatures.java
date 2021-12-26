/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.common.worldgen.feature;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class BOPNetherFeatures
{
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> BLACKSTONE_BULB = register("blackstone_bulb", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BOPBlocks.BLACKSTONE_BULB))))));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> BLACKSTONE_SPINES = register("blackstone_spines", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(BOPBlocks.BLACKSTONE_SPINES))))));

    public static final ConfiguredFeature<?, ?> LARGE_ROSE_QUARTZ = register("large_rose_quartz", BOPBaseFeatures.LARGE_ROSE_QUARTZ.configured(new LargeDripstoneConfiguration(30, UniformInt.of(3, 7), UniformFloat.of(0.3F, 1.8F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F)));
    public static final ConfiguredFeature<?, ?> OBSIDIAN_SPLATTER = register("obsidian_splatter", BOPBaseFeatures.OBSIDIAN_SPLATTER.configured(NoneFeatureConfiguration.INSTANCE));
    public static final ConfiguredFeature<?, ?> SMALL_CRYSTAL = register("small_crystal", BOPBaseFeatures.SMALL_CRYSTAL.configured(NoneFeatureConfiguration.INSTANCE));

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> feature)
    {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(BiomesOPlenty.MOD_ID, key), feature);
    }
}
