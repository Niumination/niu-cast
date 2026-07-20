package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.j f10011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f10012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10013d;

    public /* synthetic */ u1(com.welink.protocol.nfbd.j jVar, BluetoothGatt bluetoothGatt, String str, int i8) {
        this.f10010a = i8;
        this.f10011b = jVar;
        this.f10012c = bluetoothGatt;
        this.f10013d = str;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0169  */
    /* JADX WARN: Code duplicated, block: B:68:0x0175  */
    /* JADX WARN: Code duplicated, block: B:70:0x017e  */
    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArr;
        byte[] bytes;
        x1 x1Var;
        NearDevice nearDevice;
        BluetoothGatt bluetoothGatt = this.f10012c;
        com.welink.protocol.nfbd.j jVar = this.f10011b;
        String str = this.f10013d;
        switch (this.f10010a) {
            case 0:
                UUID uuid = c6.f9690c;
                com.welink.protocol.nfbd.j jVar2 = this.f10011b;
                jVar2.getClass();
                BluetoothGatt bluetoothGatt2 = this.f10012c;
                BluetoothGattService bluetoothGattServiceM = com.welink.protocol.nfbd.j.m(bluetoothGatt2, uuid);
                if (bluetoothGattServiceM != null) {
                    BluetoothGattCharacteristic characteristic = bluetoothGattServiceM.getCharacteristic(uuid);
                    if (characteristic == null) {
                        String mes = "Characteristic " + uuid + " was not found";
                        Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            h0.a.x("TransConnect:", mes, "NearGattClient", null);
                        }
                    } else {
                        BluetoothDevice device = bluetoothGatt2.getDevice();
                        Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
                        String address = device.getAddress();
                        Map map = jVar2.f4134c;
                        if (map.get(address) != null) {
                            x1 x1Var2 = (x1) map.get(device.getAddress());
                            NearDevice nearDevice2 = x1Var2 != null ? x1Var2.f10057c : null;
                            if (nearDevice2 != null) {
                                Map map2 = com.welink.protocol.nfbd.h.f4132a;
                                int iD = com.welink.protocol.nfbd.h.d(nearDevice2.e);
                                String str2 = str == null ? jVar2.f != null ? "1.0" : null : str;
                                if (str != null && (x1Var = (x1) map.get(device.getAddress())) != null) {
                                    x1Var.f10058d = str;
                                    we.h.h("NearGattClient", "updateRemoteDeviceSupportedVersion: ".concat(str));
                                }
                                if (Intrinsics.areEqual(str2, "1.0")) {
                                    String string = jVar2.p(iD, nearDevice2, str2).toString();
                                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                    bytes = string.getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                } else if (Intrinsics.areEqual(str2, "2.0")) {
                                    String string2 = jVar2.p(iD, nearDevice2, str2).toString();
                                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                    bytes = string2.getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                } else {
                                    Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                                    Intrinsics.checkNotNullParameter("buildConnectRequest: matchedVersion is not support", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearGattClient", "TransConnect:buildConnectRequest: matchedVersion is not support", null);
                                    }
                                }
                                bArr = bytes;
                                if (bArr == null) {
                                    jVar2.y(bluetoothGatt2, null);
                                    li.l0.p(li.h0.a(li.v0.f7499b), null, null, new c2(jVar2, bluetoothGatt2, characteristic, bArr, null), 3);
                                } else {
                                    Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                                    Intrinsics.checkNotNullParameter("sendCreateConnectionRequest: connectRequest is null", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearGattClient", "TransConnect:sendCreateConnectionRequest: connectRequest is null", null);
                                    }
                                    bluetoothGatt2.disconnect();
                                }
                            } else {
                                Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                                Intrinsics.checkNotNullParameter("buildConnectRequest: nearDevice is null", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearGattClient", "TransConnect:buildConnectRequest: nearDevice is null", null);
                                }
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                            Intrinsics.checkNotNullParameter("buildConnectRequest: mBluetoothGatt[device.address] is null", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearGattClient", "TransConnect:buildConnectRequest: mBluetoothGatt[device.address] is null", null);
                            }
                        }
                        bArr = null;
                        if (bArr == null) {
                            jVar2.y(bluetoothGatt2, null);
                            li.l0.p(li.h0.a(li.v0.f7499b), null, null, new c2(jVar2, bluetoothGatt2, characteristic, bArr, null), 3);
                        } else {
                            Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                            Intrinsics.checkNotNullParameter("sendCreateConnectionRequest: connectRequest is null", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearGattClient", "TransConnect:sendCreateConnectionRequest: connectRequest is null", null);
                            }
                            bluetoothGatt2.disconnect();
                        }
                    }
                }
                break;
            case 1:
                x1 x1Var3 = (x1) jVar.f4134c.get(bluetoothGatt.getDevice().getAddress());
                nearDevice = x1Var3 != null ? x1Var3.f10057c : null;
                if (nearDevice != null && Intrinsics.areEqual(nearDevice.f3885c, str)) {
                    o.d.z("Device trusted by remote device: ", str, "NearGattClient");
                    Iterator it = jVar.f4136g.iterator();
                    while (it.hasNext()) {
                        ((w) it.next()).h(nearDevice, true);
                    }
                    break;
                }
                break;
            default:
                x1 x1Var4 = (x1) jVar.f4134c.get(bluetoothGatt.getDevice().getAddress());
                nearDevice = x1Var4 != null ? x1Var4.f10057c : null;
                if (nearDevice != null && Intrinsics.areEqual(nearDevice.f3885c, str)) {
                    o.d.z("Device reject by remote device: ", str, "NearGattClient");
                    Iterator it2 = jVar.f4136g.iterator();
                    while (it2.hasNext()) {
                        ((w) it2.next()).g(nearDevice);
                    }
                    break;
                }
                break;
        }
    }
}
