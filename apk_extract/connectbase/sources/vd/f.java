package vd;

import com.transsion.hubsdk.os.TranEnvironment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class f implements pg.e {
    @Override // pg.e
    public File a() {
        return TranEnvironment.getProductDirectory();
    }

    @Override // pg.e
    public File b(int i10) {
        return TranEnvironment.getDataVendorDeDirectory(i10);
    }

    @Override // pg.e
    public File[] c(String str) {
        return TranEnvironment.buildExternalStorageAppDataDirs(str);
    }
}
