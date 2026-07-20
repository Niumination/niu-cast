package qf;

import java.io.Closeable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.a f9050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1 f9052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0 f9053d;

    public d(zg.a key, Object config, Function1 body) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f9050a = key;
        this.f9051b = config;
        this.f9052c = body;
        this.f9053d = new ob.c(8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9053d.invoke();
    }
}
