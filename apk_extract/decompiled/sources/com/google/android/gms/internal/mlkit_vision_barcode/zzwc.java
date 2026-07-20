package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.a;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzwc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwc> CREATOR = new a(26);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2131d;
    public final long e;

    public zzwc(int i8, int i9, int i10, int i11, long j8) {
        this.f2128a = i8;
        this.f2129b = i9;
        this.f2130c = i10;
        this.f2131d = i11;
        this.e = j8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2128a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2129b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f2130c);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f2131d);
        qd.k(parcel, 5, 8);
        parcel.writeLong(this.e);
        qd.j(parcel, i9);
    }
}
