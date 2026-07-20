package tj;

import android.os.IInterface;
import org.appspot.transsion.aiot.aidl.Message;

/* JADX INFO: loaded from: classes3.dex */
public interface m extends IInterface {
    void onConnectionLost(String str);

    void onMessageReceived(Message message);
}
