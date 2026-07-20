package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzva extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzva> CREATOR = new a(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzve f2075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzvf[] f2078d;
    public final zzvc[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f2079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzux[] f2080i;

    public zzva(zzve zzveVar, String str, String str2, zzvf[] zzvfVarArr, zzvc[] zzvcVarArr, String[] strArr, zzux[] zzuxVarArr) {
        this.f2075a = zzveVar;
        this.f2076b = str;
        this.f2077c = str2;
        this.f2078d = zzvfVarArr;
        this.e = zzvcVarArr;
        this.f2079h = strArr;
        this.f2080i = zzuxVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.d(parcel, 1, this.f2075a, i8);
        qd.e(parcel, 2, this.f2076b);
        qd.e(parcel, 3, this.f2077c);
        qd.g(parcel, 4, this.f2078d, i8);
        qd.g(parcel, 5, this.e, i8);
        qd.f(parcel, 6, this.f2079h);
        qd.g(parcel, 7, this.f2080i, i8);
        qd.j(parcel, i9);
    }
}
