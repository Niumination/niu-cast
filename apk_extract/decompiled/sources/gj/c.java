package gj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import k3.i2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f5216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5218d;
    public final d e;
    public final String f;

    public c(d taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.e = taskRunner;
        this.f = name;
        this.f5217c = new ArrayList();
    }

    public final void a() {
        byte[] bArr = ej.b.f4964a;
        synchronized (this.e) {
            try {
                if (b()) {
                    this.e.d(this);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean b() {
        a aVar = this.f5216b;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.f5214d) {
                this.f5218d = true;
            }
        }
        ArrayList arrayList = this.f5217c;
        boolean z2 = false;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((a) arrayList.get(size)).f5214d) {
                a aVar2 = (a) arrayList.get(size);
                if (d.f5220i.isLoggable(Level.FINE)) {
                    i2.a(aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void c(a task, long j8) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.e) {
            if (!this.f5215a) {
                if (d(task, j8, false)) {
                    this.e.d(this);
                }
                Unit unit = Unit.INSTANCE;
            } else if (task.f5214d) {
                if (d.f5220i.isLoggable(Level.FINE)) {
                    i2.a(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (d.f5220i.isLoggable(Level.FINE)) {
                    i2.a(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean d(a task, long j8, boolean z2) {
        Intrinsics.checkNotNullParameter(task, "task");
        task.getClass();
        Intrinsics.checkNotNullParameter(this, "queue");
        c cVar = task.f5211a;
        if (cVar != this) {
            if (cVar != null) {
                throw new IllegalStateException("task is in multiple queues");
            }
            task.f5211a = this;
        }
        a8.a aVar = this.e.f5225g;
        long jNanoTime = System.nanoTime();
        long j10 = jNanoTime + j8;
        ArrayList arrayList = this.f5217c;
        int iIndexOf = arrayList.indexOf(task);
        if (iIndexOf != -1) {
            if (task.f5212b <= j10) {
                if (d.f5220i.isLoggable(Level.FINE)) {
                    i2.a(task, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(iIndexOf);
        }
        task.f5212b = j10;
        if (d.f5220i.isLoggable(Level.FINE)) {
            i2.a(task, this, z2 ? "run again after ".concat(i2.b(j10 - jNanoTime)) : "scheduled after ".concat(i2.b(j10 - jNanoTime)));
        }
        Iterator it = arrayList.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((a) it.next()).f5212b - jNanoTime > j8) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = arrayList.size();
        }
        arrayList.add(size, task);
        return size == 0;
    }

    public final void e() {
        byte[] bArr = ej.b.f4964a;
        synchronized (this.e) {
            try {
                this.f5215a = true;
                if (b()) {
                    this.e.d(this);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final String toString() {
        return this.f;
    }
}
