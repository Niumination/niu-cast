package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new a(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2038b;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2037a);
        qd.e(parcel, 3, this.f2038b);
        qd.j(parcel, i9);
    }
}
