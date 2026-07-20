package ao;

import eo.k0;
import ik.y0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kn.l0;
import lm.t0;
import nm.d1;
import nm.h0;
import vp.f0;
import vp.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final o f626a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Set<dp.f> f627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Set<dp.f> f628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final HashMap<dp.b, dp.b> f629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final HashMap<dp.b, dp.b> f630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final HashMap<m, dp.f> f631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final Set<dp.f> f632g;

    static {
        n[] nVarArrValues = n.values();
        ArrayList arrayList = new ArrayList(nVarArrValues.length);
        int length = nVarArrValues.length;
        int i10 = 0;
        int i11 = 0;
        while (i11 < length) {
            n nVar = nVarArrValues[i11];
            i11++;
            arrayList.add(nVar.getTypeName());
        }
        f627b = h0.a6(arrayList);
        m[] mVarArrValues = m.values();
        ArrayList arrayList2 = new ArrayList(mVarArrValues.length);
        int length2 = mVarArrValues.length;
        int i12 = 0;
        while (i12 < length2) {
            m mVar = mVarArrValues[i12];
            i12++;
            arrayList2.add(mVar.getTypeName());
        }
        f628c = h0.a6(arrayList2);
        f629d = new HashMap<>();
        f630e = new HashMap<>();
        f631f = d1.M(new t0(m.UBYTEARRAY, dp.f.k("ubyteArrayOf")), new t0(m.USHORTARRAY, dp.f.k("ushortArrayOf")), new t0(m.UINTARRAY, dp.f.k("uintArrayOf")), new t0(m.ULONGARRAY, dp.f.k("ulongArrayOf")));
        n[] nVarArrValues2 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length3 = nVarArrValues2.length;
        int i13 = 0;
        while (i13 < length3) {
            n nVar2 = nVarArrValues2[i13];
            i13++;
            linkedHashSet.add(nVar2.getArrayClassId().j());
        }
        f632g = linkedHashSet;
        n[] nVarArrValues3 = n.values();
        int length4 = nVarArrValues3.length;
        while (i10 < length4) {
            n nVar3 = nVarArrValues3[i10];
            i10++;
            f629d.put(nVar3.getArrayClassId(), nVar3.getClassId());
            f630e.put(nVar3.getClassId(), nVar3.getArrayClassId());
        }
    }

    @in.n
    public static final boolean d(@os.l f0 f0Var) {
        eo.h hVarD;
        l0.p(f0Var, y0.a.f8215h);
        if (j1.w(f0Var) || (hVarD = f0Var.G0().d()) == null) {
            return false;
        }
        return f626a.c(hVarD);
    }

    @os.m
    public final dp.b a(@os.l dp.b bVar) {
        l0.p(bVar, "arrayClassId");
        return f629d.get(bVar);
    }

    public final boolean b(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return f632g.contains(fVar);
    }

    public final boolean c(@os.l eo.m mVar) {
        l0.p(mVar, "descriptor");
        eo.m mVarB = mVar.b();
        return (mVarB instanceof k0) && l0.g(((k0) mVarB).e(), k.f565m) && f627b.contains(mVar.getName());
    }
}
