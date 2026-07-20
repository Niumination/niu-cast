package c9;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.transsion.connectx.sdk.TCCPSourceApi;
import dc.e;
import gm.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements mh.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1383c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f1384d = cc.a.a("android.view.inputmethod.InputMethodManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InputMethodManager f1386b;

    public a() {
        Context contextA = bc.a.a();
        this.f1385a = contextA;
        this.f1386b = (InputMethodManager) contextA.getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
    }

    @Override // mh.a
    public void a(Context context, @i Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        if (inputMethodManager == null) {
            return;
        }
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i10]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if ((obj instanceof View) && ((View) obj).getRootView() == window.getDecorView().getRootView()) {
                    declaredField.set(inputMethodManager, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // mh.a
    public void b(List<String> list) {
        try {
            Method methodG = cc.a.g(f1384d, "updateSecurityInputBlackList", List.class);
            methodG.setAccessible(true);
            methodG.invoke(this.f1386b, list);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f1383c, "updateSecurityInputBlackList fail " + e10);
        }
    }

    @Override // mh.a
    public void c(int i10, int i11) {
        e.n(f1383c, "AOSP does not support hideAllInputMethod");
    }

    @Override // mh.a
    public void d(sb.a aVar) {
    }

    @Override // mh.a
    public void e(sb.a aVar) {
    }

    @Override // mh.a
    public void f(KeyEvent keyEvent, String str) {
        cc.a.j(cc.a.g(this.f1386b.getClass(), "commitConnectKeyAndText", KeyEvent.class, String.class), this.f1386b, keyEvent, str);
    }

    @Override // mh.a
    public void g(boolean z10) {
    }
}
