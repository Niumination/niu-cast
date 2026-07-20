package g6;

import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import us.e;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOif;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOtry;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6421a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6422b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f6423c = SystemProperties.getBoolean("persist.sys.traneffect.enable", true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f6424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f6425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f6426f;

    static {
        try {
            f6424d = Class.forName("android.widget.AbsListView");
            f6425e = Class.forName("android.widget.HorizontalScrollView");
            f6426f = Class.forName("android.widget.ScrollView");
        } catch (Exception unused) {
            Log.e("OverScrollDecorHelper", "class not found.");
        }
    }

    public static boolean a(Class cls, View view) {
        try {
            cls.getMethod("enableTranBounceEffect", null).invoke(view, null);
            return true;
        } catch (Throwable unused) {
            Log.e("OverScrollDecorHelper", "setBounceEdgeEffect not found." + cls.toString());
            return false;
        }
    }

    public static b b(View view, int i10, h6.a aVar) {
        if (!f6423c) {
            return null;
        }
        a(view.getClass(), view);
        Log.d("OverScrollDecorHelper", "clazz:" + view.getClass().toString());
        if (i10 == 0) {
            z1OoOtry z1oootry = new z1OoOtry(aVar);
            z1oootry.N = new ts.b(view.getClass(), view);
            return z1oootry;
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("orientation");
        }
        z1OoOif z1oooif = new z1OoOif(aVar);
        z1oooif.N = new ts.b(view.getClass(), view);
        return z1oooif;
    }

    public static b c(View view, int i10) {
        if (!f6423c) {
            return null;
        }
        if (i10 == 0) {
            return new z1OoOtry(new h6.a(view));
        }
        if (i10 == 1) {
            return new z1OoOif(new h6.a(view));
        }
        throw new IllegalArgumentException("orientation");
    }

    public static b d(GridView gridView) {
        if (!f6423c || !a(f6424d, gridView)) {
            return null;
        }
        z1OoOtry z1oootry = new z1OoOtry(new us.a(gridView));
        z1oootry.N = new ts.b(f6424d, gridView);
        return z1oootry;
    }

    public static b e(HorizontalScrollView horizontalScrollView) {
        if (!f6423c || !a(f6425e, horizontalScrollView)) {
            return null;
        }
        z1OoOif z1oooif = new z1OoOif(new us.c(horizontalScrollView));
        z1oooif.N = new ts.b(f6425e, horizontalScrollView);
        return z1oooif;
    }

    public static b f(ListView listView) {
        if (!f6423c || !a(f6424d, listView)) {
            return null;
        }
        z1OoOtry z1oootry = new z1OoOtry(new us.a(listView));
        z1oootry.N = new ts.b(f6424d, listView);
        return z1oootry;
    }

    public static b g(ListView listView, boolean z10) {
        b bVarF = f(listView);
        if (bVarF != null && z10) {
            bVarF.g(true);
        }
        return bVarF;
    }

    public static b h(ScrollView scrollView) {
        if (!f6423c || !a(f6426f, scrollView)) {
            return null;
        }
        z1OoOtry z1oootry = new z1OoOtry(new e(scrollView));
        z1oootry.N = new ts.b(f6426f, scrollView);
        return z1oootry;
    }

    public static b i(RecyclerView recyclerView, int i10) {
        if (!f6423c) {
            return null;
        }
        z1OoOdo z1ooodo = new z1OoOdo();
        recyclerView.setEdgeEffectFactory(z1ooodo);
        if (i10 == 0) {
            z1OoOtry z1oootry = new z1OoOtry(new us.d(recyclerView));
            z1oootry.N = z1ooodo;
            return z1oootry;
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("orientation");
        }
        z1OoOif z1oooif = new z1OoOif(new us.d(recyclerView));
        z1oooif.N = z1ooodo;
        return z1oooif;
    }

    public static b j(RecyclerView recyclerView, int i10, boolean z10) {
        b bVarI = i(recyclerView, i10);
        if (bVarI != null && z10) {
            bVarI.g(true);
        }
        return bVarI;
    }

    public static b k(ViewPager viewPager) {
        if (!f6423c) {
            return null;
        }
        viewPager.setOverScrollMode(2);
        return new z1OoOif(new z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoObyte.z1OoOtry(viewPager));
    }

    public static b l(ViewPager2 viewPager2) {
        if (!f6423c) {
            return null;
        }
        viewPager2.setOverScrollMode(2);
        return new z1OoOif(new z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOcase.z1OoOdo(viewPager2));
    }

    public static b m(ViewPager2 viewPager2, int i10) {
        if (!f6423c) {
            return null;
        }
        viewPager2.setOverScrollMode(2);
        if (i10 == 0) {
            return new z1OoOtry(new z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOcase.z1OoOdo(viewPager2));
        }
        if (i10 == 1) {
            return new z1OoOif(new z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOcase.z1OoOdo(viewPager2));
        }
        throw new IllegalArgumentException("orientation");
    }
}
