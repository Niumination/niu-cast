package com.transsion.message.cast.analytics.p000const;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/transsion/message/cast/analytics/const/EAnalyticsEvent;", "", "<init>", "()V", "IOT_PC_CALL_TRANSFER", "", "IOT_PC_CANCEL_CALL_EVENT", "IOT_PC_SWITCH_OUTPUT_AUDIO_EVENT", "IOT_PC_SMS_TRANSFER", "IOT_PC_CANCEL_SMS_EVENT", "IOT_PC_REPLY_SMS_EVENT", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class EAnalyticsEvent {
    public static final EAnalyticsEvent INSTANCE = new EAnalyticsEvent();
    public static final String IOT_PC_CALL_TRANSFER = "iot_multi_con_phone_call_sync_exp";
    public static final String IOT_PC_CANCEL_CALL_EVENT = "iot_multi_con_phone_call_sync_cancel";
    public static final String IOT_PC_CANCEL_SMS_EVENT = "iot_multi_con_message_sync_cancel";
    public static final String IOT_PC_REPLY_SMS_EVENT = "iot_multi_con_message_sync_reply_click";
    public static final String IOT_PC_SMS_TRANSFER = "iot_multi_con_message_sync_exp";
    public static final String IOT_PC_SWITCH_OUTPUT_AUDIO_EVENT = "iot_multi_con_phone_call_speaker_switch";

    private EAnalyticsEvent() {
    }
}
