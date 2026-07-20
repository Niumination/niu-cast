package jb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideBean;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideResource;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import com.transsion.iotservice.multiscreen.pc.bean.VapAssetList;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import eb.k1;
import eb.y;
import java.util.List;
import k3.gc;
import k3.sb;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    /* JADX WARN: Code duplicated, block: B:11:0x0049  */
    /* JADX WARN: Code duplicated, block: B:13:0x006b  */
    /* JADX WARN: Code duplicated, block: B:15:0x007e  */
    /* JADX WARN: Code duplicated, block: B:17:0x0094  */
    /* JADX WARN: Code duplicated, block: B:19:0x009e  */
    /* JADX WARN: Code duplicated, block: B:9:0x0043  */
    public final FunctionGuideResource a() {
        List listListOf;
        FunctionGuideBean.Companion companion;
        FunctionGuideBean functionGuideBeanCreateDefaultGuide;
        if (sb.b()) {
            y yVar = y.f4799a;
            k1 k1Var = k1.f4765a;
            hc.c cVar = k1.e;
            if (cVar != null && cVar.f == 3) {
                VapResource function_guide_full_screen = VapAssetList.getFUNCTION_GUIDE_FULL_SCREEN();
                int i8 = R$string.large_screen_viewing;
                int i9 = R$string.md_func_tip3;
                FunctionGuideBean.Companion companion2 = FunctionGuideBean.INSTANCE;
                listListOf = CollectionsKt.listOf((Object[]) new FunctionGuideBean[]{companion2.createDefaultGuide(function_guide_full_screen, i8, i9), companion2.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTIPLE_WINDOWS(), R$string.easy_multiwindow_operation_more, R$string.split_screen_chat_video), companion2.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_FILE_DRAG(), R$string.file_fast_transfer, R$string.md_func_tip7)});
            } else if (sb.b()) {
                VapResource function_guide_multi_sync_view = VapAssetList.getFUNCTION_GUIDE_MULTI_SYNC_VIEW();
                int i10 = R$string.pad_phone_mirror;
                int i11 = R$string.md_func_tip8;
                companion = FunctionGuideBean.INSTANCE;
                FunctionGuideBean functionGuideBeanCreateDefaultGuide2 = companion.createDefaultGuide(function_guide_multi_sync_view, i10, i11);
                FunctionGuideBean functionGuideBeanCreateDefaultGuide3 = companion.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTI_CLIP_MIRROR(), R$string.md_paste_from_other_device, R$string.md_func_tip9);
                if (o7.a.c("com.transsion.phone_extend_pad")) {
                    Intrinsics.checkNotNullParameter("DefaultDataSource", "tag");
                    Intrinsics.checkNotNullParameter("loadFunctionGuideResource,PHONE_EXTEND_PAD is supported", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("DefaultDataSource"), "loadFunctionGuideResource,PHONE_EXTEND_PAD is supported");
                    }
                    functionGuideBeanCreateDefaultGuide = companion.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW(), R$string.md_phone_extend, R$string.md_screen_extend_subtitle);
                } else {
                    functionGuideBeanCreateDefaultGuide = null;
                }
                listListOf = CollectionsKt.listOfNotNull((Object[]) new FunctionGuideBean[]{functionGuideBeanCreateDefaultGuide2, functionGuideBeanCreateDefaultGuide3, functionGuideBeanCreateDefaultGuide});
            } else {
                VapResource function_guide_expand_windows = VapAssetList.getFUNCTION_GUIDE_EXPAND_WINDOWS();
                int i12 = R$string.md_screen_extend;
                int i13 = R$string.md_func_tip10;
                FunctionGuideBean.Companion companion3 = FunctionGuideBean.INSTANCE;
                listListOf = CollectionsKt.listOf((Object[]) new FunctionGuideBean[]{companion3.createDefaultGuide(function_guide_expand_windows, i12, i13), companion3.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTIPLE_WINDOWS(), R$string.easy_multiwindow_operation, R$string.md_func_tip5), companion3.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_FILE_DRAG(), R$string.file_fast_transfer, R$string.md_func_tip7)});
            }
        } else if (sb.b()) {
            VapResource function_guide_multi_sync_view2 = VapAssetList.getFUNCTION_GUIDE_MULTI_SYNC_VIEW();
            int i14 = R$string.pad_phone_mirror;
            int i15 = R$string.md_func_tip8;
            companion = FunctionGuideBean.INSTANCE;
            FunctionGuideBean functionGuideBeanCreateDefaultGuide4 = companion.createDefaultGuide(function_guide_multi_sync_view2, i14, i15);
            FunctionGuideBean functionGuideBeanCreateDefaultGuide5 = companion.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTI_CLIP_MIRROR(), R$string.md_paste_from_other_device, R$string.md_func_tip9);
            if (o7.a.c("com.transsion.phone_extend_pad")) {
                Intrinsics.checkNotNullParameter("DefaultDataSource", "tag");
                Intrinsics.checkNotNullParameter("loadFunctionGuideResource,PHONE_EXTEND_PAD is supported", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("DefaultDataSource"), "loadFunctionGuideResource,PHONE_EXTEND_PAD is supported");
                }
                functionGuideBeanCreateDefaultGuide = companion.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW(), R$string.md_phone_extend, R$string.md_screen_extend_subtitle);
            } else {
                functionGuideBeanCreateDefaultGuide = null;
            }
            listListOf = CollectionsKt.listOfNotNull((Object[]) new FunctionGuideBean[]{functionGuideBeanCreateDefaultGuide4, functionGuideBeanCreateDefaultGuide5, functionGuideBeanCreateDefaultGuide});
        } else {
            VapResource function_guide_expand_windows2 = VapAssetList.getFUNCTION_GUIDE_EXPAND_WINDOWS();
            int i16 = R$string.md_screen_extend;
            int i17 = R$string.md_func_tip10;
            FunctionGuideBean.Companion companion4 = FunctionGuideBean.INSTANCE;
            listListOf = CollectionsKt.listOf((Object[]) new FunctionGuideBean[]{companion4.createDefaultGuide(function_guide_expand_windows2, i16, i17), companion4.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_MULTIPLE_WINDOWS(), R$string.easy_multiwindow_operation, R$string.md_func_tip5), companion4.createDefaultGuide(VapAssetList.getFUNCTION_GUIDE_FILE_DRAG(), R$string.file_fast_transfer, R$string.md_func_tip7)});
        }
        return new FunctionGuideResource("", listListOf, 0);
    }

    public final SearchPageText b() {
        Intrinsics.checkNotNullParameter("DefaultDataSource", "tag");
        Intrinsics.checkNotNullParameter("loadSearchPageResource", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DefaultDataSource"), "loadSearchPageResource");
        }
        return new SearchPageText(new TextBean(Integer.valueOf(R$string.connect_tips), null), new TextBean(Integer.valueOf(R$string.module_pc_get_our_pc_connect_www), null), false, 4, null);
    }
}
