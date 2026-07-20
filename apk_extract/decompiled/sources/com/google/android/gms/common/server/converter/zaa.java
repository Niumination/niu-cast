package com.google.android.gms.common.server.converter;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringToIntConverter f1932b;

    public zaa(int i8, StringToIntConverter stringToIntConverter) {
        this.f1931a = i8;
        this.f1932b = stringToIntConverter;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1931a);
        qd.d(parcel, 2, this.f1932b, i8);
        qd.j(parcel, i9);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f1931a = 1;
        this.f1932b = stringToIntConverter;
    }
}
