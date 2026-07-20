package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import uc.a;

/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new a(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1916b;

    public ModuleInstallResponse(int i8, boolean z2) {
        this.f1915a = i8;
        this.f1916b = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1915a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1916b ? 1 : 0);
        qd.j(parcel, i9);
    }
}
