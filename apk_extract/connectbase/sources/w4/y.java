package w4;

import android.os.IInterface;
import android.os.RemoteException;
import com.transsion.connectx.sdk.SendFileTransferListener;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class y implements c0.a {
    @Override // w4.c0.a
    public final void a(IInterface iInterface) throws RemoteException {
        ((SendFileTransferListener) iInterface).onTransferFinish();
    }
}
