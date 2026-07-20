package s2;

import java.io.File;
import java.util.Iterator;
import jq.h0;
import kn.l0;
import kn.r1;
import os.l;
import r2.j;
import r2.k;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/transsion/airtransfer/filetransfer/common/FileUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n1855#2,2:62\n*S KotlinDebug\n*F\n+ 1 FileUtils.kt\ncom/transsion/airtransfer/filetransfer/common/FileUtilsKt\n*L\n58#1:62,2\n*E\n"})
public final class c {
    public static final void a(@l File file) {
        l0.p(file, "<this>");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @l
    public static final String b(@l String str) {
        l0.p(str, "<this>");
        File parentFile = new File(q2.a.f13797a.a(), str).getParentFile();
        if (parentFile != null) {
            a(parentFile);
        }
        return e(str);
    }

    public static final void c(@l j jVar) {
        l0.p(jVar, "<this>");
        jVar.k(b(jVar.f14177b));
    }

    public static final void d(@l k kVar) {
        l0.p(kVar, "<this>");
        Iterator<T> it = kVar.f14189c.iterator();
        while (it.hasNext()) {
            c((j) it.next());
        }
    }

    @l
    public static final String e(@l String str) {
        String strZ5;
        String strR5;
        l0.p(str, "<this>");
        String str2 = ".";
        if (h0.T2(str, ".", false, 2, null)) {
            strZ5 = h0.z5(str, ".", null, 2, null);
            strR5 = h0.r5(str, ".", null, 2, null);
        } else {
            str2 = "";
            strZ5 = str;
            strR5 = "";
        }
        String strA = q2.a.f13797a.a();
        File file = new File(strA, str);
        int i10 = 1;
        while (file.exists()) {
            str = strZ5 + '(' + i10 + ')' + str2 + strR5;
            file = new File(strA, str);
            i10++;
        }
        return str;
    }
}
