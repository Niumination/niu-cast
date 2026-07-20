package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Build;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.welink.protocol.utils.ArrayUtil$ServicePort;
import com.welink.protocol.utils.DeviceData;
import com.welink.protocol.utils.DeviceInfo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import se.a4;
import se.b6;
import se.c1;
import se.c6;
import se.d1;
import se.e1;
import se.f1;
import se.g1;
import se.g5;
import se.h1;
import se.h4;
import se.h5;
import se.k4;
import se.k6;
import se.o4;
import se.s5;
import se.v5;
import se.z5;
import se.z6;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final se.k L = new se.k(c1.INSTANCE);
    public final d1 A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public List J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f4112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NearConnectionService$ScreenStateReceiver f4114d;
    public boolean e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h5 f4115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a4 f4116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f4117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k6 f4118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f4119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ne.f f4120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f4121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f4123o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f4124r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f4125s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f4127v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte[] f4128w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f4129x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Boolean f4131z;
    public Integer p = -1;
    public Integer q = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f4126t = -1;
    public Integer u = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final byte[] f4130y = new byte[6];
    public final lc.a K = new lc.a(this, 5);

    public g(Context context, z zVar) {
        boolean z2;
        String strReplace;
        byte[] bArrB;
        int i8 = 0;
        this.f4111a = context;
        this.f4112b = zVar;
        this.f4131z = Boolean.FALSE;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        g1 listener = new g1(this);
        h1 listener2 = new h1(this, i8);
        e1 listener3 = new e1(this);
        f1 listener4 = new f1(this, i8);
        we.h.b("NearConnectionService", "onCreate, context: " + context);
        d1 d1Var = new d1(this);
        this.A = d1Var;
        synchronized (d1Var) {
            z2 = d1Var.f10726a != null;
        }
        if (!z2) {
            we.h.c("NearConnectionService", "onCreate, Handler Thread not created", null);
        }
        synchronized (L) {
            String mes = "setAdapterService() - trying to set service to " + this;
            Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionService", "TransConnect:" + mes, null);
            }
        }
        we.h.j("NearConnectionService", "initBlescanTool, sdk version: 2.0.36-omicron-2025/09/08-20:00");
        UUID uuid = we.e.f10723a;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("DeviceUuidPrefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        String string = sharedPreferences.getString("device_uuid_property", "");
        if (string != null) {
            if (string.length() == 0) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("device_uuid_property", we.e.f10723a.toString());
                editorEdit.apply();
                we.h.h("DeviceUuidUtil", "Created new UUID: " + we.e.f10723a);
            } else {
                we.e.f10723a = UUID.fromString(string);
            }
        }
        ne.f fVar = new ne.f(context);
        this.f4120l = fVar;
        BluetoothAdapter bluetoothAdapter = fVar.f8196b;
        String address = bluetoothAdapter != null ? bluetoothAdapter.getAddress() : null;
        this.f4122n = address;
        o.d.z("Adapter Address is ", address, "NearConnectionService");
        String str = this.f4122n;
        if (str != null && (strReplace = StringsKt__StringsJVMKt.replace(str, ":", "", false)) != null && (bArrB = m3.q.b(strReplace)) != null) {
            m3.q.f(bArrB);
        }
        NearConnectionService$ScreenStateReceiver nearConnectionService$ScreenStateReceiver = new NearConnectionService$ScreenStateReceiver();
        nearConnectionService$ScreenStateReceiver.f3882a = this;
        this.f4114d = nearConnectionService$ScreenStateReceiver;
        we.h.b("NearConnectionService", "initFileTransferController");
        h4 h4Var = (h4) h4.q.b(context);
        a4 a4Var = (a4) a4.f9642j.a(context, h4Var);
        this.f4116h = a4Var;
        h5 h5Var = (h5) h5.f9773o.a(context, this);
        this.f4115g = h5Var;
        if (a4Var != null) {
            we.i executor = new we.i(d1Var);
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(listener3, "listener");
            Pair pair = TuplesKt.to(executor, listener3);
            LinkedHashSet linkedHashSet = a4Var.f9646h;
            if (!linkedHashSet.contains(pair)) {
                linkedHashSet.add(pair);
            }
        }
        if (h4Var != null) {
            we.i executor2 = new we.i(d1Var);
            Intrinsics.checkNotNullParameter(executor2, "executor");
            Intrinsics.checkNotNullParameter(listener2, "listener");
            we.h.b("NearP2pManager", "registerMonitoredListener: listener:" + listener2);
            ConcurrentHashMap.KeySetView monitoredListenerPairs = h4Var.f9768k;
            Intrinsics.checkNotNullExpressionValue(monitoredListenerPairs, "monitoredListenerPairs");
            synchronized (monitoredListenerPairs) {
                try {
                    Pair pair2 = TuplesKt.to(executor2, listener2);
                    if (!h4Var.f9768k.contains(pair2)) {
                        we.h.b("NearP2pManager", "registerMonitoredListener: monitoredListenerPairs add pair");
                        h4Var.f9768k.add(pair2);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        m mVar = (m) m.f4170t.b(context);
        this.f4117i = mVar;
        if (mVar != null) {
            we.i executor3 = new we.i(d1Var);
            Intrinsics.checkNotNullParameter(executor3, "executor");
            Intrinsics.checkNotNullParameter(listener4, "listener");
            Pair pair3 = TuplesKt.to(executor3, listener4);
            LinkedHashSet linkedHashSet2 = mVar.f4179m;
            if (!linkedHashSet2.contains(pair3)) {
                linkedHashSet2.add(pair3);
            }
        }
        this.f4118j = (k6) k6.f9842g.b(context);
        fVar.f8200h = h5Var;
        if (h5Var != null && h5Var.f9779j) {
            this.F = false;
        }
        if (h5Var != null && h5Var.f9780k) {
            this.G = false;
        }
        if (h5Var != null && h5Var.f9778i) {
            this.D = false;
        }
        if (h5Var != null && h5Var.f9781l) {
            this.E = false;
        }
        this.f4131z = h5Var != null ? Boolean.valueOf(h5Var.f9777h) : null;
        e();
        g(null, null);
        we.h.h("NearConnectionService", "mVendor Pid=" + this.f4123o);
        we.h.b("NearConnectionService", "gatt service init");
        a aVar = (a) a.f4027k.a(context, h4Var);
        this.f4119k = aVar;
        if (aVar != null) {
            we.i executor4 = new we.i(d1Var);
            Intrinsics.checkNotNullParameter(executor4, "executor");
            Intrinsics.checkNotNullParameter(listener3, "listener");
            Pair pair4 = TuplesKt.to(executor4, listener3);
            LinkedHashSet linkedHashSet3 = aVar.f4031h;
            if (!linkedHashSet3.contains(pair4)) {
                linkedHashSet3.add(pair4);
            }
        }
        d dVar = (d) d.f4092k.a(context, h4Var);
        this.f4121m = dVar;
        if (dVar != null) {
            we.i executor5 = new we.i(d1Var);
            Intrinsics.checkNotNullParameter(executor5, "executor");
            Intrinsics.checkNotNullParameter(listener3, "listener");
            Pair pair5 = TuplesKt.to(executor5, listener3);
            LinkedHashSet linkedHashSet4 = dVar.f4096h;
            if (!linkedHashSet4.contains(pair5)) {
                linkedHashSet4.add(pair5);
            }
        }
        BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
        we.i executor6 = new we.i(d1Var);
        Intrinsics.checkNotNullParameter(executor6, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Pair pair6 = TuplesKt.to(executor6, listener);
        LinkedHashSet linkedHashSet5 = ne.b.e;
        if (!linkedHashSet5.contains(pair6)) {
            linkedHashSet5.add(pair6);
        }
        if (Intrinsics.areEqual(this.f4131z, Boolean.TRUE)) {
            we.h.h("NearConnectionService", "Smart Config Enabled, start again");
            r(5);
        }
        String str2 = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm").format(LocalDateTime.now());
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        we.h.h("NearConnectionService", "Create Complete on " + str2);
        NotificationChannelCompat.Builder builder = new NotificationChannelCompat.Builder("near_connection_01", 3);
        builder.setName("near_connection_service_channel");
        builder.setDescription("near_connection_service_channel");
        builder.setLightsEnabled(true);
        builder.setLightColor(SupportMenu.CATEGORY_MASK);
        builder.setVibrationEnabled(true);
        builder.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        Intrinsics.checkNotNullExpressionValue(builder.build(), "build(...)");
    }

    public static final void a(g gVar, DeviceData deviceData, ConnectRequest connectRequest, int i8, NearDevice nearDevice) {
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_BLE_CONNECTED_EXCHANGE_REQUEST");
        intent.putExtra("com.welink.service.EXTRA_DEVICE_DATA", deviceData);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_STATE", i8);
        intent.putExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST", connectRequest);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        gVar.f4112b.j(intent);
    }

    public static final void b(g gVar, WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection collection) {
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_DEVICE_CONNECTED");
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_GROUP_INFO", wifiP2pGroup);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_INFO", wifiP2pInfo);
        intent.putParcelableArrayListExtra("com.welink.service.EXTRA_WIFI_P2P_CLIENT_LIST", new ArrayList<>(collection));
        gVar.f4112b.j(intent);
    }

    public static boolean j(DeviceInfo deviceInfo, ScanResult scanResult) {
        BluetoothDevice device;
        String name;
        if (deviceInfo == null || scanResult == null || scanResult.getDevice() == null) {
            Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
            Intrinsics.checkNotNullParameter("Invalid device name, deviceInfo or result is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionService", "TransConnect:Invalid device name, deviceInfo or result is null", null);
            }
            return false;
        }
        BluetoothDevice device2 = scanResult.getDevice();
        if ((device2 != null ? device2.getName() : null) == null || !((device = scanResult.getDevice()) == null || (name = device.getName()) == null || name.length() != 0)) {
            Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
            Intrinsics.checkNotNullParameter("Invalid device name, device name is null or empty", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionService", "TransConnect:Invalid device name, device name is null or empty", null);
            }
            return false;
        }
        String str = deviceInfo.p;
        if (str != null) {
            BluetoothDevice device3 = scanResult.getDevice();
            if (Intrinsics.areEqual(str, device3 != null ? device3.getAddress() : null)) {
                Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
                Intrinsics.checkNotNullParameter("Invalid device name, device name is same as device address", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearConnectionService", "TransConnect:Invalid device name, device name is same as device address", null);
                }
                return false;
            }
        }
        BluetoothDevice device4 = scanResult.getDevice();
        String name2 = device4 != null ? device4.getName() : null;
        BluetoothDevice device5 = scanResult.getDevice();
        we.h.b("NearConnectionService", "Valid device name, device name is " + name2 + ", address is " + (device5 != null ? device5.getAddress() : null));
        return true;
    }

    public final void A() {
        Object systemService = this.f4111a.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        boolean zIsWifiEnabled = ((WifiManager) systemService).isWifiEnabled();
        k6 k6Var = this.f4118j;
        if (zIsWifiEnabled && k6Var != null) {
            we.h.a("stopScan");
            if (k6Var.e) {
                Context context = k6Var.f9843a;
                if (context != null) {
                    context.unregisterReceiver(k6Var.f);
                }
                k6Var.e = false;
            }
        }
        if (k6Var == null || !k6Var.e) {
            return;
        }
        Context context2 = k6Var.f9843a;
        if (context2 != null) {
            context2.unregisterReceiver(k6Var.f);
        }
        k6Var.e = false;
    }

    public final void c() {
        if (!this.f) {
            we.h.j("NearConnectionService", "Screen is off, ignore restartScanAndAdvertise");
            return;
        }
        if (!Intrinsics.areEqual(this.f4131z, Boolean.FALSE)) {
            o();
            return;
        }
        Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
        Intrinsics.checkNotNullParameter("smart connect disabled, ignore restartScanAndAdvertise", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearConnectionService", "TransConnect:smart connect disabled, ignore restartScanAndAdvertise", null);
        }
    }

    public final void d() {
        Integer numValueOf;
        Integer num = this.p;
        if (num != null && num.intValue() == -1) {
            h5 h5Var = this.f4115g;
            if (h5Var != null) {
                h0.a.C(h5Var.f9776g, "Got Scenario: ", "TranConnectionController");
                numValueOf = Integer.valueOf(h5Var.f9776g);
            } else {
                numValueOf = null;
            }
            this.p = numValueOf;
        }
        Integer num2 = this.p;
        if (num2 != null && num2.intValue() == -1) {
            this.p = 0;
        }
        we.h.h("NearConnectionService", "Scenario=" + this.p);
    }

    public final void e() {
        String str;
        String str2;
        if (this.f4123o == null) {
            h5 h5Var = this.f4115g;
            if (h5Var != null) {
                o.d.z("Got PidInfo: ", h5Var.f, "TranConnectionController");
                str2 = h5Var.f;
            } else {
                str2 = null;
            }
            this.f4123o = str2;
        }
        String str3 = this.f4123o;
        if (str3 == null || Intrinsics.compare(str3.length(), 18) == -1) {
            String str4 = Build.DEVICE;
            Map map = h.f4132a;
            String brand = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(brand, "BRAND");
            Intrinsics.checkNotNullParameter(brand, "brand");
            Locale locale = Locale.ENGLISH;
            if (StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Tecno", locale, "toLowerCase(...)"), true)) {
                str = "03";
            } else if (StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Infinix", locale, "toLowerCase(...)"), true)) {
                str = "04";
            } else {
                str = StringsKt__StringsKt.contains(a1.a.t(locale, "ENGLISH", brand, locale, "toLowerCase(...)"), (CharSequence) a1.a.t(locale, "ENGLISH", "Itel", locale, "toLowerCase(...)"), true) ? "02" : "FF";
            }
            String strJ = h0.a.j("060D00", str, "0001100001");
            we.h.b("NearConnectionService", h0.a.l("getAdvPid:", strJ, ",productType:06,productSubtype:0D,reserver:00,productBrand:", str, ",vendorBrand:00,wirelesssType:01,protocolVersion:10,productEncode:0001"));
            this.f4123o = strJ;
        }
        String str5 = this.f4123o;
        byte[] bArrB = str5 != null ? m3.q.b(str5) : null;
        Byte bValueOf = bArrB != null ? Byte.valueOf(bArrB[1]) : null;
        if (bValueOf != null && (bValueOf.byteValue() == 13 || bValueOf.byteValue() == 18 || bValueOf.byteValue() == 15 || bValueOf.byteValue() == 21)) {
            this.f4113c = true;
        }
        a aVar = this.f4119k;
        if (aVar != null) {
            String string = Arrays.toString(bArrB);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            we.h.b("NearBleManager", "setVendorPid: " + string);
            aVar.f4033j = bArrB;
        }
        m mVar = this.f4117i;
        if (mVar != null) {
            String string2 = Arrays.toString(bArrB);
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            we.h.b("NearLanManager", "setVendorPid: " + string2);
            mVar.f4172d = bArrB;
        }
        a4 a4Var = this.f4116h;
        if (a4Var != null) {
            String string3 = Arrays.toString(bArrB);
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            we.h.b("NearLaptopManager", "setVendorPid: " + string3);
            a4Var.f9647i = bArrB;
        }
        String mes = "vendorId=" + this.f4123o + " is Gatt " + this.f4113c;
        Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", mes, "NearConnectionService", null);
        }
    }

    public final void f(NearDevice nearDevice, int i8) {
        WirelessDevice wirelessDevice = nearDevice != null ? nearDevice.f3896s : null;
        if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
            return;
        }
        BluetoothDevice bluetoothDevice = ((WirelessDevice.Bluetooth) wirelessDevice).f4011d;
        if (bluetoothDevice != null) {
            p(new DeviceData(we.c.BLUETOOTH_LE, bluetoothDevice.getName(), null, bluetoothDevice, 240), nearDevice, PointerIconCompat.TYPE_ALIAS, i8);
            return;
        }
        Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
        Intrinsics.checkNotNullParameter("disconnectNotification error, invalid bluetooth device", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearConnectionService", "TransConnect:disconnectNotification error, invalid bluetooth device", null);
        }
    }

    public final void g(Integer num, byte[] bArr) {
        int i8;
        BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
        int i9 = 11;
        if ((num != null && num.intValue() == 0) || (bArr != null && ArraysKt.contains(bArr, (byte) 0))) {
            if (num != null && num.intValue() == 0) {
                we.h.b("NearConnectionService", "ScreeCast: Advertise available single screen cast");
            } else {
                we.h.b("NearConnectionService", "ScreeCast: Advertise available misc screen cast");
                i9 = 6;
            }
            i8 = i9;
        } else {
            i8 = 18;
            if (num != null && num.intValue() == 1) {
                h0.a.C(18, "AirDrop: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 8) {
                h0.a.C(18, "New AirCast: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 10) {
                h0.a.C(18, "AudioSink: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 5) {
                h0.a.C(18, "HandoffData: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 4) {
                h0.a.C(18, "ClipboardShare: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 11) {
                h0.a.C(18, "KeyboardMouseShare: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 12) {
                h0.a.C(18, "CallShare: Advertise available length=", "NearConnectionService");
            } else if (num != null && num.intValue() == 13) {
                h0.a.C(18, "CameraShare: Advertise available length=", "NearConnectionService");
            } else {
                h0.a.C(18, "Other: Advertise available length=", "NearConnectionService");
            }
        }
        Integer num2 = this.p;
        if ((num2 == null || num2.intValue() != 0) && (bArr == null || !ArraysKt.contains(bArr, (byte) 0))) {
            i8 -= 2;
        }
        String str = this.f4129x;
        if (str != null) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            Integer numValueOf = Integer.valueOf(bytes.length);
            Intrinsics.checkNotNull(numValueOf);
            if (numValueOf.intValue() <= i8) {
                return;
            }
        }
        String string = Settings.Global.getString(this.f4111a.getContentResolver(), "device_name");
        Intrinsics.checkNotNull(string);
        this.f4129x = m3.q.a(i8, string);
    }

    /* JADX WARN: Code duplicated, block: B:293:0x0492 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:294:0x0494  */
    /* JADX WARN: Code duplicated, block: B:311:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:313:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:393:0x0635 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:394:0x0637  */
    /* JADX WARN: Code duplicated, block: B:411:0x0670 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:412:0x0672  */
    /* JADX WARN: Code duplicated, block: B:591:0x08d1 A[PHI: r4
      0x08d1: PHI (r4v67 java.lang.String) = (r4v64 java.lang.String), (r4v65 java.lang.String), (r4v68 java.lang.String) binds: [B:601:0x08f4, B:596:0x08e3, B:589:0x08ce] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:609:0x091c  */
    /* JADX WARN: Code duplicated, block: B:611:0x092e  */
    /* JADX WARN: Code duplicated, block: B:614:0x0935 A[PHI: r4
      0x0935: PHI (r4v62 java.lang.String) = (r4v59 java.lang.String), (r4v60 java.lang.String), (r4v63 java.lang.String) binds: [B:624:0x0958, B:619:0x0947, B:612:0x0932] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:616:0x0939  */
    /* JADX WARN: Code duplicated, block: B:618:0x0943  */
    /* JADX WARN: Code duplicated, block: B:621:0x094a  */
    /* JADX WARN: Code duplicated, block: B:623:0x0954  */
    /* JADX WARN: Code duplicated, block: B:626:0x095b  */
    /* JADX WARN: Code duplicated, block: B:629:0x0963  */
    /* JADX WARN: Code duplicated, block: B:631:0x097a  */
    /* JADX WARN: Code duplicated, block: B:804:0x0c02  */
    /* JADX WARN: Code duplicated, block: B:810:0x0c17  */
    /* JADX WARN: Code duplicated, block: B:822:0x0c46  */
    /* JADX WARN: Code duplicated, block: B:824:0x0c4b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void i(Intent intent) {
        String stringExtra;
        String string;
        String string2;
        List<ArrayUtil$ServicePort> list;
        Integer numU;
        String str;
        String f3883a;
        String str2;
        String f3883a2;
        Integer numT;
        Integer numU2;
        Integer numU3;
        boolean z2;
        m mVar = this.f4117i;
        a aVar = this.f4119k;
        h5 h5Var = this.f4115g;
        byte[] bArr = this.f4130y;
        we.h.b("NearConnectionService", "handleConnectionChangeEvent: " + intent.getAction());
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            d dVar = this.f4121m;
            a4 a4Var = this.f4116h;
            int iE = 0;
            switch (iHashCode) {
                case -2078410075:
                    if (action.equals("com.android.bluetooth.btservice.action.STATE_CHANGED") && (stringExtra = intent.getStringExtra("action")) != null && Intrinsics.areEqual("com.android.bluetooth.btservice.action.STATE_CHANGED", stringExtra)) {
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                        if (intExtra == 10) {
                            x(intent.getIntExtra("smart_state", 0));
                            return;
                        } else {
                            if (intExtra != 12) {
                                return;
                            }
                            r(intent.getIntExtra("smart_state", 1));
                            return;
                        }
                    }
                    return;
                case -2003286917:
                    if (action.equals("com.welink.service.ACTION_BLE_ADV_VENDOR_PID")) {
                        we.h.b("NearConnectionService", "ACTION_BLE_ADV_VENDOR_PID");
                        String stringExtra2 = intent.getStringExtra("com.welink.service.EXTRA_BLE_ADV_VENDOR_PID");
                        if (stringExtra2 != null) {
                            Intrinsics.checkNotNull(h5Var);
                            h5Var.k(stringExtra2);
                            this.f4123o = stringExtra2;
                            e();
                            return;
                        }
                        return;
                    }
                    return;
                case -1867072215:
                    if (action.equals("com.welink.protocol.nfbd.action.DISCONNECT_P2P_DEVICE") && a4Var != null) {
                        a4Var.l();
                        Unit unit = Unit.INSTANCE;
                        return;
                    }
                    return;
                case -1733219186:
                    if (action.equals("com.welink.protocol.nfbd.action.STOP_LAN_DISCOVERY")) {
                        this.E = true;
                        this.f4128w = null;
                        if (h5Var != null) {
                            h5Var.f9781l = false;
                        }
                        y();
                        return;
                    }
                    return;
                case -1644135453:
                    if (action.equals("com.welink.protocol.nfbd.action.START_LAN_ADVERTISE")) {
                        int intExtra2 = intent.getIntExtra("com.welink.protocol.nfbd.extra.service", -1);
                        if ((intExtra2 < 0 || intExtra2 >= 14) && intExtra2 != 251) {
                            this.f4126t = 251;
                        } else {
                            this.f4126t = Integer.valueOf(intExtra2);
                        }
                        this.f4127v = intent.getByteArrayExtra("com.welink.protocol.nfbd.extra.service_data");
                        this.u = Integer.valueOf(intent.getIntExtra("com.welink.protocol.nfbd.extra.subcapability", 0));
                        String str3 = this.f4123o;
                        if (str3 != null) {
                            BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
                            byte[] bArrM = ne.b.m();
                            String strH = ne.b.h(this.f4111a);
                            int iIntValue = this.f4126t.intValue();
                            byte[] bArr2 = this.f4127v;
                            Integer num = this.u;
                            m mVar2 = this.f4117i;
                            if (mVar2 != null) {
                                mVar2.r(str3, bArrM, strH, iIntValue, bArr2, num);
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                        this.D = false;
                        if (h5Var != null) {
                            h5Var.f9778i = true;
                            Unit unit3 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case -1511357481:
                    if (action.equals("com.welink.service.ACTION_BLE_ADV_SCENARIO")) {
                        we.h.b("NearConnectionService", "ACTION_BLE_ADV_SCENARIO");
                        int intExtra3 = intent.getIntExtra("com.welink.service.EXTRA_BLE_ADV_SCENARIO", -1);
                        if (intExtra3 != -1) {
                            if (h5Var != null) {
                                h5Var.l(intExtra3);
                                Unit unit4 = Unit.INSTANCE;
                            }
                            this.p = Integer.valueOf(intExtra3);
                            d();
                            return;
                        }
                        return;
                    }
                    return;
                case -1178831460:
                    if (action.equals("com.welink.protocol.nfbd.action.STOP_SCAN_DEVICE")) {
                        if (h5Var != null) {
                            h5Var.n();
                            Unit unit5 = Unit.INSTANCE;
                        }
                        this.G = true;
                        q(false);
                        this.f4125s = null;
                        z();
                        return;
                    }
                    return;
                case -1074931348:
                    if (action.equals("com.welink.protocol.nfbd.action.START_LAN_DISCOVERY")) {
                        this.E = false;
                        byte[] byteArrayExtra = intent.getByteArrayExtra("com.welink.protocol.nfbd.extra.service");
                        this.f4128w = byteArrayExtra;
                        if (h5Var != null) {
                            h5Var.f9781l = true;
                        }
                        t(byteArrayExtra);
                        return;
                    }
                    return;
                case -816135686:
                    if (!action.equals("com.welink.protocol.nfbd.action.START_SCAN_DEVICE")) {
                        return;
                    }
                    break;
                case -703436582:
                    if (action.equals("com.welink.service.ACTION_SET_ADVERTISING_UNIQUE_ID")) {
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("com.welink.service.EXTRA_ADVERTISING_UNIQUE_ID");
                        if (byteArrayExtra2 != null) {
                            Intrinsics.checkNotNullParameter(byteArrayExtra2, "<this>");
                            StringBuilder sb2 = new StringBuilder();
                            int length = byteArrayExtra2.length;
                            int iE2 = 0;
                            while (iE2 < length) {
                                byte b9 = byteArrayExtra2[iE2];
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                iE2 = h0.a.e(new Object[]{Byte.valueOf(b9)}, 1, "%02x ", "format(...)", sb2, iE2, 1);
                            }
                            string = sb2.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        } else {
                            string = null;
                        }
                        o.d.z("ACTION_SET_ADVERTISING_UNIQUE_ID: ", string, "NearConnectionService");
                        if (byteArrayExtra2 == null || byteArrayExtra2.length != 6) {
                            if (byteArrayExtra2 != null) {
                                Intrinsics.checkNotNullParameter(byteArrayExtra2, "<this>");
                                StringBuilder sb3 = new StringBuilder();
                                int length2 = byteArrayExtra2.length;
                                while (iE < length2) {
                                    byte b10 = byteArrayExtra2[iE];
                                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                    iE = h0.a.e(new Object[]{Byte.valueOf(b10)}, 1, "%02x ", "format(...)", sb3, iE, 1);
                                }
                                string2 = sb3.toString();
                                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                            } else {
                                string2 = null;
                            }
                            we.h.c("NearConnectionService", "Invalid advertising unique id, " + string2, null);
                            return;
                        }
                        ArraysKt___ArraysJvmKt.fill$default(bArr, (byte) 0, 0, 0, 6, (Object) null);
                        ArraysKt.copyInto(byteArrayExtra2, bArr, 0, 0, 6);
                        BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
                        ne.b.w(bArr);
                        Intrinsics.checkNotNullParameter(bArr, "<this>");
                        StringBuilder sb4 = new StringBuilder();
                        int length3 = bArr.length;
                        while (iE < length3) {
                            byte b11 = bArr[iE];
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            iE = h0.a.e(new Object[]{Byte.valueOf(b11)}, 1, "%02x ", "format(...)", sb4, iE, 1);
                        }
                        String string3 = sb4.toString();
                        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                        we.h.b("NearConnectionService", "Set advertising unique id: " + string3);
                        return;
                    }
                    return;
                case -680231159:
                    if (action.equals("com.welink.service.ACTION_SET_SERVER_PORT")) {
                        we.h.b("NearConnectionService", "ACTION_SET_SERVER_PORT");
                        int intExtra4 = intent.getIntExtra("com.welink.service.EXTRA_MSG_PORT", 0);
                        int intExtra5 = intent.getIntExtra("com.welink.service.EXTRA_DATA_PORT", 0);
                        if ((intExtra4 == 0 && intExtra5 == 0) || a4Var == null) {
                            return;
                        }
                        Unit unit6 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case -672751838:
                    if (action.equals("com.welink.protocol.nfbd.action.NOTIFY_P2P_DISCONNECT")) {
                        int intExtra6 = intent.getIntExtra("com.welink.protocol.nfbd.extra.type", 0);
                        h0.a.u(intExtra6, "Get P2p disconnect event: ", "NearConnectionService");
                        if (intExtra6 != 0 && intExtra6 != 1 && intExtra6 != 2 && intExtra6 != 3) {
                            h0.a.C(intExtra6, "P2p disconnect unknown event: ", "NearConnectionService");
                            Unit unit7 = Unit.INSTANCE;
                            return;
                        }
                        we.h.b("NearConnectionService", "P2p disconnect Successfully");
                        if (a4Var != null) {
                            a4Var.k(intExtra6);
                            Unit unit8 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case -665170681:
                    if (!action.equals("com.welink.protocol.nfbd.action.RESUME_SCAN_DEVICE")) {
                        return;
                    }
                    break;
                case -613852395:
                    if (action.equals("com.welink.protocol.nfbd.action.ADV_PARAMS_UPDATE")) {
                        we.h.b("NearConnectionService", "ACTION_ADV_PARAMS_UPDATE");
                        int intExtra7 = intent.getIntExtra("com.welink.protocol.nfbd.extra.event", -1);
                        if (intExtra7 == 3) {
                            this.f4123o = null;
                            e();
                            Unit unit9 = Unit.INSTANCE;
                            return;
                        } else if (intExtra7 == 4) {
                            this.f4129x = null;
                            g(null, null);
                            Unit unit10 = Unit.INSTANCE;
                            return;
                        } else if (intExtra7 != 6) {
                            we.h.b("NearConnectionService", "Unknown Update BLE params event, ignore");
                            Unit unit11 = Unit.INSTANCE;
                            return;
                        } else {
                            this.p = -1;
                            d();
                            Unit unit12 = Unit.INSTANCE;
                            return;
                        }
                    }
                    return;
                case -278745456:
                    if (action.equals("com.welink.protocol.nfbd.action.RECEIVE_FILE_DECLINE")) {
                        we.h.b("NearConnectionService", "ACTION_RECEIVE_FILE_DECLINE");
                        NearDevice nearDevice = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int intExtra8 = intent.getIntExtra("com.welink.service.EXTRA_REASON_CODE", 0);
                        int intExtra9 = intent.getIntExtra("com.welink.protocol.nfbd.extra.scenario", -1);
                        if (intExtra9 == 0) {
                            Integer numValueOf = nearDevice != null ? Integer.valueOf(nearDevice.getF3890k()) : null;
                            if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 12)) {
                                if (a4Var != null) {
                                    a4Var.p();
                                    return;
                                }
                                return;
                            } else if (numValueOf == null || numValueOf.intValue() != 14) {
                                we.h.c("NearConnectionService", "Unknown Wireless Type for accept", null);
                                Unit unit13 = Unit.INSTANCE;
                                return;
                            } else if (nearDevice.s() == null) {
                                we.h.c("NearConnectionService", "Reject notify Invalid device address, LAN", null);
                                Unit unit14 = Unit.INSTANCE;
                                return;
                            } else {
                                if (mVar != null) {
                                    mVar.q(nearDevice);
                                    Unit unit15 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        if (intExtra9 != 1 && intExtra9 != 4 && intExtra9 != 5 && intExtra9 != 8) {
                            if (intExtra9 != 251) {
                                switch (intExtra9) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        we.h.c("NearConnectionService", "Reject notify Unknown Scenario", null);
                                        Unit unit16 = Unit.INSTANCE;
                                        break;
                                }
                                return;
                            }
                            Integer numValueOf2 = nearDevice != null ? Integer.valueOf(nearDevice.getF3890k()) : null;
                            if ((numValueOf2 != null && numValueOf2.intValue() == 0) || (numValueOf2 != null && numValueOf2.intValue() == 12)) {
                                if (nearDevice.getF3883a() == null) {
                                    we.h.c("NearConnectionService", "Reject notify Invalid device address, LE BT", null);
                                    Unit unit17 = Unit.INSTANCE;
                                    return;
                                } else {
                                    if (aVar != null) {
                                        aVar.w(nearDevice, intExtra8);
                                        Unit unit18 = Unit.INSTANCE;
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (numValueOf2 != null && numValueOf2.intValue() == 1) {
                                if (nearDevice.getF3883a() == null) {
                                    we.h.c("NearConnectionService", "Reject notify Invalid device address, classic BT", null);
                                    Unit unit19 = Unit.INSTANCE;
                                    return;
                                } else {
                                    if (dVar != null) {
                                        dVar.v(nearDevice, intExtra8);
                                        Unit unit20 = Unit.INSTANCE;
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (numValueOf2 == null || numValueOf2.intValue() != 14) {
                                we.h.c("NearConnectionService", "Reject notify Unknown Wireless Type for reject", null);
                                Unit unit21 = Unit.INSTANCE;
                                return;
                            } else if (nearDevice.s() == null) {
                                we.h.c("NearConnectionService", "Reject notify Invalid device address, LAN", null);
                                Unit unit22 = Unit.INSTANCE;
                                return;
                            } else {
                                if (mVar != null) {
                                    mVar.q(nearDevice);
                                    Unit unit23 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        Integer numValueOf3 = nearDevice != null ? Integer.valueOf(nearDevice.getF3890k()) : null;
                        if ((numValueOf3 != null && numValueOf3.intValue() == 0) || (numValueOf3 != null && numValueOf3.intValue() == 12)) {
                            if (nearDevice.getF3883a() == null) {
                                we.h.c("NearConnectionService", "Reject notify Invalid device address, LE BT", null);
                                Unit unit24 = Unit.INSTANCE;
                                return;
                            } else {
                                if (aVar != null) {
                                    aVar.w(nearDevice, intExtra8);
                                    Unit unit25 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        if (numValueOf3 != null && numValueOf3.intValue() == 1) {
                            if (nearDevice.getF3883a() == null) {
                                we.h.c("NearConnectionService", "Reject notify Invalid device address, classic BT", null);
                                Unit unit26 = Unit.INSTANCE;
                                return;
                            } else {
                                if (dVar != null) {
                                    dVar.v(nearDevice, intExtra8);
                                    Unit unit27 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        if (numValueOf3 == null || numValueOf3.intValue() != 14) {
                            we.h.c("NearConnectionService", "Reject notify Unknown Wireless Type for reject", null);
                            Unit unit28 = Unit.INSTANCE;
                            return;
                        } else if (nearDevice.s() == null) {
                            we.h.c("NearConnectionService", "Reject notify Invalid device address, LAN", null);
                            Unit unit29 = Unit.INSTANCE;
                            return;
                        } else {
                            if (mVar != null) {
                                mVar.q(nearDevice);
                                Unit unit30 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case -275683401:
                    if (action.equals("com.welink.protocol.nfbd.action.NOTIFY_QRSCAN_CONNECT_DEVICE")) {
                        we.h.b("NearConnectionService", "ACTION_NOTIFY_QRSCAN_CONNECT_DEVICE");
                        NearDevice device = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int e = device != null ? device.getE() : 0;
                        if (device == null) {
                            we.h.c("NearConnectionService", "P2P QR/NFC connect error, invalid device address", null);
                            return;
                        }
                        if (e == 0) {
                            we.h.b("NearConnectionService", "P2P QR/NFC connect for Screen Cast");
                            String stringExtra3 = intent.getStringExtra("SSID");
                            String stringExtra4 = intent.getStringExtra("PWD");
                            String stringExtra5 = intent.getStringExtra("BSSID");
                            String str4 = stringExtra5 == null ? "02:00:00:00:00:00" : stringExtra5;
                            int intExtra10 = intent.getIntExtra("CHAN", 0);
                            if (a4Var != null) {
                                se.k kVar = a4.f9642j;
                                Intrinsics.checkNotNullParameter(device, "device");
                                int i8 = device.p;
                                long j8 = WorkRequest.MIN_BACKOFF_MILLIS;
                                if (i8 != 2) {
                                    o4 o4Var = a4Var.e;
                                    if (o4Var != null) {
                                        Intrinsics.checkNotNullParameter(device, "device");
                                        o4Var.f(new k4(o4Var, device, stringExtra3, stringExtra4, intExtra10, str4, j8));
                                    }
                                } else {
                                    o4 o4Var2 = a4Var.f;
                                    if (o4Var2 != null) {
                                        Intrinsics.checkNotNullParameter(device, "device");
                                        o4Var2.f(new k4(o4Var2, device, stringExtra3, stringExtra4, intExtra10, str4, j8));
                                    }
                                }
                                Unit unit31 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        if (e != 1 && e != 4 && e != 5 && e != 8 && e != 251) {
                            switch (e) {
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    break;
                                default:
                                    we.h.c("NearConnectionService", "Unknown Service Type", null);
                                    Unit unit32 = Unit.INSTANCE;
                                    break;
                            }
                            return;
                        }
                        we.h.b("NearConnectionService", "P2P QR/NFC connect for Parcel Drop or Air Cast or ALL");
                        String stringExtra6 = intent.getStringExtra("SSID");
                        String stringExtra7 = intent.getStringExtra("PWD");
                        String stringExtra8 = intent.getStringExtra("BSSID");
                        String str5 = stringExtra8 == null ? "02:00:00:00:00:00" : stringExtra8;
                        int intExtra11 = intent.getIntExtra("CHAN", 0);
                        long longExtra = intent.getLongExtra("TIMEOUT", WorkRequest.MIN_BACKOFF_MILLIS);
                        if (a4Var != null) {
                            Intrinsics.checkNotNullParameter(device, "device");
                            if (device.p != 2) {
                                o4 o4Var3 = a4Var.e;
                                if (o4Var3 != null) {
                                    Intrinsics.checkNotNullParameter(device, "device");
                                    o4Var3.f(new k4(o4Var3, device, stringExtra6, stringExtra7, intExtra11, str5, longExtra));
                                }
                            } else {
                                o4 o4Var4 = a4Var.f;
                                if (o4Var4 != null) {
                                    Intrinsics.checkNotNullParameter(device, "device");
                                    o4Var4.f(new k4(o4Var4, device, stringExtra6, stringExtra7, intExtra11, str5, longExtra));
                                }
                            }
                            Unit unit33 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case -168062048:
                    if (action.equals("com.welink.protocol.nfbd.action.START_ADV_DEVICE")) {
                        we.h.b("NearConnectionService", "ACTION_START_ADV_DEVICE");
                        this.F = false;
                        if (h5Var != null) {
                            h5Var.f9779j = true;
                            Unit unit34 = Unit.INSTANCE;
                        }
                        int intExtra12 = intent.getIntExtra("com.welink.protocol.nfbd.extra.scenario", -1);
                        this.f4124r = intent.getByteArrayExtra("com.welink.protocol.nfbd.extra.service_data");
                        intent.getIntArrayExtra("com.welink.protocol.nfbd.extra.service_private_data");
                        if ((intExtra12 < 0 || intExtra12 >= 14) && intExtra12 != 251) {
                            this.p = 251;
                            Unit unit35 = Unit.INSTANCE;
                        } else {
                            this.p = Integer.valueOf(intExtra12);
                            if (h5Var != null) {
                                h5Var.l(intExtra12);
                                Unit unit36 = Unit.INSTANCE;
                            }
                        }
                        this.q = Integer.valueOf(intent.getIntExtra("com.welink.protocol.nfbd.extra.subcapability", 0));
                        s(this.f4123o);
                        return;
                    }
                    return;
                case -144388414:
                    if (action.equals("com.welink.service.ACTION_SET_ADVERTISING_SERVICE_AND_PORT")) {
                        Parcelable[] parcelableArr = (Parcelable[]) intent.getParcelableArrayExtra("com.welink.service.EXTRA_ADVERTISING_SERVICE_AND_PORT", ArrayUtil$ServicePort.class);
                        if (parcelableArr != null) {
                            ArrayList arrayList = new ArrayList();
                            int length4 = parcelableArr.length;
                            while (iE < length4) {
                                Parcelable parcelable = parcelableArr[iE];
                                if (parcelable instanceof ArrayUtil$ServicePort) {
                                    arrayList.add(parcelable);
                                }
                                iE++;
                            }
                            list = CollectionsKt.toList(arrayList);
                        } else {
                            list = null;
                        }
                        ArrayList<Pair> arrayList2 = new ArrayList();
                        if (list != null) {
                            for (ArrayUtil$ServicePort arrayUtil$ServicePort : list) {
                                arrayList2.add(new Pair(arrayUtil$ServicePort.getF4211a(), Integer.valueOf(arrayUtil$ServicePort.getF4212b())));
                            }
                            Unit unit37 = Unit.INSTANCE;
                        }
                        if (arrayList2.size() > 0) {
                            if (!arrayList2.isEmpty()) {
                                for (Pair pair : arrayList2) {
                                    if (((CharSequence) pair.getFirst()).length() <= 0 || ((Number) pair.getSecond()).intValue() <= 0) {
                                        return;
                                    }
                                }
                            }
                            this.J = CollectionsKt.toList(arrayList2);
                            if (mVar != null) {
                                mVar.o(CollectionsKt.toList(arrayList2));
                                Unit unit38 = Unit.INSTANCE;
                            }
                            if (aVar != null) {
                                aVar.u(CollectionsKt.toList(arrayList2));
                                Unit unit39 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case -102508283:
                    if (action.equals("com.welink.service.ACTION_P2P_INVITATION_ACCEPTED")) {
                        we.h.b("NearConnectionService", "ACTION_P2P_INVITATION_ACCEPTED");
                        NearDevice device2 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int e4 = device2 != null ? device2.getE() : 0;
                        if (device2 == null) {
                            we.h.c("NearConnectionService", "P2P Invitation Accepted error, invalid device address", null);
                            return;
                        }
                        if (e4 == 0) {
                            ConnectRequest connectRequest = (ConnectRequest) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST", ConnectRequest.class));
                            we.h.b("NearConnectionService", "P2P Invitation Accepted for Screen Cast");
                            int f3890k = device2.getF3890k();
                            if (f3890k != 0) {
                                switch (f3890k) {
                                    case 10:
                                    case 11:
                                        if (a4Var != null) {
                                            Unit unit40 = Unit.INSTANCE;
                                        }
                                        if (a4Var != null) {
                                            String f3868j = connectRequest != null ? connectRequest.getF3868j() : null;
                                            String f3869k = connectRequest != null ? connectRequest.getF3869k() : null;
                                            String f3870l = connectRequest != null ? connectRequest.getF3870l() : null;
                                            int f3871m = connectRequest != null ? connectRequest.getF3871m() : 0;
                                            se.k kVar2 = a4.f9642j;
                                            Intrinsics.checkNotNullParameter(device2, "device");
                                            int i9 = device2.p;
                                            long j10 = WorkRequest.MIN_BACKOFF_MILLIS;
                                            if (i9 != 2) {
                                                o4 o4Var5 = a4Var.e;
                                                if (o4Var5 != null) {
                                                    Intrinsics.checkNotNullParameter(device2, "device");
                                                    o4Var5.f(new k4(o4Var5, device2, f3868j, f3869k, f3871m, f3870l, j10));
                                                }
                                            } else {
                                                o4 o4Var6 = a4Var.f;
                                                if (o4Var6 != null) {
                                                    Intrinsics.checkNotNullParameter(device2, "device");
                                                    o4Var6.f(new k4(o4Var6, device2, f3868j, f3869k, f3871m, f3870l, j10));
                                                }
                                            }
                                            Unit unit41 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 12:
                                        break;
                                    default:
                                        we.h.c("NearConnectionService", "P2P Invitation Accepted error, Unknown Wireless Type", null);
                                        Unit unit42 = Unit.INSTANCE;
                                        break;
                                }
                                return;
                            }
                            if (a4Var != null) {
                                a4Var.v(device2, connectRequest);
                                Unit unit43 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        if (e4 != 1 && e4 != 4 && e4 != 5 && e4 != 8) {
                            if (e4 != 251) {
                                switch (e4) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        we.h.c("NearConnectionService", "P2P Invitation Accepted error, Unknown Service Type", null);
                                        Unit unit44 = Unit.INSTANCE;
                                        break;
                                }
                                return;
                            }
                            ConnectRequest connectRequest2 = (ConnectRequest) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST", ConnectRequest.class));
                            int f3890k2 = device2.getF3890k();
                            if (f3890k2 == 0) {
                                we.h.b("NearConnectionService", "P2P Invitation Accepted for General Device over BLE");
                                if (aVar != null) {
                                    aVar.t(device2, connectRequest2);
                                    Unit unit45 = Unit.INSTANCE;
                                }
                            } else if (f3890k2 == 1) {
                                we.h.b("NearConnectionService", "P2P Invitation Accepted for General Device over BT Classic");
                                if (dVar != null) {
                                    dVar.t(device2, connectRequest2);
                                    Unit unit46 = Unit.INSTANCE;
                                }
                            } else if (f3890k2 == 12) {
                                we.h.b("NearConnectionService", "P2P Invitation Accepted for General Device over BLE");
                                if (aVar != null) {
                                    aVar.t(device2, connectRequest2);
                                    Unit unit47 = Unit.INSTANCE;
                                }
                            }
                            Unit unit48 = Unit.INSTANCE;
                            return;
                        }
                        we.h.b("NearConnectionService", "P2P Invitation Accepted for Parcel Drop or Air Cast");
                        ConnectRequest connectRequest3 = (ConnectRequest) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST", ConnectRequest.class));
                        int f3890k3 = device2.getF3890k();
                        if (f3890k3 == 0) {
                            we.h.b("NearConnectionService", "P2P Invitation Accepted for General Device over BLE");
                            if (aVar != null) {
                                aVar.t(device2, connectRequest3);
                                Unit unit49 = Unit.INSTANCE;
                            }
                        } else if (f3890k3 == 1) {
                            we.h.b("NearConnectionService", "P2P Invitation Accepted for General Device over BT Classic");
                            if (dVar != null) {
                                dVar.t(device2, connectRequest3);
                                Unit unit50 = Unit.INSTANCE;
                            }
                        } else if (f3890k3 == 12) {
                            we.h.b("NearConnectionService", "P2P Invitation Accepted for General Device over BLE");
                            if (aVar != null) {
                                aVar.t(device2, connectRequest3);
                                Unit unit410 = Unit.INSTANCE;
                            }
                        }
                        Unit unit51 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 41814542:
                    if (action.equals("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT")) {
                        we.h.b("NearConnectionService", "ACTION_RECEIVE_FILE_ACCEPT");
                        NearDevice nearDevice2 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        boolean booleanExtra = intent.getBooleanExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                        int intExtra13 = intent.getIntExtra("com.welink.protocol.nfbd.extra.scenario", -1);
                        if (intExtra13 == 0) {
                            Integer numValueOf4 = nearDevice2 != null ? Integer.valueOf(nearDevice2.getF3890k()) : null;
                            if ((numValueOf4 != null && numValueOf4.intValue() == 0) || (numValueOf4 != null && numValueOf4.intValue() == 12)) {
                                if (a4Var != null) {
                                    a4Var.o();
                                    return;
                                }
                                return;
                            } else if (numValueOf4 == null || numValueOf4.intValue() != 14) {
                                we.h.c("NearConnectionService", "Unknown Wireless Type for accept", null);
                                Unit unit52 = Unit.INSTANCE;
                                return;
                            } else if (nearDevice2.s() == null) {
                                we.h.c("NearConnectionService", "Accept notify Invalid device address, LAN", null);
                                Unit unit53 = Unit.INSTANCE;
                                return;
                            } else {
                                if (mVar != null) {
                                    mVar.p(nearDevice2, booleanExtra);
                                    Unit unit54 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        if (intExtra13 != 1 && intExtra13 != 4 && intExtra13 != 5 && intExtra13 != 8) {
                            if (intExtra13 != 251) {
                                switch (intExtra13) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        we.h.c("NearConnectionService", "Accept notify Unknown Scenario", null);
                                        Unit unit55 = Unit.INSTANCE;
                                        break;
                                }
                                return;
                            }
                            Integer numValueOf5 = nearDevice2 != null ? Integer.valueOf(nearDevice2.getF3890k()) : null;
                            if ((numValueOf5 != null && numValueOf5.intValue() == 0) || (numValueOf5 != null && numValueOf5.intValue() == 12)) {
                                if (nearDevice2.getF3883a() == null) {
                                    we.h.c("NearConnectionService", "Accept notify Invalid device address, LE BT", null);
                                    Unit unit56 = Unit.INSTANCE;
                                    return;
                                } else {
                                    if (aVar != null) {
                                        aVar.v(nearDevice2, booleanExtra);
                                        Unit unit57 = Unit.INSTANCE;
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (numValueOf5 != null && numValueOf5.intValue() == 1) {
                                if (nearDevice2.getF3883a() == null) {
                                    we.h.c("NearConnectionService", "Accept notify Invalid device address, classic BT", null);
                                    Unit unit58 = Unit.INSTANCE;
                                    return;
                                } else {
                                    if (dVar != null) {
                                        dVar.u(nearDevice2, booleanExtra);
                                        Unit unit59 = Unit.INSTANCE;
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (numValueOf5 == null || numValueOf5.intValue() != 14) {
                                we.h.c("NearConnectionService", "Accept notify Unknown Wireless Type for reject", null);
                                Unit unit60 = Unit.INSTANCE;
                                return;
                            } else if (nearDevice2.s() == null) {
                                we.h.c("NearConnectionService", "Accept notify Invalid device address, LAN", null);
                                Unit unit61 = Unit.INSTANCE;
                                return;
                            } else {
                                if (mVar != null) {
                                    mVar.p(nearDevice2, booleanExtra);
                                    Unit unit62 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        Integer numValueOf6 = nearDevice2 != null ? Integer.valueOf(nearDevice2.getF3890k()) : null;
                        if ((numValueOf6 != null && numValueOf6.intValue() == 0) || (numValueOf6 != null && numValueOf6.intValue() == 12)) {
                            if (nearDevice2.getF3883a() == null) {
                                we.h.c("NearConnectionService", "Accept notify Invalid device address, LE BT", null);
                                Unit unit63 = Unit.INSTANCE;
                                return;
                            } else {
                                if (aVar != null) {
                                    aVar.v(nearDevice2, booleanExtra);
                                    Unit unit64 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        if (numValueOf6 != null && numValueOf6.intValue() == 1) {
                            if (nearDevice2.getF3883a() == null) {
                                we.h.c("NearConnectionService", "Accept notify Invalid device address, classic BT", null);
                                Unit unit65 = Unit.INSTANCE;
                                return;
                            } else {
                                if (dVar != null) {
                                    dVar.u(nearDevice2, booleanExtra);
                                    Unit unit66 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        if (numValueOf6 == null || numValueOf6.intValue() != 14) {
                            we.h.c("NearConnectionService", "Accept notify Unknown Wireless Type for reject", null);
                            Unit unit67 = Unit.INSTANCE;
                            return;
                        } else if (nearDevice2.s() == null) {
                            we.h.c("NearConnectionService", "Accept notify Invalid device address, LAN", null);
                            Unit unit68 = Unit.INSTANCE;
                            return;
                        } else {
                            if (mVar != null) {
                                mVar.p(nearDevice2, booleanExtra);
                                Unit unit69 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 50077167:
                    if (action.equals("com.welink.protocol.nfbd.action.DISCONNECT_CANCEL_CONN")) {
                        if (intent.getIntExtra("com.welink.protocol.nfbd.extra.scenario", -1) != 0) {
                            NearDevice nearDevice3 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                            if ((nearDevice3 != null ? nearDevice3.getF3883a() : null) != null && aVar != null) {
                                aVar.k(nearDevice3);
                                Unit unit70 = Unit.INSTANCE;
                            }
                            Unit unit71 = Unit.INSTANCE;
                        } else if (a4Var != null) {
                            a4Var.x();
                            Unit unit72 = Unit.INSTANCE;
                        }
                        this.B = false;
                        return;
                    }
                    return;
                case 82387580:
                    if (action.equals("com.welink.protocol.nfbd.action.REQUEST_CONNECT_DEVICE")) {
                        NearDevice device3 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int e10 = device3 != null ? device3.getE() : 0;
                        if (device3 == null) {
                            we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                        }
                        if (e10 != 0) {
                            if (e10 != 1 && e10 != 4 && e10 != 5 && e10 != 8) {
                                if (e10 != 251) {
                                    switch (e10) {
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                            break;
                                        default:
                                            we.h.c("NearConnectionService", "Unknown Service Type", null);
                                            Unit unit73 = Unit.INSTANCE;
                                            break;
                                    }
                                    return;
                                }
                                Integer numValueOf7 = device3 != null ? Integer.valueOf(device3.getF3890k()) : null;
                                if ((numValueOf7 != null && numValueOf7.intValue() == 0) || (numValueOf7 != null && numValueOf7.intValue() == 12)) {
                                    if (aVar != null) {
                                        aVar.j(device3);
                                    }
                                } else if (numValueOf7 != null && numValueOf7.intValue() == 1) {
                                    if (dVar != null) {
                                        dVar.k(device3);
                                    }
                                } else if (numValueOf7 != null && numValueOf7.intValue() == 14 && mVar != null) {
                                    mVar.j(device3);
                                    Unit unit74 = Unit.INSTANCE;
                                }
                                Unit unit75 = Unit.INSTANCE;
                                return;
                            }
                            Integer numValueOf8 = device3 != null ? Integer.valueOf(device3.getF3890k()) : null;
                            if ((numValueOf8 != null && numValueOf8.intValue() == 0) || (numValueOf8 != null && numValueOf8.intValue() == 12)) {
                                if (aVar != null) {
                                    aVar.j(device3);
                                }
                            } else if (numValueOf8 != null && numValueOf8.intValue() == 1) {
                                if (dVar != null) {
                                    dVar.k(device3);
                                }
                            } else if (numValueOf8 != null && numValueOf8.intValue() == 14 && mVar != null) {
                                mVar.j(device3);
                                Unit unit76 = Unit.INSTANCE;
                            }
                            Unit unit77 = Unit.INSTANCE;
                            return;
                        }
                        Integer numValueOf9 = device3 != null ? Integer.valueOf(device3.getF3890k()) : null;
                        if ((numValueOf9 != null && numValueOf9.intValue() == 0) || (numValueOf9 != null && numValueOf9.intValue() == 12)) {
                            if (a4Var == null || (numU = a4Var.u()) == null || numU.intValue() != 0) {
                                we.h.d("ERROR: Request connect active running already, Device state: " + (a4Var != null ? a4Var.u() : null), null);
                                return;
                            }
                            Integer numT2 = a4Var.t();
                            if (numT2 == null || numT2.intValue() != 0) {
                                we.h.d("ERROR: Request connect passive running already, Device state: " + a4Var.t(), null);
                                return;
                            }
                            if (this.B) {
                                Intrinsics.checkNotNullParameter(device3, "device");
                                a0 a0Var = a4Var.f9644d;
                                if (Intrinsics.areEqual(a0Var != null ? Boolean.valueOf(a0Var.r(device3)) : null, Boolean.FALSE)) {
                                    we.h.c("NearConnectionService", "warning: Remote Invite Connection is Running, Ignore this Command Operation", null);
                                    this.B = false;
                                    return;
                                }
                            }
                            String stringExtra9 = intent.getStringExtra("selectedMac");
                            String stringExtra10 = intent.getStringExtra("fileName");
                            int intExtra14 = intent.getIntExtra("fileCount", 1);
                            long longExtra2 = intent.getLongExtra("fileSize", 0L);
                            String stringExtra11 = intent.getStringExtra("fileType");
                            int intExtra15 = intent.getIntExtra("p2pPort", 51888);
                            if (stringExtra9 == null) {
                                f(device3, 20482);
                                this.B = false;
                                this.C = false;
                                we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                                return;
                            }
                            if (!a4Var.q(stringExtra9) && !a4Var.q(device3.getF3883a()) && !a4Var.q(device3.getF3885c()) && !a4Var.q(device3.getF3884b())) {
                                f(device3, 20481);
                                this.B = false;
                                this.C = false;
                                we.h.c("NearConnectionService", "ERROR, not found valid device in list", null);
                                return;
                            }
                            String str6 = "";
                            if (this.B) {
                                Intrinsics.checkNotNullParameter(device3, "device");
                                a0 a0Var2 = a4Var.f9644d;
                                if (Intrinsics.areEqual(a0Var2 != null ? Boolean.valueOf(a0Var2.r(device3)) : null, Boolean.TRUE)) {
                                    we.h.h("NearConnectionService", "Request connect passive mode");
                                    if (a4Var.q(device3.getF3885c())) {
                                        f3883a2 = device3.getF3885c();
                                        if (f3883a2 != null) {
                                            str6 = f3883a2;
                                        }
                                        str2 = str6;
                                    } else if (a4Var.q(device3.getF3884b())) {
                                        f3883a2 = device3.getF3884b();
                                        if (f3883a2 != null) {
                                            str6 = f3883a2;
                                        }
                                        str2 = str6;
                                    } else if (a4Var.q(device3.getF3883a())) {
                                        f3883a2 = device3.getF3883a();
                                        if (f3883a2 != null) {
                                            str6 = f3883a2;
                                        }
                                        str2 = str6;
                                    } else {
                                        str2 = stringExtra9;
                                    }
                                    if (str2.length() <= 0) {
                                        we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                                        this.B = false;
                                        f(device3, 20482);
                                        return;
                                    } else {
                                        Intrinsics.checkNotNull(stringExtra10);
                                        Intrinsics.checkNotNull(stringExtra11);
                                        a4Var.z(new g5(str2, stringExtra10, intExtra14, longExtra2, stringExtra11, intExtra15, device3));
                                        Unit unit78 = Unit.INSTANCE;
                                    }
                                } else {
                                    we.h.h("NearConnectionService", "Request connect active mode");
                                    this.C = true;
                                    if (a4Var.q(device3.getF3885c())) {
                                        f3883a = device3.getF3885c();
                                        if (f3883a != null) {
                                            str6 = f3883a;
                                        }
                                        str = str6;
                                    } else if (a4Var.q(device3.getF3884b())) {
                                        f3883a = device3.getF3884b();
                                        if (f3883a != null) {
                                            str6 = f3883a;
                                        }
                                        str = str6;
                                    } else if (a4Var.q(device3.getF3883a())) {
                                        f3883a = device3.getF3883a();
                                        if (f3883a != null) {
                                            str6 = f3883a;
                                        }
                                        str = str6;
                                    } else {
                                        str = stringExtra9;
                                    }
                                    if (str.length() > 0) {
                                        we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                                        this.C = false;
                                        f(device3, 20482);
                                        return;
                                    } else {
                                        Intrinsics.checkNotNull(stringExtra10);
                                        Intrinsics.checkNotNull(stringExtra11);
                                        a4Var.A(new g5(str, stringExtra10, intExtra14, longExtra2, stringExtra11, intExtra15, device3));
                                        Unit unit79 = Unit.INSTANCE;
                                    }
                                }
                            } else {
                                we.h.h("NearConnectionService", "Request connect active mode");
                                this.C = true;
                                if (a4Var.q(device3.getF3885c())) {
                                    f3883a = device3.getF3885c();
                                    if (f3883a != null) {
                                        str6 = f3883a;
                                    }
                                    str = str6;
                                } else if (a4Var.q(device3.getF3884b())) {
                                    f3883a = device3.getF3884b();
                                    if (f3883a != null) {
                                        str6 = f3883a;
                                    }
                                    str = str6;
                                } else if (a4Var.q(device3.getF3883a())) {
                                    f3883a = device3.getF3883a();
                                    if (f3883a != null) {
                                        str6 = f3883a;
                                    }
                                    str = str6;
                                } else {
                                    str = stringExtra9;
                                }
                                if (str.length() > 0) {
                                    we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                                    this.C = false;
                                    f(device3, 20482);
                                    return;
                                } else {
                                    Intrinsics.checkNotNull(stringExtra10);
                                    Intrinsics.checkNotNull(stringExtra11);
                                    a4Var.A(new g5(str, stringExtra10, intExtra14, longExtra2, stringExtra11, intExtra15, device3));
                                    Unit unit710 = Unit.INSTANCE;
                                }
                            }
                        } else if (numValueOf9 != null && numValueOf9.intValue() == 14 && mVar != null) {
                            mVar.j(device3);
                            Unit unit80 = Unit.INSTANCE;
                        }
                        Unit unit81 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 91405581:
                    if (action.equals("com.welink.protocol.nfbd.action.DISCONNECT_REMOTE_DEVICE")) {
                        we.h.b("NearConnectionService", "ACTION_DISCONNECT_REMOTE_DEVICE");
                        NearDevice nearDevice4 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int e11 = nearDevice4 != null ? nearDevice4.getE() : 0;
                        if (nearDevice4 == null) {
                            we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                        }
                        if (e11 == 0) {
                            Integer numValueOf10 = nearDevice4 != null ? Integer.valueOf(nearDevice4.getF3890k()) : null;
                            if ((numValueOf10 != null && numValueOf10.intValue() == 0) || ((numValueOf10 != null && numValueOf10.intValue() == 1) || (numValueOf10 != null && numValueOf10.intValue() == 12))) {
                                this.B = false;
                                this.C = false;
                                if (a4Var != null) {
                                    a4Var.y();
                                    Unit unit82 = Unit.INSTANCE;
                                }
                            } else if ((numValueOf10 != null && numValueOf10.intValue() == 10) || (numValueOf10 != null && numValueOf10.intValue() == 11)) {
                                if (a4Var != null) {
                                    a4Var.l();
                                    Unit unit83 = Unit.INSTANCE;
                                }
                            } else if (numValueOf10 != null && numValueOf10.intValue() == 14 && mVar != null) {
                                mVar.k(nearDevice4);
                                Unit unit84 = Unit.INSTANCE;
                            }
                            Unit unit85 = Unit.INSTANCE;
                            return;
                        }
                        if (e11 != 1 && e11 != 4 && e11 != 5 && e11 != 8) {
                            if (e11 == 251) {
                                if (nearDevice4 != null) {
                                    int f3890k4 = nearDevice4.getF3890k();
                                    if (f3890k4 == 0) {
                                        if (aVar != null) {
                                            aVar.k(nearDevice4);
                                            Unit unit86 = Unit.INSTANCE;
                                        }
                                    } else if (f3890k4 != 1) {
                                        if (f3890k4 != 14) {
                                            switch (f3890k4) {
                                                case 10:
                                                case 11:
                                                    if (a4Var != null) {
                                                        a4Var.l();
                                                        Unit unit87 = Unit.INSTANCE;
                                                    }
                                                    break;
                                                case 12:
                                                    if (aVar != null) {
                                                        aVar.k(nearDevice4);
                                                        Unit unit88 = Unit.INSTANCE;
                                                    }
                                                    break;
                                                default:
                                                    we.h.c("NearConnectionService", "Unknown Wireless Type for disconnect", null);
                                                    Unit unit89 = Unit.INSTANCE;
                                                    break;
                                            }
                                        } else if (mVar != null) {
                                            mVar.k(nearDevice4);
                                            Unit unit90 = Unit.INSTANCE;
                                        }
                                    } else if (dVar != null) {
                                        dVar.l(nearDevice4);
                                        Unit unit91 = Unit.INSTANCE;
                                    }
                                }
                                Unit unit92 = Unit.INSTANCE;
                                return;
                            }
                            switch (e11) {
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    break;
                                default:
                                    we.h.c("NearConnectionService", "Unknown Scenario", null);
                                    Unit unit93 = Unit.INSTANCE;
                                    return;
                            }
                        }
                        if (nearDevice4 != null) {
                            int f3890k5 = nearDevice4.getF3890k();
                            if (f3890k5 == 0) {
                                if (aVar != null) {
                                    aVar.k(nearDevice4);
                                    Unit unit94 = Unit.INSTANCE;
                                }
                            } else if (f3890k5 != 1) {
                                if (f3890k5 != 14) {
                                    switch (f3890k5) {
                                        case 10:
                                        case 11:
                                            if (a4Var != null) {
                                                a4Var.l();
                                                Unit unit95 = Unit.INSTANCE;
                                            }
                                            break;
                                        case 12:
                                            if (aVar != null) {
                                                aVar.k(nearDevice4);
                                                Unit unit96 = Unit.INSTANCE;
                                            }
                                            break;
                                        default:
                                            we.h.c("NearConnectionService", "Unknown Wireless Type for disconnect", null);
                                            Unit unit97 = Unit.INSTANCE;
                                            break;
                                    }
                                } else if (mVar != null) {
                                    mVar.k(nearDevice4);
                                    Unit unit98 = Unit.INSTANCE;
                                }
                            } else if (dVar != null) {
                                dVar.l(nearDevice4);
                                Unit unit99 = Unit.INSTANCE;
                            }
                        }
                        Unit unit100 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 174457792:
                    if (action.equals("com.welink.protocol.nfbd.action.NOTIFY_CONNECT_DEVICE")) {
                        we.h.c("NearConnectionService", "ACTION_NOTIFY_CONNECT_DEVICE enter", null);
                        if (a4Var == null || (numT = a4Var.t()) == null || numT.intValue() != 0) {
                            we.h.d("ERROR: Notify connect passive running already, Device state: " + (a4Var != null ? a4Var.t() : null), null);
                            return;
                        }
                        Integer numU4 = a4Var.u();
                        if (numU4 == null || numU4.intValue() != 0) {
                            we.h.d("ERROR: Notify connect active running already, Device state: " + a4Var.u(), null);
                            return;
                        }
                        if (this.C) {
                            we.h.j("NearConnectionService", "warning: Local Connection is Running, Ignore this Command Operation");
                            return;
                        }
                        we.h.c("NearConnectionService", "ACTION_NOTIFY_CONNECT_DEVICE start connect", null);
                        String stringExtra12 = intent.getStringExtra("com.welink.protocol.nfbd.extra.LOCADDR");
                        String stringExtra13 = intent.getStringExtra("com.welink.protocol.nfbd.extra.SRCADDR");
                        ScanResult scanResult = (ScanResult) ((Parcelable) intent.getParcelableExtra("com.welink.protocol.nfbd.extra.RESULTS", ScanResult.class));
                        DeviceInfo deviceInfo = (DeviceInfo) ((Parcelable) intent.getParcelableExtra("com.welink.protocol.nfbd.extra.DEVINFO", DeviceInfo.class));
                        if (intent.getIntExtra("com.welink.protocol.nfbd.extra.CMDREQU", 7) == 7) {
                            this.B = true;
                            Intrinsics.checkNotNull(deviceInfo);
                            Intrinsics.checkNotNull(scanResult);
                            a4Var.w(7, stringExtra12, stringExtra13, deviceInfo, scanResult);
                            Unit unit101 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    return;
                case 215901582:
                    if (action.equals("com.welink.protocol.nfbd.action.PAUSE_SCAN_DEVICE")) {
                        we.h.b("NearConnectionService", "ACTION_PAUSE_SCAN_DEVICE");
                        z();
                        return;
                    }
                    return;
                case 306114362:
                    if (action.equals("com.welink.protocol.nfbd.action.STOP_SCAN_WIFI_DEVICE")) {
                        A();
                        return;
                    }
                    return;
                case 383419276:
                    if (action.equals("com.welink.service.ACTION_BLE_CONNECTED_EXCHANGE_RESPONSE")) {
                        we.h.b("NearConnectionService", "ACTION_BLE_CONNECTED_EXCHANGE_RESPONSE");
                        NearDevice nearDevice5 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int intExtra16 = intent.getIntExtra("requestId", 0);
                        int intExtra17 = intent.getIntExtra(TypedValues.CycleType.S_WAVE_OFFSET, 0);
                        boolean booleanExtra2 = intent.getBooleanExtra("isBusy", false);
                        iE = nearDevice5 != null ? nearDevice5.getE() : 0;
                        if (nearDevice5 == null) {
                            we.h.c("NearConnectionService", "Exchange Response error, invalid device address", null);
                            return;
                        }
                        if (iE == 0) {
                            we.h.b("NearConnectionService", "Exchange Response for Screen Cast");
                            if (a4Var != null) {
                                a4Var.r(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                Unit unit102 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        if (iE != 1 && iE != 4 && iE != 5 && iE != 8) {
                            if (iE != 251) {
                                switch (iE) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        we.h.c("NearConnectionService", "Exchange Response error, Unknown Service Type", null);
                                        Unit unit103 = Unit.INSTANCE;
                                        break;
                                }
                                return;
                            }
                            int f3890k6 = nearDevice5.getF3890k();
                            if (f3890k6 == 0) {
                                if (aVar != null) {
                                    aVar.s(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                    Unit unit104 = Unit.INSTANCE;
                                }
                            } else if (f3890k6 == 1) {
                                we.h.b("NearConnectionService", "Exchange Response for General Device over BT Classic");
                                if (dVar != null) {
                                    dVar.s(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                    Unit unit105 = Unit.INSTANCE;
                                }
                            } else if (f3890k6 != 12) {
                                if (f3890k6 == 14) {
                                    we.h.b("NearConnectionService", "Exchange Response for General Device over WLAN NSD");
                                    if (mVar != null) {
                                        mVar.n(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                        Unit unit106 = Unit.INSTANCE;
                                    }
                                }
                            } else if (aVar != null) {
                                aVar.s(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                Unit unit107 = Unit.INSTANCE;
                            }
                            Unit unit108 = Unit.INSTANCE;
                            return;
                        }
                        we.h.b("NearConnectionService", "Exchange Response for Parcel Drop or Air Cast");
                        int f3890k7 = nearDevice5.getF3890k();
                        if (f3890k7 == 0) {
                            we.h.b("NearConnectionService", "Exchange Response for FileTransfer over BLE");
                            if (aVar != null) {
                                aVar.s(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                Unit unit109 = Unit.INSTANCE;
                            }
                        } else if (f3890k7 == 1) {
                            we.h.b("NearConnectionService", "Exchange Response for FileTransfer over BT Classic");
                            if (dVar != null) {
                                dVar.s(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                Unit unit110 = Unit.INSTANCE;
                            }
                        } else if (f3890k7 == 12) {
                            we.h.b("NearConnectionService", "Exchange Response for FileTransfer over BLE");
                            if (aVar != null) {
                                aVar.s(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                Unit unit1010 = Unit.INSTANCE;
                            }
                        } else if (f3890k7 == 14) {
                            we.h.b("NearConnectionService", "Exchange Response for WLAN NSD");
                            if (mVar != null) {
                                mVar.n(nearDevice5, booleanExtra2, intExtra16, intExtra17);
                                Unit unit111 = Unit.INSTANCE;
                            }
                        }
                        Unit unit112 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 538422684:
                    if (action.equals("com.welink.protocol.nfbd.action.START_SCAN_WIFI_DEVICE")) {
                        v();
                        return;
                    }
                    return;
                case 621607914:
                    if (action.equals("com.welink.protocol.nfbd.action.NOTIFY_SCAN_RESULT")) {
                        n((DeviceInfo) ((Parcelable) intent.getParcelableExtra("com.welink.protocol.nfbd.extra.DEVINFO", DeviceInfo.class)), (ScanResult) ((Parcelable) intent.getParcelableExtra("com.welink.protocol.nfbd.extra.RESULTS", ScanResult.class)));
                        return;
                    }
                    return;
                case 719996205:
                    if (action.equals("com.welink.service.ACTION_BLE_ADV_DEVICE_NAME")) {
                        we.h.b("NearConnectionService", "ACTION_BLE_ADV_DEVICE_NAME");
                        String stringExtra14 = intent.getStringExtra("com.welink.service.EXTRA_BLE_ADV_DEVICE_NAME");
                        if (stringExtra14 != null) {
                            Intrinsics.checkNotNull(h5Var);
                            h5Var.m(stringExtra14);
                            this.f4129x = stringExtra14;
                            g(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                case 1027648115:
                    if (action.equals("com.welink.service.ACTION_WIFI_P2P_CLIENT_MODE")) {
                        we.h.b("NearConnectionService", "ACTION_WIFI_P2P_CLIENT_MODE");
                        int intExtra18 = intent.getIntExtra("com.welink.service.EXTRA_WIFI_P2P_CLIENT_MODE", -1);
                        if (intExtra18 >= 0) {
                            if (aVar != null) {
                                aVar.x(intExtra18);
                                Unit unit113 = Unit.INSTANCE;
                            }
                            if (dVar != null) {
                                dVar.w(intExtra18);
                                Unit unit114 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 1210516695:
                    if (action.equals("com.welink.protocol.nfbd.action.UNREG_CONN_NOTIFY") && a4Var != null) {
                        a4Var.B();
                        Unit unit115 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 1296180006:
                    if (action.equals("com.welink.protocol.nfbd.action.ACTION_UPDATE_CON_STATE")) {
                        we.h.b("NearConnectionService", "ACTION_UPDATE_CON_STATE");
                        if (!intent.getBooleanExtra("STATE", false)) {
                            we.h.b("NearConnectionService", "Qr,NFC Connect Successfully");
                            return;
                        }
                        if ((a4Var == null || (numU3 = a4Var.u()) == null || numU3.intValue() != 4) && (a4Var == null || (numU2 = a4Var.u()) == null || numU2.intValue() != 5)) {
                            we.h.b("NearConnectionService", "Passive Connect Successfully");
                            this.B = false;
                            return;
                        } else {
                            we.h.b("NearConnectionService", "Active Connect Successfully");
                            this.C = false;
                            return;
                        }
                    }
                    return;
                case 1304311190:
                    if (action.equals("com.welink.protocol.nfbd.action.NOTIFY_CREATE_GO") && a4Var != null) {
                        a4Var.j();
                        Unit unit116 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 1332581235:
                    if (action.equals("com.welink.protocol.nfbd.action.ACTION_REVIVE_SERVICE")) {
                        we.h.b("NearConnectionService", "ACTION_REVIVE_SERVICE");
                        return;
                    }
                    return;
                case 1621353406:
                    if (action.equals("com.welink.protocol.nfbd.action.STOP_ADV_DEVICE")) {
                        we.h.b("NearConnectionService", "ACTION_STOP_ADV_DEVICE");
                        this.p = -1;
                        this.F = true;
                        this.f4124r = null;
                        this.J = null;
                        if (h5Var != null) {
                            h5Var.f9779j = false;
                            Unit unit117 = Unit.INSTANCE;
                        }
                        if (ne.b.f8191k) {
                            ne.b.y();
                            if (aVar != null) {
                                aVar.y();
                            }
                            this.f4129x = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 1867694174:
                    if (action.equals("com.welink.protocol.nfbd.action.DISCONNECT_RESET_CONN")) {
                        int intExtra19 = intent.getIntExtra("TRANDIR", 0);
                        if (intExtra19 == 1) {
                            we.h.b("NearConnectionService", "Active Reset Inviting Flag");
                            this.B = false;
                            if (a4Var != null) {
                                a4Var.k(2);
                                Unit unit118 = Unit.INSTANCE;
                            }
                            this.C = false;
                            if (a4Var != null) {
                                z2 = true;
                                a4Var.k(1);
                                Unit unit119 = Unit.INSTANCE;
                            }
                            m(z2);
                            return;
                        }
                        if (intExtra19 == 2) {
                            we.h.b("NearConnectionService", "Active Reset QR Mode Flag");
                            if (a4Var != null) {
                                Unit unit120 = Unit.INSTANCE;
                            }
                            if (a4Var != null) {
                                a4Var.k(0);
                                Unit unit121 = Unit.INSTANCE;
                            }
                        } else if (intExtra19 != 5) {
                            we.h.j("NearConnectionService", "Unknown Reset Event");
                            Unit unit122 = Unit.INSTANCE;
                        } else {
                            we.h.b("NearConnectionService", "Active Reset P2P Mode Flag");
                            if (a4Var != null) {
                                a4Var.k(3);
                                Unit unit123 = Unit.INSTANCE;
                            }
                        }
                        z2 = true;
                        m(z2);
                        return;
                    }
                    return;
                case 1935157209:
                    if (action.equals("com.welink.protocol.nfbd.action.ACTION_FLUSH_DEVICE")) {
                        NearDevice nearDevice6 = (NearDevice) ((Parcelable) intent.getParcelableExtra("com.welink.service.EXTRA_NEAR_DEVICE", NearDevice.class));
                        int e12 = nearDevice6 != null ? nearDevice6.getE() : 0;
                        if (nearDevice6 == null) {
                            we.h.c("NearConnectionService", "ERROR, invalid device address", null);
                        }
                        if (e12 == 0) {
                            we.h.b("NearConnectionService", "Flush Device for Screen Cast");
                            Integer numValueOf11 = nearDevice6 != null ? Integer.valueOf(nearDevice6.getF3890k()) : null;
                            if ((numValueOf11 != null && numValueOf11.intValue() == 0) || (numValueOf11 != null && numValueOf11.intValue() == 12)) {
                                this.B = false;
                                this.C = false;
                                if (a4Var != null) {
                                    a4Var.m(nearDevice6);
                                    Unit unit124 = Unit.INSTANCE;
                                }
                            } else if ((numValueOf11 != null && numValueOf11.intValue() == 10) || (numValueOf11 != null && numValueOf11.intValue() == 11)) {
                                if (a4Var != null) {
                                    a4Var.m(nearDevice6);
                                    Unit unit125 = Unit.INSTANCE;
                                }
                            } else if (numValueOf11 != null && numValueOf11.intValue() == 14 && mVar != null) {
                                mVar.l(nearDevice6);
                                Unit unit126 = Unit.INSTANCE;
                            }
                            m(true);
                            Unit unit127 = Unit.INSTANCE;
                            return;
                        }
                        if (e12 != 1 && e12 != 4 && e12 != 5 && e12 != 8) {
                            if (e12 != 251) {
                                switch (e12) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        we.h.c("NearConnectionService", "Flush Device, Unknown Service Type", null);
                                        Unit unit128 = Unit.INSTANCE;
                                        break;
                                }
                                return;
                            }
                            we.h.b("NearConnectionService", "Flush Device for All");
                            Integer numValueOf12 = nearDevice6 != null ? Integer.valueOf(nearDevice6.getF3890k()) : null;
                            if ((numValueOf12 != null && numValueOf12.intValue() == 0) || (numValueOf12 != null && numValueOf12.intValue() == 12)) {
                                if (aVar != null) {
                                    aVar.l(nearDevice6);
                                    Unit unit129 = Unit.INSTANCE;
                                }
                            } else if (numValueOf12 != null && numValueOf12.intValue() == 1) {
                                if (dVar != null) {
                                    dVar.m(nearDevice6);
                                    Unit unit130 = Unit.INSTANCE;
                                }
                            } else if ((numValueOf12 != null && numValueOf12.intValue() == 10) || (numValueOf12 != null && numValueOf12.intValue() == 11)) {
                                if (a4Var != null) {
                                    a4Var.m(nearDevice6);
                                    Unit unit131 = Unit.INSTANCE;
                                }
                            } else if (numValueOf12 != null && numValueOf12.intValue() == 14 && mVar != null) {
                                mVar.l(nearDevice6);
                                Unit unit132 = Unit.INSTANCE;
                            }
                            m(true);
                            Unit unit133 = Unit.INSTANCE;
                            return;
                        }
                        we.h.b("NearConnectionService", "Flush Device for Air Parcel Drop or Air Cast");
                        Integer numValueOf13 = nearDevice6 != null ? Integer.valueOf(nearDevice6.getF3890k()) : null;
                        if ((numValueOf13 != null && numValueOf13.intValue() == 0) || (numValueOf13 != null && numValueOf13.intValue() == 12)) {
                            if (aVar != null) {
                                aVar.l(nearDevice6);
                                Unit unit134 = Unit.INSTANCE;
                            }
                        } else if ((numValueOf13 != null && numValueOf13.intValue() == 10) || (numValueOf13 != null && numValueOf13.intValue() == 11)) {
                            if (a4Var != null) {
                                a4Var.m(nearDevice6);
                                Unit unit135 = Unit.INSTANCE;
                            }
                        } else if (numValueOf13 != null && numValueOf13.intValue() == 1) {
                            if (dVar != null) {
                                dVar.m(nearDevice6);
                                Unit unit136 = Unit.INSTANCE;
                            }
                        } else if (numValueOf13 != null && numValueOf13.intValue() == 14 && mVar != null) {
                            mVar.l(nearDevice6);
                            Unit unit137 = Unit.INSTANCE;
                        }
                        m(true);
                        Unit unit138 = Unit.INSTANCE;
                        return;
                    }
                    return;
                case 1960774111:
                    if (action.equals("com.welink.protocol.nfbd.action.ACTION_RESET_P2P_DEVICE")) {
                        k();
                        return;
                    }
                    return;
                case 1992544005:
                    if (action.equals("com.welink.protocol.nfbd.action.STOP_LAN_ADVERTISE")) {
                        this.D = true;
                        this.f4127v = null;
                        if (h5Var != null) {
                            h5Var.f9778i = false;
                            Unit unit139 = Unit.INSTANCE;
                        }
                        if (mVar != null) {
                            mVar.f4178l = null;
                            if (we.m.e(1282)) {
                                we.m.c(1282);
                            }
                            b6 b6Var = mVar.f;
                            if (b6Var != null) {
                                b6Var.r();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            this.f4125s = intent.getByteArrayExtra("com.welink.protocol.nfbd.extra.service");
            this.G = false;
            q(true);
            u();
        }
    }

    public final void k() {
        a4 a4Var = this.f4116h;
        if (a4Var != null) {
            o4 o4Var = a4Var.e;
            if (o4Var != null) {
                o4Var.n();
            }
            o4 o4Var2 = a4Var.f;
            if (o4Var2 != null) {
                o4Var2.n();
            }
        }
    }

    public final void l(boolean z2) {
        we.h.g("onScreenOff, advLeDisable=" + this.F + ", scanLeDisable=" + this.G + "\r\nadvLanDisable=" + this.D + ", scanLanDisable=" + this.E + "\r\n smartState: " + this.f4131z);
        this.f = z2 ^ true;
        z();
        if (ne.b.f8191k) {
            ne.b.y();
            a aVar = this.f4119k;
            if (aVar != null) {
                aVar.y();
            }
            this.f4129x = null;
        }
        y();
        m mVar = this.f4117i;
        if (mVar != null) {
            mVar.f4178l = null;
            if (we.m.e(1282)) {
                we.m.c(1282);
            }
            b6 b6Var = mVar.f;
            if (b6Var != null) {
                b6Var.r();
            }
        }
    }

    public final void m(boolean z2) {
        we.h.g("onScreenOn, advLeDisable=" + this.F + ", scanLeDisable=" + this.G + "\r\nadvLanDisable=" + this.D + ", scanLanDisable=" + this.E + "\r\n smartState: " + this.f4131z);
        this.f = z2;
        if (Intrinsics.areEqual(this.f4131z, Boolean.FALSE)) {
            we.h.c("NearConnectionService", "smart connect disabled", null);
        } else {
            o();
        }
    }

    public final void n(DeviceInfo deviceInfo, ScanResult scanResult) {
        if (deviceInfo == null || scanResult == null) {
            Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
            Intrinsics.checkNotNullParameter("processScanResults error, invalid deviceInfo or result", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionService", "TransConnect:processScanResults error, invalid deviceInfo or result", null);
                return;
            }
            return;
        }
        h5 h5Var = this.f4115g;
        byte b9 = deviceInfo.f4220a;
        if (b9 != 10) {
            if (b9 == 13 || b9 == 15 || b9 == 21 || b9 == 18) {
                if (h5Var != null) {
                    h5Var.j(255, this.f4122n, deviceInfo.f4223d, deviceInfo, scanResult);
                    return;
                }
                return;
            } else if (b9 == 2 || b9 == 1 || b9 == 0 || b9 == 20) {
                if (h5Var != null) {
                    h5Var.j(255, this.f4122n, deviceInfo.f4223d, deviceInfo, scanResult);
                    return;
                }
                return;
            } else {
                if ((b9 == 22 || b9 == 23 || b9 == 24) && h5Var != null) {
                    h5Var.j(255, this.f4122n, deviceInfo.f4223d, deviceInfo, scanResult);
                    return;
                }
                return;
            }
        }
        ScanRecord scanRecord = scanResult.getScanRecord();
        Intrinsics.checkNotNull(scanRecord);
        byte[] serviceData = scanRecord.getServiceData(z6.f10087c);
        Intrinsics.checkNotNull(serviceData);
        System.arraycopy(serviceData, 0, new byte[6], 0, 6);
        byte b10 = serviceData[12];
        a4 a4Var = this.f4116h;
        if (b10 != 7) {
            if (h5Var != null) {
                h5Var.j(255, this.f4122n, deviceInfo.f4223d, deviceInfo, scanResult);
            }
            if (a4Var != null) {
                a4Var.w(128, this.f4122n, deviceInfo.f4223d, deviceInfo, scanResult);
                return;
            }
            return;
        }
        byte[] bArr = new byte[6];
        we.h.h("NearConnectionService", "local running: " + this.C + ", remote running: " + this.B + ", pc connection is connecting: " + (a4Var != null ? Boolean.valueOf(a4Var.n()) : null));
        if ((a4Var != null && a4Var.n()) || this.C || this.B || !j(deviceInfo, scanResult)) {
            if (this.C) {
                we.h.j("NearConnectionService", "warning: Local Connection is Running, Ignore this Command Operation");
                return;
            }
            if (this.B) {
                we.h.j("NearConnectionService", "warning: Device Connection is Running, Ignore this Command Operation");
                return;
            } else if (j(deviceInfo, scanResult)) {
                we.h.j("NearConnectionService", "warning: Device Connection is Running, Ignore this Command Operation");
                return;
            } else {
                we.h.j("NearConnectionService", "warning: Invalid Device Name, Ignore this Command Operation");
                return;
            }
        }
        System.arraycopy(serviceData, 6, bArr, 0, 6);
        String strC = m3.q.c(bArr);
        byte[] bArrM = ne.b.m();
        String strC2 = bArrM != null ? m3.q.c(bArrM) : null;
        we.h.h("NearConnectionService", "Target addr = " + strC + ", adapter= " + this.f4122n);
        if ((StringsKt__StringsJVMKt.equals(this.f4122n, strC, true) || (strC2 != null && StringsKt__StringsJVMKt.equals(strC2, strC, true))) && serviceData[12] == 7) {
            if (this.B || this.C) {
                we.h.j("NearConnectionService", "Connect is running already,");
                if (this.B) {
                    we.h.j("NearConnectionService", "Remote Invite Running Already");
                    return;
                } else {
                    if (this.C) {
                        we.h.j("NearConnectionService", "Local Connect Running Already");
                        return;
                    }
                    return;
                }
            }
            we.h.b("NearConnectionService", "Send Connect Request from " + deviceInfo.f4223d);
            this.B = true;
            if (a4Var != null) {
                a4Var.w(7, strC, deviceInfo.f4223d, deviceInfo, scanResult);
            }
        }
    }

    public final void o() {
        String str;
        Integer numT;
        Integer numU;
        Integer numS;
        List services;
        List list = this.J;
        if (list != null && !list.isEmpty() && (services = this.J) != null) {
            we.h.b("NearConnectionService", "Recover last service port=" + services);
            m mVar = this.f4117i;
            if (mVar != null) {
                Intrinsics.checkNotNullParameter(services, "services");
                mVar.f4177k = services;
            }
            a aVar = this.f4119k;
            if (aVar != null) {
                aVar.u(services);
            }
        }
        h5 h5Var = this.f4115g;
        a4 a4Var = this.f4116h;
        if ((a4Var == null || (numT = a4Var.t()) == null || numT.intValue() != 0 || (numU = a4Var.u()) == null || numU.intValue() != 0 || (numS = a4Var.s()) == null || numS.intValue() != 0) && h5Var == null) {
            Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
            Intrinsics.checkNotNullParameter("Smart Connect is Running, wait for completing", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearConnectionService", "TransConnect:Smart Connect is Running, wait for completing", null);
                return;
            }
            return;
        }
        if (!this.F && !this.H) {
            s(this.f4123o);
        }
        if (!this.D && !this.I && (str = this.f4123o) != null) {
            BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
            byte[] bArrM = ne.b.m();
            String strH = ne.b.h(this.f4111a);
            int iIntValue = this.f4126t.intValue();
            byte[] bArr = this.f4127v;
            m mVar2 = this.f4117i;
            if (mVar2 != null) {
                mVar2.r(str, bArrM, strH, iIntValue, bArr, 0);
            }
        }
        if (h5Var != null && !h5Var.f9780k && !this.G) {
            we.h.j("NearConnectionService", "Le Scan has been disabled?");
            this.G = true;
            this.f4125s = null;
        }
        if (h5Var != null && !h5Var.f9781l && !this.E) {
            we.h.j("NearConnectionService", "Lan Scan has been disabled?");
            this.E = true;
            this.f4128w = null;
        }
        if (!this.G && !this.H) {
            u();
        }
        if (this.E || this.I) {
            return;
        }
        t(this.f4128w);
    }

    public final void p(DeviceData deviceData, NearDevice nearDevice, int i8, int i9) {
        Intent intent = new Intent("com.welink.service.ACTION_NEAR_DEVICE_STATE_CHANGE");
        intent.putExtra("com.welink.service.EXTRA_DEVICE_DATA", deviceData);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_STATE", i8);
        if (i8 == 1010 || i8 == 1032) {
            intent.putExtra("com.welink.service.EXTRA_DISCONNECT_REASON_CODE", i9);
        }
        this.f4112b.j(intent);
    }

    public final void q(boolean z2) {
        h5 h5Var = this.f4115g;
        if (h5Var != null) {
            synchronized (h5Var.f9783n) {
                h5Var.f9780k = z2;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void r(int i8) {
        BluetoothAdapter bluetoothAdapter;
        address = null;
        String address = null;
        we.h.c("NearConnectionService", "start", null);
        if (i8 != 1 && i8 != 5 && i8 != 2 && i8 != 4) {
            we.h.c("NearConnectionService", "Unknown Start value " + i8, null);
            return;
        }
        boolean z2 = this.e;
        Context context = this.f4111a;
        if (!z2) {
            this.e = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(this.f4114d, intentFilter, 2);
        }
        h5 h5Var = this.f4115g;
        if (h5Var != null) {
            h5Var.f9777h = true;
        }
        m mVar = this.f4117i;
        if (mVar != null && (i8 == 1 || i8 == 4)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 20480;
            messageObtain.arg1 = 1;
            Intrinsics.checkNotNull(messageObtain);
            mVar.i(messageObtain);
        }
        this.f4131z = Boolean.TRUE;
        if (i8 == 1) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Intrinsics.checkNotNullExpressionValue(defaultAdapter, "getDefaultAdapter(...)");
            Object systemService = context.getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            if (defaultAdapter.isEnabled()) {
                this.H = false;
            }
            if (wifiManager.isWifiEnabled()) {
                this.I = false;
            }
            if (ye.h.f11191a == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                lb.f6527a = context;
                Intrinsics.checkNotNull(context);
                Intrinsics.checkNotNullParameter(context, "context");
                Object systemService2 = context.getSystemService("wifi");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                WifiManager wifiManager2 = (WifiManager) systemService2;
                ye.h.f11191a = wifiManager2;
                ye.h.f11192b = wifiManager2 != null ? Boolean.valueOf(wifiManager2.is24GHzBandSupported()) : null;
                WifiManager wifiManager3 = ye.h.f11191a;
                ye.h.f11193c = wifiManager3 != null ? Boolean.valueOf(wifiManager3.is5GHzBandSupported()) : null;
                WifiManager wifiManager4 = ye.h.f11191a;
                ye.h.f11194d = wifiManager4 != null ? Boolean.valueOf(wifiManager4.is6GHzBandSupported()) : null;
                WifiManager wifiManager5 = ye.h.f11191a;
                ye.h.e = wifiManager5 != null ? Boolean.valueOf(wifiManager5.is60GHzBandSupported()) : null;
                WifiManager wifiManager6 = ye.h.f11191a;
                ye.h.f = wifiManager6 != null ? Boolean.valueOf(wifiManager6.isP2pSupported()) : null;
                we.h.a("WifiUtil init");
            }
        } else if (i8 == 2) {
            we.h.h("NearConnectionService", "Bluetooth Enabled, both Ble and Wifi");
            this.H = false;
            if (this.f4122n == null) {
                ne.f fVar = this.f4120l;
                if (fVar != null && (bluetoothAdapter = fVar.f8196b) != null) {
                    address = bluetoothAdapter.getAddress();
                }
                this.f4122n = address;
                we.h.g("Adapter Address is " + address);
                if (this.f4122n == null) {
                    Object systemService3 = context.getSystemService("bluetooth");
                    Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
                    BluetoothAdapter adater = ((BluetoothManager) systemService3).getAdapter();
                    if (adater != null) {
                        if (fVar != null) {
                            Intrinsics.checkNotNullParameter(adater, "adater");
                            if (fVar.f8196b != null) {
                                we.h.j("BleScanTool", "setBluetoothAdapter: mBluetoothAdapter is not null, please call clearBuf() first");
                            } else {
                                fVar.f8196b = adater;
                            }
                        }
                        String address2 = adater.getAddress();
                        this.f4122n = address2;
                        h0.a.D("Get adapter address ", address2, "NearConnectionService");
                    }
                }
            }
            c();
        } else if (i8 == 4) {
            we.h.h("NearConnectionService", "Wifi Enabled, both Ble and Wifi");
            this.I = false;
            c();
        }
        if (i8 == 1) {
            we.h.j("NearConnectionService", "start service, TranConnectSDK BUILD VERSION: 2.0.36-omicron-2025/09/08-20:00");
            Intent intent = new Intent("com.welink.service.ACTION_NEAR_SERVICE_ACTIVATED");
            intent.putExtra("com.welink.service.EXTRA_NEAR_SERVICE_ENABLED", 1);
            this.f4112b.j(intent);
        }
        Object systemService4 = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService4, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService4).isInteractive()) {
            m(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    public final void s(String str) {
        String str2;
        Integer num;
        f fVar;
        l lVar;
        BluetoothManager bluetoothManager;
        BluetoothAdapter bluetoothAdapter;
        ne.f fVar2 = this.f4120l;
        if (fVar2 == null || ((bluetoothAdapter = fVar2.f8196b) != null && bluetoothAdapter.isEnabled())) {
            BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
            if (ne.b.f8191k) {
                return;
            }
            d();
            Integer num2 = this.p;
            int iIntValue = this.q.intValue();
            if (str == null) {
                e();
                str2 = this.f4123o;
                if (str2 == null) {
                    Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
                    Intrinsics.checkNotNullParameter("Get vendor PID failed", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearConnectionService", "TransConnect:Get vendor PID failed", null);
                        return;
                    }
                    return;
                }
            } else {
                str2 = str;
            }
            if ((num2 != null && num2.intValue() == -1) || num2 == null) {
                Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
                Intrinsics.checkNotNullParameter("Get scenario failed", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearConnectionService", "TransConnect:Get scenario failed", null);
                    return;
                }
                return;
            }
            we.h.c("NearConnectionService", "Get scenario success, scenario=" + num2, null);
            StringBuilder sbP = h0.a.p("startAdvertising, pid=", str2, ", deviceName=", this.f4129x, ", scenario=");
            sbP.append(num2);
            we.h.c("NearConnectionService", sbP.toString(), null);
            int iJ = 29 - ne.b.j(num2.intValue(), this.f4124r);
            String string = Settings.Global.getString(this.f4111a.getContentResolver(), "device_name");
            this.f4129x = string;
            if (string != null) {
                Intrinsics.checkNotNullParameter(string, "<this>");
                byte[] bytes = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                Integer numValueOf = Integer.valueOf(bytes.length);
                Intrinsics.checkNotNull(numValueOf);
                if (numValueOf.intValue() > iJ) {
                    g(num2, this.f4124r);
                    if (this.f4129x == null) {
                        we.h.c("NearConnectionService", "Get device Name failed", null);
                        return;
                    }
                }
            } else {
                g(num2, this.f4124r);
                if (this.f4129x == null) {
                    we.h.c("NearConnectionService", "Get device Name failed", null);
                    return;
                }
            }
            String deviceName = this.f4129x;
            if (deviceName != null) {
                Intrinsics.checkNotNullParameter(deviceName, "deviceName");
                ne.b.f8190j = deviceName;
            }
            ne.b.f8183a.isLeExtendedAdvertisingSupported();
            Integer num3 = this.p;
            boolean z2 = (num3 == null || num3.intValue() != 0) && this.f4113c && ((num = this.p) == null || num.intValue() != -1);
            boolean z3 = z2;
            StringBuilder sbP2 = h0.a.p("startAdvertising, pid=", str2, ", deviceName=", this.f4129x, ", isIncludeDeviceName=");
            sbP2.append(z2);
            we.h.d(sbP2.toString(), null);
            ne.b.x(str2, z2, 2, z3, num2.intValue(), iIntValue, this.f4111a, this.f4124r);
            if (num2.intValue() != 0) {
                a aVar = this.f4119k;
                if (aVar != null && (lVar = aVar.f4028c) != null) {
                    Context context = lVar.f4152d;
                    if (context == null || (bluetoothManager = lVar.f4151c) == null) {
                        Intrinsics.checkNotNullParameter("NearGattService", "tag");
                        Intrinsics.checkNotNullParameter("Context or BluetoothManager is null", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearGattService", "TransConnect:Context or BluetoothManager is null", null);
                        }
                    } else {
                        BluetoothAdapter adapter = bluetoothManager.getAdapter();
                        if (adapter == null || adapter.isEnabled()) {
                            we.h.h("NearGattService", "Starting GATT server");
                            if (bluetoothManager.getAdapter() == null) {
                                we.h.j("NearGattService", "Bluetooth is not supported");
                            } else {
                                PackageManager packageManager = context.getPackageManager();
                                if (packageManager != null && !packageManager.hasSystemFeature("android.hardware.bluetooth_le")) {
                                    we.h.j("NearGattService", "Bluetooth LE is not supported");
                                } else if (lVar.f4153g) {
                                    if (we.m.e(515)) {
                                        we.m.c(515);
                                        we.h.b("NearGattService", "GATT server stop timer cancelled");
                                    }
                                    we.h.j("NearGattService", "GATT server already started");
                                } else {
                                    BluetoothGattServer bluetoothGattServerOpenGattServer = bluetoothManager.openGattServer(context, lVar.f4169z);
                                    lVar.e = bluetoothGattServerOpenGattServer;
                                    if (bluetoothGattServerOpenGattServer == null) {
                                        we.h.c("NearGattService", "Failed to create GATT server", null);
                                    } else {
                                        we.h.b("NearGattService", "GATT server opened successfully");
                                        UUID uuid = c6.f9688a;
                                        BluetoothGattService bluetoothGattService = new BluetoothGattService(c6.f9688a, 0);
                                        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(c6.f9689b, 12, 16);
                                        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = new BluetoothGattCharacteristic(c6.f9691d, 18, 1);
                                        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(c6.f, 17);
                                        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
                                        bluetoothGattCharacteristic2.addDescriptor(bluetoothGattDescriptor);
                                        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
                                        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic2);
                                        if (!lVar.k(bluetoothGattService)) {
                                            we.h.j("NearGattService", "Unable to add setupConnect service.");
                                        }
                                        lVar.f4153g = true;
                                        we.h.h("NearGattService", "GATT server started successfully");
                                    }
                                }
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("NearGattService", "tag");
                            Intrinsics.checkNotNullParameter("Bluetooth adapter is not enabled", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearGattService", "TransConnect:Bluetooth adapter is not enabled", null);
                            }
                        }
                    }
                }
                d dVar = this.f4121m;
                if (dVar == null || (fVar = dVar.f4094d) == null) {
                    return;
                }
                pe.d dVar2 = fVar.e;
                if (dVar2 == null) {
                    Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                    Intrinsics.checkNotNullParameter("startServer failed, mBluetoothConnection is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothServer", "TransConnect:startServer failed, mBluetoothConnection is null", null);
                        return;
                    }
                    return;
                }
                if (dVar2.q()) {
                    Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                    Intrinsics.checkNotNullParameter("startServer failed, mBluetoothConnection is already connected", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothServer", "TransConnect:startServer failed, mBluetoothConnection is already connected", null);
                        return;
                    }
                    return;
                }
                pe.d dVar3 = fVar.e;
                if (dVar3 != null && dVar3.f8809o) {
                    if (we.m.e(1027)) {
                        we.m.c(1027);
                        we.h.b("NearBluetoothServer", "GATT server stop timer cancelled");
                    }
                    we.h.j("NearBluetoothServer", "GATT server already started");
                    return;
                }
                if (dVar3 != null) {
                    if (dVar3.f8809o) {
                        we.h.b("BluetoothConnection", "Server already started");
                    } else {
                        dVar3.f8809o = true;
                        dVar3.v();
                    }
                }
            }
        }
    }

    public final void t(byte[] bArr) {
        byte[] byteArray;
        byte[] bArr2 = bArr;
        m mVar = this.f4117i;
        if (mVar != null) {
            if (mVar.f4181o) {
                we.h.j("NearLanManager", "startDiscovery: already started");
                return;
            }
            b6 b6Var = mVar.f;
            if (b6Var != null) {
                if (bArr2 == null) {
                    byteArray = null;
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    int length = bArr2.length;
                    int i8 = 0;
                    while (i8 < length) {
                        byte b9 = bArr2[i8];
                        Map map = b6Var.f9670j;
                        if (b9 == 0 || b9 == 8) {
                            if (!map.containsKey("_tranCast._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 1) {
                            if (!map.containsKey("_tranFile._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 5 || b9 == 4) {
                            if (!map.containsKey("_tranUcHo._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 9) {
                            if (!map.containsKey("_tranExtendCast._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 10) {
                            if (!map.containsKey("_tranAudioSink._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 11) {
                            if (!map.containsKey("_tranKeyboardMouseShare._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 12) {
                            if (!map.containsKey("_tranCallShare._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 == 13) {
                            if (!map.containsKey("_tranCameraShare._tcp")) {
                                linkedHashSet.add(Byte.valueOf(b9));
                                if (linkedHashSet.size() >= 2) {
                                    linkedHashSet.add((byte) -5);
                                }
                            }
                        } else if (b9 != -5) {
                            we.h.j("TranLanController", "getUnDiscoveredServices: unknown service type: " + ((int) b9));
                        } else if (!map.containsKey("_tran._tcp")) {
                            linkedHashSet.add(Byte.valueOf(b9));
                        }
                        i8++;
                        bArr2 = bArr;
                    }
                    byteArray = CollectionsKt.toByteArray(linkedHashSet);
                }
                if (byteArray == null || byteArray.length == 0) {
                    we.h.j("TranLanController", "startDiscovery: device is discovering already");
                    return;
                }
                we.h.b("TranLanController", "startDiscovery");
                for (byte b10 : byteArray) {
                    NsdManager nsdManager = b6Var.e;
                    if (b10 == 0 || b10 == 8) {
                        s5 s5Var = new s5(b6Var, "_tranCast._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranCast._tcp", 1, s5Var);
                        }
                        b6Var.l();
                    } else if (b10 == 1) {
                        s5 s5Var2 = new s5(b6Var, "_tranFile._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranFile._tcp", 1, s5Var2);
                        }
                        b6Var.l();
                    } else if (b10 == 5 || b10 == 4) {
                        s5 s5Var3 = new s5(b6Var, "_tranUcHo._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranUcHo._tcp", 1, s5Var3);
                        }
                        b6Var.l();
                    } else if (b10 == 9) {
                        s5 s5Var4 = new s5(b6Var, "_tranExtendCast._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranExtendCast._tcp", 1, s5Var4);
                        }
                        b6Var.l();
                    } else if (b10 == 10) {
                        s5 s5Var5 = new s5(b6Var, "_tranAudioSink._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranAudioSink._tcp", 1, s5Var5);
                        }
                        b6Var.l();
                    } else if (b10 == 11) {
                        s5 s5Var6 = new s5(b6Var, "_tranKeyboardMouseShare._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranKeyboardMouseShare._tcp", 1, s5Var6);
                        }
                        b6Var.l();
                    } else if (b10 == 12) {
                        s5 s5Var7 = new s5(b6Var, "_tranCallShare._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranCallShare._tcp", 1, s5Var7);
                        }
                        b6Var.l();
                    } else if (b10 == 13) {
                        s5 s5Var8 = new s5(b6Var, "_tranCameraShare._tcp");
                        if (nsdManager != null) {
                            nsdManager.discoverServices("_tranCameraShare._tcp", 1, s5Var8);
                        }
                        b6Var.l();
                    } else if (b10 == -5) {
                        b6Var.l();
                    } else {
                        h0.a.C(b10, "startDiscovery: unknown service type: ", "TranLanController");
                    }
                }
                b6Var.f9675o = true;
            }
        }
    }

    public final void u() {
        ArrayList arrayList;
        df.m mVar;
        ArrayList arrayList2;
        df.m mVar2;
        ArrayList arrayList3;
        df.m mVar3;
        ArrayList arrayList4;
        df.m mVar4;
        ArrayList arrayList5;
        df.m mVar5;
        ArrayList arrayList6;
        df.m mVar6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        df.m mVar7;
        ArrayList arrayList9;
        ArrayList arrayList10;
        df.m mVar8;
        ArrayList arrayList11;
        ArrayList arrayList12;
        int i8 = 1;
        df.m mVar9 = new df.m(6);
        mVar9.f4459c = -100;
        ArrayList arrayList13 = new ArrayList();
        byte[] bArr = this.f4125s;
        byte b9 = -1;
        byte b10 = 0;
        if (bArr != null) {
            int length = bArr.length;
            int i9 = 0;
            while (i9 < length) {
                byte b11 = bArr[i9];
                if (b11 != b9) {
                    int iM177constructorimpl = UByte.m177constructorimpl(b11) & UByte.MAX_VALUE;
                    if (iM177constructorimpl == 0) {
                        arrayList13.add((byte) 10);
                    } else {
                        if ((i8 <= iM177constructorimpl && iM177constructorimpl < 7) || (9 <= iM177constructorimpl && iM177constructorimpl < 14)) {
                            if (!arrayList13.contains((byte) 18)) {
                                arrayList13.add((byte) 18);
                            }
                            if (!arrayList13.contains((byte) 13)) {
                                arrayList13.add((byte) 13);
                            }
                            if (!arrayList13.contains((byte) 15)) {
                                arrayList13.add((byte) 15);
                            }
                            if (!arrayList13.contains((byte) 21)) {
                                arrayList13.add((byte) 21);
                            }
                            if (!arrayList13.contains((byte) 7)) {
                                arrayList13.add((byte) 7);
                            }
                            if (!arrayList13.contains((byte) 10)) {
                                arrayList13.add((byte) 10);
                            }
                            if (!arrayList13.contains((byte) 22)) {
                                arrayList13.add((byte) 22);
                            }
                            if (!arrayList13.contains((byte) 23)) {
                                arrayList13.add((byte) 23);
                            }
                            if (!arrayList13.contains((byte) 24)) {
                                arrayList13.add((byte) 24);
                            }
                        } else if (iM177constructorimpl == 15) {
                            if (!arrayList13.contains(Byte.valueOf(b10))) {
                                arrayList13.add(Byte.valueOf(b10));
                            }
                            if (!arrayList13.contains((byte) 1)) {
                                arrayList13.add((byte) 1);
                            }
                            if (!arrayList13.contains((byte) 2)) {
                                arrayList13.add((byte) 2);
                            }
                            if (!arrayList13.contains((byte) 20)) {
                                arrayList13.add((byte) 20);
                            }
                        } else if (iM177constructorimpl == 8 || iM177constructorimpl == 251) {
                            if (!arrayList13.contains((byte) 18)) {
                                arrayList13.add((byte) 18);
                            }
                            if (!arrayList13.contains((byte) 13)) {
                                arrayList13.add((byte) 13);
                            }
                            if (!arrayList13.contains((byte) 15)) {
                                arrayList13.add((byte) 15);
                            }
                            if (!arrayList13.contains((byte) 21)) {
                                arrayList13.add((byte) 21);
                            }
                            if (!arrayList13.contains((byte) 7)) {
                                arrayList13.add((byte) 7);
                            }
                            if (!arrayList13.contains((byte) 10)) {
                                arrayList13.add((byte) 10);
                            }
                            if (!arrayList13.contains((byte) 0)) {
                                arrayList13.add((byte) 0);
                            }
                            if (!arrayList13.contains((byte) 1)) {
                                arrayList13.add((byte) 1);
                            }
                            if (!arrayList13.contains((byte) 2)) {
                                arrayList13.add((byte) 2);
                            }
                            if (!arrayList13.contains((byte) 20)) {
                                arrayList13.add((byte) 20);
                            }
                            if (!arrayList13.contains((byte) 22)) {
                                arrayList13.add((byte) 22);
                            }
                            if (!arrayList13.contains((byte) 23)) {
                                arrayList13.add((byte) 23);
                            }
                            if (!arrayList13.contains((byte) 24)) {
                                arrayList13.add((byte) 24);
                            }
                        } else {
                            String strM = o.d.m("Unknown Scenario Type ", "NearConnectionService", "tag", "mes", b11);
                            if (lb.f6529c >= 1) {
                                h0.a.x("TransConnect:", strM, "NearConnectionService", null);
                            }
                        }
                        i8 = 1;
                    }
                }
                i9 += i8;
                b9 = -1;
                b10 = 0;
            }
        }
        mVar9.f4460d = arrayList13;
        byte[] bArr2 = this.f4125s;
        mVar9.f4458b = bArr2 != null ? ArraysKt.toList(bArr2) : null;
        we.h.c("NearConnectionService", "filter setting: " + ((ArrayList) mVar9.f4460d), null);
        mVar9.f4459c = -200;
        h5 h5Var = this.f4115g;
        if (h5Var != null) {
            synchronized (h5Var.f9783n) {
                h5Var.f9774c = true;
                Unit unit = Unit.INSTANCE;
            }
        }
        we.h.c("NearConnectionService", "Kolun Enable is false", null);
        ne.f fVar = this.f4120l;
        if (fVar != null) {
            lc.a scanResultCallBack = this.K;
            Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
            Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
            we.h.h("BleScanTool", "startScanAndConnect......");
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                Intrinsics.checkNotNullParameter("mBluetoothAdapter为null，本机可能不支持蓝牙", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "mBluetoothAdapter为null，本机可能不支持蓝牙", null);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!defaultAdapter.isEnabled()) {
                    we.h.g("蓝牙没打开，现在开启蓝牙......");
                    defaultAdapter.enable();
                }
                int iCurrentTimeMillis = 0;
                while (!defaultAdapter.isEnabled() && iCurrentTimeMillis < 6) {
                    iCurrentTimeMillis = (int) ((System.currentTimeMillis() - jCurrentTimeMillis) / ((long) 1000));
                }
                if (defaultAdapter.isEnabled() || iCurrentTimeMillis < 6) {
                    we.h.g("蓝牙开启成功！");
                    fVar.e = mVar9;
                    fVar.f8199g = scanResultCallBack;
                    ScanFilter.Builder builder = new ScanFilter.Builder();
                    df.m mVar10 = fVar.e;
                    if ((mVar10 != null ? (ArrayList) mVar10.f4460d : null) == null) {
                        Intrinsics.checkNotNullParameter("BleScanTool", "tag");
                        Intrinsics.checkNotNullParameter("startScanAndConnect: Please Configure Scan Filter Or Set mIsNeedAllScanResult to true", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("BleScanTool", "TransConnect:startScanAndConnect: Please Configure Scan Filter Or Set mIsNeedAllScanResult to true", null);
                            return;
                        }
                        return;
                    }
                    if (mVar10 == null || (arrayList = (ArrayList) mVar10.f4460d) == null || !(!arrayList.isEmpty())) {
                        builder.setServiceUuid(null);
                        builder.setManufacturerData(-1, null);
                    } else {
                        we.h.h("BleScanTool", "mIsNeedAllScanResult: false, setServiceUuid for scan filter");
                        df.m mVar11 = fVar.e;
                        Byte b12 = (mVar11 == null || (arrayList12 = (ArrayList) mVar11.f4460d) == null) ? null : (Byte) CollectionsKt.firstOrNull((List) arrayList12);
                        if ((b12 == null || b12.byteValue() != 10) && ((mVar = fVar.e) == null || (arrayList10 = (ArrayList) mVar.f4460d) == null || !arrayList10.contains((byte) 10) || (mVar8 = fVar.e) == null || (arrayList11 = (ArrayList) mVar8.f4460d) == null || arrayList11.size() != 1)) {
                            df.m mVar12 = fVar.e;
                            if (mVar12 == null || (arrayList8 = (ArrayList) mVar12.f4460d) == null || !arrayList8.contains((byte) 16) || (mVar7 = fVar.e) == null || (arrayList9 = (ArrayList) mVar7.f4460d) == null || arrayList9.size() != 1) {
                                df.m mVar13 = fVar.e;
                                if (mVar13 == null || (arrayList2 = (ArrayList) mVar13.f4460d) == null || arrayList2.contains((byte) 16) || (mVar2 = fVar.e) == null || (arrayList3 = (ArrayList) mVar2.f4460d) == null || arrayList3.contains((byte) 10) || (mVar3 = fVar.e) == null || (arrayList4 = (ArrayList) mVar3.f4460d) == null || arrayList4.contains((byte) 18) || (mVar4 = fVar.e) == null || (arrayList5 = (ArrayList) mVar4.f4460d) == null || arrayList5.contains((byte) 13) || (mVar5 = fVar.e) == null || (arrayList6 = (ArrayList) mVar5.f4460d) == null || arrayList6.contains((byte) 15) || (mVar6 = fVar.e) == null || (arrayList7 = (ArrayList) mVar6.f4460d) == null || arrayList7.contains((byte) 21)) {
                                    we.h.h("BleScanTool", "Not set filer for both manu id and service id set");
                                    builder.setServiceUuid(null);
                                    builder.setManufacturerData(-1, null);
                                } else {
                                    builder.setServiceUuid(new ParcelUuid(fVar.f8197c));
                                }
                            } else {
                                builder.setManufacturerData(z6.f10085a, new byte[0]);
                            }
                        } else if (Build.VERSION.SDK_INT < 35) {
                            we.h.h("BleScanTool", "setServiceUuid for below api 35 vanilla");
                            builder.setServiceData(new ParcelUuid(fVar.f8197c), new byte[0]);
                        } else {
                            we.h.h("BleScanTool", "setServiceData for equal or above api 35 vanilla");
                            builder.setServiceUuid(null);
                            builder.setManufacturerData(-1, null);
                        }
                    }
                    fVar.f8198d.add(builder.build());
                    we.h.h("BleScanTool", "startScanAndConnect: now start scan......");
                    we.h.h("BleScanTool", "startScanAndConnect: now use system api to start scan ......");
                    if (fVar.f == null) {
                        fVar.f = ((BluetoothManager) fVar.f8195a.getSystemService(BluetoothManager.class)).getAdapter().getBluetoothLeScanner();
                    }
                    BluetoothLeScanner bluetoothLeScanner = fVar.f;
                    if (bluetoothLeScanner != null) {
                        bluetoothLeScanner.startScan(fVar.f8198d, new ScanSettings.Builder().setScanMode(2).setLegacy(false).build(), fVar.f8203k);
                        return;
                    }
                    return;
                }
                Intrinsics.checkNotNullParameter("蓝牙开启超过6s，开启超时，退出！", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "蓝牙开启超过6s，开启超时，退出！", null);
                }
            }
            Intrinsics.checkNotNullParameter("BleScanTool", "tag");
            Intrinsics.checkNotNullParameter("startScanAndConnect: 蓝牙开启超时，退出！", "mes");
            if (lb.f6529c >= 1) {
                Log.e("BleScanTool", "TransConnect:startScanAndConnect: 蓝牙开启超时，退出！", null);
            }
        }
    }

    public final void v() {
        Context context;
        Context context2;
        Object systemService = this.f4111a.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        boolean zIsWifiEnabled = ((WifiManager) systemService).isWifiEnabled();
        k6 k6Var = this.f4118j;
        if (zIsWifiEnabled && k6Var != null) {
            WifiManager wifiManager = k6Var.f9844b;
            if (wifiManager != null) {
                wifiManager.startScan();
            }
            if (!k6Var.e && (context2 = k6Var.f9843a) != null) {
                context2.registerReceiver(k6Var.f, new IntentFilter("android.net.wifi.SCAN_RESULTS"), 2);
                k6Var.e = true;
            }
        }
        if (k6Var == null || k6Var.e || (context = k6Var.f9843a) == null) {
            return;
        }
        context.registerReceiver(k6Var.f, new IntentFilter("android.net.wifi.SCAN_RESULTS"), 2);
        k6Var.e = true;
    }

    public final void w(Intent intent, int i8) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        o.e eVar = new o.e(this, intent, i8, 6);
        d1 d1Var = this.A;
        if (d1Var != null) {
            d1Var.f(eVar);
        }
    }

    public final void x(int i8) {
        Integer numS;
        Integer numS2;
        Integer numS3;
        we.h.c("NearConnectionService", "stop Device", null);
        if (i8 != 2 && i8 != 4 && i8 != 0) {
            we.h.c("NearConnectionService", "Unknown Stop Event value " + i8, null);
            return;
        }
        if (i8 == 0) {
            this.G = true;
            this.F = true;
            this.E = true;
            this.D = true;
            q(false);
            h5 h5Var = this.f4115g;
            if (h5Var != null) {
                h5Var.f9779j = false;
            }
            if (h5Var != null) {
                h5Var.f9781l = false;
            }
            if (h5Var != null) {
                h5Var.f9778i = false;
            }
        } else if (i8 == 2) {
            this.H = true;
        } else if (i8 == 4) {
            this.I = true;
        }
        Intrinsics.checkNotNullParameter("NearConnectionService", "tag");
        Intrinsics.checkNotNullParameter("reset Device", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearConnectionService", "TransConnect:reset Device", null);
        }
        if (i8 == 0 || i8 == 2 || i8 == 4 || i8 == 3) {
            if (this.e) {
                this.e = false;
                this.f4111a.unregisterReceiver(this.f4114d);
            }
            this.B = false;
            l(false);
        } else {
            String strM = o.d.m("Unknown Reset Event value ", "NearConnectionService", "tag", "mes", i8);
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", strM, "NearConnectionService", null);
            }
        }
        this.f4131z = Boolean.FALSE;
        h5 h5Var2 = this.f4115g;
        if (h5Var2 != null) {
            h5Var2.f9777h = false;
        }
        m mVar = this.f4117i;
        if (mVar != null && (i8 == 0 || i8 == 4)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 20480;
            messageObtain.arg1 = 0;
            Intrinsics.checkNotNull(messageObtain);
            mVar.i(messageObtain);
        }
        a aVar = this.f4119k;
        if (aVar != null) {
            aVar.y();
        }
        we.h.c("NearConnectionService", "cleanup", null);
        a4 a4Var = this.f4116h;
        if (a4Var != null) {
            we.h.g("cleanup");
            a0 a0Var = a4Var.f9644d;
            Integer numValueOf = a0Var != null ? Integer.valueOf(a0Var.f4035d) : null;
            b0 b0Var = a4Var.f9643c;
            Integer numValueOf2 = b0Var != null ? Integer.valueOf(b0Var.f4054d) : null;
            if (i8 != 0) {
                if (i8 == 2) {
                    if (numValueOf != null && numValueOf.intValue() != 0) {
                        if (numValueOf.intValue() < 3) {
                            a0 a0Var2 = a4Var.f9644d;
                            if (a0Var2 != null) {
                                a0Var2.l(3);
                            }
                        } else {
                            a0 a0Var3 = a4Var.f9644d;
                            if (a0Var3 != null) {
                                a0Var3.l(4);
                            }
                        }
                    }
                    if (numValueOf2 != null && numValueOf2.intValue() != 0) {
                        if (numValueOf2.intValue() < 3) {
                            b0 b0Var2 = a4Var.f9643c;
                            if (b0Var2 != null) {
                                b0Var2.k(3);
                            }
                        } else {
                            b0 b0Var3 = a4Var.f9643c;
                            if (b0Var3 != null) {
                                b0Var3.k(4);
                            }
                        }
                    }
                    if (numValueOf != null && numValueOf.intValue() == 0 && numValueOf2 != null && numValueOf2.intValue() == 0 && a4Var.s() != null && ((numS2 = a4Var.s()) == null || numS2.intValue() != 0)) {
                        we.h.b("NearLaptopManager", "Get Bluetooth Adapter Off");
                        o4 o4Var = a4Var.e;
                        if (o4Var != null) {
                            o4Var.l(4);
                        }
                        o4 o4Var2 = a4Var.f;
                        if (o4Var2 != null) {
                            o4Var2.l(4);
                        }
                    }
                } else if (i8 == 4) {
                    if (numValueOf != null && numValueOf.intValue() != 0) {
                        a0 a0Var4 = a4Var.f9644d;
                        if (a0Var4 != null) {
                            a0Var4.l(1);
                        }
                    } else if (numValueOf2 != null && numValueOf2.intValue() != 0) {
                        b0 b0Var4 = a4Var.f9643c;
                        if (b0Var4 != null) {
                            b0Var4.k(1);
                        }
                    } else if (a4Var.s() != null && ((numS3 = a4Var.s()) == null || numS3.intValue() != 0)) {
                        o4 o4Var3 = a4Var.e;
                        if (o4Var3 != null) {
                            o4Var3.l(1);
                        }
                        o4 o4Var4 = a4Var.f;
                        if (o4Var4 != null) {
                            o4Var4.l(1);
                        }
                    }
                }
            } else if (a4Var.s() != null && ((numS = a4Var.s()) == null || numS.intValue() != 0)) {
                a4Var.l();
            } else if (numValueOf2 != null && numValueOf2.intValue() != 0) {
                b0 b0Var5 = a4Var.f9643c;
                if (b0Var5 != null) {
                    b0Var5.k(0);
                }
            } else if (numValueOf == null || numValueOf.intValue() == 0) {
                we.h.d("Smart Config Disable but no device is connected", null);
            } else {
                a0 a0Var5 = a4Var.f9644d;
                if (a0Var5 != null) {
                    a0Var5.l(0);
                }
            }
        }
        a aVar2 = this.f4119k;
        if (aVar2 != null) {
            aVar2.y();
        }
        if (i8 == 0) {
            this.f4125s = null;
            this.p = -1;
            this.f4128w = null;
            this.f4126t = -1;
            Intent intent = new Intent("com.welink.service.ACTION_NEAR_SERVICE_DEACTIVATED");
            intent.putExtra("com.welink.service.EXTRA_NEAR_SERVICE_ENABLED", 0);
            this.f4112b.j(intent);
        }
    }

    public final void y() {
        b6 b6Var;
        m mVar = this.f4117i;
        if (mVar == null || (b6Var = mVar.f) == null) {
            return;
        }
        if (b6Var.f9670j.isEmpty()) {
            we.h.j("TranLanController", "stopDiscovery: device isn't discovering");
            return;
        }
        we.h.b("TranLanController", "stopDiscovery");
        b6Var.f9675o = false;
        b6Var.f9673m.clear();
        synchronized (b6Var.p) {
            try {
                Iterator it = MapsKt.toList(b6Var.p).iterator();
                while (it.hasNext()) {
                    v5 v5Var = (v5) ((Pair) it.next()).component2();
                    b6Var.s(v5Var);
                    z5 z5Var = b6Var.f9676r;
                    if (z5Var != null) {
                        z5Var.g(v5Var);
                    }
                }
                b6Var.p.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (b6Var.f9671k) {
            try {
                for (s5 s5Var : CollectionsKt.toList(b6Var.f9671k)) {
                    NsdManager nsdManager = b6Var.e;
                    if (nsdManager != null) {
                        nsdManager.stopServiceDiscovery(s5Var);
                    }
                }
                b6Var.f9671k.clear();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void z() {
        we.h.j("NearConnectionService", "stopScan");
        h5 h5Var = this.f4115g;
        if (h5Var != null) {
            synchronized (h5Var.f9783n) {
                h5Var.f9774c = false;
                Unit unit = Unit.INSTANCE;
            }
        }
        ne.f fVar = this.f4120l;
        if (fVar != null) {
            BluetoothAdapter bluetoothAdapter = fVar.f8196b;
            if (bluetoothAdapter == null) {
                Intrinsics.checkNotNullParameter("BleScanTool", "tag");
                Intrinsics.checkNotNullParameter("stopScan: mBluetoothAdapter为null，本机可能不支持蓝牙", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BleScanTool", "TransConnect:stopScan: mBluetoothAdapter为null，本机可能不支持蓝牙", null);
                    return;
                }
                return;
            }
            if (bluetoothAdapter.isEnabled()) {
                fVar.f(0);
                return;
            }
            Intrinsics.checkNotNullParameter("BleScanTool", "tag");
            Intrinsics.checkNotNullParameter("stopScan: 蓝牙没开，啥都不做", "mes");
            if (lb.f6529c >= 1) {
                Log.e("BleScanTool", "TransConnect:stopScan: 蓝牙没开，啥都不做", null);
            }
        }
    }
}
