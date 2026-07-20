package com.google.android.gms.common.server.converter;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new a(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1935c;

    public zac(int i8, String str, int i9) {
        this.f1933a = i8;
        this.f1934b = str;
        this.f1935c = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1933a);
        qd.e(parcel, 2, this.f1934b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1935c);
        qd.j(parcel, i9);
    }

    public zac(String str, int i8) {
        this.f1933a = 1;
        this.f1934b = str;
        this.f1935c = i8;
    }
}
