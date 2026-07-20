package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends um.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f11910b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f11911a;

    public static final class a implements um.g.c<r0> {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public r0(@os.l String str) {
        super(f11910b);
        this.f11911a = str;
    }

    public static r0 p0(r0 r0Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = r0Var.f11911a;
        }
        r0Var.getClass();
        return new r0(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r0) && kn.l0.g(this.f11911a, ((r0) obj).f11911a);
    }

    @os.l
    public final String f0() {
        return this.f11911a;
    }

    public int hashCode() {
        return this.f11911a.hashCode();
    }

    @os.l
    public final r0 j0(@os.l String str) {
        return new r0(str);
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("CoroutineName("), this.f11911a, ')');
    }

    @os.l
    public final String v0() {
        return this.f11911a;
    }
}
