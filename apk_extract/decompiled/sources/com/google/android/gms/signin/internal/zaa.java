package com.google.android.gms.signin.internal;

import a3.a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Intent f2206c;

    public zaa(int i8, int i9, Intent intent) {
        this.f2204a = i8;
        this.f2205b = i9;
        this.f2206c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2204a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2205b);
        qd.d(parcel, 3, this.f2206c, i8);
        qd.j(parcel, i9);
    }
}
