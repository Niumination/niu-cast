package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    int label;

    public e(Continuation<? super e> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Unit unit, Continuation<? super Unit> continuation) {
        e eVar = new e(continuation);
        eVar.L$0 = fVar;
        return eVar.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [hh.f] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlin.coroutines.Continuation, qg.e] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.coroutines.jvm.internal.ContinuationImpl, qg.e] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v2, types: [mg.b, mg.r] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KType kTypeTypeOf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r7 = this.label;
        try {
            if (r7 != 0) {
                if (r7 == 1) {
                    hh.f fVar = (hh.f) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r7 = fVar;
                    this = this;
                } else {
                    if (r7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            hh.f fVar2 = (hh.f) this.L$0;
            this.L$0 = fVar2;
            this.label = 1;
            Object objE = fVar2.e(this);
            r7 = fVar2;
            this = objE;
            if (objE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (ug.b unused) {
            ?? r10 = (mg.r) r7.f5401a;
            zf.z zVar = zf.z.u;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
            try {
                kTypeTypeOf = Reflection.typeOf(zf.z.class);
            } catch (Throwable unused2) {
                kTypeTypeOf = null;
            }
            ih.a aVar = new ih.a(orCreateKotlinClass, kTypeTypeOf);
            this.L$0 = null;
            this.label = 2;
            if (r10.B(zVar, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
