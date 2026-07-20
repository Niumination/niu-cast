package j1;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {
    public static final ExecutorService e = Executors.newCachedThreadPool(new w1.c());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f5952a = new LinkedHashSet(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f5953b = new LinkedHashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f5954c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c0 f5955d = null;

    public e0(j jVar) {
        d(new c0(jVar));
    }

    public final synchronized void a(a0 a0Var) {
        Throwable th2;
        try {
            c0 c0Var = this.f5955d;
            if (c0Var != null && (th2 = c0Var.f5944b) != null) {
                a0Var.onResult(th2);
            }
            this.f5953b.add(a0Var);
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final synchronized void b(a0 a0Var) {
        j jVar;
        try {
            c0 c0Var = this.f5955d;
            if (c0Var != null && (jVar = c0Var.f5943a) != null) {
                a0Var.onResult(jVar);
            }
            this.f5952a.add(a0Var);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c() {
        c0 c0Var = this.f5955d;
        if (c0Var == null) {
            return;
        }
        j jVar = c0Var.f5943a;
        if (jVar != null) {
            synchronized (this) {
                Iterator it = new ArrayList(this.f5952a).iterator();
                while (it.hasNext()) {
                    ((a0) it.next()).onResult(jVar);
                }
            }
            return;
        }
        Throwable th2 = c0Var.f5944b;
        synchronized (this) {
            ArrayList arrayList = new ArrayList(this.f5953b);
            if (arrayList.isEmpty()) {
                w1.b.c("Lottie encountered an error but no failure listener was added:", th2);
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((a0) it2.next()).onResult(th2);
            }
        }
    }

    public final void d(c0 c0Var) {
        if (this.f5955d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f5955d = c0Var;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c();
        } else {
            this.f5954c.post(new a4.c(this, 26));
        }
    }

    public e0(Callable callable, boolean z2) {
        if (z2) {
            try {
                d((c0) callable.call());
                return;
            } catch (Throwable th2) {
                d(new c0(th2));
                return;
            }
        }
        d0 d0Var = new d0(callable);
        d0Var.f5949a = this;
        e.execute(d0Var);
    }
}
