package com.transsion.iotcardsdk.exception;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/iotcardsdk/exception/InvalidParameterException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", MessageBank.KEY_MESSAGE, "", "(Ljava/lang/String;)V", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class InvalidParameterException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidParameterException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public InvalidParameterException() {
        this("");
    }
}
