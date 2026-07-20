package eb;

import android.util.Log;
import k3.gc;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $isInterrupt;
    final /* synthetic */ String $tag;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(String str, boolean z2, Continuation<? super p0> continuation) {
        super(2, continuation);
        this.$tag = str;
        this.$isInterrupt = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new p0(this.$tag, this.$isInterrupt, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    /* JADX WARN: Code duplicated, block: B:21:0x006d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0088  */
    /* JADX WARN: Code duplicated, block: B:25:0x0091  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.welink.protocol.nfbd.y yVar;
        com.welink.protocol.nfbd.c0 c0Var;
        Integer numValueOf;
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
            Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
            Intrinsics.checkNotNullParameter("delay 500ms disable smart connect", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "delay 500ms disable smart connect");
            }
            Lazy lazy = mc.b.f7958a;
            Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
            Intrinsics.checkNotNullParameter("disableSmartConnect", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("TranConnectManager"), "disableSmartConnect");
            }
            se.b1 b1VarE = mc.b.e();
            b1VarE.getClass();
            we.h.b("NearConnectionManager", "disableSmartConnect");
            yVar = b1VarE.f9655c;
            c0Var = yVar.f4191c;
            if (c0Var != null) {
                numValueOf = Integer.valueOf(c0Var.d());
            } else {
                numValueOf = null;
            }
            if ((numValueOf == null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == 3))) {
                yVar.S();
            } else {
                we.h.b("SmartConnectWrapper", "Service is not enabled, ignore");
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        y yVar2 = y.f4799a;
        String strI = h0.a.i("closePcConnectionSwitch from ", this.$tag);
        boolean z2 = this.$isInterrupt;
        this.label = 1;
        if (yVar2.j(strI, z2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.label = 2;
        if (li.r0.a(500L, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Intrinsics.checkNotNullParameter("PCConnectSwitchManager", "tag");
        Intrinsics.checkNotNullParameter("delay 500ms disable smart connect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PCConnectSwitchManager"), "delay 500ms disable smart connect");
        }
        Lazy lazy2 = mc.b.f7958a;
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("disableSmartConnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), "disableSmartConnect");
        }
        se.b1 b1VarE2 = mc.b.e();
        b1VarE2.getClass();
        we.h.b("NearConnectionManager", "disableSmartConnect");
        yVar = b1VarE2.f9655c;
        c0Var = yVar.f4191c;
        if (c0Var != null) {
            numValueOf = Integer.valueOf(c0Var.d());
        } else {
            numValueOf = null;
        }
        if (numValueOf == null) {
            yVar.S();
        } else {
            yVar.S();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((p0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
