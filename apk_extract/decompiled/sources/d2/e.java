package d2;

import java.io.Closeable;
import java.io.IOException;
import tj.w;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yh.a f4272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f4273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public yh.a f4274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yh.a f4275d;
    public yh.a e;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ((j2.c) this.f4275d.get()).close();
    }
}
