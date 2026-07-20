package r5;

import k4.m;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f14282a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f14283b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f14284c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f14285d = 100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f14286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile long f14287f;

    public final boolean a(long j10) {
        m.c("hushiming-diff", "Video - Audio: " + (j10 - f14286e));
        return true;
    }

    public final void b(long j10) {
        f14286e = j10;
    }
}
