package se;

import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.nfbd.WirelessDevice;
import java.util.ArrayList;
import java.util.List;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 implements Parcelable.Creator {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x00b2  */
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        WirelessDevice wirelessDevice;
        f gVar;
        WirelessDevice wirelessDevice2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        int i8 = parcel.readInt();
        Integer numValueOf = i8 != -1 ? Integer.valueOf(i8) : null;
        String string4 = parcel.readString();
        int i9 = parcel.readInt();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        int i12 = parcel.readInt();
        long j8 = parcel.readLong();
        UInt uIntM248boximpl = j8 != 0 ? UInt.m248boximpl(UInt.m254constructorimpl((int) j8)) : null;
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        int i13 = parcel.readInt();
        int i14 = parcel.readInt();
        int i15 = parcel.readInt();
        Integer numValueOf2 = i15 != -1 ? Integer.valueOf(i15) : null;
        int i16 = parcel.readInt();
        int i17 = parcel.readInt();
        int i18 = parcel.readInt();
        Boolean boolValueOf = Boolean.valueOf(parcel.readBoolean());
        long j10 = parcel.readLong();
        int iM254constructorimpl = UInt.m254constructorimpl(parcel.readInt());
        int[] iArrCreateIntArray = parcel.createIntArray();
        List<Integer> list = iArrCreateIntArray != null ? ArraysKt.toList(iArrCreateIntArray) : null;
        String string7 = parcel.readString();
        if (string7 != null) {
            switch (string7.hashCode()) {
                case -322116978:
                    if (!string7.equals("Bluetooth")) {
                        wirelessDevice = null;
                    } else {
                        wirelessDevice2 = (WirelessDevice) ((Parcelable) parcel.readParcelable(WirelessDevice.Bluetooth.class.getClassLoader(), WirelessDevice.Bluetooth.class));
                        wirelessDevice = wirelessDevice2;
                    }
                    break;
                case 78510:
                    if (!string7.equals("P2P")) {
                        wirelessDevice = null;
                    } else {
                        wirelessDevice2 = (WirelessDevice) ((Parcelable) parcel.readParcelable(WirelessDevice.P2p.class.getClassLoader(), WirelessDevice.P2p.class));
                        wirelessDevice = wirelessDevice2;
                    }
                    break;
                case 2695989:
                    if (!string7.equals("Wifi")) {
                        wirelessDevice = null;
                    } else {
                        wirelessDevice2 = (WirelessDevice) ((Parcelable) parcel.readParcelable(WirelessDevice.Wifi.class.getClassLoader(), WirelessDevice.Wifi.class));
                        wirelessDevice = wirelessDevice2;
                    }
                    break;
                case 67081517:
                    string7.equals("Empty");
                    wirelessDevice = null;
                    break;
                default:
                    wirelessDevice = null;
                    break;
            }
        } else {
            wirelessDevice = null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        NearDevice device = new NearDevice(string, string2, string3, numValueOf, string4, i9, i10, i11, i12, uIntM248boximpl, string5, string6, i13, i14, numValueOf2, i16, i17, i18, boolValueOf, j10, iM254constructorimpl, list, wirelessDevice, arrayListCreateStringArrayList != null ? CollectionsKt.toList(arrayListCreateStringArrayList) : null, (NearDeviceExtension) ((Parcelable) parcel.readParcelable(NearDeviceExtension.class.getClassLoader(), NearDeviceExtension.class)), parcel.readByte(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        String string8 = parcel.readString();
        if (Intrinsics.areEqual(string8, g.class.getSimpleName())) {
            gVar = new g(0);
        } else if (Intrinsics.areEqual(string8, e.class.getSimpleName())) {
            gVar = new e(device, (Function1) null);
        } else if (Intrinsics.areEqual(string8, d.class.getSimpleName())) {
            Intrinsics.checkNotNullParameter(device, "device");
            gVar = new d();
        } else if (Intrinsics.areEqual(string8, h.class.getSimpleName())) {
            Intrinsics.checkNotNullParameter(device, "device");
            gVar = new h();
        } else {
            gVar = new g(0);
        }
        device.I = gVar;
        device.B = parcel.readInt();
        return device;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        return new NearDevice[i8];
    }
}
