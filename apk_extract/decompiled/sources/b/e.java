package b;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import com.google.android.material.motion.MaterialBackHandler;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1169b;

    public /* synthetic */ e(Object obj, int i8) {
        this.f1168a = i8;
        this.f1169b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        int i8 = this.f1168a;
        Object obj = this.f1169b;
        switch (i8) {
            case 0:
                OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0((Function0) obj);
                break;
            case 1:
                ((Runnable) obj).run();
                break;
            default:
                ((MaterialBackHandler) obj).handleBackInvoked();
                break;
        }
    }
}
