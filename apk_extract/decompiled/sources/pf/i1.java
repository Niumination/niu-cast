package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 extends SuspendLambda implements Function3 {
    final /* synthetic */ Function3<vf.b, Throwable, Continuation<? super Throwable>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i1(Function3<? super vf.b, ? super Throwable, ? super Continuation<? super Throwable>, ? extends Object> function3, Continuation<? super i1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        i1 i1Var = new i1(this.$handler, continuation);
        i1Var.L$0 = fVar;
        return i1Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [hh.f] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.coroutines.Continuation, pf.i1] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, pf.i1] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
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
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r7 = this.label;
        try {
            if (r7 == 0) {
                ResultKt.throwOnFailure(obj);
                hh.f fVar = (hh.f) this.L$0;
                this.L$0 = fVar;
                this.label = 1;
                Object objE = fVar.e(this);
                r7 = fVar;
                this = objE;
                if (objE == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (r7 != 1) {
                    if (r7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Throwable th2 = (Throwable) obj;
                    if (th2 != null) {
                        throw th2;
                    }
                    return Unit.INSTANCE;
                }
                hh.f fVar2 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                r7 = fVar2;
                this = this;
            }
        } catch (Throwable th3) {
            Function3 function3 = this.$handler;
            vf.c cVar = (vf.c) r7.f5401a;
            vj.b bVar = d0.f8835a;
            c0 c0Var = new c0(cVar);
            this.L$0 = null;
            this.label = 2;
            obj = function3.invoke(c0Var, th3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
