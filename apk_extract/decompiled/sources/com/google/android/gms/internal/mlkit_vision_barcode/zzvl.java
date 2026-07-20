package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvl> CREATOR = new a(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2127b;

    public zzvl(int i8, boolean z2) {
        this.f2126a = i8;
        this.f2127b = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2126a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2127b ? 1 : 0);
        qd.j(parcel, i9);
    }
}
