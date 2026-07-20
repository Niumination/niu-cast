package org.appspot.transsion.aiot.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import s8.b;

/* JADX INFO: loaded from: classes3.dex */
public class IProxiInterDevice implements Parcelable {
    public static final Parcelable.Creator<IProxiInterDevice> CREATOR = new b(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8582d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f8583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f8585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f8586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8588m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f8589n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f8590o;
    public final String p;
    public final String q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f8591r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f8592s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f8593t;
    public final String u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f8594v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f8595w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f8596x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f8597y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f8598z;

    public IProxiInterDevice(Parcel parcel) {
        this.f8597y = false;
        this.f8579a = parcel.readString();
        this.f8580b = parcel.readString();
        this.f8581c = parcel.readInt();
        this.f8582d = parcel.readInt();
        this.e = parcel.readInt();
        this.f8583h = parcel.createStringArrayList();
        this.f8584i = parcel.readString();
        this.f8585j = parcel.readLong();
        this.f8586k = parcel.readInt();
        this.f8587l = parcel.readInt();
        this.f8588m = parcel.readInt();
        this.f8589n = parcel.readInt();
        this.f8590o = parcel.readByte() != 0;
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.f8591r = parcel.readInt();
        this.f8592s = parcel.readInt();
        this.f8593t = parcel.readString();
        this.u = parcel.readString();
        this.f8594v = parcel.readInt();
        this.f8595w = parcel.readString();
        this.f8596x = parcel.readInt();
        this.f8597y = parcel.readBoolean();
        this.f8598z = parcel.readBoolean();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "deviceId=" + this.f8579a + ",deviceName=" + this.f8580b + ",deviceType=" + this.f8581c + ",wirelessType=" + this.f8582d + ",serviceType=" + this.e + ",publishService=" + this.f8583h + ",deviceAddress=" + this.f8584i + ",currentService=" + this.f8585j + ",connectState=" + this.f8586k + ",bluetoothState=" + this.f8587l + ",wifiP2pState=" + this.f8588m + ",wifiNanState=" + this.f8589n + ",isConnectable=" + this.f8590o + ",remoteIp=" + this.p + ",localIp=" + this.q + ",rssi=" + this.f8591r + ",fileCount=" + this.f8592s + ",fileTypesString=" + this.f8593t + ",deviceBrand=" + this.u + ",publishServiceId=" + this.f8594v + ",shortPid=" + this.f8595w + ",iPhoneRequestResult=" + this.f8596x + "isAutoConnect=" + this.f8597y + ",isInviting=" + this.f8598z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f8579a);
        parcel.writeString(this.f8580b);
        parcel.writeInt(this.f8581c);
        parcel.writeInt(this.f8582d);
        parcel.writeInt(this.e);
        parcel.writeStringList(this.f8583h);
        parcel.writeString(this.f8584i);
        parcel.writeLong(this.f8585j);
        parcel.writeInt(this.f8586k);
        parcel.writeInt(this.f8587l);
        parcel.writeInt(this.f8588m);
        parcel.writeInt(this.f8589n);
        parcel.writeByte(this.f8590o ? (byte) 1 : (byte) 0);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeInt(this.f8591r);
        parcel.writeInt(this.f8592s);
        parcel.writeString(this.f8593t);
        parcel.writeString(this.u);
        parcel.writeInt(this.f8594v);
        parcel.writeString(this.f8595w);
        parcel.writeInt(this.f8596x);
        parcel.writeByte(this.f8597y ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8598z ? (byte) 1 : (byte) 0);
    }
}
