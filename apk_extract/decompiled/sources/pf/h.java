package pf;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends SuspendLambda implements Function2 {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public h(Continuation<? super h> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        h hVar = new h(continuation);
        hVar.L$0 = obj;
        return hVar;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        wf.b bVar;
        int i8;
        Object objA;
        wf.b bVarE;
        wf.b bVar2;
        int i9;
        wf.b bVar3;
        String str;
        Throwable j1Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                ResultKt.throwOnFailure(obj);
                bVar = (wf.b) this.L$0;
                if (!((Boolean) bVar.b().i().b(d0.f8837c)).booleanValue()) {
                    i.f8848b.trace("Skipping default response validation for " + bVar.b().d().getUrl());
                    return Unit.INSTANCE;
                }
                i8 = bVar.h().f11581a;
                kf.c cVarB = bVar.b();
                if (i8 >= 300) {
                    zg.h hVarI = cVarB.i();
                    zg.a key = i.f8847a;
                    hVarI.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    if (!hVarI.c().containsKey(key)) {
                        this.L$0 = bVar;
                        this.I$0 = i8;
                        this.label = 1;
                        objA = kf.f.a(cVarB, this);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i9 = this.I$0;
                bVar3 = (wf.b) this.L$1;
                bVar2 = (wf.b) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    str = (String) obj;
                } catch (kh.a unused) {
                    str = "<body failed decoding>";
                }
                if (300 > i9 && i9 < 400) {
                    j1Var = new g1(bVar3, str);
                } else if (400 > i9 && i9 < 500) {
                    j1Var = new g(bVar3, str);
                } else if (500 <= i9 || i9 >= 600) {
                    j1Var = new j1(bVar3, str);
                } else {
                    j1Var = new n1(bVar3, str);
                }
                i.f8848b.trace("Default response validation for " + bVar2.b().d().getUrl() + " failed with " + j1Var);
                throw j1Var;
            }
            i8 = this.I$0;
            wf.b bVar4 = (wf.b) this.L$0;
            ResultKt.throwOnFailure(obj);
            objA = obj;
            bVar = bVar4;
            this.L$0 = bVar;
            this.L$1 = bVarE;
            this.I$0 = i8;
            this.label = 2;
            Object objA2 = wf.e.a(bVarE, Charsets.UTF_8, this);
            if (objA2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            i9 = i8;
            bVar3 = bVarE;
            wf.b bVar5 = bVar;
            obj = objA2;
            bVar2 = bVar5;
            str = (String) obj;
            if (300 > i9) {
                if (400 > i9) {
                    if (500 <= i9) {
                        j1Var = new j1(bVar3, str);
                    } else {
                        j1Var = new j1(bVar3, str);
                    }
                } else if (500 <= i9) {
                    j1Var = new j1(bVar3, str);
                } else {
                    j1Var = new j1(bVar3, str);
                }
            } else if (400 > i9) {
                if (500 <= i9) {
                    j1Var = new j1(bVar3, str);
                } else {
                    j1Var = new j1(bVar3, str);
                }
            } else if (500 <= i9) {
                j1Var = new j1(bVar3, str);
            } else {
                j1Var = new j1(bVar3, str);
            }
            i.f8848b.trace("Default response validation for " + bVar2.b().d().getUrl() + " failed with " + j1Var);
            throw j1Var;
        } catch (kh.a unused2) {
            bVar2 = bVar;
            i9 = i8;
            bVar3 = bVarE;
            str = "<body failed decoding>";
        }
        kf.c cVar = (kf.c) objA;
        cVar.i().e(i.f8847a, Unit.INSTANCE);
        bVarE = cVar.e();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(wf.b bVar, Continuation<? super Unit> continuation) {
        return ((h) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
