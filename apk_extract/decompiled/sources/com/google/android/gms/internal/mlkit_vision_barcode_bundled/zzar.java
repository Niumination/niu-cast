package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new g(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzav f2147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzaw[] f2150d;
    public final zzat[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f2151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzao[] f2152i;

    public zzar(zzav zzavVar, String str, String str2, zzaw[] zzawVarArr, zzat[] zzatVarArr, String[] strArr, zzao[] zzaoVarArr) {
        this.f2147a = zzavVar;
        this.f2148b = str;
        this.f2149c = str2;
        this.f2150d = zzawVarArr;
        this.e = zzatVarArr;
        this.f2151h = strArr;
        this.f2152i = zzaoVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.d(parcel, 1, this.f2147a, i8);
        qd.e(parcel, 2, this.f2148b);
        qd.e(parcel, 3, this.f2149c);
        qd.g(parcel, 4, this.f2150d, i8);
        qd.g(parcel, 5, this.e, i8);
        qd.f(parcel, 6, this.f2151h);
        qd.g(parcel, 7, this.f2152i, i8);
        qd.j(parcel, i9);
    }
}
