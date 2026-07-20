package pb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ue.P2PConnectService;
import eb.k1;
import eb.y;
import eb.y0;
import k3.gc;
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
import li.v0;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends SuspendLambda implements Function2 {
    final /* synthetic */ hc.d $p2PConnectDevice;
    int label;
    final /* synthetic */ P2PConnectService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(P2PConnectService p2PConnectService, hc.d dVar, Continuation<? super f> continuation) {
        super(2, continuation);
        this.this$0 = p2PConnectService;
        this.$p2PConnectDevice = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new f(this.this$0, this.$p2PConnectDevice, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    /* JADX WARN: Code duplicated, block: B:25:0x008d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String log;
        hc.b bVar;
        String log2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i8 == 2) {
                ResultKt.throwOnFailure(obj);
                log = "connect p2p device:" + this.$p2PConnectDevice;
                Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("P2PConnectService"), log);
                }
                k1 k1Var = k1.f4765a;
                hc.d dVar = this.$p2PConnectDevice;
                String str = this.this$0.f2686d;
                this.label = 3;
                obj = k1Var.c(dVar, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            bVar = (hc.b) obj;
            log2 = "connect p2p service:" + bVar;
            Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("P2PConnectService"), log2);
            }
            if (!bVar.f5279a) {
                P2PConnectService p2PConnectService = this.this$0;
                int i9 = P2PConnectService.f2682i;
                p2PConnectService.getClass();
                y0.b("P2PConnectService connect failed");
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        v0 v0Var = v0.f7498a;
        a2 a2Var = r.f9163a;
        e eVar = new e(this.this$0, null);
        this.label = 1;
        if (l0.u(a2Var, eVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (this.this$0.f2685c.compareAndSet(true, false)) {
            y yVar = y.f4799a;
            this.label = 2;
            if (yVar.q(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        log = "connect p2p device:" + this.$p2PConnectDevice;
        Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("P2PConnectService"), log);
        }
        k1 k1Var2 = k1.f4765a;
        hc.d dVar2 = this.$p2PConnectDevice;
        String str2 = this.this$0.f2686d;
        this.label = 3;
        obj = k1Var2.c(dVar2, str2, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        bVar = (hc.b) obj;
        log2 = "connect p2p service:" + bVar;
        Intrinsics.checkNotNullParameter("P2PConnectService", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("P2PConnectService"), log2);
        }
        if (!bVar.f5279a) {
            P2PConnectService p2PConnectService2 = this.this$0;
            int i10 = P2PConnectService.f2682i;
            p2PConnectService2.getClass();
            y0.b("P2PConnectService connect failed");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((f) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
