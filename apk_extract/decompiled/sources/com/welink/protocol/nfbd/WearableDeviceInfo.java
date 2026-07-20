package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.welink.protocol.ble.EarBudsInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/welink/protocol/nfbd/WearableDeviceInfo;", "Landroid/os/Parcelable;", "TWS", "WATCH", "BAND", "RING_WATCH", "Unknown", "Lcom/welink/protocol/nfbd/WearableDeviceInfo$BAND;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo$RING_WATCH;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo$TWS;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo$Unknown;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo$WATCH;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class WearableDeviceInfo implements Parcelable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WearableDeviceInfo$BAND;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo;", "CREATOR", "com/welink/protocol/nfbd/d0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWearableDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$BAND\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,230:1\n9#2,4:231\n9#2,4:235\n*S KotlinDebug\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$BAND\n*L\n109#1:231,4\n110#1:235,4\n*E\n"})
    public static final /* data */ class BAND extends WearableDeviceInfo {
        public static final d0 CREATOR = new d0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f3989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BluetoothDevice f3990d;

        public BAND(String str, String str2, ScanResult scanResult, BluetoothDevice bluetoothDevice) {
            this.f3987a = str;
            this.f3988b = str2;
            this.f3989c = scanResult;
            this.f3990d = bluetoothDevice;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof BAND) && (str = this.f3988b) != null && (str2 = ((BAND) obj).f3988b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f3988b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "BAND(deviceName=" + this.f3987a + ", deviceAddress=" + this.f3988b + ", scanResult=" + this.f3989c + ", device=" + this.f3990d + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f3987a);
            parcel.writeString(this.f3988b);
            parcel.writeParcelable(this.f3989c, i8);
            parcel.writeParcelable(this.f3990d, i8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WearableDeviceInfo$RING_WATCH;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo;", "CREATOR", "com/welink/protocol/nfbd/e0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWearableDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$RING_WATCH\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,230:1\n9#2,4:231\n9#2,4:235\n*S KotlinDebug\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$RING_WATCH\n*L\n154#1:231,4\n155#1:235,4\n*E\n"})
    public static final /* data */ class RING_WATCH extends WearableDeviceInfo {
        public static final e0 CREATOR = new e0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f3993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BluetoothDevice f3994d;

        public RING_WATCH(String str, String str2, ScanResult scanResult, BluetoothDevice bluetoothDevice) {
            this.f3991a = str;
            this.f3992b = str2;
            this.f3993c = scanResult;
            this.f3994d = bluetoothDevice;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof RING_WATCH) && (str = this.f3992b) != null && (str2 = ((RING_WATCH) obj).f3992b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f3992b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "RING_WATCH(deviceName=" + this.f3991a + ", deviceAddress=" + this.f3992b + ", scanResult=" + this.f3993c + ", device=" + this.f3994d + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f3991a);
            parcel.writeString(this.f3992b);
            parcel.writeParcelable(this.f3993c, i8);
            parcel.writeParcelable(this.f3994d, i8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WearableDeviceInfo$TWS;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo;", "CREATOR", "com/welink/protocol/nfbd/f0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWearableDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$TWS\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,230:1\n9#2,4:231\n9#2,4:235\n9#2,4:239\n*S KotlinDebug\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$TWS\n*L\n14#1:231,4\n15#1:235,4\n18#1:239,4\n*E\n"})
    public static final /* data */ class TWS extends WearableDeviceInfo {
        public static final f0 CREATOR = new f0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f3997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BluetoothDevice f3998d;
        public final int e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Boolean f3999h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final EarBudsInfo f4000i;

        public TWS(String str, String str2, ScanResult scanResult, BluetoothDevice bluetoothDevice, int i8, Boolean bool, EarBudsInfo earBudsInfo) {
            this.f3995a = str;
            this.f3996b = str2;
            this.f3997c = scanResult;
            this.f3998d = bluetoothDevice;
            this.e = i8;
            this.f3999h = bool;
            this.f4000i = earBudsInfo;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof TWS) && (str = this.f3996b) != null && (str2 = ((TWS) obj).f3996b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f3996b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "TWS(deviceName=" + this.f3995a + ", deviceAddress=" + this.f3996b + ", scanResult=" + this.f3997c + ", device=" + this.f3998d + ", type=" + this.e + ", isEarBuds=" + this.f3999h + ", earBudsInfo=" + this.f4000i + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f3995a);
            parcel.writeString(this.f3996b);
            parcel.writeParcelable(this.f3997c, i8);
            parcel.writeParcelable(this.f3998d, i8);
            parcel.writeInt(this.e);
            Boolean bool = this.f3999h;
            Intrinsics.checkNotNull(bool);
            parcel.writeBoolean(bool.booleanValue());
            parcel.writeParcelable(this.f4000i, i8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WearableDeviceInfo$Unknown;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo;", "CREATOR", "com/welink/protocol/nfbd/g0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWearableDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$Unknown\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,230:1\n9#2,4:231\n*S KotlinDebug\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$Unknown\n*L\n199#1:231,4\n*E\n"})
    public static final /* data */ class Unknown extends WearableDeviceInfo {
        public static final g0 CREATOR = new g0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f4003c;

        public Unknown(String str, String str2, ScanResult scanResult) {
            this.f4001a = str;
            this.f4002b = str2;
            this.f4003c = scanResult;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof Unknown) && (str = this.f4002b) != null && (str2 = ((Unknown) obj).f4002b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f4002b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Unknown(deviceName=" + this.f4001a + ", deviceAddress=" + this.f4002b + ", scanResult=" + this.f4003c + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4001a);
            parcel.writeString(this.f4002b);
            parcel.writeParcelable(this.f4003c, i8);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/WearableDeviceInfo$WATCH;", "Lcom/welink/protocol/nfbd/WearableDeviceInfo;", "CREATOR", "com/welink/protocol/nfbd/h0", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @SourceDebugExtension({"SMAP\nWearableDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$WATCH\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,230:1\n9#2,4:231\n9#2,4:235\n*S KotlinDebug\n*F\n+ 1 WearableDeviceInfo.kt\ncom/welink/protocol/nfbd/WearableDeviceInfo$WATCH\n*L\n64#1:231,4\n65#1:235,4\n*E\n"})
    public static final /* data */ class WATCH extends WearableDeviceInfo {
        public static final h0 CREATOR = new h0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ScanResult f4006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BluetoothDevice f4007d;

        public WATCH(String str, String str2, ScanResult scanResult, BluetoothDevice bluetoothDevice) {
            this.f4004a = str;
            this.f4005b = str2;
            this.f4006c = scanResult;
            this.f4007d = bluetoothDevice;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            String str;
            String str2;
            return (obj instanceof WATCH) && (str = this.f4005b) != null && (str2 = ((WATCH) obj).f4005b) != null && Intrinsics.areEqual(str, str2);
        }

        public final int hashCode() {
            String str = this.f4005b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "WATCH(deviceName=" + this.f4004a + ", deviceAddress=" + this.f4005b + ", scanResult=" + this.f4006c + ", device=" + this.f4007d + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.f4004a);
            parcel.writeString(this.f4005b);
            parcel.writeParcelable(this.f4006c, i8);
            parcel.writeParcelable(this.f4007d, i8);
        }
    }
}
