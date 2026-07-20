package sk;

import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import lm.l2;
import nq.k1;
import tl.r0;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends x<DatagramChannel> implements g, m {

    @os.l
    public final pq.f0<o> H;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final DatagramChannel f15157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final DatagramSocket f15158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final pq.g0<o> f15159z;

    @xm.f(c = "io.ktor.network.sockets.DatagramSocketImpl", f = "DatagramSocketImpl.kt", i = {}, l = {77}, m = "receiveSuspend", n = {}, s = {})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
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
            return u.this.h2(null, this);
        }
    }

    @xm.f(c = "io.ktor.network.sockets.DatagramSocketImpl$receiver$1", f = "DatagramSocketImpl.kt", i = {0, 1}, l = {40, 40}, m = "invokeSuspend", n = {"$this$produce", "$this$produce"}, s = {"L$0", "L$0"})
    public static final class b extends xm.o implements jn.p<pq.d0<? super o>, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public b(um.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = u.this.new b(dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0042 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x0043  */
        /* JADX WARN: Code duplicated, block: B:21:0x0053 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x0054  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0054 -> B:15:0x0030). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
            /*
                r7 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r1 = r7.L$0
                pq.d0 r1 = (pq.d0) r1
                lm.d1.n(r8)     // Catch: java.nio.channels.ClosedChannelException -> L56
                r8 = r1
                goto L30
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1d:
                java.lang.Object r1 = r7.L$1
                pq.g0 r1 = (pq.g0) r1
                java.lang.Object r4 = r7.L$0
                pq.d0 r4 = (pq.d0) r4
                lm.d1.n(r8)     // Catch: java.nio.channels.ClosedChannelException -> L56
                goto L46
            L29:
                lm.d1.n(r8)
                java.lang.Object r8 = r7.L$0
                pq.d0 r8 = (pq.d0) r8
            L30:
                pq.g0 r1 = r8.a()     // Catch: java.nio.channels.ClosedChannelException -> L56
                sk.u r4 = sk.u.this     // Catch: java.nio.channels.ClosedChannelException -> L56
                r7.L$0 = r8     // Catch: java.nio.channels.ClosedChannelException -> L56
                r7.L$1 = r1     // Catch: java.nio.channels.ClosedChannelException -> L56
                r7.label = r3     // Catch: java.nio.channels.ClosedChannelException -> L56
                java.lang.Object r4 = sk.u.J1(r4, r7)     // Catch: java.nio.channels.ClosedChannelException -> L56
                if (r4 != r0) goto L43
                return r0
            L43:
                r6 = r4
                r4 = r8
                r8 = r6
            L46:
                r7.L$0 = r4     // Catch: java.nio.channels.ClosedChannelException -> L56
                r5 = 0
                r7.L$1 = r5     // Catch: java.nio.channels.ClosedChannelException -> L56
                r7.label = r2     // Catch: java.nio.channels.ClosedChannelException -> L56
                java.lang.Object r8 = r1.L(r8, r7)     // Catch: java.nio.channels.ClosedChannelException -> L56
                if (r8 != r0) goto L54
                return r0
            L54:
                r8 = r4
                goto L30
            L56:
                lm.l2 r7 = lm.l2.f10208a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: sk.u.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pq.d0<? super o> d0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@os.l DatagramChannel datagramChannel, @os.l rk.j jVar) {
        super(datagramChannel, jVar, tk.c.f(), null, 8, null);
        kn.l0.p(datagramChannel, "channel");
        kn.l0.p(jVar, "selector");
        this.f15157x = datagramChannel;
        DatagramSocket datagramSocketSocket = datagramChannel.socket();
        kn.l0.m(datagramSocketSocket);
        this.f15158y = datagramSocketSocket;
        this.f15159z = new s(datagramChannel, this);
        this.H = pq.b0.f(this, k1.c(), 0, new b(null), 2, null);
    }

    public static /* synthetic */ void f2() {
    }

    @os.l
    public DatagramChannel Y1() {
        return this.f15157x;
    }

    @Override // sk.x, rk.i, rk.h
    public SelectableChannel a() {
        return this.f15157x;
    }

    @Override // sk.v
    @os.m
    public Object c(@os.l o oVar, @os.l um.d<? super l2> dVar) {
        return g.a.c(this, oVar, dVar);
    }

    @Override // sk.x, rk.i, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        pq.f0.a.b(this.H, null, 1, null);
        super.close();
        pq.g0.a.a(this.f15159z, null, 1, null);
    }

    @Override // sk.q
    @os.l
    public pq.f0<o> d() {
        return this.H;
    }

    public final Object g2(um.d<? super o> dVar) {
        ByteBuffer byteBufferW0 = tk.c.f().W0();
        try {
            SocketAddress socketAddressReceive = this.f15157x.receive(byteBufferW0);
            if (socketAddressReceive == null) {
                return h2(byteBufferW0, dVar);
            }
            e2(rk.g.READ, false);
            byteBufferW0.flip();
            tl.s sVarA = w0.a(0);
            try {
                r0.a(sVarA, byteBufferW0);
                o oVar = new o(sVarA.z2(), socketAddressReceive);
                tk.c.f15780e.recycle(byteBufferW0);
                return oVar;
            } catch (Throwable th2) {
                sVarA.close();
                throw th2;
            }
        } catch (Throwable th3) {
            tk.c.f15780e.recycle(byteBufferW0);
            throw th3;
        }
    }

    @Override // sk.v
    @os.l
    public pq.g0<o> h() {
        return this.f15159z;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x005a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:31:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object h2(java.nio.ByteBuffer r6, um.d<? super sk.o> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sk.u.a
            if (r0 == 0) goto L13
            r0 = r7
            sk.u$a r0 = (sk.u.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            sk.u$a r0 = new sk.u$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r6 = r0.L$0
            sk.u r6 = (sk.u) r6
            lm.d1.n(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L51
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            lm.d1.n(r7)
        L3d:
            rk.g r7 = rk.g.READ
            r5.e2(r7, r3)
            rk.j r2 = r5.f15162f
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.K(r5, r7, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            java.nio.channels.DatagramChannel r7 = r5.f15157x     // Catch: java.lang.Throwable -> L80
            java.net.SocketAddress r7 = r7.receive(r6)     // Catch: java.lang.Throwable -> L80
            if (r7 != 0) goto L5a
            goto L3d
        L5a:
            rk.g r0 = rk.g.READ
            r1 = 0
            r5.e2(r0, r1)
            r6.flip()
            tl.s r5 = tl.w0.a(r1)
            tl.r0.a(r5, r6)     // Catch: java.lang.Throwable -> L7b
            tl.v r5 = r5.z2()     // Catch: java.lang.Throwable -> L7b
            sk.o r0 = new sk.o
            r0.<init>(r5, r7)
            bm.h r5 = tk.c.f()
            r5.recycle(r6)
            return r0
        L7b:
            r6 = move-exception
            r5.close()
            throw r6
        L80:
            r5 = move-exception
            bm.h r7 = tk.c.f()
            r7.recycle(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sk.u.h2(java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    @Override // sk.q
    @os.m
    public Object n(@os.l um.d<? super o> dVar) {
        return q.a.a(this, dVar);
    }

    @Override // sk.a
    @os.l
    public SocketAddress o() {
        SocketAddress localSocketAddress = this.f15158y.getLocalSocketAddress();
        if (localSocketAddress != null) {
            return localSocketAddress;
        }
        throw new IllegalStateException("Channel is not yet bound");
    }

    @Override // sk.b
    @os.l
    public SocketAddress t() {
        SocketAddress remoteSocketAddress = this.f15158y.getRemoteSocketAddress();
        if (remoteSocketAddress != null) {
            return remoteSocketAddress;
        }
        throw new IllegalStateException("Channel is not yet connected");
    }
}
