package mj;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f8108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f8109b;

    public l(k socketAdapterFactory) {
        Intrinsics.checkNotNullParameter(socketAdapterFactory, "socketAdapterFactory");
        this.f8109b = socketAdapterFactory;
    }

    @Override // mj.m
    public final boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.f8109b.a(sslSocket);
    }

    @Override // mj.m
    public final String b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        m mVarD = d(sslSocket);
        if (mVarD != null) {
            return mVarD.b(sslSocket);
        }
        return null;
    }

    @Override // mj.m
    public final void c(SSLSocket sslSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        m mVarD = d(sslSocket);
        if (mVarD != null) {
            mVarD.c(sslSocket, str, protocols);
        }
    }

    public final synchronized m d(SSLSocket sSLSocket) {
        try {
            if (this.f8108a == null && this.f8109b.a(sSLSocket)) {
                this.f8108a = this.f8109b.b(sSLSocket);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f8108a;
    }

    @Override // mj.m
    public final boolean isSupported() {
        return true;
    }
}
