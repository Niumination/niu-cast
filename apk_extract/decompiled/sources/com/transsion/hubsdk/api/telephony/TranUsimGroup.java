package com.transsion.hubsdk.api.telephony;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranUsimGroup implements Parcelable {
    public static final Parcelable.Creator<TranUsimGroup> CREATOR = new a(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2371b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TranUsimGroup '");
        sb2.append(this.f2371b);
        sb2.append("' '");
        return h0.a.n(sb2, this.f2370a, "' ");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2370a);
        parcel.writeInt(this.f2371b);
    }
}
