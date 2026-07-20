package vq;

import kn.r1;
import lm.l2;
import nq.n1;
import nq.x2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class h0 extends x2 implements nq.c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final Throwable f17849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final String f17850b;

    public h0(@os.m Throwable th2, @os.m String str) {
        this.f17849a = th2;
        this.f17850b = str;
    }

    @Override // nq.c1
    @os.l
    public n1 E(long j10, @os.l Runnable runnable, @os.l um.g gVar) {
        v0();
        throw new lm.y();
    }

    @Override // nq.x2
    @os.l
    public x2 f0() {
        return this;
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@os.l um.g gVar) {
        v0();
        throw new lm.y();
    }

    @Override // nq.x2, nq.n0
    @os.l
    public nq.n0 limitedParallelism(int i10) {
        v0();
        throw new lm.y();
    }

    @Override // nq.c1
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object n(long j10, @os.l um.d<? super l2> dVar) {
        return nq.c1.a.a(this, j10, dVar);
    }

    @Override // nq.n0
    @os.l
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public Void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        v0();
        throw new lm.y();
    }

    @Override // nq.x2, nq.n0
    @os.l
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dispatchers.Main[missing");
        if (this.f17849a != null) {
            str = ", cause=" + this.f17849a;
        } else {
            str = "";
        }
        return l.a.a(sb2, str, ']');
    }

    public final Void v0() {
        String strConcat;
        if (this.f17849a == null) {
            g0.e();
            throw new lm.y();
        }
        String str = this.f17850b;
        if (str == null || (strConcat = ". ".concat(str)) == null) {
            strConcat = "";
        }
        throw new IllegalStateException("Module with the Main dispatcher had failed to initialize".concat(strConcat), this.f17849a);
    }

    @Override // nq.c1
    @os.l
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public Void b0(long j10, @os.l nq.p<? super l2> pVar) {
        v0();
        throw new lm.y();
    }

    public /* synthetic */ h0(Throwable th2, String str, int i10, kn.w wVar) {
        this(th2, (i10 & 2) != 0 ? null : str);
    }
}
