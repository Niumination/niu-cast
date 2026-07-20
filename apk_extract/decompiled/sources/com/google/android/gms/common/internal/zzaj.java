package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new b(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1907a;

    public zzaj(int i8) {
        this.f1907a = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1907a);
        qd.j(parcel, i9);
    }
}
