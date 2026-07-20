package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvj> CREATOR = new a(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2117d;
    public final Point[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzvc f2119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zzvf f2120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zzvg f2121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final zzvi f2122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final zzvh f2123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final zzvd f2124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final zzuz f2125o;
    public final zzva p;
    public final zzvb q;

    public zzvj(int i8, String str, String str2, byte[] bArr, Point[] pointArr, int i9, zzvc zzvcVar, zzvf zzvfVar, zzvg zzvgVar, zzvi zzviVar, zzvh zzvhVar, zzvd zzvdVar, zzuz zzuzVar, zzva zzvaVar, zzvb zzvbVar) {
        this.f2114a = i8;
        this.f2115b = str;
        this.f2116c = str2;
        this.f2117d = bArr;
        this.e = pointArr;
        this.f2118h = i9;
        this.f2119i = zzvcVar;
        this.f2120j = zzvfVar;
        this.f2121k = zzvgVar;
        this.f2122l = zzviVar;
        this.f2123m = zzvhVar;
        this.f2124n = zzvdVar;
        this.f2125o = zzuzVar;
        this.p = zzvaVar;
        this.q = zzvbVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2114a);
        qd.e(parcel, 2, this.f2115b);
        qd.e(parcel, 3, this.f2116c);
        qd.b(parcel, 4, this.f2117d);
        qd.g(parcel, 5, this.e, i8);
        qd.k(parcel, 6, 4);
        parcel.writeInt(this.f2118h);
        qd.d(parcel, 7, this.f2119i, i8);
        qd.d(parcel, 8, this.f2120j, i8);
        qd.d(parcel, 9, this.f2121k, i8);
        qd.d(parcel, 10, this.f2122l, i8);
        qd.d(parcel, 11, this.f2123m, i8);
        qd.d(parcel, 12, this.f2124n, i8);
        qd.d(parcel, 13, this.f2125o, i8);
        qd.d(parcel, 14, this.p, i8);
        qd.d(parcel, 15, this.q, i8);
        qd.j(parcel, i9);
    }
}
