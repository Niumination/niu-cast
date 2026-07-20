package com.transsion.hubsdk.api.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TranAlphaTag implements Parcelable {
    public static final Parcelable.Creator<TranAlphaTag> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2252c;

    public class a implements Parcelable.Creator<TranAlphaTag> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranAlphaTag createFromParcel(Parcel parcel) {
            return new TranAlphaTag(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranAlphaTag[] newArray(int i10) {
            return new TranAlphaTag[i10];
        }
    }

    public TranAlphaTag() {
        this.f2251b = null;
    }

    public static boolean j(String str, String str2) {
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
        return this.f2251b;
    }

    public int b() {
        return this.f2252c;
    }

    public int c() {
        return this.f2250a;
    }

    public boolean d() {
        return TextUtils.isEmpty(this.f2251b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e(TranAlphaTag tranAlphaTag) {
        return j(this.f2251b, tranAlphaTag.f2251b);
    }

    public void f(Parcel parcel) {
        this.f2250a = parcel.readInt();
        this.f2251b = parcel.readString();
        this.f2252c = parcel.readInt();
    }

    public void g(String str) {
        this.f2251b = str;
    }

    public void h(int i10) {
        this.f2252c = i10;
    }

    public void i(int i10) {
        this.f2250a = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TranAlphaTag: '");
        sb2.append(this.f2250a);
        sb2.append("' '");
        sb2.append(this.f2251b);
        sb2.append("' '");
        return c.a.a(sb2, this.f2252c, "'");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f2250a);
        parcel.writeString(this.f2251b);
        parcel.writeInt(this.f2252c);
    }

    public TranAlphaTag(Parcel parcel) {
        this.f2251b = null;
        this.f2250a = parcel.readInt();
        this.f2251b = parcel.readString();
        this.f2252c = parcel.readInt();
    }
}
