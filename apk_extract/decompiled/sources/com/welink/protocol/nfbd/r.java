package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new NearNetworkElement.BluetoothLe(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NearNetworkElement.BluetoothLe[i8];
    }
}
