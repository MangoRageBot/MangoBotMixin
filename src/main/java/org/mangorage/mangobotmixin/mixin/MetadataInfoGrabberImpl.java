package org.mangorage.mangobotmixin.mixin;

import org.mangorage.mangobotcore.plugin.api.IPluginInfoGetter;
import org.mangorage.mangobotcore.plugin.api.Metadata;
import org.spongepowered.asm.mixin.Mixins;

import java.util.List;

public final class MetadataInfoGrabberImpl implements IPluginInfoGetter {
    @Override
    public void onGet(List<Metadata> list) {
        list
                .forEach(container -> {
                    final var extraMap = container.getExtraMap();
                    if (extraMap != null) {
                        final var mixins = (List<String>) extraMap.getKey("mixins", List.class);
                        if (mixins != null) {
                            for (String mixin : mixins) {
                                System.out.println("Adding Mixin " + mixin);
                                Mixins.addConfiguration(mixin);
                            }
                        }
                    }
                });
    }
}
