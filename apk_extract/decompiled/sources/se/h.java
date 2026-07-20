package se;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.PointerIconCompat;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionGuideDialog;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import java.util.ArrayList;
import java.util.List;
import k3.gc;
import k3.sb;
import k3.vb;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements f, x7.j, z9.a, vj.a {
    public static boolean l(ContextWrapper context, ActivityResultLauncher permissionDialogLauncher, List needPermissions, int i8) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionDialogLauncher, "permissionDialogLauncher");
        Intrinsics.checkNotNullParameter(needPermissions, "needPermissions");
        Intrinsics.checkNotNullParameter("UserPermissionNotifyIsShow", "key");
        SharedPreferences sharedPreferences = vb.f6684a;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        if (!sharedPreferences.getBoolean("UserPermissionNotifyIsShow", true)) {
            return false;
        }
        if (i8 != 0 && i8 == 1) {
            needPermissions = sb.b() ? CollectionsKt.listOf((Object[]) new Permission[]{jb.h.f6138a, jb.h.f6139b}) : CollectionsKt.listOf(jb.h.f6139b);
        }
        Intent intent = new Intent(context, (Class<?>) PermissionGuideDialog.class);
        intent.putParcelableArrayListExtra("permissionList", new ArrayList<>(needPermissions));
        intent.putExtra("from", "PermissionDialog");
        intent.putExtra("businessType", i8);
        int i9 = PermissionGuideDialog.f2790l;
        permissionDialogLauncher.launch(intent);
        ob.b.f8417b.f8437a.getClass();
        tj.w.X("iot_multi_con_permissionpage_ex", tj.w.D());
        return true;
    }

    public static boolean m(AppCompatActivity appCompatActivity, ActivityResultLauncher activityResultLauncher, int i8) {
        return l(appCompatActivity, activityResultLauncher, CollectionsKt.listOf((Object[]) new Permission[]{jb.h.f6141d, jb.h.f6138a, jb.h.f6139b}), i8);
    }

    @Override // z9.a
    public boolean a(Canvas canvas, float f, float f4, float f10, int i8) {
        return false;
    }

    @Override // x7.j
    public void b(q7.f disconnectInfoBean) {
        Intrinsics.checkNotNullParameter(disconnectInfoBean, "disconnectInfoBean");
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("source service disconnected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "source service disconnected");
        }
        eb.l2.b();
    }

    @Override // z9.a
    public boolean c() {
        return false;
    }

    @Override // vj.a
    public vj.b d(String str) {
        return xj.d.NOP_LOGGER;
    }

    @Override // se.f
    public boolean e(NearDevice device, com.welink.protocol.nfbd.z manager, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        device.A(PointerIconCompat.TYPE_CELL);
        g newState = new g(0);
        Intrinsics.checkNotNullParameter(newState, "newState");
        device.I = newState;
        return true;
    }

    @Override // se.f
    public boolean f(NearDevice device, com.welink.protocol.nfbd.z manager, ConnectRequest request, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(request, "request");
        return false;
    }

    @Override // z9.a
    public void g(Canvas canvas, float f, float f4, float f10, float f11, float f12, Paint paint) {
        boolean z2 = j9.a.f6132a;
        Log.w("h", "aosp not support drawSmoothRoundRect [" + f + "," + f4 + ", " + f10 + ", " + f11 + "], radius=" + f12);
    }

    @Override // se.f
    public boolean h(NearDevice device, com.welink.protocol.nfbd.z manager) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Log.e("DisconnectingState", "flushDevice not support in DisconnectingState");
        return false;
    }

    @Override // se.f
    public boolean i(NearDevice device, com.welink.protocol.nfbd.z manager, g5 g5Var, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        return false;
    }

    @Override // se.f
    public boolean j(NearDevice device, com.welink.protocol.nfbd.z manager, int i8, int i9, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        return false;
    }

    @Override // x7.j
    public void k(q7.g error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // x7.j
    public void onConnected() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("source service connected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "source service connected");
        }
    }
}
