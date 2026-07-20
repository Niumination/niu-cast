package com.transsion.message.cast.notification.i;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/transsion/message/cast/notification/i/CallHandler;", "", "answerCall", "", "callId", "", "rejectCall", "setAudioOutput", "output", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface CallHandler {
    void answerCall(String callId);

    void rejectCall(String callId);

    void setAudioOutput(String callId, EAudioOutput output);
}
