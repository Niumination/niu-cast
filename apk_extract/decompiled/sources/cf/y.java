package cf;

import af.k2;
import af.l1;
import af.l6;
import af.y5;
import java.net.InetSocketAddress;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;
import k3.v8;
import ze.y2;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends ze.e0 {
    public static final a8.a q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f1659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n5.a f1660c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y5 f1658a = new y5(new a4.b(this, 5));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k2 f1661d = l6.f444d;
    public final a8.a e = q;
    public final a8.a f = new a8.a(l1.u, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ServerSocketFactory f1662g = ServerSocketFactory.getDefault();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1663h = l1.f422o;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f1664i = l1.p;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1665j = 65535;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1666k = 8192;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1667l = 4194304;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f1668m = Long.MAX_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f1669n = TimeUnit.MINUTES.toNanos(5);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f1670o = Long.MAX_VALUE;
    public final long p = Long.MAX_VALUE;

    static {
        Logger.getLogger(y.class.getName());
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.toNanos(1L);
        timeUnit.toNanos(1L);
        TimeUnit.DAYS.toNanos(1000L);
        q = k.f1573n;
        EnumSet.of(y2.MTLS, y2.CUSTOM_MANAGERS);
    }

    public y(InetSocketAddress inetSocketAddress, n5.a aVar) {
        this.f1659b = inetSocketAddress;
        v8.i(aVar, "handshakerSocketFactory");
        this.f1660c = aVar;
    }
}
