package com.welink.protocol.utils;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pWfdInfo;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import we.b;
import we.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/welink/protocol/utils/DeviceData;", "Landroid/os/Parcelable;", "we/c", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDeviceData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceData.kt\ncom/welink/protocol/utils/DeviceData\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,81:1\n9#2,4:82\n9#2,4:86\n9#2,4:90\n9#2,4:94\n9#2,4:98\n9#2,4:102\n*S KotlinDebug\n*F\n+ 1 DeviceData.kt\ncom/welink/protocol/utils/DeviceData\n*L\n26#1:82,4\n27#1:86,4\n28#1:90,4\n29#1:94,4\n30#1:98,4\n31#1:102,4\n*E\n"})
public final /* data */ class DeviceData implements Parcelable {

    @JvmField
    public static final Parcelable.Creator<DeviceData> CREATOR = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LanNetworkInfo f4215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BluetoothDevice f4216d;
    public final WifiP2pDevice e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WifiP2pInfo f4217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WifiP2pGroup f4218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WifiP2pWfdInfo f4219j;

    public /* synthetic */ DeviceData(c cVar, String str, LanNetworkInfo lanNetworkInfo, BluetoothDevice bluetoothDevice, int i8) {
        this(cVar, str, lanNetworkInfo, (i8 & 8) != 0 ? null : bluetoothDevice, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceData)) {
            return false;
        }
        DeviceData deviceData = (DeviceData) obj;
        return this.f4213a == deviceData.f4213a && Intrinsics.areEqual(this.f4214b, deviceData.f4214b) && Intrinsics.areEqual(this.f4215c, deviceData.f4215c) && Intrinsics.areEqual(this.f4216d, deviceData.f4216d) && Intrinsics.areEqual(this.e, deviceData.e) && Intrinsics.areEqual(this.f4217h, deviceData.f4217h) && Intrinsics.areEqual(this.f4218i, deviceData.f4218i) && Intrinsics.areEqual(this.f4219j, deviceData.f4219j);
    }

    public final int hashCode() {
        int iHashCode = this.f4213a.hashCode() * 31;
        String str = this.f4214b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        LanNetworkInfo lanNetworkInfo = this.f4215c;
        int iHashCode3 = (iHashCode2 + (lanNetworkInfo == null ? 0 : lanNetworkInfo.hashCode())) * 31;
        BluetoothDevice bluetoothDevice = this.f4216d;
        int iHashCode4 = (iHashCode3 + (bluetoothDevice == null ? 0 : bluetoothDevice.hashCode())) * 31;
        WifiP2pDevice wifiP2pDevice = this.e;
        int iHashCode5 = (iHashCode4 + (wifiP2pDevice == null ? 0 : wifiP2pDevice.hashCode())) * 31;
        WifiP2pInfo wifiP2pInfo = this.f4217h;
        int iHashCode6 = (iHashCode5 + (wifiP2pInfo == null ? 0 : wifiP2pInfo.hashCode())) * 31;
        WifiP2pGroup wifiP2pGroup = this.f4218i;
        int iHashCode7 = (iHashCode6 + (wifiP2pGroup == null ? 0 : wifiP2pGroup.hashCode())) * 31;
        WifiP2pWfdInfo wifiP2pWfdInfo = this.f4219j;
        return iHashCode7 + (wifiP2pWfdInfo != null ? wifiP2pWfdInfo.hashCode() : 0);
    }

    public final String toString() {
        return "DeviceData(deviceType=" + this.f4213a + ", deviceName=" + this.f4214b + ", lanNetworkInfo=" + this.f4215c + ", bluetoothDevice=" + this.f4216d + ", p2pDevice=" + this.e + ", p2pInfo=" + this.f4217h + ", p2pGroup=" + this.f4218i + ", p2pWfdInfo=" + this.f4219j + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i8) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.f4213a.ordinal());
        String str = this.f4214b;
        if (str == null) {
            str = "";
        }
        dest.writeString(str);
        dest.writeParcelable(this.f4215c, i8);
        dest.writeParcelable(this.f4216d, i8);
        dest.writeParcelable(this.e, i8);
        dest.writeParcelable(this.f4217h, i8);
        dest.writeParcelable(this.f4218i, i8);
        dest.writeParcelable(this.f4219j, i8);
    }

    public DeviceData(c deviceType, String str, LanNetworkInfo lanNetworkInfo, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, WifiP2pInfo wifiP2pInfo, WifiP2pGroup wifiP2pGroup, WifiP2pWfdInfo wifiP2pWfdInfo) {
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        this.f4213a = deviceType;
        this.f4214b = str;
        this.f4215c = lanNetworkInfo;
        this.f4216d = bluetoothDevice;
        this.e = wifiP2pDevice;
        this.f4217h = wifiP2pInfo;
        this.f4218i = wifiP2pGroup;
        this.f4219j = wifiP2pWfdInfo;
    }
}
