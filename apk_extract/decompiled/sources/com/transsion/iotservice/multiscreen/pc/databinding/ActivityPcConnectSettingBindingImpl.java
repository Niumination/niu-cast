package com.transsion.iotservice.multiscreen.pc.databinding;

import ag.d0;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import bb.d;
import bb.e;
import bb.l;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsCarouselAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import com.transsion.iotservice.multiscreen.pc.ui.copy.CopyPastActivity;
import com.transsion.iotservice.multiscreen.pc.ui.gesture.GestureActivity;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcConnectSettingViewModel;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetslistitemlayout.OSListItemView;
import dc.n;
import java.util.List;
import k3.ed;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import ld.m;
import ob.b;
import qd.k;
import tj.w;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityPcConnectSettingBindingImpl extends ActivityPcConnectSettingBinding implements a {
    public static final SparseIntArray A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f2461s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final k f2462t;
    public final k u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f2463v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f2464w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f2465x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k f2466y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f2467z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R$id.damping_layout, 13);
        sparseIntArray.put(R$id.indicator, 14);
        sparseIntArray.put(R$id.phone_settings_container, 15);
        sparseIntArray.put(R$id.os_mask_status_bar, 16);
        sparseIntArray.put(R$id.liquidBar, 17);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityPcConnectSettingBindingImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 18, (ViewDataBinding.IncludedLayouts) null, A);
        OSListItemView oSListItemView = (OSListItemView) objArrMapBindings[5];
        OSListItemView oSListItemView2 = (OSListItemView) objArrMapBindings[4];
        OSListItemView oSListItemView3 = (OSListItemView) objArrMapBindings[3];
        OSListItemView oSListItemView4 = (OSListItemView) objArrMapBindings[6];
        OSListItemView oSListItemView5 = (OSListItemView) objArrMapBindings[7];
        OSListItemView oSListItemView6 = (OSListItemView) objArrMapBindings[8];
        OSListItemView oSListItemView7 = (OSListItemView) objArrMapBindings[11];
        OSListItemView oSListItemView8 = (OSListItemView) objArrMapBindings[10];
        OSListItemView oSListItemView9 = (OSListItemView) objArrMapBindings[9];
        OSListItemView oSListItemView10 = (OSListItemView) objArrMapBindings[12];
        super(dataBindingComponent, view, oSListItemView, oSListItemView2, oSListItemView3, oSListItemView4, oSListItemView5, oSListItemView6, oSListItemView7, oSListItemView8, oSListItemView9, oSListItemView10, (TextView) objArrMapBindings[2], (ViewPager2) objArrMapBindings[1]);
        this.f2467z = -1L;
        this.f2448a.setTag(null);
        this.f2449b.setTag(null);
        this.f2450c.setTag(null);
        this.f2451d.setTag(null);
        this.e.setTag(null);
        this.f2452h.setTag(null);
        this.f2453i.setTag(null);
        this.f2454j.setTag(null);
        this.f2455k.setTag(null);
        this.f2456l.setTag(null);
        ((FrameLayout) objArrMapBindings[0]).setTag(null);
        this.f2457m.setTag(null);
        this.f2458n.setTag(null);
        setRootTag(view);
        this.f2461s = new k(3, 2, this);
        this.f2462t = new k(7, 2, this);
        this.u = new k(4, 2, this);
        this.f2463v = new k(5, 2, this);
        this.f2464w = new k(1, 2, this);
        this.f2465x = new k(2, 2, this);
        this.f2466y = new k(6, 2, this);
        invalidateAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ya.a
    public final void b(int i8) {
        switch (i8) {
            case 1:
                l lVar = this.f2460r;
                if (lVar != null) {
                    Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
                    Intrinsics.checkNotNullParameter("onJumpToAllowFind", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("BaseSettingActivity"), "onJumpToAllowFind");
                    }
                    int i9 = BaseSettingActivity.f2662k;
                    BaseSettingActivity activity = lVar.f1239a;
                    if (!activity.isFinishing() && !activity.isDestroyed()) {
                        m mVar = activity.f2665d;
                        if (mVar == null || !mVar.isShowing()) {
                            activity.n().getClass();
                            boolean zAreEqual = Intrinsics.areEqual(lb.a.b("multi_device_connection.allow_find").getValue(), Boolean.TRUE);
                            d onChange = new d(activity, 3);
                            e eVar = new e(activity, 3);
                            Intrinsics.checkNotNullParameter(activity, "activity");
                            Intrinsics.checkNotNullParameter(onChange, "onChange");
                            String[] strArr = {activity.getString(R$string.md_all_device), activity.getString(R$string.md_trust_device)};
                            int i10 = !zAreEqual ? 1 : 0;
                            String string = activity.getString(R$string.md_allow_find);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            activity.f2665d = n.a(activity, string, strArr, i10, new d0(onChange, 5), eVar, false, 960);
                        }
                        break;
                    }
                }
                break;
            case 2:
                l lVar2 = this.f2460r;
                if (lVar2 != null) {
                    lVar2.a(false);
                }
                break;
            case 3:
                l lVar3 = this.f2460r;
                if (lVar3 != null) {
                    lVar3.a(true);
                }
                break;
            case 4:
                l lVar4 = this.f2460r;
                if (lVar4 != null) {
                    Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
                    Intrinsics.checkNotNullParameter("onJumpToCopyPastePage", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("BaseSettingActivity"), "onJumpToCopyPastePage");
                    }
                    b.f8417b.f8437a.getClass();
                    w.X("iot_multi_con_shareclipboard_settings_ex", w.D());
                    BaseSettingActivity baseSettingActivity = lVar4.f1239a;
                    baseSettingActivity.startActivity(new Intent(baseSettingActivity, (Class<?>) CopyPastActivity.class));
                }
                break;
            case 5:
                l lVar5 = this.f2460r;
                if (lVar5 != null) {
                    Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
                    Intrinsics.checkNotNullParameter("onJumpToMirrorAndGesturePage", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("BaseSettingActivity"), "onJumpToMirrorAndGesturePage");
                    }
                    b.f8417b.f8437a.getClass();
                    w.X("iot_pc_con_enter_mirror_gesture_page", new Bundle());
                    BaseSettingActivity baseSettingActivity2 = lVar5.f1239a;
                    baseSettingActivity2.startActivity(new Intent(baseSettingActivity2, (Class<?>) GestureActivity.class));
                }
                break;
            case 6:
                l lVar6 = this.f2460r;
                if (lVar6 != null) {
                    Intrinsics.checkNotNullParameter("BaseSettingActivity", "tag");
                    Intrinsics.checkNotNullParameter("onSwitchToShareNotification", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("BaseSettingActivity"), "onSwitchToShareNotification");
                    }
                    Boolean bool = (Boolean) lVar6.f1239a.n().f2866d.getValue();
                    boolean z2 = !(bool != null ? bool.booleanValue() : true);
                    lb.a.e("multi_device_connection.share_notifications", z2);
                    String log = "toggleNotificationSharingSwitch: newState=" + z2;
                    Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
                    Intrinsics.checkNotNullParameter(log, "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("SettingViewModel"), log);
                    }
                }
                break;
            case 7:
                l lVar7 = this.f2460r;
                if (lVar7 != null) {
                    lVar7.b();
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0167  */
    /* JADX WARN: Code duplicated, block: B:104:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0175  */
    /* JADX WARN: Code duplicated, block: B:106:0x017c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0186  */
    /* JADX WARN: Code duplicated, block: B:110:0x018d  */
    /* JADX WARN: Code duplicated, block: B:113:0x0198  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:118:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:121:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:22:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0080  */
    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x008d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0090 A[PHI: r2
      0x0090: PHI (r2v4 long) = (r2v0 long), (r2v6 long) binds: [B:21:0x0062, B:35:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:72:0x0102  */
    /* JADX WARN: Code duplicated, block: B:75:0x0109  */
    /* JADX WARN: Code duplicated, block: B:76:0x0110  */
    /* JADX WARN: Code duplicated, block: B:78:0x0116  */
    /* JADX WARN: Code duplicated, block: B:81:0x011f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0121  */
    /* JADX WARN: Code duplicated, block: B:83:0x0126  */
    /* JADX WARN: Code duplicated, block: B:86:0x012f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0136  */
    /* JADX WARN: Code duplicated, block: B:89:0x013c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0149  */
    /* JADX WARN: Code duplicated, block: B:94:0x014e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0157  */
    /* JADX WARN: Code duplicated, block: B:98:0x015e  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        SearchPageText searchPageText;
        int iA;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        bd.b bVar;
        int i8;
        boolean z2;
        boolean zSafeUnbox3;
        int i9;
        String str;
        String str2;
        String strB;
        MutableLiveData mutableLiveData;
        List list;
        Integer num;
        long j10;
        SearchPageText searchPageText2;
        boolean zSafeUnbox4;
        MutableLiveData mutableLiveData2;
        int i10;
        MutableLiveData mutableLiveData3;
        Boolean bool;
        MutableLiveData mutableLiveData4;
        Boolean bool2;
        MutableLiveData mutableLiveData5;
        Boolean bool3;
        MutableLiveData mutableLiveData6;
        Boolean bool4;
        MutableLiveData mutableLiveData7;
        MutableLiveData mutableLiveData8;
        MutableLiveData mutableLiveData9;
        Boolean bool5;
        boolean zSafeUnbox5;
        long j11;
        MutableLiveData mutableLiveData10;
        MutableLiveData mutableLiveData11;
        synchronized (this) {
            j8 = this.f2467z;
            this.f2467z = 0L;
        }
        SettingsCarouselAdapter settingsCarouselAdapter = this.q;
        PcConnectSettingViewModel pcConnectSettingViewModel = this.f2459o;
        PageIndicatorWrapper pageIndicatorWrapper = this.p;
        long j12 = j8 & 59397;
        if ((60415 & j8) != 0) {
            if (j12 != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData10 = pcConnectSettingViewModel.f2869i;
                    mutableLiveData11 = pcConnectSettingViewModel.f2864b;
                } else {
                    mutableLiveData10 = null;
                    mutableLiveData11 = null;
                }
                updateLiveDataRegistration(0, mutableLiveData10);
                updateLiveDataRegistration(2, mutableLiveData11);
                list = mutableLiveData10 != null ? (List) mutableLiveData10.getValue() : null;
                num = mutableLiveData11 != null ? (Integer) mutableLiveData11.getValue() : null;
                j10 = j8 & 40962;
                if (j10 == 0) {
                    i9 = 0;
                } else {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData9 = pcConnectSettingViewModel.f2871k;
                    } else {
                        mutableLiveData9 = null;
                    }
                    updateLiveDataRegistration(1, mutableLiveData9);
                    if (mutableLiveData9 != null) {
                        bool5 = (Boolean) mutableLiveData9.getValue();
                    } else {
                        bool5 = null;
                    }
                    zSafeUnbox5 = ViewDataBinding.safeUnbox(bool5);
                    if (j10 != 0) {
                        if (zSafeUnbox5) {
                            j11 = 131072;
                        } else {
                            j11 = 65536;
                        }
                        j8 |= j11;
                    }
                    if (zSafeUnbox5) {
                        i9 = 0;
                    } else {
                        i9 = 8;
                    }
                }
                if ((j8 & 40960) != 0 || pcConnectSettingViewModel == null) {
                    i8 = 0;
                    str2 = null;
                    iA = 0;
                } else {
                    i8 = pcConnectSettingViewModel.u;
                    str2 = pcConnectSettingViewModel.f2878t.getValue() == 0 ? "round" : "bottom_corners_round";
                    iA = pcConnectSettingViewModel.a();
                }
                if ((j8 & 40992) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        strB = pcConnectSettingViewModel.b();
                        mutableLiveData8 = pcConnectSettingViewModel.f2870j;
                    } else {
                        mutableLiveData8 = null;
                        strB = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveData8);
                    if (mutableLiveData8 != null) {
                        str = (String) mutableLiveData8.getValue();
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                    strB = null;
                }
                if ((j8 & 40968) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData7 = pcConnectSettingViewModel.f2872l;
                        bVar = pcConnectSettingViewModel.f2873m;
                    } else {
                        mutableLiveData7 = null;
                        bVar = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveData7);
                    if (mutableLiveData7 != null) {
                        searchPageText2 = (SearchPageText) mutableLiveData7.getValue();
                    } else {
                        searchPageText2 = null;
                    }
                } else {
                    searchPageText2 = null;
                    bVar = null;
                }
                if ((j8 & 40976) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData6 = pcConnectSettingViewModel.f2867g;
                    } else {
                        mutableLiveData6 = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveData6);
                    if (mutableLiveData6 != null) {
                        bool4 = (Boolean) mutableLiveData6.getValue();
                    } else {
                        bool4 = null;
                    }
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(bool4);
                } else {
                    zSafeUnbox3 = false;
                }
                if ((j8 & 41024) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData5 = pcConnectSettingViewModel.f2865c;
                    } else {
                        mutableLiveData5 = null;
                    }
                    updateLiveDataRegistration(6, mutableLiveData5);
                    if (mutableLiveData5 != null) {
                        bool3 = (Boolean) mutableLiveData5.getValue();
                    } else {
                        bool3 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(bool3);
                } else {
                    searchPageText2 = searchPageText2;
                    zSafeUnbox2 = false;
                }
                if ((j8 & 41088) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData4 = pcConnectSettingViewModel.f2866d;
                    } else {
                        mutableLiveData4 = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveData4);
                    if (mutableLiveData4 != null) {
                        bool2 = (Boolean) mutableLiveData4.getValue();
                    } else {
                        bool2 = null;
                    }
                    zSafeUnbox4 = ViewDataBinding.safeUnbox(bool2);
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    zSafeUnbox4 = false;
                }
                if ((j8 & 41216) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData3 = pcConnectSettingViewModel.f;
                        i10 = 8;
                    } else {
                        i10 = 8;
                        mutableLiveData3 = null;
                    }
                    updateLiveDataRegistration(i10, mutableLiveData3);
                    if (mutableLiveData3 != null) {
                        bool = (Boolean) mutableLiveData3.getValue();
                    } else {
                        bool = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool);
                } else {
                    zSafeUnbox4 = zSafeUnbox4;
                    zSafeUnbox = false;
                }
                if ((j8 & 41472) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData2 = pcConnectSettingViewModel.f2875o;
                    } else {
                        mutableLiveData2 = null;
                    }
                    updateLiveDataRegistration(9, mutableLiveData2);
                    if (mutableLiveData2 != null) {
                    }
                    mutableLiveData = mutableLiveData2;
                } else {
                    mutableLiveData = null;
                }
                z2 = zSafeUnbox4;
                searchPageText = searchPageText2;
            } else {
                list = null;
            }
            j10 = j8 & 40962;
            if (j10 == 0) {
                i9 = 0;
            } else {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData9 = pcConnectSettingViewModel.f2871k;
                } else {
                    mutableLiveData9 = null;
                }
                updateLiveDataRegistration(1, mutableLiveData9);
                if (mutableLiveData9 != null) {
                    bool5 = (Boolean) mutableLiveData9.getValue();
                } else {
                    bool5 = null;
                }
                zSafeUnbox5 = ViewDataBinding.safeUnbox(bool5);
                if (j10 != 0) {
                    if (zSafeUnbox5) {
                        j11 = 131072;
                    } else {
                        j11 = 65536;
                    }
                    j8 |= j11;
                }
                if (zSafeUnbox5) {
                    i9 = 0;
                } else {
                    i9 = 8;
                }
            }
            if ((j8 & 40960) != 0) {
                i8 = 0;
                str2 = null;
                iA = 0;
            } else {
                i8 = 0;
                str2 = null;
                iA = 0;
            }
            if ((j8 & 40992) != 0) {
                if (pcConnectSettingViewModel != null) {
                    strB = pcConnectSettingViewModel.b();
                    mutableLiveData8 = pcConnectSettingViewModel.f2870j;
                } else {
                    mutableLiveData8 = null;
                    strB = null;
                }
                updateLiveDataRegistration(5, mutableLiveData8);
                if (mutableLiveData8 != null) {
                    str = (String) mutableLiveData8.getValue();
                } else {
                    str = null;
                }
            } else {
                str = null;
                strB = null;
            }
            if ((j8 & 40968) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData7 = pcConnectSettingViewModel.f2872l;
                    bVar = pcConnectSettingViewModel.f2873m;
                } else {
                    mutableLiveData7 = null;
                    bVar = null;
                }
                updateLiveDataRegistration(3, mutableLiveData7);
                if (mutableLiveData7 != null) {
                    searchPageText2 = (SearchPageText) mutableLiveData7.getValue();
                } else {
                    searchPageText2 = null;
                }
            } else {
                searchPageText2 = null;
                bVar = null;
            }
            if ((j8 & 40976) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData6 = pcConnectSettingViewModel.f2867g;
                } else {
                    mutableLiveData6 = null;
                }
                updateLiveDataRegistration(4, mutableLiveData6);
                if (mutableLiveData6 != null) {
                    bool4 = (Boolean) mutableLiveData6.getValue();
                } else {
                    bool4 = null;
                }
                zSafeUnbox3 = ViewDataBinding.safeUnbox(bool4);
            } else {
                zSafeUnbox3 = false;
            }
            if ((j8 & 41024) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData5 = pcConnectSettingViewModel.f2865c;
                } else {
                    mutableLiveData5 = null;
                }
                updateLiveDataRegistration(6, mutableLiveData5);
                if (mutableLiveData5 != null) {
                    bool3 = (Boolean) mutableLiveData5.getValue();
                } else {
                    bool3 = null;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(bool3);
            } else {
                searchPageText2 = searchPageText2;
                zSafeUnbox2 = false;
            }
            if ((j8 & 41088) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData4 = pcConnectSettingViewModel.f2866d;
                } else {
                    mutableLiveData4 = null;
                }
                updateLiveDataRegistration(7, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    bool2 = (Boolean) mutableLiveData4.getValue();
                } else {
                    bool2 = null;
                }
                zSafeUnbox4 = ViewDataBinding.safeUnbox(bool2);
            } else {
                zSafeUnbox2 = zSafeUnbox2;
                zSafeUnbox4 = false;
            }
            if ((j8 & 41216) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData3 = pcConnectSettingViewModel.f;
                    i10 = 8;
                } else {
                    i10 = 8;
                    mutableLiveData3 = null;
                }
                updateLiveDataRegistration(i10, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    bool = (Boolean) mutableLiveData3.getValue();
                } else {
                    bool = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            } else {
                zSafeUnbox4 = zSafeUnbox4;
                zSafeUnbox = false;
            }
            if ((j8 & 41472) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData2 = pcConnectSettingViewModel.f2875o;
                } else {
                    mutableLiveData2 = null;
                }
                updateLiveDataRegistration(9, mutableLiveData2);
                if (mutableLiveData2 != null) {
                }
                mutableLiveData = mutableLiveData2;
            } else {
                mutableLiveData = null;
            }
            z2 = zSafeUnbox4;
            searchPageText = searchPageText2;
        } else {
            pageIndicatorWrapper = pageIndicatorWrapper;
            searchPageText = null;
            iA = 0;
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            bVar = null;
            i8 = 0;
            z2 = false;
            zSafeUnbox3 = false;
            i9 = 0;
            str = null;
            str2 = null;
            strB = null;
            mutableLiveData = null;
            list = null;
            num = null;
        }
        if ((j8 & 32768) != 0) {
            this.f2448a.setOnClickListener(this.f2461s);
            this.f2449b.setOnClickListener(this.f2465x);
            this.f2450c.setOnClickListener(this.f2464w);
            this.f2451d.setOnClickListener(this.u);
            this.e.setOnClickListener(this.f2463v);
            this.f2454j.setOnClickListener(this.f2466y);
            this.f2456l.setOnClickListener(this.f2462t);
        }
        if ((j8 & 40960) != 0) {
            sa.d.c(this.f2448a, str2);
            sa.d.l(this.f2448a, i8);
            sa.d.l(this.f2449b, iA);
        }
        if ((j8 & 40962) != 0) {
            this.f2449b.setVisibility(i9);
        }
        if ((j8 & 40992) != 0) {
            sa.d.f(this.f2449b, str, strB);
        }
        if ((41472 & j8) != 0) {
            sa.d.d(this.f2450c, mutableLiveData);
        }
        if ((41216 & j8) != 0) {
            sa.d.e(this.f2452h, zSafeUnbox);
        }
        if ((j8 & 41024) != 0) {
            sa.d.e(this.f2453i, zSafeUnbox2);
        }
        if ((j8 & 41088) != 0) {
            sa.d.e(this.f2454j, z2);
        }
        if ((j8 & 40976) != 0) {
            sa.d.e(this.f2455k, zSafeUnbox3);
        }
        if ((j8 & 40968) != 0) {
            ed.b(this.f2457m, searchPageText, bVar);
        }
        if ((j8 & 59397) != 0) {
            sa.d.h(this.f2458n, settingsCarouselAdapter, list, pageIndicatorWrapper, num);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.f2467z != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.f2467z = 32768L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean onFieldChange(int i8, Object obj, int i9) {
        switch (i8) {
            case 0:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 1;
                    break;
                }
                return true;
            case 1:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 2;
                    break;
                }
                return true;
            case 2:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 4;
                    break;
                }
                return true;
            case 3:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 8;
                    break;
                }
                return true;
            case 4:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 16;
                    break;
                }
                return true;
            case 5:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 32;
                    break;
                }
                return true;
            case 6:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 64;
                    break;
                }
                return true;
            case 7:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 128;
                    break;
                }
                return true;
            case 8:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 256;
                    break;
                }
                return true;
            case 9:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.f2467z |= 512;
                    break;
                }
                return true;
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean setVariable(int i8, Object obj) {
        if (9 == i8) {
        } else if (2 == i8) {
            this.q = (SettingsCarouselAdapter) obj;
            synchronized (this) {
                this.f2467z |= 2048;
            }
            notifyPropertyChanged(2);
            super.requestRebind();
        } else if (4 == i8) {
            this.f2460r = (l) obj;
            synchronized (this) {
                this.f2467z |= 4096;
            }
            notifyPropertyChanged(4);
            super.requestRebind();
        } else if (21 == i8) {
            this.f2459o = (PcConnectSettingViewModel) obj;
            synchronized (this) {
                this.f2467z |= 8192;
            }
            notifyPropertyChanged(21);
            super.requestRebind();
        } else {
            if (10 != i8) {
                return false;
            }
            this.p = (PageIndicatorWrapper) obj;
            synchronized (this) {
                this.f2467z |= 16384;
            }
            notifyPropertyChanged(10);
            super.requestRebind();
        }
        return true;
    }
}
