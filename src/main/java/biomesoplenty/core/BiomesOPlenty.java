/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/

package biomesoplenty.core;

import biomesoplenty.api.biome.BiomeProviders;
import biomesoplenty.client.handler.FluidFogHandler;
import biomesoplenty.init.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value = BiomesOPlenty.MOD_ID)
public class BiomesOPlenty
{
    public static final String MOD_ID = "biomesoplenty";

    public static BiomesOPlenty instance;
    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public static Logger logger = LogManager.getLogger(MOD_ID);

    public BiomesOPlenty()
    {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        ModParticles.PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

        if (FMLEnvironment.dist == Dist.CLIENT)
        {
            MinecraftForge.EVENT_BUS.register(new FluidFogHandler());
        }

        ModConfig.setup();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ModBiomes.setup();
            ModVanillaCompat.setup();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
//        NoiseSimulator.run();
    }

    private void loadComplete(final FMLLoadCompleteEvent event)
    {
        proxy.init();
        ModTags.setup();
    }
}
