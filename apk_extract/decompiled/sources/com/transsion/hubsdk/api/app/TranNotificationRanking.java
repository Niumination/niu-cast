package com.transsion.hubsdk.api.app;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranNotificationRanking implements Parcelable {
    public static final Parcelable.Creator<TranNotificationRanking> CREATOR = new a(29);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2338c;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "TranNotificationRanking{mPackageName='" + this.f2336a + "', mUid=" + this.f2337b + ", mIsTranForceAppGroup=" + this.f2338c + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2336a);
        parcel.writeInt(this.f2337b);
        parcel.writeByte(this.f2338c ? (byte) 1 : (byte) 0);
    }
}
