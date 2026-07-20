package qg;

import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ p0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(p0 p0Var, Continuation<? super n0> continuation) {
        super(2, continuation);
        this.this$0 = p0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new n0(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            ng.p pVar = this.this$0.f9102n;
            this.label = 1;
            obj = pVar.f8263d.r0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        p0 p0Var = this.this$0;
        for (r0 r0Var : (Iterable) obj) {
            String value = r0Var.a();
            String str = rg.c.f9437a;
            Intrinsics.checkNotNullParameter(value, "value");
            if (StringsKt__StringsKt.contains$default(rg.c.f9437a, "windows", false, 2, (Object) null) && Intrinsics.areEqual(value, "0.0.0.0")) {
                value = "127.0.0.1";
            }
            b bVar = p0Var.f9093c;
            StringBuilder sb2 = new StringBuilder("Responding at ");
            String lowerCase = r0Var.getType().f9121a.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            sb2.append(lowerCase);
            sb2.append("://");
            sb2.append(value);
            sb2.append(':');
            sb2.append(r0Var.getPort());
            bVar.f9064b.info(sb2.toString());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((n0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
