package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2028d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2025a);
        qd.e(parcel, 3, this.f2026b);
        qd.e(parcel, 4, this.f2027c);
        qd.e(parcel, 5, this.f2028d);
        qd.j(parcel, i9);
    }
}
