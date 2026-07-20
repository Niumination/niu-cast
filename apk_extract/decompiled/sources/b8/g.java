package b8;

import android.os.SystemProperties;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOtry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1225a = SystemProperties.getBoolean("persist.sys.traneffect.enable", true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f1226b;

    static {
        try {
            Class.forName("android.widget.AbsListView");
            f1226b = Class.forName("android.widget.HorizontalScrollView");
            Class.forName("android.widget.ScrollView");
        } catch (Exception unused) {
            Log.e("OverScrollDecorHelper", "class not found.");
        }
    }

    public static boolean a(Class cls, FrameLayout frameLayout) {
        try {
            cls.getMethod("enableTranBounceEffect", null).invoke(frameLayout, null);
            return true;
        } catch (Throwable unused) {
            Log.e("OverScrollDecorHelper", "setBounceEdgeEffect not found." + cls.toString());
            return false;
        }
    }

    public static z1OoOnew b(OverBoundNestedScrollView overBoundNestedScrollView, c8.a aVar, boolean z2) {
        if (!f1225a && !z2) {
            return null;
        }
        a(overBoundNestedScrollView.getClass(), overBoundNestedScrollView);
        Log.d("OverScrollDecorHelper", "clazz:" + overBoundNestedScrollView.getClass().toString());
        z1OoOtry z1oootry = new z1OoOtry(aVar);
        z1oootry.f11257z = new qf.c(overBoundNestedScrollView.getClass(), overBoundNestedScrollView);
        return z1oootry;
    }

    public static z1OoOnew c(RecyclerView recyclerView) {
        if (recyclerView == null) {
            Log.e("OverScrollDecorHelper", "exception recyclerView = null");
            return null;
        }
        if (!f1225a) {
            return null;
        }
        z1OoOdo z1ooodo = new z1OoOdo();
        recyclerView.setEdgeEffectFactory(z1ooodo);
        z1OoOtry z1oootry = new z1OoOtry(new c8.c(recyclerView));
        z1oootry.f11257z = z1ooodo;
        z1ooodo.e = z1oootry;
        return z1oootry;
    }
}
