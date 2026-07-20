package org.appspot.transsion.aiot.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes3.dex */
public class IBluetoothBean implements Parcelable {
    public static final Parcelable.Creator<IBluetoothBean> CREATOR = new b(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8577d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8578h;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "BluetoothBean{name='" + this.f8574a + "', address='" + this.f8575b + "', alias='" + this.f8576c + "', isConnected=" + this.f8577d + "', batterylevel=" + this.e + "', isActive=" + this.f8578h + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f8574a);
        parcel.writeString(this.f8575b);
        parcel.writeString(this.f8576c);
        parcel.writeBoolean(this.f8577d);
        parcel.writeInt(this.e);
        parcel.writeBoolean(this.f8578h);
    }
}
