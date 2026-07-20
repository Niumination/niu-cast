package sk;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import nq.l2;
import nq.r2;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements z, rk.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ServerSocketChannel f15105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final rk.j f15106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ rk.i f15107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final nq.b0 f15108d;

    @xm.f(c = "io.ktor.network.sockets.ServerSocketImpl", f = "ServerSocketImpl.kt", i = {0}, l = {34}, m = "acceptSuspend", n = {"this"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
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
            return a0.this.b(this);
        }
    }

    public a0(@os.l ServerSocketChannel serverSocketChannel, @os.l rk.j jVar) {
        kn.l0.p(serverSocketChannel, "channel");
        kn.l0.p(jVar, "selector");
        this.f15105a = serverSocketChannel;
        this.f15106b = jVar;
        this.f15107c = new rk.i(serverSocketChannel);
        if (serverSocketChannel.isBlocking()) {
            throw new IllegalArgumentException("Channel need to be configured as non-blocking.");
        }
        this.f15108d = r2.c(null, 1, null);
    }

    @Override // sk.f
    @os.m
    public Object M1(@os.l um.d<? super b0> dVar) throws IOException {
        SocketChannel socketChannelAccept = this.f15105a.accept();
        return socketChannelAccept == null ? b(dVar) : c(socketChannelAccept);
    }

    @Override // sk.d
    public l2 O1() {
        return this.f15108d;
    }

    @Override // rk.h
    public int X() {
        return this.f15107c.X();
    }

    @Override // rk.h
    public SelectableChannel a() {
        return this.f15105a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0045 -> B:18:0x0048). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object b(um.d<? super sk.b0> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof sk.a0.a
            if (r0 == 0) goto L13
            r0 = r5
            sk.a0$a r0 = (sk.a0.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            sk.a0$a r0 = new sk.a0$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            sk.a0 r4 = (sk.a0) r4
            lm.d1.n(r5)
            goto L48
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            lm.d1.n(r5)
        L36:
            rk.g r5 = rk.g.ACCEPT
            r4.e2(r5, r3)
            rk.j r2 = r4.f15106b
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r2.K(r4, r5, r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            java.nio.channels.ServerSocketChannel r5 = r4.f15105a
            java.nio.channels.SocketChannel r5 = r5.accept()
            if (r5 != 0) goto L51
            goto L36
        L51:
            sk.b0 r4 = r4.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sk.a0.b(um.d):java.lang.Object");
    }

    public final b0 c(SocketChannel socketChannel) throws IOException {
        e2(rk.g.ACCEPT, false);
        Socket socket = socketChannel.socket();
        kn.l0.m(socket);
        socketChannel.configureBlocking(false);
        socket.setTcpNoDelay(true);
        return new d0(socketChannel, socket, this.f15106b, null, 8, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            try {
                this.f15105a.close();
                this.f15106b.R1(this);
                this.f15108d.complete();
            } catch (Throwable th2) {
                this.f15106b.R1(this);
                throw th2;
            }
        } catch (Throwable th3) {
            this.f15108d.k(th3);
        }
    }

    @Override // sk.d, nq.n1
    public void dispose() {
        z.a.a(this);
    }

    @Override // rk.h
    public void e2(@os.l rk.g gVar, boolean z10) {
        kn.l0.p(gVar, "interest");
        this.f15107c.e2(gVar, z10);
    }

    @os.l
    public ServerSocketChannel h() {
        return this.f15105a;
    }

    @os.l
    public final rk.j n() {
        return this.f15106b;
    }

    @Override // sk.a
    @os.l
    public SocketAddress o() {
        SocketAddress localSocketAddress = this.f15105a.socket().getLocalSocketAddress();
        kn.l0.o(localSocketAddress, "channel.socket().localSocketAddress");
        return localSocketAddress;
    }

    @os.l
    public nq.b0 p() {
        return this.f15108d;
    }

    @Override // rk.h
    @os.l
    public rk.c w() {
        return this.f15107c.w();
    }
}
