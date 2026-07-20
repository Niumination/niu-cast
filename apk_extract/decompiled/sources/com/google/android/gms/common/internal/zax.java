package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new b(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scope[] f1906d;

    public zax(int i8, int i9, int i10, Scope[] scopeArr) {
        this.f1903a = i8;
        this.f1904b = i9;
        this.f1905c = i10;
        this.f1906d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1903a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1904b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1905c);
        qd.g(parcel, 4, this.f1906d, i8);
        qd.j(parcel, i9);
    }
}
