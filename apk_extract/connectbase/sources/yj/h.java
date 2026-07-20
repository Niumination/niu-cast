package yj;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends TrustManagerFactory {

    public static final class a extends TrustManagerFactorySpi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<TrustManager> f20949a;

        public a(List<TrustManager> list) {
            this.f20949a = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        public TrustManager[] engineGetTrustManagers() {
            return (TrustManager[]) this.f20949a.toArray(new TrustManager[0]);
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        public void engineInit(KeyStore keyStore) {
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
        }
    }

    public h(List<TrustManager> list) {
        super(new a(list), new h1(), "FakeAlgorithm");
    }
}
