package oc;

import android.net.Uri;
import com.transsion.hubsdk.content.TranContentProvider;

/* JADX INFO: loaded from: classes2.dex */
public class b implements hf.b {
    @Override // hf.b
    public Uri a(Uri uri, int i10) {
        return TranContentProvider.maybeAddUserId(uri, i10);
    }
}
