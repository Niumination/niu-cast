package wf;

import java.util.concurrent.CancellationException;
import k3.ga;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.o1;
import li.r1;
import li.s;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vf.c f10750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jf.d f10751b;

    public j(vf.c builder, jf.d client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.f10750a = builder;
        this.f10751b = client;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(b bVar, ContinuationImpl continuationImpl) {
        g gVar;
        if (continuationImpl instanceof g) {
            gVar = (g) continuationImpl;
            int i8 = gVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                gVar.label = i8 - Integer.MIN_VALUE;
            } else {
                gVar = new g(this, continuationImpl);
            }
        } else {
            gVar = new g(this, continuationImpl);
        }
        Object obj = gVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = gVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext.Element element = bVar.getCoroutineContext().get(o1.f7483a);
            Intrinsics.checkNotNull(element);
            r1 r1Var = (r1) ((s) element);
            r1Var.r0();
            try {
                ga.a(bVar.d());
            } catch (Throwable unused) {
            }
            gVar.L$0 = r1Var;
            gVar.label = 1;
            if (r1Var.S(gVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0095 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0096  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(ContinuationImpl continuationImpl) throws Throwable {
        h hVar;
        j jVar;
        kf.c cVar;
        b bVarE;
        b bVarE2;
        if (continuationImpl instanceof h) {
            hVar = (h) continuationImpl;
            int i8 = hVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                hVar.label = i8 - Integer.MIN_VALUE;
            } else {
                hVar = new h(this, continuationImpl);
            }
        } else {
            hVar = new h(this, continuationImpl);
        }
        Object objA = hVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = hVar.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    this = (j) hVar.L$0;
                    ResultKt.throwOnFailure(objA);
                } else {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        b bVar = (b) hVar.L$0;
                        ResultKt.throwOnFailure(objA);
                        return bVar;
                    }
                    cVar = (kf.c) hVar.L$1;
                    jVar = (j) hVar.L$0;
                    ResultKt.throwOnFailure(objA);
                }
                bVarE = ((kf.c) objA).e();
                bVarE2 = cVar.e();
                hVar.L$0 = bVarE;
                hVar.L$1 = null;
                hVar.label = 3;
                if (jVar.a(bVarE2, hVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return bVarE;
            }
            ResultKt.throwOnFailure(objA);
            vf.c cVar2 = new vf.c();
            cVar2.c(this.f10750a);
            jf.d dVar = this.f10751b;
            hVar.L$0 = this;
            hVar.label = 1;
            objA = dVar.a(cVar2, hVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            kf.c cVar3 = (kf.c) objA;
            hVar.L$0 = this;
            hVar.L$1 = cVar3;
            hVar.label = 2;
            Object objA2 = kf.f.a(cVar3, hVar);
            if (objA2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            jVar = this;
            cVar = cVar3;
            objA = objA2;
            bVarE = ((kf.c) objA).e();
            bVarE2 = cVar.e();
            hVar.L$0 = bVarE;
            hVar.L$1 = null;
            hVar.label = 3;
            if (jVar.a(bVarE2, hVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return bVarE;
        } catch (CancellationException e) {
            throw xf.a.a(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(ContinuationImpl continuationImpl) throws Throwable {
        i iVar;
        if (continuationImpl instanceof i) {
            iVar = (i) continuationImpl;
            int i8 = iVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                iVar.label = i8 - Integer.MIN_VALUE;
            } else {
                iVar = new i(this, continuationImpl);
            }
        } else {
            iVar = new i(this, continuationImpl);
        }
        Object objA = iVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = iVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objA);
                vf.c cVar = new vf.c();
                cVar.c(this.f10750a);
                zg.a aVar = pf.s.f8865a;
                Intrinsics.checkNotNullParameter(cVar, "<this>");
                cVar.f.e(pf.s.f8865a, Unit.INSTANCE);
                jf.d dVar = this.f10751b;
                iVar.label = 1;
                objA = dVar.a(cVar, iVar);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
            return ((kf.c) objA).e();
        } catch (CancellationException e) {
            throw xf.a.a(e);
        }
    }

    public final String toString() {
        return "HttpStatement[" + this.f10750a.f10557a + ']';
    }
}
