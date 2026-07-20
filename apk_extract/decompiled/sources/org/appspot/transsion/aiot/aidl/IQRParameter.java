package org.appspot.transsion.aiot.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import s8.b;

/* JADX INFO: loaded from: classes3.dex */
public class IQRParameter implements Parcelable {
    public static final Parcelable.Creator<IQRParameter> CREATOR = new b(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8602d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8610o;
    public int p;
    public long q;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "deviceid:" + this.f8599a + ",ssid:" + this.f8600b + ",password:" + this.f8601c + ",bssid:" + this.f8602d + ",channel:" + this.e + ",serviceType" + this.f8603h + ",publicService" + this.f8604i + ",privateService" + this.f8605j + ",subCapability" + this.f8606k + ",brandName" + this.f8607l + ",wiressType" + this.f8608m + ",p2pRole" + this.f8609n + ",deviceName" + this.f8610o + ",deviceType" + this.p + ",timeOut" + this.q;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f8599a);
        parcel.writeString(this.f8600b);
        parcel.writeString(this.f8601c);
        parcel.writeString(this.f8602d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f8603h);
        parcel.writeInt(this.f8604i);
        parcel.writeInt(this.f8605j);
        parcel.writeInt(this.f8606k);
        parcel.writeString(this.f8607l);
        parcel.writeInt(this.f8608m);
        parcel.writeInt(this.f8609n);
        parcel.writeString(this.f8610o);
        parcel.writeInt(this.p);
        parcel.writeLong(this.q);
    }
}
