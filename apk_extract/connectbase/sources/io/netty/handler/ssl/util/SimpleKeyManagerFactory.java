package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleKeyManagerFactory extends KeyManagerFactory {
    private static final FastThreadLocal<SimpleKeyManagerFactorySpi> CURRENT_SPI = new FastThreadLocal<SimpleKeyManagerFactorySpi>() { // from class: io.netty.handler.ssl.util.SimpleKeyManagerFactory.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public SimpleKeyManagerFactorySpi initialValue() {
            return new SimpleKeyManagerFactorySpi();
        }
    };
    private static final Provider PROVIDER;

    static {
        String str = "";
        PROVIDER = new Provider(str, 0.0d, str) { // from class: io.netty.handler.ssl.util.SimpleKeyManagerFactory.1
            private static final long serialVersionUID = -2680540247105807895L;
        };
    }

    public SimpleKeyManagerFactory() {
        this("");
    }

    public abstract KeyManager[] engineGetKeyManagers();

    public abstract void engineInit(KeyStore keyStore, char[] cArr) throws Exception;

    public abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception;

    /* JADX WARN: Illegal instructions before constructor call */
    public SimpleKeyManagerFactory(String str) throws Throwable {
        FastThreadLocal<SimpleKeyManagerFactorySpi> fastThreadLocal = CURRENT_SPI;
        super(fastThreadLocal.get(), PROVIDER, (String) ObjectUtil.checkNotNull(str, "name"));
        fastThreadLocal.get().init(this);
        fastThreadLocal.remove();
    }

    public static final class SimpleKeyManagerFactorySpi extends KeyManagerFactorySpi {
        private volatile KeyManager[] keyManagers;
        private SimpleKeyManagerFactory parent;

        private SimpleKeyManagerFactorySpi() {
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static void wrapIfNeeded(KeyManager[] keyManagerArr) {
            for (int i10 = 0; i10 < keyManagerArr.length; i10++) {
                KeyManager keyManager = keyManagerArr[i10];
                if ((keyManager instanceof X509KeyManager) && !(keyManager instanceof X509ExtendedKeyManager)) {
                    keyManagerArr[i10] = new X509KeyManagerWrapper((X509KeyManager) keyManager);
                }
            }
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public KeyManager[] engineGetKeyManagers() {
            KeyManager[] keyManagerArrEngineGetKeyManagers = this.keyManagers;
            if (keyManagerArrEngineGetKeyManagers == null) {
                keyManagerArrEngineGetKeyManagers = this.parent.engineGetKeyManagers();
                if (PlatformDependent.javaVersion() >= 7) {
                    wrapIfNeeded(keyManagerArrEngineGetKeyManagers);
                }
                this.keyManagers = keyManagerArrEngineGetKeyManagers;
            }
            return (KeyManager[]) keyManagerArrEngineGetKeyManagers.clone();
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(KeyStore keyStore, char[] cArr) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore, cArr);
            } catch (KeyStoreException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new KeyStoreException(e11);
            }
        }

        public void init(SimpleKeyManagerFactory simpleKeyManagerFactory) {
            this.parent = simpleKeyManagerFactory;
        }

        @Override // javax.net.ssl.KeyManagerFactorySpi
        public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new InvalidAlgorithmParameterException(e11);
            }
        }
    }
}
