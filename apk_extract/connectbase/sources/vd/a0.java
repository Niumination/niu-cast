package vd;

import com.transsion.hubsdk.os.TranSELinux;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements pg.j {
    @Override // pg.j
    public boolean a(File file) {
        new TranSELinux();
        return TranSELinux.restorecon(file);
    }
}
