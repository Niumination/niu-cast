package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
final class OpenSslKeyMaterialManager {
    private static final Map<String, String> KEY_TYPES;
    static final String KEY_TYPE_DH_RSA = "DH_RSA";
    static final String KEY_TYPE_EC = "EC";
    static final String KEY_TYPE_EC_EC = "EC_EC";
    static final String KEY_TYPE_EC_RSA = "EC_RSA";
    static final String KEY_TYPE_RSA = "RSA";
    private final OpenSslKeyMaterialProvider provider;

    static {
        HashMap map = new HashMap();
        KEY_TYPES = map;
        map.put(KEY_TYPE_RSA, KEY_TYPE_RSA);
        map.put("DHE_RSA", KEY_TYPE_RSA);
        map.put("ECDHE_RSA", KEY_TYPE_RSA);
        map.put("ECDHE_ECDSA", KEY_TYPE_EC);
        map.put("ECDH_RSA", KEY_TYPE_EC_RSA);
        map.put("ECDH_ECDSA", KEY_TYPE_EC_EC);
        map.put(KEY_TYPE_DH_RSA, KEY_TYPE_DH_RSA);
    }

    public OpenSslKeyMaterialManager(OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        this.provider = openSslKeyMaterialProvider;
    }

    private String chooseClientAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) {
        X509KeyManager x509KeyManagerKeyManager = this.provider.keyManager();
        return x509KeyManagerKeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManagerKeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, referenceCountedOpenSslEngine) : x509KeyManagerKeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    private String chooseServerAlias(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) {
        X509KeyManager x509KeyManagerKeyManager = this.provider.keyManager();
        return x509KeyManagerKeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManagerKeyManager).chooseEngineServerAlias(str, null, referenceCountedOpenSslEngine) : x509KeyManagerKeyManager.chooseServerAlias(str, null, null);
    }

    private void setKeyMaterial(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String str) throws SSLException {
        ReferenceCounted referenceCounted = null;
        try {
            try {
                OpenSslKeyMaterial openSslKeyMaterialChooseKeyMaterial = this.provider.chooseKeyMaterial(referenceCountedOpenSslEngine.alloc, str);
                if (openSslKeyMaterialChooseKeyMaterial != null) {
                    referenceCountedOpenSslEngine.setKeyMaterial(openSslKeyMaterialChooseKeyMaterial);
                    openSslKeyMaterialChooseKeyMaterial.release();
                } else if (openSslKeyMaterialChooseKeyMaterial != null) {
                    openSslKeyMaterialChooseKeyMaterial.release();
                }
            } catch (SSLException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new SSLException(e11);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                referenceCounted.release();
            }
            throw th2;
        }
    }

    public void setKeyMaterialClientSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, String[] strArr, X500Principal[] x500PrincipalArr) throws SSLException {
        String strChooseClientAlias = chooseClientAlias(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
        if (strChooseClientAlias != null) {
            setKeyMaterial(referenceCountedOpenSslEngine, strChooseClientAlias);
        }
    }

    public void setKeyMaterialServerSide(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) throws SSLException {
        String strChooseServerAlias;
        String[] strArrAuthMethods = referenceCountedOpenSslEngine.authMethods();
        if (strArrAuthMethods.length == 0) {
            throw new SSLHandshakeException("Unable to find key material");
        }
        HashSet hashSet = new HashSet(KEY_TYPES.size());
        for (String str : strArrAuthMethods) {
            String str2 = KEY_TYPES.get(str);
            if (str2 != null && hashSet.add(str2) && (strChooseServerAlias = chooseServerAlias(referenceCountedOpenSslEngine, str2)) != null) {
                setKeyMaterial(referenceCountedOpenSslEngine, strChooseServerAlias);
                return;
            }
        }
        throw new SSLHandshakeException("Unable to find key material for auth method(s): " + Arrays.toString(strArrAuthMethods));
    }
}
