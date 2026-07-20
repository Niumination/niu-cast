package b0;

import android.content.Intent;
import android.net.Uri;
import android.os.VibrationEffect;
import android.os.VibratorManager;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.mlkit.vision.MlKitAnalyzer;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.lifecycle.ViewModelKt;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanViewModel;
import java.util.List;
import k3.pb;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import li.g2;
import li.l0;
import li.v0;
import wb.f;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1178b;

    public /* synthetic */ d(Object obj, int i8) {
        this.f1177a = i8;
        this.f1178b = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        BarcodeScannerImpl barcodeScannerImpl;
        List list;
        t5.a aVar;
        String strH;
        switch (this.f1177a) {
            case 0:
                ((CallbackToFutureAdapter.Completer) this.f1178b).set((SurfaceRequest.Result) obj);
                break;
            case 1:
                MlKitAnalyzer.Result result = (MlKitAnalyzer.Result) obj;
                Intrinsics.checkNotNullParameter(result, "result");
                QrScanViewModel qrScanViewModel = (QrScanViewModel) this.f1178b;
                if (!qrScanViewModel.f2813j && (barcodeScannerImpl = qrScanViewModel.f) != null && (list = (List) result.getValue(barcodeScannerImpl)) != null && (aVar = (t5.a) CollectionsKt.firstOrNull(list)) != null && (strH = aVar.f10166a.h()) != null) {
                    g2 g2Var = qrScanViewModel.f2812i;
                    if (g2Var != null) {
                        g2Var.h(null);
                    }
                    if (!StringsKt__StringsJVMKt.startsWith$default(strH, "tqr://a=com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT", false, 2, null)) {
                        qrScanViewModel.f2812i = l0.p(ViewModelKt.getViewModelScope(qrScanViewModel), v0.f7499b, null, new f(qrScanViewModel, null), 2);
                    } else {
                        qrScanViewModel.f2813j = true;
                        Intent intent = new Intent();
                        intent.setAction("com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT");
                        String strSubstring = strH.substring(StringsKt__StringsKt.indexOf$default((CharSequence) strH, "c=", 0, false, 6, (Object) null) + 2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        intent.putExtra("QR_message", strSubstring);
                        intent.setFlags(268435456);
                        pb.a().startActivity(intent);
                        Object systemService = pb.a().getSystemService("vibrator_manager");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
                        ((VibratorManager) systemService).getDefaultVibrator().vibrate(VibrationEffect.createOneShot(50L, -1));
                        ag.a aVar2 = qrScanViewModel.f2811h;
                        if (aVar2 != null) {
                            aVar2.invoke();
                        }
                    }
                }
                break;
            case 2:
                ((Recorder) this.f1178b).lambda$setupAndStartMediaMuxer$9((Uri) obj);
                break;
            default:
                ((VideoSpec.Builder) obj).setQualitySelector((QualitySelector) this.f1178b);
                break;
        }
    }
}
