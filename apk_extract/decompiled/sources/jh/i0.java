package jh;

import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(o oVar, ByteBuffer byteBuffer, ContinuationImpl continuationImpl) {
        h0 h0Var;
        if (continuationImpl instanceof h0) {
            h0Var = (h0) continuationImpl;
            int i8 = h0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                h0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                h0Var = new h0(continuationImpl);
            }
        } else {
            h0Var = new h0(continuationImpl);
        }
        Object obj = h0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = h0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            if (oVar.f()) {
                return Boxing.boxInt(-1);
            }
            if (oVar.d().T()) {
                h0Var.L$0 = oVar;
                h0Var.L$1 = byteBuffer;
                h0Var.label = 1;
                if (oVar.e(1, h0Var) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteBuffer = (ByteBuffer) h0Var.L$1;
            oVar = (o) h0Var.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return oVar.f() ? Boxing.boxInt(-1) : Boxing.boxInt(wi.n.a(oVar.d(), byteBuffer));
    }
}
