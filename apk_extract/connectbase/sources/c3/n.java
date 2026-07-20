package c3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import jq.h0;
import kn.l0;
import r2.w;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements y2.c<w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final n f1317a = new n();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f1318b = "No space left on device";

    @Override // y2.c
    @os.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public w a(@os.m Exception exc) {
        if (exc instanceof SocketException) {
            return w.FILE_CHANNEL_CLOSE;
        }
        if (exc instanceof IOException) {
            String message = ((IOException) exc).getMessage();
            if (l0.g(message != null ? Boolean.valueOf(h0.T2(message, f1318b, false, 2, null)) : null, Boolean.TRUE)) {
                return w.NO_SPACE;
            }
        }
        return ((exc instanceof FileNotFoundException) || (exc instanceof SecurityException) || (exc instanceof dn.j) || (exc instanceof UnsupportedOperationException)) ? w.FILE_OPERATION_ERROR : w.UNKNOWN;
    }
}
