package com.transsion.kolun.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class KolunTrackingEvent implements Parcelable {
    public static final Parcelable.Creator<KolunTrackingEvent> CREATOR = new b(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f2913d;

    public KolunTrackingEvent(Parcel parcel) {
        this.f2910a = parcel.readString();
        this.f2911b = parcel.readLong();
        this.f2912c = parcel.readString();
        this.f2913d = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2910a);
        parcel.writeLong(this.f2911b);
        parcel.writeString(this.f2912c);
        parcel.writeBundle(this.f2913d);
    }
}
