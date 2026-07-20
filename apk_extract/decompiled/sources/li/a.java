package li;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends x1 implements Continuation, g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f7429c;

    public a(CoroutineContext coroutineContext, boolean z2, boolean z3) {
        super(z3);
        if (z2) {
            Y((p1) coroutineContext.get(o1.f7483a));
        }
        this.f7429c = coroutineContext.plus(this);
    }

    @Override // li.x1
    public final String F() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // li.x1
    public final void W(v vVar) {
        d0.a(this.f7429c, vVar);
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f7429c;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f7429c;
    }

    @Override // li.x1
    public final void k0(Object obj) {
        if (!(obj instanceof u)) {
            s0(obj);
            return;
        }
        u uVar = (u) obj;
        Throwable th2 = uVar.f7494a;
        uVar.getClass();
        r0(u.f7493b.get(uVar) != 0, th2);
    }

    public void r0(boolean z2, Throwable th2) {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(obj);
        if (thM162exceptionOrNullimpl != null) {
            obj = new u(false, thM162exceptionOrNullimpl);
        }
        Object objE0 = e0(obj);
        if (objE0 == l0.e) {
            return;
        }
        x(objE0);
    }

    public void s0(Object obj) {
    }
}
