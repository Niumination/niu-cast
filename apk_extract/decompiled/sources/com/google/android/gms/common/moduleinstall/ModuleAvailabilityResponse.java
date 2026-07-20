package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import uc.a;

/* JADX INFO: loaded from: classes.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new a(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1913b;

    public ModuleAvailabilityResponse(boolean z2, int i8) {
        this.f1912a = z2;
        this.f1913b = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1912a ? 1 : 0);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1913b);
        qd.j(parcel, i9);
    }
}
