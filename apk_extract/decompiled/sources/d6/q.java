package d6;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.mlkit.vision.MlKitAnalyzer;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanActivity;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanViewModel;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.NearLaptopManager$TransferConnectInfo;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import com.welink.protocol.nfbd.WirelessDevice;
import com.welink.protocol.nfbd.a0;
import com.welink.protocol.nfbd.z;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k3.gc;
import k3.lb;
import k3.tb;
import k3.xc;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import se.a4;
import se.e1;
import se.z0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4341d;
    public final /* synthetic */ Object e;

    public /* synthetic */ q(int i8, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f4338a = i8;
        this.f4339b = obj;
        this.f4340c = obj2;
        this.f4341d = obj3;
        this.e = obj4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        NearLaptopManager$TransferConnectInfo nearLaptopManager$TransferConnectInfo;
        DeviceInfo deviceInfo;
        WifiP2pInfo wifiP2pInfo;
        ConnectRequest connectRequest;
        Object obj = this.e;
        Object obj2 = this.f4339b;
        Object obj3 = this.f4340c;
        Object obj4 = this.f4341d;
        switch (this.f4338a) {
            case 0:
                t this$0 = (t) obj2;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Ref.ObjectRef extractor = (Ref.ObjectRef) obj3;
                Intrinsics.checkNotNullParameter(extractor, "$extractor");
                MediaCodec this_apply = (MediaCodec) obj;
                Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
                Ref.ObjectRef decoder = (Ref.ObjectRef) obj4;
                Intrinsics.checkNotNullParameter(decoder, "$decoder");
                try {
                    this$0.k((MediaExtractor) extractor.element, this_apply);
                } catch (Throwable tr) {
                    String msg = Intrinsics.stringPlus("MediaCodec exception e=", tr);
                    Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    Intrinsics.checkNotNullParameter(tr, "tr");
                    this$0.c(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, Intrinsics.stringPlus("0x2 MediaCodec exception e=", tr));
                    t.j(this$0, (MediaCodec) decoder.element, (MediaExtractor) extractor.element);
                    return;
                }
                break;
            case 1:
                AtomicCoreUtils.updateCardData$lambda$27((f7.a) obj2, (JSONObject) obj3, (JSONObject) obj4, (Bundle) obj);
                break;
            case 2:
                ((ImageCapture) obj2).lambda$takePicture$3((ImageCapture.OutputFileOptions) obj3, (Executor) obj4, (ImageCapture.OnImageSavedCallback) obj);
                break;
            case 3:
                q5.a aVar = ((z0) obj2).f10076b;
                TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = (TranConnectionController$P2pDeviceInfo) obj;
                WifiP2pGroup wifiP2pGroup = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3983k : null;
                NearDevice device = (NearDevice) obj3;
                Intrinsics.checkNotNullParameter(device, "device");
                StringBuilder sb2 = new StringBuilder("onNearP2pOwnerAvailable:device:");
                sb2.append(device);
                sb2.append(" , p2pDevice: ");
                WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) obj4;
                sb2.append(wifiP2pDevice);
                sb2.append(", p2pGroup: ");
                sb2.append(wifiP2pGroup);
                String log = sb2.toString();
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), log);
                }
                mc.b.f7959b = device;
                WirelessDevice.P2p p2p = (WirelessDevice.P2p) device.f3896s;
                if (p2p != null && wifiP2pDevice != null && wifiP2pGroup != null) {
                    hc.d dVar = new hc.d();
                    String str = p2p.f4013a;
                    if (str == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    dVar.f5290g = str;
                    String str2 = p2p.f4015c;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Intrinsics.checkNotNullParameter(str2, "<set-?>");
                    dVar.f5291h = str2;
                    dVar.f5289d = Integer.parseInt(tb.a(device.h()));
                    dVar.a(wifiP2pDevice.deviceAddress);
                    dVar.f5292i = wifiP2pGroup.getFrequency();
                    String str3 = device.f3885c;
                    if (str3 == null) {
                        str3 = "";
                    }
                    Intrinsics.checkNotNullParameter(str3, "<set-?>");
                    dVar.f5286a = str3;
                    String str4 = device.f3884b;
                    String str5 = str4 != null ? str4 : "";
                    Intrinsics.checkNotNullParameter(str5, "<set-?>");
                    dVar.f5287b = str5;
                    dVar.e = device.e;
                    String log2 = "onNearP2pOwnerAvailable: " + dVar;
                    Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                    Intrinsics.checkNotNullParameter(log2, "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("TranConnectManager"), log2);
                    }
                    break;
                }
                break;
            case 4:
                ((com.welink.protocol.nfbd.j) obj2).o((BluetoothGatt) obj3, (BluetoothGattCharacteristic) obj4, (byte[]) obj);
                break;
            case 5:
                e1 e1Var = (e1) ((Pair) obj2).getSecond();
                e1Var.getClass();
                BluetoothDevice inviteDevice = (BluetoothDevice) obj3;
                Intrinsics.checkNotNullParameter(inviteDevice, "inviteDevice");
                NearLaptopManager$TransferConnectInfo info = (NearLaptopManager$TransferConnectInfo) obj4;
                Intrinsics.checkNotNullParameter(info, "info");
                com.welink.protocol.nfbd.g gVar = e1Var.f9726b;
                gVar.getClass();
                Intent intent = new Intent("com.welink.service.ACTION_NEAR_DEVICE_CONNECT_INVITATION");
                intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", inviteDevice);
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_CONNECT_INFO", info);
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_INFO", (DeviceInfo) obj);
                gVar.f4112b.j(intent);
                break;
            case 6:
                BluetoothDevice bluetoothDevice = (BluetoothDevice) obj2;
                if (bluetoothDevice == null || (nearLaptopManager$TransferConnectInfo = (NearLaptopManager$TransferConnectInfo) obj3) == null || (deviceInfo = (DeviceInfo) obj4) == null) {
                    Intrinsics.checkNotNullParameter("TranConnectionManager", "tag");
                    Intrinsics.checkNotNullParameter("handleNearDeviceConnectInvitation, but info is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("TranConnectionManager", "TransConnect:handleNearDeviceConnectInvitation, but info is null", null);
                    }
                } else {
                    z zVar = (z) obj;
                    zVar.getClass();
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, bluetoothDevice.getName(), 31, deviceInfo, new TranConnectionController$EventInfo((String) null, 31, 0, 0, 0, new NearDeviceDataParcel(nearLaptopManager$TransferConnectInfo, bluetoothDevice)), new NearDeviceDataParcel(bluetoothDevice, null));
                    we.h.h("TranConnectionManager", "Receive remote laptop connect invitation, device name: " + bluetoothDevice.getName() + ", connectInfo: " + nearLaptopManager$TransferConnectInfo);
                    zVar.q(tranConnectionController$MessageInfo, null);
                }
                break;
            case 7:
                WifiP2pGroup wifiP2pGroup2 = (WifiP2pGroup) obj2;
                if (wifiP2pGroup2 != null && (wifiP2pInfo = (WifiP2pInfo) obj3) != null && ((List) obj4) != null) {
                    z zVar2 = (z) obj;
                    zVar2.getClass();
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo2 = new TranConnectionController$MessageInfo(null, 0, 0, null, 30, new DeviceInfo((byte) 0, (byte) 0, (String) null, (String) null, (Boolean) null, (EarBudsInfo) null, 3, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128), new TranConnectionController$EventInfo((String) null, 30, 0, 0, 0, new NearDeviceDataParcel(wifiP2pGroup2, null)), new NearDeviceDataParcel(wifiP2pInfo, null));
                    we.h.h("TranConnectionManager", "Other p2p device connected");
                    zVar2.q(tranConnectionController$MessageInfo2, null);
                    break;
                }
                break;
            case 8:
                BluetoothDevice device2 = (BluetoothDevice) obj2;
                if (device2 != null && (connectRequest = (ConnectRequest) obj3) != null) {
                    z zVar3 = (z) obj4;
                    zVar3.getClass();
                    Intrinsics.checkNotNullParameter(device2, "device");
                    Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                    NearDevice nearDevice = (NearDevice) obj;
                    TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 24, 0, 0, 0, new NearDeviceDataParcel(connectRequest, nearDevice));
                    byte b9 = (byte) connectRequest.f3876t;
                    byte b10 = (byte) connectRequest.u;
                    String str6 = connectRequest.f3865d;
                    if (str6 == null) {
                        str6 = connectRequest.f3875s;
                    }
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo3 = new TranConnectionController$MessageInfo(null, connectRequest.f3873o, connectRequest.p, connectRequest.f3874r, 24, new DeviceInfo(b9, b10, connectRequest.f3877v, str6, (Boolean) null, (EarBudsInfo) null, 0, connectRequest.f3878w, connectRequest.f3879x, connectRequest.f3880y, connectRequest.f3862a, connectRequest.f3881z, connectRequest.A, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2088960), tranConnectionController$EventInfo, new NearDeviceDataParcel(device2, nearDevice));
                    we.h.h("TranConnectionManager", "Receive remote p2p connect request");
                    zVar3.q(tranConnectionController$MessageInfo3, nearDevice);
                    break;
                }
                break;
            case 9:
                for (se.w wVar : ((a0) obj2).A) {
                    BluetoothDevice inviteDevice2 = ((ScanResult) obj3).getDevice();
                    Intrinsics.checkNotNullExpressionValue(inviteDevice2, "getDevice(...)");
                    NearLaptopManager$TransferConnectInfo info2 = (NearLaptopManager$TransferConnectInfo) obj4;
                    DeviceInfo deviceInfo2 = (DeviceInfo) obj;
                    int i8 = wVar.f10039a;
                    Intrinsics.checkNotNullParameter(inviteDevice2, "inviteDevice");
                    Intrinsics.checkNotNullParameter(info2, "info");
                    switch (i8) {
                        case 0:
                            we.h.b("NearBleManager", "onConnectInvitation: " + inviteDevice2 + ", " + info2 + ", " + deviceInfo2);
                            break;
                        case 1:
                            we.h.b("NearBluetoothManager", "onConnectInvitation: " + inviteDevice2 + ", " + info2 + ", " + deviceInfo2);
                            break;
                        default:
                            for (Pair pair : ((a4) wVar.f10040b).f9646h) {
                                ((Executor) pair.getFirst()).execute(new q(5, pair, inviteDevice2, info2, deviceInfo2));
                            }
                            break;
                    }
                }
                break;
            case 10:
                ((MlKitAnalyzer) obj2).lambda$detectRecursively$0((Map) obj3, (ImageProxy) obj4, (Map) obj);
                break;
            default:
                QrScanActivity qrScanActivity = (QrScanActivity) obj4;
                ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) ((m4.l) obj3).get();
                QrScanViewModel qrScanViewModel = (QrScanViewModel) obj2;
                Lazy lazy = qrScanViewModel.f2810g;
                qrScanViewModel.e = processCameraProvider;
                Preview previewBuild = new Preview.Builder().build();
                previewBuild.setSurfaceProvider((Preview.SurfaceProvider) obj);
                Intrinsics.checkNotNullExpressionValue(previewBuild, "apply(...)");
                CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
                Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
                new ImageCapture.Builder().build();
                try {
                    ProcessCameraProvider processCameraProvider2 = qrScanViewModel.e;
                    if (processCameraProvider2 != null) {
                        processCameraProvider2.unbindAll();
                    }
                    ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
                    r5.a aVar2 = new r5.a(256);
                    Intrinsics.checkNotNullExpressionValue(aVar2, "build(...)");
                    qrScanViewModel.f = xc.a(aVar2);
                    imageAnalysisBuild.setAnalyzer((ExecutorService) lazy.getValue(), new MlKitAnalyzer(CollectionsKt.listOf(qrScanViewModel.f), 0, (ExecutorService) lazy.getValue(), qrScanViewModel.f2815l));
                    Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "apply(...)");
                    ProcessCameraProvider processCameraProvider3 = qrScanViewModel.e;
                    qrScanViewModel.f2809d = processCameraProvider3 != null ? processCameraProvider3.bindToLifecycle(qrScanActivity, DEFAULT_BACK_CAMERA, previewBuild, imageAnalysisBuild) : null;
                    qrScanViewModel.a();
                } catch (Exception unused) {
                    return;
                }
                break;
        }
    }

    public /* synthetic */ q(t tVar, Ref.ObjectRef objectRef, MediaCodec mediaCodec, Ref.ObjectRef objectRef2) {
        this.f4338a = 0;
        this.f4339b = tVar;
        this.f4340c = objectRef;
        this.e = mediaCodec;
        this.f4341d = objectRef2;
    }
}
