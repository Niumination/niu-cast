package cf;

import af.k2;
import af.k3;
import af.l1;
import af.l6;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;
import ze.f1;
import ze.x2;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends ze.d0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final df.c f1572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a8.a f1573n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k3 f1574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2 f1575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a8.a f1576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a8.a f1577d;
    public SSLSocketFactory e;
    public final df.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f1578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f1579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f1580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f1583l;

    static {
        Logger.getLogger(k.class.getName());
        df.b bVar = new df.b(df.c.e);
        bVar.a(df.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, df.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, df.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, df.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, df.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, df.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        bVar.b(df.n.TLS_1_2);
        if (!bVar.f4430a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        bVar.f4433d = true;
        f1572m = new df.c(bVar);
        TimeUnit.DAYS.toNanos(1000L);
        f1573n = new a8.a(new j3.z(), 3);
        EnumSet.of(x2.MTLS, x2.CUSTOM_MANAGERS);
    }

    public k(String str, int i8) {
        Logger logger = l1.f410a;
        try {
            String authority = new URI(null, null, str, i8, null, null, null).getAuthority();
            this.f1575b = l6.f444d;
            this.f1576c = f1573n;
            this.f1577d = new a8.a(l1.u, 3);
            this.f = f1572m;
            this.f1578g = i.TLS;
            this.f1579h = Long.MAX_VALUE;
            this.f1580i = l1.f421n;
            this.f1581j = 65535;
            this.f1582k = 4194304;
            this.f1583l = Integer.MAX_VALUE;
            this.f1574a = new k3(authority, new o5.c(this), new a8.a(this, 4));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid host or port: " + str + " " + i8, e);
        }
    }

    @Override // ze.f1
    public final f1 b() {
        this.f1578g = i.PLAINTEXT;
        return this;
    }
}
