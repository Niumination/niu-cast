package w4;

import android.os.IInterface;
import android.os.RemoteException;
import com.transsion.connectx.sdk.TCCPListener;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements c0.a {
    @Override // w4.c0.a
    public final void a(IInterface iInterface) throws RemoteException {
        ((TCCPListener) iInterface).onStart();
    }
}
