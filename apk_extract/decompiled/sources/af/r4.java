package af;

import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f554d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f555h;

    public /* synthetic */ r4(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i8) {
        this.f551a = i8;
        this.f552b = obj;
        this.f553c = obj2;
        this.f554d = obj3;
        this.e = obj4;
        this.f555h = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ze.q2 q2Var = null;
        switch (this.f551a) {
            case 0:
                for (e5 e5Var : (Collection) this.f552b) {
                    if (e5Var != ((e5) this.f553c)) {
                        e5Var.f245a.h(x2.G);
                    }
                }
                Future future = (Future) this.f554d;
                if (future != null) {
                    future.cancel(false);
                }
                Future future2 = (Future) this.e;
                if (future2 != null) {
                    future2.cancel(false);
                }
                x2 x2Var = (x2) this.f555h;
                r rVar = ((j3) x2Var.D.f375b).E;
                synchronized (rVar.f538a) {
                    try {
                        ((HashSet) rVar.f539b).remove(x2Var);
                        if (((HashSet) rVar.f539b).isEmpty()) {
                            q2Var = (ze.q2) rVar.f540c;
                            rVar.f539b = new HashSet();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                if (q2Var != null) {
                    ((j3) rVar.f541d).D.c(q2Var);
                    return;
                }
                return;
            case 1:
                v5.f fVar = (v5.f) this.f552b;
                o5.c cVar = (o5.c) this.f553c;
                tj.w wVar = (tj.w) this.f554d;
                Callable callable = (Callable) this.e;
                q3.g gVar = (q3.g) this.f555h;
                fVar.getClass();
                try {
                    if (((q3.k) cVar.f8405a).c()) {
                        wVar.o();
                        return;
                    }
                    try {
                        if (!fVar.f10515c.get()) {
                            synchronized (fVar) {
                                fVar.f10519i = fVar.e.c();
                            }
                            fVar.f10515c.set(true);
                        }
                        if (((q3.k) cVar.f8405a).c()) {
                            wVar.o();
                            return;
                        }
                        Object objCall = callable.call();
                        if (((q3.k) cVar.f8405a).c()) {
                            wVar.o();
                            return;
                        } else {
                            gVar.f8950a.g(objCall);
                            return;
                        }
                    } catch (RuntimeException e) {
                        throw new l5.a("Internal error has occurred when executing ML Kit tasks", 13, e);
                    }
                } catch (Exception e4) {
                    if (((q3.k) cVar.f8405a).c()) {
                        wVar.o();
                        return;
                    } else {
                        gVar.f8950a.f(e4);
                        return;
                    }
                }
            default:
                String str = (String) this.f555h;
                se.d3 d3Var = (se.d3) this.f552b;
                NearDevice nearDevice = (NearDevice) this.f553c;
                byte[] data = d3Var.j(nearDevice, str);
                if (data == null) {
                    Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                    Intrinsics.checkNotNullParameter("sendCreateConnectionRequest: connectRequest is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearLanTcpClient", "TransConnect:sendCreateConnectionRequest: connectRequest is null", null);
                    }
                    se.b3 b3Var = d3Var.f;
                    if (b3Var != null) {
                        b3Var.c(nearDevice, null);
                        return;
                    }
                    return;
                }
                String remoteIp = (String) this.f554d;
                d3Var.s(nearDevice, remoteIp, 3000L);
                se.b3 b3Var2 = d3Var.f;
                if (b3Var2 != null) {
                    Intrinsics.checkNotNullParameter(remoteIp, "remoteIp");
                    uf.d session = (uf.d) this.e;
                    Intrinsics.checkNotNullParameter(session, "session");
                    Intrinsics.checkNotNullParameter(data, "data");
                    li.v0 v0Var = li.v0.f7498a;
                    li.l0.p(li.h0.a(si.e.f10118a), null, null, new se.a3(b3Var2, remoteIp, session, data, b3Var2.f9659d, null), 3);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    se.d3 d3Var2 = b3Var2.f9659d;
                    d3Var2.f9713l = countDownLatch;
                    Boolean boolValueOf = Boolean.valueOf(countDownLatch.await(1000L, TimeUnit.MILLISECONDS));
                    d3Var2.f9713l = null;
                    if (Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
                        we.h.b("NearLanTcpClient", "sendPacketArray failed: " + boolValueOf);
                        return;
                    } else {
                        we.h.h("NearLanTcpClient", "sendPacketArray success: " + boolValueOf);
                        return;
                    }
                }
                return;
        }
    }

    public r4(x2 x2Var, Collection collection, e5 e5Var, Future future, Future future2) {
        this.f551a = 0;
        this.f555h = x2Var;
        this.f552b = collection;
        this.f553c = e5Var;
        this.f554d = future;
        this.e = future2;
    }
}
