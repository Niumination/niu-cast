package ag;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ue.NFCTouchSelectorActivity;
import com.transsion.iotservice.multiscreen.pc.ui.UsbEntranceActivity;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectDialog;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrScanActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.ConnectingFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.ConnectingViewModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import k3.gc;
import k3.pb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.AbstractLongTimeSource;
import li.j1;
import li.r1;
import li.v0;
import m3.c6;
import qg.y0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f753b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f752a = i8;
        this.f753b = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z2;
        boolean z3;
        int i8 = 0;
        FunctionGuideViewModel functionGuideViewModel = null;
        int i9 = 1;
        Object obj = this.f753b;
        switch (this.f752a) {
            case 0:
                d dVar = (d) obj;
                LinkedHashSet linkedHashSet = new LinkedHashSet(dVar.f761c.f793b);
                v vVar = dVar.f761c;
                int i10 = vVar.f793b;
                for (int i11 = 0; i11 < i10; i11++) {
                    linkedHashSet.add(vVar.c(i11).toString());
                }
                return linkedHashSet;
            case 1:
                bj.e eVar = (bj.e) obj;
                return Integer.valueOf(cj.i.c(eVar, eVar.f1346i));
            case 2:
                ((Function0) obj).invoke();
                return Unit.INSTANCE;
            case 3:
                ((gg.u) obj).A();
                return Unit.INSTANCE;
            case 4:
                return Long.valueOf(((AbstractLongTimeSource) obj).read());
            case 5:
                we.h.h("BleScanTool", "wifi auto connect to build area network success, now disconnect ble");
                oe.e eVar2 = ((ne.f) obj).f8201i;
                if (eVar2 != null) {
                    eVar2.b();
                }
                return Unit.INSTANCE;
            case 6:
                int i12 = NFCTouchSelectorActivity.f2680b;
                ((NFCTouchSelectorActivity) obj).init();
                return Unit.INSTANCE;
            case 7:
                ((r1) obj).r0();
                return Unit.INSTANCE;
            case 8:
                return ((rf.d) obj).a();
            case 9:
                int i13 = UsbEntranceActivity.f2702a;
                li.l0.p(j1.f7459a, v0.f7499b, null, new qb.c(null), 2);
                ob.b.f8417b.f8437a.getClass();
                Bundle bundle = new Bundle();
                bundle.putString("is_first_connect", tj.w.x());
                tj.w.X("iot_pc_con_cableconnect_startconnect", bundle);
                ((UsbEntranceActivity) obj).finish();
                return Unit.INSTANCE;
            case 10:
                return new qg.i0(((ng.r) ((qg.i) obj)).f8272i);
            case 11:
                qg.s response = (qg.s) obj;
                Intrinsics.checkNotNullParameter(response, "response");
                return new wg.d();
            case 12:
                return (vj.b) obj;
            case 13:
                qg.p0 p0Var = (qg.p0) obj;
                long j8 = p0Var.f9094d.f8251a;
                p0Var.g(j8, j8);
                return Unit.INSTANCE;
            case 14:
                int i14 = CastControlDialog.f2710n;
                Intrinsics.checkNotNullParameter("CastControlDialog", "tag");
                Intrinsics.checkNotNullParameter("onHomePressed", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("CastControlDialog"), "onHomePressed");
                }
                ((CastControlDialog) obj).finishAndRemoveTask();
                return Unit.INSTANCE;
            case 15:
                int i15 = PcRequestConnectDialog.f2742h;
                ((PcRequestConnectDialog) obj).finishAndRemoveTask();
                return Unit.INSTANCE;
            case 16:
                return (jh.o) obj;
            case 17:
                t7.c cVar = (t7.c) obj;
                cVar.getClass();
                Intrinsics.checkNotNullParameter("GalleryChangeMonitorWorker", "tag");
                Intrinsics.checkNotNullParameter("transImage", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("GalleryChangeMonitorWorker"), "transImage");
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("android:query-arg-sql-selection", "_size > ?");
                bundle2.putStringArray("android:query-arg-sql-selection-args", new String[]{"0"});
                bundle2.putStringArray("android:query-arg-sort-columns", new String[]{"_id"});
                bundle2.putInt("android:query-arg-sort-direction", 1);
                bundle2.putInt("android:query-arg-limit", 1);
                bundle2.putInt("android:query-arg-offset", 0);
                Cursor cursor = pb.a().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "_display_name"}, bundle2, null);
                if (cursor != null && cursor.moveToPosition(0)) {
                    File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                    long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    String[] strArr = cVar.f10195b;
                    int length = strArr.length;
                    while (true) {
                        if (i8 < length) {
                            String str = strArr[i8];
                            String parent = file.getParent();
                            if (parent == null || !StringsKt__StringsKt.contains(parent, (CharSequence) str, true)) {
                                i8++;
                            } else {
                                z2 = true;
                            }
                        } else {
                            z2 = false;
                        }
                    }
                    String[] strArr2 = cVar.f10196c;
                    int length2 = strArr2.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 < length2) {
                            String str2 = strArr2[i16];
                            String parent2 = file.getParent();
                            if (parent2 == null || !StringsKt__StringsKt.contains(parent2, (CharSequence) str2, true)) {
                                i16++;
                            } else {
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                    }
                    String log = "transImage timeDiff : " + jCurrentTimeMillis + "  isScreenShotPic:" + z2 + "  isCamera：" + z3 + " lastTransImageId:" + t7.c.e + "  imageId:" + j10;
                    Intrinsics.checkNotNullParameter("GalleryChangeMonitorWorker", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("GalleryChangeMonitorWorker"), log);
                    }
                    if (jCurrentTimeMillis < 10001 && j10 != t7.c.e) {
                        if (z2) {
                            boolean z5 = t7.a.f10190a;
                            Intrinsics.checkNotNullParameter(cursor, "cursor");
                            Iterator it = t7.a.e.iterator();
                            while (it.hasNext()) {
                                ((Function2) it.next()).invoke(cursor, 6);
                            }
                        } else if (z3) {
                            boolean z10 = t7.a.f10190a;
                            Intrinsics.checkNotNullParameter(cursor, "cursor");
                            Iterator it2 = t7.a.e.iterator();
                            while (it2.hasNext()) {
                                ((Function2) it2.next()).invoke(cursor, 2);
                            }
                        }
                        t7.c.e = j10;
                    }
                }
                return Unit.INSTANCE;
            case 18:
                int i17 = FunctionGuideActivity.f2774o;
                Intrinsics.checkNotNullParameter("FunctionGuideActivity", "tag");
                Intrinsics.checkNotNullParameter("onHomePressed", "log");
                if (gc.f6462a <= 5) {
                    Log.w(gc.f6463b.concat("FunctionGuideActivity"), "onHomePressed");
                }
                FunctionGuideActivity functionGuideActivity = (FunctionGuideActivity) obj;
                FunctionGuideViewModel functionGuideViewModel2 = functionGuideActivity.f2776l;
                if (functionGuideViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                } else {
                    functionGuideViewModel = functionGuideViewModel2;
                }
                functionGuideViewModel.a();
                functionGuideActivity.finishAndRemoveTask();
                return Unit.INSTANCE;
            case 19:
                List<String> listB = ((vg.f) obj).f10590a.a().b("Cookie");
                if (listB == null) {
                    return MapsKt.emptyMap();
                }
                HashMap map = new HashMap(listB.size());
                for (String cookiesHeader : listB) {
                    Regex regex = zf.k.f11517a;
                    Intrinsics.checkNotNullParameter(cookiesHeader, "cookiesHeader");
                    Sequence map2 = SequencesKt.map(Regex.findAll$default(zf.k.f11517a, cookiesHeader, 0, 2, null), new y0(28));
                    final char c9 = 1 == true ? 1 : 0;
                    map.putAll(MapsKt.toMap(SequencesKt.map(SequencesKt.filter(map2, new Function1() { // from class: zf.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Pair it3 = (Pair) obj2;
                            Intrinsics.checkNotNullParameter(it3, "it");
                            return Boolean.valueOf((c9 && StringsKt__StringsJVMKt.startsWith$default((String) it3.getFirst(), "$", false, 2, null)) ? false : true);
                        }
                    }), new y0(29))));
                }
                return map;
            case 20:
                String str3 = QrScanActivity.f2804c;
                ((QrScanActivity) obj).finish();
                return Unit.INSTANCE;
            case 21:
                zf.q qVar = zf.d0.f11496b;
                zf.f0 f0VarA = c6.a();
                xg.y yVar = (xg.y) obj;
                f0VarA.e(yVar.f10996a.getParameters());
                zf.d0 stringValues = yVar.f10999d;
                f0VarA.getClass();
                Intrinsics.checkNotNullParameter(stringValues, "stringValues");
                stringValues.c(new zg.v(f0VarA, i9));
                return f0VarA.build();
            case 22:
                ConnectingViewModel connectingViewModel = ((ConnectingFragment) obj).f2826d;
                if (connectingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConnectingViewModel");
                    connectingViewModel = null;
                }
                connectingViewModel.getClass();
                Intrinsics.checkNotNullParameter("RememberedViewModel", "tag");
                Intrinsics.checkNotNullParameter("reset state", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("RememberedViewModel"), "reset state");
                }
                connectingViewModel.e.postValue(Boolean.FALSE);
                connectingViewModel.f2832c.postValue(null);
                connectingViewModel.f2830a.postValue(null);
                return Unit.INSTANCE;
            default:
                ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if (((CharSequence) CollectionsKt.first((List) arrayList)).length() == 0 && arrayList.size() > 1) {
                    i8 = 1;
                }
                return arrayList.subList(i8, ((CharSequence) CollectionsKt.last((List) arrayList)).length() == 0 ? CollectionsKt.getLastIndex(arrayList) : CollectionsKt.getLastIndex(arrayList) + 1);
        }
    }
}
