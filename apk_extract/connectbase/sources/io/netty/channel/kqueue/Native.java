package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.PeerCredentials;
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

/* JADX INFO: loaded from: classes2.dex */
final class Native {
    private static final int CONNECT_DATA_IDEMPOTENT;
    private static final int CONNECT_RESUME_ON_READ_WRITE;
    static final int CONNECT_TCP_FASTOPEN;
    static final short EVFILT_READ;
    static final short EVFILT_SOCK;
    static final short EVFILT_USER;
    static final short EVFILT_WRITE;
    static final short EV_ADD;
    static final short EV_ADD_CLEAR_ENABLE;
    static final short EV_CLEAR;
    static final short EV_DELETE;
    static final short EV_DELETE_DISABLE;
    static final short EV_DISABLE;
    static final short EV_ENABLE;
    static final short EV_EOF;
    static final short EV_ERROR;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    static final boolean IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    static final int NOTE_CONNRESET;
    static final int NOTE_DISCONNECTED;
    static final int NOTE_RDHUP;
    static final int NOTE_READCLOSED;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Native.class);

    static {
        ClassInitializerUtil.tryLoadClasses(Native.class, PeerCredentials.class, DefaultFileRegion.class, FileChannel.class, FileDescriptor.class);
        try {
            sizeofKEvent();
        } catch (UnsatisfiedLinkError unused) {
            loadNativeLibrary();
        }
        Unix.registerInternal(new Runnable() { // from class: io.netty.channel.kqueue.Native.1
            @Override // java.lang.Runnable
            public void run() {
                Native.registerUnix();
            }
        });
        short sEvAdd = KQueueStaticallyReferencedJniMethods.evAdd();
        EV_ADD = sEvAdd;
        short sEvEnable = KQueueStaticallyReferencedJniMethods.evEnable();
        EV_ENABLE = sEvEnable;
        short sEvDisable = KQueueStaticallyReferencedJniMethods.evDisable();
        EV_DISABLE = sEvDisable;
        short sEvDelete = KQueueStaticallyReferencedJniMethods.evDelete();
        EV_DELETE = sEvDelete;
        short sEvClear = KQueueStaticallyReferencedJniMethods.evClear();
        EV_CLEAR = sEvClear;
        EV_ERROR = KQueueStaticallyReferencedJniMethods.evError();
        EV_EOF = KQueueStaticallyReferencedJniMethods.evEOF();
        short sNoteReadClosed = KQueueStaticallyReferencedJniMethods.noteReadClosed();
        NOTE_READCLOSED = sNoteReadClosed;
        short sNoteConnReset = KQueueStaticallyReferencedJniMethods.noteConnReset();
        NOTE_CONNRESET = sNoteConnReset;
        short sNoteDisconnected = KQueueStaticallyReferencedJniMethods.noteDisconnected();
        NOTE_DISCONNECTED = sNoteDisconnected;
        NOTE_RDHUP = sNoteReadClosed | sNoteConnReset | sNoteDisconnected;
        EV_ADD_CLEAR_ENABLE = (short) (sEvAdd | sEvClear | sEvEnable);
        EV_DELETE_DISABLE = (short) (sEvDelete | sEvDisable);
        EVFILT_READ = KQueueStaticallyReferencedJniMethods.evfiltRead();
        EVFILT_WRITE = KQueueStaticallyReferencedJniMethods.evfiltWrite();
        EVFILT_USER = KQueueStaticallyReferencedJniMethods.evfiltUser();
        EVFILT_SOCK = KQueueStaticallyReferencedJniMethods.evfiltSock();
        int iConnectResumeOnReadWrite = KQueueStaticallyReferencedJniMethods.connectResumeOnReadWrite();
        CONNECT_RESUME_ON_READ_WRITE = iConnectResumeOnReadWrite;
        int iConnectDataIdempotent = KQueueStaticallyReferencedJniMethods.connectDataIdempotent();
        CONNECT_DATA_IDEMPOTENT = iConnectDataIdempotent;
        CONNECT_TCP_FASTOPEN = iConnectResumeOnReadWrite | iConnectDataIdempotent;
        IS_SUPPORTING_TCP_FASTOPEN_CLIENT = isSupportingFastOpenClient();
        IS_SUPPORTING_TCP_FASTOPEN_SERVER = isSupportingFastOpenServer();
    }

    private Native() {
    }

    private static boolean isSupportingFastOpenClient() {
        try {
            return KQueueStaticallyReferencedJniMethods.fastOpenClient() == 1;
        } catch (Exception e10) {
            logger.debug("Failed to probe fastOpenClient sysctl, assuming client-side TCP FastOpen cannot be used.", (Throwable) e10);
            return false;
        }
    }

    private static boolean isSupportingFastOpenServer() {
        try {
            return KQueueStaticallyReferencedJniMethods.fastOpenServer() == 1;
        } catch (Exception e10) {
            logger.debug("Failed to probe fastOpenServer sysctl, assuming server-side TCP FastOpen cannot be used.", (Throwable) e10);
            return false;
        }
    }

    public static native int keventAddUserEvent(int i10, int i11);

    public static native int keventTriggerUserEvent(int i10, int i11);

    private static native int keventWait(int i10, long j10, int i11, long j11, int i12, int i13, int i14);

    public static int keventWait(int i10, KQueueEventArray kQueueEventArray, KQueueEventArray kQueueEventArray2, int i11, int i12) throws IOException {
        int iKeventWait = keventWait(i10, kQueueEventArray.memoryAddress(), kQueueEventArray.size(), kQueueEventArray2.memoryAddress(), kQueueEventArray2.capacity(), i11, i12);
        if (iKeventWait >= 0) {
            return iKeventWait;
        }
        throw Errors.newIOException("kevent", iKeventWait);
    }

    private static native int kqueueCreate();

    private static void loadNativeLibrary() throws Throwable {
        String strNormalizedOs = PlatformDependent.normalizedOs();
        if (!"osx".equals(strNormalizedOs) && !strNormalizedOs.contains("bsd")) {
            throw new IllegalStateException("Only supported on OSX/BSD");
        }
        String str = "netty_transport_native_kqueue_" + PlatformDependent.normalizedArch();
        ClassLoader classLoader = PlatformDependent.getClassLoader(Native.class);
        try {
            NativeLibraryLoader.load(str, classLoader);
        } catch (UnsatisfiedLinkError e10) {
            try {
                NativeLibraryLoader.load("netty_transport_native_kqueue", classLoader);
                logger.debug("Failed to load {}", str, e10);
            } catch (UnsatisfiedLinkError e11) {
                ThrowableUtil.addSuppressed(e10, e11);
                throw e10;
            }
        }
    }

    public static io.netty.channel.unix.FileDescriptor newKQueue() {
        return new io.netty.channel.unix.FileDescriptor(kqueueCreate());
    }

    public static native int offsetofKEventFFlags();

    public static native int offsetofKEventFilter();

    public static native int offsetofKEventFlags();

    public static native int offsetofKEventIdent();

    public static native int offsetofKeventData();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int registerUnix();

    public static native int sizeofKEvent();
}
