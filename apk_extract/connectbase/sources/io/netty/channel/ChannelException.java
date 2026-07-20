package io.netty.channel;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelException extends RuntimeException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2908618315971075004L;

    public static final class StacklessChannelException extends ChannelException {
        private static final long serialVersionUID = -6384642137753538579L;

        public StacklessChannelException(String str, Throwable th2) {
            super(str, th2);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        public StacklessChannelException(String str, Throwable th2, boolean z10) {
            super(str, th2, z10);
        }
    }

    public ChannelException() {
    }

    public static ChannelException newStatic(String str, Class<?> cls, String str2) {
        return (ChannelException) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessChannelException(str, null, true) : new StacklessChannelException(str, null), cls, str2);
    }

    public ChannelException(String str, Throwable th2) {
        super(str, th2);
    }

    public ChannelException(String str) {
        super(str);
    }

    public ChannelException(Throwable th2) {
        super(th2);
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ RuntimeException.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    public ChannelException(String str, Throwable th2, boolean z10) {
        super(str, th2, false, true);
    }
}
