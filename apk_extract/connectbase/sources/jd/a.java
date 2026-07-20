package jd;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import com.transsion.hubsdk.internal.policy.TranPhoneWindow;

/* JADX INFO: loaded from: classes2.dex */
public class a implements cg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranPhoneWindow f8674a;

    public a(Context context) {
        this.f8674a = new TranPhoneWindow(context);
    }

    @Override // cg.a
    public View a() {
        return this.f8674a.getDecorView();
    }

    @Override // cg.a
    public boolean b(int i10) {
        return this.f8674a.requestFeature(i10);
    }

    @Override // cg.a
    public void c(int i10) {
        this.f8674a.setBackgroundDrawableResource(i10);
    }

    @Override // cg.a
    public void d(WindowManager windowManager, IBinder iBinder, String str) {
        this.f8674a.setWindowManager(windowManager, iBinder, str);
    }
}
