package li;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 extends p0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation f7512d;

    public y1(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, true, false);
        this.f7512d = IntrinsicsKt.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // li.x1
    public final void l0() {
        ri.a.a(this.f7512d, this);
    }
}
