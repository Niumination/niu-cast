package com.transsion.sdk.oneid.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class OdIdInfo extends OneBaseInfo implements Serializable {
    public int appid;
    public String oaid;
    public String opid;
    public String tsid;
    public String vaid;

    public OdIdInfo(GroupFpInfo groupFpInfo) {
        this.vaid = groupFpInfo.vaid;
        UniqueIdInfo uniqueIdInfo = groupFpInfo.dids;
        this.tsid = uniqueIdInfo.tsid;
        this.oaid = uniqueIdInfo.oaid;
        this.opid = uniqueIdInfo.opid;
    }
}
