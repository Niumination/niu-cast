package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.util.AsciiString;
import java.util.HashMap;
import java.util.Map;
import rs.f;
import u.a;

/* JADX INFO: loaded from: classes3.dex */
final class OpenSslClientSessionCache extends OpenSslSessionCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<HostPort, OpenSslSessionCache.NativeSslSession> sessions;

    public static final class HostPort {
        private final int hash;
        private final String host;
        private final int port;

        public HostPort(String str, int i10) {
            this.host = str;
            this.port = i10;
            this.hash = (AsciiString.hashCode(str) * 31) + i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof HostPort)) {
                return false;
            }
            HostPort hostPort = (HostPort) obj;
            return this.port == hostPort.port && this.host.equalsIgnoreCase(hostPort.host);
        }

        public int hashCode() {
            return this.hash;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("HostPort{host='");
            sb2.append(this.host);
            sb2.append("', port=");
            return a.a(sb2, this.port, f.f14860b);
        }
    }

    public OpenSslClientSessionCache(OpenSslEngineMap openSslEngineMap) {
        super(openSslEngineMap);
        this.sessions = new HashMap();
    }

    private static HostPort keyFor(String str, int i10) {
        if (str != null || i10 >= 1) {
            return new HostPort(str, i10);
        }
        return null;
    }

    @Override // io.netty.handler.ssl.OpenSslSessionCache
    public synchronized void clear() {
        super.clear();
        this.sessions.clear();
    }

    @Override // io.netty.handler.ssl.OpenSslSessionCache
    public boolean sessionCreated(OpenSslSessionCache.NativeSslSession nativeSslSession) {
        HostPort hostPortKeyFor = keyFor(nativeSslSession.getPeerHost(), nativeSslSession.getPeerPort());
        if (hostPortKeyFor == null || this.sessions.containsKey(hostPortKeyFor)) {
            return false;
        }
        this.sessions.put(hostPortKeyFor, nativeSslSession);
        return true;
    }

    @Override // io.netty.handler.ssl.OpenSslSessionCache
    public void sessionRemoved(OpenSslSessionCache.NativeSslSession nativeSslSession) {
        HostPort hostPortKeyFor = keyFor(nativeSslSession.getPeerHost(), nativeSslSession.getPeerPort());
        if (hostPortKeyFor == null) {
            return;
        }
        this.sessions.remove(hostPortKeyFor);
    }

    @Override // io.netty.handler.ssl.OpenSslSessionCache
    public void setSession(long j10, String str, int i10) {
        HostPort hostPortKeyFor = keyFor(str, i10);
        if (hostPortKeyFor == null) {
            return;
        }
        synchronized (this) {
            try {
                OpenSslSessionCache.NativeSslSession nativeSslSession = this.sessions.get(hostPortKeyFor);
                if (nativeSslSession == null) {
                    return;
                }
                if (!nativeSslSession.isValid()) {
                    removeSessionWithId(nativeSslSession.sessionId());
                    return;
                }
                boolean session = SSL.setSession(j10, nativeSslSession.session());
                if (session) {
                    if (nativeSslSession.shouldBeSingleUse()) {
                        nativeSslSession.invalidate();
                    }
                    nativeSslSession.updateLastAccessedTime();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
