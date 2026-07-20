package wb;

import androidx.lifecycle.LifecycleOwnerKt;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import li.l0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QrConnectActivity f10705b;

    public /* synthetic */ a(QrConnectActivity qrConnectActivity, int i8) {
        this.f10704a = i8;
        this.f10705b = qrConnectActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        QrConnectActivity qrConnectActivity = this.f10705b;
        switch (this.f10704a) {
            case 0:
                int i8 = QrConnectActivity.f2797d;
                l0.p(LifecycleOwnerKt.getLifecycleScope(qrConnectActivity), null, null, new b(qrConnectActivity, null), 3);
                break;
            default:
                int i9 = QrConnectActivity.f2797d;
                qrConnectActivity.finish();
                break;
        }
        return Unit.INSTANCE;
    }
}
