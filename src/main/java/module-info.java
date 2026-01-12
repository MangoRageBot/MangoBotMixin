module org.mangorage.mangobotmixin {
    requires org.mangorage.mangobotcore;
    requires org.spongepowered.mixin;
    requires org.mangorage.bootstrap;
    requires org.jetbrains.annotations;
    requires mixinextras.common;

    exports org.mangorage.mangobotmixin.plugin to org.mangorage.mangobotcore;
    exports org.mangorage.mangobotmixin.mixin.core to org.spongepowered.mixin, mixinextras.common;
    exports org.mangorage.mangobotmixin.mixin to org.spongepowered.mixin, mixinextras.common;
    exports org.mangorage.mangobotmixin.mixin.services to mixinextras.common, org.spongepowered.mixin;
    exports org.mangorage.mangobotmixin.services to mixinextras.common, org.spongepowered.mixin, org.mangorage.bootstrap;


    // Bootstrap Services
    provides org.mangorage.bootstrap.api.module.IModuleConfigurator with org.mangorage.mangobotmixin.services.ModuleConfigService;
    provides org.mangorage.bootstrap.api.transformer.IClassTransformer with org.mangorage.mangobotmixin.services.SpongeMixinClassTransformerImpl;

    // MangoBot Services
    provides org.mangorage.mangobotcore.api.plugin.v1.Plugin with org.mangorage.mangobotmixin.plugin.MangoBotMixinPlugin;
    provides org.mangorage.mangobotcore.api.plugin.v1.IPluginInfoGetter with org.mangorage.mangobotmixin.services.MetadataInfoGrabberImpl;

    // Mixin Service
    provides org.spongepowered.asm.service.IGlobalPropertyService with org.mangorage.mangobotmixin.mixin.services.MangoBotMixinBlackboardImpl;


    // Bootstrap Services
    uses org.mangorage.bootstrap.api.transformer.IClassTransformer;
    uses org.mangorage.bootstrap.api.module.IModuleConfigurator;

    // MangoBot Services
    uses org.mangorage.mangobotcore.api.plugin.v1.Plugin;
    uses org.mangorage.mangobotcore.api.plugin.v1.IPluginInfoGetter;

    // Mixin Service
    uses org.spongepowered.asm.service.IGlobalPropertyService;
}