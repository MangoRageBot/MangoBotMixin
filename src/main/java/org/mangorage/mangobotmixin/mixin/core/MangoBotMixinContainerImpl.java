package org.mangorage.mangobotmixin.mixin.core;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.launch.platform.container.ContainerHandleURI;
import org.spongepowered.asm.launch.platform.container.ContainerHandleVirtual;

import java.nio.file.Path;
import java.util.Map;

public final class MangoBotMixinContainerImpl extends ContainerHandleVirtual {
    /**
     * Creates a new root container handle.
     *
     * @param name the name
     * @since 1.0.0
     */
    public MangoBotMixinContainerImpl(final @NotNull String name) {
        super(name);
    }

    /**
     * Adds a resource to this container.
     *
     * @param name the name
     * @param path the path
     * @since 1.0.0
     */
    public void addResource(final @NotNull String name, final @NotNull Path path) {
        this.add(new ResourceContainer(name, path));
    }

    /**
     * Adds a resource to this container.
     *
     * @param entry the entry
     * @since 1.0.0
     */
    public void addResource(final Map.@NotNull Entry<String, Path> entry) {
        this.add(new ResourceContainer(entry.getKey(), entry.getValue()));
    }

    @Override
    public String toString() {
        return "MixinContainer{name=" + this.getName() + "}";
    }

   static class ResourceContainer extends ContainerHandleURI {
        private final String name;
        private final Path path;

        ResourceContainer(final @NotNull String name, final @NotNull Path path) {
            super(path.toUri());

            this.name = name;
            this.path = path;
        }

        public @NotNull String name() {
            return this.name;
        }

        public @NotNull Path path() {
            return this.path;
        }

        @Override
        public @NotNull String toString() {
            return "ResourceContainer{name=" + this.name + ", path=" + this.path + "}";
        }
    }
}
