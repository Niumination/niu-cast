package a0;

import af.l1;
import af.o5;
import af.q2;
import af.r2;
import af.s3;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import android.view.View;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.Preview;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.view.CameraController;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.window.area.RearDisplaySessionImpl;
import androidx.window.area.WindowAreaControllerImpl;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import cf.a0;
import cf.c0;
import cf.d0;
import cf.e0;
import cf.f0;
import cf.h0;
import cf.o0;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import com.transsion.iotservice.multiscreen.pc.bean.MultiConnectInfo;
import com.transsion.iotservice.multiscreen.pc.socket.TranTCCPChannel;
import com.transsion.pcconnect.invoke.bridge.Device;
import com.transsion.widgetslib.flipper.FlipperLayout;
import d6.q;
import d6.w;
import eb.g0;
import eb.y;
import ef.k;
import ef.l;
import ef.m;
import ef.o;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import k3.gc;
import k3.sb;
import k3.sc;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import li.l0;
import qj.s;
import qj.t;
import tj.x;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f16b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f17c;

    public /* synthetic */ e(int i8, Object obj, Object obj2) {
        this.f15a = i8;
        this.f16b = obj;
        this.f17c = obj2;
    }

    private final void a() {
        h0 h0Var = (h0) this.f16b;
        o5 o5Var = (o5) this.f17c;
        try {
            synchronized (h0Var.f1546n) {
                h0Var.e.setTcpNoDelay(true);
            }
            i1.b bVarD = h0Var.f1535a.e.d(h0Var.e, ze.b.f11321b);
            synchronized (h0Var.f1546n) {
                h0Var.e = (Socket) bVarD.f5527a;
            }
            h0Var.f1541i = (ze.b) bVarD.f5528b;
            cf.c cVar = new cf.c(o5Var, h0Var);
            cVar.a(sc.d(h0Var.e), h0Var.e);
            m mVar = h0Var.f1536b;
            s sVarA = sc.a(cVar);
            mVar.getClass();
            cf.b bVar = new cf.b(h0Var, new cf.b(cVar, new l(sVarA, false), 0), 1);
            synchronized (h0Var.f1546n) {
                try {
                    cf.e eVar = new cf.e(h0Var, bVar);
                    h0Var.f1548r = eVar;
                    h0Var.f1549s = new o0(h0Var, eVar);
                    h0Var.f1548r.r();
                    o oVar = new o();
                    oVar.c(7, h0Var.f1535a.f1510h);
                    oVar.c(6, h0Var.f1535a.f1512j);
                    h0Var.f1548r.e(oVar);
                    int i8 = h0Var.f1535a.f1510h;
                    if (i8 > 65535) {
                        h0Var.f1548r.d(0, i8 - 65535);
                    }
                    h0Var.f1548r.flush();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (h0Var.f1535a.f != Long.MAX_VALUE) {
                x xVar = new x(h0Var);
                ScheduledExecutorService scheduledExecutorService = h0Var.f1540h;
                d0 d0Var = h0Var.f1535a;
                q2 q2Var = new q2(xVar, scheduledExecutorService, d0Var.f, d0Var.f1509g, true);
                h0Var.f1542j = q2Var;
                synchronized (q2Var) {
                    if (q2Var.f530d) {
                        q2Var.b();
                    }
                }
            }
            long j8 = h0Var.f1535a.f1513k;
            if (j8 != Long.MAX_VALUE) {
                s3 s3Var = new s3(j8);
                h0Var.f1543k = s3Var;
                s3Var.a(new c0(h0Var, 2), h0Var.f1540h);
            }
            if (h0Var.f1535a.f1515m != Long.MAX_VALUE) {
                h0Var.f1544l = h0Var.f1540h.schedule(new r2(new c0(h0Var, 3)), (long) (((Math.random() * 0.2d) + 0.9d) * h0Var.f1535a.f1515m), TimeUnit.NANOSECONDS);
            }
            Executor executor = h0Var.f1539g;
            m mVar2 = h0Var.f1536b;
            t tVarB = sc.b(sc.f(h0Var.e));
            mVar2.getClass();
            executor.execute(new e0(h0Var, new k(tVarB, false)));
        } catch (IOException | Error | RuntimeException e) {
            synchronized (h0Var.f1546n) {
                try {
                    if (!h0Var.q) {
                        h0.A.log(Level.INFO, "Socket failed to handshake", e);
                    }
                    l1.b(h0Var.e);
                    h0Var.m();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0155  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [T, android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r3v28, types: [T, android.media.MediaCodec] */
    @Override // java.lang.Runnable
    public final void run() {
        int i8 = 1;
        switch (this.f15a) {
            case 0:
                ((EncoderImpl) this.f16b).lambda$acquireInputBuffer$13((CallbackToFutureAdapter.Completer) this.f17c);
                return;
            case 1:
                ((CameraController) this.f16b).lambda$setCameraSelector$3((CameraSelector) this.f17c);
                return;
            case 2:
                a0 a0Var = (a0) this.f16b;
                ArrayList arrayList = (ArrayList) this.f17c;
                synchronized (a0Var.f1476s) {
                    try {
                        a0Var.f1479w.Q(true, a0Var.q, arrayList);
                        if (!a0Var.f1481y) {
                            a0Var.f1479w.f(a0Var.q, ef.a.NO_ERROR);
                        }
                        a0Var.p.l(a0Var.q, true);
                        if (a0Var.f1471l) {
                            a0Var.f1473n = null;
                            a0Var.p(ze.q2.e);
                        } else {
                            a0Var.f1473n = new af.f(a0Var, 0);
                            a0Var.f1472m = true;
                            a0Var.i(true);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                return;
            case 3:
                a();
                return;
            case 4:
                e0 e0Var = (e0) this.f16b;
                f0 f0Var = (f0) this.f17c;
                synchronized (e0Var.e.f1546n) {
                    try {
                        if (!f0Var.e()) {
                            e0Var.e.f1548r.f(f0Var.f1529a, ef.a.NO_ERROR);
                        }
                        e0Var.e.l(f0Var.f1529a, true);
                    } catch (Throwable th3) {
                        throw th3;
                    }
                    break;
                }
                return;
            case 5:
                WindowAreaControllerImpl.RearDisplaySessionConsumer.onSessionStarted$lambda$1$lambda$0((WindowAreaControllerImpl.RearDisplaySessionConsumer) this.f16b, (RearDisplaySessionImpl) this.f17c);
                return;
            case 6:
                d6.l this$0 = (d6.l) this.f16b;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                e6.b fileContainer = (e6.b) this.f17c;
                Intrinsics.checkNotNullParameter(fileContainer, "$fileContainer");
                try {
                    this$0.d(fileContainer);
                    return;
                } catch (Throwable tr) {
                    String msg = Intrinsics.stringPlus("Audio exception=", tr);
                    Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    Intrinsics.checkNotNullParameter(tr, "tr");
                    this$0.b();
                    return;
                }
            case 7:
                d6.t this$1 = (d6.t) this.f16b;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                e6.b file = (e6.b) this.f17c;
                Intrinsics.checkNotNullParameter(file, "$fileContainer");
                this$1.getClass();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                try {
                    j6.b bVar = j6.b.f6107a;
                    Intrinsics.checkNotNullParameter(file, "file");
                    ?? mediaExtractor = new MediaExtractor();
                    file.d(mediaExtractor);
                    objectRef.element = mediaExtractor;
                    int iC = j6.b.c(mediaExtractor);
                    if (iC < 0) {
                        throw new RuntimeException("No video track found");
                    }
                    ((MediaExtractor) objectRef.element).selectTrack(iC);
                    MediaFormat videoFormat = ((MediaExtractor) objectRef.element).getTrackFormat(iC);
                    if (videoFormat == null) {
                        throw new RuntimeException("format is null");
                    }
                    Intrinsics.checkNotNullParameter(videoFormat, "videoFormat");
                    String string = videoFormat.getString("mime");
                    if (string == null) {
                        string = "";
                    }
                    if (StringsKt__StringsKt.contains$default(string, "hevc", false, 2, (Object) null)) {
                        int i9 = Build.VERSION.SDK_INT;
                        if (!bVar.a("video/hevc")) {
                            this$1.c(10008, "0x8 hevc not support sdk:" + i9 + ",support hevc:" + bVar.a("video/hevc"));
                            d6.t.j(this$1, null, null);
                            return;
                        }
                    }
                    this$1.p = videoFormat.getInteger("width");
                    this$1.q = videoFormat.getInteger("height");
                    String msg2 = "Video size is " + this$1.p + " x " + this$1.q;
                    Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    if (this$1.p % 16 != 0) {
                        this$1.f4346a.getClass();
                    }
                    try {
                        if (!this$1.i()) {
                            throw new RuntimeException("render create fail");
                        }
                        this$1.h(this$1.p, this$1.q);
                        w wVar = this$1.f4347b;
                        if (wVar != null) {
                            SurfaceTexture surfaceTexture = new SurfaceTexture(wVar.f4371i[0]);
                            surfaceTexture.setOnFrameAvailableListener(this$1);
                            surfaceTexture.setDefaultBufferSize(this$1.p, this$1.q);
                            Unit unit = Unit.INSTANCE;
                            this$1.f4356m = surfaceTexture;
                        }
                        try {
                            String string2 = videoFormat.getString("mime");
                            if (string2 == null) {
                                string2 = "";
                            }
                            String msg3 = Intrinsics.stringPlus("Video MIME is ", string2);
                            Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                            Intrinsics.checkNotNullParameter(msg3, "msg");
                            ?? CreateDecoderByType = MediaCodec.createDecoderByType(string2);
                            Surface surface = new Surface(this$1.f4356m);
                            this$1.f4355l = surface;
                            CreateDecoderByType.configure(videoFormat, surface, null, 0);
                            CreateDecoderByType.start();
                            Handler handler = this$1.f4349d.f4335b;
                            if (handler != null) {
                                handler.post(new q(this$1, objectRef, CreateDecoderByType, objectRef2));
                            }
                            Unit unit2 = Unit.INSTANCE;
                            objectRef2.element = CreateDecoderByType;
                            return;
                        } catch (Throwable tr2) {
                            String msg4 = Intrinsics.stringPlus("MediaCodec configure exception e=", tr2);
                            Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                            Intrinsics.checkNotNullParameter(msg4, "msg");
                            Intrinsics.checkNotNullParameter(tr2, "tr");
                            this$1.c(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, Intrinsics.stringPlus("0x2 MediaCodec exception e=", tr2));
                            d6.t.j(this$1, (MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
                            return;
                        }
                    } catch (Throwable th4) {
                        this$1.c(10004, Intrinsics.stringPlus("0x4 render create fail e=", th4));
                        d6.t.j(this$1, null, null);
                        return;
                    }
                } catch (Throwable tr3) {
                    String msg5 = Intrinsics.stringPlus("MediaExtractor exception e=", tr3);
                    Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                    Intrinsics.checkNotNullParameter(msg5, "msg");
                    Intrinsics.checkNotNullParameter(tr3, "tr");
                    this$1.c(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, Intrinsics.stringPlus("0x1 MediaExtractor exception e=", tr3));
                    d6.t.j(this$1, (MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
                    return;
                }
            case 8:
                MultiConnectInfo multiConnectInfo = (MultiConnectInfo) this.f16b;
                Device device = (Device) this.f17c;
                gc.c("MultiConnectManager", "permission granted, turn icon");
                synchronized (g0.f4753a) {
                    if (g0.f4754b) {
                        gc.c("MultiConnectManager", "connectMainSocket isMultiConnecting");
                        return;
                    }
                    g0.f4754b = true;
                    MultiConnectInfo multiConnectInfo2 = g0.f4755c;
                    multiConnectInfo2.copyFromNullable(multiConnectInfo);
                    gc.c("MultiConnectManager", "mMultiConnectInfo:" + multiConnectInfo2);
                    g0.f = device;
                    y yVar = y.f4799a;
                    if (sb.b()) {
                        String str = device.f2949c;
                        if (Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_3D)) {
                            i8 = 0;
                        } else if (Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_2D)) {
                            i8 = 6;
                        } else {
                            i8 = -1;
                        }
                    } else if (!Intrinsics.areEqual(device.f2949c, ExifInterface.GPS_MEASUREMENT_3D)) {
                        i8 = 6;
                    }
                    y.f = i8;
                    l0.p(g0.f4757g, null, null, new eb.f0(device, null), 3);
                    return;
                }
            case 9:
                ExtensionEmbeddingBackend.SplitListenerWrapper.accept$lambda$1((ExtensionEmbeddingBackend.SplitListenerWrapper) this.f16b, (ArrayList) this.f17c);
                return;
            case 10:
                g9.a.b((String) this.f16b, (TimeoutException) this.f17c);
                return;
            case 11:
                g9.a.a((String) this.f16b, (RemoteException) this.f17c);
                return;
            case 12:
                ((ViewTransition) this.f16b).lambda$applyTransition$0((View[]) this.f17c);
                return;
            case 13:
                SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.accept$lambda$0((SidecarWindowBackend.WindowLayoutChangeCallbackWrapper) this.f16b, (WindowLayoutInfo) this.f17c);
                return;
            case 14:
                ((Camera2CameraControlImpl) this.f16b).lambda$updateSessionConfigAsync$6((CallbackToFutureAdapter.Completer) this.f17c);
                return;
            case 15:
                ((Camera2CameraControlImpl) this.f16b).lambda$removeSessionCameraCaptureCallback$9((CameraCaptureCallback) this.f17c);
                return;
            case 16:
                ((ResourcesCompat.FontCallback) this.f16b).lambda$callbackSuccessAsync$0((Typeface) this.f17c);
                return;
            case 17:
                AtomicCoreUtils.cancelAllAtomicCoreData$lambda$19((f7.a) this.f16b, (String) this.f17c);
                return;
            case 18:
                AtomicCoreUtils.sendAtomicCoreData$lambda$7((f7.a) this.f16b, (Bundle) this.f17c);
                return;
            case 19:
                ((CameraX) this.f16b).lambda$shutdownInternal$3((CallbackToFutureAdapter.Completer) this.f17c);
                return;
            case 20:
                ImageAnalysis.lambda$createPipeline$0((SafeCloseImageReaderProxy) this.f16b, (SafeCloseImageReaderProxy) this.f17c);
                return;
            case 21:
                ((ImageCapture) this.f16b).lambda$sendImageCaptureRequest$4((ImageCapture.OnImageCapturedCallback) this.f17c);
                return;
            case 22:
                ((MetadataImageReader) this.f16b).lambda$enqueueImageProxy$1((ImageReaderProxy.OnImageAvailableListener) this.f17c);
                return;
            case 23:
                ((Preview.SurfaceProvider) this.f16b).onSurfaceRequested((SurfaceRequest) this.f17c);
                return;
            case 24:
                TranTCCPChannel.sendData$lambda$1$lambda$0((byte[]) this.f16b, (OutputStream) this.f17c);
                return;
            case 25:
                ((TakePictureRequest) this.f16b).lambda$onResult$2((ImageProxy) this.f17c);
                return;
            case 26:
                ((TakePictureRequest) this.f16b).lambda$onResult$1((ImageCapture.OutputFileResults) this.f17c);
                return;
            case 27:
                ((TakePictureRequest) this.f16b).lambda$onError$0((ImageCaptureException) this.f17c);
                return;
            case 28:
                FlipperLayout.a((FlipperLayout) this.f16b, (nd.e) this.f17c);
                return;
            default:
                ((CameraRepository) this.f16b).lambda$deinit$1((CameraInternal) this.f17c);
                return;
        }
    }
}
