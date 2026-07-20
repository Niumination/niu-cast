package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new a(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f1993b;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1992a);
        qd.f(parcel, 3, this.f1993b);
        qd.j(parcel, i9);
    }
}
