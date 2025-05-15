package net.pixeldreamstudios.valor_core.mixin;

import java.net.URI;
import net.minecraft.util.CommonLinks;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CommonLinks.class)
public class CommonLinksMixin {
    @Shadow
    @Final
    @Mutable
    public static URI SNAPSHOT_BUGS_FEEDBACK;

    @Shadow
    @Final
    @Mutable
    public static URI RELEASE_FEEDBACK;


    @Redirect(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/CommonLinks;SNAPSHOT_BUGS_FEEDBACK:Ljava/net/URI;", opcode = Opcodes.PUTSTATIC))
    private static void newSnapshotBugsFeedback(URI uri) {
        SNAPSHOT_BUGS_FEEDBACK = URI.create("https://legacy.curseforge.com/minecraft/modpacks/valor-rpg/issues");
    }

    @Redirect(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/CommonLinks;RELEASE_FEEDBACK:Ljava/net/URI;", opcode = Opcodes.PUTSTATIC))
    private static void newaReleaseFeedback(URI uri) {
        RELEASE_FEEDBACK = URI.create("https://discord.pixeldreamstudios.net");
    }
}
