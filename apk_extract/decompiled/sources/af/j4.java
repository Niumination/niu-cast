package af;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class j4 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f368d = Logger.getLogger(j4.class.getName());
    public static final k2 e = new k2(17);
    public static final k2 f = new k2(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k2 f369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2 f370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f371c;

    public j4() {
        String str = System.getenv("GRPC_PROXY_EXP");
        k2 k2Var = f;
        k2Var.getClass();
        this.f369a = k2Var;
        k2 k2Var2 = e;
        k2Var2.getClass();
        this.f370b = k2Var2;
        if (str == null) {
            this.f371c = null;
            return;
        }
        String[] strArrSplit = str.split(":", 2);
        int i8 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f368d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        this.f371c = new InetSocketAddress(strArrSplit[0], i8);
    }

    public final ze.z1 a(InetSocketAddress inetSocketAddress) {
        URL url;
        if (inetSocketAddress == null) {
            return null;
        }
        InetSocketAddress inetSocketAddress2 = this.f371c;
        if (inetSocketAddress2 != null) {
            ze.h0 h0VarNewBuilder = ze.i0.newBuilder();
            h0VarNewBuilder.getClass();
            h0VarNewBuilder.f11355a = inetSocketAddress2;
            v8.i(inetSocketAddress, "targetAddress");
            h0VarNewBuilder.f11356b = inetSocketAddress;
            return new ze.i0(h0VarNewBuilder.f11355a, h0VarNewBuilder.f11356b, h0VarNewBuilder.f11357c, h0VarNewBuilder.f11358d, null);
        }
        Logger logger = f368d;
        try {
            try {
                URI uri = new URI("https", null, l1.e(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                this.f369a.getClass();
                ProxySelector proxySelector = ProxySelector.getDefault();
                if (proxySelector == null) {
                    logger.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    logger.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress3 = (InetSocketAddress) proxy.address();
                String strE = l1.e(inetSocketAddress3);
                InetAddress address = inetSocketAddress3.getAddress();
                int port = inetSocketAddress3.getPort();
                this.f370b.getClass();
                try {
                    url = new URL("https", strE, port, "");
                } catch (MalformedURLException unused) {
                    logger.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{"https", strE});
                    url = null;
                }
                PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strE, address, port, "https", "", null, url, Authenticator.RequestorType.PROXY);
                if (inetSocketAddress3.isUnresolved()) {
                    inetSocketAddress3 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress3.getHostName()), inetSocketAddress3.getPort());
                }
                ze.h0 h0VarNewBuilder2 = ze.i0.newBuilder();
                h0VarNewBuilder2.getClass();
                h0VarNewBuilder2.f11356b = inetSocketAddress;
                h0VarNewBuilder2.f11355a = inetSocketAddress3;
                if (passwordAuthenticationRequestPasswordAuthentication == null) {
                    return new ze.i0(h0VarNewBuilder2.f11355a, h0VarNewBuilder2.f11356b, h0VarNewBuilder2.f11357c, h0VarNewBuilder2.f11358d, null);
                }
                h0VarNewBuilder2.f11357c = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                h0VarNewBuilder2.f11358d = passwordAuthenticationRequestPasswordAuthentication.getPassword() != null ? new String(passwordAuthenticationRequestPasswordAuthentication.getPassword()) : null;
                return new ze.i0(h0VarNewBuilder2.f11355a, h0VarNewBuilder2.f11356b, h0VarNewBuilder2.f11357c, h0VarNewBuilder2.f11358d, null);
            } catch (URISyntaxException e4) {
                logger.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e4);
                return null;
            }
        } catch (Throwable th2) {
            logger.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th2);
            return null;
        }
    }
}
