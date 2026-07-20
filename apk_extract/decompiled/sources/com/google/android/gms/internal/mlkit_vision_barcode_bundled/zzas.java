package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new g(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2156d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f2160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f2161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f2162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f2163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f2164o;
    public final String p;

    public zzas(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.f2153a = str;
        this.f2154b = str2;
        this.f2155c = str3;
        this.f2156d = str4;
        this.e = str5;
        this.f2157h = str6;
        this.f2158i = str7;
        this.f2159j = str8;
        this.f2160k = str9;
        this.f2161l = str10;
        this.f2162m = str11;
        this.f2163n = str12;
        this.f2164o = str13;
        this.p = str14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2153a);
        qd.e(parcel, 2, this.f2154b);
        qd.e(parcel, 3, this.f2155c);
        qd.e(parcel, 4, this.f2156d);
        qd.e(parcel, 5, this.e);
        qd.e(parcel, 6, this.f2157h);
        qd.e(parcel, 7, this.f2158i);
        qd.e(parcel, 8, this.f2159j);
        qd.e(parcel, 9, this.f2160k);
        qd.e(parcel, 10, this.f2161l);
        qd.e(parcel, 11, this.f2162m);
        qd.e(parcel, 12, this.f2163n);
        qd.e(parcel, 13, this.f2164o);
        qd.e(parcel, 14, this.p);
        qd.j(parcel, i9);
    }
}
