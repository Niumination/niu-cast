package ni;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8291a = o.p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public li.l f8292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f8293c;

    public f(m mVar) {
        this.f8293c = mVar;
    }

    public static final void a(f fVar) {
        li.l lVar = fVar.f8292b;
        Intrinsics.checkNotNull(lVar);
        fVar.f8292b = null;
        fVar.f8291a = o.f8315l;
        Throwable thO = fVar.f8293c.o();
        if (thO == null) {
            Result.Companion companion = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(Boolean.FALSE));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(thO)));
        }
    }

    public final Object b(ContinuationImpl continuationImpl) throws Throwable {
        boolean z2;
        v vVar;
        Boolean boolBoxBoolean;
        v vVar2;
        Object obj = this.f8291a;
        if (obj != o.p && obj != o.f8315l) {
            z2 = true;
            break;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f8299k;
        m mVar = this.f8293c;
        v vVar3 = (v) atomicReferenceFieldUpdater.get(mVar);
        while (true) {
            if (mVar.w()) {
                this.f8291a = o.f8315l;
                Throwable thO = mVar.o();
                if (thO == null) {
                    z2 = false;
                    break;
                }
                int i8 = qi.x.f9171a;
                throw thO;
            }
            long andIncrement = m.e.getAndIncrement(mVar);
            long j8 = o.f8307b;
            long j10 = andIncrement / j8;
            int i9 = (int) (andIncrement % j8);
            if (vVar3.f9170c != j10) {
                v vVarM = mVar.m(j10, vVar3);
                if (vVarM == null) {
                    continue;
                } else {
                    vVar = vVarM;
                }
            } else {
                vVar = vVar3;
            }
            Object objI = mVar.I(vVar, i9, andIncrement, null);
            a8.a aVar = o.f8316m;
            if (objI == aVar) {
                throw new IllegalStateException("unreachable");
            }
            a8.a aVar2 = o.f8318o;
            if (objI != aVar2) {
                if (objI != o.f8317n) {
                    vVar.b();
                    this.f8291a = objI;
                    z2 = true;
                    break;
                }
                m mVar2 = this.f8293c;
                li.l lVarL = l0.l(IntrinsicsKt.intercepted(continuationImpl));
                try {
                    this.f8292b = lVarL;
                    qi.w wVar = vVar;
                    Object objI2 = mVar2.I(vVar, i9, andIncrement, this);
                    if (objI2 != aVar) {
                        d dVar = null;
                        Function1 function1 = mVar2.f8304b;
                        if (objI2 == aVar2) {
                            if (andIncrement < mVar2.t()) {
                                wVar.b();
                            }
                            v vVar4 = (v) m.f8299k.get(mVar2);
                            while (true) {
                                if (mVar2.w()) {
                                    a(this);
                                    break;
                                }
                                long andIncrement2 = m.e.getAndIncrement(mVar2);
                                long j11 = o.f8307b;
                                long j12 = andIncrement2 / j11;
                                int i10 = (int) (andIncrement2 % j11);
                                if (vVar4.f9170c != j12) {
                                    v vVarM2 = mVar2.m(j12, vVar4);
                                    if (vVarM2 != null) {
                                        vVar2 = vVarM2;
                                    }
                                } else {
                                    vVar2 = vVar4;
                                }
                                v vVar5 = vVar2;
                                Object objI3 = mVar2.I(vVar2, i10, andIncrement2, this);
                                if (objI3 == o.f8316m) {
                                    c(vVar5, i10);
                                    break;
                                }
                                if (objI3 == o.f8318o) {
                                    if (andIncrement2 < mVar2.t()) {
                                        vVar5.b();
                                    }
                                    vVar4 = vVar5;
                                } else {
                                    if (objI3 == o.f8317n) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    vVar5.b();
                                    this.f8291a = objI3;
                                    this.f8292b = null;
                                    boolBoxBoolean = Boxing.boxBoolean(true);
                                    if (function1 != null) {
                                        dVar = new d(0, function1, objI3);
                                    }
                                }
                            }
                        } else {
                            wVar.b();
                            this.f8291a = objI2;
                            this.f8292b = null;
                            boolBoxBoolean = Boxing.boxBoolean(true);
                            if (function1 != null) {
                                dVar = new d(0, function1, objI2);
                            }
                        }
                        lVarL.p(boolBoxBoolean, dVar);
                        break;
                    }
                    c(wVar, i9);
                    Object objR = lVarL.r();
                    if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuationImpl);
                    }
                    return objR;
                } catch (Throwable th2) {
                    lVarL.A();
                    throw th2;
                }
            }
            if (andIncrement < mVar.t()) {
                vVar.b();
            }
            vVar3 = vVar;
        }
        return Boxing.boxBoolean(z2);
    }

    @Override // li.s2
    public final void c(qi.w wVar, int i8) {
        li.l lVar = this.f8292b;
        if (lVar != null) {
            lVar.c(wVar, i8);
        }
    }

    public final Object d() throws Throwable {
        Object obj = this.f8291a;
        a8.a aVar = o.p;
        if (obj == aVar) {
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
        this.f8291a = aVar;
        if (obj != o.f8315l) {
            return obj;
        }
        Throwable thP = this.f8293c.p();
        int i8 = qi.x.f9171a;
        throw thP;
    }
}
