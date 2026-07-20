package ag;

import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bg.c f798b;

    public x(v headers, bg.c builder) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f797a = headers;
        this.f798b = builder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f798b.e();
        this.f797a.e();
    }
}
