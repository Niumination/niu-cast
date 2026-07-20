package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new a(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2042b;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 2, this.f2041a);
        qd.e(parcel, 3, this.f2042b);
        qd.j(parcel, i9);
    }
}
