package eb;

import android.util.Log;
import k3.gc;
import k3.pb;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 extends SuspendLambda implements Function2 {
    int label;

    public i1(Continuation<? super i1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (li.r0.a(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        gc.c("PhysicalConnectManager", "delay 500ms close connection");
        if (Intrinsics.areEqual(k1.f4766b, "cable")) {
            na.n.b(false);
        } else {
            Lazy lazy = l0.f4770a;
            gc.c("P2PTool", "releaseP2P");
            if (k3.o1.a(pb.a(), CollectionsKt.listOf(jb.h.f6139b)).isEmpty()) {
                Lazy lazy2 = mc.b.f7958a;
                mc.b.c();
            } else {
                gc.b("P2PTool", "releaseP2P without permission.");
            }
            k1.f4768d.getClass();
            Intrinsics.checkNotNullParameter("ConnectApi", "tag");
            Intrinsics.checkNotNullParameter("resetConnection", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectApi"), "resetConnection");
            }
            Lazy lazy3 = mc.b.f7958a;
            mc.b.b();
            mc.b.c();
        }
        k1.e = null;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((i1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
