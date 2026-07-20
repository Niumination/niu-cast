package bj;

import ag.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements d, cj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f1343d;
    public final String[] e;
    public final d[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List[] f1344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f1345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d[] f1346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f1347j;

    public e(String serialName, int i8, List typeParameters, a builder) {
        i kind = i.f1353c;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f1340a = serialName;
        this.f1341b = i8;
        this.f1342c = builder.f1334a;
        ArrayList arrayList = builder.f1335b;
        this.f1343d = CollectionsKt___CollectionsKt.toHashSet(arrayList);
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.e = strArr;
        this.f = cj.i.b(builder.f1336c);
        this.f1344g = (List[]) builder.f1337d.toArray(new List[0]);
        CollectionsKt___CollectionsKt.toBooleanArray(builder.e);
        Iterable<IndexedValue> iterableWithIndex = ArraysKt.withIndex(strArr);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(iterableWithIndex));
        for (IndexedValue indexedValue : iterableWithIndex) {
            arrayList2.add(TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        this.f1345h = MapsKt.toMap(arrayList2);
        this.f1346i = cj.i.b(typeParameters);
        this.f1347j = LazyKt.lazy(new ag.a(this, 1));
    }

    @Override // cj.a
    public final Set a() {
        return this.f1343d;
    }

    @Override // bj.d
    public final int b() {
        return this.f1341b;
    }

    @Override // bj.d
    public final String c(int i8) {
        return this.e[i8];
    }

    @Override // bj.d
    public final d d(int i8) {
        return this.f[i8];
    }

    @Override // bj.d
    public final String e() {
        return this.f1340a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            d dVar = (d) obj;
            if (Intrinsics.areEqual(this.f1340a, dVar.e()) && Arrays.equals(this.f1346i, ((e) obj).f1346i)) {
                int iB = dVar.b();
                int i8 = this.f1341b;
                if (i8 == iB) {
                    for (int i9 = 0; i9 < i8; i9++) {
                        d[] dVarArr = this.f;
                        if (Intrinsics.areEqual(dVarArr[i9].e(), dVar.d(i9).e()) && Intrinsics.areEqual(dVarArr[i9].getKind(), dVar.d(i9).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // bj.d
    public final e1 getKind() {
        return i.f1353c;
    }

    public final int hashCode() {
        return ((Number) this.f1347j.getValue()).intValue();
    }

    public final String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(RangesKt.until(0, this.f1341b), ", ", this.f1340a.concat("("), ")", 0, null, new d0(this, 2), 24, null);
    }
}
