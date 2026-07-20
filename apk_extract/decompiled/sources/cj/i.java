package cj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import k3.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bj.d[] f1712a = new bj.d[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aj.a[] f1713b = new aj.a[0];

    public static final Set a(bj.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar instanceof a) {
            return ((a) dVar).a();
        }
        HashSet hashSet = new HashSet(dVar.b());
        int iB = dVar.b();
        for (int i8 = 0; i8 < iB; i8++) {
            hashSet.add(dVar.c(i8));
        }
        return hashSet;
    }

    public static final bj.d[] b(List list) {
        bj.d[] dVarArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (dVarArr = (bj.d[]) list.toArray(new bj.d[0])) == null) ? f1712a : dVarArr;
    }

    public static final int c(bj.d dVar, bj.d[] typeParams) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int iHashCode = (dVar.e().hashCode() * 31) + Arrays.hashCode(typeParams);
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        int iB = dVar.b();
        int i8 = 1;
        while (true) {
            int iHashCode2 = 0;
            if (!(iB > 0)) {
                break;
            }
            int i9 = iB - 1;
            int i10 = i8 * 31;
            String strE = dVar.d(dVar.b() - iB).e();
            if (strE != null) {
                iHashCode2 = strE.hashCode();
            }
            i8 = i10 + iHashCode2;
            iB = i9;
        }
        int iB2 = dVar.b();
        int iHashCode3 = 1;
        while (true) {
            if (!(iB2 > 0)) {
                return (((iHashCode * 31) + i8) * 31) + iHashCode3;
            }
            int i11 = iB2 - 1;
            int i12 = iHashCode3 * 31;
            e1 kind = dVar.d(dVar.b() - iB2).getKind();
            iHashCode3 = i12 + (kind != null ? kind.hashCode() : 0);
            iB2 = i11;
        }
    }
}
