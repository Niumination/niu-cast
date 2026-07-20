package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class z2 extends um.a implements l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final z2 f11998a = new z2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f11999b = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    public z2() {
        super(l2.f11882k);
    }

    @lm.k(level = lm.m.WARNING, message = f11999b)
    public static /* synthetic */ void F0() {
    }

    @lm.k(level = lm.m.WARNING, message = f11999b)
    public static /* synthetic */ void f0() {
    }

    @lm.k(level = lm.m.WARNING, message = f11999b)
    public static /* synthetic */ void j0() {
    }

    @lm.k(level = lm.m.WARNING, message = f11999b)
    public static /* synthetic */ void p0() {
    }

    @lm.k(level = lm.m.WARNING, message = f11999b)
    public static /* synthetic */ void v0() {
    }

    @lm.k(level = lm.m.WARNING, message = f11999b)
    public static /* synthetic */ void w0() {
    }

    @Override // nq.l2
    @os.l
    public yq.e J1() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // nq.l2
    @lm.k(level = lm.m.WARNING, message = f11999b)
    @os.l
    public CancellationException O() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // nq.l2
    @lm.k(level = lm.m.WARNING, message = f11999b)
    @os.l
    public n1 S1(boolean z10, boolean z11, @os.l jn.l<? super Throwable, lm.l2> lVar) {
        return a3.f11823a;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.WARNING, message = f11999b)
    public void b(@os.m CancellationException cancellationException) {
    }

    @Override // nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean c(Throwable th2) {
        return false;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    @Override // nq.l2
    @os.m
    public l2 getParent() {
        return null;
    }

    @Override // nq.l2
    public boolean isActive() {
        return true;
    }

    @Override // nq.l2
    public boolean isCancelled() {
        return false;
    }

    @Override // nq.l2
    public boolean isCompleted() {
        return false;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.WARNING, message = f11999b)
    @os.l
    public n1 k0(@os.l jn.l<? super Throwable, lm.l2> lVar) {
        return a3.f11823a;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.WARNING, message = f11999b)
    @os.l
    public v o(@os.l x xVar) {
        return a3.f11823a;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.WARNING, message = f11999b)
    public boolean start() {
        return false;
    }

    @Override // nq.l2
    @os.m
    @lm.k(level = lm.m.WARNING, message = f11999b)
    public Object t(@os.l um.d<? super lm.l2> dVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @os.l
    public String toString() {
        return "NonCancellable";
    }

    @Override // nq.l2
    @os.l
    public gq.m<l2> y() {
        return gq.g.f6836a;
    }

    @Override // nq.l2
    @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @os.l
    public l2 y0(@os.l l2 l2Var) {
        return l2Var;
    }
}
