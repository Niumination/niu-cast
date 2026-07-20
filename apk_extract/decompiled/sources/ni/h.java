package ni;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h extends FunctionReferenceImpl implements Function3 {
    public h(Object obj) {
        super(3, obj, m.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m1632invoke5_sEAP8((Throwable) obj, ((u) obj2).f8326a, (CoroutineContext) obj3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke-5_sEAP8, reason: not valid java name */
    public final void m1632invoke5_sEAP8(Throwable th2, Object obj, CoroutineContext coroutineContext) {
        Function1 function1 = ((m) this.receiver).f8304b;
        Intrinsics.checkNotNull(function1);
        Object objB = u.b(obj);
        Intrinsics.checkNotNull(objB);
        qi.g.a(function1, objB, coroutineContext);
    }
}
