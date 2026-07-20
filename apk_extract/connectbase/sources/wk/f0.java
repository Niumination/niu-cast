package wk;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f19611b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final f0 f19612c = new f0(nm.k0.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<g0> f19613a;

    public static final class a {

        /* JADX INFO: renamed from: wk.f0$a$a, reason: collision with other inner class name */
        public static final class C0481a extends kn.n0 implements jn.l<String, Boolean> {
            public static final C0481a INSTANCE = new C0481a();

            public C0481a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l String str) {
                kn.l0.p(str, "it");
                return Boolean.valueOf(str.length() > 0);
            }
        }

        public static final class b extends kn.n0 implements jn.l<String, g0> {
            public static final b INSTANCE = new b();

            public b() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final g0 invoke(@os.l String str) {
                kn.l0.p(str, "segment");
                return (jq.h0.S2(str, rs.f.f14859a, false, 2, null) && jq.h0.S2(str, rs.f.f14860b, false, 2, null)) ? new g0(str, h0.Parameter) : new g0(ik.e.i(str, 0, 0, null, 7, null), h0.Constant);
            }
        }

        public a() {
        }

        @os.l
        public final f0 a() {
            return f0.f19612c;
        }

        @os.l
        public final f0 b(@os.l String str) {
            kn.l0.p(str, "path");
            return kn.l0.g(str, "/") ? f0.f19612c : new f0(gq.v.c3(gq.v.k1(gq.v.p0(jq.h0.X4(str, new String[]{"/"}, false, 0, 6, null), C0481a.INSTANCE), b.INSTANCE)));
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends kn.n0 implements jn.l<g0, CharSequence> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l g0 g0Var) {
            kn.l0.p(g0Var, "it");
            return g0Var.f19615a;
        }
    }

    public /* synthetic */ f0(List list, kn.w wVar) {
        this(list);
    }

    @os.l
    public final List<g0> b() {
        return this.f19613a;
    }

    @os.l
    public String toString() {
        return nm.h0.m3(this.f19613a, "/", null, null, 0, null, b.INSTANCE, 30, null);
    }

    public f0(List<g0> list) {
        this.f19613a = list;
    }
}
