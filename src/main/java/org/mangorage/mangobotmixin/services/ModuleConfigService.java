package org.mangorage.mangobotmixin.services;

import org.mangorage.bootstrap.api.module.IModuleConfigurator;
import org.mangorage.bootstrap.api.module.IModuleLayer;

import java.util.List;

public final class ModuleConfigService implements IModuleConfigurator {
    @Override
    public void configureModuleLayer(IModuleLayer moduleLayer) {
        // Common Stuff that both modules need...
        moduleLayer.addOpens(
                "org.spongepowered.mixin",
                List.of(
                        "org.spongepowered.asm.mixin.transformer"
                ),
                List.of(
                        "org.mangorage.mangobotmixin",
                        "mixinextras.common"
                )
        );

        // Stuff that needs to be opened to the one target
        moduleLayer.addOpens(
                "org.spongepowered.mixin",
                List.of(

                        "org.spongepowered.asm.mixin",
                        "org.spongepowered.asm.transformers"
                ),
                List.of(
                        "org.mangorage.mangobotmixin"
                )
        );

        // Stuff that needs to be opened to the one target
        moduleLayer.addOpens(
                "org.spongepowered.mixin",
                List.of(
                        "org.spongepowered.asm.mixin.transformer.ext.extensions",
                        "org.spongepowered.asm.mixin.injection.struct",
                        "org.spongepowered.asm.mixin.transformer.ext",
                        "org.spongepowered.asm.transformers",
                        "org.spongepowered.asm.mixin"
                ),
                List.of(
                        "mixinextras.common"
                )
        );
    }
}
