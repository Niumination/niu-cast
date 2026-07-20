package wo;

import eo.h0;
import eo.h1;
import eo.j0;
import eo.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends wo.a<fo.c, jp.g<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final h0 f19752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final j0 f19753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final rp.e f19754e;

    public static final class a implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final HashMap<dp.f, jp.g<?>> f19755a = new HashMap<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ eo.e f19757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ dp.b f19758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List<fo.c> f19759e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ z0 f19760f;

        /* JADX INFO: renamed from: wo.b$a$a, reason: collision with other inner class name */
        public static final class C0488a implements p.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p.a f19761a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p.a f19762b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f19763c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ dp.f f19764d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ArrayList<fo.c> f19765e;

            public C0488a(p.a aVar, a aVar2, dp.f fVar, ArrayList<fo.c> arrayList) {
                this.f19762b = aVar;
                this.f19763c = aVar2;
                this.f19764d = fVar;
                this.f19765e = arrayList;
                this.f19761a = aVar;
            }

            @Override // wo.p.a
            public void a() {
                this.f19762b.a();
                this.f19763c.f19755a.put(this.f19764d, new jp.a((fo.c) nm.h0.h5(this.f19765e)));
            }

            @Override // wo.p.a
            public void b(@os.l dp.f fVar, @os.l dp.b bVar, @os.l dp.f fVar2) {
                l0.p(fVar, "name");
                l0.p(bVar, "enumClassId");
                l0.p(fVar2, "enumEntryName");
                this.f19761a.b(fVar, bVar, fVar2);
            }

            @Override // wo.p.a
            public void c(@os.m dp.f fVar, @os.m Object obj) {
                this.f19761a.c(fVar, obj);
            }

            @Override // wo.p.a
            @os.m
            public p.b d(@os.l dp.f fVar) {
                l0.p(fVar, "name");
                return this.f19761a.d(fVar);
            }

            @Override // wo.p.a
            @os.m
            public p.a e(@os.l dp.f fVar, @os.l dp.b bVar) {
                l0.p(fVar, "name");
                l0.p(bVar, "classId");
                return this.f19761a.e(fVar, bVar);
            }

            @Override // wo.p.a
            public void f(@os.l dp.f fVar, @os.l jp.f fVar2) {
                l0.p(fVar, "name");
                l0.p(fVar2, "value");
                this.f19761a.f(fVar, fVar2);
            }
        }

        /* JADX INFO: renamed from: wo.b$a$b, reason: collision with other inner class name */
        public static final class C0489b implements p.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final ArrayList<jp.g<?>> f19766a = new ArrayList<>();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ dp.f f19768c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b f19769d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ eo.e f19770e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ dp.b f19771f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ List<fo.c> f19772g;

            /* JADX INFO: renamed from: wo.b$a$b$a, reason: collision with other inner class name */
            public static final class C0490a implements p.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ p.a f19773a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ p.a f19774b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ C0489b f19775c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ArrayList<fo.c> f19776d;

                public C0490a(p.a aVar, C0489b c0489b, ArrayList<fo.c> arrayList) {
                    this.f19774b = aVar;
                    this.f19775c = c0489b;
                    this.f19776d = arrayList;
                    this.f19773a = aVar;
                }

                @Override // wo.p.a
                public void a() {
                    this.f19774b.a();
                    this.f19775c.f19766a.add(new jp.a((fo.c) nm.h0.h5(this.f19776d)));
                }

                @Override // wo.p.a
                public void b(@os.l dp.f fVar, @os.l dp.b bVar, @os.l dp.f fVar2) {
                    l0.p(fVar, "name");
                    l0.p(bVar, "enumClassId");
                    l0.p(fVar2, "enumEntryName");
                    this.f19773a.b(fVar, bVar, fVar2);
                }

                @Override // wo.p.a
                public void c(@os.m dp.f fVar, @os.m Object obj) {
                    this.f19773a.c(fVar, obj);
                }

                @Override // wo.p.a
                @os.m
                public p.b d(@os.l dp.f fVar) {
                    l0.p(fVar, "name");
                    return this.f19773a.d(fVar);
                }

                @Override // wo.p.a
                @os.m
                public p.a e(@os.l dp.f fVar, @os.l dp.b bVar) {
                    l0.p(fVar, "name");
                    l0.p(bVar, "classId");
                    return this.f19773a.e(fVar, bVar);
                }

                @Override // wo.p.a
                public void f(@os.l dp.f fVar, @os.l jp.f fVar2) {
                    l0.p(fVar, "name");
                    l0.p(fVar2, "value");
                    this.f19773a.f(fVar, fVar2);
                }
            }

            public C0489b(dp.f fVar, b bVar, eo.e eVar, dp.b bVar2, List<fo.c> list) {
                this.f19768c = fVar;
                this.f19769d = bVar;
                this.f19770e = eVar;
                this.f19771f = bVar2;
                this.f19772g = list;
            }

            @Override // wo.p.b
            public void a() {
                h1 h1VarB = oo.a.b(this.f19768c, this.f19770e);
                if (h1VarB != null) {
                    HashMap<dp.f, jp.g<?>> map = a.this.f19755a;
                    dp.f fVar = this.f19768c;
                    jp.h hVar = jp.h.f8775a;
                    List<? extends jp.g<?>> listC = eq.a.c(this.f19766a);
                    f0 type = h1VarB.getType();
                    l0.o(type, "parameter.type");
                    map.put(fVar, hVar.b(listC, type));
                    return;
                }
                if (this.f19769d.w(this.f19771f) && l0.g(this.f19768c.b(), "value")) {
                    ArrayList<jp.g<?>> arrayList = this.f19766a;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (obj instanceof jp.a) {
                            arrayList2.add(obj);
                        }
                    }
                    List<fo.c> list = this.f19772g;
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        list.add((fo.c) ((jp.a) it.next()).f8774a);
                    }
                }
            }

            @Override // wo.p.b
            public void b(@os.l dp.b bVar, @os.l dp.f fVar) {
                l0.p(bVar, "enumClassId");
                l0.p(fVar, "enumEntryName");
                this.f19766a.add(new jp.j(bVar, fVar));
            }

            @Override // wo.p.b
            public void c(@os.l jp.f fVar) {
                l0.p(fVar, "value");
                this.f19766a.add(new jp.q(fVar));
            }

            @Override // wo.p.b
            @os.m
            public p.a d(@os.l dp.b bVar) {
                l0.p(bVar, "classId");
                ArrayList arrayList = new ArrayList();
                b bVar2 = this.f19769d;
                z0 z0Var = z0.f4654a;
                l0.o(z0Var, "NO_SOURCE");
                p.a aVarY = bVar2.y(bVar, z0Var, arrayList);
                l0.m(aVarY);
                return new C0490a(aVarY, this, arrayList);
            }

            @Override // wo.p.b
            public void e(@os.m Object obj) {
                this.f19766a.add(a.this.i(this.f19768c, obj));
            }
        }

        public a(eo.e eVar, dp.b bVar, List<fo.c> list, z0 z0Var) {
            this.f19757c = eVar;
            this.f19758d = bVar;
            this.f19759e = list;
            this.f19760f = z0Var;
        }

        @Override // wo.p.a
        public void a() {
            if (b.this.x(this.f19758d, this.f19755a) || b.this.w(this.f19758d)) {
                return;
            }
            this.f19759e.add(new fo.d(this.f19757c.q(), this.f19755a, this.f19760f));
        }

        @Override // wo.p.a
        public void b(@os.l dp.f fVar, @os.l dp.b bVar, @os.l dp.f fVar2) {
            l0.p(fVar, "name");
            l0.p(bVar, "enumClassId");
            l0.p(fVar2, "enumEntryName");
            this.f19755a.put(fVar, new jp.j(bVar, fVar2));
        }

        @Override // wo.p.a
        public void c(@os.m dp.f fVar, @os.m Object obj) {
            if (fVar != null) {
                this.f19755a.put(fVar, i(fVar, obj));
            }
        }

        @Override // wo.p.a
        @os.m
        public p.b d(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return new C0489b(fVar, b.this, this.f19757c, this.f19758d, this.f19759e);
        }

        @Override // wo.p.a
        @os.m
        public p.a e(@os.l dp.f fVar, @os.l dp.b bVar) {
            l0.p(fVar, "name");
            l0.p(bVar, "classId");
            ArrayList arrayList = new ArrayList();
            b bVar2 = b.this;
            z0 z0Var = z0.f4654a;
            l0.o(z0Var, "NO_SOURCE");
            p.a aVarY = bVar2.y(bVar, z0Var, arrayList);
            l0.m(aVarY);
            return new C0488a(aVarY, this, fVar, arrayList);
        }

        @Override // wo.p.a
        public void f(@os.l dp.f fVar, @os.l jp.f fVar2) {
            l0.p(fVar, "name");
            l0.p(fVar2, "value");
            this.f19755a.put(fVar, new jp.q(fVar2));
        }

        public final jp.g<?> i(dp.f fVar, Object obj) {
            jp.g<?> gVarC = jp.h.f8775a.c(obj);
            return gVarC == null ? jp.k.f8778b.a(l0.C("Unsupported annotation argument: ", fVar)) : gVarC;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@os.l h0 h0Var, @os.l j0 j0Var, @os.l up.n nVar, @os.l n nVar2) {
        super(nVar, nVar2);
        l0.p(h0Var, "module");
        l0.p(j0Var, "notFoundClasses");
        l0.p(nVar, "storageManager");
        l0.p(nVar2, "kotlinClassFinder");
        this.f19752c = h0Var;
        this.f19753d = j0Var;
        this.f19754e = new rp.e(h0Var, j0Var);
    }

    @Override // wo.a
    @os.m
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public jp.g<?> B(@os.l String str, @os.l Object obj) {
        l0.p(str, "desc");
        l0.p(obj, "initializer");
        if (jq.h0.T2("ZBCS", str, false, 2, null)) {
            int iIntValue = ((Integer) obj).intValue();
            int iHashCode = str.hashCode();
            if (iHashCode == 66) {
                if (str.equals("B")) {
                    obj = Byte.valueOf((byte) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 67) {
                if (str.equals("C")) {
                    obj = Character.valueOf((char) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 83) {
                if (str.equals("S")) {
                    obj = Short.valueOf((short) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 90 && str.equals("Z")) {
                obj = Boolean.valueOf(iIntValue != 0);
            }
            throw new AssertionError(str);
        }
        return jp.h.f8775a.c(obj);
    }

    @Override // wo.a
    @os.l
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public fo.c D(@os.l yo.a.b bVar, @os.l ap.c cVar) {
        l0.p(bVar, "proto");
        l0.p(cVar, "nameResolver");
        return this.f19754e.a(bVar, cVar);
    }

    public final eo.e I(dp.b bVar) {
        return eo.x.c(this.f19752c, bVar, this.f19753d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wo.a
    @os.m
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public jp.g<?> F(@os.l jp.g<?> gVar) {
        jp.g<?> yVar;
        l0.p(gVar, "constant");
        if (gVar instanceof jp.d) {
            yVar = new jp.w(((Number) ((jp.d) gVar).f8774a).byteValue());
        } else if (gVar instanceof jp.u) {
            yVar = new jp.z(((Number) ((jp.u) gVar).f8774a).shortValue());
        } else if (gVar instanceof jp.m) {
            yVar = new jp.x(((Number) ((jp.m) gVar).f8774a).intValue());
        } else {
            if (!(gVar instanceof jp.r)) {
                return gVar;
            }
            yVar = new jp.y(((Number) ((jp.r) gVar).f8774a).longValue());
        }
        return yVar;
    }

    @Override // wo.a
    @os.m
    public p.a y(@os.l dp.b bVar, @os.l z0 z0Var, @os.l List<fo.c> list) {
        l0.p(bVar, "annotationClassId");
        l0.p(z0Var, "source");
        l0.p(list, "result");
        return new a(I(bVar), bVar, list, z0Var);
    }
}
