package q1;

import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class v1<L> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f13731b = Logger.getLogger(v1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b<L>> f13732a = Collections.synchronizedList(new ArrayList());

    public interface a<L> {
        void a(L listener);
    }

    public static final class b<L> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final L f13733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f13734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.a("this")
        public final Queue<a<L>> f13735c = new ArrayDeque();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @u1.a("this")
        public final Queue<Object> f13736d = new ArrayDeque();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @u1.a("this")
        public boolean f13737e;

        public b(L listener, Executor executor) {
            listener.getClass();
            this.f13733a = listener;
            executor.getClass();
            this.f13734b = executor;
        }

        public synchronized void a(a<L> event, Object label) {
            this.f13735c.add(event);
            this.f13736d.add(label);
        }

        public void b() {
            boolean z10;
            synchronized (this) {
                try {
                    if (this.f13737e) {
                        z10 = false;
                    } else {
                        z10 = true;
                        this.f13737e = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                try {
                    this.f13734b.execute(this);
                } catch (RuntimeException e10) {
                    synchronized (this) {
                        this.f13737e = false;
                        v1.f13731b.log(Level.SEVERE, "Exception while running callbacks for " + this.f13733a + " on " + this.f13734b, (Throwable) e10);
                        throw e10;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x005a */
        /* JADX WARN: Code duplicated, block: B:28:0x005e  */
        /* JADX WARN: Code duplicated, block: B:36:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            r2.a(r9.f13733a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        
            q1.v1.f13731b.log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.f13733a + " " + r3, (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r9 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L2b
                boolean r2 = r9.f13737e     // Catch: java.lang.Throwable -> L1f
                c1.h0.g0(r2)     // Catch: java.lang.Throwable -> L1f
                java.util.Queue<q1.v1$a<L>> r2 = r9.f13735c     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L1f
                q1.v1$a r2 = (q1.v1.a) r2     // Catch: java.lang.Throwable -> L1f
                java.util.Queue<java.lang.Object> r3 = r9.f13736d     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1f
                if (r2 != 0) goto L24
                r9.f13737e = r0     // Catch: java.lang.Throwable -> L1f
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = r0
                goto L53
            L1f:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L53
            L24:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1f
                L r4 = r9.f13733a     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d
                r2.a(r4)     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d
                goto L0
            L2b:
                r2 = move-exception
                goto L5c
            L2d:
                r2 = move-exception
                java.util.logging.Logger r4 = q1.v1.a()     // Catch: java.lang.Throwable -> L2b
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L2b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
                r6.<init>()     // Catch: java.lang.Throwable -> L2b
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                L r7 = r9.f13733a     // Catch: java.lang.Throwable -> L2b
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r7 = " "
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                r6.append(r3)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L2b
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L2b
                goto L0
            L53:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L5a
                throw r1     // Catch: java.lang.Throwable -> L55
            L55:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L5c
            L5a:
                r1 = move-exception
                goto L53
            L5c:
                if (r1 == 0) goto L66
                monitor-enter(r9)
                r9.f13737e = r0     // Catch: java.lang.Throwable -> L63
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L63
                goto L66
            L63:
                r0 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L63
                throw r0
            L66:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: q1.v1.b.run():void");
        }
    }

    public void b(L listener, Executor executor) {
        c1.h0.F(listener, "listener");
        c1.h0.F(executor, "executor");
        this.f13732a.add(new b<>(listener, executor));
    }

    public void c() {
        for (int i10 = 0; i10 < this.f13732a.size(); i10++) {
            this.f13732a.get(i10).b();
        }
    }

    public void d(a<L> event) {
        f(event, event);
    }

    public void e(a<L> event, String label) {
        f(event, label);
    }

    public final void f(a<L> event, Object label) {
        c1.h0.F(event, NotificationCompat.CATEGORY_EVENT);
        c1.h0.F(label, "label");
        synchronized (this.f13732a) {
            try {
                Iterator<b<L>> it = this.f13732a.iterator();
                while (it.hasNext()) {
                    it.next().a(event, label);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
