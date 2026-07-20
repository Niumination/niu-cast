package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oi.i f1281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f1282b;

    public f0(oi.i iVar, Function2 function2) {
        this.f1281a = iVar;
        this.f1282b = function2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        e0 e0Var;
        oi.i iVar;
        if (continuation instanceof e0) {
            e0Var = (e0) continuation;
            int i8 = e0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                e0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                e0Var = new e0(this, continuation);
            }
        } else {
            e0Var = new e0(this, continuation);
        }
        Object obj2 = e0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = e0Var.label;
        if (i9 != 0) {
            if (i9 == 1) {
                iVar = (oi.i) e0Var.L$0;
                ResultKt.throwOnFailure(obj2);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj2);
        oi.i iVar2 = this.f1281a;
        e0Var.L$0 = iVar2;
        e0Var.label = 1;
        InlineMarker.mark(6);
        Object objInvoke = this.f1282b.invoke(obj, e0Var);
        InlineMarker.mark(7);
        if (objInvoke == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj2 = objInvoke;
        iVar = iVar2;
        e0Var.L$0 = null;
        e0Var.label = 2;
        if (iVar.emit(obj2, e0Var) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
