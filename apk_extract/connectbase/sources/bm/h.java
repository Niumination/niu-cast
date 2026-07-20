package bm;

import java.io.Closeable;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public interface h<T> extends Closeable {

    public static final class a {
        public static <T> void a(@l h<T> hVar) {
            l0.p(hVar, "this");
            hVar.dispose();
        }
    }

    int Q1();

    @l
    T W0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void dispose();

    void recycle(@l T t10);
}
