package se;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.welink.protocol.nfbd.NearDevice;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.d f9852a;

    public l0(com.welink.protocol.nfbd.d dVar) {
        this.f9852a = dVar;
    }

    public final void a(BluetoothDevice device, int i8, int i9) {
        com.welink.protocol.nfbd.c cVar;
        com.welink.protocol.nfbd.f fVar;
        com.welink.protocol.nfbd.c cVar2;
        com.welink.protocol.nfbd.c cVar3;
        com.welink.protocol.nfbd.c cVar4;
        com.welink.protocol.nfbd.c cVar5;
        com.welink.protocol.nfbd.c cVar6;
        com.welink.protocol.nfbd.c cVar7;
        com.welink.protocol.nfbd.d dVar = this.f9852a;
        switch (i8) {
            case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                we.h.h("NearBluetoothManager", "onConnectionLost: REASON_CONNECTION_LOST");
                if (device == null) {
                    we.h.c("NearBluetoothManager", "onConnectionLost: device is null", null);
                } else if (i9 == 0) {
                    com.welink.protocol.nfbd.c cVar8 = dVar.f4093c;
                    if (cVar8 != null) {
                        cVar8.r(device, DeviceType.INFRARED_TV_BOX, i8);
                    }
                } else if (i9 == 1) {
                    com.welink.protocol.nfbd.f fVar2 = dVar.f4094d;
                    if (fVar2 != null) {
                        Intrinsics.checkNotNullParameter(device, "device");
                        fVar2.i(fVar2.e(8193, DeviceType.INFRARED_TV_BOX, i8, device));
                    }
                } else {
                    we.h.c("NearBluetoothManager", "notifyConnectedState: unknown mode", null);
                }
                break;
            case PointerIconCompat.TYPE_HAND /* 1002 */:
                Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                Intrinsics.checkNotNullParameter("onConnectionLost: REASON_REMOTE_DEVICE_DISCONNECTED", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothManager", "TransConnect:onConnectionLost: REASON_REMOTE_DEVICE_DISCONNECTED", null);
                }
                if (i9 != 0) {
                    if (i9 != 1) {
                        Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                        Intrinsics.checkNotNullParameter("notifyConnectedState: unknown mode", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearBluetoothManager", "TransConnect:notifyConnectedState: unknown mode", null);
                        }
                        break;
                    } else if (device != null && (fVar = dVar.f4094d) != null) {
                        Intrinsics.checkNotNullParameter(device, "device");
                        fVar.i(fVar.e(8193, DeviceType.INFRARED_TV_BOX, i8, device));
                        break;
                    }
                } else if (device != null && (cVar = dVar.f4093c) != null) {
                    cVar.r(device, DeviceType.INFRARED_TV_BOX, i8);
                    break;
                }
                break;
            case PointerIconCompat.TYPE_HELP /* 1003 */:
                String mes = "onConnectionLost: REASON_TIMEOUT, mode: ".concat(com.welink.protocol.nfbd.d.j(dVar, i9));
                Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes, "NearBluetoothManager", null);
                }
                if (i9 != 0) {
                    if (i9 != 1) {
                        Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                        Intrinsics.checkNotNullParameter("notifyConnectedState: unknown mode", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearBluetoothManager", "TransConnect:notifyConnectedState: unknown mode", null);
                        }
                        break;
                    } else if (device != null && (cVar3 = dVar.f4093c) != null) {
                        cVar3.r(device, DeviceType.INFRARED_TV_BOX, i8);
                        break;
                    }
                } else if (device != null && (cVar2 = dVar.f4093c) != null) {
                    cVar2.r(device, DeviceType.INFRARED_TV_BOX, i8);
                    break;
                }
                break;
            case PointerIconCompat.TYPE_WAIT /* 1004 */:
                Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                Intrinsics.checkNotNullParameter("onConnectionLost: REASON_SOCKET_NOT_FOUND", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothManager", "TransConnect:onConnectionLost: REASON_SOCKET_NOT_FOUND", null);
                }
                if (i9 != 0) {
                    if (i9 != 1) {
                        Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                        Intrinsics.checkNotNullParameter("notifyConnectedState: unknown mode", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearBluetoothManager", "TransConnect:notifyConnectedState: unknown mode", null);
                        }
                        break;
                    } else if (device != null && (cVar5 = dVar.f4093c) != null) {
                        cVar5.r(device, DeviceType.INFRARED_TV_BOX, i8);
                        break;
                    }
                } else if (device != null && (cVar4 = dVar.f4093c) != null) {
                    cVar4.r(device, DeviceType.INFRARED_TV_BOX, i8);
                    break;
                }
                break;
            case 1005:
                Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                Intrinsics.checkNotNullParameter("onConnectionLost: REASON_SERVER_SOCKET_NOT_FOUND", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothManager", "TransConnect:onConnectionLost: REASON_SERVER_SOCKET_NOT_FOUND", null);
                }
                if (i9 != 0) {
                    if (i9 != 1) {
                        Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                        Intrinsics.checkNotNullParameter("notifyConnectedState: unknown mode", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearBluetoothManager", "TransConnect:notifyConnectedState: unknown mode", null);
                        }
                        break;
                    } else if (device != null && (cVar7 = dVar.f4093c) != null) {
                        g0 g0Var = com.welink.protocol.nfbd.c.f4072v;
                        cVar7.r(device, DeviceType.INFRARED_TV_BOX, 0);
                        break;
                    }
                } else if (device != null && (cVar6 = dVar.f4093c) != null) {
                    g0 g0Var2 = com.welink.protocol.nfbd.c.f4072v;
                    cVar6.r(device, DeviceType.INFRARED_TV_BOX, 0);
                    break;
                }
                break;
            default:
                we.h.j("NearBluetoothManager", "onConnectionLost: UNKNOWN");
                break;
        }
    }

    public final void b(BluetoothDevice device, int i8, int i9) {
        com.welink.protocol.nfbd.d dVar = this.f9852a;
        if (i8 != 0) {
            switch (i8) {
                case 101:
                    we.h.b("NearBluetoothManager", "onConnectionStateChanged: STATE_CONNECTING,  device:" + device + ", name: " + (device != null ? device.getName() : null));
                    break;
                case 102:
                    String strJ = com.welink.protocol.nfbd.d.j(dVar, i9);
                    we.h.b("NearBluetoothManager", "onConnectionStateChanged: STATE_CONNECTED,  device: " + device + ", name: " + (device != null ? device.getName() : null) + ", mode: " + strJ);
                    break;
                case DeviceType.INFRARED_TV_BOX /* 103 */:
                    we.h.h("NearBluetoothManager", "onConnectionStateChanged: STATE_DISCONNECTED, device: " + device + ", name: " + (device != null ? device.getName() : null));
                    break;
                case 104:
                    we.h.b("NearBluetoothManager", "onConnectionStateChanged: STATE_LISTEN");
                    break;
                default:
                    we.h.b("NearBluetoothManager", "onConnectionStateChanged: UNKNOWN");
                    break;
            }
        } else {
            we.h.b("NearBluetoothManager", "onConnectionStateChanged: STATE_NONE");
        }
        if (device != null) {
            if (i9 == 0) {
                com.welink.protocol.nfbd.c cVar = dVar.f4093c;
                if (cVar != null) {
                    g0 g0Var = com.welink.protocol.nfbd.c.f4072v;
                    cVar.r(device, i8, 0);
                    return;
                }
                return;
            }
            if (i9 != 1) {
                Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                Intrinsics.checkNotNullParameter("notifyConnectedState: unknown mode", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothManager", "TransConnect:notifyConnectedState: unknown mode", null);
                    return;
                }
                return;
            }
            com.welink.protocol.nfbd.f fVar = dVar.f4094d;
            if (fVar != null) {
                g0 g0Var2 = com.welink.protocol.nfbd.f.f4099r;
                Intrinsics.checkNotNullParameter(device, "device");
                fVar.i(fVar.e(8193, i8, 0, device));
            }
        }
    }

    public final void c(BluetoothDevice device, byte[] bArr, int i8, int i9) {
        if (device == null) {
            Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
            Intrinsics.checkNotNullParameter("onMessageReceived: device is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothManager", "TransConnect:onMessageReceived: device is null", null);
                return;
            }
            return;
        }
        com.welink.protocol.nfbd.d dVar = this.f9852a;
        if (i9 == 0) {
            com.welink.protocol.nfbd.c cVar = dVar.f4093c;
            if (cVar != null) {
                Intrinsics.checkNotNullParameter(device, "device");
                if (cVar.o(device.getAddress()) == null) {
                    Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                    Intrinsics.checkNotNullParameter("notifyMessageReceived, nearDevice is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothClient", "TransConnect:notifyMessageReceived, nearDevice is null", null);
                        return;
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putByteArray("receiveData", bArr);
                bundle.putParcelable("device", device);
                Message messageObtainMessage = cVar.a().obtainMessage(6405, Integer.valueOf(i8));
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
                messageObtainMessage.setData(bundle);
                cVar.i(messageObtainMessage);
                return;
            }
            return;
        }
        if (i9 != 1) {
            String mes = "onMessageReceived: unknown ".concat(com.welink.protocol.nfbd.d.j(dVar, i9));
            Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes, "NearBluetoothManager", null);
                return;
            }
            return;
        }
        com.welink.protocol.nfbd.f fVar = dVar.f4094d;
        if (fVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (!fVar.f4109n.contains(device)) {
                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                Intrinsics.checkNotNullParameter("notifyMessageReceived, nearDevice is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothServer", "TransConnect:notifyMessageReceived, nearDevice is null", null);
                    return;
                }
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putByteArray("receiveData", bArr);
            bundle2.putParcelable("device", device);
            Message messageObtainMessage2 = fVar.a().obtainMessage(8195, Integer.valueOf(i8));
            Intrinsics.checkNotNullExpressionValue(messageObtainMessage2, "obtainMessage(...)");
            messageObtainMessage2.setData(bundle2);
            fVar.i(messageObtainMessage2);
        }
    }

    public final void d(BluetoothDevice bluetoothDevice, int i8, int i9) {
        if (bluetoothDevice != null) {
            com.welink.protocol.nfbd.d dVar = this.f9852a;
            if (i9 == 0) {
                com.welink.protocol.nfbd.c cVar = dVar.f4093c;
                if (cVar == null || cVar.o(bluetoothDevice.getAddress()) == null) {
                    return;
                }
                Message messageObtainMessage = cVar.a().obtainMessage(6404, i8, 0);
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
                cVar.i(messageObtainMessage);
                return;
            }
            if (i9 != 1) {
                Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
                Intrinsics.checkNotNullParameter("onMessageSent: unknown mode", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothManager", "TransConnect:onMessageSent: unknown mode", null);
                    return;
                }
                return;
            }
            com.welink.protocol.nfbd.f fVar = dVar.f4094d;
            if (fVar != null) {
                if (((NearDevice) fVar.f4108m.get(bluetoothDevice.getAddress())) != null) {
                    Message messageObtainMessage2 = fVar.a().obtainMessage(8194, i8, 0);
                    Intrinsics.checkNotNullExpressionValue(messageObtainMessage2, "obtainMessage(...)");
                    fVar.i(messageObtainMessage2);
                }
            }
        }
    }
}
