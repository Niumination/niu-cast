package wj;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class h2 implements vj.g2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f18715d = Logger.getLogger(h2.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f18716e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c1.q0<ProxySelector> f18717f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final String f18718g = "GRPC_PROXY_EXP";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f18719h = "https";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1.q0<ProxySelector> f18720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f18721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f18722c;

    public class a implements c {
        @Override // wj.h2.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i10, "");
            } catch (MalformedURLException unused) {
                h2.f18715d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i10, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements c1.q0<ProxySelector> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4);
    }

    public h2() {
        this(f18717f, f18716e, System.getenv(f18718g));
    }

    public static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(":", 2);
        int i10 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f18715d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(strArrSplit[0], i10);
    }

    @Override // vj.g2
    @gm.j
    public vj.f2 a(SocketAddress socketAddress) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f18722c != null ? vj.q0.newBuilder().c(this.f18722c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }

    public final vj.f2 c(InetSocketAddress inetSocketAddress) throws IOException {
        try {
            try {
                URI uri = new URI(f18719h, null, v0.l(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = this.f18720a.get();
                if (proxySelector == null) {
                    f18715d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    f18715d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationA = this.f18721b.a(v0.l(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), f18719h, "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                vj.q0.b bVarC = vj.q0.newBuilder().d(inetSocketAddress).c(inetSocketAddress2);
                if (passwordAuthenticationA == null) {
                    return bVarC.a();
                }
                bVarC.f17245c = passwordAuthenticationA.getUserName();
                bVarC.f17246d = passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null;
                return bVarC.a();
            } catch (URISyntaxException e10) {
                f18715d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e10);
                return null;
            }
        } catch (Throwable th2) {
            f18715d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th2);
            return null;
        }
    }

    @b1.e
    public h2(c1.q0<ProxySelector> q0Var, c cVar, @gm.j String str) {
        q0Var.getClass();
        this.f18720a = q0Var;
        cVar.getClass();
        this.f18721b = cVar;
        if (str != null) {
            this.f18722c = d(str);
        } else {
            this.f18722c = null;
        }
    }
}
