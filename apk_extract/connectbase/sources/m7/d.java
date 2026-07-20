package m7;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.app.AssistUtils;
import com.android.internal.app.IVoiceInteractionSessionShowCallback;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10580b = "TranAospAssistUtilsExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10581a;

    public interface a {
        void a();

        void onShown();
    }

    public static class b extends IVoiceInteractionSessionShowCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f10582a;

        public b(a aVar) {
            this.f10582a = aVar;
        }

        public void a() throws RemoteException {
            a aVar = this.f10582a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public void b() throws RemoteException {
            a aVar = this.f10582a;
            if (aVar != null) {
                aVar.onShown();
            }
        }
    }

    public d(Context context) {
        this.f10581a = context;
    }

    public boolean a(Bundle bundle, int i10, a aVar, IBinder iBinder) {
        try {
            return new AssistUtils(this.f10581a).showSessionForActiveService(bundle, i10, new b(aVar), iBinder);
        } catch (Exception e10) {
            p6.b.a("showSessionForActiveService fail ", e10, f10580b);
            return false;
        }
    }
}
