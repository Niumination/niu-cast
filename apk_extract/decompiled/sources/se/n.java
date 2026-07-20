package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import androidx.core.os.EnvironmentCompat;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WifiP2pDevice f9879d;
    public final /* synthetic */ boolean e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9880h;

    public /* synthetic */ n(com.welink.protocol.nfbd.z zVar, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice, boolean z2) {
        this.f9876a = 5;
        this.f9877b = zVar;
        this.f9878c = bluetoothDevice;
        this.f9879d = wifiP2pDevice;
        this.f9880h = nearDevice;
        this.e = z2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003d  */
    /* JADX WARN: Code duplicated, block: B:15:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0053  */
    /* JADX WARN: Code duplicated, block: B:17:0x0058  */
    /* JADX WARN: Code duplicated, block: B:19:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:24:0x0066 A[PHI: r7
      0x0066: PHI (r7v6 java.lang.String) = (r7v5 java.lang.String), (r7v15 java.lang.String), (r7v17 java.lang.String) binds: [B:14:0x004f, B:18:0x0059, B:22:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0071 A[PHI: r7
      0x0071: PHI (r7v12 java.lang.String) = (r7v7 java.lang.String), (r7v9 java.lang.String), (r7v13 java.lang.String) binds: [B:31:0x0076, B:35:0x007e, B:27:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0080  */
    /* JADX WARN: Code duplicated, block: B:38:0x0084  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00dd A[PHI: r8
      0x00dd: PHI (r8v9 java.lang.String) = (r8v7 java.lang.String), (r8v10 java.lang.String) binds: [B:61:0x00e6, B:55:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:68:0x011f A[PHI: r0
      0x011f: PHI (r0v20 java.lang.String) = (r0v13 java.lang.String), (r0v15 java.lang.String), (r0v21 java.lang.String) binds: [B:72:0x012a, B:76:0x0132, B:66:0x011c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:69:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0124  */
    /* JADX WARN: Code duplicated, block: B:71:0x0129  */
    /* JADX WARN: Code duplicated, block: B:73:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x012e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0131  */
    /* JADX WARN: Code duplicated, block: B:77:0x0134  */
    /* JADX WARN: Code duplicated, block: B:79:0x0138  */
    /* JADX WARN: Code duplicated, block: B:81:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0142  */
    @Override // java.lang.Runnable
    public final void run() {
        NearDeviceDataParcel nearDeviceDataParcel;
        NearDeviceDataParcel nearDeviceDataParcel2;
        String name;
        String address;
        String str;
        DeviceInfo deviceInfo;
        String name2;
        String str2;
        NearDeviceDataParcel nearDeviceDataParcel3;
        String name3;
        String str3;
        String address2;
        String str4;
        int i8;
        boolean z2 = this.e;
        BluetoothDevice bluetoothDevice = this.f9878c;
        NearDevice nearDevice = this.f9880h;
        WifiP2pDevice wifiP2pDevice = this.f9879d;
        Object obj = this.f9877b;
        switch (this.f9876a) {
            case 0:
                ((e1) ((Pair) obj).getSecond()).h(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
                break;
            case 1:
                ((e1) ((Pair) obj).getSecond()).h(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
                break;
            case 2:
                ((e1) ((Pair) obj).getSecond()).h(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
                break;
            case 3:
                ((e1) ((Pair) obj).getSecond()).h(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
                break;
            case 4:
                ((e1) ((Pair) obj).getSecond()).h(bluetoothDevice, wifiP2pDevice, z2, nearDevice);
                break;
            default:
                com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) obj;
                zVar.getClass();
                NearDeviceDataParcel nearDeviceDataParcel4 = null;
                if (wifiP2pDevice == null) {
                    if (nearDevice != null) {
                        nearDeviceDataParcel2 = new NearDeviceDataParcel(nearDevice, null);
                    } else {
                        nearDeviceDataParcel = null;
                    }
                    TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 22, this.e ? 1 : 0, 0, 0, nearDeviceDataParcel);
                    if (nearDevice != null) {
                        Map map = com.welink.protocol.nfbd.h.f4132a;
                        byte bE = com.welink.protocol.nfbd.h.e(nearDevice.f3889j);
                        byte bG = com.welink.protocol.nfbd.h.g(nearDevice.h());
                        name3 = nearDevice.f3884b;
                        if (name3 != null) {
                            str3 = name3;
                        } else {
                            if (bluetoothDevice != null) {
                                name3 = bluetoothDevice.getName();
                            } else {
                                name3 = null;
                            }
                            if (name3 != null) {
                                str3 = name3;
                            } else {
                                if (wifiP2pDevice != null) {
                                    name3 = wifiP2pDevice.deviceName;
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                                } else {
                                    str3 = name3;
                                }
                            }
                        }
                        if ((bluetoothDevice != null || (address2 = bluetoothDevice.getAddress()) == null) && (address2 = nearDevice.f3883a) == null) {
                            if (wifiP2pDevice != null) {
                                address2 = wifiP2pDevice.deviceAddress;
                            } else {
                                address2 = null;
                            }
                            if (address2 == null) {
                                str4 = "02:00:00:00:00:00";
                            } else {
                                str4 = address2;
                            }
                        } else {
                            str4 = address2;
                        }
                        if (bluetoothDevice != null) {
                            i8 = 0;
                        } else {
                            i8 = 3;
                        }
                        deviceInfo = new DeviceInfo(bE, bG, str3, str4, (Boolean) null, (EarBudsInfo) null, i8, com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    } else {
                        if (wifiP2pDevice != null || (name = wifiP2pDevice.deviceName) == null) {
                            if (bluetoothDevice != null) {
                                name = bluetoothDevice.getName();
                            } else {
                                name = null;
                            }
                            if (name == null) {
                                name = "laptop";
                            }
                        }
                        String str5 = name;
                        if (bluetoothDevice != null || (address = bluetoothDevice.getAddress()) == null) {
                            if (wifiP2pDevice != null) {
                                address = wifiP2pDevice.deviceAddress;
                            } else {
                                address = null;
                            }
                            if (address == null) {
                                str = "02:00:00:00:00:00";
                            } else {
                                str = address;
                            }
                        } else {
                            str = address;
                        }
                        deviceInfo = new DeviceInfo((byte) 0, (byte) 0, str5, str, (Boolean) null, (EarBudsInfo) null, 3, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    }
                    if (nearDevice != null || (name2 = nearDevice.f3884b) == null) {
                        if (bluetoothDevice != null) {
                            name2 = bluetoothDevice.getName();
                        } else {
                            name2 = null;
                        }
                        if (name2 != null) {
                            str2 = name2;
                        } else {
                            if (wifiP2pDevice != null) {
                                name2 = wifiP2pDevice.deviceName;
                            } else {
                                name2 = null;
                            }
                            if (name2 == null) {
                                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                            } else {
                                str2 = name2;
                            }
                        }
                    } else {
                        str2 = name2;
                    }
                    if (bluetoothDevice != null) {
                        if (nearDevice != null) {
                            nearDeviceDataParcel3 = new NearDeviceDataParcel(nearDevice, null);
                        }
                        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, str2, 22, deviceInfo, tranConnectionController$EventInfo, nearDeviceDataParcel3);
                        we.h.h("TranConnectionManager", "P2p client disconnected");
                        zVar.q(tranConnectionController$MessageInfo, nearDevice);
                    } else {
                        nearDeviceDataParcel4 = new NearDeviceDataParcel(bluetoothDevice, nearDevice);
                    }
                    nearDeviceDataParcel3 = nearDeviceDataParcel4;
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo2 = new TranConnectionController$MessageInfo(null, 0, 0, str2, 22, deviceInfo, tranConnectionController$EventInfo, nearDeviceDataParcel3);
                    we.h.h("TranConnectionManager", "P2p client disconnected");
                    zVar.q(tranConnectionController$MessageInfo2, nearDevice);
                } else {
                    nearDeviceDataParcel2 = new NearDeviceDataParcel(wifiP2pDevice, nearDevice);
                }
                nearDeviceDataParcel = nearDeviceDataParcel2;
                TranConnectionController$EventInfo tranConnectionController$EventInfo2 = new TranConnectionController$EventInfo((String) null, 22, this.e ? 1 : 0, 0, 0, nearDeviceDataParcel);
                if (nearDevice != null) {
                    Map map2 = com.welink.protocol.nfbd.h.f4132a;
                    byte bE2 = com.welink.protocol.nfbd.h.e(nearDevice.f3889j);
                    byte bG2 = com.welink.protocol.nfbd.h.g(nearDevice.h());
                    name3 = nearDevice.f3884b;
                    if (name3 != null) {
                        str3 = name3;
                    } else {
                        if (bluetoothDevice != null) {
                            name3 = bluetoothDevice.getName();
                        } else {
                            name3 = null;
                        }
                        if (name3 != null) {
                            str3 = name3;
                        } else {
                            if (wifiP2pDevice != null) {
                                name3 = wifiP2pDevice.deviceName;
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                            } else {
                                str3 = name3;
                            }
                        }
                    }
                    if (bluetoothDevice != null) {
                        if (wifiP2pDevice != null) {
                            address2 = wifiP2pDevice.deviceAddress;
                        } else {
                            address2 = null;
                        }
                        if (address2 == null) {
                            str4 = "02:00:00:00:00:00";
                        } else {
                            str4 = address2;
                        }
                    } else {
                        if (wifiP2pDevice != null) {
                            address2 = wifiP2pDevice.deviceAddress;
                        } else {
                            address2 = null;
                        }
                        if (address2 == null) {
                            str4 = "02:00:00:00:00:00";
                        } else {
                            str4 = address2;
                        }
                    }
                    if (bluetoothDevice != null) {
                        i8 = 0;
                    } else {
                        i8 = 3;
                    }
                    deviceInfo = new DeviceInfo(bE2, bG2, str3, str4, (Boolean) null, (EarBudsInfo) null, i8, com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                } else {
                    if (wifiP2pDevice != null) {
                        if (bluetoothDevice != null) {
                            name = bluetoothDevice.getName();
                        } else {
                            name = null;
                        }
                        if (name == null) {
                            name = "laptop";
                        }
                    } else {
                        if (bluetoothDevice != null) {
                            name = bluetoothDevice.getName();
                        } else {
                            name = null;
                        }
                        if (name == null) {
                            name = "laptop";
                        }
                    }
                    String str6 = name;
                    if (bluetoothDevice != null) {
                        if (wifiP2pDevice != null) {
                            address = wifiP2pDevice.deviceAddress;
                        } else {
                            address = null;
                        }
                        if (address == null) {
                            str = "02:00:00:00:00:00";
                        } else {
                            str = address;
                        }
                    } else {
                        if (wifiP2pDevice != null) {
                            address = wifiP2pDevice.deviceAddress;
                        } else {
                            address = null;
                        }
                        if (address == null) {
                            str = "02:00:00:00:00:00";
                        } else {
                            str = address;
                        }
                    }
                    deviceInfo = new DeviceInfo((byte) 0, (byte) 0, str6, str, (Boolean) null, (EarBudsInfo) null, 3, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                }
                if (nearDevice != null) {
                    if (bluetoothDevice != null) {
                        name2 = bluetoothDevice.getName();
                    } else {
                        name2 = null;
                    }
                    if (name2 != null) {
                        str2 = name2;
                    } else {
                        if (wifiP2pDevice != null) {
                            name2 = wifiP2pDevice.deviceName;
                        } else {
                            name2 = null;
                        }
                        if (name2 == null) {
                            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                        } else {
                            str2 = name2;
                        }
                    }
                } else {
                    if (bluetoothDevice != null) {
                        name2 = bluetoothDevice.getName();
                    } else {
                        name2 = null;
                    }
                    if (name2 != null) {
                        str2 = name2;
                    } else {
                        if (wifiP2pDevice != null) {
                            name2 = wifiP2pDevice.deviceName;
                        } else {
                            name2 = null;
                        }
                        if (name2 == null) {
                            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                        } else {
                            str2 = name2;
                        }
                    }
                }
                if (bluetoothDevice != null) {
                    if (nearDevice != null) {
                        nearDeviceDataParcel3 = new NearDeviceDataParcel(nearDevice, null);
                    }
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo3 = new TranConnectionController$MessageInfo(null, 0, 0, str2, 22, deviceInfo, tranConnectionController$EventInfo2, nearDeviceDataParcel3);
                    we.h.h("TranConnectionManager", "P2p client disconnected");
                    zVar.q(tranConnectionController$MessageInfo3, nearDevice);
                } else {
                    nearDeviceDataParcel4 = new NearDeviceDataParcel(bluetoothDevice, nearDevice);
                }
                nearDeviceDataParcel3 = nearDeviceDataParcel4;
                TranConnectionController$MessageInfo tranConnectionController$MessageInfo4 = new TranConnectionController$MessageInfo(null, 0, 0, str2, 22, deviceInfo, tranConnectionController$EventInfo2, nearDeviceDataParcel3);
                we.h.h("TranConnectionManager", "P2p client disconnected");
                zVar.q(tranConnectionController$MessageInfo4, nearDevice);
                break;
        }
    }

    public /* synthetic */ n(Pair pair, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, boolean z2, NearDevice nearDevice, int i8) {
        this.f9876a = i8;
        this.f9877b = pair;
        this.f9878c = bluetoothDevice;
        this.f9879d = wifiP2pDevice;
        this.e = z2;
        this.f9880h = nearDevice;
    }
}
