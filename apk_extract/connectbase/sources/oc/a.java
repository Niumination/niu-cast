package oc;

import android.content.BroadcastReceiver;
import com.transsion.hubsdk.content.TranBroadcastReceiverHelper;

/* JADX INFO: loaded from: classes2.dex */
public class a implements hf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranBroadcastReceiverHelper f12170a = new TranBroadcastReceiverHelper();

    @Override // hf.a
    public int a(BroadcastReceiver broadcastReceiver) {
        return this.f12170a.getSendingUserId(broadcastReceiver);
    }
}
