package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanColorInfo implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanColorInfo> CREATOR = new b(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2929a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f2929a == ((TwsBleScanColorInfo) obj).f2929a;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2929a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.f2929a);
    }
}
