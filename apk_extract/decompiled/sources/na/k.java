package na;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.transsion.iotservice.common.util.ToastActivity;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import li.l0;
import li.v0;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f8141a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Toast f8142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f8143c;

    static {
        v0 v0Var = v0.f7498a;
        f8143c = h0.a(r.f9163a);
    }

    public static final void a(int i8, String str) {
        Toast toast = f8142b;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(pb.a(), str, i8);
        Intrinsics.checkNotNullExpressionValue(toastMakeText, "makeText(...)");
        f8142b = toastMakeText;
        Toast toast2 = ToastActivity.f2384a;
        ToastActivity.f2384a = f8142b;
        Application applicationA = pb.a();
        Intent intent = new Intent(pb.a(), (Class<?>) ToastActivity.class);
        intent.setFlags(268435456);
        applicationA.startActivity(intent);
    }

    public final synchronized void b(Application context, String msg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.length() != 0) {
            l0.p(f8143c, null, null, new i(msg, null), 3);
            return;
        }
        Intrinsics.checkNotNullParameter("ToastUtil", "tag");
        Intrinsics.checkNotNullParameter("ToastUtil, msg is null", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("ToastUtil"), "ToastUtil, msg is null");
        }
    }

    public final synchronized void c(Application context, int i8) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(i8);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        d(context, string);
    }

    public final synchronized void d(Context context, String msg) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.length() != 0) {
            l0.p(f8143c, null, null, new j(msg, null), 3);
            return;
        }
        Intrinsics.checkNotNullParameter("ToastUtil", "tag");
        Intrinsics.checkNotNullParameter("ToastUtil, msg is null", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("ToastUtil"), "ToastUtil, msg is null");
        }
    }
}
