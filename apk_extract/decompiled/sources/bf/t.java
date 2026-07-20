package bf;

import k3.bc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lambda f1294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ni.m f1295b;

    /* JADX WARN: Multi-variable type inference failed */
    public t(Function0 isReallyReady) {
        Intrinsics.checkNotNullParameter(isReallyReady, "isReallyReady");
        this.f1294a = (Lambda) isReallyReady;
        this.f1295b = bc.a(-1, 6, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final Object a(Continuation continuation) {
        s sVar;
        if (continuation instanceof s) {
            sVar = (s) continuation;
            int i8 = sVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                sVar.label = i8 - Integer.MIN_VALUE;
            } else {
                sVar = new s(this, continuation);
            }
        } else {
            sVar = new s(this, continuation);
        }
        Object obj = sVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = sVar.label;
        if (i9 != 0) {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (t) sVar.L$0;
        }
        ResultKt.throwOnFailure(obj);
        while (!((Boolean) this.f1294a.invoke()).booleanValue()) {
            sVar.L$0 = this;
            sVar.label = 1;
            if (this.f1295b.j(sVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
