package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import js.a;

/* JADX INFO: loaded from: classes3.dex */
abstract class JettyAlpnSslEngine extends JdkSslEngine {
    private static final boolean available = initAvailable();

    public static final class ClientEngine extends JettyAlpnSslEngine {
        public ClientEngine(SSLEngine sSLEngine, final JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
            super(sSLEngine);
            ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
            final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolSelectionListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols()), "protocolListener");
            a.c(sSLEngine, new a.InterfaceC0232a() { // from class: io.netty.handler.ssl.JettyAlpnSslEngine.ClientEngine.1
                @Override // js.a.InterfaceC0232a
                public List<String> protocols() {
                    return jdkApplicationProtocolNegotiator.protocols();
                }

                @Override // js.a.InterfaceC0232a
                public void selected(String str) throws SSLException {
                    try {
                        protocolSelectionListener.selected(str);
                    } catch (Throwable th2) {
                        throw SslUtils.toSSLHandshakeException(th2);
                    }
                }

                @Override // js.a.InterfaceC0232a
                public void unsupported() {
                    protocolSelectionListener.unsupported();
                }
            });
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
            try {
                a.e(getWrappedEngine());
            } finally {
                super.closeInbound();
            }
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeOutbound() {
            try {
                a.e(getWrappedEngine());
            } finally {
                super.closeOutbound();
            }
        }
    }

    public static final class ServerEngine extends JettyAlpnSslEngine {
        public ServerEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
            super(sSLEngine);
            ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
            final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())), "protocolSelector");
            a.c(sSLEngine, new a.c() { // from class: io.netty.handler.ssl.JettyAlpnSslEngine.ServerEngine.1
                @Override // js.a.c
                public String select(List<String> list) throws SSLException {
                    try {
                        return protocolSelector.select(list);
                    } catch (Throwable th2) {
                        throw SslUtils.toSSLHandshakeException(th2);
                    }
                }

                @Override // js.a.c
                public void unsupported() {
                    protocolSelector.unsupported();
                }
            });
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
            try {
                a.e(getWrappedEngine());
            } finally {
                super.closeInbound();
            }
        }

        @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
        public void closeOutbound() {
            try {
                a.e(getWrappedEngine());
            } finally {
                super.closeOutbound();
            }
        }
    }

    private static boolean initAvailable() {
        if (PlatformDependent.javaVersion() > 8) {
            return false;
        }
        try {
            Class.forName("sun.security.ssl.ALPNExtension", true, null);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isAvailable() {
        return available;
    }

    public static JettyAlpnSslEngine newClientEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
        return new ClientEngine(sSLEngine, jdkApplicationProtocolNegotiator);
    }

    public static JettyAlpnSslEngine newServerEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator) {
        return new ServerEngine(sSLEngine, jdkApplicationProtocolNegotiator);
    }

    private JettyAlpnSslEngine(SSLEngine sSLEngine) {
        super(sSLEngine);
    }
}
