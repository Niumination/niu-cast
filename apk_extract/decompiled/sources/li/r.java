package li;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends x1 implements q {
    public final Object r0(ContinuationImpl continuationImpl) throws Throwable {
        Object objY = y(continuationImpl);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objY;
    }

    public final boolean s0(Throwable th2) {
        return d0(new u(false, th2));
    }
}
