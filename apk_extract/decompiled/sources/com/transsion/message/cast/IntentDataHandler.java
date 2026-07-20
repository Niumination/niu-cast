package com.transsion.message.cast;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.phonenumber.GeoCoderManager;
import com.transsion.message.cast.transfer.data.CallInfo;
import com.transsion.message.cast.transfer.data.SmsInfo;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import com.transsion.message.cast.transfer.i.TransferServiceListener;
import h0.a;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/transsion/message/cast/IntentDataHandler;", "", "listener", "Lcom/transsion/message/cast/transfer/i/TransferServiceListener;", "<init>", "(Lcom/transsion/message/cast/transfer/i/TransferServiceListener;)V", "tag", "", "handleIntent", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "parseAndHandleExternalIntent", "handleIncomingCallData", "contentJson", "Lorg/json/JSONObject;", "callId", "handleSmsData", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IntentDataHandler {
    private final TransferServiceListener listener;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public IntentDataHandler() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    private final void handleIncomingCallData(Context context, JSONObject contentJson, String callId) {
        String str;
        String str2;
        EAudioOutput eAudioOutput;
        String strOptString = contentJson.optString("phoneNumber");
        String strOptString2 = contentJson.optString("contactName");
        String strOptString3 = contentJson.optString("location");
        d.B("Initial location: ", strOptString3, this.tag);
        if (strOptString2 == null || strOptString2.length() == 0) {
            d.B("Contact name not provided, using phone number: ", strOptString, this.tag);
            str = strOptString;
        } else {
            str = strOptString2;
        }
        if (strOptString3 == null || strOptString3.length() == 0) {
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            GeoCoderManager geoCoderManager = new GeoCoderManager((TelephonyManager) systemService, context, Locale.getDefault());
            String geoDescription = geoCoderManager.getGeoDescription(strOptString, geoCoderManager.getCurrentCountryIso());
            d.B("Geocoded number description: ", geoDescription, this.tag);
            str2 = geoDescription;
        } else {
            str2 = strOptString3;
        }
        Log.d(this.tag, "Final location: " + str2);
        String strOptString4 = contentJson.optString("deviceName");
        String strOptString5 = contentJson.optString("audioOutput");
        if (strOptString5 != null) {
            switch (strOptString5) {
                case "SPEAKER":
                    eAudioOutput = EAudioOutput.SPEAKER;
                    break;
                case "EARPIECE":
                    eAudioOutput = EAudioOutput.EARPIECE;
                    break;
                case "WIRED":
                    eAudioOutput = EAudioOutput.WIRED;
                    break;
                case "BLUETOOTH":
                    eAudioOutput = EAudioOutput.BLUETOOTH;
                    break;
                default:
                    eAudioOutput = EAudioOutput.SPEAKER;
                    break;
            }
        } else {
            eAudioOutput = EAudioOutput.SPEAKER;
        }
        EAudioOutput eAudioOutput2 = eAudioOutput;
        String str3 = this.tag;
        StringBuilder sbP = a.p("Processing call data: CallInfo(callId=", callId, ", phoneNumber=", strOptString, ", contactName=");
        sbP.append(str);
        sbP.append(")");
        Log.d(str3, sbP.toString());
        Intrinsics.checkNotNull(strOptString);
        Intrinsics.checkNotNull(strOptString4);
        CallInfo callInfo = new CallInfo(callId, strOptString, str, str2, strOptString4, eAudioOutput2);
        TransferServiceListener transferServiceListener = this.listener;
        if (transferServiceListener != null) {
            transferServiceListener.onIncomingCall(callInfo);
        }
    }

    private final void handleSmsData(JSONObject contentJson) {
        String str;
        String strOptString = contentJson.optString("smsId");
        String strOptString2 = contentJson.optString("contactName");
        String strOptString3 = contentJson.optString("content");
        String strOptString4 = contentJson.optString("phoneNumber");
        long jOptLong = contentJson.optLong("timestamp");
        String strOptString5 = contentJson.optString("deviceName");
        if (strOptString2 == null || strOptString2.length() == 0) {
            d.B("Contact name not provided, using phone number: ", strOptString4, this.tag);
            str = strOptString4;
        } else {
            str = strOptString2;
        }
        Intrinsics.checkNotNull(strOptString);
        Intrinsics.checkNotNull(strOptString4);
        Intrinsics.checkNotNull(strOptString3);
        Intrinsics.checkNotNull(strOptString5);
        SmsInfo smsInfo = new SmsInfo(strOptString, str, strOptString4, strOptString3, jOptLong, strOptString5);
        Log.d(this.tag, a.l("Processing SMS data: SmsInfo(phoneNumber=", strOptString4, ", content=", strOptString3, ")"));
        TransferServiceListener transferServiceListener = this.listener;
        if (transferServiceListener != null) {
            transferServiceListener.onSmsReceived(smsInfo);
        }
    }

    private final void parseAndHandleExternalIntent(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("topic");
        Log.d(this.tag, "Processing topic: " + stringExtra);
        String stringExtra2 = intent.getStringExtra("content");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        Log.d(this.tag, "Processing content: ".concat(stringExtra2));
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            Log.e(this.tag, "Invalid intent data");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra2);
            Log.d(this.tag, "Content JSON: " + jSONObject);
            String strOptString = jSONObject.optString("callId");
            Log.d(this.tag, "Received call data: CallInfo(callId=" + strOptString + ")");
            Locale locale = Locale.ROOT;
            String lowerCase = "CALL_FORWARD".toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(stringExtra, lowerCase)) {
                Intrinsics.checkNotNull(strOptString);
                handleIncomingCallData(context, jSONObject, strOptString);
            } else {
                String lowerCase2 = "SMS_FORWARD".toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(stringExtra, lowerCase2)) {
                    handleSmsData(jSONObject);
                } else {
                    Log.d(this.tag, "Ignoring unknown topic: " + stringExtra);
                }
            }
        } catch (Exception e) {
            a.w("Error handling intent: ", e.getMessage(), this.tag);
        }
    }

    public final void handleIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent != null) {
            d.B("Handling intent with action: ", intent.getAction(), this.tag);
            parseAndHandleExternalIntent(context, intent);
        }
    }

    public IntentDataHandler(TransferServiceListener transferServiceListener) {
        this.listener = transferServiceListener;
        this.tag = "IntentDataHandler";
    }

    public /* synthetic */ IntentDataHandler(TransferServiceListener transferServiceListener, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : transferServiceListener);
    }
}
