package androidx.window.java.core;

import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import oi.h;
import oi.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.window.java.core.CallbackToFlowAdapter$connect$1$1", f = "CallbackToFlowAdapter.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class CallbackToFlowAdapter$connect$1$1 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Consumer<T> $consumer;
    final /* synthetic */ h $flow;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackToFlowAdapter$connect$1$1(h hVar, Consumer<T> consumer, Continuation<? super CallbackToFlowAdapter$connect$1$1> continuation) {
        super(2, continuation);
        this.$flow = hVar;
        this.$consumer = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallbackToFlowAdapter$connect$1$1(this.$flow, this.$consumer, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            h hVar = this.$flow;
            final Consumer<T> consumer = this.$consumer;
            i iVar = new i() { // from class: androidx.window.java.core.CallbackToFlowAdapter$connect$1$1.1
                @Override // oi.i
                public final Object emit(T t3, Continuation<? super Unit> continuation) {
                    consumer.accept(t3);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (hVar.a(iVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((CallbackToFlowAdapter$connect$1$1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
