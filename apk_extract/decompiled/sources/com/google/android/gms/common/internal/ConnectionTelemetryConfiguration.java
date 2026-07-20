package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new b(21);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RootTelemetryConfiguration f1843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f1846d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f1847h;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z2, boolean z3, int[] iArr, int i8, int[] iArr2) {
        this.f1843a = rootTelemetryConfiguration;
        this.f1844b = z2;
        this.f1845c = z3;
        this.f1846d = iArr;
        this.e = i8;
        this.f1847h = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.d(parcel, 1, this.f1843a, i8);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1844b ? 1 : 0);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1845c ? 1 : 0);
        int[] iArr = this.f1846d;
        if (iArr != null) {
            int i10 = qd.i(parcel, 4);
            parcel.writeIntArray(iArr);
            qd.j(parcel, i10);
        }
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e);
        int[] iArr2 = this.f1847h;
        if (iArr2 != null) {
            int i11 = qd.i(parcel, 6);
            parcel.writeIntArray(iArr2);
            qd.j(parcel, i11);
        }
        qd.j(parcel, i9);
    }
}
