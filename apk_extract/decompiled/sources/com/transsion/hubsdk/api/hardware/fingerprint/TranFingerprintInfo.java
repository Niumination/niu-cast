package com.transsion.hubsdk.api.hardware.fingerprint;

import android.os.Parcel;
import android.os.Parcelable;
import uc.a;

/* JADX INFO: loaded from: classes2.dex */
public class TranFingerprintInfo implements Parcelable {
    public static final Parcelable.Creator<TranFingerprintInfo> CREATOR = new a(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2352d;
    public long e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2349a);
        parcel.writeInt(this.f2350b);
        parcel.writeString(this.f2351c.toString());
        parcel.writeInt(this.f2352d);
        parcel.writeLong(this.e);
    }
}
