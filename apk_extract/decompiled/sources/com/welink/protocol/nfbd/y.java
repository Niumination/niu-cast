package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentTransaction;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import k3.lb;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import se.b1;
import se.b5;
import se.h5;
import se.o1;
import se.q1;
import se.q4;
import se.r6;
import se.s1;
import se.s4;
import se.t1;
import se.t4;
import se.u0;
import se.u4;
import se.u6;
import se.v0;
import se.v4;
import se.v6;
import se.w0;
import se.w4;
import se.w6;
import se.x6;
import se.y4;
import se.y6;
import se.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends we.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f4191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b5 f4192d;
    public final y4 e;
    public final q4 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BluetoothAdapter f4193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WifiManager f4194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t1 f4195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f4196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f4197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CountDownLatch f4198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f4199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f4200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile se.e f4201o;
    public final sb.a p;
    public final u4 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Context context) {
        super(false, "SmartConnectWrapper");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4196j = ConcurrentHashMap.newKeySet();
        this.f4197k = ConcurrentHashMap.newKeySet();
        this.f4199m = ConcurrentHashMap.newKeySet();
        this.f4200n = new Object();
        sb.a callback = new sb.a(this, 4);
        this.p = callback;
        u4 u4Var = new u4(this);
        this.q = u4Var;
        c0 c0Var = (c0) c0.f4087g.b(context);
        this.f4191c = c0Var;
        if (c0Var != null) {
            Intrinsics.checkNotNullParameter(callback, "connReqCallback");
            c0Var.e = callback;
            z zVar = c0Var.f4090c;
            if (zVar != null) {
                r6 connReqCallback = new r6(c0Var, 1);
                Intrinsics.checkNotNullParameter(connReqCallback, "connReqCallback");
                zVar.f = connReqCallback;
                h5 h5Var = zVar.f4203c;
                if (h5Var != null) {
                    Intrinsics.checkNotNullParameter(connReqCallback, "notifyCallback");
                    h5Var.e = connReqCallback;
                }
                g gVar = zVar.f4207i;
                if (gVar != null) {
                    Intrinsics.checkNotNullParameter(connReqCallback, "connReqCallback");
                    if (gVar.f4116h != null) {
                        Intrinsics.checkNotNullParameter(connReqCallback, "connReqCallback");
                        we.h.g("RegisterNotify");
                    }
                }
            }
        }
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager = (BluetoothManager) systemService;
        this.f4193g = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
        Object systemService2 = context.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.f4194h = (WifiManager) systemService2;
        Object systemService3 = context.getSystemService("wifip2p");
        Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
        Object systemService4 = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService4, "null cannot be cast to non-null type android.net.ConnectivityManager");
        b5 b5Var = (b5) b5.f9660g.b(context);
        this.f4192d = b5Var;
        if (b5Var != null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            b5Var.f = callback;
        }
        this.e = (y4) y4.f10068b.b(context);
        q4 q4Var = (q4) q4.e.b(context);
        this.f = q4Var;
        if (q4Var != null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
        t1 t1Var = new t1();
        this.f4195i = t1Var;
        t1Var.E(new we.i(this), u4Var);
    }

    public static int l(Integer num) {
        if (num == null) {
            return -1;
        }
        if (new IntRange(1, 14).contains(num.intValue())) {
            return 1;
        }
        if (new IntRange(36, 165).contains(num.intValue())) {
            return 2;
        }
        return new IntRange(36, 233).contains(num.intValue()) ? 3 : -1;
    }

    public static void n(Integer num) {
        if (num != null && num.intValue() == 0) {
            we.h.b("SmartConnectWrapper", "Function Disabled now");
            return;
        }
        if (num != null && num.intValue() == 2) {
            we.h.b("SmartConnectWrapper", "P2P Disconnected");
        } else if (num != null && num.intValue() == 6) {
            we.h.b("SmartConnectWrapper", "Function Disabling Successfully");
        }
    }

    public static boolean o(y yVar, NearDevice device) {
        Object next;
        Object next2;
        Integer num;
        Integer num2;
        yVar.getClass();
        Intrinsics.checkNotNullParameter(device, "device");
        if (!yVar.z()) {
            return false;
        }
        ConcurrentHashMap.KeySetView mNearDevices = yVar.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        synchronized (mNearDevices) {
            try {
                ConcurrentHashMap.KeySetView mNearDevices2 = yVar.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                Iterator it = mNearDevices2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    NearDevice nearDevice = (NearDevice) next;
                    if (Intrinsics.areEqual(nearDevice, device) && ((num2 = nearDevice.f3898v) == null || num2.intValue() != 1006)) {
                        break;
                        break;
                    }
                }
                if (((NearDevice) next) != null) {
                    Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                    Intrinsics.checkNotNullParameter("Current Device is already connected, ignore", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("SmartConnectWrapper", "TransConnect:Current Device is already connected, ignore", null);
                    }
                } else {
                    ConcurrentHashMap.KeySetView mNearDevices3 = yVar.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
                    Iterator it2 = mNearDevices3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        NearDevice nearDevice2 = (NearDevice) next2;
                        if (!Intrinsics.areEqual(nearDevice2, device) && Intrinsics.areEqual(nearDevice2.f3885c, device.f3885c) && ((num = nearDevice2.f3898v) == null || num.intValue() != 1006)) {
                            break;
                            break;
                        }
                    }
                    if (((NearDevice) next2) != null) {
                        Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                        Intrinsics.checkNotNullParameter("Previous device is already connected, ignore", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("SmartConnectWrapper", "TransConnect:Previous device is already connected, ignore", null);
                        }
                    } else {
                        Unit unit = Unit.INSTANCE;
                        ConcurrentHashMap.KeySetView mInvitingDevices = yVar.f4199m;
                        Intrinsics.checkNotNullExpressionValue(mInvitingDevices, "mInvitingDevices");
                        synchronized (mInvitingDevices) {
                            ConcurrentHashMap.KeySetView mInvitingDevices2 = yVar.f4199m;
                            Intrinsics.checkNotNullExpressionValue(mInvitingDevices2, "mInvitingDevices");
                            if (mInvitingDevices2.isEmpty()) {
                                if (yVar.f4196j.contains(device)) {
                                    c0 c0Var = yVar.f4191c;
                                    if (!Intrinsics.areEqual(c0Var != null ? Boolean.valueOf(c0Var.i(device, yVar.p)) : null, Boolean.TRUE)) {
                                        we.h.b("SmartConnectWrapper", "Connect Device Failed, " + device.f3883a + ", " + device.f3884b);
                                    }
                                } else {
                                    we.h.b("SmartConnectWrapper", "Device not found, ignore");
                                }
                                return true;
                            }
                            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                            Intrinsics.checkNotNullParameter("Inviting Device is already connected, ignore", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("SmartConnectWrapper", "TransConnect:Inviting Device is already connected, ignore", null);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        String mes = h0.a.k("Connect Device not allowed, ", device.f3883a, ", ", device.f3884b);
        Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c < 1) {
            return false;
        }
        h0.a.x("TransConnect:", mes, "SmartConnectWrapper", null);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x003f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0042 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0045 A[RETURN, SYNTHETIC] */
    public static int p(int i8) {
        if (i8 == -3) {
            return 104;
        }
        if (i8 == -2) {
            return 100;
        }
        if (i8 == -1) {
            return 102;
        }
        if (i8 == 0) {
            return DeviceType.INFRARED_TV_BOX;
        }
        if (i8 == 3) {
            return DeviceType.INFRARED_AIR_PURIFIER;
        }
        if (i8 == 6) {
            return 101;
        }
        if (i8 == 11) {
            return DeviceType.INFRARED_LIGHT;
        }
        if (i8 == 8192 || i8 == 12288 || i8 == 16384) {
            return DeviceType.INFRARED_AIR_PURIFIER;
        }
        if (i8 == 13) {
            return 109;
        }
        if (i8 == 14) {
            return 108;
        }
        switch (i8) {
            case 16:
                return DeviceType.INFRARED_PROJECTOR;
            case 17:
                return DeviceType.INFRARED_AMPLIFIER;
            case 18:
                return DeviceType.INFRARED_AIR_CONDITION;
            default:
                switch (i8) {
                    case 4096:
                        return DeviceType.INFRARED_AIR_PURIFIER;
                    case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                        return DeviceType.INFRARED_HEATER;
                    case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                        return DeviceType.INFRARED_ELECTRIC_HEATER;
                    case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                        return DeviceType.INFRARED_SWEEP_ROBOT;
                    case FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN /* 4100 */:
                        return DeviceType.INFRARED_CURTAIN;
                    case 4101:
                        return 104;
                    case 4102:
                        return 116;
                    case 4103:
                        return 117;
                    case 4104:
                        return 118;
                    case 4105:
                        return 119;
                    default:
                        switch (i8) {
                            case 12293:
                                return 104;
                            case 12294:
                                return 116;
                            case 12295:
                                return 117;
                            case 12296:
                                return 118;
                            default:
                                return i8 + MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                        }
                }
        }
    }

    public static /* synthetic */ NearDevice s(y yVar, BluetoothDevice bluetoothDevice, Integer num, Integer num2, int i8) {
        return yVar.r(bluetoothDevice, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : num2, null, null);
    }

    public static byte[] w(int i8, boolean z2, boolean z3) {
        int i9 = 1;
        byte[] bArr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        if (i8 == 1) {
            bArr[0] = 0;
        } else if (i8 != 2) {
            if (i8 == 4) {
                bArr[0] = 4;
            } else if (i8 == 8) {
                bArr[0] = 5;
            } else if (i8 == 16) {
                bArr[0] = 8;
            } else if (i8 == 32) {
                bArr[0] = 9;
            } else if (i8 == 64) {
                bArr[0] = 10;
            } else if (i8 == 128) {
                bArr[0] = 11;
            } else if (i8 == 256) {
                bArr[0] = 12;
            } else if (i8 == 512) {
                bArr[0] = 13;
            } else if (i8 == 1024) {
                bArr[0] = 15;
            } else if (i8 != 2047) {
                for (int i10 = 0; i10 < 11; i10++) {
                    if (UInt.m254constructorimpl(UInt.m254constructorimpl(i9 << i10) & i8) != UInt.m254constructorimpl(0)) {
                        switch (i10) {
                            case 0:
                                i9 = 1;
                                bArr[0] = 0;
                                continue;
                            case 1:
                                if (!z2 && z3) {
                                    bArr[0] = 0;
                                }
                                i9 = 1;
                                bArr[1] = 1;
                                continue;
                            case 2:
                                bArr[2] = 4;
                                break;
                            case 3:
                                bArr[3] = 5;
                                break;
                            case 4:
                                bArr[4] = 8;
                                break;
                            case 5:
                                bArr[5] = 9;
                                break;
                            case 6:
                                bArr[6] = 10;
                                break;
                            case 7:
                                bArr[i10] = 11;
                                break;
                            case 8:
                                bArr[i10] = 12;
                                break;
                            case 9:
                                bArr[i10] = 13;
                                break;
                            case 10:
                                bArr[i10] = 15;
                                break;
                        }
                        i9 = 1;
                    } else {
                        i9 = 1;
                    }
                }
            } else {
                bArr[0] = 0;
                bArr[1] = 1;
                bArr[2] = 4;
                bArr[3] = 5;
                bArr[4] = 8;
                bArr[5] = 9;
                bArr[6] = 10;
                bArr[7] = 11;
                bArr[8] = 12;
                bArr[9] = 13;
                bArr[10] = 15;
            }
        } else if (z2 || !z3) {
            bArr[0] = 1;
        } else {
            bArr[0] = 0;
            bArr[1] = 1;
        }
        return bArr;
    }

    public static /* synthetic */ byte[] x(y yVar, int i8, boolean z2, int i9) {
        if ((i9 & 2) != 0) {
            z2 = false;
        }
        yVar.getClass();
        return w(i8, z2, false);
    }

    public final void A(int i8) {
        f(new b0.b(i8, 6, this));
    }

    public final void B(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        int iIntValue;
        se.e eVar;
        List<Pair> list;
        c0 c0Var;
        c0 c0Var2;
        Integer num;
        Integer num2;
        Integer num3;
        se.e eVar2;
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfoE = tranConnectionController$MessageInfo.getF3974i();
        Integer numValueOf = tranConnectionController$EventInfoE != null ? Integer.valueOf(tranConnectionController$EventInfoE.f3965b) : null;
        TranConnectionController$EventInfo tranConnectionController$EventInfoE2 = tranConnectionController$MessageInfo.getF3974i();
        Integer numValueOf2 = tranConnectionController$EventInfoE2 != null ? Integer.valueOf(tranConnectionController$EventInfoE2.getF3966c()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 1) || (numValueOf != null && numValueOf.intValue() == 2)) {
            String str = tranConnectionController$MessageInfo.f3969a;
            int i8 = tranConnectionController$MessageInfo.f3970b;
            int i9 = tranConnectionController$MessageInfo.f3971c;
            we.h.b("SmartConnectWrapper", "Connect successfully event");
            DeviceInfo deviceInfoD = tranConnectionController$MessageInfo.getF3973h();
            NearDeviceDataParcel nearDeviceDataParcelF = tranConnectionController$MessageInfo.getF3975j();
            Parcelable parcelable = nearDeviceDataParcelF != null ? (Parcelable) nearDeviceDataParcelF.getF3903a() : null;
            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
            I(str, i8, i9, deviceInfoD, (TranConnectionController$P2pDeviceInfo) parcelable);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 3) {
            we.h.b("SmartConnectWrapper", "Remote Notify, Device Name: " + tranConnectionController$MessageInfo.getF3972d());
            String strB = tranConnectionController$MessageInfo.getF3972d();
            List<String> listSplit = strB != null ? new Regex("[###]+").split(strB, 0) : null;
            String str2 = listSplit != null ? listSplit.get(0) : null;
            String str3 = listSplit != null ? listSplit.get(1) : null;
            String str4 = listSplit != null ? listSplit.get(2) : null;
            StringBuilder sbP = h0.a.p("Device Brand: ", str2, ", Device Name: ", str3, ", Device Mac: ");
            sbP.append(str4);
            we.h.b("SmartConnectWrapper", sbP.toString());
            N(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 14) {
            we.h.b("SmartConnectWrapper", "Remote device request to exchange data");
            TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
            Parcelable parcelable2 = (tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a;
            if (!(parcelable2 instanceof BluetoothDevice)) {
                if (!(parcelable2 instanceof ConnectRequest)) {
                    Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                    Intrinsics.checkNotNullParameter("Incorrect reported device type, request ignore", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported device type, request ignore", null);
                        return;
                    }
                    return;
                }
                Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.ConnectRequest");
                NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
                if (!((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof NearDevice)) {
                    we.h.j("SmartConnectWrapper", "Can't find NearDevice, ignore");
                    return;
                }
                Object obj2 = nearDeviceDataParcel2.f3903a;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                NearDevice nearDevice = (NearDevice) obj2;
                ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
                if (mNearDevices == null || !mNearDevices.isEmpty()) {
                    Iterator it = mNearDevices.iterator();
                    while (it.hasNext()) {
                        if (((NearDevice) it.next()) == nearDevice) {
                            we.h.j("SmartConnectWrapper", "NearDevice reference already exists in mNearDevices, skipping");
                        }
                    }
                    this.f4195i.k(nearDevice, null, false, true);
                } else {
                    this.f4195i.k(nearDevice, null, false, true);
                }
                R(nearDevice, 0, 0);
                return;
            }
            Object obj3 = tranConnectionController$EventInfo.f3968h.f3903a;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj3;
            NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$MessageInfo.f3975j;
            if (!((nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null) instanceof NearDevice)) {
                we.h.j("SmartConnectWrapper", "Can't find NearDevice, ignore");
                return;
            }
            Object obj4 = nearDeviceDataParcel3.f3903a;
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
            NearDevice nearDevice2 = (NearDevice) obj4;
            ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
            Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
            if (mNearDevices2 != null && mNearDevices2.isEmpty()) {
                this.f4195i.k(nearDevice2, null, false, true);
                break;
            }
            Iterator it2 = mNearDevices2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((NearDevice) it2.next()) == nearDevice2) {
                        we.h.j("SmartConnectWrapper", "NearDevice reference already exists in mNearDevices, skipping");
                        break;
                    }
                } else {
                    this.f4195i.k(nearDevice2, null, false, true);
                    break;
                }
            }
            Q(bluetoothDevice);
            R(nearDevice2, 0, 0);
            if (nearDevice2.e != 0 || (eVar2 = this.f4201o) == null) {
                return;
            }
            eVar2.w(nearDevice2);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 15) {
            we.h.b("SmartConnectWrapper", "Remote device notify to exchange data");
            P(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 18) {
            we.h.b("SmartConnectWrapper", "BLE Connected, Device Name: " + tranConnectionController$MessageInfo.getF3972d());
            j(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 19) {
            we.h.b("SmartConnectWrapper", "BLE Disconnected, Device Name: " + tranConnectionController$MessageInfo.getF3972d());
            k(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 20) {
            we.h.b("SmartConnectWrapper", "P2P Owner Available");
            M(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 21) {
            J(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 24) {
            G(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 22) {
            K(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 23) {
            F(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 27) {
            E(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 28) {
            D(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 29) {
            we.h.b("SmartConnectWrapper", "Device Flush Event");
            t(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 30) {
            L(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 31) {
            C(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 16) {
            we.h.b("SmartConnectWrapper", "Remote device request to connect");
            N(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 17) {
            we.h.b("SmartConnectWrapper", "Remote device disconnect");
            O(tranConnectionController$MessageInfo);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -1) {
            we.h.b("SmartConnectWrapper", "Remote device reject to accept");
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 6) {
            if (numValueOf2 != null && numValueOf2.intValue() == 1) {
                we.h.b("SmartConnectWrapper", "Function Enabled Successfully");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 4) {
                we.h.b("SmartConnectWrapper", "WiFi Enabled Successfully");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 2) {
                we.h.b("SmartConnectWrapper", "BT Enabled Successfully");
                return;
            } else {
                if (numValueOf2 != null && numValueOf2.intValue() == 5) {
                    we.h.b("SmartConnectWrapper", "Service Recovered Successfully");
                    return;
                }
                return;
            }
        }
        if (numValueOf != null && numValueOf.intValue() == 5) {
            we.h.b("SmartConnectWrapper", "Service Destroyed");
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 4) {
            if ((numValueOf2 != null && numValueOf2.intValue() == -2) || ((numValueOf2 != null && numValueOf2.intValue() == 6) || ((numValueOf2 != null && numValueOf2.intValue() == -1) || ((numValueOf2 != null && numValueOf2.intValue() == 0) || ((numValueOf2 != null && numValueOf2.intValue() == -3) || (numValueOf2 != null && numValueOf2.intValue() == 18)))))) {
                we.h.b("SmartConnectWrapper", "Connect Failed, Reason code: " + numValueOf2);
                f(new a0.b((Object) null, this, tranConnectionController$MessageInfo.getF3973h(), numValueOf2.intValue(), 4));
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 11) {
                if (this.f4191c != null) {
                    u0 u0Var = c0.f4087g;
                    num3 = -1;
                } else {
                    num3 = null;
                }
                we.h.b("SmartConnectWrapper", "Disconnect timeout, Reason code: " + numValueOf2 + ", mCurrentState: " + num3);
                n(num3);
                f(new b.d(this, tranConnectionController$MessageInfo.getF3973h(), numValueOf2.intValue(), 6));
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 10) {
                we.h.b("SmartConnectWrapper", "Disconnect from external, WiFi Adapter Off Event");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 9) {
                we.h.b("SmartConnectWrapper", "Disconnect from external, Bluetooth Adapter Off Event");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 12) {
                we.h.b("SmartConnectWrapper", "Bluetooth Off Event, Ignore");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 1) {
                if (this.f4191c != null) {
                    u0 u0Var2 = c0.f4087g;
                    num2 = -1;
                } else {
                    num2 = null;
                }
                we.h.b("SmartConnectWrapper", "SmartConfig Disable Event, mCurrentState: " + num2);
                n(num2);
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 3) {
                we.h.b("SmartConnectWrapper", "Disconnect request has been done");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 4) {
                we.h.b("SmartConnectWrapper", "Disconnect Peer Event, Ignore");
                return;
            }
            if ((numValueOf2 != null && numValueOf2.intValue() == 19) || ((numValueOf2 != null && numValueOf2.intValue() == 20) || (numValueOf2 != null && numValueOf2.intValue() == 5))) {
                if (this.f4191c != null) {
                    u0 u0Var3 = c0.f4087g;
                    num = -1;
                } else {
                    num = null;
                }
                we.h.b("SmartConnectWrapper", "Disconnect Peer Successfully, mCurrentState: " + num + ", Reason code: " + numValueOf2);
                n(num);
                return;
            }
            if ((numValueOf2 != null && numValueOf2.intValue() == 14) || ((numValueOf2 != null && numValueOf2.intValue() == 13) || ((numValueOf2 != null && numValueOf2.intValue() == 16) || (numValueOf2 != null && numValueOf2.intValue() == 17)))) {
                we.h.b("SmartConnectWrapper", "Connect Failed During BLE period, Reason code: " + numValueOf2);
                f(new a0.b((Object) null, this, tranConnectionController$MessageInfo.getF3973h(), numValueOf2.intValue(), 4));
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 15) {
                we.h.b("SmartConnectWrapper", "Disconnect, connection was terminated in advance");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 21) {
                we.h.b("SmartConnectWrapper", "Disconnect P2p, reset timeout");
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 22) {
                we.h.b("SmartConnectWrapper", "Disconnect P2p, reset succeed");
                return;
            } else {
                if (numValueOf2 != null && numValueOf2.intValue() == 23) {
                    we.h.b("SmartConnectWrapper", "Disconnect P2p, no p2p group probably");
                    return;
                }
                return;
            }
        }
        if (numValueOf != null && numValueOf.intValue() == 11) {
            if (numValueOf2 != null && numValueOf2.intValue() == 1) {
                we.h.j("SmartConnectWrapper", "Scan Failed, Already Started");
                A(2001);
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 2) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Scan Failed, Application Registration Failed", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Scan Failed, Application Registration Failed", null);
                }
                A(2002);
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 3) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Scan Failed, Internal Error", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Scan Failed, Internal Error", null);
                }
                A(2003);
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 4) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Scan Failed, Feature Unsupported", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Scan Failed, Feature Unsupported", null);
                }
                A(2004);
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 5) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Scan Failed, Out of Hardware Resources", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Scan Failed, Out of Hardware Resources", null);
                }
                A(2005);
                return;
            }
            if (numValueOf2 != null && numValueOf2.intValue() == 6) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Scan Failed, Scanning Too Frequently", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Scan Failed, Scanning Too Frequently", null);
                }
                A(2006);
                return;
            }
            String mes = "Scan Failed, Reason code: " + numValueOf2;
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes, "SmartConnectWrapper", null);
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 34) {
            f(new s4(tranConnectionController$MessageInfo, this, 1));
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 12) {
            DeviceInfo deviceInfoD2 = tranConnectionController$MessageInfo.getF3973h();
            if (deviceInfoD2 != null) {
                byte b9 = deviceInfoD2.f4220a;
                if (b9 == 13 || b9 == 18 || b9 == 15 || b9 == 21) {
                    we.h.b("SmartConnectWrapper", "Found phone/pad device id = " + deviceInfoD2.getF4223d());
                    NearDeviceDataParcel nearDeviceDataParcelF2 = tranConnectionController$MessageInfo.getF3975j();
                    Parcelable parcelable3 = nearDeviceDataParcelF2 != null ? (Parcelable) nearDeviceDataParcelF2.getF3903a() : null;
                    Intrinsics.checkNotNull(parcelable3, "null cannot be cast to non-null type android.bluetooth.le.ScanResult");
                    f(new a0.g(deviceInfoD2, 20, (ScanResult) parcelable3, this));
                } else if (b9 == 10) {
                    we.h.b("SmartConnectWrapper", "Found laptop device addr = " + deviceInfoD2.getF4223d());
                    NearDeviceDataParcel nearDeviceDataParcelF3 = tranConnectionController$MessageInfo.getF3975j();
                    Parcelable parcelable4 = nearDeviceDataParcelF3 != null ? (Parcelable) nearDeviceDataParcelF3.getF3903a() : null;
                    Intrinsics.checkNotNull(parcelable4, "null cannot be cast to non-null type android.bluetooth.le.ScanResult");
                    f(new a0.g(deviceInfoD2, 20, (ScanResult) parcelable4, this));
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 13) {
            DeviceInfo deviceInfoD3 = tranConnectionController$MessageInfo.getF3973h();
            if (deviceInfoD3 != null) {
                int i10 = deviceInfoD3.f4225i;
                if (i10 == 2) {
                    o.d.z("Found Wi-Fi STA device addr = ", deviceInfoD3.getF4223d(), "SmartConnectWrapper");
                    Unit unit2 = Unit.INSTANCE;
                } else if (i10 == 3) {
                    o.d.z("Found Wi-Fi P2P device addr = ", deviceInfoD3.getF4223d(), "SmartConnectWrapper");
                    Unit unit3 = Unit.INSTANCE;
                } else if (i10 != 4) {
                    if (i10 == 5) {
                        o.d.z("Found Wi-Fi IBSS device addr = ", deviceInfoD3.getF4223d(), "SmartConnectWrapper");
                    }
                    Unit unit4 = Unit.INSTANCE;
                } else {
                    o.d.z("Found Wi-Fi NAN device addr = ", deviceInfoD3.getF4223d(), "SmartConnectWrapper");
                    Unit unit5 = Unit.INSTANCE;
                }
                NearDeviceDataParcel nearDeviceDataParcelF4 = tranConnectionController$MessageInfo.getF3975j();
                Parcelable parcelable5 = nearDeviceDataParcelF4 != null ? (Parcelable) nearDeviceDataParcelF4.getF3903a() : null;
                Intrinsics.checkNotNull(parcelable5, "null cannot be cast to non-null type android.net.wifi.ScanResult");
                f(new a0.g(deviceInfoD3, 21, (android.net.wifi.ScanResult) parcelable5, this));
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 25) {
            TranConnectionController$EventInfo tranConnectionController$EventInfoE3 = tranConnectionController$MessageInfo.getF3974i();
            NearDevice nearDevice3 = (tranConnectionController$EventInfoE3.getF3968h() == null || !(tranConnectionController$EventInfoE3.getF3968h().getF3903a() instanceof NearDevice)) ? null : (NearDevice) tranConnectionController$EventInfoE3.getF3968h().getF3903a();
            if (tranConnectionController$MessageInfo.getF3975j() != null && (((Parcelable) tranConnectionController$MessageInfo.getF3975j().getF3903a()) instanceof WifiP2pDevice)) {
            }
            if (nearDevice3 != null) {
                boolean z2 = this.f4196j.contains(nearDevice3) || this.f4197k.contains(nearDevice3);
                se.e eVar3 = this.f4201o;
                if (eVar3 != null) {
                    eVar3.v(nearDevice3, (4 & 2) != 0 ? 1 : 2, -1);
                    Unit unit6 = Unit.INSTANCE;
                }
                if (!z2 || (c0Var2 = this.f4191c) == null) {
                    return;
                }
                c0Var2.b(nearDevice3);
                Unit unit7 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 32) {
            we.h.h("SmartConnectWrapper", "LAN connected now");
            NearDeviceDataParcel f3968h = tranConnectionController$MessageInfo.getF3974i().getF3968h();
            if (!((f3968h != null ? (Parcelable) f3968h.getF3903a() : null) instanceof NearDevice)) {
                we.h.c("SmartConnectWrapper", "Connected, device is not match, LAN checking", null);
                return;
            }
            Object f3903a = tranConnectionController$MessageInfo.getF3974i().getF3968h().getF3903a();
            Intrinsics.checkNotNull(f3903a, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
            NearDevice nearDevice4 = (NearDevice) f3903a;
            String strS = tranConnectionController$MessageInfo.getF3974i().f3964a;
            if (strS == null) {
                strS = nearDevice4.s();
            }
            String str5 = strS;
            String strL = tranConnectionController$MessageInfo.f3969a;
            if (strL == null) {
                strL = nearDevice4.l();
            }
            NetworkParamsInformation networkParamsInformation = new NetworkParamsInformation(str5, null, strL, null, null, null, null, null, null, null, null, null, null, null, null);
            NearDeviceExtension nearDeviceExtension = nearDevice4.u;
            LanNetworkInfo lanNetworkInfo = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
            if (lanNetworkInfo == null || (list = lanNetworkInfo.f4247n) == null) {
                iIntValue = 0;
            } else {
                iIntValue = 0;
                for (Pair pair : list) {
                    we.h.b("SmartConnectWrapper", "Service: " + pair.getFirst() + ", Port: " + pair.getSecond());
                    if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "ScreenCast", true)) {
                        if (nearDevice4.getE() == 0 || nearDevice4.getE() == 8) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "FileTransfer", true)) {
                        if (nearDevice4.getE() == 1) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "UcHoService", true)) {
                        if (nearDevice4.getE() == 5 || nearDevice4.getE() == 4) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "ExtendCast", true)) {
                        if (nearDevice4.getE() == 9) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "AudioSink", true)) {
                        if (nearDevice4.getE() == 10) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "KeyboardMouseShare", true)) {
                        if (nearDevice4.getE() == 11) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "CallShare", true)) {
                        if (nearDevice4.getE() == 12) {
                            iIntValue = ((Number) pair.getSecond()).intValue();
                        }
                    } else if (!StringsKt__StringsKt.contains((CharSequence) pair.getFirst(), (CharSequence) "CameraShare", true)) {
                        we.h.b("SmartConnectWrapper", "Unknown Service: " + pair.getFirst() + ", Port: " + pair.getSecond());
                    } else if (nearDevice4.getE() == 13) {
                        iIntValue = ((Number) pair.getSecond()).intValue();
                    }
                }
                Unit unit8 = Unit.INSTANCE;
            }
            NearNetworkElement.Wifi wifi = new NearNetworkElement.Wifi(9, null, null, null, null, Integer.valueOf(iIntValue), 0, 0, 1, networkParamsInformation, 0, null);
            if (!this.f4196j.contains(nearDevice4) || (eVar = this.f4201o) == null) {
                return;
            }
            eVar.r(nearDevice4, wifi);
            Unit unit9 = Unit.INSTANCE;
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 33) {
            we.h.h("SmartConnectWrapper", "LAN disconnected now");
            NearDeviceDataParcel f3968h2 = tranConnectionController$MessageInfo.getF3974i().getF3968h();
            if ((f3968h2 != null ? (Parcelable) f3968h2.getF3903a() : null) instanceof NearDevice) {
                Object f3903a2 = tranConnectionController$MessageInfo.getF3974i().getF3968h().getF3903a();
                Intrinsics.checkNotNull(f3903a2, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                NearDevice nearDevice5 = (NearDevice) f3903a2;
                String strS2 = tranConnectionController$MessageInfo.getF3974i().f3964a;
                if (strS2 == null) {
                    strS2 = nearDevice5.s();
                }
                if (tranConnectionController$MessageInfo.f3969a == null) {
                    nearDevice5.l();
                }
                if (strS2 == null || !Intrinsics.areEqual(strS2, "127.0.0.1")) {
                    se.e eVar4 = this.f4201o;
                    if (eVar4 != null) {
                        eVar4.v(nearDevice5, 11, tranConnectionController$MessageInfo.getF3974i().getF3966c());
                        Unit unit10 = Unit.INSTANCE;
                    }
                } else {
                    se.e eVar5 = this.f4201o;
                    if (eVar5 != null) {
                        eVar5.q(nearDevice5, 13);
                        Unit unit11 = Unit.INSTANCE;
                    }
                }
                if (!this.f4196j.contains(nearDevice5) || (c0Var = this.f4191c) == null) {
                    return;
                }
                c0Var.b(nearDevice5);
                Unit unit12 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 35) {
            se.e eVar6 = this.f4201o;
            if (eVar6 != null) {
                eVar6.n();
                Unit unit13 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 36) {
            if ((numValueOf2 == null || numValueOf2.intValue() != 1) && ((numValueOf2 == null || numValueOf2.intValue() != 2) && ((numValueOf2 == null || numValueOf2.intValue() != 3) && ((numValueOf2 == null || numValueOf2.intValue() != 4) && (numValueOf2 == null || numValueOf2.intValue() != 5))))) {
                we.h.j("SmartConnectWrapper", "Advertising Failed, Unkown Reason code: " + numValueOf2);
                if (numValueOf2 != null) {
                    int iIntValue2 = numValueOf2.intValue();
                    se.e eVar7 = this.f4201o;
                    if (eVar7 != null) {
                        eVar7.l(iIntValue2);
                        Unit unit14 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                return;
            }
            String mes2 = "Advertising Failed, Reason code: " + numValueOf2;
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter(mes2, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes2, "SmartConnectWrapper", null);
            }
            se.e eVar8 = this.f4201o;
            if (eVar8 != null) {
                eVar8.l(numValueOf2.intValue());
                Unit unit15 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 37) {
            se.e eVar9 = this.f4201o;
            if (eVar9 != null) {
                eVar9.p();
                Unit unit16 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 38) {
            se.e eVar10 = this.f4201o;
            if (eVar10 != null) {
                eVar10.o();
                Unit unit17 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 39) {
            boolean z3 = tranConnectionController$MessageInfo.f3970b >= 1;
            NearDeviceDataParcel nearDeviceDataParcelF5 = tranConnectionController$MessageInfo.getF3975j();
            if ((nearDeviceDataParcelF5 != null ? (Parcelable) nearDeviceDataParcelF5.getF3903a() : null) instanceof NearDevice) {
                Object f3903a3 = tranConnectionController$MessageInfo.getF3975j().getF3903a();
                Intrinsics.checkNotNull(f3903a3, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                NearDevice nearDevice6 = (NearDevice) f3903a3;
                ConcurrentHashMap.KeySetView mNearDevices3 = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
                if (mNearDevices3 == null || !mNearDevices3.isEmpty()) {
                    Iterator it3 = mNearDevices3.iterator();
                    while (it3.hasNext()) {
                        if (((NearDevice) it3.next()) == nearDevice6) {
                            we.h.b("SmartConnectWrapper", "NearDevice found in device list, update trusted state");
                            se.e eVar11 = this.f4201o;
                            if (eVar11 != null) {
                                eVar11.t(nearDevice6, z3);
                                Unit unit18 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                }
                we.h.j("SmartConnectWrapper", "NearDevice not found in device list, ignore trusted state");
                Unit unit19 = Unit.INSTANCE;
                return;
            }
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 40) {
            NearDeviceDataParcel nearDeviceDataParcelF6 = tranConnectionController$MessageInfo.getF3975j();
            if ((nearDeviceDataParcelF6 != null ? (Parcelable) nearDeviceDataParcelF6.getF3903a() : null) instanceof NearDevice) {
                Object f3903a4 = tranConnectionController$MessageInfo.getF3975j().getF3903a();
                Intrinsics.checkNotNull(f3903a4, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                NearDevice nearDevice7 = (NearDevice) f3903a4;
                ConcurrentHashMap.KeySetView mNearDevices4 = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices4, "mNearDevices");
                if (mNearDevices4 == null || !mNearDevices4.isEmpty()) {
                    Iterator it4 = mNearDevices4.iterator();
                    while (it4.hasNext()) {
                        if (((NearDevice) it4.next()) == nearDevice7) {
                            we.h.b("SmartConnectWrapper", "NearDevice found in device list, notify reject event");
                            se.e eVar12 = this.f4201o;
                            if (eVar12 != null) {
                                eVar12.s(nearDevice7);
                                Unit unit20 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                }
                we.h.j("SmartConnectWrapper", "NearDevice not found in device list, ignore reject event");
                Unit unit21 = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    public final void C(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        T next;
        String str;
        byte[] bArr;
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        if (!(((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof NearLaptopManager$TransferConnectInfo)) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Incorrect reported data type, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported data type, ignore", null);
                return;
            }
            return;
        }
        Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearLaptopManager.TransferConnectInfo");
        NearLaptopManager$TransferConnectInfo nearLaptopManager$TransferConnectInfo = (NearLaptopManager$TransferConnectInfo) obj;
        DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if (!((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice)) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Incorrect reported device type, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported device type, ignore", null);
                return;
            }
            return;
        }
        Object obj2 = nearDeviceDataParcel2.f3903a;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        synchronized (mNearDevices) {
            try {
                ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                Iterator it = mNearDevices2.iterator();
                do {
                    if (!it.hasNext()) {
                        next = 0;
                        break;
                    }
                    next = it.next();
                    NearDevice nearDevice = (NearDevice) next;
                    if (!Intrinsics.areEqual(nearDevice.f3883a, bluetoothDevice.getAddress())) {
                        if (Intrinsics.areEqual(nearDevice.f3885c, deviceInfo != null ? deviceInfo.f4223d : null)) {
                            break;
                        }
                        str = nearDevice.f3885c;
                        bArr = nearLaptopManager$TransferConnectInfo.f3914c;
                    } else {
                        break;
                    }
                } while (!Intrinsics.areEqual(str, bArr != null ? m3.q.c(bArr) : null));
                objectRef.element = next;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (next != 0) {
            this.f4195i.G((NearDevice) next, false);
            NearDevice nearDevice2 = (NearDevice) objectRef.element;
            o.d.z("NearDeviceInvitationRequestNotify flush device ", nearDevice2 != null ? nearDevice2.f3883a : null, "SmartConnectWrapper");
        } else {
            we.h.j("SmartConnectWrapper", "Not found NearDevice");
        }
        NearDevice nearDeviceC = deviceInfo != null ? h.c(deviceInfo, null, bluetoothDevice, 0, 0, null, 96) : null;
        if (nearDeviceC != null) {
            this.f4195i.k(nearDeviceC, t4.LE_DEVICE, false, true);
        }
    }

    public final void D(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        byte b9 = 0;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        U();
        t1 t1Var = this.f4195i;
        t1Var.getClass();
        t1Var.f(new m.c(t1Var, 8));
        t1 t1Var2 = this.f4195i;
        u4 observer = this.q;
        t1Var2.getClass();
        Intrinsics.checkNotNullParameter(observer, "observer");
        t1Var2.f9989c.removeIf(new q1(b9, new sb.a(observer, 2)));
        ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        synchronized (mNearDevices) {
            this.f4196j.clear();
            Unit unit = Unit.INSTANCE;
        }
        se.e eVar = this.f4201o;
        if (eVar != null) {
            b1 b1Var = (b1) eVar.f9720b;
            int size = b1Var.f9653a.size();
            for (int i8 = 0; i8 < size; i8++) {
                z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
                z0Var.getClass();
                we.h.b("NearConnectionManager", "onServiceDisabled");
                z0Var.f10075a.execute(new v0(z0Var, b9, b9));
            }
        }
        CountDownLatch countDownLatch = this.f4198l;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void E(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        this.f4195i.E(new we.i(this), this.q);
        se.e eVar = this.f4201o;
        if (eVar != null) {
            b1 b1Var = (b1) eVar.f9720b;
            int size = b1Var.f9653a.size();
            for (int i8 = 0; i8 < size; i8++) {
                z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
                z0Var.getClass();
                we.h.b("NearConnectionManager", "onServiceEnabled");
                z0Var.f10075a.execute(new v0(z0Var, 2, (byte) 0));
            }
        }
        CountDownLatch countDownLatch = this.f4198l;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a6 A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:102:0x0150, B:103:0x015b, B:105:0x0161, B:107:0x016c, B:109:0x0170, B:111:0x0176, B:113:0x017a, B:115:0x017e, B:117:0x0184, B:119:0x018a, B:124:0x0193, B:126:0x0197, B:128:0x019b, B:132:0x01a6, B:134:0x01ac, B:142:0x01be), top: B:219:0x0150 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x01ac A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:102:0x0150, B:103:0x015b, B:105:0x0161, B:107:0x016c, B:109:0x0170, B:111:0x0176, B:113:0x017a, B:115:0x017e, B:117:0x0184, B:119:0x018a, B:124:0x0193, B:126:0x0197, B:128:0x019b, B:132:0x01a6, B:134:0x01ac, B:142:0x01be), top: B:219:0x0150 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:232:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, com.welink.protocol.nfbd.NearDevice] */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, android.os.Parcelable] */
    public final void F(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        int i8;
        T next;
        int i9;
        NearDeviceDataParcel nearDeviceDataParcel;
        int i10;
        int i11;
        T t3;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if ((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice) {
            Object obj = nearDeviceDataParcel2.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Parcelable parcelable = tranConnectionController$MessageInfo.f3975j.f3904b;
            T t8 = parcelable instanceof NearDevice ? (NearDevice) parcelable : 0;
            objectRef.element = t8;
            if (t8 == 0) {
                we.h.j("SmartConnectWrapper", "P2p connect failed, can't find NearDevice, find it by device address");
                ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
                synchronized (mNearDevices) {
                    try {
                        ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                        Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                        Iterator it = mNearDevices2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t3 = 0;
                                break;
                            }
                            Object next2 = it.next();
                            NearDevice nearDevice = (NearDevice) next2;
                            if (!Intrinsics.areEqual(nearDevice.f3883a, bluetoothDevice.getAddress()) && !Intrinsics.areEqual(nearDevice.f3885c, bluetoothDevice.getAddress())) {
                                WirelessDevice wirelessDevice = nearDevice.f3896s;
                                WirelessDevice.Bluetooth bluetooth = wirelessDevice instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice : null;
                                if (bluetooth == null) {
                                    continue;
                                } else {
                                    BluetoothDevice bluetoothDevice2 = bluetooth.f4011d;
                                    if (!Intrinsics.areEqual(bluetoothDevice2 != null ? bluetoothDevice2.getAddress() : null, bluetoothDevice.getAddress())) {
                                        continue;
                                    }
                                }
                            }
                            if (Intrinsics.areEqual(nearDevice.f3884b, tranConnectionController$MessageInfo.f3972d)) {
                                t3 = next2;
                                break;
                            }
                        }
                        objectRef.element = t3;
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (objectRef.element == 0) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Can't find NearDevice, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, ignore", null);
                    return;
                }
                return;
            }
            TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
            Integer numValueOf = tranConnectionController$EventInfo != null ? Integer.valueOf(tranConnectionController$EventInfo.f3966c) : null;
            if (numValueOf != null && numValueOf.intValue() == 100) {
                i11 = 10;
            } else if (numValueOf != null && numValueOf.intValue() == 0) {
                i11 = 6;
            } else if (numValueOf != null && numValueOf.intValue() == 2) {
                i11 = 8;
            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                i11 = 9;
            } else if (numValueOf != null && numValueOf.intValue() == 1) {
                i11 = 7;
            } else {
                i11 = (numValueOf != null && numValueOf.intValue() == 101) ? 12 : 0;
            }
            NearDevice nearDevice2 = (NearDevice) objectRef.element;
            if (nearDevice2 != null) {
                se.e eVar = this.f4201o;
                if (eVar != null) {
                    eVar.q(nearDevice2, i11);
                }
                c0 c0Var = this.f4191c;
                if (c0Var != null) {
                    c0Var.b(nearDevice2);
                    return;
                }
                return;
            }
            return;
        }
        DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
        Parcelable parcelable2 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
        NearDevice nearDevice3 = parcelable2 instanceof NearDevice ? (NearDevice) parcelable2 : null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ConcurrentHashMap.KeySetView mNearDevices3 = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
        synchronized (mNearDevices3) {
            try {
                ConcurrentHashMap.KeySetView mNearDevices4 = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices4, "mNearDevices");
                Iterator it2 = mNearDevices4.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i8 = 10;
                        next = 0;
                        break;
                    }
                    next = it2.next();
                    NearDevice nearDevice4 = (NearDevice) next;
                    if (!Intrinsics.areEqual(nearDevice4.f3883a, deviceInfo != null ? deviceInfo.f4223d : null)) {
                        if (!Intrinsics.areEqual(nearDevice4.f3885c, deviceInfo != null ? deviceInfo.f4223d : null)) {
                            WirelessDevice wirelessDevice2 = nearDevice4.f3896s;
                            WirelessDevice.P2p p2p = wirelessDevice2 instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice2 : null;
                            if (p2p != null) {
                                if (!Intrinsics.areEqual(p2p.f4014b, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                    if (nearDevice3 == null) {
                                        if (!Intrinsics.areEqual(nearDevice4, nearDevice3)) {
                                            i10 = nearDevice4.f3890k;
                                            i8 = 10;
                                            if (i10 != 10 || i10 == 11) {
                                                break;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else if (nearDevice3 == null) {
                                if (!Intrinsics.areEqual(nearDevice4, nearDevice3)) {
                                    i10 = nearDevice4.f3890k;
                                    i8 = 10;
                                    if (i10 != 10) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    i8 = 10;
                    break;
                }
                objectRef2.element = next;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$MessageInfo.f3974i;
        if (((tranConnectionController$EventInfo2 == null || (nearDeviceDataParcel = tranConnectionController$EventInfo2.f3968h) == null) ? null : nearDeviceDataParcel.f3904b) instanceof NearDevice) {
            objectRef2.element = tranConnectionController$EventInfo2.f3968h.f3904b;
        } else {
            NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$MessageInfo.f3975j;
            if ((nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null) instanceof NearDevice) {
                Object obj2 = nearDeviceDataParcel3.f3903a;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                objectRef2.element = (NearDevice) obj2;
            } else {
                we.h.j("SmartConnectWrapper", "p2p disconnect use found device");
            }
        }
        if (objectRef2.element == 0) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Can't find NearDevice, Qr or nfc p2p mode ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, Qr or nfc p2p mode ignore", null);
                return;
            }
            return;
        }
        TranConnectionController$EventInfo tranConnectionController$EventInfo3 = tranConnectionController$MessageInfo.f3974i;
        Integer numValueOf2 = tranConnectionController$EventInfo3 != null ? Integer.valueOf(tranConnectionController$EventInfo3.f3966c) : null;
        if (numValueOf2 != null && numValueOf2.intValue() == 100) {
            i9 = i8;
        } else if (numValueOf2 != null && numValueOf2.intValue() == 107) {
            i9 = 25;
        } else if (numValueOf2 != null && numValueOf2.intValue() == 0) {
            i9 = 6;
        } else if (numValueOf2 != null && numValueOf2.intValue() == 2) {
            i9 = 8;
        } else if (numValueOf2 != null && numValueOf2.intValue() == 3) {
            i9 = 9;
        } else if (numValueOf2 != null && numValueOf2.intValue() == 1) {
            i9 = 7;
        } else {
            i9 = (numValueOf2 != null && numValueOf2.intValue() == 101) ? 12 : 0;
        }
        NearDevice nearDevice5 = (NearDevice) objectRef2.element;
        if (nearDevice5 != null) {
            se.e eVar2 = this.f4201o;
            if (eVar2 != null) {
                eVar2.q(nearDevice5, i9);
            }
            c0 c0Var2 = this.f4191c;
            if (c0Var2 != null) {
                c0Var2.b(nearDevice5);
            }
        }
    }

    public final void G(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDevice device;
        NearDeviceDataParcel nearDeviceDataParcel;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if ((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice) {
            Object obj = nearDeviceDataParcel2.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
            if (!(((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof ConnectRequest)) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Incorrect reported data type, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported data type, ignore", null);
                    return;
                }
                return;
            }
            Object obj2 = tranConnectionController$EventInfo.f3968h.f3903a;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.welink.protocol.nfbd.ConnectRequest");
            ConnectRequest request = (ConnectRequest) obj2;
            we.h.b("SmartConnectWrapper", "Received P2P Invite Request, Device Name: " + request);
            we.h.b("SmartConnectWrapper", "NearDevice Connecting: null");
            Parcelable parcelable = tranConnectionController$EventInfo.f3968h.f3904b;
            if (parcelable instanceof NearDevice) {
                device = (NearDevice) parcelable;
            } else {
                we.h.j("SmartConnectWrapper", "P2p connect, can't find NearDevice-ConnectRequest, find it by device address");
                device = r(bluetoothDevice, null, null, null, Integer.valueOf(PointerIconCompat.TYPE_COPY));
            }
            if (device == null) {
                we.h.c("SmartConnectWrapper", "Can't find NearDevice, ignore", null);
                return;
            }
            c0 c0Var = this.f4191c;
            if (c0Var != null) {
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(request, "request");
                z manager = c0Var.f4090c;
                if (manager != null) {
                    r6 r6Var = new r6(c0Var, 3);
                    Intrinsics.checkNotNullParameter(manager, "manager");
                    Intrinsics.checkNotNullParameter(request, "request");
                    if (device.I.f(device, manager, request, r6Var)) {
                        we.h.b("TransSmartConnect", "Send P2p Connect Request Success");
                        return;
                    }
                    Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                    Intrinsics.checkNotNullParameter("Send P2p Connect Request Failed", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("TransSmartConnect", "TransConnect:Send P2p Connect Request Failed", null);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ef A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x000b, B:6:0x0015, B:8:0x0019, B:11:0x0020, B:13:0x0025, B:15:0x0056, B:17:0x005a, B:21:0x0066, B:30:0x00eb, B:32:0x00ef, B:35:0x00f5, B:45:0x0139, B:46:0x0140, B:59:0x015f, B:62:0x0162, B:63:0x0163, B:36:0x0107, B:38:0x0112, B:41:0x0119, B:42:0x011b, B:44:0x0132, B:24:0x0078, B:26:0x00cd, B:28:0x00d6, B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:66:0x000b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f5 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x000b, B:6:0x0015, B:8:0x0019, B:11:0x0020, B:13:0x0025, B:15:0x0056, B:17:0x005a, B:21:0x0066, B:30:0x00eb, B:32:0x00ef, B:35:0x00f5, B:45:0x0139, B:46:0x0140, B:59:0x015f, B:62:0x0162, B:63:0x0163, B:36:0x0107, B:38:0x0112, B:41:0x0119, B:42:0x011b, B:44:0x0132, B:24:0x0078, B:26:0x00cd, B:28:0x00d6, B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:66:0x000b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0107 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x000b, B:6:0x0015, B:8:0x0019, B:11:0x0020, B:13:0x0025, B:15:0x0056, B:17:0x005a, B:21:0x0066, B:30:0x00eb, B:32:0x00ef, B:35:0x00f5, B:45:0x0139, B:46:0x0140, B:59:0x015f, B:62:0x0162, B:63:0x0163, B:36:0x0107, B:38:0x0112, B:41:0x0119, B:42:0x011b, B:44:0x0132, B:24:0x0078, B:26:0x00cd, B:28:0x00d6, B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:66:0x000b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0112 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x000b, B:6:0x0015, B:8:0x0019, B:11:0x0020, B:13:0x0025, B:15:0x0056, B:17:0x005a, B:21:0x0066, B:30:0x00eb, B:32:0x00ef, B:35:0x00f5, B:45:0x0139, B:46:0x0140, B:59:0x015f, B:62:0x0162, B:63:0x0163, B:36:0x0107, B:38:0x0112, B:41:0x0119, B:42:0x011b, B:44:0x0132, B:24:0x0078, B:26:0x00cd, B:28:0x00d6, B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:66:0x000b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0116  */
    /* JADX WARN: Code duplicated, block: B:41:0x0119 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x000b, B:6:0x0015, B:8:0x0019, B:11:0x0020, B:13:0x0025, B:15:0x0056, B:17:0x005a, B:21:0x0066, B:30:0x00eb, B:32:0x00ef, B:35:0x00f5, B:45:0x0139, B:46:0x0140, B:59:0x015f, B:62:0x0162, B:63:0x0163, B:36:0x0107, B:38:0x0112, B:41:0x0119, B:42:0x011b, B:44:0x0132, B:24:0x0078, B:26:0x00cd, B:28:0x00d6, B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:66:0x000b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0132 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x000b, B:6:0x0015, B:8:0x0019, B:11:0x0020, B:13:0x0025, B:15:0x0056, B:17:0x005a, B:21:0x0066, B:30:0x00eb, B:32:0x00ef, B:35:0x00f5, B:45:0x0139, B:46:0x0140, B:59:0x015f, B:62:0x0162, B:63:0x0163, B:36:0x0107, B:38:0x0112, B:41:0x0119, B:42:0x011b, B:44:0x0132, B:24:0x0078, B:26:0x00cd, B:28:0x00d6, B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:66:0x000b, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0156 A[Catch: all -> 0x0152, TryCatch #1 {all -> 0x0152, blocks: (B:47:0x0141, B:49:0x0149, B:58:0x015d, B:55:0x0156, B:57:0x015a), top: B:67:0x0141, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x00f5, please report this as an issue */
    public final void H(NearDevice nearDevice, WifiP2pDevice wifiP2pDevice, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo) {
        NearNetworkElement.Wifi wifi;
        NearNetworkElement.Wifi wifi2;
        NearDeviceExtension nearDeviceExtension;
        LanNetworkInfo lanNetworkInfo;
        LanNetworkInfo lanNetworkInfo2;
        String str;
        NearDeviceExtension nearDeviceExtension2;
        ConcurrentHashMap.KeySetView mNearDevices;
        se.e eVar;
        WifiP2pGroup wifiP2pGroup;
        synchronized (this) {
            try {
                we.h.h("SmartConnectWrapper", "Notify p2pConnectNotify");
                if (wifiP2pDevice != null) {
                    wifi2 = new NearNetworkElement.Wifi(1, wifiP2pDevice.deviceName, 0, 0, wifiP2pDevice.deviceAddress, 0, 0, 0, 1, new NetworkParamsInformation(tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3979d : null, null, tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.e : null, null, null, null, null, null, null, null, null, null, null, null, null), 0, (tranConnectionController$P2pDeviceInfo == null || (wifiP2pGroup = tranConnectionController$P2pDeviceInfo.f3983k) == null) ? null : wifiP2pGroup.getInterface());
                } else {
                    if (tranConnectionController$P2pDeviceInfo != null) {
                        String str2 = tranConnectionController$P2pDeviceInfo.f3979d;
                        NetworkParamsInformation networkParamsInformation = new NetworkParamsInformation(str2, null, tranConnectionController$P2pDeviceInfo.e, null, str2, str2, str2, tranConnectionController$P2pDeviceInfo.f3977b, null, null, null, null, null, null, null);
                        String str3 = tranConnectionController$P2pDeviceInfo.f3976a;
                        Integer numValueOf = Integer.valueOf(l(Integer.valueOf(tranConnectionController$P2pDeviceInfo.f3978c)));
                        Integer numValueOf2 = Integer.valueOf(tranConnectionController$P2pDeviceInfo.f3978c);
                        String str4 = tranConnectionController$P2pDeviceInfo.f3977b;
                        Integer numValueOf3 = Integer.valueOf(tranConnectionController$P2pDeviceInfo.f3980h);
                        Integer numValueOf4 = Integer.valueOf(tranConnectionController$P2pDeviceInfo.f3981i);
                        WifiP2pGroup wifiP2pGroup2 = tranConnectionController$P2pDeviceInfo.f3983k;
                        wifi2 = new NearNetworkElement.Wifi(1, str3, numValueOf, numValueOf2, str4, numValueOf3, numValueOf4, 0, 1, networkParamsInformation, 0, wifiP2pGroup2 != null ? wifiP2pGroup2.getInterface() : null);
                    } else {
                        wifi = null;
                    }
                    nearDeviceExtension = nearDevice.u;
                    if (nearDeviceExtension != null) {
                        lanNetworkInfo = nearDeviceExtension.f3909h;
                    } else {
                        lanNetworkInfo = null;
                    }
                    if (lanNetworkInfo != null) {
                        we.h.b("SmartConnectWrapper", "Network info is available: " + lanNetworkInfo);
                    } else {
                        we.h.b("SmartConnectWrapper", "Network info is not available, force update it");
                        if (tranConnectionController$P2pDeviceInfo != null) {
                            str = tranConnectionController$P2pDeviceInfo.f3979d;
                        } else {
                            str = null;
                        }
                        lanNetworkInfo2 = new LanNetworkInfo(str, tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.e : null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null);
                        nearDeviceExtension2 = nearDevice.u;
                        if (nearDeviceExtension2 != null) {
                            Intrinsics.checkNotNullParameter(lanNetworkInfo2, "lanNetworkInfo");
                            nearDeviceExtension2.f3909h = lanNetworkInfo2;
                        }
                    }
                    mNearDevices = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
                    synchronized (mNearDevices) {
                        try {
                            if (this.f4196j.contains(nearDevice) || this.f4197k.contains(nearDevice)) {
                                if (wifi != null && (eVar = this.f4201o) != null) {
                                    eVar.r(nearDevice, wifi);
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                wifi = wifi2;
                nearDeviceExtension = nearDevice.u;
                if (nearDeviceExtension != null) {
                    lanNetworkInfo = nearDeviceExtension.f3909h;
                } else {
                    lanNetworkInfo = null;
                }
                if (lanNetworkInfo != null) {
                    we.h.b("SmartConnectWrapper", "Network info is available: " + lanNetworkInfo);
                } else {
                    we.h.b("SmartConnectWrapper", "Network info is not available, force update it");
                    if (tranConnectionController$P2pDeviceInfo != null) {
                        str = tranConnectionController$P2pDeviceInfo.f3979d;
                    } else {
                        str = null;
                    }
                    lanNetworkInfo2 = new LanNetworkInfo(str, tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.e : null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null);
                    nearDeviceExtension2 = nearDevice.u;
                    if (nearDeviceExtension2 != null) {
                        Intrinsics.checkNotNullParameter(lanNetworkInfo2, "lanNetworkInfo");
                        nearDeviceExtension2.f3909h = lanNetworkInfo2;
                    }
                }
                mNearDevices = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
                synchronized (mNearDevices) {
                    if (this.f4196j.contains(nearDevice)) {
                        if (wifi != null) {
                            eVar.r(nearDevice, wifi);
                        }
                    } else if (wifi != null) {
                        eVar.r(nearDevice, wifi);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void I(String str, int i8, int i9, DeviceInfo deviceInfo, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo) {
        WifiP2pGroup wifiP2pGroup;
        String str2;
        synchronized (this) {
            try {
                we.h.h("SmartConnectWrapper", "Notify p2pConnectNotify");
                String str3 = (tranConnectionController$P2pDeviceInfo == null || (str2 = tranConnectionController$P2pDeviceInfo.f3979d) == null) ? str : str2;
                int i10 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3980h : i8;
                int i11 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3981i : i9;
                String str4 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3976a : null;
                String str5 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3977b : null;
                Integer numValueOf = tranConnectionController$P2pDeviceInfo != null ? Integer.valueOf(tranConnectionController$P2pDeviceInfo.f3978c) : null;
                int iL = l(numValueOf);
                NearNetworkElement.Wifi wifi = new NearNetworkElement.Wifi(1, str4, Integer.valueOf(iL), numValueOf, str5, Integer.valueOf(i10), Integer.valueOf(i11), 0, 1, new NetworkParamsInformation(str3, null, tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.e : null, null, str3, str3, str3, str5, null, null, null, null, null, null, null), 0, (tranConnectionController$P2pDeviceInfo == null || (wifiP2pGroup = tranConnectionController$P2pDeviceInfo.f3983k) == null) ? null : wifiP2pGroup.getInterface());
                NearDevice nearDeviceV = v(deviceInfo);
                if (nearDeviceV != null) {
                    se.e eVar = this.f4201o;
                    if (eVar != null) {
                        eVar.r(nearDeviceV, wifi);
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    we.h.c("SmartConnectWrapper", "Current Device is null, ignore", null);
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:79:0x016c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [T, android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    public final void J(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        T next;
        NearDeviceDataParcel nearDeviceDataParcel;
        int i8;
        NearDevice nearDeviceS;
        WifiP2pDevice wifiP2pDevice;
        TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo;
        NearDeviceDataParcel nearDeviceDataParcel2;
        NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$MessageInfo.f3975j;
        if ((nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null) instanceof BluetoothDevice) {
            Object obj = nearDeviceDataParcel3.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
            Parcelable parcelable = (tranConnectionController$EventInfo == null || (nearDeviceDataParcel2 = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel2.f3903a;
            if (parcelable instanceof WifiP2pDevice) {
                Parcelable parcelable2 = tranConnectionController$EventInfo.f3968h.f3904b;
                if (parcelable2 instanceof NearDevice) {
                    nearDeviceS = (NearDevice) parcelable2;
                } else {
                    we.h.j("SmartConnectWrapper", "P2p connect, can't find NearDevice-P2pDevice, find it by device address");
                    nearDeviceS = r(bluetoothDevice, null, null, null, Integer.valueOf(PointerIconCompat.TYPE_NO_DROP));
                }
                Object obj2 = tranConnectionController$MessageInfo.f3974i.f3968h.f3903a;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                wifiP2pDevice = (WifiP2pDevice) obj2;
                tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(null, null, 0, tranConnectionController$MessageInfo.f3974i.f3964a, tranConnectionController$MessageInfo.f3969a, 0, 0, wifiP2pDevice, null);
            } else if (parcelable instanceof TranConnectionController$P2pDeviceInfo) {
                Parcelable parcelable3 = tranConnectionController$EventInfo.f3968h.f3904b;
                if (parcelable3 instanceof NearDevice) {
                    nearDeviceS = (NearDevice) parcelable3;
                } else {
                    we.h.j("SmartConnectWrapper", "P2p connect, can't find NearDevice-P2pDeviceInfo, find it by device address");
                    nearDeviceS = s(this, bluetoothDevice, null, Integer.valueOf(PointerIconCompat.TYPE_NO_DROP), 24);
                }
                Object obj3 = tranConnectionController$MessageInfo.f3974i.f3968h.f3903a;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
                tranConnectionController$P2pDeviceInfo = (TranConnectionController$P2pDeviceInfo) obj3;
                wifiP2pDevice = null;
            } else {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Incorrect reported data p2p device type, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported data p2p device type, ignore", null);
                }
                nearDeviceS = null;
                wifiP2pDevice = null;
                tranConnectionController$P2pDeviceInfo = null;
            }
            if (nearDeviceS != null) {
                H(nearDeviceS, wifiP2pDevice, tranConnectionController$P2pDeviceInfo);
                return;
            }
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Can't find NearDevice, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, ignore", null);
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
        Intrinsics.checkNotNullParameter("Incorrect reported device type, ignore", "mes");
        if (lb.f6529c >= 1) {
            Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported device type, ignore", null);
        }
        NearDeviceDataParcel nearDeviceDataParcel4 = tranConnectionController$MessageInfo.f3975j;
        Parcelable parcelable4 = nearDeviceDataParcel4 != null ? nearDeviceDataParcel4.f3904b : null;
        NearDevice nearDevice = parcelable4 instanceof NearDevice ? (NearDevice) parcelable4 : null;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        synchronized (mNearDevices) {
            try {
                ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                Iterator it = mNearDevices2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = 0;
                        break;
                    }
                    next = it.next();
                    NearDevice nearDevice2 = (NearDevice) next;
                    String str = nearDevice2.f3883a;
                    DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
                    if (!Intrinsics.areEqual(str, deviceInfo != null ? deviceInfo.f4223d : null)) {
                        String str2 = nearDevice2.f3885c;
                        DeviceInfo deviceInfo2 = tranConnectionController$MessageInfo.f3973h;
                        if (Intrinsics.areEqual(str2, deviceInfo2 != null ? deviceInfo2.f4223d : null)) {
                            break;
                        }
                        WirelessDevice wirelessDevice = nearDevice2.f3896s;
                        WirelessDevice.P2p p2p = wirelessDevice instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice : null;
                        if (p2p != null) {
                            String str3 = p2p.f4014b;
                            DeviceInfo deviceInfo3 = tranConnectionController$MessageInfo.f3973h;
                            if (!Intrinsics.areEqual(str3, deviceInfo3 != null ? deviceInfo3.f4223d : null)) {
                                if (nearDevice == null && (Intrinsics.areEqual(nearDevice2, nearDevice) || (i8 = nearDevice2.f3890k) == 10 || i8 == 11)) {
                                    break;
                                    break;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (nearDevice == null) {
                        }
                    } else {
                        break;
                    }
                }
                objectRef.element = next;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$MessageInfo.f3974i;
        Parcelable parcelable5 = (tranConnectionController$EventInfo2 == null || (nearDeviceDataParcel = tranConnectionController$EventInfo2.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a;
        if (!(parcelable5 instanceof TranConnectionController$P2pDeviceInfo)) {
            if (!(parcelable5 instanceof WifiP2pDevice)) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Incorrect reported data type, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported data type, ignore", null);
                    return;
                }
                return;
            }
            NearDeviceDataParcel nearDeviceDataParcel5 = tranConnectionController$EventInfo2.f3968h;
            Parcelable parcelable6 = nearDeviceDataParcel5.f3904b;
            NearDevice nearDevice3 = parcelable6 instanceof NearDevice ? (NearDevice) parcelable6 : null;
            if (nearDevice3 == null) {
                nearDevice3 = (NearDevice) next;
            }
            Object obj4 = nearDeviceDataParcel5.f3903a;
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
            WifiP2pDevice wifiP2pDevice2 = (WifiP2pDevice) obj4;
            TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo2 = new TranConnectionController$P2pDeviceInfo(null, null, 0, tranConnectionController$MessageInfo.f3974i.f3964a, tranConnectionController$MessageInfo.f3969a, 0, 0, wifiP2pDevice2, null);
            if (nearDevice3 != null) {
                H(nearDevice3, wifiP2pDevice2, tranConnectionController$P2pDeviceInfo2);
                return;
            }
            return;
        }
        Object obj5 = tranConnectionController$EventInfo2.f3968h.f3903a;
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
        TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo3 = (TranConnectionController$P2pDeviceInfo) obj5;
        ?? r7 = tranConnectionController$MessageInfo.f3974i.f3968h.f3904b;
        if (r7 instanceof NearDevice) {
            objectRef.element = r7;
            ConcurrentHashMap.KeySetView mNearDevices3 = this.f4196j;
            Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
            synchronized (mNearDevices3) {
                T t3 = objectRef.element;
                if (t3 != 0) {
                    NearDevice nearDevice4 = (NearDevice) ((Parcelable) t3);
                    if (!this.f4196j.contains(nearDevice4)) {
                        this.f4196j.add(nearDevice4);
                    }
                }
            }
        }
        T t8 = objectRef.element;
        if (t8 != 0) {
            H((NearDevice) t8, null, tranConnectionController$P2pDeviceInfo3);
            return;
        }
        Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
        Intrinsics.checkNotNullParameter("P2p connect, can't find NearDevice, ignore", "mes");
        if (lb.f6529c >= 1) {
            Log.e("SmartConnectWrapper", "TransConnect:P2p connect, can't find NearDevice, ignore", null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:217:0x02f3  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21, types: [T, android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.welink.protocol.nfbd.NearDevice] */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, com.welink.protocol.nfbd.NearDevice] */
    public final void K(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        T t3;
        c0 c0Var;
        Integer num;
        NearDeviceDataParcel nearDeviceDataParcel;
        int i8;
        Object next;
        Integer num2;
        NearDevice nearDevice;
        Integer num3;
        se.e eVar;
        c0 c0Var2;
        Integer num4;
        se.e eVar2;
        se.e eVar3;
        se.e eVar4;
        c0 c0Var3;
        Integer num5;
        se.e eVar5;
        T t8;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if (!((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice)) {
            DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
            Parcelable parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
            NearDevice nearDevice2 = parcelable instanceof NearDevice ? (NearDevice) parcelable : null;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
            Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
            synchronized (mNearDevices) {
                try {
                    ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                    Iterator it = mNearDevices2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t3 = 0;
                            break;
                        }
                        Object next2 = it.next();
                        NearDevice nearDevice3 = (NearDevice) next2;
                        if (!Intrinsics.areEqual(nearDevice3.f3883a, deviceInfo != null ? deviceInfo.f4223d : null)) {
                            if (!Intrinsics.areEqual(nearDevice3.f3885c, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                WirelessDevice wirelessDevice = nearDevice3.f3896s;
                                WirelessDevice.P2p p2p = wirelessDevice instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice : null;
                                if (p2p != null) {
                                    if (!Intrinsics.areEqual(p2p.f4014b, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                        if (nearDevice2 != null || (!Intrinsics.areEqual(nearDevice3, nearDevice2) && (i8 = nearDevice3.f3890k) != 10 && i8 != 11)) {
                                        }
                                    }
                                } else if (nearDevice2 != null) {
                                }
                            }
                        }
                        t3 = next2;
                        break;
                    }
                    objectRef.element = t3;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
            if (((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : nearDeviceDataParcel.f3904b) instanceof NearDevice) {
                objectRef.element = tranConnectionController$EventInfo.f3968h.f3904b;
            } else {
                NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$MessageInfo.f3975j;
                if ((nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null) instanceof NearDevice) {
                    Object obj = nearDeviceDataParcel3.f3903a;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                    objectRef.element = (NearDevice) obj;
                } else {
                    we.h.j("SmartConnectWrapper", "p2p disconnect use found device");
                }
            }
            T t10 = objectRef.element;
            if (t10 == 0) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Can't find NearDevice, Qr or Nfc p2p mode, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, Qr or Nfc p2p mode, ignore", null);
                    return;
                }
                return;
            }
            NearDevice nearDevice4 = (NearDevice) t10;
            se.e eVar6 = this.f4201o;
            if (eVar6 != null) {
                eVar6.v(nearDevice4, 2, -1);
            }
            NearDevice nearDevice5 = (NearDevice) objectRef.element;
            if (nearDevice5 == null || (num = nearDevice5.f3898v) == null || num.intValue() != 1006) {
                NearDevice nearDevice6 = (NearDevice) objectRef.element;
                if (nearDevice6 != null) {
                    nearDevice6.A(PointerIconCompat.TYPE_CELL);
                }
                NearDevice nearDevice7 = (NearDevice) objectRef.element;
                if (nearDevice7 != null) {
                    nearDevice7.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                }
                if (nearDevice7 != null) {
                    se.g newState = new se.g(0);
                    Intrinsics.checkNotNullParameter(newState, "newState");
                    nearDevice7.I = newState;
                }
            }
            NearDevice nearDevice8 = (NearDevice) objectRef.element;
            if (nearDevice8 == null || (c0Var = this.f4191c) == null) {
                return;
            }
            c0Var.b(nearDevice8);
            return;
        }
        Object obj2 = nearDeviceDataParcel2.f3903a;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj2;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Parcelable parcelable2 = tranConnectionController$MessageInfo.f3975j.f3904b;
        T t11 = parcelable2 instanceof NearDevice ? (NearDevice) parcelable2 : 0;
        objectRef2.element = t11;
        if (t11 == 0) {
            we.h.j("SmartConnectWrapper", "P2p disconnect, can't find NearDevice, find it by device address");
            ConcurrentHashMap.KeySetView mNearDevices3 = this.f4196j;
            Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
            synchronized (mNearDevices3) {
                try {
                    ConcurrentHashMap.KeySetView mNearDevices4 = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices4, "mNearDevices");
                    Iterator it2 = mNearDevices4.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t8 = 0;
                            break;
                        }
                        Object next3 = it2.next();
                        NearDevice nearDevice9 = (NearDevice) next3;
                        if (!Intrinsics.areEqual(nearDevice9.f3883a, bluetoothDevice.getAddress()) && !Intrinsics.areEqual(nearDevice9.f3885c, bluetoothDevice.getAddress())) {
                            WirelessDevice wirelessDevice2 = nearDevice9.f3896s;
                            WirelessDevice.Bluetooth bluetooth = wirelessDevice2 instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice2 : null;
                            if (bluetooth == null) {
                                continue;
                            } else {
                                BluetoothDevice bluetoothDevice2 = bluetooth.f4011d;
                                if (!Intrinsics.areEqual(bluetoothDevice2 != null ? bluetoothDevice2.getAddress() : null, bluetoothDevice.getAddress())) {
                                    continue;
                                }
                            }
                        }
                        if (Intrinsics.areEqual(nearDevice9.f3884b, tranConnectionController$MessageInfo.f3972d)) {
                            t8 = next3;
                            break;
                        }
                    }
                    objectRef2.element = t8;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        } else {
            ConcurrentHashMap.KeySetView mNearDevices5 = this.f4196j;
            Intrinsics.checkNotNullExpressionValue(mNearDevices5, "mNearDevices");
            Iterator it3 = mNearDevices5.iterator();
            do {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
            } while (!Intrinsics.areEqual((NearDevice) next, objectRef2.element));
            ?? r7 = (NearDevice) next;
            if (r7 != 0 && r7 != objectRef2.element && (num2 = r7.f3898v) != null && num2.intValue() == 1003 && r7.f3899w == 1008 && (nearDevice = (NearDevice) objectRef2.element) != null && (num3 = nearDevice.f3898v) != null && num3.intValue() == 1004) {
                we.h.j("SmartConnectWrapper", "P2p disconnect, device is connecting happened, replace with new device");
                objectRef2.element = r7;
            }
        }
        T t12 = objectRef2.element;
        if (t12 == 0) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Can't find NearDevice, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, ignore", null);
                return;
            }
            return;
        }
        Integer num6 = ((NearDevice) t12).f3898v;
        if (num6 != null && num6.intValue() == 1003) {
            NearDevice nearDevice10 = (NearDevice) objectRef2.element;
            if (nearDevice10 != null && nearDevice10.f3899w == 1008) {
                we.h.b("SmartConnectWrapper", "P2P Disconnected, device is connecting?, ignore");
                return;
            }
            we.h.b("SmartConnectWrapper", "P2P Disconnected, device is connecting, but bluetooth disconnected, report device disconnected");
            NearDevice nearDevice11 = (NearDevice) objectRef2.element;
            if (nearDevice11 != null && (eVar5 = this.f4201o) != null) {
                eVar5.v(nearDevice11, 2, -1);
            }
            NearDevice nearDevice12 = (NearDevice) objectRef2.element;
            if (nearDevice12 == null || (num5 = nearDevice12.f3898v) == null || num5.intValue() != 1006) {
                NearDevice nearDevice13 = (NearDevice) objectRef2.element;
                if (nearDevice13 != null) {
                    nearDevice13.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                }
                if (nearDevice13 != null) {
                    se.g newState2 = new se.g(0);
                    Intrinsics.checkNotNullParameter(newState2, "newState");
                    nearDevice13.I = newState2;
                }
            }
            NearDevice nearDevice14 = (NearDevice) objectRef2.element;
            if (nearDevice14 == null || (c0Var3 = this.f4191c) == null) {
                return;
            }
            c0Var3.b(nearDevice14);
            return;
        }
        NearDevice nearDevice15 = (NearDevice) objectRef2.element;
        if ((nearDevice15 != null && nearDevice15.f3889j == 15) || ((nearDevice15 != null && nearDevice15.f3889j == 16) || (nearDevice15 != null && nearDevice15.f3889j == 17))) {
            we.h.b("SmartConnectWrapper", "Apple p2p disconnected, reason iphoneRequestResult:  " + (nearDevice15 != null ? Integer.valueOf(nearDevice15.E) : null));
            NearDevice nearDevice16 = (NearDevice) objectRef2.element;
            Integer numValueOf = nearDevice16 != null ? Integer.valueOf(nearDevice16.E) : null;
            if (numValueOf != null && numValueOf.intValue() == 4) {
                NearDevice nearDevice17 = (NearDevice) objectRef2.element;
                if (nearDevice17 != null && (eVar4 = this.f4201o) != null) {
                    eVar4.v(nearDevice17, 2, 24);
                }
            } else if (numValueOf != null && numValueOf.intValue() == 5) {
                NearDevice nearDevice18 = (NearDevice) objectRef2.element;
                if (nearDevice18 != null && (eVar3 = this.f4201o) != null) {
                    eVar3.v(nearDevice18, 2, 23);
                }
            } else {
                NearDevice nearDevice19 = (NearDevice) objectRef2.element;
                if (nearDevice19 != null && (eVar2 = this.f4201o) != null) {
                    eVar2.v(nearDevice19, 2, -1);
                }
            }
        } else if (nearDevice15 != null && (eVar = this.f4201o) != null) {
            eVar.v(nearDevice15, 2, -1);
        }
        NearDevice nearDevice20 = (NearDevice) objectRef2.element;
        we.h.b("SmartConnectWrapper", "P2P Disconnected, deprecated device state is: " + (nearDevice20 != null ? nearDevice20.v(null) : null) + ", ignore");
        NearDevice nearDevice21 = (NearDevice) objectRef2.element;
        if (nearDevice21 == null || (num4 = nearDevice21.f3898v) == null || num4.intValue() != 1006) {
            NearDevice nearDevice22 = (NearDevice) objectRef2.element;
            if (nearDevice22 != null) {
                nearDevice22.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
            }
            if (nearDevice22 != null) {
                se.g newState3 = new se.g(0);
                Intrinsics.checkNotNullParameter(newState3, "newState");
                nearDevice22.I = newState3;
            }
        }
        NearDevice nearDevice23 = (NearDevice) objectRef2.element;
        if (nearDevice23 == null || (c0Var2 = this.f4191c) == null) {
            return;
        }
        c0Var2.b(nearDevice23);
    }

    public final void L(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        if (!(((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof WifiP2pGroup)) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Incorrect reported data type, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported data type, ignore", null);
                return;
            }
            return;
        }
        Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pGroup");
        WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) obj;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if ((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof WifiP2pInfo) {
            Object obj2 = nearDeviceDataParcel2.f3903a;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pInfo");
            WifiP2pInfo wifiP2pInfo = (WifiP2pInfo) obj2;
            se.e eVar = this.f4201o;
            if (eVar != null) {
                Intrinsics.checkNotNullParameter(wifiP2pGroup, "wifiP2pGroup");
                Intrinsics.checkNotNullParameter(wifiP2pInfo, "wifiP2pInfo");
                b1 b1Var = (b1) eVar.f9720b;
                int size = b1Var.f9653a.size();
                for (int i8 = 0; i8 < size; i8++) {
                    z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
                    z0Var.getClass();
                    Intrinsics.checkNotNullParameter(wifiP2pGroup, "wifiP2pGroup");
                    Intrinsics.checkNotNullParameter(wifiP2pInfo, "wifiP2pInfo");
                    we.h.b("NearConnectionManager", "onP2pOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo);
                    z0Var.f10075a.execute(new a0.g(z0Var, 7, wifiP2pGroup, wifiP2pInfo));
                }
            }
            o.d.z("P2P Other Device Connected, group name = ", wifiP2pGroup.getNetworkName(), "SmartConnectWrapper");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    public final void M(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        T next;
        int i8;
        NearDeviceDataParcel nearDeviceDataParcel;
        WifiP2pDevice wifiP2pDevice;
        NearDevice nearDeviceR;
        NearDeviceDataParcel nearDeviceDataParcel2;
        NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$MessageInfo.f3975j;
        Parcelable parcelable = nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null;
        if (parcelable instanceof BluetoothDevice) {
            Object obj = nearDeviceDataParcel3.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
            if (((tranConnectionController$EventInfo == null || (nearDeviceDataParcel2 = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel2.f3903a) instanceof WifiP2pDevice) {
                Parcelable parcelable2 = tranConnectionController$EventInfo.f3968h.f3904b;
                if (parcelable2 instanceof NearDevice) {
                    nearDeviceR = (NearDevice) parcelable2;
                } else {
                    we.h.j("SmartConnectWrapper", "P2p owner available, can't find NearDevice-P2pDevice, find it by device address");
                    nearDeviceR = r(bluetoothDevice, null, null, null, Integer.valueOf(PointerIconCompat.TYPE_COPY));
                }
                Object obj2 = tranConnectionController$MessageInfo.f3974i.f3968h.f3903a;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                wifiP2pDevice = (WifiP2pDevice) obj2;
                o.d.z("Found P2P Owner device addr = ", wifiP2pDevice.deviceAddress, "SmartConnectWrapper");
            } else {
                wifiP2pDevice = null;
                nearDeviceR = null;
            }
            if (nearDeviceR != null) {
                se.e eVar = this.f4201o;
                if (eVar != null) {
                    eVar.x(nearDeviceR, wifiP2pDevice, null);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Can't find NearDevice, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, ignore", null);
                return;
            }
            return;
        }
        if (parcelable instanceof WifiP2pDevice) {
            Object obj3 = nearDeviceDataParcel3.f3903a;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
            WifiP2pDevice wifiP2pDevice2 = (WifiP2pDevice) obj3;
            TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$MessageInfo.f3974i;
            Parcelable parcelable3 = (tranConnectionController$EventInfo2 == null || (nearDeviceDataParcel = tranConnectionController$EventInfo2.f3968h) == null) ? null : nearDeviceDataParcel.f3904b;
            NearDevice nearDevice = parcelable3 instanceof NearDevice ? (NearDevice) parcelable3 : null;
            Parcelable parcelable4 = tranConnectionController$MessageInfo.f3975j.f3904b;
            TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = parcelable4 instanceof TranConnectionController$P2pDeviceInfo ? (TranConnectionController$P2pDeviceInfo) parcelable4 : null;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
            Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
            synchronized (mNearDevices) {
                try {
                    ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                    Iterator it = mNearDevices2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = 0;
                            break;
                        }
                        next = it.next();
                        NearDevice nearDevice2 = (NearDevice) next;
                        if (!Intrinsics.areEqual(nearDevice2.f3884b, tranConnectionController$MessageInfo.f3972d) && !Intrinsics.areEqual(nearDevice2.f3884b, wifiP2pDevice2.deviceName)) {
                            WirelessDevice wirelessDevice = nearDevice2.f3896s;
                            WirelessDevice.P2p p2p = wirelessDevice instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice : null;
                            if ((p2p != null && Intrinsics.areEqual(p2p.f4014b, wifiP2pDevice2.deviceAddress)) || (nearDevice != null && (Intrinsics.areEqual(nearDevice2, nearDevice) || (i8 = nearDevice2.f3890k) == 10 || i8 == 11))) {
                                break;
                                break;
                                break;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    objectRef.element = next;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (next != 0) {
                NearDevice nearDevice3 = (NearDevice) next;
                se.e eVar2 = this.f4201o;
                if (eVar2 != null) {
                    eVar2.x(nearDevice3, wifiP2pDevice2, tranConnectionController$P2pDeviceInfo);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Device is not match, p2p available", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Device is not match, p2p available", null);
            }
        }
    }

    public final void N(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDevice device;
        DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
        NearDeviceDataParcel nearDeviceDataParcel = tranConnectionController$MessageInfo.f3975j;
        Parcelable parcelable = nearDeviceDataParcel != null ? (Parcelable) nearDeviceDataParcel.f3903a : null;
        if (parcelable instanceof BluetoothDevice) {
            o.d.z("Found Bluetooth device addr = ", deviceInfo != null ? deviceInfo.f4223d : null, "SmartConnectWrapper");
            Object obj = tranConnectionController$MessageInfo.f3975j.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            device = v(deviceInfo);
            we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new device");
            if (device != null) {
                we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new device");
            } else {
                device = u();
                TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
                int i8 = tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.f3967d : 0;
                int i9 = tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.e : 0;
                if (device == null) {
                    device = deviceInfo != null ? h.c(deviceInfo, null, bluetoothDevice, i8, i9, null, 96) : null;
                    if (device == null) {
                        we.h.c("SmartConnectWrapper", "Can't create near device for remote connect request, ignore", null);
                        return;
                    } else {
                        we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new device");
                        this.f4195i.k(device, null, false, false);
                    }
                } else {
                    if (!Intrinsics.areEqual(device.f3883a, deviceInfo != null ? deviceInfo.f4223d : null)) {
                        if (!Intrinsics.areEqual(device.f3885c, deviceInfo != null ? deviceInfo.f4223d : null)) {
                            we.h.c("SmartConnectWrapper", "Near device address is not match, ignore", null);
                            return;
                        }
                    }
                    we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new device");
                }
            }
        } else {
            if (!(parcelable instanceof ScanResult)) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Incorrect scan result type, ignore", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Incorrect scan result type, ignore", null);
                    return;
                }
                return;
            }
            Object obj2 = nearDeviceDataParcel.f3903a;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.le.ScanResult");
            ScanResult scanResult = (ScanResult) obj2;
            NearDevice nearDeviceV = v(deviceInfo);
            we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new laptop device");
            if (nearDeviceV != null) {
                we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new laptop device");
            } else {
                nearDeviceV = u();
                if (nearDeviceV == null) {
                    device = deviceInfo != null ? h.c(deviceInfo, scanResult, null, 0, 0, null, 120) : null;
                    if (device == null) {
                        we.h.c("SmartConnectWrapper", "Can't create near device for remote pc connect request, ignore", null);
                        return;
                    } else {
                        we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new laptop device");
                        this.f4195i.k(device, null, false, false);
                    }
                } else {
                    if (!Intrinsics.areEqual(nearDeviceV.f3883a, deviceInfo != null ? deviceInfo.f4223d : null)) {
                        if (!Intrinsics.areEqual(nearDeviceV.f3885c, deviceInfo != null ? deviceInfo.f4223d : null)) {
                            we.h.c("SmartConnectWrapper", "Near device address is not match, ignore pc connect", null);
                            return;
                        }
                    }
                    we.h.h("SmartConnectWrapper", "Notify remoteConnectRequestNotify new laptop device");
                }
            }
            device = nearDeviceV;
        }
        se.e eVar = this.f4201o;
        if (eVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            b1 b1Var = (b1) eVar.f9720b;
            b1Var.f9654b.add(device);
            SparseArray sparseArray = b1Var.f9653a;
            int size = sparseArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                z0 z0Var = (z0) sparseArray.valueAt(i10);
                z0Var.getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                z0Var.f10075a.execute(new w0(z0Var, device, 1, (byte) 0));
            }
        }
    }

    public final void O(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        se.e eVar;
        DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
        NearDeviceDataParcel nearDeviceDataParcel = tranConnectionController$MessageInfo.f3975j;
        if (!((nearDeviceDataParcel != null ? (Parcelable) nearDeviceDataParcel.f3903a : null) instanceof BluetoothDevice)) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Incorrect scan result type, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Incorrect scan result type, ignore", null);
                return;
            }
            return;
        }
        Object obj = nearDeviceDataParcel.f3903a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
        NearDevice nearDeviceV = v(deviceInfo);
        if (nearDeviceV == null) {
            NearDevice nearDeviceU = u();
            if (nearDeviceU != null) {
                se.e eVar2 = this.f4201o;
                if (eVar2 != null) {
                    eVar2.v(nearDeviceU, 1, -1);
                }
                c0 c0Var = this.f4191c;
                if (c0Var != null) {
                    c0Var.b(nearDeviceU);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Can't find connecting device, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Can't find connecting device, ignore", null);
            }
            NearDevice nearDeviceC = deviceInfo != null ? h.c(deviceInfo, null, bluetoothDevice, 0, 0, null, 96) : null;
            if (nearDeviceC == null || (eVar = this.f4201o) == null) {
                return;
            }
            eVar.v(nearDeviceC, 1, -1);
            return;
        }
        if (!this.f4196j.contains(nearDeviceV) && !this.f4197k.contains(nearDeviceV)) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Near device is not in list, ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Near device is not in list, ignore", null);
                return;
            }
            return;
        }
        Integer num = nearDeviceV.f3898v;
        if (num == null || num.intValue() != 1006) {
            we.h.j("SmartConnectWrapper", "Device is p2p connecting, ignore disconnect event??");
            return;
        }
        se.e eVar3 = this.f4201o;
        if (eVar3 != null) {
            eVar3.v(nearDeviceV, 1, -1);
        }
        c0 c0Var2 = this.f4191c;
        if (c0Var2 != null) {
            c0Var2.b(nearDeviceV);
        }
    }

    public final void P(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        Object next;
        NearDeviceDataParcel nearDeviceDataParcel = tranConnectionController$MessageInfo.f3975j;
        Object obj = null;
        if (!((nearDeviceDataParcel != null ? (Parcelable) nearDeviceDataParcel.f3903a : null) instanceof BluetoothDevice)) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Incorrect reported device type, notify ignore", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Incorrect reported device type, notify ignore", null);
                return;
            }
            return;
        }
        Object obj2 = nearDeviceDataParcel.f3903a;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj2;
        ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        Iterator it = mNearDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            NearDevice nearDevice = (NearDevice) next;
            if (Intrinsics.areEqual(nearDevice.f3883a, bluetoothDevice.getAddress()) || Intrinsics.areEqual(nearDevice.f3885c, bluetoothDevice.getAddress())) {
                break;
            }
            WirelessDevice wirelessDevice = nearDevice.f3896s;
            WirelessDevice.Bluetooth bluetooth = wirelessDevice instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice : null;
            if (bluetooth != null) {
                BluetoothDevice bluetoothDevice2 = bluetooth.f4011d;
                if (Intrinsics.areEqual(bluetoothDevice2 != null ? bluetoothDevice2.getAddress() : null, bluetoothDevice.getAddress())) {
                    break;
                }
            }
        }
        NearDevice device = (NearDevice) next;
        if (device == null) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Can't find NearDevice, ignore notify", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Can't find NearDevice, ignore notify", null);
                return;
            }
            return;
        }
        WirelessDevice wirelessDevice2 = device.f3896s;
        Intrinsics.checkNotNull(wirelessDevice2, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
        WirelessDevice.Bluetooth bluetooth2 = (WirelessDevice.Bluetooth) wirelessDevice2;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        bluetooth2.e = tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.f3967d : 0;
        bluetooth2.f4012h = tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.e : 0;
        R(device, tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.f3967d : 0, tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.e : 0);
        se.e eVar = this.f4201o;
        if (eVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            b1 b1Var = (b1) eVar.f9720b;
            for (Object obj3 : b1Var.f9654b) {
                if (Intrinsics.areEqual((NearDevice) obj3, device)) {
                    obj = obj3;
                    break;
                }
            }
            if (((NearDevice) obj) == null) {
                b1Var.f9654b.add(device);
            }
            SparseArray sparseArray = b1Var.f9653a;
            int size = sparseArray.size();
            for (int i8 = 0; i8 < size; i8++) {
                ((z0) sparseArray.valueAt(i8)).getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                we.h.b("NearConnectionManager", "onExchangeNotify: " + device);
            }
        }
    }

    public final void Q(BluetoothDevice bluetoothDevice) {
        ConcurrentHashMap.KeySetView mInvitingDevices = this.f4199m;
        Intrinsics.checkNotNullExpressionValue(mInvitingDevices, "mInvitingDevices");
        synchronized (mInvitingDevices) {
            ConcurrentHashMap.KeySetView mInvitingDevices2 = this.f4199m;
            Intrinsics.checkNotNullExpressionValue(mInvitingDevices2, "mInvitingDevices");
            CollectionsKt__MutableCollectionsKt.removeAll(mInvitingDevices2, new se.b0(bluetoothDevice, 1));
        }
    }

    public final void R(NearDevice device, int i8, int i9) {
        c0 c0Var = this.f4191c;
        if (c0Var != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            z manager = c0Var.f4090c;
            if (manager != null) {
                r6 r6Var = new r6(c0Var, 0);
                device.getClass();
                Intrinsics.checkNotNullParameter(manager, "manager");
                if (device.I.j(device, manager, i8, i9, r6Var)) {
                    we.h.b("TransSmartConnect", "Send Exchange Response Success");
                    return;
                }
                Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                Intrinsics.checkNotNullParameter("Send Exchange Response Failed", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("TransSmartConnect", "TransConnect:Send Exchange Response Failed", null);
                }
            }
        }
    }

    public final void S() {
        c0 c0Var = this.f4191c;
        if (c0Var != null) {
            we.h.h("TransSmartConnect", "Disable SmartConnect");
            if (Intrinsics.areEqual(c0Var.f, v6.f10038a) || Intrinsics.areEqual(c0Var.f, w6.f10047a) || Intrinsics.areEqual(c0Var.f, y6.f10070a)) {
                c0Var.l(x6.f10059a);
            }
        }
    }

    public final void T() {
        if (z()) {
            we.h.b("SmartConnectWrapper", "Smart Config is already enabled, ignore");
            return;
        }
        c0 c0Var = this.f4191c;
        if (c0Var != null) {
            we.h.h("TransSmartConnect", "Enable SmartConnect");
            if (Intrinsics.areEqual(c0Var.f, u6.f10019a) || Intrinsics.areEqual(c0Var.f, w6.f10047a)) {
                c0Var.l(y6.f10070a);
            }
        }
    }

    public final void U() {
        z zVar;
        z zVar2;
        c0 c0Var = this.f4191c;
        if (c0Var != null && (zVar2 = c0Var.f4090c) != null) {
            Intent intent = new Intent();
            intent.setAction("com.welink.protocol.nfbd.action.STOP_ADV_DEVICE");
            g gVar = zVar2.f4207i;
            if (gVar != null) {
                gVar.w(intent, 0);
            }
        }
        y4 y4Var = this.e;
        if (y4Var == null || (zVar = y4Var.f10069a) == null) {
            return;
        }
        h5 h5Var = zVar.f4203c;
        if (h5Var != null && !h5Var.f9778i) {
            we.h.j("TranConnectionManager", "LanAdvertisement is not running");
            return;
        }
        Intent intent2 = new Intent();
        intent2.setAction("com.welink.protocol.nfbd.action.STOP_LAN_ADVERTISE");
        g gVar2 = zVar.f4207i;
        if (gVar2 != null) {
            gVar2.w(intent2, 0);
        }
    }

    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what == 20001) {
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.MessageInfo");
            B((TranConnectionController$MessageInfo) obj);
        }
    }

    public final void j(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        boolean z2 = ((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof NearDevice;
        NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
        if (!z2) {
            Parcelable parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
            NearDevice nearDeviceS = (parcelable == null || !(parcelable instanceof BluetoothDevice)) ? null : s(this, (BluetoothDevice) parcelable, null, null, 30);
            if (parcelable == null || !(parcelable instanceof BluetoothDevice) || nearDeviceS != null) {
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                h0.a.D("Connected LE device ", ((BluetoothDevice) parcelable).getAddress(), "SmartConnectWrapper");
                return;
            }
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Connected, device is not match, Bluetooth checking", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Connected, device is not match, Bluetooth checking", null);
            }
            this.f4199m.add(parcelable);
            return;
        }
        Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
        NearDevice nearDevice = (NearDevice) obj;
        Parcelable parcelable2 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
        NearDevice nearDeviceS2 = (parcelable2 == null || !(parcelable2 instanceof BluetoothDevice)) ? null : s(this, (BluetoothDevice) parcelable2, null, Integer.valueOf(PointerIconCompat.TYPE_TEXT), 24);
        if (this.f4196j.contains(nearDevice) || nearDeviceS2 != null) {
            h0.a.D("Connected LE device ", nearDevice.f3883a, "SmartConnectWrapper");
            return;
        }
        Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
        Intrinsics.checkNotNullParameter("Connected, device is not match, NearDevice checking bluetooth device", "mes");
        if (lb.f6529c >= 1) {
            Log.e("SmartConnectWrapper", "TransConnect:Connected, device is not match, NearDevice checking bluetooth device", null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0198  */
    public final void k(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDevice nearDeviceS;
        Integer num;
        NearDevice nearDeviceS2;
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        Object obj = null;
        if (!(((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof NearDevice)) {
            NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
            Parcelable parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
            if (parcelable == null || !(parcelable instanceof BluetoothDevice)) {
                nearDeviceS = null;
            } else {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) parcelable;
                Q(bluetoothDevice);
                nearDeviceS = s(this, bluetoothDevice, Integer.valueOf(PointerIconCompat.TYPE_ALIAS), null, 24);
            }
            if (parcelable != null && (parcelable instanceof BluetoothDevice) && nearDeviceS == null) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Disconnected, device is not match, Bluetooth checking", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Disconnected, device is not match, Bluetooth checking", null);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            h0.a.D("Disconnected LE device ", ((BluetoothDevice) parcelable).getAddress(), "SmartConnectWrapper");
            if (nearDeviceS == null || (num = nearDeviceS.f3898v) == null || num.intValue() != 1006) {
                return;
            }
            if (!this.f4195i.z(nearDeviceS)) {
                we.h.b("SmartConnectWrapper", "Disconnected LE, device is disconnected, it is not in discovery list, ignore");
                return;
            }
            we.h.b("SmartConnectWrapper", "Disconnected LE, device is disconnected, resume scan");
            se.e eVar = this.f4201o;
            if (eVar != null) {
                eVar.v(nearDeviceS, 1, tranConnectionController$EventInfo != null ? tranConnectionController$EventInfo.f3966c : -1);
            }
            c0 c0Var = this.f4191c;
            if (c0Var != null) {
                c0Var.b(nearDeviceS);
                return;
            }
            return;
        }
        Object obj2 = tranConnectionController$EventInfo.f3968h.f3903a;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
        NearDevice nearDevice = (NearDevice) obj2;
        NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$MessageInfo.f3975j;
        Parcelable parcelable2 = nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null;
        if (parcelable2 == null || !(parcelable2 instanceof BluetoothDevice)) {
            nearDeviceS2 = null;
        } else {
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) parcelable2;
            Q(bluetoothDevice2);
            nearDeviceS2 = s(this, bluetoothDevice2, Integer.valueOf(PointerIconCompat.TYPE_ALIAS), null, 24);
        }
        if (!this.f4196j.contains(nearDevice) && nearDeviceS2 == null) {
            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
            Intrinsics.checkNotNullParameter("Disconnected, device is not match, NearDevice checking bluetooth device", "mes");
            if (lb.f6529c >= 1) {
                Log.e("SmartConnectWrapper", "TransConnect:Disconnected, device is not match, NearDevice checking bluetooth device", null);
                return;
            }
            return;
        }
        h0.a.D("Disconnected LE device ", nearDevice.f3883a, "SmartConnectWrapper");
        Integer num2 = nearDevice.f3898v;
        if (num2 != null && num2.intValue() == 1006) {
            we.h.b("SmartConnectWrapper", "Disconnected LE, device is disconnected");
            int i8 = nearDevice.e;
            if (i8 == 1) {
                if (this.f4197k.contains(nearDevice)) {
                    this.f4197k.remove(nearDevice);
                }
                if (a.f4027k.c("1.0")) {
                    int iP = p(tranConnectionController$EventInfo.f3966c);
                    int i9 = nearDevice.f3889j;
                    if (i9 == 17 || i9 == 16 || i9 == 15) {
                        we.h.h("SmartConnectWrapper", "when disconnected LE, apple iphoneRequestResult is " + nearDevice.E + " ");
                        int i10 = nearDevice.E;
                        if (i10 == 4 || i10 == 5) {
                            we.h.h("SmartConnectWrapper", "p2p CONNECT_CANCEL or PERMISSION_REJECT, ble disconnect notify ignore");
                            return;
                        }
                    }
                    se.e eVar2 = this.f4201o;
                    if (eVar2 != null) {
                        eVar2.v(nearDevice, 1, iP);
                    }
                } else {
                    se.e eVar3 = this.f4201o;
                    if (eVar3 != null) {
                        eVar3.q(nearDevice, 1);
                    }
                }
            } else if (i8 == 0) {
                int iP2 = p(tranConnectionController$EventInfo.f3966c);
                int i11 = tranConnectionController$EventInfo.f3966c;
                if (i11 == -3 || i11 == -2 || i11 == -1 || i11 == 0) {
                    h0.a.C(i11, "Connect Failed, Reason code: ", "SmartConnectWrapper");
                    f(new a0.b(nearDevice, this, tranConnectionController$MessageInfo.f3973h, iP2, 4));
                } else if (i11 == 3) {
                    ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
                    synchronized (mNearDevices) {
                        try {
                            ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                            Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                            for (Object obj3 : mNearDevices2) {
                                if (Intrinsics.areEqual((NearDevice) obj3, nearDevice)) {
                                    obj = obj3;
                                    break;
                                }
                            }
                            NearDevice nearDevice2 = (NearDevice) obj;
                            if (nearDevice2 != null) {
                                nearDevice2.A(PointerIconCompat.TYPE_CELL);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    se.e eVar4 = this.f4201o;
                    if (eVar4 != null) {
                        eVar4.v(nearDevice, 2, iP2);
                    }
                } else if (i11 == 6) {
                    h0.a.C(i11, "Connect Failed, Reason code: ", "SmartConnectWrapper");
                    f(new a0.b(nearDevice, this, tranConnectionController$MessageInfo.f3973h, iP2, 4));
                } else if (i11 == 11) {
                    ConcurrentHashMap.KeySetView mNearDevices3 = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
                    synchronized (mNearDevices3) {
                        try {
                            ConcurrentHashMap.KeySetView mNearDevices4 = this.f4196j;
                            Intrinsics.checkNotNullExpressionValue(mNearDevices4, "mNearDevices");
                            for (Object obj4 : mNearDevices4) {
                                if (Intrinsics.areEqual((NearDevice) obj4, nearDevice)) {
                                    obj = obj4;
                                    break;
                                }
                            }
                            NearDevice nearDevice3 = (NearDevice) obj;
                            if (nearDevice3 != null) {
                                nearDevice3.A(PointerIconCompat.TYPE_CELL);
                                Unit unit2 = Unit.INSTANCE;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    se.e eVar5 = this.f4201o;
                    if (eVar5 != null) {
                        eVar5.u(nearDevice, iP2);
                    }
                } else if (i11 != 13 && i11 != 14) {
                    switch (i11) {
                        case 16:
                        case 17:
                        case 18:
                            h0.a.C(i11, "Connect Failed, Reason code: ", "SmartConnectWrapper");
                            f(new a0.b(nearDevice, this, tranConnectionController$MessageInfo.f3973h, iP2, 4));
                            break;
                    }
                } else {
                    h0.a.C(i11, "Connect Failed, Reason code: ", "SmartConnectWrapper");
                    f(new a0.b(nearDevice, this, tranConnectionController$MessageInfo.f3973h, iP2, 4));
                }
            } else {
                int iP3 = p(tranConnectionController$EventInfo.f3966c);
                se.e eVar6 = this.f4201o;
                if (eVar6 != null) {
                    eVar6.v(nearDevice, 1, iP3);
                }
            }
            c0 c0Var2 = this.f4191c;
            if (c0Var2 != null) {
                c0Var2.b(nearDevice);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0132  */
    public final boolean m(NearDevice device) {
        String str;
        String str2;
        if (this.f4195i.y(device)) {
            return false;
        }
        NearDeviceExtension nearDeviceExtension = device.u;
        if (nearDeviceExtension != null && !nearDeviceExtension.e) {
            t1 t1Var = this.f4195i;
            t1Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            synchronized (t1Var.f9990d) {
                try {
                    t4 t4VarW = t1.w(device);
                    switch (s1.$EnumSwitchMapping$0[t4VarW.ordinal()]) {
                        case 1:
                            ConcurrentHashMap.KeySetView mBleCachedDevices = t1Var.f9992h;
                            Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                            synchronized (mBleCachedDevices) {
                                Iterator it = t1Var.f9992h.iterator();
                                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                                while (it.hasNext()) {
                                    NearDevice nearDevice = (NearDevice) it.next();
                                    Intrinsics.checkNotNull(nearDevice);
                                    if (t1Var.n(nearDevice, device)) {
                                        return true;
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                                break;
                            }
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                            we.h.j("NearDeviceTableFusion", "Unsupported device type " + t4VarW.name());
                            Unit unit3 = Unit.INSTANCE;
                            break;
                        case 12:
                            we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                            Unit unit4 = Unit.INSTANCE;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else if (nearDeviceExtension != null && nearDeviceExtension.e) {
            t1 t1Var2 = this.f4195i;
            t1Var2.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            synchronized (t1Var2.f9990d) {
                try {
                    t4 t4VarW2 = t1.w(device);
                    switch (s1.$EnumSwitchMapping$0[t4VarW2.ordinal()]) {
                        case 1:
                            ConcurrentHashMap.KeySetView mBleCachedDevices2 = t1Var2.f9992h;
                            Intrinsics.checkNotNullExpressionValue(mBleCachedDevices2, "mBleCachedDevices");
                            synchronized (mBleCachedDevices2) {
                                Iterator it2 = t1Var2.f9992h.iterator();
                                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                                while (it2.hasNext()) {
                                    NearDevice nearDevice2 = (NearDevice) it2.next();
                                    Intrinsics.checkNotNull(nearDevice2);
                                    if (t1Var2.m(nearDevice2, device)) {
                                        return true;
                                    }
                                }
                                Unit unit5 = Unit.INSTANCE;
                                Unit unit6 = Unit.INSTANCE;
                                str = device.f3884b;
                                if (str != null || str.length() == 0 || ((str2 = device.f3884b) != null && Intrinsics.areEqual(str2, device.f3883a) && device.e != 15)) {
                                    we.h.j("SmartConnectWrapper", "Device name is empty, we will cascade it later");
                                    return true;
                                }
                            }
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                            we.h.j("NearDeviceTableFusion", "Unsupported device type " + t4VarW2.name());
                            Unit unit7 = Unit.INSTANCE;
                            str = device.f3884b;
                            if (str != null) {
                                break;
                            }
                            we.h.j("SmartConnectWrapper", "Device name is empty, we will cascade it later");
                            return true;
                        case 12:
                            we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW2.name());
                            Unit unit8 = Unit.INSTANCE;
                            str = device.f3884b;
                            if (str != null) {
                                break;
                            }
                            we.h.j("SmartConnectWrapper", "Device name is empty, we will cascade it later");
                            return true;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0093  */
    /* JADX WARN: Code duplicated, block: B:32:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:59:0x0103  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object q(boolean z2, ContinuationImpl continuationImpl) throws Throwable {
        x xVar;
        if (continuationImpl instanceof x) {
            xVar = (x) continuationImpl;
            int i8 = xVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                xVar.label = i8 - Integer.MIN_VALUE;
            } else {
                xVar = new x(this, continuationImpl);
            }
        } else {
            xVar = new x(this, continuationImpl);
        }
        Object objU = xVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = xVar.label;
        if (i9 != 0) {
            if (i9 == 1) {
                this = (y) xVar.L$0;
                ResultKt.throwOnFailure(objU);
                this.f4198l = null;
                if (!Intrinsics.areEqual((Boolean) objU, Boxing.boxBoolean(true))) {
                    return Boxing.boxInt(100);
                }
                we.h.b("SmartConnectWrapper", "Smart Connect Enable Block Timeout");
                return Boxing.boxInt(-2);
            }
            if (i9 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (y) xVar.L$0;
            ResultKt.throwOnFailure(objU);
            this.f4198l = null;
            if (!Intrinsics.areEqual((Boolean) objU, Boxing.boxBoolean(true))) {
                return Boxing.boxInt(200);
            }
            we.h.b("SmartConnectWrapper", "Smart Connect Enable Block Timeout");
            return Boxing.boxInt(-3);
        }
        ResultKt.throwOnFailure(objU);
        c0 c0Var = this.f4191c;
        if (z2) {
            Integer numBoxInt = c0Var != null ? Boxing.boxInt(c0Var.d()) : null;
            if (numBoxInt == null || numBoxInt.intValue() != 0) {
                return numBoxInt;
            }
            we.h.b("SmartConnectWrapper", "Smart Connect is not enabled, enable it");
            T();
            this.f4198l = new CountDownLatch(1);
            li.v0 v0Var = li.v0.f7498a;
            si.e eVar = si.e.f10118a;
            v4 v4Var = new v4(this, null);
            xVar.L$0 = this;
            xVar.label = 1;
            objU = li.l0.u(eVar, v4Var, xVar);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.f4198l = null;
            if (!Intrinsics.areEqual((Boolean) objU, Boxing.boxBoolean(true))) {
                return Boxing.boxInt(100);
            }
            we.h.b("SmartConnectWrapper", "Smart Connect Enable Block Timeout");
            return Boxing.boxInt(-2);
        }
        Integer numBoxInt2 = c0Var != null ? Boxing.boxInt(c0Var.d()) : null;
        if ((numBoxInt2 == null || numBoxInt2.intValue() != 1) && ((numBoxInt2 == null || numBoxInt2.intValue() != 2) && (numBoxInt2 == null || numBoxInt2.intValue() != 3))) {
            return numBoxInt2;
        }
        S();
        this.f4198l = new CountDownLatch(1);
        li.v0 v0Var2 = li.v0.f7498a;
        si.e eVar2 = si.e.f10118a;
        w4 w4Var = new w4(this, null);
        xVar.L$0 = this;
        xVar.label = 2;
        objU = li.l0.u(eVar2, w4Var, xVar);
        if (objU == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.f4198l = null;
        if (!Intrinsics.areEqual((Boolean) objU, Boxing.boxBoolean(true))) {
            return Boxing.boxInt(200);
        }
        we.h.b("SmartConnectWrapper", "Smart Connect Enable Block Timeout");
        return Boxing.boxInt(-3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.lang.Object] */
    public final NearDevice r(BluetoothDevice bluetoothDevice, Integer num, Integer num2, Integer num3, Integer num4) {
        T t3;
        T t8;
        NearDevice nearDevice;
        T next;
        NearDevice nearDevice2;
        BluetoothDevice bluetoothDevice2;
        ConcurrentHashMap.KeySetView mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        synchronized (mNearDevices) {
            try {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ConcurrentHashMap.KeySetView mNearDevices2 = this.f4196j;
                Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                Iterator it = mNearDevices2.iterator();
                while (true) {
                    t3 = 0;
                    if (!it.hasNext()) {
                        t8 = 0;
                        break;
                    }
                    Object next2 = it.next();
                    NearDevice nearDevice3 = (NearDevice) next2;
                    if (num2 == null || nearDevice3.f3899w != num2.intValue()) {
                        if ((num == null || nearDevice3.f3899w == num.intValue()) && ((num3 == null || Intrinsics.areEqual(nearDevice3.f3898v, num3)) && (num4 == null || !Intrinsics.areEqual(nearDevice3.f3898v, num4)))) {
                        }
                    }
                    String address = bluetoothDevice.getAddress();
                    WirelessDevice wirelessDevice = nearDevice3.f3896s;
                    WirelessDevice.Bluetooth bluetooth = wirelessDevice instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice : null;
                    if (Intrinsics.areEqual(address, (bluetooth == null || (bluetoothDevice2 = bluetooth.f4011d) == null) ? null : bluetoothDevice2.getAddress())) {
                        t8 = next2;
                        break;
                    }
                }
                objectRef.element = t8;
                if (t8 == 0) {
                    ConcurrentHashMap.KeySetView mNearDevices3 = this.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices3, "mNearDevices");
                    Iterator it2 = mNearDevices3.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = 0;
                            break;
                        }
                        next = it2.next();
                        nearDevice2 = (NearDevice) next;
                        if (Intrinsics.areEqual(bluetoothDevice.getAddress(), nearDevice2.f3883a)) {
                            break;
                        }
                    } while (!Intrinsics.areEqual(bluetoothDevice.getAddress(), nearDevice2.f3885c));
                    objectRef.element = next;
                }
                ConcurrentHashMap.KeySetView mOptionalDevices = this.f4197k;
                Intrinsics.checkNotNullExpressionValue(mOptionalDevices, "mOptionalDevices");
                synchronized (mOptionalDevices) {
                    try {
                        if (objectRef.element == 0) {
                            ConcurrentHashMap.KeySetView mOptionalDevices2 = this.f4197k;
                            Intrinsics.checkNotNullExpressionValue(mOptionalDevices2, "mOptionalDevices");
                            if (!mOptionalDevices2.isEmpty()) {
                                ConcurrentHashMap.KeySetView mOptionalDevices3 = this.f4197k;
                                Intrinsics.checkNotNullExpressionValue(mOptionalDevices3, "mOptionalDevices");
                                for (Object obj : mOptionalDevices3) {
                                    NearDevice nearDevice4 = (NearDevice) obj;
                                    if (!Intrinsics.areEqual(bluetoothDevice.getAddress(), nearDevice4.f3883a) && !Intrinsics.areEqual(bluetoothDevice.getAddress(), nearDevice4.f3885c)) {
                                    }
                                    t3 = obj;
                                }
                                objectRef.element = t3;
                            }
                        }
                        nearDevice = (NearDevice) objectRef.element;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return nearDevice;
    }

    public final void t(TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        NearDeviceDataParcel nearDeviceDataParcel;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        if (((tranConnectionController$EventInfo == null || (nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h) == null) ? null : (Parcelable) nearDeviceDataParcel.f3903a) instanceof NearDevice) {
            Object obj = tranConnectionController$EventInfo.f3968h.f3903a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
            NearDevice device = (NearDevice) obj;
            NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
            Parcelable parcelable = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
            if (parcelable instanceof BluetoothDevice) {
                Object obj2 = nearDeviceDataParcel2.f3903a;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                Q((BluetoothDevice) obj2);
            } else if (parcelable instanceof WirelessDevice.P2p) {
                Object obj3 = nearDeviceDataParcel2.f3903a;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
                o.d.z("P2p device flush, ssid or name = ", ((WirelessDevice.P2p) obj3).f4013a, "SmartConnectWrapper");
            } else if (parcelable instanceof WirelessDevice.Wlan) {
                Object obj4 = nearDeviceDataParcel2.f3903a;
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Wlan");
            }
            t1 t1Var = this.f4195i;
            t1Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            t1Var.f(new o1(t1Var, device, 1));
            ConcurrentHashMap.KeySetView keySetView = this.f4197k;
            if (keySetView.contains(device)) {
                keySetView.remove(device);
            }
        }
    }

    public final NearDevice u() {
        ConcurrentHashMap.KeySetView<NearDevice> mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        NearDevice nearDevice = null;
        for (NearDevice nearDevice2 : mNearDevices) {
            Integer num = nearDevice2.f3898v;
            if (num != null && num.intValue() == 1003) {
                nearDevice = nearDevice2;
            }
        }
        return nearDevice;
    }

    public final NearDevice v(DeviceInfo deviceInfo) {
        String str;
        NearDevice nearDevice = null;
        if (deviceInfo == null) {
            return null;
        }
        ConcurrentHashMap.KeySetView<NearDevice> mNearDevices = this.f4196j;
        Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
        for (NearDevice nearDevice2 : mNearDevices) {
            String str2 = nearDevice2.f3883a;
            String str3 = deviceInfo.f4223d;
            if ((str2 != null && Intrinsics.areEqual(str2, str3)) || ((str = nearDevice2.f3885c) != null && Intrinsics.areEqual(str, str3))) {
                nearDevice = nearDevice2;
            }
        }
        return nearDevice;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean y(NearDevice device, boolean z2) {
        String str;
        t1 t1Var = this.f4195i;
        t1Var.getClass();
        Intrinsics.checkNotNullParameter(device, "device");
        synchronized (t1Var.f9990d) {
            try {
                t4 t4VarW = t1.w(device);
                Object obj = null;
                nearDevice = null;
                Object obj2 = null;
                NearDevice nearDevice = null;
                Object obj3 = null;
                switch (s1.$EnumSwitchMapping$0[t4VarW.ordinal()]) {
                    case 1:
                        ConcurrentHashMap.KeySetView mBleCachedDevices = t1Var.f9992h;
                        Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                        for (Object obj4 : mBleCachedDevices) {
                            NearDevice nearDevice2 = (NearDevice) obj4;
                            Intrinsics.checkNotNull(nearDevice2);
                            if (!Intrinsics.areEqual(nearDevice2.f3883a, device.f3883a) && Intrinsics.areEqual(nearDevice2.f3885c, device.f3885c) && nearDevice2.e == device.e) {
                                NearDeviceExtension nearDeviceExtension = nearDevice2.u;
                                int i8 = nearDeviceExtension != null ? nearDeviceExtension.f3908d : 0;
                                NearDeviceExtension nearDeviceExtension2 = device.u;
                                if (i8 == (nearDeviceExtension2 != null ? nearDeviceExtension2.f3908d : 0) && nearDeviceExtension != null && !nearDeviceExtension.e && nearDeviceExtension2 != null && !nearDeviceExtension2.e) {
                                    obj = obj4;
                                    nearDevice = (NearDevice) obj;
                                    break;
                                }
                            }
                        }
                        nearDevice = (NearDevice) obj;
                        break;
                    case 2:
                        ConcurrentHashMap.KeySetView mNsdCachedDevices = t1Var.f9994j;
                        Intrinsics.checkNotNullExpressionValue(mNsdCachedDevices, "mNsdCachedDevices");
                        for (Object obj5 : mNsdCachedDevices) {
                            NearDevice nearDevice3 = (NearDevice) obj5;
                            Intrinsics.checkNotNull(nearDevice3);
                            NearDeviceExtension nearDeviceExtension3 = nearDevice3.u;
                            LanNetworkInfo lanNetworkInfo = nearDeviceExtension3 != null ? nearDeviceExtension3.f3909h : null;
                            NearDeviceExtension nearDeviceExtension4 = device.u;
                            LanNetworkInfo lanNetworkInfo2 = nearDeviceExtension4 != null ? nearDeviceExtension4.f3909h : null;
                            String str2 = nearDevice3.f3883a;
                            if (str2 != null && (str = device.f3883a) != null && Intrinsics.areEqual(str2, str) && Intrinsics.areEqual(nearDevice3.f3885c, device.f3885c) && nearDevice3.e == device.e && lanNetworkInfo != null && lanNetworkInfo2 != null && !Intrinsics.areEqual(lanNetworkInfo, lanNetworkInfo2)) {
                                obj3 = obj5;
                                nearDevice = (NearDevice) obj3;
                                break;
                            }
                        }
                        nearDevice = (NearDevice) obj3;
                        break;
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        we.h.j("NearDeviceTableFusion", "Unsupported device type " + t4VarW.name());
                        break;
                    case 5:
                        ConcurrentHashMap.KeySetView mBtCachedDevices = t1Var.f9993i;
                        Intrinsics.checkNotNullExpressionValue(mBtCachedDevices, "mBtCachedDevices");
                        for (Object obj6 : mBtCachedDevices) {
                            NearDevice nearDevice4 = (NearDevice) obj6;
                            Intrinsics.checkNotNull(nearDevice4);
                            if (!Intrinsics.areEqual(nearDevice4.f3883a, device.f3883a)) {
                                obj2 = obj6;
                                nearDevice = (NearDevice) obj2;
                                break;
                            }
                        }
                        nearDevice = (NearDevice) obj2;
                        break;
                    case 12:
                        we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                if (nearDevice == null) {
                    Unit unit = Unit.INSTANCE;
                    return false;
                }
                if (z2) {
                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                    we.m.b(Integer.valueOf(nearDevice.hashCode()));
                    t1Var.H(nearDevice, t4VarW, false, true);
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean z() {
        c0 c0Var = this.f4191c;
        Integer numValueOf = c0Var != null ? Integer.valueOf(c0Var.d()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return true;
        }
        we.h.b("SmartConnectWrapper", "Smart Config is not enabled, state = " + numValueOf);
        return false;
    }
}
