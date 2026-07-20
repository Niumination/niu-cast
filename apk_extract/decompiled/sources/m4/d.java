package m4;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f7913d = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f7914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f7915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f7916c;

    public d(Runnable runnable, Executor executor) {
        this.f7914a = runnable;
        this.f7915b = executor;
    }

    public d() {
        this.f7914a = null;
        this.f7915b = null;
    }
}
