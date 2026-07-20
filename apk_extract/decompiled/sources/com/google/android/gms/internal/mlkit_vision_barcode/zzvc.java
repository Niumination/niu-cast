package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzvc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvc> CREATOR = new a(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2096d;

    public zzvc(int i8, String str, String str2, String str3) {
        this.f2093a = i8;
        this.f2094b = str;
        this.f2095c = str2;
        this.f2096d = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2093a);
        qd.e(parcel, 2, this.f2094b);
        qd.e(parcel, 3, this.f2095c);
        qd.e(parcel, 4, this.f2096d);
        qd.j(parcel, i9);
    }
}
