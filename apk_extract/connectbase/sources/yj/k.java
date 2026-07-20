package yj;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class k extends k1.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f21070e;

    public k(String str) {
        this(str, -1L, null);
    }

    public String d() {
        return this.f21068c;
    }

    public long e() {
        return this.f21069d;
    }

    public TimeUnit f() {
        return this.f21070e;
    }

    public k(String str, long j10, TimeUnit timeUnit) {
        this.f21068c = (String) c1.h0.F(str, "goAwayDebugString");
        this.f21069d = j10;
        this.f21070e = timeUnit;
    }
}
