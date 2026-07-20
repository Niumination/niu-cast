package com.google.mlkit.vision.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import x5.f;

/* JADX INFO: loaded from: classes2.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2284d;
    public final int e;

    public VisionImageMetadataParcel(int i8, int i9, int i10, int i11, long j8) {
        this.f2281a = i8;
        this.f2282b = i9;
        this.e = i10;
        this.f2283c = j8;
        this.f2284d = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f2281a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f2282b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.e);
        qd.k(parcel, 4, 8);
        parcel.writeLong(this.f2283c);
        qd.k(parcel, 5, 4);
        parcel.writeInt(this.f2284d);
        qd.j(parcel, i9);
    }
}
