package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.welink.protocol.utils.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import se.e5;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"com/welink/protocol/nfbd/TranConnectionController$MessageInfo", "Landroid/os/Parcelable;", "CREATOR", "se/e5", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nTranConnectionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranConnectionController.kt\ncom/welink/protocol/nfbd/TranConnectionController$MessageInfo\n+ 2 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n*L\n1#1,578:1\n9#2,4:579\n9#2,4:583\n9#2,4:587\n*S KotlinDebug\n*F\n+ 1 TranConnectionController.kt\ncom/welink/protocol/nfbd/TranConnectionController$MessageInfo\n*L\n435#1:579,4\n436#1:583,4\n437#1:587,4\n*E\n"})
public final /* data */ class TranConnectionController$MessageInfo implements Parcelable {
    public static final e5 CREATOR = new e5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3972d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DeviceInfo f3973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TranConnectionController$EventInfo f3974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NearDeviceDataParcel f3975j;

    public TranConnectionController$MessageInfo(String str, int i8, int i9, String str2, int i10, DeviceInfo deviceInfo, TranConnectionController$EventInfo tranConnectionController$EventInfo, NearDeviceDataParcel nearDeviceDataParcel) {
        this.f3969a = str;
        this.f3970b = i8;
        this.f3971c = i9;
        this.f3972d = str2;
        this.e = i10;
        this.f3973h = deviceInfo;
        this.f3974i = tranConnectionController$EventInfo;
        this.f3975j = nearDeviceDataParcel;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getF3972d() {
        return this.f3972d;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final DeviceInfo getF3973h() {
        return this.f3973h;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final TranConnectionController$EventInfo getF3974i() {
        return this.f3974i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranConnectionController$MessageInfo)) {
            return false;
        }
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = (TranConnectionController$MessageInfo) obj;
        return Intrinsics.areEqual(this.f3969a, tranConnectionController$MessageInfo.f3969a) && this.f3970b == tranConnectionController$MessageInfo.f3970b && this.f3971c == tranConnectionController$MessageInfo.f3971c && Intrinsics.areEqual(this.f3972d, tranConnectionController$MessageInfo.f3972d) && this.e == tranConnectionController$MessageInfo.e && Intrinsics.areEqual(this.f3973h, tranConnectionController$MessageInfo.f3973h) && Intrinsics.areEqual(this.f3974i, tranConnectionController$MessageInfo.f3974i) && Intrinsics.areEqual(this.f3975j, tranConnectionController$MessageInfo.f3975j);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final NearDeviceDataParcel getF3975j() {
        return this.f3975j;
    }

    public final int hashCode() {
        String str = this.f3969a;
        int iC = a1.a.c(this.f3971c, a1.a.c(this.f3970b, (str == null ? 0 : str.hashCode()) * 31, 31), 31);
        String str2 = this.f3972d;
        int iC2 = a1.a.c(this.e, (iC + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        DeviceInfo deviceInfo = this.f3973h;
        int iHashCode = (iC2 + (deviceInfo == null ? 0 : deviceInfo.hashCode())) * 31;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = this.f3974i;
        int iHashCode2 = (iHashCode + (tranConnectionController$EventInfo == null ? 0 : tranConnectionController$EventInfo.hashCode())) * 31;
        NearDeviceDataParcel nearDeviceDataParcel = this.f3975j;
        return iHashCode2 + (nearDeviceDataParcel != null ? nearDeviceDataParcel.hashCode() : 0);
    }

    public final String toString() {
        return "MessageInfo(serverIp=" + this.f3969a + ", dataPort=" + this.f3970b + ", msgPort=" + this.f3971c + ", devName=" + this.f3972d + ", trannDir=" + this.e + ", deviceInfo=" + this.f3973h + ", eventInfo=" + this.f3974i + ", scanResult=" + this.f3975j + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f3969a);
        parcel.writeInt(this.f3970b);
        parcel.writeInt(this.f3971c);
        parcel.writeString(this.f3972d);
        parcel.writeInt(this.e);
        parcel.writeParcelable(this.f3973h, i8);
        parcel.writeParcelable(this.f3974i, i8);
        parcel.writeParcelable(this.f3975j, i8);
    }
}
