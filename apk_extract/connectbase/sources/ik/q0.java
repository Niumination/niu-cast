package ik;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f8146d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final q0 f8147e = new q0("HTTP", 2, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final q0 f8148f = new q0("HTTP", 1, 1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final q0 f8149g = new q0("HTTP", 1, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final q0 f8150h = new q0("SPDY", 3, 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final q0 f8151i = new q0("QUIC", 1, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8154c;

    public static final class a {
        public a() {
        }

        @os.l
        public final q0 a(@os.l String str, int i10, int i11) {
            kn.l0.p(str, "name");
            if (kn.l0.g(str, "HTTP") && i10 == 1 && i11 == 1) {
                return q0.f8148f;
            }
            return (kn.l0.g(str, "HTTP") && i10 == 2 && i11 == 0) ? q0.f8147e : new q0(str, i10, i11);
        }

        @os.l
        public final q0 b() {
            return q0.f8149g;
        }

        @os.l
        public final q0 c() {
            return q0.f8148f;
        }

        @os.l
        public final q0 d() {
            return q0.f8147e;
        }

        @os.l
        public final q0 e() {
            return q0.f8151i;
        }

        @os.l
        public final q0 f() {
            return q0.f8150h;
        }

        @os.l
        public final q0 g(@os.l CharSequence charSequence) {
            kn.l0.p(charSequence, "value");
            List listR4 = jq.h0.R4(charSequence, new String[]{"/", "."}, false, 0, 6, null);
            if (listR4.size() != 3) {
                throw new IllegalStateException(kn.l0.C("Failed to parse HttpProtocolVersion. Expected format: protocol/major.minor, but actual: ", charSequence).toString());
            }
            return a((String) listR4.get(0), Integer.parseInt((String) listR4.get(1)), Integer.parseInt((String) listR4.get(2)));
        }

        public a(kn.w wVar) {
        }
    }

    public q0(@os.l String str, int i10, int i11) {
        kn.l0.p(str, "name");
        this.f8152a = str;
        this.f8153b = i10;
        this.f8154c = i11;
    }

    public static /* synthetic */ q0 j(q0 q0Var, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = q0Var.f8152a;
        }
        if ((i12 & 2) != 0) {
            i10 = q0Var.f8153b;
        }
        if ((i12 & 4) != 0) {
            i11 = q0Var.f8154c;
        }
        return q0Var.i(str, i10, i11);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return kn.l0.g(this.f8152a, q0Var.f8152a) && this.f8153b == q0Var.f8153b && this.f8154c == q0Var.f8154c;
    }

    @os.l
    public final String f() {
        return this.f8152a;
    }

    public final int g() {
        return this.f8153b;
    }

    public final int h() {
        return this.f8154c;
    }

    public int hashCode() {
        return Integer.hashCode(this.f8154c) + k0.d.a(this.f8153b, this.f8152a.hashCode() * 31, 31);
    }

    @os.l
    public final q0 i(@os.l String str, int i10, int i11) {
        kn.l0.p(str, "name");
        return new q0(str, i10, i11);
    }

    public final int k() {
        return this.f8153b;
    }

    public final int l() {
        return this.f8154c;
    }

    @os.l
    public final String m() {
        return this.f8152a;
    }

    @os.l
    public String toString() {
        return this.f8152a + el.b0.f4502a + this.f8153b + n1.e.f11183c + this.f8154c;
    }
}
