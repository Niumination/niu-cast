package lj;

import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import k3.fb;
import k3.lc;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7515d = fb.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7516c;

    public a() {
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new mj.m[]{fb.c() ? new mj.a() : null, new mj.l(mj.f.f), new mj.l(mj.j.f8107a), new mj.l(mj.h.f8106a)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((mj.m) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.f7516c = arrayList;
    }

    @Override // lj.m
    public final lc b(X509TrustManager trustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        mj.b bVar = x509TrustManagerExtensions != null ? new mj.b(trustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : super.b(trustManager);
    }

    @Override // lj.m
    public final void c(SSLSocket sslSocket, String str, List protocols) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Iterator it = this.f7516c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((mj.m) next).a(sslSocket));
        mj.m mVar = (mj.m) next;
        if (mVar != null) {
            mVar.c(sslSocket, str, protocols);
        }
    }

    @Override // lj.m
    public final String d(SSLSocket sslSocket) {
        Object next;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Iterator it = this.f7516c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((mj.m) next).a(sslSocket));
        mj.m mVar = (mj.m) next;
        if (mVar != null) {
            return mVar.b(sslSocket);
        }
        return null;
    }

    @Override // lj.m
    public final boolean e(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }
}
