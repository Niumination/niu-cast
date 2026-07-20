package ic;

import android.app.Application;
import com.transsion.hubsdk.app.TranActivityThreadBridge;

/* JADX INFO: loaded from: classes2.dex */
public class g1 implements bf.h {
    @Override // bf.h
    public Application a() {
        return TranActivityThreadBridge.getApplication();
    }

    @Override // bf.h
    public Application b() {
        return TranActivityThreadBridge.currentApplication();
    }
}
