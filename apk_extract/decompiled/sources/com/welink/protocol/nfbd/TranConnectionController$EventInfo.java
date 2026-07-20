package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import se.d5;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"com/welink/protocol/nfbd/TranConnectionController$EventInfo", "Landroid/os/Parcelable;", "CREATOR", "se/d5", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class TranConnectionController$EventInfo implements Parcelable {
    public static final d5 CREATOR = new d5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3967d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NearDeviceDataParcel f3968h;

    public /* synthetic */ TranConnectionController$EventInfo(int i8, String str, int i9, int i10, int i11, int i12) {
        this(str, i8, i9, (i12 & 8) != 0 ? 0 : i10, (i12 & 16) != 0 ? 0 : i11, (NearDeviceDataParcel) null);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final NearDeviceDataParcel getF3968h() {
        return this.f3968h;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getF3966c() {
        return this.f3966c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranConnectionController$EventInfo)) {
            return false;
        }
        TranConnectionController$EventInfo tranConnectionController$EventInfo = (TranConnectionController$EventInfo) obj;
        return Intrinsics.areEqual(this.f3964a, tranConnectionController$EventInfo.f3964a) && this.f3965b == tranConnectionController$EventInfo.f3965b && this.f3966c == tranConnectionController$EventInfo.f3966c && this.f3967d == tranConnectionController$EventInfo.f3967d && this.e == tranConnectionController$EventInfo.e && Intrinsics.areEqual(this.f3968h, tranConnectionController$EventInfo.f3968h);
    }

    public final int hashCode() {
        String str = this.f3964a;
        int iC = a1.a.c(this.e, a1.a.c(this.f3967d, a1.a.c(this.f3966c, a1.a.c(this.f3965b, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31), 31);
        NearDeviceDataParcel nearDeviceDataParcel = this.f3968h;
        return iC + (nearDeviceDataParcel != null ? nearDeviceDataParcel.hashCode() : 0);
    }

    public final String toString() {
        return "EventInfo(serverIp=" + this.f3964a + ", eventType=" + this.f3965b + ", reasonCode=" + this.f3966c + ", requestId=" + this.f3967d + ", offset=" + this.e + ", data=" + this.f3968h + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f3964a);
        parcel.writeInt(this.f3965b);
        parcel.writeInt(this.f3966c);
        parcel.writeInt(this.f3967d);
        parcel.writeInt(this.e);
    }

    public TranConnectionController$EventInfo(String str, int i8, int i9, int i10, int i11, NearDeviceDataParcel nearDeviceDataParcel) {
        this.f3964a = str;
        this.f3965b = i8;
        this.f3966c = i9;
        this.f3967d = i10;
        this.e = i11;
        this.f3968h = nearDeviceDataParcel;
    }
}
