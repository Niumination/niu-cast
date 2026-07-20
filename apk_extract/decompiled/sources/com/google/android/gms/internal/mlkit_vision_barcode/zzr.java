package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new a(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2040b;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 2, this.f2039a);
        qd.e(parcel, 3, this.f2040b);
        qd.j(parcel, i9);
    }
}
