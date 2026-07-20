package dn;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jq.h0;
import kn.l0;
import kn.r1;
import nm.k0;
import nm.z;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1549#2:149\n1620#2,3:150\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n133#1:149\n133#1:150,3\n*E\n"})
public class n {
    @os.l
    public static final File a(@os.l File file) {
        l0.p(file, "<this>");
        return new File(c(file));
    }

    public static final int b(String str) {
        int iO3;
        char c10 = File.separatorChar;
        int iO4 = h0.o3(str, c10, 0, false, 4, null);
        if (iO4 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c10 || (iO3 = h0.o3(str, c10, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iO5 = h0.o3(str, c10, iO3 + 1, false, 4, null);
            return iO5 >= 0 ? iO5 + 1 : str.length();
        }
        if (iO4 > 0 && str.charAt(iO4 - 1) == ':') {
            return iO4 + 1;
        }
        if (iO4 == -1 && h0.Y2(str, n1.e.f11184d, false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    @os.l
    public static final String c(@os.l File file) {
        l0.p(file, "<this>");
        String path = file.getPath();
        l0.o(path, "getPath(...)");
        String path2 = file.getPath();
        l0.o(path2, "getPath(...)");
        String strSubstring = path.substring(0, b(path2));
        l0.o(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean d(@os.l File file) {
        l0.p(file, "<this>");
        String path = file.getPath();
        l0.o(path, "getPath(...)");
        return b(path) > 0;
    }

    @os.l
    public static final File e(@os.l File file, int i10, int i11) {
        l0.p(file, "<this>");
        return f(file).j(i10, i11);
    }

    @os.l
    public static final i f(@os.l File file) {
        List list;
        l0.p(file, "<this>");
        String path = file.getPath();
        l0.m(path);
        int iB = b(path);
        String strSubstring = path.substring(0, iB);
        l0.o(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iB);
        l0.o(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            list = k0.INSTANCE;
        } else {
            List listQ4 = h0.Q4(strSubstring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(z.b0(listQ4, 10));
            Iterator it = listQ4.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new i(new File(strSubstring), list);
    }
}
