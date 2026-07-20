package com.transsion.hubsdk.api.hardware.fingerprint;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranFingerprintInfo implements Parcelable {
    public static final Parcelable.Creator<TranFingerprintInfo> CREATOR = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2213g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f2215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f2217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2219f;

    public class a implements Parcelable.Creator<TranFingerprintInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranFingerprintInfo createFromParcel(Parcel parcel) {
            return new TranFingerprintInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranFingerprintInfo[] newArray(int i10) {
            return new TranFingerprintInfo[i10];
        }
    }

    public TranFingerprintInfo() {
    }

    public CharSequence a() {
        return this.f2215b;
    }

    public int b() {
        return this.f2218e;
    }

    public long c() {
        return this.f2219f;
    }

    public CharSequence d() {
        return this.f2217d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f2216c;
    }

    public void f(CharSequence charSequence) {
        this.f2215b = charSequence;
    }

    public void g(int i10) {
        this.f2218e = i10;
    }

    public void h(long j10) {
        this.f2219f = j10;
    }

    public void i(int i10) {
        this.f2214a = i10;
    }

    public void j(CharSequence charSequence) {
        this.f2217d = charSequence;
    }

    public void k(int i10) {
        this.f2216c = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2214a);
        parcel.writeInt(this.f2216c);
        parcel.writeString(this.f2217d.toString());
        parcel.writeInt(this.f2218e);
        parcel.writeLong(this.f2219f);
    }

    public TranFingerprintInfo(Parcel parcel) {
        this.f2214a = parcel.readInt();
        this.f2216c = parcel.readInt();
        this.f2217d = parcel.readString();
        this.f2218e = parcel.readInt();
        this.f2219f = parcel.readLong();
    }
}
