package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Http2Exception extends Exception {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -6941186345430164209L;
    private final Http2Error error;
    private final ShutdownHint shutdownHint;

    public static final class ClosedStreamCreationException extends Http2Exception {
        private static final long serialVersionUID = -6746542974372246206L;

        public ClosedStreamCreationException(Http2Error http2Error) {
            super(http2Error);
        }

        public ClosedStreamCreationException(Http2Error http2Error, String str) {
            super(http2Error, str);
        }

        public ClosedStreamCreationException(Http2Error http2Error, String str, Throwable th2) {
            super(http2Error, str, th2);
        }
    }

    public static final class CompositeStreamException extends Http2Exception implements Iterable<StreamException> {
        private static final long serialVersionUID = 7091134858213711015L;
        private final List<StreamException> exceptions;

        public CompositeStreamException(Http2Error http2Error, int i10) {
            super(http2Error, ShutdownHint.NO_SHUTDOWN);
            this.exceptions = new ArrayList(i10);
        }

        public void add(StreamException streamException) {
            this.exceptions.add(streamException);
        }

        @Override // java.lang.Iterable
        public Iterator<StreamException> iterator() {
            return this.exceptions.iterator();
        }
    }

    public static final class HeaderListSizeException extends StreamException {
        private static final long serialVersionUID = -8807603212183882637L;
        private final boolean decode;

        public HeaderListSizeException(int i10, Http2Error http2Error, String str, boolean z10) {
            super(i10, http2Error, str);
            this.decode = z10;
        }

        public boolean duringDecode() {
            return this.decode;
        }
    }

    public enum ShutdownHint {
        NO_SHUTDOWN,
        GRACEFUL_SHUTDOWN,
        HARD_SHUTDOWN
    }

    public static final class StacklessHttp2Exception extends Http2Exception {
        private static final long serialVersionUID = 1077888485687219443L;

        public StacklessHttp2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint) {
            super(http2Error, str, shutdownHint);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        public StacklessHttp2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint, boolean z10) {
            super(http2Error, str, shutdownHint, z10);
        }
    }

    public static Http2Exception closedStreamError(Http2Error http2Error, String str, Object... objArr) {
        return new ClosedStreamCreationException(http2Error, formatErrorMessage(str, objArr));
    }

    public static Http2Exception connectionError(Http2Error http2Error, String str, Object... objArr) {
        return new Http2Exception(http2Error, formatErrorMessage(str, objArr));
    }

    private static String formatErrorMessage(String str, Object[] objArr) {
        if (str != null) {
            return String.format(str, objArr);
        }
        if (objArr == null || objArr.length == 0) {
            return "Unexpected error";
        }
        return "Unexpected error: " + Arrays.toString(objArr);
    }

    public static Http2Exception headerListSizeError(int i10, Http2Error http2Error, boolean z10, String str, Object... objArr) {
        return i10 == 0 ? connectionError(http2Error, str, objArr) : new HeaderListSizeException(i10, http2Error, formatErrorMessage(str, objArr), z10);
    }

    public static boolean isStreamError(Http2Exception http2Exception) {
        return http2Exception instanceof StreamException;
    }

    public static Http2Exception newStatic(Http2Error http2Error, String str, ShutdownHint shutdownHint, Class<?> cls, String str2) {
        return (Http2Exception) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessHttp2Exception(http2Error, str, shutdownHint, true) : new StacklessHttp2Exception(http2Error, str, shutdownHint), cls, str2);
    }

    public static Http2Exception streamError(int i10, Http2Error http2Error, String str, Object... objArr) {
        return i10 == 0 ? connectionError(http2Error, str, objArr) : new StreamException(i10, http2Error, formatErrorMessage(str, objArr));
    }

    public static int streamId(Http2Exception http2Exception) {
        if (isStreamError(http2Exception)) {
            return ((StreamException) http2Exception).streamId();
        }
        return 0;
    }

    public Http2Error error() {
        return this.error;
    }

    public ShutdownHint shutdownHint() {
        return this.shutdownHint;
    }

    public static class StreamException extends Http2Exception {
        private static final long serialVersionUID = 602472544416984384L;
        private final int streamId;

        public StreamException(int i10, Http2Error http2Error, String str) {
            super(http2Error, str, ShutdownHint.NO_SHUTDOWN);
            this.streamId = i10;
        }

        public int streamId() {
            return this.streamId;
        }

        public StreamException(int i10, Http2Error http2Error, String str, Throwable th2) {
            super(http2Error, str, th2, ShutdownHint.NO_SHUTDOWN);
            this.streamId = i10;
        }
    }

    public Http2Exception(Http2Error http2Error) {
        this(http2Error, ShutdownHint.HARD_SHUTDOWN);
    }

    public static Http2Exception connectionError(Http2Error http2Error, Throwable th2, String str, Object... objArr) {
        return new Http2Exception(http2Error, formatErrorMessage(str, objArr), th2);
    }

    public Http2Exception(Http2Error http2Error, ShutdownHint shutdownHint) {
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }

    public static Http2Exception streamError(int i10, Http2Error http2Error, Throwable th2, String str, Object... objArr) {
        if (i10 == 0) {
            return connectionError(http2Error, th2, str, objArr);
        }
        return new StreamException(i10, http2Error, formatErrorMessage(str, objArr), th2);
    }

    public Http2Exception(Http2Error http2Error, String str) {
        this(http2Error, str, ShutdownHint.HARD_SHUTDOWN);
    }

    public Http2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint) {
        super(str);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }

    public Http2Exception(Http2Error http2Error, String str, Throwable th2) {
        this(http2Error, str, th2, ShutdownHint.HARD_SHUTDOWN);
    }

    public Http2Exception(Http2Error http2Error, String str, Throwable th2, ShutdownHint shutdownHint) {
        super(str, th2);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    private Http2Exception(Http2Error http2Error, String str, ShutdownHint shutdownHint, boolean z10) {
        super(str, null, false, true);
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
        this.shutdownHint = (ShutdownHint) ObjectUtil.checkNotNull(shutdownHint, "shutdownHint");
    }
}
