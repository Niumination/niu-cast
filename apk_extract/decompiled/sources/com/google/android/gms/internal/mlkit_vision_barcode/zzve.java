package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzve extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzve> CREATOR = new a(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2102d;
    public final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2104i;

    public zzve(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f2099a = str;
        this.f2100b = str2;
        this.f2101c = str3;
        this.f2102d = str4;
        this.e = str5;
        this.f2103h = str6;
        this.f2104i = str7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f2099a);
        qd.e(parcel, 2, this.f2100b);
        qd.e(parcel, 3, this.f2101c);
        qd.e(parcel, 4, this.f2102d);
        qd.e(parcel, 5, this.e);
        qd.e(parcel, 6, this.f2103h);
        qd.e(parcel, 7, this.f2104i);
        qd.j(parcel, i9);
    }
}
