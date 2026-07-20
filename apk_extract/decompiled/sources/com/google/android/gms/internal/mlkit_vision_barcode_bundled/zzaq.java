package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import l3.g;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new g(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2144d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zzap f2145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final zzap f2146i;

    public zzaq(String str, String str2, String str3, String str4, String str5, zzap zzapVar, zzap zzapVar2) {
        this.f2141a = str;
        this.f2142b = str2;
        this.f2143c = str3;
        this.f2144d = str4;
        this.e = str5;
        this.f2145h = zzapVar;
        this.f2146i = zzapVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2141a);
        qd.e(parcel, 2, this.f2142b);
        qd.e(parcel, 3, this.f2143c);
        qd.e(parcel, 4, this.f2144d);
        qd.e(parcel, 5, this.e);
        qd.d(parcel, 6, this.f2145h, i8);
        qd.d(parcel, 7, this.f2146i, i8);
        qd.j(parcel, i9);
    }
}
