package ub;

import android.content.Context;
import android.view.View;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16250c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ue.c f16251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e9.c f16252b;

    public oh.c a(String str) {
        if (fc.b.b(str)) {
            e.f(f16250c, "TranThubToastPresenter");
            ue.c cVar = this.f16251a;
            if (cVar != null) {
                return cVar;
            }
            ue.c cVar2 = new ue.c();
            this.f16251a = cVar2;
            return cVar2;
        }
        e.f(f16250c, "TranAospToastPresenter");
        e9.c cVar3 = this.f16252b;
        if (cVar3 != null) {
            return cVar3;
        }
        e9.c cVar4 = new e9.c();
        this.f16252b = cVar4;
        return cVar4;
    }

    public View b(Context context, CharSequence charSequence) {
        return a(fc.b.a.f5989i).a(context, charSequence);
    }
}
