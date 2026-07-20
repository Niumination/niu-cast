package com.transsion.iotservice.multiscreen.pc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import cj.d;
import com.transsion.iotservice.multiscreen.pc.receiver.HomeKeyReceiver;
import com.transsion.iotservice.multiscreen.pc.ui.BlankActivity;
import java.util.ArrayList;
import k3.gc;
import k3.o1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import qb.b;
import se.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/BlankActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "k3/oc", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class BlankActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Runnable f2696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f2697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f2698d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HomeKeyReceiver f2699a;

    public final void j() {
        l0.p(LifecycleOwnerKt.getLifecycleScope(this), null, null, new b(this, null), 3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intrinsics.checkNotNullParameter("BlankActivity", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BlankActivity"), "onCreate");
        }
        if (f2697c == null) {
            j();
            return;
        }
        final int i8 = 0;
        HomeKeyReceiver homeKeyReceiver = new HomeKeyReceiver(new Function0(this) { // from class: qb.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BlankActivity f8976b;

            {
                this.f8976b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                BlankActivity blankActivity = this.f8976b;
                switch (i8) {
                    case 0:
                        Runnable runnable = BlankActivity.f2696b;
                        Intrinsics.checkNotNullParameter("BlankActivity", "tag");
                        Intrinsics.checkNotNullParameter("onHomePressed", "log");
                        if (gc.f6462a <= 5) {
                            Log.w(gc.f6463b.concat("BlankActivity"), "onHomePressed");
                        }
                        blankActivity.j();
                        break;
                    default:
                        Runnable runnable2 = BlankActivity.f2696b;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        blankActivity.j();
                        break;
                }
                return Unit.INSTANCE;
            }
        });
        va.b.f(this, homeKeyReceiver, "android.intent.action.CLOSE_SYSTEM_DIALOGS", false);
        this.f2699a = homeKeyReceiver;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a4.b(this, 20));
        ArrayList arrayList = f2697c;
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotGrantPermissions");
            arrayList = null;
        }
        if (h.l(this, activityResultLauncherRegisterForActivityResult, arrayList, f2698d)) {
            return;
        }
        ArrayList arrayList3 = f2697c;
        if (arrayList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotGrantPermissions");
        } else {
            arrayList2 = arrayList3;
        }
        final int i9 = 1;
        o1.c(this, arrayList2, "scanPermissions", new Function0(this) { // from class: qb.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ BlankActivity f8976b;

            {
                this.f8976b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                BlankActivity blankActivity = this.f8976b;
                switch (i9) {
                    case 0:
                        Runnable runnable = BlankActivity.f2696b;
                        Intrinsics.checkNotNullParameter("BlankActivity", "tag");
                        Intrinsics.checkNotNullParameter("onHomePressed", "log");
                        if (gc.f6462a <= 5) {
                            Log.w(gc.f6463b.concat("BlankActivity"), "onHomePressed");
                        }
                        blankActivity.j();
                        break;
                    default:
                        Runnable runnable2 = BlankActivity.f2696b;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        blankActivity.j();
                        break;
                }
                return Unit.INSTANCE;
            }
        }, new d(2, this, activityResultLauncherRegisterForActivityResult));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Intrinsics.checkNotNullParameter("BlankActivity", "tag");
        Intrinsics.checkNotNullParameter("onDestroy", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BlankActivity"), "onDestroy");
        }
        HomeKeyReceiver homeKeyReceiver = this.f2699a;
        if (homeKeyReceiver != null) {
            unregisterReceiver(homeKeyReceiver);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Intrinsics.checkNotNullParameter("BlankActivity", "tag");
        Intrinsics.checkNotNullParameter("onNewIntent: duplicate call", "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("BlankActivity"), "onNewIntent: duplicate call");
        }
    }
}
