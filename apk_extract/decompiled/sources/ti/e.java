package ti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import li.j;
import li.l;
import li.s2;
import qi.w;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements li.i, f, s2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10227h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "state$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f10228a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10230c;
    private volatile /* synthetic */ Object state$volatile = h.f10233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f10229b = new ArrayList(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10231d = -1;
    public Object e = h.f10236d;

    public e(CoroutineContext coroutineContext) {
        this.f10228a = coroutineContext;
    }

    @Override // li.i
    public final void a(Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            atomicReferenceFieldUpdater = f10227h;
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == h.f10234b) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, h.f10235c));
        ArrayList arrayList = this.f10229b;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a();
        }
        this.e = h.f10236d;
        this.f10229b = null;
    }

    public final Object b(ContinuationImpl continuationImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10227h;
        Object obj = atomicReferenceFieldUpdater.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        c cVar = (c) obj;
        Object obj2 = this.e;
        ArrayList<c> arrayList = this.f10229b;
        if (arrayList != null) {
            for (c cVar2 : arrayList) {
                if (cVar2 != cVar) {
                    cVar2.a();
                }
            }
            atomicReferenceFieldUpdater.set(this, h.f10234b);
            this.e = h.f10236d;
            this.f10229b = null;
        }
        Object objInvoke = cVar.f10222c.invoke(cVar.f10220a, cVar.f10223d, obj2);
        a8.a aVar = h.e;
        Continuation continuation = cVar.e;
        if (cVar.f10223d == aVar) {
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function1) continuation).invoke(continuationImpl);
        }
        Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
        return ((Function2) continuation).invoke(objInvoke, continuationImpl);
    }

    @Override // li.s2
    public final void c(w wVar, int i8) {
        this.f10230c = wVar;
        this.f10231d = i8;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(ContinuationImpl continuationImpl) {
        d dVar;
        if (continuationImpl instanceof d) {
            dVar = (d) continuationImpl;
            int i8 = dVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                dVar.label = i8 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, continuationImpl);
            }
        } else {
            dVar = new d(this, continuationImpl);
        }
        Object objB = dVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = dVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                this = (e) dVar.L$0;
                ResultKt.throwOnFailure(objB);
            } else {
                if (i9 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objB);
            }
        }
        ResultKt.throwOnFailure(objB);
        dVar.L$0 = this;
        dVar.label = 1;
        l lVar = new l(1, IntrinsicsKt.intercepted(dVar));
        lVar.s();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10227h;
            Object obj = atomicReferenceFieldUpdater.get(this);
            a8.a aVar = h.f10233a;
            if (obj == aVar) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lVar)) {
                    lVar.w(this);
                    break;
                }
            } else {
                if (!(obj instanceof List)) {
                    if (!(obj instanceof c)) {
                        throw new IllegalStateException(("unexpected state: " + obj).toString());
                    }
                    Unit unit = Unit.INSTANCE;
                    c cVar = (c) obj;
                    Object obj2 = this.e;
                    Function3 function3 = cVar.f;
                    lVar.p(unit, function3 != null ? (Function3) function3.invoke(this, cVar.f10223d, obj2) : null);
                    break;
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, aVar)) {
                    Iterator it = ((Iterable) obj).iterator();
                    while (it.hasNext()) {
                        c cVarE = e(it.next());
                        Intrinsics.checkNotNull(cVarE);
                        cVarE.f10224g = null;
                        cVarE.f10225h = -1;
                        f(cVarE, true);
                    }
                }
            }
        }
        Object objR = lVar.r();
        if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(dVar);
        }
        if (objR != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objR = Unit.INSTANCE;
        }
        if (objR == coroutine_suspended) {
            return coroutine_suspended;
        }
        dVar.L$0 = null;
        dVar.label = 2;
        objB = this.b(dVar);
        return objB == coroutine_suspended ? coroutine_suspended : objB;
    }

    public final c e(Object obj) {
        ArrayList arrayList = this.f10229b;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        for (Object obj3 : arrayList) {
            if (((c) obj3).f10220a == obj) {
                obj2 = obj3;
                break;
            }
        }
        c cVar = (c) obj2;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final void f(c cVar, boolean z2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10227h;
        if (atomicReferenceFieldUpdater.get(this) instanceof c) {
            return;
        }
        Object obj = cVar.f10220a;
        if (!z2) {
            ArrayList arrayList = this.f10229b;
            Intrinsics.checkNotNull(arrayList);
            if (arrayList == null || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((c) it.next()).f10220a == obj) {
                        throw new IllegalStateException(a1.a.p(obj, "Cannot use select clauses on the same object: ").toString());
                    }
                }
            }
        }
        cVar.f10221b.invoke(obj, this, cVar.f10223d);
        if (this.e != h.f10236d) {
            atomicReferenceFieldUpdater.set(this, cVar);
            return;
        }
        if (!z2) {
            ArrayList arrayList2 = this.f10229b;
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.add(cVar);
        }
        cVar.f10224g = this.f10230c;
        cVar.f10225h = this.f10231d;
        this.f10230c = null;
        this.f10231d = -1;
    }

    public final int g(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10227h;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof j) {
                c cVarE = e(obj);
                if (cVarE != null) {
                    Function3 function3 = cVarE.f;
                    Function3 function4 = function3 != null ? (Function3) function3.invoke(this, cVarE.f10223d, obj2) : null;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, cVarE)) {
                        j jVar = (j) obj3;
                        this.e = obj2;
                        a8.a aVarD = jVar.d(Unit.INSTANCE, function4);
                        if (aVarD == null) {
                            this.e = h.f10236d;
                            return 2;
                        }
                        jVar.u(aVarD);
                        return 0;
                    }
                } else {
                    continue;
                }
            } else {
                if (Intrinsics.areEqual(obj3, h.f10234b) || (obj3 instanceof c)) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj3, h.f10235c)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj3, h.f10233a)) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, CollectionsKt.listOf(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, CollectionsKt.plus((Collection<? extends Object>) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }
}
