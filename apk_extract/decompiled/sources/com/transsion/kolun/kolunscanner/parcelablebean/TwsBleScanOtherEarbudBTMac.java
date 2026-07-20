package com.transsion.kolun.kolunscanner.parcelablebean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;
import uc.a;

/* JADX INFO: loaded from: classes2.dex */
public class TwsBleScanOtherEarbudBTMac implements Parcelable {
    public static final Parcelable.Creator<TwsBleScanOtherEarbudBTMac> CREATOR = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2931a;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f2931a, ((TwsBleScanOtherEarbudBTMac) obj).f2931a);
    }

    public final int hashCode() {
        return Objects.hash(this.f2931a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f2931a);
    }
}
