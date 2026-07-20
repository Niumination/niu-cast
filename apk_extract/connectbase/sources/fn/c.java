package fn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
@f
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c f6120a = new c();

    @Override // fn.a
    @os.l
    public b a(@os.l Path path, @os.l Path path2, boolean z10) {
        l0.p(path, "<this>");
        l0.p(path2, TypedValues.AttributesType.S_TARGET);
        LinkOption[] linkOptionArrA = j.f6137a.a(z10);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(linkOptionArrA, linkOptionArrA.length);
            l0.o(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
        }
        return b.CONTINUE;
    }
}
