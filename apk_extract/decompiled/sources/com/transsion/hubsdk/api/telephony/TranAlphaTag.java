package com.transsion.hubsdk.api.telephony;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranAlphaTag implements Parcelable {
    public static final Parcelable.Creator<TranAlphaTag> CREATOR = new a(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2369c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TranAlphaTag: '");
        sb2.append(this.f2367a);
        sb2.append("' '");
        sb2.append(this.f2368b);
        sb2.append("' '");
        return h0.a.m(sb2, "'", this.f2369c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2367a);
        parcel.writeString(this.f2368b);
        parcel.writeInt(this.f2369c);
    }
}
