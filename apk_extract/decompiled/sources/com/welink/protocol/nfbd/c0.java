package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import java.util.LinkedHashMap;
import k3.id;
import k3.lb;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import se.c7;
import se.g5;
import se.r4;
import se.s6;
import se.t6;
import se.u0;
import se.u6;
import se.v6;
import se.w6;
import se.x6;
import se.y6;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u0 f4087g = new u0(t6.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4088a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7 f4089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f4090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r4 f4091d;
    public sb.a e;
    public id f;

    public c0(Context context) {
        new LinkedHashMap();
        new LinkedHashMap();
        u0 u0Var = c7.f;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f4089b = (c7) u0Var.b(applicationContext);
        u0 u0Var2 = z.f4202l;
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        this.f4090c = (z) u0Var2.b(applicationContext2);
        this.f = u6.f10019a;
    }

    public static String c(id idVar) {
        if (Intrinsics.areEqual(idVar, u6.f10019a)) {
            return "Off";
        }
        if (Intrinsics.areEqual(idVar, y6.f10070a)) {
            return "TurningOn";
        }
        if (Intrinsics.areEqual(idVar, v6.f10038a)) {
            return "On";
        }
        if (Intrinsics.areEqual(idVar, x6.f10059a)) {
            return "TurningOff";
        }
        return Intrinsics.areEqual(idVar, w6.f10047a) ? "Pause" : "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    public final void a(TranConnectionController$MessageInfo tranConnectionController$MessageInfo, Function1 function1) {
        Parcelable parcelable;
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        boolean z2 = ((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof NearDevice;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if (!z2) {
            parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
            if (parcelable != null) {
                boolean z3 = parcelable instanceof BluetoothDevice;
                return;
            }
            return;
        }
        Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
        NearDevice nearDevice = (NearDevice) obj;
        parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
        if (parcelable != null && (parcelable instanceof BluetoothDevice)) {
            h0.a.D("Found LE device disconnected ", ((BluetoothDevice) parcelable).getAddress(), "TransSmartConnect");
        }
        h0.a.D("Disconnected LE device ", nearDevice.f3883a, "TransSmartConnect");
        if (nearDevice.e != 0) {
            we.h.b("TransSmartConnect", "Bypass unknown device");
            return;
        }
        int i8 = tranConnectionController$EventInfo.f3966c;
        boolean z5 = false;
        boolean z10 = true;
        if (i8 != -3 && i8 != -2 && i8 != -1 && i8 != 0) {
            if (i8 == 1) {
                we.h.b("TransSmartConnect", "Notify->Smart Config Disabled, mCurrentState: ".concat(c(this.f)));
            } else if (i8 == 3) {
                we.h.j("TransSmartConnect", "P2p Disconnect Callback, Passive Mode");
            } else if (i8 != 6) {
                switch (i8) {
                    case 9:
                    case 10:
                        z5 = false;
                        break;
                    case 11:
                        we.h.j("TransSmartConnect", "Disconnect Remote P2P Device Timeout, Passive mode");
                        z5 = false;
                        break;
                    case 12:
                        we.h.j("TransSmartConnect", "Notify: P2p is Connecting, got BT OFF event");
                        break;
                    case 13:
                    case 14:
                    case 16:
                    case 17:
                        h0.a.C(i8, "Connect Failed, Reason code: ", "TransSmartConnect");
                        z5 = false;
                        break;
                    case 15:
                        z5 = true;
                        break;
                    case 18:
                        if (function1 == null) {
                            z5 = false;
                        } else {
                            z5 = true;
                            z10 = z5;
                        }
                        break;
                }
            } else if (function1 == null) {
                z5 = true;
                z10 = z5;
            } else {
                z5 = false;
            }
            z10 = z5;
        } else if (function1 == null) {
            z5 = true;
            z10 = z5;
        } else {
            z5 = false;
        }
        g(nearDevice, z5, z10, z5);
    }

    public final void b(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        z manager = this.f4090c;
        if (manager != null) {
            device.getClass();
            Intrinsics.checkNotNullParameter(manager, "manager");
            if (device.I.h(device, manager)) {
                we.h.b("TransSmartConnect", "Flush device Success");
                return;
            }
            Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
            Intrinsics.checkNotNullParameter("Flush device Failed", "mes");
            if (lb.f6529c >= 1) {
                Log.e("TransSmartConnect", "TransConnect:Flush device Failed", null);
            }
        }
    }

    public final int d() {
        int i8;
        id idVar = this.f;
        c7 c7Var = this.f4089b;
        Integer numValueOf = null;
        if (c7Var != null) {
            boolean z2 = c7Var.f9696d;
            we.h.h("TranssionBluetoothManager", "state : " + z2);
            BluetoothAdapter bluetoothAdapter = c7Var.f9694b;
            Boolean boolValueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.isEnabled()) : null;
            WifiManager wifiManager = c7Var.f9695c;
            Boolean boolValueOf2 = wifiManager != null ? Boolean.valueOf(wifiManager.isWifiEnabled()) : null;
            if (z2 && Intrinsics.areEqual(boolValueOf2, Boolean.FALSE) && Intrinsics.areEqual(boolValueOf, Boolean.TRUE)) {
                i8 = 3;
            } else if (z2 && Intrinsics.areEqual(boolValueOf, Boolean.FALSE) && Intrinsics.areEqual(boolValueOf2, Boolean.TRUE)) {
                i8 = 2;
            } else {
                i8 = z2 ? 1 : 0;
            }
            numValueOf = Integer.valueOf(i8);
        }
        if (Intrinsics.areEqual(idVar, u6.f10019a)) {
            return 0;
        }
        if (Intrinsics.areEqual(idVar, v6.f10038a)) {
            return 1;
        }
        if (Intrinsics.areEqual(idVar, w6.f10047a)) {
            if (numValueOf != null && numValueOf.intValue() == 2) {
                return 2;
            }
            return (numValueOf != null && numValueOf.intValue() == 3) ? 3 : -1;
        }
        if (Intrinsics.areEqual(idVar, y6.f10070a)) {
            return 4;
        }
        if (Intrinsics.areEqual(idVar, x6.f10059a)) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void e(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDeviceDataParcel nearDeviceDataParcel;
        tranConnectionController$MessageInfo.getClass();
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        boolean z2 = (nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice;
        z zVar = this.f4090c;
        if (!z2) {
            if (zVar != null) {
                zVar.k(false);
                return;
            }
            return;
        }
        Object obj = nearDeviceDataParcel2.f3903a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        if (!(((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof TranConnectionController$P2pDeviceInfo)) {
            Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
            Intrinsics.checkNotNullParameter("Incorrect reported data type, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("TransSmartConnect", "TransConnect:Incorrect reported data type, ignore", null);
                return;
            }
            return;
        }
        Object obj2 = tranConnectionController$EventInfo.f3968h.f3903a;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
        we.h.h("TransSmartConnect", "P2p Device Connected, Device Info:" + ((TranConnectionController$P2pDeviceInfo) obj2));
        if (zVar != null) {
            zVar.k(true);
        }
    }

    public final void f(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        if (((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof NearDevice) {
            Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
            NearDevice nearDevice = (NearDevice) obj;
            NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
            Parcelable parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
            if (parcelable != null) {
                boolean z2 = parcelable instanceof BluetoothDevice;
            }
            if (nearDevice.e != 0) {
                we.h.b("TransSmartConnect", "Bypass unknown device");
            } else if (tranConnectionController$EventInfo.f3966c == 5) {
                we.h.j("TransSmartConnect", "P2p Disconnect Successfully, Passive Mode");
                g(nearDevice, false, true, false);
            }
        }
    }

    public final void g(NearDevice nearDevice, boolean z2, boolean z3, boolean z5) {
        z zVar = this.f4090c;
        if ((nearDevice != null && nearDevice.f3890k == 0) || (nearDevice != null && nearDevice.f3890k == 12)) {
            if ((z2 || z3 || z5) && zVar != null) {
                zVar.r(1);
                return;
            }
            return;
        }
        if (((nearDevice == null || nearDevice.f3890k != 10) && (nearDevice == null || nearDevice.f3890k != 11)) || !z3 || zVar == null) {
            return;
        }
        zVar.r(2);
    }

    public final void h() {
        if (Intrinsics.areEqual(this.f, y6.f10070a) || Intrinsics.areEqual(this.f, u6.f10019a) || Intrinsics.areEqual(this.f, w6.f10047a)) {
            l(v6.f10038a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0195 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:115:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ab A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c2 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01c6 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x01d1 A[Catch: all -> 0x0081, TRY_ENTER, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01e3 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0111 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0115 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:4:0x0010, B:6:0x0015, B:13:0x0024, B:15:0x0028, B:20:0x0034, B:24:0x004e, B:35:0x0065, B:36:0x0068, B:38:0x007a, B:41:0x0084, B:45:0x008c, B:46:0x008f, B:48:0x00a1, B:51:0x00a8, B:53:0x00ae, B:55:0x00c0, B:58:0x00c7, B:60:0x00d2, B:61:0x00d4, B:63:0x00d8, B:64:0x00e3, B:66:0x00e9, B:68:0x00fb, B:71:0x0102, B:73:0x0106, B:74:0x0111, B:76:0x0115, B:77:0x0120, B:84:0x012d, B:86:0x0133, B:88:0x0145, B:91:0x014c, B:93:0x0157, B:94:0x0159, B:96:0x015d, B:97:0x0168, B:99:0x016e, B:101:0x0180, B:104:0x0187, B:106:0x018b, B:107:0x0195, B:118:0x01ab, B:121:0x01c2, B:123:0x01c6, B:126:0x01d1, B:128:0x01e3, B:131:0x01ea), top: B:136:0x0010 }] */
    public final boolean i(NearDevice device, sb.a aVar) {
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        g5 g5Var;
        z zVar;
        int i8;
        z zVar2;
        Intrinsics.checkNotNullParameter(device, "device");
        synchronized (this.f4088a) {
            try {
                Integer num = device.f3898v;
                if (!((num != null ? num.intValue() : -1) == -1)) {
                    Integer num2 = device.f3898v;
                    int iIntValue = num2 != null ? num2.intValue() : -1;
                    if (iIntValue < 1003 || iIntValue > 1005) {
                        z2 = false;
                    } else {
                        we.h.b("TransSmartConnect", "TransSmartConnect: Device is busy, state: " + iIntValue);
                        z2 = true;
                    }
                    if (!z2) {
                        int i9 = device.e;
                        if (i9 == 0) {
                            int i10 = device.f3890k;
                            if (i10 == 0 || i10 == 1) {
                                str = device.f3883a;
                                str2 = device.f3885c;
                                if (i10 != 0 || i10 == 1) {
                                    str3 = "bluetooth";
                                } else {
                                    str3 = "nfc";
                                }
                                str4 = str3;
                                if (str2 == null) {
                                    str = str2;
                                }
                                if (str != null) {
                                    g5Var = new g5(str, "Connect Notification", 1, 0L, str4, 51888, device);
                                } else {
                                    g5Var = null;
                                }
                                if (g5Var != null) {
                                    Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                    Intrinsics.checkNotNullParameter("Error: Invalid Device Address or Device Id", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TransSmartConnect", "TransConnect:Error: Invalid Device Address or Device Id", null);
                                    }
                                    return false;
                                }
                                zVar = this.f4090c;
                                if (zVar != null) {
                                    device.B(zVar, g5Var, new s6(this, aVar, 0));
                                }
                            } else if (i10 != 14) {
                                switch (i10) {
                                    case 10:
                                    case 11:
                                        WirelessDevice wirelessDevice = device.f3896s;
                                        if (!(wirelessDevice instanceof WirelessDevice.P2p)) {
                                            Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                            Intrinsics.checkNotNullParameter("Error: Invalid P2P Device", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("TransSmartConnect", "TransConnect:Error: Invalid P2P Device", null);
                                            }
                                            return false;
                                        }
                                        Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                                        WirelessDevice.P2p p2p = (WirelessDevice.P2p) wirelessDevice;
                                        if (p2p.f4016d < 0) {
                                            p2p.f4016d = 0;
                                        }
                                        z zVar3 = this.f4090c;
                                        if (zVar3 != null) {
                                            device.B(zVar3, null, new s6(this, aVar, 1));
                                        }
                                        break;
                                        break;
                                    case 12:
                                        str = device.f3883a;
                                        str2 = device.f3885c;
                                        if (i10 != 0) {
                                            str3 = "bluetooth";
                                        } else {
                                            str3 = "bluetooth";
                                        }
                                        str4 = str3;
                                        if (str2 == null) {
                                            str = str2;
                                        }
                                        if (str != null) {
                                            g5Var = new g5(str, "Connect Notification", 1, 0L, str4, 51888, device);
                                        } else {
                                            g5Var = null;
                                        }
                                        if (g5Var != null) {
                                            Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                            Intrinsics.checkNotNullParameter("Error: Invalid Device Address or Device Id", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("TransSmartConnect", "TransConnect:Error: Invalid Device Address or Device Id", null);
                                            }
                                            return false;
                                        }
                                        zVar = this.f4090c;
                                        if (zVar != null) {
                                            device.B(zVar, g5Var, new s6(this, aVar, 0));
                                        }
                                        break;
                                        break;
                                    default:
                                        return false;
                                }
                            } else {
                                if (!(device.f3896s instanceof WirelessDevice.Wlan)) {
                                    Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                    Intrinsics.checkNotNullParameter("Error: Invalid Wlan Device", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TransSmartConnect", "TransConnect:Error: Invalid Wlan Device", null);
                                    }
                                    return false;
                                }
                                z zVar4 = this.f4090c;
                                if (zVar4 != null) {
                                    device.B(zVar4, null, new s6(this, aVar, 2));
                                }
                            }
                        } else if (i9 != 1 && i9 != 4 && i9 != 5 && i9 != 8 && i9 != 251) {
                            switch (i9) {
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    i8 = device.f3890k;
                                    if (i8 == 0) {
                                        zVar2 = this.f4090c;
                                        if (zVar2 != null) {
                                            device.B(zVar2, null, new s6(this, aVar, 3));
                                        }
                                    } else {
                                        zVar2 = this.f4090c;
                                        if (zVar2 != null) {
                                            device.B(zVar2, null, new s6(this, aVar, 3));
                                        }
                                    }
                                    break;
                                default:
                                    Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                    Intrinsics.checkNotNullParameter("Unsupported ", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TransSmartConnect", "TransConnect:Unsupported ", null);
                                    }
                                    break;
                            }
                        } else {
                            i8 = device.f3890k;
                            if (i8 == 0 || i8 == 1) {
                                zVar2 = this.f4090c;
                                if (zVar2 != null) {
                                    device.B(zVar2, null, new s6(this, aVar, 3));
                                }
                            } else if (i8 != 14) {
                                switch (i8) {
                                    case 10:
                                    case 11:
                                        WirelessDevice wirelessDevice2 = device.f3896s;
                                        if (!(wirelessDevice2 instanceof WirelessDevice.P2p)) {
                                            Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                            Intrinsics.checkNotNullParameter("Error: Invalid P2P Device", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("TransSmartConnect", "TransConnect:Error: Invalid P2P Device", null);
                                            }
                                            return false;
                                        }
                                        Intrinsics.checkNotNull(wirelessDevice2, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                                        WirelessDevice.P2p p2p2 = (WirelessDevice.P2p) wirelessDevice2;
                                        if (p2p2.f4016d < 0) {
                                            p2p2.f4016d = 0;
                                        }
                                        z zVar5 = this.f4090c;
                                        if (zVar5 != null) {
                                            device.B(zVar5, null, new s6(this, aVar, 4));
                                        }
                                        break;
                                        break;
                                    case 12:
                                        zVar2 = this.f4090c;
                                        if (zVar2 != null) {
                                            device.B(zVar2, null, new s6(this, aVar, 3));
                                        }
                                        break;
                                    default:
                                        Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                        Intrinsics.checkNotNullParameter("Error: Invalid wireless type", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("TransSmartConnect", "TransConnect:Error: Invalid wireless type", null);
                                        }
                                        return false;
                                }
                            } else {
                                if (!(device.f3896s instanceof WirelessDevice.Wlan)) {
                                    Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                    Intrinsics.checkNotNullParameter("Error: Invalid Wlan Device", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TransSmartConnect", "TransConnect:Error: Invalid Wlan Device", null);
                                    }
                                    return false;
                                }
                                z zVar6 = this.f4090c;
                                if (zVar6 != null) {
                                    device.B(zVar6, null, new s6(this, aVar, 5));
                                }
                            }
                        }
                        return true;
                    }
                }
                we.h.b("TransSmartConnect", "TransSmartConnect, Device start connect busy, state: " + c(this.f) + ", wirelessType: " + device.f3890k);
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void j(TranConnectionController$MessageInfo tranConnectionController$MessageInfo, Function1 function1) {
        sb.a aVar;
        int i8 = tranConnectionController$MessageInfo.e;
        int i9 = tranConnectionController$MessageInfo.f3970b;
        String strC = c(this.f);
        StringBuilder sbR = o.d.r(i8, i9, "Event: Main Event: ", ", Sub event: ", ", state: ");
        sbR.append(strC);
        we.h.j("TransSmartConnect", sbR.toString());
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        Integer numValueOf = tranConnectionController$EventInfo != null ? Integer.valueOf(tranConnectionController$EventInfo.f3965b) : null;
        TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$MessageInfo.f3974i;
        Integer numValueOf2 = tranConnectionController$EventInfo2 != null ? Integer.valueOf(tranConnectionController$EventInfo2.f3966c) : null;
        we.h.j("TransSmartConnect", "Event: Main Event: " + numValueOf + ", Reason code: " + numValueOf2 + ", state: " + c(this.f));
        synchronized (this.f4088a) {
            try {
                TranConnectionController$EventInfo tranConnectionController$EventInfo3 = tranConnectionController$MessageInfo.f3974i;
                Integer numValueOf3 = tranConnectionController$EventInfo3 != null ? Integer.valueOf(tranConnectionController$EventInfo3.f3965b) : null;
                boolean z2 = false;
                if (numValueOf3 != null && numValueOf3.intValue() == 1) {
                    z zVar = this.f4090c;
                    if (zVar != null) {
                        zVar.k(true);
                    }
                } else if (numValueOf3 != null && numValueOf3.intValue() == 2) {
                    z zVar2 = this.f4090c;
                    if (zVar2 != null) {
                        zVar2.k(false);
                    }
                } else {
                    if (numValueOf3 != null && numValueOf3.intValue() == 10) {
                        we.h.j("TransSmartConnect", "Event: BLE Gatt Connected, request stop scan");
                        z zVar3 = this.f4090c;
                        if (zVar3 != null) {
                            Intent intent = new Intent();
                            intent.setAction("com.welink.protocol.nfbd.action.PAUSE_SCAN_DEVICE");
                            g gVar = zVar3.f4207i;
                            if (gVar != null) {
                                gVar.w(intent, 0);
                            }
                        }
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 6) {
                        int i10 = tranConnectionController$MessageInfo.f3970b;
                        if (i10 == 1 || i10 == 2 || i10 == 4) {
                            if (i10 == 2 && function1 == null) {
                                we.h.j("TransSmartConnect", "ConnectQR: Bluetooth was enabled, ignore");
                                z2 = true;
                            }
                            h();
                        }
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 5) {
                        we.h.j("TransSmartConnect", "Notify: Service was destroyed by android");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 4) {
                        int i11 = tranConnectionController$MessageInfo.f3970b;
                        if (i11 != 4) {
                            switch (i11) {
                                case 19:
                                    break;
                                case 20:
                                    id idVar = this.f;
                                    u6 u6Var = u6.f10019a;
                                    if (!Intrinsics.areEqual(idVar, u6Var)) {
                                        l(u6Var);
                                    }
                                    break;
                                case 21:
                                    break;
                                case 22:
                                    we.h.j("TransSmartConnect", "Reset and disconnect P2P Device Succeed");
                                    break;
                                case 23:
                                    we.h.j("TransSmartConnect", "Reset and disconnect P2P Device Busy, No p2p Group");
                                    break;
                                default:
                                    h();
                                    break;
                            }
                        } else if (function1 != null) {
                            h();
                        } else {
                            we.h.j("TransSmartConnect", "QR P2p Available");
                        }
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 11) {
                        we.h.h("TransSmartConnect", "Scan request Callback, Reason: " + tranConnectionController$MessageInfo.f3970b);
                        int i12 = tranConnectionController$MessageInfo.f3970b;
                        if (i12 != 1) {
                            we.h.h("TransSmartConnect", "Scan request failed: " + i12);
                            z zVar4 = this.f4090c;
                            if (zVar4 != null) {
                                Intent intent2 = new Intent();
                                intent2.setAction("com.welink.protocol.nfbd.action.STOP_SCAN_DEVICE");
                                g gVar2 = zVar4.f4207i;
                                if (gVar2 != null) {
                                    gVar2.w(intent2, 0);
                                }
                            }
                        }
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 14) {
                        we.h.h("TransSmartConnect", "Get Remote Exchange Request");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 15) {
                        we.h.h("TransSmartConnect", "Get Remote Exchange Notify");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 16) {
                        we.h.h("TransSmartConnect", "Get Remote Connect Notification");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 21) {
                        we.h.h("TransSmartConnect", "P2p Connected Event");
                        e(tranConnectionController$MessageInfo);
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 22) {
                        we.h.h("TransSmartConnect", "P2p Disconnected Event");
                        f(tranConnectionController$MessageInfo);
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 23) {
                        we.h.h("TransSmartConnect", "P2p Connect Failed Event");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 24) {
                        we.h.h("TransSmartConnect", "P2p Invite Event");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 25) {
                        we.h.h("TransSmartConnect", "P2p Disconnected Event");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 18) {
                        we.h.h("TransSmartConnect", "BLE connected now");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 19) {
                        we.h.h("TransSmartConnect", "BLE disconnected now");
                        a(tranConnectionController$MessageInfo, function1);
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 20) {
                        we.h.h("TransSmartConnect", "P2p Owner Available");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 27) {
                        we.h.h("TransSmartConnect", "Service Enabled");
                        h();
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 28) {
                        we.h.h("TransSmartConnect", "Service Disabled");
                        id idVar2 = this.f;
                        u6 u6Var2 = u6.f10019a;
                        if (!Intrinsics.areEqual(idVar2, u6Var2)) {
                            l(u6Var2);
                        }
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 30) {
                        we.h.h("TransSmartConnect", "P2p Other Device Connected");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 31) {
                        we.h.h("TransSmartConnect", "P2p Invitation Request");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 32) {
                        we.h.h("TransSmartConnect", "LAN connected now");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 33) {
                        we.h.h("TransSmartConnect", "LAN disconnected now");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 35) {
                        we.h.h("TransSmartConnect", "Advertise Start Success");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 36) {
                        we.h.h("TransSmartConnect", "Advertise Start Failed");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 37) {
                        we.h.h("TransSmartConnect", "Advertise Stop Success");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 38) {
                        we.h.h("TransSmartConnect", "Advertise Stop Failed");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 39) {
                        we.h.h("TransSmartConnect", "Trusted State Changed");
                    } else if (numValueOf3 != null && numValueOf3.intValue() == 40) {
                        we.h.h("TransSmartConnect", "Reject");
                    }
                    z2 = true;
                }
                if (z2 || function1 == null) {
                    if (!z2 && (aVar = this.e) != null) {
                        aVar.invoke(tranConnectionController$MessageInfo);
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    function1.invoke(tranConnectionController$MessageInfo);
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k(int i8) {
        c7 c7Var = this.f4089b;
        if (i8 == 0) {
            this.f4091d = null;
            if (c7Var != null) {
                c7Var.c(0);
                return;
            }
            return;
        }
        if (i8 == 1) {
            if (c7Var != null) {
                c7Var.c(1);
            }
        } else if (i8 == 2 || i8 == 3) {
            if (c7Var != null) {
                c7Var.c(i8);
            }
            id idVar = this.f;
            u6 u6Var = u6.f10019a;
            if (Intrinsics.areEqual(idVar, u6Var)) {
                return;
            }
            l(u6Var);
        }
    }

    public final void l(id idVar) {
        id idVar2 = this.f;
        this.f = idVar;
        we.h.b("TransSmartConnect", "state change from " + c(idVar2) + " -> " + c(this.f));
        if (idVar instanceof u6) {
            we.h.b("TransSmartConnect", "SmartConnect is off");
            return;
        }
        if (idVar instanceof w6) {
            we.h.b("TransSmartConnect", "SmartConnect is pause");
            return;
        }
        if (idVar instanceof v6) {
            we.h.b("TransSmartConnect", "SmartConnect is on");
            return;
        }
        if (!(idVar instanceof y6)) {
            if (!(idVar instanceof x6)) {
                throw new NoWhenBranchMatchedException();
            }
            int iD = d();
            if (iD != 1) {
                if (iD == 2) {
                    we.h.b("TransSmartConnect", "Turning off SmartConnect, but the bt is disabled");
                    k(2);
                    return;
                } else if (iD == 3) {
                    we.h.b("TransSmartConnect", "Turning off SmartConnect, but the wifi is disabled");
                    k(3);
                    return;
                } else if (iD != 5) {
                    we.h.b("TransSmartConnect", "Service is not enabled, ignore");
                    return;
                }
            }
            we.h.b("TransSmartConnect", "Turning off SmartConnect");
            k(0);
            return;
        }
        we.h.b("TransSmartConnect", "Turning on SmartConnect");
        c7 c7Var = this.f4089b;
        if (c7Var != null) {
            c7Var.f9696d = true;
            tc.d.h().getClass();
            boolean z2 = m3.j.a() != null;
            BluetoothAdapter bluetoothAdapter = c7Var.f9694b;
            WifiManager wifiManager = c7Var.f9695c;
            if (z2) {
                if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                    tc.d dVarH = tc.d.h();
                    if (!dVarH.k()) {
                        vc.a.b("KolunScannerManager", "mKolunScanner is dead");
                    } else if (dVarH.i().isEmpty()) {
                        vc.a.b("KolunScannerManager", "mContext is null");
                    } else {
                        try {
                            ((tc.a) ((tc.c) dVarH.f10209a)).k(dVarH.i());
                        } catch (RemoteException e) {
                            vc.a.a(5, "KolunScannerManager", "setWifiEnable,err:", e);
                        }
                    }
                }
                if (bluetoothAdapter != null && !bluetoothAdapter.isEnabled()) {
                    tc.d.h().g();
                }
            } else {
                if (wifiManager != null && !wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                }
                if (bluetoothAdapter != null && !bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.enable();
                }
            }
            c7Var.a(1);
        }
    }
}
