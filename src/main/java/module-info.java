module org.mangorage.mangobotmixin {
    requires org.mangorage.mangobotcore;
    requires org.spongepowered.mixin;
    requires org.mangorage.bootstrap;
    requires org.jetbrains.annotations;

    exports org.mangorage.mangobotmixin.plugin to org.mangorage.mangobotcore;
    exports org.mangorage.mangobotmixin.mixin.core to org.spongepowered.mixin;


    provides org.mangorage.bootstrap.api.transformer.IClassTransformer with org.mangorage.mangobotmixin.mixin.SpongeMixinTransformer;
    provides org.spongepowered.asm.service.IGlobalPropertyService with org.mangorage.mangobotmixin.mixin.core.MixinBlackboardImpl;
    provides org.mangorage.mangobotcore.plugin.api.Plugin with org.mangorage.mangobotmixin.plugin.MangoBotMixinPlugin;

    uses org.mangorage.bootstrap.api.transformer.IClassTransformer;
    uses org.spongepowered.asm.service.IGlobalPropertyService;
    uses org.mangorage.mangobotcore.plugin.api.Plugin;
}