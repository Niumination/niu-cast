package org.appspot.transsion.aiot.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes3.dex */
public class Message implements Parcelable {
    public static final Parcelable.Creator<Message> CREATOR = new b(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8613c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8614d = 0;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        parcel.writeString(this.f8611a);
        parcel.writeString(this.f8612b);
        parcel.writeInt(this.f8613c);
        parcel.writeLong(this.f8614d);
        int iDataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition2 - iDataPosition);
        parcel.setDataPosition(iDataPosition2);
    }
}
