package sk;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import lm.d1;

/* JADX INFO: loaded from: classes2.dex */
public final class d0<S extends SocketChannel> extends x<S> implements b0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final S f15111x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final Socket f15112y;

    @xm.f(c = "io.ktor.network.sockets.SocketImpl", f = "SocketImpl.kt", i = {0, 1}, l = {35, ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX}, m = "connect$ktor_network", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ d0<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(d0<? extends S> d0Var, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = d0Var;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.J1(null, this);
        }
    }

    public /* synthetic */ d0(SocketChannel socketChannel, Socket socket, rk.j jVar, e0.e eVar, int i10, kn.w wVar) {
        this(socketChannel, socket, jVar, (i10 & 8) != 0 ? null : eVar);
    }

    public static /* synthetic */ void g2(d0 d0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        d0Var.f2(z10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object J1(@os.l SocketAddress socketAddress, @os.l um.d<? super b0> dVar) throws IOException {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            if (this.f15111x.connect(socketAddress)) {
                return this;
            }
            f2(true);
            rk.j jVar = this.f15162f;
            rk.g gVar = rk.g.CONNECT;
            aVar.L$0 = this;
            aVar.label = 1;
            if (jVar.K(this, gVar, aVar) == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (d0) aVar.L$0;
            d1.n(obj);
        }
        while (true) {
            if (!this.f15111x.finishConnect()) {
                this.f2(true);
                rk.j jVar2 = this.f15162f;
                rk.g gVar2 = rk.g.CONNECT;
                aVar.L$0 = this;
                aVar.label = 2;
                if (jVar2.K(this, gVar2, aVar) == aVar2) {
                    return aVar2;
                }
            } else {
                if (!this.Y1()) {
                    this.f2(false);
                    return this;
                }
                this.f15112y.close();
            }
        }
    }

    @os.l
    public S S1() {
        return this.f15111x;
    }

    public final boolean Y1() {
        InetAddress address;
        String hostAddress;
        InetAddress address2;
        InetAddress address3;
        String hostAddress2;
        if (o() == null || t() == null) {
            throw new IllegalStateException("localAddress and remoteAddress should not be null.");
        }
        SocketAddress socketAddressO = o();
        InetSocketAddress inetSocketAddress = socketAddressO instanceof InetSocketAddress ? (InetSocketAddress) socketAddressO : null;
        String str = "";
        if (inetSocketAddress == null || (address = inetSocketAddress.getAddress()) == null || (hostAddress = address.getHostAddress()) == null) {
            hostAddress = "";
        }
        SocketAddress socketAddressT = t();
        InetSocketAddress inetSocketAddress2 = socketAddressT instanceof InetSocketAddress ? (InetSocketAddress) socketAddressT : null;
        if (inetSocketAddress2 != null && (address3 = inetSocketAddress2.getAddress()) != null && (hostAddress2 = address3.getHostAddress()) != null) {
            str = hostAddress2;
        }
        SocketAddress socketAddressT2 = t();
        InetSocketAddress inetSocketAddress3 = socketAddressT2 instanceof InetSocketAddress ? (InetSocketAddress) socketAddressT2 : null;
        boolean zIsAnyLocalAddress = (inetSocketAddress3 == null || (address2 = inetSocketAddress3.getAddress()) == null) ? false : address2.isAnyLocalAddress();
        if (ml.a.d(o()) == ml.a.d(t())) {
            return zIsAnyLocalAddress || kn.l0.g(hostAddress, str);
        }
        return false;
    }

    @Override // sk.x, rk.i, rk.h
    public SelectableChannel a() {
        return this.f15111x;
    }

    public final void f2(boolean z10) {
        e2(rk.g.CONNECT, z10);
    }

    @Override // sk.a
    @os.l
    public SocketAddress o() {
        SocketAddress localSocketAddress = this.f15112y.getLocalSocketAddress();
        kn.l0.o(localSocketAddress, "socket.localSocketAddress");
        return localSocketAddress;
    }

    @Override // sk.b
    @os.l
    public SocketAddress t() {
        SocketAddress remoteSocketAddress = this.f15112y.getRemoteSocketAddress();
        kn.l0.o(remoteSocketAddress, "socket.remoteSocketAddress");
        return remoteSocketAddress;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(@os.l S s10, @os.l Socket socket, @os.l rk.j jVar, @os.m e0.e eVar) {
        super(s10, jVar, null, eVar);
        kn.l0.p(s10, "channel");
        kn.l0.p(socket, t2.a.f15434a);
        kn.l0.p(jVar, "selector");
        this.f15111x = s10;
        this.f15112y = socket;
        if (s10.isBlocking()) {
            throw new IllegalArgumentException("Channel need to be configured as non-blocking.");
        }
    }
}
