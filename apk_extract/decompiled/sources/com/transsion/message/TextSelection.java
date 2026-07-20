package com.transsion.message;

import android.content.Context;
import com.transsion.message.bank.MessageBank;

/* JADX INFO: loaded from: classes2.dex */
public class TextSelection {
    public static final String FEATURE = "text_selection";

    public static String get(Context context) {
        return MessageBank.getInstance(context).takeMessage(FEATURE);
    }
}
