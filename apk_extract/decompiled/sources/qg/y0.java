package qg;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import se.v2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9126a;

    public /* synthetic */ y0(int i8) {
        this.f9126a = i8;
    }

    /* JADX WARN: Type inference failed for: r1v23, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String string;
        String string2;
        String value;
        String value2;
        String str = "";
        int i8 = 0;
        xg.f0 f0Var = null;
        switch (this.f9126a) {
            case 0:
                mg.z createApplicationPlugin = (mg.z) obj;
                Intrinsics.checkNotNullParameter(createApplicationPlugin, "$this$createApplicationPlugin");
                b1 b1Var = (b1) ((mg.k) createApplicationPlugin).f8070h;
                createApplicationPlugin.a(new a1(new g1(b1Var.f9067a, b1Var.f9068b), null));
                return Unit.INSTANCE;
            case 1:
                Intrinsics.checkNotNullParameter((mg.b) obj, "<this>");
                return 0;
            case 2:
                KFunction it = (KFunction) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!it.getParameters().isEmpty() && rg.a.c(it.getParameters().get(0)));
            case 3:
                KFunction it2 = (KFunction) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                List<KParameter> parameters = it2.getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it3 = parameters.iterator();
                    while (it3.hasNext()) {
                        if (!((KParameter) it3.next()).isOptional() && (i8 = i8 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                return Integer.valueOf(i8);
            case 4:
                KFunction it4 = (KFunction) obj;
                Intrinsics.checkNotNullParameter(it4, "it");
                return Integer.valueOf(it4.getParameters().size());
            case 5:
                nf.f engine = (nf.f) obj;
                Intrinsics.checkNotNullParameter(engine, "$this$engine");
                engine.f8216c = 10;
                engine.f8217d = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
                return Unit.INSTANCE;
            case 6:
                sf.g install = (sf.g) obj;
                Intrinsics.checkNotNullParameter(install, "$this$install");
                v2 block = new v2(null);
                install.getClass();
                Intrinsics.checkNotNullParameter(block, "block");
                install.f10095a = block;
                return Unit.INSTANCE;
            case 7:
                uf.j install2 = (uf.j) obj;
                Intrinsics.checkNotNullParameter(install2, "$this$install");
                Duration.Companion companion = Duration.INSTANCE;
                install2.f10432b = Duration.m1509getInWholeMillisecondsimpl(DurationKt.toDuration(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH, DurationUnit.MILLISECONDS));
                return Unit.INSTANCE;
            case 8:
                yg.p pVar = (yg.p) obj;
                pVar.f11213b = WorkRequest.MIN_BACKOFF_MILLIS;
                pVar.f11214c = WorkRequest.MIN_BACKOFF_MILLIS;
                return Unit.INSTANCE;
            case 9:
                InetAddress it5 = (InetAddress) obj;
                Intrinsics.checkNotNullParameter(it5, "it");
                String hostAddress = it5.getHostAddress();
                return (hostAddress == null || (string = hostAddress.toString()) == null) ? "" : string;
            case 10:
                InetAddress it6 = (InetAddress) obj;
                Intrinsics.checkNotNullParameter(it6, "it");
                String hostAddress2 = it6.getHostAddress();
                return (hostAddress2 == null || (string2 = hostAddress2.toString()) == null) ? "" : string2;
            case 11:
                qf.b createClientPlugin = (qf.b) obj;
                Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
                createClientPlugin.a(sf.c.f10090a, new sf.j(null, createClientPlugin, ((sf.g) createClientPlugin.f9043b).f10095a, null));
                return Unit.INSTANCE;
            case 12:
                Intrinsics.checkNotNullParameter((vf.c) obj, "<this>");
                return Unit.INSTANCE;
            case 13:
                Intrinsics.checkNotNullParameter((zf.j0) obj, "<this>");
                return Unit.INSTANCE;
            case 14:
                ((Boolean) obj).booleanValue();
                return Unit.INSTANCE;
            case 15:
                String it7 = (String) obj;
                Intrinsics.checkNotNullParameter(it7, "it");
                return it7;
            case 16:
                Byte b9 = (Byte) obj;
                b9.byteValue();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                return o.d.q(new Object[]{b9}, 1, "%02x", "format(...)");
            case 17:
                mg.z createApplicationPlugin2 = (mg.z) obj;
                Intrinsics.checkNotNullParameter(createApplicationPlugin2, "$this$createApplicationPlugin");
                createApplicationPlugin2.a(new xg.c(null));
                return Unit.INSTANCE;
            case 18:
                xg.w it8 = (xg.w) obj;
                Intrinsics.checkNotNullParameter(it8, "it");
                return it8.f10994a;
            case 19:
                String it9 = (String) obj;
                Intrinsics.checkNotNullParameter(it9, "it");
                return Boolean.valueOf(it9.length() > 0);
            case 20:
                String segment = (String) obj;
                Intrinsics.checkNotNullParameter(segment, "segment");
                return (StringsKt__StringsKt.contains$default((CharSequence) segment, '{', false, 2, (Object) null) && StringsKt__StringsKt.contains$default((CharSequence) segment, '}', false, 2, (Object) null)) ? new xg.w(segment, xg.x.Parameter) : new xg.w(zf.d.c(segment, 0, 0, 7), xg.x.Constant);
            case 21:
                List path = (List) obj;
                Intrinsics.checkNotNullParameter(path, "path");
                return CollectionsKt___CollectionsKt.joinToString$default(path, " -> ", "  ", null, 0, null, new y0(22), 28, null);
            case 22:
                xg.e0 it10 = (xg.e0) obj;
                Intrinsics.checkNotNullParameter(it10, "it");
                return "\"" + it10.f10943a.f10989r + Typography.quote;
            case 23:
                xg.g0 it11 = (xg.g0) obj;
                Intrinsics.checkNotNullParameter(it11, "it");
                vj.b bVar = xg.o0.f10980b;
                if (bVar.isTraceEnabled()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(it11.toString());
                    Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                    sb2.append('\n');
                    Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                    xg.h0 h0Var = it11.f10949c;
                    if (h0Var != null) {
                        h0Var.a(0, sb2);
                    }
                    if (it11.f10950d != null) {
                        sb2.append("Matched routes:");
                        Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                        sb2.append('\n');
                        Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                        ArrayList arrayList = it11.e;
                        if (arrayList.isEmpty()) {
                            sb2.append("  No results");
                            Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                            sb2.append('\n');
                            Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                        } else {
                            sb2.append(CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, new y0(21), 30, null));
                            Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                            sb2.append('\n');
                            Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                        }
                        sb2.append("Routing resolve result:");
                        Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                        sb2.append('\n');
                        Intrinsics.checkNotNullExpressionValue(sb2, "append(...)");
                        StringBuilder sb3 = new StringBuilder("  ");
                        xg.f0 f0Var2 = it11.f10950d;
                        if (f0Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("finalResult");
                        } else {
                            f0Var = f0Var2;
                        }
                        sb3.append(f0Var);
                        sb2.append(sb3.toString());
                    }
                    String string3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                    bVar.trace(string3);
                }
                return Unit.INSTANCE;
            case 24:
                Intrinsics.checkNotNullParameter((yf.a) obj, "it");
                return new fh.a();
            case 25:
                za.b.e.postValue((Boolean) obj);
                return Unit.INSTANCE;
            case 26:
                za.b.f11268a.postValue((Boolean) obj);
                return Unit.INSTANCE;
            case 27:
                za.b.f11270c.postValue((Boolean) obj);
                return Unit.INSTANCE;
            case 28:
                MatchResult it12 = (MatchResult) obj;
                Intrinsics.checkNotNullParameter(it12, "it");
                MatchGroup matchGroup = it12.getGroups().get(2);
                if (matchGroup == null || (value = matchGroup.getValue()) == null) {
                    value = "";
                }
                MatchGroup matchGroup2 = it12.getGroups().get(4);
                if (matchGroup2 != null && (value2 = matchGroup2.getValue()) != null) {
                    str = value2;
                }
                return TuplesKt.to(value, str);
            default:
                Pair cookie = (Pair) obj;
                Intrinsics.checkNotNullParameter(cookie, "cookie");
                return (StringsKt__StringsJVMKt.startsWith$default((String) cookie.getSecond(), "\"", false, 2, null) && StringsKt__StringsJVMKt.endsWith$default((String) cookie.getSecond(), "\"", false, 2, null)) ? Pair.copy$default(cookie, null, StringsKt__StringsKt.removeSurrounding((String) cookie.getSecond(), (CharSequence) "\""), 1, null) : cookie;
        }
    }
}
