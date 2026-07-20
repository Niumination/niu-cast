package pi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f8891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f8893c;

    public b0(oi.i iVar, CoroutineContext coroutineContext) {
        this.f8891a = coroutineContext;
        this.f8892b = qi.z.b(coroutineContext);
        this.f8893c = new a0(iVar, null);
    }

    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        Object objB = c.b(this.f8891a, obj, this.f8892b, this.f8893c, continuation);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }
}
