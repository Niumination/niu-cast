package r2;

import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f14195d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14196e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14197f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public jn.a<l2> f14200c;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public o() {
        this(0, 0L, 3, null);
    }

    @os.m
    public final jn.a<l2> a() {
        return this.f14200c;
    }

    public long b() {
        return this.f14199b;
    }

    public int c() {
        return this.f14198a;
    }

    public final void d(@os.l jn.a<l2> aVar) {
        l0.p(aVar, "callback");
        this.f14200c = aVar;
    }

    public final void e(@os.m jn.a<l2> aVar) {
        this.f14200c = aVar;
    }

    public void f(long j10) {
        this.f14199b = j10;
    }

    public void g(int i10) {
        this.f14198a = i10;
    }

    public o(int i10, long j10) {
        this.f14198a = i10;
        this.f14199b = j10;
    }

    public /* synthetic */ o(int i10, long j10, int i11, kn.w wVar) {
        this((i11 & 1) != 0 ? 1 : i10, (i11 & 2) != 0 ? 0L : j10);
    }
}
