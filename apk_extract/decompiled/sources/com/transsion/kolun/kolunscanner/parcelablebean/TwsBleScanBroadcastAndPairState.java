package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanBroadcastAndPairState implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanBroadcastAndPairState> CREATOR = new b(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2928c;

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
        TwsBleScanBroadcastAndPairState twsBleScanBroadcastAndPairState = (TwsBleScanBroadcastAndPairState) obj;
        return this.f2926a == twsBleScanBroadcastAndPairState.f2926a && this.f2927b == twsBleScanBroadcastAndPairState.f2927b && this.f2928c == twsBleScanBroadcastAndPairState.f2928c;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f2926a), Boolean.valueOf(this.f2927b), Boolean.valueOf(this.f2928c));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeByte(this.f2926a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2927b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2928c ? (byte) 1 : (byte) 0);
    }
}
