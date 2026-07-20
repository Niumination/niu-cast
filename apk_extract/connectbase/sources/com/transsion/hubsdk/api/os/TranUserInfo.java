package com.transsion.hubsdk.api.os;

import android.os.Parcel;
import android.os.Parcelable;
import va.x;

/* JADX INFO: loaded from: classes2.dex */
public class TranUserInfo implements Parcelable {
    public static final Parcelable.Creator<TranUserInfo> CREATOR = new a();
    public static final int J = 2;
    public static final int K = 4096;
    public static final int L = 64;
    public static final int M = 16;
    public static final int N = 1;
    public static final int O = 4;
    public static final int P = 8;
    public static final int Q = 32;
    public static final int R = 128;
    public static final int S = 256;
    public static final int T = 512;
    public static final int U = 1024;
    public static final int V = 2048;
    public static final int W = 32768;
    public static final String X = "android.os.usertype.profile.DUAL";
    public static final int Y = -10000;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2226g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2227i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2228n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f2229p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2230v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f2231w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2232x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2234z;

    public class a implements Parcelable.Creator<TranUserInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranUserInfo createFromParcel(Parcel parcel) {
            return new TranUserInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranUserInfo[] newArray(int i10) {
            return new TranUserInfo[i10];
        }
    }

    public TranUserInfo() {
    }

    public void A(boolean z10) {
        this.f2228n = z10;
    }

    public void B(int i10) {
        this.f2232x = i10;
    }

    public void C(int i10) {
        this.f2234z = i10;
    }

    public void D(int i10) {
        this.f2233y = i10;
    }

    public void E(int i10) {
        this.f2224e = i10;
    }

    public void F(String str) {
        this.f2222c = str;
    }

    public long a() {
        return this.f2226g;
    }

    public int b() {
        return this.f2221b;
    }

    public String c() {
        return this.f2225f;
    }

    public int d() {
        return this.f2220a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f2231w;
    }

    public String f() {
        return this.f2223d;
    }

    public int g() {
        return this.f2232x;
    }

    public int h() {
        return this.f2234z;
    }

    public int i() {
        return this.f2233y;
    }

    public int j() {
        return this.f2224e;
    }

    public String k() {
        return this.f2222c;
    }

    public boolean l() {
        return x.f16857j.equals(this.f2222c);
    }

    public boolean m() {
        return this.H;
    }

    public boolean n() {
        return (this.f2221b & 64) != 64;
    }

    public boolean o() {
        return (this.f2221b & 16) == 16;
    }

    public boolean p() {
        return x.f16856i.equals(this.f2222c);
    }

    public boolean q() {
        return this.f2227i;
    }

    public boolean r() {
        return this.f2228n;
    }

    public void s(long j10) {
        this.f2226g = j10;
    }

    public void t(boolean z10) {
        this.H = z10;
    }

    public void u(int i10) {
        this.f2221b = i10;
    }

    public void v(String str) {
        this.f2225f = str;
    }

    public void w(int i10) {
        this.f2220a = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2220a);
        parcel.writeInt(i10);
        parcel.writeString(this.f2222c);
        parcel.writeString(this.f2223d);
        parcel.writeInt(this.f2224e);
        parcel.writeString(this.f2225f);
        parcel.writeLong(this.f2226g);
        parcel.writeByte(this.f2227i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2228n ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f2231w);
        parcel.writeInt(this.f2232x);
        parcel.writeInt(this.f2233y);
        parcel.writeInt(this.f2234z);
        parcel.writeByte(this.H ? (byte) 1 : (byte) 0);
    }

    public void x(String str) {
        this.f2231w = str;
    }

    public void y(String str) {
        this.f2223d = str;
    }

    public void z(boolean z10) {
        this.f2227i = z10;
    }

    public TranUserInfo(Parcel parcel) {
        this.f2220a = parcel.readInt();
        this.f2221b = parcel.readInt();
        this.f2222c = parcel.readString();
        this.f2223d = parcel.readString();
        this.f2224e = parcel.readInt();
        this.f2225f = parcel.readString();
        this.f2226g = parcel.readLong();
        this.f2227i = parcel.readByte() != 0;
        this.f2228n = parcel.readByte() != 0;
        this.f2231w = parcel.readString();
        this.f2232x = parcel.readInt();
        this.f2233y = parcel.readInt();
        this.f2234z = parcel.readInt();
        this.H = parcel.readByte() != 0;
    }
}
