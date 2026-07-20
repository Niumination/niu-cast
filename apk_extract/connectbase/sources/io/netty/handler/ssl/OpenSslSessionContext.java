package io.netty.handler.ssl;

import ik.f;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SessionTicketKey;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OpenSslSessionContext implements SSLSessionContext {
    final ReferenceCountedOpenSslContext context;
    private final long mask;
    private final OpenSslKeyMaterialProvider provider;
    private final OpenSslSessionCache sessionCache;
    private final OpenSslSessionStats stats;

    public OpenSslSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider, long j10, OpenSslSessionCache openSslSessionCache) {
        this.context = referenceCountedOpenSslContext;
        this.provider = openSslKeyMaterialProvider;
        this.mask = j10;
        this.stats = new OpenSslSessionStats(referenceCountedOpenSslContext);
        this.sessionCache = openSslSessionCache;
        SSLContext.setSSLSessionCache(referenceCountedOpenSslContext.ctx, openSslSessionCache);
    }

    public final void destroy() {
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = this.provider;
        if (openSslKeyMaterialProvider != null) {
            openSslKeyMaterialProvider.destroy();
        }
        this.sessionCache.clear();
    }

    @Override // javax.net.ssl.SSLSessionContext
    public Enumeration<byte[]> getIds() {
        return new Enumeration<byte[]>() { // from class: io.netty.handler.ssl.OpenSslSessionContext.1
            private final Iterator<OpenSslSessionId> ids;

            {
                this.ids = OpenSslSessionContext.this.sessionCache.getIds().iterator();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.ids.hasNext();
            }

            @Override // java.util.Enumeration
            public byte[] nextElement() {
                return this.ids.next().cloneBytes();
            }
        };
    }

    @Override // javax.net.ssl.SSLSessionContext
    public SSLSession getSession(byte[] bArr) {
        return this.sessionCache.getSession(new OpenSslSessionId(bArr));
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionCacheSize() {
        return this.sessionCache.getSessionCacheSize();
    }

    @Override // javax.net.ssl.SSLSessionContext
    public int getSessionTimeout() {
        return this.sessionCache.getSessionTimeout();
    }

    public final boolean isInCache(OpenSslSessionId openSslSessionId) {
        return this.sessionCache.containsSessionWithId(openSslSessionId);
    }

    public boolean isSessionCacheEnabled() {
        Lock lock = this.context.ctxLock.readLock();
        lock.lock();
        try {
            return (SSLContext.getSessionCacheMode(this.context.ctx) & this.mask) != 0;
        } finally {
            lock.unlock();
        }
    }

    public final void removeFromCache(OpenSslSessionId openSslSessionId) {
        this.sessionCache.removeSessionWithId(openSslSessionId);
    }

    public void setSessionCacheEnabled(boolean z10) {
        long j10 = z10 ? this.mask | SSL.SSL_SESS_CACHE_NO_INTERNAL_LOOKUP | SSL.SSL_SESS_CACHE_NO_INTERNAL_STORE : SSL.SSL_SESS_CACHE_OFF;
        Lock lockWriteLock = this.context.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.setSessionCacheMode(this.context.ctx, j10);
            if (!z10) {
                this.sessionCache.clear();
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionCacheSize(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, f.b.f7973h);
        this.sessionCache.setSessionCacheSize(i10);
    }

    public void setSessionFromCache(String str, int i10, long j10) {
        this.sessionCache.setSession(j10, str, i10);
    }

    @Override // javax.net.ssl.SSLSessionContext
    public void setSessionTimeout(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "seconds");
        Lock lockWriteLock = this.context.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.setSessionCacheTimeout(this.context.ctx, i10);
            this.sessionCache.setSessionTimeout(i10);
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Deprecated
    public void setTicketKeys(byte[] bArr) {
        if (bArr.length % 48 != 0) {
            throw new IllegalArgumentException("keys.length % 48 != 0");
        }
        int length = bArr.length / 48;
        SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 17) {
            int i12 = i10 + 16;
            i10 += 32;
            sessionTicketKeyArr[i11 + 16] = new SessionTicketKey(Arrays.copyOfRange(bArr, i10, 16), Arrays.copyOfRange(bArr, i12, 16), Arrays.copyOfRange(bArr, i12, 16));
        }
        Lock lockWriteLock = this.context.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
        } finally {
            lockWriteLock.unlock();
        }
    }

    public OpenSslSessionStats stats() {
        return this.stats;
    }

    public final boolean useKeyManager() {
        return this.provider != null;
    }

    public void setTicketKeys(OpenSslSessionTicketKey... openSslSessionTicketKeyArr) {
        ObjectUtil.checkNotNull(openSslSessionTicketKeyArr, "keys");
        int length = openSslSessionTicketKeyArr.length;
        SessionTicketKey[] sessionTicketKeyArr = new SessionTicketKey[length];
        for (int i10 = 0; i10 < length; i10++) {
            sessionTicketKeyArr[i10] = openSslSessionTicketKeyArr[i10].key;
        }
        Lock lockWriteLock = this.context.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.clearOptions(this.context.ctx, SSL.SSL_OP_NO_TICKET);
            if (length > 0) {
                SSLContext.setSessionTicketKeys(this.context.ctx, sessionTicketKeyArr);
            }
        } finally {
            lockWriteLock.unlock();
        }
    }
}
