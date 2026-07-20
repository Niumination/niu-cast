package n0;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class q<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f11072e = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<l<T>> f11073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<l<Throwable>> f11074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f11075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public volatile p<T> f11076d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f11076d == null) {
                return;
            }
            p<T> pVar = q.this.f11076d;
            T t10 = pVar.f11070a;
            if (t10 != null) {
                q.this.i(t10);
            } else {
                q.this.g(pVar.f11071b);
            }
        }
    }

    public class b extends FutureTask<p<T>> {
        public b(Callable<p<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                q.this.l(get());
            } catch (InterruptedException | ExecutionException e10) {
                q.this.l(new p(e10));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q(Callable<p<T>> callable) {
        this(callable, false);
    }

    public synchronized q<T> e(l<Throwable> lVar) {
        try {
            if (this.f11076d != null && this.f11076d.f11071b != null) {
                lVar.onResult(this.f11076d.f11071b);
            }
            this.f11074b.add(lVar);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    public synchronized q<T> f(l<T> lVar) {
        try {
            if (this.f11076d != null && this.f11076d.f11070a != null) {
                lVar.onResult(this.f11076d.f11070a);
            }
            this.f11073a.add(lVar);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    public final synchronized void g(Throwable th2) {
        ArrayList arrayList = new ArrayList(this.f11074b);
        if (arrayList.isEmpty()) {
            z0.d.f("Lottie encountered an error but no failure listener was added:", th2);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((l) it.next()).onResult(th2);
        }
    }

    public final void h() {
        this.f11075c.post(new a());
    }

    public final synchronized void i(T t10) {
        Iterator it = new ArrayList(this.f11073a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).onResult(t10);
        }
    }

    public synchronized q<T> j(l<Throwable> lVar) {
        this.f11074b.remove(lVar);
        return this;
    }

    public synchronized q<T> k(l<T> lVar) {
        this.f11073a.remove(lVar);
        return this;
    }

    public final void l(@Nullable p<T> pVar) {
        if (this.f11076d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f11076d = pVar;
        h();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q(Callable<p<T>> callable, boolean z10) {
        this.f11073a = new LinkedHashSet(1);
        this.f11074b = new LinkedHashSet(1);
        this.f11075c = new Handler(Looper.getMainLooper());
        this.f11076d = null;
        if (!z10) {
            f11072e.execute(new b(callable));
            return;
        }
        try {
            l(callable.call());
        } catch (Throwable th2) {
            l(new p<>(th2));
        }
    }
}
