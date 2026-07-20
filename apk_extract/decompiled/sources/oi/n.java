package oi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends SuspendLambda implements Function2 {
    final /* synthetic */ i $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Ref.ObjectRef<Object> objectRef, i iVar, Continuation<? super n> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.$downstream = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        n nVar = new n(this.$lastValue, this.$downstream, continuation);
        nVar.L$0 = obj;
        return nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1633invokeWpGqRn0(((ni.u) obj).f8326a, (Continuation) obj2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1633invokeWpGqRn0(Object obj, Continuation<? super Unit> continuation) {
        return ((n) create(new ni.u(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [T, a8.a] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            ?? r7 = ((ni.u) this.L$0).f8326a;
            objectRef = this.$lastValue;
            boolean z2 = r7 instanceof ni.t;
            if (!z2) {
                objectRef.element = r7;
            }
            i iVar = this.$downstream;
            if (z2) {
                Throwable thA = ni.u.a(r7);
                if (thA != null) {
                    throw thA;
                }
                Object obj2 = objectRef.element;
                if (obj2 != null) {
                    if (obj2 == pi.c.f8895b) {
                        obj2 = null;
                    }
                    this.L$0 = r7;
                    this.L$1 = objectRef;
                    this.label = 1;
                    if (iVar.emit(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef2 = objectRef;
                }
                objectRef.element = pi.c.f8896c;
            }
            return Unit.INSTANCE;
        }
        if (i8 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2 = (Ref.ObjectRef) this.L$1;
        ResultKt.throwOnFailure(obj);
        objectRef = objectRef2;
        objectRef.element = pi.c.f8896c;
        return Unit.INSTANCE;
    }
}
