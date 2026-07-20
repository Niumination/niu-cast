package com.transsion.infra.gateway.core.bean;

import zh.d;

/* JADX INFO: loaded from: classes2.dex */
public class GatewaySignKey {
    public d algorithm;
    public String key;
    public int keyVersion;

    public GatewaySignKey(String key, int keyVersion, d algorithm) {
        this.key = key;
        this.keyVersion = keyVersion;
        this.algorithm = algorithm;
    }

    public d getAlgorithm() {
        return this.algorithm;
    }

    public String getKey() {
        return this.key;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public void setAlgorithm(d algorithm) {
        this.algorithm = algorithm;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setKeyVersion(int keyVersion) {
        this.keyVersion = keyVersion;
    }
}
