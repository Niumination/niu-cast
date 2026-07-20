package sk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f15160a = "SO_REUSEPORT";

    public static final void a(@os.l SelectableChannel selectableChannel, @os.l e0 e0Var) throws IllegalAccessException, IOException, InvocationTargetException {
        kn.l0.p(selectableChannel, "<this>");
        kn.l0.p(e0Var, "options");
        if (selectableChannel instanceof SocketChannel) {
            SocketChannel socketChannel = (SocketChannel) selectableChannel;
            Socket socket = socketChannel.socket();
            kn.l0.m(socket);
            byte b10 = e0Var.f15115b;
            l0.f15134b.getClass();
            if (!l0.j(b10, l0.f15135c)) {
                socket.setTrafficClass(e0Var.f15115b & 255);
            }
            socket.setReuseAddress(e0Var.f15116c);
            if (e0Var.f15117d) {
                g0.f15127a.c(socketChannel);
            }
            if (e0Var instanceof e0.d) {
                e0.d dVar = (e0.d) e0Var;
                Integer numValueOf = Integer.valueOf(dVar.f15120g);
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    socket.setReceiveBufferSize(numValueOf.intValue());
                }
                Integer numValueOf2 = Integer.valueOf(dVar.f15119f);
                if (numValueOf2.intValue() <= 0) {
                    numValueOf2 = null;
                }
                if (numValueOf2 != null) {
                    socket.setSendBufferSize(numValueOf2.intValue());
                }
            }
            if (e0Var instanceof e0.e) {
                e0.e eVar = (e0.e) e0Var;
                Integer numValueOf3 = Integer.valueOf(eVar.f15122i);
                if (numValueOf3.intValue() < 0) {
                    numValueOf3 = null;
                }
                if (numValueOf3 != null) {
                    socket.setSoLinger(true, numValueOf3.intValue());
                }
                Boolean bool = eVar.f15123j;
                if (bool != null) {
                    socket.setKeepAlive(bool.booleanValue());
                }
                socket.setTcpNoDelay(eVar.f15121h);
            }
        }
        if (selectableChannel instanceof ServerSocketChannel) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectableChannel;
            ServerSocket serverSocketSocket = serverSocketChannel.socket();
            kn.l0.m(serverSocketSocket);
            if (e0Var.f15116c) {
                serverSocketSocket.setReuseAddress(true);
            }
            if (e0Var.f15117d) {
                g0.f15127a.b(serverSocketChannel);
            }
        }
        if (selectableChannel instanceof DatagramChannel) {
            DatagramChannel datagramChannel = (DatagramChannel) selectableChannel;
            DatagramSocket datagramSocketSocket = datagramChannel.socket();
            kn.l0.m(datagramSocketSocket);
            byte b11 = e0Var.f15115b;
            l0.f15134b.getClass();
            if (!l0.j(b11, l0.f15135c)) {
                datagramSocketSocket.setTrafficClass(e0Var.f15115b & 255);
            }
            if (e0Var.f15116c) {
                datagramSocketSocket.setReuseAddress(true);
            }
            if (e0Var.f15117d) {
                g0.f15127a.a(datagramChannel);
            }
            if (e0Var instanceof e0.f) {
                datagramSocketSocket.setBroadcast(((e0.f) e0Var).f15125h);
            }
            if (e0Var instanceof e0.d) {
                e0.d dVar2 = (e0.d) e0Var;
                Integer numValueOf4 = Integer.valueOf(dVar2.f15120g);
                if (numValueOf4.intValue() <= 0) {
                    numValueOf4 = null;
                }
                if (numValueOf4 != null) {
                    datagramSocketSocket.setReceiveBufferSize(numValueOf4.intValue());
                }
                Integer numValueOf5 = Integer.valueOf(dVar2.f15119f);
                Integer num = numValueOf5.intValue() > 0 ? numValueOf5 : null;
                if (num == null) {
                    return;
                }
                datagramSocketSocket.setSendBufferSize(num.intValue());
            }
        }
    }

    public static final void b(@os.l SelectableChannel selectableChannel) throws IOException {
        kn.l0.p(selectableChannel, "<this>");
        selectableChannel.configureBlocking(false);
    }
}
