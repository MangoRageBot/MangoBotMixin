package org.mangorage.mangobotmixin.mixin.transformer;

import org.mangorage.mangobotmixin.mixin.MixinContainer;
import org.spongepowered.asm.mixin.transformer.IMixinTransformer;
import org.spongepowered.asm.mixin.transformer.IMixinTransformerFactory;

public final class MangoBotTransformer {
    private static final MangoBotTransformer INSTANCE = new MangoBotTransformer();

    public static MangoBotTransformer getInstance() {
        return INSTANCE;
    }

    private IMixinTransformerFactory factory;
    private IMixinTransformer transformer;
    private MixinContainer mixinContainer;

    public void set(IMixinTransformerFactory transformer, MixinContainer mixinContainer) {
        this.factory = transformer;
        this.mixinContainer = mixinContainer;
    }

    public IMixinTransformer getTransformer() {
        return transformer;
    }

    public void load() {
        this.transformer = factory.createTransformer();

    }
}
