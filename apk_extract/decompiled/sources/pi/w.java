package pi;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w extends FunctionReferenceImpl implements Function3, SuspendFunction {
    public static final w INSTANCE = new w();

    public w() {
        super(3, oi.i.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(oi.i iVar, Object obj, Continuation<? super Unit> continuation) {
        return iVar.emit(obj, continuation);
    }
}
