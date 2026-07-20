package tf;

import android.hardware.fingerprint.FingerprintManager;
import com.transsion.hubsdk.api.hardware.fingerprint.TranFingerprintInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    boolean a();

    void b(boolean z10) throws ac.a;

    List<TranFingerprintInfo> c(int i10);

    void d(int i10, String str);

    void e(int i10);

    void f(int i10);

    void g(boolean z10);

    String h(int i10);

    void i(String str, boolean z10);

    int j(FingerprintManager.AuthenticationResult authenticationResult);

    void k(boolean z10);

    TranFingerprintInfo l(int i10);

    void m(int i10, String str, int i11);

    boolean n();

    int o(int i10);
}
