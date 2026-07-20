package com.welink.protocol.nfbd;

import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new WearableDeviceInfo.Unknown(parcel.readString(), parcel.readString(), (ScanResult) ((Parcelable) parcel.readParcelable(ScanResult.class.getClassLoader(), ScanResult.class)));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new WearableDeviceInfo.Unknown[i8];
    }
}
