package w3;

import android.text.TextUtils;
import androidx.core.util.Predicate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile j f17923c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<c> f17924a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f17925b;

    public static class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Athena Dispatcher");
            thread.setDaemon(false);
            return thread;
        }

        public a(b bVar) {
        }
    }

    public static /* synthetic */ boolean a(c cVar) {
        return cVar instanceof f;
    }

    public static j d() {
        if (f17923c == null) {
            synchronized (j.class) {
                try {
                    if (f17923c == null) {
                        f17923c = new j();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f17923c;
    }

    public static /* synthetic */ boolean f(String str, c cVar) {
        return TextUtils.equals(cVar.b(), str);
    }

    public static /* synthetic */ boolean j(c cVar) {
        return cVar instanceof f;
    }

    public synchronized int c(final String str) {
        return s3.e.a(this.f17924a, new Predicate() { // from class: w3.h
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return j.f(str, (c) obj);
            }
        });
    }

    public synchronized void e(c cVar) {
        if (c(cVar.b()) <= 0 && !i()) {
            this.f17924a.add(cVar);
            synchronized (this) {
                try {
                    if (this.f17925b == null) {
                        this.f17925b = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
                    }
                    this.f17925b.execute(cVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void g() {
        n nVar;
        Thread thread;
        for (c cVar : this.f17924a) {
            if ((cVar instanceof n) && (thread = (nVar = (n) cVar).f17913b) != null && !thread.isInterrupted()) {
                nVar.f17913b.interrupt();
            }
        }
    }

    public synchronized void h(c cVar) {
        this.f17924a.remove(cVar);
    }

    public final synchronized boolean i() {
        return s3.e.a(this.f17924a, new i()) > 0;
    }
}
