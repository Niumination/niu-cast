package com.transsion.message.cast;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0007"}, d2 = {"formatTime", "", "ts", "", "formatPhone344", "num", "normalizePhone", "messagecast_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nChatActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatActivity.kt\ncom/transsion/message/cast/ChatActivityKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,417:1\n434#2:418\n507#2,5:419\n434#2:424\n507#2,5:425\n*S KotlinDebug\n*F\n+ 1 ChatActivity.kt\ncom/transsion/message/cast/ChatActivityKt\n*L\n410#1:418\n410#1:419,5\n416#1:424\n416#1:425,5\n*E\n"})
public final class ChatActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatPhone344(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() != 11) {
            return str;
        }
        String strTake = StringsKt.take(string, 3);
        String strSubstring = string.substring(3, 7);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = string.substring(7);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return strTake + " " + strSubstring + " " + strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatTime(long j8) {
        String str = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date(j8));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String normalizePhone(String str) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
