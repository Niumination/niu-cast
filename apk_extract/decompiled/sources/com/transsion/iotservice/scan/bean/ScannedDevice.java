package com.transsion.iotservice.scan.bean;

import a1.a;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006 "}, d2 = {"Lcom/transsion/iotservice/scan/bean/ScannedDevice;", "", "devicePID", "", "deviceName", "deviceMac", "deviceBrand", "", "deviceRssi", "isLost", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getDevicePID", "()Ljava/lang/String;", "getDeviceName", "getDeviceMac", "getDeviceBrand", "()I", "getDeviceRssi", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "scanconnect_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class ScannedDevice {

    @SerializedName("deviceBrand")
    private final int deviceBrand;

    @SerializedName("deviceMac")
    private final String deviceMac;

    @SerializedName("deviceName")
    private final String deviceName;

    @SerializedName("devicePID")
    private final String devicePID;

    @SerializedName("deviceRssi")
    private final int deviceRssi;

    @SerializedName("isLost")
    private final boolean isLost;

    public ScannedDevice(String devicePID, String deviceName, String deviceMac, int i8, int i9, boolean z2) {
        Intrinsics.checkNotNullParameter(devicePID, "devicePID");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        this.devicePID = devicePID;
        this.deviceName = deviceName;
        this.deviceMac = deviceMac;
        this.deviceBrand = i8;
        this.deviceRssi = i9;
        this.isLost = z2;
    }

    public static /* synthetic */ ScannedDevice copy$default(ScannedDevice scannedDevice, String str, String str2, String str3, int i8, int i9, boolean z2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = scannedDevice.devicePID;
        }
        if ((i10 & 2) != 0) {
            str2 = scannedDevice.deviceName;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            str3 = scannedDevice.deviceMac;
        }
        String str5 = str3;
        if ((i10 & 8) != 0) {
            i8 = scannedDevice.deviceBrand;
        }
        int i11 = i8;
        if ((i10 & 16) != 0) {
            i9 = scannedDevice.deviceRssi;
        }
        int i12 = i9;
        if ((i10 & 32) != 0) {
            z2 = scannedDevice.isLost;
        }
        return scannedDevice.copy(str, str4, str5, i11, i12, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDevicePID() {
        return this.devicePID;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceMac() {
        return this.deviceMac;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDeviceBrand() {
        return this.deviceBrand;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDeviceRssi() {
        return this.deviceRssi;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLost() {
        return this.isLost;
    }

    public final ScannedDevice copy(String devicePID, String deviceName, String deviceMac, int deviceBrand, int deviceRssi, boolean isLost) {
        Intrinsics.checkNotNullParameter(devicePID, "devicePID");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        return new ScannedDevice(devicePID, deviceName, deviceMac, deviceBrand, deviceRssi, isLost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScannedDevice)) {
            return false;
        }
        ScannedDevice scannedDevice = (ScannedDevice) other;
        return Intrinsics.areEqual(this.devicePID, scannedDevice.devicePID) && Intrinsics.areEqual(this.deviceName, scannedDevice.deviceName) && Intrinsics.areEqual(this.deviceMac, scannedDevice.deviceMac) && this.deviceBrand == scannedDevice.deviceBrand && this.deviceRssi == scannedDevice.deviceRssi && this.isLost == scannedDevice.isLost;
    }

    public final int getDeviceBrand() {
        return this.deviceBrand;
    }

    public final String getDeviceMac() {
        return this.deviceMac;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDevicePID() {
        return this.devicePID;
    }

    public final int getDeviceRssi() {
        return this.deviceRssi;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLost) + a.c(this.deviceRssi, a.c(this.deviceBrand, a.e(a.e(this.devicePID.hashCode() * 31, 31, this.deviceName), 31, this.deviceMac), 31), 31);
    }

    public final boolean isLost() {
        return this.isLost;
    }

    public String toString() {
        String str = this.devicePID;
        String str2 = this.deviceName;
        String str3 = this.deviceMac;
        int i8 = this.deviceBrand;
        int i9 = this.deviceRssi;
        boolean z2 = this.isLost;
        StringBuilder sbP = h0.a.p("ScannedDevice(devicePID=", str, ", deviceName=", str2, ", deviceMac=");
        sbP.append(str3);
        sbP.append(", deviceBrand=");
        sbP.append(i8);
        sbP.append(", deviceRssi=");
        sbP.append(i9);
        sbP.append(", isLost=");
        sbP.append(z2);
        sbP.append(")");
        return sbP.toString();
    }
}
