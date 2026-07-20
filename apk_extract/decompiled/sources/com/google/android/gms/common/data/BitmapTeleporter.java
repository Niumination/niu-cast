package com.google.android.gms.common.data;

import a3.a;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new a(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ParcelFileDescriptor f1827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1828c;

    public BitmapTeleporter(int i8, ParcelFileDescriptor parcelFileDescriptor, int i9) {
        this.f1826a = i8;
        this.f1827b = parcelFileDescriptor;
        this.f1828c = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        if (this.f1827b == null) {
            l.e(null);
            throw null;
        }
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1826a);
        qd.d(parcel, 2, this.f1827b, i8 | 1);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1828c);
        qd.j(parcel, i9);
        this.f1827b = null;
    }
}
