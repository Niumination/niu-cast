package qd;

import android.content.Context;
import android.nfc.NfcAdapter;
import com.transsion.hubsdk.nfc.TranNfcAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class k implements mg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranNfcAdapter f13985a = new TranNfcAdapter();

    @Override // mg.a
    public NfcAdapter a(Context context) {
        TranNfcAdapter tranNfcAdapter = this.f13985a;
        if (tranNfcAdapter != null) {
            return (NfcAdapter) tranNfcAdapter.getNfcAdapter(context);
        }
        return null;
    }

    @Override // mg.a
    public int b(NfcAdapter nfcAdapter) {
        TranNfcAdapter tranNfcAdapter = this.f13985a;
        if (tranNfcAdapter != null) {
            return tranNfcAdapter.getAdapterState(nfcAdapter);
        }
        return 1;
    }
}
