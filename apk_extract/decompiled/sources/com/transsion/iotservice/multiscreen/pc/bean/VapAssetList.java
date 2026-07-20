package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b:\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\bR\u001c\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\bR\u001c\u0010$\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\bR\u001c\u0010'\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\bR\u001c\u0010*\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\bR\u001c\u0010-\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u0010\bR\u001c\u00100\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\bR\u001c\u00103\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u0010\bR\u001c\u00106\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010\bR\u001c\u00109\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\bR\u001c\u0010<\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010\b¨\u0006?"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/VapAssetList;", "", "<init>", "()V", "SEARCH_WATER_RIPPLE_VAP", "Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;", "getSEARCH_WATER_RIPPLE_VAP$annotations", "getSEARCH_WATER_RIPPLE_VAP", "()Lcom/transsion/iotservice/multiscreen/pc/bean/VapResource;", "FUNCTION_GUIDE_FILE_DRAG", "getFUNCTION_GUIDE_FILE_DRAG$annotations", "getFUNCTION_GUIDE_FILE_DRAG", "FUNCTION_GUIDE_FULL_SCREEN", "getFUNCTION_GUIDE_FULL_SCREEN$annotations", "getFUNCTION_GUIDE_FULL_SCREEN", "FUNCTION_GUIDE_MULTIPLE_WINDOWS", "getFUNCTION_GUIDE_MULTIPLE_WINDOWS$annotations", "getFUNCTION_GUIDE_MULTIPLE_WINDOWS", "FUNCTION_GUIDE_EXPAND_WINDOWS", "getFUNCTION_GUIDE_EXPAND_WINDOWS$annotations", "getFUNCTION_GUIDE_EXPAND_WINDOWS", "FUNCTION_GUIDE_CLIP_MIRROR", "getFUNCTION_GUIDE_CLIP_MIRROR$annotations", "getFUNCTION_GUIDE_CLIP_MIRROR", "FUNCTION_GUIDE_SYNC_VIEW", "getFUNCTION_GUIDE_SYNC_VIEW$annotations", "getFUNCTION_GUIDE_SYNC_VIEW", "FUNCTION_GUIDE_PHEXTENSION_VIEW", "getFUNCTION_GUIDE_PHEXTENSION_VIEW$annotations", "getFUNCTION_GUIDE_PHEXTENSION_VIEW", "MIRROR_ON_RESOURCE", "getMIRROR_ON_RESOURCE$annotations", "getMIRROR_ON_RESOURCE", "MIRROR_OFF_RESOURCE", "getMIRROR_OFF_RESOURCE$annotations", "getMIRROR_OFF_RESOURCE", "MIRROR_CLOSE_RESOURCE", "getMIRROR_CLOSE_RESOURCE$annotations", "getMIRROR_CLOSE_RESOURCE", "MIRROR_EXTENSION_RESOURCE", "getMIRROR_EXTENSION_RESOURCE$annotations", "getMIRROR_EXTENSION_RESOURCE", "CLOSE_MIRROR_RESOURCE", "getCLOSE_MIRROR_RESOURCE$annotations", "getCLOSE_MIRROR_RESOURCE", "CLOSE_EXTENSION_RESOURCE", "getCLOSE_EXTENSION_RESOURCE$annotations", "getCLOSE_EXTENSION_RESOURCE", "EXTENSION_CLOSE_RESOURCE", "getEXTENSION_CLOSE_RESOURCE$annotations", "getEXTENSION_CLOSE_RESOURCE", "EXTENSION_MIRROR_RESOURCE", "getEXTENSION_MIRROR_RESOURCE$annotations", "getEXTENSION_MIRROR_RESOURCE", "FUNCTION_GUIDE_MULTI_SYNC_VIEW", "getFUNCTION_GUIDE_MULTI_SYNC_VIEW$annotations", "getFUNCTION_GUIDE_MULTI_SYNC_VIEW", "FUNCTION_GUIDE_MULTI_CLIP_MIRROR", "getFUNCTION_GUIDE_MULTI_CLIP_MIRROR$annotations", "getFUNCTION_GUIDE_MULTI_CLIP_MIRROR", "FUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW", "getFUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW$annotations", "getFUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class VapAssetList {
    public static final VapAssetList INSTANCE = new VapAssetList();
    private static final VapResource SEARCH_WATER_RIPPLE_VAP = new VapResource("search/wave", false, 0, null, 14, null);
    private static final VapResource FUNCTION_GUIDE_FILE_DRAG = new VapResource("guide/fileDrag", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_FULL_SCREEN = new VapResource("guide/fullScreen", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_MULTIPLE_WINDOWS = new VapResource("guide/multipleWindows", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_EXPAND_WINDOWS = new VapResource("guide/expandWindows", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_CLIP_MIRROR = new VapResource("guide/clipMirror", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_SYNC_VIEW = new VapResource("guide/syncView", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_PHEXTENSION_VIEW = new VapResource("guide/phoneExtension", false, 0, null, 12, null);
    private static final VapResource MIRROR_ON_RESOURCE = new VapResource("mirror/mirrorOn", false, 0, null, 12, null);
    private static final VapResource MIRROR_OFF_RESOURCE = new VapResource("mirror/mirrorOff", false, 0, null, 12, null);
    private static final VapResource MIRROR_CLOSE_RESOURCE = new VapResource("phoneExtension/mirror-close", false, 0, null, 12, null);
    private static final VapResource MIRROR_EXTENSION_RESOURCE = new VapResource("phoneExtension/mirror-extension", false, 0, null, 12, null);
    private static final VapResource CLOSE_MIRROR_RESOURCE = new VapResource("phoneExtension/close-mirror", false, 0, null, 12, null);
    private static final VapResource CLOSE_EXTENSION_RESOURCE = new VapResource("phoneExtension/close-extension", false, 0, null, 12, null);
    private static final VapResource EXTENSION_CLOSE_RESOURCE = new VapResource("phoneExtension/extension-close", false, 0, null, 12, null);
    private static final VapResource EXTENSION_MIRROR_RESOURCE = new VapResource("phoneExtension/extension-mirror", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_MULTI_SYNC_VIEW = new VapResource("guide_multi/syncView", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_MULTI_CLIP_MIRROR = new VapResource("guide_multi/clipMirror", false, 0, null, 12, null);
    private static final VapResource FUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW = new VapResource("guide_multi/phoneExtension", false, 0, null, 12, null);

    private VapAssetList() {
    }

    public static final VapResource getCLOSE_EXTENSION_RESOURCE() {
        return CLOSE_EXTENSION_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getCLOSE_EXTENSION_RESOURCE$annotations() {
    }

    public static final VapResource getCLOSE_MIRROR_RESOURCE() {
        return CLOSE_MIRROR_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getCLOSE_MIRROR_RESOURCE$annotations() {
    }

    public static final VapResource getEXTENSION_CLOSE_RESOURCE() {
        return EXTENSION_CLOSE_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getEXTENSION_CLOSE_RESOURCE$annotations() {
    }

    public static final VapResource getEXTENSION_MIRROR_RESOURCE() {
        return EXTENSION_MIRROR_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getEXTENSION_MIRROR_RESOURCE$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_CLIP_MIRROR() {
        return FUNCTION_GUIDE_CLIP_MIRROR;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_CLIP_MIRROR$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_EXPAND_WINDOWS() {
        return FUNCTION_GUIDE_EXPAND_WINDOWS;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_EXPAND_WINDOWS$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_FILE_DRAG() {
        return FUNCTION_GUIDE_FILE_DRAG;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_FILE_DRAG$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_FULL_SCREEN() {
        return FUNCTION_GUIDE_FULL_SCREEN;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_FULL_SCREEN$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_MULTIPLE_WINDOWS() {
        return FUNCTION_GUIDE_MULTIPLE_WINDOWS;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_MULTIPLE_WINDOWS$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_MULTI_CLIP_MIRROR() {
        return FUNCTION_GUIDE_MULTI_CLIP_MIRROR;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_MULTI_CLIP_MIRROR$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW() {
        return FUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_MULTI_PHEXTENSION_VIEW$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_MULTI_SYNC_VIEW() {
        return FUNCTION_GUIDE_MULTI_SYNC_VIEW;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_MULTI_SYNC_VIEW$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_PHEXTENSION_VIEW() {
        return FUNCTION_GUIDE_PHEXTENSION_VIEW;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_PHEXTENSION_VIEW$annotations() {
    }

    public static final VapResource getFUNCTION_GUIDE_SYNC_VIEW() {
        return FUNCTION_GUIDE_SYNC_VIEW;
    }

    @JvmStatic
    public static /* synthetic */ void getFUNCTION_GUIDE_SYNC_VIEW$annotations() {
    }

    public static final VapResource getMIRROR_CLOSE_RESOURCE() {
        return MIRROR_CLOSE_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getMIRROR_CLOSE_RESOURCE$annotations() {
    }

    public static final VapResource getMIRROR_EXTENSION_RESOURCE() {
        return MIRROR_EXTENSION_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getMIRROR_EXTENSION_RESOURCE$annotations() {
    }

    public static final VapResource getMIRROR_OFF_RESOURCE() {
        return MIRROR_OFF_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getMIRROR_OFF_RESOURCE$annotations() {
    }

    public static final VapResource getMIRROR_ON_RESOURCE() {
        return MIRROR_ON_RESOURCE;
    }

    @JvmStatic
    public static /* synthetic */ void getMIRROR_ON_RESOURCE$annotations() {
    }

    public static final VapResource getSEARCH_WATER_RIPPLE_VAP() {
        return SEARCH_WATER_RIPPLE_VAP;
    }

    @JvmStatic
    public static /* synthetic */ void getSEARCH_WATER_RIPPLE_VAP$annotations() {
    }
}
