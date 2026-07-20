package com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/pack/bean/TccpRequestConnectBean;", "", "brandName", "", "deviceName", "mac", "isReset", "", "screenSelector", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getBrandName", "()Ljava/lang/String;", "getDeviceName", "getMac", "()Z", "getScreenSelector", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TccpRequestConnectBean {

    @SerializedName("brandName")
    private final String brandName;

    @SerializedName("deviceName")
    private final String deviceName;

    @SerializedName("isReset")
    private final boolean isReset;

    @SerializedName("mac")
    private final String mac;

    @SerializedName("screenSelector")
    private final int screenSelector;

    public TccpRequestConnectBean(String brandName, String deviceName, String mac, boolean z2, int i8) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.brandName = brandName;
        this.deviceName = deviceName;
        this.mac = mac;
        this.isReset = z2;
        this.screenSelector = i8;
    }

    public static /* synthetic */ TccpRequestConnectBean copy$default(TccpRequestConnectBean tccpRequestConnectBean, String str, String str2, String str3, boolean z2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = tccpRequestConnectBean.brandName;
        }
        if ((i9 & 2) != 0) {
            str2 = tccpRequestConnectBean.deviceName;
        }
        String str4 = str2;
        if ((i9 & 4) != 0) {
            str3 = tccpRequestConnectBean.mac;
        }
        String str5 = str3;
        if ((i9 & 8) != 0) {
            z2 = tccpRequestConnectBean.isReset;
        }
        boolean z3 = z2;
        if ((i9 & 16) != 0) {
            i8 = tccpRequestConnectBean.screenSelector;
        }
        return tccpRequestConnectBean.copy(str, str4, str5, z3, i8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBrandName() {
        return this.brandName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMac() {
        return this.mac;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsReset() {
        return this.isReset;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getScreenSelector() {
        return this.screenSelector;
    }

    public final TccpRequestConnectBean copy(String brandName, String deviceName, String mac, boolean isReset, int screenSelector) {
        Intrinsics.checkNotNullParameter(brandName, "brandName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new TccpRequestConnectBean(brandName, deviceName, mac, isReset, screenSelector);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TccpRequestConnectBean)) {
            return false;
        }
        TccpRequestConnectBean tccpRequestConnectBean = (TccpRequestConnectBean) other;
        return Intrinsics.areEqual(this.brandName, tccpRequestConnectBean.brandName) && Intrinsics.areEqual(this.deviceName, tccpRequestConnectBean.deviceName) && Intrinsics.areEqual(this.mac, tccpRequestConnectBean.mac) && this.isReset == tccpRequestConnectBean.isReset && this.screenSelector == tccpRequestConnectBean.screenSelector;
    }

    public final String getBrandName() {
        return this.brandName;
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
        return Integer.hashCode(this.screenSelector) + a.g(this.isReset, a.e(a.e(this.brandName.hashCode() * 31, 31, this.deviceName), 31, this.mac), 31);
    }

    public final boolean isReset() {
        return this.isReset;
    }

    public String toString() {
        String str = this.brandName;
        String str2 = this.deviceName;
        String str3 = this.mac;
        boolean z2 = this.isReset;
        int i8 = this.screenSelector;
        StringBuilder sbP = h0.a.p("TccpRequestConnectBean(brandName=", str, ", deviceName=", str2, ", mac=");
        sbP.append(str3);
        sbP.append(", isReset=");
        sbP.append(z2);
        sbP.append(", screenSelector=");
        return h0.a.m(sbP, ")", i8);
    }

    public /* synthetic */ TccpRequestConnectBean(String str, String str2, String str3, boolean z2, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z2, (i9 & 16) != 0 ? 0 : i8);
    }
}
