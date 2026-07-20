package m3;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionGuideDialog;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanActivity;
import java.util.ArrayList;
import k3.pb;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    public static void a(FragmentActivity activity, String entry, ActivityResultLauncher launcher, Function1 grantResultCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(grantResultCallback, "grantResultCallback");
        ArrayList arrayListA = k3.o1.a(activity, CollectionsKt.listOf((Object[]) new Permission[]{jb.h.f6141d, jb.h.f6138a, jb.h.f6139b, jb.h.f6140c}));
        int i8 = PermissionGuideDialog.f2790l;
        if (se.h.l(pb.a(), launcher, arrayListA, 0)) {
            return;
        }
        if (arrayListA.isEmpty()) {
            eb.y yVar = eb.y.f4799a;
            eb.y.f = 0;
            Intent intent = new Intent(activity, (Class<?>) QrScanActivity.class);
            QrScanActivity.f2804c = entry;
            activity.startActivity(intent);
            grantResultCallback.invoke(Boolean.TRUE);
        }
        k3.o1.c(activity, arrayListA, "allPermissions", new qg.j0(activity, 2, entry, grantResultCallback), new dc.j(activity, arrayListA, launcher, grantResultCallback, 1));
    }
}
