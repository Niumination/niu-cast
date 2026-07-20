package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;
import u2.c;
import u2.l;
import u2.w;

/* JADX INFO: loaded from: classes.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new b(15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBinder f1900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConnectionResult f1901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1902d;
    public final boolean e;

    public zav(int i8, IBinder iBinder, ConnectionResult connectionResult, boolean z2, boolean z3) {
        this.f1899a = i8;
        this.f1900b = iBinder;
        this.f1901c = connectionResult;
        this.f1902d = z2;
        this.e = z3;
    }

    public final boolean equals(Object obj) {
        Object wVar;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (this.f1901c.equals(zavVar.f1901c)) {
            Object wVar2 = null;
            IBinder iBinder = this.f1900b;
            if (iBinder == null) {
                wVar = null;
            } else {
                int i8 = u2.a.f10327c;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                wVar = iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new w(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = zavVar.f1900b;
            if (iBinder2 != null) {
                int i9 = u2.a.f10327c;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                wVar2 = iInterfaceQueryLocalInterface2 instanceof c ? (c) iInterfaceQueryLocalInterface2 : new w(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (l.h(wVar, wVar2)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1899a);
        qd.c(parcel, 2, this.f1900b);
        qd.d(parcel, 3, this.f1901c, i8);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1902d ? 1 : 0);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        qd.j(parcel, i9);
    }
}
