package com.transsion.iotservice.multiscreen.pc;

import a1.a;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.github.rubensousa.gravitysnaphelper.GravitySnapRecyclerView;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityCastControlBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityCopyPasteBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityDialogBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityFunctionGuideBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityGestureBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcConnectSettingBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcConnectSettingPadBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcConnectSettingPadBindingSw600dpImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityPcTransferSettingBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityQrConnectBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityQrScanBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivitySearchBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ActivityTrustDevicesBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPadExtendPermissionGuideBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPcRequestConnectBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPermissionBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPermissionGuideBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogTcircleConfirmBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogUsbConnectFailBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentConnectingBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentFaiOrRefuselBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentSearchPcBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.FragmentWaitAcceptBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingCarouselLottieBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ItemSettingLottieBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ItemTrustDeviceBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.LayoutFunctionGuideItemBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.LayoutSettingItemBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ModulePcActivityHelperBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.ModulePcItemPcNewBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.OsListItemLayoutItemLongDivideLineBinding;
import com.transsion.iotservice.multiscreen.pc.databinding.OsListItemLayoutItemLongDivideLineBindingImpl;
import com.transsion.iotservice.multiscreen.pc.databinding.OsListItemLayoutItemShortDivideLineBindingImpl;
import com.transsion.iotservice.multiscreen.pc.ue.HelperItemView;
import com.transsion.iotservice.multiscreen.pc.ui.view.RoundedCardView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetsliquid.view.OSLiquidBigButton;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import java.util.ArrayList;
import java.util.List;
import ra.c;
import ra.d;

/* JADX INFO: loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f2385a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(31);
        f2385a = sparseIntArray;
        sparseIntArray.put(R$layout.activity_cast_control, 1);
        sparseIntArray.put(R$layout.activity_copy_paste, 2);
        sparseIntArray.put(R$layout.activity_dialog, 3);
        sparseIntArray.put(R$layout.activity_function_guide, 4);
        sparseIntArray.put(R$layout.activity_gesture, 5);
        sparseIntArray.put(R$layout.activity_pc_connect_setting, 6);
        sparseIntArray.put(R$layout.activity_pc_connect_setting_pad, 7);
        sparseIntArray.put(R$layout.activity_pc_transfer_setting, 8);
        sparseIntArray.put(R$layout.activity_qr_connect, 9);
        sparseIntArray.put(R$layout.activity_qr_scan, 10);
        sparseIntArray.put(R$layout.activity_search, 11);
        sparseIntArray.put(R$layout.activity_trust_devices, 12);
        sparseIntArray.put(R$layout.dialog_pad_extend_permission_guide, 13);
        sparseIntArray.put(R$layout.dialog_pc_request_connect, 14);
        sparseIntArray.put(R$layout.dialog_permission, 15);
        sparseIntArray.put(R$layout.dialog_permission_guide, 16);
        sparseIntArray.put(R$layout.dialog_tcircle_confirm, 17);
        sparseIntArray.put(R$layout.dialog_usb_connect_fail, 18);
        sparseIntArray.put(R$layout.fragment_connecting, 19);
        sparseIntArray.put(R$layout.fragment_fai_or_refusel, 20);
        sparseIntArray.put(R$layout.fragment_search_pc, 21);
        sparseIntArray.put(R$layout.fragment_wait_accept, 22);
        sparseIntArray.put(R$layout.item_setting_carousel_lottie, 23);
        sparseIntArray.put(R$layout.item_setting_lottie, 24);
        sparseIntArray.put(R$layout.item_trust_device, 25);
        sparseIntArray.put(R$layout.layout_function_guide_item, 26);
        sparseIntArray.put(R$layout.layout_setting_item, 27);
        sparseIntArray.put(R$layout.module_pc_activity_helper, 28);
        sparseIntArray.put(R$layout.module_pc_item_pc_new, 29);
        sparseIntArray.put(R$layout.os_list_item_layout_item_long_divide_line, 30);
        sparseIntArray.put(R$layout.os_list_item_layout_item_short_divide_line, 31);
    }

    @Override // androidx.databinding.DataBinderMapper
    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.transsion.base.arch.mvvm.DataBinderMapperImpl());
        arrayList.add(new com.transsion.common.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public final String convertBrIdToString(int i8) {
        return (String) c.f9386a.get(i8);
    }

    @Override // androidx.databinding.DataBinderMapper
    public final ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i8) {
        int i9 = f2385a.get(i8);
        if (i9 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            switch (i9) {
                case 1:
                    if ("layout/activity_cast_control_0".equals(tag)) {
                        return new ActivityCastControlBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for activity_cast_control is invalid. Received: "));
                case 2:
                    if (!"layout/activity_copy_paste_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for activity_copy_paste is invalid. Received: "));
                    }
                    Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, ActivityCopyPasteBindingImpl.f2424k, ActivityCopyPasteBindingImpl.f2425l);
                    OsListItemLayoutItemLongDivideLineBinding osListItemLayoutItemLongDivideLineBinding = (OsListItemLayoutItemLongDivideLineBinding) objArrMapBindings[5];
                    OSListItemView oSListItemView = (OSListItemView) objArrMapBindings[2];
                    OSListItemView oSListItemView2 = (OSListItemView) objArrMapBindings[4];
                    OSLiquidToolBar oSLiquidToolBar = (OSLiquidToolBar) objArrMapBindings[8];
                    ActivityCopyPasteBindingImpl activityCopyPasteBindingImpl = new ActivityCopyPasteBindingImpl(dataBindingComponent, view, osListItemLayoutItemLongDivideLineBinding, oSListItemView, oSListItemView2, oSLiquidToolBar, (RoundedCardView) objArrMapBindings[3]);
                    activityCopyPasteBindingImpl.f2426j = -1L;
                    activityCopyPasteBindingImpl.setContainedBinding(activityCopyPasteBindingImpl.f2418a);
                    activityCopyPasteBindingImpl.f2419b.setTag(null);
                    activityCopyPasteBindingImpl.f2420c.setTag(null);
                    ((FrameLayout) objArrMapBindings[0]).setTag(null);
                    ((LinearLayout) objArrMapBindings[1]).setTag(null);
                    activityCopyPasteBindingImpl.e.setTag(null);
                    activityCopyPasteBindingImpl.setRootTag(view);
                    activityCopyPasteBindingImpl.invalidateAll();
                    return activityCopyPasteBindingImpl;
                case 3:
                    if (!"layout/activity_dialog_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for activity_dialog is invalid. Received: "));
                    }
                    Object[] objArrMapBindings2 = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    ActivityDialogBindingImpl activityDialogBindingImpl = new ActivityDialogBindingImpl(dataBindingComponent, view, 0);
                    activityDialogBindingImpl.f2427a = -1L;
                    ((ConstraintLayout) objArrMapBindings2[0]).setTag(null);
                    activityDialogBindingImpl.setRootTag(view);
                    activityDialogBindingImpl.invalidateAll();
                    return activityDialogBindingImpl;
                case 4:
                    if (!"layout/activity_function_guide_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for activity_function_guide is invalid. Received: "));
                    }
                    Object[] objArrMapBindings3 = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding.IncludedLayouts) null, ActivityFunctionGuideBindingImpl.f2435l);
                    OSLiquidBigButton oSLiquidBigButton = (OSLiquidBigButton) objArrMapBindings3[2];
                    ViewPager2 viewPager2 = (ViewPager2) objArrMapBindings3[1];
                    PageIndicatorWrapper pageIndicatorWrapper = (PageIndicatorWrapper) objArrMapBindings3[4];
                    ActivityFunctionGuideBindingImpl activityFunctionGuideBindingImpl = new ActivityFunctionGuideBindingImpl(dataBindingComponent, view, oSLiquidBigButton, viewPager2, pageIndicatorWrapper);
                    activityFunctionGuideBindingImpl.f2436k = -1L;
                    activityFunctionGuideBindingImpl.f2429a.setTag(null);
                    activityFunctionGuideBindingImpl.f2430b.setTag(null);
                    ((ConstraintLayout) objArrMapBindings3[0]).setTag(null);
                    activityFunctionGuideBindingImpl.setRootTag(view);
                    activityFunctionGuideBindingImpl.invalidateAll();
                    return activityFunctionGuideBindingImpl;
                case 5:
                    if (!"layout/activity_gesture_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for activity_gesture is invalid. Received: "));
                    }
                    Object[] objArrMapBindings4 = ViewDataBinding.mapBindings(dataBindingComponent, view, 11, ActivityGestureBindingImpl.f2445m, ActivityGestureBindingImpl.f2446n);
                    RoundedCardView roundedCardView = (RoundedCardView) objArrMapBindings4[4];
                    OsListItemLayoutItemLongDivideLineBinding osListItemLayoutItemLongDivideLineBinding2 = (OsListItemLayoutItemLongDivideLineBinding) objArrMapBindings4[7];
                    OSListItemView oSListItemView3 = (OSListItemView) objArrMapBindings4[3];
                    OSListItemView oSListItemView4 = (OSListItemView) objArrMapBindings4[5];
                    OSLiquidToolBar oSLiquidToolBar2 = (OSLiquidToolBar) objArrMapBindings4[10];
                    RoundedCardView roundedCardView2 = (RoundedCardView) objArrMapBindings4[2];
                    OsListItemLayoutItemLongDivideLineBinding osListItemLayoutItemLongDivideLineBinding3 = (OsListItemLayoutItemLongDivideLineBinding) objArrMapBindings4[6];
                    ActivityGestureBindingImpl activityGestureBindingImpl = new ActivityGestureBindingImpl(dataBindingComponent, view, roundedCardView, osListItemLayoutItemLongDivideLineBinding2, oSListItemView3, oSListItemView4, oSLiquidToolBar2, roundedCardView2, osListItemLayoutItemLongDivideLineBinding3);
                    activityGestureBindingImpl.f2447l = -1L;
                    activityGestureBindingImpl.f2437a.setTag(null);
                    activityGestureBindingImpl.setContainedBinding(activityGestureBindingImpl.f2438b);
                    activityGestureBindingImpl.f2439c.setTag(null);
                    activityGestureBindingImpl.f2440d.setTag(null);
                    ((FrameLayout) objArrMapBindings4[0]).setTag(null);
                    ((ConstraintLayout) objArrMapBindings4[1]).setTag(null);
                    activityGestureBindingImpl.f2441h.setTag(null);
                    activityGestureBindingImpl.setContainedBinding(activityGestureBindingImpl.f2442i);
                    activityGestureBindingImpl.setRootTag(view);
                    activityGestureBindingImpl.invalidateAll();
                    return activityGestureBindingImpl;
                case 6:
                    if ("layout/activity_pc_connect_setting_0".equals(tag)) {
                        return new ActivityPcConnectSettingBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for activity_pc_connect_setting is invalid. Received: "));
                case 7:
                    if ("layout-sw600dp/activity_pc_connect_setting_pad_0".equals(tag)) {
                        return new ActivityPcConnectSettingPadBindingSw600dpImpl(view, dataBindingComponent);
                    }
                    if ("layout/activity_pc_connect_setting_pad_0".equals(tag)) {
                        return new ActivityPcConnectSettingPadBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for activity_pc_connect_setting_pad is invalid. Received: "));
                case 8:
                    if ("layout/activity_pc_transfer_setting_0".equals(tag)) {
                        return new ActivityPcTransferSettingBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for activity_pc_transfer_setting is invalid. Received: "));
                case 9:
                    if (!"layout/activity_qr_connect_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for activity_qr_connect is invalid. Received: "));
                    }
                    Object[] objArrMapBindings5 = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    ActivityQrConnectBindingImpl activityQrConnectBindingImpl = new ActivityQrConnectBindingImpl(dataBindingComponent, view, 0);
                    activityQrConnectBindingImpl.f2494a = -1L;
                    ((ConstraintLayout) objArrMapBindings5[0]).setTag(null);
                    activityQrConnectBindingImpl.setRootTag(view);
                    activityQrConnectBindingImpl.invalidateAll();
                    return activityQrConnectBindingImpl;
                case 10:
                    if ("layout/activity_qr_scan_0".equals(tag)) {
                        return new ActivityQrScanBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for activity_qr_scan is invalid. Received: "));
                case 11:
                    if (!"layout/activity_search_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for activity_search is invalid. Received: "));
                    }
                    ActivitySearchBindingImpl activitySearchBindingImpl = new ActivitySearchBindingImpl(dataBindingComponent, view, (FrameLayout) ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null)[0]);
                    activitySearchBindingImpl.f2507c = -1L;
                    activitySearchBindingImpl.f2506a.setTag(null);
                    activitySearchBindingImpl.setRootTag(view);
                    activitySearchBindingImpl.invalidateAll();
                    return activitySearchBindingImpl;
                case 12:
                    if ("layout/activity_trust_devices_0".equals(tag)) {
                        return new ActivityTrustDevicesBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for activity_trust_devices is invalid. Received: "));
                case 13:
                    if ("layout/dialog_pad_extend_permission_guide_0".equals(tag)) {
                        return new DialogPadExtendPermissionGuideBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for dialog_pad_extend_permission_guide is invalid. Received: "));
                case 14:
                    if ("layout/dialog_pc_request_connect_0".equals(tag)) {
                        return new DialogPcRequestConnectBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for dialog_pc_request_connect is invalid. Received: "));
                case 15:
                    if (!"layout/dialog_permission_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for dialog_permission is invalid. Received: "));
                    }
                    Object[] objArrMapBindings6 = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding.IncludedLayouts) null, DialogPermissionBindingImpl.f2535b);
                    DialogPermissionBindingImpl dialogPermissionBindingImpl = new DialogPermissionBindingImpl(dataBindingComponent, view, 0);
                    dialogPermissionBindingImpl.f2536a = -1L;
                    ((ConstraintLayout) objArrMapBindings6[0]).setTag(null);
                    dialogPermissionBindingImpl.setRootTag(view);
                    dialogPermissionBindingImpl.invalidateAll();
                    return dialogPermissionBindingImpl;
                case 16:
                    if ("layout/dialog_permission_guide_0".equals(tag)) {
                        return new DialogPermissionGuideBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for dialog_permission_guide is invalid. Received: "));
                case 17:
                    if (!"layout/dialog_tcircle_confirm_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for dialog_tcircle_confirm is invalid. Received: "));
                    }
                    Object[] objArrMapBindings7 = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    DialogTcircleConfirmBindingImpl dialogTcircleConfirmBindingImpl = new DialogTcircleConfirmBindingImpl(dataBindingComponent, view, (TextView) objArrMapBindings7[1]);
                    dialogTcircleConfirmBindingImpl.f2551c = -1L;
                    ((LinearLayout) objArrMapBindings7[0]).setTag(null);
                    dialogTcircleConfirmBindingImpl.f2549a.setTag(null);
                    dialogTcircleConfirmBindingImpl.setRootTag(view);
                    dialogTcircleConfirmBindingImpl.invalidateAll();
                    return dialogTcircleConfirmBindingImpl;
                case 18:
                    if ("layout/dialog_usb_connect_fail_0".equals(tag)) {
                        return new DialogUsbConnectFailBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for dialog_usb_connect_fail is invalid. Received: "));
                case 19:
                    if ("layout/fragment_connecting_0".equals(tag)) {
                        return new FragmentConnectingBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for fragment_connecting is invalid. Received: "));
                case 20:
                    if ("layout/fragment_fai_or_refusel_0".equals(tag)) {
                        return new FragmentFaiOrRefuselBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for fragment_fai_or_refusel is invalid. Received: "));
                case 21:
                    if (!"layout/fragment_search_pc_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for fragment_search_pc is invalid. Received: "));
                    }
                    Object[] objArrMapBindings8 = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    FragmentSearchPcBindingImpl fragmentSearchPcBindingImpl = new FragmentSearchPcBindingImpl(dataBindingComponent, view, (AnimView) objArrMapBindings8[1], (LottieAnimationView) objArrMapBindings8[4], (ConstraintLayout) objArrMapBindings8[0], (GravitySnapRecyclerView) objArrMapBindings8[3], (TextView) objArrMapBindings8[5], (TextView) objArrMapBindings8[2]);
                    fragmentSearchPcBindingImpl.p = -1L;
                    fragmentSearchPcBindingImpl.f2584a.setTag(null);
                    fragmentSearchPcBindingImpl.f2585b.setTag(null);
                    fragmentSearchPcBindingImpl.f2586c.setTag(null);
                    fragmentSearchPcBindingImpl.f2587d.setTag(null);
                    fragmentSearchPcBindingImpl.e.setTag(null);
                    fragmentSearchPcBindingImpl.f2588h.setTag(null);
                    fragmentSearchPcBindingImpl.setRootTag(view);
                    fragmentSearchPcBindingImpl.invalidateAll();
                    return fragmentSearchPcBindingImpl;
                case 22:
                    if ("layout/fragment_wait_accept_0".equals(tag)) {
                        return new FragmentWaitAcceptBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for fragment_wait_accept is invalid. Received: "));
                case 23:
                    if (!"layout/item_setting_carousel_lottie_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for item_setting_carousel_lottie is invalid. Received: "));
                    }
                    Object[] objArrMapBindings9 = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    ItemSettingCarouselLottieBindingImpl itemSettingCarouselLottieBindingImpl = new ItemSettingCarouselLottieBindingImpl(dataBindingComponent, view, (LottieAnimationView) objArrMapBindings9[1]);
                    itemSettingCarouselLottieBindingImpl.f2609d = -1L;
                    itemSettingCarouselLottieBindingImpl.f2606a.setTag(null);
                    ((FrameLayout) objArrMapBindings9[0]).setTag(null);
                    itemSettingCarouselLottieBindingImpl.setRootTag(view);
                    itemSettingCarouselLottieBindingImpl.invalidateAll();
                    return itemSettingCarouselLottieBindingImpl;
                case 24:
                    if (!"layout/item_setting_lottie_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for item_setting_lottie is invalid. Received: "));
                    }
                    Object[] objArrMapBindings10 = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    ItemSettingLottieBindingImpl itemSettingLottieBindingImpl = new ItemSettingLottieBindingImpl(dataBindingComponent, view, (LottieAnimationView) objArrMapBindings10[1], (TextView) objArrMapBindings10[3], (TextView) objArrMapBindings10[2]);
                    itemSettingLottieBindingImpl.f2614h = -1L;
                    itemSettingLottieBindingImpl.f2610a.setTag(null);
                    ((LinearLayout) objArrMapBindings10[0]).setTag(null);
                    itemSettingLottieBindingImpl.f2611b.setTag(null);
                    itemSettingLottieBindingImpl.f2612c.setTag(null);
                    itemSettingLottieBindingImpl.setRootTag(view);
                    itemSettingLottieBindingImpl.invalidateAll();
                    return itemSettingLottieBindingImpl;
                case 25:
                    if ("layout/item_trust_device_0".equals(tag)) {
                        return new ItemTrustDeviceBindingImpl(view, dataBindingComponent);
                    }
                    throw new IllegalArgumentException(a.p(tag, "The tag for item_trust_device is invalid. Received: "));
                case 26:
                    if (!"layout/layout_function_guide_item_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for layout_function_guide_item is invalid. Received: "));
                    }
                    Object[] objArrMapBindings11 = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    LayoutFunctionGuideItemBindingImpl layoutFunctionGuideItemBindingImpl = new LayoutFunctionGuideItemBindingImpl(dataBindingComponent, view, (AnimView) objArrMapBindings11[1], (TextView) objArrMapBindings11[3], (TextView) objArrMapBindings11[2]);
                    layoutFunctionGuideItemBindingImpl.e = -1L;
                    layoutFunctionGuideItemBindingImpl.f2623a.setTag(null);
                    ((LinearLayout) objArrMapBindings11[0]).setTag(null);
                    layoutFunctionGuideItemBindingImpl.f2624b.setTag(null);
                    layoutFunctionGuideItemBindingImpl.f2625c.setTag(null);
                    layoutFunctionGuideItemBindingImpl.setRootTag(view);
                    layoutFunctionGuideItemBindingImpl.invalidateAll();
                    return layoutFunctionGuideItemBindingImpl;
                case 27:
                    if (!"layout/layout_setting_item_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for layout_setting_item is invalid. Received: "));
                    }
                    Object[] objArrMapBindings12 = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding.IncludedLayouts) null, LayoutSettingItemBindingImpl.f2635h);
                    LayoutSettingItemBindingImpl layoutSettingItemBindingImpl = new LayoutSettingItemBindingImpl(dataBindingComponent, view, (ConstraintLayout) objArrMapBindings12[0], (PageIndicatorWrapper) objArrMapBindings12[3], (OSListItemView) objArrMapBindings12[1], (ViewPager2) objArrMapBindings12[2]);
                    layoutSettingItemBindingImpl.e = -1L;
                    layoutSettingItemBindingImpl.f2631a.setTag(null);
                    layoutSettingItemBindingImpl.setRootTag(view);
                    layoutSettingItemBindingImpl.invalidateAll();
                    return layoutSettingItemBindingImpl;
                case 28:
                    if (!"layout/module_pc_activity_helper_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for module_pc_activity_helper is invalid. Received: "));
                    }
                    Object[] objArrMapBindings13 = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding.IncludedLayouts) null, ModulePcActivityHelperBindingImpl.p);
                    ModulePcActivityHelperBindingImpl modulePcActivityHelperBindingImpl = new ModulePcActivityHelperBindingImpl(dataBindingComponent, view, (HelperItemView) objArrMapBindings13[4], (HelperItemView) objArrMapBindings13[1], (TextView) objArrMapBindings13[6], (HelperItemView) objArrMapBindings13[3], (HelperItemView) objArrMapBindings13[2], (OverBoundNestedScrollView) objArrMapBindings13[0], (HelperItemView) objArrMapBindings13[5]);
                    modulePcActivityHelperBindingImpl.f2647o = -1L;
                    modulePcActivityHelperBindingImpl.f2636a.setTag(null);
                    modulePcActivityHelperBindingImpl.f2637b.setTag(null);
                    modulePcActivityHelperBindingImpl.f2639d.setTag(null);
                    modulePcActivityHelperBindingImpl.e.setTag(null);
                    modulePcActivityHelperBindingImpl.f2640h.setTag(null);
                    modulePcActivityHelperBindingImpl.f2641i.setTag(null);
                    modulePcActivityHelperBindingImpl.setRootTag(view);
                    modulePcActivityHelperBindingImpl.invalidateAll();
                    return modulePcActivityHelperBindingImpl;
                case 29:
                    if (!"layout/module_pc_item_pc_new_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for module_pc_item_pc_new is invalid. Received: "));
                    }
                    Object[] objArrMapBindings14 = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding.IncludedLayouts) null, ModulePcItemPcNewBindingImpl.f2654k);
                    ImageView imageView = (ImageView) objArrMapBindings14[2];
                    ImageView imageView2 = (ImageView) objArrMapBindings14[1];
                    RelativeLayout relativeLayout = (RelativeLayout) objArrMapBindings14[0];
                    ModulePcItemPcNewBindingImpl modulePcItemPcNewBindingImpl = new ModulePcItemPcNewBindingImpl(dataBindingComponent, view, imageView, imageView2, relativeLayout, (TextView) objArrMapBindings14[3]);
                    modulePcItemPcNewBindingImpl.f2655j = -1L;
                    modulePcItemPcNewBindingImpl.f2648a.setTag(null);
                    modulePcItemPcNewBindingImpl.f2649b.setTag(null);
                    modulePcItemPcNewBindingImpl.f2650c.setTag(null);
                    modulePcItemPcNewBindingImpl.f2651d.setTag(null);
                    modulePcItemPcNewBindingImpl.setRootTag(view);
                    modulePcItemPcNewBindingImpl.invalidateAll();
                    return modulePcItemPcNewBindingImpl;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    if (!"layout/os_list_item_layout_item_long_divide_line_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for os_list_item_layout_item_long_divide_line is invalid. Received: "));
                    }
                    Object[] objArrMapBindings15 = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    OsListItemLayoutItemLongDivideLineBindingImpl osListItemLayoutItemLongDivideLineBindingImpl = new OsListItemLayoutItemLongDivideLineBindingImpl(dataBindingComponent, view, 0);
                    osListItemLayoutItemLongDivideLineBindingImpl.f2656a = -1L;
                    ((FrameLayout) objArrMapBindings15[0]).setTag(null);
                    osListItemLayoutItemLongDivideLineBindingImpl.setRootTag(view);
                    osListItemLayoutItemLongDivideLineBindingImpl.invalidateAll();
                    return osListItemLayoutItemLongDivideLineBindingImpl;
                case 31:
                    if (!"layout/os_list_item_layout_item_short_divide_line_0".equals(tag)) {
                        throw new IllegalArgumentException(a.p(tag, "The tag for os_list_item_layout_item_short_divide_line is invalid. Received: "));
                    }
                    Object[] objArrMapBindings16 = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
                    OsListItemLayoutItemShortDivideLineBindingImpl osListItemLayoutItemShortDivideLineBindingImpl = new OsListItemLayoutItemShortDivideLineBindingImpl(dataBindingComponent, view, 0);
                    osListItemLayoutItemShortDivideLineBindingImpl.f2657a = -1L;
                    ((FrameLayout) objArrMapBindings16[0]).setTag(null);
                    osListItemLayoutItemShortDivideLineBindingImpl.setRootTag(view);
                    osListItemLayoutItemShortDivideLineBindingImpl.invalidateAll();
                    return osListItemLayoutItemShortDivideLineBindingImpl;
            }
        }
        return null;
    }

    @Override // androidx.databinding.DataBinderMapper
    public final int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) d.f9387a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public final ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i8) {
        if (viewArr == null || viewArr.length == 0 || f2385a.get(i8) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
