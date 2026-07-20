package jj;

import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import com.transsion.widgetslib.view.followsoft.RootViewDeferringInsetsCallback;
import com.transsion.widgetslib.view.followsoft.TranslateDeferringInsetsAnimationCallback;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(Window window, int i10, View... viewArr) {
        WindowCompat.setDecorFitsSystemWindows(window, false);
        RootViewDeferringInsetsCallback rootViewDeferringInsetsCallback = new RootViewDeferringInsetsCallback(i10, WindowInsetsCompat.Type.ime());
        ViewCompat.setWindowInsetsAnimationCallback(window.getDecorView(), rootViewDeferringInsetsCallback);
        ViewCompat.setOnApplyWindowInsetsListener(window.getDecorView(), rootViewDeferringInsetsCallback);
        for (View view : viewArr) {
            ViewCompat.setWindowInsetsAnimationCallback(view, new TranslateDeferringInsetsAnimationCallback(view, i10, WindowInsetsCompat.Type.ime(), 1));
        }
    }

    public static void b(Window window, View... viewArr) {
        a(window, WindowInsetsCompat.Type.statusBars(), viewArr);
    }

    public static void c(Window window, View view, View... viewArr) {
        WindowCompat.setDecorFitsSystemWindows(window, false);
        RootViewDeferringInsetsCallback rootViewDeferringInsetsCallback = new RootViewDeferringInsetsCallback(WindowInsetsCompat.Type.systemBars(), WindowInsetsCompat.Type.ime());
        ViewCompat.setWindowInsetsAnimationCallback(view, rootViewDeferringInsetsCallback);
        ViewCompat.setOnApplyWindowInsetsListener(view, rootViewDeferringInsetsCallback);
        for (View view2 : viewArr) {
            ViewCompat.setWindowInsetsAnimationCallback(view2, new TranslateDeferringInsetsAnimationCallback(view2, WindowInsetsCompat.Type.systemBars(), WindowInsetsCompat.Type.ime(), 1));
        }
    }
}
