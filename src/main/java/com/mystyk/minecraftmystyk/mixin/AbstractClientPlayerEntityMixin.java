package com.mystyk.minecraftmystyk.mixin;


import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {
    public AbstractClientPlayerEntityMixin(World world, GameProfile gameProfile) {
        super(world, gameProfile);
    }

    /*@Inject(method = "getFovMultiplier", at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void getFovMultiplierMixin(CallbackInfoReturnable<Float> info, float f) {
        Item item = this.getActiveItem().getItem();
        ItemStack itemstack = this.getActiveItem();
        if(this.isUsingItem() && itemstack.isOf(ModItems.ENDER_STRUNG_BOW)) {
            int i = this.getItemUseTime();
            float g = (float)i / 20.0f;
            g = g > 1.0f ? 1.0f : g * g;
            f *= 1.0f - g * 0.15f;
            info.setReturnValue(MathHelper.lerp(MinecraftClient.getInstance().options.getFovEffectScale().getValue().floatValue(), 1.0f, f));
        }
    }*/
}
