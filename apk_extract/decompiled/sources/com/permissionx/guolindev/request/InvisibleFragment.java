package com.permissionx.guolindev.request;

import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import c6.a;
import c6.c;
import c6.r;
import com.permissionx.guolindev.request.InvisibleFragment;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/permissionx/guolindev/request/InvisibleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "permissionx_release"}, k = 1, mv = {1, 7, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InvisibleFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2289a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f2290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f2291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ActivityResultLauncher f2292d;
    public final ActivityResultLauncher e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ActivityResultLauncher f2293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ActivityResultLauncher f2294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ActivityResultLauncher f2295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ActivityResultLauncher f2296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ActivityResultLauncher f2297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ActivityResultLauncher f2298m;

    public InvisibleFragment() {
        final int i8 = 0;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i8) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f2292d = activityResultLauncherRegisterForActivityResult;
        final int i9 = 1;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i9) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…)\n            }\n        }");
        this.e = activityResultLauncherRegisterForActivityResult2;
        final int i10 = 2;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i10) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResul…)\n            }\n        }");
        this.f2293h = activityResultLauncherRegisterForActivityResult3;
        final int i11 = 3;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i11) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult4, "registerForActivityResul…)\n            }\n        }");
        this.f2294i = activityResultLauncherRegisterForActivityResult4;
        final int i12 = 4;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i12) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult5, "registerForActivityResul…)\n            }\n        }");
        this.f2295j = activityResultLauncherRegisterForActivityResult5;
        final int i13 = 5;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult6 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i13) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult6, "registerForActivityResul…)\n            }\n        }");
        this.f2296k = activityResultLauncherRegisterForActivityResult6;
        final int i14 = 6;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult7 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i14) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult7, "registerForActivityResul…)\n            }\n        }");
        this.f2297l = activityResultLauncherRegisterForActivityResult7;
        final int i15 = 7;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult8 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i15) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult8, "registerForActivityResul…)\n            }\n        }");
        this.f2298m = activityResultLauncherRegisterForActivityResult8;
        final int i16 = 8;
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c6.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvisibleFragment f1437b;

            {
                this.f1437b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                switch (i16) {
                    case 0:
                        InvisibleFragment this$0 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        this$0.d(new n(this$0, (Map) obj));
                        break;
                    case 1:
                        InvisibleFragment this$1 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$1, "this$0");
                        this$1.d(new j(this$1, (Boolean) obj));
                        break;
                    case 2:
                        InvisibleFragment this$2 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$2, "this$0");
                        this$2.d(new p(this$2));
                        break;
                    case 3:
                        InvisibleFragment this$3 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$3, "this$0");
                        this$3.d(new q(this$3));
                        break;
                    case 4:
                        InvisibleFragment this$4 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$4, "this$0");
                        this$4.d(new m(this$4));
                        break;
                    case 5:
                        InvisibleFragment this$5 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$5, "this$0");
                        this$5.d(new l(this$5));
                        break;
                    case 6:
                        InvisibleFragment this$6 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$6, "this$0");
                        this$6.d(new o(this$6));
                        break;
                    case 7:
                        InvisibleFragment this$7 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$7, "this$0");
                        this$7.d(new k(this$7, (Boolean) obj));
                        break;
                    default:
                        InvisibleFragment this$8 = this.f1437b;
                        Intrinsics.checkNotNullParameter(this$8, "this$0");
                        if (this$8.b()) {
                            a aVar = this$8.f2291c;
                            r rVar = null;
                            if (aVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("task");
                                aVar = null;
                            }
                            r rVar2 = this$8.f2290b;
                            if (rVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pb");
                            } else {
                                rVar = rVar2;
                            }
                            aVar.j(new ArrayList(rVar.f1446i));
                        }
                        break;
                }
            }
        }), "registerForActivityResul…)\n            }\n        }");
    }

    public final boolean b() {
        if (this.f2290b != null && this.f2291c != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }

    public final void c() {
        if (b()) {
            r rVar = null;
            a aVar = null;
            if (Settings.canDrawOverlays(requireContext())) {
                a aVar2 = this.f2291c;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("task");
                } else {
                    aVar = aVar2;
                }
                aVar.g();
                return;
            }
            r rVar2 = this.f2290b;
            if (rVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar2 = null;
            }
            rVar2.getClass();
            r rVar3 = this.f2290b;
            if (rVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
            } else {
                rVar = rVar3;
            }
            rVar.getClass();
        }
    }

    public final void d(Function0 function0) {
        this.f2289a.post(new c(0, function0));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (b()) {
            r rVar = this.f2290b;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar = null;
            }
            rVar.getClass();
        }
    }
}
