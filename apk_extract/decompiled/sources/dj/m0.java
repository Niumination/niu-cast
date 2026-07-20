package dj;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0 f4613a;

    public abstract long a();

    public abstract x c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ej.b.d(g());
    }

    public abstract qj.h g();
}
