package com.transsion.hubsdk.api.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import j.c;

/* JADX INFO: loaded from: classes2.dex */
public class TranUsimGroup implements Parcelable {
    public static final Parcelable.Creator<TranUsimGroup> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2254b;

    public class a implements Parcelable.Creator<TranUsimGroup> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranUsimGroup createFromParcel(Parcel parcel) {
            return new TranUsimGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranUsimGroup[] newArray(int i10) {
            return new TranUsimGroup[i10];
        }
    }

    public TranUsimGroup() {
        this.f2253a = null;
    }

    public static boolean h(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str.equals(str2);
    }

    public String a() {
        return this.f2253a;
    }

    public int b() {
        return this.f2254b;
    }

    public boolean c() {
        return TextUtils.isEmpty(this.f2253a);
    }

    public boolean d(TranUsimGroup tranUsimGroup) {
        return h(this.f2253a, tranUsimGroup.f2253a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(Parcel parcel) {
        this.f2253a = parcel.readString();
        this.f2254b = parcel.readInt();
    }

    public void f(String str) {
        this.f2253a = str;
    }

    public void g(int i10) {
        this.f2254b = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TranUsimGroup '");
        sb2.append(this.f2254b);
        sb2.append("' '");
        return c.a(sb2, this.f2253a, "' ");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2253a);
        parcel.writeInt(this.f2254b);
    }

    public TranUsimGroup(int i10, String str) {
        this.f2254b = i10;
        this.f2253a = str;
    }

    public TranUsimGroup(Parcel parcel) {
        this.f2253a = null;
        this.f2253a = parcel.readString();
        this.f2254b = parcel.readInt();
    }
}
