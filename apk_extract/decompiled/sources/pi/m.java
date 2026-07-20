package pi;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import li.g0;
import li.j0;
import li.l0;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f8901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f8902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f8903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ oi.i f8904d;

    public m(Ref.ObjectRef objectRef, g0 g0Var, o oVar, oi.i iVar) {
        this.f8901a = objectRef;
        this.f8902b = g0Var;
        this.f8903c = oVar;
        this.f8904d = iVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, li.g2] */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        l lVar;
        if (continuation instanceof l) {
            lVar = (l) continuation;
            int i8 = lVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                lVar.label = i8 - Integer.MIN_VALUE;
            } else {
                lVar = new l(this, continuation);
            }
        } else {
            lVar = new l(this, continuation);
        }
        Object obj2 = lVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = lVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj2);
            p1 p1Var = (p1) this.f8901a.element;
            if (p1Var != null) {
                p1Var.h(new p());
                lVar.L$0 = this;
                lVar.L$1 = obj;
                lVar.L$2 = p1Var;
                lVar.label = 1;
                if (p1Var.S(lVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj = lVar.L$1;
            this = (m) lVar.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        this.f8901a.element = l0.p(this.f8902b, null, j0.UNDISPATCHED, new k(this.f8903c, this.f8904d, obj, null), 1);
        return Unit.INSTANCE;
    }
}
