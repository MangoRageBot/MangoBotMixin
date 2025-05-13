package org.mangorage.mangobotmixin.mixin;

import org.mangorage.mangobotmixin.mixin.core.MangoBotMixinBootstrap;
import org.mangorage.mangobotmixin.mixin.core.MixinServiceMangoBot;
import org.mangorage.mangobotmixin.mixin.transformer.MangoBotTransformer;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.lang.reflect.Method;

public final class SpongeMixinImpl {
    private static final SpongeMixinImpl INSTANCE = new SpongeMixinImpl();

    public static void load() {}

    SpongeMixinImpl() {
        // Load
//        System.setProperty("mixin.debug.verbose", "true");
//        System.setProperty("mixin.debug", "true");
//        System.setProperty("mixin.env.disableRefMap", "true");
//        System.setProperty("mixin.checks", "true");

        System.setProperty("mixin.bootstrapService", MangoBotMixinBootstrap.class.getName());
        System.setProperty("mixin.service", MixinServiceMangoBot.class.getName());
        System.setProperty("mixin.env.remapRefMap", "false");

        MixinBootstrap.init();

        Mixins.addConfiguration("mangobotcore.mixins.json");

        completeMixinBootstrap();

        // Mixin Extras Init
    }

    private void completeMixinBootstrap() {
        // Move to the default phase.
        try {
            final Method method = MixinEnvironment.class.getDeclaredMethod("gotoPhase", MixinEnvironment.Phase.class);
            method.setAccessible(true);
            method.invoke(null, MixinEnvironment.Phase.INIT);
            method.invoke(null, MixinEnvironment.Phase.DEFAULT);
        } catch(final Exception exception) {
            exception.printStackTrace();
        }

        MangoBotTransformer.getInstance().load();
    }
}


