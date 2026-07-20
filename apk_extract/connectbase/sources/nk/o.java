package nk;

import fl.b1;
import fl.f1;
import java.io.File;
import java.nio.file.Path;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    @os.l
    public static final n a(@os.l File file, @os.l String str, @os.l ik.i iVar) {
        l0.p(file, "baseDir");
        l0.p(str, "relativePath");
        l0.p(iVar, "contentType");
        return new n(f1.b(file, str), iVar);
    }

    @os.l
    public static final n b(@os.l Path path, @os.l Path path2, @os.l ik.i iVar) {
        l0.p(path, "baseDir");
        l0.p(path2, "relativePath");
        l0.p(iVar, "contentType");
        return new n(b1.b(path, path2), iVar);
    }

    public static /* synthetic */ n c(File file, String str, ik.i iVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            iVar = ik.w.b(ik.i.f7981f, str);
        }
        return a(file, str, iVar);
    }

    public static /* synthetic */ n d(Path path, Path path2, ik.i iVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            iVar = ik.u.b(ik.i.f7981f, path2);
        }
        return b(path, path2, iVar);
    }
}
