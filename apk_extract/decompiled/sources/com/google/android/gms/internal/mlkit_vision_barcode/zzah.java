package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import k3.a;
import k3.qd;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new a(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1987b;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        return this.f1986a == zzahVar.f1986a && l.h(Boolean.valueOf(this.f1987b), Boolean.valueOf(zzahVar.f1987b));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1986a), Boolean.valueOf(this.f1987b)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        int i10 = this.f1986a;
        qd.k(parcel, 2, 4);
        parcel.writeInt(i10);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1987b ? 1 : 0);
        qd.j(parcel, i9);
    }
}
