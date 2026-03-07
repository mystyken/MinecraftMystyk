package com.mystyk.minecraftmystyk;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import org.intellij.lang.annotations.Identifier;

public class MinecraftMystykClient implements ClientModInitializer{
    @Override
    public void onInitializeClient() {

    }

    /*private static void registerBowModel(Item bow) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            return entity.getActiveItem() == stack ? (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f : 0.0f;
        });

        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"), (stack, world, entity, seed) -> {
            return entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f;
        });
    }*/
}