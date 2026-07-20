package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvi> CREATOR = new a(25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2113c;

    public zzvi(String str, String str2, int i8) {
        this.f2111a = str;
        this.f2112b = str2;
        this.f2113c = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2111a);
        qd.e(parcel, 2, this.f2112b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f2113c);
        qd.j(parcel, i9);
    }
}
