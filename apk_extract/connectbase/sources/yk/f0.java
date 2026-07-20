package yk;

import java.io.File;
import java.io.IOException;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {
    @os.l
    public static final String a() throws IOException {
        String canonicalPath = new File(".").getCanonicalPath();
        l0.o(canonicalPath, "File(\".\").canonicalPath");
        return canonicalPath;
    }
}
