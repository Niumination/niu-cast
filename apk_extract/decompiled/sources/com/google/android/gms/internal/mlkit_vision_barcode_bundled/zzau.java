package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new g(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f2169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f2170b;

    public zzau(double d7, double d10) {
        this.f2169a = d7;
        this.f2170b = d10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 8);
        parcel.writeDouble(this.f2169a);
        qd.k(parcel, 2, 8);
        parcel.writeDouble(this.f2170b);
        qd.j(parcel, i9);
    }
}
