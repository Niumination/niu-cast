package pf;

import java.nio.charset.Charset;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import m3.a6;
import m3.y5;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends SuspendLambda implements Function3 {
    final /* synthetic */ String $acceptCharsetHeader;
    final /* synthetic */ Charset $requestCharset;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(String str, Charset charset, Continuation<? super i0> continuation) {
        super(3, continuation);
        this.$acceptCharsetHeader = str;
        this.$requestCharset = charset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Charset charsetA;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        vf.c cVar = (vf.c) this.L$0;
        Object obj2 = this.L$1;
        String value = this.$acceptCharsetHeader;
        vj.b bVar = l0.f8858a;
        zf.s sVar = cVar.f10559c;
        String[] strArr = zf.v.f11551a;
        String strI = sVar.i("Accept-Charset");
        zf.j0 j0Var = cVar.f10557a;
        if (strI == null) {
            l0.f8858a.trace("Adding Accept-Charset=" + value + " to " + j0Var);
            zf.s sVar2 = cVar.f10559c;
            sVar2.getClass();
            Intrinsics.checkNotNullParameter("Accept-Charset", "name");
            Intrinsics.checkNotNullParameter(value, "value");
            sVar2.n(value);
            List listH = sVar2.h("Accept-Charset");
            listH.clear();
            listH.add(value);
        }
        if (!(obj2 instanceof String)) {
            return null;
        }
        zf.i iVarB = a6.b(cVar);
        if (iVarB != null) {
            if (!Intrinsics.areEqual(iVarB.f11506d, zf.h.f11502b.f11506d)) {
                return null;
            }
        }
        Charset charset = this.$requestCharset;
        String str = (String) obj2;
        zf.i iVar = iVarB == null ? zf.h.f11502b : iVarB;
        if (iVarB != null && (charsetA = y5.a(iVarB)) != null) {
            charset = charsetA;
        }
        l0.f8858a.trace("Sending request body to " + j0Var + " as text/plain with charset " + charset);
        return new cg.o(str, y5.b(iVar, charset), null);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(vf.c cVar, Object obj, Continuation<? super cg.j> continuation) {
        i0 i0Var = new i0(this.$acceptCharsetHeader, this.$requestCharset, continuation);
        i0Var.L$0 = cVar;
        i0Var.L$1 = obj;
        return i0Var.invokeSuspend(Unit.INSTANCE);
    }
}
