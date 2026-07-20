package nf;

import java.util.Map;
import jh.j0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.o2;
import m3.h6;
import m3.k6;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends SuspendLambda implements Function2 {
    final /* synthetic */ CoroutineContext $callContext;
    final /* synthetic */ jh.o $input;
    final /* synthetic */ j0 $originOutput;
    final /* synthetic */ j0 $output;
    final /* synthetic */ boolean $overProxy;
    final /* synthetic */ vf.d $request;
    final /* synthetic */ ch.d $requestTime;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(vf.d dVar, j0 j0Var, boolean z2, ch.d dVar2, jh.o oVar, j0 j0Var2, CoroutineContext coroutineContext, Continuation<? super n> continuation) {
        super(2, continuation);
        this.$request = dVar;
        this.$output = j0Var;
        this.$overProxy = z2;
        this.$requestTime = dVar2;
        this.$input = oVar;
        this.$originOutput = j0Var2;
        this.$callContext = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new n(this.$request, this.$output, this.$overProxy, this.$requestTime, this.$input, this.$originOutput, this.$callContext, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0076 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0083  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:33:0x0104  */
    /* JADX WARN: Code duplicated, block: B:35:0x0113 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0114  */
    /* JADX WARN: Code duplicated, block: B:38:0x0123 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0124  */
    /* JADX WARN: Code duplicated, block: B:41:0x0126  */
    /* JADX WARN: Code duplicated, block: B:43:0x0135 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0152 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0153 A[PHI: r11
      0x0153: PHI (r11v22 java.lang.Object) = (r11v21 java.lang.Object), (r11v0 java.lang.Object) binds: [B:45:0x0150, B:6:0x0011] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        vf.d dVar;
        j0 j0Var;
        CoroutineContext coroutineContext;
        vf.g gVar;
        zf.z zVar;
        j0 j0Var2;
        vf.d dVar2;
        j0 j0Var3;
        CoroutineContext coroutineContext2;
        Object objU;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                vf.d dVar3 = this.$request;
                j0 j0Var4 = this.$output;
                boolean z2 = this.$overProxy;
                this.label = 1;
                if (b0.f(dVar3, j0Var4, z2, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                m mVar = new m(this.$input, null);
                this.label = 2;
                obj = o2.b(1000L, mVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) obj) != null) {
                    ch.d dVar4 = this.$requestTime;
                    vf.d dVar5 = this.$request;
                    jh.o oVar = this.$input;
                    j0 j0Var5 = this.$originOutput;
                    CoroutineContext coroutineContext3 = this.$callContext;
                    this.label = 3;
                    obj = l0.u(coroutineContext3, new v(oVar, j0Var5, coroutineContext3, dVar4, dVar5, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gVar = (vf.g) obj;
                    zVar = gVar.f10573a;
                    if (Intrinsics.areEqual(zVar, zf.z.f11577v)) {
                        vf.c cVar = new vf.c();
                        vf.d request = this.$request;
                        zg.a aVar = vf.e.f10566a;
                        Intrinsics.checkNotNullParameter(cVar, "<this>");
                        Intrinsics.checkNotNullParameter(request, "request");
                        zf.x xVar = request.f10562b;
                        Intrinsics.checkNotNullParameter(xVar, "<set-?>");
                        cVar.f10558b = xVar;
                        cg.j jVar = request.f10564d;
                        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
                        cVar.f10560d = jVar;
                        zg.a aVar2 = vf.i.f10584a;
                        zg.h hVar = cVar.f;
                        cVar.b((ih.a) hVar.d(aVar2));
                        h6.c(cVar.f10557a, request.f10561a);
                        zf.t tVar = request.f10563c;
                        zf.s sVar = cVar.f10559c;
                        sVar.e(tVar);
                        k6.a(hVar, request.f);
                        String[] strArr = zf.v.f11551a;
                        Intrinsics.checkNotNullParameter("Expect", "name");
                        ((Map) sVar.f574b).remove("Expect");
                        vf.d dVarA = cVar.a();
                        j0 j0Var6 = this.$output;
                        CoroutineContext coroutineContext4 = this.$callContext;
                        boolean z3 = this.$overProxy;
                        this.label = 4;
                        objU = l0.u(coroutineContext4, new a0(dVarA, j0Var6, z3, true, coroutineContext4, null), this);
                        if (objU != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            objU = Unit.INSTANCE;
                        }
                        if (objU == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (Intrinsics.areEqual(zVar, zf.z.f11564c)) {
                            j0Var2 = this.$output;
                            this.L$0 = gVar;
                            this.label = 6;
                            if (((jh.k) j0Var2).i(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return gVar;
                        }
                        dVar2 = this.$request;
                        j0Var3 = this.$output;
                        coroutineContext2 = this.$callContext;
                        this.label = 5;
                        if (b0.e(dVar2, j0Var3, coroutineContext2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    dVar = this.$request;
                    j0Var = this.$output;
                    coroutineContext = this.$callContext;
                    this.label = 7;
                    if (b0.e(dVar, j0Var, coroutineContext) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ch.d dVar6 = this.$requestTime;
                vf.d dVar7 = this.$request;
                jh.o oVar2 = this.$input;
                j0 j0Var7 = this.$originOutput;
                CoroutineContext coroutineContext5 = this.$callContext;
                this.label = 8;
                obj = l0.u(coroutineContext5, new v(oVar2, j0Var7, coroutineContext5, dVar6, dVar7, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 1:
                ResultKt.throwOnFailure(obj);
                m mVar2 = new m(this.$input, null);
                this.label = 2;
                obj = o2.b(1000L, mVar2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (((Boolean) obj) != null) {
                    ch.d dVar8 = this.$requestTime;
                    vf.d dVar9 = this.$request;
                    jh.o oVar3 = this.$input;
                    j0 j0Var8 = this.$originOutput;
                    CoroutineContext coroutineContext6 = this.$callContext;
                    this.label = 3;
                    obj = l0.u(coroutineContext6, new v(oVar3, j0Var8, coroutineContext6, dVar8, dVar9, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gVar = (vf.g) obj;
                    zVar = gVar.f10573a;
                    if (Intrinsics.areEqual(zVar, zf.z.f11577v)) {
                        vf.c cVar2 = new vf.c();
                        vf.d request2 = this.$request;
                        zg.a aVar3 = vf.e.f10566a;
                        Intrinsics.checkNotNullParameter(cVar2, "<this>");
                        Intrinsics.checkNotNullParameter(request2, "request");
                        zf.x xVar2 = request2.f10562b;
                        Intrinsics.checkNotNullParameter(xVar2, "<set-?>");
                        cVar2.f10558b = xVar2;
                        cg.j jVar2 = request2.f10564d;
                        Intrinsics.checkNotNullParameter(jVar2, "<set-?>");
                        cVar2.f10560d = jVar2;
                        zg.a aVar4 = vf.i.f10584a;
                        zg.h hVar2 = cVar2.f;
                        cVar2.b((ih.a) hVar2.d(aVar4));
                        h6.c(cVar2.f10557a, request2.f10561a);
                        zf.t tVar2 = request2.f10563c;
                        zf.s sVar2 = cVar2.f10559c;
                        sVar2.e(tVar2);
                        k6.a(hVar2, request2.f);
                        String[] strArr2 = zf.v.f11551a;
                        Intrinsics.checkNotNullParameter("Expect", "name");
                        ((Map) sVar2.f574b).remove("Expect");
                        vf.d dVarA2 = cVar2.a();
                        j0 j0Var9 = this.$output;
                        CoroutineContext coroutineContext7 = this.$callContext;
                        boolean z5 = this.$overProxy;
                        this.label = 4;
                        objU = l0.u(coroutineContext7, new a0(dVarA2, j0Var9, z5, true, coroutineContext7, null), this);
                        if (objU != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            objU = Unit.INSTANCE;
                        }
                        if (objU == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (Intrinsics.areEqual(zVar, zf.z.f11564c)) {
                            j0Var2 = this.$output;
                            this.L$0 = gVar;
                            this.label = 6;
                            if (((jh.k) j0Var2).i(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return gVar;
                        }
                        dVar2 = this.$request;
                        j0Var3 = this.$output;
                        coroutineContext2 = this.$callContext;
                        this.label = 5;
                        if (b0.e(dVar2, j0Var3, coroutineContext2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    dVar = this.$request;
                    j0Var = this.$output;
                    coroutineContext = this.$callContext;
                    this.label = 7;
                    if (b0.e(dVar, j0Var, coroutineContext) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ch.d dVar10 = this.$requestTime;
                vf.d dVar11 = this.$request;
                jh.o oVar4 = this.$input;
                j0 j0Var10 = this.$originOutput;
                CoroutineContext coroutineContext8 = this.$callContext;
                this.label = 8;
                obj = l0.u(coroutineContext8, new v(oVar4, j0Var10, coroutineContext8, dVar10, dVar11, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 2:
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj) != null) {
                    ch.d dVar12 = this.$requestTime;
                    vf.d dVar13 = this.$request;
                    jh.o oVar5 = this.$input;
                    j0 j0Var11 = this.$originOutput;
                    CoroutineContext coroutineContext9 = this.$callContext;
                    this.label = 3;
                    obj = l0.u(coroutineContext9, new v(oVar5, j0Var11, coroutineContext9, dVar12, dVar13, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gVar = (vf.g) obj;
                    zVar = gVar.f10573a;
                    if (Intrinsics.areEqual(zVar, zf.z.f11577v)) {
                        vf.c cVar3 = new vf.c();
                        vf.d request3 = this.$request;
                        zg.a aVar5 = vf.e.f10566a;
                        Intrinsics.checkNotNullParameter(cVar3, "<this>");
                        Intrinsics.checkNotNullParameter(request3, "request");
                        zf.x xVar3 = request3.f10562b;
                        Intrinsics.checkNotNullParameter(xVar3, "<set-?>");
                        cVar3.f10558b = xVar3;
                        cg.j jVar3 = request3.f10564d;
                        Intrinsics.checkNotNullParameter(jVar3, "<set-?>");
                        cVar3.f10560d = jVar3;
                        zg.a aVar6 = vf.i.f10584a;
                        zg.h hVar3 = cVar3.f;
                        cVar3.b((ih.a) hVar3.d(aVar6));
                        h6.c(cVar3.f10557a, request3.f10561a);
                        zf.t tVar3 = request3.f10563c;
                        zf.s sVar3 = cVar3.f10559c;
                        sVar3.e(tVar3);
                        k6.a(hVar3, request3.f);
                        String[] strArr3 = zf.v.f11551a;
                        Intrinsics.checkNotNullParameter("Expect", "name");
                        ((Map) sVar3.f574b).remove("Expect");
                        vf.d dVarA3 = cVar3.a();
                        j0 j0Var12 = this.$output;
                        CoroutineContext coroutineContext10 = this.$callContext;
                        boolean z10 = this.$overProxy;
                        this.label = 4;
                        objU = l0.u(coroutineContext10, new a0(dVarA3, j0Var12, z10, true, coroutineContext10, null), this);
                        if (objU != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            objU = Unit.INSTANCE;
                        }
                        if (objU == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (Intrinsics.areEqual(zVar, zf.z.f11564c)) {
                            j0Var2 = this.$output;
                            this.L$0 = gVar;
                            this.label = 6;
                            if (((jh.k) j0Var2).i(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return gVar;
                        }
                        dVar2 = this.$request;
                        j0Var3 = this.$output;
                        coroutineContext2 = this.$callContext;
                        this.label = 5;
                        if (b0.e(dVar2, j0Var3, coroutineContext2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    dVar = this.$request;
                    j0Var = this.$output;
                    coroutineContext = this.$callContext;
                    this.label = 7;
                    if (b0.e(dVar, j0Var, coroutineContext) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ch.d dVar14 = this.$requestTime;
                vf.d dVar15 = this.$request;
                jh.o oVar6 = this.$input;
                j0 j0Var13 = this.$originOutput;
                CoroutineContext coroutineContext11 = this.$callContext;
                this.label = 8;
                obj = l0.u(coroutineContext11, new v(oVar6, j0Var13, coroutineContext11, dVar14, dVar15, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 3:
                ResultKt.throwOnFailure(obj);
                gVar = (vf.g) obj;
                zVar = gVar.f10573a;
                if (Intrinsics.areEqual(zVar, zf.z.f11577v)) {
                    vf.c cVar4 = new vf.c();
                    vf.d request4 = this.$request;
                    zg.a aVar7 = vf.e.f10566a;
                    Intrinsics.checkNotNullParameter(cVar4, "<this>");
                    Intrinsics.checkNotNullParameter(request4, "request");
                    zf.x xVar4 = request4.f10562b;
                    Intrinsics.checkNotNullParameter(xVar4, "<set-?>");
                    cVar4.f10558b = xVar4;
                    cg.j jVar4 = request4.f10564d;
                    Intrinsics.checkNotNullParameter(jVar4, "<set-?>");
                    cVar4.f10560d = jVar4;
                    zg.a aVar8 = vf.i.f10584a;
                    zg.h hVar4 = cVar4.f;
                    cVar4.b((ih.a) hVar4.d(aVar8));
                    h6.c(cVar4.f10557a, request4.f10561a);
                    zf.t tVar4 = request4.f10563c;
                    zf.s sVar4 = cVar4.f10559c;
                    sVar4.e(tVar4);
                    k6.a(hVar4, request4.f);
                    String[] strArr4 = zf.v.f11551a;
                    Intrinsics.checkNotNullParameter("Expect", "name");
                    ((Map) sVar4.f574b).remove("Expect");
                    vf.d dVarA4 = cVar4.a();
                    j0 j0Var14 = this.$output;
                    CoroutineContext coroutineContext12 = this.$callContext;
                    boolean z11 = this.$overProxy;
                    this.label = 4;
                    objU = l0.u(coroutineContext12, new a0(dVarA4, j0Var14, z11, true, coroutineContext12, null), this);
                    if (objU != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        objU = Unit.INSTANCE;
                    }
                    if (objU == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (Intrinsics.areEqual(zVar, zf.z.f11564c)) {
                        j0Var2 = this.$output;
                        this.L$0 = gVar;
                        this.label = 6;
                        if (((jh.k) j0Var2).i(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return gVar;
                    }
                    dVar2 = this.$request;
                    j0Var3 = this.$output;
                    coroutineContext2 = this.$callContext;
                    this.label = 5;
                    if (b0.e(dVar2, j0Var3, coroutineContext2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ch.d dVar16 = this.$requestTime;
                vf.d dVar17 = this.$request;
                jh.o oVar7 = this.$input;
                j0 j0Var15 = this.$originOutput;
                CoroutineContext coroutineContext13 = this.$callContext;
                this.label = 8;
                obj = l0.u(coroutineContext13, new v(oVar7, j0Var15, coroutineContext13, dVar16, dVar17, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 4:
            case 5:
            case 7:
                ResultKt.throwOnFailure(obj);
                ch.d dVar18 = this.$requestTime;
                vf.d dVar19 = this.$request;
                jh.o oVar8 = this.$input;
                j0 j0Var16 = this.$originOutput;
                CoroutineContext coroutineContext14 = this.$callContext;
                this.label = 8;
                obj = l0.u(coroutineContext14, new v(oVar8, j0Var16, coroutineContext14, dVar18, dVar19, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            case 6:
                vf.g gVar2 = (vf.g) this.L$0;
                ResultKt.throwOnFailure(obj);
                return gVar2;
            case 8:
                ResultKt.throwOnFailure(obj);
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super vf.g> continuation) {
        return ((n) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
