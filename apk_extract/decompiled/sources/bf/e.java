package bf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oi.h f1279a;

    public e(oi.h requestFlow) {
        Intrinsics.checkNotNullParameter(requestFlow, "requestFlow");
        this.f1279a = requestFlow;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // bf.g
    public final Object a(ze.j jVar, t tVar, Continuation continuation) {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i8 = cVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                cVar.label = i8 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, continuation);
            }
        } else {
            cVar = new c(this, continuation);
        }
        Object obj = cVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = cVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                tVar = (t) cVar.L$2;
                jVar = (ze.j) cVar.L$1;
                this = (e) cVar.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        cVar.L$0 = this;
        cVar.L$1 = jVar;
        cVar.L$2 = tVar;
        cVar.label = 1;
        if (tVar.a(cVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        oi.h hVar = this.f1279a;
        d dVar = new d(0, jVar, tVar);
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.L$2 = null;
        cVar.label = 2;
        if (hVar.a(dVar, cVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
