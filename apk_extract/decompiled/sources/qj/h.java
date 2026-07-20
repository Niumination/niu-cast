package qj;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface h extends z, ReadableByteChannel {
    long C(f fVar);

    f getBuffer();

    InputStream j0();

    f n();

    boolean request(long j8);

    int x(p pVar);
}
