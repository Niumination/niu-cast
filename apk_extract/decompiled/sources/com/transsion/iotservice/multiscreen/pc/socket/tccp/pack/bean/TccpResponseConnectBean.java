package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpResponseConnectBean;", "", "connectCheck", "", "isRemember", "", "screenSelector", "brandName", "", "deviceName", "mac", "<init>", "(IZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConnectCheck", "()I", "()Z", "getScreenSelector", "getBrandName", "()Ljava/lang/String;", "getDeviceName", "getMac", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpResponseConnectBean {

    @SerializedName("brandName")
    private final String brandName;

    @SerializedName("connectCheck")
    private final int connectCheck;

    @SerializedName("deviceName")
    private final String deviceName;

    @SerializedName("isRemember")
    private final boolean isRemember;

    @SerializedName("mac")
    private final String mac;

    @SerializedName("screenSelector")
    private final int screenSelector;

    public TccpResponseConnectBean(int i8, boolean z2, int i9, String brandName, String deviceName, String str) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.connectCheck = i8;
        this.isRemember = z2;
        this.screenSelector = i9;
        this.brandName = brandName;
        this.deviceName = deviceName;
        this.mac = str;
    }

    public static /* synthetic */ TccpResponseConnectBean copy$default(TccpResponseConnectBean tccpResponseConnectBean, int i8, boolean z2, int i9, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = tccpResponseConnectBean.connectCheck;
        }
        if ((i10 & 2) != 0) {
            z2 = tccpResponseConnectBean.isRemember;
        }
        boolean z3 = z2;
        if ((i10 & 4) != 0) {
            i9 = tccpResponseConnectBean.screenSelector;
        }
        int i11 = i9;
        if ((i10 & 8) != 0) {
            str = tccpResponseConnectBean.brandName;
        }
        String str4 = str;
        if ((i10 & 16) != 0) {
            str2 = tccpResponseConnectBean.deviceName;
        }
        String str5 = str2;
        if ((i10 & 32) != 0) {
            str3 = tccpResponseConnectBean.mac;
        }
        return tccpResponseConnectBean.copy(i8, z3, i11, str4, str5, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getConnectCheck() {
        return this.connectCheck;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsRemember() {
        return this.isRemember;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getScreenSelector() {
        return this.screenSelector;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    public final TccpResponseConnectBean copy(int connectCheck, boolean isRemember, int screenSelector, String brandName, String deviceName, String mac) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        return new TccpResponseConnectBean(connectCheck, isRemember, screenSelector, brandName, deviceName, mac);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TccpResponseConnectBean)) {
            return false;
        }
        TccpResponseConnectBean tccpResponseConnectBean = (TccpResponseConnectBean) other;
        return this.connectCheck == tccpResponseConnectBean.connectCheck && this.isRemember == tccpResponseConnectBean.isRemember && this.screenSelector == tccpResponseConnectBean.screenSelector && Intrinsics.areEqual(this.brandName, tccpResponseConnectBean.brandName) && Intrinsics.areEqual(this.deviceName, tccpResponseConnectBean.deviceName) && Intrinsics.areEqual(this.mac, tccpResponseConnectBean.mac);
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final int getConnectCheck() {
        return this.connectCheck;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getMac() {
        return this.mac;
    }

    public final int getScreenSelector() {
        return this.screenSelector;
    }

    public int hashCode() {
        int iE = a.e(a.e(a.c(this.screenSelector, a.g(this.isRemember, Integer.hashCode(this.connectCheck) * 31, 31), 31), 31, this.brandName), 31, this.deviceName);
        String str = this.mac;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final boolean isRemember() {
        return this.isRemember;
    }

    public String toString() {
        return "TccpResponseConnectBean(connectCheck=" + this.connectCheck + ", isRemember=" + this.isRemember + ", screenSelector=" + this.screenSelector + ", brandName=" + this.brandName + ", deviceName=" + this.deviceName + ", mac=" + this.mac + ")";
    }

    public /* synthetic */ TccpResponseConnectBean(int i8, boolean z2, int i9, String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, z2, (i10 & 4) != 0 ? 0 : i9, str, str2, (i10 & 32) != 0 ? null : str3);
    }
}
