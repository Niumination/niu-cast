package com.transsion.iotcardsdk.util;

import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.ByteString;
import com.transsion.iotcardsdk.SdkInit;
import com.transsion.iotcardsdk.bean.DisplayTemplateBean;
import com.transsion.iotcardsdk.bean.DisplayType;
import com.transsion.iotcardsdk.bean.IotCardTemplateBean;
import com.transsion.iotcardsdk.bean.SwitchTemplateBean;
import com.transsion.iotcardsdk.bean.TCCardBean;
import com.transsion.iotcardsdk.constant.IotCardConstance;
import com.transsion.iotservice.iotcard.proto.IotcardBean;
import com.transsion.iotservice.iotcard.proto.IotcardList;
import com.transsion.iotservice.iotcard.proto.IotcardListMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bJ \u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001b0\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bJ\u001c\u0010$\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bJ\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bJ\u0014\u0010+\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/transsion/iotcardsdk/util/IotcardConverter;", "", "()V", "DISPLAY_CARD", "", "EMPTY_CARD", "SWITCH_CARD", "convertBundleToString", "", "bundle", "Landroid/os/Bundle;", "convertCardDisplayType", "cardDisplayType", "Lcom/transsion/iotcardsdk/bean/DisplayType;", "convertIconToByteString", "Lcom/google/protobuf/ByteString;", "icon", "", "convertToIotCardBean", "Lcom/transsion/iotservice/iotcard/proto/IotcardBean;", "iotCardTemplateBean", "Lcom/transsion/iotcardsdk/bean/IotCardTemplateBean;", "controlId", "packageName", "convertToIotCardBeanList", "Lcom/transsion/iotservice/iotcard/proto/IotcardList;", "iotcardTemplateBeanList", "", "convertToIotcardListMap", "Lcom/transsion/iotservice/iotcard/proto/IotcardListMap;", "map", "", "convertToTCCardBean", "Lcom/transsion/iotcardsdk/bean/TCCardBean;", "convertToTCCardBeanList", "cardList", "getProperty", "key", "defaultValue", "isSupportVersion", "", "currentVersion", "targetVersion", "toJson", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nIotcardConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IotcardConverter.kt\ncom/transsion/iotcardsdk/util/IotcardConverter\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,280:1\n215#2,2:281\n766#3:283\n857#3,2:284\n1549#3:286\n1620#3,3:287\n1549#3:290\n1620#3,3:291\n1#4:294\n*S KotlinDebug\n*F\n+ 1 IotcardConverter.kt\ncom/transsion/iotcardsdk/util/IotcardConverter\n*L\n155#1:281,2\n159#1:283\n159#1:284,2\n193#1:286\n193#1:287,3\n194#1:290\n194#1:291,3\n*E\n"})
public final class IotcardConverter {
    public static final int DISPLAY_CARD = 1;
    public static final int EMPTY_CARD = 3;
    public static final IotcardConverter INSTANCE = new IotcardConverter();
    public static final int SWITCH_CARD = 2;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayType.values().length];
            try {
                iArr[DisplayType.TEXT_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayType.BATTERY_TEMPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayType.CONNECT_TEMPLATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DisplayType.CUSTOM_TEMPLATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DisplayType.BATTERY_CHARGE_TEMPLATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private IotcardConverter() {
    }

    public final String convertBundleToString(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : bundle.keySet()) {
            sb2.append(str);
            sb2.append(":");
            sb2.append(bundle.get(str));
            sb2.append("\n");
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }

    public final int convertCardDisplayType(DisplayType cardDisplayType) {
        int i8 = cardDisplayType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cardDisplayType.ordinal()];
        if (i8 == 1) {
            return IotCardConstance.INSTANCE.getTEXT_TEMPLATE();
        }
        if (i8 == 2) {
            return IotCardConstance.INSTANCE.getBATTERY_TEMPLATE();
        }
        if (i8 == 3) {
            return IotCardConstance.INSTANCE.getCONNECT_TEMPLATE();
        }
        if (i8 != 4) {
            return i8 != 5 ? IotCardConstance.INSTANCE.getUNKNOWN_TEMPLATE() : IotCardConstance.INSTANCE.getBATTERY_CHARGE_TEMPLATE();
        }
        return IotCardConstance.INSTANCE.getCUSTOM_TEMPLATE();
    }

    public final ByteString convertIconToByteString(byte[] icon) {
        if (icon == null) {
            icon = new byte[0];
        }
        ByteString byteStringCopyFrom = ByteString.copyFrom(icon);
        Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(mIcon)");
        return byteStringCopyFrom;
    }

    public final IotcardBean convertToIotCardBean(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        Log.d("IotcardConverter", "convertToIotCardBean: " + iotCardTemplateBean.getControlId());
        IotcardBean.Builder builderNewBuilder = IotcardBean.newBuilder();
        builderNewBuilder.setControlId(iotCardTemplateBean.getControlId());
        builderNewBuilder.setPackageName(iotCardTemplateBean.getPackageName());
        if (iotCardTemplateBean instanceof DisplayTemplateBean) {
            builderNewBuilder.setCardType(1);
            DisplayTemplateBean displayTemplateBean = (DisplayTemplateBean) iotCardTemplateBean;
            builderNewBuilder.setTitle(displayTemplateBean.getTitle());
            builderNewBuilder.setMCustomIcon(convertIconToByteString(displayTemplateBean.getNewCustomIcon()));
            String subTitle = displayTemplateBean.getSubTitle();
            if (subTitle != null) {
                builderNewBuilder.setSubTitle(subTitle);
            }
            builderNewBuilder.setDeviceTypeId(iotCardTemplateBean.getDeviceTypeId());
            builderNewBuilder.setPid(displayTemplateBean.getPid());
            builderNewBuilder.setDeviceConnectedStatus(iotCardTemplateBean.getDeviceConnectedStatus());
            builderNewBuilder.setDeviceConnectedDesc(displayTemplateBean.getDeviceConnectedDesc());
            builderNewBuilder.setExtraInfoOneIcon(convertIconToByteString(displayTemplateBean.getNewExtraInfoOneIcon()));
            String extraInfoOneDesc = displayTemplateBean.getExtraInfoOneDesc();
            if (extraInfoOneDesc != null) {
                builderNewBuilder.setExtraInfoOneDesc(extraInfoOneDesc);
            }
            builderNewBuilder.setExtraInfoTwoIcon(convertIconToByteString(displayTemplateBean.getNewExtraInfoTwoIcon()));
            String extraInfoTwoDesc = displayTemplateBean.getExtraInfoTwoDesc();
            if (extraInfoTwoDesc != null) {
                builderNewBuilder.setExtraInfoTwoDesc(extraInfoTwoDesc);
            }
            builderNewBuilder.setDeviceLastConnectedTime(iotCardTemplateBean.getDeviceLastConnectedTime());
            String targetPackageName = displayTemplateBean.getTargetPackageName();
            if (targetPackageName != null) {
                builderNewBuilder.setTargetPackageName(targetPackageName);
            }
            String targetClassName = displayTemplateBean.getTargetClassName();
            if (targetClassName != null) {
                builderNewBuilder.setTargetClassName(targetClassName);
            }
            builderNewBuilder.setIsSupportClickCard(displayTemplateBean.getIsSupportClickCard());
            if (iotCardTemplateBean.getDeviceSingleId() != null) {
                builderNewBuilder.setDeviceSingleId(iotCardTemplateBean.getDeviceSingleId());
            }
            builderNewBuilder.setDeviceShowLevel(iotCardTemplateBean.getDeviceShowLevel());
            builderNewBuilder.setClickCardBundle(convertBundleToString(displayTemplateBean.getClickCardBundle()));
            builderNewBuilder.setCardDisplayType(convertCardDisplayType(displayTemplateBean.getCardDisplayType()));
            String displayMessage = displayTemplateBean.getDisplayMessage();
            if (displayMessage != null) {
                builderNewBuilder.setDisplayMessage(displayMessage);
            }
            byte[] displayCustomIcon = displayTemplateBean.getDisplayCustomIcon();
            if (displayCustomIcon != null) {
                builderNewBuilder.setDisplayCustomIcon(INSTANCE.convertIconToByteString(displayCustomIcon));
            }
        } else if (iotCardTemplateBean instanceof SwitchTemplateBean) {
            builderNewBuilder.setCardType(2);
            SwitchTemplateBean switchTemplateBean = (SwitchTemplateBean) iotCardTemplateBean;
            builderNewBuilder.setTitle(switchTemplateBean.getTitle());
            builderNewBuilder.setMCustomIcon(convertIconToByteString(switchTemplateBean.getNewCustomIcon()));
            String subTitle2 = switchTemplateBean.getSubTitle();
            if (subTitle2 != null) {
                builderNewBuilder.setSubTitle(subTitle2);
            }
            builderNewBuilder.setDeviceTypeId(iotCardTemplateBean.getDeviceTypeId());
            builderNewBuilder.setPid(switchTemplateBean.getPid());
            builderNewBuilder.setDeviceConnectedStatus(iotCardTemplateBean.getDeviceConnectedStatus());
            builderNewBuilder.setDeviceConnectedDesc(switchTemplateBean.getDeviceConnectedDesc());
            builderNewBuilder.setDeviceLastConnectedTime(iotCardTemplateBean.getDeviceLastConnectedTime());
            builderNewBuilder.setTargetPackageName(switchTemplateBean.getTargetPackageName());
            String targetClassName2 = switchTemplateBean.getTargetClassName();
            if (targetClassName2 != null) {
                builderNewBuilder.setTargetClassName(targetClassName2);
            }
            builderNewBuilder.setIsSupportClickCard(switchTemplateBean.getIsSupportClickCard());
            if (iotCardTemplateBean.getDeviceSingleId() != null) {
                builderNewBuilder.setDeviceSingleId(iotCardTemplateBean.getDeviceSingleId());
            }
            builderNewBuilder.setDeviceShowLevel(iotCardTemplateBean.getDeviceShowLevel());
            builderNewBuilder.setDeviceSwitch(switchTemplateBean.getDeviceSwitch());
            builderNewBuilder.setSwitchActionType(switchTemplateBean.getSwitchActionType());
            builderNewBuilder.setClickCardBundle(convertBundleToString(switchTemplateBean.getClickCardBundle()));
            builderNewBuilder.setCardDisplayType(convertCardDisplayType(switchTemplateBean.getCardDisplayType()));
            String displayMessage2 = switchTemplateBean.getDisplayMessage();
            if (displayMessage2 != null) {
                builderNewBuilder.setDisplayMessage(displayMessage2);
            }
            byte[] displayCustomIcon2 = switchTemplateBean.getDisplayCustomIcon();
            if (displayCustomIcon2 != null) {
                builderNewBuilder.setDisplayCustomIcon(INSTANCE.convertIconToByteString(displayCustomIcon2));
            }
        }
        IotcardBean iotcardBeanBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(iotcardBeanBuild, "iotcardBeanBuilder.build()");
        return iotcardBeanBuild;
    }

    public final IotcardList convertToIotCardBeanList(List<? extends IotCardTemplateBean> iotcardTemplateBeanList) {
        Intrinsics.checkNotNullParameter(iotcardTemplateBeanList, "iotcardTemplateBeanList");
        IotcardList.Builder builderNewBuilder = IotcardList.newBuilder();
        Iterator<? extends IotCardTemplateBean> it = iotcardTemplateBeanList.iterator();
        while (it.hasNext()) {
            builderNewBuilder.addIotcardBean(convertToIotCardBean(it.next()));
        }
        IotcardList iotcardListBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(iotcardListBuild, "iotcardListBuiler.build()");
        return iotcardListBuild;
    }

    public final IotcardListMap convertToIotcardListMap(Map<String, ? extends List<? extends IotCardTemplateBean>> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        List<? extends IotCardTemplateBean> listEmptyList = CollectionsKt.emptyList();
        String key = null;
        for (Map.Entry<String, ? extends List<? extends IotCardTemplateBean>> entry : map.entrySet()) {
            key = entry.getKey();
            listEmptyList = entry.getValue();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            if (SdkInit.INSTANCE.isSupportDevice(((IotCardTemplateBean) obj).getDeviceTypeId())) {
                arrayList.add(obj);
            }
        }
        IotcardListMap iotcardListMapBuild = IotcardListMap.newBuilder().putDisplayTemplates(key, convertToIotCardBeanList(arrayList)).build();
        Intrinsics.checkNotNullExpressionValue(iotcardListMapBuild, "newBuilder().putDisplayT… iotcardBeanList).build()");
        return iotcardListMapBuild;
    }

    public final TCCardBean convertToTCCardBean(IotCardTemplateBean iotCardTemplateBean) {
        Intrinsics.checkNotNullParameter(iotCardTemplateBean, "iotCardTemplateBean");
        TCCardBean tCCardBean = new TCCardBean(null, null, null, null, 0, null, false, null, null, null, 0L, null, null, false, null, 0, 0, 0, false, 0, false, 0, null, null, null, 33554431, null);
        if (iotCardTemplateBean instanceof DisplayTemplateBean) {
            tCCardBean.setControlId(iotCardTemplateBean.getControlId());
            tCCardBean.setPackageName(iotCardTemplateBean.getPackageName());
            DisplayTemplateBean displayTemplateBean = (DisplayTemplateBean) iotCardTemplateBean;
            tCCardBean.setTitle(displayTemplateBean.getTitle());
            String subTitle = displayTemplateBean.getSubTitle();
            if (subTitle == null) {
                subTitle = "";
            }
            tCCardBean.setSubTitle(subTitle);
            tCCardBean.setDeviceTypeId(iotCardTemplateBean.getDeviceTypeId());
            tCCardBean.setPid(displayTemplateBean.getPid());
            tCCardBean.setDeviceConnectedStatus(iotCardTemplateBean.getDeviceConnectedStatus());
            tCCardBean.setDeviceConnectedDesc(displayTemplateBean.getDeviceConnectedDesc());
            String extraInfoOneDesc = displayTemplateBean.getExtraInfoOneDesc();
            if (extraInfoOneDesc == null) {
                extraInfoOneDesc = "";
            }
            tCCardBean.setExtraInfoOneDesc(extraInfoOneDesc);
            String extraInfoTwoDesc = displayTemplateBean.getExtraInfoTwoDesc();
            if (extraInfoTwoDesc == null) {
                extraInfoTwoDesc = "";
            }
            tCCardBean.setExtraInfoTwoDesc(extraInfoTwoDesc);
            tCCardBean.setDeviceLastConnectedTime(iotCardTemplateBean.getDeviceLastConnectedTime());
            String targetClassName = displayTemplateBean.getTargetClassName();
            if (targetClassName == null) {
                targetClassName = "";
            }
            tCCardBean.setTargetClassName(targetClassName);
            String targetClassName2 = displayTemplateBean.getTargetClassName();
            if (targetClassName2 == null) {
                targetClassName2 = "";
            }
            tCCardBean.setTargetPackageName(targetClassName2);
            tCCardBean.setSupportClickCard(displayTemplateBean.getIsSupportClickCard());
            tCCardBean.setClickCardBundle(displayTemplateBean.getClickCardBundle());
            tCCardBean.setDeviceShowLevel(iotCardTemplateBean.getDeviceShowLevel());
            tCCardBean.setCardType(1);
            tCCardBean.setCardDisplayType(convertCardDisplayType(displayTemplateBean.getCardDisplayType()));
            String displayMessage = displayTemplateBean.getDisplayMessage();
            if (displayMessage == null) {
                displayMessage = "";
            }
            tCCardBean.setDisplayMessage(displayMessage);
            String boxBattery = displayTemplateBean.getBoxBattery();
            tCCardBean.setBoxBattery(boxBattery != null ? boxBattery : "");
            tCCardBean.setDeviceServiceMap(iotCardTemplateBean.getDeviceServiceMap());
        } else if (iotCardTemplateBean instanceof SwitchTemplateBean) {
            tCCardBean.setControlId(iotCardTemplateBean.getControlId());
            tCCardBean.setPackageName(iotCardTemplateBean.getPackageName());
            SwitchTemplateBean switchTemplateBean = (SwitchTemplateBean) iotCardTemplateBean;
            tCCardBean.setTitle(switchTemplateBean.getTitle());
            String subTitle2 = switchTemplateBean.getSubTitle();
            if (subTitle2 == null) {
                subTitle2 = "";
            }
            tCCardBean.setSubTitle(subTitle2);
            tCCardBean.setDeviceTypeId(iotCardTemplateBean.getDeviceTypeId());
            tCCardBean.setPid(switchTemplateBean.getPid());
            tCCardBean.setDeviceConnectedStatus(iotCardTemplateBean.getDeviceConnectedStatus());
            tCCardBean.setDeviceConnectedDesc(switchTemplateBean.getDeviceConnectedDesc());
            tCCardBean.setDeviceLastConnectedTime(iotCardTemplateBean.getDeviceLastConnectedTime());
            String targetClassName3 = switchTemplateBean.getTargetClassName();
            if (targetClassName3 == null) {
                targetClassName3 = "";
            }
            tCCardBean.setTargetClassName(targetClassName3);
            String targetClassName4 = switchTemplateBean.getTargetClassName();
            if (targetClassName4 == null) {
                targetClassName4 = "";
            }
            tCCardBean.setTargetPackageName(targetClassName4);
            tCCardBean.setSupportClickCard(switchTemplateBean.getIsSupportClickCard());
            tCCardBean.setClickCardBundle(switchTemplateBean.getClickCardBundle());
            tCCardBean.setDeviceShowLevel(iotCardTemplateBean.getDeviceShowLevel());
            tCCardBean.setCardType(2);
            tCCardBean.setDeviceSwitch(switchTemplateBean.getDeviceSwitch());
            tCCardBean.setSwitchActionType(switchTemplateBean.getSwitchActionType());
            tCCardBean.setCardDisplayType(convertCardDisplayType(switchTemplateBean.getCardDisplayType()));
            String displayMessage2 = switchTemplateBean.getDisplayMessage();
            tCCardBean.setDisplayMessage(displayMessage2 != null ? displayMessage2 : "");
            tCCardBean.setDeviceServiceMap(iotCardTemplateBean.getDeviceServiceMap());
        }
        return tCCardBean;
    }

    public final List<TCCardBean> convertToTCCardBeanList(List<? extends IotCardTemplateBean> cardList) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IotCardTemplateBean> it = cardList.iterator();
        while (it.hasNext()) {
            arrayList.add(convertToTCCardBean(it.next()));
        }
        return arrayList;
    }

    public final String getProperty(String key, String defaultValue) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class, String.class);
            Intrinsics.checkNotNullExpressionValue(method, "clazz.getMethod(\"get\", S…java, String::class.java)");
            Object objInvoke = method.invoke(cls, key, "");
            return objInvoke instanceof String ? (String) objInvoke : null;
        } catch (Exception unused) {
            return defaultValue;
        }
    }

    public final boolean isSupportVersion(String currentVersion, String targetVersion) {
        Intrinsics.checkNotNullParameter(currentVersion, "currentVersion");
        Intrinsics.checkNotNullParameter(targetVersion, "targetVersion");
        List listSplit$default = StringsKt__StringsKt.split$default(currentVersion, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (true) {
            int iIntValue = 0;
            if (!it.hasNext()) {
                break;
            }
            Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
            if (intOrNull != null) {
                iIntValue = intOrNull.intValue();
            }
            arrayList.add(Integer.valueOf(iIntValue));
        }
        List listSplit$default2 = StringsKt__StringsKt.split$default(targetVersion, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default2));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            Integer intOrNull2 = StringsKt.toIntOrNull((String) it2.next());
            arrayList2.add(Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0));
        }
        int iMax = Math.max(arrayList.size(), arrayList2.size());
        int i8 = 0;
        while (i8 < iMax) {
            int iIntValue2 = ((Number) ((i8 < 0 || i8 > CollectionsKt.getLastIndex(arrayList)) ? 0 : arrayList.get(i8))).intValue();
            int iIntValue3 = ((Number) ((i8 < 0 || i8 > CollectionsKt.getLastIndex(arrayList2)) ? 0 : arrayList2.get(i8))).intValue();
            if (iIntValue2 > iIntValue3) {
                return true;
            }
            if (iIntValue2 < iIntValue3) {
                return false;
            }
            i8++;
        }
        return true;
    }

    public final String toJson(List<TCCardBean> cardList) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        String json = new q().toJson(cardList);
        Intrinsics.checkNotNullExpressionValue(json, "json");
        return json;
    }

    public final IotcardBean convertToIotCardBean(String controlId, String packageName) {
        Intrinsics.checkNotNullParameter(controlId, "controlId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        IotcardBean.Builder builderNewBuilder = IotcardBean.newBuilder();
        builderNewBuilder.setControlId(controlId);
        builderNewBuilder.setTargetPackageName(packageName);
        builderNewBuilder.setCardType(3);
        IotcardBean iotcardBeanBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(iotcardBeanBuild, "iotcardBeanBuilder.build()");
        return iotcardBeanBuild;
    }
}
