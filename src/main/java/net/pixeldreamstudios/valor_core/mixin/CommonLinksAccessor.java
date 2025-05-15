package net.pixeldreamstudios.valor_core.mixin;

import java.net.URI;
import net.minecraft.util.CommonLinks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CommonLinks.class)
public interface CommonLinksAccessor {
    @Accessor("SNAPSHOT_BUGS_FEEDBACK")
    static void setLink(URI uri) {
        throw new AssertionError();
    }
}
