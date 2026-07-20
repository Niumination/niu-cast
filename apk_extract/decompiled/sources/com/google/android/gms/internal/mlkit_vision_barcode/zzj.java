package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new a(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1997d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2000j;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1994a);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1995b);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1996c);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.f1997d);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.e);
        qd.k(parcel, 7, 4);
        parcel.writeInt(this.f1998h);
        qd.k(parcel, 8, 4);
        parcel.writeInt(this.f1999i ? 1 : 0);
        qd.e(parcel, 9, this.f2000j);
        qd.j(parcel, i9);
    }
}
