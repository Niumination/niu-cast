package ic;

import android.app.Activity;
import com.transsion.hubsdk.app.TranActivity;

/* JADX INFO: loaded from: classes2.dex */
public class b implements bf.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7773b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranActivity f7774a;

    @Override // bf.b
    public void a(Object obj) {
        if (this.f7774a == null) {
            this.f7774a = new TranActivity();
        }
        this.f7774a.setupAlert(obj);
    }

    @Override // bf.b
    public String b(Activity activity) {
        return null;
    }

    @Override // bf.b
    @Deprecated
    public void c(int i10, String str, String str2, String str3, boolean z10) {
        if (fc.a.f()) {
            if (this.f7774a == null) {
                this.f7774a = new TranActivity();
            }
            this.f7774a.sceneHappen(i10, str, str2, str3, z10);
        }
    }
}
