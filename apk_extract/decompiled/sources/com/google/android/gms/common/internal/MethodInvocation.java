package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new b(13);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1864d;
    public final long e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f1866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f1867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1868k;

    public MethodInvocation(int i8, int i9, int i10, long j8, long j10, String str, String str2, int i11, int i12) {
        this.f1861a = i8;
        this.f1862b = i9;
        this.f1863c = i10;
        this.f1864d = j8;
        this.e = j10;
        this.f1865h = str;
        this.f1866i = str2;
        this.f1867j = i11;
        this.f1868k = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1861a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1862b);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1863c);
        qd.k(parcel, 4, 8);
        parcel.writeLong(this.f1864d);
        qd.k(parcel, 5, 8);
        parcel.writeLong(this.e);
        qd.e(parcel, 6, this.f1865h);
        qd.e(parcel, 7, this.f1866i);
        qd.k(parcel, 8, 4);
        parcel.writeInt(this.f1867j);
        qd.k(parcel, 9, 4);
        parcel.writeInt(this.f1868k);
        qd.j(parcel, i9);
    }
}
