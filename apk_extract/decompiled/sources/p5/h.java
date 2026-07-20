package p5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Feature[] f8680a = new Feature[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Feature f8681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j3.n f8682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j3.n f8683d;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        f8681b = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        Feature feature3 = new Feature("vision.face", 1L);
        Feature feature4 = new Feature("vision.ica", 1L);
        Feature feature5 = new Feature("vision.ocr", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        Feature feature8 = new Feature("tflite_dynamite", 1L);
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        j3.f fVar = new j3.f();
        fVar.a("barcode", feature);
        fVar.a("custom_ica", feature2);
        fVar.a("face", feature3);
        fVar.a("ica", feature4);
        fVar.a("ocr", feature5);
        fVar.a("langid", feature6);
        fVar.a("nlclassifier", feature7);
        fVar.a("tflite_dynamite", feature8);
        fVar.a("barcode_ui", feature9);
        fVar.a("smart_reply", feature10);
        j3.e eVar = fVar.f6069c;
        if (eVar != null) {
            throw eVar.a();
        }
        j3.n nVarZzg = j3.n.zzg(fVar.f6068b, fVar.f6067a, fVar);
        j3.e eVar2 = fVar.f6069c;
        if (eVar2 != null) {
            throw eVar2.a();
        }
        f8682c = nVarZzg;
        j3.f fVar2 = new j3.f();
        fVar2.a("com.google.android.gms.vision.barcode", feature);
        fVar2.a("com.google.android.gms.vision.custom.ica", feature2);
        fVar2.a("com.google.android.gms.vision.face", feature3);
        fVar2.a("com.google.android.gms.vision.ica", feature4);
        fVar2.a("com.google.android.gms.vision.ocr", feature5);
        fVar2.a("com.google.android.gms.mlkit.langid", feature6);
        fVar2.a("com.google.android.gms.mlkit.nlclassifier", feature7);
        fVar2.a("com.google.android.gms.tflite_dynamite", feature8);
        fVar2.a("com.google.android.gms.mlkit_smartreply", feature10);
        j3.e eVar3 = fVar2.f6069c;
        if (eVar3 != null) {
            throw eVar3.a();
        }
        j3.n nVarZzg2 = j3.n.zzg(fVar2.f6068b, fVar2.f6067a, fVar2);
        j3.e eVar4 = fVar2.f6069c;
        if (eVar4 != null) {
            throw eVar4.a();
        }
        f8683d = nVarZzg2;
    }

    public static void a(Context context, List list) {
        q3.k kVarB;
        p2.b.f8650b.getClass();
        if (p2.b.a(context) < 221500000) {
            Intent intent = new Intent();
            intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
            intent.setAction("com.google.android.gms.vision.DEPENDENCY");
            intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
            intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
            context.sendBroadcast(intent);
            return;
        }
        Feature[] featureArrB = b(f8682c, list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new p(featureArrB, 1));
        u2.l.a("APIs must not be empty.", !arrayList.isEmpty());
        y2.f fVar = new y2.f(context, y2.f.f11029i, q2.b.f8941g, q2.e.f8942b);
        ApiFeatureRequest apiFeatureRequestG = ApiFeatureRequest.g(arrayList, true);
        if (apiFeatureRequestG.f1921a.isEmpty()) {
            ModuleInstallResponse moduleInstallResponse = new ModuleInstallResponse(0, false);
            kVarB = new q3.k();
            kVarB.g(moduleInstallResponse);
        } else {
            r2.i iVar = new r2.i();
            iVar.f9335a = new Feature[]{h3.d.f5240c};
            iVar.f9336b = true;
            iVar.f9337c = 27304;
            iVar.f9338d = new se.e(fVar, apiFeatureRequestG);
            kVarB = fVar.b(0, iVar.a());
        }
        b bVar = b.f8667c;
        kVarB.getClass();
        kVarB.e(q3.h.f8951a, bVar);
    }

    public static Feature[] b(j3.g gVar, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            Feature feature = (Feature) ((j3.n) gVar).get(list.get(i8));
            u2.l.e(feature);
            featureArr[i8] = feature;
        }
        return featureArr;
    }
}
