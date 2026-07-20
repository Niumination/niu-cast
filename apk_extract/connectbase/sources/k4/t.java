package k4;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static /* synthetic */ void c(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static /* synthetic */ void d(Context context, int i10) {
        Toast.makeText(context, context.getText(i10), 0).show();
    }

    public static void e(final int i10, final Context context) {
        i6.a.b.f7724a.a(new Runnable() { // from class: k4.s
            @Override // java.lang.Runnable
            public final void run() {
                t.d(context, i10);
            }
        });
    }

    public static void f(final String str, final Context context) {
        i6.a.b.f7724a.a(new Runnable() { // from class: k4.r
            @Override // java.lang.Runnable
            public final void run() {
                t.c(context, str);
            }
        });
    }
}
