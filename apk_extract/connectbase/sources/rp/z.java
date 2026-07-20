package rp;

import eo.z0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ap.c f14779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ap.g f14780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final z0 f14781c;

    public static final class a extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final yo.a.c f14782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.m
        public final a f14783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final dp.b f14784f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final yo.a.c.EnumC0567c f14785g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f14786h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l yo.a.c cVar, @os.l ap.c cVar2, @os.l ap.g gVar, @os.m z0 z0Var, @os.m a aVar) {
            super(cVar2, gVar, z0Var);
            l0.p(cVar, "classProto");
            l0.p(cVar2, "nameResolver");
            l0.p(gVar, "typeTable");
            this.f14782d = cVar;
            this.f14783e = aVar;
            this.f14784f = x.a(cVar2, cVar.getFqName());
            yo.a.c.EnumC0567c enumC0567cD = ap.b.f644f.d(cVar.getFlags());
            this.f14785g = enumC0567cD == null ? yo.a.c.EnumC0567c.CLASS : enumC0567cD;
            Boolean boolD = ap.b.f645g.d(cVar.getFlags());
            l0.o(boolD, "IS_INNER.get(classProto.flags)");
            this.f14786h = boolD.booleanValue();
        }

        @Override // rp.z
        @os.l
        public dp.c a() {
            dp.c cVarB = this.f14784f.b();
            l0.o(cVarB, "classId.asSingleFqName()");
            return cVarB;
        }

        @os.l
        public final dp.b e() {
            return this.f14784f;
        }

        @os.l
        public final yo.a.c f() {
            return this.f14782d;
        }

        @os.l
        public final yo.a.c.EnumC0567c g() {
            return this.f14785g;
        }

        @os.m
        public final a h() {
            return this.f14783e;
        }

        public final boolean i() {
            return this.f14786h;
        }
    }

    public static final class b extends z {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final dp.c f14787d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l dp.c cVar, @os.l ap.c cVar2, @os.l ap.g gVar, @os.m z0 z0Var) {
            super(cVar2, gVar, z0Var);
            l0.p(cVar, "fqName");
            l0.p(cVar2, "nameResolver");
            l0.p(gVar, "typeTable");
            this.f14787d = cVar;
        }

        @Override // rp.z
        @os.l
        public dp.c a() {
            return this.f14787d;
        }
    }

    public /* synthetic */ z(ap.c cVar, ap.g gVar, z0 z0Var, kn.w wVar) {
        this(cVar, gVar, z0Var);
    }

    @os.l
    public abstract dp.c a();

    @os.l
    public final ap.c b() {
        return this.f14779a;
    }

    @os.m
    public final z0 c() {
        return this.f14781c;
    }

    @os.l
    public final ap.g d() {
        return this.f14780b;
    }

    @os.l
    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }

    public z(ap.c cVar, ap.g gVar, z0 z0Var) {
        this.f14779a = cVar;
        this.f14780b = gVar;
        this.f14781c = z0Var;
    }
}
