package org.mangorage.mangobotmixin.plugin;


import org.mangorage.bootstrap.api.loader.IMangoLoader;
import org.mangorage.mangobotcore.api.plugin.v1.MangoBotPlugin;
import org.mangorage.mangobotcore.api.plugin.v1.Plugin;
import org.objectweb.asm.ClassReader;

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
        IMangoLoader mangoLoader = (IMangoLoader) this.getClass().getClassLoader();

        final var transformerHistory = mangoLoader.getTransformerHistory();
        if (transformerHistory != null) {
            final var history = transformerHistory.getHistory("org.mangorage.mangobotcore.internal.ExampleThing");
            if (history == null || history.size() == 1) return;

            final var result = history.get(1);
            System.out.println("Transformed class bytes:");
            ClassReader cr = new ClassReader(result.transformerResult());
            cr.accept(new org.objectweb.asm.util.TraceClassVisitor(new java.io.PrintWriter(System.out)), 0);

            System.out.println("Original class bytes:");
            ClassReader cr2 = new ClassReader(result.classData());
            cr2.accept(new org.objectweb.asm.util.TraceClassVisitor(new java.io.PrintWriter(System.out)), 0);
        }
    }
}
