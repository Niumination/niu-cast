package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i8 = parcel.readInt();
        String string = parcel.readString();
        int i9 = parcel.readInt();
        Integer numValueOf = i9 != -1 ? Integer.valueOf(i9) : null;
        int i10 = parcel.readInt();
        Integer numValueOf2 = i10 != -1 ? Integer.valueOf(i10) : null;
        String string2 = parcel.readString();
        int i11 = parcel.readInt();
        Integer numValueOf3 = i11 != -1 ? Integer.valueOf(i11) : null;
        int i12 = parcel.readInt();
        return new NearNetworkElement.Wifi(i8, string, numValueOf, numValueOf2, string2, numValueOf3, i12 != -1 ? Integer.valueOf(i12) : null, parcel.readInt(), parcel.readInt(), (NetworkParamsInformation) ((Parcelable) parcel.readParcelable(NetworkParamsInformation.class.getClassLoader(), NetworkParamsInformation.class)), parcel.readInt(), parcel.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NearNetworkElement.Wifi[i8];
    }
}
