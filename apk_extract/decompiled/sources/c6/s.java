package c6;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import androidx.core.app.NotificationManagerCompat;
import com.permissionx.guolindev.request.InvisibleFragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1448d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(r rVar, int i8) {
        super(rVar);
        this.f1448d = i8;
    }

    @Override // c6.a
    public final void i() {
        switch (this.f1448d) {
            case 0:
                r rVar = (r) this.f1434b;
                if (rVar.f1443d.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    if (a.a.a(rVar.a(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                        g();
                    } else {
                        boolean zA = a.a.a(rVar.a(), "android.permission.ACCESS_FINE_LOCATION");
                        boolean zA2 = a.a.a(rVar.a(), "android.permission.ACCESS_COARSE_LOCATION");
                        if (zA || zA2) {
                            j(CollectionsKt.emptyList());
                        }
                    }
                }
                g();
                break;
            case 1:
                r rVar2 = (r) this.f1434b;
                if (rVar2.f1443d.contains("android.permission.BODY_SENSORS_BACKGROUND")) {
                    if (a.a.a(rVar2.a(), "android.permission.BODY_SENSORS_BACKGROUND")) {
                        g();
                    } else if (a.a.a(rVar2.a(), "android.permission.BODY_SENSORS")) {
                        j(CollectionsKt.emptyList());
                    }
                }
                g();
                break;
            case 2:
                r rVar3 = (r) this.f1434b;
                if (!rVar3.f1443d.contains("android.permission.REQUEST_INSTALL_PACKAGES") || rVar3.d() < 26) {
                    g();
                } else if (rVar3.a().getPackageManager().canRequestPackageInstalls()) {
                    g();
                } else {
                    g();
                }
                break;
            case 3:
                if (!((r) this.f1434b).f1443d.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    g();
                } else if (Environment.isExternalStorageManager()) {
                    g();
                } else {
                    g();
                }
                break;
            case 4:
                ArrayList arrayList = new ArrayList();
                r rVar4 = (r) this.f1434b;
                for (String str : rVar4.f1442c) {
                    if (a.a.a(rVar4.a(), str)) {
                        rVar4.f.add(str);
                    } else {
                        arrayList.add(str);
                    }
                }
                if (arrayList.isEmpty()) {
                    g();
                } else {
                    rVar4.e(rVar4.f1442c, this);
                }
                break;
            case 5:
                r rVar5 = (r) this.f1434b;
                if (rVar5.f1443d.contains("android.permission.POST_NOTIFICATIONS") && NotificationManagerCompat.from(rVar5.a()).areNotificationsEnabled()) {
                    g();
                } else {
                    g();
                }
                break;
            case 6:
                r rVar6 = (r) this.f1434b;
                if (!rVar6.f1443d.contains("android.permission.SYSTEM_ALERT_WINDOW")) {
                    g();
                } else if (rVar6.d() < 23) {
                    rVar6.f.add("android.permission.SYSTEM_ALERT_WINDOW");
                    rVar6.f1443d.remove("android.permission.SYSTEM_ALERT_WINDOW");
                    g();
                } else if (Settings.canDrawOverlays(rVar6.a())) {
                    g();
                } else {
                    g();
                }
                break;
            default:
                r rVar7 = (r) this.f1434b;
                if (!rVar7.f1443d.contains("android.permission.WRITE_SETTINGS")) {
                    g();
                } else if (rVar7.d() < 23) {
                    rVar7.f.add("android.permission.WRITE_SETTINGS");
                    rVar7.f1443d.remove("android.permission.WRITE_SETTINGS");
                    g();
                } else if (Settings.System.canWrite(rVar7.a())) {
                    g();
                } else {
                    g();
                }
                break;
        }
    }

    @Override // c6.a
    public final void j(List permissions) {
        switch (this.f1448d) {
            case 0:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder = (r) this.f1434b;
                permissionBuilder.getClass();
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC = permissionBuilder.c();
                Intrinsics.checkNotNullParameter(permissionBuilder, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC.f2290b = permissionBuilder;
                invisibleFragmentC.f2291c = this;
                invisibleFragmentC.e.launch("android.permission.ACCESS_BACKGROUND_LOCATION");
                break;
            case 1:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder2 = (r) this.f1434b;
                permissionBuilder2.getClass();
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC2 = permissionBuilder2.c();
                Intrinsics.checkNotNullParameter(permissionBuilder2, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC2.f2290b = permissionBuilder2;
                invisibleFragmentC2.f2291c = this;
                invisibleFragmentC2.f2298m.launch("android.permission.BODY_SENSORS_BACKGROUND");
                break;
            case 2:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder3 = (r) this.f1434b;
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC3 = permissionBuilder3.c();
                Intrinsics.checkNotNullParameter(permissionBuilder3, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC3.f2290b = permissionBuilder3;
                invisibleFragmentC3.f2291c = this;
                Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                intent.setData(Uri.parse("package:" + invisibleFragmentC3.requireActivity().getPackageName()));
                invisibleFragmentC3.f2296k.launch(intent);
                break;
            case 3:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder4 = (r) this.f1434b;
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC4 = permissionBuilder4.c();
                Intrinsics.checkNotNullParameter(permissionBuilder4, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC4.f2290b = permissionBuilder4;
                invisibleFragmentC4.f2291c = this;
                if (!Environment.isExternalStorageManager()) {
                    Intent intent2 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                    intent2.setData(Uri.parse("package:" + invisibleFragmentC4.requireActivity().getPackageName()));
                    if (intent2.resolveActivity(invisibleFragmentC4.requireActivity().getPackageManager()) == null) {
                        intent2 = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                    }
                    invisibleFragmentC4.f2295j.launch(intent2);
                } else if (invisibleFragmentC4.b()) {
                    invisibleFragmentC4.d(new g(invisibleFragmentC4));
                }
                break;
            case 4:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r rVar = (r) this.f1434b;
                HashSet hashSet = new HashSet(rVar.f);
                hashSet.addAll(permissions);
                if (!hashSet.isEmpty()) {
                    rVar.e(hashSet, this);
                } else {
                    g();
                }
                break;
            case 5:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder5 = (r) this.f1434b;
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC5 = permissionBuilder5.c();
                Intrinsics.checkNotNullParameter(permissionBuilder5, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC5.f2290b = permissionBuilder5;
                invisibleFragmentC5.f2291c = this;
                Intent intent3 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                intent3.putExtra("android.provider.extra.APP_PACKAGE", invisibleFragmentC5.requireActivity().getPackageName());
                invisibleFragmentC5.f2297l.launch(intent3);
                break;
            case 6:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder6 = (r) this.f1434b;
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC6 = permissionBuilder6.c();
                Intrinsics.checkNotNullParameter(permissionBuilder6, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC6.f2290b = permissionBuilder6;
                invisibleFragmentC6.f2291c = this;
                if (!Settings.canDrawOverlays(invisibleFragmentC6.requireContext())) {
                    Intent intent4 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    intent4.setData(Uri.parse("package:" + invisibleFragmentC6.requireActivity().getPackageName()));
                    invisibleFragmentC6.f2293h.launch(intent4);
                } else {
                    invisibleFragmentC6.c();
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                r permissionBuilder7 = (r) this.f1434b;
                Intrinsics.checkNotNullParameter(this, "chainTask");
                InvisibleFragment invisibleFragmentC7 = permissionBuilder7.c();
                Intrinsics.checkNotNullParameter(permissionBuilder7, "permissionBuilder");
                Intrinsics.checkNotNullParameter(this, "chainTask");
                invisibleFragmentC7.f2290b = permissionBuilder7;
                invisibleFragmentC7.f2291c = this;
                if (!Settings.System.canWrite(invisibleFragmentC7.requireContext())) {
                    Intent intent5 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent5.setData(Uri.parse("package:" + invisibleFragmentC7.requireActivity().getPackageName()));
                    invisibleFragmentC7.f2294i.launch(intent5);
                } else if (invisibleFragmentC7.b()) {
                    invisibleFragmentC7.d(new i(invisibleFragmentC7));
                }
                break;
        }
    }
}
