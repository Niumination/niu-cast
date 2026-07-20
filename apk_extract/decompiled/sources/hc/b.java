package hc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5282d;
    public final int e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f5285i;

    public b(boolean z2, String reason, String mac, String ip, int i8, String name, int i9, int i10, String pid, int i11) {
        reason = (i11 & 2) != 0 ? "failed" : reason;
        mac = (i11 & 4) != 0 ? "" : mac;
        ip = (i11 & 8) != 0 ? "" : ip;
        i8 = (i11 & 16) != 0 ? 0 : i8;
        name = (i11 & 32) != 0 ? "" : name;
        i9 = (i11 & 64) != 0 ? 0 : i9;
        i10 = (i11 & 128) != 0 ? 3 : i10;
        pid = (i11 & 256) != 0 ? "" : pid;
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(ip, "ip");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pid, "pid");
        this.f5279a = z2;
        this.f5280b = reason;
        this.f5281c = mac;
        this.f5282d = ip;
        this.e = i8;
        this.f = name;
        this.f5283g = i9;
        this.f5284h = i10;
        this.f5285i = pid;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ConnectResultBean(connected=");
        sb2.append(this.f5279a);
        sb2.append(", reason='");
        sb2.append(this.f5280b);
        sb2.append("', mac='");
        sb2.append(this.f5281c);
        sb2.append("', ip='");
        sb2.append(this.f5282d);
        sb2.append("', brand=");
        sb2.append(this.e);
        sb2.append(", name='");
        sb2.append(this.f);
        sb2.append("', serviceType=");
        sb2.append(this.f5283g);
        sb2.append(", deviceType=");
        sb2.append(this.f5284h);
        sb2.append(", pid='");
        return h0.a.n(sb2, this.f5285i, "')");
    }
}
