package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzuz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuz> CREATOR = new a(15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2072d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zzuy f2073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzuy f2074i;

    public zzuz(String str, String str2, String str3, String str4, String str5, zzuy zzuyVar, zzuy zzuyVar2) {
        this.f2069a = str;
        this.f2070b = str2;
        this.f2071c = str3;
        this.f2072d = str4;
        this.e = str5;
        this.f2073h = zzuyVar;
        this.f2074i = zzuyVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2069a);
        qd.e(parcel, 2, this.f2070b);
        qd.e(parcel, 3, this.f2071c);
        qd.e(parcel, 4, this.f2072d);
        qd.e(parcel, 5, this.e);
        qd.d(parcel, 6, this.f2073h, i8);
        qd.d(parcel, 7, this.f2074i, i8);
        qd.j(parcel, i9);
    }
}
