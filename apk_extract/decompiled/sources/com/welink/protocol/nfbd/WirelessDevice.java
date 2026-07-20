package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/welink/protocol/nfbd/WirelessDevice;", "Landroid/os/Parcelable;", "Bluetooth", "Wifi", "P2p", "Wlan", "Unknown", "Lcom/welink/protocol/nfbd/WirelessDevice$Bluetooth;", "Lcom/welink/protocol/nfbd/WirelessDevice$P2p;", "Lcom/welink/protocol/nfbd/WirelessDevice$Unknown;", "Lcom/welink/protocol/nfbd/WirelessDevice$Wifi;", "Lcom/welink/protocol/nfbd/WirelessDevice$Wlan;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class WirelessDevice implements Parcelable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WirelessDevice$P2p;", "Lcom/welink/protocol/nfbd/WirelessDevice;", "CREATOR", "com/welink/protocol/nfbd/j0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWirelessDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$P2p\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,244:1\n9#2,4:245\n*S KotlinDebug\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$P2p\n*L\n115#1:245,4\n*E\n"})
    public static final /* data */ class P2p extends WirelessDevice {
        public static final j0 CREATOR = new j0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f4015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4016d;
        public final WifiP2pDevice e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f4017h;

        public P2p(String str, String str2, String str3, int i8, WifiP2pDevice wifiP2pDevice, long j8) {
            this.f4013a = str;
            this.f4014b = str2;
            this.f4015c = str3;
            this.f4016d = i8;
            this.e = wifiP2pDevice;
            this.f4017h = j8;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            if (!(obj instanceof P2p)) {
                return false;
            }
            String str2 = this.f4014b;
            if (str2 == null || (str = ((P2p) obj).f4014b) == null || !Intrinsics.areEqual(str2, str)) {
                return ((P2p) obj).f4014b == null && str2 == null;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f4014b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            int i8 = this.f4016d;
            StringBuilder sb2 = new StringBuilder("P2p(ssid=");
            sb2.append(this.f4013a);
            sb2.append(", bssid=");
            sb2.append(this.f4014b);
            sb2.append(", password=");
            sb2.append(this.f4015c);
            sb2.append(", channel=");
            sb2.append(i8);
            sb2.append(", device=");
            sb2.append(this.e);
            sb2.append(", timeout=");
            return o.d.p(sb2, this.f4017h, ")");
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4013a);
            parcel.writeString(this.f4014b);
            parcel.writeString(this.f4015c);
            parcel.writeInt(this.f4016d);
            parcel.writeParcelable(this.e, i8);
            parcel.writeLong(this.f4017h);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WirelessDevice$Unknown;", "Lcom/welink/protocol/nfbd/WirelessDevice;", "CREATOR", "com/welink/protocol/nfbd/k0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWirelessDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$Unknown\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,244:1\n9#2,4:245\n*S KotlinDebug\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$Unknown\n*L\n208#1:245,4\n*E\n"})
    public static final /* data */ class Unknown extends WirelessDevice {
        public static final k0 CREATOR = new k0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f4020c;

        public Unknown(String str, String str2, ScanResult scanResult) {
            this.f4018a = str;
            this.f4019b = str2;
            this.f4020c = scanResult;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof Unknown) && (str = this.f4019b) != null && (str2 = ((Unknown) obj).f4019b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f4019b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Unknown(deviceName=" + this.f4018a + ", deviceAddress=" + this.f4019b + ", scanResult=" + this.f4020c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4018a);
            parcel.writeString(this.f4019b);
            parcel.writeParcelable(this.f4020c, i8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WirelessDevice$Wifi;", "Lcom/welink/protocol/nfbd/WirelessDevice;", "CREATOR", "com/welink/protocol/nfbd/l0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWirelessDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$Wifi\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,244:1\n9#2,4:245\n*S KotlinDebug\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$Wifi\n*L\n65#1:245,4\n*E\n"})
    public static final /* data */ class Wifi extends WirelessDevice {
        public static final l0 CREATOR = new l0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final android.net.wifi.ScanResult f4023c;

        public Wifi(String str, String str2, android.net.wifi.ScanResult scanResult) {
            this.f4021a = str;
            this.f4022b = str2;
            this.f4023c = scanResult;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            if (!(obj instanceof Wifi)) {
                return false;
            }
            String str2 = this.f4022b;
            if (str2 == null || (str = ((Wifi) obj).f4022b) == null || !Intrinsics.areEqual(str2, str)) {
                return ((Wifi) obj).f4022b == null && str2 == null;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f4022b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Wifi(ssid=" + this.f4021a + ", bssid=" + this.f4022b + ", scanResult=" + this.f4023c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4021a);
            parcel.writeString(this.f4022b);
            parcel.writeParcelable(this.f4023c, i8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WirelessDevice$Wlan;", "Lcom/welink/protocol/nfbd/WirelessDevice;", "CREATOR", "com/welink/protocol/nfbd/m0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class Wlan extends WirelessDevice {
        public static final m0 CREATOR = new m0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4026c;

        public Wlan(String str, String str2, String str3) {
            this.f4024a = str;
            this.f4025b = str2;
            this.f4026c = str3;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof Wlan) && (str = this.f4025b) != null && (str2 = ((Wlan) obj).f4025b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f4025b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Wlan(deviceName=" + this.f4024a + ", remoteAddress=" + this.f4025b + ", localAddress=" + this.f4026c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4024a);
            parcel.writeString(this.f4025b);
            parcel.writeString(this.f4026c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WirelessDevice$Bluetooth;", "Lcom/welink/protocol/nfbd/WirelessDevice;", "CREATOR", "com/welink/protocol/nfbd/i0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWirelessDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$Bluetooth\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,244:1\n9#2,4:245\n9#2,4:249\n*S KotlinDebug\n*F\n+ 1 WirelessDevice.kt\ncom/welink/protocol/nfbd/WirelessDevice$Bluetooth\n*L\n18#1:245,4\n19#1:249,4\n*E\n"})
    public static final /* data */ class Bluetooth extends WirelessDevice {
        public static final i0 CREATOR = new i0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f4010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BluetoothDevice f4011d;
        public int e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4012h;

        public Bluetooth(String str, String str2, ScanResult scanResult, BluetoothDevice bluetoothDevice, int i8, int i9) {
            this.f4008a = str;
            this.f4009b = str2;
            this.f4010c = scanResult;
            this.f4011d = bluetoothDevice;
            this.e = i8;
            this.f4012h = i9;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof Bluetooth) && (str = this.f4009b) != null && (str2 = ((Bluetooth) obj).f4009b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f4009b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            int i8 = this.e;
            int i9 = this.f4012h;
            StringBuilder sb2 = new StringBuilder("Bluetooth(deviceName=");
            sb2.append(this.f4008a);
            sb2.append(", deviceAddress=");
            sb2.append(this.f4009b);
            sb2.append(", scanResult=");
            sb2.append(this.f4010c);
            sb2.append(", device=");
            sb2.append(this.f4011d);
            sb2.append(", requestId=");
            sb2.append(i8);
            sb2.append(", offset=");
            return h0.a.m(sb2, ")", i9);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4008a);
            parcel.writeString(this.f4009b);
            parcel.writeParcelable(this.f4010c, i8);
            parcel.writeParcelable(this.f4011d, i8);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f4012h);
        }

        public /* synthetic */ Bluetooth(String str, String str2, ScanResult scanResult, BluetoothDevice bluetoothDevice) {
            this(str, str2, scanResult, bluetoothDevice, 0, 0);
        }
    }
}
