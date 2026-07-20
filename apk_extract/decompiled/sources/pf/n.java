package pf;

import k3.ga;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import li.r1;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends SuspendLambda implements Function3 {
    final /* synthetic */ jf.d $this_defaultTransformers;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(jf.d dVar, Continuation<? super n> continuation) {
        super(3, continuation);
        this.$this_defaultTransformers = dVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(hh.f fVar, wf.c cVar, Continuation<? super Unit> continuation) {
        n nVar = new n(this.$this_defaultTransformers, continuation);
        nVar.L$0 = fVar;
        nVar.L$1 = cVar;
        return nVar.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0140 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0141  */
    /* JADX WARN: Code duplicated, block: B:50:0x0191 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0192  */
    /* JADX WARN: Code duplicated, block: B:73:0x0260 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0261  */
    /* JADX WARN: Code duplicated, block: B:77:0x026c  */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x026c, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        hh.f fVar;
        ih.a aVar;
        Object objL;
        hh.f fVar2;
        ih.a aVar2;
        ih.a aVar3;
        hh.f fVar3;
        Object objR;
        Object objL2;
        hh.f fVar4;
        ih.a aVar4;
        Object objF;
        Object objF2;
        Object objF3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        wf.c cVar = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                fVar = (hh.f) this.L$0;
                wf.c cVar2 = (wf.c) this.L$1;
                aVar = cVar2.f10742a;
                Object obj2 = cVar2.f10743b;
                if (!(obj2 instanceof jh.o)) {
                    return Unit.INSTANCE;
                }
                wf.b bVarE = ((kf.c) fVar.f5401a).e();
                KClass kClass = aVar.f5872a;
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Unit.class))) {
                    ga.a((jh.o) obj2);
                    wf.c cVar3 = new wf.c(aVar, Unit.INSTANCE);
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.label = 1;
                    Object objF4 = fVar.f(cVar3, this);
                    if (objF4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    obj = objF4;
                    fVar3 = fVar;
                    cVar = (wf.c) obj;
                    fVar = fVar3;
                    aVar = aVar3;
                } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.L$2 = fVar;
                    this.L$3 = aVar;
                    this.label = 2;
                    objL2 = jh.g0.l((jh.o) obj2, this);
                    if (objL2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fVar4 = fVar;
                    aVar4 = aVar;
                    wi.k kVar = (wi.k) objL2;
                    Intrinsics.checkNotNullParameter(kVar, "<this>");
                    wf.c cVar4 = new wf.c(aVar4, Boxing.boxInt(Integer.parseInt(wi.p.b(kVar))));
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 3;
                    objF = fVar4.f(cVar4, this);
                    if (objF == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    hh.f fVar5 = fVar;
                    obj = objF;
                    fVar3 = fVar5;
                    cVar = (wf.c) obj;
                    fVar = fVar3;
                    aVar = aVar3;
                } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(wi.k.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(wi.k.class))) {
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.L$2 = fVar;
                    this.L$3 = aVar;
                    this.label = 4;
                    objL = jh.g0.l((jh.o) obj2, this);
                    if (objL == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fVar2 = fVar;
                    aVar2 = aVar;
                    wf.c cVar5 = new wf.c(aVar2, objL);
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 5;
                    objF2 = fVar2.f(cVar5, this);
                    if (objF2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    hh.f fVar6 = fVar;
                    obj = objF2;
                    fVar3 = fVar6;
                    cVar = (wf.c) obj;
                    fVar = fVar3;
                    aVar = aVar3;
                } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.label = 6;
                    objR = jh.g0.r((jh.o) obj2, this);
                    if (objR == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    wf.c cVar6 = new wf.c(aVar, (byte[]) objR);
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.label = 7;
                    objF3 = fVar.f(cVar6, this);
                    if (objF3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    hh.f fVar7 = fVar;
                    obj = objF3;
                    fVar3 = fVar7;
                    cVar = (wf.c) obj;
                    fVar = fVar3;
                    aVar = aVar3;
                } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(jh.o.class))) {
                    r1 r1Var = new r1((li.p1) bVarE.getCoroutineContext().get(li.o1.f7483a));
                    jh.y0 y0VarG = jh.o0.g(fVar, this.$this_defaultTransformers.f6258d, false, new m(obj2, bVarE, null), 2);
                    ag.a block = new ag.a(r1Var, 7);
                    Intrinsics.checkNotNullParameter(y0VarG, "<this>");
                    Intrinsics.checkNotNullParameter(block, "block");
                    ((x1) y0VarG.a()).A(new bh.a(1, block));
                    wf.c cVar7 = new wf.c(aVar, y0VarG.f6311a);
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.label = 8;
                    Object objF5 = fVar.f(cVar7, this);
                    if (objF5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    obj = objF5;
                    fVar3 = fVar;
                    cVar = (wf.c) obj;
                    fVar = fVar3;
                    aVar = aVar3;
                } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(zf.z.class))) {
                    ga.a((jh.o) obj2);
                    wf.c cVar8 = new wf.c(aVar, bVarE.h());
                    this.L$0 = fVar;
                    this.L$1 = aVar;
                    this.label = 9;
                    Object objF6 = fVar.f(cVar8, this);
                    if (objF6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    obj = objF6;
                    fVar3 = fVar;
                    cVar = (wf.c) obj;
                    fVar = fVar3;
                    aVar = aVar3;
                }
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 1:
                aVar3 = (ih.a) this.L$1;
                fVar3 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 2:
                ih.a aVar5 = (ih.a) this.L$3;
                hh.f fVar8 = (hh.f) this.L$2;
                ih.a aVar6 = (ih.a) this.L$1;
                hh.f fVar9 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                objL2 = obj;
                fVar = fVar9;
                fVar4 = fVar8;
                aVar = aVar6;
                aVar4 = aVar5;
                wi.k kVar2 = (wi.k) objL2;
                Intrinsics.checkNotNullParameter(kVar2, "<this>");
                wf.c cVar9 = new wf.c(aVar4, Boxing.boxInt(Integer.parseInt(wi.p.b(kVar2))));
                this.L$0 = fVar;
                this.L$1 = aVar;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                objF = fVar4.f(cVar9, this);
                if (objF == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar3 = aVar;
                hh.f fVar10 = fVar;
                obj = objF;
                fVar3 = fVar10;
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 3:
                aVar3 = (ih.a) this.L$1;
                fVar3 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 4:
                ih.a aVar7 = (ih.a) this.L$3;
                hh.f fVar11 = (hh.f) this.L$2;
                aVar = (ih.a) this.L$1;
                hh.f fVar12 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                objL = obj;
                fVar = fVar12;
                fVar2 = fVar11;
                aVar2 = aVar7;
                wf.c cVar10 = new wf.c(aVar2, objL);
                this.L$0 = fVar;
                this.L$1 = aVar;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 5;
                objF2 = fVar2.f(cVar10, this);
                if (objF2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar3 = aVar;
                hh.f fVar13 = fVar;
                obj = objF2;
                fVar3 = fVar13;
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 5:
                aVar3 = (ih.a) this.L$1;
                fVar3 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 6:
                ih.a aVar8 = (ih.a) this.L$1;
                hh.f fVar14 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                aVar = aVar8;
                objR = obj;
                fVar = fVar14;
                wf.c cVar11 = new wf.c(aVar, (byte[]) objR);
                this.L$0 = fVar;
                this.L$1 = aVar;
                this.label = 7;
                objF3 = fVar.f(cVar11, this);
                if (objF3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar3 = aVar;
                hh.f fVar15 = fVar;
                obj = objF3;
                fVar3 = fVar15;
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 7:
                aVar3 = (ih.a) this.L$1;
                fVar3 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 8:
                aVar3 = (ih.a) this.L$1;
                fVar3 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            case 9:
                aVar3 = (ih.a) this.L$1;
                fVar3 = (hh.f) this.L$0;
                ResultKt.throwOnFailure(obj);
                cVar = (wf.c) obj;
                fVar = fVar3;
                aVar = aVar3;
                if (cVar != null) {
                    o.f8860a.trace("Transformed with default transformers response body for " + ((kf.c) fVar.f5401a).d().getUrl() + " to " + aVar.f5872a);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
