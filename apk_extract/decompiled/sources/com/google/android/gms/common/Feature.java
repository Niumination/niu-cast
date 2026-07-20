package com.google.android.gms.common;

import a3.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import k3.qd;
import u6.c;

/* JADX INFO: loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR = new a(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1806c;

    public Feature(String str, int i8, long j8) {
        this.f1804a = str;
        this.f1805b = i8;
        this.f1806c = j8;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f1804a;
            if (((str != null && str.equals(feature.f1804a)) || (str == null && feature.f1804a == null)) && g() == feature.g()) {
                return true;
            }
        }
        return false;
    }

    public final long g() {
        long j8 = this.f1806c;
        return j8 == -1 ? this.f1805b : j8;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1804a, Long.valueOf(g())});
    }

    public final String toString() {
        c cVar = new c(this);
        cVar.q(this.f1804a, "name");
        cVar.q(Long.valueOf(g()), "version");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.e(parcel, 1, this.f1804a);
        qd.k(parcel, 2, 4);
        parcel.writeInt(this.f1805b);
        long jG = g();
        qd.k(parcel, 3, 8);
        parcel.writeLong(jG);
        qd.j(parcel, i9);
    }

    public Feature(String str, long j8) {
        this.f1804a = str;
        this.f1806c = j8;
        this.f1805b = -1;
    }
}
