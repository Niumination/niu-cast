package oi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ni.d0 f8560a;

    public p(ni.d0 d0Var) {
        this.f8560a = d0Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        o oVar;
        if (continuation instanceof o) {
            oVar = (o) continuation;
            int i8 = oVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                oVar.label = i8 - Integer.MIN_VALUE;
            } else {
                oVar = new o(this, continuation);
            }
        } else {
            oVar = new o(this, continuation);
        }
        Object obj2 = oVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = oVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj2);
            if (obj == null) {
                obj = pi.c.f8895b;
            }
            oVar.label = 1;
            if (((ni.r) this.f8560a).f8323d.r(obj, oVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj2);
        }
        return Unit.INSTANCE;
    }
}
