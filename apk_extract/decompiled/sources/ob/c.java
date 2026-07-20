package ob;

import android.app.Application;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.UserHandle;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.R$mipmap;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.TCircleConfirmDialog;
import com.transsion.iotservice.multiscreen.pc.ui.search.GestureHandleActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.WaitAcceptFragment;
import com.welink.protocol.wifi.KolunPhoneConnectWifiDeviceUtil$1;
import eb.y;
import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executors;
import jh.k;
import k3.gc;
import k3.lb;
import k3.pb;
import kotlin.Lazy;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import m3.q;
import mg.a0;
import qe.f;
import qe.i;
import we.h;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8438a;

    public /* synthetic */ c(int i8) {
        this.f8438a = i8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        oe.c cVar;
        Object obj;
        int i8;
        byte b9;
        String string;
        byte b10 = 0;
        int i9 = 2;
        switch (this.f8438a) {
            case 0:
                Lazy lazy = d.f8439a;
                return Boolean.FALSE;
            case 1:
                h.g("thread start");
                while (oe.c.f8454t) {
                    Triple triple = (Triple) oe.c.f8452r.take();
                    if (triple != null) {
                        int iIntValue = ((Number) triple.getFirst()).intValue();
                        if (iIntValue == 1) {
                            oe.c cVar2 = (oe.c) triple.getThird();
                            if (cVar2 != null) {
                                Object second = triple.getSecond();
                                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.welink.protocol.model.SendDataModel");
                                i sendDataModel = (i) second;
                                Intrinsics.checkNotNullParameter(sendDataModel, "sendDataModel");
                                ArrayList arrayList = new ArrayList();
                                List<Byte> mutableList = ArraysKt.toMutableList(sendDataModel.f9030c);
                                h.g("update connect parameter before send data");
                                byte b11 = sendDataModel.f9029b ? (byte) 1 : b10;
                                int i10 = b10;
                                while (true) {
                                    List<Byte> list = mutableList;
                                    int length = CollectionsKt.toByteArray(list).length;
                                    int i11 = oe.c.p;
                                    f fVar = oe.c.f8453s;
                                    byte b12 = sendDataModel.f9028a;
                                    if (length > i11) {
                                        boolean z2 = cVar2.f8461i;
                                        if (z2 && cVar2.f8460h) {
                                            if ((UByte.m177constructorimpl(fVar.f9013a) & UByte.MAX_VALUE) == b12) {
                                                if (fVar.f9014b) {
                                                    int i12 = fVar.f9015c;
                                                    i10 = i12 == 255 ? 0 : i12 + 1;
                                                    fVar.f9015c = i10;
                                                    h.g("SendDataTruly: packetIndex: " + i10);
                                                } else {
                                                    Intrinsics.checkNotNullParameter("Error: sendDataTruly: the remote received failed, so stop send!!!", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("welinkBLE", "Error: sendDataTruly: the remote received failed, so stop send!!!", null);
                                                    }
                                                }
                                            }
                                            arrayList.add((byte) -18);
                                            arrayList.add(Byte.valueOf(q.i(oe.c.p)[1]));
                                            arrayList.add(Byte.valueOf(b12));
                                            byte b13 = (byte) (((byte) (q.i(oe.c.p)[0] & 1)) == 1 ? ((byte) (b11 & (-17))) | 16 : (byte) (b11 & (-17)));
                                            b11 = (byte) (((byte) (((byte) ((((byte) (q.i(oe.c.p)[0] & 2)) >> 1) == 1 ? ((byte) (b13 & (-33))) | 32 : (byte) (b13 & (-33)))) & (-3))) | 2);
                                            arrayList.add(Byte.valueOf(b11));
                                            arrayList.add(Byte.valueOf((byte) i10));
                                            List<Byte> list2 = mutableList;
                                            arrayList.addAll(CollectionsKt.toMutableList((Collection) CollectionsKt.take(list2, oe.c.p)));
                                            cVar2.d(CollectionsKt.toByteArray(arrayList));
                                            mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.drop(list2, oe.c.p));
                                            if ((UByte.m177constructorimpl(fVar.f9013a) & UByte.MAX_VALUE) == b12 && fVar.f9014b) {
                                                int i13 = fVar.f9016d + oe.c.p;
                                                fVar.f9016d = i13;
                                                float f = i13;
                                                h.g("SendDataTruly: the sent data's percent is ================" + ((int) ((f / (CollectionsKt.toByteArray(mutableList).length + f)) * 100)) + "%==================\nmHugeDataModel.dataSendOffset: " + fVar.f9016d);
                                            }
                                            i10 = i10 == 255 ? 0 : i10 + 1;
                                            arrayList.clear();
                                        } else {
                                            String mes = "Error: sendDataTruly: GattConnect is " + z2 + ", DescriptorWriteStatus is " + cVar2.f8460h + ", stop send data";
                                            Intrinsics.checkNotNullParameter(mes, "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("welinkBLE", mes, null);
                                            }
                                        }
                                    } else {
                                        if ((UByte.m177constructorimpl(fVar.f9013a) & UByte.MAX_VALUE) != b12) {
                                            obj = null;
                                        } else if (fVar.f9014b) {
                                            obj = null;
                                            int i14 = fVar.f9015c;
                                            i10 = i14 == 255 ? 0 : i14 + 1;
                                            fVar.f9015c = i10;
                                            h.g("SendDataTruly: final data, packetIndex: " + i10);
                                        } else {
                                            Intrinsics.checkNotNullParameter("Error: sendDataTruly: the remote received failed, so stop send!!!", "mes");
                                            if (lb.f6529c >= 1) {
                                                obj = null;
                                                Log.e("welinkBLE", "Error: sendDataTruly: the remote received failed, so stop send!!!", null);
                                            }
                                            b9 = 0;
                                            i8 = 2;
                                            b10 = b9;
                                            i9 = i8;
                                        }
                                        arrayList.add((byte) -18);
                                        arrayList.add(Byte.valueOf(q.i(CollectionsKt.toByteArray(list).length)[1]));
                                        arrayList.add(Byte.valueOf(b12));
                                        byte b14 = (byte) (((byte) (q.i(CollectionsKt.toByteArray(list).length)[0] & 1)) == 1 ? ((byte) (b11 & (-17))) | 16 : (byte) (b11 & (-17)));
                                        i8 = 2;
                                        arrayList.add(Byte.valueOf((byte) (((byte) ((((byte) (q.i(CollectionsKt.toByteArray(list).length)[0] & 2)) >> 1) == 1 ? ((byte) (b14 & (-33))) | 32 : (byte) (b14 & (-33)))) & (-3))));
                                        arrayList.add(Byte.valueOf((byte) i10));
                                        arrayList.addAll(list);
                                        cVar2.d(CollectionsKt.toByteArray(arrayList));
                                        if ((UByte.m177constructorimpl(fVar.f9013a) & UByte.MAX_VALUE) == b12 && fVar.f9014b) {
                                            int length2 = fVar.f9016d + CollectionsKt.toByteArray(list).length;
                                            fVar.f9016d = length2;
                                            h.g("SendDataTruly: the sent data's percent is ================100%==================\nmHugeDataModel.dataSendOffset: " + length2);
                                            b9 = 0;
                                            fVar.f9013a = (byte) 0;
                                            fVar.f9014b = true;
                                            fVar.f9015c = -1;
                                            fVar.f9016d = 0;
                                        } else {
                                            b9 = 0;
                                        }
                                        arrayList.clear();
                                        mutableList.clear();
                                        h.g("now recovery the connect parameter");
                                        b10 = b9;
                                        i9 = i8;
                                    }
                                    obj = null;
                                    b9 = 0;
                                    i8 = 2;
                                    b10 = b9;
                                    i9 = i8;
                                }
                            }
                        } else if (iIntValue == i9 && (cVar = (oe.c) triple.getThird()) != null) {
                            Object second2 = triple.getSecond();
                            Intrinsics.checkNotNull(second2, "null cannot be cast to non-null type kotlin.ByteArray");
                            oe.c.a(cVar, (byte[]) second2);
                        }
                    }
                }
                h.g("thread finish");
                return Unit.INSTANCE;
            case 2:
                return pa.c.f8705a;
            case 3:
                return new ka.d();
            case 4:
                return new s8.a();
            case 5:
                d9.a aVar = new d9.a();
                String str = pa.c.e;
                String str2 = l9.a.f7342a;
                aVar.a().a(str);
                return aVar;
            case 6:
                return new f9.a();
            case 7:
                return Unit.INSTANCE;
            case 8:
                return Unit.INSTANCE;
            case 9:
                return Unit.INSTANCE;
            case 10:
                try {
                    return FileSystems.getDefault().newWatchService();
                } catch (NoClassDefFoundError unused) {
                    return null;
                }
            case 11:
                y yVar = y.f4799a;
                return pb.a().getResources().getString(R$string.module_pc_pc_match_request, y.f == 1 ? pb.a().getResources().getString(R$string.module_pc_expand_screen_title) : pb.a().getResources().getString(R$string.module_pc_connect));
            case 12:
                c cVar3 = TCircleConfirmDialog.f2756d;
                if (cVar3 != null) {
                    cVar3.invoke();
                }
                return Unit.INSTANCE;
            case 13:
                Object systemService = pb.a().getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                return (ConnectivityManager) systemService;
            case 14:
                Object systemService2 = pb.a().getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
                return (ConnectivityManager) systemService2;
            case 15:
                return new eb.d(i9);
            case 16:
                return new k(false);
            case 17:
                return new LinkedHashMap();
            case 18:
                HandlerThread handlerThread = new HandlerThread("NotificationHandler");
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            case 19:
                return Integer.valueOf(R$mipmap.icon_flash_light_on);
            case 20:
                return Integer.valueOf(R$mipmap.icon_flash_light_off);
            case 21:
                return Executors.newSingleThreadExecutor();
            case 22:
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = pb.a().getString(R$string.scan_instruction);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                if (na.c.a()) {
                    string = pb.a().getString(R$string.module_pc_connect);
                    Intrinsics.checkNotNull(string);
                } else {
                    string = pb.a().getString(R$string.pc_manager);
                    Intrinsics.checkNotNull(string);
                }
                return o.d.q(new Object[]{string, pb.a().getString(R$string.device_connect)}, 2, string2, "format(...)");
            case 23:
                return Boolean.FALSE;
            case 24:
                try {
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter("FileReceiver---ReceiverFinish---:", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("FileTransferProcessor"), "FileReceiver---ReceiverFinish---:");
                    }
                    b.f8417b.c("succes_end");
                    sj.a aVar2 = xa.i.f10891a;
                    xa.i.f();
                    Application context = pb.a();
                    String path = xa.i.p;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(path, "path");
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(new File(path)));
                    UserHandle CURRENT = z8.a.f11265a;
                    Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
                    pb.c(context, intent);
                    pa.a aVar3 = pa.a.f8703a;
                    Intent intent2 = new Intent((pa.a.j("ro.tr_project.flip_screen.support") || pa.a.j("ro.tr_project.foldable_screen.support")) ? "com.transsion.filemanagerx.PCCONNECTION_FOLDABLE" : "com.transsion.filemanagerx.PCINTERCONNECTION");
                    intent2.setFlags(268435456);
                    sj.a aVar4 = xa.i.f10891a;
                    Application applicationA = pb.a();
                    Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
                    pb.d(aVar4, applicationA, intent2);
                    break;
                } catch (Exception e) {
                    Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
                    Intrinsics.checkNotNullParameter(e, "e");
                    Log.e(gc.f6463b.concat("FileTransferProcessor"), e.getMessage(), e);
                }
                return Unit.INSTANCE;
            case 25:
                GestureHandleActivity.f2816a = true;
                return Unit.INSTANCE;
            case 26:
                int i15 = KolunPhoneConnectWifiDeviceUtil$1.f4248a;
                throw null;
            case 27:
                int i16 = KolunPhoneConnectWifiDeviceUtil$1.f4248a;
                throw null;
            case 28:
                try {
                    Class.forName("java.nio.file.Files");
                    return new n5.a();
                } catch (ClassNotFoundException unused2) {
                    return new a0();
                }
            default:
                return new WaitAcceptFragment();
        }
    }
}
