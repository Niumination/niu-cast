package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new g(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2189d;
    public final Point[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzat f2191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zzaw f2192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zzax f2193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final zzaz f2194l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final zzay f2195m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final zzau f2196n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final zzaq f2197o;
    public final zzar p;
    public final zzas q;

    public zzba(int i8, String str, String str2, byte[] bArr, Point[] pointArr, int i9, zzat zzatVar, zzaw zzawVar, zzax zzaxVar, zzaz zzazVar, zzay zzayVar, zzau zzauVar, zzaq zzaqVar, zzar zzarVar, zzas zzasVar) {
        this.f2186a = i8;
        this.f2187b = str;
        this.f2188c = str2;
        this.f2189d = bArr;
        this.e = pointArr;
        this.f2190h = i9;
        this.f2191i = zzatVar;
        this.f2192j = zzawVar;
        this.f2193k = zzaxVar;
        this.f2194l = zzazVar;
        this.f2195m = zzayVar;
        this.f2196n = zzauVar;
        this.f2197o = zzaqVar;
        this.p = zzarVar;
        this.q = zzasVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2186a);
        qd.e(parcel, 2, this.f2187b);
        qd.e(parcel, 3, this.f2188c);
        qd.b(parcel, 4, this.f2189d);
        qd.g(parcel, 5, this.e, i8);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.f2190h);
        qd.d(parcel, 7, this.f2191i, i8);
        qd.d(parcel, 8, this.f2192j, i8);
        qd.d(parcel, 9, this.f2193k, i8);
        qd.d(parcel, 10, this.f2194l, i8);
        qd.d(parcel, 11, this.f2195m, i8);
        qd.d(parcel, 12, this.f2196n, i8);
        qd.d(parcel, 13, this.f2197o, i8);
        qd.d(parcel, 14, this.p, i8);
        qd.d(parcel, 15, this.q, i8);
        qd.j(parcel, i9);
    }
}
