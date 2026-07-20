package e9;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class c implements oh.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f4165a = cc.a.a("android.widget.ToastPresenter");

    @Override // oh.c
    public View a(Context context, CharSequence charSequence) {
        Object objJ = cc.a.j(cc.a.g(f4165a, "getTextToastView", Context.class, CharSequence.class), null, context, charSequence);
        if (objJ == null || !(objJ instanceof View)) {
            return null;
        }
        return (View) objJ;
    }
}
