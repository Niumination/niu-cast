package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.PointerIconCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceData;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.List;
import java.util.Map;
import k3.lb;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Parcelable f9732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9734d;
    public final /* synthetic */ NearDevice e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f9735h;

    public /* synthetic */ e4(com.welink.protocol.nfbd.z zVar, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, int i8, NearDevice nearDevice) {
        this.f9731a = 1;
        this.f9735h = zVar;
        this.f9732b = bluetoothDevice;
        this.f9733c = wifiP2pDevice;
        this.f9734d = i8;
        this.e = nearDevice;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x033b  */
    /* JADX WARN: Code duplicated, block: B:114:0x034f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0351  */
    /* JADX WARN: Code duplicated, block: B:116:0x0356  */
    /* JADX WARN: Code duplicated, block: B:118:0x0359 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x035b  */
    /* JADX WARN: Code duplicated, block: B:120:0x035e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0361  */
    /* JADX WARN: Code duplicated, block: B:123:0x0364 A[PHI: r4
      0x0364: PHI (r4v5 java.lang.String) = (r4v4 java.lang.String), (r4v15 java.lang.String), (r4v17 java.lang.String) binds: [B:113:0x034d, B:117:0x0357, B:121:0x035f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:128:0x036f A[PHI: r4
      0x036f: PHI (r4v12 java.lang.String) = (r4v6 java.lang.String), (r4v8 java.lang.String), (r4v13 java.lang.String) binds: [B:130:0x0374, B:134:0x037c, B:126:0x036c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:132:0x0378  */
    /* JADX WARN: Code duplicated, block: B:133:0x037b  */
    /* JADX WARN: Code duplicated, block: B:135:0x037e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0382  */
    /* JADX WARN: Code duplicated, block: B:138:0x0385  */
    /* JADX WARN: Code duplicated, block: B:140:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:145:0x03c4 A[PHI: r9
      0x03c4: PHI (r9v12 java.lang.String) = (r9v5 java.lang.String), (r9v13 java.lang.String) binds: [B:149:0x03cd, B:143:0x03c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:146:0x03c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:148:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:150:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:155:0x03da A[PHI: r9
      0x03da: PHI (r9v10 java.lang.String) = (r9v8 java.lang.String), (r9v11 java.lang.String) binds: [B:159:0x03e3, B:153:0x03d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:156:0x03dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x03df  */
    /* JADX WARN: Code duplicated, block: B:158:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:160:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:166:0x041c A[PHI: r0
      0x041c: PHI (r0v10 java.lang.String) = (r0v3 java.lang.String), (r0v5 java.lang.String), (r0v11 java.lang.String) binds: [B:170:0x0427, B:174:0x042f, B:164:0x0419] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:167:0x041f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:168:0x0421  */
    /* JADX WARN: Code duplicated, block: B:169:0x0426  */
    /* JADX WARN: Code duplicated, block: B:171:0x0429 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:172:0x042b  */
    /* JADX WARN: Code duplicated, block: B:173:0x042e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0431  */
    /* JADX WARN: Code duplicated, block: B:177:0x0435  */
    /* JADX WARN: Code duplicated, block: B:179:0x043d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x043f  */
    @Override // java.lang.Runnable
    public final void run() {
        NearDeviceDataParcel nearDeviceDataParcel;
        NearDeviceDataParcel nearDeviceDataParcel2;
        BluetoothDevice bluetoothDevice;
        String name;
        String str;
        String address;
        String str2;
        DeviceInfo deviceInfo;
        String name2;
        String str3;
        NearDeviceDataParcel nearDeviceDataParcel3;
        String name3;
        String str4;
        String address2;
        String str5;
        int i8;
        BluetoothDevice device;
        NearDevice nearDeviceC;
        String mes;
        String localAddress;
        NearDevice nearDeviceB;
        NearDevice nearDevice = this.e;
        int i9 = this.f9734d;
        Object obj = this.f9733c;
        Parcelable parcelable = this.f9732b;
        Object obj2 = this.f9735h;
        NearDeviceDataParcel nearDeviceDataParcel4 = null;
        switch (this.f9731a) {
            case 0:
                we.h.c("NearP2pManager", "onP2pOwnerConnectTimeout", null);
                h4 h4Var = (h4) obj2;
                if (h4Var.f9765h instanceof p6) {
                    we.h.j("NearP2pManager", "onP2pOwnerConnectTimeout, mP2pGroupOwnerConnectionState is TransConnectP2pDisconnectedState already, ignore it");
                } else {
                    we.h.j("NearP2pManager", "onP2pOwnerConnectTimeout, because mP2pGroupOwnerConnectionState is not TransConnectP2pDisconnectedState");
                    ka.d dVar = h4Var.f9766i;
                    if (dVar != null) {
                        dVar.q(i9);
                    }
                }
                if (h4Var.f9772o) {
                    i9 = DeviceType.INFRARED_AMPLIFIER;
                }
                h4Var.f9772o = false;
                h4Var.w(true, i9, (BluetoothDevice) parcelable, (WifiP2pDevice) obj, this.e);
                break;
            case 1:
                com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) obj2;
                zVar.getClass();
                WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) obj;
                if (wifiP2pDevice == null) {
                    if (nearDevice != null) {
                        nearDeviceDataParcel2 = new NearDeviceDataParcel(nearDevice, null);
                    } else {
                        nearDeviceDataParcel = null;
                    }
                    TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 23, this.f9734d, 0, 0, nearDeviceDataParcel);
                    bluetoothDevice = (BluetoothDevice) parcelable;
                    if (nearDevice != null) {
                        Map map = com.welink.protocol.nfbd.h.f4132a;
                        byte bE = com.welink.protocol.nfbd.h.e(nearDevice.f3889j);
                        byte bG = com.welink.protocol.nfbd.h.g(nearDevice.h());
                        name3 = nearDevice.f3884b;
                        if (name3 != null) {
                            str4 = name3;
                        } else {
                            if (bluetoothDevice != null) {
                                name3 = bluetoothDevice.getName();
                            } else {
                                name3 = null;
                            }
                            if (name3 != null) {
                                str4 = name3;
                            } else {
                                if (wifiP2pDevice != null) {
                                    name3 = wifiP2pDevice.deviceName;
                                } else {
                                    name3 = null;
                                }
                                if (name3 == null) {
                                    str4 = EnvironmentCompat.MEDIA_UNKNOWN;
                                } else {
                                    str4 = name3;
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
                                str5 = "02:00:00:00:00:00";
                            } else {
                                str5 = address2;
                            }
                        } else {
                            str5 = address2;
                        }
                        if (bluetoothDevice != null) {
                            i8 = 0;
                        } else {
                            i8 = 3;
                        }
                        deviceInfo = new DeviceInfo(bE, bG, str4, str5, (Boolean) null, (EarBudsInfo) null, i8, com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    } else {
                        if (bluetoothDevice != null || (name = bluetoothDevice.getName()) == null) {
                            if (wifiP2pDevice != null) {
                                name = wifiP2pDevice.deviceName;
                            } else {
                                name = null;
                            }
                            if (name == null) {
                                str = EnvironmentCompat.MEDIA_UNKNOWN;
                            } else {
                                str = name;
                            }
                        } else {
                            str = name;
                        }
                        if (bluetoothDevice != null || (address = bluetoothDevice.getAddress()) == null) {
                            if (wifiP2pDevice != null) {
                                address = wifiP2pDevice.deviceAddress;
                            } else {
                                address = null;
                            }
                            if (address == null) {
                                str2 = "02:00:00:00:00:00";
                            } else {
                                str2 = address;
                            }
                        } else {
                            str2 = address;
                        }
                        deviceInfo = new DeviceInfo((byte) 0, (byte) 0, str, str2, (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    }
                    if (nearDevice != null || (name2 = nearDevice.f3884b) == null) {
                        if (bluetoothDevice != null) {
                            name2 = bluetoothDevice.getName();
                        } else {
                            name2 = null;
                        }
                        if (name2 != null) {
                            str3 = name2;
                        } else {
                            if (wifiP2pDevice != null) {
                                name2 = wifiP2pDevice.deviceName;
                            } else {
                                name2 = null;
                            }
                            if (name2 == null) {
                                str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                            } else {
                                str3 = name2;
                            }
                        }
                    } else {
                        str3 = name2;
                    }
                    if (bluetoothDevice != null) {
                        if (nearDevice != null) {
                            nearDeviceDataParcel3 = new NearDeviceDataParcel(nearDevice, null);
                        }
                        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, str3, 23, deviceInfo, tranConnectionController$EventInfo, nearDeviceDataParcel3);
                        we.h.h("TranConnectionManager", "P2p connection failed");
                        zVar.q(tranConnectionController$MessageInfo, nearDevice);
                    } else {
                        nearDeviceDataParcel4 = new NearDeviceDataParcel(bluetoothDevice, nearDevice);
                    }
                    nearDeviceDataParcel3 = nearDeviceDataParcel4;
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo2 = new TranConnectionController$MessageInfo(null, 0, 0, str3, 23, deviceInfo, tranConnectionController$EventInfo, nearDeviceDataParcel3);
                    we.h.h("TranConnectionManager", "P2p connection failed");
                    zVar.q(tranConnectionController$MessageInfo2, nearDevice);
                } else {
                    nearDeviceDataParcel2 = new NearDeviceDataParcel(wifiP2pDevice, nearDevice);
                }
                nearDeviceDataParcel = nearDeviceDataParcel2;
                TranConnectionController$EventInfo tranConnectionController$EventInfo2 = new TranConnectionController$EventInfo((String) null, 23, this.f9734d, 0, 0, nearDeviceDataParcel);
                bluetoothDevice = (BluetoothDevice) parcelable;
                if (nearDevice != null) {
                    Map map2 = com.welink.protocol.nfbd.h.f4132a;
                    byte bE2 = com.welink.protocol.nfbd.h.e(nearDevice.f3889j);
                    byte bG2 = com.welink.protocol.nfbd.h.g(nearDevice.h());
                    name3 = nearDevice.f3884b;
                    if (name3 != null) {
                        str4 = name3;
                    } else {
                        if (bluetoothDevice != null) {
                            name3 = bluetoothDevice.getName();
                        } else {
                            name3 = null;
                        }
                        if (name3 != null) {
                            str4 = name3;
                        } else {
                            if (wifiP2pDevice != null) {
                                name3 = wifiP2pDevice.deviceName;
                            } else {
                                name3 = null;
                            }
                            if (name3 == null) {
                                str4 = EnvironmentCompat.MEDIA_UNKNOWN;
                            } else {
                                str4 = name3;
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
                            str5 = "02:00:00:00:00:00";
                        } else {
                            str5 = address2;
                        }
                    } else {
                        if (wifiP2pDevice != null) {
                            address2 = wifiP2pDevice.deviceAddress;
                        } else {
                            address2 = null;
                        }
                        if (address2 == null) {
                            str5 = "02:00:00:00:00:00";
                        } else {
                            str5 = address2;
                        }
                    }
                    if (bluetoothDevice != null) {
                        i8 = 0;
                    } else {
                        i8 = 3;
                    }
                    deviceInfo = new DeviceInfo(bE2, bG2, str4, str5, (Boolean) null, (EarBudsInfo) null, i8, com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                } else {
                    if (bluetoothDevice != null) {
                        if (wifiP2pDevice != null) {
                            name = wifiP2pDevice.deviceName;
                        } else {
                            name = null;
                        }
                        if (name == null) {
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                        } else {
                            str = name;
                        }
                    } else {
                        if (wifiP2pDevice != null) {
                            name = wifiP2pDevice.deviceName;
                        } else {
                            name = null;
                        }
                        if (name == null) {
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                        } else {
                            str = name;
                        }
                    }
                    if (bluetoothDevice != null) {
                        if (wifiP2pDevice != null) {
                            address = wifiP2pDevice.deviceAddress;
                        } else {
                            address = null;
                        }
                        if (address == null) {
                            str2 = "02:00:00:00:00:00";
                        } else {
                            str2 = address;
                        }
                    } else {
                        if (wifiP2pDevice != null) {
                            address = wifiP2pDevice.deviceAddress;
                        } else {
                            address = null;
                        }
                        if (address == null) {
                            str2 = "02:00:00:00:00:00";
                        } else {
                            str2 = address;
                        }
                    }
                    deviceInfo = new DeviceInfo((byte) 0, (byte) 0, str, str2, (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                }
                if (nearDevice != null) {
                    if (bluetoothDevice != null) {
                        name2 = bluetoothDevice.getName();
                    } else {
                        name2 = null;
                    }
                    if (name2 != null) {
                        str3 = name2;
                    } else {
                        if (wifiP2pDevice != null) {
                            name2 = wifiP2pDevice.deviceName;
                        } else {
                            name2 = null;
                        }
                        if (name2 == null) {
                            str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                        } else {
                            str3 = name2;
                        }
                    }
                } else {
                    if (bluetoothDevice != null) {
                        name2 = bluetoothDevice.getName();
                    } else {
                        name2 = null;
                    }
                    if (name2 != null) {
                        str3 = name2;
                    } else {
                        if (wifiP2pDevice != null) {
                            name2 = wifiP2pDevice.deviceName;
                        } else {
                            name2 = null;
                        }
                        if (name2 == null) {
                            str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                        } else {
                            str3 = name2;
                        }
                    }
                }
                if (bluetoothDevice != null) {
                    if (nearDevice != null) {
                        nearDeviceDataParcel3 = new NearDeviceDataParcel(nearDevice, null);
                    }
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo3 = new TranConnectionController$MessageInfo(null, 0, 0, str3, 23, deviceInfo, tranConnectionController$EventInfo2, nearDeviceDataParcel3);
                    we.h.h("TranConnectionManager", "P2p connection failed");
                    zVar.q(tranConnectionController$MessageInfo3, nearDevice);
                } else {
                    nearDeviceDataParcel4 = new NearDeviceDataParcel(bluetoothDevice, nearDevice);
                }
                nearDeviceDataParcel3 = nearDeviceDataParcel4;
                TranConnectionController$MessageInfo tranConnectionController$MessageInfo4 = new TranConnectionController$MessageInfo(null, 0, 0, str3, 23, deviceInfo, tranConnectionController$EventInfo2, nearDeviceDataParcel3);
                we.h.h("TranConnectionManager", "P2p connection failed");
                zVar.q(tranConnectionController$MessageInfo4, nearDevice);
                break;
            default:
                DeviceData deviceData = (DeviceData) obj2;
                we.c cVar = deviceData != null ? deviceData.f4213a : null;
                ConnectRequest connectRequest = (ConnectRequest) parcelable;
                com.welink.protocol.nfbd.z zVar2 = (com.welink.protocol.nfbd.z) obj;
                switch (cVar == null ? -1 : l5.$EnumSwitchMapping$0[cVar.ordinal()]) {
                    case 1:
                    case 2:
                        if (i9 == 1008) {
                            if (connectRequest != null && (device = deviceData.f4216d) != null) {
                                zVar2.getClass();
                                Intrinsics.checkNotNullParameter(device, "device");
                                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                                TranConnectionController$EventInfo tranConnectionController$EventInfo3 = new TranConnectionController$EventInfo((String) null, 14, 0, 0, 0, new NearDeviceDataParcel(device, nearDevice));
                                byte b9 = (byte) connectRequest.f3876t;
                                byte b10 = (byte) connectRequest.u;
                                String str6 = connectRequest.f3865d;
                                if (str6 == null) {
                                    str6 = connectRequest.f3875s;
                                }
                                DeviceInfo deviceInfo2 = new DeviceInfo(b9, b10, connectRequest.f3877v, str6, (Boolean) null, (EarBudsInfo) null, 0, connectRequest.f3878w, connectRequest.f3879x, connectRequest.f3880y, connectRequest.f3862a, connectRequest.f3881z, connectRequest.A, (String) null, (String) null, (byte) 0, 0, connectRequest.D, connectRequest.e, connectRequest.E, 1048576);
                                if (nearDevice == null) {
                                    Map map3 = com.welink.protocol.nfbd.h.f4132a;
                                    nearDeviceC = com.welink.protocol.nfbd.h.c(deviceInfo2, null, device, 0, 0, connectRequest.f3874r, 64);
                                } else {
                                    nearDeviceC = nearDevice;
                                }
                                String str7 = connectRequest.f3862a;
                                if (str7 != null && com.welink.protocol.nfbd.a.f4027k.c(str7)) {
                                    we.h.h("TranConnectionManager", "Remote version is greater than 1.0");
                                    UInt uInt = connectRequest.B;
                                    if (uInt == null || uInt.getData() != 0) {
                                        we.h.h("TranConnectionManager", "Target public service is " + uInt);
                                        int data = uInt != null ? uInt.getData() : 0;
                                        UInt uInt2 = connectRequest.C;
                                        nearDeviceC.f3888i = ((((long) (uInt2 != null ? uInt2.getData() : 0)) & 4294967295L) << 32) | (4294967295L & ((long) data));
                                    }
                                }
                                nearDeviceC.A(PointerIconCompat.TYPE_HELP);
                                nearDeviceC.f3899w = PointerIconCompat.TYPE_TEXT;
                                nearDeviceC.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                                e newState = new e(nearDeviceC, zVar2.f);
                                Intrinsics.checkNotNullParameter(newState, "newState");
                                nearDeviceC.I = newState;
                                nearDeviceC.p = connectRequest.q;
                                TranConnectionController$MessageInfo tranConnectionController$MessageInfo5 = new TranConnectionController$MessageInfo(null, connectRequest.f3873o, connectRequest.p, connectRequest.f3874r, 14, deviceInfo2, tranConnectionController$EventInfo3, new NearDeviceDataParcel(nearDeviceC, nearDevice));
                                we.h.h("TranConnectionManager", "Receive remote connect request from le");
                                zVar2.q(tranConnectionController$MessageInfo5, nearDeviceC);
                                break;
                            }
                        } else if (i9 != 1010) {
                            mes = o.d.m("Bluetooth Unknown device state: ", "TranConnectionManager", "tag", "mes", i9);
                            if (lb.f6529c < 1) {
                            }
                        }
                        break;
                    case 3:
                        if (i9 == 1031) {
                            if (connectRequest != null) {
                                LanNetworkInfo lanNetworkInfo = deviceData.f4215c;
                                if ((lanNetworkInfo != null ? lanNetworkInfo.f4237a : null) != null && (localAddress = lanNetworkInfo.f4238b) != null) {
                                    zVar2.getClass();
                                    String remoteAddress = lanNetworkInfo.f4237a;
                                    Intrinsics.checkNotNullParameter(remoteAddress, "remoteAddress");
                                    Intrinsics.checkNotNullParameter(localAddress, "localAddress");
                                    Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                                    TranConnectionController$EventInfo tranConnectionController$EventInfo4 = new TranConnectionController$EventInfo(remoteAddress, 14, 0, 0, 0, new NearDeviceDataParcel(connectRequest, nearDevice));
                                    byte b11 = (byte) connectRequest.f3876t;
                                    byte b12 = (byte) connectRequest.u;
                                    String str8 = connectRequest.f3865d;
                                    if (str8 == null) {
                                        str8 = connectRequest.f3875s;
                                    }
                                    DeviceInfo deviceInfo3 = new DeviceInfo(b11, b12, connectRequest.f3877v, str8, (Boolean) null, (EarBudsInfo) null, 10, connectRequest.f3878w, connectRequest.f3879x, connectRequest.f3880y, connectRequest.f3862a, connectRequest.f3881z, connectRequest.A, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2088960);
                                    LanNetworkInfo lanNetworkInfo2 = new LanNetworkInfo(remoteAddress, localAddress, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null);
                                    if (nearDevice == null) {
                                        Map map4 = com.welink.protocol.nfbd.h.f4132a;
                                        nearDeviceB = com.welink.protocol.nfbd.h.b(deviceInfo3, null, null, connectRequest.f3874r, lanNetworkInfo2);
                                    } else {
                                        nearDeviceB = nearDevice;
                                    }
                                    String str9 = connectRequest.f3862a;
                                    if (str9 != null && com.welink.protocol.nfbd.m.f4170t.d(str9)) {
                                        we.h.h("TranConnectionManager", "Remote version is greater than 1.0");
                                        UInt uInt3 = connectRequest.B;
                                        if (uInt3 == null || uInt3.getData() != 0) {
                                            we.h.h("TranConnectionManager", "Target public service is " + uInt3);
                                            int data2 = uInt3 != null ? uInt3.getData() : 0;
                                            UInt uInt4 = connectRequest.C;
                                            nearDeviceB.f3888i = ((((long) (uInt4 != null ? uInt4.getData() : 0)) & 4294967295L) << 32) | (4294967295L & ((long) data2));
                                        }
                                    }
                                    nearDeviceB.A(PointerIconCompat.TYPE_HELP);
                                    e newState2 = new e(nearDeviceB, zVar2.f);
                                    Intrinsics.checkNotNullParameter(newState2, "newState");
                                    nearDeviceB.I = newState2;
                                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo6 = new TranConnectionController$MessageInfo(localAddress, connectRequest.f3873o, connectRequest.p, connectRequest.f3874r, 14, deviceInfo3, tranConnectionController$EventInfo4, new NearDeviceDataParcel(nearDeviceB, nearDevice));
                                    we.h.h("TranConnectionManager", "Receive remote connect request from lan");
                                    zVar2.q(tranConnectionController$MessageInfo6, nearDeviceB);
                                }
                            }
                            Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                            Intrinsics.checkNotNullParameter("Device Lan connected, but remote or local address is null", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("TranConnectionManager", "TransConnect:Device Lan connected, but remote or local address is null", null);
                            }
                            break;
                        } else if (i9 != 1032) {
                            mes = o.d.m("WLAN Unknown device state: ", "TranConnectionManager", "tag", "mes", i9);
                            if (lb.f6529c < 1) {
                            }
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        we.h.j("TranConnectionManager", "Unsupported device type: " + deviceData.f4213a);
                        break;
                    default:
                        mes = "Unknown device type: " + (deviceData != null ? deviceData.f4213a : null);
                        Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c < 1) {
                        }
                        break;
                }
                h0.a.x("TransConnect:", mes, "TranConnectionManager", null);
                break;
        }
    }

    public /* synthetic */ e4(Object obj, int i8, Parcelable parcelable, Object obj2, NearDevice nearDevice, int i9) {
        this.f9731a = i9;
        this.f9735h = obj;
        this.f9734d = i8;
        this.f9732b = parcelable;
        this.f9733c = obj2;
        this.e = nearDevice;
    }
}
