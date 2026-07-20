package we;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pWfdInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.welink.protocol.utils.DeviceData;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10722a;

    public /* synthetic */ b(int i8) {
        this.f10722a = i8;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10722a) {
            case 0:
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DeviceData(c.getEntries().get(parcel.readInt()), parcel.readString(), (LanNetworkInfo) ((Parcelable) parcel.readParcelable(LanNetworkInfo.class.getClassLoader(), LanNetworkInfo.class)), (BluetoothDevice) ((Parcelable) parcel.readParcelable(BluetoothDevice.class.getClassLoader(), BluetoothDevice.class)), (WifiP2pDevice) ((Parcelable) parcel.readParcelable(WifiP2pDevice.class.getClassLoader(), WifiP2pDevice.class)), (WifiP2pInfo) ((Parcelable) parcel.readParcelable(WifiP2pInfo.class.getClassLoader(), WifiP2pInfo.class)), (WifiP2pGroup) ((Parcelable) parcel.readParcelable(WifiP2pGroup.class.getClassLoader(), WifiP2pGroup.class)), (WifiP2pWfdInfo) ((Parcelable) parcel.readParcelable(WifiP2pWfdInfo.class.getClassLoader(), WifiP2pWfdInfo.class)));
            default:
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                LanNetworkInfo lanNetworkInfo = new LanNetworkInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), 2048);
                int i8 = parcel.readInt();
                ArrayList arrayList = new ArrayList();
                for (int i9 = 0; i9 < i8; i9++) {
                    String string = parcel.readString();
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new Pair(string, Integer.valueOf(parcel.readInt())));
                }
                lanNetworkInfo.f4247n = arrayList;
                return lanNetworkInfo;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i8) {
        switch (this.f10722a) {
            case 0:
                return new DeviceData[i8];
            default:
                return new LanNetworkInfo[i8];
        }
    }
}
