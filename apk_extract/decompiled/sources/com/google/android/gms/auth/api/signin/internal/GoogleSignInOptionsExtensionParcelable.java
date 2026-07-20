package com.google.android.gms.auth.api.signin.internal;

import a3.a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new a(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f1796c;

    public GoogleSignInOptionsExtensionParcelable(int i8, int i9, Bundle bundle) {
        this.f1794a = i8;
        this.f1795b = i9;
        this.f1796c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1794a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1795b);
        qd.a(parcel, 3, this.f1796c);
        qd.j(parcel, i9);
    }
}
