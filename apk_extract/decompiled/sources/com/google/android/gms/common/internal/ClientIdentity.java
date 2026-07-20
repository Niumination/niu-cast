package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import s8.b;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new b(11);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1842b;

    public ClientIdentity(int i8, String str) {
        this.f1841a = i8;
        this.f1842b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f1841a == this.f1841a && l.h(clientIdentity.f1842b, this.f1842b);
    }

    public final int hashCode() {
        return this.f1841a;
    }

    public final String toString() {
        return this.f1841a + ":" + this.f1842b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1841a);
        qd.e(parcel, 2, this.f1842b);
        qd.j(parcel, i9);
    }
}
