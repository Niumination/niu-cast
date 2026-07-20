package q1;

import com.google.j2objc.annotations.RetainedWith;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class h2 implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f13483f = Logger.getLogger(h2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f13484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.a("queue")
    public final Deque<Runnable> f13485b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.a("queue")
    public c f13486c = c.IDLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.a("queue")
    public long f13487d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @RetainedWith
    public final b f13488e = new b();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f13489a;

        public a(final h2 this$0, final Runnable val$task) {
            this.f13489a = val$task;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13489a.run();
        }

        public String toString() {
            return this.f13489a.toString();
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public Runnable f13490a;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
        
            if (r1 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        
            r8.f13490a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
        
            q1.h2.f13483f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f13490a, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
        
            r8.f13490a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r8 = this;
                r0 = 0
                r1 = r0
            L2:
                q1.h2 r2 = q1.h2.this     // Catch: java.lang.Throwable -> L56
                java.util.Deque r2 = q1.h2.a(r2)     // Catch: java.lang.Throwable -> L56
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L56
                if (r0 != 0) goto L28
                q1.h2 r0 = q1.h2.this     // Catch: java.lang.Throwable -> L1e
                q1.h2$c r3 = r0.f13486c     // Catch: java.lang.Throwable -> L1e
                q1.h2$c r4 = q1.h2.c.RUNNING     // Catch: java.lang.Throwable -> L1e
                if (r3 != r4) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
                if (r1 == 0) goto L1d
                java.lang.Thread r8 = java.lang.Thread.currentThread()
                r8.interrupt()
            L1d:
                return
            L1e:
                r8 = move-exception
                goto L79
            L20:
                q1.h2.d(r0)     // Catch: java.lang.Throwable -> L1e
                q1.h2 r0 = q1.h2.this     // Catch: java.lang.Throwable -> L1e
                r0.f13486c = r4     // Catch: java.lang.Throwable -> L1e
                r0 = 1
            L28:
                q1.h2 r3 = q1.h2.this     // Catch: java.lang.Throwable -> L1e
                java.util.Deque<java.lang.Runnable> r3 = r3.f13485b     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1e
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L1e
                r8.f13490a = r3     // Catch: java.lang.Throwable -> L1e
                if (r3 != 0) goto L47
                q1.h2 r8 = q1.h2.this     // Catch: java.lang.Throwable -> L1e
                q1.h2$c r0 = q1.h2.c.IDLE     // Catch: java.lang.Throwable -> L1e
                r8.f13486c = r0     // Catch: java.lang.Throwable -> L1e
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
                if (r1 == 0) goto L46
                java.lang.Thread r8 = java.lang.Thread.currentThread()
                r8.interrupt()
            L46:
                return
            L47:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L56
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r8.f13490a     // Catch: java.lang.Throwable -> L58 java.lang.RuntimeException -> L5a
                r3.run()     // Catch: java.lang.Throwable -> L58 java.lang.RuntimeException -> L5a
            L53:
                r8.f13490a = r2     // Catch: java.lang.Throwable -> L56
                goto L2
            L56:
                r8 = move-exception
                goto L7b
            L58:
                r0 = move-exception
                goto L76
            L5a:
                r3 = move-exception
                java.util.logging.Logger r4 = q1.h2.f13483f     // Catch: java.lang.Throwable -> L58
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L58
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58
                r6.<init>()     // Catch: java.lang.Throwable -> L58
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L58
                java.lang.Runnable r7 = r8.f13490a     // Catch: java.lang.Throwable -> L58
                r6.append(r7)     // Catch: java.lang.Throwable -> L58
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L58
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L58
                goto L53
            L76:
                r8.f13490a = r2     // Catch: java.lang.Throwable -> L56
                throw r0     // Catch: java.lang.Throwable -> L56
            L79:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1e
                throw r8     // Catch: java.lang.Throwable -> L56
            L7b:
                if (r1 == 0) goto L84
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L84:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: q1.h2.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (h2.this.f13485b) {
                    h2.this.f13486c = c.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f13490a;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + h2.this.f13486c + "}";
        }

        public /* synthetic */ b(h2 h2Var, a aVar) {
            this();
        }
    }

    public enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public h2(Executor executor) {
        executor.getClass();
        this.f13484a = executor;
    }

    public static /* synthetic */ long d(h2 h2Var) {
        long j10 = h2Var.f13487d;
        h2Var.f13487d = 1 + j10;
        return j10;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x005f  */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable task) {
        c cVar;
        boolean z10;
        task.getClass();
        synchronized (this.f13485b) {
            c cVar2 = this.f13486c;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j10 = this.f13487d;
                a aVar = new a(this, task);
                this.f13485b.add(aVar);
                c cVar3 = c.QUEUING;
                this.f13486c = cVar3;
                try {
                    this.f13484a.execute(this.f13488e);
                    if (this.f13486c != cVar3) {
                        return;
                    }
                    synchronized (this.f13485b) {
                        try {
                            if (this.f13487d == j10 && this.f13486c == cVar3) {
                                this.f13486c = cVar;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f13485b) {
                        try {
                            c cVar4 = this.f13486c;
                            if (cVar4 != c.IDLE && cVar4 != c.QUEUING) {
                                z10 = false;
                            } else if (this.f13485b.removeLastOccurrence(aVar)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!(e10 instanceof RejectedExecutionException) || z10) {
                                throw e10;
                            }
                            return;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
            this.f13485b.add(task);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f13484a + "}";
    }
}
