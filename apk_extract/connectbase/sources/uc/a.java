package uc;

import android.content.Context;
import com.transsion.hubsdk.foldable.TranFoldingScreen;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements nf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranFoldingScreen f16253a = new TranFoldingScreen();

    @Override // nf.a
    public void a(Context context, String str) {
        cc.a.j(cc.a.g(this.f16253a.getClass(), "removeActivityEmbeddingPkg", Context.class, String.class), this.f16253a, context, str);
    }

    @Override // nf.a
    public int b(Context context) {
        return this.f16253a.getScreenRelayMode(context);
    }

    @Override // nf.a
    public void c(Context context, String str, boolean z10, boolean z11) throws ac.a {
        TranFoldingScreen tranFoldingScreen = this.f16253a;
        if (tranFoldingScreen != null) {
            tranFoldingScreen.setHoverModeStateForPackage(context, str, z10, z11);
        }
    }

    @Override // nf.a
    public int d(Context context, String str) {
        return this.f16253a.getCompatibleMode(context, str);
    }

    @Override // nf.a
    public boolean e(Context context, String str) {
        return this.f16253a.isPkgInActivityEmbedding(context, str);
    }

    @Override // nf.a
    public String f(Context context) {
        return this.f16253a.getActivityEmbeddingPkgs(context);
    }

    @Override // nf.a
    public void g(Context context, int i10) {
        this.f16253a.setScreenRelayMode(context, i10);
    }

    @Override // nf.a
    public void h(Context context, String str) {
        this.f16253a.addActivityEmbeddingPkg(context, str);
    }

    @Override // nf.a
    public void i(Context context, String str, int i10) {
        Method methodG = cc.a.g(this.f16253a.getClass(), "setCompatibleMode", Context.class, String.class, Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f16253a, context, str, Integer.valueOf(i10));
        }
    }

    @Override // nf.a
    public void j(Context context, String str, int i10, boolean z10) throws ac.a {
        TranFoldingScreen tranFoldingScreen = this.f16253a;
        if (tranFoldingScreen != null) {
            tranFoldingScreen.setCompatibleMode(context, str, i10, z10);
        }
    }

    @Override // nf.a
    public boolean k(Context context, String str) throws ac.a {
        TranFoldingScreen tranFoldingScreen = this.f16253a;
        if (tranFoldingScreen != null) {
            return tranFoldingScreen.getHoverModeStateForPackage(context, str);
        }
        return false;
    }
}
