package com.google.android.gms.common;

import a3.a;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f3.b;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new a(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1977d;
    public final boolean e;

    public zzo(String str, boolean z2, boolean z3, IBinder iBinder, boolean z5) {
        this.f1974a = str;
        this.f1975b = z2;
        this.f1976c = z3;
        this.f1977d = (Context) b.l(b.k(iBinder));
        this.e = z5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f1974a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1975b ? 1 : 0);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1976c ? 1 : 0);
        qd.c(parcel, 4, new b(this.f1977d));
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        qd.j(parcel, i9);
    }
}
