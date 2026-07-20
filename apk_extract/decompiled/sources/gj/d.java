package gj;

import af.f;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f5219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Logger f5220i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5224d;
    public final ArrayList e;
    public final f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a8.a f5225g;

    static {
        String name = ej.b.f4968g + " TaskRunner";
        Intrinsics.checkNotNullParameter(name, "name");
        f5219h = new d(new a8.a(new ej.a(name, true)));
        Logger logger = Logger.getLogger(d.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f5220i = logger;
    }

    public d(a8.a backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.f5225g = backend;
        this.f5221a = ModuleDescriptor.MODULE_VERSION;
        this.f5224d = new ArrayList();
        this.e = new ArrayList();
        this.f = new f(this, 21);
    }

    public static final void a(d dVar, a aVar) {
        dVar.getClass();
        byte[] bArr = ej.b.f4964a;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(aVar.f5213c);
        try {
            long jA = aVar.a();
            synchronized (dVar) {
                dVar.b(aVar, jA);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            synchronized (dVar) {
                dVar.b(aVar, -1L);
                Unit unit2 = Unit.INSTANCE;
                currentThread.setName(name);
            }
        }
    }

    public final void b(a aVar, long j8) {
        byte[] bArr = ej.b.f4964a;
        c cVar = aVar.f5211a;
        Intrinsics.checkNotNull(cVar);
        if (cVar.f5216b != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z2 = cVar.f5218d;
        cVar.f5218d = false;
        cVar.f5216b = null;
        this.f5224d.remove(cVar);
        if (j8 != -1 && !z2 && !cVar.f5215a) {
            cVar.d(aVar, j8, true);
        }
        if (cVar.f5217c.isEmpty()) {
            return;
        }
        this.e.add(cVar);
    }

    public final a c() {
        boolean z2;
        byte[] bArr = ej.b.f4964a;
        while (true) {
            ArrayList arrayList = this.e;
            if (arrayList.isEmpty()) {
                return null;
            }
            a8.a aVar = this.f5225g;
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            a aVar2 = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                a aVar3 = (a) ((c) it.next()).f5217c.get(0);
                long jMax = Math.max(0L, aVar3.f5212b - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar2 != null) {
                        z2 = true;
                        break;
                    }
                    aVar2 = aVar3;
                }
            }
            ArrayList arrayList2 = this.f5224d;
            if (aVar2 != null) {
                byte[] bArr2 = ej.b.f4964a;
                aVar2.f5212b = -1L;
                c cVar = aVar2.f5211a;
                Intrinsics.checkNotNull(cVar);
                cVar.f5217c.remove(aVar2);
                arrayList.remove(cVar);
                cVar.f5216b = aVar2;
                arrayList2.add(cVar);
                if (z2 || (!this.f5222b && !arrayList.isEmpty())) {
                    f runnable = this.f;
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    ((ThreadPoolExecutor) aVar.f44b).execute(runnable);
                }
                return aVar2;
            }
            if (this.f5222b) {
                if (jMin < this.f5223c - jNanoTime) {
                    Intrinsics.checkNotNullParameter(this, "taskRunner");
                    notify();
                }
                return null;
            }
            this.f5222b = true;
            this.f5223c = jNanoTime + jMin;
            try {
                try {
                    Intrinsics.checkNotNullParameter(this, "taskRunner");
                    long j8 = jMin / 1000000;
                    long j10 = jMin - (1000000 * j8);
                    if (j8 > 0 || jMin > 0) {
                        wait(j8, (int) j10);
                    }
                } catch (InterruptedException unused) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ((c) arrayList2.get(size)).b();
                    }
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        c cVar2 = (c) arrayList.get(size2);
                        cVar2.b();
                        if (cVar2.f5217c.isEmpty()) {
                            arrayList.remove(size2);
                        }
                    }
                }
                this.f5222b = false;
            } catch (Throwable th2) {
                this.f5222b = false;
                throw th2;
            }
        }
    }

    public final void d(c taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        byte[] bArr = ej.b.f4964a;
        if (taskQueue.f5216b == null) {
            boolean zIsEmpty = taskQueue.f5217c.isEmpty();
            ArrayList addIfAbsent = this.e;
            if (zIsEmpty) {
                addIfAbsent.remove(taskQueue);
            } else {
                Intrinsics.checkNotNullParameter(addIfAbsent, "$this$addIfAbsent");
                if (!addIfAbsent.contains(taskQueue)) {
                    addIfAbsent.add(taskQueue);
                }
            }
        }
        boolean z2 = this.f5222b;
        a8.a aVar = this.f5225g;
        if (z2) {
            Intrinsics.checkNotNullParameter(this, "taskRunner");
            notify();
        } else {
            f runnable = this.f;
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            ((ThreadPoolExecutor) aVar.f44b).execute(runnable);
        }
    }

    public final c e() {
        int i8;
        synchronized (this) {
            i8 = this.f5221a;
            this.f5221a = i8 + 1;
        }
        return new c(this, a1.a.o(i8, "Q"));
    }
}
