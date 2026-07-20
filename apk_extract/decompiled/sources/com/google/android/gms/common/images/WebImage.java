package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Locale;
import k3.qd;
import s8.b;
import u2.l;

/* JADX INFO: loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new b(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f1837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1839d;

    public WebImage(int i8, Uri uri, int i9, int i10) {
        this.f1836a = i8;
        this.f1837b = uri;
        this.f1838c = i9;
        this.f1839d = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (l.h(this.f1837b, webImage.f1837b) && this.f1838c == webImage.f1838c && this.f1839d == webImage.f1839d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1837b, Integer.valueOf(this.f1838c), Integer.valueOf(this.f1839d)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        return "Image " + this.f1838c + "x" + this.f1839d + " " + this.f1837b.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = qd.i(parcel, 20293);
        qd.k(parcel, 1, 4);
        parcel.writeInt(this.f1836a);
        qd.d(parcel, 2, this.f1837b, i8);
        qd.k(parcel, 3, 4);
        parcel.writeInt(this.f1838c);
        qd.k(parcel, 4, 4);
        parcel.writeInt(this.f1839d);
        qd.j(parcel, i9);
    }
}
