package com.transsion.iotservice.multiscreen.pc.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.iotservice.multiscreen.pc.R$dimen;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsLottieAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.SettingItem;
import com.transsion.iotservice.multiscreen.pc.databinding.LayoutSettingItemBinding;
import com.transsion.widgetslistitemlayout.OSListItemView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import na.c;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/view/SettingItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/transsion/iotservice/multiscreen/pc/bean/SettingItem;", "content", "", "setItemContent", "(Lcom/transsion/iotservice/multiscreen/pc/bean/SettingItem;)V", "", "state", "setSwitchState", "(Z)V", "Lcom/transsion/iotservice/multiscreen/pc/adapter/SettingsLottieAdapter;", "getAdapter", "()Lcom/transsion/iotservice/multiscreen/pc/adapter/SettingsLottieAdapter;", "adapter", "setViewPagerAdapter", "(Lcom/transsion/iotservice/multiscreen/pc/adapter/SettingsLottieAdapter;)V", "currentItem", "setViewPagerIndex", "(I)V", "Landroid/view/View$OnClickListener;", NotificationCompat.CATEGORY_EVENT, "setItemClickEvent", "(Landroid/view/View$OnClickListener;)V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SettingItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutSettingItemBinding f2905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SettingsLottieAdapter f2906b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingItemView(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: renamed from: getAdapter, reason: from getter */
    public final SettingsLottieAdapter getF2906b() {
        return this.f2906b;
    }

    public final void setItemClickEvent(View.OnClickListener event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f2905a.f2633c.setOnClickListener(event);
    }

    public final void setItemContent(SettingItem content) {
        Intrinsics.checkNotNullParameter(content, "content");
        OSListItemView listItemLayout = this.f2905a.f2633c;
        Intrinsics.checkNotNullExpressionValue(listItemLayout, "listItemLayout");
        Switch r7 = listItemLayout.getSwitch();
        if (r7 != null) {
            r7.setClickable(false);
        }
        TextView viewTitle = listItemLayout.getViewTitle();
        if (viewTitle != null) {
            viewTitle.setText(content.getTitle());
        }
        TextView viewSubtitle = listItemLayout.getViewSubtitle();
        if (viewSubtitle != null) {
            if (content.getDesc() == null) {
                viewSubtitle.setVisibility(8);
            } else {
                viewSubtitle.setVisibility(0);
                viewSubtitle.setText(content.getDesc().intValue());
            }
        }
    }

    public final void setSwitchState(boolean state) {
        Switch r7;
        LayoutSettingItemBinding layoutSettingItemBinding = this.f2905a;
        Switch r10 = layoutSettingItemBinding.f2633c.getSwitch();
        if ((r10 == null || r10.isChecked() != state) && (r7 = layoutSettingItemBinding.f2633c.getSwitch()) != null) {
            r7.setChecked(state);
        }
    }

    public final void setViewPagerAdapter(SettingsLottieAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.f2906b = adapter;
        LayoutSettingItemBinding layoutSettingItemBinding = this.f2905a;
        layoutSettingItemBinding.f2634d.setAdapter(adapter);
        layoutSettingItemBinding.f2634d.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.transsion.iotservice.multiscreen.pc.ui.view.SettingItemView.setViewPagerAdapter.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void onPageScrolled(int i8, float f, int i9) {
                SettingItemView settingItemView = SettingItemView.this;
                settingItemView.f2905a.f2632b.setActiveMarker(i8);
                settingItemView.f2905a.f2632b.a((j.v() ? -1 : 1) * f);
                super.onPageScrolled(i8, f, i9);
            }
        });
    }

    public final void setViewPagerIndex(int currentItem) {
        this.f2905a.f2634d.setCurrentItem(currentItem);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SettingItemView(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SettingItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutSettingItemBinding layoutSettingItemBinding = (LayoutSettingItemBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R$layout.layout_setting_item, this, true);
        this.f2905a = layoutSettingItemBinding;
        layoutSettingItemBinding.f2634d.setOffscreenPageLimit(1);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R$dimen.setting_item_padding_vertical_hios);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R$dimen.setting_item_padding_horizontal_hios);
        if (c.a()) {
            layoutSettingItemBinding.f2634d.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset2, 0);
            dimensionPixelOffset = 0;
            dimensionPixelOffset2 = 0;
        }
        layoutSettingItemBinding.f2631a.setPadding(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset);
    }
}
