package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvd> CREATOR = new a(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f2097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f2098b;

    public zzvd(double d7, double d10) {
        this.f2097a = d7;
        this.f2098b = d10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 8);
        parcel.writeDouble(this.f2097a);
        qd.k(parcel, 2, 8);
        parcel.writeDouble(this.f2098b);
        qd.j(parcel, i9);
    }
}
