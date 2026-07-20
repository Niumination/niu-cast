package androidx.lifecycle;

import android.app.Application;
import kn.l0;
import n1.i;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {

    @l
    private final Application application;

    public AndroidViewModel(@l Application application) {
        l0.p(application, i.f11236l);
        this.application = application;
    }

    @l
    public <T extends Application> T getApplication() {
        T t10 = (T) this.application;
        l0.n(t10, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t10;
    }
}
