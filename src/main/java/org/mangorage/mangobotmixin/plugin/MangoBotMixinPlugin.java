package org.mangorage.mangobotmixin.plugin;

import org.mangorage.mangobotcore.plugin.api.MangoBotPlugin;
import org.mangorage.mangobotcore.plugin.api.Plugin;

@MangoBotPlugin(id = MangoBotMixinPlugin.ID)
public final class MangoBotMixinPlugin implements Plugin {
    public static final String ID = "mangobotmixin";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void load() {
    }
}
