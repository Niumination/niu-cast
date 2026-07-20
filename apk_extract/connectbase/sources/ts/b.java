package ts;

import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f16070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f16071b;

    public b(Class cls, View view) {
        this.f16070a = view;
        this.f16071b = cls;
    }

    @Override // ts.a
    public void a() {
        try {
            Log.d("BounceEffect", "cancelTranBounceAnimation called " + this.f16071b.toString());
            this.f16071b.getMethod("cancelTranBounceAnimation", null).invoke(this.f16070a, null);
        } catch (Throwable unused) {
            Log.e("BounceEffect", "cancelTranBounceAnimation not found." + this.f16071b.toString());
        }
    }
}
