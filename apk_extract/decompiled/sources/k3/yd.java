package k3;

import android.content.res.Resources;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.widget.FootOperationBar;
import com.welink.protocol.nfbd.NearDevice;
import java.net.Socket;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6730d;
    public final /* synthetic */ Object e;

    public /* synthetic */ yd(Object obj, Object obj2, Object obj3, String str, int i8) {
        this.f6727a = i8;
        this.f6729c = obj;
        this.f6730d = obj2;
        this.e = obj3;
        this.f6728b = str;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a6  */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        e0 e0VarC;
        String str2;
        m3.va vaVarZzh;
        int i8 = 0;
        switch (this.f6727a) {
            case 0:
                be beVar = (be) this.f6729c;
                df.m mVar = (df.m) this.f6730d;
                la laVar = (la) this.e;
                String str3 = (String) this.f6728b;
                beVar.getClass();
                d2.a aVar = (d2.a) mVar.f4460d;
                aVar.f4258b = laVar;
                ad adVar = (ad) aVar.f4257a;
                if (adVar != null) {
                    str = adVar.f6364d;
                    int i9 = f.f6434a;
                    if (str == null || str.isEmpty()) {
                        str = "NA";
                    } else {
                        u2.l.e(str);
                    }
                } else {
                    str = "NA";
                }
                zc zcVar = new zc();
                zcVar.f6752a = beVar.f6382a;
                zcVar.f6753b = beVar.f6383b;
                synchronized (be.class) {
                    try {
                        e0VarC = be.f6380k;
                        if (e0VarC == null) {
                            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                            b0 b0Var = new b0();
                            while (i8 < locales.size()) {
                                Locale locale = locales.get(i8);
                                tc.d dVar = p5.c.f8670a;
                                b0Var.a(locale.toLanguageTag());
                                i8++;
                            }
                            e0VarC = b0Var.c();
                            be.f6380k = e0VarC;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                zcVar.f6760k = e0VarC;
                zcVar.f6756g = Boolean.TRUE;
                zcVar.f6755d = str;
                zcVar.f6754c = str3;
                zcVar.e = beVar.f.d() ? (String) beVar.f.b() : beVar.f6385d.a();
                zcVar.f6758i = 10;
                zcVar.f6759j = Integer.valueOf(beVar.f6387h);
                mVar.f4458b = zcVar;
                beVar.f6384c.a(mVar);
                return;
            case 1:
                m3.oa oaVar = (m3.oa) this.f6729c;
                i1.a aVar2 = (i1.a) this.f6730d;
                m3.m7 m7Var = (m3.m7) this.e;
                String str4 = (String) this.f6728b;
                u6.a aVar3 = (u6.a) aVar2.f5524b;
                aVar3.f10379c = m7Var;
                m3.o9 o9Var = (m3.o9) aVar3.f10378b;
                if (o9Var != null) {
                    int i10 = m3.t2.f7862a;
                    str2 = o9Var.f7813d;
                    if (str2 == null || str2.isEmpty()) {
                        str2 = "NA";
                    }
                } else {
                    str2 = "NA";
                }
                zc zcVar2 = new zc();
                zcVar2.f6752a = oaVar.f7821a;
                zcVar2.f6753b = oaVar.f7822b;
                synchronized (m3.oa.class) {
                    try {
                        vaVarZzh = m3.oa.f7819j;
                        if (vaVarZzh == null) {
                            LocaleListCompat locales2 = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
                            Object[] objArrCopyOf = new Object[4];
                            int i11 = 0;
                            while (i8 < locales2.size()) {
                                Locale locale2 = locales2.get(i8);
                                tc.d dVar2 = p5.c.f8670a;
                                String languageTag = locale2.toLanguageTag();
                                languageTag.getClass();
                                int i12 = i11 + 1;
                                int length = objArrCopyOf.length;
                                if (length < i12) {
                                    int i13 = length + (length >> 1) + 1;
                                    if (i13 < i12) {
                                        int iHighestOneBit = Integer.highestOneBit(i11);
                                        i13 = iHighestOneBit + iHighestOneBit;
                                    }
                                    if (i13 < 0) {
                                        i13 = Integer.MAX_VALUE;
                                    }
                                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i13);
                                }
                                objArrCopyOf[i11] = languageTag;
                                i8++;
                                i11 = i12;
                            }
                            vaVarZzh = m3.va.zzh(objArrCopyOf, i11);
                            m3.oa.f7819j = vaVarZzh;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                zcVar2.f6760k = vaVarZzh;
                zcVar2.f6756g = Boolean.TRUE;
                zcVar2.f6755d = str2;
                zcVar2.f6754c = str4;
                zcVar2.e = oaVar.f.d() ? (String) oaVar.f.b() : oaVar.f7824d.a();
                zcVar2.f6758i = 10;
                zcVar2.f6759j = Integer.valueOf(oaVar.f7826h);
                aVar2.f5525c = zcVar2;
                oaVar.f7823c.a(aVar2);
                return;
            case 2:
                NearDevice nearDevice = (NearDevice) this.f6730d;
                String str5 = (String) this.f6728b;
                se.d3 d3Var = (se.d3) this.f6729c;
                byte[] data = d3Var.j(nearDevice, str5);
                if (data == null) {
                    Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                    Intrinsics.checkNotNullParameter("sendCreateConnectionRequest: connectRequest is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearLanTcpClient", "TransConnect:sendCreateConnectionRequest: connectRequest is null", null);
                    }
                    se.t2 t2Var = d3Var.e;
                    if (t2Var != null) {
                        t2Var.b(nearDevice, null);
                        return;
                    }
                    return;
                }
                Socket socket = (Socket) this.e;
                d3Var.s(nearDevice, socket.getInetAddress().getHostAddress(), 3000L);
                se.t2 t2Var2 = d3Var.e;
                if (t2Var2 != null) {
                    Intrinsics.checkNotNullParameter(socket, "socket");
                    Intrinsics.checkNotNullParameter(data, "data");
                    li.v0 v0Var = li.v0.f7498a;
                    li.l0.p(li.h0.a(si.e.f10118a), null, null, new se.s2(data, socket, t2Var2.f9999b, null), 3);
                    return;
                }
                return;
            default:
                Space space = (Space) ((ViewGroup) this.f6729c).findViewById(R$id.os_foot_opt_space);
                if (space == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
                boolean z2 = ((FootOperationBar) this.f6728b).f3388z;
                LinearLayout linearLayout = (LinearLayout) this.f6730d;
                int measuredWidth = z2 ? linearLayout.getMeasuredWidth() : ((ImageView) this.e).getMeasuredWidth();
                if (measuredWidth > 0) {
                    layoutParams.width = measuredWidth;
                }
                int measuredHeight = linearLayout.getMeasuredHeight();
                if (measuredHeight > 0) {
                    layoutParams.height = measuredHeight;
                }
                space.setLayoutParams(layoutParams);
                return;
        }
    }

    public yd(FootOperationBar footOperationBar, ViewGroup viewGroup, LinearLayout linearLayout, ImageView imageView) {
        this.f6727a = 3;
        this.f6728b = footOperationBar;
        this.f6729c = viewGroup;
        this.f6730d = linearLayout;
        this.e = imageView;
    }
}
