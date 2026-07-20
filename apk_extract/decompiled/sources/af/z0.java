package af;

import android.content.res.Resources;
import android.util.Log;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.view.LoadingView;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f744c;

    public /* synthetic */ z0(Object obj, boolean z2, int i8) {
        this.f742a = i8;
        this.f744c = obj;
        this.f743b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        boolean z2 = this.f743b;
        Object obj = this.f744c;
        switch (this.f742a) {
            case 0:
                e eVar = (e) obj;
                if (z2) {
                    b1 b1Var = (b1) eVar.f225c;
                    b1Var.f175o = true;
                    if (b1Var.f172l > 0) {
                        z4 z4Var = b1Var.f174n;
                        z4Var.f750b = false;
                        z4Var.b();
                    }
                }
                ((b1) eVar.f225c).f178t = false;
                return;
            default:
                int i8 = LoadingView.f3120d;
                LoadingView loadingView = (LoadingView) obj;
                loadingView.getClass();
                int measuredWidth = loadingView.getMeasuredWidth();
                Resources resources = loadingView.getContext().getResources();
                String str2 = "loading_medium.json";
                if (resources != null) {
                    if (measuredWidth <= resources.getDimensionPixelSize(R$dimen.os_loading_small_size)) {
                        str = z2 ? "loading_small_night.json" : "loading_small.json";
                    } else if (measuredWidth > resources.getDimensionPixelSize(R$dimen.os_loading_medium_size)) {
                        str = z2 ? "loading_large_night.json" : "loading_large.json";
                    } else if (z2) {
                        str2 = "loading_medium_night.json";
                    }
                    str2 = str;
                }
                InputStream inputStreamOpen = null;
                try {
                    try {
                        try {
                            inputStreamOpen = loadingView.getContext().getAssets().open(str2);
                            loadingView.f3122b.setAnimation(str2);
                            if (loadingView.f3121a) {
                                loadingView.f3122b.d();
                                break;
                            }
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            throw th2;
                        }
                    } catch (Exception e4) {
                        Log.e("LoadingView", "open asset file error", e4);
                        if (inputStreamOpen == null) {
                            return;
                        } else {
                            inputStreamOpen.close();
                        }
                    }
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return;
                }
                break;
        }
    }
}
