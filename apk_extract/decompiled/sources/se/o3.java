package se;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class o3 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    int label;

    public o3(Continuation<? super o3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        o3 o3Var = new o3(continuation);
        o3Var.L$0 = obj;
        return o3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            xg.r rVar = ((xg.s) this.L$0).f10988a;
            zf.i iVar = zf.h.f11502b;
            this.label = 1;
            KType kTypeTypeOf = null;
            cg.o oVar = new cg.o("pong", m3.r.a(rVar, iVar), null);
            Intrinsics.checkNotNullParameter(oVar, "<this>");
            Unit unit = Unit.INSTANCE;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cg.o.class);
            try {
                kTypeTypeOf = Reflection.typeOf(cg.o.class);
            } catch (Throwable unused) {
            }
            Object objB = rVar.B(oVar, new ih.a(orCreateKotlinClass, kTypeTypeOf), this);
            if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objB = Unit.INSTANCE;
            }
            if (objB == coroutine_suspended) {
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
    public final Object invoke(xg.s sVar, Continuation<? super Unit> continuation) {
        return ((o3) create(sVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
