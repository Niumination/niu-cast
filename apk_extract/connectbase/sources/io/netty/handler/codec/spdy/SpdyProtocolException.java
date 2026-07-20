package io.netty.handler.codec.spdy;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SpdyProtocolException extends Exception {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 7870000537743847264L;

    public static final class StacklessSpdyProtocolException extends SpdyProtocolException {
        private static final long serialVersionUID = -6302754207557485099L;

        public StacklessSpdyProtocolException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        public StacklessSpdyProtocolException(String str, boolean z10) {
            super(str, z10);
        }
    }

    public static SpdyProtocolException newStatic(String str, Class<?> cls, String str2) {
        return (SpdyProtocolException) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessSpdyProtocolException(str, true) : new StacklessSpdyProtocolException(str), cls, str2);
    }

    public SpdyProtocolException() {
    }

    public SpdyProtocolException(String str, Throwable th2) {
        super(str, th2);
    }

    public SpdyProtocolException(String str) {
        super(str);
    }

    public SpdyProtocolException(Throwable th2) {
        super(th2);
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    private SpdyProtocolException(String str, boolean z10) {
        super(str, null, false, true);
    }
}
