package com.transsion.infra.gateway.core.bean;

import ja.a;

/* JADX INFO: loaded from: classes2.dex */
public class GatewaySignKey {
    public a algorithm;
    public String key;
    public int keyVersion;

    public GatewaySignKey(String str, int i8, a aVar) {
        this.key = str;
        this.keyVersion = i8;
        this.algorithm = aVar;
    }

    public a getAlgorithm() {
        return this.algorithm;
    }

    public String getKey() {
        return this.key;
    }

    public int getKeyVersion() {
        return this.keyVersion;
    }

    public void setAlgorithm(a aVar) {
        this.algorithm = aVar;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKeyVersion(int i8) {
        this.keyVersion = i8;
    }
}
