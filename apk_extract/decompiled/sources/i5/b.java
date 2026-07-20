package i5;

import e5.j;
import e5.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5719a = Logger.getLogger(b.class.getName());

    /* JADX WARN: Code duplicated, block: B:39:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static List a(InputStream inputStream) throws Throwable {
        Throwable th2;
        IOException e;
        Logger logger = f5719a;
        if (inputStream == null) {
            return Collections.emptyList();
        }
        InputStream inputStream2 = null;
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                try {
                    l lVar = new l();
                    lVar.readExternal(objectInputStream);
                    if (lVar.getMetadataList().isEmpty()) {
                        throw new IllegalStateException("Empty metadata");
                    }
                    List<j> metadataList = lVar.getMetadataList();
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                        logger.log(Level.WARNING, "Error closing input stream (ignored)", (Throwable) e4);
                    }
                    return metadataList;
                } catch (IOException e10) {
                    e = e10;
                    throw new IllegalStateException("Unable to parse metadata file", e);
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (IOException e11) {
                        logger.log(Level.WARNING, "Error closing input stream (ignored)", (Throwable) e11);
                    }
                } else {
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        logger.log(Level.WARNING, "Error closing input stream (ignored)", (Throwable) e12);
                    }
                }
                throw th2;
            }
        } catch (IOException e13) {
            e = e13;
        } catch (Throwable th4) {
            th2 = th4;
            if (0 != 0) {
                inputStream2.close();
            } else {
                inputStream.close();
            }
            throw th2;
        }
    }
}
