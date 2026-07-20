package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvg> CREATOR = new a(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2108b;

    public zzvg(String str, String str2) {
        this.f2107a = str;
        this.f2108b = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2107a);
        qd.e(parcel, 2, this.f2108b);
        qd.j(parcel, i9);
    }
}
