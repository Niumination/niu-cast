package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvf> CREATOR = new a(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2106b;

    public zzvf(int i8, String str) {
        this.f2105a = i8;
        this.f2106b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2105a);
        qd.e(parcel, 2, this.f2106b);
        qd.j(parcel, i9);
    }
}
