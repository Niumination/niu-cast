package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.ble.EarBudsInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new WearableDeviceInfo.TWS(parcel.readString(), parcel.readString(), (ScanResult) ((Parcelable) parcel.readParcelable(ScanResult.class.getClassLoader(), ScanResult.class)), (BluetoothDevice) ((Parcelable) parcel.readParcelable(BluetoothDevice.class.getClassLoader(), BluetoothDevice.class)), parcel.readInt(), Boolean.valueOf(parcel.readBoolean()), (EarBudsInfo) ((Parcelable) parcel.readParcelable(EarBudsInfo.class.getClassLoader(), EarBudsInfo.class)));
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new WearableDeviceInfo.TWS[i8];
    }
}
