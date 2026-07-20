package sk;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    @os.l
    public static final g a(@os.l m0.a aVar, @os.l rk.j jVar, @os.m SocketAddress socketAddress, @os.l e0.f fVar) throws IOException {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(jVar, "selector");
        kn.l0.p(fVar, "options");
        DatagramChannel datagramChannelOpenDatagramChannel = jVar.z().openDatagramChannel();
        try {
            kn.l0.o(datagramChannelOpenDatagramChannel, "");
            w.a(datagramChannelOpenDatagramChannel, fVar);
            w.b(datagramChannelOpenDatagramChannel);
            datagramChannelOpenDatagramChannel.socket().bind(socketAddress);
            return new u(datagramChannelOpenDatagramChannel, jVar);
        } catch (Throwable th2) {
            datagramChannelOpenDatagramChannel.close();
            throw th2;
        }
    }

    @os.l
    public static final m b(@os.l m0.a aVar, @os.l rk.j jVar, @os.l SocketAddress socketAddress, @os.m SocketAddress socketAddress2, @os.l e0.f fVar) throws IOException {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(jVar, "selector");
        kn.l0.p(socketAddress, "remoteAddress");
        kn.l0.p(fVar, "options");
        DatagramChannel datagramChannelOpenDatagramChannel = jVar.z().openDatagramChannel();
        try {
            kn.l0.o(datagramChannelOpenDatagramChannel, "");
            w.a(datagramChannelOpenDatagramChannel, fVar);
            w.b(datagramChannelOpenDatagramChannel);
            datagramChannelOpenDatagramChannel.socket().bind(socketAddress2);
            datagramChannelOpenDatagramChannel.connect(socketAddress);
            return new u(datagramChannelOpenDatagramChannel, jVar);
        } catch (Throwable th2) {
            datagramChannelOpenDatagramChannel.close();
            throw th2;
        }
    }
}
