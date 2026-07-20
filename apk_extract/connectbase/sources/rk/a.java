package rk;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import jn.p;
import kn.l0;
import lm.c1;
import lm.d1;
import lm.l2;
import nq.d4;
import nq.r0;
import nq.s0;
import os.m;
import p6.s;
import pq.w;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends l implements Closeable, s0 {
    private volatile boolean closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final AtomicLong f14509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final b<l2, um.d<l2>> f14510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final rk.d<h> f14511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final um.g f14512g;
    private volatile boolean inSelect;

    @m
    private volatile Selector selectorRef;

    /* JADX INFO: renamed from: rk.a$a, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.network.selector.ActorSelectorManager$1", f = "ActorSelectorManager.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"selector"}, s = {"L$0"})
    public static final class C0355a extends o implements p<s0, um.d<? super l2>, Object> {
        Object L$0;
        int label;

        public C0355a(um.d<? super C0355a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@m Object obj, @os.l um.d<?> dVar) {
            return a.this.new C0355a(dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, wm.a] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.nio.channels.spi.AbstractSelector] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.nio.channels.Selector] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.nio.channels.Selector, java.nio.channels.spi.AbstractSelector] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.nio.channels.spi.AbstractSelector] */
        /* JADX WARN: Type inference failed for: r1v11, types: [rk.a, rk.l] */
        /* JADX WARN: Type inference failed for: r6v3, types: [rk.a, rk.l] */
        /* JADX WARN: Type inference failed for: r7v13, types: [rk.l] */
        /* JADX WARN: Type inference failed for: r7v25 */
        /* JADX WARN: Type inference failed for: r7v26 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) throws IOException {
            Throwable th2;
            ?? r10;
            ?? r11;
            ?? r12;
            ?? r13 = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    AbstractSelector abstractSelectorOpenSelector = a.this.f14549a.openSelector();
                    if (abstractSelectorOpenSelector == null) {
                        throw new IllegalStateException("openSelector() = null");
                    }
                    a.this.selectorRef = abstractSelectorOpenSelector;
                    try {
                        a aVar = a.this;
                        rk.d<h> dVar = aVar.f14511f;
                        this.L$0 = abstractSelectorOpenSelector;
                        this.label = 1;
                        if (aVar.J1(dVar, abstractSelectorOpenSelector, this) == r13) {
                            return r13;
                        }
                        r10 = abstractSelectorOpenSelector;
                        a.this.closed = true;
                        a.this.f14511f.b();
                        a.this.selectorRef = null;
                        r12 = r10;
                        r11 = a.this;
                    } catch (Throwable th3) {
                        r13 = abstractSelectorOpenSelector;
                        th2 = th3;
                        a.this.closed = true;
                        a.this.f14511f.b();
                        a.this.c(r13, th2);
                        a.this.closed = true;
                        a.this.f14511f.b();
                        a.this.selectorRef = null;
                        r12 = r13;
                        r11 = a.this;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r13 = (AbstractSelector) this.L$0;
                    try {
                        d1.n(obj);
                        r10 = r13;
                        a.this.closed = true;
                        a.this.f14511f.b();
                        a.this.selectorRef = null;
                        r12 = r10;
                        r11 = a.this;
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            a.this.closed = true;
                            a.this.f14511f.b();
                            a.this.c(r13, th2);
                            a.this.closed = true;
                            a.this.f14511f.b();
                            a.this.selectorRef = null;
                            r12 = r13;
                            r11 = a.this;
                        } catch (Throwable th5) {
                            a.this.closed = true;
                            a.this.f14511f.b();
                            a.this.selectorRef = null;
                            a.this.c(r13, null);
                            throw th5;
                        }
                    }
                }
                r11.c(r12, null);
                while (true) {
                    h hVarD = a.this.f14511f.d();
                    if (hVarD == null) {
                        r12.close();
                        return l2.f10208a;
                    }
                    a.this.k(hVarD, new w("Failed to apply interest: selector closed"));
                }
            } catch (Throwable th6) {
                r13.close();
                throw th6;
            }
        }

        @Override // jn.p
        @m
        public final Object invoke(@os.l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((C0355a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class b<R, C extends um.d<? super R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final AtomicReference<C> f14513a = new AtomicReference<>(null);

        public final boolean b(R r10) {
            C andSet = this.f14513a.getAndSet(null);
            if (andSet == null) {
                return false;
            }
            c1.a aVar = c1.Companion;
            andSet.resumeWith(c1.m59constructorimpl(r10));
            return true;
        }

        @m
        public final Object c(@os.l C c10, @os.l jn.a<Boolean> aVar) {
            l0.p(c10, "continuation");
            l0.p(aVar, "condition");
            if (!aVar.invoke().booleanValue()) {
                return null;
            }
            if (!g0.e.a(this.f14513a, null, c10)) {
                throw new IllegalStateException("Continuation is already set");
            }
            if (aVar.invoke().booleanValue() || !g0.e.a(this.f14513a, c10, null)) {
                return wm.a.COROUTINE_SUSPENDED;
            }
            return null;
        }
    }

    @xm.f(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {70, 75, 85}, m = "process", n = {"this", "mb", "selector", "this", "mb", "selector", "this", "mb", "selector"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class c extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.J1(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", i = {0, 0}, l = {161}, m = "receiveOrNullSuspend", n = {"this", "$this$receiveOrNullSuspend"}, s = {"L$0", "L$1"})
    public static final class d extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.f2(null, this);
        }
    }

    @xm.f(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", i = {0, 0}, l = {206}, m = "select", n = {"this", "selector"}, s = {"L$0", "L$1"})
    public static final class e extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.g2(null, this);
        }
    }

    public a(@os.l um.g gVar) {
        l0.p(gVar, "context");
        this.f14509d = new AtomicLong();
        this.f14510e = new b<>();
        this.f14511f = new rk.d<>();
        this.f14512g = gVar.plus(new r0("selector"));
        nq.k.f(this, null, null, new C0355a(null), 3, null);
    }

    public final Object D1(um.d<? super l2> dVar) {
        d4.a(dVar);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0076  */
    /* JADX WARN: Code duplicated, block: B:25:0x008b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0094  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x007d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0094 -> B:19:0x0072). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ae -> B:19:0x0072). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00be -> B:19:0x0072). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00ee -> B:44:0x00f1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:53:0x007d
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object J1(rk.d<rk.h> r10, java.nio.channels.Selector r11, um.d<? super lm.l2> r12) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rk.a.J1(rk.d, java.nio.channels.Selector, um.d):java.lang.Object");
    }

    @Override // rk.l
    public void O(@os.l h hVar) {
        l0.p(hVar, "selectable");
        try {
            if (!this.f14511f.a(hVar)) {
                if (!hVar.a().isOpen()) {
                    throw new ClosedChannelException();
                }
                throw new ClosedSelectorException();
            }
            if (this.f14510e.b(l2.f10208a)) {
                return;
            }
            h2();
        } catch (Throwable th2) {
            k(hVar, th2);
        }
    }

    @Override // rk.j
    public void R1(@os.l h hVar) {
        SelectionKey selectionKeyKeyFor;
        l0.p(hVar, s.f13016a);
        k(hVar, new ClosedChannelException());
        Selector selector = this.selectorRef;
        if (selector == null || (selectionKeyKeyFor = hVar.a().keyFor(selector)) == null) {
            return;
        }
        selectionKeyKeyFor.cancel();
        h2();
    }

    public final void S1(rk.d<h> dVar, Selector selector) {
        while (true) {
            h hVarD = dVar.d();
            if (hVarD == null) {
                return;
            } else {
                b(selector, hVarD);
            }
        }
    }

    public final Object Y1(rk.d<h> dVar, um.d<? super h> dVar2) {
        h hVarD = dVar.d();
        return hVarD == null ? f2(dVar, dVar2) : hVarD;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.f14511f.b();
        if (this.f14510e.b(l2.f10208a)) {
            return;
        }
        h2();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f2(rk.d<h> dVar, um.d<? super h> dVar2) {
        d dVar3;
        Object obj;
        if (dVar2 instanceof d) {
            dVar3 = (d) dVar2;
            int i10 = dVar3.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar3.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar3 = new d(dVar2);
            }
        } else {
            dVar3 = new d(dVar2);
        }
        Object obj2 = dVar3.result;
        Object obj3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar3.label;
        if (i11 == 0) {
            d1.n(obj2);
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rk.d<h> dVar4 = (rk.d) dVar3.L$1;
            a aVar = (a) dVar3.L$0;
            d1.n(obj2);
            dVar = dVar4;
            this = aVar;
        }
        do {
            h hVarD = dVar.d();
            if (hVarD != null) {
                return hVarD;
            }
            obj = null;
            if (this.closed) {
                return null;
            }
            dVar3.L$0 = this;
            dVar3.L$1 = dVar;
            dVar3.label = 1;
            b<l2, um.d<l2>> bVar = this.f14510e;
            if (dVar.c() && !this.closed) {
                if (!g0.e.a(bVar.f14513a, null, dVar3)) {
                    throw new IllegalStateException("Continuation is already set");
                }
                if ((dVar.c() && !this.closed) || !g0.e.a(bVar.f14513a, dVar3, null)) {
                    obj = wm.a.COROUTINE_SUSPENDED;
                }
            }
            if (obj == null) {
                obj = l2.f10208a;
            }
            if (obj == wm.a.COROUTINE_SUSPENDED) {
                xm.h.c(dVar3);
            }
        } while (obj != obj3);
        return obj3;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g2(Selector selector, um.d<? super Integer> dVar) throws IOException {
        e eVar;
        int iSelectNow;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            d1.n(obj);
            this.inSelect = true;
            eVar.L$0 = this;
            eVar.L$1 = selector;
            eVar.label = 1;
            if (d4.a(eVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            selector = (Selector) eVar.L$1;
            this = (a) eVar.L$0;
            d1.n(obj);
        }
        if (this.f14509d.get() == 0) {
            iSelectNow = selector.select(500L);
            this.inSelect = false;
        } else {
            this.inSelect = false;
            this.f14509d.set(0L);
            iSelectNow = selector.selectNow();
        }
        return new Integer(iSelectNow);
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f14512g;
    }

    public final void h2() {
        Selector selector;
        if (this.f14509d.incrementAndGet() == 1 && this.inSelect && (selector = this.selectorRef) != null) {
            selector.wakeup();
        }
    }
}
