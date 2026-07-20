package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanBatteryInfo implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanBatteryInfo> CREATOR = new b(25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2921c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TwsBleScanBatteryInfo twsBleScanBatteryInfo = (TwsBleScanBatteryInfo) obj;
        return this.f2919a == twsBleScanBatteryInfo.f2919a && this.f2920b == twsBleScanBatteryInfo.f2920b && this.f2921c == twsBleScanBatteryInfo.f2921c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2919a), Integer.valueOf(this.f2920b), Integer.valueOf(this.f2921c));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2919a);
        parcel.writeInt(this.f2920b);
        parcel.writeInt(this.f2921c);
    }
}
