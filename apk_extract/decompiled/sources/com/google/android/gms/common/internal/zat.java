package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;

/* JADX INFO: loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new b(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f1896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GoogleSignInAccount f1898d;

    public zat(int i8, Account account, int i9, GoogleSignInAccount googleSignInAccount) {
        this.f1895a = i8;
        this.f1896b = account;
        this.f1897c = i9;
        this.f1898d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1895a);
        qd.d(parcel, 2, this.f1896b, i8);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1897c);
        qd.d(parcel, 4, this.f1898d, i8);
        qd.j(parcel, i9);
    }
}
