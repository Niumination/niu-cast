package ro;

import eo.z0;
import ho.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import lm.t0;
import nm.d1;
import nm.k0;
import un.o;
import uo.u;
import wo.p;
import wo.q;
import wo.v;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends z {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f14634y;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final u f14635g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final qo.h f14636i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final up.i f14637n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final d f14638p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final up.i<List<dp.c>> f14639v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final fo.g f14640w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final up.i f14641x;

    public static final class a extends n0 implements jn.a<Map<String, ? extends p>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Map<String, ? extends p> invoke() {
            v vVar = h.this.f14636i.f14088a.f14066l;
            String strB = h.this.f7473e.b();
            l0.o(strB, "fqName.asString()");
            List<String> listA = vVar.a(strB);
            h hVar = h.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listA) {
                dp.b bVarM = dp.b.m(mp.d.d(str).e());
                l0.o(bVarM, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                p pVarA = wo.o.a(hVar.f14636i.f14088a.f14057c, bVarM);
                t0 t0Var = pVarA == null ? null : new t0(str, pVarA);
                if (t0Var != null) {
                    arrayList.add(t0Var);
                }
            }
            return d1.D0(arrayList);
        }
    }

    public static final class b extends n0 implements jn.a<HashMap<mp.d, mp.d>> {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f14642a;

            static {
                int[] iArr = new int[xo.a.EnumC0527a.values().length];
                iArr[xo.a.EnumC0527a.MULTIFILE_CLASS_PART.ordinal()] = 1;
                iArr[xo.a.EnumC0527a.FILE_FACADE.ordinal()] = 2;
                f14642a = iArr;
            }
        }

        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final HashMap<mp.d, mp.d> invoke() {
            HashMap<mp.d, mp.d> map = new HashMap<>();
            for (Map.Entry<String, p> entry : h.this.G0().entrySet()) {
                String key = entry.getKey();
                p value = entry.getValue();
                mp.d dVarD = mp.d.d(key);
                l0.o(dVarD, "byInternalName(partInternalName)");
                xo.a aVarB = value.b();
                int i10 = a.f14642a[aVarB.f20438a.ordinal()];
                if (i10 == 1) {
                    String strE = aVarB.e();
                    if (strE != null) {
                        mp.d dVarD2 = mp.d.d(strE);
                        l0.o(dVarD2, "byInternalName(header.mu…: continue@kotlinClasses)");
                        map.put(dVarD, dVarD2);
                    }
                } else if (i10 == 2) {
                    map.put(dVarD, dVarD);
                }
            }
            return map;
        }
    }

    public static final class c extends n0 implements jn.a<List<? extends dp.c>> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends dp.c> invoke() {
            Collection<u> collectionV = h.this.f14635g.v();
            ArrayList arrayList = new ArrayList(nm.z.b0(collectionV, 10));
            Iterator<T> it = collectionV.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).e());
            }
            return arrayList;
        }
    }

    static {
        g1 g1Var = new g1(l1.d(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;");
        m1 m1Var = l1.f9319a;
        f14634y = new o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@os.l qo.h hVar, @os.l u uVar) {
        fo.g gVarA;
        super(hVar.f14088a.f14069o, uVar.e());
        l0.p(hVar, "outerContext");
        l0.p(uVar, "jPackage");
        this.f14635g = uVar;
        qo.h hVarD = qo.a.d(hVar, this, null, 0, 6, null);
        this.f14636i = hVarD;
        this.f14637n = hVarD.f14088a.f14055a.h(new a());
        this.f14638p = new d(hVarD, uVar, this);
        this.f14639v = hVarD.f14088a.f14055a.i(new c(), k0.INSTANCE);
        if (hVarD.f14088a.f14076v.f11789c) {
            fo.g.f6167h.getClass();
            gVarA = fo.g.a.f6169b;
        } else {
            gVarA = qo.f.a(hVarD, uVar);
        }
        this.f14640w = gVarA;
        this.f14641x = hVarD.f14088a.f14055a.h(new b());
    }

    @os.m
    public final eo.e F0(@os.l uo.g gVar) {
        l0.p(gVar, "jClass");
        return this.f14638p.f14608d.P(gVar);
    }

    @os.l
    public final Map<String, p> G0() {
        return (Map) up.m.a(this.f14637n, this, f14634y[0]);
    }

    @os.l
    public d H0() {
        return this.f14638p;
    }

    @os.l
    public final List<dp.c> I0() {
        return this.f14639v.invoke();
    }

    @Override // fo.b, fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.f14640w;
    }

    @Override // ho.z, ho.k, eo.p
    @os.l
    public z0 getSource() {
        return new q(this);
    }

    @Override // eo.k0
    public op.h o() {
        return this.f14638p;
    }

    @Override // ho.z, ho.j
    @os.l
    public String toString() {
        return "Lazy Java package fragment: " + this.f7473e + " of module " + this.f14636i.f14088a.f14069o;
    }
}
