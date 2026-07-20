package eb;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.util.Log;
import java.util.Iterator;
import k3.gc;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import se.b5;
import se.b6;
import se.h5;
import se.k6;
import se.q4;
import se.y4;

/* JADX INFO: loaded from: classes2.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f4782a = new o1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kc.b f4783b = new kc.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f4784c = li.h0.a(li.v0.f7499b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static li.g2 f4785d;
    public static boolean e;

    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    public static void b() {
        com.welink.protocol.nfbd.z zVar;
        boolean z2;
        boolean zIsDiscovering;
        boolean zIsDiscovering2;
        gc.a("ScanManager", "stopScan");
        if (!e) {
            gc.c("ScanManager", "stopScan already stop");
            return;
        }
        kc.b bVar = f4783b;
        bVar.getClass();
        gc.c("ScanApi", "stopScan 1");
        if (bVar.f6819b) {
            bVar.f6819b = false;
            Iterator it = bVar.f6818a.iterator();
            while (it.hasNext()) {
                ((lc.b) it.next()).getClass();
                Intrinsics.checkNotNullParameter("BLEScanHelper", "tag");
                Intrinsics.checkNotNullParameter("stopScan", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("BLEScanHelper"), "stopScan");
                }
                Lazy lazy = mc.b.f7958a;
                com.welink.protocol.nfbd.y yVar = mc.b.e().f9655c;
                com.welink.protocol.nfbd.c0 c0Var = yVar.f4191c;
                if (c0Var != null) {
                    if (c0Var.f4091d != null) {
                        c0Var.f4091d = null;
                    }
                    com.welink.protocol.nfbd.z zVar2 = c0Var.f4090c;
                    if (zVar2 != null) {
                        Intent intent = new Intent();
                        intent.setAction("com.welink.protocol.nfbd.action.STOP_SCAN_DEVICE");
                        com.welink.protocol.nfbd.g gVar = zVar2.f4207i;
                        if (gVar != null) {
                            gVar.w(intent, 0);
                        }
                    }
                }
                q4 q4Var = yVar.f;
                if (q4Var != null) {
                    pe.f fVar = q4Var.f9950a;
                    if (fVar == null) {
                        we.h.j("SmartBluetoothManager", "stopBluetoothDiscovery failed, mBluetoothController is null or isDiscovering");
                    } else {
                        if (pe.f.f8814m) {
                            BluetoothAdapter bluetoothAdapter = pe.f.f8813l;
                            Intrinsics.checkNotNull(bluetoothAdapter);
                            zIsDiscovering2 = bluetoothAdapter.isDiscovering();
                        } else {
                            zIsDiscovering2 = false;
                        }
                        if (!zIsDiscovering2) {
                            we.h.j("SmartBluetoothManager", "stopBluetoothDiscovery failed, mBluetoothController is null or isDiscovering");
                        }
                    }
                    q4Var.f9951b = null;
                    q4Var.f9952c.remove(UInt.m248boximpl(4));
                    if (fVar != null && (z2 = pe.f.f8814m)) {
                        if (z2) {
                            try {
                                BluetoothAdapter bluetoothAdapter2 = pe.f.f8813l;
                                Intrinsics.checkNotNull(bluetoothAdapter2);
                                zIsDiscovering = bluetoothAdapter2.isDiscovering();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        } else {
                            zIsDiscovering = false;
                        }
                        if (zIsDiscovering) {
                            BluetoothAdapter bluetoothAdapter3 = pe.f.f8813l;
                            Intrinsics.checkNotNull(bluetoothAdapter3);
                            bluetoothAdapter3.cancelDiscovery();
                        }
                        fVar.h(fVar.f8819i);
                    }
                }
                b5 b5Var = yVar.f4192d;
                if (b5Var != null) {
                    we.h.g("Device stop search, state: " + b5Var.f9664d.get(UInt.m248boximpl(8)));
                    Integer num = (Integer) b5Var.f9664d.get(UInt.m248boximpl(8));
                    if (num != null && num.intValue() == 3) {
                        com.welink.protocol.nfbd.z zVar3 = b5Var.f9662b;
                        if (zVar3 != null) {
                            k6 k6Var = zVar3.e;
                            if (k6Var != null) {
                                synchronized (k6Var.f9846d) {
                                    k6Var.f9845c = null;
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                            Intent intent2 = new Intent();
                            intent2.setAction("com.welink.protocol.nfbd.action.STOP_SCAN_WIFI_DEVICE");
                            com.welink.protocol.nfbd.g gVar2 = zVar3.f4207i;
                            if (gVar2 != null) {
                                gVar2.w(intent2, 0);
                            }
                        }
                        b5Var.f9664d.put(UInt.m248boximpl(8), 2);
                        b5Var.e.put(UInt.m248boximpl(8), null);
                    }
                }
                y4 y4Var = yVar.e;
                if (y4Var != null && (zVar = y4Var.f10069a) != null) {
                    h5 h5Var = zVar.f4203c;
                    if (h5Var == null || h5Var.f9781l) {
                        com.welink.protocol.nfbd.m mVar = zVar.f4204d;
                        if (mVar != null) {
                            synchronized (mVar.f4171c) {
                                b6 b6Var = mVar.f;
                                if (b6Var != null) {
                                    synchronized (b6Var.f9668h) {
                                        b6Var.f = null;
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                        Intent intent3 = new Intent();
                        intent3.setAction("com.welink.protocol.nfbd.action.STOP_LAN_DISCOVERY");
                        com.welink.protocol.nfbd.g gVar3 = zVar.f4207i;
                        if (gVar3 != null) {
                            gVar3.w(intent3, 0);
                        }
                    } else {
                        we.h.j("TranConnectionManager", "LanDiscovery is not running");
                    }
                }
            }
        } else {
            gc.c("ScanApi", "scan is already stopped");
        }
        e = false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(ContinuationImpl continuationImpl) {
        l1 l1Var;
        if (continuationImpl instanceof l1) {
            l1Var = (l1) continuationImpl;
            int i8 = l1Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                l1Var.label = i8 - Integer.MIN_VALUE;
            } else {
                l1Var = new l1(this, continuationImpl);
            }
        } else {
            l1Var = new l1(this, continuationImpl);
        }
        Object obj = l1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = l1Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            gc.a("ScanManager", "startAdvertisement");
            li.g2 g2Var = f4785d;
            if (g2Var != null && g2Var.a()) {
                gc.a("ScanManager", "cancelAndJoin");
                li.g2 g2Var2 = f4785d;
                if (g2Var2 != null) {
                    l1Var.L$0 = this;
                    l1Var.label = 1;
                    g2Var2.h(null);
                    Object objS = g2Var2.S(l1Var);
                    if (objS != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        objS = Unit.INSTANCE;
                    }
                    if (objS == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        f4785d = li.l0.p(f4784c, null, null, new m1(null), 3);
        return Unit.INSTANCE;
    }
}
