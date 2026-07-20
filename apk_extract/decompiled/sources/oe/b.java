package oe;

import a0.g;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.os.BatteryManager;
import android.util.Log;
import com.welink.protocol.nfbd.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import k3.lb;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import m3.o;
import se.c6;
import we.h;
import we.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends BluetoothGattServerCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8448b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f8447a = i8;
        this.f8448b = obj;
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public final void onCharacteristicReadRequest(BluetoothDevice device, int i8, int i9, BluetoothGattCharacteristic characteristic) {
        int i10 = this.f8447a;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        switch (i10) {
            case 0:
                super.onCharacteristicReadRequest(device, i8, i9, characteristic);
                h.g("Device: onCharacteristicReadRequest: device: " + device + ", requestId: " + i8 + ",offset: " + i9);
                break;
            default:
                super.onCharacteristicReadRequest(device, i8, i9, characteristic);
                h.b("NearGattService", "onCharacteristicReadRequest: device: " + device + ", requestId: " + i8 + ", offset: " + i9 + ", characteristic uuid: " + characteristic.getUuid());
                UUID uuid = c6.f9691d;
                UUID uuid2 = characteristic.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                boolean zB = o.b(uuid, uuid2);
                l lVar = (l) this.f8448b;
                if (zB) {
                    o.d.z("Incoming read request received from: ", device.getAddress(), "NearGattService");
                    byte[] bArr = {1, 0};
                    BluetoothGattServer bluetoothGattServer = lVar.e;
                    if (bluetoothGattServer != null) {
                        bluetoothGattServer.sendResponse(device, i8, 0, 0, bArr);
                    }
                }
                UUID uuid3 = c6.f9692g;
                UUID uuid4 = characteristic.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid4, "getUuid(...)");
                if (o.b(uuid3, uuid4)) {
                    o.d.z("Battery level read request received from: ", device.getAddress(), "NearGattService");
                    BatteryManager batteryManager = lVar.f4165v;
                    byte[] byteArray = null;
                    Integer numValueOf = batteryManager != null ? Integer.valueOf(batteryManager.getIntProperty(4)) : null;
                    BluetoothGattServer bluetoothGattServer2 = lVar.e;
                    if (bluetoothGattServer2 != null) {
                        if (numValueOf != null) {
                            int iIntValue = numValueOf.intValue();
                            ArrayList arrayList = new ArrayList();
                            for (int iA = 1; iA >= 0; iA = h0.a.a((byte) (iIntValue >> (iA * 8)), arrayList, iA, -1)) {
                            }
                            byteArray = CollectionsKt.toByteArray(arrayList);
                        }
                        bluetoothGattServer2.sendResponse(device, i8, 0, 0, byteArray);
                    }
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public final void onCharacteristicWriteRequest(BluetoothDevice device, int i8, BluetoothGattCharacteristic characteristic, boolean z2, boolean z3, int i9, byte[] value) {
        BluetoothGattServer bluetoothGattServer;
        Object obj = this.f8448b;
        int i10 = this.f8447a;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        switch (i10) {
            case 0:
                c cVar = (c) obj;
                cVar.getClass();
                h.g("Device: in onCharacteristicWriteRequest offset: " + i9 + ", responseNeeded: " + z3 + ",preparedWrite: " + z2 + ", gattServer is null, device: " + device + ", requestId: " + i8 + ",\nvalue size is " + (value != null ? Integer.valueOf(value.length) : null));
                super.onCharacteristicWriteRequest(device, i8, characteristic, z2, z3, i9, value);
                if (Intrinsics.areEqual(device, cVar.f)) {
                    h.g("Device: onCharacteristicWriteRequest, device is welink mDevice");
                    if (Intrinsics.areEqual(characteristic.getUuid(), c.f8450n)) {
                        if (value == null) {
                            h.d("Device Error: 手机发来消息 value is null !!!", null);
                        } else if (value.length == 0) {
                            h.d("Device Error: received value is empty", null);
                        } else if (value.length < 4) {
                            h.d("Device Error: received value size is value!!.size", null);
                        } else {
                            h.g("Device: Received the phone's info, value size is: ");
                            Intrinsics.checkNotNullParameter(value, "<this>");
                            String strB = "";
                            for (byte b9 : value) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b9)}, 1, "%02x ", "format(...)"));
                            }
                            h.g(strB);
                            c.f8452r.add(new Triple(2, value, cVar));
                        }
                    }
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicWriteRequest(device, i8, characteristic, z2, z3, i9, value);
                l lVar = (l) obj;
                if (lVar.e == null || lVar.f4152d == null) {
                    Intrinsics.checkNotNullParameter("NearGattService", "tag");
                    Intrinsics.checkNotNullParameter("BluetoothGattServer or Context is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattService", "TransConnect:BluetoothGattServer or Context is null", null);
                    }
                } else {
                    UUID uuid = c6.f9689b;
                    UUID uuid2 = characteristic.getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                    if (o.b(uuid, uuid2)) {
                        h.b("NearGattService", "Incoming write request received from: " + device.getAddress());
                        if (m.e(518)) {
                            m.c(518);
                            h.b("NearGattService", "Device handshake timer cancelled");
                        }
                        if (z3 && (bluetoothGattServer = lVar.e) != null) {
                            bluetoothGattServer.sendResponse(device, i8, 0, 0, null);
                        }
                        lVar.f(new g(lVar, device, i9, value));
                    } else {
                        h.j("NearGattService", "Unknown characteristic write request");
                        l.z(device, lVar);
                        BluetoothGattServer bluetoothGattServer2 = lVar.e;
                        if (bluetoothGattServer2 != null) {
                            bluetoothGattServer2.sendResponse(device, i8, 257, 0, null);
                        }
                    }
                }
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0085, code lost:
    
        if (kotlin.collections.ArraysKt.contains(r0, new android.os.ParcelUuid(se.c6.f9688a)) != false) goto L16;
     */
    @Override // android.bluetooth.BluetoothGattServerCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onConnectionStateChange(android.bluetooth.BluetoothDevice r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oe.b.onConnectionStateChange(android.bluetooth.BluetoothDevice, int, int):void");
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public final void onDescriptorReadRequest(BluetoothDevice device, int i8, int i9, BluetoothGattDescriptor descriptor) {
        switch (this.f8447a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorReadRequest(device, i8, i9, descriptor);
                h.g("Devices: onDescriptorReadRequest: device: " + device + ", requestId: " + i8 + ",offset: " + i9 + ", descriptor: " + descriptor.getUuid() + " ");
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorReadRequest(device, i8, i9, descriptor);
                l lVar = (l) this.f8448b;
                if (lVar.e == null || lVar.f4152d == null) {
                    Intrinsics.checkNotNullParameter("NearGattService", "tag");
                    Intrinsics.checkNotNullParameter("BluetoothGattServer or Context is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattService", "TransConnect:BluetoothGattServer or Context is null", null);
                    }
                } else {
                    UUID uuid = c6.f;
                    UUID uuid2 = descriptor.getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                    if (o.b(uuid, uuid2)) {
                        h.b("NearGattService", "Config descriptor read");
                        byte[] bArr = lVar.f4156j.contains(device) ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                        try {
                            BluetoothGattServer bluetoothGattServer = lVar.e;
                            if (bluetoothGattServer != null) {
                                bluetoothGattServer.sendResponse(device, i8, 0, 0, bArr);
                            }
                            h.b("NearGattService", "Sent descriptor read successful response");
                        } catch (Exception unused) {
                            Intrinsics.checkNotNullParameter("NearGattService", "tag");
                            Intrinsics.checkNotNullParameter("Failed to send descriptor read response", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearGattService", "TransConnect:Failed to send descriptor read response", null);
                                return;
                            }
                            return;
                        }
                    } else {
                        h.j("NearGattService", "Unknown descriptor read request");
                        try {
                            BluetoothGattServer bluetoothGattServer2 = lVar.e;
                            if (bluetoothGattServer2 != null) {
                                bluetoothGattServer2.sendResponse(device, i8, 257, 0, null);
                            }
                            h.b("NearGattService", "Sent descriptor read failed(unknown) response");
                        } catch (Exception unused2) {
                            Intrinsics.checkNotNullParameter("NearGattService", "tag");
                            Intrinsics.checkNotNullParameter("Failed to send descriptor read response", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearGattService", "TransConnect:Failed to send descriptor read response", null);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public final void onDescriptorWriteRequest(BluetoothDevice device, int i8, BluetoothGattDescriptor descriptor, boolean z2, boolean z3, int i9, byte[] value) {
        Object obj = this.f8448b;
        int i10 = this.f8447a;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (i10) {
            case 0:
                super.onDescriptorWriteRequest(device, i8, descriptor, z2, z3, i9, value);
                c cVar = (c) obj;
                if (z3) {
                    cVar.getClass();
                }
                h.g("Devices: onDescriptorWriteRequest: device: " + device + ", requestId: " + i8 + ",responseNeeded: " + z3 + ", descriptor: " + descriptor.getUuid() + " value is :");
                if (Intrinsics.areEqual(device, cVar.f)) {
                    h.g("Device: onDescriptorWriteRequest, device is welink mDevice");
                    if (Intrinsics.areEqual(descriptor.getUuid(), c.f8451o)) {
                        h.g("Devices: onDescriptorWriteRequest: success");
                        cVar.f8460h = true;
                        h.g("send localMaxAttMTU:517 to phone");
                        ArrayList arrayList = new ArrayList();
                        for (int iA = 1; iA >= 0; iA = h0.a.a((byte) (517 >> (iA * 8)), arrayList, iA, -1)) {
                        }
                        cVar.f((byte) 62, false, CollectionsKt.toByteArray(arrayList));
                    }
                    Intrinsics.checkNotNullParameter(value, "<this>");
                    String strB = "";
                    for (byte b9 : value) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b9)}, 1, "%02x ", "format(...)"));
                    }
                    h.g(strB);
                }
                break;
            default:
                super.onDescriptorWriteRequest(device, i8, descriptor, z2, z3, i9, value);
                l lVar = (l) obj;
                if (lVar.e == null || lVar.f4152d == null) {
                    Intrinsics.checkNotNullParameter("NearGattService", "tag");
                    Intrinsics.checkNotNullParameter("BluetoothGattServer or Context is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattService", "TransConnect:BluetoothGattServer or Context is null", null);
                    }
                } else {
                    UUID uuid = c6.f;
                    UUID uuid2 = descriptor.getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
                    if (o.b(uuid, uuid2)) {
                        boolean zEquals = Arrays.equals(value, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        LinkedHashSet linkedHashSet = lVar.f4156j;
                        if (zEquals) {
                            h.h("NearGattService", "Subscribe device to notifications: " + device.getAddress());
                            linkedHashSet.add(device);
                            if (!lVar.f4155i.contains(device)) {
                                l.j(lVar, device, 0, 2);
                            }
                            l.z(device, lVar);
                        } else if (Arrays.equals(value, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                            h.h("NearGattService", "Unsubscribe device from notifications: " + device.getAddress());
                            linkedHashSet.remove(device);
                        } else {
                            String string = Arrays.toString(value);
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            h.j("NearGattService", "Unknown descriptor value: " + string);
                        }
                        if (z3) {
                            try {
                                BluetoothGattServer bluetoothGattServer = lVar.e;
                                if (bluetoothGattServer != null) {
                                    bluetoothGattServer.sendResponse(device, i8, 0, 0, null);
                                }
                                h.b("NearGattService", "Sent descriptor successful response successfully");
                            } catch (Exception unused) {
                                Intrinsics.checkNotNullParameter("NearGattService", "tag");
                                Intrinsics.checkNotNullParameter("Failed to send descriptor response", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearGattService", "TransConnect:Failed to send descriptor response", null);
                                    return;
                                }
                                return;
                            }
                        }
                    } else if (z3) {
                        try {
                            BluetoothGattServer bluetoothGattServer2 = lVar.e;
                            if (bluetoothGattServer2 != null) {
                                bluetoothGattServer2.sendResponse(device, i8, 257, 0, null);
                            }
                            h.b("NearGattService", "Sent descriptor failed response successfully");
                        } catch (Exception unused2) {
                            Intrinsics.checkNotNullParameter("NearGattService", "tag");
                            Intrinsics.checkNotNullParameter("Failed to send descriptor response", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearGattService", "TransConnect:Failed to send descriptor response", null);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onExecuteWrite(BluetoothDevice device, int i8, boolean z2) {
        switch (this.f8447a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                super.onExecuteWrite(device, i8, z2);
                h.g("Devices: onExecuteWrite, execute: " + z2);
                break;
            default:
                super.onExecuteWrite(device, i8, z2);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public final void onMtuChanged(BluetoothDevice device, int i8) {
        switch (this.f8447a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                super.onMtuChanged(device, i8);
                h.g("Devices: onMtuChanged, attMtu: " + i8);
                if (Intrinsics.areEqual(device, ((c) this.f8448b).f)) {
                    h.g("Device: onMtuChanged, device is welink mDevice");
                    if (i8 > 20) {
                        int i9 = (i8 - 3) - c.q;
                        c.p = i9;
                        h.g("Devices: gatt mtu is " + i8 + ",DATA_MAX_LENGTH: " + i9 + ", ");
                    }
                }
                break;
            default:
                super.onMtuChanged(device, i8);
                se.a.f9637a = i8;
                h0.a.C(i8, "MTU size changed to: ", "NearGattService");
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public void onNotificationSent(BluetoothDevice device, int i8) {
        switch (this.f8447a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                super.onNotificationSent(device, i8);
                ((c) this.f8448b).f8464l = true;
                h.g("Devices: mIsLastSendOK, onNotificationSent, status: " + i8);
                break;
            default:
                super.onNotificationSent(device, i8);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattServerCallback
    public final void onServiceAdded(int i8, BluetoothGattService service) {
        switch (this.f8447a) {
            case 0:
                Intrinsics.checkNotNullParameter(service, "service");
                super.onServiceAdded(i8, service);
                h.g("Device: onServiceAdded: status: " + i8 + ", service: " + service.getUuid());
                break;
            default:
                super.onServiceAdded(i8, service);
                h.b("NearGattService", "onServiceAdded: status: " + i8 + ", service: " + service);
                if (i8 != 0) {
                    Log.d("NearGattService", "onServiceAdded Adding Service failed..");
                }
                l lVar = (l) this.f8448b;
                o.d.x(lVar.f4154h.size(), "onServiceAdded. service remain: ", "NearGattService");
                LinkedBlockingQueue linkedBlockingQueue = lVar.f4154h;
                if (linkedBlockingQueue.peek() != null) {
                    lVar.k((BluetoothGattService) linkedBlockingQueue.remove());
                }
                break;
        }
    }
}
