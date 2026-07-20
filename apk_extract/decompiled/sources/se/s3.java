package se;

import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s3 extends SuspendLambda implements Function2 {
    Object L$0;
    int label;
    final /* synthetic */ t3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s3(t3 t3Var, Continuation<? super s3> continuation) {
        super(2, continuation);
        this.this$0 = t3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new s3(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005e -> B:16:0x003b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                Collection collectionValues = this.this$0.f10001b.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                it = collectionValues.iterator();
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            while (it.hasNext()) {
                yg.a aVar = (yg.a) it.next();
                Intrinsics.checkNotNull(aVar);
                oh.c cVar = new oh.c(oh.b.NORMAL, "Server stopped");
                this.L$0 = it;
                this.label = 1;
                if (oh.u0.b(aVar, cVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.this$0.f10001b.clear();
            qg.p0 p0Var = this.this$0.e;
            if (p0Var != null) {
                p0Var.g(500L, 500L);
            }
            t3 t3Var = this.this$0;
            t3Var.e = null;
            t3Var.f10000a = 0;
            li.g2 g2Var = t3Var.f10003d;
            if (g2Var != null) {
                g2Var.h(null);
            }
        } catch (Exception e4) {
            this.this$0.getClass();
            String mes = "WebSocket server stop failed: " + e4;
            Intrinsics.checkNotNullParameter("WebSocketKtorServer", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("WebSocketKtorServer", "TransConnect:" + mes, null);
            }
            e4.printStackTrace();
        } finally {
            qg.p0 p0Var2 = this.this$0.e;
            if (p0Var2 != null) {
                p0Var2.g(500L, 500L);
            }
            t3 t3Var2 = this.this$0;
            t3Var2.e = null;
            t3Var2.f10000a = 0;
            li.g2 g2Var2 = t3Var2.f10003d;
            if (g2Var2 != null) {
                g2Var2.h(null);
            }
            this.this$0.f10003d = null;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((s3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
