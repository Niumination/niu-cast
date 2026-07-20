package com.transsion.hubsdk.api.view;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class TranBrightnessInfo implements Parcelable {
    public static final Parcelable.Creator<TranBrightnessInfo> CREATOR = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2255i = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2256n = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2257p = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2258v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2259w = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2266g;

    public class a implements Parcelable.Creator<TranBrightnessInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TranBrightnessInfo createFromParcel(Parcel parcel) {
            return new TranBrightnessInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TranBrightnessInfo[] newArray(int i10) {
            return new TranBrightnessInfo[i10];
        }
    }

    public /* synthetic */ TranBrightnessInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f2260a);
        parcel.writeFloat(this.f2261b);
        parcel.writeFloat(this.f2262c);
        parcel.writeFloat(this.f2263d);
        parcel.writeInt(this.f2265f);
        parcel.writeFloat(this.f2264e);
        parcel.writeInt(this.f2266g);
    }

    public TranBrightnessInfo() {
    }

    public TranBrightnessInfo(Parcel parcel) {
        this.f2260a = parcel.readFloat();
        this.f2261b = parcel.readFloat();
        this.f2262c = parcel.readFloat();
        this.f2263d = parcel.readFloat();
        this.f2265f = parcel.readInt();
        this.f2264e = parcel.readFloat();
        this.f2266g = parcel.readInt();
    }
}
