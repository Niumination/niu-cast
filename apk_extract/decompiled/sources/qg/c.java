package qg;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    int label;

    public c(Continuation<? super c> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Unit unit, Continuation<? super Unit> continuation) {
        c cVar = new c(continuation);
        cVar.L$0 = fVar;
        return cVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KType kTypeTypeOf;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            mg.r rVar = (mg.r) fVar.f5401a;
            zg.a aVar = mg.s.f8076a;
            Intrinsics.checkNotNullParameter(rVar, "<this>");
            if (rVar.k().b()) {
                return Unit.INSTANCE;
            }
            mg.r rVar2 = (mg.r) fVar.f5401a;
            zf.z zVarG = rVar2.k().g();
            if (zVarG == null && (zVarG = (zf.z) rVar2.i().d(xg.o0.f10979a)) == null) {
                zVarG = zf.z.p;
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(zf.z.class);
            try {
                kTypeTypeOf = Reflection.typeOf(zf.z.class);
            } catch (Throwable unused) {
                kTypeTypeOf = null;
            }
            ih.a aVar2 = new ih.a(orCreateKotlinClass, kTypeTypeOf);
            this.label = 1;
            if (rVar2.B(zVarG, aVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
