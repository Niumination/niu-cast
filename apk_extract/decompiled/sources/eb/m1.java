package eb;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.welink.protocol.utils.ArrayUtil$ServicePort;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k3.gc;
import k3.pb;
import k3.sb;
import k3.tb;
import k3.vb;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import se.h5;
import se.y4;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 extends SuspendLambda implements Function2 {
    int label;

    public m1(Continuation<? super m1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new m1(continuation);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:139:0x0422  */
    /* JADX WARN: Failed to find 'out' block for switch in B:138:0x041f. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
        SharedPreferences sharedPreferences;
        String strTakeLast;
        SharedPreferences sharedPreferences2;
        byte[] uniqueId;
        com.welink.protocol.nfbd.z zVar;
        com.welink.protocol.nfbd.z zVar2;
        int i8;
        SharedPreferences sharedPreferences3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        kc.b bVar = o1.f4783b;
        Application context = pb.a();
        Intrinsics.checkNotNullParameter(context, "context");
        String deviceName = Settings.Global.getString(context.getContentResolver(), "device_name");
        Intrinsics.checkNotNull(deviceName);
        byte[] bytes = deviceName.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        int length = bytes.length;
        float length2 = length / deviceName.length();
        gc.a("PhoneUtil", "PhoneUtil,getAdvName, phoneDeviceName:" + deviceName + ",phoneDeviceName.toByteArray().size:" + length + " ,step:" + length2);
        if (length2 <= 1.0f) {
            f = 1.0f;
        } else if (length2 <= 2.0f) {
            f = 2.0f;
        } else {
            f = length2 <= 3.0f ? 3.0f : 4.0f;
        }
        if (f == 1.0f) {
            if (deviceName.length() > 11) {
                String strSubstring = deviceName.substring(0, 6);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = deviceName.substring(deviceName.length() - 2, deviceName.length());
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                deviceName = o.d.l(strSubstring, "...", strSubstring2);
            }
        } else if (f == 2.0f) {
            if (deviceName.length() > 5) {
                String strSubstring3 = deviceName.substring(0, 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                deviceName = strSubstring3 + "...";
            }
        } else if (f == 3.0f) {
            if (deviceName.length() > 3) {
                String strSubstring4 = deviceName.substring(0, 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                deviceName = strSubstring4 + "...";
            }
        } else if (f == 4.0f && deviceName.length() > 2) {
            String strSubstring5 = deviceName.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
            deviceName = strSubstring5 + ".";
        }
        gc.a("PhoneUtil", "PhoneUtil,getAdvName :" + deviceName);
        Intrinsics.checkNotNull(deviceName);
        Application context2 = pb.a();
        Intrinsics.checkNotNullParameter(context2, "context");
        String strA = sb.a(context2);
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        String strA2 = tb.a(BRAND);
        pa.a aVar = pa.a.f8703a;
        if (pa.a.j("ro.tr_project.foldable_screen.support")) {
            Intrinsics.checkNotNullParameter("0000", "default");
            Intrinsics.checkNotNullParameter("model_id", "key");
            Intrinsics.checkNotNullParameter("0000", "defaultVal");
            SharedPreferences sharedPreferences4 = vb.f6684a;
            if (sharedPreferences4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences3 = null;
            } else {
                sharedPreferences3 = sharedPreferences4;
            }
            String string = sharedPreferences3.getString("model_id", "");
            strTakeLast = StringsKt___StringsKt.takeLast(string != null ? string : "", 4);
        } else if (pa.a.j("ro.tr_project.flip_screen.support")) {
            Intrinsics.checkNotNullParameter("0011", "default");
            Intrinsics.checkNotNullParameter("model_id", "key");
            Intrinsics.checkNotNullParameter("0011", "defaultVal");
            SharedPreferences sharedPreferences5 = vb.f6684a;
            if (sharedPreferences5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences2 = null;
            } else {
                sharedPreferences2 = sharedPreferences5;
            }
            String string2 = sharedPreferences2.getString("model_id", "");
            strTakeLast = StringsKt___StringsKt.takeLast(string2 != null ? string2 : "", 4);
        } else {
            Intrinsics.checkNotNullParameter("FFFF", "default");
            Intrinsics.checkNotNullParameter("model_id", "key");
            Intrinsics.checkNotNullParameter("FFFF", "defaultVal");
            SharedPreferences sharedPreferences6 = vb.f6684a;
            if (sharedPreferences6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences = null;
            } else {
                sharedPreferences = sharedPreferences6;
            }
            String string3 = sharedPreferences.getString("model_id", "");
            String str = string3 != null ? string3 : "";
            strTakeLast = str.length() == 0 ? "DDDD" : StringsKt___StringsKt.takeLast(str, 4);
        }
        StringBuilder sbP = h0.a.p("06", strA, "00", strA2, "000111");
        sbP.append(strTakeLast);
        String vendorId = sbP.toString();
        StringBuilder sbP2 = h0.a.p("PhoneUtil,getAdvPid:", vendorId, ",productType:06,productSubtype:", strA, ",reserver:00,productBrand:");
        sbP2.append(strA2);
        sbP2.append(",vendorBrand:00,wirelesssType:01,protocolVersion:11,productEncode:");
        sbP2.append(strTakeLast);
        String log = sbP2.toString();
        Intrinsics.checkNotNullParameter("AdvertiseUtil", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("AdvertiseUtil"), log);
        }
        bVar.getClass();
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(vendorId, "broadcastPid");
        gc.a("ScanApi", "startAdvertisement deviceName:" + deviceName + " broadcastPid:" + vendorId);
        if (bVar.f6820c) {
            Log.i("ScanApi", "startAdvertisement:already advertising");
        } else {
            Lazy lazy = mc.b.f7958a;
            mc.b.d();
            if (deviceName.length() > 0 && vendorId.length() > 0) {
                gc.a("ScanApi", "SmartConnect is enabled. startAdvertisement");
                a8.a aVar2 = ma.b.f7956b.f7957a;
                aVar2.getClass();
                try {
                    List listSplit$default = StringsKt__StringsKt.split$default(aVar2.e(), new String[]{":"}, false, 0, 6, (Object) null);
                    uniqueId = new byte[listSplit$default.size()];
                    int size = listSplit$default.size();
                    for (int i9 = 0; i9 < size; i9++) {
                        uniqueId[i9] = (byte) Integer.parseInt((String) listSplit$default.get(i9), 16);
                    }
                } catch (Exception unused) {
                    uniqueId = new byte[0];
                }
                Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                Intrinsics.checkNotNullParameter(vendorId, "vendorId");
                String log2 = "startAdv:".concat(vendorId);
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TranConnectManager"), log2);
                }
                se.b1 b1VarE = mc.b.e();
                int iM254constructorimpl = UInt.m254constructorimpl(65);
                com.welink.protocol.nfbd.y yVar = b1VarE.f9655c;
                if (uniqueId.length == 0) {
                    we.h.j("NearConnectionManager", "startAdvertising: uniqueId is null or empty, ignore it");
                } else if (uniqueId.length == 6) {
                    yVar.getClass();
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    com.welink.protocol.nfbd.c0 c0Var = yVar.f4191c;
                    if (c0Var != null) {
                        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                        com.welink.protocol.nfbd.z zVar3 = c0Var.f4090c;
                        if (zVar3 != null) {
                            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                            Intent intent = new Intent();
                            intent.setAction("com.welink.service.ACTION_SET_ADVERTISING_UNIQUE_ID");
                            intent.putExtra("com.welink.service.EXTRA_ADVERTISING_UNIQUE_ID", uniqueId);
                            com.welink.protocol.nfbd.g gVar = zVar3.f4207i;
                            if (gVar != null) {
                                gVar.w(intent, 0);
                            }
                        }
                    }
                } else {
                    we.h.j("NearConnectionManager", "startAdvertising: uniqueId size is not 6, ignore it");
                }
                if (vendorId.length() == 0) {
                    we.h.j("NearConnectionManager", "startAdvertising: vendorId is null or empty, ignore it");
                } else {
                    com.welink.protocol.nfbd.c0 c0Var2 = yVar.f4191c;
                    if (c0Var2 != null && (zVar = c0Var2.f4090c) != null) {
                        Intent intent2 = new Intent();
                        intent2.setAction("com.welink.service.ACTION_BLE_ADV_VENDOR_PID");
                        intent2.putExtra("com.welink.service.EXTRA_BLE_ADV_VENDOR_PID", vendorId);
                        com.welink.protocol.nfbd.g gVar2 = zVar.f4207i;
                        if (gVar2 != null) {
                            gVar2.w(intent2, 0);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (!arrayList.isEmpty()) {
                    List servicePortList = CollectionsKt.toList(arrayList);
                    yVar.getClass();
                    Intrinsics.checkNotNullParameter(servicePortList, "serviceList");
                    com.welink.protocol.nfbd.c0 c0Var3 = yVar.f4191c;
                    if (c0Var3 != null) {
                        Intrinsics.checkNotNullParameter(servicePortList, "servicePortList");
                        com.welink.protocol.nfbd.z zVar4 = c0Var3.f4090c;
                        if (zVar4 != null) {
                            Intrinsics.checkNotNullParameter(servicePortList, "servicePortList");
                            Intent intent3 = new Intent();
                            intent3.setAction("com.welink.service.ACTION_SET_ADVERTISING_SERVICE_AND_PORT");
                            Intrinsics.checkNotNullParameter(servicePortList, "servicePortList");
                            List<Pair> list = servicePortList;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.i(list));
                            for (Pair pair : list) {
                                arrayList2.add(new ArrayUtil$ServicePort((String) pair.getFirst(), ((Number) pair.getSecond()).intValue()));
                            }
                            intent3.putExtra("com.welink.service.EXTRA_ADVERTISING_SERVICE_AND_PORT", (ArrayUtil$ServicePort[]) arrayList2.toArray(new ArrayUtil$ServicePort[0]));
                            com.welink.protocol.nfbd.g gVar3 = zVar4.f4207i;
                            if (gVar3 != null) {
                                gVar3.w(intent3, 0);
                            }
                        }
                    }
                }
                if (1 != UInt.m254constructorimpl(0)) {
                    yVar.getClass();
                    boolean z2 = UInt.m254constructorimpl(iM254constructorimpl & 1) != UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(2 & iM254constructorimpl);
                    UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(iM254constructorimpl & 4);
                    UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(iM254constructorimpl & 8);
                    UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(16 & iM254constructorimpl);
                    UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(iM254constructorimpl & 32);
                    UInt.m254constructorimpl(0);
                    boolean z3 = UInt.m254constructorimpl(iM254constructorimpl & 64) != UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(iM254constructorimpl & 256);
                    UInt.m254constructorimpl(0);
                    UInt.m254constructorimpl(iM254constructorimpl & 128);
                    UInt.m254constructorimpl(0);
                    ConcurrentHashMap.KeySetView keySetView = yVar.f4195i.f;
                    keySetView.clear();
                    int i10 = 0;
                    while (i10 < 10) {
                        if (UInt.m254constructorimpl(UInt.m254constructorimpl(1 << i10) & 1) != UInt.m254constructorimpl(0)) {
                            switch (i10) {
                                case 0:
                                    i8 = 1;
                                    keySetView.add(0);
                                    break;
                                case 1:
                                    i8 = 1;
                                    keySetView.add(1);
                                    break;
                                case 2:
                                    keySetView.add(4);
                                    i8 = 1;
                                    break;
                                case 3:
                                    keySetView.add(5);
                                    i8 = 1;
                                    break;
                                case 4:
                                    keySetView.add(8);
                                    i8 = 1;
                                    break;
                                case 5:
                                    keySetView.add(9);
                                    i8 = 1;
                                    break;
                                case 6:
                                    keySetView.add(10);
                                    i8 = 1;
                                    break;
                                case 7:
                                    keySetView.add(11);
                                    i8 = 1;
                                    break;
                                case 8:
                                    keySetView.add(12);
                                    i8 = 1;
                                    break;
                                case 9:
                                    keySetView.add(13);
                                    i8 = 1;
                                    break;
                                default:
                                    i8 = 1;
                                    break;
                            }
                        } else {
                            i8 = 1;
                        }
                        i10 += i8;
                    }
                    we.h.b("NearDeviceTableFusion", "Advertising Device List: " + keySetView);
                    if (z2) {
                        com.welink.protocol.nfbd.y.x(yVar, 1, false, 6);
                        we.h.b("SmartConnectWrapper", "Start Screen Cast Advertising");
                        com.welink.protocol.nfbd.c0 c0Var4 = yVar.f4191c;
                        if (c0Var4 != null) {
                            se.u0 u0Var = com.welink.protocol.nfbd.c0.f4087g;
                            com.welink.protocol.nfbd.z zVar5 = c0Var4.f4090c;
                            if (zVar5 != null) {
                                Intent intent4 = new Intent();
                                intent4.setAction("com.welink.protocol.nfbd.action.START_ADV_DEVICE");
                                intent4.putExtra("com.welink.protocol.nfbd.extra.scenario", 0);
                                intent4.putExtra("com.welink.protocol.nfbd.extra.subcapability", (Serializable) 0);
                                intent4.putExtra("com.welink.protocol.nfbd.extra.service_data", new byte[0]);
                                intent4.putExtra("com.welink.protocol.nfbd.extra.service_private_data", new int[0]);
                                com.welink.protocol.nfbd.g gVar4 = zVar5.f4207i;
                                if (gVar4 != null) {
                                    gVar4.w(intent4, 0);
                                }
                            }
                        }
                    }
                    if (z3) {
                        we.h.b("SmartConnectWrapper", "Start mDNS Advertising");
                        byte[] bArrX = com.welink.protocol.nfbd.y.x(yVar, 1, true, 4);
                        y4 y4Var = yVar.e;
                        if (y4Var != null && (zVar2 = y4Var.f10069a) != null) {
                            h5 h5Var = zVar2.f4203c;
                            if (h5Var == null || !h5Var.f9778i) {
                                Intent intent5 = new Intent();
                                intent5.setAction("com.welink.protocol.nfbd.action.START_LAN_ADVERTISE");
                                intent5.putExtra("com.welink.protocol.nfbd.extra.service", 0);
                                intent5.putExtra("com.welink.protocol.nfbd.extra.service_data", bArrX);
                                intent5.putExtra("com.welink.protocol.nfbd.extra.subcapability", (Serializable) 0);
                                com.welink.protocol.nfbd.g gVar5 = zVar2.f4207i;
                                if (gVar5 != null) {
                                    gVar5.w(intent5, 0);
                                }
                            } else {
                                we.h.j("TranConnectionManager", "LanAdvertisement is running already");
                            }
                        }
                    }
                } else {
                    we.h.j("NearConnectionManager", "startAdvertising: service is SERVICE_NONE");
                }
                bVar.f6820c = true;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((m1) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
