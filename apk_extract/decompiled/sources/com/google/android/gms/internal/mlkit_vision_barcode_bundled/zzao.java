package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new g(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f2133b;

    public zzao(int i8, String[] strArr) {
        this.f2132a = i8;
        this.f2133b = strArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2132a);
        qd.f(parcel, 2, this.f2133b);
        qd.j(parcel, i9);
    }
}
