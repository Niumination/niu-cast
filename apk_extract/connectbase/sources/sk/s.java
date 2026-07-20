package sk;

import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import lm.a1;
import lm.d1;
import lm.l2;
import nq.a2;
import nq.k1;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements pq.g0<o> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15150d = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "onCloseHandler");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15151e = AtomicIntegerFieldUpdater.newUpdater(s.class, "closed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final DatagramChannel f15152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final u f15153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ar.a f15154c;

    @os.l
    private volatile /* synthetic */ int closed;

    @os.l
    private volatile /* synthetic */ Object closedCause;

    @os.l
    private volatile /* synthetic */ Object onCloseHandler;

    @xm.f(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", i = {0, 0, 0, 1}, l = {161, 77}, m = "send", n = {"this", "element", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return s.this.L(null, this);
        }
    }

    @xm.f(c = "io.ktor.network.sockets.DatagramSendChannel$send$2$1", f = "DatagramSendChannel.kt", i = {0, 0}, l = {87}, m = "invokeSuspend", n = {"$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1"})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ o $element;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ s this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o oVar, s sVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$element = oVar;
            this.this$0 = sVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new b(this.$element, this.this$0, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            Object obj2;
            Throwable th2;
            bm.h hVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                bm.h<ByteBuffer> hVarF = tk.c.f();
                o oVar = this.$element;
                s sVar = this.this$0;
                ByteBuffer byteBufferW0 = hVarF.W0();
                try {
                    ByteBuffer byteBuffer = byteBufferW0;
                    t.f(oVar, byteBuffer);
                    if (sVar.f15152a.send(byteBuffer, oVar.f15148b) != 0) {
                        sVar.f15153b.e2(rk.g.WRITE, false);
                    } else {
                        SocketAddress socketAddress = oVar.f15148b;
                        this.L$0 = hVarF;
                        this.L$1 = byteBufferW0;
                        this.label = 1;
                        if (sVar.n(byteBuffer, socketAddress, this) == aVar) {
                            return aVar;
                        }
                    }
                    hVar = hVarF;
                    obj2 = byteBufferW0;
                } catch (Throwable th3) {
                    obj2 = byteBufferW0;
                    th2 = th3;
                    hVar = hVarF;
                    hVar.recycle(obj2);
                    throw th2;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.L$1;
                hVar = (bm.h) this.L$0;
                try {
                    d1.n(obj);
                } catch (Throwable th4) {
                    th2 = th4;
                    hVar.recycle(obj2);
                    throw th2;
                }
            }
            l2 l2Var = l2.f10208a;
            hVar.recycle(obj2);
            return l2Var;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", i = {0, 0, 0}, l = {96}, m = "sendSuspend", n = {"this", "buffer", "address"}, s = {"L$0", "L$1", "L$2"})
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
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return s.this.n(null, null, this);
        }
    }

    public s(@os.l DatagramChannel datagramChannel, @os.l u uVar) {
        kn.l0.p(datagramChannel, "channel");
        kn.l0.p(uVar, t2.a.f15434a);
        this.f15152a = datagramChannel;
        this.f15153b = uVar;
        this.onCloseHandler = null;
        this.closed = 0;
        this.closedCause = null;
        this.f15154c = ar.c.b(false, 1, null);
    }

    @a2
    public static /* synthetic */ void j() {
    }

    @Override // pq.g0
    public boolean J() {
        return i0.c(this.f15153b);
    }

    public final void e() {
        do {
            jn.l lVar = (jn.l) this.onCloseHandler;
            if (lVar == t.f15156b) {
                return;
            }
            if (lVar != null) {
                if (!j.d.a(f15150d, this, lVar, t.f15156b)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                lVar.invoke(this.closedCause);
                return;
            }
        } while (!j.d.a(f15150d, this, null, t.f15155a));
    }

    @Override // pq.g0
    public boolean f(@os.m Throwable th2) {
        if (!f15151e.compareAndSet(this, 0, 1)) {
            return false;
        }
        this.closedCause = th2;
        if (!i0.c(this.f15153b)) {
            this.f15153b.close();
        }
        e();
        return true;
    }

    @os.l
    public final DatagramChannel g() {
        return this.f15152a;
    }

    @os.l
    public final u h() {
        return this.f15153b;
    }

    @Override // pq.g0
    @a2
    public void i(@os.l jn.l<? super Throwable, l2> lVar) {
        kn.l0.p(lVar, "handler");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15150d;
        if (j.d.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            return;
        }
        if (this.onCloseHandler != t.f15155a) {
            t.e((jn.l) this.onCloseHandler);
        } else {
            if (!j.d.a(atomicReferenceFieldUpdater, this, t.f15155a, t.f15156b)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            lVar.invoke(this.closedCause);
        }
    }

    @lm.k(level = lm.m.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean k(@os.l o oVar) {
        return pq.g0.a.c(this, oVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // pq.g0
    @os.m
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Object L(@os.l o oVar, @os.l um.d<? super l2> dVar) throws Throwable {
        a aVar;
        ar.a aVar2;
        ar.a aVar3;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar4 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                aVar2 = this.f15154c;
                aVar.L$0 = this;
                aVar.L$1 = oVar;
                aVar.L$2 = aVar2;
                aVar.label = 1;
                if (aVar2.h(null, aVar) == aVar4) {
                    return aVar4;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar3 = (ar.a) aVar.L$0;
                    try {
                        d1.n(obj);
                        l2 l2Var = l2.f10208a;
                        aVar3.f(null);
                        return l2Var;
                    } catch (Throwable th2) {
                        th = th2;
                        aVar3.f(null);
                        throw th;
                    }
                }
                ar.a aVar5 = (ar.a) aVar.L$2;
                oVar = (o) aVar.L$1;
                s sVar = (s) aVar.L$0;
                d1.n(obj);
                aVar2 = aVar5;
                this = sVar;
            }
            nq.n0 n0VarC = k1.c();
            b bVar = new b(oVar, this, null);
            aVar.L$0 = aVar2;
            aVar.L$1 = null;
            aVar.L$2 = null;
            aVar.label = 2;
            if (nq.k.g(n0VarC, bVar, aVar) == aVar4) {
                return aVar4;
            }
            aVar3 = aVar2;
            l2 l2Var2 = l2.f10208a;
            aVar3.f(null);
            return l2Var2;
        } catch (Throwable th3) {
            th = th3;
            aVar3 = aVar2;
            aVar3.f(null);
            throw th;
        }
    }

    @Override // pq.g0
    @os.l
    public yq.i<o, pq.g0<o>> m() {
        throw new lm.j0(kn.l0.C("An operation is not implemented: ", "[DatagramSendChannel] doesn't support [onSend] select clause"));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0063  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0058 -> B:18:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object n(java.nio.ByteBuffer r7, java.net.SocketAddress r8, um.d<? super lm.l2> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof sk.s.c
            if (r0 == 0) goto L13
            r0 = r9
            sk.s$c r0 = (sk.s.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            sk.s$c r0 = new sk.s$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.L$2
            java.net.SocketAddress r6 = (java.net.SocketAddress) r6
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            sk.s r8 = (sk.s) r8
            lm.d1.n(r9)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L5b
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            lm.d1.n(r9)
        L41:
            sk.u r9 = r6.f15153b
            rk.g r2 = rk.g.WRITE
            r9.e2(r2, r3)
            sk.u r9 = r6.f15153b
            rk.j r4 = r9.f15162f
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r9 = r4.K(r9, r2, r0)
            if (r9 != r1) goto L5b
            return r1
        L5b:
            java.nio.channels.DatagramChannel r9 = r6.f15152a
            int r9 = r9.send(r7, r8)
            if (r9 == 0) goto L41
            sk.u r6 = r6.f15153b
            rk.g r7 = rk.g.WRITE
            r8 = 0
            r6.e2(r7, r8)
            lm.l2 r6 = lm.l2.f10208a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sk.s.n(java.nio.ByteBuffer, java.net.SocketAddress, um.d):java.lang.Object");
    }

    @Override // pq.g0
    public boolean offer(o oVar) {
        return pq.g0.a.c(this, oVar);
    }

    @os.l
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Object o(@os.l o oVar) {
        kn.l0.p(oVar, "element");
        if (!ar.a.C0021a.c(this.f15154c, null, 1, null)) {
            pq.p.f13308b.getClass();
            return pq.p.f13309c;
        }
        try {
            bm.h<ByteBuffer> hVarF = tk.c.f();
            ByteBuffer byteBufferW0 = hVarF.W0();
            try {
                ByteBuffer byteBuffer = byteBufferW0;
                tl.p.k(oVar.f15147a.N2(), byteBuffer);
                boolean z10 = this.f15152a.send(byteBuffer, oVar.f15148b) == 0;
                l2 l2Var = l2.f10208a;
                hVarF.recycle(byteBufferW0);
                ar.a.C0021a.d(this.f15154c, null, 1, null);
                if (z10) {
                    oVar.f15147a.z2();
                }
                return pq.p.f13308b.success-PtdJZtk(l2Var);
            } catch (Throwable th2) {
                hVarF.recycle(byteBufferW0);
                throw th2;
            }
        } catch (Throwable th3) {
            ar.a.C0021a.d(this.f15154c, null, 1, null);
            throw th3;
        }
    }
}
