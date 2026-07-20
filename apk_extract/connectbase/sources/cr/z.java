package cr;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface z extends Closeable, Flushable {
    void Z0(c cVar, long j10) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    b0 f();

    void flush() throws IOException;
}
