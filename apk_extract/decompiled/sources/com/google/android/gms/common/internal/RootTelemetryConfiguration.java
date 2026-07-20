package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new b(17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1872d;
    public final int e;

    public RootTelemetryConfiguration(int i8, int i9, int i10, boolean z2, boolean z3) {
        this.f1869a = i8;
        this.f1870b = z2;
        this.f1871c = z3;
        this.f1872d = i9;
        this.e = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1869a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1870b ? 1 : 0);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1871c ? 1 : 0);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1872d);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e);
        qd.j(parcel, i9);
    }
}
