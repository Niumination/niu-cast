package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new g(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2137d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2140j;

    public zzap(int i8, int i9, int i10, int i11, int i12, int i13, boolean z2, String str) {
        this.f2134a = i8;
        this.f2135b = i9;
        this.f2136c = i10;
        this.f2137d = i11;
        this.e = i12;
        this.f2138h = i13;
        this.f2139i = z2;
        this.f2140j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2134a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2135b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f2136c);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f2137d);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.f2138h);
        qd.k(parcel, 7, 4);
        parcel.writeInt(this.f2139i ? 1 : 0);
        qd.e(parcel, 8, this.f2140j);
        qd.j(parcel, i9);
    }
}
