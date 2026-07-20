package k3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class o1 {
    public static final ArrayList a(Context context, List permissionGroups) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(permissionGroups, "permissionGroups");
        ArrayList arrayList = new ArrayList();
        for (Object obj : permissionGroups) {
            ArrayList<String> permissions = ((Permission) obj).getPermissions();
            Intrinsics.checkNotNullExpressionValue(permissions, "getPermissions(...)");
            Iterator<T> it = permissions.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (context.checkSelfPermission((String) next) == 0);
            if (next != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final void b(FragmentActivity context, List needPermissions, ActivityResultLauncher permissionDialogLauncher, Function1 permissionDialogCallback, String pageTag) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(needPermissions, "needPermissions");
        Intrinsics.checkNotNullParameter(pageTag, "pageTag");
        if (permissionDialogLauncher != null) {
            Function1 function1 = PermissionDialog.f2787d;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(needPermissions, "needPermissions");
            Intrinsics.checkNotNullParameter(permissionDialogLauncher, "permissionDialogLauncher");
            Intrinsics.checkNotNullParameter(pageTag, "pageTag");
            Intent intent = new Intent(context, (Class<?>) PermissionDialog.class);
            intent.putParcelableArrayListExtra("permissionList", new ArrayList<>(needPermissions));
            intent.putExtra("from", pageTag);
            PermissionDialog.f2787d = null;
            permissionDialogLauncher.launch(intent);
            return;
        }
        if (permissionDialogCallback == null) {
            Intrinsics.checkNotNullParameter("PermissionExt", "tag");
            Intrinsics.checkNotNullParameter("PermissionDialog is not start up because param is null", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("PermissionExt"), "PermissionDialog is not start up because param is null");
                return;
            }
            return;
        }
        Function1 function2 = PermissionDialog.f2787d;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(needPermissions, "needPermissions");
        Intrinsics.checkNotNullParameter(permissionDialogCallback, "permissionDialogCallback");
        Intrinsics.checkNotNullParameter(pageTag, "pageTag");
        Intent intent2 = new Intent(context, (Class<?>) PermissionDialog.class);
        intent2.putParcelableArrayListExtra("permissionList", new ArrayList<>(needPermissions));
        intent2.putExtra("from", pageTag);
        intent2.setFlags(268435456);
        PermissionDialog.f2787d = permissionDialogCallback;
        context.startActivity(intent2);
    }

    public static final void c(FragmentActivity activity, List permissionGroups, String name, Function0 whenGranted, Function0 whenNotGranted) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(permissionGroups, "permissionGroups");
        Intrinsics.checkNotNullParameter(name, "permissionGroupName");
        Intrinsics.checkNotNullParameter(whenGranted, "whenGranted");
        Intrinsics.checkNotNullParameter(whenNotGranted, "whenNotGranted");
        ArrayList<String> permissions = new ArrayList();
        Iterator it = permissionGroups.iterator();
        while (it.hasNext()) {
            ArrayList<String> permissions2 = ((Permission) it.next()).getPermissions();
            Intrinsics.checkNotNullExpressionValue(permissions2, "getPermissions(...)");
            Iterator<T> it2 = permissions2.iterator();
            while (it2.hasNext()) {
                permissions.add((String) it2.next());
            }
        }
        ArrayList arrayListA = a(activity, permissionGroups);
        if (arrayListA.isEmpty()) {
            whenGranted.invoke();
            return;
        }
        permissions.clear();
        Iterator it3 = arrayListA.iterator();
        while (it3.hasNext()) {
            ArrayList<String> permissions3 = ((Permission) it3.next()).getPermissions();
            Intrinsics.checkNotNullExpressionValue(permissions3, "getPermissions(...)");
            Iterator<T> it4 = permissions3.iterator();
            while (it4.hasNext()) {
                permissions.add((String) it4.next());
            }
        }
        Iterator it5 = permissions.iterator();
        Intrinsics.checkNotNullExpressionValue(it5, "iterator(...)");
        while (it5.hasNext()) {
            Object next = it5.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            String str = (String) next;
            Intrinsics.checkNotNullParameter(name, "name");
            String key = "first_req_permission_tag".concat(name);
            Intrinsics.checkNotNullParameter(key, "key");
            SharedPreferences sharedPreferences = vb.f6684a;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences = null;
            }
            if (sharedPreferences.getBoolean(key, true)) {
                break;
            } else if (!activity.shouldShowRequestPermissionRationale(str)) {
                whenNotGranted.invoke();
                return;
            }
        }
        String log = "checkAppPermission: permissionList=" + permissions;
        Intrinsics.checkNotNullParameter("PermissionExt", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PermissionExt"), log);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        LinkedHashSet normalPermissions = new LinkedHashSet();
        LinkedHashSet specialPermissions = new LinkedHashSet();
        Intrinsics.checkNotNull(activity);
        int i8 = activity.getApplicationInfo().targetSdkVersion;
        for (String str2 : permissions) {
            if (b6.a.f1212a.contains(str2)) {
                specialPermissions.add(str2);
            } else {
                normalPermissions.add(str2);
            }
        }
        specialPermissions.contains("android.permission.ACCESS_BACKGROUND_LOCATION");
        if (specialPermissions.contains("android.permission.POST_NOTIFICATIONS") && i8 >= 33) {
            specialPermissions.remove("android.permission.POST_NOTIFICATIONS");
            normalPermissions.add("android.permission.POST_NOTIFICATIONS");
        }
        Intrinsics.checkNotNullParameter(normalPermissions, "normalPermissions");
        Intrinsics.checkNotNullParameter(specialPermissions, "specialPermissions");
        c6.r permissionBuilder = new c6.r();
        permissionBuilder.f1441b = -1;
        permissionBuilder.e = new LinkedHashSet();
        permissionBuilder.f = new LinkedHashSet();
        permissionBuilder.f1444g = new LinkedHashSet();
        permissionBuilder.f1445h = new LinkedHashSet();
        new LinkedHashSet();
        permissionBuilder.f1446i = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        permissionBuilder.f1440a = activity;
        permissionBuilder.f1442c = normalPermissions;
        permissionBuilder.f1443d = specialPermissions;
        permissionBuilder.f1447j = new c1.a(name, whenGranted, whenNotGranted);
        permissionBuilder.f1441b = permissionBuilder.a().getRequestedOrientation();
        int i9 = permissionBuilder.a().getResources().getConfiguration().orientation;
        if (i9 == 1) {
            permissionBuilder.a().setRequestedOrientation(7);
        } else if (i9 == 2) {
            permissionBuilder.a().setRequestedOrientation(6);
        }
        i1.a aVar = new i1.a(1);
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 4));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 0));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 6));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 7));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 3));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 2));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 5));
        Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
        aVar.d(new c6.s(permissionBuilder, 1));
        c6.a aVar2 = (c6.a) aVar.f5524b;
        if (aVar2 != null) {
            aVar2.i();
        }
    }

    public static void d(AppCompatActivity appCompatActivity, ActivityResultLauncher activityResultLauncher, Function0 whenGranted) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(whenGranted, "whenGranted");
        ArrayList arrayListA = a(appCompatActivity, CollectionsKt.listOf((Object[]) new Permission[]{jb.h.f6141d, jb.h.f6138a, jb.h.f6139b}));
        if (arrayListA.isEmpty()) {
            whenGranted.invoke();
        } else {
            c(appCompatActivity, arrayListA, "scanPermissions", new ag.a(whenGranted, 2), new dc.j(appCompatActivity, arrayListA, activityResultLauncher, null, 0));
        }
    }
}
