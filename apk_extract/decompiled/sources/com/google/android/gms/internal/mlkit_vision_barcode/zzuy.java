package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzuy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuy> CREATOR = new a(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2065d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2068j;

    public zzuy(int i8, int i9, int i10, int i11, int i12, int i13, boolean z2, String str) {
        this.f2062a = i8;
        this.f2063b = i9;
        this.f2064c = i10;
        this.f2065d = i11;
        this.e = i12;
        this.f2066h = i13;
        this.f2067i = z2;
        this.f2068j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2062a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2063b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f2064c);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f2065d);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.f2066h);
        qd.k(parcel, 7, 4);
        parcel.writeInt(this.f2067i ? 1 : 0);
        qd.e(parcel, 8, this.f2068j);
        qd.j(parcel, i9);
    }
}
