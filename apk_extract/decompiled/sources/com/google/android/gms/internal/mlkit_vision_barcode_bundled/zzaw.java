package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new g(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2178b;

    public zzaw(int i8, String str) {
        this.f2177a = i8;
        this.f2178b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2177a);
        qd.e(parcel, 2, this.f2178b);
        qd.j(parcel, i9);
    }
}
