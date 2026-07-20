package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new b(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f1874b;

    public TelemetryData(int i8, List list) {
        this.f1873a = i8;
        this.f1874b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1873a);
        qd.h(parcel, 2, this.f1874b);
        qd.j(parcel, i9);
    }
}
