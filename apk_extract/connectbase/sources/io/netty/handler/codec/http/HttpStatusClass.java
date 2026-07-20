package io.netty.handler.codec.http;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.widgetslib.view.swipmenu.OSSwipeMenuLayout;
import io.netty.util.AsciiString;

/* JADX INFO: loaded from: classes3.dex */
public enum HttpStatusClass {
    INFORMATIONAL(100, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, "Informational"),
    SUCCESS(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 300, "Success"),
    REDIRECTION(300, 400, "Redirection"),
    CLIENT_ERROR(400, OSSwipeMenuLayout.D0, "Client Error"),
    SERVER_ERROR(OSSwipeMenuLayout.D0, 600, "Server Error"),
    UNKNOWN(0, 0, "Unknown Status") { // from class: io.netty.handler.codec.http.HttpStatusClass.1
        @Override // io.netty.handler.codec.http.HttpStatusClass
        public boolean contains(int i10) {
            return i10 < 100 || i10 >= 600;
        }
    };

    private static final HttpStatusClass[] statusArray;
    private final AsciiString defaultReasonPhrase;
    private final int max;
    private final int min;

    static {
        HttpStatusClass httpStatusClass = INFORMATIONAL;
        HttpStatusClass httpStatusClass2 = SUCCESS;
        HttpStatusClass httpStatusClass3 = REDIRECTION;
        HttpStatusClass httpStatusClass4 = CLIENT_ERROR;
        HttpStatusClass httpStatusClass5 = SERVER_ERROR;
        HttpStatusClass[] httpStatusClassArr = new HttpStatusClass[6];
        statusArray = httpStatusClassArr;
        httpStatusClassArr[1] = httpStatusClass;
        httpStatusClassArr[2] = httpStatusClass2;
        httpStatusClassArr[3] = httpStatusClass3;
        httpStatusClassArr[4] = httpStatusClass4;
        httpStatusClassArr[5] = httpStatusClass5;
    }

    private static int digit(char c10) {
        return c10 - '0';
    }

    private static int fast_div100(int i10) {
        return (int) ((((long) i10) * 1374389535) >> 37);
    }

    private static boolean isDigit(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public boolean contains(int i10) {
        return i10 >= this.min && i10 < this.max;
    }

    public AsciiString defaultReasonPhrase() {
        return this.defaultReasonPhrase;
    }

    HttpStatusClass(int i10, int i11, String str) {
        this.min = i10;
        this.max = i11;
        this.defaultReasonPhrase = AsciiString.cached(str);
    }

    public static HttpStatusClass valueOf(int i10) {
        HttpStatusClass httpStatusClass = UNKNOWN;
        return httpStatusClass.contains(i10) ? httpStatusClass : statusArray[fast_div100(i10)];
    }

    public static HttpStatusClass valueOf(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() == 3) {
            char cCharAt = charSequence.charAt(0);
            return (isDigit(cCharAt) && isDigit(charSequence.charAt(1)) && isDigit(charSequence.charAt(2))) ? valueOf(digit(cCharAt) * 100) : UNKNOWN;
        }
        return UNKNOWN;
    }
}
