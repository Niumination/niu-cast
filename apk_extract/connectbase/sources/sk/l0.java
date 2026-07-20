package sk;

import lm.s1;

/* JADX INFO: loaded from: classes2.dex */
@in.g
public final class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f15134b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f15135c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f15136d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f15137e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f15138f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f15139g = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f15140a;

    public static final class a {
        public a() {
        }

        public final byte a() {
            return l0.f15136d;
        }

        public final byte b() {
            return l0.f15139g;
        }

        public final byte c() {
            return l0.f15137e;
        }

        public final byte d() {
            return l0.f15138f;
        }

        public final byte e() {
            return l0.f15135c;
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ l0(byte b10) {
        this.f15140a = b10;
    }

    public static final /* synthetic */ l0 f(byte b10) {
        return new l0(b10);
    }

    public static byte g(byte b10) {
        return b10;
    }

    public static byte h(int i10) {
        return s1.m((byte) i10);
    }

    public static boolean i(byte b10, Object obj) {
        return (obj instanceof l0) && b10 == ((l0) obj).f15140a;
    }

    public static final boolean j(byte b10, byte b11) {
        return b10 == b11;
    }

    public static final int k(byte b10) {
        return b10 & 255;
    }

    public static int m(byte b10) {
        return s1.z(b10);
    }

    public static String n(byte b10) {
        return "TypeOfService(value=" + ((Object) s1.f0(b10)) + ')';
    }

    public boolean equals(Object obj) {
        return i(this.f15140a, obj);
    }

    public int hashCode() {
        return s1.z(this.f15140a);
    }

    public final byte l() {
        return this.f15140a;
    }

    public final /* synthetic */ byte o() {
        return this.f15140a;
    }

    public String toString() {
        return n(this.f15140a);
    }
}
