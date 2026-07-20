package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaz> CREATOR = new g(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2185c;

    public zzaz(String str, String str2, int i8) {
        this.f2183a = str;
        this.f2184b = str2;
        this.f2185c = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2183a);
        qd.e(parcel, 2, this.f2184b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f2185c);
        qd.j(parcel, i9);
    }
}
