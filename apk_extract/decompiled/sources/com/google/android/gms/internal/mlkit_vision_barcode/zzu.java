package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new a(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2049d;
    public Point[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zzn f2050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzq f2051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zzr f2052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zzt f2053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zzs f2054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zzo f2055m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public zzk f2056n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public zzl f2057o;
    public zzm p;
    public byte[] q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f2059s;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2046a);
        qd.e(parcel, 3, this.f2047b);
        qd.e(parcel, 4, this.f2048c);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.f2049d);
        qd.g(parcel, 6, this.e, i8);
        qd.d(parcel, 7, this.f2050h, i8);
        qd.d(parcel, 8, this.f2051i, i8);
        qd.d(parcel, 9, this.f2052j, i8);
        qd.d(parcel, 10, this.f2053k, i8);
        qd.d(parcel, 11, this.f2054l, i8);
        qd.d(parcel, 12, this.f2055m, i8);
        qd.d(parcel, 13, this.f2056n, i8);
        qd.d(parcel, 14, this.f2057o, i8);
        qd.d(parcel, 15, this.p, i8);
        qd.b(parcel, 16, this.q);
        qd.k(parcel, 17, 4);
        parcel.writeInt(this.f2058r ? 1 : 0);
        qd.k(parcel, 18, 8);
        parcel.writeDouble(this.f2059s);
        qd.j(parcel, i9);
    }
}
