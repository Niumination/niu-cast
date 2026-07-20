package b8;

import android.content.Context;
import android.nfc.NfcAdapter;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements mg.a {
    @Override // mg.a
    public NfcAdapter a(Context context) {
        Method methodG = cc.a.g(NfcAdapter.class, "getNfcAdapter", Context.class);
        if (methodG != null) {
            return (NfcAdapter) cc.a.j(methodG, null, context);
        }
        return null;
    }

    @Override // mg.a
    public int b(NfcAdapter nfcAdapter) {
        Method methodG = cc.a.g(nfcAdapter.getClass(), "getAdapterState", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, nfcAdapter, new Object[0])).intValue();
        }
        return 1;
    }
}
