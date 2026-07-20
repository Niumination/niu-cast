package androidx.window.layout;

import androidx.core.util.Consumer;
import ni.d0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f1154b;

    public /* synthetic */ a(d0 d0Var, int i8) {
        this.f1153a = i8;
        this.f1154b = d0Var;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        int i8 = this.f1153a;
        d0 d0Var = this.f1154b;
        WindowLayoutInfo windowLayoutInfo = (WindowLayoutInfo) obj;
        switch (i8) {
            case 0:
                WindowInfoTrackerImpl.AnonymousClass1.invokeSuspend$lambda$0(d0Var, windowLayoutInfo);
                break;
            default:
                WindowInfoTrackerImpl.AnonymousClass2.invokeSuspend$lambda$0(d0Var, windowLayoutInfo);
                break;
        }
    }
}
