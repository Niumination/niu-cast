package ni;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g extends FunctionReferenceImpl implements Function3 {
    public g(Object obj) {
        super(3, obj, m.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Throwable) obj, obj2, (CoroutineContext) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th2, Object obj, CoroutineContext coroutineContext) {
        Function1 function1 = ((m) this.receiver).f8304b;
        Intrinsics.checkNotNull(function1);
        qi.g.a(function1, obj, coroutineContext);
    }
}
