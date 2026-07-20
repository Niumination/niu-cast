package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import uc.a;

/* JADX INFO: loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1927c;

    public FavaDiagnosticsEntity(int i8, String str, int i9) {
        this.f1925a = i8;
        this.f1926b = str;
        this.f1927c = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1925a);
        qd.e(parcel, 2, this.f1926b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1927c);
        qd.j(parcel, i9);
    }
}
