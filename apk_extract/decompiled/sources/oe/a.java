package oe;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.welink.protocol.nfbd.a0;
import com.welink.protocol.nfbd.b0;
import com.welink.protocol.nfbd.j;
import d6.q;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import k3.hc;
import k3.jd;
import k3.lb;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import m3.p;
import org.json.JSONException;
import org.json.JSONObject;
import se.a4;
import se.c6;
import se.g5;
import se.m5;
import se.o5;
import se.u1;
import se.v1;
import se.z6;
import we.h;
import we.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends BluetoothGattCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8446b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f8445a = i8;
        this.f8446b = obj;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        Object obj = this.f8446b;
        int i8 = this.f8445a;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        switch (i8) {
            case 0:
                c cVar = (c) obj;
                if (!Intrinsics.areEqual(gatt, cVar.f8458d)) {
                    h.g("Phone: onCharacteristicChanged , it is not welink gatt");
                } else if (characteristic.getValue() == null) {
                    Intrinsics.checkNotNullParameter("Phone: 设备发来消息：value is null !!!", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", "Phone: 设备发来消息：value is null !!!", null);
                    }
                } else {
                    int length = characteristic.getValue().length;
                    byte[] value = characteristic.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
                    Intrinsics.checkNotNullParameter(value, "<this>");
                    StringBuilder sb2 = new StringBuilder();
                    int iE = 0;
                    for (int length2 = value.length; iE < length2; length2 = length2) {
                        byte b9 = value[iE];
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        iE = h0.a.e(new Object[]{Byte.valueOf(b9)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                    }
                    String string = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    h.g("Phone: Received the remote's info, value size is " + length + " \nvalue:" + string);
                    if (characteristic.getValue()[0] == -18 && characteristic.getValue()[2] == c.f8453s.f9013a) {
                        byte[] value2 = characteristic.getValue();
                        Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
                        c.a(cVar, value2);
                    } else if (characteristic.getValue()[0] == -18 && characteristic.getValue()[2] == 62) {
                        int length3 = characteristic.getValue().length;
                        int i9 = c.q;
                        if (length3 == 2 + i9) {
                            int iM177constructorimpl = ((UByte.m177constructorimpl(characteristic.getValue()[5]) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(characteristic.getValue()[6]) & UByte.MAX_VALUE);
                            h.g("Phone: GET_MAX_MTU: get remote support max mtu is: " + iM177constructorimpl);
                            if (iM177constructorimpl < i9 + 1) {
                                int i10 = 20 - i9;
                                c.p = i10;
                                h.d("Phone: maxAttMTU is illegal, now use default att mtu: 23, DATA_MAX_LENGTH : " + i10, null);
                            } else if (517 > iM177constructorimpl) {
                                BluetoothGatt bluetoothGatt = cVar.f8458d;
                                if (bluetoothGatt != null) {
                                    bluetoothGatt.requestMtu(iM177constructorimpl);
                                }
                                int i11 = (iM177constructorimpl - 3) - i9;
                                c.p = i11;
                                h.g("Phone: now use remoteMaxMTU as att mtu: " + iM177constructorimpl + ", new DATA_MAX_LENGTH: " + i11);
                            } else {
                                BluetoothGatt bluetoothGatt2 = cVar.f8458d;
                                if (bluetoothGatt2 != null) {
                                    bluetoothGatt2.requestMtu(517);
                                }
                                int i12 = 514 - i9;
                                c.p = i12;
                                h.g("Phone: now use localMaxAttMTU as att mtu: 517, new DATA_MAX_LENGTH: " + i12);
                            }
                        }
                    } else {
                        c.f8452r.add(new Triple(2, characteristic.getValue(), cVar));
                    }
                }
                break;
            case 2:
                super.onCharacteristicChanged(gatt, characteristic);
                h.h("TranFileReceiveController", "onCharacteristicChanged : " + characteristic.getUuid());
                if (Intrinsics.areEqual(characteristic.getUuid(), z6.f10088d)) {
                    byte[] value3 = characteristic.getValue();
                    Intrinsics.checkNotNullExpressionValue(value3, "getValue(...)");
                    a0.j((a0) obj, value3);
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i8) {
        switch (this.f8445a) {
            case 0:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                h.g("Phone: Read characteristic:" + characteristic + "  status:" + i8);
                break;
            case 1:
            default:
                super.onCharacteristicRead(gatt, characteristic, i8);
                break;
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i8) {
        int i9 = this.f8445a;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        switch (i9) {
            case 0:
                h.g("Phone: mIsLastSendOK, Write characteristic:" + characteristic + "  status:" + i8);
                ((c) this.f8446b).f8464l = true;
                break;
            case 1:
                super.onCharacteristicWrite(gatt, characteristic, i8);
                if (i8 != 0) {
                    h.j("NearGattClient", "onCharacteristicWrite received: " + i8);
                } else {
                    h.b("NearGattClient", "Write characteristic: " + characteristic.getUuid());
                    CountDownLatch countDownLatch = ((j) this.f8446b).p;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
                break;
            case 2:
                super.onCharacteristicWrite(gatt, characteristic, i8);
                h0.a.u(i8, "onCharacteristicWrite : ", "TranFileReceiveController");
                a0 a0Var = (a0) this.f8446b;
                if (i8 != 0) {
                    a0Var.f4050x = null;
                    a0Var.n();
                } else if (!Intrinsics.areEqual(characteristic.getUuid(), z6.f10088d)) {
                    a0Var.f4050x = null;
                    a0Var.m();
                    if (!a0Var.A.isEmpty()) {
                        a0.o((a0) this.f8446b, -4, 0, 4, null, null, 448);
                    }
                } else {
                    byte[] value = characteristic.getValue();
                    if (value != null) {
                        byte[] bArr = a0Var.f4050x;
                        Intrinsics.checkNotNull(bArr);
                        if (Arrays.equals(value, bArr)) {
                            onReliableWriteCompleted(gatt, i8);
                            h.b("TranFileReceiveController", "writeCharacteristic ok");
                        }
                    }
                }
                break;
            default:
                super.onCharacteristicWrite(gatt, characteristic, i8);
                int i10 = b0.Q;
                h0.a.C(i8, "onCharacteristicWrite : ", "TranFileSendController");
                if (i8 != 0) {
                    gatt.abortReliableWrite();
                    b0 b0Var = (b0) this.f8446b;
                    b0Var.f4063o = null;
                    b0Var.m();
                } else if (Intrinsics.areEqual(characteristic.getUuid(), z6.e)) {
                    if (!((b0) this.f8446b).f4068w) {
                        byte[] value2 = characteristic.getValue();
                        Intrinsics.checkNotNullExpressionValue(value2, "getValue(...)");
                        if (!StringsKt__StringsJVMKt.contentEquals((CharSequence) new String(value2, Charsets.UTF_8), (CharSequence) ((b0) this.f8446b).f4063o)) {
                            b0 b0Var2 = (b0) this.f8446b;
                            b0Var2.f4063o = null;
                            b0Var2.m();
                        } else {
                            gatt.executeReliableWrite();
                            b0 b0Var3 = (b0) this.f8446b;
                            b0Var3.g(6000L, b0Var3.M);
                            h.b("TranFileSendController", "writeCharacteristic ok");
                        }
                    } else {
                        if (!((b0) this.f8446b).p.isEmpty()) {
                            b0.n((b0) this.f8446b, 0, 4, 384);
                        }
                        b0 b0Var4 = (b0) this.f8446b;
                        b0Var4.f4063o = null;
                        b0Var4.l();
                    }
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onConnectionStateChange(BluetoothGatt gatt, int i8, int i9) {
        int i10 = 2;
        int i11 = this.f8445a;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        switch (i11) {
            case 0:
                h.g("Phone: onConnectionStateChange status:" + i8 + "  newState:" + i9);
                c cVar = (c) this.f8446b;
                if (i9 == 0) {
                    h.d("GATT STATE_DISCONNECTED: gatt is " + gatt + "，mBluetoothGatt is " + cVar.f8458d + "!", null);
                    cVar.f8461i = false;
                    cVar.f8460h = false;
                    h.g("先释放资源!");
                    BluetoothGatt bluetoothGatt = cVar.f8458d;
                    if (bluetoothGatt != null && !Intrinsics.areEqual(bluetoothGatt, gatt)) {
                        BluetoothGatt bluetoothGatt2 = cVar.f8458d;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        c.c(bluetoothGatt2);
                        cVar.f8458d = null;
                    }
                    c.c(gatt);
                    if (!cVar.f8462j) {
                        h.g("主动断连的，不需要重连!");
                    } else {
                        cVar.getClass();
                        if (p.a()) {
                            BluetoothDevice remoteDevice = cVar.f8457c.getRemoteDevice(cVar.f8455a);
                            if (remoteDevice != null) {
                                h.g("connect gatt new");
                                cVar.f8462j = true;
                                cVar.f8458d = remoteDevice.connectGatt(cVar.f8456b, false, cVar.f8463k, 2);
                            } else {
                                Intrinsics.checkNotNullParameter("remote device is null", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("welinkBLE", "remote device is null", null);
                                }
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("connect: 蓝牙开启超时，退出！", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("welinkBLE", "connect: 蓝牙开启超时，退出！", null);
                            }
                        }
                        h.g("现在重新建立gatt连接，系统默认连接超时时间是30s，超时后会再次收到STATE_DISCONNECTED事件，连接成功后会收到STATE_CONNECTED");
                    }
                    break;
                } else if (i9 == 2) {
                    h.g("GATT STATE_CONNECTED: gatt is " + gatt + "，mBluetoothGatt is " + cVar.f8458d + "!");
                    Boolean boolValueOf = Boolean.valueOf(gatt.requestConnectionPriority(1));
                    StringBuilder sb2 = new StringBuilder("GATT STATE_CONNECTED: requestConnectionPriority result is ");
                    sb2.append(boolValueOf);
                    sb2.append("!");
                    h.g(sb2.toString());
                    if (cVar.f8458d == null) {
                        cVar.f8458d = gatt;
                    }
                    gatt.discoverServices();
                    cVar.f8461i = true;
                    UUID uuid = c.f8449m;
                    hc.a();
                    break;
                }
                break;
            case 1:
                super.onConnectionStateChange(gatt, i8, i9);
                j jVar = (j) this.f8446b;
                if (i9 == 0) {
                    h.h("NearGattClient", "Disconnected from GATT server.");
                    jVar.getClass();
                    jVar.f(new b.d(jVar, gatt, i8, i9));
                    break;
                } else if (i9 == 2) {
                    h.h("NearGattClient", "Connected to GATT server.");
                    jVar.getClass();
                    jVar.f(new b.d(jVar, gatt, i8, i9));
                    break;
                }
                break;
            case 2:
                super.onConnectionStateChange(gatt, i8, i9);
                h.h("TranFileReceiveController", "onConnectionStateChange " + i8 + " -> " + i9);
                a0 a0Var = (a0) this.f8446b;
                if (i9 == 2) {
                    a0Var.B = 2;
                    a0.o(a0Var, 0, 0, 18, null, null, 384);
                    a0Var.f4035d = 2;
                    gatt.discoverServices();
                    m5 m5Var = new m5(a0Var, i10);
                    ConcurrentHashMap concurrentHashMap = m.f10734a;
                    m.a(2052, CoroutineLiveDataKt.DEFAULT_TIMEOUT, a0Var.a(), m5Var);
                } else if (i9 == 0 && a0Var.B != 2) {
                    h.h("TranFileReceiveController", "retry connect");
                    a0Var.B = 0;
                    if (a0Var.f != null && a0Var.f4040k < 3) {
                        a0Var.p(false);
                        a0Var.f4040k++;
                        a0Var.g(300L, a0Var.O);
                    } else {
                        a0Var.f4040k = 0;
                        a0Var.f = null;
                        a0Var.f4036g.clear();
                        a0Var.n();
                    }
                } else if (i9 == 0) {
                    a0Var.B = 0;
                    h.h("TranFileReceiveController", "BLE disconnect");
                    if (!a0Var.A.isEmpty()) {
                        a0.o(a0Var, 24, 0, 4, null, null, 448);
                    }
                    a0Var.m();
                }
                break;
            default:
                super.onConnectionStateChange(gatt, i8, i9);
                int i12 = b0.Q;
                h.b("TranFileSendController", "onConnectionStateChange " + i8 + " -> " + i9);
                b0 b0Var = (b0) this.f8446b;
                if (b0Var.c(b0Var.I)) {
                    b0 b0Var2 = (b0) this.f8446b;
                    b0Var2.h(b0Var2.I);
                }
                if (i9 == 2) {
                    b0 b0Var3 = (b0) this.f8446b;
                    b0Var3.F = i9;
                    if (!b0Var3.f4068w) {
                        ((b0) this.f8446b).f4054d = 2;
                        b0.n((b0) this.f8446b, 0, 18, 384);
                        gatt.discoverServices();
                        b0 b0Var4 = (b0) this.f8446b;
                        b0Var4.getClass();
                        o5 o5Var = new o5(b0Var4, 2);
                        ConcurrentHashMap concurrentHashMap2 = m.f10734a;
                        m.a(2308, CoroutineLiveDataKt.DEFAULT_TIMEOUT, b0Var4.a(), o5Var);
                    } else {
                        if (!((b0) this.f8446b).p.isEmpty()) {
                            b0.n((b0) this.f8446b, 0, 4, 384);
                        }
                        ((b0) this.f8446b).o(false);
                    }
                } else if (i9 == 0 && ((b0) this.f8446b).F != 2) {
                    h.b("TranFileSendController", "retry connect");
                    b0 b0Var5 = (b0) this.f8446b;
                    b0Var5.F = 0;
                    if (!b0Var5.f4068w) {
                        b0 b0Var6 = (b0) this.f8446b;
                        if (b0Var6.f4061m >= 3) {
                            b0Var6.f4061m = 0;
                            b0Var6.m();
                        } else {
                            b0Var6.o(false);
                            b0 b0Var7 = (b0) this.f8446b;
                            b0Var7.f4061m++;
                            b0Var7.g(300L, b0Var7.O);
                        }
                    } else {
                        if (!((b0) this.f8446b).p.isEmpty()) {
                            b0.n((b0) this.f8446b, 0, 4, 384);
                        }
                        ((b0) this.f8446b).l();
                    }
                } else if (i9 == 0) {
                    ((b0) this.f8446b).F = 0;
                    h.h("TranFileSendController", "BLE disconnect");
                    b0 b0Var8 = (b0) this.f8446b;
                    if (!b0Var8.p.isEmpty()) {
                        b0.n(b0Var8, 24, 4, 448);
                    }
                    b0Var8.l();
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int i8) {
        switch (this.f8445a) {
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorRead(gatt, descriptor, i8);
                h.h("TranFileReceiveController", "onDescriptorRead");
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorRead(gatt, descriptor, i8);
                int i9 = b0.Q;
                h.b("TranFileSendController", "onDescriptorRead");
                break;
            default:
                super.onDescriptorRead(gatt, descriptor, i8);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int i8) {
        String str = null;
        switch (this.f8445a) {
            case 0:
                super.onDescriptorWrite(gatt, descriptor, i8);
                h.g("Phone: onDescriptorWrite status:" + i8);
                c cVar = (c) this.f8446b;
                if (Intrinsics.areEqual(gatt, cVar.f8458d)) {
                    h.g("Phone: onDescriptorWrite ,and it is welink gatt");
                    if (i8 != 0) {
                        h.d("Phone: onDescriptorWrite status error!", null);
                    } else {
                        h.g("Phone: onDescriptorWrite status success and it is welink gatt");
                        cVar.f8460h = true;
                    }
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorWrite(gatt, descriptor, i8);
                if (i8 == 0 && Intrinsics.areEqual(descriptor.getUuid(), c6.f)) {
                    h.h("NearGattClient", "Descriptor write success.");
                    j jVar = (j) this.f8446b;
                    jVar.getClass();
                    if (m.e(261)) {
                        m.c(261);
                    }
                    m.a(262, 50L, jVar.a(), new u1(jVar, gatt, str, 0));
                    break;
                }
                break;
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorWrite(gatt, descriptor, i8);
                h0.a.u(i8, "onDescriptorWrite : ", "TranFileReceiveController");
                a0 a0Var = (a0) this.f8446b;
                if (i8 != 0) {
                    a0Var.n();
                    break;
                } else {
                    UUID uuid = z6.f10088d;
                    Intrinsics.checkNotNullExpressionValue(uuid, "<get-FILE_TRANSFER_RECEIVE_UUID>(...)");
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB = jd.b(gatt, uuid);
                    if (bluetoothGattCharacteristicB != null && !gatt.readCharacteristic(bluetoothGattCharacteristicB)) {
                        h.h("TranFileReceiveController", "readCharacteristic fail");
                        a0Var.n();
                        break;
                    }
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                super.onDescriptorWrite(gatt, descriptor, i8);
                int i9 = b0.Q;
                h.b("TranFileSendController", "onDescriptorWrite");
                if (i8 != 0) {
                    ((b0) this.f8446b).m();
                } else {
                    ((b0) this.f8446b).f4069x = true;
                    if (((b0) this.f8446b).f4068w) {
                        ((b0) this.f8446b).t(gatt);
                    }
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onMtuChanged(BluetoothGatt gatt, int i8, int i9) {
        Object obj = this.f8446b;
        int i10 = this.f8445a;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        switch (i10) {
            case 0:
                super.onMtuChanged(gatt, i8, i9);
                if (Intrinsics.areEqual(gatt, ((c) obj).f8458d)) {
                    h.g("Phone: onMtuChanged, and it is welink gatt");
                    if (i9 != 0) {
                        h.g("Phone: onMtuChanged fail");
                    } else {
                        h.g("Phone: onMtuChanged success, att mtu = " + i8);
                    }
                }
                break;
            case 1:
                super.onMtuChanged(gatt, i8, i9);
                if (i9 == 0) {
                    h0.a.u(i8, "MTU changed to: ", "NearGattClient");
                    se.a.f9637a = i8;
                    if (m.e(259)) {
                        m.c(259);
                    }
                    j jVar = (j) obj;
                    jVar.getClass();
                    gatt.discoverServices();
                    m.a(260, CoroutineLiveDataKt.DEFAULT_TIMEOUT, jVar.a(), new v1(jVar, gatt, 1, (byte) 0));
                }
                break;
            case 2:
                super.onMtuChanged(gatt, i8, i9);
                h0.a.u(i9, "onMtuChanged : ", "TranFileReceiveController");
                break;
            default:
                super.onMtuChanged(gatt, i8, i9);
                int i11 = b0.Q;
                h.b("TranFileSendController", "onMtuChanged : " + i9);
                gatt.discoverServices();
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onPhyRead(BluetoothGatt gatt, int i8, int i9, int i10) {
        switch (this.f8445a) {
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onPhyRead(gatt, i8, i9, i10);
                h.h("TranFileReceiveController", "onPhyRead");
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onPhyRead(gatt, i8, i9, i10);
                int i11 = b0.Q;
                h.b("TranFileSendController", "onPhyRead");
                break;
            default:
                super.onPhyRead(gatt, i8, i9, i10);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onPhyUpdate(BluetoothGatt gatt, int i8, int i9, int i10) {
        switch (this.f8445a) {
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onPhyUpdate(gatt, i8, i9, i10);
                h.h("TranFileReceiveController", "onPhyUpdate");
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onPhyUpdate(gatt, i8, i9, i10);
                int i11 = b0.Q;
                h.b("TranFileSendController", "onPhyUpdate");
                break;
            default:
                super.onPhyUpdate(gatt, i8, i9, i10);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt gatt, int i8, int i9) {
        switch (this.f8445a) {
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onReadRemoteRssi(gatt, i8, i9);
                h.h("TranFileReceiveController", "onReadRemoteRssi");
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onReadRemoteRssi(gatt, i8, i9);
                int i10 = b0.Q;
                h.b("TranFileSendController", "onReadRemoteRssi");
                break;
            default:
                super.onReadRemoteRssi(gatt, i8, i9);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt gatt, int i8) {
        Object obj = this.f8446b;
        switch (this.f8445a) {
            case 1:
                super.onReliableWriteCompleted(gatt, i8);
                if (i8 == 0) {
                    h.b("NearGattClient", "Reliable write completed.");
                }
                break;
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onReliableWriteCompleted(gatt, i8);
                h.b("TranFileReceiveController", "writeCharacteristic complete");
                a0 a0Var = (a0) obj;
                if (i8 != 0) {
                    a0Var.f4050x = null;
                    a0Var.n();
                    h.b("TranFileReceiveController", "writeCharacteristic result failed");
                } else {
                    h.b("TranFileReceiveController", "writeCharacteristic successfully");
                    if (a0Var.c(a0Var.N)) {
                        a0Var.h(a0Var.N);
                    }
                    UUID uuid = z6.f10088d;
                    Intrinsics.checkNotNullExpressionValue(uuid, "<get-FILE_TRANSFER_RECEIVE_UUID>(...)");
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB = jd.b(gatt, uuid);
                    LinkedHashSet linkedHashSet = a0Var.A;
                    if (bluetoothGattCharacteristicB != null) {
                        if (a0Var.f4045r) {
                            h.b("TranFileReceiveController", "Start P2P connect now");
                            a0Var.f4035d = 3;
                            a0Var.f(new o.e(11, a0Var, gatt));
                        } else {
                            h.b("TranFileReceiveController", "Reject connect now");
                            if (!linkedHashSet.isEmpty()) {
                                a0.o((a0) obj, -1, 0, 4, null, null, 448);
                            }
                        }
                    } else if (!linkedHashSet.isEmpty()) {
                        a0.o((a0) obj, -4, 0, 4, null, null, 448);
                    }
                    a0Var.f4050x = null;
                    a0Var.p(false);
                }
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                super.onReliableWriteCompleted(gatt, i8);
                int i9 = b0.Q;
                h.b("TranFileSendController", "writeCharacteristic complete");
                b0 b0Var = (b0) obj;
                if (i8 != 0) {
                    b0Var.f4063o = null;
                    b0Var.m();
                    h.b("TranFileSendController", "writeCharacteristic result failed");
                    break;
                } else {
                    h.b("TranFileSendController", "writeCharacteristic successfully");
                    if (b0Var.c(b0Var.M)) {
                        b0Var.h(b0Var.M);
                    }
                    UUID uuid2 = z6.e;
                    Intrinsics.checkNotNullExpressionValue(uuid2, "<get-FILE_TRANSFER_SEND_UUID>(...)");
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB2 = jd.b(gatt, uuid2);
                    if (bluetoothGattCharacteristicB2 != null && !gatt.readCharacteristic(bluetoothGattCharacteristicB2)) {
                        h.b("TranFileSendController", "readCharacteristic failed");
                        b0Var.f4063o = null;
                        b0Var.m();
                        break;
                    }
                }
                break;
            default:
                super.onReliableWriteCompleted(gatt, i8);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public final void onServicesDiscovered(BluetoothGatt gatt, int i8) {
        Byte bValueOf;
        Object obj = this.f8446b;
        int i9 = this.f8445a;
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        switch (i9) {
            case 0:
                h.g("Phone: onServicesDiscovered status:" + i8);
                c cVar = (c) obj;
                if (Intrinsics.areEqual(gatt, cVar.f8458d) && i8 == 0) {
                    h.g("Phone: onServicesDiscovered, and it is welink gatt");
                    BluetoothGattService service = gatt.getService(c.f8449m);
                    h.g("Phone: gattService:" + service);
                    BluetoothGattCharacteristic characteristic = service != null ? service.getCharacteristic(c.f8450n) : null;
                    cVar.e = characteristic;
                    h.g("Phone: mReadWriteCharacteristic:" + characteristic + ", properties: " + (characteristic != null ? Integer.valueOf(characteristic.getProperties()) : null));
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = cVar.e;
                    if (bluetoothGattCharacteristic != null) {
                        bluetoothGattCharacteristic.setWriteType(1);
                    }
                    BluetoothGattCharacteristic bluetoothGattCharacteristic2 = cVar.e;
                    BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic2 != null ? bluetoothGattCharacteristic2.getDescriptor(c.f8451o) : null;
                    if (service == null || cVar.e == null || descriptor == null) {
                        h.d("Phone: initService error: gattService is " + service + ", mReadWriteCharacteristic is " + cVar.e + "descriptor is " + descriptor + ", now disconnect gatt", null);
                        cVar.b();
                    } else {
                        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        gatt.setCharacteristicNotification(cVar.e, true);
                        gatt.writeDescriptor(descriptor);
                        h.g("Phone: initService finish !");
                    }
                    break;
                }
                break;
            case 1:
                super.onServicesDiscovered(gatt, i8);
                if (i8 != 0) {
                    h.j("NearGattClient", "onServicesDiscovered received: " + i8);
                } else {
                    h.h("NearGattClient", "Services discovered.");
                    j jVar = (j) obj;
                    jVar.getClass();
                    jVar.f(new v1(jVar, gatt, i8));
                }
                break;
            case 2:
                super.onServicesDiscovered(gatt, i8);
                h.h("TranFileReceiveController", "onServicesDiscovered : " + i8);
                if (m.e(2052)) {
                    m.c(2052);
                }
                a0 a0Var = (a0) obj;
                if (i8 != 0) {
                    a0Var.n();
                } else {
                    UUID uuid = z6.f10088d;
                    Intrinsics.checkNotNullExpressionValue(uuid, "<get-FILE_TRANSFER_RECEIVE_UUID>(...)");
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB = jd.b(gatt, uuid);
                    if (bluetoothGattCharacteristicB != null) {
                        gatt.setCharacteristicNotification(bluetoothGattCharacteristicB, true);
                        BluetoothGattDescriptor descriptor2 = bluetoothGattCharacteristicB.getDescriptor(z6.f);
                        byte[] bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                        descriptor2.setValue(bArr);
                        if (gatt.writeDescriptor(descriptor2, bArr) != 0) {
                            h.h("TranFileReceiveController", "writeDescriptor fail");
                            a0Var.n();
                        }
                    }
                }
                break;
            default:
                super.onServicesDiscovered(gatt, i8);
                int i10 = b0.Q;
                h.b("TranFileSendController", "onServicesDiscovered : " + i8);
                if (m.e(2308)) {
                    m.c(2308);
                }
                b0 b0Var = (b0) obj;
                if (i8 != 0) {
                    b0Var.m();
                } else {
                    UUID uuid2 = z6.e;
                    Intrinsics.checkNotNullExpressionValue(uuid2, "<get-FILE_TRANSFER_SEND_UUID>(...)");
                    BluetoothGattCharacteristic bluetoothGattCharacteristicB2 = jd.b(gatt, uuid2);
                    if (bluetoothGattCharacteristicB2 != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            g5 g5Var = b0Var.f;
                            jSONObject.put("FileName", g5Var != null ? g5Var.f9747b : null);
                            g5 g5Var2 = b0Var.f;
                            jSONObject.put("FileSize", g5Var2 != null ? Long.valueOf(g5Var2.f9749d) : null);
                            g5 g5Var3 = b0Var.f;
                            jSONObject.put("FileCount", g5Var3 != null ? Integer.valueOf(g5Var3.f9748c) : null);
                            g5 g5Var4 = b0Var.f;
                            jSONObject.put("Port", g5Var4 != null ? Integer.valueOf(g5Var4.f) : null);
                            BluetoothAdapter bluetoothAdapter = b0Var.f4062n;
                            jSONObject.put("DeviceName", bluetoothAdapter != null ? bluetoothAdapter.getName() : null);
                            BluetoothAdapter bluetoothAdapter2 = b0Var.f4062n;
                            jSONObject.put("DeviceMac", bluetoothAdapter2 != null ? bluetoothAdapter2.getAddress() : null);
                            g5 g5Var5 = b0Var.f;
                            jSONObject.put("ConnectType", g5Var5 != null ? g5Var5.e : null);
                            a4 a4Var = b0Var.q;
                            if (a4Var != null) {
                                byte[] bArr2 = a4Var.f9647i;
                                bValueOf = Byte.valueOf(bArr2 != null ? bArr2[1] : (byte) 13);
                            } else {
                                bValueOf = null;
                            }
                            jSONObject.put("ProductSubType", bValueOf);
                            jSONObject.put("version", "1.0");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("request", "ignore");
                            String string = jSONObject2.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            String strP = b0.p(string);
                            if (strP == null || jSONObject.put("encrypt", strP) == null) {
                                jSONObject.put("plaintext", jSONObject2);
                            }
                            b0Var.f4063o = jSONObject.toString();
                            gatt.beginReliableWrite();
                            bluetoothGattCharacteristicB2.setValue(b0Var.f4063o);
                            String str = b0Var.f4063o;
                            Intrinsics.checkNotNull(str);
                            byte[] bytes = str.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            if (gatt.writeCharacteristic(bluetoothGattCharacteristicB2, bytes, 2) != 0) {
                                h.b("TranFileSendController", "writeCharacteristic failed");
                                b0Var.m();
                            }
                        } catch (JSONException e) {
                            int i11 = b0.Q;
                            String strN = o.d.n("JSONException", e.getMessage(), "TranFileSendController", "tag", "mes");
                            if (lb.f6529c >= 1) {
                                h0.a.x("TransConnect:", strN, "TranFileSendController", null);
                            }
                            b0Var.m();
                            return;
                        }
                    }
                }
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value, int i8) {
        Object obj = this.f8446b;
        switch (this.f8445a) {
            case 1:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicRead(gatt, characteristic, value, i8);
                if (i8 != 0) {
                    h.j("NearGattClient", "onCharacteristicRead received: " + i8);
                } else {
                    h.b("NearGattClient", "Read characteristic: " + characteristic.getUuid());
                }
                break;
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicRead(gatt, characteristic, value, i8);
                h0.a.u(i8, "onCharacteristicRead : ", "TranFileReceiveController");
                a0 a0Var = (a0) obj;
                if (i8 != 0) {
                    a0Var.n();
                } else {
                    a0Var.getClass();
                    if (Intrinsics.areEqual(characteristic.getUuid(), z6.f10088d)) {
                        Intrinsics.checkNotNullParameter(value, "data");
                        StringBuilder sb2 = new StringBuilder();
                        int length = value.length;
                        int iE = 0;
                        while (iE < length) {
                            byte b9 = value[iE];
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            iE = h0.a.e(new Object[]{Byte.valueOf(b9)}, 1, "0x%02X ", "format(...)", sb2, iE, 1);
                        }
                        String string = sb2.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        h.h("TranFileReceiveController", string);
                        if (value.length == 1 && value[0] == -16) {
                            h.h("TranFileReceiveController", "Remote is Not ready, message will send via notification later");
                        } else {
                            a0Var.s(value);
                        }
                    }
                }
                break;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicRead(gatt, characteristic, value, i8);
                int i9 = b0.Q;
                h0.a.C(i8, "onCharacteristicRead : ", "TranFileSendController");
                b0 b0Var = (b0) obj;
                if (i8 == 0) {
                    b0Var.getClass();
                    if (Intrinsics.areEqual(characteristic.getUuid(), z6.e)) {
                        Intrinsics.checkNotNullParameter(value, "data");
                        StringBuilder sb3 = new StringBuilder();
                        int length2 = value.length;
                        int iE2 = 0;
                        while (iE2 < length2) {
                            byte b10 = value[iE2];
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            iE2 = h0.a.e(new Object[]{Byte.valueOf(b10)}, 1, "0x%02X ", "format(...)", sb3, iE2, 1);
                        }
                        String string2 = sb3.toString();
                        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                        h.b("TranFileSendController", string2);
                        if (value.length == 1 && value[0] == -16) {
                            h.b("TranFileSendController", "PC BUSY");
                            if (!b0Var.p.isEmpty()) {
                                b0.n(b0Var, -3, 4, 384);
                            }
                            b0Var.o(false);
                            break;
                        } else if (value.length == 1 && value[0] == 16) {
                            gatt.setCharacteristicNotification(characteristic, true);
                            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(z6.f);
                            Intrinsics.checkNotNullExpressionValue(descriptor, "getDescriptor(...)");
                            byte[] bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                            descriptor.setValue(bArr);
                            if (gatt.writeDescriptor(descriptor, bArr) != 0) {
                                h.b("TranFileSendController", "writeDescriptor fail");
                                b0Var.m();
                            }
                            break;
                        }
                    }
                } else {
                    b0Var.m();
                    break;
                }
                break;
            default:
                super.onCharacteristicRead(gatt, characteristic, value, i8);
                break;
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value) {
        switch (this.f8445a) {
            case 1:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicChanged(gatt, characteristic, value);
                h.b("NearGattClient", "onCharacteristicChanged: " + characteristic.getUuid());
                if (Intrinsics.areEqual(characteristic.getUuid(), c6.e)) {
                    j jVar = (j) this.f8446b;
                    jVar.getClass();
                    jVar.f(new q(4, jVar, gatt, characteristic, value));
                    return;
                }
                return;
            case 2:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicChanged(gatt, characteristic, value);
                h.h("TranFileReceiveController", "onCharacteristicChanged : " + characteristic.getUuid());
                if (Intrinsics.areEqual(characteristic.getUuid(), z6.f10088d)) {
                    a0.j((a0) this.f8446b, value);
                    return;
                }
                return;
            case 3:
                Intrinsics.checkNotNullParameter(gatt, "gatt");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(value, "value");
                super.onCharacteristicChanged(gatt, characteristic, value);
                int i8 = b0.Q;
                h.b("TranFileSendController", "onCharacteristicChanged : " + characteristic.getUuid());
                if (Intrinsics.areEqual(characteristic.getUuid(), z6.e)) {
                    b0 b0Var = (b0) this.f8446b;
                    b0Var.getClass();
                    Intrinsics.checkNotNullParameter(value, "data");
                    StringBuilder sb2 = new StringBuilder();
                    boolean z2 = false;
                    int iE = 0;
                    for (int length = value.length; iE < length; length = length) {
                        byte b9 = value[iE];
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        iE = h0.a.e(new Object[]{Byte.valueOf(b9)}, 1, "0x%02X ", "format(...)", sb2, iE, 1);
                        z2 = z2;
                    }
                    boolean z3 = z2;
                    String string = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    h.b("TranFileSendController", string);
                    if (value.length == 1 && value[z3 ? 1 : 0] == -1) {
                        h.b("TranFileSendController", "PC REJECT");
                        if (!b0Var.p.isEmpty()) {
                            b0.n(b0Var, -3, 4, 384);
                        }
                        if (b0Var.c(b0Var.J)) {
                            b0Var.h(b0Var.J);
                        }
                        b0Var.f(b0Var.K);
                        return;
                    }
                    try {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(value, Charsets.UTF_8));
                            String string2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                            h.b("TranFileSendController", string2);
                            b0Var.f4070y = jSONObject.getString("Ssid");
                            b0Var.f4071z = jSONObject.getString("Pwd");
                            jSONObject.getInt("FilePort");
                            jSONObject.getInt("MessagePort");
                            if (!jSONObject.isNull("Bssid")) {
                                b0Var.A = jSONObject.getString("Bssid");
                            }
                            if (!jSONObject.isNull("Chan")) {
                                int i9 = jSONObject.getInt("Chan");
                                b0Var.B = i9;
                                if (i9 < 1 || ((15 <= i9 && i9 < 36) || i9 > 165)) {
                                    b0Var.B = z3 ? 1 : 0;
                                    h.j("TranFileSendController", "Invalid Channel number, force set to 0");
                                }
                            }
                            if (b0Var.f4054d == 3) {
                                h.b("TranFileSendController", "P2P connecting already, ignore this event");
                            } else {
                                b0Var.f4054d = 3;
                                b0Var.r(gatt);
                            }
                        } catch (JSONException e) {
                            String mes = "JSONException" + e.getMessage();
                            Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                            Intrinsics.checkNotNullParameter(mes, "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("TranFileSendController", "TransConnect:" + mes, null);
                            }
                        }
                        return;
                    } finally {
                        b0Var.o(z3);
                    }
                }
                return;
            default:
                super.onCharacteristicChanged(gatt, characteristic, value);
                return;
        }
    }
}
