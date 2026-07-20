package com.transsion.message.cast.transfer.i;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.transfer.data.SmsInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/transsion/message/cast/transfer/i/SmsInterface;", "", "onSmsReceived", "", "smsInfo", "Lcom/transsion/message/cast/transfer/data/SmsInfo;", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface SmsInterface {
    void onSmsReceived(SmsInfo smsInfo);
}
