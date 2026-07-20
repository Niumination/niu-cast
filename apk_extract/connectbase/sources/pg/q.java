package pg;

import android.os.UserHandle;
import com.transsion.hubsdk.api.os.TranUserInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface q {
    TranUserInfo a(int i10);

    TranUserInfo b(String str, String str2, int i10, int i11, String[] strArr);

    int[] c(int i10);

    boolean d(int i10);

    UserHandle e(String str, String str2, String[] strArr);

    boolean f(int i10);

    void g(String str, boolean z10, UserHandle userHandle);

    int h(int i10);

    boolean i(int i10, boolean z10);

    boolean j(String str, int i10);

    List<TranUserInfo> k();

    List<UserHandle> l();

    TranUserInfo m(String str, String str2, int i10, int i11, String[] strArr);

    boolean n();

    List<TranUserInfo> o(boolean z10);

    boolean p(int i10);

    List<TranUserInfo> q(int i10);
}
