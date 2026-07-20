package com.welink.protocol.nfbd;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new NearNetworkElement.Nfc(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NearNetworkElement.Nfc[i8];
    }
}
