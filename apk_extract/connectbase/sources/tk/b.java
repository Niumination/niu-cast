package tk;

import in.n;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jn.p;
import kn.l0;
import kn.w;
import lm.c1;
import lm.k;
import lm.l2;
import lm.m;
import nq.j;
import nq.n0;
import nq.r0;
import nq.s0;
import os.l;
import um.g;
import xm.f;
import xm.h;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@k(level = m.HIDDEN, message = "This is going to be deprecated. Use kotlinx.coroutines dispatchers")
public final class b extends n0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final ThreadGroup f15767b = new ThreadGroup("io-pool-group-sub");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final ll.c f15768c = new ll.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final C0404b[] f15769d;

    public static final class a extends ll.e implements Runnable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public final Runnable f15770d;

        public a(@l Runnable runnable) {
            l0.p(runnable, "r");
            this.f15770d = runnable;
        }

        @l
        public final Runnable N() {
            return this.f15770d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15770d.run();
        }
    }

    /* JADX INFO: renamed from: tk.b$b, reason: collision with other inner class name */
    public static final class C0404b extends Thread {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @l
        public static final a f15771d = new a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @l
        public static final AtomicReferenceFieldUpdater<C0404b, um.d<l2>> f15772e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @l
        public final ll.c f15774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final jn.l<um.d<? super l2>, Object> f15775c;

        @os.m
        private volatile um.d<? super l2> cont;

        /* JADX INFO: renamed from: tk.b$b$a */
        public static final class a {
            public a() {
            }

            @n
            public static /* synthetic */ void a() {
            }

            public a(w wVar) {
            }
        }

        /* JADX INFO: renamed from: tk.b$b$b, reason: collision with other inner class name */
        public static final class C0405b extends kn.n0 implements jn.l<um.d<? super l2>, Object> {
            public C0405b() {
                super(1);
            }

            @Override // jn.l
            @l
            public final Object invoke(@os.m um.d<? super l2> dVar) {
                um.d dVarE = dVar == null ? null : wm.c.e(dVar);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0404b.f15772e;
                if (!j.d.a(atomicReferenceFieldUpdater, C0404b.this, null, dVarE)) {
                    throw new IllegalStateException("Failed to set continuation");
                }
                Object objV = C0404b.this.f15774b.v();
                C0404b c0404b = C0404b.this;
                return (objV == c0404b.f15774b || !j.d.a(atomicReferenceFieldUpdater, c0404b, dVarE, null)) ? wm.a.COROUTINE_SUSPENDED : l2.f10208a;
            }
        }

        /* JADX INFO: renamed from: tk.b$b$c */
        @f(c = "io.ktor.network.util.IOCoroutineDispatcher$IOThread$run$1", f = "IOCoroutineDispatcher.kt", i = {0}, l = {181}, m = "invokeSuspend", n = {"this_$iv$iv"}, s = {"L$0"})
        public static final class c extends o implements p<s0, um.d<? super l2>, Object> {
            Object L$0;
            int label;

            public c(um.d<? super c> dVar) {
                super(2, dVar);
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@os.m Object obj, @l um.d<?> dVar) {
                return C0404b.this.new c(dVar);
            }

            /* JADX WARN: Code duplicated, block: B:30:0x004f A[Catch: all -> 0x0012, TryCatch #1 {all -> 0x0012, blocks: (B:6:0x000e, B:26:0x0041, B:27:0x0045, B:35:0x005a, B:13:0x0020, B:14:0x0026, B:22:0x003b, B:17:0x0030, B:20:0x0035, B:51:0x008e, B:46:0x0072, B:38:0x005f, B:47:0x007f, B:30:0x004f, B:33:0x0054, B:50:0x008a, B:43:0x006d), top: B:58:0x000e, inners: #0 }] */
            /* JADX WARN: Code duplicated, block: B:50:0x008a A[Catch: all -> 0x0012, LOOP:1: B:27:0x0045->B:50:0x008a, LOOP_END, TryCatch #1 {all -> 0x0012, blocks: (B:6:0x000e, B:26:0x0041, B:27:0x0045, B:35:0x005a, B:13:0x0020, B:14:0x0026, B:22:0x003b, B:17:0x0030, B:20:0x0035, B:51:0x008e, B:46:0x0072, B:38:0x005f, B:47:0x007f, B:30:0x004f, B:33:0x0054, B:50:0x008a, B:43:0x006d), top: B:58:0x000e, inners: #0 }] */
            /* JADX WARN: Code duplicated, block: B:65:0x005a A[EDGE_INSN: B:65:0x005a->B:35:0x005a BREAK  A[LOOP:1: B:27:0x0045->B:50:0x008a], SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:66:0x004d A[ADDED_TO_REGION, SYNTHETIC] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [ll.e] */
            /* JADX WARN: Type inference failed for: r4v10 */
            /* JADX WARN: Type inference failed for: r4v2 */
            /* JADX WARN: Type inference failed for: r4v3 */
            /* JADX WARN: Type inference failed for: r4v8, types: [ll.e] */
            /* JADX WARN: Type inference failed for: r4v9 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x003f -> B:41:0x006a). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0040 -> B:26:0x0041). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
                /*
                    r6 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r6.label
                    r2 = 1
                    r3 = 0
                    if (r1 == 0) goto L1d
                    if (r1 != r2) goto L15
                    java.lang.Object r1 = r6.L$0
                    tk.b$b r1 = (tk.b.C0404b) r1
                    lm.d1.n(r7)     // Catch: java.lang.Throwable -> L12
                    goto L41
                L12:
                    r7 = move-exception
                    goto L92
                L15:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L1d:
                    lm.d1.n(r7)
                L20:
                    tk.b$b r7 = tk.b.C0404b.this     // Catch: java.lang.Throwable -> L12
                    ll.c r1 = tk.b.C0404b.a(r7)     // Catch: java.lang.Throwable -> L12
                L26:
                    java.lang.Object r4 = r1.v()     // Catch: java.lang.Throwable -> L12
                    ll.e r4 = (ll.e) r4     // Catch: java.lang.Throwable -> L12
                    if (r4 != r1) goto L30
                L2e:
                    r4 = r3
                    goto L3b
                L30:
                    boolean r5 = r4 instanceof java.lang.Runnable     // Catch: java.lang.Throwable -> L12
                    if (r5 != 0) goto L35
                    goto L2e
                L35:
                    boolean r5 = r4.G()     // Catch: java.lang.Throwable -> L12
                    if (r5 == 0) goto L8e
                L3b:
                    java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L12
                    if (r4 == 0) goto L40
                    goto L6a
                L40:
                    r1 = r7
                L41:
                    ll.c r7 = tk.b.C0404b.a(r1)     // Catch: java.lang.Throwable -> L12
                L45:
                    java.lang.Object r4 = r7.v()     // Catch: java.lang.Throwable -> L12
                    ll.e r4 = (ll.e) r4     // Catch: java.lang.Throwable -> L12
                    if (r4 != r7) goto L4f
                L4d:
                    r4 = r3
                    goto L5a
                L4f:
                    boolean r5 = r4 instanceof java.lang.Runnable     // Catch: java.lang.Throwable -> L12
                    if (r5 != 0) goto L54
                    goto L4d
                L54:
                    boolean r5 = r4.G()     // Catch: java.lang.Throwable -> L12
                    if (r5 == 0) goto L8a
                L5a:
                    java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L12
                    if (r4 == 0) goto L5f
                    goto L6a
                L5f:
                    ll.c r7 = r1.f15774b     // Catch: java.lang.Throwable -> L12
                    java.lang.Object r7 = r7.v()     // Catch: java.lang.Throwable -> L12
                    boolean r7 = r7 instanceof tk.b.c     // Catch: java.lang.Throwable -> L12
                    if (r7 == 0) goto L7f
                    r4 = r3
                L6a:
                    if (r4 != 0) goto L6d
                    goto L9e
                L6d:
                    r4.run()     // Catch: java.lang.Throwable -> L71
                    goto L20
                L71:
                    r7 = move-exception
                    tk.b$b r1 = tk.b.C0404b.this     // Catch: java.lang.Throwable -> L12
                    java.util.concurrent.ExecutionException r4 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> L12
                    java.lang.String r5 = "Task failed"
                    r4.<init>(r5, r7)     // Catch: java.lang.Throwable -> L12
                    tk.b.C0404b.c(r1, r4)     // Catch: java.lang.Throwable -> L12
                    goto L20
                L7f:
                    r6.L$0 = r1     // Catch: java.lang.Throwable -> L12
                    r6.label = r2     // Catch: java.lang.Throwable -> L12
                    java.lang.Object r7 = r1.i(r6)     // Catch: java.lang.Throwable -> L12
                    if (r7 != r0) goto L41
                    return r0
                L8a:
                    r4.B()     // Catch: java.lang.Throwable -> L12
                    goto L45
                L8e:
                    r4.B()     // Catch: java.lang.Throwable -> L12
                    goto L26
                L92:
                    tk.b$b r6 = tk.b.C0404b.this
                    java.util.concurrent.ExecutionException r0 = new java.util.concurrent.ExecutionException
                    java.lang.String r1 = "Thread pool worker failed"
                    r0.<init>(r1, r7)
                    tk.b.C0404b.c(r6, r0)
                L9e:
                    lm.l2 r6 = lm.l2.f10208a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: tk.b.C0404b.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@l s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((c) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        static {
            AtomicReferenceFieldUpdater<C0404b, um.d<l2>> atomicReferenceFieldUpdaterNewUpdater = AtomicReferenceFieldUpdater.newUpdater(C0404b.class, um.d.class, "cont");
            if (atomicReferenceFieldUpdaterNewUpdater == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.atomic.AtomicReferenceFieldUpdater<io.ktor.network.util.IOCoroutineDispatcher.IOThread, kotlin.coroutines.Continuation<kotlin.Unit>?>");
            }
            f15772e = atomicReferenceFieldUpdaterNewUpdater;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0404b(int i10, @l ll.c cVar, @l ThreadGroup threadGroup) {
            super(threadGroup, l0.C("io-thread-", Integer.valueOf(i10)));
            l0.p(cVar, "tasks");
            l0.p(threadGroup, "dispatcherThreadGroup");
            this.f15773a = i10;
            this.f15774b = cVar;
            setDaemon(true);
            this.f15775c = new C0405b();
        }

        public final void e(Throwable th2) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(this, th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [ll.e] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r1v1, types: [ll.e] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final Object f(um.d<? super Runnable> dVar) {
            ?? r10;
            ?? r11;
            ll.c cVar = this.f15774b;
            while (true) {
                r10 = (ll.e) cVar.v();
                if (r10 == cVar || !(r10 instanceof Runnable)) {
                    r10 = 0;
                    break;
                }
                if (r10.G()) {
                    break;
                }
                r10.B();
            }
            Runnable runnable = (Runnable) r10;
            if (runnable != null) {
                return runnable;
            }
            while (true) {
                ll.c cVar2 = this.f15774b;
                while (true) {
                    r11 = (ll.e) cVar2.v();
                    if (r11 == cVar2 || !(r11 instanceof Runnable)) {
                        r11 = 0;
                        break;
                    }
                    if (r11.G()) {
                        break;
                    }
                    r11.B();
                }
                Runnable runnable2 = (Runnable) r11;
                if (runnable2 != null) {
                    return runnable2;
                }
                if (this.f15774b.v() instanceof c) {
                    return null;
                }
                i(dVar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [ll.e] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final Object g(um.d<? super Runnable> dVar) {
            ?? r10;
            while (true) {
                ll.c cVar = this.f15774b;
                while (true) {
                    r10 = (ll.e) cVar.v();
                    if (r10 == cVar || !(r10 instanceof Runnable)) {
                        r10 = 0;
                        break;
                    }
                    if (r10.G()) {
                        break;
                    }
                    r10.B();
                }
                Runnable runnable = (Runnable) r10;
                if (runnable != null) {
                    return runnable;
                }
                if (this.f15774b.v() instanceof c) {
                    return null;
                }
                i(dVar);
            }
        }

        public final boolean h() {
            um.d<l2> andSet = f15772e.getAndSet(this, null);
            if (andSet == null) {
                return false;
            }
            c1.a aVar = c1.Companion;
            andSet.resumeWith(c1.m59constructorimpl(l2.f10208a));
            return true;
        }

        public final Object i(um.d<? super l2> dVar) {
            Object objInvoke = this.f15775c.invoke(dVar);
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objInvoke == aVar) {
                h.c(dVar);
            }
            return objInvoke == aVar ? objInvoke : l2.f10208a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            j.a(new r0(l0.C("io-dispatcher-executor-", Integer.valueOf(this.f15773a))), new c(null));
        }
    }

    public static final class c extends ll.e {
    }

    public b(int i10) {
        this.f15766a = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException(k.b.a("nThreads should be positive but ", i10, " specified").toString());
        }
        C0404b[] c0404bArr = new C0404b[i10];
        int i11 = 0;
        int i12 = 0;
        while (i12 < i10) {
            int i13 = i12 + 1;
            c0404bArr[i12] = new C0404b(i13, this.f15768c, this.f15767b);
            i12 = i13;
        }
        this.f15769d = c0404bArr;
        int length = c0404bArr.length;
        while (i11 < length) {
            C0404b c0404b = c0404bArr[i11];
            i11++;
            c0404b.start();
        }
    }

    public static /* synthetic */ void f0() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ll.e eVar;
        if (this.f15768c.z() instanceof c) {
            return;
        }
        ll.c cVar = this.f15768c;
        c cVar2 = new c();
        do {
            eVar = (ll.e) cVar.z();
            if (eVar instanceof c) {
                break;
            }
        } while (!eVar.j(cVar2, cVar));
        j0();
    }

    @Override // nq.n0
    public void dispatch(@l g gVar, @l Runnable runnable) {
        l0.p(gVar, "context");
        l0.p(runnable, "block");
        a aVar = new a(runnable);
        this.f15768c.f(aVar);
        p0(aVar);
    }

    public final void j0() {
        C0404b[] c0404bArr = this.f15769d;
        int i10 = this.f15766a;
        for (int i11 = 0; i11 < i10; i11++) {
            c0404bArr[i11].h();
        }
    }

    public final void p0(ll.e eVar) {
        C0404b[] c0404bArr = this.f15769d;
        int i10 = this.f15766a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i11 + 1;
            if (c0404bArr[i11].h() || (eVar.v() instanceof ll.g)) {
                return;
            } else {
                i11 = i12;
            }
        }
    }
}
