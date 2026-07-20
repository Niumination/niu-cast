package eo;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final l1 f4610a = new l1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Map<m1, Integer> f4611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final h f4612c;

    public static final class a extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final a f4613c = new a();

        public a() {
            super("inherited", false);
        }
    }

    public static final class b extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final b f4614c = new b();

        public b() {
            super("internal", false);
        }
    }

    public static final class c extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final c f4615c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    public static final class d extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final d f4616c = new d();

        public d() {
            super("local", false);
        }
    }

    public static final class e extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final e f4617c = new e();

        public e() {
            super("private", false);
        }
    }

    public static final class f extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final f f4618c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // eo.m1
        @os.l
        public String b() {
            return "private/*private to this*/";
        }
    }

    public static final class g extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final g f4619c = new g();

        public g() {
            super("protected", true);
        }
    }

    public static final class h extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final h f4620c = new h();

        public h() {
            super("public", true);
        }
    }

    public static final class i extends m1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final i f4621c = new i();

        public i() {
            super("unknown", false);
        }
    }

    static {
        om.d dVar = new om.d();
        dVar.put(f.f4618c, 0);
        dVar.put(e.f4617c, 0);
        dVar.put(b.f4614c, 1);
        dVar.put(g.f4619c, 1);
        h hVar = h.f4620c;
        dVar.put(hVar, 2);
        f4611b = nm.c1.d(dVar);
        f4612c = hVar;
    }

    @os.m
    public final Integer a(@os.l m1 m1Var, @os.l m1 m1Var2) {
        kn.l0.p(m1Var, "first");
        kn.l0.p(m1Var2, y1.o.r.f20674f);
        if (m1Var == m1Var2) {
            return 0;
        }
        Map<m1, Integer> map = f4611b;
        Integer num = map.get(m1Var);
        Integer num2 = map.get(m1Var2);
        if (num == null || num2 == null || kn.l0.g(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(@os.l m1 m1Var) {
        kn.l0.p(m1Var, "visibility");
        return m1Var == e.f4617c || m1Var == f.f4618c;
    }
}
