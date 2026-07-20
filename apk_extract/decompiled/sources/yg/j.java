package yg;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.o1;
import li.p1;
import m3.e0;
import oh.u0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(l session, Function2 function2, ContinuationImpl continuationImpl) {
        f fVar;
        oh.d dVar;
        if (continuationImpl instanceof f) {
            fVar = (f) continuationImpl;
            int i8 = fVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                fVar.label = i8 - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuationImpl);
            }
        } else {
            fVar = new f(continuationImpl);
        }
        Object obj = fVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = fVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                dVar = (oh.d) fVar.L$0;
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
        Intrinsics.checkNotNullParameter(session, "<this>");
        mg.a application = session.c().getApplication();
        bd.b bVar = q.f11216h;
        q qVar = (q) mg.e.c(application);
        vj.b bVar2 = oh.l.f8508a;
        Intrinsics.checkNotNullParameter(session, "session");
        if (session instanceof oh.d) {
            throw new IllegalArgumentException("Cannot wrap other DefaultWebSocketSession");
        }
        oh.k kVar = new oh.k(session, qVar.f11219a, qVar.f11220b);
        kVar.b0((List) session.c().i().b(q.f11218j));
        mg.b bVarC = session.c();
        fVar.L$0 = kVar;
        fVar.label = 1;
        if (b(kVar, bVarC, function2, fVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        dVar = kVar;
        fVar.L$0 = null;
        fVar.label = 2;
        CoroutineContext.Element element = dVar.getCoroutineContext().get(o1.f7483a);
        Intrinsics.checkNotNull(element);
        Object objS = ((p1) element).S(fVar);
        if (objS != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objS = Unit.INSTANCE;
        }
        if (objS == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static final Object b(oh.k kVar, mg.b bVar, Function2 function2, ContinuationImpl continuationImpl) throws ah.b {
        e eVar;
        oh.d dVar;
        if (continuationImpl instanceof e) {
            eVar = (e) continuationImpl;
            int i8 = eVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                eVar.label = i8 - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuationImpl);
            }
        } else {
            eVar = new e(continuationImpl);
        }
        Object obj = eVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = eVar.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    bVar = (mg.b) eVar.L$1;
                    oh.d dVar2 = (oh.d) eVar.L$0;
                    ResultKt.throwOnFailure(obj);
                    dVar = dVar2;
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            r.f11223a.trace("Starting websocket session for " + m3.k.a(bVar.g()));
            b bVarA = e0.a(bVar, kVar);
            eVar.L$0 = kVar;
            eVar.L$1 = bVar;
            eVar.label = 1;
            dVar = kVar;
            if (function2.invoke(bVarA, eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar.L$0 = bVar;
            eVar.L$1 = null;
            eVar.label = 2;
            if (u0.b(dVar, new oh.c(oh.b.NORMAL, ""), eVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (ah.b e) {
            throw e;
        } catch (CancellationException e4) {
            throw e4;
        } catch (Throwable th2) {
            mg.a application = bVar.getApplication();
            Intrinsics.checkNotNullParameter(application, "<this>");
            application.f8055i.f9064b.error("Websocket handler failed", th2);
            throw th2;
        }
    }
}
