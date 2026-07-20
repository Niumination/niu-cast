package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new a(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2045c;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 2, this.f2043a);
        qd.e(parcel, 3, this.f2044b);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f2045c);
        qd.j(parcel, i9);
    }
}
