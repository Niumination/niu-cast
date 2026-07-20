package k3;

import android.content.Context;
import android.content.Intent;
import android.service.quicksettings.TileService;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class oc {
    public static void a(Context context, ArrayList notGrantPermissions, int i8, Runnable whenGranted) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notGrantPermissions, "notGrantPermissions");
        Intrinsics.checkNotNullParameter(whenGranted, "whenGranted");
        BlankActivity.f2697c = notGrantPermissions;
        BlankActivity.f2696b = whenGranted;
        BlankActivity.f2698d = i8;
        if (!(context instanceof TileService)) {
            Intent intent = new Intent(pb.a(), (Class<?>) BlankActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } else {
            TileService tileService = (TileService) context;
            Intent intent2 = new Intent(pb.a(), (Class<?>) BlankActivity.class);
            Intrinsics.checkNotNullParameter(tileService, "<this>");
            Intrinsics.checkNotNullParameter(intent2, "intent");
            lj.k.a(tileService, intent2);
        }
    }
}
