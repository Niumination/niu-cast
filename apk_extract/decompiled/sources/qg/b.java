package qg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements mg.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f9063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.b f9064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pg.b f9065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yf.c f9066d;

    public b(ClassLoader classLoader, vj.b log, pg.b config) {
        yf.c monitor = new yf.c();
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        this.f9063a = classLoader;
        this.f9064b = log;
        this.f9065c = config;
        this.f9066d = monitor;
    }
}
