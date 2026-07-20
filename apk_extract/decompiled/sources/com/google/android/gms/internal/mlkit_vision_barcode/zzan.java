package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new a(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1991d;
    public final int e;

    public zzan(int i8, int i9, int i10, int i11, long j8) {
        this.f1988a = i8;
        this.f1989b = i9;
        this.f1990c = i10;
        this.f1991d = j8;
        this.e = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        int i10 = this.f1988a;
        qd.k(parcel, 2, 4);
        parcel.writeInt(i10);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1989b);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1990c);
        qd.k(parcel, 5, 8);
        parcel.writeLong(this.f1991d);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.e);
        qd.j(parcel, i9);
    }
}
