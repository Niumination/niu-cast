package pf;

import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m3.a6;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends SuspendLambda implements Function5 {
    final /* synthetic */ Charset $responseCharsetFallback;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(Charset charset, Continuation<? super j0> continuation) {
        super(5, continuation);
        this.$responseCharsetFallback = charset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        wf.b bVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            wf.b bVar2 = (wf.b) this.L$0;
            jh.o oVar = (jh.o) this.L$1;
            if (!Intrinsics.areEqual(((ih.a) this.L$2).f5872a, Reflection.getOrCreateKotlinClass(String.class))) {
                return null;
            }
            this.L$0 = bVar2;
            this.L$1 = null;
            this.label = 1;
            Object objL = jh.g0.l(oVar, this);
            if (objL == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
            obj = objL;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (wf.b) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        wi.k kVar = (wi.k) obj;
        Charset charset = this.$responseCharsetFallback;
        kf.c cVarB = bVar.b();
        vj.b bVar3 = l0.f8858a;
        Charset charsetA = a6.a(cVarB.e());
        if (charsetA != null) {
            charset = charsetA;
        }
        l0.f8858a.trace("Reading response body for " + cVarB.d().getUrl() + " as String with charset " + charset);
        return lh.a.h(kVar, charset, 2);
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(qf.j jVar, wf.b bVar, jh.o oVar, ih.a aVar, Continuation<Object> continuation) {
        j0 j0Var = new j0(this.$responseCharsetFallback, continuation);
        j0Var.L$0 = bVar;
        j0Var.L$1 = oVar;
        j0Var.L$2 = aVar;
        return j0Var.invokeSuspend(Unit.INSTANCE);
    }
}
