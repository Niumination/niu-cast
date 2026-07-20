package se;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class h3 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ i3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3(i3 i3Var, Continuation<? super h3> continuation) {
        super(2, continuation);
        this.this$0 = i3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new h3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            try {
                Iterator it = this.this$0.e.values().iterator();
                while (it.hasNext()) {
                    ((Socket) it.next()).close();
                }
                this.this$0.e.clear();
                ServerSocket serverSocket = this.this$0.f9800b;
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ServerSocket serverSocket2 = this.this$0.f9800b;
                if (serverSocket2 != null) {
                    serverSocket2.close();
                }
            }
            this.this$0.f9800b = null;
            li.g2 g2Var = this.this$0.f9802d;
            if (g2Var != null) {
                g2Var.h(null);
            }
            this.this$0.f9802d = null;
            we.h.h("TcpHskServer", "Server stopped");
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            ServerSocket serverSocket3 = this.this$0.f9800b;
            if (serverSocket3 != null) {
                serverSocket3.close();
            }
            this.this$0.f9800b = null;
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((h3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
