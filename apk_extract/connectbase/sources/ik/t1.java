package ik;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class t1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f8189c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final t1 f8190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final t1 f8191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final t1 f8192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final t1 f8193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final t1 f8194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final Map<String, t1> f8195i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8197b;

    public static final class a {
        public a() {
        }

        @os.l
        public final t1 a(@os.l String str) {
            kn.l0.p(str, "name");
            String strE = fl.t1.e(str);
            t1.f8189c.getClass();
            t1 t1Var = (t1) t1.f8195i.get(strE);
            return t1Var == null ? new t1(strE, 0) : t1Var;
        }

        @os.l
        public final Map<String, t1> b() {
            return t1.f8195i;
        }

        @os.l
        public final t1 c() {
            return t1.f8190d;
        }

        @os.l
        public final t1 d() {
            return t1.f8191e;
        }

        @os.l
        public final t1 e() {
            return t1.f8194h;
        }

        @os.l
        public final t1 f() {
            return t1.f8192f;
        }

        @os.l
        public final t1 g() {
            return t1.f8193g;
        }

        public a(kn.w wVar) {
        }
    }

    static {
        t1 t1Var = new t1("http", 80);
        f8190d = t1Var;
        t1 t1Var2 = new t1(h2.f18719h, wj.v0.f19368n);
        f8191e = t1Var2;
        t1 t1Var3 = new t1("ws", 80);
        f8192f = t1Var3;
        t1 t1Var4 = new t1("wss", wj.v0.f19368n);
        f8193g = t1Var4;
        t1 t1Var5 = new t1("socks", 1080);
        f8194h = t1Var5;
        List listO = nm.y.O(t1Var, t1Var2, t1Var3, t1Var4, t1Var5);
        int iJ = nm.c1.j(nm.z.b0(listO, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (Object obj : listO) {
            linkedHashMap.put(((t1) obj).f8196a, obj);
        }
        f8195i = linkedHashMap;
    }

    public t1(@os.l String str, int i10) {
        kn.l0.p(str, "name");
        this.f8196a = str;
        this.f8197b = i10;
        int i11 = 0;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            i11++;
            if (!fl.r.a(cCharAt)) {
                throw new IllegalArgumentException("All characters should be lower case");
            }
        }
    }

    public static /* synthetic */ t1 j(t1 t1Var, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = t1Var.f8196a;
        }
        if ((i11 & 2) != 0) {
            i10 = t1Var.f8197b;
        }
        return t1Var.i(str, i10);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return kn.l0.g(this.f8196a, t1Var.f8196a) && this.f8197b == t1Var.f8197b;
    }

    @os.l
    public final String g() {
        return this.f8196a;
    }

    public final int h() {
        return this.f8197b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f8197b) + (this.f8196a.hashCode() * 31);
    }

    @os.l
    public final t1 i(@os.l String str, int i10) {
        kn.l0.p(str, "name");
        return new t1(str, i10);
    }

    public final int k() {
        return this.f8197b;
    }

    @os.l
    public final String l() {
        return this.f8196a;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("URLProtocol(name=");
        sb2.append(this.f8196a);
        sb2.append(", defaultPort=");
        return u.a.a(sb2, this.f8197b, ')');
    }
}
