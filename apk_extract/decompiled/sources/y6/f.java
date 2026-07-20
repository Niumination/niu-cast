package y6;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.work.WorkRequest;
import ef.o;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import k3.dd;
import m3.d0;
import m3.g0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.c f11091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f11092d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a8.a f11093h;

    public f(s6.c cVar, long j8, a8.a aVar) {
        Context context = e8.b.f4712i;
        StringBuilder sb2 = new StringBuilder();
        try {
            String strL = g0.l(context);
            sb2.append(Build.MODEL);
            sb2.append(Build.BRAND);
            sb2.append(g0.p(context));
            sb2.append(Build.VERSION.RELEASE);
            sb2.append(g0.o(context));
            sb2.append(g0.m(context));
            sb2.append(Locale.getDefault().getLanguage());
            sb2.append(strL == null ? "" : strL);
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
        int iHashCode = sb2.toString().hashCode();
        this.e = iHashCode;
        if (cVar.f9532d > 0 && iHashCode != cVar.e) {
            z6.a.e("dimensionChanged, so set appConfig version to 0");
            cVar.f9532d = 0L;
        }
        this.f11091c = cVar;
        this.f11092d = j8;
        this.f11093h = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0299  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a1 A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:110:0x02ad A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02b9 A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02c5 A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:120:0x02d3 A[Catch: Exception -> 0x0297, TRY_ENTER, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02dd A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:125:0x02ed A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0306  */
    /* JADX WARN: Code duplicated, block: B:132:0x0317 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x032c A[LOOP:2: B:130:0x0311->B:135:0x032c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:138:0x033c A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x035e A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0367 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x036a A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0378 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x038c A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x039f A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x03b3 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x03c8 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x03dc A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x03ef A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x040b A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x041e A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:177:0x0435 A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x044c A[Catch: Exception -> 0x034e, TryCatch #1 {Exception -> 0x034e, blocks: (B:129:0x0309, B:130:0x0311, B:132:0x0317, B:138:0x033c, B:141:0x0351, B:143:0x035e, B:146:0x0367, B:148:0x036b, B:150:0x0378, B:151:0x037c, B:153:0x038c, B:154:0x0390, B:156:0x039f, B:157:0x03a3, B:159:0x03b3, B:160:0x03b7, B:162:0x03c8, B:163:0x03cc, B:165:0x03dc, B:166:0x03e0, B:168:0x03ef, B:169:0x03f3, B:171:0x040b, B:172:0x040f, B:174:0x041e, B:175:0x0422, B:177:0x0435, B:178:0x0439, B:180:0x044c, B:181:0x0450, B:147:0x036a), top: B:223:0x0309 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x049a A[Catch: Exception -> 0x04c5, TryCatch #6 {Exception -> 0x04c5, blocks: (B:185:0x0494, B:187:0x049a, B:188:0x04a2, B:190:0x04a8, B:192:0x04c0, B:196:0x04c7, B:199:0x04d8, B:206:0x04f5, B:202:0x04e3), top: B:231:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x04a8 A[Catch: Exception -> 0x04c5, TryCatch #6 {Exception -> 0x04c5, blocks: (B:185:0x0494, B:187:0x049a, B:188:0x04a2, B:190:0x04a8, B:192:0x04c0, B:196:0x04c7, B:199:0x04d8, B:206:0x04f5, B:202:0x04e3), top: B:231:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x04c0 A[Catch: Exception -> 0x04c5, TryCatch #6 {Exception -> 0x04c5, blocks: (B:185:0x0494, B:187:0x049a, B:188:0x04a2, B:190:0x04a8, B:192:0x04c0, B:196:0x04c7, B:199:0x04d8, B:206:0x04f5, B:202:0x04e3), top: B:231:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x04d8 A[Catch: Exception -> 0x04c5, TryCatch #6 {Exception -> 0x04c5, blocks: (B:185:0x0494, B:187:0x049a, B:188:0x04a2, B:190:0x04a8, B:192:0x04c0, B:196:0x04c7, B:199:0x04d8, B:206:0x04f5, B:202:0x04e3), top: B:231:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:202:0x04e3 A[Catch: Exception -> 0x04c5, TryCatch #6 {Exception -> 0x04c5, blocks: (B:185:0x0494, B:187:0x049a, B:188:0x04a2, B:190:0x04a8, B:192:0x04c0, B:196:0x04c7, B:199:0x04d8, B:206:0x04f5, B:202:0x04e3), top: B:231:0x0494 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:211:0x050b  */
    /* JADX WARN: Code duplicated, block: B:212:0x0515  */
    /* JADX WARN: Code duplicated, block: B:216:0x0525  */
    /* JADX WARN: Code duplicated, block: B:239:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x032b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x04c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0210  */
    /* JADX WARN: Code duplicated, block: B:93:0x0213  */
    /* JADX WARN: Code duplicated, block: B:94:0x0219  */
    /* JADX WARN: Code duplicated, block: B:96:0x0233  */
    /* JADX WARN: Code duplicated, block: B:99:0x028a A[Catch: Exception -> 0x0297, TryCatch #4 {Exception -> 0x0297, blocks: (B:97:0x027f, B:99:0x028a, B:105:0x029b, B:107:0x02a1, B:108:0x02a7, B:110:0x02ad, B:111:0x02b3, B:113:0x02b9, B:114:0x02bf, B:116:0x02c5, B:117:0x02cb, B:120:0x02d3, B:122:0x02dd, B:123:0x02e7, B:125:0x02ed, B:126:0x0300), top: B:229:0x027f }] */
    @Override // y6.d
    public final void a() throws Throwable {
        String string;
        String string2;
        HttpURLConnection httpURLConnection;
        o oVar;
        o oVar2;
        int i8;
        int i9;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        s6.c cVar;
        boolean z2;
        int i10;
        f fVar;
        JSONObject jSONObject;
        boolean zHas;
        CopyOnWriteArrayList<s6.a> copyOnWriteArrayList;
        JSONObject jSONObject2;
        s6.c cVarC;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        long j8;
        JSONObject jSONObject3;
        String strOptString;
        JSONArray jSONArray;
        JSONObject jSONObject4;
        int i11;
        JSONObject jSONObject5;
        JSONArray jSONArray2;
        int i12;
        long j10;
        Iterator it;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        int i13;
        s6.a aVar;
        int iOptInt;
        long j11;
        int iOptInt2;
        String str10;
        int iOptInt3;
        int iOptInt4;
        int iOptInt5;
        int iOptInt6;
        String str11;
        int iOptInt7;
        String str12;
        int iOptInt8;
        String str13;
        int iOptInt9;
        String str14;
        int iOptInt10;
        String str15;
        int iOptInt11;
        String str16;
        int iOptInt12;
        a8.a aVar2;
        SSLContext sSLContextA;
        s6.c cVar2 = this.f11091c;
        try {
            JSONObject jSONObjectD = dd.d(e8.b.f4712i);
            jSONObjectD.put("sname", String.valueOf(cVar2.f9529a));
            int i14 = cVar2.f9529a;
            Integer numValueOf = Integer.valueOf(i14);
            ArrayMap arrayMap = s6.d.A;
            jSONObjectD.put("sdkver", arrayMap.containsKey(numValueOf) ? (String) arrayMap.get(Integer.valueOf(i14)) : "");
            string = jSONObjectD.toString();
        } catch (Exception e) {
            z6.a.c(e.getMessage());
            string = "";
        }
        String str17 = cVar2.f9537k;
        if (str17 == null) {
            str17 = "";
        }
        String str18 = s6.d.f9538a;
        if (TextUtils.isEmpty(str17)) {
            string2 = s6.d.a(false) + s6.d.f;
        } else {
            StringBuilder sbS = o.d.s(str17);
            sbS.append(s6.d.f);
            string2 = sbS.toString();
        }
        long j12 = cVar2.f9532d;
        int i15 = cVar2.f9529a;
        HttpURLConnection httpURLConnection2 = null;
        o oVar3 = new o(-1, (Object) null);
        try {
            URL url = new URL(f8.c.a(string2, true));
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                try {
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        if (d0.f7650a == null && (sSLContextA = v6.a.a()) != null) {
                            d0.f7650a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = d0.f7650a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(v6.a.f10526a);
                        }
                    }
                    byte[] bytes = string.getBytes();
                    Pair pairI = m6.a.f().f7948a.i();
                    try {
                        byte[] bArr = (byte[]) pairI.second;
                        g gVar = bArr == null ? null : new g(bArr);
                        if (gVar != null) {
                            byte[] bytes2 = Base64.encodeToString(gVar.f(bytes), 2).getBytes();
                            httpURLConnection.setRequestProperty("index", String.valueOf(((Integer) pairI.first).intValue() + 1));
                            httpURLConnection.setRequestProperty("accept", "*/*");
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes2.length));
                            httpURLConnection.setRequestProperty("ver", String.valueOf(j12));
                            httpURLConnection.setRequestProperty("vn", "1");
                            httpURLConnection.setRequestProperty("app", String.valueOf(i15));
                            httpURLConnection.setRequestProperty("model", Build.MODEL);
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                            httpURLConnection.setConnectTimeout(30000);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            dataOutputStream.write(bytes2);
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            int responseCode = httpURLConnection.getResponseCode();
                            try {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("url", url);
                                jSONObject6.put("params", string);
                                jSONObject6.put("version", j12);
                                jSONObject6.put("code", responseCode);
                                z6.a.f("--> request config:%s", jSONObject6.toString());
                            } catch (Exception e4) {
                                z6.a.d("print request config exception:%s", e4.getMessage());
                            }
                            try {
                                if (responseCode == 200) {
                                    String strA = dd.a(httpURLConnection.getInputStream());
                                    oVar2 = TextUtils.equals("{}", strA) ? new o(1, (Object) null) : TextUtils.isEmpty(strA) ? new o(-1, (Object) null) : new o(0, new String(dd.m(Base64.decode(strA, 2)), StandardCharsets.UTF_8));
                                } else {
                                    oVar = new o(-1, dd.a(httpURLConnection.getErrorStream()));
                                    oVar2 = oVar;
                                }
                            } catch (Exception e10) {
                                e = e10;
                                oVar = new o(-1, e.getMessage());
                                if (httpURLConnection == null) {
                                    oVar3 = oVar;
                                }
                                i8 = oVar3.f4951a;
                                i9 = this.e;
                                if (i8 != 0) {
                                    if (i8 != 1) {
                                        cVar2.f9531c++;
                                    } else {
                                        z6.a.f("<-- appIdConfig:%s", "NOT_MODIFIED");
                                        cVar2.e = i9;
                                        cVar2.c(System.currentTimeMillis() + this.f11092d);
                                    }
                                    fVar = this;
                                    cVar = cVar2;
                                    z2 = false;
                                } else {
                                    String str19 = (String) oVar3.f4952b;
                                    z6.a.f("<-- appIdConfig:%s", str19);
                                    n6.a aVar3 = m6.a.f().f7948a;
                                    aVar3.getClass();
                                    str = "";
                                    str2 = "gpct";
                                    str3 = "upct";
                                    str4 = "num";
                                    str5 = "pr";
                                    str6 = "gmax";
                                    str7 = "stats";
                                    str8 = "frq";
                                    str9 = "ur";
                                    try {
                                        jSONObject = new JSONObject(str19);
                                        if (jSONObject.has("ver")) {
                                            cVar2.f9532d = jSONObject.getLong("ver");
                                        }
                                        if (jSONObject.has("url")) {
                                            cVar2.f9534h = jSONObject.getString("url");
                                        }
                                        if (jSONObject.has("interval")) {
                                            cVar2.f9535i = jSONObject.getInt("interval");
                                        }
                                        if (jSONObject.has("offline")) {
                                            cVar2.f9536j = jSONObject.getInt("offline");
                                        }
                                        if (jSONObject.has("url_config")) {
                                            cVar2.f9537k = jSONObject.getString("url_config");
                                        }
                                        zHas = jSONObject.has("data");
                                        copyOnWriteArrayList = cVar2.f;
                                        if (zHas) {
                                            jSONArray = jSONObject.getJSONArray("data");
                                            if (jSONArray.length() > 0) {
                                                jSONObject4 = jSONArray.getJSONObject(0).getJSONObject("cfg");
                                                i11 = 0;
                                                while (i11 < jSONArray.length()) {
                                                    jSONObject5 = jSONArray.getJSONObject(i11).getJSONObject("cfg");
                                                    jSONArray2 = jSONArray.getJSONObject(i11).getJSONArray("tids");
                                                    i12 = 0;
                                                    while (i12 < jSONArray2.length()) {
                                                        cVar = cVar2;
                                                        JSONObject jSONObject7 = jSONObject;
                                                        try {
                                                            j10 = jSONArray2.getLong(i12);
                                                            it = copyOnWriteArrayList.iterator();
                                                            while (true) {
                                                                if (it.hasNext()) {
                                                                    jSONArray3 = jSONArray;
                                                                    jSONArray4 = jSONArray2;
                                                                    i13 = i12;
                                                                    aVar = null;
                                                                    break;
                                                                }
                                                                jSONArray3 = jSONArray;
                                                                aVar = (s6.a) it.next();
                                                                jSONArray4 = jSONArray2;
                                                                i13 = i12;
                                                                if (aVar.f9513a == j10) {
                                                                    break;
                                                                }
                                                                jSONArray2 = jSONArray4;
                                                                jSONArray = jSONArray3;
                                                                i12 = i13;
                                                            }
                                                            if (aVar == null) {
                                                                aVar = new s6.a();
                                                                aVar.f9515c = new s6.b();
                                                                aVar.f9513a = j10;
                                                                copyOnWriteArrayList.add(aVar);
                                                            }
                                                            s6.b bVar = aVar.f9515c;
                                                            iOptInt = jSONObject4.optInt("cv", 0);
                                                            if (jSONObject5.has("cv")) {
                                                                iOptInt = jSONObject5.getInt("cv");
                                                            }
                                                            if (iOptInt > 0) {
                                                                j11 = ((long) iOptInt) * 60000;
                                                            } else {
                                                                j11 = iOptInt;
                                                            }
                                                            bVar.f9520d = j11;
                                                            iOptInt2 = jSONObject4.optInt("gmin", 0);
                                                            if (jSONObject5.has("gmin")) {
                                                                iOptInt2 = jSONObject5.getInt("gmin");
                                                            }
                                                            bVar.f = iOptInt2;
                                                            str10 = str6;
                                                            iOptInt3 = jSONObject4.optInt(str10, 100);
                                                            if (jSONObject5.has(str10)) {
                                                                iOptInt3 = jSONObject5.getInt(str10);
                                                            }
                                                            bVar.f9521g = iOptInt3;
                                                            iOptInt4 = jSONObject4.optInt(str4, 0);
                                                            if (jSONObject5.has(str4)) {
                                                                iOptInt4 = jSONObject5.getInt(str4);
                                                            }
                                                            bVar.f9524j = iOptInt4;
                                                            iOptInt5 = jSONObject4.optInt("s", 10);
                                                            if (jSONObject5.has("s")) {
                                                                iOptInt5 = jSONObject5.getInt("s");
                                                            }
                                                            str6 = str10;
                                                            bVar.f9526l = ((long) iOptInt5) * 60000;
                                                            iOptInt6 = jSONObject4.optInt("iw", 0);
                                                            if (jSONObject5.has("iw")) {
                                                                iOptInt6 = jSONObject5.getInt("iw");
                                                            }
                                                            bVar.e = iOptInt6;
                                                            str11 = str9;
                                                            iOptInt7 = jSONObject4.optInt(str11, 100);
                                                            if (jSONObject5.has(str11)) {
                                                                iOptInt7 = jSONObject5.getInt(str11);
                                                            }
                                                            bVar.f9518b = iOptInt7;
                                                            str12 = str8;
                                                            iOptInt8 = jSONObject4.optInt(str12, 0);
                                                            if (jSONObject5.has(str12)) {
                                                                iOptInt8 = jSONObject5.getInt(str12);
                                                            }
                                                            str9 = str11;
                                                            bVar.f9527m = ((long) (iOptInt8 * 60)) * 1000;
                                                            str13 = str7;
                                                            iOptInt9 = jSONObject4.optInt(str13, 0);
                                                            if (jSONObject5.has(str13)) {
                                                                iOptInt9 = jSONObject5.getInt(str13);
                                                            }
                                                            bVar.f9517a = iOptInt9;
                                                            str14 = str5;
                                                            iOptInt10 = jSONObject4.optInt(str14, 0);
                                                            if (jSONObject5.has(str14)) {
                                                                iOptInt10 = jSONObject5.getInt(str14);
                                                            }
                                                            bVar.f9528n = iOptInt10;
                                                            str15 = str3;
                                                            String str20 = str4;
                                                            iOptInt11 = jSONObject4.optInt(str15, 1);
                                                            if (jSONObject5.has(str15)) {
                                                                iOptInt11 = jSONObject5.getInt(str15);
                                                            }
                                                            bVar.f9519c = iOptInt11;
                                                            str16 = str2;
                                                            iOptInt12 = jSONObject4.optInt(str16, 1);
                                                            if (jSONObject5.has(str16)) {
                                                                iOptInt12 = jSONObject5.getInt(str16);
                                                            }
                                                            bVar.f9522h = iOptInt12;
                                                            str7 = str13;
                                                            str8 = str12;
                                                            str5 = str14;
                                                            cVar2 = cVar;
                                                            jSONObject = jSONObject7;
                                                            jSONArray2 = jSONArray4;
                                                            i12 = i13 + 1;
                                                            jSONArray = jSONArray3;
                                                            str2 = str16;
                                                            str4 = str20;
                                                            str3 = str15;
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            z2 = true;
                                                            z6.a.c(Log.getStackTraceString(e));
                                                            e8.d.a("updateAppConfig", e);
                                                            cVar.e = i9;
                                                            i10 = cVar.f9535i;
                                                            if (i10 > 0) {
                                                                fVar = this;
                                                                fVar.f11092d = ((long) i10) * 3600000;
                                                            } else {
                                                                fVar = this;
                                                            }
                                                            cVar.c(System.currentTimeMillis() + fVar.f11092d);
                                                            aVar2 = fVar.f11093h;
                                                            if (aVar2 != null) {
                                                                aVar2.d(cVar.f9529a, z2);
                                                            }
                                                        }
                                                    }
                                                    i11++;
                                                    cVar2 = cVar2;
                                                    jSONObject = jSONObject;
                                                    str2 = str2;
                                                    str4 = str4;
                                                    str3 = str3;
                                                }
                                            }
                                        }
                                        cVar = cVar2;
                                        z2 = true;
                                        jSONObject2 = jSONObject;
                                        try {
                                            if (jSONObject2.has("table")) {
                                                jSONObject3 = jSONObject2.getJSONObject("table");
                                                for (s6.a aVar4 : copyOnWriteArrayList) {
                                                    String str21 = str;
                                                    strOptString = jSONObject3.optString(String.valueOf(aVar4.f9513a), str21);
                                                    if (strOptString.length() > 0) {
                                                        aVar4.f9514b = strOptString;
                                                    }
                                                    str = str21;
                                                }
                                            }
                                            cVarC = ((i1.b) aVar3.f8123c).c(t6.d.f10184a);
                                            if (cVarC != null) {
                                                copyOnWriteArrayList2 = cVarC.f;
                                                if (dd.g(copyOnWriteArrayList2)) {
                                                    j8 = 0;
                                                } else {
                                                    j8 = ((s6.a) copyOnWriteArrayList2.get(0)).f9515c.f9526l;
                                                }
                                                if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                                                    j8 = 30000;
                                                }
                                                s6.d.f9551r = j8;
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            z6.a.c(Log.getStackTraceString(e));
                                            e8.d.a("updateAppConfig", e);
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                        cVar = cVar2;
                                    }
                                    cVar.e = i9;
                                    i10 = cVar.f9535i;
                                    if (i10 > 0) {
                                        fVar = this;
                                        fVar.f11092d = ((long) i10) * 3600000;
                                    } else {
                                        fVar = this;
                                    }
                                    cVar.c(System.currentTimeMillis() + fVar.f11092d);
                                }
                                aVar2 = fVar.f11093h;
                                if (aVar2 != null) {
                                    aVar2.d(cVar.f9529a, z2);
                                }
                            }
                            httpURLConnection.disconnect();
                            oVar3 = oVar2;
                        } else if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Exception e14) {
                        e = e14;
                    }
                } catch (Exception e15) {
                    e = e15;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e16) {
            e = e16;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
        }
        i8 = oVar3.f4951a;
        i9 = this.e;
        if (i8 != 0) {
            if (i8 != 1) {
                cVar2.f9531c++;
            } else {
                z6.a.f("<-- appIdConfig:%s", "NOT_MODIFIED");
                cVar2.e = i9;
                cVar2.c(System.currentTimeMillis() + this.f11092d);
            }
            fVar = this;
            cVar = cVar2;
            z2 = false;
        } else {
            String str110 = (String) oVar3.f4952b;
            z6.a.f("<-- appIdConfig:%s", str110);
            n6.a aVar5 = m6.a.f().f7948a;
            aVar5.getClass();
            str = "";
            str2 = "gpct";
            str3 = "upct";
            str4 = "num";
            str5 = "pr";
            str6 = "gmax";
            str7 = "stats";
            str8 = "frq";
            str9 = "ur";
            jSONObject = new JSONObject(str110);
            if (jSONObject.has("ver")) {
                cVar2.f9532d = jSONObject.getLong("ver");
            }
            if (jSONObject.has("url")) {
                cVar2.f9534h = jSONObject.getString("url");
            }
            if (jSONObject.has("interval")) {
                cVar2.f9535i = jSONObject.getInt("interval");
            }
            if (jSONObject.has("offline")) {
                cVar2.f9536j = jSONObject.getInt("offline");
            }
            if (jSONObject.has("url_config")) {
                cVar2.f9537k = jSONObject.getString("url_config");
            }
            zHas = jSONObject.has("data");
            copyOnWriteArrayList = cVar2.f;
            if (zHas) {
                jSONArray = jSONObject.getJSONArray("data");
                if (jSONArray.length() > 0) {
                    jSONObject4 = jSONArray.getJSONObject(0).getJSONObject("cfg");
                    i11 = 0;
                    while (i11 < jSONArray.length()) {
                        jSONObject5 = jSONArray.getJSONObject(i11).getJSONObject("cfg");
                        jSONArray2 = jSONArray.getJSONObject(i11).getJSONArray("tids");
                        i12 = 0;
                        while (i12 < jSONArray2.length()) {
                            cVar = cVar2;
                            JSONObject jSONObject8 = jSONObject;
                            j10 = jSONArray2.getLong(i12);
                            it = copyOnWriteArrayList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    jSONArray3 = jSONArray;
                                    jSONArray4 = jSONArray2;
                                    i13 = i12;
                                    aVar = null;
                                    break;
                                }
                                jSONArray3 = jSONArray;
                                aVar = (s6.a) it.next();
                                jSONArray4 = jSONArray2;
                                i13 = i12;
                                if (aVar.f9513a == j10) {
                                    break;
                                    break;
                                } else {
                                    jSONArray2 = jSONArray4;
                                    jSONArray = jSONArray3;
                                    i12 = i13;
                                }
                            }
                            if (aVar == null) {
                                aVar = new s6.a();
                                aVar.f9515c = new s6.b();
                                aVar.f9513a = j10;
                                copyOnWriteArrayList.add(aVar);
                            }
                            s6.b bVar2 = aVar.f9515c;
                            iOptInt = jSONObject4.optInt("cv", 0);
                            if (jSONObject5.has("cv")) {
                                iOptInt = jSONObject5.getInt("cv");
                            }
                            if (iOptInt > 0) {
                                j11 = ((long) iOptInt) * 60000;
                            } else {
                                j11 = iOptInt;
                            }
                            bVar2.f9520d = j11;
                            iOptInt2 = jSONObject4.optInt("gmin", 0);
                            if (jSONObject5.has("gmin")) {
                                iOptInt2 = jSONObject5.getInt("gmin");
                            }
                            bVar2.f = iOptInt2;
                            str10 = str6;
                            iOptInt3 = jSONObject4.optInt(str10, 100);
                            if (jSONObject5.has(str10)) {
                                iOptInt3 = jSONObject5.getInt(str10);
                            }
                            bVar2.f9521g = iOptInt3;
                            iOptInt4 = jSONObject4.optInt(str4, 0);
                            if (jSONObject5.has(str4)) {
                                iOptInt4 = jSONObject5.getInt(str4);
                            }
                            bVar2.f9524j = iOptInt4;
                            iOptInt5 = jSONObject4.optInt("s", 10);
                            if (jSONObject5.has("s")) {
                                iOptInt5 = jSONObject5.getInt("s");
                            }
                            str6 = str10;
                            bVar2.f9526l = ((long) iOptInt5) * 60000;
                            iOptInt6 = jSONObject4.optInt("iw", 0);
                            if (jSONObject5.has("iw")) {
                                iOptInt6 = jSONObject5.getInt("iw");
                            }
                            bVar2.e = iOptInt6;
                            str11 = str9;
                            iOptInt7 = jSONObject4.optInt(str11, 100);
                            if (jSONObject5.has(str11)) {
                                iOptInt7 = jSONObject5.getInt(str11);
                            }
                            bVar2.f9518b = iOptInt7;
                            str12 = str8;
                            iOptInt8 = jSONObject4.optInt(str12, 0);
                            if (jSONObject5.has(str12)) {
                                iOptInt8 = jSONObject5.getInt(str12);
                            }
                            str9 = str11;
                            bVar2.f9527m = ((long) (iOptInt8 * 60)) * 1000;
                            str13 = str7;
                            iOptInt9 = jSONObject4.optInt(str13, 0);
                            if (jSONObject5.has(str13)) {
                                iOptInt9 = jSONObject5.getInt(str13);
                            }
                            bVar2.f9517a = iOptInt9;
                            str14 = str5;
                            iOptInt10 = jSONObject4.optInt(str14, 0);
                            if (jSONObject5.has(str14)) {
                                iOptInt10 = jSONObject5.getInt(str14);
                            }
                            bVar2.f9528n = iOptInt10;
                            str15 = str3;
                            String str22 = str4;
                            iOptInt11 = jSONObject4.optInt(str15, 1);
                            if (jSONObject5.has(str15)) {
                                iOptInt11 = jSONObject5.getInt(str15);
                            }
                            bVar2.f9519c = iOptInt11;
                            str16 = str2;
                            iOptInt12 = jSONObject4.optInt(str16, 1);
                            if (jSONObject5.has(str16)) {
                                iOptInt12 = jSONObject5.getInt(str16);
                            }
                            bVar2.f9522h = iOptInt12;
                            str7 = str13;
                            str8 = str12;
                            str5 = str14;
                            cVar2 = cVar;
                            jSONObject = jSONObject8;
                            jSONArray2 = jSONArray4;
                            i12 = i13 + 1;
                            jSONArray = jSONArray3;
                            str2 = str16;
                            str4 = str22;
                            str3 = str15;
                        }
                        i11++;
                        cVar2 = cVar2;
                        jSONObject = jSONObject;
                        str2 = str2;
                        str4 = str4;
                        str3 = str3;
                    }
                }
            }
            cVar = cVar2;
            z2 = true;
            jSONObject2 = jSONObject;
            if (jSONObject2.has("table")) {
                jSONObject3 = jSONObject2.getJSONObject("table");
                while (r1.hasNext()) {
                    String str23 = str;
                    strOptString = jSONObject3.optString(String.valueOf(aVar4.f9513a), str23);
                    if (strOptString.length() > 0) {
                        aVar4.f9514b = strOptString;
                    }
                    str = str23;
                }
            }
            cVarC = ((i1.b) aVar5.f8123c).c(t6.d.f10184a);
            if (cVarC != null) {
                copyOnWriteArrayList2 = cVarC.f;
                if (dd.g(copyOnWriteArrayList2)) {
                    j8 = 0;
                } else {
                    j8 = ((s6.a) copyOnWriteArrayList2.get(0)).f9515c.f9526l;
                }
                if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    j8 = 30000;
                }
                s6.d.f9551r = j8;
            }
            cVar.e = i9;
            i10 = cVar.f9535i;
            if (i10 > 0) {
                fVar = this;
                fVar.f11092d = ((long) i10) * 3600000;
            } else {
                fVar = this;
            }
            cVar.c(System.currentTimeMillis() + fVar.f11092d);
        }
        aVar2 = fVar.f11093h;
        if (aVar2 != null) {
            aVar2.d(cVar.f9529a, z2);
        }
    }

    @Override // y6.d
    public final String c() {
        return h0.a.m(new StringBuilder("Retrieve-"), "-Config", this.f11091c.f9529a);
    }
}
