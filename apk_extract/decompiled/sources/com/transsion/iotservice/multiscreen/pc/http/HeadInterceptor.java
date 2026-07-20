package com.transsion.iotservice.multiscreen.pc.http;

import af.r5;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.core.deviceinfo.DeviceInfo;
import dj.e0;
import dj.j0;
import dj.v;
import dj.w;
import ij.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import k3.pb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m3.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/HeadInterceptor;", "Ldj/w;", "<init>", "()V", "Ldj/v;", "chain", "Ldj/e0;", "requestLatestHeader", "(Ldj/v;)Ldj/e0;", "Ldj/j0;", "intercept", "(Ldj/v;)Ldj/j0;", "Ljava/text/SimpleDateFormat;", "mTimeFormat", "Ljava/text/SimpleDateFormat;", "", "mGaid", "Ljava/lang/String;", "mVaid", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HeadInterceptor implements w {
    private String mGaid;
    private final SimpleDateFormat mTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private String mVaid;

    public HeadInterceptor() {
        String strA;
        String str = "";
        this.mGaid = "";
        this.mVaid = "";
        try {
            pb.a();
            strA = h0.a();
            Intrinsics.checkNotNull(strA);
        } catch (Exception unused) {
            strA = "";
        }
        this.mVaid = strA;
        try {
            String gAId = DeviceInfo.getGAId();
            Intrinsics.checkNotNull(gAId);
            str = gAId;
        } catch (Exception unused2) {
        }
        this.mGaid = str;
    }

    private final e0 requestLatestHeader(v chain) {
        r5 r5VarB = ((f) chain).f.b();
        r5VarB.v("appName", "TransLink");
        r5VarB.v("appVersion", "1.3.1.227");
        String str = this.mTimeFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        r5VarB.v("Date", str);
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        r5VarB.v("brand", BRAND);
        r5VarB.v("Content-Type", "application/json");
        r5VarB.v("eDevId", "1001");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        r5VarB.v("transId", string);
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        r5VarB.v("deviceModel", MODEL);
        r5VarB.v("User-Agent", "welink 1.3.1.227");
        r5VarB.v("Referer", this.mGaid + ":" + this.mVaid + ":");
        return r5VarB.o();
    }

    @Override // dj.w
    public j0 intercept(v chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return ((f) chain).b(requestLatestHeader(chain));
    }
}
