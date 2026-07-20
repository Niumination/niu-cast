package com.transsion.message.bank;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.transsion.content.ParticularFeatureManager;
import com.transsion.util.Singleton;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class MessageBank {
    public static final String FEATURE_NAME = "message_bank";
    public static final int FLAG_CURRENT = 4;
    public static final int FLAG_DISPOSABLE = 1;
    public static final int FLAG_SECURITY = 2;
    public static final int FLAG_UPDATE = 8;
    public static final String KEY_FEATURE = "feature";
    public static final String KEY_FLAG = "flag";
    public static final String KEY_FROM = "from";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_OP = "op";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_TO = "to";
    public static final String KEY_TYPE = "type";
    private static final Object LOCK = new Object();
    public static final int OP_NONE = 0;
    public static final int OP_STORE = 1;
    public static final int OP_TAKE = 2;
    public static final String TAG = "MessageBank";
    public static final int TYPE_FEATURE_STRING = 2;
    public static final int TYPE_STRING = 1;
    private static MessageBank sInstance;
    private final Context mAppContext;
    private final MySingleton mTellerSingleton;

    public class MySingleton extends Singleton<ITeller> {
        public MySingleton(final ParticularFeatureManager particularFeatureManager) {
            super(new Supplier() { // from class: com.transsion.message.bank.a
                @Override // java.util.function.Supplier
                public final Object get() {
                    return MessageBank.MySingleton.lambda$new$0(particularFeatureManager);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ITeller lambda$new$0(ParticularFeatureManager particularFeatureManager) {
            IBinder feature = particularFeatureManager.getFeature(MessageBank.FEATURE_NAME);
            if (feature == null) {
                return null;
            }
            return ITeller.Stub.asInterface(feature);
        }
    }

    private MessageBank(Context context) {
        this.mAppContext = context;
        this.mTellerSingleton = new MySingleton(ParticularFeatureManager.get(context));
    }

    public static MessageBank getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                try {
                    if (sInstance == null) {
                        sInstance = new MessageBank(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sInstance;
    }

    public static boolean isSupported(Context context) {
        return ParticularFeatureManager.get(context).hasFeature(FEATURE_NAME);
    }

    private Bundle transaction(Bundle bundle) {
        ITeller iTeller = (ITeller) this.mTellerSingleton.get();
        if (iTeller == null) {
            Log.w(TAG, "message bank is not supported");
            return null;
        }
        try {
            return iTeller.transaction(this.mAppContext.getOpPackageName(), bundle);
        } catch (RemoteException e) {
            Log.w(TAG, "transaction failed " + e);
            return null;
        }
    }

    public String storeMessage(String str, String str2) {
        return storeMessage(str, null, str2, false, false);
    }

    public String takeMessage(String str) {
        return takeMessage(str, null, null);
    }

    public String storeMessage(String str, String str2, String str3) {
        return storeMessage(str, str2, str3, false, false);
    }

    public String takeMessage(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_OP, 2);
        bundle.putInt(KEY_TYPE, 2);
        bundle.putString(KEY_FEATURE, str);
        bundle.putString("from", str2);
        bundle.putString(KEY_PASSWORD, str3);
        Bundle bundleTransaction = transaction(bundle);
        if (bundleTransaction == null) {
            return null;
        }
        return bundleTransaction.getString(KEY_MESSAGE);
    }

    public String storeMessage(String str, String str2, String str3, boolean z2, boolean z3) {
        int i8 = z2 ? 2 : 0;
        if (z3) {
            i8 |= 1;
        }
        return storeMessage(str, str2, str3, i8);
    }

    private String storeMessage(String str, String str2, String str3, int i8) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_OP, 1);
        bundle.putInt(KEY_TYPE, 2);
        bundle.putString(KEY_FEATURE, str);
        bundle.putInt(KEY_FLAG, i8);
        bundle.putString("to", str2);
        bundle.putString(KEY_MESSAGE, str3);
        Bundle bundleTransaction = transaction(bundle);
        if (bundleTransaction == null) {
            return null;
        }
        return bundleTransaction.getString(KEY_PASSWORD);
    }
}
