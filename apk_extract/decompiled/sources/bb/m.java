package bb;

import android.util.Log;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends SuspendLambda implements Function2 {
    final /* synthetic */ String $deviceMac;
    int label;
    final /* synthetic */ r this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(r rVar, String str, Continuation<? super m> continuation) {
        super(2, continuation);
        this.this$0 = rVar;
        this.$deviceMac = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m(this.this$0, this.$deviceMac, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            vi.c cVar = this.this$0.f;
            this.label = 1;
            if (cVar.d(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (this.this$0.e.containsKey(this.$deviceMac)) {
            String strN = o.d.n("device is connecting,do not delete device:", this.$deviceMac, "BleScanDataFilterHelper", "tag", "log");
            if (gc.f6462a <= 5) {
                Log.w(gc.f6463b.concat("BleScanDataFilterHelper"), strN);
            }
            this.this$0.f.e(null);
            return Unit.INSTANCE;
        }
        if (!this.this$0.f1245g) {
            Intrinsics.checkNotNullParameter("BleScanDataFilterHelper", "tag");
            Intrinsics.checkNotNullParameter("deleteDevice :no need to delete", "log");
            if (gc.f6462a <= 2) {
                Log.v(gc.f6463b.concat("BleScanDataFilterHelper"), "deleteDevice :no need to delete");
            }
            this.this$0.f.e(null);
            return Unit.INSTANCE;
        }
        String strN2 = o.d.n("scan time out delete found device:", this.$deviceMac, "BleScanDataFilterHelper", "tag", "log");
        if (gc.f6462a <= 5) {
            Log.w(gc.f6463b.concat("BleScanDataFilterHelper"), strN2);
        }
        this.this$0.f1244d.remove(this.$deviceMac);
        this.this$0.f1243c.remove(this.$deviceMac);
        if (this.this$0.f1244d.isEmpty()) {
            this.this$0.f1242b = false;
        }
        this.this$0.b(true);
        this.this$0.f.e(null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((m) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
