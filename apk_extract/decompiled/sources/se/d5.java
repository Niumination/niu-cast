package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d5 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new TranConnectionController$EventInfo(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), 32);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new TranConnectionController$EventInfo[i8];
    }
}
