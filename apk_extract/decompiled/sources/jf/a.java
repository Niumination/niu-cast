package jf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, Continuation<? super a> continuation) {
        super(3, continuation);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        a aVar = new a(this.this$0, continuation);
        aVar.L$0 = fVar;
        aVar.L$1 = obj;
        return aVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        hh.f fVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                obj2 = this.L$1;
                fVar = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        hh.f fVar2 = (hh.f) this.L$0;
        obj2 = this.L$1;
        if (!(obj2 instanceof kf.c)) {
            throw new IllegalStateException(("Error: HttpClientCall expected, but found " + obj2 + '(' + Reflection.getOrCreateKotlinClass(obj2.getClass()) + ").").toString());
        }
        wf.a aVar = this.this$0.f6261j;
        Unit unit = Unit.INSTANCE;
        wf.b bVarE = ((kf.c) obj2).e();
        this.L$0 = fVar2;
        this.L$1 = obj2;
        this.label = 1;
        Object objB = aVar.b(unit, bVarE, this);
        if (objB == coroutine_suspended) {
            return coroutine_suspended;
        }
        fVar = fVar2;
        obj = objB;
        wf.b response = (wf.b) obj;
        kf.c cVar = (kf.c) obj2;
        cVar.getClass();
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(response, "<set-?>");
        cVar.f6857c = response;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (fVar.f(obj2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
