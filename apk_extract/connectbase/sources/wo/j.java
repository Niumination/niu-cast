package wo;

import el.b0;
import eo.a1;
import jq.h0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements tp.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final mp.d f19794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final mp.d f19795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final rp.s<cp.e> f19796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final tp.f f19798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final p f19799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final String f19800h;

    public j(@os.l mp.d dVar, @os.m mp.d dVar2, @os.l yo.a.l lVar, @os.l ap.c cVar, @os.m rp.s<cp.e> sVar, boolean z10, @os.l tp.f fVar, @os.m p pVar) {
        l0.p(dVar, cb.b.C0062b.f1395b);
        l0.p(lVar, "packageProto");
        l0.p(cVar, "nameResolver");
        l0.p(fVar, "abiStability");
        this.f19794b = dVar;
        this.f19795c = dVar2;
        this.f19796d = sVar;
        this.f19797e = z10;
        this.f19798f = fVar;
        this.f19799g = pVar;
        fp.i.g<yo.a.l, Integer> gVar = bp.a.f1015m;
        l0.o(gVar, "packageModuleName");
        Integer num = (Integer) ap.e.a(lVar, gVar);
        this.f19800h = num == null ? "main" : cVar.c(num.intValue());
    }

    @Override // tp.g
    @os.l
    public String a() {
        return "Class '" + d().b().b() + '\'';
    }

    @Override // eo.z0
    @os.l
    public a1 b() {
        a1 a1Var = a1.f4590a;
        l0.o(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    @os.l
    public final dp.b d() {
        return new dp.b(this.f19794b.g(), g());
    }

    @os.m
    public final mp.d e() {
        return this.f19795c;
    }

    @os.m
    public final p f() {
        return this.f19799g;
    }

    @os.l
    public final dp.f g() {
        String strF = this.f19794b.f();
        l0.o(strF, "className.internalName");
        dp.f fVarK = dp.f.k(h0.q5(strF, b0.f4502a, null, 2, null));
        l0.o(fVarK, "identifier(className.int….substringAfterLast('/'))");
        return fVarK;
    }

    @os.l
    public String toString() {
        return ((Object) j.class.getSimpleName()) + ": " + this.f19794b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public j(@os.l p pVar, @os.l yo.a.l lVar, @os.l ap.c cVar, @os.m rp.s<cp.e> sVar, boolean z10, @os.l tp.f fVar) {
        l0.p(pVar, "kotlinClass");
        l0.p(lVar, "packageProto");
        l0.p(cVar, "nameResolver");
        l0.p(fVar, "abiStability");
        mp.d dVarB = mp.d.b(pVar.f());
        l0.o(dVarB, "byClassId(kotlinClass.classId)");
        String strE = pVar.b().e();
        mp.d dVarD = null;
        if (strE != null && strE.length() > 0) {
            dVarD = mp.d.d(strE);
        }
        this(dVarB, dVarD, lVar, cVar, sVar, z10, fVar, pVar);
    }
}
