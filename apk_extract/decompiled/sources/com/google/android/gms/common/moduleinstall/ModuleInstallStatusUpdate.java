package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import uc.a;

/* JADX INFO: loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new a(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f1919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f1920d;
    public final int e;

    public ModuleInstallStatusUpdate(int i8, int i9, Long l4, Long l8, int i10) {
        this.f1917a = i8;
        this.f1918b = i9;
        this.f1919c = l4;
        this.f1920d = l8;
        this.e = i10;
        if (l4 != null && l8 != null && l8.longValue() != 0 && l8.longValue() == 0) {
            throw new IllegalArgumentException("Given Long is zero");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1917a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1918b);
        Long l4 = this.f1919c;
        if (l4 != null) {
            qd.k(parcel, 3, 8);
            parcel.writeLong(l4.longValue());
        }
        Long l8 = this.f1920d;
        if (l8 != null) {
            qd.k(parcel, 4, 8);
            parcel.writeLong(l8.longValue());
        }
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.e);
        qd.j(parcel, i9);
    }
}
