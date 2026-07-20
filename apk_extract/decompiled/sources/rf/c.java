package rf;

import jh.j0;
import jh.l0;
import jh.o0;
import jh.y0;
import jh.z0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import li.r;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ Ref.ObjectRef<b> $copyTask;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Ref.ObjectRef<b> objectRef, Continuation<? super c> continuation) {
        super(2, continuation);
        this.$copyTask = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        c cVar = new c(this.$copyTask, continuation);
        cVar.L$0 = obj;
        return cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        z0 z0Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                z0Var = (z0) this.L$0;
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
        z0Var = (z0) this.L$0;
        b bVar = this.$copyTask.element;
        Intrinsics.checkNotNull(bVar);
        b bVar2 = bVar;
        this.L$0 = z0Var;
        this.label = 1;
        y0 y0Var = bVar2.f9430b;
        if (y0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("writerJob");
            y0Var = null;
        }
        l0 l0Var = o0.f6300a;
        Intrinsics.checkNotNullParameter(y0Var, "<this>");
        if (!((x1) y0Var.a()).H()) {
            y0 y0Var2 = bVar2.f9430b;
            if (y0Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("writerJob");
                y0Var2 = null;
            }
            y0Var2.f6311a.b(new e());
        }
        obj = ((r) bVar2.f9429a).r0(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        byte[] bArr = (byte[]) obj;
        j0 j0Var = z0Var.f6313a;
        this.L$0 = null;
        this.label = 2;
        l0 l0Var2 = o0.f6300a;
        if (o0.d(j0Var, bArr, 0, bArr.length, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(z0 z0Var, Continuation<? super Unit> continuation) {
        return ((c) create(z0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
