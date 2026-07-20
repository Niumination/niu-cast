package io.netty.channel.epoll;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.Unix;
import io.netty.util.internal.ClassInitializerUtil;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/* JADX INFO: loaded from: classes2.dex */
public final class Native {
    public static final int EPOLLERR;
    public static final int EPOLLET;
    public static final int EPOLLIN;
    public static final int EPOLLOUT;
    public static final int EPOLLRDHUP;
    static final boolean IS_SUPPORTING_RECVMMSG;
    public static final boolean IS_SUPPORTING_SENDMMSG;

    @Deprecated
    public static final boolean IS_SUPPORTING_TCP_FASTOPEN;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    static final boolean IS_SUPPORTING_UDP_SEGMENT;
    public static final String KERNEL_VERSION;
    private static final int TCP_FASTOPEN_MODE;
    public static final int TCP_MD5SIG_MAXKEYLEN;
    private static final int TFO_ENABLED_CLIENT_MASK = 1;
    private static final int TFO_ENABLED_SERVER_MASK = 2;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Native.class);

    static {
        Selector selectorOpen;
        try {
            selectorOpen = Selector.open();
        } catch (IOException unused) {
            selectorOpen = null;
        }
        ClassInitializerUtil.tryLoadClasses(Native.class, PeerCredentials.class, DefaultFileRegion.class, FileChannel.class, FileDescriptor.class, NativeDatagramPacketArray.NativeDatagramPacket.class);
        try {
            try {
                offsetofEpollData();
                if (selectorOpen != null) {
                    try {
                        selectorOpen.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th2) {
                if (selectorOpen != null) {
                    try {
                        selectorOpen.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th2;
            }
        } catch (UnsatisfiedLinkError unused4) {
            loadNativeLibrary();
            if (selectorOpen != null) {
            }
        }
        Unix.registerInternal(new Runnable() { // from class: io.netty.channel.epoll.Native.1
            @Override // java.lang.Runnable
            public void run() {
                Native.registerUnix();
            }
        });
        EPOLLIN = NativeStaticallyReferencedJniMethods.epollin();
        EPOLLOUT = NativeStaticallyReferencedJniMethods.epollout();
        EPOLLRDHUP = NativeStaticallyReferencedJniMethods.epollrdhup();
        EPOLLET = NativeStaticallyReferencedJniMethods.epollet();
        EPOLLERR = NativeStaticallyReferencedJniMethods.epollerr();
        IS_SUPPORTING_SENDMMSG = NativeStaticallyReferencedJniMethods.isSupportingSendmmsg();
        IS_SUPPORTING_RECVMMSG = NativeStaticallyReferencedJniMethods.isSupportingRecvmmsg();
        IS_SUPPORTING_UDP_SEGMENT = isSupportingUdpSegment();
        int iTcpFastopenMode = NativeStaticallyReferencedJniMethods.tcpFastopenMode();
        TCP_FASTOPEN_MODE = iTcpFastopenMode;
        boolean z10 = (iTcpFastopenMode & 1) == 1;
        IS_SUPPORTING_TCP_FASTOPEN_CLIENT = z10;
        boolean z11 = (iTcpFastopenMode & 2) == 2;
        IS_SUPPORTING_TCP_FASTOPEN_SERVER = z11;
        IS_SUPPORTING_TCP_FASTOPEN = z10 || z11;
        TCP_MD5SIG_MAXKEYLEN = NativeStaticallyReferencedJniMethods.tcpMd5SigMaxKeyLen();
        KERNEL_VERSION = NativeStaticallyReferencedJniMethods.kernelVersion();
    }

    private Native() {
    }

    public static int epollBusyWait(io.netty.channel.unix.FileDescriptor fileDescriptor, EpollEventArray epollEventArray) throws IOException {
        int iEpollBusyWait0 = epollBusyWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length());
        if (iEpollBusyWait0 >= 0) {
            return iEpollBusyWait0;
        }
        throw Errors.newIOException("epoll_wait", iEpollBusyWait0);
    }

    private static native int epollBusyWait0(int i10, long j10, int i11);

    private static native int epollCreate();

    public static void epollCtlAdd(int i10, int i11, int i12) throws IOException {
        int iEpollCtlAdd0 = epollCtlAdd0(i10, i11, i12);
        if (iEpollCtlAdd0 < 0) {
            throw Errors.newIOException("epoll_ctl", iEpollCtlAdd0);
        }
    }

    private static native int epollCtlAdd0(int i10, int i11, int i12);

    public static void epollCtlDel(int i10, int i11) throws IOException {
        int iEpollCtlDel0 = epollCtlDel0(i10, i11);
        if (iEpollCtlDel0 < 0) {
            throw Errors.newIOException("epoll_ctl", iEpollCtlDel0);
        }
    }

    private static native int epollCtlDel0(int i10, int i11);

    public static void epollCtlMod(int i10, int i11, int i12) throws IOException {
        int iEpollCtlMod0 = epollCtlMod0(i10, i11, i12);
        if (iEpollCtlMod0 < 0) {
            throw Errors.newIOException("epoll_ctl", iEpollCtlMod0);
        }
    }

    private static native int epollCtlMod0(int i10, int i11, int i12);

    private static native int epollWait(int i10, long j10, int i11, int i12);

    @Deprecated
    public static int epollWait(io.netty.channel.unix.FileDescriptor fileDescriptor, EpollEventArray epollEventArray, io.netty.channel.unix.FileDescriptor fileDescriptor2, int i10, int i11) throws IOException {
        int i12;
        int i13;
        if (i10 == 0 && i11 == 0) {
            return epollWait(fileDescriptor, epollEventArray, 0);
        }
        if (i10 == Integer.MAX_VALUE) {
            i12 = 0;
            i13 = 0;
        } else {
            i12 = i10;
            i13 = i11;
        }
        int iEpollWait0 = epollWait0(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), fileDescriptor2.intValue(), i12, i13);
        if (iEpollWait0 >= 0) {
            return iEpollWait0;
        }
        throw Errors.newIOException("epoll_wait", iEpollWait0);
    }

    private static native int epollWait0(int i10, long j10, int i11, int i12, int i13, int i14);

    private static native int eventFd();

    public static native void eventFdRead(int i10);

    public static native void eventFdWrite(int i10, long j10);

    private static native boolean isSupportingUdpSegment();

    private static void loadNativeLibrary() throws Throwable {
        if (!"linux".equals(PlatformDependent.normalizedOs())) {
            throw new IllegalStateException("Only supported on Linux");
        }
        String str = "netty_transport_native_epoll_" + PlatformDependent.normalizedArch();
        ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
        try {
            NativeLibraryLoader.load(str, classLoader);
        } catch (UnsatisfiedLinkError e10) {
            try {
                NativeLibraryLoader.load("netty_transport_native_epoll", classLoader);
                logger.debug("Failed to load {}", str, e10);
            } catch (UnsatisfiedLinkError e11) {
                ThrowableUtil.addSuppressed(e10, e11);
                throw e10;
            }
        }
    }

    public static io.netty.channel.unix.FileDescriptor newEpollCreate() {
        return new io.netty.channel.unix.FileDescriptor(epollCreate());
    }

    public static io.netty.channel.unix.FileDescriptor newEventFd() {
        return new io.netty.channel.unix.FileDescriptor(eventFd());
    }

    public static io.netty.channel.unix.FileDescriptor newTimerFd() {
        return new io.netty.channel.unix.FileDescriptor(timerFd());
    }

    public static native int offsetofEpollData();

    public static int recvmmsg(int i10, boolean z10, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i11, int i12) throws IOException {
        int iRecvmmsg0 = recvmmsg0(i10, z10, nativeDatagramPacketArr, i11, i12);
        return iRecvmmsg0 >= 0 ? iRecvmmsg0 : Errors.ioResult("recvmmsg", iRecvmmsg0);
    }

    private static native int recvmmsg0(int i10, boolean z10, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i11, int i12);

    public static int recvmsg(int i10, boolean z10, NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket) throws IOException {
        int iRecvmsg0 = recvmsg0(i10, z10, nativeDatagramPacket);
        return iRecvmsg0 >= 0 ? iRecvmsg0 : Errors.ioResult("recvmsg", iRecvmsg0);
    }

    private static native int recvmsg0(int i10, boolean z10, NativeDatagramPacketArray.NativeDatagramPacket nativeDatagramPacket);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int registerUnix();

    @Deprecated
    public static int sendmmsg(int i10, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i11, int i12) throws IOException {
        return sendmmsg(i10, Socket.isIPv6Preferred(), nativeDatagramPacketArr, i11, i12);
    }

    private static native int sendmmsg0(int i10, boolean z10, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i11, int i12);

    public static native int sizeofEpollEvent();

    public static int splice(int i10, long j10, int i11, long j11, long j12) throws IOException {
        int iSplice0 = splice0(i10, j10, i11, j11, j12);
        return iSplice0 >= 0 ? iSplice0 : Errors.ioResult("splice", iSplice0);
    }

    private static native int splice0(int i10, long j10, int i11, long j11, long j12);

    private static native int timerFd();

    public static native void timerFdRead(int i10);

    public static native void timerFdSetTime(int i10, int i11, int i12) throws IOException;

    public static int sendmmsg(int i10, boolean z10, NativeDatagramPacketArray.NativeDatagramPacket[] nativeDatagramPacketArr, int i11, int i12) throws IOException {
        int iSendmmsg0 = sendmmsg0(i10, z10, nativeDatagramPacketArr, i11, i12);
        return iSendmmsg0 >= 0 ? iSendmmsg0 : Errors.ioResult("sendmmsg", iSendmmsg0);
    }

    public static int epollWait(io.netty.channel.unix.FileDescriptor fileDescriptor, EpollEventArray epollEventArray, boolean z10) throws IOException {
        return epollWait(fileDescriptor, epollEventArray, z10 ? 0 : -1);
    }

    public static int epollWait(io.netty.channel.unix.FileDescriptor fileDescriptor, EpollEventArray epollEventArray, int i10) throws IOException {
        int iEpollWait = epollWait(fileDescriptor.intValue(), epollEventArray.memoryAddress(), epollEventArray.length(), i10);
        if (iEpollWait >= 0) {
            return iEpollWait;
        }
        throw Errors.newIOException("epoll_wait", iEpollWait);
    }
}
