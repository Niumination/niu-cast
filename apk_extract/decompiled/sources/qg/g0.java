package qg;

import java.nio.charset.Charset;
import k3.g2;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vj.b f9071a = g2.a("io.ktor.server.engine.DefaultTransform");

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(jh.o oVar, Charset charset, ContinuationImpl continuationImpl) throws Exception {
        f0 f0Var;
        String strB;
        if (continuationImpl instanceof f0) {
            f0Var = (f0) continuationImpl;
            int i8 = f0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                f0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                f0Var = new f0(continuationImpl);
            }
        } else {
            f0Var = new f0(continuationImpl);
        }
        Object objK = f0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = f0Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objK);
            f0Var.L$0 = charset;
            f0Var.label = 1;
            objK = jh.g0.k(oVar, Long.MAX_VALUE, f0Var);
            if (objK == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            charset = (Charset) f0Var.L$0;
            ResultKt.throwOnFailure(objK);
        }
        wi.k kVar = (wi.k) objK;
        if (kVar.T()) {
            return "";
        }
        try {
            if (Intrinsics.areEqual(charset, Charsets.UTF_8) || Intrinsics.areEqual(charset, Charsets.ISO_8859_1)) {
                Intrinsics.checkNotNullParameter(kVar, "<this>");
                strB = wi.p.b(kVar);
            } else {
                strB = h.h(kVar, charset);
            }
            return strB;
        } finally {
            kVar.close();
        }
    }
}
