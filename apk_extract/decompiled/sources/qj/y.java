package qj;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import k3.sc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Socket f9234m;

    public y(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.f9234m = socket;
    }

    @Override // qj.e
    public final void j() {
        Socket socket = this.f9234m;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!sc.c(e)) {
                throw e;
            }
            o.f9207a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e4) {
            o.f9207a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e4);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
