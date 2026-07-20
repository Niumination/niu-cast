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
public final class p3 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ t3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p3(t3 t3Var, Continuation<? super p3> continuation) {
        super(2, continuation);
        this.this$0 = t3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        p3 p3Var = new p3(this.this$0, continuation);
        p3Var.L$0 = obj;
        return p3Var;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[PHI: r1
      0x0044: PHI (r1v9 yg.a) = (r1v7 yg.a), (r1v8 yg.a), (r1v10 yg.a) binds: [B:35:0x0061, B:41:0x009b, B:22:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:33:0x005a, B:37:0x0064, B:39:0x0085), top: B:49:0x0009 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0085, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [yg.a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r6v1, types: [se.t3] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        yg.a aVar;
        Exception e;
        ClosedChannelException e4;
        String mes;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                yg.a aVar2 = (yg.a) this.L$0;
                try {
                    t3.a(this.this$0, aVar2);
                    t3 t3Var = this.this$0;
                    this.L$0 = aVar2;
                    this.label = 1;
                    if (t3.b(t3Var, aVar2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar2;
                    if (!this.this$0.f) {
                        this.this$0.c(aVar);
                    }
                } catch (ClosedChannelException e10) {
                    aVar = aVar2;
                    e4 = e10;
                    this.this$0.getClass();
                    mes = "WebSocket connection closed: " + e4;
                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("WebSocketKtorServer", "TransConnect:" + mes, null);
                    }
                    if (!this.this$0.f) {
                    }
                    return Unit.INSTANCE;
                } catch (Exception e11) {
                    aVar = aVar2;
                    e = e11;
                    e.printStackTrace();
                    if (!this.this$0.f) {
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    coroutine_suspended = aVar2;
                    th = th2;
                    if (!this.this$0.f) {
                        this.this$0.c(coroutine_suspended);
                    }
                    throw th;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (yg.a) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    if (!this.this$0.f) {
                        this.this$0.c(aVar);
                    }
                } catch (ClosedChannelException e12) {
                    e4 = e12;
                    this.this$0.getClass();
                    mes = "WebSocket connection closed: " + e4;
                    Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("WebSocketKtorServer", "TransConnect:" + mes, null);
                    }
                    if (!this.this$0.f) {
                    }
                    return Unit.INSTANCE;
                } catch (Exception e13) {
                    e = e13;
                    e.printStackTrace();
                    if (!this.this$0.f) {
                    }
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(yg.a aVar, Continuation<? super Unit> continuation) {
        return ((p3) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
