package qg;

import k3.nd;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    int label;

    public x(Continuation<? super x> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Unit unit, Continuation<? super Unit> continuation) {
        x xVar = new x(continuation);
        xVar.L$0 = fVar;
        return xVar.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0081 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [hh.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10, types: [hh.f] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v19, types: [hh.f] */
    /* JADX WARN: Type inference failed for: r1v2, types: [hh.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v3, types: [hh.f] */
    /* JADX WARN: Type inference failed for: r1v8, types: [hh.f] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, qg.x] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, qg.x] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, qg.x] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, qg.x] */
    /* JADX WARN: Type inference failed for: r7v6, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, qg.x] */
    /* JADX WARN: Type inference failed for: r7v8, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, qg.x] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ?? r7;
        ?? r10;
        hh.f fVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r11 = this.label;
        try {
            try {
                try {
                    switch (r11) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            fVar = (hh.f) this.L$0;
                            w wVar = new w(((mg.r) fVar.f5401a).getApplication(), (mg.r) fVar.f5401a, null);
                            this.L$0 = fVar;
                            this.label = 1;
                            if (dh.c.a(wVar, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            jh.o oVarK = ((mg.r) fVar.f5401a).g().k();
                            this.L$0 = null;
                            r11 = 2;
                            r11 = 2;
                            r11 = 2;
                            this.label = 2;
                            this = jh.g0.d(oVarK, Long.MAX_VALUE, this);
                            if (this == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            fVar = (hh.f) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            jh.o oVarK2 = ((mg.r) fVar.f5401a).g().k();
                            this.L$0 = null;
                            r11 = 2;
                            r11 = 2;
                            r11 = 2;
                            this.label = 2;
                            this = jh.g0.d(oVarK2, Long.MAX_VALUE, this);
                            if (this == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 2:
                        case 4:
                        case 6:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 3:
                            r11 = (hh.f) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            jh.o oVarK3 = ((mg.r) r11.f5401a).g().k();
                            this.L$0 = null;
                            this.label = 4;
                            if (jh.g0.d(oVarK3, Long.MAX_VALUE, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 5:
                            hh.f fVar2 = (hh.f) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            r10 = fVar2;
                            this = this;
                            jh.o oVarK4 = ((mg.r) r10.f5401a).g().k();
                            r7.L$0 = null;
                            r7.label = 6;
                            if (jh.g0.d(oVarK4, Long.MAX_VALUE, r7) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 7:
                            Throwable th2 = (Throwable) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                throw th2;
                            } catch (Throwable unused) {
                                throw th2;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable unused2) {
                }
            } catch (ah.b e) {
                nd.a(((mg.r) r11.f5401a).getApplication());
                v vVar = new v(r11, e, null);
                this.L$0 = r11;
                this.label = 3;
                Object objInvoke = vVar.invoke(this);
                if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    objInvoke = Unit.INSTANCE;
                }
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th3) {
                mg.r rVar = (mg.r) r11.f5401a;
                this.L$0 = r11;
                this.label = 5;
                Object objF = h.f(rVar, th3, this);
                r10 = r11;
                r7 = this;
                if (objF == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th4) {
            try {
                jh.o oVarK5 = ((mg.r) r11.f5401a).g().k();
                this.L$0 = th4;
                this.label = 7;
                if (jh.g0.d(oVarK5, Long.MAX_VALUE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable unused3) {
            }
            throw th4;
        }
    }
}
