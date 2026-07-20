package ne;

import com.transsion.hubsdk.tranthubutils.TranConfigs;
import java.io.File;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements hh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranConfigs f11450a = new TranConfigs();

    @Override // hh.b
    public File a(String str) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getConfigs(str);
    }

    @Override // hh.b
    public void b(String str) {
        if (this.f11450a == null) {
            return;
        }
        TranConfigs.initialize(str);
    }

    @Override // hh.b
    public File c(String str, boolean z10) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getNativeLibrary(str, z10);
    }

    @Override // hh.b
    public File d(String str, String str2) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getAsset(str, str2);
    }

    @Override // hh.b
    public File e(String str) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getLibrary(str);
    }

    @Override // hh.b
    public List<File> f(String str) {
        TranConfigs tranConfigs = this.f11450a;
        return tranConfigs == null ? Collections.emptyList() : tranConfigs.getConfigsList(str);
    }

    @Override // hh.b
    public File g(String str, String str2) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getConfigs(str, str2);
    }

    @Override // hh.b
    public File h(String str) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getMedia(str);
    }

    @Override // hh.b
    public File i(String str) {
        TranConfigs tranConfigs = this.f11450a;
        if (tranConfigs == null) {
            return null;
        }
        return tranConfigs.getAsset(str);
    }

    @Override // hh.b
    public List<File> j(String str, String str2) {
        TranConfigs tranConfigs = this.f11450a;
        return tranConfigs == null ? Collections.emptyList() : tranConfigs.getConfigsList(str, str2);
    }
}
