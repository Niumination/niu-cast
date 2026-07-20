package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new a(29);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2016d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f2019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f2021l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f2022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f2023n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2024o;
    public String p;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 2, this.f2013a);
        qd.e(parcel, 3, this.f2014b);
        qd.e(parcel, 4, this.f2015c);
        qd.e(parcel, 5, this.f2016d);
        qd.e(parcel, 6, this.e);
        qd.e(parcel, 7, this.f2017h);
        qd.e(parcel, 8, this.f2018i);
        qd.e(parcel, 9, this.f2019j);
        qd.e(parcel, 10, this.f2020k);
        qd.e(parcel, 11, this.f2021l);
        qd.e(parcel, 12, this.f2022m);
        qd.e(parcel, 13, this.f2023n);
        qd.e(parcel, 14, this.f2024o);
        qd.e(parcel, 15, this.p);
        qd.j(parcel, i9);
    }
}
