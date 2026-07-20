package com.transsion.hubsdk.api.view;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranBrightnessInfo implements Parcelable {
    public static final Parcelable.Creator<TranBrightnessInfo> CREATOR = new a(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2375d;
    public float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2377i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeFloat(this.f2372a);
        parcel.writeFloat(this.f2373b);
        parcel.writeFloat(this.f2374c);
        parcel.writeFloat(this.f2375d);
        parcel.writeInt(this.f2376h);
        parcel.writeFloat(this.e);
        parcel.writeInt(this.f2377i);
    }
}
