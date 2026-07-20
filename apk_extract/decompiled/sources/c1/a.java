package c1;

import androidx.core.os.CancellationSignal;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CancellationSignal.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1362c;

    public /* synthetic */ a(Runnable runnable, Transition transition, Runnable runnable2) {
        this.f1360a = runnable;
        this.f1362c = transition;
        this.f1361b = runnable2;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.f1360a, (Transition) this.f1362c, (Runnable) this.f1361b);
    }

    public /* synthetic */ a(String str, Function0 function0, Function0 function1) {
        this.f1360a = str;
        this.f1361b = function0;
        this.f1362c = function1;
    }
}
