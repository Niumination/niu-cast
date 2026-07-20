package i7;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.transsion.atomiccore.hostsdk.provider.AtomicCoreCardClientProvider;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import k3.k1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5722c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, Object obj2, Handler handler, int i8) {
        super(handler);
        this.f5720a = i8;
        this.f5721b = obj;
        this.f5722c = obj2;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2, Uri uri) {
        switch (this.f5720a) {
            case 1:
                LinkedHashMap linkedHashMap = lb.a.f7355a;
                ((MutableLiveData) this.f5722c).postValue(Boolean.valueOf(lb.a.a((String) this.f5721b)));
                break;
            default:
                super.onChange(z2, uri);
                break;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z2) {
        ContentProviderClient contentProviderClient;
        Bundle bundle;
        switch (this.f5720a) {
            case 0:
                super.onChange(z2);
                int i8 = AtomicCoreCardClientProvider.f2324d;
                Context context = (Context) this.f5721b;
                String packageName = context.getPackageName();
                AtomicCoreCardClientProvider atomicCoreCardClientProvider = (AtomicCoreCardClientProvider) this.f5722c;
                String providerFullCanonicalName = packageName + "/" + atomicCoreCardClientProvider.getClass().getCanonicalName();
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(providerFullCanonicalName, "providerFullCanonicalName");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ContentResolver contentResolver = context.getContentResolver();
                    ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver != null ? contentResolver.acquireUnstableContentProviderClient(c7.a.f1449a) : null;
                    k1.a("AtomicCoreDemoClientProvider", "getProviderClient, providerClient=" + contentProviderClientAcquireUnstableContentProviderClient + ", SERVER_URI=" + c7.a.f1449a);
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m159constructorimpl(ResultKt.createFailure(th2));
                    contentProviderClient = null;
                }
                Bundle bundleCall = contentProviderClient != null ? contentProviderClient.call("getCardAction", providerFullCanonicalName, null) : null;
                k1.a("AtomicCoreDemoClientProvider", "notifyAllAtomicCoreCard=" + (bundleCall != null ? bundleCall.keySet() : null));
                if (bundleCall != null) {
                    ArrayList<String> stringArrayList = bundleCall.getStringArrayList("cardActionData");
                    Bundle bundle2 = bundleCall.getBundle("cardActionBundleData");
                    if (stringArrayList != null) {
                        for (String str : stringArrayList) {
                            int i9 = AtomicCoreCardClientProvider.f2324d;
                            try {
                                Result.Companion companion3 = Result.INSTANCE;
                                JSONObject jSONObject = new JSONObject(str);
                                String strOptString = jSONObject.optString("action");
                                String strOptString2 = jSONObject.optString("action_type");
                                String strOptString3 = jSONObject.optString("serviceId");
                                String strOptString4 = jSONObject.optString("serviceInstanceId");
                                String strOptString5 = jSONObject.optString("intentId");
                                String strOptString6 = jSONObject.optString("businessData");
                                String strOptString7 = jSONObject.optString("entry");
                                String strOptString8 = jSONObject.optString("cardSize");
                                String strOptString9 = jSONObject.optString("pageId");
                                long jOptLong = jSONObject.optLong("timestamp");
                                long jOptLong2 = jSONObject.optLong("tpk_version_code");
                                long jOptLong3 = jSONObject.optLong("dataVersion");
                                String strOptString10 = jSONObject.optString("options");
                                String strOptString11 = jSONObject.optString("primaryKeys");
                                if (bundle2 == null || (bundle = bundle2.getBundle(strOptString11)) == null) {
                                    bundle = new Bundle();
                                }
                                Bundle bundle3 = bundle;
                                Intrinsics.checkNotNullExpressionValue(bundle3, "cardActionBundleData?.ge…              ?: Bundle()");
                                atomicCoreCardClientProvider.a(context, strOptString, strOptString2, new e7.a(strOptString4 == null ? "" : strOptString4, strOptString5 == null ? "" : strOptString5, strOptString6 == null ? "{}" : strOptString6, strOptString7, strOptString8, strOptString9, jOptLong3, strOptString10, jOptLong, jOptLong2, strOptString3), bundle3);
                                Result.m159constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th3) {
                                Result.Companion companion4 = Result.INSTANCE;
                                Result.m159constructorimpl(ResultKt.createFailure(th3));
                            }
                        }
                    }
                }
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
                break;
            default:
                super.onChange(z2);
                break;
        }
    }
}
