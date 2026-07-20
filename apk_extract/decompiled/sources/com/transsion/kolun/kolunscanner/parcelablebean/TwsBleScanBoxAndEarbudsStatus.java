package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanBoxAndEarbudsStatus implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanBoxAndEarbudsStatus> CREATOR = new b(26);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2925d;
    public boolean e;

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
        TwsBleScanBoxAndEarbudsStatus twsBleScanBoxAndEarbudsStatus = (TwsBleScanBoxAndEarbudsStatus) obj;
        return this.f2922a == twsBleScanBoxAndEarbudsStatus.f2922a && this.f2923b == twsBleScanBoxAndEarbudsStatus.f2923b && this.f2924c == twsBleScanBoxAndEarbudsStatus.f2924c && this.f2925d == twsBleScanBoxAndEarbudsStatus.f2925d && this.e == twsBleScanBoxAndEarbudsStatus.e;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f2922a), Boolean.valueOf(this.f2923b), Boolean.valueOf(this.f2924c), Boolean.valueOf(this.f2925d), Boolean.valueOf(this.e));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeByte(this.f2922a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2923b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2924c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2925d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }
}
