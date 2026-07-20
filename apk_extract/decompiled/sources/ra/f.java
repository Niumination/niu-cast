package ra;

import android.app.Application;
import android.util.Log;
import eb.y;
import eb.y0;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.a2;
import li.g0;
import li.l0;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends SuspendLambda implements Function2 {
    int label;

    public f(Continuation<? super f> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0076  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Application context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            y0 y0Var = y0.f4813a;
            context = pb.a();
            Intrinsics.checkNotNullParameter(context, "context");
            if (!y0.f4814b) {
                va.b.f(context, y0.f4824n, "android.net.wifi.WIFI_STATE_CHANGED", true);
                va.b.f(context, y0.f4823m, "android.bluetooth.adapter.action.STATE_CHANGED", true);
                va.b.f(context, y0.f4825o, "android.net.wifi.WIFI_AP_STATE_CHANGED", true);
                y0.f4814b = true;
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        y yVar = y.f4799a;
        this.label = 1;
        if (yVar.d(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        qi.c cVar = nb.d.f8148a;
        Intrinsics.checkNotNullParameter("PcModuleServiceLife", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PcModuleServiceLife"), "onCreate");
        }
        l0.p(nb.d.f8148a, null, null, new nb.c(null), 3);
        a2 a2Var = r.f9163a;
        e eVar = new e(null);
        this.label = 2;
        if (l0.u(a2Var, eVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        y0 y0Var2 = y0.f4813a;
        context = pb.a();
        Intrinsics.checkNotNullParameter(context, "context");
        if (!y0.f4814b) {
            va.b.f(context, y0.f4824n, "android.net.wifi.WIFI_STATE_CHANGED", true);
            va.b.f(context, y0.f4823m, "android.bluetooth.adapter.action.STATE_CHANGED", true);
            va.b.f(context, y0.f4825o, "android.net.wifi.WIFI_AP_STATE_CHANGED", true);
            y0.f4814b = true;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
