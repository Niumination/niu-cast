package com.transsion.hubsdk.api.os;

import android.os.Parcel;
import android.os.Parcelable;
import uc.a;

/* JADX INFO: loaded from: classes2.dex */
public class TranUserInfo implements Parcelable {
    public static final Parcelable.Creator<TranUserInfo> CREATOR = new a(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2356d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2364o;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2353a);
        parcel.writeInt(i8);
        parcel.writeString(this.f2354b);
        parcel.writeString(this.f2355c);
        parcel.writeInt(this.f2356d);
        parcel.writeString(this.e);
        parcel.writeLong(this.f2357h);
        parcel.writeByte(this.f2358i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2359j ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f2360k);
        parcel.writeInt(this.f2361l);
        parcel.writeInt(this.f2362m);
        parcel.writeInt(this.f2363n);
        parcel.writeByte(this.f2364o ? (byte) 1 : (byte) 0);
    }
}
