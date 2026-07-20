package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f2029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f2030b;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 2, 8);
        parcel.writeDouble(this.f2029a);
        qd.k(parcel, 3, 8);
        parcel.writeDouble(this.f2030b);
        qd.j(parcel, i9);
    }
}
