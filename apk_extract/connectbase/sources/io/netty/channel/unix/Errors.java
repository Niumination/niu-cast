package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import k.c;

/* JADX INFO: loaded from: classes2.dex */
public final class Errors {
    public static final int ERRNO_ENOENT_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOENT();
    public static final int ERRNO_ENOTCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoENOTCONN();
    public static final int ERRNO_EBADF_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEBADF();
    public static final int ERRNO_EPIPE_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEPIPE();
    public static final int ERRNO_ECONNRESET_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoECONNRESET();
    public static final int ERRNO_EAGAIN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEAGAIN();
    public static final int ERRNO_EWOULDBLOCK_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK();
    public static final int ERRNO_EINPROGRESS_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS();
    public static final int ERROR_ECONNREFUSED_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED();
    public static final int ERROR_EISCONN_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEISCONN();
    public static final int ERROR_EALREADY_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEALREADY();
    public static final int ERROR_ENETUNREACH_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorENETUNREACH();
    public static final int ERROR_EHOSTUNREACH_NEGATIVE = -ErrorsStaticallyReferencedJniMethods.errorEHOSTUNREACH();
    private static final String[] ERRORS = new String[2048];

    public static final class NativeConnectException extends ConnectException {
        private static final long serialVersionUID = -5532328671712318161L;
        private final int expectedErr;

        /* JADX WARN: Illegal instructions before constructor call */
        public NativeConnectException(String str, int i10) {
            StringBuilder sbA = c.a(str, "(..) failed: ");
            sbA.append(Errors.errnoString(-i10));
            super(sbA.toString());
            this.expectedErr = i10;
        }

        public int expectedErr() {
            return this.expectedErr;
        }
    }

    public static final class NativeIoException extends IOException {
        private static final long serialVersionUID = 8222160204268655526L;
        private final int expectedErr;
        private final boolean fillInStackTrace;

        public NativeIoException(String str, int i10) {
            this(str, i10, true);
        }

        public int expectedErr() {
            return this.expectedErr;
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            if (!this.fillInStackTrace) {
                return this;
            }
            return super.fillInStackTrace();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public NativeIoException(String str, int i10, boolean z10) {
            StringBuilder sbA = c.a(str, "(..) failed: ");
            sbA.append(Errors.errnoString(-i10));
            super(sbA.toString());
            this.expectedErr = i10;
            this.fillInStackTrace = z10;
        }
    }

    static {
        int i10 = 0;
        while (true) {
            String[] strArr = ERRORS;
            if (i10 >= strArr.length) {
                return;
            }
            strArr[i10] = ErrorsStaticallyReferencedJniMethods.strError(i10);
            i10++;
        }
    }

    private Errors() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String errnoString(int i10) {
        String[] strArr = ERRORS;
        return i10 < strArr.length + (-1) ? strArr[i10] : ErrorsStaticallyReferencedJniMethods.strError(i10);
    }

    public static boolean handleConnectErrno(String str, int i10) throws IOException {
        if (i10 == ERRNO_EINPROGRESS_NEGATIVE || i10 == ERROR_EALREADY_NEGATIVE) {
            return false;
        }
        throw newConnectException0(str, i10);
    }

    @Deprecated
    public static int ioResult(String str, int i10, NativeIoException nativeIoException, ClosedChannelException closedChannelException) throws IOException {
        if (i10 == ERRNO_EAGAIN_NEGATIVE || i10 == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i10 == nativeIoException.expectedErr()) {
            throw nativeIoException;
        }
        if (i10 == ERRNO_EBADF_NEGATIVE) {
            throw closedChannelException;
        }
        if (i10 == ERRNO_ENOTCONN_NEGATIVE) {
            throw new NotYetConnectedException();
        }
        if (i10 == ERRNO_ENOENT_NEGATIVE) {
            throw new FileNotFoundException();
        }
        throw newIOException(str, i10);
    }

    private static IOException newConnectException0(String str, int i10) {
        if (i10 == ERROR_ENETUNREACH_NEGATIVE || i10 == ERROR_EHOSTUNREACH_NEGATIVE) {
            return new NoRouteToHostException();
        }
        if (i10 == ERROR_EISCONN_NEGATIVE) {
            throw new AlreadyConnectedException();
        }
        if (i10 == ERRNO_ENOENT_NEGATIVE) {
            return new FileNotFoundException();
        }
        StringBuilder sbA = c.a(str, "(..) failed: ");
        sbA.append(errnoString(-i10));
        return new ConnectException(sbA.toString());
    }

    public static NativeIoException newConnectionResetException(String str, int i10) {
        NativeIoException nativeIoException = new NativeIoException(str, i10, false);
        nativeIoException.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return nativeIoException;
    }

    public static NativeIoException newIOException(String str, int i10) {
        return new NativeIoException(str, i10);
    }

    @Deprecated
    public static void throwConnectException(String str, int i10) throws IOException {
        if (i10 != ERROR_EALREADY_NEGATIVE) {
            throw newConnectException0(str, i10);
        }
        throw new ConnectionPendingException();
    }

    public static int ioResult(String str, int i10) throws IOException {
        if (i10 == ERRNO_EAGAIN_NEGATIVE || i10 == ERRNO_EWOULDBLOCK_NEGATIVE) {
            return 0;
        }
        if (i10 != ERRNO_EBADF_NEGATIVE) {
            if (i10 != ERRNO_ENOTCONN_NEGATIVE) {
                if (i10 == ERRNO_ENOENT_NEGATIVE) {
                    throw new FileNotFoundException();
                }
                throw new NativeIoException(str, i10, false);
            }
            throw new NotYetConnectedException();
        }
        throw new ClosedChannelException();
    }
}
