package qg;

import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public b0(Continuation<? super b0> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        b0 b0Var = new b0(continuation);
        b0Var.L$0 = fVar;
        b0Var.L$1 = obj;
        return b0Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        cg.j oVar;
        cg.j aVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            Object value = this.L$1;
            mg.r call = (mg.r) fVar.f5401a;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof cg.j) {
                oVar = (cg.j) value;
            } else if (value instanceof String) {
                oVar = new cg.o((String) value, m3.r.a(call, null), null);
            } else {
                if (value instanceof byte[]) {
                    aVar = new cg.a((byte[]) value);
                } else if (value instanceof zf.z) {
                    aVar = new sg.b((zf.z) value);
                } else if (value instanceof jh.o) {
                    aVar = new sg.a(value, 1);
                } else {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(value, "value");
                    if (value instanceof InputStream) {
                        aVar = new sg.a(value, 0);
                    } else {
                        oVar = null;
                    }
                }
                oVar = aVar;
            }
            if (oVar != null) {
                this.L$0 = null;
                this.label = 1;
                if (fVar.f(oVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
