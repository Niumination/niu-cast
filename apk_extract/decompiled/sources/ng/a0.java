package ng;

import ag.p0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jh.g0;
import jh.j0;
import jh.o0;
import k3.ga;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.j1;
import li.l0;
import li.p1;
import li.p2;
import li.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends qg.s {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f8236r = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j0 f8237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jh.o f8238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final li.a0 f8239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final li.q f8240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zf.z f8241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final zf.s f8242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public jh.k f8243o;
    public g2 p;
    public final ka.d q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(b call, j0 output, jh.o input, li.a0 engineDispatcher, li.a0 userDispatcher, li.q qVar) {
        super(call);
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(engineDispatcher, "engineDispatcher");
        Intrinsics.checkNotNullParameter(userDispatcher, "userDispatcher");
        this.f8237i = output;
        this.f8238j = input;
        this.f8239k = engineDispatcher;
        this.f8240l = qVar;
        this.f8241m = zf.z.e;
        this.f8242n = new zf.s();
        ka.d dVar = new ka.d();
        dVar.f6817b = this;
        dVar.f6816a = SetsKt.emptySet();
        this.q = dVar;
    }

    @Override // wg.a
    public final ka.d a() {
        return this.q;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // qg.s
    public final Object h(byte[] bArr, ContinuationImpl continuationImpl) {
        t tVar;
        if (continuationImpl instanceof t) {
            tVar = (t) continuationImpl;
            int i8 = tVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                tVar.label = i8 - Integer.MIN_VALUE;
            } else {
                tVar = new t(this, continuationImpl);
            }
        } else {
            tVar = new t(this, continuationImpl);
        }
        Object obj = tVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = tVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                bArr = (byte[]) tVar.L$1;
                this = (a0) tVar.L$0;
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
        tVar.L$0 = this;
        tVar.L$1 = bArr;
        tVar.label = 1;
        if (p(true, tVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        j0 j0VarO = this.o();
        p2 p2Var = v0.f7500c;
        u uVar = new u(j0VarO, bArr, null);
        tVar.L$0 = null;
        tVar.L$1 = null;
        tVar.label = 2;
        if (l0.u(p2Var, uVar, tVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // qg.s
    public final Object j(ContinuationImpl continuationImpl) {
        v vVar;
        if (continuationImpl instanceof v) {
            vVar = (v) continuationImpl;
            int i8 = vVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                vVar.label = i8 - Integer.MIN_VALUE;
            } else {
                vVar = new v(this, continuationImpl);
            }
        } else {
            vVar = new v(this, continuationImpl);
        }
        Object obj = vVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = vVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                this = (a0) vVar.L$0;
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
        vVar.L$0 = this;
        vVar.label = 1;
        if (p(true, vVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        j0 j0Var = this.f8237i;
        vVar.L$0 = null;
        vVar.label = 2;
        if (((jh.k) j0Var).i(vVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // qg.s
    public final Object k(cg.j jVar, ContinuationImpl continuationImpl) {
        w wVar;
        g2 g2Var;
        if (continuationImpl instanceof w) {
            wVar = (w) continuationImpl;
            int i8 = wVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                wVar.label = i8 - Integer.MIN_VALUE;
            } else {
                wVar = new w(this, continuationImpl);
            }
        } else {
            wVar = new w(this, continuationImpl);
        }
        Object obj = wVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = wVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                this = (a0) wVar.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i9 == 2) {
                this = (a0) wVar.L$0;
                ResultKt.throwOnFailure(obj);
                g2Var = this.p;
                if (g2Var != null) {
                    return Unit.INSTANCE;
                }
                wVar.L$0 = null;
                wVar.label = 3;
                if (g2Var.S(wVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        boolean z2 = jVar instanceof cg.h;
        li.q qVar = this.f8240l;
        if (z2) {
            if (qVar == null) {
                throw new IllegalStateException("Unable to perform upgrade as it is not requested by the client: request should have Upgrade and Connection headers filled properly");
            }
            Boxing.boxBoolean(((li.r) qVar).d0(Boxing.boxBoolean(true)));
        } else if (qVar != null) {
            Boxing.boxBoolean(((li.r) qVar).d0(Boxing.boxBoolean(false)));
        }
        wVar.L$0 = this;
        wVar.label = 1;
        if (qg.s.l(this, jVar, wVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        jh.k kVar = this.f8243o;
        if (kVar != null) {
            wVar.L$0 = this;
            wVar.label = 2;
            if (kVar.i(wVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        g2Var = this.p;
        if (g2Var != null) {
            return Unit.INSTANCE;
        }
        wVar.L$0 = null;
        wVar.label = 3;
        if (g2Var.S(wVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // qg.s
    public final Object m(cg.h hVar, ContinuationImpl continuationImpl) throws Throwable {
        x xVar;
        a0 a0Var;
        Throwable th2;
        j0 j0Var;
        if (continuationImpl instanceof x) {
            xVar = (x) continuationImpl;
            int i8 = xVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                xVar.label = i8 - Integer.MIN_VALUE;
            } else {
                xVar = new x(this, continuationImpl);
            }
        } else {
            xVar = new x(this, continuationImpl);
        }
        Object objE = xVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = xVar.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    hVar = (cg.h) xVar.L$1;
                    this = (a0) xVar.L$0;
                    ResultKt.throwOnFailure(objE);
                } else if (i9 == 2) {
                    this = (a0) xVar.L$0;
                    ResultKt.throwOnFailure(objE);
                    xVar.L$0 = this;
                    xVar.label = 3;
                    if (((p1) objE).S(xVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j0Var = this.f8237i;
                    xVar.L$0 = this;
                    xVar.label = 4;
                    if (((jh.k) j0Var).i(xVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i9 == 3) {
                    this = (a0) xVar.L$0;
                    ResultKt.throwOnFailure(objE);
                    j0Var = this.f8237i;
                    xVar.L$0 = this;
                    xVar.label = 4;
                    if (((jh.k) j0Var).i(xVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i9 != 4) {
                        if (i9 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th2 = (Throwable) xVar.L$1;
                        a0Var = (a0) xVar.L$0;
                        ResultKt.throwOnFailure(objE);
                        ga.a(a0Var.f8238j);
                        throw th2;
                    }
                    this = (a0) xVar.L$0;
                    ResultKt.throwOnFailure(objE);
                }
                ga.a(this.f8238j);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objE);
            xVar.L$0 = this;
            xVar.L$1 = hVar;
            xVar.label = 1;
            if (p(false, xVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            jh.o oVar = this.f8238j;
            j0 j0Var2 = this.f8237i;
            li.a0 a0Var2 = this.f8239k;
            xVar.L$0 = this;
            xVar.L$1 = null;
            xVar.label = 2;
            objE = hVar.e(oVar, j0Var2, a0Var2, xVar);
            if (objE == coroutine_suspended) {
                return coroutine_suspended;
            }
            xVar.L$0 = this;
            xVar.label = 3;
            if (((p1) objE).S(xVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j0Var = this.f8237i;
            xVar.L$0 = this;
            xVar.label = 4;
            if (((jh.k) j0Var).i(xVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ga.a(this.f8238j);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            a0Var = this;
            th2 = th3;
            j0 j0Var3 = a0Var.f8237i;
            xVar.L$0 = a0Var;
            xVar.L$1 = th2;
            xVar.label = 5;
            if (((jh.k) j0Var3).i(xVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // qg.s
    public final Object n(ContinuationImpl continuationImpl) {
        y yVar;
        if (continuationImpl instanceof y) {
            yVar = (y) continuationImpl;
            int i8 = yVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                yVar.label = i8 - Integer.MIN_VALUE;
            } else {
                yVar = new y(this, continuationImpl);
            }
        } else {
            yVar = new y(this, continuationImpl);
        }
        Object obj = yVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = yVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            yVar.L$0 = this;
            yVar.label = 1;
            if (p(false, yVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (a0) yVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return this.o();
    }

    public final j0 o() {
        String[] strArr = zf.v.f11551a;
        boolean zAreEqual = Intrinsics.areEqual(this.q.c("Transfer-Encoding"), "chunked");
        j0 output = this.f8237i;
        if (!zAreEqual) {
            return output;
        }
        p2 coroutineContext = v0.f7500c;
        ag.k kVar = ag.p.f777a;
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        ag.m block = new ag.m(output, null);
        j1 j1Var = j1.f7459a;
        Intrinsics.checkNotNullParameter(j1Var, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        jh.v0 v0VarP = g0.p(j1Var, coroutineContext, new jh.k(false), block);
        jh.k kVar2 = v0VarP.f6306a;
        this.f8243o = kVar2;
        this.p = v0VarP.f6307b;
        return kVar2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object p(boolean z2, ContinuationImpl continuationImpl) throws Throwable {
        z zVar;
        a0 a0Var;
        p0 p0Var;
        zf.s sVar = this.f8242n;
        if (continuationImpl instanceof z) {
            zVar = (z) continuationImpl;
            int i8 = zVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                zVar.label = i8 - Integer.MIN_VALUE;
            } else {
                zVar = new z(this, continuationImpl);
            }
        } else {
            zVar = new z(this, continuationImpl);
        }
        Object obj = zVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = zVar.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    z2 = zVar.Z$0;
                    p0Var = (p0) zVar.L$1;
                    a0 a0Var2 = (a0) zVar.L$0;
                    ResultKt.throwOnFailure(obj);
                    a0Var = a0Var2;
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p0Var = (p0) zVar.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                p0Var.getClass();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            p0 p0Var2 = new p0();
            try {
                zf.z zVar2 = this.f8241m;
                p0Var2.d(zVar2.f11581a, "HTTP/1.1", zVar2.f11582b);
                try {
                    for (String str : ((Map) sVar.f574b).keySet()) {
                        List listB = sVar.b(str);
                        Intrinsics.checkNotNull(listB);
                        Iterator it = listB.iterator();
                        while (it.hasNext()) {
                            p0Var2.b(str, (String) it.next());
                        }
                    }
                    p0Var2.a();
                    j0 j0Var = this.f8237i;
                    try {
                        wi.a aVar = p0Var2.f780a;
                        Intrinsics.checkNotNullParameter(aVar, "<this>");
                        zVar.L$0 = this;
                        zVar.L$1 = p0Var2;
                        zVar.Z$0 = z2;
                        zVar.label = 1;
                        if (o0.e(j0Var, aVar, zVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        a0Var = this;
                        p0Var = p0Var2;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        this = p0Var2;
                        this.getClass();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
            if (!z2) {
                j0 j0Var2 = a0Var.f8237i;
                zVar.L$0 = p0Var;
                zVar.L$1 = null;
                zVar.label = 2;
                if (((jh.k) j0Var2).h(zVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            p0Var.getClass();
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
