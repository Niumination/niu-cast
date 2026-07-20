package com.transsion.iotservice.multiscreen.pc.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import bb.l;
import bd.b;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.adapter.SettingsCarouselAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.ui.setting.PcConnectSettingViewModel;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetslistitemlayout.OSListItemView;
import java.util.List;
import k3.ed;
import qd.k;
import sa.d;
import ya.a;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityPcConnectSettingPadBindingSw600dpImpl extends ActivityPcConnectSettingPadBinding implements a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final SparseIntArray f2484v;
    public final k p;
    public final k q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k f2485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final k f2486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final k f2487t;
    public long u;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2484v = sparseIntArray;
        sparseIntArray.put(R$id.damping_layout, 10);
        sparseIntArray.put(R$id.indicator, 11);
        sparseIntArray.put(R$id.os_mask_status_bar, 12);
        sparseIntArray.put(R$id.liquidBar, 13);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityPcConnectSettingPadBindingSw600dpImpl(View view, DataBindingComponent dataBindingComponent) {
        Object[] objArrMapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 14, (ViewDataBinding.IncludedLayouts) null, f2484v);
        OSListItemView oSListItemView = (OSListItemView) objArrMapBindings[4];
        OSListItemView oSListItemView2 = (OSListItemView) objArrMapBindings[3];
        OSListItemView oSListItemView3 = (OSListItemView) objArrMapBindings[5];
        OSListItemView oSListItemView4 = (OSListItemView) objArrMapBindings[7];
        OSListItemView oSListItemView5 = (OSListItemView) objArrMapBindings[6];
        OSListItemView oSListItemView6 = (OSListItemView) objArrMapBindings[8];
        OSListItemView oSListItemView7 = (OSListItemView) objArrMapBindings[9];
        super(dataBindingComponent, view, oSListItemView, oSListItemView2, oSListItemView3, oSListItemView4, oSListItemView5, oSListItemView6, oSListItemView7, (TextView) objArrMapBindings[2], (ViewPager2) objArrMapBindings[1]);
        this.u = -1L;
        this.f2468a.setTag(null);
        this.f2469b.setTag(null);
        this.f2470c.setTag(null);
        this.f2471d.setTag(null);
        this.e.setTag(null);
        this.f2472h.setTag(null);
        this.f2473i.setTag(null);
        ((FrameLayout) objArrMapBindings[0]).setTag(null);
        this.f2474j.setTag(null);
        this.f2475k.setTag(null);
        setRootTag(view);
        this.p = new k(2, 2, this);
        this.q = new k(5, 2, this);
        this.f2485r = new k(1, 2, this);
        this.f2486s = new k(4, 2, this);
        this.f2487t = new k(3, 2, this);
        invalidateAll();
    }

    @Override // ya.a
    public final void b(int i8) {
        l lVar;
        if (i8 == 1) {
            l lVar2 = this.f2479o;
            if (lVar2 != null) {
                lVar2.a(false);
                return;
            }
            return;
        }
        if (i8 == 2) {
            l lVar3 = this.f2479o;
            if (lVar3 != null) {
                lVar3.a(true);
                return;
            }
            return;
        }
        if (i8 == 3) {
            l lVar4 = this.f2479o;
            if (lVar4 != null) {
                lVar4.c();
                return;
            }
            return;
        }
        if (i8 != 4) {
            if (i8 == 5 && (lVar = this.f2479o) != null) {
                lVar.b();
                return;
            }
            return;
        }
        l lVar5 = this.f2479o;
        if (lVar5 != null) {
            lVar5.e();
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0162 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0164  */
    /* JADX WARN: Code duplicated, block: B:104:0x0169  */
    /* JADX WARN: Code duplicated, block: B:107:0x0170  */
    /* JADX WARN: Code duplicated, block: B:108:0x0179  */
    /* JADX WARN: Code duplicated, block: B:111:0x0190  */
    /* JADX WARN: Code duplicated, block: B:22:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0075  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:37:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x0084 A[PHI: r2
      0x0084: PHI (r2v4 long) = (r2v0 long), (r2v6 long) binds: [B:21:0x0057, B:35:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:75:0x0100  */
    /* JADX WARN: Code duplicated, block: B:76:0x0107  */
    /* JADX WARN: Code duplicated, block: B:79:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0114  */
    /* JADX WARN: Code duplicated, block: B:81:0x0119  */
    /* JADX WARN: Code duplicated, block: B:84:0x0122  */
    /* JADX WARN: Code duplicated, block: B:85:0x0129  */
    /* JADX WARN: Code duplicated, block: B:88:0x0131  */
    /* JADX WARN: Code duplicated, block: B:91:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x013f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0144  */
    /* JADX WARN: Code duplicated, block: B:96:0x014d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0156  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.databinding.ViewDataBinding
    public final void executeBindings() {
        long j8;
        b bVar;
        boolean zSafeUnbox;
        boolean z2;
        String strB;
        int i8;
        int i9;
        MutableLiveData mutableLiveData;
        SearchPageText searchPageText;
        String str;
        int iA;
        String str2;
        MutableLiveData mutableLiveData2;
        List list;
        Integer num;
        long j10;
        boolean zSafeUnbox2;
        MutableLiveData mutableLiveData3;
        LiveData<?> liveData;
        Boolean bool;
        LiveData<?> liveData2;
        Boolean bool2;
        LiveData<?> liveData3;
        LiveData<?> liveData4;
        LiveData<?> liveData5;
        Boolean bool3;
        boolean zSafeUnbox3;
        long j11;
        LiveData<?> liveData6;
        LiveData<?> liveData7;
        synchronized (this) {
            j8 = this.u;
            this.u = 0L;
        }
        SettingsCarouselAdapter settingsCarouselAdapter = this.f2478n;
        PcConnectSettingViewModel pcConnectSettingViewModel = this.f2476l;
        PageIndicatorWrapper pageIndicatorWrapper = this.f2477m;
        long j12 = j8 & 29701;
        if ((30207 & j8) != 0) {
            if (j12 != 0) {
                if (pcConnectSettingViewModel != null) {
                    liveData6 = pcConnectSettingViewModel.f2869i;
                    liveData7 = pcConnectSettingViewModel.f2864b;
                } else {
                    liveData6 = null;
                    liveData7 = null;
                }
                updateLiveDataRegistration(0, liveData6);
                updateLiveDataRegistration(2, liveData7);
                list = liveData6 != null ? (List) liveData6.getValue() : null;
                num = liveData7 != null ? (Integer) liveData7.getValue() : null;
                j10 = j8 & 20482;
                if (j10 == 0) {
                    i9 = 0;
                } else {
                    if (pcConnectSettingViewModel != null) {
                        liveData5 = pcConnectSettingViewModel.f2871k;
                    } else {
                        liveData5 = null;
                    }
                    updateLiveDataRegistration(1, liveData5);
                    if (liveData5 != null) {
                        bool3 = (Boolean) liveData5.getValue();
                    } else {
                        bool3 = null;
                    }
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(bool3);
                    if (j10 != 0) {
                        if (zSafeUnbox3) {
                            j11 = 65536;
                        } else {
                            j11 = 32768;
                        }
                        j8 |= j11;
                    }
                    if (zSafeUnbox3) {
                        i9 = 0;
                    } else {
                        i9 = 8;
                    }
                }
                if ((j8 & 20480) != 0 || pcConnectSettingViewModel == null) {
                    i8 = 0;
                    str = null;
                    iA = 0;
                } else {
                    i8 = pcConnectSettingViewModel.u;
                    str = pcConnectSettingViewModel.f2878t.getValue() == 0 ? "round" : "bottom_corners_round";
                    iA = pcConnectSettingViewModel.a();
                }
                if ((j8 & 20496) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        strB = pcConnectSettingViewModel.b();
                        liveData4 = pcConnectSettingViewModel.f2870j;
                    } else {
                        liveData4 = null;
                        strB = null;
                    }
                    updateLiveDataRegistration(4, liveData4);
                    if (liveData4 != null) {
                        str2 = (String) liveData4.getValue();
                    } else {
                        str2 = null;
                    }
                } else {
                    str2 = null;
                    strB = null;
                }
                if ((j8 & 20488) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        liveData3 = pcConnectSettingViewModel.f2872l;
                        bVar = pcConnectSettingViewModel.f2873m;
                    } else {
                        bVar = null;
                        liveData3 = null;
                    }
                    updateLiveDataRegistration(3, liveData3);
                    searchPageText = liveData3 != null ? (SearchPageText) liveData3.getValue() : null;
                    if ((j8 & 20512) != 0) {
                        if (pcConnectSettingViewModel != null) {
                            mutableLiveData2 = pcConnectSettingViewModel.f2877s;
                        } else {
                            mutableLiveData2 = null;
                        }
                        updateLiveDataRegistration(5, mutableLiveData2);
                        if (mutableLiveData2 != null) {
                        }
                    } else {
                        bVar = bVar;
                        mutableLiveData2 = null;
                    }
                    if ((j8 & 20544) != 0) {
                        if (pcConnectSettingViewModel != null) {
                            liveData2 = pcConnectSettingViewModel.f2865c;
                        } else {
                            liveData2 = null;
                        }
                        updateLiveDataRegistration(6, liveData2);
                        if (liveData2 != null) {
                            bool2 = (Boolean) liveData2.getValue();
                        } else {
                            bool2 = null;
                        }
                        zSafeUnbox2 = ViewDataBinding.safeUnbox(bool2);
                    } else {
                        searchPageText = searchPageText;
                        zSafeUnbox2 = false;
                    }
                    if ((j8 & 20608) != 0) {
                        if (pcConnectSettingViewModel != null) {
                            mutableLiveData3 = pcConnectSettingViewModel.q;
                        } else {
                            mutableLiveData3 = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveData3);
                        if (mutableLiveData3 != null) {
                        }
                    } else {
                        zSafeUnbox2 = zSafeUnbox2;
                        mutableLiveData3 = null;
                    }
                    if ((j8 & 20736) != 0) {
                        if (pcConnectSettingViewModel != null) {
                            liveData = pcConnectSettingViewModel.e;
                        } else {
                            liveData = null;
                        }
                        updateLiveDataRegistration(8, liveData);
                        if (liveData != null) {
                            bool = (Boolean) liveData.getValue();
                        } else {
                            bool = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool);
                    } else {
                        zSafeUnbox = false;
                    }
                    mutableLiveData = mutableLiveData3;
                    z2 = zSafeUnbox2;
                } else {
                    bVar = null;
                }
                if ((j8 & 20512) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData2 = pcConnectSettingViewModel.f2877s;
                    } else {
                        mutableLiveData2 = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveData2);
                    if (mutableLiveData2 != null) {
                    }
                } else {
                    bVar = bVar;
                    mutableLiveData2 = null;
                }
                if ((j8 & 20544) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        liveData2 = pcConnectSettingViewModel.f2865c;
                    } else {
                        liveData2 = null;
                    }
                    updateLiveDataRegistration(6, liveData2);
                    if (liveData2 != null) {
                        bool2 = (Boolean) liveData2.getValue();
                    } else {
                        bool2 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(bool2);
                } else {
                    searchPageText = searchPageText;
                    zSafeUnbox2 = false;
                }
                if ((j8 & 20608) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData3 = pcConnectSettingViewModel.q;
                    } else {
                        mutableLiveData3 = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveData3);
                    if (mutableLiveData3 != null) {
                    }
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    mutableLiveData3 = null;
                }
                if ((j8 & 20736) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        liveData = pcConnectSettingViewModel.e;
                    } else {
                        liveData = null;
                    }
                    updateLiveDataRegistration(8, liveData);
                    if (liveData != null) {
                        bool = (Boolean) liveData.getValue();
                    } else {
                        bool = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool);
                } else {
                    zSafeUnbox = false;
                }
                mutableLiveData = mutableLiveData3;
                z2 = zSafeUnbox2;
            } else {
                list = null;
            }
            j10 = j8 & 20482;
            if (j10 == 0) {
                i9 = 0;
            } else {
                if (pcConnectSettingViewModel != null) {
                    liveData5 = pcConnectSettingViewModel.f2871k;
                } else {
                    liveData5 = null;
                }
                updateLiveDataRegistration(1, liveData5);
                if (liveData5 != null) {
                    bool3 = (Boolean) liveData5.getValue();
                } else {
                    bool3 = null;
                }
                zSafeUnbox3 = ViewDataBinding.safeUnbox(bool3);
                if (j10 != 0) {
                    if (zSafeUnbox3) {
                        j11 = 65536;
                    } else {
                        j11 = 32768;
                    }
                    j8 |= j11;
                }
                if (zSafeUnbox3) {
                    i9 = 0;
                } else {
                    i9 = 8;
                }
            }
            if ((j8 & 20480) != 0) {
                i8 = 0;
                str = null;
                iA = 0;
            } else {
                i8 = 0;
                str = null;
                iA = 0;
            }
            if ((j8 & 20496) != 0) {
                if (pcConnectSettingViewModel != null) {
                    strB = pcConnectSettingViewModel.b();
                    liveData4 = pcConnectSettingViewModel.f2870j;
                } else {
                    liveData4 = null;
                    strB = null;
                }
                updateLiveDataRegistration(4, liveData4);
                if (liveData4 != null) {
                    str2 = (String) liveData4.getValue();
                } else {
                    str2 = null;
                }
            } else {
                str2 = null;
                strB = null;
            }
            if ((j8 & 20488) != 0) {
                if (pcConnectSettingViewModel != null) {
                    liveData3 = pcConnectSettingViewModel.f2872l;
                    bVar = pcConnectSettingViewModel.f2873m;
                } else {
                    bVar = null;
                    liveData3 = null;
                }
                updateLiveDataRegistration(3, liveData3);
                if (liveData3 != null) {
                }
                if ((j8 & 20512) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData2 = pcConnectSettingViewModel.f2877s;
                    } else {
                        mutableLiveData2 = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveData2);
                    if (mutableLiveData2 != null) {
                    }
                } else {
                    bVar = bVar;
                    mutableLiveData2 = null;
                }
                if ((j8 & 20544) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        liveData2 = pcConnectSettingViewModel.f2865c;
                    } else {
                        liveData2 = null;
                    }
                    updateLiveDataRegistration(6, liveData2);
                    if (liveData2 != null) {
                        bool2 = (Boolean) liveData2.getValue();
                    } else {
                        bool2 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(bool2);
                } else {
                    searchPageText = searchPageText;
                    zSafeUnbox2 = false;
                }
                if ((j8 & 20608) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        mutableLiveData3 = pcConnectSettingViewModel.q;
                    } else {
                        mutableLiveData3 = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveData3);
                    if (mutableLiveData3 != null) {
                    }
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    mutableLiveData3 = null;
                }
                if ((j8 & 20736) != 0) {
                    if (pcConnectSettingViewModel != null) {
                        liveData = pcConnectSettingViewModel.e;
                    } else {
                        liveData = null;
                    }
                    updateLiveDataRegistration(8, liveData);
                    if (liveData != null) {
                        bool = (Boolean) liveData.getValue();
                    } else {
                        bool = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool);
                } else {
                    zSafeUnbox = false;
                }
                mutableLiveData = mutableLiveData3;
                z2 = zSafeUnbox2;
            } else {
                bVar = null;
            }
            if ((j8 & 20512) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData2 = pcConnectSettingViewModel.f2877s;
                } else {
                    mutableLiveData2 = null;
                }
                updateLiveDataRegistration(5, mutableLiveData2);
                if (mutableLiveData2 != null) {
                }
            } else {
                bVar = bVar;
                mutableLiveData2 = null;
            }
            if ((j8 & 20544) != 0) {
                if (pcConnectSettingViewModel != null) {
                    liveData2 = pcConnectSettingViewModel.f2865c;
                } else {
                    liveData2 = null;
                }
                updateLiveDataRegistration(6, liveData2);
                if (liveData2 != null) {
                    bool2 = (Boolean) liveData2.getValue();
                } else {
                    bool2 = null;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(bool2);
            } else {
                searchPageText = searchPageText;
                zSafeUnbox2 = false;
            }
            if ((j8 & 20608) != 0) {
                if (pcConnectSettingViewModel != null) {
                    mutableLiveData3 = pcConnectSettingViewModel.q;
                } else {
                    mutableLiveData3 = null;
                }
                updateLiveDataRegistration(7, mutableLiveData3);
                if (mutableLiveData3 != null) {
                }
            } else {
                zSafeUnbox2 = zSafeUnbox2;
                mutableLiveData3 = null;
            }
            if ((j8 & 20736) != 0) {
                if (pcConnectSettingViewModel != null) {
                    liveData = pcConnectSettingViewModel.e;
                } else {
                    liveData = null;
                }
                updateLiveDataRegistration(8, liveData);
                if (liveData != null) {
                    bool = (Boolean) liveData.getValue();
                } else {
                    bool = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(bool);
            } else {
                zSafeUnbox = false;
            }
            mutableLiveData = mutableLiveData3;
            z2 = zSafeUnbox2;
        } else {
            settingsCarouselAdapter = settingsCarouselAdapter;
            bVar = null;
            zSafeUnbox = false;
            z2 = false;
            strB = null;
            i8 = 0;
            i9 = 0;
            mutableLiveData = null;
            searchPageText = null;
            str = null;
            iA = 0;
            str2 = null;
            mutableLiveData2 = null;
            list = null;
            num = null;
        }
        if ((j8 & 16384) != 0) {
            this.f2468a.setOnClickListener(this.p);
            this.f2469b.setOnClickListener(this.f2485r);
            this.f2471d.setOnClickListener(this.f2487t);
            this.f2472h.setOnClickListener(this.f2486s);
            this.f2473i.setOnClickListener(this.q);
        }
        if ((j8 & 20480) != 0) {
            d.c(this.f2468a, str);
            d.l(this.f2468a, i8);
            d.l(this.f2469b, iA);
        }
        if ((j8 & 20482) != 0) {
            this.f2469b.setVisibility(i9);
        }
        if ((j8 & 20496) != 0) {
            d.f(this.f2469b, str2, strB);
        }
        if ((20736 & j8) != 0) {
            d.e(this.f2470c, zSafeUnbox);
        }
        if ((20608 & j8) != 0) {
            d.d(this.f2471d, mutableLiveData);
        }
        if ((j8 & 20544) != 0) {
            d.e(this.e, z2);
        }
        if ((j8 & 20512) != 0) {
            d.d(this.f2472h, mutableLiveData2);
        }
        if ((j8 & 20488) != 0) {
            ed.b(this.f2474j, searchPageText, bVar);
        }
        if ((j8 & 29701) != 0) {
            d.h(this.f2475k, settingsCarouselAdapter, list, pageIndicatorWrapper, num);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final boolean hasPendingBindings() {
        synchronized (this) {
            try {
                return this.u != 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public final void invalidateAll() {
        synchronized (this) {
            this.u = 16384L;
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
                    this.u |= 1;
                    break;
                }
                return true;
            case 1:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 2;
                    break;
                }
                return true;
            case 2:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 4;
                    break;
                }
                return true;
            case 3:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 8;
                    break;
                }
                return true;
            case 4:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 16;
                    break;
                }
                return true;
            case 5:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 32;
                    break;
                }
                return true;
            case 6:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 64;
                    break;
                }
                return true;
            case 7:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 128;
                    break;
                }
                return true;
            case 8:
                if (i9 != 0) {
                    return false;
                }
                synchronized (this) {
                    this.u |= 256;
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
            this.f2478n = (SettingsCarouselAdapter) obj;
            synchronized (this) {
                this.u |= 1024;
            }
            notifyPropertyChanged(2);
            super.requestRebind();
        } else if (4 == i8) {
            this.f2479o = (l) obj;
            synchronized (this) {
                this.u |= 2048;
            }
            notifyPropertyChanged(4);
            super.requestRebind();
        } else if (21 == i8) {
            this.f2476l = (PcConnectSettingViewModel) obj;
            synchronized (this) {
                this.u |= 4096;
            }
            notifyPropertyChanged(21);
            super.requestRebind();
        } else {
            if (10 != i8) {
                return false;
            }
            this.f2477m = (PageIndicatorWrapper) obj;
            synchronized (this) {
                this.u |= 8192;
            }
            notifyPropertyChanged(10);
            super.requestRebind();
        }
        return true;
    }
}
