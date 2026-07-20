package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new a(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzp f2007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zzq[] f2010d;
    public zzn[] e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f2011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzi[] f2012i;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.d(parcel, 2, this.f2007a, i8);
        qd.e(parcel, 3, this.f2008b);
        qd.e(parcel, 4, this.f2009c);
        qd.g(parcel, 5, this.f2010d, i8);
        qd.g(parcel, 6, this.e, i8);
        qd.f(parcel, 7, this.f2011h);
        qd.g(parcel, 8, this.f2012i, i8);
        qd.j(parcel, i9);
    }
}
