package com.google.android.gms.signin.internal;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new a(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectionResult f2212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zav f2213c;

    public zak(int i8, ConnectionResult connectionResult, zav zavVar) {
        this.f2211a = i8;
        this.f2212b = connectionResult;
        this.f2213c = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2211a);
        qd.d(parcel, 2, this.f2212b, i8);
        qd.d(parcel, 3, this.f2213c, i8);
        qd.j(parcel, i9);
    }
}
