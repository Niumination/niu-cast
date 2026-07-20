package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import javax.net.ssl.KeyManager;
import javax.net.ssl.ManagerFactoryParameters;

/* JADX INFO: loaded from: classes3.dex */
public final class KeyManagerFactoryWrapper extends SimpleKeyManagerFactory {

    /* JADX INFO: renamed from: km, reason: collision with root package name */
    private final KeyManager f8337km;

    public KeyManagerFactoryWrapper(KeyManager keyManager) {
        this.f8337km = (KeyManager) ObjectUtil.checkNotNull(keyManager, "km");
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public KeyManager[] engineGetKeyManagers() {
        return new KeyManager[]{this.f8337km};
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(KeyStore keyStore, char[] cArr) throws Exception {
    }

    @Override // io.netty.handler.ssl.util.SimpleKeyManagerFactory
    public void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception {
    }
}
