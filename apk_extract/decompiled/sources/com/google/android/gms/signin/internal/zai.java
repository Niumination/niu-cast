package com.google.android.gms.signin.internal;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new a(22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zat f2210b;

    public zai(int i8, zat zatVar) {
        this.f2209a = i8;
        this.f2210b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2209a);
        qd.d(parcel, 2, this.f2210b, i8);
        qd.j(parcel, i9);
    }
}
