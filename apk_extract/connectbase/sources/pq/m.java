package pq;

import java.util.concurrent.CancellationException;
import kn.r1;
import lm.a1;
import lm.l2;
import nq.m2;
import nq.t2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,41:1\n706#2,2:42\n706#2,2:44\n706#2,2:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n21#1:42,2\n26#1:44,2\n32#1:46,2\n*E\n"})
public class m<E> extends nq.a<l2> implements l<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final l<E> f13307d;

    public m(@os.l um.g gVar, @os.l l<E> lVar, boolean z10, boolean z11) {
        super(gVar, z10, z11);
        this.f13307d = lVar;
    }

    @Override // pq.f0
    @os.l
    public yq.g<p<E>> B() {
        return this.f13307d.B();
    }

    @Override // pq.f0
    @os.l
    public yq.g<E> C() {
        return this.f13307d.C();
    }

    @Override // pq.f0
    @os.l
    public Object D() {
        return this.f13307d.D();
    }

    @Override // pq.g0
    public boolean J() {
        return this.f13307d.J();
    }

    @Override // pq.g0
    @os.m
    public Object L(E e10, @os.l um.d<? super l2> dVar) {
        return this.f13307d.L(e10, dVar);
    }

    @os.l
    public final l<E> V1() {
        return this.f13307d;
    }

    @os.l
    public final l<E> a() {
        return this;
    }

    @Override // nq.t2, nq.l2
    public final void b(@os.m CancellationException cancellationException) throws Throwable {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new m2(m0(), null, this);
        }
        d0(cancellationException);
    }

    @Override // nq.t2, nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean c(Throwable th2) throws Throwable {
        d0(new m2(m0(), null, this));
        return true;
    }

    @Override // nq.t2, nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() throws Throwable {
        d0(new m2(m0(), null, this));
    }

    @Override // nq.t2
    public void d0(@os.l Throwable th2) throws Throwable {
        CancellationException cancellationExceptionF1 = t2.F1(this, th2, null, 1, null);
        this.f13307d.b(cancellationExceptionF1);
        c0(cancellationExceptionF1);
    }

    @Override // pq.g0
    public boolean f(@os.m Throwable th2) {
        return this.f13307d.f(th2);
    }

    @Override // pq.g0
    public void i(@os.l jn.l<? super Throwable, l2> lVar) {
        this.f13307d.i(lVar);
    }

    @Override // pq.f0
    public boolean isEmpty() {
        return this.f13307d.isEmpty();
    }

    @Override // pq.f0
    @os.l
    public n<E> iterator() {
        return this.f13307d.iterator();
    }

    @Override // pq.g0
    @os.l
    public yq.i<E, g0<E>> m() {
        return this.f13307d.m();
    }

    @Override // pq.f0
    @os.m
    public Object n(@os.l um.d<? super E> dVar) {
        return this.f13307d.n(dVar);
    }

    @Override // pq.g0
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return this.f13307d.offer(e10);
    }

    @Override // pq.f0
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @a1(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return this.f13307d.poll();
    }

    @Override // pq.f0
    public boolean r() {
        return this.f13307d.r();
    }

    @Override // pq.f0
    @os.m
    public Object s(@os.l um.d<? super p<? extends E>> dVar) {
        Object objS = this.f13307d.s(dVar);
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        return objS;
    }

    @Override // pq.f0
    @an.h
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @a1(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object u(@os.l um.d<? super E> dVar) {
        return this.f13307d.u(dVar);
    }

    @Override // pq.g0
    @os.l
    public Object w(E e10) {
        return this.f13307d.w(e10);
    }

    @Override // pq.f0
    @os.l
    public yq.g<E> x() {
        return this.f13307d.x();
    }
}
