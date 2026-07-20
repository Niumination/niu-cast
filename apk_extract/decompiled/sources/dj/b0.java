package dj;

import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import k3.lc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Cloneable, d {
    public static final List C = ej.b.l(d0.HTTP_2, d0.HTTP_1_1);
    public static final List D = ej.b.l(j.e, j.f);
    public final int A;
    public final a8.a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f4495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tj.w f4496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4498d;
    public final mg.a0 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f4500i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f4501j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4502k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l f4503l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f4504m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ProxySelector f4505n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final l f4506o;
    public final SocketFactory p;
    public final SSLSocketFactory q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final X509TrustManager f4507r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f4508s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f4509t;
    public final pj.c u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f4510v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final lc f4511w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f4512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f4513y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f4514z;

    public b0(a0 builder) throws NoSuchAlgorithmException, KeyStoreException {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f4495a = builder.f4478a;
        this.f4496b = builder.f4479b;
        this.f4497c = ej.b.w(builder.f4480c);
        this.f4498d = ej.b.w(builder.f4481d);
        this.e = builder.e;
        this.f4499h = builder.f;
        this.f4500i = builder.f4482g;
        this.f4501j = builder.f4483h;
        this.f4502k = builder.f4484i;
        this.f4503l = builder.f4485j;
        this.f4504m = builder.f4486k;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.f4505n = proxySelector == null ? nj.a.f8329a : proxySelector;
        this.f4506o = builder.f4487l;
        this.p = builder.f4488m;
        List list = D;
        this.f4508s = list;
        this.f4509t = C;
        this.u = builder.p;
        this.f4512x = builder.f4491r;
        this.f4513y = builder.f4492s;
        this.f4514z = builder.f4493t;
        this.A = builder.u;
        this.B = new a8.a(9);
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.q = null;
                    this.f4511w = null;
                    this.f4507r = null;
                    this.f4510v = f.f4531c;
                    break;
                }
                if (((j) it.next()).f4572a) {
                    lj.m mVar = lj.m.f7532a;
                    X509TrustManager trustManager = lj.m.f7532a.i();
                    this.f4507r = trustManager;
                    lj.m mVar2 = lj.m.f7532a;
                    Intrinsics.checkNotNull(trustManager);
                    this.q = mVar2.h(trustManager);
                    Intrinsics.checkNotNull(trustManager);
                    Intrinsics.checkNotNullParameter(trustManager, "trustManager");
                    lc certificateChainCleaner = lj.m.f7532a.b(trustManager);
                    this.f4511w = certificateChainCleaner;
                    f fVar = builder.q;
                    Intrinsics.checkNotNull(certificateChainCleaner);
                    fVar.getClass();
                    Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
                    this.f4510v = Intrinsics.areEqual(fVar.f4533b, certificateChainCleaner) ? fVar : new f(fVar.f4532a, certificateChainCleaner);
                    break;
                }
            }
        } else {
            this.q = null;
            this.f4511w = null;
            this.f4507r = null;
            this.f4510v = f.f4531c;
            break;
        }
        List list3 = this.f4497c;
        if (list3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        List list4 = this.f4498d;
        if (list4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        }
        if (list4.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list4).toString());
        }
        List list5 = list;
        boolean z2 = list5 instanceof Collection;
        X509TrustManager x509TrustManager = this.f4507r;
        lc lcVar = this.f4511w;
        SSLSocketFactory sSLSocketFactory = this.q;
        if (!z2 || !list5.isEmpty()) {
            Iterator it2 = list5.iterator();
            while (it2.hasNext()) {
                if (((j) it2.next()).f4572a) {
                    if (sSLSocketFactory == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (lcVar == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (!(sSLSocketFactory == null)) {
            throw new IllegalStateException("Check failed.");
        }
        if (lcVar != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!Intrinsics.areEqual(this.f4510v, f.f4531c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Object clone() {
        return super.clone();
    }
}
