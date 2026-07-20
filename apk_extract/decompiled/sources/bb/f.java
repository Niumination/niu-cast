package bb;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.VapAssetList;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import com.transsion.widgetslistitemlayout.OSListItemView;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import k3.gc;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import se.r6;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1238d;

    public /* synthetic */ f(OSListItemView oSListItemView, BaseSettingActivity baseSettingActivity, OSListItemView oSListItemView2) {
        this.f1235a = 0;
        this.f1236b = oSListItemView;
        this.f1238d = baseSettingActivity;
        this.f1237c = oSListItemView2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        VapResource extension_mirror_resource;
        Object obj2 = this.f1238d;
        Object obj3 = this.f1237c;
        Object obj4 = this.f1236b;
        switch (this.f1235a) {
            case 0:
                int i8 = BaseSettingActivity.f2662k;
                OSListItemView oSListItemView = (OSListItemView) obj4;
                if (!Intrinsics.areEqual((Boolean) obj, Boolean.FALSE)) {
                    if (oSListItemView != null) {
                        oSListItemView.f3802o = 3;
                        oSListItemView.invalidate();
                    }
                    BaseSettingActivity baseSettingActivity = (BaseSettingActivity) obj2;
                    Drawable drawable = ContextCompat.getDrawable(baseSettingActivity, baseSettingActivity.n().a());
                    if (drawable != null) {
                        OSListItemView oSListItemView2 = (OSListItemView) obj3;
                        if (oSListItemView2 != null) {
                            oSListItemView2.d(drawable);
                        }
                        if (oSListItemView2 != null) {
                            oSListItemView2.setLeftImageStrokeColor(0);
                        }
                    }
                } else if (oSListItemView != null) {
                    oSListItemView.f3802o = 1;
                    oSListItemView.invalidate();
                }
                return Unit.INSTANCE;
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                while (byteBuffer.hasRemaining()) {
                    lg.c cVar = (lg.c) obj4;
                    Ref.IntRef intRef = (Ref.IntRef) obj3;
                    WritableByteChannel writableByteChannel = (WritableByteChannel) obj2;
                    if (cVar == null) {
                        do {
                            intRef.element = writableByteChannel.write(byteBuffer);
                            if (!byteBuffer.hasRemaining()) {
                            }
                        } while (intRef.element > 0);
                    } else {
                        cVar.a();
                        do {
                            try {
                                intRef.element = writableByteChannel.write(byteBuffer);
                                if (byteBuffer.hasRemaining()) {
                                }
                                Unit unit = Unit.INSTANCE;
                                cVar.b();
                            } catch (Throwable th2) {
                                cVar.b();
                                throw th2;
                            }
                        } while (intRef.element > 0);
                        Unit unit2 = Unit.INSTANCE;
                        cVar.b();
                    }
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                String it = (String) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                w wVar = (w) obj4;
                if (wVar != null) {
                    String string = ((TextView) obj3).getContext().getResources().getString(((SearchPageText) obj2).getLink().getDefaultText().intValue());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    wVar.d(string);
                }
                return Unit.INSTANCE;
            case 3:
                Pair pair = (Pair) obj;
                int i9 = CastControlDialog.f2710n;
                boolean zBooleanValue = ((Boolean) pair.component1()).booleanValue();
                boolean zBooleanValue2 = ((Boolean) pair.component2()).booleanValue();
                Ref.BooleanRef booleanRef = (Ref.BooleanRef) obj4;
                Ref.BooleanRef booleanRef2 = (Ref.BooleanRef) obj3;
                if (zBooleanValue == booleanRef.element && zBooleanValue2 == booleanRef2.element) {
                    Intrinsics.checkNotNullParameter("CastControlDialog", "tag");
                    Intrinsics.checkNotNullParameter("state no change", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("CastControlDialog"), "state no change");
                    }
                    return Unit.INSTANCE;
                }
                CastControlDialog castControlDialog = (CastControlDialog) obj2;
                CastControlViewModel castControlViewModel = castControlDialog.f2712k;
                CastControlViewModel castControlViewModel2 = null;
                if (castControlViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    castControlViewModel = null;
                }
                boolean z2 = booleanRef.element;
                boolean z3 = booleanRef2.element;
                castControlViewModel.getClass();
                String log = "fromMirror: " + z2 + ", fromExtend: " + z3 + ", toMirror: " + zBooleanValue + ", toExtend: " + zBooleanValue2;
                Intrinsics.checkNotNullParameter("CastControlViewModel", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("CastControlViewModel"), log);
                }
                if (!z2 && !z3 && zBooleanValue) {
                    extension_mirror_resource = VapAssetList.getCLOSE_MIRROR_RESOURCE();
                } else if (z2 && !zBooleanValue && !zBooleanValue2) {
                    extension_mirror_resource = VapAssetList.getMIRROR_CLOSE_RESOURCE();
                } else if (!z2 && !z3 && zBooleanValue2) {
                    extension_mirror_resource = VapAssetList.getCLOSE_EXTENSION_RESOURCE();
                } else if (z3 && !zBooleanValue2 && !zBooleanValue) {
                    extension_mirror_resource = VapAssetList.getEXTENSION_CLOSE_RESOURCE();
                } else if (z2 && zBooleanValue2) {
                    extension_mirror_resource = VapAssetList.getMIRROR_EXTENSION_RESOURCE();
                } else {
                    extension_mirror_resource = (z3 && zBooleanValue) ? VapAssetList.getEXTENSION_MIRROR_RESOURCE() : VapAssetList.getMIRROR_CLOSE_RESOURCE();
                }
                CastControlViewModel castControlViewModel3 = castControlDialog.f2712k;
                if (castControlViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    castControlViewModel2 = castControlViewModel3;
                }
                castControlViewModel2.f2724j.setValue(extension_mirror_resource);
                if (extension_mirror_resource != null) {
                    String strN = o.d.n("setMirrorAnimResource: ", extension_mirror_resource.getPath(), "CastControlViewModel", "tag", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("CastControlViewModel"), strN);
                    }
                }
                booleanRef.element = zBooleanValue;
                booleanRef2.element = zBooleanValue2;
                return Unit.INSTANCE;
            case 4:
                TranConnectionController$MessageInfo msgInfo = (TranConnectionController$MessageInfo) obj;
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                ((NearDevice) obj4).d(msgInfo, (r6) obj3, (a8.a) obj2);
                return Unit.INSTANCE;
            default:
                TranConnectionController$MessageInfo msgInfo2 = (TranConnectionController$MessageInfo) obj;
                Intrinsics.checkNotNullParameter(msgInfo2, "msgInfo");
                ((NearDevice) obj4).d(msgInfo2, (r6) obj3, (a8.a) obj2);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ f(Object obj, int i8, Object obj2, Object obj3) {
        this.f1235a = i8;
        this.f1236b = obj;
        this.f1237c = obj2;
        this.f1238d = obj3;
    }
}
