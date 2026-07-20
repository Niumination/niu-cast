package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/MultiConnectInfo;", "", "netWorkInfo", "", "connectType", "netWorkType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getNetWorkInfo", "()Ljava/lang/String;", "setNetWorkInfo", "(Ljava/lang/String;)V", "getConnectType", "setConnectType", "getNetWorkType", "()I", "setNetWorkType", "(I)V", "copyFromNullable", "", "info", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class MultiConnectInfo {
    public static final int NETWORK_TYPE_P2P = 10;
    public static final int NETWORK_TYPE_WLAN = 14;

    @SerializedName("connectType")
    private String connectType;

    @SerializedName("netWorkInfo")
    private String netWorkInfo;

    @SerializedName("netWorkType")
    private int netWorkType;

    public MultiConnectInfo(String netWorkInfo, String connectType, int i8) {
        Intrinsics.checkNotNullParameter(netWorkInfo, "netWorkInfo");
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        this.netWorkInfo = netWorkInfo;
        this.connectType = connectType;
        this.netWorkType = i8;
    }

    public static /* synthetic */ MultiConnectInfo copy$default(MultiConnectInfo multiConnectInfo, String str, String str2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = multiConnectInfo.netWorkInfo;
        }
        if ((i9 & 2) != 0) {
            str2 = multiConnectInfo.connectType;
        }
        if ((i9 & 4) != 0) {
            i8 = multiConnectInfo.netWorkType;
        }
        return multiConnectInfo.copy(str, str2, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNetWorkInfo() {
        return this.netWorkInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getConnectType() {
        return this.connectType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNetWorkType() {
        return this.netWorkType;
    }

    public final MultiConnectInfo copy(String netWorkInfo, String connectType, int netWorkType) {
        Intrinsics.checkNotNullParameter(netWorkInfo, "netWorkInfo");
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        return new MultiConnectInfo(netWorkInfo, connectType, netWorkType);
    }

    public final void copyFromNullable(MultiConnectInfo info) {
        String str;
        String str2;
        if (info == null || (str = info.netWorkInfo) == null) {
            str = "p2p0";
        }
        this.netWorkInfo = str;
        if (info == null || (str2 = info.connectType) == null) {
            str2 = "ble";
        }
        this.connectType = str2;
        this.netWorkType = info != null ? info.netWorkType : 10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiConnectInfo)) {
            return false;
        }
        MultiConnectInfo multiConnectInfo = (MultiConnectInfo) other;
        return Intrinsics.areEqual(this.netWorkInfo, multiConnectInfo.netWorkInfo) && Intrinsics.areEqual(this.connectType, multiConnectInfo.connectType) && this.netWorkType == multiConnectInfo.netWorkType;
    }

    public final String getConnectType() {
        return this.connectType;
    }

    public final String getNetWorkInfo() {
        return this.netWorkInfo;
    }

    public final int getNetWorkType() {
        return this.netWorkType;
    }

    public int hashCode() {
        return Integer.hashCode(this.netWorkType) + a.e(this.netWorkInfo.hashCode() * 31, 31, this.connectType);
    }

    public final void setConnectType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.connectType = str;
    }

    public final void setNetWorkInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.netWorkInfo = str;
    }

    public final void setNetWorkType(int i8) {
        this.netWorkType = i8;
    }

    public String toString() {
        String str = this.netWorkInfo;
        String str2 = this.connectType;
        return h0.a.m(h0.a.p("MultiConnectInfo(netWorkInfo=", str, ", connectType=", str2, ", netWorkType="), ")", this.netWorkType);
    }
}
