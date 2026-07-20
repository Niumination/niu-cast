package bm;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<T> implements h<T> {
    @Override // bm.h
    public int Q1() {
        return 0;
    }

    @Override // bm.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        h.a.a(this);
    }

    @Override // bm.h
    public void dispose() {
    }

    @Override // bm.h
    public void recycle(@l T t10) {
        l0.p(t10, "instance");
    }
}
