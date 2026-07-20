package yj;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends KeyManagerFactory {

    public static final class a extends KeyManagerFactorySpi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<KeyManager> f20948a;

        public a(List<KeyManager> list) {
            this.f20948a = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public KeyManager[] engineGetKeyManagers() {
            return (KeyManager[]) this.f20948a.toArray(new KeyManager[0]);
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(KeyStore keyStore, char[] cArr) {
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters) {
        }
    }

    public g(List<KeyManager> list) {
        super(new a(list), new h1(), "FakeAlgorithm");
    }
}
