package com.welink.protocol.nfbd;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import se.f5;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"com/welink/protocol/nfbd/TranConnectionController$P2pDeviceInfo", "Landroid/os/Parcelable;", "CREATOR", "se/f5", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nTranConnectionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranConnectionController.kt\ncom/welink/protocol/nfbd/TranConnectionController$P2pDeviceInfo\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,578:1\n9#2,4:579\n9#2,4:583\n*S KotlinDebug\n*F\n+ 1 TranConnectionController.kt\ncom/welink/protocol/nfbd/TranConnectionController$P2pDeviceInfo\n*L\n513#1:579,4\n514#1:583,4\n*E\n"})
public final /* data */ class TranConnectionController$P2pDeviceInfo implements Parcelable {
    public static final f5 CREATOR = new f5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3979d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WifiP2pDevice f3982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WifiP2pGroup f3983k;

    public TranConnectionController$P2pDeviceInfo(String str, String str2, int i8, String str3, String str4, int i9, int i10, WifiP2pDevice wifiP2pDevice, WifiP2pGroup wifiP2pGroup) {
        this.f3976a = str;
        this.f3977b = str2;
        this.f3978c = i8;
        this.f3979d = str3;
        this.e = str4;
        this.f3980h = i9;
        this.f3981i = i10;
        this.f3982j = wifiP2pDevice;
        this.f3983k = wifiP2pGroup;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(TranConnectionController$P2pDeviceInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
        TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = (TranConnectionController$P2pDeviceInfo) obj;
        return Intrinsics.areEqual(this.f3976a, tranConnectionController$P2pDeviceInfo.f3976a) && Intrinsics.areEqual(this.f3977b, tranConnectionController$P2pDeviceInfo.f3977b) && this.f3978c == tranConnectionController$P2pDeviceInfo.f3978c && Intrinsics.areEqual(this.f3979d, tranConnectionController$P2pDeviceInfo.f3979d) && Intrinsics.areEqual(this.e, tranConnectionController$P2pDeviceInfo.e) && this.f3980h == tranConnectionController$P2pDeviceInfo.f3980h && this.f3981i == tranConnectionController$P2pDeviceInfo.f3981i && Intrinsics.areEqual(this.f3983k, tranConnectionController$P2pDeviceInfo.f3983k);
    }

    public final int hashCode() {
        String str = this.f3976a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3977b;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f3978c) * 31;
        String str3 = this.f3979d;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int iHashCode4 = (((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f3980h) * 31) + this.f3981i) * 31;
        WifiP2pGroup wifiP2pGroup = this.f3983k;
        return iHashCode4 + (wifiP2pGroup != null ? wifiP2pGroup.hashCode() : 0);
    }

    public final String toString() {
        return "P2pDeviceInfo(ssid=" + this.f3976a + ", bssid=" + this.f3977b + ", channel=" + this.f3978c + ", serverIp=" + this.f3979d + ", localIp=" + this.e + ", serverDataPort=" + this.f3980h + ", serverControlPort=" + this.f3981i + ", p2pGroup=" + this.f3983k + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f3976a);
        parcel.writeString(this.f3977b);
        parcel.writeInt(this.f3978c);
        parcel.writeString(this.f3979d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f3980h);
        parcel.writeInt(this.f3981i);
        parcel.writeParcelable(this.f3982j, i8);
        parcel.writeParcelable(this.f3983k, i8);
    }
}
