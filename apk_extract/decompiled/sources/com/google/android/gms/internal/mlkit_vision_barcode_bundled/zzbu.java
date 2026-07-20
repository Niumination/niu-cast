package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzbu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbu> CREATOR = new g(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2203d;
    public final long e;

    public zzbu(int i8, int i9, int i10, int i11, long j8) {
        this.f2200a = i8;
        this.f2201b = i9;
        this.f2202c = i10;
        this.f2203d = i11;
        this.e = j8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2200a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2201b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f2202c);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f2203d);
        qd.k(parcel, 5, 8);
        parcel.writeLong(this.e);
        qd.j(parcel, i9);
    }
}
