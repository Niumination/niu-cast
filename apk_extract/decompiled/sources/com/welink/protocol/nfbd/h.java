package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k3.lb;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import m3.r6;
import se.j1;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f4132a = MapsKt.mapOf(TuplesKt.to(0, "Oraimo"), TuplesKt.to(1, "Syinix"), TuplesKt.to(2, "itel"), TuplesKt.to(3, "TECNO"), TuplesKt.to(4, "Infinix"), TuplesKt.to(5, "Boomplay"), TuplesKt.to(6, "TECNO Mobile"), TuplesKt.to(248, "Apple"), TuplesKt.to(249, "Hasee"), TuplesKt.to(Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION), "Asus"), TuplesKt.to(251, "HP"), TuplesKt.to(252, "Dell"), TuplesKt.to(253, "Lenovo"), TuplesKt.to(254, "ThinkPad"));

    public static NearDevice a(BluetoothDevice device) {
        int i8;
        NearDeviceExtension nearDeviceExtension;
        Intrinsics.checkNotNullParameter(device, "device");
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        int type = device.getType();
        if (type == 1) {
            i8 = 8;
        } else if (type != 2) {
            i8 = type != 3 ? 0 : 24;
        } else {
            i8 = 16;
        }
        String name = device.getName();
        if (name == null) {
            name = "";
        }
        String address = device.getAddress();
        if (address == null) {
            address = "0xF2:0x00:0x00:0x00:0x00:0x00";
        }
        WirelessDevice.Bluetooth bluetooth = new WirelessDevice.Bluetooth(name, address, null, device);
        if (arrayList.isEmpty()) {
            nearDeviceExtension = null;
        } else {
            List capability = CollectionsKt.toList(arrayList);
            Intrinsics.checkNotNullParameter(capability, "capability");
            nearDeviceExtension = new NearDeviceExtension(capability, null, null, 0, true, null, null, null);
        }
        j1 j1Var = new j1();
        j1Var.f9818k = name;
        j1Var.f9810a = address;
        j1Var.f9819l = -127;
        j1Var.f9811b = address;
        j1Var.f9812c = 1;
        j1Var.f9817j = "Transsion";
        j1Var.f9813d = 1;
        j1Var.f9816i = 0;
        j1Var.f9823r = UInt.m248boximpl(i8);
        j1Var.f9822o = "0x0001";
        j1Var.c(Integer.valueOf(device.getBondState()));
        j1Var.f9820m = Integer.valueOf(PointerIconCompat.TYPE_CELL);
        j1Var.f9821n = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
        j1Var.f9825t = bluetooth;
        j1Var.p = null;
        j1Var.f9826v = nearDeviceExtension;
        return j1Var.a();
    }

    /* JADX WARN: Code duplicated, block: B:132:0x02c4 A[PHI: r1
      0x02c4: PHI (r1v15 java.lang.String) = (r1v14 java.lang.String), (r1v51 java.lang.String), (r1v53 java.lang.String), (r1v55 java.lang.String) binds: [B:112:0x028f, B:118:0x029f, B:124:0x02af, B:130:0x02bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:147:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:148:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:158:0x0309 A[PHI: r2
      0x0309: PHI (r2v10 java.lang.String) = (r2v8 java.lang.String), (r2v12 java.lang.String) binds: [B:162:0x0313, B:156:0x0306] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:164:0x031a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x031c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x032d  */
    /* JADX WARN: Code duplicated, block: B:172:0x032f  */
    /* JADX WARN: Code duplicated, block: B:176:0x033b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x033d  */
    /* JADX WARN: Code duplicated, block: B:205:0x0386  */
    /* JADX WARN: Code duplicated, block: B:207:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:208:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:209:0x03af  */
    /* JADX WARN: Code duplicated, block: B:210:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:213:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:266:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:268:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:271:0x04bf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:280:0x04d7  */
    /* JADX WARN: Code duplicated, block: B:283:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:285:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:286:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:288:0x04f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:292:0x0505  */
    /* JADX WARN: Code duplicated, block: B:293:0x050c  */
    /* JADX WARN: Code duplicated, block: B:295:0x0527  */
    /* JADX WARN: Code duplicated, block: B:299:0x0536  */
    /* JADX WARN: Code duplicated, block: B:300:0x053b  */
    /* JADX WARN: Code duplicated, block: B:305:0x054b  */
    /* JADX WARN: Code duplicated, block: B:308:0x0552  */
    /* JADX WARN: Code duplicated, block: B:311:0x0557  */
    /* JADX WARN: Code duplicated, block: B:314:0x0578  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a6  */
    /* JADX WARN: Failed to find 'out' block for switch in B:48:0x00cd. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static NearDevice b(DeviceInfo deviceInfo, ScanResult scanResult, BluetoothDevice bluetoothDevice, String str, LanNetworkInfo lanNetworkInfo) {
        BluetoothDevice device;
        int i8;
        Integer num;
        String str2;
        int i9;
        String str3;
        String str4;
        String address;
        BluetoothDevice device2;
        String address2;
        BluetoothDevice device3;
        WirelessDevice bluetooth;
        WirelessDevice unknown;
        EarBudsInfo earBudsInfo;
        WearableDeviceInfo wearableDeviceInfo;
        String str5;
        EarBudsInfo earBudsInfo2;
        int i10;
        String str6;
        NearDeviceExtension nearDeviceExtension;
        String str7;
        int rssi;
        EarBudsInfo earBudsInfo3;
        String strB;
        String address3;
        Boolean boolValueOf;
        boolean zBooleanValue;
        BluetoothDevice device4;
        BluetoothDevice device5;
        ScanRecord scanRecord;
        BluetoothDevice device6;
        boolean z2;
        char c9;
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        String str8 = (String) f4132a.get(Integer.valueOf(deviceInfo.f4221b & UByte.MAX_VALUE));
        if (str8 == null) {
            str8 = "Unknown";
        }
        String str9 = str8;
        int iK = k(deviceInfo.f4225i);
        int i11 = i(deviceInfo.f4226j);
        int iJ = j(Integer.valueOf(deviceInfo.f4227k));
        if (bluetoothDevice == null) {
            device = scanResult != null ? scanResult.getDevice() : null;
        } else {
            device = bluetoothDevice;
        }
        Integer numValueOf = device != null ? Integer.valueOf(device.getType()) : null;
        int iF = f(deviceInfo.f4220a, numValueOf);
        String address4 = device != null ? device.getAddress() : null;
        if (iK == 0 || iK == 1) {
            if (numValueOf != null && numValueOf.intValue() == 1) {
                i8 = 8;
            } else if (numValueOf != null && numValueOf.intValue() == 2) {
                i8 = 16;
            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                i8 = 24;
            } else {
                if (scanResult != null) {
                    scanResult.isLegacy();
                } else if (device != null) {
                    device.getType();
                } else {
                    i8 = 0;
                }
                i8 = 16;
            }
        } else if (iK != 14) {
            i8 = 0;
        } else {
            i8 = 7;
        }
        ArrayList arrayList = new ArrayList();
        String str10 = "NearDeviceCreateUtils";
        String str11 = address4;
        if (i11 == 15) {
            num = numValueOf;
            iF = iF;
            str2 = str9;
            i9 = iJ;
            str3 = null;
            arrayList.add(15);
        } else if (i11 != 251) {
            switch (i11) {
                case 0:
                    i9 = iJ;
                    arrayList.add(0);
                    num = numValueOf;
                    str2 = str9;
                    break;
                case 1:
                    i9 = iJ;
                    arrayList.add(1);
                    num = numValueOf;
                    str2 = str9;
                    break;
                case 2:
                    arrayList.add(2);
                    num = numValueOf;
                    str2 = str9;
                    i9 = iJ;
                    break;
                case 3:
                    arrayList.add(3);
                    num = numValueOf;
                    str2 = str9;
                    i9 = iJ;
                    break;
                case 4:
                    arrayList.add(4);
                    num = numValueOf;
                    str2 = str9;
                    i9 = iJ;
                    break;
                case 5:
                    arrayList.add(5);
                    num = numValueOf;
                    str2 = str9;
                    i9 = iJ;
                    break;
                case 6:
                    arrayList.add(6);
                    num = numValueOf;
                    str2 = str9;
                    i9 = iJ;
                    break;
                default:
                    switch (i11) {
                        case 8:
                            arrayList.add(8);
                            break;
                        case 9:
                            arrayList.add(9);
                            break;
                        case 10:
                            arrayList.add(10);
                            break;
                        case 11:
                            arrayList.add(11);
                            break;
                        case 12:
                            arrayList.add(12);
                            break;
                        case 13:
                            arrayList.add(13);
                            break;
                    }
                    num = numValueOf;
                    str2 = str9;
                    i9 = iJ;
                    break;
            }
            str3 = null;
        } else {
            i9 = iJ;
            byte[] bArr = deviceInfo.f4230n;
            if (bArr != null) {
                str2 = str9;
                if (bArr.length == 0) {
                    c9 = 1;
                    z2 = true;
                } else {
                    z2 = false;
                    c9 = 1;
                }
                if ((!z2) == c9) {
                    num = numValueOf;
                    if (bArr.length >= 2) {
                        int iM254constructorimpl = UInt.m254constructorimpl(UInt.m254constructorimpl(UInt.m254constructorimpl(UByte.m177constructorimpl(bArr[c9]) & UByte.MAX_VALUE) << 8) | UInt.m254constructorimpl(UByte.m177constructorimpl(bArr[0]) & UByte.MAX_VALUE));
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(1) & iM254constructorimpl) != 0) {
                            arrayList.add(1);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(2) & iM254constructorimpl) != 0) {
                            arrayList.add(8);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(4) & iM254constructorimpl) != 0) {
                            arrayList.add(9);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(32) & iM254constructorimpl) != 0) {
                            arrayList.add(10);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(8) & iM254constructorimpl) != 0) {
                            arrayList.add(4);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(16) & iM254constructorimpl) != 0) {
                            arrayList.add(5);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(64) & iM254constructorimpl) != 0) {
                            arrayList.add(11);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(128) & iM254constructorimpl) != 0) {
                            arrayList.add(12);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(256) & iM254constructorimpl) != 0) {
                            arrayList.add(13);
                        }
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(65024) & iM254constructorimpl) != 0) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            iF = iF;
                            String mes = h0.a.o(new Object[]{UInt.m248boximpl(iM254constructorimpl)}, 1, "%04X", "format(...)", "Reserved service flag is not supported, ");
                            Intrinsics.checkNotNullParameter("NearDeviceCreateUtils", "tag");
                            Intrinsics.checkNotNullParameter(mes, "mes");
                            str3 = null;
                            if (lb.f6529c >= 1) {
                                h0.a.x("TransConnect:", mes, "NearDeviceCreateUtils", null);
                            }
                        }
                    }
                } else {
                    num = numValueOf;
                }
            } else {
                num = numValueOf;
                str2 = str9;
            }
            str3 = null;
        }
        String name = deviceInfo.p;
        if (name != null) {
            str4 = name;
        } else {
            name = (scanResult == null || (device6 = scanResult.getDevice()) == null) ? str3 : device6.getName();
            if (name != null) {
                str4 = name;
            } else {
                name = (scanResult == null || (scanRecord = scanResult.getScanRecord()) == null) ? str3 : scanRecord.getDeviceName();
                if (name != null) {
                    str4 = name;
                } else {
                    name = (scanResult == null || (device5 = scanResult.getDevice()) == null) ? str3 : device5.getAddress();
                    if (name == null) {
                        str4 = str;
                    } else {
                        str4 = name;
                    }
                }
            }
        }
        String str12 = deviceInfo.f4223d;
        String str13 = deviceInfo.q;
        if (str12 != null && str13 != null && !Intrinsics.areEqual(str12, str13)) {
            if (((scanResult == null || (device4 = scanResult.getDevice()) == null) ? str3 : device4.getAddress()) != null) {
                BluetoothDevice device7 = scanResult.getDevice();
                if (device7 != null) {
                    address = device7.getAddress();
                } else {
                    address = str3;
                }
            } else if (str12 == null) {
                if (str12 == null) {
                    if (scanResult != null) {
                        if (device != null) {
                            address = device.getAddress();
                        } else {
                            address = str3;
                        }
                    } else if (device != null) {
                        address = device.getAddress();
                    } else {
                        address = str3;
                    }
                } else if (scanResult != null) {
                    if (device != null) {
                        address = device.getAddress();
                    } else {
                        address = str3;
                    }
                } else if (device != null) {
                    address = device.getAddress();
                } else {
                    address = str3;
                }
            } else if (str12 == null) {
                if (scanResult != null) {
                    if (device != null) {
                        address = device.getAddress();
                    } else {
                        address = str3;
                    }
                } else if (device != null) {
                    address = device.getAddress();
                } else {
                    address = str3;
                }
            } else if (scanResult != null) {
                if (device != null) {
                    address = device.getAddress();
                } else {
                    address = str3;
                }
            } else if (device != null) {
                address = device.getAddress();
            } else {
                address = str3;
            }
        } else if (str12 == null && str13 != null && Intrinsics.areEqual(str12, str13)) {
            if (scanResult == null || (device3 = scanResult.getDevice()) == null || (address2 = device3.getAddress()) == null) {
                address2 = device != null ? device.getAddress() : str3;
                if (address2 == null) {
                    address = r6.c(str13);
                } else {
                    address = address2;
                }
            } else {
                address = address2;
            }
        } else if (str12 == null && str13 != null) {
            if ((device != null ? device.getAddress() : str3) != null) {
                address = device.getAddress();
            } else if (scanResult != null) {
                if (device != null) {
                    address = device.getAddress();
                } else {
                    address = str3;
                }
            } else if (device != null) {
                address = device.getAddress();
            } else {
                address = str3;
            }
        } else if (scanResult != null || (device2 = scanResult.getDevice()) == null || (address = device2.getAddress()) == null) {
            if (device != null) {
                address = device.getAddress();
            } else {
                address = str3;
            }
        }
        if (address == null) {
            address = lanNetworkInfo != null ? lanNetworkInfo.f4237a : str3;
        }
        String str14 = i11 == 15 ? str11 : address;
        if (iK != 0 && iK != 1) {
            if (iK != 14) {
                unknown = new WirelessDevice.Unknown(str4, str14, scanResult);
                str10 = "NearDeviceCreateUtils";
            } else {
                bluetooth = new WirelessDevice.Wlan(str4, lanNetworkInfo != null ? lanNetworkInfo.f4237a : null, lanNetworkInfo != null ? lanNetworkInfo.f4238b : null);
            }
            earBudsInfo = deviceInfo.f4224h;
            switch (iF) {
                case 7:
                case 8:
                case 9:
                    Intrinsics.checkNotNull(num);
                    str5 = str14;
                    earBudsInfo2 = earBudsInfo;
                    i10 = 1;
                    wearableDeviceInfo = new WearableDeviceInfo.TWS(str4, str5, scanResult, device, num.intValue(), deviceInfo.e, earBudsInfo2);
                    break;
                case 10:
                    wearableDeviceInfo = new WearableDeviceInfo.WATCH(str4, str14, scanResult, device);
                    str5 = str14;
                    i10 = 1;
                    earBudsInfo2 = earBudsInfo;
                    break;
                case 11:
                    wearableDeviceInfo = new WearableDeviceInfo.BAND(str4, str14, scanResult, device);
                    str5 = str14;
                    i10 = 1;
                    earBudsInfo2 = earBudsInfo;
                    break;
                case 12:
                    wearableDeviceInfo = new WearableDeviceInfo.RING_WATCH(str4, str14, scanResult, device);
                    str5 = str14;
                    i10 = 1;
                    earBudsInfo2 = earBudsInfo;
                    break;
                default:
                    wearableDeviceInfo = new WearableDeviceInfo.Unknown(str4, str14, scanResult);
                    str5 = str14;
                    i10 = 1;
                    earBudsInfo2 = earBudsInfo;
                    break;
            }
            if (arrayList.isEmpty()) {
                str6 = null;
                nearDeviceExtension = str6;
            } else if (iK != 0 || iK == i10) {
                str6 = null;
                int i12 = ((scanResult != null || scanResult.isLegacy()) && scanResult != null && scanResult.getAdvertisingSid() == 255 && scanResult.getSecondaryPhy() == 0) ? 0 : i10;
                if (scanResult == null && scanResult.isConnectable()) {
                    address3 = scanResult.getDevice().getAddress();
                } else {
                    address3 = null;
                }
                if (scanResult != null) {
                    boolValueOf = Boolean.valueOf(scanResult.isConnectable());
                } else {
                    boolValueOf = null;
                }
                if (scanResult == null && device != null) {
                    boolValueOf = Boolean.FALSE;
                }
                List capability = CollectionsKt.toList(arrayList);
                Intrinsics.checkNotNullParameter(capability, "capability");
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                } else {
                    zBooleanValue = false;
                }
                Intrinsics.checkNotNullParameter(wearableDeviceInfo, "wearableDeviceInfo");
                nearDeviceExtension = new NearDeviceExtension(capability, deviceInfo.q, address3, i12, zBooleanValue, null, null, wearableDeviceInfo);
            } else if (iK != 14) {
                String strM = o.d.m("Unsupported wireless type: ", str10, "tag", "mes", iK);
                if (lb.f6529c >= i10) {
                    str6 = null;
                    h0.a.x("TransConnect:", strM, str10, null);
                } else {
                    str6 = null;
                }
                nearDeviceExtension = str6;
            } else {
                str6 = null;
                boolean z3 = (lanNetworkInfo != null ? lanNetworkInfo.f4247n : null) != null ? i10 : 0;
                LanNetworkInfo lanNetworkInfo2 = new LanNetworkInfo(lanNetworkInfo != null ? lanNetworkInfo.f4237a : null, lanNetworkInfo != null ? lanNetworkInfo.f4238b : null, lanNetworkInfo != null ? lanNetworkInfo.f4239c : null, lanNetworkInfo != null ? lanNetworkInfo.f4240d : null, lanNetworkInfo != null ? lanNetworkInfo.e : null, lanNetworkInfo != null ? lanNetworkInfo.f4241h : null, lanNetworkInfo != null ? lanNetworkInfo.f4242i : null, lanNetworkInfo != null ? lanNetworkInfo.f4243j : null, lanNetworkInfo != null ? lanNetworkInfo.f4244k : null, lanNetworkInfo != null ? lanNetworkInfo.f4245l : null, lanNetworkInfo != null ? lanNetworkInfo.f4246m : null, lanNetworkInfo != null ? lanNetworkInfo.f4247n : null);
                List capability2 = CollectionsKt.toList(arrayList);
                Intrinsics.checkNotNullParameter(capability2, "capability");
                Intrinsics.checkNotNullParameter(lanNetworkInfo2, "lanNetworkInfo");
                nearDeviceExtension = new NearDeviceExtension(capability2, null, null, 1, z3, lanNetworkInfo2, null, null);
            }
            j1 j1Var = new j1();
            j1Var.f9818k = str4;
            str7 = str5;
            j1Var.f9810a = str7;
            if (scanResult != null) {
                rssi = scanResult.getRssi();
            } else {
                rssi = 0;
            }
            j1Var.f9819l = Integer.valueOf(rssi);
            if (str12 != 0 || (strB = r6.b(str12)) == null) {
                earBudsInfo3 = earBudsInfo2;
                if (earBudsInfo3 != null) {
                    str6 = earBudsInfo3.p;
                }
                if (str6 != null) {
                    str7 = str6;
                }
            } else {
                str7 = strB;
            }
            j1Var.f9811b = str7;
            j1Var.f9812c = iF;
            j1Var.f9817j = str2;
            j1Var.f9813d = i11;
            j1Var.e = i9;
            j1Var.f9816i = iK;
            j1Var.f9823r = UInt.m248boximpl(i8);
            j1Var.f9822o = deviceInfo.f4222c;
            j1Var.c(Integer.valueOf(device != 0 ? device.getBondState() : 0));
            j1Var.f9825t = unknown;
            j1Var.u = deviceInfo.f4231o;
            j1Var.f9820m = Integer.valueOf(PointerIconCompat.TYPE_CELL);
            j1Var.f9821n = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
            j1Var.p = deviceInfo.f4229m;
            j1Var.f9826v = nearDeviceExtension;
            j1Var.f9827w = deviceInfo.f4232r;
            j1Var.f9828x = deviceInfo.f4233s;
            j1Var.f9829y = deviceInfo.f4234t;
            j1Var.f9830z = deviceInfo.u;
            j1Var.A = deviceInfo.f4235v;
            j1Var.B = deviceInfo.f4236w;
            return j1Var.a();
        }
        bluetooth = new WirelessDevice.Bluetooth(str4, str14, scanResult, device);
        unknown = bluetooth;
        earBudsInfo = deviceInfo.f4224h;
        switch (iF) {
            case 7:
            case 8:
            case 9:
                Intrinsics.checkNotNull(num);
                str5 = str14;
                earBudsInfo2 = earBudsInfo;
                i10 = 1;
                wearableDeviceInfo = new WearableDeviceInfo.TWS(str4, str5, scanResult, device, num.intValue(), deviceInfo.e, earBudsInfo2);
                break;
            case 10:
                wearableDeviceInfo = new WearableDeviceInfo.WATCH(str4, str14, scanResult, device);
                str5 = str14;
                i10 = 1;
                earBudsInfo2 = earBudsInfo;
                break;
            case 11:
                wearableDeviceInfo = new WearableDeviceInfo.BAND(str4, str14, scanResult, device);
                str5 = str14;
                i10 = 1;
                earBudsInfo2 = earBudsInfo;
                break;
            case 12:
                wearableDeviceInfo = new WearableDeviceInfo.RING_WATCH(str4, str14, scanResult, device);
                str5 = str14;
                i10 = 1;
                earBudsInfo2 = earBudsInfo;
                break;
            default:
                wearableDeviceInfo = new WearableDeviceInfo.Unknown(str4, str14, scanResult);
                str5 = str14;
                i10 = 1;
                earBudsInfo2 = earBudsInfo;
                break;
        }
        if (arrayList.isEmpty()) {
            str6 = null;
            nearDeviceExtension = str6;
        } else if (iK != 0) {
            str6 = null;
            if (scanResult != null) {
            }
            if (scanResult == null) {
                address3 = null;
            } else {
                address3 = null;
            }
            if (scanResult != null) {
                boolValueOf = Boolean.valueOf(scanResult.isConnectable());
            } else {
                boolValueOf = null;
            }
            if (scanResult == null) {
                boolValueOf = Boolean.FALSE;
            }
            List capability3 = CollectionsKt.toList(arrayList);
            Intrinsics.checkNotNullParameter(capability3, "capability");
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
            Intrinsics.checkNotNullParameter(wearableDeviceInfo, "wearableDeviceInfo");
            nearDeviceExtension = new NearDeviceExtension(capability3, deviceInfo.q, address3, i12, zBooleanValue, null, null, wearableDeviceInfo);
        } else {
            str6 = null;
            if (scanResult != null) {
            }
            if (scanResult == null) {
                address3 = null;
            } else {
                address3 = null;
            }
            if (scanResult != null) {
                boolValueOf = Boolean.valueOf(scanResult.isConnectable());
            } else {
                boolValueOf = null;
            }
            if (scanResult == null) {
                boolValueOf = Boolean.FALSE;
            }
            List capability4 = CollectionsKt.toList(arrayList);
            Intrinsics.checkNotNullParameter(capability4, "capability");
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
            Intrinsics.checkNotNullParameter(wearableDeviceInfo, "wearableDeviceInfo");
            nearDeviceExtension = new NearDeviceExtension(capability4, deviceInfo.q, address3, i12, zBooleanValue, null, null, wearableDeviceInfo);
        }
        j1 j1Var2 = new j1();
        j1Var2.f9818k = str4;
        str7 = str5;
        j1Var2.f9810a = str7;
        if (scanResult != null) {
            rssi = scanResult.getRssi();
        } else {
            rssi = 0;
        }
        j1Var2.f9819l = Integer.valueOf(rssi);
        if (str12 != 0) {
            earBudsInfo3 = earBudsInfo2;
            if (earBudsInfo3 != null) {
                str6 = earBudsInfo3.p;
            }
            if (str6 != null) {
                str7 = str6;
            }
        } else {
            earBudsInfo3 = earBudsInfo2;
            if (earBudsInfo3 != null) {
                str6 = earBudsInfo3.p;
            }
            if (str6 != null) {
                str7 = str6;
            }
        }
        j1Var2.f9811b = str7;
        j1Var2.f9812c = iF;
        j1Var2.f9817j = str2;
        j1Var2.f9813d = i11;
        j1Var2.e = i9;
        j1Var2.f9816i = iK;
        j1Var2.f9823r = UInt.m248boximpl(i8);
        j1Var2.f9822o = deviceInfo.f4222c;
        j1Var2.c(Integer.valueOf(device != 0 ? device.getBondState() : 0));
        j1Var2.f9825t = unknown;
        j1Var2.u = deviceInfo.f4231o;
        j1Var2.f9820m = Integer.valueOf(PointerIconCompat.TYPE_CELL);
        j1Var2.f9821n = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
        j1Var2.p = deviceInfo.f4229m;
        j1Var2.f9826v = nearDeviceExtension;
        j1Var2.f9827w = deviceInfo.f4232r;
        j1Var2.f9828x = deviceInfo.f4233s;
        j1Var2.f9829y = deviceInfo.f4234t;
        j1Var2.f9830z = deviceInfo.u;
        j1Var2.A = deviceInfo.f4235v;
        j1Var2.B = deviceInfo.f4236w;
        return j1Var2.a();
    }

    public static /* synthetic */ NearDevice c(DeviceInfo deviceInfo, ScanResult scanResult, BluetoothDevice bluetoothDevice, int i8, int i9, String str, int i10) {
        if ((i10 & 32) != 0) {
            str = null;
        }
        return b(deviceInfo, scanResult, bluetoothDevice, str, null);
    }

    public static int d(int i8) {
        if (i8 == 8) {
            return 8;
        }
        if (i8 == 251) {
            return 251;
        }
        switch (i8) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                switch (i8) {
                    case 10:
                        return 10;
                    case 11:
                        return 11;
                    case 12:
                        return 12;
                    case 13:
                        return 13;
                    default:
                        return -1;
                }
        }
    }

    public static byte e(int i8) {
        switch (i8) {
            case 1:
                return (byte) 13;
            case 2:
                return (byte) 18;
            case 3:
                return (byte) 10;
            case 4:
                return (byte) 11;
            case 5:
                return (byte) 21;
            case 6:
                return (byte) 15;
            case 7:
            case 8:
            case 9:
                return (byte) 2;
            case 10:
                return (byte) 0;
            case 11:
                return (byte) 1;
            case 12:
                return (byte) 20;
            case 13:
            case 14:
            default:
                return (byte) -1;
            case 15:
                return (byte) 22;
            case 16:
                return (byte) 23;
            case 17:
                return (byte) 24;
        }
    }

    public static int f(byte b9, Integer num) {
        if (b9 == 13) {
            return 1;
        }
        if (b9 == 21) {
            return 5;
        }
        if (b9 == 15) {
            return 6;
        }
        if (b9 == 18) {
            return 2;
        }
        if (b9 == 10) {
            return 3;
        }
        if (b9 == 11) {
            return 4;
        }
        if (b9 == 2) {
            if (num == null || num.intValue() != 2) {
                if (num != null && num.intValue() == 1) {
                    return 7;
                }
                if (num != null && num.intValue() == 3) {
                    return 8;
                }
            }
            return 9;
        }
        if (b9 == 0) {
            return 10;
        }
        if (b9 == 1) {
            return 11;
        }
        if (b9 == 20) {
            return 12;
        }
        if (b9 == 22) {
            return 15;
        }
        if (b9 == 23) {
            return 16;
        }
        return b9 == 24 ? 17 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0057 A[RETURN, SYNTHETIC] */
    public static byte g(String deviceBrand) {
        Intrinsics.checkNotNullParameter(deviceBrand, "deviceBrand");
        switch (deviceBrand) {
            case "Oraimo":
                return (byte) 0;
            case "Syinix":
                return (byte) 1;
            case "Infinix":
                return (byte) 4;
            case "TECNO Mobile":
                return (byte) 6;
            case "itel":
                return (byte) 2;
            case "TECNO":
                return (byte) 3;
            case "Boomplay":
                return (byte) 5;
            default:
                return (byte) -1;
        }
    }

    public static int h(int i8) {
        if (i8 == 14) {
            return 10;
        }
        switch (i8) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            default:
                return -1;
        }
    }

    public static int i(int i8) {
        if (i8 == 8) {
            return 8;
        }
        if (i8 == 15) {
            return 15;
        }
        if (i8 == 251) {
            return 251;
        }
        switch (i8) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                switch (i8) {
                    case 10:
                        return 10;
                    case 11:
                        return 11;
                    case 12:
                        return 12;
                    case 13:
                        return 13;
                    default:
                        return -1;
                }
        }
    }

    public static int j(Integer num) {
        if (num.intValue() == 0) {
            return 0;
        }
        int i8 = 1;
        if (num.intValue() != 1) {
            i8 = 2;
            if (num.intValue() != 2) {
                i8 = 4;
                if (num.intValue() != 4) {
                    i8 = 8;
                    if (num.intValue() != 8) {
                        i8 = 12;
                        if (num.intValue() != 12) {
                            return num.intValue() == 3 ? 3 : 0;
                        }
                    }
                }
            }
        }
        return i8;
    }

    public static int k(int i8) {
        switch (i8) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 14;
            default:
                return -1;
        }
    }
}
