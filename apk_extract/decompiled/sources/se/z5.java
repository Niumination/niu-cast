package se;

import android.net.nsd.NsdServiceInfo;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f10080a = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f10081b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f10082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture f10083d;
    public boolean e;
    public qi.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b6 f10084g;

    public z5(b6 b6Var) {
        this.f10084g = b6Var;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ik.t(1));
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        this.f10082c = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        li.v0 v0Var = li.v0.f7498a;
        this.f = li.h0.a(si.e.f10118a);
        we.h.b("TranLanController", "ServiceResolvePoller init");
    }

    public final void a(NsdServiceInfo service) {
        Intrinsics.checkNotNullParameter(service, "service");
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f10081b;
        if (concurrentLinkedQueue.contains(service)) {
            we.h.b("TranLanController", "Service already exists: " + service.getServiceName() + ", Service hashCode: " + service.hashCode());
            return;
        }
        concurrentLinkedQueue.add(service);
        int size = concurrentLinkedQueue.size();
        we.h.b("TranLanController", "Add Service: " + service.getServiceName() + ", size: " + size);
        if (size == 1) {
            i();
        } else {
            h0.a.C(size, "Service added, but not start polling, size: ", "TranLanController");
        }
    }

    public final void b(v5 serviceRequest) {
        Intrinsics.checkNotNullParameter(serviceRequest, "serviceRequest");
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f10080a;
        boolean zContains = concurrentLinkedQueue.contains(serviceRequest);
        NsdServiceInfo nsdServiceInfo = serviceRequest.f10034a;
        if (zContains) {
            we.h.b("TranLanController", "Service Request already exists: " + nsdServiceInfo.getServiceName() + ", Req hashCode: " + serviceRequest.hashCode());
            return;
        }
        concurrentLinkedQueue.add(serviceRequest);
        int size = concurrentLinkedQueue.size();
        we.h.b("TranLanController", "Add Service Request: " + nsdServiceInfo.getServiceName() + ", size: " + size);
        if (size == 1) {
            i();
        } else {
            h0.a.C(size, "Service Request added, but not start polling, size: ", "TranLanController");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object c(int i8, String str, ContinuationImpl continuationImpl) throws Throwable {
        w5 w5Var;
        jf.d dVar;
        Throwable th2;
        if (continuationImpl instanceof w5) {
            w5Var = (w5) continuationImpl;
            int i9 = w5Var.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                w5Var.label = i9 - Integer.MIN_VALUE;
            } else {
                w5Var = new w5(this, continuationImpl);
            }
        } else {
            w5Var = new w5(this, continuationImpl);
        }
        Object obj = w5Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = w5Var.label;
        boolean z2 = false;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            List list = jf.g.f6269a;
            ag.b block = new ag.b(15);
            Intrinsics.checkNotNullParameter(block, "block");
            jf.d dVarA = jf.h.a(jf.g.f6270b, block);
            try {
                String urlString = "http://" + str + ":" + i8 + "/ping";
                vf.c cVar = new vf.c();
                zg.a aVar = vf.e.f10566a;
                Intrinsics.checkNotNullParameter(cVar, "<this>");
                Intrinsics.checkNotNullParameter(urlString, "urlString");
                zf.m0.b(cVar.f10557a, urlString);
                zf.x xVar = zf.x.f11553b;
                Intrinsics.checkNotNullParameter(xVar, "<set-?>");
                cVar.f10558b = xVar;
                wf.j jVar = new wf.j(cVar, dVarA);
                w5Var.L$0 = dVarA;
                w5Var.label = 1;
                Object objB = jVar.b(w5Var);
                if (objB == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dVar = dVarA;
                obj = objB;
            } catch (Exception unused) {
                dVar = dVarA;
            } catch (Throwable th3) {
                dVar = dVarA;
                th2 = th3;
                dVar.close();
                throw th2;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            dVar = (jf.d) w5Var.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused2) {
            } catch (Throwable th4) {
                th2 = th4;
                dVar.close();
                throw th2;
            }
        }
        if (((wf.b) obj).h().f11581a == 200) {
            z2 = true;
        }
        dVar.close();
        return Boxing.boxBoolean(z2);
    }

    public final void d() {
        if (this.e) {
            this.e = false;
            ScheduledFuture scheduledFuture = this.f10083d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f10083d = null;
            we.h.b("TranLanController", "Polling Service Resolve Task paused");
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0169  */
    /* JADX WARN: Code duplicated, block: B:53:0x0186 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x018f  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0184 -> B:54:0x0187). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01c6 -> B:62:0x01c8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object e(kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.z5.e(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void f(NsdServiceInfo service) {
        Intrinsics.checkNotNullParameter(service, "service");
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f10081b;
        if (!concurrentLinkedQueue.contains(service)) {
            we.h.b("TranLanController", "Service not found: " + service.getServiceName() + ", ignore");
            return;
        }
        concurrentLinkedQueue.remove(service);
        we.h.b("TranLanController", "Remove Service: " + service.getServiceName() + ", size: " + concurrentLinkedQueue.size());
        if (concurrentLinkedQueue.isEmpty()) {
            d();
        }
    }

    public final void g(v5 serviceRequest) throws InterruptedException {
        Intrinsics.checkNotNullParameter(serviceRequest, "serviceRequest");
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f10080a;
        concurrentLinkedQueue.remove(serviceRequest);
        if (concurrentLinkedQueue.isEmpty()) {
            d();
            if (this.f10084g.f9675o) {
                return;
            }
            d();
            this.f10082c.shutdown();
            this.f10082c.awaitTermination(2L, TimeUnit.SECONDS);
            if (this.f10082c.isShutdown() && this.f10082c.isTerminated()) {
                concurrentLinkedQueue.clear();
                we.h.b("TranLanController", "Polling Service Resolve Task stopped");
            } else {
                we.h.j("TranLanController", "Polling Service Resolve Task failed to stop");
            }
            li.h0.b(this.f, new CancellationException("Polling Service Resolve Task stopped"));
        }
    }

    public final void h(String serviceName) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f10081b;
        concurrentLinkedQueue.removeIf(new q1(2, new hg.e(serviceName, 2)));
        we.h.b("TranLanController", "Remove Service with Name: " + serviceName + ", size: " + concurrentLinkedQueue.size());
        if (concurrentLinkedQueue.isEmpty()) {
            d();
        }
    }

    public final void i() {
        if (this.e) {
            return;
        }
        this.e = true;
        if (!li.h0.d(this.f)) {
            li.v0 v0Var = li.v0.f7498a;
            this.f = li.h0.a(si.e.f10118a);
        }
        if (this.f10082c.isShutdown()) {
            this.f10082c = Executors.newSingleThreadScheduledExecutor(new ik.t(1));
        }
        if (this.f10082c.isShutdown()) {
            we.h.j("TranLanController", "Polling Service Resolve Task failed, shutdown");
            return;
        }
        try {
            this.f10083d = this.f10082c.scheduleWithFixedDelay(new m.c(this, 11), 5L, 5L, TimeUnit.SECONDS);
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        }
    }
}
