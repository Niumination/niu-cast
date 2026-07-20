package oi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f8541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f8542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f8543c;

    public f(g gVar, Ref.ObjectRef objectRef, i iVar) {
        this.f8541a = gVar;
        this.f8542b = objectRef;
        this.f8543c = iVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        e eVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i8 = eVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                eVar.label = i8 - Integer.MIN_VALUE;
            } else {
                eVar = new e(this, continuation);
            }
        } else {
            eVar = new e(this, continuation);
        }
        Object obj2 = eVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = eVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj2);
            this.f8541a.getClass();
            Ref.ObjectRef objectRef = this.f8542b;
            T t3 = objectRef.element;
            if (t3 != pi.c.f8895b && Intrinsics.areEqual(t3, obj)) {
                return Unit.INSTANCE;
            }
            objectRef.element = obj;
            eVar.label = 1;
            if (this.f8543c.emit(obj, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj2);
        }
        return Unit.INSTANCE;
    }
}
