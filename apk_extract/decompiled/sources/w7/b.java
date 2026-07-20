package w7;

import android.app.KeyguardManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends KeyguardManager.KeyguardDismissCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f10677a;

    public b(Function0 function0) {
        this.f10677a = function0;
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public final void onDismissSucceeded() {
        super.onDismissSucceeded();
        Function0 function0 = this.f10677a;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
