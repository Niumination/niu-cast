package com.transsion.athena.data;

import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TrackDataWrapper implements Parcelable {
    public static final Parcelable.Creator<TrackDataWrapper> CREATOR = new b(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrackData f2322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2323c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2321a);
        parcel.writeParcelable(this.f2322b, i8);
        parcel.writeLong(this.f2323c);
    }
}
