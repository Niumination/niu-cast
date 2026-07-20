package com.transsion.connectx.mirror.source.uibc.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class KeyEventInfo implements Parcelable {
    public static final Parcelable.Creator<KeyEventInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2195c;

    public class a implements Parcelable.Creator<KeyEventInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KeyEventInfo createFromParcel(Parcel parcel) {
            return new KeyEventInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyEventInfo[] newArray(int i10) {
            return new KeyEventInfo[i10];
        }
    }

    public KeyEventInfo(int i10, int i11, String str) {
        this.f2193a = i10;
        this.f2194b = i11;
        this.f2195c = str;
    }

    public int a() {
        return this.f2193a;
    }

    public int b() {
        return this.f2194b;
    }

    public String c() {
        return this.f2195c;
    }

    public void d(Parcel parcel) {
        this.f2193a = parcel.readInt();
        this.f2194b = parcel.readInt();
        this.f2195c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(int i10) {
        this.f2193a = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyEventInfo)) {
            return false;
        }
        KeyEventInfo keyEventInfo = (KeyEventInfo) obj;
        if (a() == keyEventInfo.a() && b() == keyEventInfo.b()) {
            return c().equals(keyEventInfo.c());
        }
        return false;
    }

    public void f(int i10) {
        this.f2194b = i10;
    }

    public void g(String str) {
        this.f2195c = str;
    }

    public int hashCode() {
        return c().hashCode() + ((b() + (a() * 31)) * 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2193a);
        parcel.writeInt(this.f2194b);
        parcel.writeString(this.f2195c);
    }

    public KeyEventInfo(int i10, String str) {
        this(0, i10, str);
    }

    public KeyEventInfo(String str) {
        this(0, 101, str);
    }

    public KeyEventInfo(Parcel parcel) {
        this.f2193a = 0;
        this.f2193a = parcel.readInt();
        this.f2194b = parcel.readInt();
        this.f2195c = parcel.readString();
    }
}
