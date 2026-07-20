package re;

import android.view.KeyEvent;
import com.transsion.hubsdk.hardware.input.TranKeyEvent;

/* JADX INFO: loaded from: classes2.dex */
public class j implements lh.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14475a = "j";

    @Override // lh.e
    public KeyEvent a(long j10, long j11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, String str) {
        return TranKeyEvent.obtain(j10, j11, i10, i11, i12, i13, i14, i15, i16, i17, i18, str);
    }
}
