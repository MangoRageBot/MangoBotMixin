package org.mangorage.mangobotmixin.mixin.services;

import org.spongepowered.asm.service.IMixinServiceBootstrap;

public final class MangoBotMixinBootstrapImpl implements IMixinServiceBootstrap {
    @Override
    public String getName() {
        return "MangoBotBootstrap";
    }

    @Override
    public String getServiceClassName() {
        return "org.mangorage.mixin.MixinServiceMangoBot";
    }

    @Override
    public void bootstrap() {
        System.out.println("WORKED");
    }
}
