package eb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnecting;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalScanning;
import k3.gc;
import k3.y8;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1<hc.b, Unit> $callback;
    final /* synthetic */ hc.b $it;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h1(hc.b bVar, Function1<? super hc.b, Unit> function1, Continuation<? super h1> continuation) {
        super(2, continuation);
        this.$it = bVar;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new h1(this.$it, this.$callback, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c8 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        hc.c cVarA;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hc.b bVar = this.$it;
            if (!bVar.f5279a || StringsKt.isBlank(bVar.f5282d)) {
                k1.f4767c = "";
                Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                Intrinsics.checkNotNullParameter("BleFromPeerConnect:STATE_DISCONNECT", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PhysicalConnectManager"), "BleFromPeerConnect:STATE_DISCONNECT");
                }
                k1 k1Var = k1.f4765a;
                this.label = 1;
                if (k1Var.f(true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.$callback.invoke(this.$it);
                return Unit.INSTANCE;
            }
            y yVar = y.f4799a;
            y.i("onPreConnectByBleFromPeer");
            cVarA = y8.a(this.$it);
            if (Intrinsics.areEqual(y.f4804h, new PhysicalConnecting())) {
                this.L$0 = cVarA;
                this.label = 2;
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("onPhysicalScanning", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "onPhysicalScanning");
                }
                Object objC = y.c(new PhysicalScanning(), this);
                if (objC != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objC = Unit.INSTANCE;
                }
                if (objC == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            y yVar2 = y.f4799a;
            if (Intrinsics.areEqual(y.f4804h, new PhysicalScanning())) {
                k1 k1Var2 = k1.f4765a;
                k1.j("ble_from_peer");
                k1.e = cVarA;
                this.L$0 = cVarA;
                this.label = 3;
                if (y.g(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                k1 k1Var3 = k1.f4765a;
                this.L$0 = null;
                this.label = 4;
                if (k1.g(cVarA, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.$callback.invoke(this.$it);
            return Unit.INSTANCE;
        }
        if (i8 == 1) {
            ResultKt.throwOnFailure(obj);
            this.$callback.invoke(this.$it);
            return Unit.INSTANCE;
        }
        if (i8 == 2) {
            cVarA = (hc.c) this.L$0;
            ResultKt.throwOnFailure(obj);
            y yVar3 = y.f4799a;
            if (Intrinsics.areEqual(y.f4804h, new PhysicalScanning())) {
                k1 k1Var4 = k1.f4765a;
                k1.j("ble_from_peer");
                k1.e = cVarA;
                this.L$0 = cVarA;
                this.label = 3;
                if (y.g(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                k1 k1Var5 = k1.f4765a;
                this.L$0 = null;
                this.label = 4;
                if (k1.g(cVarA, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.$callback.invoke(this.$it);
            return Unit.INSTANCE;
        }
        if (i8 == 3) {
            cVarA = (hc.c) this.L$0;
            ResultKt.throwOnFailure(obj);
            k1 k1Var6 = k1.f4765a;
            this.L$0 = null;
            this.label = 4;
            if (k1.g(cVarA, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        k1 k1Var7 = k1.f4765a;
        k1.f4767c = this.$it.f5282d;
        this.$callback.invoke(this.$it);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((h1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
