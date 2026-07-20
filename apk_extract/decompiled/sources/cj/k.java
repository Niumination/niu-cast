package cj;

import ag.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public class k implements bj.d, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1719d;
    public final String[] e;
    public final List[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean[] f1720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f1721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f1722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f1723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f1724k;

    public k(String serialName, f fVar, int i8) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.f1716a = serialName;
        this.f1717b = fVar;
        this.f1718c = i8;
        this.f1719d = -1;
        String[] strArr = new String[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            strArr[i9] = "[UNINITIALIZED]";
        }
        this.e = strArr;
        int i10 = this.f1718c;
        this.f = new List[i10];
        this.f1720g = new boolean[i10];
        this.f1721h = MapsKt.emptyMap();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        final int i11 = 0;
        this.f1722i = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: cj.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f1715b;

            {
                this.f1715b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k kVar = this.f1715b;
                switch (i11) {
                    case 0:
                        if (kVar.f1717b == null) {
                            return i.f1713b;
                        }
                        aj.a[] aVarArr = ch.d.f1688l;
                        aj.a aVar = aVarArr[3];
                        aj.a aVar2 = aVarArr[6];
                        g gVar = g.f1708a;
                        return new aj.a[]{gVar, gVar, gVar, aVar, gVar, gVar, aVar2, gVar, h.f1710a};
                    case 1:
                        return i.b(kVar.f1717b != null ? new ArrayList(0) : null);
                    default:
                        return Integer.valueOf(i.c(kVar, (bj.d[]) kVar.f1723j.getValue()));
                }
            }
        });
        final int i12 = 1;
        this.f1723j = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: cj.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f1715b;

            {
                this.f1715b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k kVar = this.f1715b;
                switch (i12) {
                    case 0:
                        if (kVar.f1717b == null) {
                            return i.f1713b;
                        }
                        aj.a[] aVarArr = ch.d.f1688l;
                        aj.a aVar = aVarArr[3];
                        aj.a aVar2 = aVarArr[6];
                        g gVar = g.f1708a;
                        return new aj.a[]{gVar, gVar, gVar, aVar, gVar, gVar, aVar2, gVar, h.f1710a};
                    case 1:
                        return i.b(kVar.f1717b != null ? new ArrayList(0) : null);
                    default:
                        return Integer.valueOf(i.c(kVar, (bj.d[]) kVar.f1723j.getValue()));
                }
            }
        });
        final int i13 = 2;
        this.f1724k = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: cj.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f1715b;

            {
                this.f1715b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k kVar = this.f1715b;
                switch (i13) {
                    case 0:
                        if (kVar.f1717b == null) {
                            return i.f1713b;
                        }
                        aj.a[] aVarArr = ch.d.f1688l;
                        aj.a aVar = aVarArr[3];
                        aj.a aVar2 = aVarArr[6];
                        g gVar = g.f1708a;
                        return new aj.a[]{gVar, gVar, gVar, aVar, gVar, gVar, aVar2, gVar, h.f1710a};
                    case 1:
                        return i.b(kVar.f1717b != null ? new ArrayList(0) : null);
                    default:
                        return Integer.valueOf(i.c(kVar, (bj.d[]) kVar.f1723j.getValue()));
                }
            }
        });
    }

    @Override // cj.a
    public final Set a() {
        return this.f1721h.keySet();
    }

    @Override // bj.d
    public final int b() {
        return this.f1718c;
    }

    @Override // bj.d
    public final String c(int i8) {
        return this.e[i8];
    }

    @Override // bj.d
    public bj.d d(int i8) {
        return ((aj.a[]) this.f1722i.getValue())[i8].getDescriptor();
    }

    @Override // bj.d
    public final String e() {
        return this.f1716a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            bj.d dVar = (bj.d) obj;
            if (Intrinsics.areEqual(this.f1716a, dVar.e()) && Arrays.equals((bj.d[]) this.f1723j.getValue(), (bj.d[]) ((k) obj).f1723j.getValue())) {
                int iB = dVar.b();
                int i8 = this.f1718c;
                if (i8 == iB) {
                    for (int i9 = 0; i9 < i8; i9++) {
                        if (Intrinsics.areEqual(d(i9).e(), dVar.d(i9).e()) && Intrinsics.areEqual(d(i9).getKind(), dVar.d(i9).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void f(String name, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i8 = this.f1719d + 1;
        this.f1719d = i8;
        String[] strArr = this.e;
        strArr[i8] = name;
        this.f1720g[i8] = z2;
        this.f[i8] = null;
        if (i8 == this.f1718c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i9 = 0; i9 < length; i9++) {
                map.put(strArr[i9], Integer.valueOf(i9));
            }
            this.f1721h = map;
        }
    }

    @Override // bj.d
    public e1 getKind() {
        return bj.i.f1352b;
    }

    public int hashCode() {
        return ((Number) this.f1724k.getValue()).intValue();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(RangesKt.until(0, this.f1718c), ", ", this.f1716a.concat("("), ")", 0, null, new d0(this, 4), 24, null);
    }
}
