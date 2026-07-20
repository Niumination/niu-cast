package com.transsion.message.cast.notification;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.notification.i.SmsHandler;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007J$\u0010\u001a\u001a\u00020\t2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0007J$\u0010\u001c\u001a\u00020\t2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0007J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0007J*\u0010\u001f\u001a\u00020\t2 \u0010 \u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\fH\u0007J0\u0010!\u001a\u00020\t2&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0007J(\u0010\"\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u000fH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\r\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/transsion/message/cast/notification/SmsReplyDispatcher;", "", "<init>", "()V", "handler", "Lcom/transsion/message/cast/notification/i/SmsHandler;", "onReplyClicked", "Lkotlin/Function2;", "", "", "onMarkReadClicked", "sendStrategy", "Lkotlin/Function3;", "onNewSms", "Lkotlin/Function4;", "", "pendingNewSms", "Ljava/util/ArrayDeque;", "Lcom/transsion/message/cast/notification/SmsReplyDispatcher$NewSms;", "setHandler", "h", "dispatch", "phoneNumber", "content", "smsId", "markAsRead", "setOnReplyClicked", "cb", "setOnMarkReadClicked", "replyClicked", "markReadClicked", "setSendStrategy", "strategy", "setOnNewSms", "dispatchNewSms", "timestamp", "NewSms", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SmsReplyDispatcher {
    private static SmsHandler handler;
    private static Function2<? super String, ? super String, Unit> onMarkReadClicked;
    private static Function4<? super String, ? super String, ? super String, ? super Long, Unit> onNewSms;
    private static Function2<? super String, ? super String, Unit> onReplyClicked;
    private static Function3<? super String, ? super String, ? super String, Unit> sendStrategy;
    public static final SmsReplyDispatcher INSTANCE = new SmsReplyDispatcher();
    private static final ArrayDeque<NewSms> pendingNewSms = new ArrayDeque<>();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/transsion/message/cast/notification/SmsReplyDispatcher$NewSms;", "", "phone", "", "sid", "content", "ts", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getPhone", "()Ljava/lang/String;", "getSid", "getContent", "getTs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class NewSms {
        private final String content;
        private final String phone;
        private final String sid;
        private final long ts;

        public NewSms(String phone, String sid, String content, long j8) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(sid, "sid");
            Intrinsics.checkNotNullParameter(content, "content");
            this.phone = phone;
            this.sid = sid;
            this.content = content;
            this.ts = j8;
        }

        public static /* synthetic */ NewSms copy$default(NewSms newSms, String str, String str2, String str3, long j8, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = newSms.phone;
            }
            if ((i8 & 2) != 0) {
                str2 = newSms.sid;
            }
            String str4 = str2;
            if ((i8 & 4) != 0) {
                str3 = newSms.content;
            }
            String str5 = str3;
            if ((i8 & 8) != 0) {
                j8 = newSms.ts;
            }
            return newSms.copy(str, str4, str5, j8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSid() {
            return this.sid;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTs() {
            return this.ts;
        }

        public final NewSms copy(String phone, String sid, String content, long ts) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(sid, "sid");
            Intrinsics.checkNotNullParameter(content, "content");
            return new NewSms(phone, sid, content, ts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewSms)) {
                return false;
            }
            NewSms newSms = (NewSms) other;
            return Intrinsics.areEqual(this.phone, newSms.phone) && Intrinsics.areEqual(this.sid, newSms.sid) && Intrinsics.areEqual(this.content, newSms.content) && this.ts == newSms.ts;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getSid() {
            return this.sid;
        }

        public final long getTs() {
            return this.ts;
        }

        public int hashCode() {
            return Long.hashCode(this.ts) + a.e(a.e(this.phone.hashCode() * 31, 31, this.sid), 31, this.content);
        }

        public String toString() {
            String str = this.phone;
            String str2 = this.sid;
            String str3 = this.content;
            long j8 = this.ts;
            StringBuilder sbP = h0.a.p("NewSms(phone=", str, ", sid=", str2, ", content=");
            sbP.append(str3);
            sbP.append(", ts=");
            sbP.append(j8);
            sbP.append(")");
            return sbP.toString();
        }
    }

    private SmsReplyDispatcher() {
    }

    @JvmStatic
    public static final void dispatch(String phoneNumber, String content, String smsId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Function3<? super String, ? super String, ? super String, Unit> function3 = sendStrategy;
        if (function3 != null) {
            function3.invoke(phoneNumber, content, smsId);
            return;
        }
        SmsHandler smsHandler = handler;
        if (smsHandler != null) {
            smsHandler.sendSms(phoneNumber, content);
        }
    }

    @JvmStatic
    public static final void dispatchNewSms(String phoneNumber, String smsId, String content, long timestamp) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Intrinsics.checkNotNullParameter(content, "content");
        Function4<? super String, ? super String, ? super String, ? super Long, Unit> function4 = onNewSms;
        if (function4 != null) {
            function4.invoke(phoneNumber, smsId, content, Long.valueOf(timestamp));
            return;
        }
        ArrayDeque<NewSms> arrayDeque = pendingNewSms;
        arrayDeque.addLast(new NewSms(phoneNumber, smsId, content, timestamp));
        if (arrayDeque.size() > 100) {
            arrayDeque.pollFirst();
        }
    }

    @JvmStatic
    public static final void markAsRead(String phoneNumber, String smsId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        SmsHandler smsHandler = handler;
        if (smsHandler != null) {
            smsHandler.markSmsAsRead(phoneNumber, smsId);
        }
    }

    @JvmStatic
    public static final void markReadClicked(String phoneNumber, String smsId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Function2<? super String, ? super String, Unit> function2 = onMarkReadClicked;
        if (function2 != null) {
            function2.invoke(phoneNumber, smsId);
        }
    }

    @JvmStatic
    public static final void replyClicked(String phoneNumber, String smsId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Function2<? super String, ? super String, Unit> function2 = onReplyClicked;
        if (function2 != null) {
            function2.invoke(phoneNumber, smsId);
        }
    }

    @JvmStatic
    public static final void setHandler(SmsHandler h9) {
        handler = h9;
    }

    @JvmStatic
    public static final void setOnMarkReadClicked(Function2<? super String, ? super String, Unit> cb2) {
        onMarkReadClicked = cb2;
    }

    @JvmStatic
    public static final void setOnNewSms(Function4<? super String, ? super String, ? super String, ? super Long, Unit> cb2) {
        onNewSms = cb2;
        if (cb2 == null) {
            return;
        }
        while (true) {
            NewSms newSmsPollFirst = pendingNewSms.pollFirst();
            if (newSmsPollFirst == null) {
                return;
            } else {
                cb2.invoke(newSmsPollFirst.getPhone(), newSmsPollFirst.getSid(), newSmsPollFirst.getContent(), Long.valueOf(newSmsPollFirst.getTs()));
            }
        }
    }

    @JvmStatic
    public static final void setOnReplyClicked(Function2<? super String, ? super String, Unit> cb2) {
        onReplyClicked = cb2;
    }

    @JvmStatic
    public static final void setSendStrategy(Function3<? super String, ? super String, ? super String, Unit> strategy) {
        sendStrategy = strategy;
    }
}
