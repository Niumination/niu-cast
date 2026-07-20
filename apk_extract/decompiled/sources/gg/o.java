package gg;

import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f5190a;

    static {
        boolean z2;
        try {
            Class.forName("java.net.StandardSocketOptions");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f5190a = z2;
    }

    public static final void a(AbstractSelectableChannel abstractSelectableChannel, y options) throws IOException {
        Intrinsics.checkNotNullParameter(abstractSelectableChannel, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        boolean z2 = abstractSelectableChannel instanceof SocketChannel;
        boolean z3 = f5190a;
        if (z2) {
            options.getClass();
            if (!UByte.m184equalsimpl0((byte) 0, (byte) 0)) {
                if (z3) {
                    ((SocketChannel) abstractSelectableChannel).setOption((SocketOption<int>) StandardSocketOptions.IP_TOS, 0);
                } else {
                    ((SocketChannel) abstractSelectableChannel).socket().setTrafficClass(0);
                }
            }
            if (options instanceof w) {
            }
            if (options instanceof x) {
                x xVar = (x) options;
                int i8 = xVar.f5205c;
                Integer numValueOf = Integer.valueOf(i8);
                if (i8 < 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    if (z3) {
                        ((SocketChannel) abstractSelectableChannel).setOption((SocketOption<Integer>) StandardSocketOptions.SO_LINGER, Integer.valueOf(iIntValue));
                    } else {
                        ((SocketChannel) abstractSelectableChannel).socket().setSoLinger(true, iIntValue);
                    }
                }
                if (z3) {
                    ((SocketChannel) abstractSelectableChannel).setOption((SocketOption<Boolean>) StandardSocketOptions.TCP_NODELAY, Boolean.valueOf(xVar.f5204b));
                } else {
                    ((SocketChannel) abstractSelectableChannel).socket().setTcpNoDelay(xVar.f5204b);
                }
            }
        }
        if (abstractSelectableChannel instanceof ServerSocketChannel) {
            options.getClass();
        }
        if (abstractSelectableChannel instanceof DatagramChannel) {
            options.getClass();
            if (!UByte.m184equalsimpl0((byte) 0, (byte) 0)) {
                if (z3) {
                    ((DatagramChannel) abstractSelectableChannel).setOption((SocketOption<int>) StandardSocketOptions.IP_TOS, 0);
                } else {
                    ((DatagramChannel) abstractSelectableChannel).socket().setTrafficClass(0);
                }
            }
            if (options instanceof w) {
            }
        }
    }
}
