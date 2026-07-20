package com.transsion.atomiccore.hostsdk.utils;

import a0.e;
import a4.c;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import d6.q;
import g7.a;
import h7.b;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import k3.k1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\fJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\"\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010(J9\u0010-\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b-\u0010.JA\u0010/\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b1\u0010\u0017J\u000f\u00102\u001a\u00020\u0006H\u0007¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u00106J\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e072\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0017\u0010@\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/transsion/atomiccore/hostsdk/utils/AtomicCoreUtils;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "atomicKey", "", "isAtomicIntentEnable", "(Landroid/content/Context;Ljava/lang/String;)Z", "subGroup", "(Landroid/content/Context;Ljava/lang/String;Z)Z", "enable", "setAtomicIntentEnable", "Landroid/database/ContentObserver;", "observer", "", "registerAtomicIntentObserver", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/ContentObserver;)V", "unregisterAtomicIntentObserver", "(Landroid/content/Context;Landroid/database/ContentObserver;)V", "interceptBySpecialMode", "(Landroid/content/Context;)Z", "name", "", "priority", "Landroid/os/Looper;", "createAndStartNewLooper", "(Ljava/lang/String;I)Landroid/os/Looper;", "Lf7/a;", "data", "Landroid/os/Bundle;", "businessBundle", "sendAtomicCoreData", "(Lf7/a;Landroid/os/Bundle;)V", "cancelAtomicCoreData", "(Lf7/a;)V", "serviceInstanceId", "cancelAllAtomicCoreData", "(Lf7/a;Ljava/lang/String;)V", "card", "Lorg/json/JSONObject;", "businessData", "options", "updateCardData", "(Lf7/a;Lorg/json/JSONObject;Landroid/os/Bundle;Lorg/json/JSONObject;)V", "updateAllCardData", "(Lf7/a;Ljava/lang/String;Lorg/json/JSONObject;Landroid/os/Bundle;Lorg/json/JSONObject;)V", "isSupportAtomicCoreCard", "genServiceInstanceId", "()Ljava/lang/String;", "Landroid/content/ContentProviderClient;", "getProviderClient", "(Landroid/content/Context;)Landroid/content/ContentProviderClient;", "", "getAtomicCardList", "(Landroid/content/Context;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "ATOMIC_CORE_CARD_SUPPORT_META", "ATOMIC_WORKER_EXECUTOR", "Landroid/os/Looper;", "Landroid/os/Handler;", "atomicWorkerHandler", "Landroid/os/Handler;", "getAtomicWorkerHandler", "()Landroid/os/Handler;", "Lg7/a;", "directionConProxy", "Lg7/a;", "TransAtomicSdkHost_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AtomicCoreUtils {
    private static final String ATOMIC_CORE_CARD_SUPPORT_META = "isAtomicCoreCardSupport";
    private static final Looper ATOMIC_WORKER_EXECUTOR;
    public static final AtomicCoreUtils INSTANCE;
    private static final String TAG = "AtomicCoreUtils";
    private static final Handler atomicWorkerHandler;

    @Keep
    private static a directionConProxy;

    static {
        AtomicCoreUtils atomicCoreUtils = new AtomicCoreUtils();
        INSTANCE = atomicCoreUtils;
        Looper looperCreateAndStartNewLooper$default = createAndStartNewLooper$default(atomicCoreUtils, "AtomicCoreWorker", 0, 2, null);
        ATOMIC_WORKER_EXECUTOR = looperCreateAndStartNewLooper$default;
        atomicWorkerHandler = new Handler(looperCreateAndStartNewLooper$default);
    }

    private AtomicCoreUtils() {
    }

    @JvmStatic
    public static final void cancelAllAtomicCoreData(f7.a data, String serviceInstanceId) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serviceInstanceId, "serviceInstanceId");
        if (data.h().length() == 0 || serviceInstanceId.length() == 0) {
            k1.b(TAG, "cancelAllAtomicCoreData serviceInstanceId is empty!!");
            return;
        }
        if (!Intrinsics.areEqual(data.h(), serviceInstanceId)) {
            k1.b(TAG, "data serviceInstanceId is not the same as serviceInstanceId!!");
            return;
        }
        k1.a(TAG, "cancelAllAtomicCoreData " + data + ", serviceInstanceId: " + serviceInstanceId);
        atomicWorkerHandler.post(new e(17, data, serviceInstanceId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelAllAtomicCoreData$lambda$19(f7.a data, String serviceInstanceId) {
        Object objM159constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(serviceInstanceId, "$serviceInstanceId");
        Context contextA = b.a();
        if (contextA != null) {
            Bundle bundle = new Bundle();
            bundle.putString("coreData", data.j());
            ContentProviderClient providerClient = INSTANCE.getProviderClient(contextA);
            if (providerClient != null) {
                try {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Bundle bundleCall = providerClient.call("cancelAllAtomicCoreData", null, bundle);
                        if (bundleCall != null) {
                            k1.a(TAG, "cancelAllAtomicCoreData result: " + bundleCall.getString("result"));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        objM159constructorimpl = Result.m159constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
                    if (thM162exceptionOrNullimpl != null) {
                        k1.b(TAG, "cancelAllAtomicCoreData error: " + thM162exceptionOrNullimpl.getMessage());
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(providerClient, null);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        AutoCloseableKt.closeFinally(providerClient, th3);
                        throw th4;
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final void cancelAtomicCoreData(f7.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.h().length() == 0) {
            k1.b(TAG, "cancelAtomicCoreData serviceInstanceId is empty!!");
            return;
        }
        k1.a(TAG, "cancelAtomicCoreData  " + data);
        atomicWorkerHandler.post(new c(data, 27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelAtomicCoreData$lambda$13(f7.a data) {
        Object objM159constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(data, "$data");
        Context contextA = b.a();
        if (contextA != null) {
            Bundle bundle = new Bundle();
            bundle.putString("coreData", data.j());
            ContentProviderClient providerClient = INSTANCE.getProviderClient(contextA);
            if (providerClient != null) {
                try {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Bundle bundleCall = providerClient.call("cancelAtomicCoreData", null, bundle);
                        if (bundleCall != null) {
                            k1.a(TAG, "cancelAtomicCoreData result: " + bundleCall.getString("result"));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        objM159constructorimpl = Result.m159constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
                    if (thM162exceptionOrNullimpl != null) {
                        k1.b(TAG, "cancelAtomicCoreData error: " + thM162exceptionOrNullimpl.getMessage());
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(providerClient, null);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        AutoCloseableKt.closeFinally(providerClient, th3);
                        throw th4;
                    }
                }
            }
        }
    }

    private final Looper createAndStartNewLooper(String name, int priority) {
        HandlerThread handlerThread = new HandlerThread(name, priority);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "thread.looper");
        return looper;
    }

    public static /* synthetic */ Looper createAndStartNewLooper$default(AtomicCoreUtils atomicCoreUtils, String str, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        return atomicCoreUtils.createAndStartNewLooper(str, i8);
    }

    @JvmStatic
    public static final String genServiceInstanceId() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.nanoTime());
        sb2.append('_');
        sb2.append(UUID.randomUUID().hashCode());
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
        return string;
    }

    @JvmStatic
    @WorkerThread
    public static final List<f7.a> getAtomicCardList(Context context) {
        Object objM159constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        try {
            Result.Companion companion = Result.INSTANCE;
            Cursor cursorQuery = context.getContentResolver().query(c7.a.f1450b.buildUpon().appendPath(context.getPackageName()).build(), null, null, null, null);
            Unit unit = null;
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        do {
                            int columnIndex = cursor2.getColumnIndex("serviceId");
                            int columnIndex2 = cursor2.getColumnIndex("serviceInstanceId");
                            int columnIndex3 = cursor2.getColumnIndex("intentId");
                            int columnIndex4 = cursor2.getColumnIndex("createTime");
                            int columnIndex5 = cursor2.getColumnIndex("businessData");
                            int columnIndex6 = cursor2.getColumnIndex("dataVersion");
                            String string = columnIndex != -1 ? cursor2.getString(columnIndex) : null;
                            String string2 = columnIndex2 != -1 ? cursor2.getString(columnIndex2) : null;
                            String string3 = columnIndex3 != -1 ? cursor2.getString(columnIndex3) : null;
                            long j8 = columnIndex4 != -1 ? cursor2.getLong(columnIndex4) : 0L;
                            String string4 = columnIndex5 != -1 ? cursor2.getString(columnIndex5) : null;
                            long j10 = columnIndex6 != -1 ? cursor2.getLong(columnIndex6) : 0L;
                            k1.a(TAG, "serviceId: " + string + ",serviceInstanceId: " + string2 + ",intentId: " + string3 + ",createTime: " + j8 + ",intentVersion: " + j10);
                            if (string != null && string2 != null && string3 != null) {
                                if (string4 == null) {
                                    string4 = "{}";
                                }
                                arrayList.add(new e7.a(string2, string3, string4, null, null, null, j10, null, j8, 0L, string));
                            }
                        } while (cursor2.moveToNext());
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                    unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(cursor, th2);
                        throw th3;
                    }
                }
            }
            objM159constructorimpl = Result.m159constructorimpl(unit);
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th4));
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        if (thM162exceptionOrNullimpl != null) {
            k1.b(TAG, "getAtomicCardList failed: " + thM162exceptionOrNullimpl);
        }
        return arrayList;
    }

    private final ContentProviderClient getProviderClient(Context context) {
        try {
            Result.Companion companion = Result.INSTANCE;
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return null;
            }
            Uri uri = c7.a.f1449a;
            return contentResolver.acquireUnstableContentProviderClient(c7.a.f1451c);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m159constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }

    @JvmStatic
    public static final boolean isSupportAtomicCoreCard(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (INSTANCE.interceptBySpecialMode(context)) {
            k1.b(TAG, "sendAtomicCoreData is disabled by special mode, return!!!");
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return context.getPackageManager().getApplicationInfo("com.transsion.atomiccore", 128).metaData.getBoolean(ATOMIC_CORE_CARD_SUPPORT_META);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            if (thM162exceptionOrNullimpl != null) {
                k1.b(TAG, "isSupportAtomicCoreCard: " + thM162exceptionOrNullimpl);
            }
            return false;
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void sendAtomicCoreData(f7.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        sendAtomicCoreData$default(data, null, 2, null);
    }

    public static /* synthetic */ void sendAtomicCoreData$default(f7.a aVar, Bundle bundle, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            bundle = null;
        }
        sendAtomicCoreData(aVar, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendAtomicCoreData$lambda$7(f7.a data, Bundle bundle) {
        Object objM159constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(data, "$data");
        k1.a(TAG, "sendAtomicCoreData " + data + ", bundle: " + bundle);
        Context contextA = b.a();
        if (contextA != null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putBundle("businessBundle", bundle);
            }
            bundle2.putString("coreData", data.j());
            ContentProviderClient providerClient = INSTANCE.getProviderClient(contextA);
            if (providerClient != null) {
                try {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Bundle bundleCall = providerClient.call("sendAtomicCoreData", null, bundle2);
                        if (bundleCall != null) {
                            k1.a(TAG, "sendAtomicCoreData result: " + bundleCall.getString("result"));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        objM159constructorimpl = Result.m159constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
                    if (thM162exceptionOrNullimpl != null) {
                        k1.b(TAG, "sendAtomicCoreData error: " + thM162exceptionOrNullimpl.getMessage());
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(providerClient, null);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        AutoCloseableKt.closeFinally(providerClient, th3);
                        throw th4;
                    }
                }
            }
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateAllCardData(f7.a card, String serviceInstanceId, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(serviceInstanceId, "serviceInstanceId");
        updateAllCardData$default(card, serviceInstanceId, jSONObject, null, null, 24, null);
    }

    public static /* synthetic */ void updateAllCardData$default(f7.a aVar, String str, JSONObject jSONObject, Bundle bundle, JSONObject jSONObject2, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            bundle = null;
        }
        if ((i8 & 16) != 0) {
            jSONObject2 = null;
        }
        updateAllCardData(aVar, str, jSONObject, bundle, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAllCardData$lambda$35(f7.a card, JSONObject jSONObject, JSONObject jSONObject2, Bundle bundle, String serviceInstanceId) {
        Object objM159constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(card, "$card");
        Intrinsics.checkNotNullParameter(serviceInstanceId, "$serviceInstanceId");
        boolean z2 = card instanceof e7.a;
        e7.a aVar = new e7.a(card.h(), card.e(), jSONObject != null ? jSONObject.toString() : null, card.d(), card.b(), card.g(), card.c(), String.valueOf(jSONObject2), z2 ? ((e7.a) card).q : System.currentTimeMillis(), z2 ? ((e7.a) card).f4704r : 0L, z2 ? ((e7.a) card).f4705s : null);
        k1.a(TAG, "updateAllCardData " + aVar + ", bundle: " + bundle);
        Context contextA = b.a();
        if (contextA != null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putBundle("businessBundle", bundle);
            }
            bundle2.putString("coreData", aVar.j());
            ContentProviderClient providerClient = INSTANCE.getProviderClient(contextA);
            try {
                if (providerClient != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Bundle bundleCall = providerClient.call("updateAllCardData", null, bundle2);
                        if (bundleCall != null) {
                            k1.a(TAG, "updateCardData result: " + bundleCall.getString("result"));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        objM159constructorimpl = Result.m159constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
                    if (thM162exceptionOrNullimpl != null) {
                        k1.b(TAG, "updateAllCardData failed: " + thM162exceptionOrNullimpl);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(providerClient, null);
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(providerClient, th3);
                    throw th4;
                }
            }
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateCardData(f7.a card, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(card, "card");
        updateCardData$default(card, jSONObject, null, null, 12, null);
    }

    public static /* synthetic */ void updateCardData$default(f7.a aVar, JSONObject jSONObject, Bundle bundle, JSONObject jSONObject2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            bundle = null;
        }
        if ((i8 & 8) != 0) {
            jSONObject2 = null;
        }
        updateCardData(aVar, jSONObject, bundle, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCardData$lambda$27(f7.a card, JSONObject jSONObject, JSONObject jSONObject2, Bundle bundle) {
        Object objM159constructorimpl;
        Unit unit;
        Intrinsics.checkNotNullParameter(card, "$card");
        boolean z2 = card instanceof e7.a;
        e7.a aVar = new e7.a(card.h(), card.e(), jSONObject != null ? jSONObject.toString() : null, card.d(), card.b(), card.g(), card.c(), String.valueOf(jSONObject2), z2 ? ((e7.a) card).q : System.currentTimeMillis(), z2 ? ((e7.a) card).f4704r : 0L, z2 ? ((e7.a) card).f4705s : null);
        k1.a(TAG, "updateCardData " + aVar + ", bundle: " + bundle);
        Context contextA = b.a();
        if (contextA != null) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putBundle("businessBundle", bundle);
            }
            bundle2.putString("coreData", aVar.j());
            ContentProviderClient providerClient = INSTANCE.getProviderClient(contextA);
            if (providerClient != null) {
                try {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Bundle bundleCall = providerClient.call("updateCardData", null, bundle2);
                        if (bundleCall != null) {
                            k1.a(TAG, "updateCardData result: " + bundleCall.getString("result"));
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        objM159constructorimpl = Result.m159constructorimpl(unit);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                    }
                    Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
                    if (thM162exceptionOrNullimpl != null) {
                        k1.b(TAG, "updateCardData failed: " + thM162exceptionOrNullimpl);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    AutoCloseableKt.closeFinally(providerClient, null);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        AutoCloseableKt.closeFinally(providerClient, th3);
                        throw th4;
                    }
                }
            }
        }
    }

    public final Handler getAtomicWorkerHandler() {
        return atomicWorkerHandler;
    }

    public final boolean interceptBySpecialMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!b.f5269b && !b.f5270c) {
            return false;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z2 = Settings.Secure.getInt(context.getContentResolver(), "super_power_saving_mode", 0) == 1;
        b.f5269b = z2;
        if (z2) {
            k1.d(TAG, "sendAtomicCoreData is disabled by super power save mode, return!!!");
            return true;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z3 = Settings.Secure.getInt(context.getContentResolver(), "os_reboot_to_repair_mode", 0) == 1;
        b.f5270c = z3;
        if (z3) {
            k1.d(TAG, "sendAtomicCoreData is disabled by repair mode, return!!!");
            return true;
        }
        k1.d(TAG, "isSuperPowerSavingMode or isRepairMode is reloaded");
        return false;
    }

    @WorkerThread
    public final boolean isAtomicIntentEnable(Context context, String atomicKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(atomicKey, "atomicKey");
        try {
            Result.Companion companion = Result.INSTANCE;
            return isAtomicIntentEnable(context, atomicKey, false);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            if (thM162exceptionOrNullimpl != null) {
                k1.b(TAG, "isAtomicIntentEnable failed: " + thM162exceptionOrNullimpl);
            }
            return false;
        }
    }

    public final void registerAtomicIntentObserver(Context context, String atomicKey, ContentObserver observer) {
        Object objM159constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(atomicKey, "atomicKey");
        Intrinsics.checkNotNullParameter(observer, "observer");
        try {
            Result.Companion companion = Result.INSTANCE;
            context.getContentResolver().registerContentObserver(c7.a.f1449a.buildUpon().appendPath("atomicIntentSwitch").appendPath(atomicKey).build(), false, observer);
            objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        if (thM162exceptionOrNullimpl != null) {
            k1.b(TAG, "registerAtomicIntentObserver failed: " + thM162exceptionOrNullimpl);
        }
    }

    @WorkerThread
    public final boolean setAtomicIntentEnable(Context context, String atomicKey, boolean enable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(atomicKey, "atomicKey");
        try {
            Result.Companion companion = Result.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putString("atomicIntentSwitch", atomicKey);
            bundle.putInt("result", enable ? 1 : 0);
            Bundle bundleCall = context.getContentResolver().call(c7.a.f1449a, "atomicIntentSwitch", (String) null, bundle);
            if (bundleCall != null) {
                k1.a(TAG, "setAtomicIntentEnable result: " + bundleCall.getString("result"));
            }
            return bundleCall != null && bundleCall.getInt("result") == 0;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            if (thM162exceptionOrNullimpl != null) {
                k1.b(TAG, "setAtomicIntentEnable failed: " + thM162exceptionOrNullimpl);
            }
            return false;
        }
    }

    public final void unregisterAtomicIntentObserver(Context context, ContentObserver observer) {
        Object objM159constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(observer, "observer");
        try {
            Result.Companion companion = Result.INSTANCE;
            context.getContentResolver().unregisterContentObserver(observer);
            objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
        if (thM162exceptionOrNullimpl != null) {
            k1.b(TAG, "unregisterAtomicIntentObserver failed: " + thM162exceptionOrNullimpl);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void sendAtomicCoreData(f7.a data, Bundle businessBundle) {
        Intrinsics.checkNotNullParameter(data, "data");
        Context contextA = b.a();
        if (contextA == null || !INSTANCE.interceptBySpecialMode(contextA)) {
            atomicWorkerHandler.post(new e(18, data, businessBundle));
        } else {
            k1.b(TAG, "sendAtomicCoreData is disabled by special mode, return!!!");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateAllCardData(f7.a card, String serviceInstanceId, JSONObject jSONObject, Bundle bundle) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(serviceInstanceId, "serviceInstanceId");
        updateAllCardData$default(card, serviceInstanceId, jSONObject, bundle, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateCardData(f7.a card, JSONObject jSONObject, Bundle bundle) {
        Intrinsics.checkNotNullParameter(card, "card");
        updateCardData$default(card, jSONObject, bundle, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateAllCardData(f7.a card, String serviceInstanceId, JSONObject businessData, Bundle businessBundle, JSONObject options) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(serviceInstanceId, "serviceInstanceId");
        if (!Intrinsics.areEqual(card.h(), serviceInstanceId)) {
            k1.b(TAG, "data serviceInstanceId is not the same as serviceInstanceId!!");
            return;
        }
        Context contextA = b.a();
        if (contextA != null && INSTANCE.interceptBySpecialMode(contextA)) {
            k1.b(TAG, "sendAtomicCoreData is disabled by special mode, return!!!");
        } else {
            atomicWorkerHandler.post(new j7.a(card, businessData, options, businessBundle, serviceInstanceId, 0));
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void updateCardData(f7.a card, JSONObject businessData, Bundle businessBundle, JSONObject options) {
        Intrinsics.checkNotNullParameter(card, "card");
        Context contextA = b.a();
        if (contextA != null && INSTANCE.interceptBySpecialMode(contextA)) {
            k1.b(TAG, "sendAtomicCoreData is disabled by special mode, return!!!");
        } else {
            atomicWorkerHandler.post(new q(1, card, businessData, options, businessBundle));
        }
    }

    @WorkerThread
    public final boolean isAtomicIntentEnable(Context context, String atomicKey, boolean subGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(atomicKey, "atomicKey");
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = subGroup ? "atomic_switch_sub_group_" : "atomic_switch_item_";
            ContentResolver contentResolver = context.getContentResolver();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(atomicKey);
            return Settings.Global.getInt(contentResolver, sb2.toString(), 1) == 1;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(Result.m159constructorimpl(ResultKt.createFailure(th2)));
            if (thM162exceptionOrNullimpl != null) {
                k1.b(TAG, "isAtomicIntentEnable " + subGroup + " failed: " + thM162exceptionOrNullimpl);
            }
            return false;
        }
    }
}
