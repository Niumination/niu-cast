package com.google.android.gms.common;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new a(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1981d;

    public zzq(String str, int i8, int i9, boolean z2) {
        int i10;
        int i11 = 1;
        this.f1978a = z2;
        this.f1979b = str;
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i12 = 0;
        while (true) {
            if (i12 >= 6) {
                i10 = 1;
                break;
            }
            i10 = iArr[i12];
            int i13 = i10 - 1;
            if (i10 == 0) {
                throw null;
            }
            if (i13 == i8) {
                break;
            } else {
                i12++;
            }
        }
        this.f1980c = i10 - 1;
        int[] iArr2 = {1, 2, 3};
        for (int i14 = 0; i14 < 3; i14++) {
            int i15 = iArr2[i14];
            int i16 = i15 - 1;
            if (i15 == 0) {
                throw null;
            }
            if (i16 == i9) {
                i11 = i15;
                break;
            }
        }
        this.f1981d = i11 - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1978a ? 1 : 0);
        qd.e(parcel, 2, this.f1979b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1980c);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1981d);
        qd.j(parcel, i9);
    }
}
