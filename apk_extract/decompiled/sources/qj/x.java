package qj;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes3.dex */
public interface x extends Closeable, Flushable {
    b0 b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    void k0(f fVar, long j8);
}
