package c6;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.permissionx.guolindev.request.InvisibleFragment;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import java.util.HashSet;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f1440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedHashSet f1442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedHashSet f1443d;
    public LinkedHashSet e;
    public LinkedHashSet f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinkedHashSet f1444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinkedHashSet f1445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinkedHashSet f1446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c1.a f1447j;

    public final FragmentActivity a() {
        FragmentActivity fragmentActivity = this.f1440a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException(AtomicIntentType.ACTIVITY);
        return null;
    }

    public final FragmentManager b() {
        FragmentManager supportFragmentManager = a().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        return supportFragmentManager;
    }

    public final InvisibleFragment c() {
        Fragment fragmentFindFragmentByTag = b().findFragmentByTag("InvisibleFragment");
        if (fragmentFindFragmentByTag != null) {
            return (InvisibleFragment) fragmentFindFragmentByTag;
        }
        InvisibleFragment invisibleFragment = new InvisibleFragment();
        b().beginTransaction().add(invisibleFragment, "InvisibleFragment").commitNowAllowingStateLoss();
        return invisibleFragment;
    }

    public final int d() {
        return a().getApplicationInfo().targetSdkVersion;
    }

    public final void e(HashSet permissions, s chainTask) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        InvisibleFragment invisibleFragmentC = c();
        Intrinsics.checkNotNullParameter(this, "permissionBuilder");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(chainTask, "chainTask");
        invisibleFragmentC.f2290b = this;
        invisibleFragmentC.f2291c = chainTask;
        Object[] array = permissions.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        invisibleFragmentC.f2292d.launch(array);
    }
}
