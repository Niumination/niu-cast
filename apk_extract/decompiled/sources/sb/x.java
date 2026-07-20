package sb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmDialog;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class x implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f9632b;

    public /* synthetic */ x(String str, int i8) {
        this.f9631a = i8;
        this.f9632b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str = this.f9632b;
        switch (this.f9631a) {
            case 0:
                ob.c cVar = TCircleConfirmDialog.f2756d;
                Intrinsics.checkNotNullParameter("TCircleConfirmDialog", "tag");
                Intrinsics.checkNotNullParameter("copy text run", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TCircleConfirmDialog"), "copy text run");
                }
                if (str != null) {
                    eb.y yVar = eb.y.f4799a;
                    eb.y.r(str);
                }
                break;
            default:
                Intrinsics.checkNotNullParameter("SearchPcFragment", "tag");
                Intrinsics.checkNotNullParameter("copy text run", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("SearchPcFragment"), "copy text run");
                }
                if (str != null) {
                    eb.y yVar2 = eb.y.f4799a;
                    eb.y.r(str);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
