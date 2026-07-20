package rp;

import eo.k0;
import eo.z0;
import java.util.Iterator;
import java.util.Set;
import kn.l0;
import kn.n0;
import nm.n1;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final b f14718c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Set<dp.b> f14719d = n1.f(dp.b.m(ao.k.a.f577d.l()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j f14720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<a, eo.e> f14721b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final dp.b f14722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final f f14723b;

        public a(@os.l dp.b bVar, @os.m f fVar) {
            l0.p(bVar, "classId");
            this.f14722a = bVar;
            this.f14723b = fVar;
        }

        @os.m
        public final f a() {
            return this.f14723b;
        }

        @os.l
        public final dp.b b() {
            return this.f14722a;
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof a) && l0.g(this.f14722a, ((a) obj).f14722a);
        }

        public int hashCode() {
            return this.f14722a.hashCode();
        }
    }

    public static final class b {
        public b() {
        }

        @os.l
        public final Set<dp.b> a() {
            return h.f14719d;
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends n0 implements jn.l<a, eo.e> {
        public c() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final eo.e invoke(@os.l a aVar) {
            l0.p(aVar, cb.b.c.f1408o);
            return h.this.c(aVar);
        }
    }

    public h(@os.l j jVar) {
        l0.p(jVar, "components");
        this.f14720a = jVar;
        this.f14721b = jVar.f14727a.f(new c());
    }

    public static /* synthetic */ eo.e e(h hVar, dp.b bVar, f fVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            fVar = null;
        }
        return hVar.d(bVar, fVar);
    }

    public final eo.e c(a aVar) {
        Object next;
        l lVarA;
        k0 k0Var;
        dp.f fVarJ;
        dp.b bVar = aVar.f14722a;
        Iterator<go.b> it = this.f14720a.f14737k.iterator();
        while (it.hasNext()) {
            eo.e eVarB = it.next().b(bVar);
            if (eVarB != null) {
                return eVarB;
            }
        }
        if (f14719d.contains(bVar)) {
            return null;
        }
        f fVarA = aVar.f14723b;
        if (fVarA == null && (fVarA = this.f14720a.f14730d.a(bVar)) == null) {
            return null;
        }
        ap.c cVar = fVarA.f14714a;
        yo.a.c cVar2 = fVarA.f14715b;
        ap.a aVar2 = fVarA.f14716c;
        z0 z0Var = fVarA.f14717d;
        dp.b bVarG = bVar.g();
        if (bVarG != null) {
            eo.e eVarE = e(this, bVarG, null, 2, null);
            tp.e eVar = eVarE instanceof tp.e ? (tp.e) eVarE : null;
            if (eVar == null) {
                return null;
            }
            dp.f fVarJ2 = bVar.j();
            l0.o(fVarJ2, "classId.shortClassName");
            if (!eVar.Y0(fVarJ2)) {
                return null;
            }
            lVarA = eVar.f15963y;
        } else {
            eo.l0 l0Var = this.f14720a.f14732f;
            dp.c cVarH = bVar.h();
            l0.o(cVarH, "classId.packageFqName");
            Iterator<T> it2 = eo.n0.c(l0Var, cVarH).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                k0Var = (k0) next;
                if (!(k0Var instanceof o)) {
                    break;
                }
                fVarJ = bVar.j();
                l0.o(fVarJ, "classId.shortClassName");
            } while (!((o) k0Var).E0(fVarJ));
            k0 k0Var2 = (k0) next;
            if (k0Var2 == null) {
                return null;
            }
            j jVar = this.f14720a;
            yo.a.t typeTable = cVar2.getTypeTable();
            l0.o(typeTable, "classProto.typeTable");
            ap.g gVar = new ap.g(typeTable);
            ap.h.a aVar3 = ap.h.f672b;
            yo.a.w versionRequirementTable = cVar2.getVersionRequirementTable();
            l0.o(versionRequirementTable, "classProto.versionRequirementTable");
            lVarA = jVar.a(k0Var2, cVar, gVar, aVar3.a(versionRequirementTable), aVar2, null);
        }
        return new tp.e(lVarA, cVar2, cVar, aVar2, z0Var);
    }

    @os.m
    public final eo.e d(@os.l dp.b bVar, @os.m f fVar) {
        l0.p(bVar, "classId");
        return this.f14721b.invoke(new a(bVar, fVar));
    }
}
