package com.transsion.widgetsliquid.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/transsion/widgetsliquid/utils/Utils;", "", "()V", "IS_AFTER_1610", "", "getIS_AFTER_1610", "()Z", "OS_TRANS_VERSION", "", "OS_VERSION", "getOS_VERSION", "()Ljava/lang/String;", "TAG", "getSystemProperties", "key", "isAfterTargetVersion", "targetVersion", "readRawTextFile", "context", "Landroid/content/Context;", "resId", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/transsion/widgetsliquid/utils/Utils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,96:1\n731#2,9:97\n731#2,9:108\n37#3,2:106\n37#3,2:117\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/transsion/widgetsliquid/utils/Utils\n*L\n55#1:97,9\n57#1:108,9\n55#1:106,2\n57#1:117,2\n*E\n"})
public final class Utils {
    public static final Utils INSTANCE;
    private static final boolean IS_AFTER_1610;
    public static final String OS_TRANS_VERSION = "ro.tranos.version";
    private static final String OS_VERSION;
    private static final String TAG = "ReadRawFileUtil";

    static {
        Utils utils = new Utils();
        INSTANCE = utils;
        OS_VERSION = utils.getSystemProperties(OS_TRANS_VERSION);
        IS_AFTER_1610 = utils.isAfterTargetVersion("16.1.0");
    }

    private Utils() {
    }

    @JvmStatic
    public static final String readRawTextFile(Context context, int resId) {
        Intrinsics.checkNotNullParameter(context, "context");
        InputStream inputStream = context.getResources().openRawResource(resId);
        try {
            Intrinsics.checkNotNullExpressionValue(inputStream, "inputStream");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(inputStream, null);
                return text;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(bufferedReader, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                CloseableKt.closeFinally(inputStream, th4);
                throw th5;
            }
        }
    }

    public final boolean getIS_AFTER_1610() {
        return IS_AFTER_1610;
    }

    public final String getOS_VERSION() {
        return OS_VERSION;
    }

    public final String getSystemProperties(String key) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, key);
        } catch (Exception e) {
            e.printStackTrace();
            a.w("getSystemProperties Exception ", e.getMessage(), TAG);
            return "";
        }
    }

    public final boolean isAfterTargetVersion(String targetVersion) {
        List listEmptyList;
        List listEmptyList2;
        if (!TextUtils.isEmpty(targetVersion)) {
            String str = OS_VERSION;
            if (!TextUtils.isEmpty(str)) {
                Pattern patternCompile = Pattern.compile("[0-9.]+");
                Matcher matcher = patternCompile.matcher(str);
                Matcher matcher2 = patternCompile.matcher(targetVersion);
                String strGroup = "";
                String strGroup2 = "";
                while (matcher.find()) {
                    strGroup2 = matcher.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "matcher.group()");
                }
                while (matcher2.find()) {
                    strGroup = matcher2.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup, "targetMatcher.group()");
                }
                if (StringsKt__StringsJVMKt.equals(strGroup2, strGroup, true)) {
                    return true;
                }
                List<String> listSplit = new Regex("\\.").split(strGroup2, 0);
                if (listSplit.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    }
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                List<String> listSplit2 = new Regex("\\.").split(strGroup, 0);
                if (listSplit2.isEmpty()) {
                    listEmptyList2 = CollectionsKt.emptyList();
                    break;
                }
                ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        listEmptyList2 = CollectionsKt.emptyList();
                        break;
                    }
                    if (listIterator2.previous().length() != 0) {
                        listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
                String[] strArr2 = (String[]) listEmptyList2.toArray(new String[0]);
                for (int i8 = 0; i8 < strArr.length && i8 < strArr2.length; i8++) {
                    String str2 = strArr[i8];
                    Intrinsics.checkNotNull(str2);
                    int i9 = Integer.parseInt(str2);
                    String str3 = strArr2[i8];
                    Intrinsics.checkNotNull(str3);
                    int i10 = Integer.parseInt(str3);
                    if (i9 > i10) {
                        return true;
                    }
                    if (i9 < i10) {
                        return false;
                    }
                }
                if (strArr.length > strArr2.length) {
                    int length = strArr.length;
                    for (int length2 = strArr2.length; length2 < length; length2++) {
                        String str4 = strArr[length2];
                        Intrinsics.checkNotNull(str4);
                        if (Integer.parseInt(str4) >= 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
