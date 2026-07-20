package eb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 extends SuspendLambda implements Function2 {
    int label;

    public k2(Continuation<? super k2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            String strN = o.d.n("main socket waiting ip:", k1.f4767c, "SocketServerManager", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SocketServerManager"), strN);
            }
            this.label = 1;
            if (li.r0.a(60000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        gc.c("SocketServerManager", "main socket waiting timeout ip:" + k1.f4767c);
        gc.c("SocketServerManager", "disconnect main socket reason for timeout.");
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        l2.f();
        y yVar = y.f4799a;
        y.m();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((k2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
