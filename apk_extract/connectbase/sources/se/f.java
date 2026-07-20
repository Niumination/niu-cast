package se;

import android.content.Context;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.view.inputmethod.ITranGlobalWritingListener;
import com.transsion.hubsdk.view.inputmethod.ITranInputMethodManager;
import gm.i;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements mh.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15066b = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranInputMethodManager f15067a = ITranInputMethodManager.Stub.asInterface(TranServiceManager.getServiceIBinder("input_method_service"));

    public class a extends ITranGlobalWritingListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public sb.a f15068a;

        public a(sb.a aVar) {
            this.f15068a = aVar;
        }

        public void a() throws RemoteException {
            sb.a aVar = this.f15068a;
            if (aVar != null) {
                aVar.b();
            }
        }

        public void b(MotionEvent motionEvent, boolean z10) throws RemoteException {
            sb.a aVar = this.f15068a;
            if (aVar != null) {
                aVar.a(motionEvent, z10);
            }
        }
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
        ITranInputMethodManager iTranInputMethodManager = this.f15067a;
        if (iTranInputMethodManager != null) {
            try {
                iTranInputMethodManager.updateSecurityInputBlackList(list);
            } catch (RemoteException e10) {
                j7.b.a("updateSecurityInputBlackList fail ", e10, f15066b);
            }
        }
    }

    @Override // mh.a
    public void c(final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: se.c
            @Override // zb.f.b
            public final Object run() {
                return this.f15058a.n(i10, i11);
            }
        }, "input_method_service");
    }

    @Override // mh.a
    public void d(final sb.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: se.b
            @Override // zb.f.b
            public final Object run() {
                return this.f15056a.o(aVar);
            }
        }, "input_method_service");
        dc.e.a(f15066b, "registerGlobalWritingListener sucess");
    }

    @Override // mh.a
    public void e(final sb.a aVar) {
        new zb.f().c(new zb.f.b() { // from class: se.a
            @Override // zb.f.b
            public final Object run() {
                return this.f15054a.q(aVar);
            }
        }, "input_method_service");
        dc.e.a(f15066b, "unregisterGlobalWritingListener sucess");
    }

    @Override // mh.a
    public void f(final KeyEvent keyEvent, final String str) {
        new zb.f().c(new zb.f.b() { // from class: se.d
            @Override // zb.f.b
            public final Object run() {
                return this.f15061a.m(keyEvent, str);
            }
        }, "input_method_service");
        dc.e.a(f15066b, "commitConnectKeyAndText sucess");
    }

    @Override // mh.a
    public void g(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: se.e
            @Override // zb.f.b
            public final Object run() {
                return this.f15064a.p(z10);
            }
        }, "input_method_service");
        dc.e.a(f15066b, "switchTranInputMethod sucess");
    }

    public final /* synthetic */ Object m(KeyEvent keyEvent, String str) throws RemoteException {
        ITranInputMethodManager iTranInputMethodManager = this.f15067a;
        if (iTranInputMethodManager == null) {
            return null;
        }
        iTranInputMethodManager.commitConnectKeyAndText(keyEvent, str);
        return null;
    }

    public final /* synthetic */ Object n(int i10, int i11) throws RemoteException {
        ITranInputMethodManager iTranInputMethodManager = this.f15067a;
        if (iTranInputMethodManager == null) {
            return null;
        }
        iTranInputMethodManager.hideAllInputMethod(i10, i11);
        return null;
    }

    public final /* synthetic */ Object o(sb.a aVar) throws RemoteException {
        ITranInputMethodManager iTranInputMethodManager = this.f15067a;
        if (iTranInputMethodManager == null) {
            return null;
        }
        iTranInputMethodManager.registerGlobalWritingListener(new a(aVar));
        return null;
    }

    public final /* synthetic */ Object p(boolean z10) throws RemoteException {
        ITranInputMethodManager iTranInputMethodManager = this.f15067a;
        if (iTranInputMethodManager == null) {
            return null;
        }
        iTranInputMethodManager.switchTranInputMethod(z10);
        return null;
    }

    public final /* synthetic */ Object q(sb.a aVar) throws RemoteException {
        ITranInputMethodManager iTranInputMethodManager = this.f15067a;
        if (iTranInputMethodManager == null) {
            return null;
        }
        iTranInputMethodManager.unregisterGlobalWritingListener(new a(aVar));
        return null;
    }

    @VisibleForTesting
    public void r(ITranInputMethodManager iTranInputMethodManager) {
        this.f15067a = iTranInputMethodManager;
    }
}
