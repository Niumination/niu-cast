package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.util.Log;
import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearLaptopManager$TransferConnectInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.UUID;
import k3.jd;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a4 extends we.g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f9642j = new k(y3.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.welink.protocol.nfbd.b0 f9643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.welink.protocol.nfbd.a0 f9644d;
    public final o4 e;
    public final o4 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f9645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f9646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f9647i;

    public a4(Context context, h4 h4Var) {
        super(false, "TranFileControllerHandlerThread");
        this.f9645g = new HashMap();
        this.f9646h = new LinkedHashSet();
        w listener = new w(this, 2);
        com.welink.protocol.nfbd.b0 b0Var = new com.welink.protocol.nfbd.b0(context, h4Var, this);
        this.f9643c = b0Var;
        Intrinsics.checkNotNullParameter(listener, "listener");
        b0Var.p.add(listener);
        com.welink.protocol.nfbd.a0 a0Var = new com.welink.protocol.nfbd.a0(context, h4Var);
        this.f9644d = a0Var;
        Intrinsics.checkNotNullParameter(listener, "listener");
        a0Var.A.add(listener);
        o4 o4Var = new o4(context, h4Var, "p2pClient", 320098822);
        this.e = o4Var;
        Intrinsics.checkNotNullParameter(listener, "listener");
        o4Var.f9916i.add(listener);
        o4 o4Var2 = new o4(context, h4Var, "p2pOwner", 320098821);
        this.f = o4Var2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        o4Var2.f9916i.add(listener);
    }

    public final void A(g5 msgInfo) {
        BluetoothDevice bluetoothDeviceQ;
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        DeviceInfo deviceInfo = (DeviceInfo) this.f9645g.get(msgInfo.f9746a);
        if (deviceInfo == null) {
            Intrinsics.checkNotNullParameter("sendFile: Device not found", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "sendFile: Device not found", null);
                return;
            }
            return;
        }
        com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
        if (b0Var != null) {
            Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
            Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
            we.h.b("TranFileSendController", "sendFile : " + msgInfo.f9746a + " transfer state : " + b0Var.f4054d);
            NearDevice nearDevice = msgInfo.f9750g;
            if (nearDevice == null || (bluetoothDeviceQ = com.welink.protocol.nfbd.b0.q(nearDevice)) == null) {
                bluetoothDeviceQ = (BluetoothDevice) b0Var.e.get(msgInfo.f9746a);
            }
            if (bluetoothDeviceQ == null) {
                we.h.c("TranFileSendController", "Not Found valid device", null);
                b0Var.f(b0Var.H);
                return;
            }
            o.d.z("select device : ", bluetoothDeviceQ.getAddress(), "TranFileSendController");
            b0Var.f4058j = deviceInfo;
            b0Var.f = msgInfo;
            b0Var.f4059k = msgInfo.f9746a;
            b0Var.f(new o.e(13, b0Var, bluetoothDeviceQ));
        }
    }

    public final void B() {
        we.h.g("unRegisterNotify");
    }

    public final void j() {
        o4 o4Var = this.f;
        if (o4Var != null) {
            o4Var.f(new j4(o4Var, 4));
        }
    }

    public final void k(int i8) {
        if (i8 == 0) {
            we.h.g("Unregister p2p listener from QR mode");
            return;
        }
        if (i8 == 1) {
            we.h.g("Unregister p2p listener from ble active mode");
            com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
            if (b0Var != null) {
                b0Var.f(new o5(b0Var, 3));
                return;
            }
            return;
        }
        if (i8 == 2) {
            we.h.g("Unregister p2p listener from ble passive mode");
            com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
            if (a0Var != null) {
                a0Var.f(new m5(a0Var, 3));
                return;
            }
            return;
        }
        if (i8 == 3) {
            we.h.g("Unregister p2p listener from reset mode");
            return;
        }
        String strH = o.d.h(i8, "Unregister p2p listener from unknown Type: ", "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", strH, null);
        }
    }

    public final void l() {
        o4 o4Var = this.e;
        if (o4Var != null) {
            o4Var.n();
        }
        o4 o4Var2 = this.f;
        if (o4Var2 != null) {
            o4Var2.n();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    public final void m(NearDevice nearDevice) {
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            if (nearDevice == null) {
                Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                Intrinsics.checkNotNullParameter("flushDevice: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("TranFileReceiveController", "TransConnect:flushDevice: device is null", null);
                }
            } else {
                int i8 = nearDevice.f3890k;
                if (i8 != 0) {
                    switch (i8) {
                        case 10:
                        case 11:
                            we.h.h("TranFileReceiveController", "flushDevice: P2P device, ignore");
                            break;
                        case 12:
                            we.h.h("TranFileReceiveController", "flushDevice: BLE device, flush");
                            a0Var.f(new o.e(10, a0Var, nearDevice));
                            break;
                        default:
                            we.h.h("TranFileReceiveController", "flushDevice: unknown device, ignore");
                            break;
                    }
                } else {
                    we.h.h("TranFileReceiveController", "flushDevice: BLE device, flush");
                    a0Var.f(new o.e(10, a0Var, nearDevice));
                }
            }
        }
        com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
        if (b0Var != null) {
            if (nearDevice == null) {
                we.h.j("TranFileSendController", "flushDevice: device is null");
            } else {
                int i9 = nearDevice.f3890k;
                if (i9 != 0) {
                    switch (i9) {
                        case 10:
                        case 11:
                            we.h.h("TranFileSendController", "flushDevice: P2P device, ignore");
                            break;
                        case 12:
                            we.h.h("TranFileSendController", "flushDevice: BLE device, flush");
                            b0Var.f(new o.e(12, b0Var, nearDevice));
                            break;
                        default:
                            we.h.h("TranFileSendController", "flushDevice: unknown device, ignore");
                            break;
                    }
                } else {
                    we.h.h("TranFileSendController", "flushDevice: BLE device, flush");
                    b0Var.f(new o.e(12, b0Var, nearDevice));
                }
            }
        }
        Integer numValueOf = nearDevice != null ? Integer.valueOf(nearDevice.p) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            o4 o4Var = this.f;
            if (o4Var != null) {
                o4Var.o(nearDevice);
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            o4 o4Var2 = this.e;
            if (o4Var2 != null) {
                o4Var2.o(nearDevice);
                return;
            }
            return;
        }
        String mes = "Unknown client mode: " + (nearDevice != null ? Integer.valueOf(nearDevice.p) : null);
        Intrinsics.checkNotNullParameter("NearLaptopManager", "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", mes, "NearLaptopManager", null);
        }
    }

    public final boolean n() {
        Integer numT = t();
        if (numT == null || numT.intValue() != 0) {
            String mes = "ERROR: Notify connect passive running already, Device state: " + t();
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", mes, null);
            }
            return true;
        }
        Integer numU = u();
        if (numU != null && numU.intValue() == 0) {
            return false;
        }
        String mes2 = "ERROR: Notify connect active running already, Device state: " + u();
        Intrinsics.checkNotNullParameter(mes2, "mes");
        if (lb.f6529c >= 1) {
            Log.e("welinkBLE", mes2, null);
        }
        return true;
    }

    public final void o() {
        Integer numValueOf;
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            we.h.h("TranFileReceiveController", "onActionAccept");
            BluetoothGatt bluetoothGatt = a0Var.f4039j;
            if (bluetoothGatt == null) {
                return;
            }
            a0Var.f4045r = true;
            UUID uuid = z6.f10088d;
            Intrinsics.checkNotNullExpressionValue(uuid, "<get-FILE_TRANSFER_RECEIVE_UUID>(...)");
            BluetoothGattCharacteristic bluetoothGattCharacteristicB = jd.b(bluetoothGatt, uuid);
            if (bluetoothGattCharacteristicB != null) {
                byte[] bArr = {0};
                a0Var.f4050x = bArr;
                bluetoothGattCharacteristicB.setValue(bArr);
                BluetoothGatt bluetoothGatt2 = a0Var.f4039j;
                if (bluetoothGatt2 != null) {
                    byte[] bArr2 = a0Var.f4050x;
                    Intrinsics.checkNotNull(bArr2);
                    numValueOf = Integer.valueOf(bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristicB, bArr2, 2));
                } else {
                    numValueOf = null;
                }
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    a0Var.g(3000L, a0Var.N);
                } else {
                    we.h.h("TranFileReceiveController", "writeCharacteristic fail");
                    a0Var.n();
                }
            }
        }
    }

    public final void p() {
        Integer numValueOf;
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            we.h.h("TranFileReceiveController", "onActionDecline");
            BluetoothGatt bluetoothGatt = a0Var.f4039j;
            if (bluetoothGatt == null) {
                return;
            }
            UUID uuid = z6.f10088d;
            Intrinsics.checkNotNullExpressionValue(uuid, "<get-FILE_TRANSFER_RECEIVE_UUID>(...)");
            BluetoothGattCharacteristic bluetoothGattCharacteristicB = jd.b(bluetoothGatt, uuid);
            if (bluetoothGattCharacteristicB != null) {
                a0Var.f4045r = false;
                byte[] bArr = {-1};
                a0Var.f4050x = bArr;
                bluetoothGattCharacteristicB.setValue(bArr);
                BluetoothGatt bluetoothGatt2 = a0Var.f4039j;
                if (bluetoothGatt2 != null) {
                    byte[] bArr2 = a0Var.f4050x;
                    Intrinsics.checkNotNull(bArr2);
                    numValueOf = Integer.valueOf(bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristicB, bArr2, 2));
                } else {
                    numValueOf = null;
                }
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    a0Var.g(3000L, a0Var.N);
                } else {
                    we.h.h("TranFileReceiveController", "writeCharacteristic fail");
                    a0Var.n();
                }
            }
        }
    }

    public final boolean q(String str) {
        return ((DeviceInfo) this.f9645g.get(str)) != null;
    }

    public final void r(NearDevice device, boolean z2, int i8, int i9) {
        Intrinsics.checkNotNullParameter(device, "device");
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            BluetoothDevice bluetoothDeviceQ = com.welink.protocol.nfbd.a0.q(device);
            if (bluetoothDeviceQ == null || !a0Var.r(device)) {
                Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                Intrinsics.checkNotNullParameter("onExchangeRsp: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("TranFileReceiveController", "TransConnect:onExchangeRsp: device is null", null);
                    return;
                }
                return;
            }
            we.h.h("TranFileReceiveController", "onExchangeRsp: device: " + bluetoothDeviceQ + ", busy: " + z2 + ", requestId: " + i8 + ", offset: " + i9);
        }
    }

    public final Integer s() {
        Integer numP;
        o4 o4Var = this.e;
        if (o4Var != null && (numP = o4Var.p()) != null) {
            return numP;
        }
        o4 o4Var2 = this.f;
        if (o4Var2 != null) {
            return o4Var2.p();
        }
        return null;
    }

    public final Integer t() {
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            return Integer.valueOf(a0Var.f4035d);
        }
        return null;
    }

    public final Integer u() {
        com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
        if (b0Var != null) {
            return Integer.valueOf(b0Var.f4054d);
        }
        return null;
    }

    public final void v(NearDevice device, ConnectRequest connectRequest) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(device, "device");
        Integer numU = u();
        if (numU == null || numU.intValue() != 0) {
            we.h.h("NearLaptopManager", "P2p Connect Accept(Active)");
            com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
            if (b0Var != null) {
                Intrinsics.checkNotNullParameter(device, "device");
                if (com.welink.protocol.nfbd.b0.q(device) == null) {
                    Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                    Intrinsics.checkNotNullParameter("onP2pInvitationAccept: device is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("TranFileSendController", "TransConnect:onP2pInvitationAccept: device is null", null);
                        return;
                    }
                    return;
                }
                b0Var.u = device;
                if (connectRequest == null || (str = connectRequest.f3868j) == null) {
                    str = b0Var.f4070y;
                }
                String str7 = str;
                if (connectRequest == null || (str2 = connectRequest.f3869k) == null) {
                    str2 = b0Var.f4071z;
                }
                String str8 = str2;
                int i8 = connectRequest != null ? connectRequest.f3871m : b0Var.B;
                if (connectRequest == null || (str3 = connectRequest.f3870l) == null) {
                    str3 = b0Var.A;
                }
                i2 i2Var = new i2(i8, device, str7, str8, str3);
                b0Var.f4067v = i2Var;
                h4 h4Var = b0Var.f4064r;
                if (h4Var != null) {
                    h4Var.u(new we.i(b0Var), b0Var.G, 320098823);
                }
                int i9 = b0Var.f4066t + 1;
                b0Var.f4066t = i9;
                h0.a.u(i9, "registerNearP2pManagerListener: count: ", "TranFileSendController");
                if (h4Var == null || !h4Var.q()) {
                    if (h4Var != null) {
                        h4Var.m(i2Var, 1);
                        return;
                    }
                    return;
                } else {
                    if (h4Var.r()) {
                        we.h.h("TranFileSendController", "P2p GC connect over group client recover directly");
                        h4Var.n(i2Var, 1);
                    } else {
                        h4Var.n(i2Var, 1);
                    }
                    b0Var.f4065s = true;
                    return;
                }
            }
            return;
        }
        Integer numT = t();
        if (numT != null && numT.intValue() == 0) {
            String str9 = connectRequest != null ? connectRequest.f3868j : null;
            String str10 = connectRequest != null ? connectRequest.f3869k : null;
            String str11 = connectRequest != null ? connectRequest.f3870l : null;
            int i10 = connectRequest != null ? connectRequest.f3871m : 0;
            Intrinsics.checkNotNullParameter(device, "device");
            int i11 = device.p;
            long j8 = WorkRequest.MIN_BACKOFF_MILLIS;
            if (i11 != 2) {
                o4 o4Var = this.e;
                if (o4Var != null) {
                    Intrinsics.checkNotNullParameter(device, "device");
                    o4Var.f(new k4(o4Var, device, str9, str10, i10, str11, j8));
                    return;
                }
                return;
            }
            o4 o4Var2 = this.f;
            if (o4Var2 != null) {
                Intrinsics.checkNotNullParameter(device, "device");
                o4Var2.f(new k4(o4Var2, device, str9, str10, i10, str11, j8));
                return;
            }
            return;
        }
        we.h.h("NearLaptopManager", "P2p Connect Accept(Passive)");
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (com.welink.protocol.nfbd.a0.q(device) == null) {
                Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                Intrinsics.checkNotNullParameter("onP2pInvitationAccept: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("TranFileReceiveController", "TransConnect:onP2pInvitationAccept: device is null", null);
                    return;
                }
                return;
            }
            a0Var.F = device;
            if (connectRequest == null || (str4 = connectRequest.f3868j) == null) {
                str4 = a0Var.f4041l;
            }
            String str12 = str4;
            if (connectRequest == null || (str5 = connectRequest.f3869k) == null) {
                str5 = a0Var.f4042m;
            }
            String str13 = str5;
            int i12 = connectRequest != null ? connectRequest.f3871m : a0Var.f4044o;
            if (connectRequest == null || (str6 = connectRequest.f3870l) == null) {
                str6 = a0Var.f4043n;
            }
            i2 i2Var2 = new i2(i12, device, str12, str13, str6);
            a0Var.G = i2Var2;
            h4 h4Var2 = a0Var.C;
            if (h4Var2 != null) {
                h4Var2.u(new we.i(a0Var), a0Var.I, 320098824);
            }
            int i13 = a0Var.E + 1;
            a0Var.E = i13;
            h0.a.u(i13, "registerNearP2pManagerListener: count: ", "TranFileReceiveController");
            if (h4Var2 == null || !h4Var2.q()) {
                if (h4Var2 != null) {
                    h4Var2.m(i2Var2, 1);
                }
            } else {
                if (h4Var2.r()) {
                    we.h.h("TranFileReceiveController", "P2p GC connect over group client recover directly");
                    h4Var2.n(i2Var2, 1);
                } else {
                    h4Var2.n(i2Var2, 1);
                }
                a0Var.D = true;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0163  */
    public final void w(Integer num, String str, String str2, DeviceInfo devinfo, ScanResult result) {
        DeviceInfo deviceInfo;
        BluetoothDevice device;
        String name;
        String name2;
        Intrinsics.checkNotNullParameter(devinfo, "devinfo");
        Intrinsics.checkNotNullParameter(result, "result");
        HashMap map = this.f9645g;
        if (num.intValue() == 128) {
            ScanRecord scanRecord = result.getScanRecord();
            Intrinsics.checkNotNull(scanRecord);
            String deviceName = scanRecord.getDeviceName();
            map.put(str2, devinfo);
            com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
            if (b0Var != null) {
                BluetoothDevice device2 = result.getDevice();
                if (str2 == null || device2 == null || (name2 = device2.getName()) == null || name2.length() == 0) {
                    we.h.b("TranFileSendController", "Ble device mac or device info null or device name null");
                    return;
                }
                String address = device2.getAddress();
                StringBuilder sbP = h0.a.p("Found device, Name: ", deviceName, ", address: ", str2, ", ble mac: ");
                sbP.append(address);
                we.h.b("TranFileSendController", sbP.toString());
                b0Var.f(new a0.g(b0Var, 22, str2, device2));
                return;
            }
            return;
        }
        if (num.intValue() == 7) {
            NearLaptopManager$TransferConnectInfo info = new NearLaptopManager$TransferConnectInfo();
            info.f3912a = true;
            info.f3913b = 0;
            Intrinsics.checkNotNull(str2);
            info.f3914c = jd.a(str2);
            Intrinsics.checkNotNull(str);
            info.f3915d = jd.a(str);
            DeviceInfo deviceInfo2 = (DeviceInfo) map.get(str2);
            if (deviceInfo2 == null) {
                Intrinsics.checkNotNullParameter("Get Notify Broadcast without scan or invalid device name", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", "Get Notify Broadcast without scan or invalid device name", null);
                }
                map.put(str2, devinfo);
                deviceInfo = devinfo;
            } else {
                if (result == null || result.getDevice() == null) {
                    Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
                    Intrinsics.checkNotNullParameter("Invalid device name, deviceInfo or result is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearConnectionService", "TransConnect:Invalid device name, deviceInfo or result is null", null);
                    }
                } else {
                    BluetoothDevice device3 = result.getDevice();
                    if ((device3 != null ? device3.getName() : null) == null || !((device = result.getDevice()) == null || (name = device.getName()) == null || name.length() != 0)) {
                        Intrinsics.checkNotNullParameter("NearLaptopManager", "tag");
                        Intrinsics.checkNotNullParameter("Invalid device name, device name is null or empty", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearLaptopManager", "TransConnect:Invalid device name, device name is null or empty", null);
                        }
                    } else {
                        String str3 = deviceInfo2.p;
                        if (str3 != null) {
                            BluetoothDevice device4 = result.getDevice();
                            if (!Intrinsics.areEqual(str3, device4 != null ? device4.getAddress() : null)) {
                                BluetoothDevice device5 = result.getDevice();
                                if (!Intrinsics.areEqual(str3, device5 != null ? device5.getName() : null)) {
                                }
                            }
                            Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
                            Intrinsics.checkNotNullParameter("Invalid device name, device name is same as device address or old device name", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearConnectionService", "TransConnect:Invalid device name, device name is same as device address or old device name", null);
                            }
                        }
                        BluetoothDevice device6 = result.getDevice();
                        String name3 = device6 != null ? device6.getName() : null;
                        BluetoothDevice device7 = result.getDevice();
                        we.h.b("NearConnectionService", "Valid device name, device name is " + name3 + ", address is " + (device7 != null ? device7.getAddress() : null));
                        deviceInfo = deviceInfo2;
                    }
                }
                Intrinsics.checkNotNullParameter("Get Notify Broadcast without scan or invalid device name", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", "Get Notify Broadcast without scan or invalid device name", null);
                }
                map.put(str2, devinfo);
                deviceInfo = devinfo;
            }
            com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
            if (a0Var != null) {
                Intrinsics.checkNotNullParameter(info, "info");
                h0.a.u(a0Var.f4035d, "onDeviceConnectRequest Start connect transfer state : ", "TranFileReceiveController");
                if (result == null || deviceInfo == null) {
                    we.h.c("TranFileReceiveController", "Invalid connect request params, ignore", null);
                    return;
                }
                a0Var.f4036g.put(result.getDevice().getAddress(), result);
                a0Var.f4038i = deviceInfo;
                a0Var.f4047t = info;
                a0Var.f4040k = 0;
                a0Var.f(new d6.q(9, a0Var, result, info, deviceInfo));
            }
        }
    }

    public final void x() {
        we.h.g("onTransferCancel");
        com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
        if (b0Var != null) {
            b0Var.f(new o5(b0Var, 11));
        }
    }

    public final void y() {
        we.h.g("onTransferComplete");
        com.welink.protocol.nfbd.b0 b0Var = this.f9643c;
        if (b0Var == null || b0Var.f4054d != 0) {
            com.welink.protocol.nfbd.b0 b0Var2 = this.f9643c;
            if (b0Var2 != null) {
                b0Var2.f(new o5(b0Var2, 1));
                return;
            }
            return;
        }
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null && a0Var.f4035d == 0) {
            we.h.d("onTransferComplete but no device is connected", null);
        } else if (a0Var != null) {
            a0Var.f(new m5(a0Var, 9));
        }
    }

    public final void z(g5 msgInfo) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        DeviceInfo deviceInfo = (DeviceInfo) this.f9645g.get(msgInfo.f9746a);
        if (deviceInfo == null) {
            Intrinsics.checkNotNullParameter("receiveFile: Device not found", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "receiveFile: Device not found", null);
                return;
            }
            return;
        }
        com.welink.protocol.nfbd.a0 a0Var = this.f9644d;
        if (a0Var != null) {
            Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
            Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
            h0.a.u(a0Var.f4035d, "onReceiveFile Start connect transfer state : ", "TranFileReceiveController");
            NearDevice nearDevice = msgInfo.f9750g;
            BluetoothDevice bluetoothDeviceQ = nearDevice != null ? com.welink.protocol.nfbd.a0.q(nearDevice) : null;
            BluetoothDevice bluetoothDevice = a0Var.f;
            if (bluetoothDevice != null && Intrinsics.areEqual(bluetoothDevice, bluetoothDeviceQ)) {
                we.h.j("TranFileReceiveController", "same device return");
                return;
            }
            int i8 = a0Var.f4035d;
            m5 m5Var = a0Var.J;
            if (i8 != 0) {
                NearLaptopManager$TransferConnectInfo nearLaptopManager$TransferConnectInfo = a0Var.f4047t;
                if (nearLaptopManager$TransferConnectInfo != null && (bArr = nearLaptopManager$TransferConnectInfo.f3914c) != null) {
                    String str = deviceInfo.f4223d;
                    if (!Arrays.equals(bArr, str != null ? m3.q.d(str) : null) && a0Var.f4035d < 3) {
                        we.h.h("TranFileReceiveController", "ble connecting but pc ble mac change need update");
                        a0Var.m();
                        a0Var.f(m5Var);
                    }
                }
                we.h.h("TranFileReceiveController", "same device connecting, return");
                return;
            }
            ScanResult scanResult = (ScanResult) a0Var.f4036g.get(bluetoothDeviceQ != null ? bluetoothDeviceQ.getAddress() : null);
            if (scanResult == null || !Intrinsics.areEqual(scanResult.getDevice(), bluetoothDeviceQ)) {
                a0Var.m();
                a0Var.f(m5Var);
                we.h.c("TranFileReceiveController", "Invalid device, ignore", null);
            } else {
                a0Var.e = msgInfo;
                a0Var.f4038i = deviceInfo;
                ScanRecord scanRecord = scanResult.getScanRecord();
                a0Var.f4037h = scanRecord != null ? scanRecord.getDeviceName() : null;
                a0Var.f = bluetoothDeviceQ;
                a0Var.f(new m5(a0Var, 1));
            }
        }
    }
}
