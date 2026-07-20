package jb;

import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.http.CloudInterface;
import com.transsion.iotservice.multiscreen.pc.http.RetrofitClient;
import com.transsion.iotservice.multiscreen.pc.http.entity.BaseResponse;
import com.transsion.iotservice.multiscreen.pc.http.entity.PhoneDataEntity;
import dj.m0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import k3.gc;
import k3.vb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import li.b0;
import li.g0;
import li.h0;
import li.i2;
import li.l0;
import li.v0;
import zj.o0;
import zj.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static CloudInterface f6144d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qi.c f6145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f6142b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vi.c f6143c = vi.d.a();
    public static final n e = new n(b0.f7433a);

    public o() {
        i2 i2VarD = l0.d();
        v0 v0Var = v0.f7498a;
        this.f6145a = h0.a(CoroutineContext.Element.DefaultImpls.plus(i2VarD, si.e.f10118a));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object a(String str, String str2, ContinuationImpl continuationImpl) throws Throwable {
        i iVar;
        if (continuationImpl instanceof i) {
            iVar = (i) continuationImpl;
            int i8 = iVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                iVar.label = i8 - Integer.MIN_VALUE;
            } else {
                iVar = new i(this, continuationImpl);
            }
        } else {
            iVar = new i(this, continuationImpl);
        }
        Object objD = iVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = iVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(objD);
                iVar.L$0 = str;
                iVar.L$1 = str2;
                iVar.label = 1;
                objD = d(iVar);
                if (objD == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = (String) iVar.L$1;
                str = (String) iVar.L$0;
                ResultKt.throwOnFailure(objD);
            }
            o0 o0VarExecute = ((CloudInterface) objD).downloadResource(str2).execute();
            gc.c("PhoneDataRepository", "downloadResourceSync:success");
            if (!o0VarExecute.f11691a.c()) {
                gc.b("PhoneDataRepository", "downloadResourceSync:response failed");
                return Boxing.boxBoolean(false);
            }
            m0 m0Var = (m0) o0VarExecute.f11692b;
            if (m0Var == null) {
                return Boxing.boxBoolean(false);
            }
            gc.c("PhoneDataRepository", "downloadResourceSync:" + str);
            File file = new File(str);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    Boxing.boxBoolean(parentFile.mkdirs());
                }
                file.createNewFile();
            }
            String strE = o0VarExecute.f11691a.f4580h.e("Content-Length");
            Long longOrNull = strE != null ? StringsKt.toLongOrNull(strE) : null;
            if (longOrNull != null && longOrNull.longValue() > 0) {
                gc.b("PhoneDataRepository", "downloadResourceSync:total is " + longOrNull);
                InputStream inputStreamJ0 = m0Var.g().j0();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i10 = inputStreamJ0.read(bArr);
                            if (i10 == -1) {
                                fileOutputStream.flush();
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, null);
                                CloseableKt.closeFinally(inputStreamJ0, null);
                                return Boxing.boxBoolean(true);
                            }
                            fileOutputStream.write(bArr, 0, i10);
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(inputStreamJ0, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(fileOutputStream, th3);
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            gc.b("PhoneDataRepository", "downloadResourceSync:total is null");
            return Boxing.boxBoolean(false);
        } catch (Exception e4) {
            gc.b("PhoneDataRepository", String.valueOf(e4.getMessage()));
            Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
            Intrinsics.checkNotNullParameter(e4, "e");
            Log.e(gc.f6463b.concat("PhoneDataRepository"), e4.getMessage(), e4);
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00de  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:56:0x0109  */
    /* JADX WARN: Code duplicated, block: B:57:0x0114  */
    /* JADX WARN: Code duplicated, block: B:59:0x0120  */
    /* JADX WARN: Code duplicated, block: B:60:0x0125  */
    /* JADX WARN: Code duplicated, block: B:68:0x0183  */
    /* JADX WARN: Code duplicated, block: B:71:0x019e  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:82:0x0248  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x021c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x01ba, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(ContinuationImpl continuationImpl) throws Throwable {
        j jVar;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Object obj;
        int i8;
        Ref.ObjectRef objectRef4;
        BaseResponse baseResponse;
        PhoneDataEntity phoneDataEntity;
        List<PhoneDataEntity.PhoneInfo> data;
        PhoneDataEntity phoneDataEntity2;
        List<PhoneDataEntity.PhoneInfo> data2;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        String MODEL;
        String lowerCase;
        String lowerCase2;
        SharedPreferences sharedPreferences3;
        String strN;
        T t3;
        if (continuationImpl instanceof j) {
            jVar = (j) continuationImpl;
            int i9 = jVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                jVar.label = i9 - Integer.MIN_VALUE;
            } else {
                jVar = new j(this, continuationImpl);
            }
        } else {
            jVar = new j(this, continuationImpl);
        }
        Object obj2 = jVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = jVar.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj2);
            Intrinsics.checkNotNullParameter("phone_data_version", "key");
            SharedPreferences sharedPreferences4 = vb.f6684a;
            if (sharedPreferences4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                sharedPreferences4 = null;
            }
            int i11 = sharedPreferences4.getInt("phone_data_version", -1);
            objectRef = new Ref.ObjectRef();
            try {
                Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                Intrinsics.checkNotNullParameter("getPhoneDataRemote", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PhoneDataRepository"), "getPhoneDataRemote");
                }
                jVar.L$0 = objectRef;
                jVar.L$1 = objectRef;
                jVar.I$0 = i11;
                jVar.label = 1;
                Object objD = d(jVar);
                if (objD == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef3 = objectRef;
                obj = objD;
                i8 = i11;
            } catch (Exception e4) {
                e = e4;
                objectRef2 = objectRef;
                Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                Intrinsics.checkNotNullParameter(e, "e");
                Log.e(gc.f6463b.concat("PhoneDataRepository"), e.getMessage(), e);
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef4 = (Ref.ObjectRef) jVar.L$1;
                objectRef2 = (Ref.ObjectRef) jVar.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    t3 = obj2;
                    objectRef4.element = t3;
                } catch (Exception e10) {
                    e = e10;
                    Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                    Intrinsics.checkNotNullParameter(e, "e");
                    Log.e(gc.f6463b.concat("PhoneDataRepository"), e.getMessage(), e);
                }
                baseResponse = (BaseResponse) objectRef2.element;
                if (baseResponse != null) {
                    if (!baseResponse.isSuccess()) {
                        strN = o.d.n("request phone data failed:", baseResponse.getMsg(), "PhoneDataRepository", "tag", "log");
                        if (gc.f6462a <= 6) {
                            Log.e(gc.f6463b.concat("PhoneDataRepository"), strN);
                        }
                    } else if (baseResponse.getRet() == null) {
                        Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                        Intrinsics.checkNotNullParameter("request phone data is null", "log");
                        if (gc.f6462a <= 6) {
                            Log.e(gc.f6463b.concat("PhoneDataRepository"), "request phone data is null");
                        }
                    } else {
                        phoneDataEntity = (PhoneDataEntity) ((BaseResponse) objectRef2.element).getRet();
                        if (phoneDataEntity != null) {
                            data = phoneDataEntity.getData();
                        } else {
                            data = null;
                        }
                        gc.a("PhoneDataRepository", "response=" + data);
                        phoneDataEntity2 = (PhoneDataEntity) baseResponse.getRet();
                        f6142b.getClass();
                        gc.a("PhoneDataRepository", "dataEntity=" + phoneDataEntity2);
                        gc.a("PhoneDataRepository", "data list=" + phoneDataEntity2.getData());
                        data2 = phoneDataEntity2.getData();
                        if (data2 != null && !data2.isEmpty()) {
                            int dataVersion = phoneDataEntity2.getDataVersion();
                            Intrinsics.checkNotNullParameter("phone_data_version", "key");
                            sharedPreferences = vb.f6684a;
                            if (sharedPreferences == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                sharedPreferences = null;
                            }
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putInt("phone_data_version", dataVersion);
                            editorEdit.apply();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            Intrinsics.checkNotNullParameter("latest_timestamp", "key");
                            sharedPreferences2 = vb.f6684a;
                            if (sharedPreferences2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                sharedPreferences2 = null;
                            }
                            SharedPreferences.Editor editorEdit2 = sharedPreferences2.edit();
                            editorEdit2.putLong("latest_timestamp", jCurrentTimeMillis);
                            editorEdit2.apply();
                            for (PhoneDataEntity.PhoneInfo phoneInfo : phoneDataEntity2.getData()) {
                                MODEL = Build.MODEL;
                                gc.a("PhoneDataRepository", "saveCurModelId, Build.MODEL=" + MODEL + ", phoneInfo.model=" + phoneInfo.getModel());
                                if (phoneInfo.getModel() == null) {
                                    String model = phoneInfo.getModel();
                                    Locale locale = Locale.ROOT;
                                    lowerCase = model.toLowerCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                    String BRAND = Build.BRAND;
                                    Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                    lowerCase2 = StringsKt__StringsKt.trim((CharSequence) StringsKt__StringsJVMKt.replace$default(MODEL, BRAND, "", false, 4, (Object) null)).toString().toLowerCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                                        gc.a("PhoneDataRepository", "saveCurModelId, phoneInfo.modelId=" + phoneInfo.getModelId());
                                        String value = phoneInfo.getModelId();
                                        Intrinsics.checkNotNullParameter(value, "modelId");
                                        Intrinsics.checkNotNullParameter("model_id", "key");
                                        Intrinsics.checkNotNullParameter(value, "value");
                                        sharedPreferences3 = vb.f6684a;
                                        if (sharedPreferences3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                            sharedPreferences3 = null;
                                        }
                                        SharedPreferences.Editor editorEdit3 = sharedPreferences3.edit();
                                        editorEdit3.putString("model_id", value);
                                        editorEdit3.apply();
                                    }
                                }
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i8 = jVar.I$0;
            objectRef = (Ref.ObjectRef) jVar.L$1;
            objectRef3 = (Ref.ObjectRef) jVar.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                obj = obj2;
            } catch (Exception e11) {
                e = e11;
                objectRef2 = objectRef3;
                Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                Intrinsics.checkNotNullParameter(e, "e");
                Log.e(gc.f6463b.concat("PhoneDataRepository"), e.getMessage(), e);
            }
        }
        jVar.L$0 = objectRef3;
        jVar.L$1 = objectRef;
        jVar.label = 2;
        Object phoneData = ((CloudInterface) obj).getPhoneData(1, i8, jVar);
        if (phoneData == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef4 = objectRef;
        objectRef2 = objectRef3;
        t3 = phoneData;
        objectRef4.element = t3;
        baseResponse = (BaseResponse) objectRef2.element;
        if (baseResponse != null) {
            if (!baseResponse.isSuccess()) {
                strN = o.d.n("request phone data failed:", baseResponse.getMsg(), "PhoneDataRepository", "tag", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("PhoneDataRepository"), strN);
                }
            } else if (baseResponse.getRet() == null) {
                Intrinsics.checkNotNullParameter("PhoneDataRepository", "tag");
                Intrinsics.checkNotNullParameter("request phone data is null", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("PhoneDataRepository"), "request phone data is null");
                }
            } else {
                phoneDataEntity = (PhoneDataEntity) ((BaseResponse) objectRef2.element).getRet();
                if (phoneDataEntity != null) {
                    data = phoneDataEntity.getData();
                } else {
                    data = null;
                }
                gc.a("PhoneDataRepository", "response=" + data);
                phoneDataEntity2 = (PhoneDataEntity) baseResponse.getRet();
                f6142b.getClass();
                gc.a("PhoneDataRepository", "dataEntity=" + phoneDataEntity2);
                gc.a("PhoneDataRepository", "data list=" + phoneDataEntity2.getData());
                data2 = phoneDataEntity2.getData();
                if (data2 != null) {
                    int dataVersion2 = phoneDataEntity2.getDataVersion();
                    Intrinsics.checkNotNullParameter("phone_data_version", "key");
                    sharedPreferences = vb.f6684a;
                    if (sharedPreferences == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        sharedPreferences = null;
                    }
                    SharedPreferences.Editor editorEdit4 = sharedPreferences.edit();
                    editorEdit4.putInt("phone_data_version", dataVersion2);
                    editorEdit4.apply();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    Intrinsics.checkNotNullParameter("latest_timestamp", "key");
                    sharedPreferences2 = vb.f6684a;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                        sharedPreferences2 = null;
                    }
                    SharedPreferences.Editor editorEdit5 = sharedPreferences2.edit();
                    editorEdit5.putLong("latest_timestamp", jCurrentTimeMillis2);
                    editorEdit5.apply();
                    while (r0.hasNext()) {
                        MODEL = Build.MODEL;
                        gc.a("PhoneDataRepository", "saveCurModelId, Build.MODEL=" + MODEL + ", phoneInfo.model=" + phoneInfo.getModel());
                        if (phoneInfo.getModel() == null) {
                            String model2 = phoneInfo.getModel();
                            Locale locale2 = Locale.ROOT;
                            lowerCase = model2.toLowerCase(locale2);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                            String BRAND2 = Build.BRAND;
                            Intrinsics.checkNotNullExpressionValue(BRAND2, "BRAND");
                            lowerCase2 = StringsKt__StringsKt.trim((CharSequence) StringsKt__StringsJVMKt.replace$default(MODEL, BRAND2, "", false, 4, (Object) null)).toString().toLowerCase(locale2);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                                gc.a("PhoneDataRepository", "saveCurModelId, phoneInfo.modelId=" + phoneInfo.getModelId());
                                String value2 = phoneInfo.getModelId();
                                Intrinsics.checkNotNullParameter(value2, "modelId");
                                Intrinsics.checkNotNullParameter("model_id", "key");
                                Intrinsics.checkNotNullParameter(value2, "value");
                                sharedPreferences3 = vb.f6684a;
                                if (sharedPreferences3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                                    sharedPreferences3 = null;
                                }
                                SharedPreferences.Editor editorEdit6 = sharedPreferences3.edit();
                                editorEdit6.putString("model_id", value2);
                                editorEdit6.apply();
                            }
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(ContinuationImpl continuationImpl) throws Throwable {
        k kVar;
        vi.c cVar;
        vi.a aVar;
        vi.a aVar2;
        Throwable th2;
        if (continuationImpl instanceof k) {
            kVar = (k) continuationImpl;
            int i8 = kVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                kVar.label = i8 - Integer.MIN_VALUE;
            } else {
                kVar = new k(this, continuationImpl);
            }
        } else {
            kVar = new k(this, continuationImpl);
        }
        Object obj = kVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = kVar.label;
        try {
            if (i9 == 0) {
                ResultKt.throwOnFailure(obj);
                CloudInterface cloudInterface = f6144d;
                if (cloudInterface != null) {
                    return cloudInterface;
                }
                cVar = f6143c;
                kVar.L$0 = cVar;
                kVar.label = 1;
                if (cVar.d(null, kVar) == coroutine_suspended) {
                    aVar = cVar;
                    return coroutine_suspended;
                }
            } else {
                if (i9 != 1) {
                    if (i9 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar2 = (vi.a) kVar.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        aVar2 = aVar2;
                        f6144d = (CloudInterface) ((q0) obj).b();
                        Unit unit = Unit.INSTANCE;
                        ((vi.c) aVar2).e(null);
                        CloudInterface cloudInterface2 = f6144d;
                        Intrinsics.checkNotNull(cloudInterface2);
                        return cloudInterface2;
                    } catch (Throwable th3) {
                        th2 = th3;
                        ((vi.c) aVar2).e(null);
                        throw th2;
                    }
                }
                vi.a aVar3 = (vi.a) kVar.L$0;
                ResultKt.throwOnFailure(obj);
                aVar = aVar3;
            }
            aVar = cVar;
            RetrofitClient retrofitClient = RetrofitClient.INSTANCE;
            kVar.L$0 = aVar;
            kVar.label = 2;
            Object retrofit = retrofitClient.getRetrofit(kVar);
            if (retrofit == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar2 = aVar;
            obj = retrofit;
            f6144d = (CloudInterface) ((q0) obj).b();
            Unit unit2 = Unit.INSTANCE;
            ((vi.c) aVar2).e(null);
            CloudInterface cloudInterface3 = f6144d;
            Intrinsics.checkNotNull(cloudInterface3);
            return cloudInterface3;
        } catch (Throwable th4) {
            aVar2 = aVar;
            th2 = th4;
            ((vi.c) aVar2).e(null);
            throw th2;
        }
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f6145a.f9137a;
    }
}
