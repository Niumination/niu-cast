package com.transsion.iotservice.multiscreen.pc.ui.qr;

import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b0.d;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalConnecting;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalDisconnecting;
import eb.l2;
import eb.y;
import k3.gc;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import ob.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/qr/QrScanViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class QrScanViewModel extends ViewModel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Camera f2809d;
    public ProcessCameraProvider e;
    public BarcodeScannerImpl f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ag.a f2811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g2 f2812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2813j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f2806a = LazyKt.lazy(new c(19));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f2807b = LazyKt.lazy(new c(20));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2808c = new MutableLiveData(Boolean.FALSE);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f2810g = LazyKt.lazy(new c(21));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f2814k = LazyKt.lazy(new c(22));

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f2815l = new d(this, 1);

    public final void a() {
        CameraInfo cameraInfo;
        LiveData<Integer> torchState;
        Integer value;
        Camera camera = this.f2809d;
        if (camera == null || (cameraInfo = camera.getCameraInfo()) == null || (torchState = cameraInfo.getTorchState()) == null || (value = torchState.getValue()) == null || value.intValue() != 0) {
            return;
        }
        this.f2808c.setValue(Boolean.FALSE);
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        BaseState baseState = y.f4804h;
        String log = "onCleared when " + baseState;
        Intrinsics.checkNotNullParameter("QrScanViewModel", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("QrScanViewModel"), log);
        }
        if (baseState.compareTo((BaseState) new PhysicalConnecting()) < 0 || Intrinsics.areEqual(baseState, new PhysicalDisconnecting())) {
            TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
            l2.d();
        }
    }
}
