package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new b(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f1908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Feature[] f1909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConnectionTelemetryConfiguration f1911d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.a(parcel, 1, this.f1908a);
        qd.g(parcel, 2, this.f1909b, i8);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1910c);
        qd.d(parcel, 4, this.f1911d, i8);
        qd.j(parcel, i9);
    }
}
