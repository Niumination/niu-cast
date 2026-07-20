package com.transsion.message.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.transsion.message.cast.ChatActivity;
import com.transsion.message.cast.notification.NotificationActionReceiver;
import com.transsion.message.cast.notification.SmsReplyDispatcher;
import com.transsion.widgetsliquid.view.OSLiquidButton;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSSelectImageView;
import e0.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import o.d;
import wc.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0015J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010,\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020&H\u0014J\u0010\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u0017H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020(H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/transsion/message/cast/ChatActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "tvTitle", "Landroid/widget/TextView;", "tvAddress", "llMessages", "Landroid/widget/LinearLayout;", "scrollMessages", "Landroid/widget/ScrollView;", "etInput", "Landroid/widget/EditText;", "btnSend", "Lcom/transsion/widgetslistitemlayout/OSSelectImageView;", "phoneNumber", "", "contactName", "smsId", "smsReceiver", "Landroid/content/BroadcastReceiver;", "messages", "Ljava/util/ArrayList;", "Lcom/transsion/message/cast/ChatMessage;", "seenMessageKeys", "Ljava/util/HashSet;", "lastSenderFromMe", "", "Ljava/lang/Boolean;", "lastTimeView", "lastTimestamp", "", "Ljava/lang/Long;", "mOSLiquidToolBar", "Lcom/transsion/widgetsliquid/view/OSLiquidToolBar;", "btnClose", "Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "getDataFromIntent", "onResume", "onPause", "addMessage", NotificationCompat.CATEGORY_MESSAGE, "resolveContactAddress", "number", "onSaveInstanceState", "outState", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nChatActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChatActivity.kt\ncom/transsion/message/cast/ChatActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,417:1\n1#2:418\n774#3:419\n865#3,2:420\n*S KotlinDebug\n*F\n+ 1 ChatActivity.kt\ncom/transsion/message/cast/ChatActivity\n*L\n361#1:419\n361#1:420,2\n*E\n"})
public final class ChatActivity extends ComponentActivity {
    private OSLiquidButton btnClose;
    private OSSelectImageView btnSend;
    private String contactName;
    private EditText etInput;
    private Boolean lastSenderFromMe;
    private TextView lastTimeView;
    private Long lastTimestamp;
    private LinearLayout llMessages;
    private OSLiquidToolBar mOSLiquidToolBar;
    private String phoneNumber;
    private ScrollView scrollMessages;
    private String smsId;
    private BroadcastReceiver smsReceiver;
    private TextView tvAddress;
    private TextView tvTitle;
    private final ArrayList<ChatMessage> messages = new ArrayList<>();
    private final HashSet<String> seenMessageKeys = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void addMessage(ChatMessage msg) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        int i8 = R.layout.item_message;
        LinearLayout linearLayout = this.llMessages;
        ScrollView scrollView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llMessages");
            linearLayout = null;
        }
        boolean z2 = false;
        View viewInflate = layoutInflaterFrom.inflate(i8, (ViewGroup) linearLayout, false);
        View viewFindViewById = viewInflate.findViewById(R.id.containerLeft);
        View viewFindViewById2 = viewInflate.findViewById(R.id.containerRight);
        if (msg.getFromMe()) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(0);
            ((TextView) viewInflate.findViewById(R.id.tvBubbleRight)).setText(msg.getContent());
            TextView textView = (TextView) viewInflate.findViewById(R.id.tvTimeRight);
            textView.setText(ChatActivityKt.formatTime(msg.getTimestamp()));
            float f = getResources().getDisplayMetrics().density;
            int i9 = (int) (18 * f);
            int i10 = (int) (30 * f);
            Boolean bool = this.lastSenderFromMe;
            boolean z3 = bool != null && Intrinsics.areEqual(bool, Boolean.valueOf(msg.getFromMe()));
            if (this.lastTimestamp != null) {
                long timestamp = msg.getTimestamp();
                Long l4 = this.lastTimestamp;
                if (timestamp - (l4 != null ? l4.longValue() : 0L) > 180000) {
                    z2 = true;
                }
            }
            if (!z3 || z2) {
                textView.setMinHeight(i9);
            } else {
                TextView textView2 = this.lastTimeView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                textView.setMinHeight(i10);
            }
            this.lastTimeView = textView;
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(8);
            ((TextView) viewInflate.findViewById(R.id.tvBubbleLeft)).setText(msg.getContent());
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tvTimeLeft);
            textView3.setText(ChatActivityKt.formatTime(msg.getTimestamp()));
            float f4 = getResources().getDisplayMetrics().density;
            int i11 = (int) (18 * f4);
            int i12 = (int) (30 * f4);
            Boolean bool2 = this.lastSenderFromMe;
            boolean z5 = bool2 != null && Intrinsics.areEqual(bool2, Boolean.valueOf(msg.getFromMe()));
            if (this.lastTimestamp != null) {
                long timestamp2 = msg.getTimestamp();
                Long l8 = this.lastTimestamp;
                if (timestamp2 - (l8 != null ? l8.longValue() : 0L) > 180000) {
                    z2 = true;
                }
            }
            if (!z5 || z2) {
                textView3.setMinHeight(i11);
            } else {
                TextView textView4 = this.lastTimeView;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                }
                textView3.setMinHeight(i12);
            }
            this.lastTimeView = textView3;
        }
        LinearLayout linearLayout2 = this.llMessages;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llMessages");
            linearLayout2 = null;
        }
        linearLayout2.addView(viewInflate);
        ScrollView scrollView2 = this.scrollMessages;
        if (scrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollMessages");
        } else {
            scrollView = scrollView2;
        }
        scrollView.post(new c(this, 1));
        this.lastSenderFromMe = Boolean.valueOf(msg.getFromMe());
        this.lastTimestamp = Long.valueOf(msg.getTimestamp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addMessage$lambda$9(ChatActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScrollView scrollView = this$0.scrollMessages;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollMessages");
            scrollView = null;
        }
        scrollView.fullScroll(130);
    }

    private final void getDataFromIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("smsId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.smsId = stringExtra;
        Log.d("ChatActivity", "smsId: " + stringExtra);
        String stringExtra2 = intent.getStringExtra("phoneNumber");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.phoneNumber = stringExtra2;
        Log.d("ChatActivity", "phoneNumber: " + stringExtra2);
        String stringExtra3 = intent.getStringExtra("contactName");
        String str = stringExtra3 != null ? stringExtra3 : "";
        this.contactName = str;
        d.B("contactName: ", str, "ChatActivity");
        TextView textView = this.tvTitle;
        String str2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        String str3 = this.contactName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactName");
            str3 = null;
        }
        textView.setText(str3);
        try {
            TextView textView2 = this.tvAddress;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAddress");
                textView2 = null;
            }
            String str4 = this.phoneNumber;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
            } else {
                str2 = str4;
            }
            textView2.setText(ChatActivityKt.formatPhone344(str2));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(View view, WindowInsetsCompat windowInsetsCompat) {
        int iSystemBars = WindowInsetsCompat.Type.systemBars();
        int iIme = WindowInsetsCompat.Type.ime();
        view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getInsets(iSystemBars).top, view.getPaddingRight(), Math.max(windowInsetsCompat.getInsets(iIme).bottom, windowInsetsCompat.getInsets(iSystemBars).bottom));
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ChatActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ChatActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OSLiquidButton oSLiquidButton = this$0.btnClose;
        if (oSLiquidButton != null) {
            ViewCompat.setSystemGestureExclusionRects(oSLiquidButton, CollectionsKt.listOf(new Rect(0, 0, oSLiquidButton.getWidth(), oSLiquidButton.getHeight())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(ChatActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.etInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etInput");
            editText = null;
        }
        String string = editText.getText().toString();
        if (string.length() > 0) {
            String str = this$0.phoneNumber;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
                str = null;
            }
            if (str.length() > 0) {
                String str2 = this$0.phoneNumber;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
                    str2 = null;
                }
                String str3 = this$0.smsId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("smsId");
                    str3 = null;
                }
                SmsReplyDispatcher.dispatch(str2, string, str3);
                ChatMessage chatMessage = new ChatMessage(String.valueOf(System.currentTimeMillis()), true, string, System.currentTimeMillis());
                this$0.messages.add(chatMessage);
                this$0.addMessage(chatMessage);
                this$0.seenMessageKeys.add(chatMessage.getId() + "-" + chatMessage.getTimestamp());
                EditText editText3 = this$0.etInput;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etInput");
                } else {
                    editText2 = editText3;
                }
                editText2.setText("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$6(ChatActivity this$0, String phone, String sid, String content, long j8) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(sid, "sid");
        Intrinsics.checkNotNullParameter(content, "content");
        String strNormalizePhone = ChatActivityKt.normalizePhone(phone);
        String str = this$0.phoneNumber;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
            str = null;
        }
        if (Intrinsics.areEqual(strNormalizePhone, ChatActivityKt.normalizePhone(str)) && content.length() > 0) {
            String str2 = sid + "-" + j8;
            if (!this$0.seenMessageKeys.contains(str2)) {
                if (sid.length() == 0) {
                    sid = String.valueOf(System.currentTimeMillis());
                }
                ChatMessage chatMessage = new ChatMessage(sid, false, content, j8);
                this$0.messages.add(chatMessage);
                this$0.addMessage(chatMessage);
                this$0.seenMessageKeys.add(str2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String resolveContactAddress(String number) {
        Long lValueOf;
        T tJoinToString$default;
        String string;
        int columnIndex;
        try {
            Cursor cursorQuery = getContentResolver().query(ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon().appendPath(number).build(), new String[]{"_id"}, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    lValueOf = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_id")) == -1) ? null : Long.valueOf(cursor2.getLong(columnIndex));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(cursor, th2);
                        throw th3;
                    }
                }
            } else {
                lValueOf = null;
            }
            if (lValueOf == null) {
                return null;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Cursor cursorQuery2 = getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"data1", "data7", "data8", "data4"}, "contact_id=? AND mimetype=?", new String[]{lValueOf.toString(), "vnd.android.cursor.item/postal-address_v2"}, null);
            if (cursorQuery2 != null) {
                Cursor cursor3 = cursorQuery2;
                try {
                    Cursor cursor4 = cursor3;
                    if (cursor4.moveToFirst()) {
                        int columnIndex2 = cursor4.getColumnIndex("data1");
                        int columnIndex3 = cursor4.getColumnIndex("data7");
                        int columnIndex4 = cursor4.getColumnIndex("data8");
                        int columnIndex5 = cursor4.getColumnIndex("data4");
                        if (columnIndex2 == -1 || (string = cursor4.getString(columnIndex2)) == null || string.length() == 0) {
                            List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{columnIndex4 != -1 ? cursor4.getString(columnIndex4) : null, columnIndex3 != -1 ? cursor4.getString(columnIndex3) : null, columnIndex5 != -1 ? cursor4.getString(columnIndex5) : null});
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : listListOfNotNull) {
                                if (((String) obj).length() > 0) {
                                    arrayList.add(obj);
                                }
                            }
                            tJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
                        } else {
                            tJoinToString$default = cursor4.getString(columnIndex2);
                        }
                        objectRef.element = tJoinToString$default;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor3, null);
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        CloseableKt.closeFinally(cursor3, th4);
                        throw th5;
                    }
                }
            }
            return (String) objectRef.element;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ChatActivity", "onCreate");
        OSSelectImageView oSSelectImageView = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        setContentView(R.layout.activity_chat);
        ViewCompat.setOnApplyWindowInsetsListener((LinearLayout) findViewById(R.id.rootChat), new b(10));
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.tvAddress = (TextView) findViewById(R.id.tvAddress);
        this.llMessages = (LinearLayout) findViewById(R.id.llMessages);
        this.scrollMessages = (ScrollView) findViewById(R.id.scrollMessages);
        this.etInput = (EditText) findViewById(R.id.etInput);
        this.btnSend = (OSSelectImageView) findViewById(R.id.btnSend);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        getDataFromIntent(intent);
        TextView textView = this.tvAddress;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAddress");
            textView = null;
        }
        String str = this.phoneNumber;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
            str = null;
        }
        textView.setText(ChatActivityKt.formatPhone344(str));
        this.btnClose = (OSLiquidButton) findViewById(R.id.btnClose);
        int i8 = getResources().getConfiguration().uiMode & 48;
        String str2 = i8 == 32 ? "#000000" : "#F2F2F2";
        OSLiquidButton oSLiquidButton = this.btnClose;
        if (oSLiquidButton != null) {
            oSLiquidButton.setShadowColor(Color.parseColor(str2));
        }
        String str3 = i8 == 32 ? "#E0FFFFFF" : "#000000";
        TextView textView2 = this.tvTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView2 = null;
        }
        textView2.setTextColor(Color.parseColor(str3));
        OSLiquidButton oSLiquidButton2 = this.btnClose;
        if (oSLiquidButton2 != null) {
            final int i9 = 0;
            oSLiquidButton2.setOnClickListener(new View.OnClickListener(this) { // from class: wc.b

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ChatActivity f10709b;

                {
                    this.f10709b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i10 = i9;
                    ChatActivity chatActivity = this.f10709b;
                    switch (i10) {
                        case 0:
                            ChatActivity.onCreate$lambda$1(chatActivity, view);
                            break;
                        default:
                            ChatActivity.onCreate$lambda$4(chatActivity, view);
                            break;
                    }
                }
            });
        }
        OSLiquidButton oSLiquidButton3 = this.btnClose;
        if (oSLiquidButton3 != null) {
            oSLiquidButton3.post(new c(this, 0));
        }
        String stringExtra = getIntent().getStringExtra("content");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str4 = stringExtra;
        Log.d("ChatActivity", "initialContent: ".concat(str4));
        long longExtra = getIntent().getLongExtra("timestamp", System.currentTimeMillis());
        String stringExtra2 = getIntent().getStringExtra("smsId");
        if (stringExtra2 == null) {
            stringExtra2 = this.smsId;
            if (stringExtra2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("smsId");
                stringExtra2 = null;
            }
            if (stringExtra2.length() == 0) {
                stringExtra2 = String.valueOf(System.currentTimeMillis());
            }
        }
        String str5 = stringExtra2;
        String str6 = str5 + "-" + longExtra;
        if (str4.length() > 0) {
            this.messages.clear();
            LinearLayout linearLayout = this.llMessages;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llMessages");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            this.seenMessageKeys.clear();
            ChatMessage chatMessage = new ChatMessage(str5, false, str4, longExtra);
            this.messages.add(chatMessage);
            addMessage(chatMessage);
            this.seenMessageKeys.add(str6);
        }
        EditText editText = this.etInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etInput");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.transsion.message.cast.ChatActivity.onCreate.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s2, int start, int before, int count) {
                boolean z2 = s2 == null || StringsKt.isBlank(s2);
                boolean z3 = !z2;
                OSSelectImageView oSSelectImageView2 = ChatActivity.this.btnSend;
                OSSelectImageView oSSelectImageView3 = null;
                if (oSSelectImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSend");
                    oSSelectImageView2 = null;
                }
                oSSelectImageView2.setEnabled(z3);
                try {
                    OSSelectImageView oSSelectImageView4 = ChatActivity.this.btnSend;
                    if (oSSelectImageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
                        oSSelectImageView4 = null;
                    }
                    oSSelectImageView4.setBackgroundResource(!z2 ? R.drawable.bg_send_button_circle_enabled : R.drawable.bg_send_button_circle_disabled);
                    OSSelectImageView oSSelectImageView5 = ChatActivity.this.btnSend;
                    if (oSSelectImageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
                    } else {
                        oSSelectImageView3 = oSSelectImageView5;
                    }
                    oSSelectImageView3.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")));
                } catch (Exception unused) {
                }
            }
        });
        OSSelectImageView oSSelectImageView2 = this.btnSend;
        if (oSSelectImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSend");
        } else {
            oSSelectImageView = oSSelectImageView2;
        }
        final int i10 = 1;
        oSSelectImageView.setOnClickListener(new View.OnClickListener(this) { // from class: wc.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f10709b;

            {
                this.f10709b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                ChatActivity chatActivity = this.f10709b;
                switch (i11) {
                    case 0:
                        ChatActivity.onCreate$lambda$1(chatActivity, view);
                        break;
                    default:
                        ChatActivity.onCreate$lambda$4(chatActivity, view);
                        break;
                }
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Log.d("ChatActivity", "onNewIntent");
        setIntent(intent);
        getDataFromIntent(intent);
        int intExtra = intent.getIntExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, -1);
        if (intExtra > 0 && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            try {
                NotificationManagerCompat.from(this).cancel(intExtra);
            } catch (SecurityException unused) {
            }
        }
        String stringExtra = intent.getStringExtra("smsId");
        if (stringExtra == null) {
            stringExtra = String.valueOf(System.currentTimeMillis());
        }
        String str = stringExtra;
        Log.d("ChatActivity", "onNewIntent sid: " + str);
        String stringExtra2 = intent.getStringExtra("content");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String str2 = stringExtra2;
        Log.d("ChatActivity", "onNewIntent newContent: ".concat(str2));
        long longExtra = intent.getLongExtra("timestamp", System.currentTimeMillis());
        String str3 = str + "-" + longExtra;
        boolean booleanExtra = intent.getBooleanExtra("openFromNotification", false);
        if (str2.length() > 0) {
            if (booleanExtra) {
                this.messages.clear();
                LinearLayout linearLayout = this.llMessages;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llMessages");
                    linearLayout = null;
                }
                linearLayout.removeAllViews();
                this.seenMessageKeys.clear();
            }
            if (this.seenMessageKeys.contains(str3)) {
                return;
            }
            ChatMessage chatMessage = new ChatMessage(str, false, str2, longExtra);
            this.messages.add(chatMessage);
            addMessage(chatMessage);
            this.seenMessageKeys.add(str3);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        SmsReplyDispatcher.setOnNewSms(null);
        try {
            BroadcastReceiver broadcastReceiver = this.smsReceiver;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        SmsReplyDispatcher.setOnNewSms(new Function4() { // from class: wc.a
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                long jLongValue = ((Long) obj4).longValue();
                return ChatActivity.onResume$lambda$6(this.f10707a, (String) obj, (String) obj2, (String) obj3, jLongValue);
            }
        });
        if (this.smsReceiver == null) {
            this.smsReceiver = new BroadcastReceiver() { // from class: com.transsion.message.cast.ChatActivity.onResume.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) throws IOException {
                    String stringExtra;
                    String stringExtra2;
                    String str = null;
                    if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "com.transsion.message.cast.SMS_MESSAGE_NEW") && (stringExtra = intent.getStringExtra("phoneNumber")) != null) {
                        Log.d("ChatActivity", "onReceive incomingPhone: ".concat(stringExtra));
                        String strNormalizePhone = ChatActivityKt.normalizePhone(stringExtra);
                        String str2 = ChatActivity.this.phoneNumber;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("phoneNumber");
                        } else {
                            str = str2;
                        }
                        if (Intrinsics.areEqual(strNormalizePhone, ChatActivityKt.normalizePhone(str)) && (stringExtra2 = intent.getStringExtra("content")) != null) {
                            Log.d("ChatActivity", "onReceive content: ".concat(stringExtra2));
                            long longExtra = intent.getLongExtra("timestamp", System.currentTimeMillis());
                            String stringExtra3 = intent.getStringExtra("smsId");
                            if (stringExtra3 == null) {
                                stringExtra3 = String.valueOf(System.currentTimeMillis());
                            }
                            String str3 = stringExtra3;
                            String str4 = str3 + "-" + longExtra;
                            if (ChatActivity.this.seenMessageKeys.contains(str4)) {
                                return;
                            }
                            ChatMessage chatMessage = new ChatMessage(str3, false, stringExtra2, longExtra);
                            ChatActivity.this.messages.add(chatMessage);
                            ChatActivity.this.addMessage(chatMessage);
                            ChatActivity.this.seenMessageKeys.add(str4);
                        }
                    }
                }
            };
        }
        IntentFilter intentFilter = new IntentFilter("com.transsion.message.cast.SMS_MESSAGE_NEW");
        BroadcastReceiver broadcastReceiver = this.smsReceiver;
        if (broadcastReceiver != null) {
            ContextCompat.registerReceiver(this, broadcastReceiver, intentFilter, 4);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
    }
}
