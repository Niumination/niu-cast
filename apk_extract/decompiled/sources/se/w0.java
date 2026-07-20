package se;

import android.content.Intent;
import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import k3.gc;
import k3.lb;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f10042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NearDevice f10043c;

    public /* synthetic */ w0(z0 z0Var, NearDevice nearDevice, int i8) {
        this.f10041a = 0;
        this.f10042b = z0Var;
        this.f10043c = nearDevice;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:56:0x0101  */
    /* JADX WARN: Code duplicated, block: B:57:0x0103  */
    /* JADX WARN: Code duplicated, block: B:58:0x0105  */
    /* JADX WARN: Code duplicated, block: B:65:0x011a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0147  */
    /* JADX WARN: Code duplicated, block: B:77:0x015b  */
    /* JADX WARN: Code duplicated, block: B:78:0x015f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0173  */
    @Override // java.lang.Runnable
    public final void run() {
        lc.a aVar;
        int i8;
        com.welink.protocol.nfbd.c0 c0Var;
        com.welink.protocol.nfbd.z zVar;
        com.welink.protocol.nfbd.g gVar;
        Intent intent;
        Intent intent2;
        NearDevice device = this.f10043c;
        z0 z0Var = this.f10042b;
        switch (this.f10041a) {
            case 0:
                z0Var.f10076b.getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                break;
            case 1:
                q5.a aVar2 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                String strN = o.d.n("onNearConnectRequest: ", device.D(), "TranConnectManager", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TranConnectManager"), strN);
                }
                break;
            case 2:
                q5.a aVar3 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                String strN2 = o.d.n("onNearDeviceLost: ", device.D(), "TranConnectManager", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), strN2);
                }
                if (device.f3885c != null && (aVar = mc.b.f7960c) != null) {
                    aVar.invoke(device, Boolean.TRUE);
                    break;
                }
                break;
            case 3:
                q5.a aVar4 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                String strN3 = o.d.n("onNearDeviceFlushed: ", device.f3884b, "TranConnectManager", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), strN3);
                }
                break;
            case 4:
                q5.a aVar5 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                String strN4 = o.d.n("onNearDeviceUpdated: ", device.D(), "TranConnectManager", "tag", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), strN4);
                }
                mc.b.a(device);
                break;
            case 5:
                q5.a aVar6 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                mc.b.a(device);
                break;
            case 6:
                q5.a aVar7 = z0Var.f10076b;
                Intrinsics.checkNotNullParameter(device, "device");
                mc.b.f7967l.set(true);
                mc.b.f7959b = device;
                Lazy lazy = mc.b.f7958a;
                NearDevice nearDevice = mc.b.f7959b;
                if (nearDevice != null) {
                    String log = "acceptRemoteRequest>" + nearDevice;
                    Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("TranConnectManager"), log);
                    }
                    b1 b1VarE = mc.b.e();
                    Integer num = b1VarE.f9654b.contains(nearDevice) ? nearDevice.f3898v : -1;
                    if (num != null && num.intValue() == 1003) {
                        com.welink.protocol.nfbd.y yVar = b1VarE.f9655c;
                        if (yVar.f4196j.contains(nearDevice) || yVar.f4197k.contains(nearDevice)) {
                            int i9 = nearDevice.e;
                            if (i9 != 0 && i9 != 1 && i9 != 4 && i9 != 5 && i9 != 8 && i9 != 251) {
                                switch (i9) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        if (i9 != 0) {
                                            i8 = 0;
                                        } else if (i9 != 1) {
                                            i8 = 1;
                                        } else if (i9 != 4) {
                                            i8 = 4;
                                        } else if (i9 != 5) {
                                            i8 = 5;
                                        } else if (i9 != 8) {
                                            i8 = 8;
                                        } else if (i9 != 251) {
                                            switch (i9) {
                                                case 10:
                                                    i8 = 10;
                                                    break;
                                                case 11:
                                                    i8 = 11;
                                                    break;
                                                case 12:
                                                    i8 = 12;
                                                    break;
                                                case 13:
                                                    i8 = 13;
                                                    break;
                                                default:
                                                    i8 = 14;
                                                    break;
                                            }
                                        } else {
                                            i8 = 251;
                                        }
                                        c0Var = yVar.f4191c;
                                        if (c0Var != null) {
                                            gVar = zVar.f4207i;
                                            if (i8 != 0) {
                                                intent = new Intent();
                                                intent.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                                intent.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                                intent.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                                if (gVar != null) {
                                                    gVar.w(intent, i8);
                                                }
                                            } else if (i8 == 1) {
                                                intent2 = new Intent();
                                                intent2.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                                intent2.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                                intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                                intent2.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                                if (gVar != null) {
                                                    gVar.w(intent2, i8);
                                                }
                                            } else {
                                                intent2 = new Intent();
                                                intent2.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                                intent2.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                                intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                                intent2.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                                if (gVar != null) {
                                                    gVar.w(intent2, i8);
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        we.h.b("SmartConnectWrapper", "Not implemented yet");
                                        break;
                                }
                            } else {
                                if (i9 != 0) {
                                    i8 = 0;
                                } else if (i9 != 1) {
                                    i8 = 1;
                                } else if (i9 != 4) {
                                    i8 = 4;
                                } else if (i9 != 5) {
                                    i8 = 5;
                                } else if (i9 != 8) {
                                    i8 = 8;
                                } else if (i9 != 251) {
                                    switch (i9) {
                                        case 10:
                                            i8 = 10;
                                            break;
                                        case 11:
                                            i8 = 11;
                                            break;
                                        case 12:
                                            i8 = 12;
                                            break;
                                        case 13:
                                            i8 = 13;
                                            break;
                                        default:
                                            i8 = 14;
                                            break;
                                    }
                                } else {
                                    i8 = 251;
                                }
                                c0Var = yVar.f4191c;
                                if (c0Var != null && (zVar = c0Var.f4090c) != null) {
                                    gVar = zVar.f4207i;
                                    if (i8 != 0) {
                                        intent = new Intent();
                                        intent.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                        intent.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                        intent.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                        if (gVar != null) {
                                            gVar.w(intent, i8);
                                        }
                                    } else if (i8 == 1 || i8 == 4 || i8 == 5 || i8 == 8) {
                                        intent2 = new Intent();
                                        intent2.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                        intent2.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                        intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                        intent2.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                        if (gVar != null) {
                                            gVar.w(intent2, i8);
                                        }
                                    } else if (i8 != 251) {
                                        switch (i8) {
                                            case 10:
                                            case 11:
                                            case 12:
                                            case 13:
                                                intent2 = new Intent();
                                                intent2.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                                intent2.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                                intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                                intent2.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                                if (gVar != null) {
                                                    gVar.w(intent2, i8);
                                                }
                                                break;
                                            default:
                                                we.h.h("TranConnectionManager", "TranConnectionManager: onAcceptRequest: unknown scenario");
                                                break;
                                        }
                                    } else {
                                        Intent intent3 = new Intent();
                                        intent3.setAction("com.welink.protocol.nfbd.action.RECEIVE_FILE_ACCEPT");
                                        intent3.putExtra("com.welink.protocol.nfbd.extra.scenario", i8);
                                        intent3.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
                                        intent3.putExtra("com.welink.protocol.nfbd.extra.isTrust", false);
                                        if (gVar != null) {
                                            gVar.w(intent3, i8);
                                        }
                                    }
                                }
                            }
                        } else {
                            Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                            Intrinsics.checkNotNullParameter("Not found any device in list", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("SmartConnectWrapper", "TransConnect:Not found any device in list", null);
                            }
                        }
                    } else {
                        String mes = "acceptRemoteRequest: device is not connecting: " + num;
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("welinkBLE", mes, null);
                        }
                    }
                }
                String log2 = "onNearDeviceInvitation: " + device.f3884b + ", " + mc.b.f7964i;
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TranConnectManager"), log2);
                }
                ag.b bVar = mc.b.f7964i;
                if (bVar != null) {
                    bVar.invoke(device);
                }
                break;
            case 7:
                z0Var.f10076b.getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                break;
            default:
                z0Var.f10076b.getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                break;
        }
    }

    public /* synthetic */ w0(z0 z0Var, NearDevice nearDevice, int i8, byte b9) {
        this.f10041a = i8;
        this.f10042b = z0Var;
        this.f10043c = nearDevice;
    }

    public /* synthetic */ w0(z0 z0Var, NearDevice nearDevice, boolean z2) {
        this.f10041a = 8;
        this.f10042b = z0Var;
        this.f10043c = nearDevice;
    }
}
