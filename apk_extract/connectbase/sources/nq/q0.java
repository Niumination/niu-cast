package nq;

/* JADX INFO: loaded from: classes3.dex */
@is.a
@lm.z0
public final class q0 extends um.a implements n3<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f11900b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11901a;

    public static final class a implements um.g.c<q0> {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public q0(long j10) {
        super(f11900b);
        this.f11901a = j10;
    }

    public static q0 p0(q0 q0Var, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = q0Var.f11901a;
        }
        q0Var.getClass();
        return new q0(j10);
    }

    @Override // nq.n3
    @os.l
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public String u0(@os.l um.g gVar) {
        String str;
        r0 r0Var = (r0) gVar.get(r0.f11910b);
        if (r0Var == null || (str = r0Var.f11911a) == null) {
            str = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iD3 = jq.h0.D3(name, m0.f11885a, 0, false, 6, null);
        if (iD3 < 0) {
            iD3 = name.length();
        }
        StringBuilder sb2 = new StringBuilder(str.length() + iD3 + 10);
        String strSubstring = name.substring(0, iD3);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb2.append(strSubstring);
        sb2.append(m0.f11885a);
        sb2.append(str);
        sb2.append('#');
        sb2.append(this.f11901a);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q0) && this.f11901a == ((q0) obj).f11901a;
    }

    public final long f0() {
        return this.f11901a;
    }

    public int hashCode() {
        return Long.hashCode(this.f11901a);
    }

    @os.l
    public final q0 j0(long j10) {
        return new q0(j10);
    }

    @os.l
    public String toString() {
        return n2.k0.a(new StringBuilder("CoroutineId("), this.f11901a, ')');
    }

    public final long v0() {
        return this.f11901a;
    }

    @Override // nq.n3
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void D1(@os.l um.g gVar, @os.l String str) {
        Thread.currentThread().setName(str);
    }
}
