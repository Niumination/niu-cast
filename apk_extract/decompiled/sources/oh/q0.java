package oh;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends SuspendLambda implements Function2 {
    final /* synthetic */ nh.d $pool;
    Object L$0;
    int label;
    final /* synthetic */ r0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(nh.d dVar, r0 r0Var, Continuation<? super q0> continuation) {
        super(2, continuation);
        this.$pool = dVar;
        this.this$0 = r0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new q0(this.$pool, this.this$0, continuation);
    }

    /* JADX INFO: Infinite loop detected, blocks: 4, insns: 0 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th2;
        ByteBuffer byteBuffer;
        w e;
        f0 e4;
        r0 r0Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                ByteBuffer byteBuffer2 = (ByteBuffer) this.$pool.R();
                try {
                    r0 r0Var2 = this.this$0;
                    this.L$0 = byteBuffer2;
                    this.label = 1;
                    if (r0.a(r0Var2, byteBuffer2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byteBuffer = byteBuffer2;
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (ClosedChannelException unused) {
                    byteBuffer = byteBuffer2;
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (IOException unused2) {
                    byteBuffer = byteBuffer2;
                    this.this$0.f8517i.h(null);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (CancellationException unused3) {
                    byteBuffer = byteBuffer2;
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (f0 e10) {
                    byteBuffer = byteBuffer2;
                    e4 = e10;
                    this.this$0.f8517i.g(false, e4);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (w e11) {
                    byteBuffer = byteBuffer2;
                    e = e11;
                    this.this$0.f8517i.g(false, e);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (Throwable th3) {
                    th2 = th3;
                    throw th2;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBuffer = (ByteBuffer) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (ClosedChannelException unused4) {
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (IOException unused5) {
                    this.this$0.f8517i.h(null);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (CancellationException unused6) {
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (f0 e12) {
                    e4 = e12;
                    this.this$0.f8517i.g(false, e4);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (w e13) {
                    e = e13;
                    this.this$0.f8517i.g(false, e);
                    this.$pool.h0(byteBuffer);
                    r0Var = this.this$0;
                } catch (Throwable th4) {
                    th2 = th4;
                    throw th2;
                }
            }
            r0Var.f8517i.q(null);
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            this.$pool.h0(coroutine_suspended);
            this.this$0.f8517i.q(null);
            throw th5;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((q0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
