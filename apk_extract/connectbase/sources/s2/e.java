package s2;

import android.net.Uri;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import jq.r;
import kn.l0;
import kn.r1;
import nm.h0;
import nm.k0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nUrlUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UrlUtils.kt\ncom/transsion/airtransfer/filetransfer/common/UrlUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Uri.kt\nandroidx/core/net/UriKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,62:1\n288#2:63\n289#2:65\n288#2:66\n289#2:68\n731#2,9:69\n29#3:64\n29#3:67\n37#4,2:78\n*S KotlinDebug\n*F\n+ 1 UrlUtils.kt\ncom/transsion/airtransfer/filetransfer/common/UrlUtilsKt\n*L\n19#1:63\n19#1:65\n28#1:66\n28#1:68\n46#1:69,9\n20#1:64\n29#1:67\n47#1:78,2\n*E\n"})
public final class e {
    public static final boolean a(@l String str) {
        Collection collectionJ5;
        l0.p(str, "<this>");
        if (str.length() < 7 || str.length() > 15) {
            return false;
        }
        List<String> listSplit = new r("\\.").split(str, 0);
        if (listSplit.isEmpty()) {
            collectionJ5 = k0.INSTANCE;
            break;
        }
        ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                collectionJ5 = k0.INSTANCE;
                break;
            }
            if (listIterator.previous().length() != 0) {
                collectionJ5 = h0.J5(listSplit, listIterator.nextIndex() + 1);
                break;
            }
        }
        String[] strArr = (String[]) collectionJ5.toArray(new String[0]);
        if (strArr.length != 4) {
            return false;
        }
        for (String str2 : strArr) {
            try {
                int i10 = Integer.parseInt(str2);
                if (i10 < 0 || i10 > 255) {
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    @l
    public static final String b(@m String str, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder("socket://");
        sb2.append(str == null ? "" : str);
        sb2.append(n1.e.f11184d);
        sb2.append(i10);
        sb2.append(";grpc://");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append(n1.e.f11184d);
        sb2.append(i11);
        return sb2.toString();
    }

    public static /* synthetic */ String c(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = t2.a.f15438e;
        }
        if ((i12 & 2) != 0) {
            i11 = t2.a.f15439f;
        }
        return b(str, i10, i11);
    }

    @l
    public static final String d(@m String str) {
        if (str != null) {
            Object obj = null;
            if (jq.h0.T2(str, ";", false, 2, null)) {
                for (Object obj2 : jq.h0.R4(str, new String[]{";"}, false, 0, 6, null)) {
                    Uri uri = Uri.parse((String) obj2);
                    l0.o(uri, "parse(this)");
                    if (l0.g(uri.getScheme(), t2.a.f15435b)) {
                        obj = obj2;
                        break;
                    }
                }
                String str2 = (String) obj;
                return str2 == null ? "unknown://" : str2;
            }
        }
        StringBuilder sb2 = new StringBuilder("grpc://");
        if (str == null) {
            str = "";
        }
        return j.c.a(sb2, str, ":50331");
    }

    @l
    public static final String e(@m String str) {
        if (str != null) {
            Object obj = null;
            if (jq.h0.T2(str, ";", false, 2, null)) {
                for (Object obj2 : jq.h0.R4(str, new String[]{";"}, false, 0, 6, null)) {
                    Uri uri = Uri.parse((String) obj2);
                    l0.o(uri, "parse(this)");
                    if (l0.g(uri.getScheme(), t2.a.f15434a)) {
                        obj = obj2;
                        break;
                    }
                }
                String str2 = (String) obj;
                return str2 == null ? "unknown://" : str2;
            }
        }
        StringBuilder sb2 = new StringBuilder("socket://");
        if (str == null) {
            str = "";
        }
        return j.c.a(sb2, str, ":50231");
    }
}
