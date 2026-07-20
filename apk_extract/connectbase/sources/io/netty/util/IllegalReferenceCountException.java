package io.netty.util;

import h.a;
import h.b;

/* JADX INFO: loaded from: classes3.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(int i10) {
        this(a.a("refCnt: ", i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IllegalReferenceCountException(int i10, int i11) {
        String strA;
        StringBuilder sbA = b.a("refCnt: ", i10, ", ");
        if (i11 > 0) {
            strA = a.a("increment: ", i11);
        } else {
            strA = "decrement: " + (-i11);
        }
        sbA.append(strA);
        this(sbA.toString());
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }

    public IllegalReferenceCountException(String str, Throwable th2) {
        super(str, th2);
    }

    public IllegalReferenceCountException(Throwable th2) {
        super(th2);
    }
}
