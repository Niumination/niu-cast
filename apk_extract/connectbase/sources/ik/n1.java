package ik;

import androidx.core.app.FrameMetricsAggregator;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final a f8120j = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public t1 f8121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public String f8122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public String f8124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public String f8125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public String f8126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final c1 f8127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public String f8128h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8129i;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends kn.n0 implements jn.l<String, CharSequence> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l String str) {
            kn.l0.p(str, "it");
            return e.p(str);
        }
    }

    public n1() {
        this(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public final <A extends Appendable> A a(A a10) throws IOException {
        a10.append(this.f8121a.f8196a);
        String str = this.f8121a.f8196a;
        if (kn.l0.g(str, "file")) {
            p1.c(a10, this.f8122b, this.f8126f);
            return a10;
        }
        if (kn.l0.g(str, "mailto")) {
            p1.d(a10, p1.i(this), this.f8126f);
            return a10;
        }
        a10.append("://");
        a10.append(p1.g(this));
        w1.g(a10, this.f8126f, this.f8127g, this.f8129i);
        if (this.f8128h.length() > 0) {
            a10.append('#');
            a10.append(e.r(this.f8128h, false, false, null, 7, null));
        }
        return a10;
    }

    @os.l
    public final y1 b() {
        return new y1(this.f8121a, this.f8122b, this.f8123c, this.f8126f, this.f8127g.f(), this.f8128h, this.f8124d, this.f8125e, this.f8129i);
    }

    @os.l
    public final String c() {
        String string = ((StringBuilder) a(new StringBuilder(256))).toString();
        kn.l0.o(string, "appendTo(StringBuilder(256)).toString()");
        return string;
    }

    @os.l
    public final String d() {
        return this.f8126f;
    }

    @os.l
    public final String e() {
        return this.f8128h;
    }

    @os.l
    public final String f() {
        return this.f8122b;
    }

    @os.l
    public final c1 g() {
        return this.f8127g;
    }

    @os.m
    public final String h() {
        return this.f8125e;
    }

    public final int i() {
        return this.f8123c;
    }

    @os.l
    public final t1 j() {
        return this.f8121a;
    }

    public final boolean k() {
        return this.f8129i;
    }

    @os.m
    public final String l() {
        return this.f8124d;
    }

    @os.l
    public final n1 m(@os.l List<String> list) {
        kn.l0.p(list, "components");
        this.f8126f = nm.h0.m3(list, "/", "/", null, 0, null, b.INSTANCE, 28, null);
        return this;
    }

    @os.l
    public final n1 n(@os.l String... strArr) {
        kn.l0.p(strArr, "components");
        m(nm.p.t(strArr));
        return this;
    }

    public final void o(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f8126f = str;
    }

    public final void p(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f8128h = str;
    }

    public final void q(@os.l String str) {
        kn.l0.p(str, "<set-?>");
        this.f8122b = str;
    }

    public final void r(@os.m String str) {
        this.f8125e = str;
    }

    public final void s(int i10) {
        this.f8123c = i10;
    }

    public final void t(@os.l t1 t1Var) {
        kn.l0.p(t1Var, "<set-?>");
        this.f8121a = t1Var;
    }

    public final void u(boolean z10) {
        this.f8129i = z10;
    }

    public final void v(@os.m String str) {
        this.f8124d = str;
    }

    public n1(@os.l t1 t1Var, @os.l String str, int i10, @os.m String str2, @os.m String str3, @os.l String str4, @os.l c1 c1Var, @os.l String str5, boolean z10) {
        kn.l0.p(t1Var, "protocol");
        kn.l0.p(str, "host");
        kn.l0.p(str4, "encodedPath");
        kn.l0.p(c1Var, "parameters");
        kn.l0.p(str5, "fragment");
        this.f8121a = t1Var;
        this.f8122b = str;
        this.f8123c = i10;
        this.f8124d = str2;
        this.f8125e = str3;
        this.f8126f = str4;
        this.f8127g = c1Var;
        this.f8128h = str5;
        this.f8129i = z10;
        String strA = o1.a(f8120j);
        if (strA != null) {
            s1.j(this, strA);
        }
        if (this.f8126f.length() == 0) {
            this.f8126f = "/";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n1(t1 t1Var, String str, int i10, String str2, String str3, String str4, c1 c1Var, String str5, boolean z10, int i11, kn.w wVar) {
        t1 t1Var2;
        c1 c1Var2;
        if ((i11 & 1) != 0) {
            t1.f8189c.getClass();
            t1Var2 = t1.f8190d;
        } else {
            t1Var2 = t1Var;
        }
        String str6 = (i11 & 2) != 0 ? "localhost" : str;
        Object[] objArr = 0;
        int i12 = (i11 & 4) != 0 ? 0 : i10;
        z1 z1Var = null;
        Object[] objArr2 = 0;
        String str7 = (i11 & 8) != 0 ? null : str2;
        String str8 = (i11 & 16) != 0 ? null : str3;
        String str9 = (i11 & 32) != 0 ? "/" : str4;
        if ((i11 & 64) != 0) {
            c1Var2 = new c1(objArr == true ? 1 : 0, z1Var, 3, objArr2 == true ? 1 : 0);
        } else {
            c1Var2 = c1Var;
        }
        this(t1Var2, str6, i12, str7, str8, str9, c1Var2, (i11 & 128) != 0 ? "" : str5, (i11 & 256) == 0 ? z10 : false);
    }
}
