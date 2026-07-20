package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new g(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2174d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2176i;

    public zzav(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f2171a = str;
        this.f2172b = str2;
        this.f2173c = str3;
        this.f2174d = str4;
        this.e = str5;
        this.f2175h = str6;
        this.f2176i = str7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2171a);
        qd.e(parcel, 2, this.f2172b);
        qd.e(parcel, 3, this.f2173c);
        qd.e(parcel, 4, this.f2174d);
        qd.e(parcel, 5, this.e);
        qd.e(parcel, 6, this.f2175h);
        qd.e(parcel, 7, this.f2176i);
        qd.j(parcel, i9);
    }
}
