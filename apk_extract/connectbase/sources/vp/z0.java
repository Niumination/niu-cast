package vp;

import java.util.ArrayDeque;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final yp.r f17778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final i f17779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final j f17780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public ArrayDeque<yp.k> f17783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public Set<yp.k> f17784j;

    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    public static abstract class b {

        public static abstract class a extends b {
        }

        /* JADX INFO: renamed from: vp.z0$b$b, reason: collision with other inner class name */
        public static final class C0464b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public static final C0464b f17786a = new C0464b();

            @Override // vp.z0.b
            @os.l
            public yp.k a(@os.l z0 z0Var, @os.l yp.i iVar) {
                kn.l0.p(z0Var, "state");
                kn.l0.p(iVar, ik.y0.a.f8215h);
                return z0Var.f17778d.u0(iVar);
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public static final c f17787a = new c();

            @Override // vp.z0.b
            public /* bridge */ /* synthetic */ yp.k a(z0 z0Var, yp.i iVar) {
                return (yp.k) b(z0Var, iVar);
            }

            @os.l
            public Void b(@os.l z0 z0Var, @os.l yp.i iVar) {
                kn.l0.p(z0Var, "state");
                kn.l0.p(iVar, ik.y0.a.f8215h);
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        public static final class d extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public static final d f17788a = new d();

            @Override // vp.z0.b
            @os.l
            public yp.k a(@os.l z0 z0Var, @os.l yp.i iVar) {
                kn.l0.p(z0Var, "state");
                kn.l0.p(iVar, ik.y0.a.f8215h);
                return z0Var.f17778d.G(iVar);
            }
        }

        public b() {
        }

        @os.l
        public abstract yp.k a(@os.l z0 z0Var, @os.l yp.i iVar);

        public b(kn.w wVar) {
        }
    }

    public z0(boolean z10, boolean z11, boolean z12, @os.l yp.r rVar, @os.l i iVar, @os.l j jVar) {
        kn.l0.p(rVar, "typeSystemContext");
        kn.l0.p(iVar, "kotlinTypePreparator");
        kn.l0.p(jVar, "kotlinTypeRefiner");
        this.f17775a = z10;
        this.f17776b = z11;
        this.f17777c = z12;
        this.f17778d = rVar;
        this.f17779e = iVar;
        this.f17780f = jVar;
    }

    public static /* synthetic */ Boolean d(z0 z0Var, yp.i iVar, yp.i iVar2, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return z0Var.c(iVar, iVar2, z10);
    }

    @os.m
    public Boolean c(@os.l yp.i iVar, @os.l yp.i iVar2, boolean z10) {
        kn.l0.p(iVar, "subType");
        kn.l0.p(iVar2, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<yp.k> arrayDeque = this.f17783i;
        kn.l0.m(arrayDeque);
        arrayDeque.clear();
        Set<yp.k> set = this.f17784j;
        kn.l0.m(set);
        set.clear();
        this.f17782h = false;
    }

    public boolean f(@os.l yp.i iVar, @os.l yp.i iVar2) {
        kn.l0.p(iVar, "subType");
        kn.l0.p(iVar2, "superType");
        return true;
    }

    @os.l
    public a g(@os.l yp.k kVar, @os.l yp.d dVar) {
        kn.l0.p(kVar, "subType");
        kn.l0.p(dVar, "superType");
        return a.CHECK_SUBTYPE_AND_LOWER;
    }

    @os.m
    public final ArrayDeque<yp.k> h() {
        return this.f17783i;
    }

    @os.m
    public final Set<yp.k> i() {
        return this.f17784j;
    }

    @os.l
    public final yp.r j() {
        return this.f17778d;
    }

    public final void k() {
        this.f17782h = true;
        if (this.f17783i == null) {
            this.f17783i = new ArrayDeque<>(4);
        }
        if (this.f17784j == null) {
            this.f17784j = eq.f.f4674c.a();
        }
    }

    public final boolean l(@os.l yp.i iVar) {
        kn.l0.p(iVar, ik.y0.a.f8215h);
        return this.f17777c && this.f17778d.E(iVar);
    }

    public final boolean m() {
        return this.f17775a;
    }

    public final boolean n() {
        return this.f17776b;
    }

    @os.l
    public final yp.i o(@os.l yp.i iVar) {
        kn.l0.p(iVar, ik.y0.a.f8215h);
        return this.f17779e.a(iVar);
    }

    @os.l
    public final yp.i p(@os.l yp.i iVar) {
        kn.l0.p(iVar, ik.y0.a.f8215h);
        return this.f17780f.a(iVar);
    }
}
