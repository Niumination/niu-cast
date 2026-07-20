package ze;

import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum f11448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f11449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f11450c;

    /* JADX WARN: Multi-variable type inference failed */
    public v(Executor executor, t tVar, y yVar) {
        this.f11448a = (Enum) executor;
        this.f11449b = tVar;
        this.f11450c = yVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Enum, java.util.concurrent.Executor] */
    public final void a() {
        try {
            this.f11448a.execute(this);
        } catch (Throwable th2) {
            y.f11473d.log(Level.INFO, "Exception notifying context listener", th2);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11449b.m(this.f11450c);
    }
}
