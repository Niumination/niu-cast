package com.transsion.atomiccore.hostsdk.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import e7.a;
import gb.c;
import k3.gc;
import k3.k1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/atomiccore/hostsdk/provider/AtomicCoreCardClientProvider;", "Landroid/content/ContentProvider;", "", "<init>", "()V", "TransAtomicSdkHost_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nAtomicCoreCardClientProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicCoreCardClientProvider.kt\ncom/transsion/atomiccore/hostsdk/provider/AtomicCoreCardClientProvider\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,447:1\n29#2:448\n*S KotlinDebug\n*F\n+ 1 AtomicCoreCardClientProvider.kt\ncom/transsion/atomiccore/hostsdk/provider/AtomicCoreCardClientProvider\n*L\n288#1:448\n*E\n"})
public abstract class AtomicCoreCardClientProvider extends ContentProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2324d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2326b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2327c = true;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(Context context, String str, String str2, a atomicCoreCard, Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(atomicCoreCard, "coreObject");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (!Intrinsics.areEqual(str, "life_circle")) {
            if (Intrinsics.areEqual(str, "action_event")) {
                extras.putString("action_type", str2);
                if (Intrinsics.areEqual(str2, "event_click_request_code")) {
                    Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
                    return;
                }
                Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
            }
            return;
        }
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1352294148:
                    if (str2.equals("create")) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
                        Intrinsics.checkNotNullParameter("Atomic-TransferClientProvider", "tag");
                        Intrinsics.checkNotNullParameter("onCreate", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("Atomic-TransferClientProvider"), "onCreate");
                        }
                        c.f5123b.getClass();
                        c.f5124c = atomicCoreCard;
                        if (c.e != null) {
                            Unit unit = Unit.INSTANCE;
                        }
                        break;
                    }
                    break;
                case 3202370:
                    if (str2.equals("hide")) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
                        break;
                    }
                    break;
                case 3529469:
                    if (str2.equals("show")) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
                        break;
                    }
                    break;
                case 1557372922:
                    if (str2.equals("destroy")) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
                        Intrinsics.checkNotNullParameter("Atomic-TransferClientProvider", "tag");
                        Intrinsics.checkNotNullParameter("onDestroy", "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("Atomic-TransferClientProvider"), "onDestroy");
                        }
                        break;
                    }
                    break;
                case 1648508603:
                    if (str2.equals("restore_data")) {
                        Bundle bundle = new Bundle();
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(atomicCoreCard, "atomicCoreCard");
                        Intrinsics.checkNotNullParameter(bundle, "bundle");
                        break;
                    }
                    break;
            }
        }
    }

    public final void b(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("serviceInstanceId");
        String string2 = bundle.getString("action");
        String string3 = bundle.getString("action_type");
        String string4 = bundle.getString("serviceId");
        String string5 = bundle.getString("entry");
        String string6 = bundle.getString("cardSize");
        String string7 = bundle.getString("pageId");
        long j8 = bundle.getLong("tpk_version_code");
        String string8 = bundle.getString("intentId");
        long j10 = bundle.getLong("timestamp");
        String string9 = bundle.getString("businessData");
        long j11 = bundle.getLong("dataVersion");
        String string10 = bundle.getString("options");
        bundle.getBundle("cardActionBundle");
        StringBuilder sb2 = new StringBuilder("serviceInstanceId=");
        sb2.append(string);
        sb2.append(", action=");
        d.A(sb2, string2, ", actionType=", string3, ", serviceId=");
        d.A(sb2, string4, ", entry=", string5, ", cardSize=");
        d.A(sb2, string6, ", pageId=", string7, ", tpkVersionCode=");
        sb2.append(j8);
        sb2.append(", intentVersion=");
        sb2.append(j11);
        sb2.append(", options=");
        sb2.append(string10);
        k1.a("AtomicCoreDemoClientProvider", sb2.toString());
        a aVar = new a(string == null ? "" : string, string8 == null ? "" : string8, string9 == null ? "{}" : string9, string5, string6, string7, j11, string10, j10, j8, string4);
        Bundle bundle2 = bundle.getBundle("cardActionBundle");
        a(context, string2, string3, aVar, bundle2 == null ? bundle : bundle2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        Object objM159constructorimpl;
        boolean z2 = false;
        Object[] objArr = 0;
        k1.a("AtomicCoreDemoClientProvider", "tryInitClientChannel " + this.f2326b);
        int i8 = this.f2326b;
        if (i8 <= 0) {
            return;
        }
        this.f2326b = i8 - 1;
        Context context = getContext();
        if (context != null) {
            boolean zIsSupportAtomicCoreCard = AtomicCoreUtils.isSupportAtomicCoreCard(context);
            this.f2327c = zIsSupportAtomicCoreCard;
            if (!zIsSupportAtomicCoreCard) {
                k1.a("AtomicCoreDemoClientProvider", "AtomicCoreCard not support");
            } else if (!this.f2325a) {
                Uri uri = Uri.parse("content://com.transsion.tcs.channel.provider/" + context.getPackageName() + "/" + getClass().getCanonicalName());
                i7.a aVar = new i7.a(context, this, AtomicCoreUtils.INSTANCE.getAtomicWorkerHandler(), objArr == true ? 1 : 0);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Context context2 = getContext();
                    ContentResolver contentResolver = context2 != null ? context2.getContentResolver() : null;
                    if (contentResolver != null) {
                        contentResolver.registerContentObserver(uri, false, aVar);
                        this.f2325a = true;
                        k1.a("AtomicCoreDemoClientProvider", "registerContentObserver success,uri=" + uri);
                    }
                    objM159constructorimpl = Result.m159constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
                }
                Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
                if (thM162exceptionOrNullimpl != null) {
                    k1.d("AtomicCoreDemoClientProvider", "registerContentObserver fail " + thM162exceptionOrNullimpl);
                }
                z2 = this.f2325a;
            }
            z2 = true;
        }
        if (z2) {
            k1.a("AtomicCoreDemoClientProvider", "initClientChannel end");
        } else {
            AtomicCoreUtils.INSTANCE.getAtomicWorkerHandler().postDelayed(new a4.c(this, 21), 100L);
        }
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String method, String str, Bundle bundle) {
        Object objM159constructorimpl;
        Intrinsics.checkNotNullParameter(method, "method");
        if (!this.f2327c) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = getContext();
            if (context == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(context, "context ?: return null");
            if (!Intrinsics.areEqual("updateAction", method)) {
                return super.call(method, str, bundle);
            }
            b(context, bundle);
            objM159constructorimpl = Result.m159constructorimpl(super.call(method, str, bundle));
            Throwable thM162exceptionOrNullimpl = Result.m162exceptionOrNullimpl(objM159constructorimpl);
            if (thM162exceptionOrNullimpl != null) {
                k1.c("AtomicCoreDemoClientProvider", "call error", thM162exceptionOrNullimpl);
            }
            return (Bundle) (Result.m165isFailureimpl(objM159constructorimpl) ? null : objM159constructorimpl);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objM159constructorimpl = Result.m159constructorimpl(ResultKt.createFailure(th2));
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.f2326b = 20;
        c();
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }
}
