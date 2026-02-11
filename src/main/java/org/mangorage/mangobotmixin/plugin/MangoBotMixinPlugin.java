package org.mangorage.mangobotmixin.plugin;


import org.mangorage.mangobotcore.api.plugin.v1.MangoBotPlugin;
import org.mangorage.mangobotcore.api.plugin.v1.Plugin;

@MangoBotPlugin(id = MangoBotMixinPlugin.ID)
public final class MangoBotMixinPlugin implements Plugin {
    public static final String ID = "mangobotmixin";

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void load() {
        System.out.println("Loaded MangoBotMixinPlugin");
    }
}
