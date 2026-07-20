package m7;

import android.content.Context;
import android.os.RemoteException;
import com.android.internal.app.IAppOpsActiveCallback;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10577b = "TranAospAppOpsServiceExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10578a;

    public interface a {
        void a(int i10, int i11, String str, String str2, boolean z10, int i12, int i13);
    }

    public static class b extends IAppOpsActiveCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f10579a;

        public b(a aVar) {
            this.f10579a = aVar;
        }

        public void a(int i10, int i11, String str, String str2, int i12, boolean z10, int i13, int i14) throws RemoteException {
            a aVar = this.f10579a;
            if (aVar != null) {
                aVar.a(i10, i11, str, str2, z10, i13, i14);
            }
        }
    }

    public c(Context context) {
        this.f10578a = context;
    }
}
