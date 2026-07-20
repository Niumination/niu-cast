package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new g(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2199b;

    public zzbc(int i8, boolean z2) {
        this.f2198a = i8;
        this.f2199b = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2198a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2199b ? 1 : 0);
        qd.j(parcel, i9);
    }
}
