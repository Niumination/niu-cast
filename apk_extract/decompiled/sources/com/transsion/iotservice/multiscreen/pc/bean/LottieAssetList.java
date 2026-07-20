package com.transsion.iotservice.multiscreen.pc.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import h0.a;
import java.util.ArrayList;
import k3.sb;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import na.c;
import na.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00110\nj\b\u0012\u0004\u0012\u00020\u0011`\fJ\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAssetList;", "", "<init>", "()V", "SEARCH_PC_LOTTIE", "Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "getSEARCH_PC_LOTTIE$annotations", "getSEARCH_PC_LOTTIE", "()Lcom/transsion/iotservice/multiscreen/pc/bean/LottieAsset;", "pcConnectSetting", "Ljava/util/ArrayList;", "Lcom/transsion/iotservice/multiscreen/pc/bean/LottieItem;", "Lkotlin/collections/ArrayList;", "padConnectSetting", "gestureSetting", "pcTransferSetting", "pcConnectCarousel", "Lcom/transsion/iotservice/multiscreen/pc/bean/CarouselItem;", "getPcConnectSettingLottieData", "getPadConnectSettingLottieData", "getGestureLottieData", "isXos", "", "getPcTransferSettingLottieData", "getPcConnectCarouselData", "getConnectingLottie", "getTrustDevice", "getOsTag", "", "getScreenTag", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class LottieAssetList {
    public static final LottieAssetList INSTANCE = new LottieAssetList();
    private static final LottieAsset SEARCH_PC_LOTTIE = new LottieAsset("search/scan", false, false, 6, null);
    private static ArrayList<LottieItem> gestureSetting;
    private static ArrayList<LottieItem> padConnectSetting;
    private static ArrayList<CarouselItem> pcConnectCarousel;
    private static ArrayList<LottieItem> pcConnectSetting;
    private static ArrayList<LottieItem> pcTransferSetting;

    private LottieAssetList() {
    }

    private final String getOsTag(boolean isXos) {
        return (!d.a() && isXos) ? "xos" : "hios";
    }

    public static final LottieAsset getSEARCH_PC_LOTTIE() {
        return SEARCH_PC_LOTTIE;
    }

    @JvmStatic
    public static /* synthetic */ void getSEARCH_PC_LOTTIE$annotations() {
    }

    private final String getScreenTag() {
        return "";
    }

    public final LottieAsset getConnectingLottie() {
        return new LottieAsset(c.a() ? "search/loading/infinix" : "search/loading/tecno", false, false);
    }

    public final ArrayList<LottieItem> getGestureLottieData(boolean isXos) {
        ArrayList<LottieItem> arrayList = gestureSetting;
        if (arrayList != null) {
            return arrayList;
        }
        String osTag = getOsTag(isXos);
        String screenTag = getScreenTag();
        ArrayList<LottieItem> arrayList2 = new ArrayList<>();
        arrayList2.add(new LottieItem(1, R$string.module_pc_gesture_intro_title, R$string.module_pc_gesture_intro_desc, new LottieAsset(a.k("pcConnectionSetting/", osTag, "/gesture", screenTag), false, false, 6, null)));
        gestureSetting = arrayList2;
        return arrayList2;
    }

    public final ArrayList<LottieItem> getPadConnectSettingLottieData() {
        ArrayList<LottieItem> arrayList = padConnectSetting;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<LottieItem> arrayList2 = new ArrayList<>();
        arrayList2.add(new LottieItem(1, R$string.blank, R$string.pc_screen_mode, new LottieAsset("pcConnectionSetting/hios/setting-pad/lottie1", false, false, 6, null)));
        padConnectSetting = arrayList2;
        return arrayList2;
    }

    public final ArrayList<CarouselItem> getPcConnectCarouselData() {
        ArrayList<CarouselItem> arrayList = pcConnectCarousel;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<CarouselItem> arrayList2 = new ArrayList<>();
        arrayList2.add(new CarouselItem(1, sb.b() ? new LottieAsset("pcConnectionSetting/hios/setting/lottie1", false, false, 6, null) : new LottieAsset("pcConnectionSetting/hios/setting-pad/lottie1", false, false, 6, null)));
        arrayList2.add(new CarouselItem(2, new LottieAsset("pcConnectionSetting/hios/setting/lottie2", false, false, 6, null)));
        pcConnectCarousel = arrayList2;
        return arrayList2;
    }

    public final ArrayList<LottieItem> getPcConnectSettingLottieData() {
        ArrayList<LottieItem> arrayList = pcConnectSetting;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<LottieItem> arrayList2 = new ArrayList<>();
        arrayList2.add(new LottieItem(1, R$string.module_pc_phone_mirroe, R$string.module_pc_you_can_also_play, new LottieAsset("pcConnectionSetting/hios/setting/lottie1", false, false, 6, null)));
        arrayList2.add(new LottieItem(2, R$string.module_pc_free_stream, R$string.module_pc_you_can_transfer, new LottieAsset("pcConnectionSetting/hios/setting/lottie2", false, false, 6, null)));
        pcConnectSetting = arrayList2;
        return arrayList2;
    }

    public final ArrayList<LottieItem> getPcTransferSettingLottieData(boolean isXos) {
        ArrayList<LottieItem> arrayList = pcTransferSetting;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<LottieItem> arrayList2 = new ArrayList<>();
        String osTag = getOsTag(isXos);
        String screenTag = getScreenTag();
        arrayList2.add(new LottieItem(1, R$string.module_pc_air_transfer_intro_title, R$string.module_pc_air_transfer_intro_desc, new LottieAsset(a.k("PcTransferSetting/", osTag, "/air-transfer", screenTag), false, false, 6, null)));
        arrayList2.add(new LottieItem(2, R$string.module_pc_air_copy_intro_title, R$string.module_pc_air_copy_intro_desc_without_text, new LottieAsset(a.k("PcTransferSetting/", osTag, "/air-copy", screenTag), false, false, 6, null)));
        pcTransferSetting = arrayList2;
        return arrayList2;
    }

    public final LottieAsset getTrustDevice() {
        return new LottieAsset(StringsKt__StringsKt.contains$default((String) c.f8133a.getValue(), "hios", false, 2, (Object) null) ? "trusted_device/hios" : "trusted_device/xos", false, false, 6, null);
    }
}
