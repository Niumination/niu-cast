package com.transsion.tranradionet;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class TranRadioNetManagerCallback extends ITranRadioNetServiceCallback.Stub {
    private static final String TAG = "TranRadioNetServiceCallback";

    private static void loge(String str) {
        Log.e(TAG, str);
    }

    private static void logi(String str) {
        Log.i(TAG, str);
    }

    @Override // com.transsion.tranradionet.ITranRadioNetServiceCallback
    public void dispatchRilCmdResponse(int i8, int i9, int i10, String str) {
        loge("default dispatchRilCmdResponse, user should override this API");
    }

    @Override // com.transsion.tranradionet.ITranRadioNetServiceCallback
    public void onEvent(int i8, String str) {
        loge("default onEvent, user should override this API");
    }
}
