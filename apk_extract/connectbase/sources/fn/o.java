package fn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final boolean c(l lVar) {
        Object obj;
        for (l lVar2 = lVar.f6146c; lVar2 != null; lVar2 = lVar2.f6146c) {
            Object obj2 = lVar2.f6145b;
            if (obj2 == null || (obj = lVar.f6145b) == null) {
                try {
                    if (Files.isSameFile(lVar2.f6144a, lVar.f6144a)) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (l0.g(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            l0.o(attributes, "readAttributes(...)");
            return attributes.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
