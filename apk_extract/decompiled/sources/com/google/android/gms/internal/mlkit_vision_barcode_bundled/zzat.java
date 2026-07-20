package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new g(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2168d;

    public zzat(int i8, String str, String str2, String str3) {
        this.f2165a = i8;
        this.f2166b = str;
        this.f2167c = str2;
        this.f2168d = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2165a);
        qd.e(parcel, 2, this.f2166b);
        qd.e(parcel, 3, this.f2167c);
        qd.e(parcel, 4, this.f2168d);
        qd.j(parcel, i9);
    }
}
