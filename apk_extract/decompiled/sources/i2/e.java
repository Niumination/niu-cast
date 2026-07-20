package i2;

import af.r5;
import android.app.job.JobParameters;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zak;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import df.m;
import j3.y;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import k3.be;
import k3.ja;
import k3.la;
import k3.wa;
import k3.yd;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import li.a0;
import li.d0;
import li.i1;
import mg.b0;
import o4.p;
import o4.r;
import o4.s;
import p5.k;
import r2.t;
import u2.l;
import u2.w;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5540c;

    public /* synthetic */ e(int i8, Object obj, Object obj2) {
        this.f5538a = i8;
        this.f5539b = obj;
        this.f5540c = obj2;
    }

    private final void a() {
        synchronized (((q3.i) this.f5540c).f8954b) {
            try {
                q3.c cVar = (q3.c) ((q3.i) this.f5540c).f8956d;
                if (cVar != null) {
                    Exception excA = ((q3.f) this.f5539b).a();
                    l.e(excA);
                    cVar.b(excA);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void b() {
        synchronized (((q3.i) this.f5540c).f8954b) {
            try {
                q3.d dVar = (q3.d) ((q3.i) this.f5540c).f8956d;
                if (dVar != null) {
                    dVar.onSuccess(((q3.f) this.f5539b).b());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    @Override // java.lang.Runnable
    public final void run() {
        r rVar;
        u2.c cVar;
        Set set;
        u2.c wVar = null;
        int i8 = 0;
        switch (this.f5538a) {
            case 0:
                int i9 = JobInfoSchedulerService.f1772a;
                ((JobInfoSchedulerService) this.f5539b).jobFinished((JobParameters) this.f5540c, false);
                return;
            case 1:
                ((li.l) this.f5540c).C((i1) this.f5539b, Unit.INSTANCE);
                return;
            case 2:
                ((li.l) this.f5539b).C((mi.c) this.f5540c, Unit.INSTANCE);
                return;
            case 3:
                s sVar = (s) this.f5539b;
                u4.a aVar = (u4.a) this.f5540c;
                if (sVar.f8399b != o4.f.f8377c) {
                    throw new IllegalStateException("provide() can be called only once.");
                }
                synchronized (sVar) {
                    rVar = sVar.f8398a;
                    sVar.f8398a = null;
                    sVar.f8399b = aVar;
                    break;
                }
                rVar.getClass();
                return;
            case 4:
                p pVar = (p) this.f5539b;
                u4.a aVar2 = (u4.a) this.f5540c;
                synchronized (pVar) {
                    try {
                        if (pVar.f8396b == null) {
                            pVar.f8395a.add(aVar2);
                        } else {
                            pVar.f8396b.add(aVar2.get());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            case 5:
                ReferenceQueue referenceQueue = (ReferenceQueue) this.f5539b;
                while (!((Set) this.f5540c).isEmpty()) {
                    try {
                        k kVar = (k) referenceQueue.remove();
                        if (kVar.f8687a.remove(kVar)) {
                            kVar.clear();
                            kVar.f8688b.getClass();
                        }
                    } catch (InterruptedException unused) {
                    }
                }
                return;
            case 6:
                Callable callable = (Callable) this.f5539b;
                q3.k kVar2 = ((q3.g) this.f5540c).f8950a;
                try {
                    kVar2.g(callable.call());
                    return;
                } catch (l5.a e) {
                    kVar2.f(e);
                    return;
                } catch (Exception e4) {
                    kVar2.f(new l5.a("Internal error has occurred when executing ML Kit tasks", 13, e4));
                    return;
                }
            case 7:
                v5.f fVar = (v5.f) this.f5539b;
                q3.g gVar = (q3.g) this.f5540c;
                int iDecrementAndGet = fVar.f10514b.decrementAndGet();
                if (iDecrementAndGet < 0) {
                    throw new IllegalStateException();
                }
                if (iDecrementAndGet == 0) {
                    synchronized (fVar) {
                        try {
                            fVar.e.f();
                            v5.f.f10512j = true;
                            be beVar = fVar.f;
                            d2.a aVar3 = new d2.a();
                            aVar3.f4259c = fVar.f10519i ? ja.TYPE_THICK : ja.TYPE_THIN;
                            r5 r5Var = new r5(6, i8);
                            r5Var.f558c = v5.a.a(fVar.f10516d);
                            aVar3.f4260d = new wa(r5Var);
                            p5.l.INSTANCE.execute(new yd(beVar, new m(aVar3, 0), la.ON_DEVICE_BARCODE_CLOSE, beVar.c(), 0));
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    fVar.f10515c.set(false);
                }
                j3.r.f6082a.clear();
                y.f6091a.clear();
                gVar.f8950a.g(null);
                return;
            case 8:
                Runnable runnable = (Runnable) this.f5540c;
                o6.a aVar4 = (o6.a) this.f5539b;
                AtomicReference atomicReference = (AtomicReference) aVar4.e;
                AtomicReference atomicReference2 = (AtomicReference) aVar4.e;
                if (((Thread) atomicReference.getAndSet(Thread.currentThread())) != null) {
                    throw new IllegalStateException();
                }
                try {
                    runnable.run();
                    atomicReference2.set(null);
                    aVar4.k();
                    return;
                } catch (Throwable th4) {
                    try {
                        atomicReference2.set(null);
                        aVar4.k();
                        break;
                    } catch (Throwable th5) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th4, th5);
                            break;
                        } catch (Exception unused2) {
                        }
                    }
                    throw th4;
                }
            case 9:
                synchronized (((q3.i) this.f5540c).f8954b) {
                    try {
                        q3.b bVar = (q3.b) ((q3.i) this.f5540c).f8956d;
                        if (bVar != null) {
                            bVar.a((q3.f) this.f5539b);
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                    break;
                }
                return;
            case 10:
                a();
                return;
            case 11:
                b();
                return;
            case 12:
                break;
            case 13:
                b0 b0Var = (b0) this.f5540c;
                r2.l lVar = (r2.l) ((r2.c) b0Var.f).f9331l.get((r2.a) b0Var.f8048c);
                if (lVar == null) {
                    return;
                }
                ConnectionResult connectionResult = (ConnectionResult) this.f5539b;
                if ((connectionResult.f1798b == 0 ? 1 : 0) == 0) {
                    lVar.n(connectionResult, null);
                    return;
                }
                b0Var.f8046a = true;
                q2.c cVar2 = (q2.c) b0Var.f8047b;
                if (cVar2.e()) {
                    if (!b0Var.f8046a || (cVar = (u2.c) b0Var.f8049d) == null) {
                        return;
                    }
                    cVar2.d(cVar, (Set) b0Var.e);
                    return;
                }
                try {
                    cVar2.d(null, cVar2.f());
                    return;
                } catch (SecurityException e10) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
                    cVar2.disconnect("Failed to get service from broker.");
                    lVar.n(new ConnectionResult(10), null);
                    return;
                }
            case 14:
                zak zakVar = (zak) this.f5539b;
                ConnectionResult connectionResult2 = zakVar.f2212b;
                Object[] objArr = connectionResult2.f1798b == 0 ? 1 : 0;
                t tVar = (t) this.f5540c;
                if (objArr != 0) {
                    zav zavVar = zakVar.f2213c;
                    l.e(zavVar);
                    ConnectionResult connectionResult3 = zavVar.f1901c;
                    if (connectionResult3.f1798b != 0) {
                        Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult3)), new Exception());
                        tVar.f9370i.b(connectionResult3);
                        tVar.f9369h.disconnect();
                        return;
                    }
                    b0 b0Var2 = tVar.f9370i;
                    IBinder iBinder = zavVar.f1900b;
                    if (iBinder != null) {
                        int i10 = u2.a.f10327c;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                        wVar = iInterfaceQueryLocalInterface instanceof u2.c ? (u2.c) iInterfaceQueryLocalInterface : new w(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                    }
                    b0Var2.getClass();
                    if (wVar == null || (set = tVar.f) == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        b0Var2.b(new ConnectionResult(4));
                    } else {
                        b0Var2.f8049d = wVar;
                        b0Var2.e = set;
                        if (b0Var2.f8046a) {
                            ((q2.c) b0Var2.f8047b).d(wVar, set);
                        }
                    }
                } else {
                    tVar.f9370i.b(connectionResult2);
                }
                tVar.f9369h.disconnect();
                return;
            case 15:
                RecyclerView recyclerView = (RecyclerView) this.f5539b;
                int iComputeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
                OSScrollbarLayout oSScrollbarLayout = (OSScrollbarLayout) this.f5540c;
                if (oSScrollbarLayout.f3223i == iComputeVerticalScrollRange) {
                    return;
                }
                oSScrollbarLayout.f3223i = iComputeVerticalScrollRange;
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                oSScrollbarLayout.f3235x = 0;
                oSScrollbarLayout.i(recyclerView, oSScrollbarLayout.f3223i, iComputeVerticalScrollOffset);
                oSScrollbarLayout.f();
                return;
            case 16:
                OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) this.f5539b;
                int iComputeVerticalScrollRange2 = overBoundNestedScrollView.computeVerticalScrollRange();
                OSScrollbarLayout oSScrollbarLayout2 = (OSScrollbarLayout) this.f5540c;
                if (oSScrollbarLayout2.f3223i == iComputeVerticalScrollRange2) {
                    return;
                }
                oSScrollbarLayout2.f3223i = iComputeVerticalScrollRange2;
                oSScrollbarLayout2.f3235x = 0;
                oSScrollbarLayout2.i(overBoundNestedScrollView, iComputeVerticalScrollRange2, overBoundNestedScrollView.computeVerticalScrollOffset());
                oSScrollbarLayout2.f();
                return;
            case 17:
                ((ti.e) ((ti.f) this.f5539b)).g((ti.b) this.f5540c, Unit.INSTANCE);
                return;
            default:
                Continuation continuationIntercepted = IntrinsicsKt.intercepted((zj.r) this.f5539b);
                Result.Companion companion = Result.INSTANCE;
                continuationIntercepted.resumeWith(Result.m159constructorimpl(ResultKt.createFailure((Exception) this.f5540c)));
                return;
        }
        while (true) {
            try {
                ((Runnable) this.f5539b).run();
            } catch (Throwable th7) {
                d0.a(EmptyCoroutineContext.INSTANCE, th7);
            }
            qi.i iVar = (qi.i) this.f5540c;
            Runnable runnableI = iVar.i();
            if (runnableI == null) {
                return;
            }
            this.f5539b = runnableI;
            i8++;
            if (i8 >= 16) {
                a0 a0Var = iVar.f9148b;
                if (a0Var.isDispatchNeeded(iVar)) {
                    a0Var.dispatch(iVar, this);
                    return;
                }
            }
        }
    }

    public /* synthetic */ e(Object obj, int i8, Object obj2, boolean z2) {
        this.f5538a = i8;
        this.f5540c = obj;
        this.f5539b = obj2;
    }
}
