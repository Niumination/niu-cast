package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new WirelessDevice.Bluetooth(parcel.readString(), parcel.readString(), (ScanResult) ((Parcelable) parcel.readParcelable(ScanResult.class.getClassLoader(), ScanResult.class)), (BluetoothDevice) ((Parcelable) parcel.readParcelable(BluetoothDevice.class.getClassLoader(), BluetoothDevice.class)), parcel.readInt(), parcel.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new WirelessDevice.Bluetooth[i8];
    }
}
