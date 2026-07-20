package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new a(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2034d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2036i;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 2, this.f2031a);
        qd.e(parcel, 3, this.f2032b);
        qd.e(parcel, 4, this.f2033c);
        qd.e(parcel, 5, this.f2034d);
        qd.e(parcel, 6, this.e);
        qd.e(parcel, 7, this.f2035h);
        qd.e(parcel, 8, this.f2036i);
        qd.j(parcel, i9);
    }
}
