package li;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class c2 extends AbstractCoroutineContextElement implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f7440a = new c2(o1.f7483a);

    @Override // li.p1
    public final x0 A(Function1 function1) {
        return d2.f7443a;
    }

    @Override // li.p1
    public final boolean H() {
        return false;
    }

    @Override // li.p1
    public final Object S(Continuation continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // li.p1
    public final boolean a() {
        return true;
    }

    @Override // li.p1
    public final o a0(x1 x1Var) {
        return d2.f7443a;
    }

    @Override // li.p1
    public final void h(CancellationException cancellationException) {
    }

    @Override // li.p1
    public final boolean isCancelled() {
        return false;
    }

    @Override // li.p1
    public final x0 s(boolean z2, boolean z3, Function1 function1) {
        return d2.f7443a;
    }

    @Override // li.p1
    public final boolean start() {
        return false;
    }

    @Override // li.p1
    public final CancellationException t() {
        throw new IllegalStateException("This job is always active");
    }

    public final String toString() {
        return "NonCancellable";
    }
}
