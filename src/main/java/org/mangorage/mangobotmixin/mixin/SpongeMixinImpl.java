package org.mangorage.mangobotmixin.mixin;

import org.mangorage.mangobotmixin.mixin.core.MangoBotMixinBootstrapImpl;
import org.mangorage.mangobotmixin.mixin.core.MangoBotMixinServiceImpl;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.IMixinTransformer;
import org.spongepowered.asm.mixin.transformer.IMixinTransformerFactory;

import java.lang.reflect.Method;

public final class SpongeMixinImpl {
    private static final boolean DEBUG = false;

    private static boolean loaded = false;
    private static IMixinTransformerFactory factory;
    private static IMixinTransformer transformer;

    public static void setFactory(IMixinTransformerFactory factory) {
        if (SpongeMixinImpl.factory != null) return;
        SpongeMixinImpl.factory = factory;
    }

    public static void prepare() {
        if (SpongeMixinImpl.transformer != null) return;
        SpongeMixinImpl.transformer = factory.createTransformer();
    }

    public static IMixinTransformer getTransformer() {
        return transformer;
    }

    public static void load() {
        if (loaded) return;
        loaded = true;

        // Load

        if (DEBUG) {
            System.setProperty("mixin.debug.verbose", "true");
            System.setProperty("mixin.debug", "true");
            System.setProperty("mixin.env.disableRefMap", "true");
            System.setProperty("mixin.checks", "true");
        }

        System.setProperty("mixin.bootstrapService", MangoBotMixinBootstrapImpl.class.getName());
        System.setProperty("mixin.service", MangoBotMixinServiceImpl.class.getName());

        MixinBootstrap.init();

        completeMixinBootstrap();
    }

    private static void completeMixinBootstrap() {
        // Move to the default phase.
        try {
            final Method method = MixinEnvironment.class.getDeclaredMethod("gotoPhase", MixinEnvironment.Phase.class);
            method.setAccessible(true);
            method.invoke(null, MixinEnvironment.Phase.INIT);
            method.invoke(null, MixinEnvironment.Phase.DEFAULT);
        } catch(final Exception exception) {
            exception.printStackTrace();
        }
        prepare();
    }
}


