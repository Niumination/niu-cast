package sk;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import lm.d1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    @xm.f(c = "io.ktor.network.sockets.ConnectUtilsJvmKt", f = "ConnectUtilsJvm.kt", i = {0}, l = {19}, m = "connect", n = {"result$iv"}, s = {"L$0"})
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
            return l.b(null, null, null, this);
        }
    }

    @os.l
    public static final z a(@os.l rk.j jVar, @os.m SocketAddress socketAddress, @os.l e0.a aVar) throws IOException {
        kn.l0.p(jVar, "selector");
        kn.l0.p(aVar, "socketOptions");
        ServerSocketChannel serverSocketChannelOpenServerSocketChannel = jVar.z().openServerSocketChannel();
        try {
            kn.l0.o(serverSocketChannelOpenServerSocketChannel, "");
            w.a(serverSocketChannelOpenServerSocketChannel, aVar);
            w.b(serverSocketChannelOpenServerSocketChannel);
            a0 a0Var = new a0(serverSocketChannelOpenServerSocketChannel, jVar);
            a0Var.f15105a.socket().bind(socketAddress, aVar.f15118f);
            return a0Var;
        } catch (Throwable th2) {
            serverSocketChannelOpenServerSocketChannel.close();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object b(@os.l rk.j jVar, @os.l SocketAddress socketAddress, @os.l e0.e eVar, @os.l um.d<? super b0> dVar) throws Throwable {
        a aVar;
        Closeable closeable;
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
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(obj);
            SocketChannel socketChannelOpenSocketChannel = jVar.z().openSocketChannel();
            try {
                kn.l0.o(socketChannelOpenSocketChannel, "");
                w.a(socketChannelOpenSocketChannel, eVar);
                w.b(socketChannelOpenSocketChannel);
                Socket socket = socketChannelOpenSocketChannel.socket();
                kn.l0.m(socket);
                d0 d0Var = new d0(socketChannelOpenSocketChannel, socket, jVar, eVar);
                aVar.L$0 = socketChannelOpenSocketChannel;
                aVar.L$1 = d0Var;
                aVar.label = 1;
                return d0Var.J1(socketAddress, aVar) == aVar2 ? aVar2 : d0Var;
            } catch (Throwable th2) {
                th = th2;
                closeable = socketChannelOpenSocketChannel;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0 d0Var2 = (d0) aVar.L$1;
            closeable = (Closeable) aVar.L$0;
            try {
                d1.n(obj);
                return d0Var2;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        closeable.close();
        throw th;
    }
}
