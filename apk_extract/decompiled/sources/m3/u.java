package m3;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.R$string;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static final void a(Application application) {
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("toastCancelCopy", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "toastCancelCopy");
        }
        String string = application.getResources().getString(R$string.module_pc_swift_copy);
        String string2 = application.getResources().getString(R$string.module_pc_operation_canceled);
        na.k kVar = na.k.f8141a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNull(string2);
        kVar.d(application, o.d.q(new Object[]{string}, 1, string2, "format(...)"));
    }

    public static final void b(Application application) {
        Resources resources = application.getResources();
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("toastCancelSend", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "toastCancelSend");
        }
        String string = resources.getString(R$string.module_pc_swift_send);
        String string2 = resources.getString(R$string.module_pc_operation_canceled);
        na.k kVar = na.k.f8141a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNull(string2);
        kVar.d(application, o.d.q(new Object[]{string}, 1, string2, "format(...)"));
    }

    public static final void c(Application application) {
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("toastDeviceNotSupport", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "toastDeviceNotSupport");
        }
        String string = application.getResources().getString(R$string.module_pc_the_device_not_suppot);
        na.k kVar = na.k.f8141a;
        Intrinsics.checkNotNull(string);
        kVar.d(application, string);
    }

    public static final void d(Application application) {
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("toastQueueing", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "toastQueueing");
        }
        String string = application.getResources().getString(R$string.module_pc_file_transfer_queueing);
        na.k kVar = na.k.f8141a;
        Intrinsics.checkNotNull(string);
        kVar.d(application, string);
    }
}
