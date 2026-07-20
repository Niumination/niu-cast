package com.google.android.gms.common.api;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import k3.qd;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new a(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1817b;

    public Scope(int i8, String str) {
        l.d(str, "scopeUri must not be null or empty");
        this.f1816a = i8;
        this.f1817b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f1817b.equals(((Scope) obj).f1817b);
    }

    public final int hashCode() {
        return this.f1817b.hashCode();
    }

    public final String toString() {
        return this.f1817b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1816a);
        qd.e(parcel, 2, this.f1817b);
        qd.j(parcel, i9);
    }
}
