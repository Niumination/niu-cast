package io.netty.channel.epoll;

import io.netty.channel.unix.FileDescriptor;
import io.netty.util.internal.SystemPropertyUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    static {
        UnsupportedOperationException th2;
        FileDescriptor fileDescriptorNewEpollCreate;
        if (SystemPropertyUtil.getBoolean("io.netty.transport.noNative", false)) {
            th2 = new UnsupportedOperationException("Native transport was explicit disabled with -Dio.netty.transport.noNative=true");
        } else {
            th2 = null;
            try {
                try {
                    fileDescriptorNewEpollCreate = Native.newEpollCreate();
                    try {
                        FileDescriptor fileDescriptorNewEventFd = Native.newEventFd();
                        if (fileDescriptorNewEpollCreate != null) {
                            try {
                                fileDescriptorNewEpollCreate.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (fileDescriptorNewEventFd != null) {
                            fileDescriptorNewEventFd.close();
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fileDescriptorNewEpollCreate != null) {
                            fileDescriptorNewEpollCreate.close();
                        }
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th4) {
                fileDescriptorNewEpollCreate = null;
                th2 = th4;
            }
        }
        UNAVAILABILITY_CAUSE = th2;
    }

    private Epoll() {
    }

    public static void ensureAvailability() {
        Throwable th2 = UNAVAILABILITY_CAUSE;
        if (th2 != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th2));
        }
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isTcpFastOpenClientSideAvailable() {
        return isAvailable() && Native.IS_SUPPORTING_TCP_FASTOPEN_CLIENT;
    }

    public static boolean isTcpFastOpenServerSideAvailable() {
        return isAvailable() && Native.IS_SUPPORTING_TCP_FASTOPEN_SERVER;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }
}
