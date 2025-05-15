import org.mangorage.mangobotmixin.mixin.core.MangoBotMixinBlackboardImpl;
import org.mangorage.mangobotmixin.mixin.transformer.SpongeMixinClassTransformerImpl;

module org.mangorage.mangobotmixin {
    requires org.mangorage.mangobotcore;
    requires org.spongepowered.mixin;
    requires org.mangorage.bootstrap;
    requires org.jetbrains.annotations;
    requires mixinextras.common;

    exports org.mangorage.mangobotmixin.plugin to org.mangorage.mangobotcore;
    exports org.mangorage.mangobotmixin.mixin.core to org.spongepowered.mixin, mixinextras.common;
    exports org.mangorage.mangobotmixin.mixin to org.spongepowered.mixin, mixinextras.common;
    exports org.mangorage.mangobotmixin.mixin.transformer to org.spongepowered.mixin, mixinextras.common;


    provides org.mangorage.bootstrap.api.transformer.IClassTransformer with SpongeMixinClassTransformerImpl;
    provides org.spongepowered.asm.service.IGlobalPropertyService with MangoBotMixinBlackboardImpl;
    provides org.mangorage.mangobotcore.plugin.api.Plugin with org.mangorage.mangobotmixin.plugin.MangoBotMixinPlugin;
    provides org.mangorage.mangobotcore.plugin.api.IPluginInfoGetter with org.mangorage.mangobotmixin.mixin.MetadataInfoGrabberImpl;

    uses org.mangorage.bootstrap.api.transformer.IClassTransformer;
    uses org.spongepowered.asm.service.IGlobalPropertyService;
    uses org.mangorage.mangobotcore.plugin.api.Plugin;
}