package pq;

import java.util.concurrent.CancellationException;
import kn.r1;
import lm.a1;
import lm.l2;
import nq.m2;
import nq.p0;
import nq.t2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,202:1\n706#2,2:203\n706#2,2:205\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n152#1:203,2\n157#1:205,2\n*E\n"})
public class g<E> extends nq.a<l2> implements d0<E>, d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final d<E> f13244d;

    public g(@os.l um.g gVar, @os.l d<E> dVar, boolean z10) {
        super(gVar, false, z10);
        this.f13244d = dVar;
        Y0((nq.l2) gVar.get(nq.l2.f11882k));
    }

    @Override // pq.g0
    public boolean J() {
        return this.f13244d.J();
    }

    @Override // pq.g0
    @os.m
    public Object L(E e10, @os.l um.d<? super l2> dVar) {
        return this.f13244d.L(e10, dVar);
    }

    @Override // nq.a
    public void Q1(@os.l Throwable th2, boolean z10) {
        if (this.f13244d.f(th2) || z10) {
            return;
        }
        p0.b(this.f11822c, th2);
    }

    @os.l
    public final d<E> V1() {
        return this.f13244d;
    }

    @Override // nq.a
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void T1(@os.l l2 l2Var) {
        g0.a.a(this.f13244d, null, 1, null);
    }

    @Override // pq.d0
    @os.l
    public g0<E> a() {
        return this;
    }

    @Override // nq.t2, nq.l2
    public final void b(@os.m CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new m2(m0(), null, this);
        }
        d0(cancellationException);
    }

    @Override // nq.t2, nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean c(Throwable th2) throws Throwable {
        if (th2 == null) {
            th2 = new m2(m0(), null, this);
        }
        d0(th2);
        return true;
    }

    @Override // nq.t2
    public void d0(@os.l Throwable th2) throws Throwable {
        CancellationException cancellationExceptionF1 = t2.F1(this, th2, null, 1, null);
        this.f13244d.b(cancellationExceptionF1);
        c0(cancellationExceptionF1);
    }

    @Override // pq.g0
    public boolean f(@os.m Throwable th2) {
        boolean zF = this.f13244d.f(th2);
        start();
        return zF;
    }

    @Override // pq.g0
    public void i(@os.l jn.l<? super Throwable, l2> lVar) {
        this.f13244d.i(lVar);
    }

    @Override // nq.a, nq.t2, nq.l2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // pq.g0
    @os.l
    public yq.i<E, g0<E>> m() {
        return this.f13244d.m();
    }

    @Override // pq.g0
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return this.f13244d.offer(e10);
    }

    @os.l
    public f0<E> v() {
        return this.f13244d.v();
    }

    @Override // pq.g0
    @os.l
    public Object w(E e10) {
        return this.f13244d.w(e10);
    }
}
