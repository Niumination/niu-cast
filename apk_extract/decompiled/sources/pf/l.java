package pf;

import java.io.InputStream;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m3.a6;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public l(Continuation<? super l> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, Object obj, Continuation<? super Unit> continuation) {
        l lVar = new l(continuation);
        lVar.L$0 = fVar;
        lVar.L$1 = obj;
        return lVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        cg.j kVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            hh.f fVar = (hh.f) this.L$0;
            Object body = this.L$1;
            zf.s sVar = ((vf.c) fVar.f5401a).f10559c;
            String[] strArr = zf.v.f11551a;
            String strI = sVar.i("Accept");
            Object obj2 = fVar.f5401a;
            if (strI == null) {
                ((vf.c) obj2).f10559c.d("Accept", "*/*");
            }
            zf.i iVarB = a6.b((vf.c) obj2);
            if (body instanceof String) {
                String str = (String) body;
                if (iVarB == null) {
                    iVarB = zf.h.f11502b;
                }
                kVar = new cg.o(str, iVarB, null);
            } else if (body instanceof byte[]) {
                kVar = new j(iVarB, body);
            } else if (body instanceof jh.o) {
                kVar = new k(fVar, iVarB, body);
            } else if (body instanceof cg.j) {
                kVar = (cg.j) body;
            } else {
                vf.c context = (vf.c) obj2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(body, "body");
                kVar = body instanceof InputStream ? new k(context, iVarB, body) : null;
            }
            if ((kVar != null ? kVar.b() : null) != null) {
                vf.c cVar = (vf.c) obj2;
                zf.s sVar2 = cVar.f10559c;
                sVar2.getClass();
                Intrinsics.checkNotNullParameter("Content-Type", "name");
                ((Map) sVar2.f574b).remove("Content-Type");
                o.f8860a.trace("Transformed with default transformers request body for " + cVar.f10557a + " from " + Reflection.getOrCreateKotlinClass(body.getClass()));
                this.L$0 = null;
                this.label = 1;
                if (fVar.f(kVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
