package com.transsion.iotcardsdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotcardsdk.bean.IotCardTemplateBean;
import com.transsion.iotcardsdk.bean.TCCardBean;
import com.transsion.iotcardsdk.util.IotcardConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tj.f;
import tj.n;
import tj.o;
import tj.p;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J5\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t0\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001a\u0010\u0015J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u0012J\u001b\u0010\u001c\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001c\u0010\u0015J\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u0003R\u001a\u0010\u001e\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u001a\u0010*\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R<\u00103\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001f\u001a\u0004\b:\u0010!\"\u0004\b;\u0010\u0018R$\u0010<\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!\"\u0004\b>\u0010\u0018R#\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020@0?8\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010F\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/transsion/iotcardsdk/TCHelper;", "", "<init>", "()V", "", "initCard", "Landroid/app/Application;", "application", "Lkotlin/Function0;", "", "", "", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "callBack", "bindWriteService", "(Landroid/app/Application;Lkotlin/jvm/functions/Function0;)V", "iotCardTemplateBean", "registerDevice", "(Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;)V", "cardList", "registerDeviceList", "(Ljava/util/List;)V", "controlId", "unregisterDevice", "(Ljava/lang/String;)V", "iotCardTemplateBeans", "unregisterDeviceList", "updateDevice", "updateDeviceList", "writeSettingProvider", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "mApplication", "Landroid/app/Application;", "getMApplication", "()Landroid/app/Application;", "setMApplication", "(Landroid/app/Application;)V", "writeServiceAction", "getWriteServiceAction", "writeServicePackageName", "getWriteServicePackageName", "Ltj/p;", "commonService", "Ltj/p;", "getCommonService", "()Ltj/p;", "setCommonService", "(Ltj/p;)V", "iotCardCallBack", "Lkotlin/jvm/functions/Function0;", "getIotCardCallBack", "()Lkotlin/jvm/functions/Function0;", "setIotCardCallBack", "(Lkotlin/jvm/functions/Function0;)V", "packageName", "getPackageName", "setPackageName", "settingProviderKey", "getSettingProviderKey", "setSettingProviderKey", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/transsion/iotcardsdk/bean/TCCardBean;", "mTcCardMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getMTcCardMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/content/ServiceConnection;", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nTCHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TCHelper.kt\ncom/transsion/iotcardsdk/TCHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,145:1\n215#2,2:146\n766#3:148\n857#3,2:149\n1855#3,2:151\n1855#3,2:153\n1855#3,2:155\n1855#3,2:157\n*S KotlinDebug\n*F\n+ 1 TCHelper.kt\ncom/transsion/iotcardsdk/TCHelper\n*L\n59#1:146,2\n64#1:148\n64#1:149,2\n66#1:151,2\n96#1:153,2\n108#1:155,2\n122#1:157,2\n*E\n"})
public final class TCHelper {
    private p commonService;
    private Function0<? extends Map<String, ? extends List<? extends IotCardTemplateBean>>> iotCardCallBack;
    private Application mApplication;
    private String packageName;
    private String settingProviderKey;
    private final String TAG = "TCHelper";
    private final String writeServiceAction = "com.transsion.aiot.mulcollaboration.MulCooperateService";
    private final String writeServicePackageName = "com.transsion.iotservice";
    private final ConcurrentHashMap<String, TCCardBean> mTcCardMap = new ConcurrentHashMap<>();
    private final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.transsion.iotcardsdk.TCHelper$serviceConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            p pVar;
            Log.d(this.this$0.getTAG(), "onServiceConnected name:" + name);
            TCHelper tCHelper = this.this$0;
            int i8 = o.f10254b;
            if (service == null) {
                pVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = service.queryLocalInterface("org.appspot.transsion.aiot.aidl.IMulCooperateCommonInterface");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) {
                    n nVar = new n();
                    nVar.f10253b = service;
                    pVar = nVar;
                } else {
                    pVar = (p) iInterfaceQueryLocalInterface;
                }
            }
            tCHelper.setCommonService(pVar);
            SdkInit.INSTANCE.setTCircle(true);
            this.this$0.initCard();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.d(this.this$0.getTAG(), "onServiceDisconnected");
            if (this.this$0.getMApplication() != null && this.this$0.getIotCardCallBack() != null) {
                Log.d(this.this$0.getTAG(), "onServiceDisconnected reconnect");
                TCHelper tCHelper = this.this$0;
                Application mApplication = tCHelper.getMApplication();
                Intrinsics.checkNotNull(mApplication);
                Function0<Map<String, List<IotCardTemplateBean>>> iotCardCallBack = this.this$0.getIotCardCallBack();
                Intrinsics.checkNotNull(iotCardCallBack);
                tCHelper.bindWriteService(mApplication, iotCardCallBack);
                return;
            }
            Log.d(this.this$0.getTAG(), "onServiceDisconnected not disconnect:" + this.this$0.getMApplication() + "," + this.this$0.getIotCardCallBack());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.transsion.iotcardsdk.TCHelper$initCard$1$3] */
    public final void initCard() {
        IBinder iBinder;
        p pVar;
        try {
            Function0<? extends Map<String, ? extends List<? extends IotCardTemplateBean>>> function0 = this.iotCardCallBack;
            Map<String, ? extends List<? extends IotCardTemplateBean>> mapInvoke = function0 != null ? function0.invoke() : null;
            if (mapInvoke != null) {
                List listEmptyList = CollectionsKt.emptyList();
                for (Map.Entry<String, ? extends List<? extends IotCardTemplateBean>> entry : mapInvoke.entrySet()) {
                    String key = entry.getKey();
                    listEmptyList = (List) entry.getValue();
                    this.packageName = key;
                    this.settingProviderKey = key + ".iotcard";
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : listEmptyList) {
                    if (SdkInit.INSTANCE.isSupportDevice(((IotCardTemplateBean) obj).getDeviceTypeId())) {
                        arrayList.add(obj);
                    }
                }
                List<TCCardBean> listConvertToTCCardBeanList = IotcardConverter.INSTANCE.convertToTCCardBeanList(arrayList);
                for (TCCardBean tCCardBean : listConvertToTCCardBeanList) {
                    this.mTcCardMap.put(tCCardBean.getControlId(), tCCardBean);
                }
                String json = IotcardConverter.INSTANCE.toJson(listConvertToTCCardBeanList);
                Log.d(this.TAG, "json:" + json);
                p pVar2 = this.commonService;
                if (pVar2 == null || (iBinder = ((n) pVar2).f10253b) == null || !iBinder.isBinderAlive() || (pVar = this.commonService) == null) {
                    return;
                }
                ((n) pVar).e(this.settingProviderKey, json, new f() { // from class: com.transsion.iotcardsdk.TCHelper$initCard$1$3
                    {
                        attachInterface(this, "org.appspot.transsion.aiot.aidl.IAppListener");
                    }
                });
            }
        } catch (Exception e) {
            Log.e(this.TAG, "initCard error e:" + e);
        }
    }

    public final void bindWriteService(Application application, Function0<? extends Map<String, ? extends List<? extends IotCardTemplateBean>>> callBack) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.mApplication = application;
        Intent intent = new Intent();
        intent.setAction(this.writeServiceAction);
        intent.setPackage(this.writeServicePackageName);
        this.iotCardCallBack = callBack;
        application.bindService(intent, this.serviceConnection, 1);
    }

    public final p getCommonService() {
        return this.commonService;
    }

    public final Function0<Map<String, List<IotCardTemplateBean>>> getIotCardCallBack() {
        return this.iotCardCallBack;
    }

    public final Application getMApplication() {
        return this.mApplication;
    }

    public final ConcurrentHashMap<String, TCCardBean> getMTcCardMap() {
        return this.mTcCardMap;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final String getSettingProviderKey() {
        return this.settingProviderKey;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final String getWriteServiceAction() {
        return this.writeServiceAction;
    }

    public final String getWriteServicePackageName() {
        return this.writeServicePackageName;
    }

    public final void registerDevice(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        TCCardBean tCCardBeanConvertToTCCardBean = IotcardConverter.INSTANCE.convertToTCCardBean(iotCardTemplateBean);
        this.mTcCardMap.put(tCCardBeanConvertToTCCardBean.getControlId(), tCCardBeanConvertToTCCardBean);
        writeSettingProvider();
    }

    public final void registerDeviceList(List<? extends IotCardTemplateBean> cardList) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        for (TCCardBean tCCardBean : IotcardConverter.INSTANCE.convertToTCCardBeanList(cardList)) {
            this.mTcCardMap.put(tCCardBean.getControlId(), tCCardBean);
        }
        writeSettingProvider();
    }

    public final void setCommonService(p pVar) {
        this.commonService = pVar;
    }

    public final void setIotCardCallBack(Function0<? extends Map<String, ? extends List<? extends IotCardTemplateBean>>> function0) {
        this.iotCardCallBack = function0;
    }

    public final void setMApplication(Application application) {
        this.mApplication = application;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setSettingProviderKey(String str) {
        this.settingProviderKey = str;
    }

    public final void unregisterDevice(String controlId) {
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        this.mTcCardMap.remove(controlId);
        writeSettingProvider();
    }

    public final void unregisterDeviceList(List<? extends IotCardTemplateBean> iotCardTemplateBeans) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBeans, "iotCardTemplateBeans");
        Iterator<T> it = iotCardTemplateBeans.iterator();
        while (it.hasNext()) {
            this.mTcCardMap.remove(((IotCardTemplateBean) it.next()).getControlId());
        }
        writeSettingProvider();
    }

    public final void updateDevice(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        TCCardBean tCCardBeanConvertToTCCardBean = IotcardConverter.INSTANCE.convertToTCCardBean(iotCardTemplateBean);
        this.mTcCardMap.put(tCCardBeanConvertToTCCardBean.getControlId(), tCCardBeanConvertToTCCardBean);
        writeSettingProvider();
    }

    public final void updateDeviceList(List<? extends IotCardTemplateBean> cardList) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        for (TCCardBean tCCardBean : IotcardConverter.INSTANCE.convertToTCCardBeanList(cardList)) {
            this.mTcCardMap.put(tCCardBean.getControlId(), tCCardBean);
        }
        writeSettingProvider();
    }

    public final void writeSettingProvider() {
        IBinder iBinder;
        p pVar;
        try {
            IotcardConverter iotcardConverter = IotcardConverter.INSTANCE;
            Collection<TCCardBean> collectionValues = this.mTcCardMap.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "mTcCardMap.values");
            String json = iotcardConverter.toJson(CollectionsKt.toList(collectionValues));
            Log.d(this.TAG, "writeSettingProvider:" + json);
            p pVar2 = this.commonService;
            if (pVar2 == null || (iBinder = ((n) pVar2).f10253b) == null || !iBinder.isBinderAlive() || (pVar = this.commonService) == null) {
                return;
            }
            ((n) pVar).e(this.settingProviderKey, json, null);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.TAG, "writeSettingProvider error e:" + e);
        }
    }
}
