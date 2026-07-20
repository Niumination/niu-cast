package io.netty.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ResourceLeakException extends RuntimeException {
    private static final long serialVersionUID = 7186453858343358280L;
    private final StackTraceElement[] cachedStackTrace;

    public ResourceLeakException() {
        this.cachedStackTrace = getStackTrace();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceLeakException)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException) obj).cachedStackTrace);
    }

    public int hashCode() {
        int iHashCode = 0;
        for (StackTraceElement stackTraceElement : this.cachedStackTrace) {
            iHashCode = (iHashCode * 31) + stackTraceElement.hashCode();
        }
        return iHashCode;
    }

    public ResourceLeakException(String str) {
        super(str);
        this.cachedStackTrace = getStackTrace();
    }

    public ResourceLeakException(String str, Throwable th2) {
        super(str, th2);
        this.cachedStackTrace = getStackTrace();
    }

    public ResourceLeakException(Throwable th2) {
        super(th2);
        this.cachedStackTrace = getStackTrace();
    }
}
