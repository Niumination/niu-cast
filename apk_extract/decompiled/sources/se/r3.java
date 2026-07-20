package se;

import android.util.Log;
import java.nio.channels.ClosedChannelException;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r3 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ t3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r3(t3 t3Var, Continuation<? super r3> continuation) {
        super(2, continuation);
        this.this$0 = t3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        t3 t3Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            try {
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj);
                    q3 q3Var = new q3(this.this$0, null);
                    this.label = 1;
                    if (li.l0.r(q3Var, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (!this.this$0.f) {
                    this.this$0.getClass();
                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                    Intrinsics.checkNotNullParameter("WebSocket server start failed finally", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed finally", null);
                    }
                }
            } catch (ClosedChannelException e) {
                this.this$0.getClass();
                we.h.c("WebSocketKtorServer", "WebSocket server start failed: " + e, null);
                if (!this.this$0.f) {
                    t3Var = this.this$0;
                    t3Var.getClass();
                    we.h.c("WebSocketKtorServer", "WebSocket server start failed finally", null);
                }
            } catch (Exception e4) {
                this.this$0.getClass();
                we.h.c("WebSocketKtorServer", "WebSocket server start failed: " + e4, null);
                if (!this.this$0.f) {
                    t3Var = this.this$0;
                    t3Var.getClass();
                    we.h.c("WebSocketKtorServer", "WebSocket server start failed finally", null);
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            if (!this.this$0.f) {
                this.this$0.getClass();
                Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                Intrinsics.checkNotNullParameter("WebSocket server start failed finally", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("WebSocketKtorServer", "TransConnect:WebSocket server start failed finally", null);
                }
            }
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((r3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
