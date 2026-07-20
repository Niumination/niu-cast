package oh;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends SuspendLambda implements Function2 {
    Object L$0;
    int label;
    final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, Continuation<? super i> continuation) {
        super(2, continuation);
        this.this$0 = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i(this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0058 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, oh.i] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v22 */
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
        ?? r7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        k kVar = this.this$0;
                        this.label = 1;
                        if (k.b(kVar, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.f8503d.h(null);
                        s0 s0Var = this.this$0.f8500a;
                        this.label = 2;
                        this = u0.b(s0Var, new c(b.NORMAL, ""), this);
                        if (this == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        this.this$0.f8503d.h(null);
                        s0 s0Var2 = this.this$0.f8500a;
                        this.label = 2;
                        this = u0.b(s0Var2, new c(b.NORMAL, ""), this);
                        if (this == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        this = this;
                        r7.this$0.f8503d.h(null);
                        s0 s0Var3 = r7.this$0.f8500a;
                        r7.label = 6;
                        if (u0.b(s0Var3, new c(b.NORMAL, ""), r7) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 8:
                        ResultKt.throwOnFailure(obj);
                        this.this$0.f8503d.h(null);
                        s0 s0Var4 = this.this$0.f8500a;
                        this.label = 9;
                        if (u0.b(s0Var4, new c(b.NORMAL, ""), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 10:
                        Throwable th2 = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        throw th2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (ah.b unused) {
                this.this$0.f8503d.h(null);
                s0 s0Var5 = this.this$0.f8500a;
                this.label = 7;
                if (u0.b(s0Var5, new c(b.NORMAL, ""), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (CancellationException unused2) {
                k kVar2 = this.this$0;
                c cVar = new c(b.NORMAL, "");
                this.label = 5;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k.f8496l;
                Object objE = kVar2.e(cVar, null, this);
                r7 = this;
                if (objE == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ni.w unused3) {
                this.this$0.f8503d.h(null);
                s0 s0Var6 = this.this$0.f8500a;
                this.label = 4;
                if (u0.b(s0Var6, new c(b.NORMAL, ""), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (ni.x unused4) {
                this.this$0.f8503d.h(null);
                s0 s0Var7 = this.this$0.f8500a;
                this.label = 3;
                if (u0.b(s0Var7, new c(b.NORMAL, ""), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                this.this$0.f8503d.g(true, li.l0.a("Failed to send frame", th3));
                s0 s0Var8 = this.this$0.f8500a;
                this.label = 8;
                Object objB = u0.b(s0Var8, th3 instanceof CancellationException ? new c(b.NORMAL, "") : new c(b.INTERNAL_ERROR, th3.toString()), this);
                if (objB != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objB = Unit.INSTANCE;
                }
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th4) {
            this.this$0.f8503d.h(null);
            s0 s0Var9 = this.this$0.f8500a;
            this.L$0 = th4;
            this.label = 10;
            if (u0.b(s0Var9, new c(b.NORMAL, ""), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th4;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
