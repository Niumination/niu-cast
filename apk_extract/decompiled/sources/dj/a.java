package dj;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import k3.b2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f4470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f4473d;
    public final SocketFactory e;
    public final SSLSocketFactory f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HostnameVerifier f4474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f4475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f4476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ProxySelector f4477j;

    public a(String host, int i8, l dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, l proxyAuthenticator, ProxySelector proxySelector) {
        List protocols = b0.C;
        List connectionSpecs = b0.D;
        Intrinsics.checkNotNullParameter(host, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.f4473d = dns;
        this.e = socketFactory;
        this.f = sSLSocketFactory;
        this.f4474g = hostnameVerifier;
        this.f4475h = fVar;
        this.f4476i = proxyAuthenticator;
        this.f4477j = proxySelector;
        t tVar = new t();
        String scheme = sSLSocketFactory != null ? "https" : "http";
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (StringsKt__StringsJVMKt.equals(scheme, "http", true)) {
            tVar.f4626a = "http";
        } else {
            if (!StringsKt__StringsJVMKt.equals(scheme, "https", true)) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(scheme));
            }
            tVar.f4626a = "https";
        }
        Intrinsics.checkNotNullParameter(host, "host");
        String strB = b2.b(l.f(host, 0, 0, false, 7));
        if (strB == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(host));
        }
        tVar.f4629d = strB;
        if (1 > i8 || 65535 < i8) {
            throw new IllegalArgumentException(a1.a.o(i8, "unexpected port: ").toString());
        }
        tVar.e = i8;
        this.f4470a = tVar.a();
        this.f4471b = ej.b.w(protocols);
        this.f4472c = ej.b.w(connectionSpecs);
    }

    public final boolean a(a that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.f4473d, that.f4473d) && Intrinsics.areEqual(this.f4476i, that.f4476i) && Intrinsics.areEqual(this.f4471b, that.f4471b) && Intrinsics.areEqual(this.f4472c, that.f4472c) && Intrinsics.areEqual(this.f4477j, that.f4477j) && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.f, that.f) && Intrinsics.areEqual(this.f4474g, that.f4474g) && Intrinsics.areEqual(this.f4475h, that.f4475h) && this.f4470a.f == that.f4470a.f;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Intrinsics.areEqual(this.f4470a, aVar.f4470a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f4475h) + ((Objects.hashCode(this.f4474g) + ((Objects.hashCode(this.f) + ((this.f4477j.hashCode() + ((this.f4472c.hashCode() + ((this.f4471b.hashCode() + ((this.f4476i.hashCode() + ((this.f4473d.hashCode() + a1.a.e(527, 31, this.f4470a.f4640j)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Address{");
        u uVar = this.f4470a;
        sb2.append(uVar.e);
        sb2.append(':');
        sb2.append(uVar.f);
        sb2.append(", ");
        sb2.append("proxySelector=" + this.f4477j);
        sb2.append("}");
        return sb2.toString();
    }
}
