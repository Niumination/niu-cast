package com.transsion.iotservice.multiscreen.pc.bean;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006$"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/PcBleScanedDeviceBean;", "", "mDeviceName", "", "mRssi", "", "mDeviceMac", "mIsHistoryConnected", "", "mBrand", "mConnectState", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZII)V", "getMDeviceName", "()Ljava/lang/String;", "getMRssi", "()I", "setMRssi", "(I)V", "getMDeviceMac", "getMIsHistoryConnected", "()Z", "getMBrand", "getMConnectState", "setMConnectState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class PcBleScanedDeviceBean {

    @SerializedName("mBrand")
    private final int mBrand;

    @SerializedName("mConnectState")
    private int mConnectState;

    @SerializedName("mDeviceMac")
    private final String mDeviceMac;

    @SerializedName("mDeviceName")
    private final String mDeviceName;

    @SerializedName("mIsHistoryConnected")
    private final boolean mIsHistoryConnected;

    @SerializedName("mRssi")
    private int mRssi;

    public PcBleScanedDeviceBean(String mDeviceName, int i8, String mDeviceMac, boolean z2, int i9, int i10) {
        Intrinsics.checkNotNullParameter(mDeviceName, "mDeviceName");
        Intrinsics.checkNotNullParameter(mDeviceMac, "mDeviceMac");
        this.mDeviceName = mDeviceName;
        this.mRssi = i8;
        this.mDeviceMac = mDeviceMac;
        this.mIsHistoryConnected = z2;
        this.mBrand = i9;
        this.mConnectState = i10;
    }

    public static /* synthetic */ PcBleScanedDeviceBean copy$default(PcBleScanedDeviceBean pcBleScanedDeviceBean, String str, int i8, String str2, boolean z2, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pcBleScanedDeviceBean.mDeviceName;
        }
        if ((i11 & 2) != 0) {
            i8 = pcBleScanedDeviceBean.mRssi;
        }
        int i12 = i8;
        if ((i11 & 4) != 0) {
            str2 = pcBleScanedDeviceBean.mDeviceMac;
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            z2 = pcBleScanedDeviceBean.mIsHistoryConnected;
        }
        boolean z3 = z2;
        if ((i11 & 16) != 0) {
            i9 = pcBleScanedDeviceBean.mBrand;
        }
        int i13 = i9;
        if ((i11 & 32) != 0) {
            i10 = pcBleScanedDeviceBean.mConnectState;
        }
        return pcBleScanedDeviceBean.copy(str, i12, str3, z3, i13, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMDeviceName() {
        return this.mDeviceName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMRssi() {
        return this.mRssi;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMDeviceMac() {
        return this.mDeviceMac;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getMIsHistoryConnected() {
        return this.mIsHistoryConnected;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMBrand() {
        return this.mBrand;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMConnectState() {
        return this.mConnectState;
    }

    public final PcBleScanedDeviceBean copy(String mDeviceName, int mRssi, String mDeviceMac, boolean mIsHistoryConnected, int mBrand, int mConnectState) {
        Intrinsics.checkNotNullParameter(mDeviceName, "mDeviceName");
        Intrinsics.checkNotNullParameter(mDeviceMac, "mDeviceMac");
        return new PcBleScanedDeviceBean(mDeviceName, mRssi, mDeviceMac, mIsHistoryConnected, mBrand, mConnectState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PcBleScanedDeviceBean)) {
            return false;
        }
        PcBleScanedDeviceBean pcBleScanedDeviceBean = (PcBleScanedDeviceBean) other;
        return Intrinsics.areEqual(this.mDeviceName, pcBleScanedDeviceBean.mDeviceName) && this.mRssi == pcBleScanedDeviceBean.mRssi && Intrinsics.areEqual(this.mDeviceMac, pcBleScanedDeviceBean.mDeviceMac) && this.mIsHistoryConnected == pcBleScanedDeviceBean.mIsHistoryConnected && this.mBrand == pcBleScanedDeviceBean.mBrand && this.mConnectState == pcBleScanedDeviceBean.mConnectState;
    }

    public final int getMBrand() {
        return this.mBrand;
    }

    public final int getMConnectState() {
        return this.mConnectState;
    }

    public final String getMDeviceMac() {
        return this.mDeviceMac;
    }

    public final String getMDeviceName() {
        return this.mDeviceName;
    }

    public final boolean getMIsHistoryConnected() {
        return this.mIsHistoryConnected;
    }

    public final int getMRssi() {
        return this.mRssi;
    }

    public int hashCode() {
        return Integer.hashCode(this.mConnectState) + a.c(this.mBrand, a.g(this.mIsHistoryConnected, a.e(a.c(this.mRssi, this.mDeviceName.hashCode() * 31, 31), 31, this.mDeviceMac), 31), 31);
    }

    public final void setMConnectState(int i8) {
        this.mConnectState = i8;
    }

    public final void setMRssi(int i8) {
        this.mRssi = i8;
    }

    public String toString() {
        return "PcBleScanedDeviceBean(mDeviceName=" + this.mDeviceName + ", mRssi=" + this.mRssi + ", mDeviceMac=" + this.mDeviceMac + ", mIsHistoryConnected=" + this.mIsHistoryConnected + ", mBrand=" + this.mBrand + ", mConnectState=" + this.mConnectState + ")";
    }

    public /* synthetic */ PcBleScanedDeviceBean(String str, int i8, String str2, boolean z2, int i9, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i8, str2, z2, i9, (i11 & 32) != 0 ? 0 : i10);
    }
}
