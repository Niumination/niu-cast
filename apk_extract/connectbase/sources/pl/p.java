package pl;

import java.util.concurrent.CancellationException;
import nq.g2;
import nq.l2;
import nq.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements h0, l0, l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l2 f13207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final c f13208b;

    public p(@os.l l2 l2Var, @os.l c cVar) {
        kn.l0.p(l2Var, "delegate");
        kn.l0.p(cVar, "channel");
        this.f13207a = l2Var;
        this.f13208b = cVar;
    }

    @Override // nq.l2
    @os.l
    public yq.e J1() {
        return this.f13207a.J1();
    }

    @Override // nq.l2
    @g2
    @os.l
    public CancellationException O() {
        return this.f13207a.O();
    }

    @Override // nq.l2
    @g2
    @os.l
    public n1 S1(boolean z10, boolean z11, @os.l jn.l<? super Throwable, lm.l2> lVar) {
        kn.l0.p(lVar, "handler");
        return this.f13207a.S1(z10, z11, lVar);
    }

    @Override // pl.l0
    public k a() {
        return this.f13208b;
    }

    @Override // nq.l2
    public void b(@os.m CancellationException cancellationException) {
        this.f13207a.b(cancellationException);
    }

    @Override // nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean c(Throwable th2) {
        return this.f13207a.c(th2);
    }

    @Override // nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.f13207a.cancel();
    }

    @os.l
    public c d() {
        return this.f13208b;
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        kn.l0.p(pVar, "operation");
        return (R) this.f13207a.fold(r10, pVar);
    }

    @Override // um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        kn.l0.p(cVar, cb.b.c.f1408o);
        return (E) this.f13207a.get(cVar);
    }

    @Override // um.g.b
    @os.l
    public um.g.c<?> getKey() {
        return this.f13207a.getKey();
    }

    @Override // nq.l2
    public boolean isActive() {
        return this.f13207a.isActive();
    }

    @Override // nq.l2
    public boolean isCancelled() {
        return this.f13207a.isCancelled();
    }

    @Override // nq.l2
    public boolean isCompleted() {
        return this.f13207a.isCompleted();
    }

    @Override // nq.l2
    @os.l
    public n1 k0(@os.l jn.l<? super Throwable, lm.l2> lVar) {
        kn.l0.p(lVar, "handler");
        return this.f13207a.k0(lVar);
    }

    @Override // um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        kn.l0.p(cVar, cb.b.c.f1408o);
        return this.f13207a.minusKey(cVar);
    }

    @Override // nq.l2
    @g2
    @os.l
    public nq.v o(@os.l nq.x xVar) {
        kn.l0.p(xVar, "child");
        return this.f13207a.o(xVar);
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        kn.l0.p(gVar, "context");
        return this.f13207a.plus(gVar);
    }

    @Override // nq.l2
    public boolean start() {
        return this.f13207a.start();
    }

    @Override // nq.l2
    @os.m
    public Object t(@os.l um.d<? super lm.l2> dVar) {
        return this.f13207a.t(dVar);
    }

    @os.l
    public String toString() {
        return "ChannelJob[" + this.f13207a + ']';
    }

    @Override // nq.l2
    @os.l
    public gq.m<l2> y() {
        return this.f13207a.y();
    }

    @Override // nq.l2
    @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @os.l
    public l2 y0(@os.l l2 l2Var) {
        kn.l0.p(l2Var, "other");
        return this.f13207a.y0(l2Var);
    }

    @Override // pl.h0
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public n mo70a() {
        return this.f13208b;
    }
}
