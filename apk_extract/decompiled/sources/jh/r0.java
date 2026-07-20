package jh;

import java.io.IOException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f6301a;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(Throwable th2) {
        Throwable iOException;
        if (th2 == 0) {
            iOException = null;
        } else if (th2 instanceof CancellationException) {
            if (th2 instanceof li.x) {
                iOException = ((li.x) th2).createCopy();
            } else {
                String message = ((CancellationException) th2).getMessage();
                iOException = li.l0.a(message == null ? "Channel was cancelled" : message, th2);
            }
        } else if ((th2 instanceof IOException) && (th2 instanceof li.x)) {
            iOException = ((li.x) th2).createCopy();
        } else {
            String message2 = th2.getMessage();
            iOException = new IOException(message2 == null ? "Channel was closed" : message2, th2);
        }
        this.f6301a = iOException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Throwable a() {
        Throwable thCreateCopy;
        Throwable th2 = this.f6301a;
        if (th2 == 0) {
            return null;
        }
        if (th2 instanceof IOException) {
            if (th2 instanceof li.x) {
                return ((li.x) th2).createCopy();
            }
            thCreateCopy = new IOException(((IOException) th2).getMessage(), th2);
        } else {
            if (!(th2 instanceof li.x)) {
                return li.l0.a(th2.getMessage(), th2);
            }
            thCreateCopy = ((li.x) th2).createCopy();
            if (thCreateCopy == null) {
                return li.l0.a(th2.getMessage(), th2);
            }
        }
        return thCreateCopy;
    }
}
