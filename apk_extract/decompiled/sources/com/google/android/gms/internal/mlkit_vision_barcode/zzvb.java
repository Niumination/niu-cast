package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvb> CREATOR = new a(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2084d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f2088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f2089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f2090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f2091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f2092o;
    public final String p;

    public zzvb(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.f2081a = str;
        this.f2082b = str2;
        this.f2083c = str3;
        this.f2084d = str4;
        this.e = str5;
        this.f2085h = str6;
        this.f2086i = str7;
        this.f2087j = str8;
        this.f2088k = str9;
        this.f2089l = str10;
        this.f2090m = str11;
        this.f2091n = str12;
        this.f2092o = str13;
        this.p = str14;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2081a);
        qd.e(parcel, 2, this.f2082b);
        qd.e(parcel, 3, this.f2083c);
        qd.e(parcel, 4, this.f2084d);
        qd.e(parcel, 5, this.e);
        qd.e(parcel, 6, this.f2085h);
        qd.e(parcel, 7, this.f2086i);
        qd.e(parcel, 8, this.f2087j);
        qd.e(parcel, 9, this.f2088k);
        qd.e(parcel, 10, this.f2089l);
        qd.e(parcel, 11, this.f2090m);
        qd.e(parcel, 12, this.f2091n);
        qd.e(parcel, 13, this.f2092o);
        qd.e(parcel, 14, this.p);
        qd.j(parcel, i9);
    }
}
