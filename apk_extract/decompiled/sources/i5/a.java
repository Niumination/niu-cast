package i5;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5718a = Logger.getLogger(a.class.getName());

    public final InputStream a(String str) {
        InputStream resourceAsStream = a.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            f5718a.log(Level.WARNING, "File " + str + " not found");
        }
        return resourceAsStream;
    }
}
