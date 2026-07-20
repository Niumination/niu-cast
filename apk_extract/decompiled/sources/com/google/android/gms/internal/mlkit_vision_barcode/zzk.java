package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new a(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2004d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zzj f2005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzj f2006i;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 2, this.f2001a);
        qd.e(parcel, 3, this.f2002b);
        qd.e(parcel, 4, this.f2003c);
        qd.e(parcel, 5, this.f2004d);
        qd.e(parcel, 6, this.e);
        qd.d(parcel, 7, this.f2005h, i8);
        qd.d(parcel, 8, this.f2006i, i8);
        qd.j(parcel, i9);
    }
}
