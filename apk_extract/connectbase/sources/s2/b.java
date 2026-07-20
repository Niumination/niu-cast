package s2;

import java.io.Closeable;
import kn.l0;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final boolean a(@m Boolean bool) {
        return !l0.g(bool, Boolean.TRUE);
    }

    public static final boolean b(@m Boolean bool) {
        return l0.g(bool, Boolean.TRUE);
    }

    public static final void c(@m Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
