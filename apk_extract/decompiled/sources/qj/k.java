package qj;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f9198a;

    public k(z delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f9198a = delegate;
    }

    @Override // qj.z
    public final b0 b() {
        return this.f9198a.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9198a.close();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f9198a + ')';
    }
}
