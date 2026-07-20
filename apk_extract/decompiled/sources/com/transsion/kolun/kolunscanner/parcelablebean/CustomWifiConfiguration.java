package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class CustomWifiConfiguration implements Parcelable {
    public static final Parcelable.Creator<CustomWifiConfiguration> CREATOR = new b(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2917d;
    public String e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2914a);
        parcel.writeString(this.f2915b);
        parcel.writeInt(this.f2916c);
        parcel.writeString(this.f2917d);
        parcel.writeString(this.e);
    }
}
