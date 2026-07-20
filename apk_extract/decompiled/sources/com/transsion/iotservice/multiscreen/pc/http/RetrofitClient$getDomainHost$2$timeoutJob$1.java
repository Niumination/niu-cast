package com.transsion.iotservice.multiscreen.pc.http;

import android.util.Log;
import androidx.lifecycle.CoroutineLiveDataKt;
import k3.gc;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.j;
import li.r0;
import na.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.http.RetrofitClient$getDomainHost$2$timeoutJob$1", f = "RetrofitClient.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class RetrofitClient$getDomainHost$2$timeoutJob$1 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetrofitClient$getDomainHost$2$timeoutJob$1(j jVar, Continuation<? super RetrofitClient$getDomainHost$2$timeoutJob$1> continuation) {
        super(2, continuation);
        this.$it = jVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RetrofitClient$getDomainHost$2$timeoutJob$1(this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (r0.a(CoroutineLiveDataKt.DEFAULT_TIMEOUT, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Intrinsics.checkNotNullParameter("RetrofitClient", "tag");
        Intrinsics.checkNotNullParameter("init gslb sdk timeout", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("RetrofitClient"), "init gslb sdk timeout");
        }
        String indiaUrl = RetrofitClient.INSTANCE.getIndiaUrl();
        RetrofitClient.gslbHost = indiaUrl;
        a.b(this.$it, indiaUrl);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((RetrofitClient$getDomainHost$2$timeoutJob$1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
