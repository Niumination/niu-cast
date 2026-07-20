package androidx.databinding.adapters;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ListenerUtil {
    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T getListener(View view, int i8) {
        return (T) view.getTag(i8);
    }

    public static <T> T trackListener(View view, T t3, int i8) {
        T t8 = (T) view.getTag(i8);
        view.setTag(i8, t3);
        return t8;
    }
}
