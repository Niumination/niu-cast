package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzax> CREATOR = new g(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2180b;

    public zzax(String str, String str2) {
        this.f2179a = str;
        this.f2180b = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2179a);
        qd.e(parcel, 2, this.f2180b);
        qd.j(parcel, i9);
    }
}
