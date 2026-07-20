package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import k3.lb;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import se.g5;
import se.i1;
import se.k1;
import se.l1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/welink/protocol/nfbd/NearDevice;", "Landroid/os/Parcelable;", "CREATOR", "se/j1", "se/l1", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nNearDevice.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NearDevice.kt\ncom/welink/protocol/nfbd/NearDevice\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ParcelExtend.kt\ncom/welink/protocol/utils/ParcelExtendKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2273:1\n1#2:2274\n9#3,4:2275\n9#3,4:2279\n9#3,4:2283\n9#3,4:2287\n1863#4,2:2291\n*S KotlinDebug\n*F\n+ 1 NearDevice.kt\ncom/welink/protocol/nfbd/NearDevice\n*L\n133#1:2275,4\n136#1:2279,4\n139#1:2283,4\n145#1:2287,4\n508#1:2291,2\n*E\n"})
public final class NearDevice implements Parcelable {
    public static final l1 CREATOR = new l1();
    public final List A;
    public int B;
    public byte C;
    public final int D;
    public int E;
    public final int F;
    public final String G;
    public final String H;
    public se.f I = new se.g(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f3886d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f3888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f3889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final UInt f3891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3894o;
    public int p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Boolean f3895r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WirelessDevice f3896s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f3897t;
    public final NearDeviceExtension u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f3898v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3899w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3900x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3901y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3902z;

    public NearDevice(String str, String str2, String str3, Integer num, String str4, int i8, int i9, int i10, int i11, UInt uInt, String str5, String str6, int i12, int i13, Integer num2, int i14, int i15, int i16, Boolean bool, long j8, int i17, List list, WirelessDevice wirelessDevice, List list2, NearDeviceExtension nearDeviceExtension, byte b9, int i18, int i19, int i20, String str7, String str8) {
        this.f3883a = str;
        this.f3884b = str2;
        this.f3885c = str3;
        this.f3886d = num;
        this.e = i9;
        this.f3887h = i10;
        this.f3888i = j8;
        this.f3889j = i8;
        this.f3890k = i11;
        this.f3891l = uInt;
        this.f3892m = str4;
        this.f3893n = str5;
        this.f3894o = str6;
        this.p = i12;
        this.q = i13;
        this.f3895r = bool;
        this.f3896s = wirelessDevice;
        this.f3897t = list2;
        this.u = nearDeviceExtension;
        this.f3898v = num2;
        this.f3899w = i14;
        this.f3900x = i15;
        this.f3901y = i16;
        this.f3902z = i17;
        this.A = list;
        this.C = b9;
        this.D = i18;
        this.E = i19;
        this.F = i20;
        this.G = str7;
        this.H = str8;
    }

    public static /* synthetic */ NearDevice n(NearDevice nearDevice, BluetoothDevice bluetoothDevice, Integer num, int i8) {
        if ((i8 & 4) != 0) {
            num = null;
        }
        return nearDevice.m(bluetoothDevice, null, num, null);
    }

    public final void A(int i8) {
        this.f3898v = Integer.valueOf(i8);
    }

    public final void B(z manager, g5 g5Var, Function1 function1) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.I.i(this, manager, g5Var, function1);
    }

    public final void C(z manager, Function1 function1) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.I.e(this, manager, function1);
    }

    public final String D() {
        String str;
        String str2 = this.f3884b;
        Integer num = this.f3886d;
        String strU = u();
        String strX = x();
        String strV = v(null);
        String strI = i(null);
        switch (this.f3900x) {
            case PointerIconCompat.TYPE_COPY /* 1011 */:
                str = "P2P Connecting";
                break;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                str = "P2P Connected";
                break;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                str = "P2P Disconnecting";
                break;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                str = "P2P Disconnected";
                break;
            default:
                str = "Unknown";
                break;
        }
        StringBuilder sb2 = new StringBuilder("NearDevice Info(\n            mAddress=");
        o.d.A(sb2, this.f3883a, ",\n            mName=", str2, ",\n            mDeviceId=");
        sb2.append(this.f3885c);
        sb2.append(",\n            mRssi=");
        sb2.append(num);
        sb2.append(",\n            mBrand=");
        sb2.append(this.f3892m);
        sb2.append(",\n            mDeviceType=");
        sb2.append(this.f3889j);
        sb2.append(",\n            mServiceType=");
        sb2.append(strU);
        sb2.append(",\n            mWirelessType=");
        o.d.A(sb2, strX, ",\n            mState=", strV, ",\n            mBtState=");
        sb2.append(strI);
        sb2.append(",\n            mP2pState=");
        sb2.append(str);
        sb2.append(",\n            ");
        return StringsKt.trimIndent(sb2.toString());
    }

    public final void E(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        int i8 = device.f3890k;
        if (this.f3890k != i8 || this == device) {
            return;
        }
        NearDeviceExtension nearDeviceExtension = this.u;
        NearDeviceExtension nearDeviceExtension2 = device.u;
        if (i8 == 0 || i8 == 1) {
            Integer num = device.f3886d;
            int iIntValue = num != null ? num.intValue() : 0;
            if (iIntValue != 0) {
                this.f3886d = Integer.valueOf(iIntValue);
            } else {
                we.h.j("NearDevice", "Update BT Device Info, ignore rssi: " + device.f3886d);
            }
            this.C = device.C;
        } else if (i8 == 14) {
            if (device.f3896s instanceof WirelessDevice.Wlan) {
                LanNetworkInfo lanNetworkInfo = nearDeviceExtension2 != null ? nearDeviceExtension2.f3909h : null;
                LanNetworkInfo lanNetworkInfo2 = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
                if (lanNetworkInfo != null && lanNetworkInfo2 != null && !Intrinsics.areEqual(lanNetworkInfo2, lanNetworkInfo)) {
                    if (nearDeviceExtension != null) {
                        Intrinsics.checkNotNullParameter(lanNetworkInfo, "lanNetworkInfo");
                        nearDeviceExtension.f3909h = lanNetworkInfo;
                    }
                    we.h.h("NearDevice", "Update LAN Network Info, new: " + lanNetworkInfo + ", old: " + lanNetworkInfo2);
                }
            } else {
                we.h.j("NearDevice", "Update LAN Network Info, device is not Wlan");
            }
        }
        WearableDeviceInfo wearableDeviceInfo = nearDeviceExtension2 != null ? nearDeviceExtension2.f3911j : null;
        if (wearableDeviceInfo == null || nearDeviceExtension == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(wearableDeviceInfo, "wearableDeviceInfo");
        nearDeviceExtension.f3911j = wearableDeviceInfo;
    }

    public final void b(NearDevice nearDevice) {
        Set set;
        List list;
        Intrinsics.checkNotNullParameter(nearDevice, "device");
        NearDeviceExtension nearDeviceExtension = this.u;
        if ((nearDeviceExtension == null || (set = nearDeviceExtension.f3910i) == null || (list = CollectionsKt.toList(set)) == null || !list.contains(nearDevice)) && nearDeviceExtension != null) {
            Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
            if (nearDeviceExtension.f3910i == null) {
                nearDeviceExtension.f3910i = new LinkedHashSet();
            }
            Set set2 = nearDeviceExtension.f3910i;
            if (set2 != null) {
                set2.add(nearDevice);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:196:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:198:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:305:0x047e  */
    /* JADX WARN: Code duplicated, block: B:306:0x0483  */
    /* JADX WARN: Code duplicated, block: B:309:0x0488  */
    /* JADX WARN: Code duplicated, block: B:311:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:313:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:314:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:316:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:348:0x0541 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:349:0x0543  */
    /* JADX WARN: Code duplicated, block: B:385:0x05e8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:386:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:417:0x065b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:418:0x065d  */
    /* JADX WARN: Code duplicated, block: B:447:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:457:0x06cb  */
    /* JADX WARN: Code duplicated, block: B:459:0x06d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:460:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:542:0x0807 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:543:0x0809  */
    /* JADX WARN: Code duplicated, block: B:566:0x0859  */
    /* JADX WARN: Code duplicated, block: B:576:0x0877  */
    /* JADX WARN: Code duplicated, block: B:578:0x0881 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:579:0x0883  */
    /* JADX WARN: Code duplicated, block: B:583:0x0896  */
    /* JADX WARN: Code duplicated, block: B:585:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:309:0x0488, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:313:0x04a9, please report this as an issue */
    public final void d(TranConnectionController$MessageInfo tranConnectionController$MessageInfo, Function1 function1, a8.a aVar) {
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo2;
        Object mes;
        String str;
        WifiP2pGroup wifiP2pGroup;
        NearDeviceDataParcel nearDeviceDataParcel;
        Parcelable parcelable;
        Function1 function2;
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo3;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        String str2 = this.f3883a;
        TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
        Integer numValueOf = tranConnectionController$EventInfo != null ? Integer.valueOf(tranConnectionController$EventInfo.f3965b) : null;
        if ((numValueOf == null || numValueOf.intValue() != 1) && (numValueOf == null || numValueOf.intValue() != 2)) {
            NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$MessageInfo.f3975j;
            if (numValueOf == null || numValueOf.intValue() != 18) {
                int i12 = this.f3890k;
                if (numValueOf != null && numValueOf.intValue() == 19) {
                    NearDeviceDataParcel nearDeviceDataParcel3 = tranConnectionController$EventInfo.f3968h;
                    if ((nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null) instanceof NearDevice) {
                        Object obj = nearDeviceDataParcel3.f3903a;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                        NearDevice nearDevice = (NearDevice) obj;
                        Parcelable parcelable2 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                        boolean z3 = (parcelable2 == null || !(parcelable2 instanceof BluetoothDevice) || n(this, (BluetoothDevice) parcelable2, Integer.valueOf(PointerIconCompat.TYPE_ALIAS), 8) == null) ? false : true;
                        if (Intrinsics.areEqual(nearDevice, this) || z3) {
                            h0.a.D("Disconnected LE device ", nearDevice.f3883a, "NearDevice");
                            if (nearDevice.e == 0) {
                                switch (tranConnectionController$EventInfo.f3966c) {
                                    case -3:
                                    case -2:
                                    case -1:
                                    case 0:
                                    case 6:
                                    case 18:
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit3 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 1:
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit4 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit5 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit6 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 2:
                                    case 5:
                                    case 7:
                                    case 8:
                                    default:
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit7 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 3:
                                        we.h.j("NearDevice", "P2p Disconnect Callback, Passive Mode");
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit9 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 4:
                                        if (i12 == 10 || i12 == 11) {
                                            we.h.j("NearDevice", "QR P2p Available");
                                            Unit unit10 = Unit.INSTANCE;
                                        } else if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit11 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 9:
                                        if (i12 == 10 || i12 == 11) {
                                            we.h.j("NearDevice", "QR P2p Bypass BT OFF Event");
                                            Unit unit12 = Unit.INSTANCE;
                                        } else {
                                            if (aVar != null) {
                                                aVar.g(false);
                                                Unit unit13 = Unit.INSTANCE;
                                            }
                                            if (aVar != null) {
                                                aVar.j(false);
                                                Unit unit14 = Unit.INSTANCE;
                                            }
                                            if (aVar != null) {
                                                aVar.l(false);
                                                Unit unit15 = Unit.INSTANCE;
                                            }
                                        }
                                        break;
                                    case 10:
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit16 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit17 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit18 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 11:
                                    case 19:
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit19 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 12:
                                        we.h.j("NearDevice", "Notify: P2p is Connecting, got BT OFF event");
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit20 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 13:
                                    case 14:
                                    case 16:
                                    case 17:
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit21 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit22 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 15:
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit23 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit24 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit25 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 20:
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit26 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 21:
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit27 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 22:
                                        we.h.j("NearDevice", "Reset and disconnect P2P Device Succeed");
                                        if (aVar != null) {
                                            aVar.l(false);
                                            Unit unit28 = Unit.INSTANCE;
                                        }
                                        if (aVar != null) {
                                            aVar.j(false);
                                            Unit unit29 = Unit.INSTANCE;
                                        }
                                        break;
                                    case 23:
                                        we.h.j("NearDevice", "Reset and disconnect P2P Device Busy, No p2p Group");
                                        Unit unit30 = Unit.INSTANCE;
                                        break;
                                    case 24:
                                        if (aVar != null) {
                                            aVar.g(false);
                                            Unit unit31 = Unit.INSTANCE;
                                        }
                                        break;
                                }
                            } else if (aVar != null) {
                                aVar.g(false);
                                Unit unit32 = Unit.INSTANCE;
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("NearDevice", "tag");
                            Intrinsics.checkNotNullParameter("Disconnected, device is not match, nearDevice checking bluetooth device", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearDevice", "TransConnect:Disconnected, device is not match, nearDevice checking bluetooth device", null);
                            }
                            Unit unit33 = Unit.INSTANCE;
                        }
                    } else {
                        Parcelable parcelable3 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                        if (parcelable3 == null || !(parcelable3 instanceof BluetoothDevice)) {
                            Intrinsics.checkNotNullParameter("NearDevice", "tag");
                            Intrinsics.checkNotNullParameter("Disconnected, device is not match, bluetooth checking", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearDevice", "TransConnect:Disconnected, device is not match, bluetooth checking", null);
                            }
                            Unit unit34 = Unit.INSTANCE;
                        } else {
                            BluetoothDevice bluetoothDevice = (BluetoothDevice) parcelable3;
                            if (n(this, bluetoothDevice, Integer.valueOf(PointerIconCompat.TYPE_ALIAS), 8) != null) {
                                Intrinsics.checkNotNull(parcelable3, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                                h0.a.D("Disconnected LE device ", bluetoothDevice.getAddress(), "NearDevice");
                                if (aVar != null) {
                                    aVar.g(false);
                                    Unit unit35 = Unit.INSTANCE;
                                }
                            } else {
                                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                Intrinsics.checkNotNullParameter("Disconnected, device is not match, bluetooth checking", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearDevice", "TransConnect:Disconnected, device is not match, bluetooth checking", null);
                                }
                                Unit unit36 = Unit.INSTANCE;
                            }
                        }
                    }
                } else {
                    String str3 = this.f3885c;
                    TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$MessageInfo.f3974i;
                    if ((numValueOf != null && numValueOf.intValue() == 20) || (numValueOf != null && numValueOf.intValue() == 24)) {
                        Parcelable parcelable4 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                        if (parcelable4 instanceof BluetoothDevice) {
                            Object obj2 = nearDeviceDataParcel2.f3903a;
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) obj2;
                            if (!Intrinsics.areEqual(str2, bluetoothDevice2.getAddress()) && !Intrinsics.areEqual(str3, bluetoothDevice2.getAddress())) {
                                WirelessDevice wirelessDevice = this.f3896s;
                                WirelessDevice.Bluetooth bluetooth = wirelessDevice instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice : null;
                                if (bluetooth != null) {
                                    BluetoothDevice bluetoothDevice3 = bluetooth.f4011d;
                                    boolean zAreEqual = Intrinsics.areEqual(bluetoothDevice3 != null ? bluetoothDevice3.getAddress() : null, bluetoothDevice2.getAddress());
                                    i11 = 1;
                                    if (zAreEqual) {
                                        if (aVar != null) {
                                            aVar.h();
                                            Unit unit37 = Unit.INSTANCE;
                                        }
                                    }
                                } else {
                                    i11 = 1;
                                }
                                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                Intrinsics.checkNotNullParameter("Device is not match", "mes");
                                if (lb.f6529c >= i11) {
                                    Log.e("NearDevice", "TransConnect:Device is not match", null);
                                }
                                Unit unit38 = Unit.INSTANCE;
                            } else if (aVar != null) {
                                aVar.h();
                                Unit unit39 = Unit.INSTANCE;
                            }
                        } else if (parcelable4 instanceof WifiP2pDevice) {
                            Object obj3 = nearDeviceDataParcel2.f3903a;
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                            WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) obj3;
                            NearDeviceDataParcel nearDeviceDataParcel4 = tranConnectionController$EventInfo2.f3968h;
                            Parcelable parcelable5 = nearDeviceDataParcel4 != null ? nearDeviceDataParcel4.f3904b : null;
                            NearDevice nearDevice2 = parcelable5 instanceof NearDevice ? (NearDevice) parcelable5 : null;
                            tranConnectionController$MessageInfo3 = tranConnectionController$MessageInfo;
                            if (!Intrinsics.areEqual(this.f3884b, tranConnectionController$MessageInfo3.f3972d) && !Intrinsics.areEqual(this.f3884b, wifiP2pDevice.deviceName)) {
                                WirelessDevice wirelessDevice2 = this.f3896s;
                                WirelessDevice.P2p p2p = wirelessDevice2 instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice2 : null;
                                if (p2p == null) {
                                    if (nearDevice2 != null) {
                                    }
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match, p2p available", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearDevice", "TransConnect:Device is not match, p2p available", null);
                                    }
                                    Unit unit40 = Unit.INSTANCE;
                                } else if (Intrinsics.areEqual(p2p.f4014b, wifiP2pDevice.deviceAddress)) {
                                    if (aVar != null) {
                                        aVar.h();
                                        Unit unit41 = Unit.INSTANCE;
                                    }
                                } else if (nearDevice2 != null || (!Intrinsics.areEqual(this, nearDevice2) && i12 != 10 && i12 != 11)) {
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match, p2p available", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearDevice", "TransConnect:Device is not match, p2p available", null);
                                    }
                                    Unit unit42 = Unit.INSTANCE;
                                } else if (aVar != null) {
                                    aVar.h();
                                    Unit unit43 = Unit.INSTANCE;
                                }
                            } else if (aVar != null) {
                                aVar.h();
                                Unit unit44 = Unit.INSTANCE;
                            }
                        }
                    } else if (numValueOf != null && numValueOf.intValue() == 21) {
                        Parcelable parcelable6 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                        if (parcelable6 instanceof BluetoothDevice) {
                            Object obj4 = nearDeviceDataParcel2.f3903a;
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                            BluetoothDevice bluetoothDevice4 = (BluetoothDevice) obj4;
                            if (Intrinsics.areEqual(str2, bluetoothDevice4.getAddress()) || Intrinsics.areEqual(str3, bluetoothDevice4.getAddress())) {
                                z2 = true;
                            } else {
                                WirelessDevice wirelessDevice3 = this.f3896s;
                                WirelessDevice.Bluetooth bluetooth2 = wirelessDevice3 instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice3 : null;
                                if (bluetooth2 != null) {
                                    BluetoothDevice bluetoothDevice5 = bluetooth2.f4011d;
                                    boolean zAreEqual2 = Intrinsics.areEqual(bluetoothDevice5 != null ? bluetoothDevice5.getAddress() : null, bluetoothDevice4.getAddress());
                                    i8 = 1;
                                    z2 = true;
                                    if (zAreEqual2) {
                                    }
                                    tranConnectionController$MessageInfo2 = tranConnectionController$MessageInfo;
                                } else {
                                    i8 = 1;
                                }
                                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                Intrinsics.checkNotNullParameter("Device is not match", "mes");
                                if (lb.f6529c >= i8) {
                                    Log.e("NearDevice", "TransConnect:Device is not match", null);
                                }
                                Unit unit45 = Unit.INSTANCE;
                                tranConnectionController$MessageInfo2 = tranConnectionController$MessageInfo;
                            }
                            if (aVar != null) {
                                aVar.j(z2);
                                Unit unit46 = Unit.INSTANCE;
                            }
                            if (aVar != null) {
                                aVar.l(z2);
                                Unit unit47 = Unit.INSTANCE;
                            }
                            tranConnectionController$MessageInfo2 = tranConnectionController$MessageInfo;
                        } else {
                            if (parcelable6 instanceof WifiP2pDevice) {
                                Object obj5 = nearDeviceDataParcel2.f3903a;
                                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                                WifiP2pDevice wifiP2pDevice2 = (WifiP2pDevice) obj5;
                                NearDeviceDataParcel nearDeviceDataParcel5 = tranConnectionController$EventInfo2.f3968h;
                                Parcelable parcelable7 = nearDeviceDataParcel5 != null ? nearDeviceDataParcel5.f3904b : null;
                                NearDevice nearDevice3 = parcelable7 instanceof NearDevice ? (NearDevice) parcelable7 : null;
                                Parcelable parcelable8 = nearDeviceDataParcel5 != null ? (Parcelable) nearDeviceDataParcel5.f3903a : null;
                                if (parcelable8 instanceof TranConnectionController$P2pDeviceInfo) {
                                    Object obj6 = nearDeviceDataParcel5.f3903a;
                                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
                                    wifiP2pGroup = ((TranConnectionController$P2pDeviceInfo) obj6).f3983k;
                                    o.d.z("Local P2p Device Connect to P2p Group: ", wifiP2pGroup != null ? wifiP2pGroup.getNetworkName() : null, "NearDevice");
                                } else {
                                    if (parcelable8 instanceof WifiP2pDevice) {
                                        we.h.b("NearDevice", "Remote P2p Device Connect to Local Group: " + wifiP2pDevice2);
                                    } else {
                                        we.h.j("NearDevice", "P2p Device is null, ignore");
                                    }
                                    wifiP2pGroup = null;
                                }
                                tranConnectionController$MessageInfo2 = tranConnectionController$MessageInfo;
                                if (Intrinsics.areEqual(this.f3884b, tranConnectionController$MessageInfo2.f3972d) || Intrinsics.areEqual(this.f3884b, wifiP2pDevice2.deviceName) || ((wifiP2pGroup != null && Intrinsics.areEqual(this.f3884b, wifiP2pGroup.getNetworkName())) || (nearDevice3 != null && (Intrinsics.areEqual(this, nearDevice3) || i12 == 10 || i12 == 11)))) {
                                    if (aVar != null) {
                                        aVar.j(true);
                                        Unit unit48 = Unit.INSTANCE;
                                    }
                                    if (aVar != null) {
                                        aVar.l(true);
                                        Unit unit49 = Unit.INSTANCE;
                                    }
                                } else {
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match, p2p connect", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearDevice", "TransConnect:Device is not match, p2p connect", null);
                                    }
                                    Unit unit50 = Unit.INSTANCE;
                                }
                            } else {
                                tranConnectionController$MessageInfo2 = tranConnectionController$MessageInfo;
                                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                mes = "P2p Device Info is not complete";
                                Intrinsics.checkNotNullParameter(mes, "mes");
                                if (lb.f6529c >= 1) {
                                    str = "TransConnect:P2p Device Info is not complete";
                                    Log.e("NearDevice", str, null);
                                } else {
                                    str = "TransConnect:P2p Device Info is not complete";
                                }
                                Unit unit51 = Unit.INSTANCE;
                            }
                            nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h;
                            if (nearDeviceDataParcel != null) {
                                parcelable = (Parcelable) nearDeviceDataParcel.f3903a;
                            } else {
                                parcelable = null;
                            }
                            if (parcelable instanceof WifiP2pDevice) {
                                Object obj7 = nearDeviceDataParcel.f3903a;
                                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                                we.h.b("NearDevice", "P2p Owner mode: " + ((WifiP2pDevice) obj7));
                            } else if (parcelable instanceof TranConnectionController$P2pDeviceInfo) {
                                Object obj8 = nearDeviceDataParcel.f3903a;
                                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
                                we.h.b("NearDevice", "P2p Client mode: " + ((TranConnectionController$P2pDeviceInfo) obj8).f3982j);
                            } else {
                                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                Intrinsics.checkNotNullParameter(mes, "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearDevice", str, null);
                                }
                            }
                            function2 = function1;
                            tranConnectionController$MessageInfo3 = tranConnectionController$MessageInfo2;
                        }
                        str = "TransConnect:P2p Device Info is not complete";
                        mes = "P2p Device Info is not complete";
                        nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h;
                        if (nearDeviceDataParcel != null) {
                            parcelable = (Parcelable) nearDeviceDataParcel.f3903a;
                        } else {
                            parcelable = null;
                        }
                        if (parcelable instanceof WifiP2pDevice) {
                            Object obj9 = nearDeviceDataParcel.f3903a;
                            Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                            we.h.b("NearDevice", "P2p Owner mode: " + ((WifiP2pDevice) obj9));
                        } else if (parcelable instanceof TranConnectionController$P2pDeviceInfo) {
                            Object obj10 = nearDeviceDataParcel.f3903a;
                            Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.welink.protocol.nfbd.TranConnectionController.P2pDeviceInfo");
                            we.h.b("NearDevice", "P2p Client mode: " + ((TranConnectionController$P2pDeviceInfo) obj10).f3982j);
                        } else {
                            Intrinsics.checkNotNullParameter("NearDevice", "tag");
                            Intrinsics.checkNotNullParameter(mes, "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("NearDevice", str, null);
                            }
                        }
                        function2 = function1;
                        tranConnectionController$MessageInfo3 = tranConnectionController$MessageInfo2;
                    } else {
                        DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
                        if (numValueOf != null && numValueOf.intValue() == 22) {
                            if ((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice) {
                                Object obj11 = nearDeviceDataParcel2.f3903a;
                                Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                                BluetoothDevice bluetoothDevice6 = (BluetoothDevice) obj11;
                                if (!Intrinsics.areEqual(str2, bluetoothDevice6.getAddress()) && !Intrinsics.areEqual(str3, bluetoothDevice6.getAddress())) {
                                    WirelessDevice wirelessDevice4 = this.f3896s;
                                    WirelessDevice.Bluetooth bluetooth3 = wirelessDevice4 instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice4 : null;
                                    if (bluetooth3 != null) {
                                        BluetoothDevice bluetoothDevice7 = bluetooth3.f4011d;
                                        boolean zAreEqual3 = Intrinsics.areEqual(bluetoothDevice7 != null ? bluetoothDevice7.getAddress() : null, bluetoothDevice6.getAddress());
                                        i9 = 1;
                                        if (zAreEqual3) {
                                            if (aVar != null) {
                                                aVar.j(false);
                                                Unit unit52 = Unit.INSTANCE;
                                            }
                                        }
                                    } else {
                                        i9 = 1;
                                    }
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match", "mes");
                                    if (lb.f6529c >= i9) {
                                        Log.e("NearDevice", "TransConnect:Device is not match", null);
                                    }
                                    Unit unit53 = Unit.INSTANCE;
                                } else if (aVar != null) {
                                    aVar.j(false);
                                    Unit unit54 = Unit.INSTANCE;
                                }
                            }
                            NearDeviceDataParcel nearDeviceDataParcel6 = tranConnectionController$EventInfo.f3968h;
                            Parcelable parcelable9 = nearDeviceDataParcel6 != null ? (Parcelable) nearDeviceDataParcel6.f3903a : null;
                            if (parcelable9 instanceof WifiP2pDevice) {
                                Object obj12 = nearDeviceDataParcel6.f3903a;
                                Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pDevice");
                                we.h.b("NearDevice", "P2p Disconnect: " + ((WifiP2pDevice) obj12) + ", isSelf:" + tranConnectionController$EventInfo.f3966c);
                                Parcelable parcelable10 = tranConnectionController$EventInfo.f3968h.f3904b;
                                if (parcelable10 instanceof NearDevice) {
                                    NearDevice nearDevice4 = (NearDevice) parcelable10;
                                    nearDevice4.A(PointerIconCompat.TYPE_CELL);
                                    nearDevice4.f3900x = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                                    nearDevice4.f3899w = PointerIconCompat.TYPE_ALIAS;
                                    se.g newState = new se.g(0);
                                    Intrinsics.checkNotNullParameter(newState, "newState");
                                    nearDevice4.I = newState;
                                }
                            } else if (parcelable9 == null) {
                                we.h.c("NearDevice", "P2p Device Info is null, direct Qr or Nfc Disconnect", null);
                                if (!Intrinsics.areEqual(str2, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                    if (!Intrinsics.areEqual(str3, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                        WirelessDevice wirelessDevice5 = this.f3896s;
                                        WirelessDevice.P2p p2p2 = wirelessDevice5 instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice5 : null;
                                        if (p2p2 != null) {
                                            if (Intrinsics.areEqual(p2p2.f4014b, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                                if (aVar != null) {
                                                    aVar.j(false);
                                                    Unit unit55 = Unit.INSTANCE;
                                                }
                                            }
                                        }
                                        we.h.c("NearDevice", "Device is not match, p2p disconnect", null);
                                        Unit unit56 = Unit.INSTANCE;
                                    } else if (aVar != null) {
                                        aVar.j(false);
                                        Unit unit57 = Unit.INSTANCE;
                                    }
                                } else if (aVar != null) {
                                    aVar.j(false);
                                    Unit unit58 = Unit.INSTANCE;
                                }
                            }
                        } else if (numValueOf != 0 && numValueOf.intValue() == 23) {
                            if ((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof BluetoothDevice) {
                                Object obj13 = nearDeviceDataParcel2.f3903a;
                                Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                                BluetoothDevice bluetoothDevice8 = (BluetoothDevice) obj13;
                                if (!Intrinsics.areEqual(str2, bluetoothDevice8.getAddress()) && !Intrinsics.areEqual(str3, bluetoothDevice8.getAddress())) {
                                    WirelessDevice wirelessDevice6 = this.f3896s;
                                    WirelessDevice.Bluetooth bluetooth4 = wirelessDevice6 instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice6 : null;
                                    if (bluetooth4 != null) {
                                        BluetoothDevice bluetoothDevice9 = bluetooth4.f4011d;
                                        boolean zAreEqual4 = Intrinsics.areEqual(bluetoothDevice9 != null ? bluetoothDevice9.getAddress() : null, bluetoothDevice8.getAddress());
                                        i10 = 1;
                                        if (zAreEqual4) {
                                            if (aVar != null) {
                                                tranConnectionController$EventInfo.getClass();
                                                aVar.i();
                                                Unit unit59 = Unit.INSTANCE;
                                            }
                                        }
                                    } else {
                                        i10 = 1;
                                    }
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match", "mes");
                                    if (lb.f6529c >= i10) {
                                        Log.e("NearDevice", "TransConnect:Device is not match", null);
                                    }
                                    Unit unit60 = Unit.INSTANCE;
                                } else if (aVar != null) {
                                    tranConnectionController$EventInfo.getClass();
                                    aVar.i();
                                    Unit unit510 = Unit.INSTANCE;
                                }
                            } else {
                                Parcelable parcelable11 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                                NearDevice nearDevice5 = parcelable11 instanceof NearDevice ? (NearDevice) parcelable11 : null;
                                if (!Intrinsics.areEqual(str2, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                    if (!Intrinsics.areEqual(str3, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                        WirelessDevice wirelessDevice7 = this.f3896s;
                                        WirelessDevice.P2p p2p3 = wirelessDevice7 instanceof WirelessDevice.P2p ? (WirelessDevice.P2p) wirelessDevice7 : null;
                                        if (p2p3 != null) {
                                            if (!Intrinsics.areEqual(p2p3.f4014b, deviceInfo != null ? deviceInfo.f4223d : null)) {
                                                if (nearDevice5 != null) {
                                                }
                                                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                                Intrinsics.checkNotNullParameter("Device is not match, p2p connect failed", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("NearDevice", "TransConnect:Device is not match, p2p connect failed", null);
                                                }
                                                Unit unit61 = Unit.INSTANCE;
                                            } else if (aVar != null) {
                                                tranConnectionController$EventInfo.getClass();
                                                aVar.i();
                                                Unit unit62 = Unit.INSTANCE;
                                            }
                                        } else if (nearDevice5 != null || (!Intrinsics.areEqual(this, nearDevice5) && i12 != 10 && i12 != 11)) {
                                            Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                            Intrinsics.checkNotNullParameter("Device is not match, p2p connect failed", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("NearDevice", "TransConnect:Device is not match, p2p connect failed", null);
                                            }
                                            Unit unit63 = Unit.INSTANCE;
                                        } else if (aVar != null) {
                                            tranConnectionController$EventInfo.getClass();
                                            aVar.i();
                                            Unit unit64 = Unit.INSTANCE;
                                        }
                                    } else if (aVar != null) {
                                        tranConnectionController$EventInfo.getClass();
                                        aVar.i();
                                        Unit unit65 = Unit.INSTANCE;
                                    }
                                } else if (aVar != null) {
                                    tranConnectionController$EventInfo.getClass();
                                    aVar.i();
                                    Unit unit66 = Unit.INSTANCE;
                                }
                            }
                        } else if (numValueOf != 0 && numValueOf.intValue() == 4) {
                            we.h.h("NearDevice", "File Transfer Disconnect");
                        } else if (numValueOf != 0 && numValueOf.intValue() == 32) {
                            NearDeviceDataParcel nearDeviceDataParcel7 = tranConnectionController$EventInfo.f3968h;
                            if ((nearDeviceDataParcel7 != null ? (Parcelable) nearDeviceDataParcel7.f3903a : null) instanceof NearDevice) {
                                Object obj14 = nearDeviceDataParcel7.f3903a;
                                Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                                NearDevice nearDevice6 = (NearDevice) obj14;
                                if (this != nearDevice6 && (i12 != nearDevice6.f3890k || !Intrinsics.areEqual(str3, nearDevice6.f3885c) || !Intrinsics.areEqual(s(), nearDevice6.s()))) {
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearDevice", "TransConnect:Device is not match", null);
                                    }
                                    Unit unit67 = Unit.INSTANCE;
                                } else if (aVar != null) {
                                    aVar.l(true);
                                    Unit unit68 = Unit.INSTANCE;
                                }
                            }
                        } else if (numValueOf != 0 && numValueOf.intValue() == 33) {
                            NearDeviceDataParcel nearDeviceDataParcel8 = tranConnectionController$EventInfo.f3968h;
                            if ((nearDeviceDataParcel8 != null ? (Parcelable) nearDeviceDataParcel8.f3903a : null) instanceof NearDevice) {
                                Object obj15 = nearDeviceDataParcel8.f3903a;
                                Intrinsics.checkNotNull(obj15, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                                NearDevice nearDevice7 = (NearDevice) obj15;
                                if (this != nearDevice7 && (i12 != nearDevice7.f3890k || !Intrinsics.areEqual(str3, nearDevice7.f3885c) || !Intrinsics.areEqual(s(), nearDevice7.s()))) {
                                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                                    Intrinsics.checkNotNullParameter("Device is not match", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("NearDevice", "TransConnect:Device is not match", null);
                                    }
                                    Unit unit69 = Unit.INSTANCE;
                                } else if (aVar != null) {
                                    aVar.l(false);
                                    Unit unit70 = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    tranConnectionController$MessageInfo3 = tranConnectionController$MessageInfo;
                }
                if (function2 != null) {
                    function2.invoke(tranConnectionController$MessageInfo3);
                    Unit unit71 = Unit.INSTANCE;
                }
            }
            NearDeviceDataParcel nearDeviceDataParcel9 = tranConnectionController$EventInfo.f3968h;
            if ((nearDeviceDataParcel9 != null ? (Parcelable) nearDeviceDataParcel9.f3903a : null) instanceof NearDevice) {
                Object obj16 = nearDeviceDataParcel9.f3903a;
                Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearDevice");
                NearDevice nearDevice8 = (NearDevice) obj16;
                Parcelable parcelable12 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                boolean z5 = (parcelable12 == null || !(parcelable12 instanceof BluetoothDevice) || m((BluetoothDevice) parcelable12, null, Integer.valueOf(PointerIconCompat.TYPE_ALIAS), null) == null) ? false : true;
                if (Intrinsics.areEqual(nearDevice8, this) || z5) {
                    h0.a.D("Connected LE device ", nearDevice8.f3883a, "NearDevice");
                    if (aVar != null) {
                        aVar.g(true);
                        Unit unit72 = Unit.INSTANCE;
                    }
                } else {
                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                    Intrinsics.checkNotNullParameter("Connected, device is not match, NearDevice checking bluetooth device", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearDevice", "TransConnect:Connected, device is not match, NearDevice checking bluetooth device", null);
                    }
                    Unit unit73 = Unit.INSTANCE;
                }
            } else {
                Parcelable parcelable13 = nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null;
                boolean z10 = (parcelable13 == null || !(parcelable13 instanceof BluetoothDevice) || n(this, (BluetoothDevice) parcelable13, null, 14) == null) ? false : true;
                if (parcelable13 == null || z10) {
                    Intrinsics.checkNotNull(parcelable13, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                    h0.a.D("Connected LE device ", ((BluetoothDevice) parcelable13).getAddress(), "NearDevice");
                    if (aVar != null) {
                        aVar.g(true);
                        Unit unit74 = Unit.INSTANCE;
                    }
                } else {
                    Intrinsics.checkNotNullParameter("NearDevice", "tag");
                    Intrinsics.checkNotNullParameter("Connected, device is not match, Bluetooth checking", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearDevice", "TransConnect:Connected, device is not match, Bluetooth checking", null);
                    }
                    Unit unit75 = Unit.INSTANCE;
                }
            }
            tranConnectionController$MessageInfo3 = tranConnectionController$MessageInfo;
            function2 = function1;
            if (function2 != null) {
                function2.invoke(tranConnectionController$MessageInfo3);
                Unit unit76 = Unit.INSTANCE;
            }
        }
        tranConnectionController$MessageInfo3 = tranConnectionController$MessageInfo;
        if (aVar != null) {
            aVar.j(true);
            Unit unit77 = Unit.INSTANCE;
        }
        function2 = function1;
        if (function2 != null) {
            function2.invoke(tranConnectionController$MessageInfo3);
            Unit unit78 = Unit.INSTANCE;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(z manager, g5 msgInfo, a8.a resultCallback, Function1 function1) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        int i8 = this.f3890k;
        if (msgInfo == null) {
            manager.p(this, new i1(this, function1, resultCallback, 1), true);
            g gVar = manager.f4207i;
            if (i8 == 0 || i8 == 1 || i8 == 12 || i8 == 14) {
                Intent intent = new Intent();
                intent.setAction("com.welink.protocol.nfbd.action.REQUEST_CONNECT_DEVICE");
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", this);
                if (gVar != null) {
                    gVar.w(intent, 0);
                    return;
                }
                return;
            }
            if (i8 != 11 && i8 != 10) {
                we.h.h("TranConnectionManager", "TranConnectionManager: onStartConnect: unknown wireless type");
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("com.welink.protocol.nfbd.action.NOTIFY_QRSCAN_CONNECT_DEVICE");
            WirelessDevice wirelessDevice = this.f3896s;
            Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
            WirelessDevice.P2p p2p = (WirelessDevice.P2p) wirelessDevice;
            intent2.putExtra("SSID", p2p.f4013a);
            intent2.putExtra("PWD", p2p.f4015c);
            String str = p2p.f4014b;
            if (str == null) {
                str = "02:00:00:00:00:00";
            }
            intent2.putExtra("BSSID", str);
            intent2.putExtra("CHAN", p2p.f4016d);
            intent2.putExtra("TIMEOUT", p2p.f4017h);
            intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", this);
            if (gVar != null) {
                gVar.w(intent2, 0);
                return;
            }
            return;
        }
        i1 connResultCallBack = new i1(this, function1, resultCallback, 2);
        manager.getClass();
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        Intrinsics.checkNotNullParameter(connResultCallBack, "connResultCallBack");
        manager.p(this, connResultCallBack, true);
        g gVar2 = manager.f4207i;
        if (i8 == 0 || i8 == 1 || i8 == 12) {
            Intent intent3 = new Intent();
            intent3.setAction("com.welink.protocol.nfbd.action.REQUEST_CONNECT_DEVICE");
            intent3.putExtra("selectedMac", msgInfo.f9746a);
            intent3.putExtra("fileName", msgInfo.f9747b);
            intent3.putExtra("fileCount", msgInfo.f9748c);
            intent3.putExtra("fileSize", msgInfo.f9749d);
            intent3.putExtra("fileType", msgInfo.e);
            intent3.putExtra("p2pPort", msgInfo.f);
            intent3.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", this);
            if (gVar2 != null) {
                gVar2.w(intent3, 0);
                return;
            }
            return;
        }
        if (i8 != 11 && i8 != 10) {
            we.h.h("TranConnectionManager", "TranConnectionManager: onStartConnect: unknown wireless type");
            return;
        }
        Intent intent4 = new Intent();
        intent4.setAction("com.welink.protocol.nfbd.action.NOTIFY_QRSCAN_CONNECT_DEVICE");
        WirelessDevice wirelessDevice2 = this.f3896s;
        Intrinsics.checkNotNull(wirelessDevice2, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
        WirelessDevice.P2p p2p2 = (WirelessDevice.P2p) wirelessDevice2;
        intent4.putExtra("SSID", p2p2.f4013a);
        intent4.putExtra("PWD", p2p2.f4015c);
        intent4.putExtra("BSSID", p2p2.f4014b);
        intent4.putExtra("CHAN", p2p2.f4016d);
        intent4.putExtra("TIMEOUT", WorkRequest.MIN_BACKOFF_MILLIS);
        intent4.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", this);
        if (gVar2 != null) {
            gVar2.w(intent4, 0);
        }
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(NearDevice.class, obj.getClass()) || !(obj instanceof NearDevice)) {
            return false;
        }
        String str3 = this.f3885c;
        boolean zAreEqual = (str3 == null || (str2 = ((NearDevice) obj).f3885c) == null) ? false : Intrinsics.areEqual(str3, str2);
        String str4 = this.f3883a;
        boolean zAreEqual2 = (str4 == null || (str = ((NearDevice) obj).f3883a) == null) ? false : Intrinsics.areEqual(str4, str);
        if (str4 == null && ((NearDevice) obj).f3883a == null) {
            zAreEqual2 = true;
        }
        NearDevice nearDevice = (NearDevice) obj;
        return zAreEqual && zAreEqual2 && (this.e == nearDevice.e) && (this.f3890k == nearDevice.f3890k) && Intrinsics.areEqual(this.f3896s, nearDevice.f3896s) && (this.D == nearDevice.D) && (this.C == nearDevice.C);
    }

    public final void f(z manager, a8.a resultCallback, Function1 function1) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        manager.p(this, new i1(this, function1, resultCallback, 0), false);
        Intent intent = new Intent();
        intent.setAction("com.welink.protocol.nfbd.action.DISCONNECT_REMOTE_DEVICE");
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", this);
        g gVar = manager.f4207i;
        if (gVar != null) {
            gVar.w(intent, 0);
        }
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getF3883a() {
        return this.f3883a;
    }

    public final String h() {
        String str = this.f3892m;
        return str == null ? "Unknown" : str;
    }

    public final int hashCode() {
        return Objects.hash(this.f3883a, this.f3885c, Integer.valueOf(this.e), Integer.valueOf(this.f3890k), this.f3896s, Integer.valueOf(this.D), Byte.valueOf(this.C));
    }

    public final String i(Integer num) {
        switch (num != null ? num.intValue() : this.f3899w) {
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                return "BT Connecting";
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                return "BT Connected";
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                return "BT Disconnecting";
            case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                return "BT Disconnected";
            default:
                return "Unknown";
        }
    }

    public final List j() {
        Set set;
        NearDeviceExtension nearDeviceExtension = this.u;
        if (nearDeviceExtension == null || (set = nearDeviceExtension.f3910i) == null) {
            return null;
        }
        return CollectionsKt.toList(set);
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getF3885c() {
        return this.f3885c;
    }

    public final String l() {
        WirelessDevice wirelessDevice = this.f3896s;
        if (!(wirelessDevice instanceof WirelessDevice.Wlan)) {
            return null;
        }
        Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Wlan");
        return ((WirelessDevice.Wlan) wirelessDevice).f4026c;
    }

    public final NearDevice m(BluetoothDevice bluetoothDevice, Integer num, Integer num2, Integer num3) {
        BluetoothDevice bluetoothDevice2;
        if (num != null && !Intrinsics.areEqual(num, this.f3898v)) {
            String mes = h0.a.k("Device state is not match, IncludeState: ", v(num), ", State: ", v(null));
            Intrinsics.checkNotNullParameter("NearDevice", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes, "NearDevice", null);
            }
            return null;
        }
        if (num2 != null) {
            if (num2.intValue() == this.f3899w) {
                String mes2 = h0.a.k("Device state is not match, btExcludeState: ", i(num2), ", btState: ", i(null));
                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                Intrinsics.checkNotNullParameter(mes2, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes2, "NearDevice", null);
                }
                return null;
            }
        }
        if (num3 != null) {
            if (num3.intValue() != this.f3899w) {
                String mes3 = h0.a.k("Device state is not match, btIncludeState: ", i(num3), ", btState: ", i(null));
                Intrinsics.checkNotNullParameter("NearDevice", "tag");
                Intrinsics.checkNotNullParameter(mes3, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes3, "NearDevice", null);
                }
                return null;
            }
        }
        String address = bluetoothDevice.getAddress();
        WirelessDevice wirelessDevice = this.f3896s;
        WirelessDevice.Bluetooth bluetooth = wirelessDevice instanceof WirelessDevice.Bluetooth ? (WirelessDevice.Bluetooth) wirelessDevice : null;
        if (Intrinsics.areEqual(address, (bluetooth == null || (bluetoothDevice2 = bluetooth.f4011d) == null) ? null : bluetoothDevice2.getAddress()) || Intrinsics.areEqual(bluetoothDevice.getAddress(), this.f3883a) || Intrinsics.areEqual(bluetoothDevice.getAddress(), this.f3885c)) {
            return this;
        }
        return null;
    }

    public final int o() {
        return Objects.hash(this.f3885c, u());
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getF3884b() {
        return this.f3884b;
    }

    public final k1 q() {
        switch (this.f3890k) {
            case 0:
            case 1:
                if (y()) {
                    return k1.IMMEDIATE_MIDDLE;
                }
                Integer num = this.f3898v;
                return (num != null && num.intValue() == 1006) ? k1.IMMEDIATE_LOW : k1.FAST_LOW;
            case 2:
                return k1.LOW_MIDDLE;
            case 3:
            case 10:
            case 11:
                return k1.MIDDLE_MIDDLE;
            case 4:
                return k1.MIDDLE_HIGH;
            case 5:
            case 9:
            case 12:
            case 13:
            default:
                return k1.LOW_LOW;
            case 6:
                return k1.LOW_MIDDLE;
            case 7:
                return k1.IMMEDIATE_LOW;
            case 8:
                return k1.LOW_HIGH;
            case 14:
                return y() ? k1.FLASH_MIDDLE : k1.IMMEDIATE_HIGH;
        }
    }

    public final String r() {
        String str = this.f3893n;
        return str == null ? "0000" : str;
    }

    public final String s() {
        WirelessDevice wirelessDevice = this.f3896s;
        if (!(wirelessDevice instanceof WirelessDevice.Wlan)) {
            return null;
        }
        Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Wlan");
        return ((WirelessDevice.Wlan) wirelessDevice).f4025b;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final int getE() {
        return this.e;
    }

    public final String toString() {
        String str;
        String str2 = this.f3884b;
        Integer num = this.f3886d;
        String strU = u();
        String strX = x();
        String strV = v(null);
        String strI = i(null);
        String str3 = "Unknown";
        switch (this.f3900x) {
            case PointerIconCompat.TYPE_COPY /* 1011 */:
                str = "P2P Connecting";
                break;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                str = "P2P Connected";
                break;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                str = "P2P Disconnecting";
                break;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                str = "P2P Disconnected";
                break;
            default:
                str = "Unknown";
                break;
        }
        switch (this.f3901y) {
            case PointerIconCompat.TYPE_ZOOM_OUT /* 1019 */:
                str3 = "NAN Connecting";
                break;
            case PointerIconCompat.TYPE_GRAB /* 1020 */:
                str3 = "NAN Connected";
                break;
            case PointerIconCompat.TYPE_GRABBING /* 1021 */:
                str3 = "NAN Disconnecting";
                break;
            case 1022:
                str3 = "NAN Disconnected";
                break;
        }
        WirelessDevice wirelessDevice = this.f3896s;
        String simpleName = this.I.getClass().getSimpleName();
        WirelessDevice wirelessDevice2 = this.f3896s;
        int i8 = this.p;
        byte b9 = this.C;
        int i9 = this.E;
        StringBuilder sb2 = new StringBuilder("\n        NearDevice Info(\n            mAddress=");
        o.d.A(sb2, this.f3883a, ",\n            mName=", str2, ",\n            mDeviceId=");
        sb2.append(this.f3885c);
        sb2.append(",\n            mRssi=");
        sb2.append(num);
        sb2.append(",\n            mBrand=");
        sb2.append(this.f3892m);
        sb2.append(",\n            mDeviceType=");
        sb2.append(this.f3889j);
        sb2.append(",\n            mServiceType=");
        sb2.append(strU);
        sb2.append(",\n            mSubCapability=");
        sb2.append(this.f3887h);
        sb2.append(",\n            mWirelessType=");
        sb2.append(strX);
        sb2.append(",\n            mSupportedType=");
        sb2.append(this.f3891l);
        sb2.append(",\n            mProductCode=");
        sb2.append(this.f3893n);
        sb2.append(",\n            mVersion=");
        sb2.append(this.f3894o);
        sb2.append(",\n            mBondState=");
        sb2.append(this.q);
        sb2.append(",\n            mIsTrusted=");
        sb2.append(this.f3895r);
        sb2.append(",\n            mState=");
        sb2.append(strV);
        sb2.append(",\n            mBtState=");
        o.d.A(sb2, strI, ",\n            mP2pState=", str, ",\n            mNanState=");
        sb2.append(str3);
        sb2.append(",\n            mWirelessDevice=");
        sb2.append(wirelessDevice);
        sb2.append(",\n            mConnectionState=");
        sb2.append(simpleName);
        sb2.append(",\n            mDeviceInfo=");
        sb2.append(wirelessDevice2);
        sb2.append(",\n            mClientMode=");
        sb2.append(i8);
        sb2.append(",\n            mExtension=");
        sb2.append(this.u);
        sb2.append(",\n            mIphoneAction=");
        sb2.append((int) b9);
        sb2.append(",\n            mIphoneActionCount=");
        sb2.append(this.D);
        sb2.append(",\n            mIphoneRequestResult=");
        sb2.append(i9);
        sb2.append(",\n            mFileCount=");
        sb2.append(this.F);
        sb2.append(",\n            mFileType=");
        sb2.append(this.G);
        sb2.append(",\n            mShortPID=");
        sb2.append(this.H);
        sb2.append("\n        )\n    ");
        return StringsKt.trimIndent(sb2.toString());
    }

    public final String u() {
        String str;
        String str2;
        int i8 = this.e;
        if (i8 == 0) {
            return "Screen Cast";
        }
        if (i8 == 1) {
            return "Parcel Drop";
        }
        if (i8 == 4) {
            return "Clipboard Drop";
        }
        if (i8 == 5) {
            return "Handover Drop";
        }
        if (i8 == 8) {
            return "Air Cast";
        }
        if (i8 == 15) {
            return "Wearable";
        }
        if (i8 != 251) {
            switch (i8) {
                case 10:
                    return "Audio Sink";
                case 11:
                    return "Keyboard Mouse Share";
                case 12:
                    return "Call Share";
                case 13:
                    return "Camera Share";
                default:
                    return "Unknown";
            }
        }
        NearDeviceExtension nearDeviceExtension = this.u;
        List list = nearDeviceExtension != null ? nearDeviceExtension.f3905a : null;
        if (list != null) {
            str = "Screen Cast";
            if (list.size() == 1) {
                int iIntValue = ((Number) list.get(0)).intValue();
                if (iIntValue == 0) {
                    return str;
                }
                if (iIntValue == 1) {
                    return "Parcel Drop";
                }
                if (iIntValue == 4) {
                    return "Clipboard Drop";
                }
                if (iIntValue == 5) {
                    return "Handover Drop";
                }
                if (iIntValue == 15) {
                    return "Wearable";
                }
                switch (iIntValue) {
                    case 8:
                        return "Air Cast";
                    case 9:
                        return "Extend Cast";
                    case 10:
                        return "Audio Sink";
                    case 11:
                        return "Keyboard Mouse Share";
                    case 12:
                        return "Call Share";
                    case 13:
                        return "Camera Share";
                    default:
                        if (((Number) list.get(0)).intValue() <= 31) {
                            return "empty";
                        }
                        we.h.j("NearDevice", "Found Private Service Type, " + list.get(0));
                        return a1.a.p(list.get(0), "Private Service + ");
                }
            }
        } else {
            str = "Screen Cast";
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Iterator it2 = it;
                int iIntValue2 = ((Number) it.next()).intValue();
                if (iIntValue2 != 0) {
                    if (iIntValue2 == 1) {
                        arrayList.add("Parcel Drop");
                    } else if (iIntValue2 == 4) {
                        arrayList.add("Clipboard Drop");
                    } else if (iIntValue2 == 5) {
                        arrayList.add("Handover Drop");
                    } else if (iIntValue2 != 15) {
                        switch (iIntValue2) {
                            case 8:
                                arrayList.add("Air Cast");
                                break;
                            case 9:
                                arrayList.add("Extend Cast");
                                break;
                            case 10:
                                arrayList.add("Audio Sink");
                                break;
                            case 11:
                                arrayList.add("Keyboard Mouse Share");
                                break;
                            case 12:
                                arrayList.add("Call Share");
                                break;
                            case 13:
                                arrayList.add("Camera Share");
                                break;
                            default:
                                if (iIntValue2 > 31) {
                                    we.h.j("NearDevice", "Found Private Service Type, " + iIntValue2);
                                    arrayList.add("Private Service + " + iIntValue2);
                                }
                                break;
                        }
                    } else {
                        arrayList.add("Wearable");
                    }
                    str2 = str;
                } else {
                    str2 = str;
                    arrayList.add(str2);
                }
                str = str2;
                list = list;
                it = it2;
            }
        }
        we.h.h("NearDevice", "Get Service Target, capabilities: " + list + ", multi-service: " + CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null));
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    public final String v(Integer num) {
        if (num == null) {
            num = this.f3898v;
        }
        if (num != null && num.intValue() == 1006) {
            return "Disconnected";
        }
        if (num != null && num.intValue() == 1003) {
            return "Connecting";
        }
        if (num != null && num.intValue() == 1004) {
            return "Connected";
        }
        return (num != null && num.intValue() == 1005) ? "Disconnecting" : "Unknown";
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final int getF3890k() {
        return this.f3890k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i8) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f3883a);
        dest.writeString(this.f3884b);
        dest.writeString(this.f3885c);
        Integer num = this.f3886d;
        dest.writeInt(num != null ? num.intValue() : -1);
        dest.writeString(this.f3892m);
        dest.writeInt(this.f3889j);
        dest.writeInt(this.e);
        dest.writeInt(this.f3887h);
        int i9 = this.f3890k;
        dest.writeInt(i9);
        UInt uInt = this.f3891l;
        dest.writeLong(uInt != null ? ((long) uInt.getData()) & 4294967295L : 0L);
        dest.writeString(this.f3893n);
        dest.writeString(this.f3894o);
        dest.writeInt(this.p);
        dest.writeInt(this.q);
        Integer num2 = this.f3898v;
        dest.writeInt(num2 != null ? num2.intValue() : -1);
        dest.writeInt(this.f3899w);
        dest.writeInt(this.f3900x);
        dest.writeInt(this.f3901y);
        Boolean bool = this.f3895r;
        dest.writeBoolean(bool != null ? bool.booleanValue() : false);
        dest.writeLong(this.f3888i);
        dest.writeInt(this.f3902z);
        List list = this.A;
        dest.writeIntArray(list != null ? CollectionsKt.toIntArray(list) : null);
        if (i9 == 0 || i9 == 1) {
            dest.writeString("Bluetooth");
            WirelessDevice wirelessDevice = this.f3896s;
            Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
            dest.writeParcelable((WirelessDevice.Bluetooth) wirelessDevice, i8);
        } else if (i9 == 2) {
            dest.writeString("Wifi");
            WirelessDevice wirelessDevice2 = this.f3896s;
            Intrinsics.checkNotNull(wirelessDevice2, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Wifi");
            dest.writeParcelable((WirelessDevice.Wifi) wirelessDevice2, i8);
        } else if (i9 == 3 || i9 == 10 || i9 == 11) {
            dest.writeString("P2P");
            WirelessDevice wirelessDevice3 = this.f3896s;
            Intrinsics.checkNotNull(wirelessDevice3, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.P2p");
            dest.writeParcelable((WirelessDevice.P2p) wirelessDevice3, i8);
        } else {
            dest.writeString("Empty");
        }
        dest.writeStringList(this.f3897t);
        dest.writeParcelable(this.u, i8);
        dest.writeString(this.I.getClass().getSimpleName());
        dest.writeInt(this.B);
        dest.writeByte(this.C);
        dest.writeInt(this.D);
        dest.writeInt(this.E);
        dest.writeInt(this.F);
        dest.writeString(this.G);
        dest.writeString(this.H);
    }

    public final String x() {
        switch (this.f3890k) {
            case 0:
                return "Bluetooth LE";
            case 1:
                return "Bluetooth EDR";
            case 2:
                return "WIFI STA";
            case 3:
                return "WIFI P2P";
            case 4:
                return "WIFI NAN";
            case 5:
            case 12:
            default:
                return "Unknown";
            case 6:
                return "UWB";
            case 7:
                return "NFC";
            case 8:
                return "Thread";
            case 9:
                return "Cellular";
            case 10:
                return "QR P2P";
            case 11:
                return "NFC P2P";
            case 13:
                return "USB";
            case 14:
                return "WLAN NSD";
            case 15:
                return "WLAN MQTT";
            case 16:
                return "WLAN COAP";
        }
    }

    public final boolean y() {
        Integer num;
        int i8 = this.f3890k;
        if (i8 == 0 || i8 == 1) {
            WirelessDevice wirelessDevice = this.f3896s;
            if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
                Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
                if (((WirelessDevice.Bluetooth) wirelessDevice).f4010c == null && (num = this.f3886d) != null && num.intValue() == 0) {
                    return true;
                }
            }
            Integer num2 = this.f3886d;
            return (num2 != null && num2.intValue() == 0) || this.f3886d == null;
        }
        if (i8 == 2 || i8 == 3 || i8 == 4 || i8 == 10 || i8 == 11) {
            return true;
        }
        if (i8 != 14) {
            return false;
        }
        NearDeviceExtension nearDeviceExtension = this.u;
        return ((nearDeviceExtension != null ? nearDeviceExtension.f3909h : null) == null || nearDeviceExtension.e) ? false : true;
    }

    public final void z(NearDevice nearDevice) {
        Set set;
        List list;
        Intrinsics.checkNotNullParameter(nearDevice, "device");
        NearDeviceExtension nearDeviceExtension = this.u;
        if ((nearDeviceExtension == null || (set = nearDeviceExtension.f3910i) == null || (list = CollectionsKt.toList(set)) == null || list.contains(nearDevice)) && nearDeviceExtension != null) {
            Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
            Set set2 = nearDeviceExtension.f3910i;
            if (set2 == null) {
                return;
            }
            set2.remove(nearDevice);
        }
    }
}
