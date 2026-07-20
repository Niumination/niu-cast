package fl;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 {
    public static final File a(File file, File file2) {
        File fileG = g(file2);
        if (dn.q.m0(fileG, "..")) {
            throw new IllegalArgumentException(kn.l0.C("Bad relative path ", file2));
        }
        if (fileG.isAbsolute()) {
            throw new IllegalStateException(kn.l0.C("Bad relative path ", file2).toString());
        }
        return new File(file, fileG.getPath());
    }

    @os.l
    public static final File b(@os.l File file, @os.l String str) {
        kn.l0.p(file, "<this>");
        kn.l0.p(str, "relativePath");
        return a(file, new File(str));
    }

    public static final int c(@os.l String str) {
        kn.l0.p(str, "path");
        int length = str.length() - 1;
        int i10 = 0;
        while (i10 <= length) {
            char cCharAt = str.charAt(i10);
            if (e(cCharAt)) {
                i10++;
            } else {
                if (cCharAt != '.') {
                    return i10;
                }
                if (i10 == length) {
                    return i10 + 1;
                }
                char cCharAt2 = str.charAt(i10 + 1);
                if (e(cCharAt2)) {
                    i10 += 2;
                } else {
                    if (cCharAt2 != '.') {
                        return i10;
                    }
                    int i11 = i10 + 2;
                    if (i11 == str.length()) {
                        i10 = i11;
                    } else {
                        if (!e(str.charAt(i11))) {
                            return i10;
                        }
                        i10 += 3;
                    }
                }
            }
        }
        return i10;
    }

    public static final File d(File file) {
        String path = file.getPath();
        if (path == null) {
            path = "";
        }
        int iC = c(path);
        if (iC == 0) {
            return file;
        }
        if (iC >= file.getPath().length()) {
            return new File(".");
        }
        String path2 = file.getPath();
        kn.l0.o(path2, "path");
        String strSubstring = path2.substring(iC);
        kn.l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return new File(strSubstring);
    }

    public static final boolean e(char c10) {
        return c10 == '\\' || c10 == '/';
    }

    public static final boolean f(char c10) {
        return c10 == '.' || e(c10);
    }

    @os.l
    public static final File g(@os.l File file) {
        kn.l0.p(file, "<this>");
        return d(h(dn.q.b0(file)));
    }

    public static final File h(File file) {
        String strSubstring;
        if (!dn.n.d(file)) {
            return file;
        }
        File file2 = file;
        while (true) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                break;
            }
            file2 = parentFile;
        }
        String path = file.getPath();
        kn.l0.o(path, "path");
        String strY6 = jq.j0.y6(path, file2.getName().length());
        int length = strY6.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = strY6.charAt(i10);
            if (cCharAt != '\\' && cCharAt != '/') {
                strSubstring = strY6.substring(i10);
                kn.l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                return new File(strSubstring);
            }
            i10 = i11;
        }
        strSubstring = "";
        return new File(strSubstring);
    }
}
