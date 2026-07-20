package com.transsion.hubsdk.api.app;

import android.os.Parcel;
import android.os.Parcelable;
import rs.f;

/* JADX INFO: loaded from: classes2.dex */
public class TranNotificationRanking implements Parcelable {
    public static final Parcelable.Creator<TranNotificationRanking> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2201c;

    public class a implements Parcelable.Creator<TranNotificationRanking> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranNotificationRanking createFromParcel(Parcel parcel) {
            return new TranNotificationRanking(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranNotificationRanking[] newArray(int i10) {
            return new TranNotificationRanking[i10];
        }
    }

    public TranNotificationRanking(String str, int i10, boolean z10) {
        this.f2199a = str;
        this.f2200b = i10;
        this.f2201c = z10;
    }

    public String a() {
        return this.f2199a;
    }

    public int b() {
        return this.f2200b;
    }

    public boolean c() {
        return this.f2201c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TranNotificationRanking{mPackageName='" + this.f2199a + "', mUid=" + this.f2200b + ", mIsTranForceAppGroup=" + this.f2201c + f.f14860b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2199a);
        parcel.writeInt(this.f2200b);
        parcel.writeByte(this.f2201c ? (byte) 1 : (byte) 0);
    }

    public TranNotificationRanking(Parcel parcel) {
        this.f2199a = parcel.readString();
        this.f2200b = parcel.readInt();
        this.f2201c = parcel.readByte() != 0;
    }
}
