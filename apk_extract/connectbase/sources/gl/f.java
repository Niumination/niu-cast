package gl;

import java.io.File;
import java.nio.file.Path;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    @os.l
    public static final pl.k a(@os.l Path path) {
        l0.p(path, "<this>");
        File file = path.toFile();
        l0.o(file, "toFile()");
        return g.b(file, 0L, 0L, null, 7, null);
    }

    @os.l
    public static final pl.k b(@os.l Path path, long j10, long j11) {
        l0.p(path, "<this>");
        File file = path.toFile();
        l0.o(file, "toFile()");
        return g.b(file, j10, j11, null, 4, null);
    }
}
