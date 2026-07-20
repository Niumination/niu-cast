package a0;

import ag.q;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.le.ScanResult;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.util.Log;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.ShaderProvider;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.MediatorLiveData;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.nfbd.NearNetworkElement;
import com.welink.protocol.nfbd.WirelessDevice;
import com.welink.protocol.nfbd.b0;
import com.welink.protocol.nfbd.j;
import com.welink.protocol.nfbd.l;
import com.welink.protocol.nfbd.y;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.lb;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import m3.r6;
import se.b4;
import se.b5;
import se.f1;
import se.h4;
import se.i2;
import se.j1;
import se.p6;
import se.s1;
import se.t1;
import se.t4;
import se.z0;
import we.m;
import zj.k;
import zj.o0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f22c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f23d;

    public /* synthetic */ g(l lVar, BluetoothDevice bluetoothDevice, int i8, byte[] bArr) {
        this.f20a = 11;
        this.f21b = lVar;
        this.f22c = bluetoothDevice;
        this.f23d = bArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:177:0x0351  */
    /* JADX WARN: Code duplicated, block: B:178:0x035a  */
    /* JADX WARN: Code duplicated, block: B:180:0x0360  */
    /* JADX WARN: Code duplicated, block: B:181:0x0369  */
    /* JADX WARN: Code duplicated, block: B:183:0x036d  */
    /* JADX WARN: Code duplicated, block: B:186:0x0373  */
    /* JADX WARN: Code duplicated, block: B:188:0x0376  */
    /* JADX WARN: Code duplicated, block: B:190:0x0385  */
    /* JADX WARN: Code duplicated, block: B:212:0x040a A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:214:0x040c A[Catch: all -> 0x03b2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x03b2, blocks: (B:194:0x039d, B:195:0x03a9, B:196:0x03ac, B:197:0x03b1, B:200:0x03b5, B:201:0x03cb, B:214:0x040c, B:203:0x03e2, B:204:0x03ed, B:206:0x03f3, B:210:0x0405), top: B:463:0x039d }] */
    /* JADX WARN: Code duplicated, block: B:218:0x0412  */
    /* JADX WARN: Code duplicated, block: B:220:0x0439  */
    /* JADX WARN: Code duplicated, block: B:225:0x0448  */
    /* JADX WARN: Code duplicated, block: B:227:0x045f  */
    /* JADX WARN: Code duplicated, block: B:229:0x0473  */
    /* JADX WARN: Code duplicated, block: B:234:0x0483  */
    /* JADX WARN: Code duplicated, block: B:235:0x0492  */
    /* JADX WARN: Code duplicated, block: B:236:0x049a  */
    /* JADX WARN: Code duplicated, block: B:410:0x0889  */
    /* JADX WARN: Code duplicated, block: B:412:0x0890  */
    /* JADX WARN: Code duplicated, block: B:414:0x0896  */
    /* JADX WARN: Code duplicated, block: B:415:0x08a1  */
    /* JADX WARN: Code duplicated, block: B:417:0x08a7  */
    /* JADX WARN: Code duplicated, block: B:419:0x08aa  */
    /* JADX WARN: Code duplicated, block: B:442:0x0914  */
    /* JADX WARN: Code duplicated, block: B:444:0x091b  */
    /* JADX WARN: Code duplicated, block: B:446:0x0921  */
    /* JADX WARN: Code duplicated, block: B:447:0x092c  */
    /* JADX WARN: Code duplicated, block: B:449:0x0932  */
    /* JADX WARN: Code duplicated, block: B:451:0x0935  */
    /* JADX WARN: Code duplicated, block: B:504:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:520:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:523:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0121  */
    /* JADX WARN: Code duplicated, block: B:71:0x0172  */
    /* JADX WARN: Code duplicated, block: B:82:0x0195  */
    @Override // java.lang.Runnable
    public final void run() {
        int i8;
        i2 i2Var;
        h4 h4Var;
        int i9;
        int i10;
        i2 i2Var2;
        h4 h4Var2;
        int i11;
        q qVar;
        int i12;
        int i13;
        int iD;
        int i14;
        int i15;
        int iD2;
        Object next;
        Object next2;
        boolean z2;
        List listJ;
        NearDeviceExtension nearDeviceExtension;
        boolean z3;
        Object next3;
        NearDevice nearDevice;
        NearDevice nearDevice2;
        String address;
        WirelessDevice device;
        NearDeviceExtension nearDeviceExtension2;
        WifiInfo wifiInfo;
        int i16;
        int i17;
        int iM254constructorimpl = 2;
        switch (this.f20a) {
            case 0:
                ((EncoderImpl) this.f21b).lambda$stopMediaCodec$11((ArrayList) this.f22c, (Runnable) this.f23d);
                return;
            case 1:
                ((Camera2CameraControlImpl) this.f21b).lambda$addSessionCameraCaptureCallback$8((Executor) this.f22c, (CameraCaptureCallback) this.f23d);
                return;
            case 2:
                ((ImageCapture) this.f21b).lambda$takePicture$2((Executor) this.f22c, (ImageCapture.OnImageCapturedCallback) this.f23d);
                return;
            case 3:
                ((Preview) this.f21b).lambda$createPipelineWithNode$0((SurfaceEdge) this.f22c, (CameraInternal) this.f23d);
                return;
            case 4:
                int i18 = CastControlDialog.f2710n;
                ((MediatorLiveData) this.f21b).setValue(TuplesKt.to(Boolean.valueOf(((Ref.BooleanRef) this.f22c).element), Boolean.valueOf(((Ref.BooleanRef) this.f23d).element)));
                return;
            case 5:
                ConnectRequest connectRequest = (ConnectRequest) this.f21b;
                if (connectRequest != null) {
                    com.welink.protocol.nfbd.c cVar = (com.welink.protocol.nfbd.c) this.f22c;
                    cVar.getClass();
                    int iD3 = connectRequest.f3871m;
                    int i19 = connectRequest.f3872n;
                    if (iD3 > 0 || i19 <= 0) {
                        if (iD3 <= 0 && i19 <= 0) {
                            i8 = 0;
                        }
                        i2Var = new i2(connectRequest.f3868j, connectRequest.f3869k, i8, connectRequest.f3870l, connectRequest.f3873o, connectRequest.p, (NearDevice) this.f23d, i19);
                        cVar.f4082n = i2Var;
                        cVar.t();
                        h4Var = cVar.f4073c;
                        if (h4Var != null) {
                            i9 = 1;
                            if (h4Var.q()) {
                                if (h4Var.r()) {
                                    we.h.h("NearBluetoothClient", "P2p GC connect over group client recover directly");
                                    h4Var.n(i2Var, 1);
                                } else {
                                    h4Var.n(i2Var, 1);
                                }
                                cVar.e = true;
                                return;
                            }
                        } else {
                            i9 = 1;
                        }
                        if (h4Var != null) {
                            h4Var.m(i2Var, i9);
                            return;
                        }
                        return;
                    }
                    if (2412 <= i19 && i19 < 2485) {
                        iD3 = a1.a.d(i19, 2412, 5, 1);
                    } else if (5180 > i19 || i19 >= 5886) {
                        iD3 = (5955 > i19 || i19 >= 7116) ? 0 : a1.a.d(i19, 5955, 5, 1);
                    } else {
                        iD3 = a1.a.d(i19, 5180, 5, 36);
                    }
                    i8 = iD3;
                    i2Var = new i2(connectRequest.f3868j, connectRequest.f3869k, i8, connectRequest.f3870l, connectRequest.f3873o, connectRequest.p, (NearDevice) this.f23d, i19);
                    cVar.f4082n = i2Var;
                    cVar.t();
                    h4Var = cVar.f4073c;
                    if (h4Var != null) {
                        i9 = 1;
                        if (h4Var.q()) {
                            if (h4Var.r()) {
                                we.h.h("NearBluetoothClient", "P2p GC connect over group client recover directly");
                                h4Var.n(i2Var, 1);
                            } else {
                                h4Var.n(i2Var, 1);
                            }
                            cVar.e = true;
                            return;
                        }
                    } else {
                        i9 = 1;
                    }
                    if (h4Var != null) {
                        h4Var.m(i2Var, i9);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                ConnectRequest connectRequest2 = (ConnectRequest) this.f21b;
                if (connectRequest2 != null) {
                    com.welink.protocol.nfbd.f fVar = (com.welink.protocol.nfbd.f) this.f22c;
                    fVar.getClass();
                    int iD4 = connectRequest2.f3871m;
                    int i20 = connectRequest2.f3872n;
                    if (iD4 > 0 || i20 <= 0) {
                        if (iD4 <= 0 && i20 <= 0) {
                            i10 = 0;
                        }
                        i2Var2 = new i2(connectRequest2.f3868j, connectRequest2.f3869k, i10, connectRequest2.f3870l, connectRequest2.f3873o, connectRequest2.p, (NearDevice) this.f23d, i20);
                        fVar.f4107l = i2Var2;
                        fVar.q();
                        h4Var2 = fVar.f4100c;
                        if (h4Var2 != null) {
                            i11 = 1;
                            if (h4Var2.q()) {
                                if (h4Var2.r()) {
                                    we.h.h("NearBluetoothServer", "P2p GC connect over group client recover directly");
                                    h4Var2.n(i2Var2, 1);
                                } else {
                                    h4Var2.n(i2Var2, 1);
                                }
                                fVar.f4110o = true;
                                return;
                            }
                        } else {
                            i11 = 1;
                        }
                        if (h4Var2 != null) {
                            h4Var2.m(i2Var2, i11);
                            return;
                        }
                        return;
                    }
                    if (2412 <= i20 && i20 < 2485) {
                        iD4 = a1.a.d(i20, 2412, 5, 1);
                    } else if (5180 > i20 || i20 >= 5886) {
                        iD4 = (5955 > i20 || i20 >= 7116) ? 0 : a1.a.d(i20, 5955, 5, 1);
                    } else {
                        iD4 = a1.a.d(i20, 5180, 5, 36);
                    }
                    i10 = iD4;
                    i2Var2 = new i2(connectRequest2.f3868j, connectRequest2.f3869k, i10, connectRequest2.f3870l, connectRequest2.f3873o, connectRequest2.p, (NearDevice) this.f23d, i20);
                    fVar.f4107l = i2Var2;
                    fVar.q();
                    h4Var2 = fVar.f4100c;
                    if (h4Var2 != null) {
                        i11 = 1;
                        if (h4Var2.q()) {
                            if (h4Var2.r()) {
                                we.h.h("NearBluetoothServer", "P2p GC connect over group client recover directly");
                                h4Var2.n(i2Var2, 1);
                            } else {
                                h4Var2.n(i2Var2, 1);
                            }
                            fVar.f4110o = true;
                            return;
                        }
                    } else {
                        i11 = 1;
                    }
                    if (h4Var2 != null) {
                        h4Var2.m(i2Var2, i11);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                q5.a aVar = ((z0) this.f21b).f10076b;
                WifiP2pGroup wifiP2pGroup = (WifiP2pGroup) this.f22c;
                Intrinsics.checkNotNullParameter(wifiP2pGroup, "wifiP2pGroup");
                WifiP2pInfo WifiP2pInfo = (WifiP2pInfo) this.f23d;
                Intrinsics.checkNotNullParameter(WifiP2pInfo, "WifiP2pInfo");
                gc.a("TranConnectManager", "onNearP2pOtherDeviceConnected: " + wifiP2pGroup + ", " + WifiP2pInfo);
                Lazy lazy = mc.b.f7958a;
                gc.a("TranConnectManager", "onNearP2pOtherDeviceConnected: null");
                return;
            case 8:
                q5.a aVar2 = ((z0) this.f21b).f10076b;
                NearDevice device2 = (NearDevice) this.f22c;
                Intrinsics.checkNotNullParameter(device2, "device");
                String str = device2.f3884b;
                Function2 function2 = mc.b.f7961d;
                q qVar2 = mc.b.f7962g;
                StringBuilder sb2 = new StringBuilder("onNearDeviceConnected: ");
                sb2.append(str);
                sb2.append(", connectCallback:");
                sb2.append(function2);
                sb2.append(", pcConnectCallback:");
                sb2.append(qVar2);
                sb2.append(", ");
                NearNetworkElement.Wifi wifi = (NearNetworkElement.Wifi) this.f23d;
                sb2.append(wifi);
                gc.c("TranConnectManager", sb2.toString());
                mc.b.f7966k = wifi;
                mc.b.f7959b = device2;
                if (mc.b.f7967l.get()) {
                    gc.c("TranConnectManager", "isPcRequestConn:true");
                    q qVar3 = mc.b.f7962g;
                    if (qVar3 != null) {
                        qVar3.invoke(device2, wifi);
                    }
                    Lazy lazy2 = mc.b.f7958a;
                    mc.b.f();
                    return;
                }
                Function2 function3 = mc.b.f7961d;
                if (function3 != null) {
                    function3.invoke(device2, wifi);
                }
                if (mc.b.f7961d == null && (qVar = mc.b.f7962g) != null) {
                    qVar.invoke(device2, wifi);
                }
                Lazy lazy3 = mc.b.f7958a;
                mc.b.f();
                mc.b.f7969n = false;
                return;
            case 9:
                j jVar = (j) this.f21b;
                jVar.getClass();
                BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) this.f23d;
                BluetoothGatt bluetoothGatt = (BluetoothGatt) this.f22c;
                jVar.f4142m.put(bluetoothGatt.getDevice().getAddress(), MapsKt.mutableMapOf(new Pair(bluetoothGatt, bluetoothGattCharacteristic)));
                jVar.f4143n.put(bluetoothGatt.getDevice().getAddress(), MapsKt.mutableMapOf(new Pair(bluetoothGatt, null)));
                i2 i2Var3 = new i2(0, jVar.n(bluetoothGatt.getDevice().getAddress()), null, null, null);
                jVar.s();
                h4 h4Var3 = jVar.f4146s;
                if (h4Var3 == null || !h4Var3.q()) {
                    h4 h4Var4 = jVar.f4146s;
                    if (h4Var4 != null) {
                        h4Var4.m(i2Var3, 2);
                        return;
                    }
                    return;
                }
                h4 h4Var5 = jVar.f4146s;
                if (h4Var5 == null || !h4Var5.r()) {
                    h4 h4Var6 = jVar.f4146s;
                    if (h4Var6 != null) {
                        h4Var6.n(i2Var3, 2);
                    }
                } else {
                    we.h.h("NearGattClient", "P2p GO connect over group client recover directly");
                    h4 h4Var7 = jVar.f4146s;
                    if (h4Var7 != null) {
                        h4Var7.n(i2Var3, 2);
                    }
                }
                jVar.f4147t = true;
                return;
            case 10:
                ConnectRequest connectRequest3 = (ConnectRequest) this.f21b;
                if (connectRequest3 != null) {
                    j jVar2 = (j) this.f22c;
                    jVar2.getClass();
                    int i21 = connectRequest3.f3871m;
                    int i22 = connectRequest3.f3872n;
                    if (i21 > 0 || i22 <= 0) {
                        i12 = (i21 > 0 || i22 > 0) ? i21 : 0;
                    } else {
                        if (2412 <= i22 && i22 < 2485) {
                            iD = a1.a.d(i22, 2412, 5, 1);
                        } else if (5180 > i22 || i22 >= 5886) {
                            iD = (5955 > i22 || i22 >= 7116) ? 0 : a1.a.d(i22, 5955, 5, 1);
                        } else {
                            iD = a1.a.d(i22, 5180, 5, 36);
                        }
                        i12 = iD;
                    }
                    i2 i2Var4 = new i2(connectRequest3.f3868j, connectRequest3.f3869k, i12, connectRequest3.f3870l, connectRequest3.f3873o, connectRequest3.p, (NearDevice) this.f23d, i22);
                    jVar2.f4139j = i2Var4;
                    jVar2.s();
                    h4 h4Var8 = jVar2.f4146s;
                    if (h4Var8 != null) {
                        i13 = 1;
                        if (h4Var8.q()) {
                            h4 h4Var9 = jVar2.f4146s;
                            if (h4Var9 == null || !h4Var9.r()) {
                                h4 h4Var10 = jVar2.f4146s;
                                if (h4Var10 != null) {
                                    h4Var10.n(i2Var4, 1);
                                }
                            } else {
                                we.h.h("NearGattClient", "P2p GC connect over group client recover directly");
                                h4 h4Var11 = jVar2.f4146s;
                                if (h4Var11 != null) {
                                    h4Var11.n(i2Var4, 1);
                                }
                            }
                            jVar2.f4147t = true;
                            return;
                        }
                    } else {
                        i13 = 1;
                    }
                    h4 h4Var12 = jVar2.f4146s;
                    if (h4Var12 != null) {
                        h4Var12.m(i2Var4, i13);
                        return;
                    }
                    return;
                }
                return;
            case 11:
                ((l) this.f21b).o((BluetoothDevice) this.f22c, (byte[]) this.f23d);
                return;
            case 12:
                ConnectRequest connectRequest4 = (ConnectRequest) this.f21b;
                if (connectRequest4 != null) {
                    l lVar = (l) this.f22c;
                    lVar.getClass();
                    int i23 = connectRequest4.f3871m;
                    int i24 = connectRequest4.f3872n;
                    if (i23 > 0 || i24 <= 0) {
                        i14 = (i23 > 0 || i24 > 0) ? i23 : 0;
                    } else {
                        if (2412 <= i24 && i24 < 2485) {
                            iD2 = a1.a.d(i24, 2412, 5, 1);
                        } else if (5180 > i24 || i24 >= 5886) {
                            iD2 = (5955 > i24 || i24 >= 7116) ? 0 : a1.a.d(i24, 5955, 5, 1);
                        } else {
                            iD2 = a1.a.d(i24, 5180, 5, 36);
                        }
                        i14 = iD2;
                    }
                    i2 i2Var5 = new i2(connectRequest4.f3868j, connectRequest4.f3869k, i14, connectRequest4.f3870l, connectRequest4.f3873o, connectRequest4.p, (NearDevice) this.f23d, i24);
                    lVar.f4162r = i2Var5;
                    lVar.r();
                    h4 h4Var13 = lVar.f4164t;
                    if (h4Var13 != null) {
                        i15 = 1;
                        if (h4Var13.q()) {
                            h4 h4Var14 = lVar.f4164t;
                            if (h4Var14 == null || !h4Var14.r()) {
                                h4 h4Var15 = lVar.f4164t;
                                if (h4Var15 != null) {
                                    h4Var15.n(i2Var5, 1);
                                }
                            } else {
                                we.h.h("NearGattService", "P2p GC connect over group client recover directly");
                                h4 h4Var16 = lVar.f4164t;
                                if (h4Var16 != null) {
                                    h4Var16.n(i2Var5, 1);
                                }
                            }
                            lVar.u = true;
                            return;
                        }
                    } else {
                        i15 = 1;
                    }
                    h4 h4Var17 = lVar.f4164t;
                    if (h4Var17 != null) {
                        h4Var17.m(i2Var5, i15);
                        return;
                    }
                    return;
                }
                return;
            case 13:
                ((f1) ((Pair) this.f21b).getSecond()).b((LanNetworkInfo) this.f22c, (NearDevice) this.f23d);
                return;
            case 14:
                ((f1) ((Pair) this.f21b).getSecond()).a((LanNetworkInfo) this.f22c, (ConnectRequest) this.f23d);
                return;
            case 15:
                we.h.c("NearP2pManager", "recordP2pGroupOwner remove", null);
                h4 h4Var18 = (h4) this.f21b;
                if (h4Var18.f9765h instanceof p6) {
                    we.h.j("NearP2pManager", "recordP2pGroupOwner, mP2pGroupOwnerConnectionState is TransConnectP2pDisconnectedState already, ignore it");
                } else {
                    we.h.j("NearP2pManager", "recordP2pGroupOwner, because mP2pGroupOwnerConnectionState is not TransConnectP2pDisconnectedState");
                    ka.d dVar = h4Var18.f9766i;
                    if (dVar != null) {
                        dVar.q(104);
                    }
                }
                int i25 = h4Var18.f9772o ? 107 : 104;
                h4Var18.f9772o = false;
                h4Var18.w(true, i25, null, (WifiP2pDevice) this.f22c, (NearDevice) this.f23d);
                h4Var18.f9769l = null;
                return;
            case 16:
                ((b4) ((Pair) this.f21b).getSecond()).c((WifiP2pGroup) this.f22c, (WifiP2pInfo) this.f23d);
                return;
            case 17:
                ((b4) ((Pair) this.f21b).getSecond()).f(null, (WifiP2pInfo) this.f22c, (Collection) this.f23d);
                return;
            case 18:
                we.h.h("NearP2pManager", "Group Removed delayed timeout, create group again");
                ye.d dVar2 = ((h4) this.f21b).f9762c;
                if (dVar2 != null) {
                    dVar2.c((List) this.f22c, (i2) this.f23d);
                    return;
                }
                return;
            case 19:
                we.h.h("SmartConnectWrapper", "Notify BluetoothScanResults");
                Map map = com.welink.protocol.nfbd.h.f4132a;
                ((y) this.f23d).f4195i.k(com.welink.protocol.nfbd.h.c((DeviceInfo) this.f21b, null, (BluetoothDevice) this.f22c, 0, 0, null, 120), t4.BT_DEVICE, true, false);
                return;
            case 20:
                DeviceInfo deviceInfo = (DeviceInfo) this.f21b;
                ScanResult scanResult = (ScanResult) this.f22c;
                y yVar = (y) this.f23d;
                Map map2 = com.welink.protocol.nfbd.h.f4132a;
                NearDevice device3 = com.welink.protocol.nfbd.h.c(deviceInfo, scanResult, scanResult != null ? scanResult.getDevice() : null, 0, 0, null, 120);
                t1 t1Var = yVar.f4195i;
                t1Var.getClass();
                Intrinsics.checkNotNullParameter(device3, "device");
                synchronized (t1Var.f9990d) {
                    switch (s1.$EnumSwitchMapping$0[t1.w(device3).ordinal()]) {
                        case 1:
                            ConcurrentHashMap.KeySetView mBleCachedDevices = t1Var.f9992h;
                            Intrinsics.checkNotNullExpressionValue(mBleCachedDevices, "mBleCachedDevices");
                            synchronized (mBleCachedDevices) {
                                try {
                                    ConcurrentHashMap.KeySetView mBleCachedDevices2 = t1Var.f9992h;
                                    Intrinsics.checkNotNullExpressionValue(mBleCachedDevices2, "mBleCachedDevices");
                                    Iterator it = mBleCachedDevices2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            NearDevice nearDevice3 = (NearDevice) next;
                                            if (!Intrinsics.areEqual(device3.f3885c, nearDevice3.f3885c) || !Intrinsics.areEqual(device3.f3883a, nearDevice3.f3883a) || device3.e != nearDevice3.e || device3.j() != null || nearDevice3.j() == null) {
                                            }
                                        } else {
                                            next = null;
                                        }
                                    }
                                    NearDevice nearDevice4 = (NearDevice) next;
                                    ConcurrentHashMap.KeySetView mBleCachedDevices3 = t1Var.f9992h;
                                    Intrinsics.checkNotNullExpressionValue(mBleCachedDevices3, "mBleCachedDevices");
                                    Iterator it2 = mBleCachedDevices3.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            next2 = it2.next();
                                            NearDevice nearDevice5 = (NearDevice) next2;
                                            if (nearDevice5.j() == null || (listJ = nearDevice5.j()) == null || !listJ.contains(device3)) {
                                            }
                                        } else {
                                            next2 = null;
                                        }
                                    }
                                    NearDevice nearDevice6 = (NearDevice) next2;
                                    if (nearDevice4 != null) {
                                        nearDevice4.E(device3);
                                    }
                                    if (nearDevice4 != null) {
                                        ConcurrentHashMap concurrentHashMap = m.f10734a;
                                        if (m.d(Integer.valueOf(nearDevice4.hashCode()))) {
                                            t1Var.K(nearDevice4, t1.w(nearDevice4));
                                        }
                                    }
                                    if (nearDevice6 != null) {
                                        nearDevice6.E(device3);
                                    }
                                    if (nearDevice6 != null) {
                                        ConcurrentHashMap concurrentHashMap2 = m.f10734a;
                                        if (m.d(Integer.valueOf(nearDevice6.hashCode()))) {
                                            t1Var.K(nearDevice6, t1.w(nearDevice6));
                                        }
                                    }
                                    z2 = (nearDevice6 == null && nearDevice4 == null) ? false : true;
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                                break;
                            }
                            if (z2) {
                                we.h.j("SmartConnectWrapper", "New Device has been cascaded already, ignore");
                                return;
                            }
                            if (yVar.m(device3)) {
                                we.h.j("SmartConnectWrapper", "New Device can be cascaded, ignore");
                                return;
                            }
                            nearDeviceExtension = device3.u;
                            if (nearDeviceExtension != null || nearDeviceExtension.e) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                            we.h.j("SmartConnectWrapper", "New Device is Non-connectable, conflict with connectable device");
                            if (!yVar.f4195i.y(device3) || yVar.y(device3, false)) {
                                if (yVar.y(device3, true)) {
                                    yVar.f4195i.k(device3, null, true, false);
                                    return;
                                } else {
                                    we.h.j("SmartConnectWrapper", "New Device is Non-connectable, but already in list, aging old device");
                                    yVar.f4195i.k(device3, null, true, false);
                                    return;
                                }
                            }
                            t1 t1Var2 = yVar.f4195i;
                            t1Var2.getClass();
                            Intrinsics.checkNotNullParameter(device3, "device");
                            synchronized (t1Var2.f9990d) {
                                try {
                                    t4 t4VarW = t1.w(device3);
                                    switch (s1.$EnumSwitchMapping$0[t4VarW.ordinal()]) {
                                        case 1:
                                            ConcurrentHashMap.KeySetView mBleCachedDevices4 = t1Var2.f9992h;
                                            Intrinsics.checkNotNullExpressionValue(mBleCachedDevices4, "mBleCachedDevices");
                                            Iterator it3 = mBleCachedDevices4.iterator();
                                            do {
                                                if (it3.hasNext()) {
                                                    next3 = it3.next();
                                                    nearDevice2 = (NearDevice) next3;
                                                    Intrinsics.checkNotNull(nearDevice2);
                                                } else {
                                                    next3 = null;
                                                }
                                                nearDevice = (NearDevice) next3;
                                                if (nearDevice == null) {
                                                    Unit unit = Unit.INSTANCE;
                                                    nearDevice = null;
                                                }
                                                if (nearDevice == null) {
                                                    Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                                                    Intrinsics.checkNotNullParameter("Can't find connectable device in list, ignore", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("SmartConnectWrapper", "TransConnect:Can't find connectable device in list, ignore", null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                String str2 = nearDevice.f3883a;
                                                String str3 = nearDevice.f3884b;
                                                String strU = nearDevice.u();
                                                StringBuilder sbP = h0.a.p("Found connectable device: ", str2, ", ", str3, ", ");
                                                sbP.append(strU);
                                                sbP.append(", update it");
                                                we.h.h("SmartConnectWrapper", sbP.toString());
                                                address = nearDevice.f3883a;
                                                if (address != null && (nearDeviceExtension2 = device3.u) != null) {
                                                    Intrinsics.checkNotNullParameter(address, "address");
                                                    nearDeviceExtension2.f3907c = address;
                                                }
                                                device = nearDevice.f3896s;
                                                if (device != null) {
                                                    we.h.h("SmartConnectWrapper", "Found wireless device, replace non-connectable wireless-device with connectable wireless-device");
                                                    Intrinsics.checkNotNullParameter(device, "device");
                                                    device3.f3896s = device;
                                                }
                                                yVar.f4195i.k(device3, null, true, false);
                                                return;
                                            } while (!t1.r(nearDevice2, device3));
                                            nearDevice = (NearDevice) next3;
                                            if (nearDevice == null) {
                                                Unit unit2 = Unit.INSTANCE;
                                                nearDevice = null;
                                            }
                                            if (nearDevice == null) {
                                                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                                                Intrinsics.checkNotNullParameter("Can't find connectable device in list, ignore", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("SmartConnectWrapper", "TransConnect:Can't find connectable device in list, ignore", null);
                                                    return;
                                                }
                                                return;
                                            }
                                            String str4 = nearDevice.f3883a;
                                            String str5 = nearDevice.f3884b;
                                            String strU2 = nearDevice.u();
                                            StringBuilder sbP2 = h0.a.p("Found connectable device: ", str4, ", ", str5, ", ");
                                            sbP2.append(strU2);
                                            sbP2.append(", update it");
                                            we.h.h("SmartConnectWrapper", sbP2.toString());
                                            address = nearDevice.f3883a;
                                            if (address != null) {
                                                Intrinsics.checkNotNullParameter(address, "address");
                                                nearDeviceExtension2.f3907c = address;
                                            }
                                            device = nearDevice.f3896s;
                                            if (device != null) {
                                                we.h.h("SmartConnectWrapper", "Found wireless device, replace non-connectable wireless-device with connectable wireless-device");
                                                Intrinsics.checkNotNullParameter(device, "device");
                                                device3.f3896s = device;
                                            }
                                            yVar.f4195i.k(device3, null, true, false);
                                            return;
                                        case 2:
                                        case 5:
                                            nearDevice = null;
                                            if (nearDevice == null) {
                                                Unit unit3 = Unit.INSTANCE;
                                                nearDevice = null;
                                            }
                                            if (nearDevice == null) {
                                                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                                                Intrinsics.checkNotNullParameter("Can't find connectable device in list, ignore", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("SmartConnectWrapper", "TransConnect:Can't find connectable device in list, ignore", null);
                                                    return;
                                                }
                                                return;
                                            }
                                            String str6 = nearDevice.f3883a;
                                            String str7 = nearDevice.f3884b;
                                            String strU3 = nearDevice.u();
                                            StringBuilder sbP3 = h0.a.p("Found connectable device: ", str6, ", ", str7, ", ");
                                            sbP3.append(strU3);
                                            sbP3.append(", update it");
                                            we.h.h("SmartConnectWrapper", sbP3.toString());
                                            address = nearDevice.f3883a;
                                            if (address != null) {
                                                Intrinsics.checkNotNullParameter(address, "address");
                                                nearDeviceExtension2.f3907c = address;
                                            }
                                            device = nearDevice.f3896s;
                                            if (device != null) {
                                                we.h.h("SmartConnectWrapper", "Found wireless device, replace non-connectable wireless-device with connectable wireless-device");
                                                Intrinsics.checkNotNullParameter(device, "device");
                                                device3.f3896s = device;
                                            }
                                            yVar.f4195i.k(device3, null, true, false);
                                            return;
                                        case 3:
                                        case 4:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                            we.h.j("NearDeviceTableFusion", "Unsupported device type " + t4VarW.name());
                                            nearDevice = null;
                                            if (nearDevice == null) {
                                                Unit unit4 = Unit.INSTANCE;
                                                nearDevice = null;
                                            }
                                            if (nearDevice == null) {
                                                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                                                Intrinsics.checkNotNullParameter("Can't find connectable device in list, ignore", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("SmartConnectWrapper", "TransConnect:Can't find connectable device in list, ignore", null);
                                                    return;
                                                }
                                                return;
                                            }
                                            String str8 = nearDevice.f3883a;
                                            String str9 = nearDevice.f3884b;
                                            String strU4 = nearDevice.u();
                                            StringBuilder sbP4 = h0.a.p("Found connectable device: ", str8, ", ", str9, ", ");
                                            sbP4.append(strU4);
                                            sbP4.append(", update it");
                                            we.h.h("SmartConnectWrapper", sbP4.toString());
                                            address = nearDevice.f3883a;
                                            if (address != null) {
                                                Intrinsics.checkNotNullParameter(address, "address");
                                                nearDeviceExtension2.f3907c = address;
                                            }
                                            device = nearDevice.f3896s;
                                            if (device != null) {
                                                we.h.h("SmartConnectWrapper", "Found wireless device, replace non-connectable wireless-device with connectable wireless-device");
                                                Intrinsics.checkNotNullParameter(device, "device");
                                                device3.f3896s = device;
                                            }
                                            yVar.f4195i.k(device3, null, true, false);
                                            return;
                                        case 12:
                                            we.h.j("NearDeviceTableFusion", "Ignore unknown device type " + t4VarW.name());
                                            nearDevice = null;
                                            if (nearDevice == null) {
                                                Unit unit5 = Unit.INSTANCE;
                                                nearDevice = null;
                                            }
                                            if (nearDevice == null) {
                                                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                                                Intrinsics.checkNotNullParameter("Can't find connectable device in list, ignore", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("SmartConnectWrapper", "TransConnect:Can't find connectable device in list, ignore", null);
                                                    return;
                                                }
                                                return;
                                            }
                                            String str10 = nearDevice.f3883a;
                                            String str11 = nearDevice.f3884b;
                                            String strU5 = nearDevice.u();
                                            StringBuilder sbP5 = h0.a.p("Found connectable device: ", str10, ", ", str11, ", ");
                                            sbP5.append(strU5);
                                            sbP5.append(", update it");
                                            we.h.h("SmartConnectWrapper", sbP5.toString());
                                            address = nearDevice.f3883a;
                                            if (address != null) {
                                                Intrinsics.checkNotNullParameter(address, "address");
                                                nearDeviceExtension2.f3907c = address;
                                            }
                                            device = nearDevice.f3896s;
                                            if (device != null) {
                                                we.h.h("SmartConnectWrapper", "Found wireless device, replace non-connectable wireless-device with connectable wireless-device");
                                                Intrinsics.checkNotNullParameter(device, "device");
                                                device3.f3896s = device;
                                            }
                                            yVar.f4195i.k(device3, null, true, false);
                                            return;
                                        default:
                                            throw new NoWhenBranchMatchedException();
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                        case 2:
                            z2 = false;
                            if (z2) {
                                we.h.j("SmartConnectWrapper", "New Device has been cascaded already, ignore");
                                return;
                            }
                            if (yVar.m(device3)) {
                                we.h.j("SmartConnectWrapper", "New Device can be cascaded, ignore");
                                return;
                            }
                            nearDeviceExtension = device3.u;
                            if (nearDeviceExtension != null) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                            we.h.j("SmartConnectWrapper", "New Device is Non-connectable, conflict with connectable device");
                            if (yVar.f4195i.y(device3)) {
                            }
                            if (yVar.y(device3, true)) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            } else {
                                we.h.j("SmartConnectWrapper", "New Device is Non-connectable, but already in list, aging old device");
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            z2 = false;
                            if (z2) {
                                we.h.j("SmartConnectWrapper", "New Device has been cascaded already, ignore");
                                return;
                            }
                            if (yVar.m(device3)) {
                                we.h.j("SmartConnectWrapper", "New Device can be cascaded, ignore");
                                return;
                            }
                            nearDeviceExtension = device3.u;
                            if (nearDeviceExtension != null) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                            we.h.j("SmartConnectWrapper", "New Device is Non-connectable, conflict with connectable device");
                            if (yVar.f4195i.y(device3)) {
                            }
                            if (yVar.y(device3, true)) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            } else {
                                we.h.j("SmartConnectWrapper", "New Device is Non-connectable, but already in list, aging old device");
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                        case 5:
                            z2 = false;
                            if (z2) {
                                we.h.j("SmartConnectWrapper", "New Device has been cascaded already, ignore");
                                return;
                            }
                            if (yVar.m(device3)) {
                                we.h.j("SmartConnectWrapper", "New Device can be cascaded, ignore");
                                return;
                            }
                            nearDeviceExtension = device3.u;
                            if (nearDeviceExtension != null) {
                                z3 = false;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                            we.h.j("SmartConnectWrapper", "New Device is Non-connectable, conflict with connectable device");
                            if (yVar.f4195i.y(device3)) {
                            }
                            if (yVar.y(device3, true)) {
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            } else {
                                we.h.j("SmartConnectWrapper", "New Device is Non-connectable, but already in list, aging old device");
                                yVar.f4195i.k(device3, null, true, false);
                                return;
                            }
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            case 21:
                we.h.h("SmartConnectWrapper", "Notify WifiScanResults");
                Map map3 = com.welink.protocol.nfbd.h.f4132a;
                y yVar2 = (y) this.f23d;
                b5 b5Var = yVar2.f4192d;
                if (b5Var == null) {
                    wifiInfo = null;
                } else {
                    ConnectivityManager connectivityManager = b5Var.f9661a;
                    NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(connectivityManager != null ? connectivityManager.getActiveNetwork() : null) : null;
                    if (networkCapabilities == null) {
                        wifiInfo = null;
                    } else if (networkCapabilities.hasTransport(1)) {
                        TransportInfo transportInfo = networkCapabilities.getTransportInfo();
                        if (transportInfo instanceof WifiInfo) {
                            wifiInfo = (WifiInfo) transportInfo;
                        } else {
                            wifiInfo = null;
                        }
                    } else {
                        Iterator it4 = b5Var.f9663c.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                NetworkCapabilities networkCapabilities2 = connectivityManager != null ? connectivityManager.getNetworkCapabilities((Network) it4.next()) : null;
                                if (networkCapabilities2 != null && networkCapabilities2.hasTransport(1)) {
                                    TransportInfo transportInfo2 = networkCapabilities2.getTransportInfo();
                                    if (transportInfo2 instanceof WifiInfo) {
                                        wifiInfo = (WifiInfo) transportInfo2;
                                    }
                                }
                            } else {
                                wifiInfo = null;
                            }
                        }
                    }
                }
                DeviceInfo deviceInfo2 = (DeviceInfo) this.f21b;
                Intrinsics.checkNotNullParameter(deviceInfo2, "deviceInfo");
                int iF = com.welink.protocol.nfbd.h.f(deviceInfo2.f4220a, 0);
                String str12 = (String) com.welink.protocol.nfbd.h.f4132a.get(Integer.valueOf(deviceInfo2.f4221b & UByte.MAX_VALUE));
                if (str12 == null) {
                    str12 = "Unknown";
                }
                int iK = com.welink.protocol.nfbd.h.k(deviceInfo2.f4225i);
                int i26 = com.welink.protocol.nfbd.h.i(deviceInfo2.f4226j);
                int iJ = com.welink.protocol.nfbd.h.j(Integer.valueOf(deviceInfo2.f4227k));
                if (!(iK == 2 || iK == 3 || iK == 4) || iF == 0) {
                    iM254constructorimpl = 0;
                } else if (iF == 1 || iF == 2) {
                    iM254constructorimpl = 7;
                } else if (iF == 3) {
                    iM254constructorimpl = UInt.m254constructorimpl(3);
                } else if (iF != 4) {
                    iM254constructorimpl = 0;
                }
                android.net.wifi.ScanResult scanResult2 = (android.net.wifi.ScanResult) this.f22c;
                if (scanResult2 == null) {
                    i16 = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                    i17 = PointerIconCompat.TYPE_CELL;
                } else if (Intrinsics.areEqual(wifiInfo != null ? wifiInfo.getBSSID() : null, scanResult2.BSSID)) {
                    i16 = PointerIconCompat.TYPE_NO_DROP;
                    i17 = PointerIconCompat.TYPE_WAIT;
                } else {
                    i16 = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;
                    i17 = PointerIconCompat.TYPE_CELL;
                }
                String strValueOf = String.valueOf(scanResult2 != null ? scanResult2.getWifiSsid() : null);
                WirelessDevice.Wifi wifi2 = new WirelessDevice.Wifi(strValueOf, scanResult2 != null ? scanResult2.BSSID : null, scanResult2);
                List capability = CollectionsKt.listOf(Integer.valueOf(i26));
                Intrinsics.checkNotNullParameter(capability, "capability");
                NearDeviceExtension nearDeviceExtension3 = new NearDeviceExtension(capability, deviceInfo2.q, scanResult2 != null ? scanResult2.BSSID : null, -1, true, null, null, null);
                j1 j1Var = new j1();
                j1Var.f9818k = strValueOf;
                j1Var.f9810a = scanResult2 != null ? scanResult2.BSSID : null;
                j1Var.f9819l = scanResult2 != null ? Integer.valueOf(scanResult2.level) : null;
                String str13 = deviceInfo2.f4223d;
                j1Var.f9811b = str13 != null ? r6.b(str13) : null;
                j1Var.f9812c = iF;
                j1Var.f9817j = str12;
                j1Var.f9813d = i26;
                j1Var.e = iJ;
                j1Var.f9816i = iK;
                j1Var.f9823r = UInt.m248boximpl(iM254constructorimpl);
                j1Var.f9822o = deviceInfo2.f4222c;
                j1Var.c(0);
                j1Var.f9820m = Integer.valueOf(i17);
                j1Var.f9821n = i16;
                j1Var.f9825t = wifi2;
                j1Var.f9826v = nearDeviceExtension3;
                j1Var.p = deviceInfo2.f4229m;
                yVar2.f4195i.k(j1Var.a(), t4.WIFI_DEVICE, true, false);
                return;
            case 22:
                b0 b0Var = (b0) this.f21b;
                String str14 = (String) this.f22c;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f23d;
                synchronized (b0Var.e) {
                    b0Var.e.put(str14, bluetoothDevice);
                    Unit unit6 = Unit.INSTANCE;
                }
                return;
            case 23:
                ((DefaultSurfaceProcessor) this.f21b).lambda$initGlRenderer$4((ShaderProvider) this.f22c, (CallbackToFutureAdapter.Completer) this.f23d);
                return;
            case 24:
                ((InternalImageProcessor) this.f21b).lambda$safeProcess$0((CallbackToFutureAdapter.Completer) this.f22c, (ImageProcessor.Request) this.f23d);
                return;
            case 25:
                ((SurfaceProcessorNode) this.f21b).lambda$sendSurfaceOutputs$0((SurfaceEdge) this.f22c, (Map.Entry) this.f23d);
                return;
            case 26:
                VideoCapture.lambda$setupSurfaceUpdateNotifier$5((AtomicBoolean) this.f21b, (SessionConfig.Builder) this.f22c, (CameraCaptureCallback) this.f23d);
                return;
            case 27:
                ((AudioSource) this.f21b).lambda$setAudioSourceCallback$5((Executor) this.f22c, (AudioSource.AudioSourceCallback) this.f23d);
                return;
            case 28:
                k kVar = (k) ((ad.b) this.f21b).f93b;
                boolean zIsCanceled = kVar.f11640b.isCanceled();
                zj.f fVar2 = (zj.f) this.f22c;
                if (zIsCanceled) {
                    fVar2.onFailure(new IOException("Canceled"));
                    return;
                } else {
                    fVar2.d(kVar, (o0) this.f23d);
                    return;
                }
            default:
                Object obj = ((ad.b) this.f21b).f93b;
                ((zj.f) this.f22c).onFailure((Throwable) this.f23d);
                return;
        }
    }

    public /* synthetic */ g(Object obj, int i8, Object obj2, Object obj3) {
        this.f20a = i8;
        this.f21b = obj;
        this.f22c = obj2;
        this.f23d = obj3;
    }
}
