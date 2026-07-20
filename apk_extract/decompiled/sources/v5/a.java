package v5;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import k3.b0;
import k3.be;
import k3.e0;
import k3.ka;
import k3.la;
import k3.sd;
import k3.td;
import k3.ua;
import k3.va;
import k3.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f10497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray f10498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f10499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f10500d;

    static {
        SparseArray sparseArray = new SparseArray();
        f10497a = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        f10498b = sparseArray2;
        f10499c = new AtomicReference();
        sparseArray.put(-1, ua.FORMAT_UNKNOWN);
        sparseArray.put(1, ua.FORMAT_CODE_128);
        sparseArray.put(2, ua.FORMAT_CODE_39);
        sparseArray.put(4, ua.FORMAT_CODE_93);
        sparseArray.put(8, ua.FORMAT_CODABAR);
        sparseArray.put(16, ua.FORMAT_DATA_MATRIX);
        sparseArray.put(32, ua.FORMAT_EAN_13);
        sparseArray.put(64, ua.FORMAT_EAN_8);
        sparseArray.put(128, ua.FORMAT_ITF);
        sparseArray.put(256, ua.FORMAT_QR_CODE);
        sparseArray.put(512, ua.FORMAT_UPC_A);
        sparseArray.put(1024, ua.FORMAT_UPC_E);
        sparseArray.put(2048, ua.FORMAT_PDF417);
        sparseArray.put(4096, ua.FORMAT_AZTEC);
        sparseArray2.put(0, va.TYPE_UNKNOWN);
        sparseArray2.put(1, va.TYPE_CONTACT_INFO);
        sparseArray2.put(2, va.TYPE_EMAIL);
        sparseArray2.put(3, va.TYPE_ISBN);
        sparseArray2.put(4, va.TYPE_PHONE);
        sparseArray2.put(5, va.TYPE_PRODUCT);
        sparseArray2.put(6, va.TYPE_SMS);
        sparseArray2.put(7, va.TYPE_TEXT);
        sparseArray2.put(8, va.TYPE_URL);
        sparseArray2.put(9, va.TYPE_WIFI);
        sparseArray2.put(10, va.TYPE_GEO);
        sparseArray2.put(11, va.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, va.TYPE_DRIVER_LICENSE);
        HashMap map = new HashMap();
        f10500d = map;
        map.put(1, sd.CODE_128);
        map.put(2, sd.CODE_39);
        map.put(4, sd.CODE_93);
        map.put(8, sd.CODABAR);
        map.put(16, sd.DATA_MATRIX);
        map.put(32, sd.EAN_13);
        map.put(64, sd.EAN_8);
        map.put(128, sd.ITF);
        map.put(256, sd.QR_CODE);
        map.put(512, sd.UPC_A);
        map.put(1024, sd.UPC_E);
        map.put(2048, sd.PDF417);
        map.put(4096, sd.AZTEC);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033  */
    /* JADX WARN: Code duplicated, block: B:13:0x003d A[LOOP:0: B:11:0x0037->B:13:0x003d, LOOP_END] */
    public static td a(r5.a aVar) {
        Iterator it;
        int i8 = aVar.f9381a;
        b0 b0Var = new b0();
        HashMap map = f10500d;
        if (i8 == 0) {
            Collection collectionValues = map.values();
            if (collectionValues instanceof Collection) {
                b0Var.b(collectionValues.size() + b0Var.f6371b);
                if (collectionValues instanceof z) {
                    b0Var.f6371b = ((z) collectionValues).zza((Object[]) b0Var.f6373d, b0Var.f6371b);
                } else {
                    it = collectionValues.iterator();
                    while (it.hasNext()) {
                        b0Var.a(it.next());
                    }
                }
            } else {
                it = collectionValues.iterator();
                while (it.hasNext()) {
                    b0Var.a(it.next());
                }
            }
        } else {
            for (Map.Entry entry : map.entrySet()) {
                if ((((Integer) entry.getKey()).intValue() & i8) != 0) {
                    b0Var.a((sd) entry.getValue());
                }
            }
        }
        a8.a aVar2 = new a8.a(11, false);
        aVar2.f44b = b0Var.c();
        return new td(aVar2);
    }

    public static void b(be beVar, ka kaVar) {
        beVar.b(new o5.c(kaVar), la.ON_DEVICE_BARCODE_LOAD);
    }

    public static boolean c() {
        AtomicReference atomicReference = f10499c;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        Context contextB = p5.f.c().b();
        e0 e0Var = h.f10520h;
        boolean z2 = g3.e.a(contextB, ModuleDescriptor.MODULE_ID) > 0;
        atomicReference.set(Boolean.valueOf(z2));
        return z2;
    }
}
