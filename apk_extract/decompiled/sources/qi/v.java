package qi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes3.dex */
public class v extends li.a implements CoroutineStackFrame {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation f9168d;

    public v(Continuation continuation, CoroutineContext coroutineContext) {
        super(coroutineContext, true, true);
        this.f9168d = continuation;
    }

    @Override // li.x1
    public final boolean c0() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f9168d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // li.x1
    public void v(Object obj) {
        g.h(li.w.a(obj), IntrinsicsKt.intercepted(this.f9168d));
    }

    @Override // li.x1
    public void x(Object obj) {
        this.f9168d.resumeWith(li.w.a(obj));
    }
}
