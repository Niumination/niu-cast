package dn;

import java.io.File;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + file2);
        }
        if (str != null) {
            sb2.append(": ".concat(str));
        }
        String string = sb2.toString();
        l0.o(string, "toString(...)");
        return string;
    }
}
