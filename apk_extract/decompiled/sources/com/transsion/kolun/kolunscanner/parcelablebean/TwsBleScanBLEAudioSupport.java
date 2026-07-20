package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import s8.b;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanBLEAudioSupport implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanBLEAudioSupport> CREATOR = new b(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2918a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f2918a == ((TwsBleScanBLEAudioSupport) obj).f2918a;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f2918a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeByte(this.f2918a ? (byte) 1 : (byte) 0);
    }
}
