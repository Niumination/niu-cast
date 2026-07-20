package cn;

import in.f;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kn.l0;
import kn.r1;
import os.l;
import os.m;
import rn.b;

/* JADX INFO: loaded from: classes3.dex */
public class a extends bn.a {

    /* JADX INFO: renamed from: cn.a$a, reason: collision with other inner class name */
    @r1({"SMAP\nJDK8PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK8PlatformImplementations.kt\nkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    public static final class C0071a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final C0071a f1679a = new C0071a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m
        @f
        public static final Integer f1680b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f1680b = num2;
        }
    }

    @Override // an.l
    @l
    public rn.f b() {
        return e(34) ? new sn.a() : new b();
    }

    @Override // an.l
    @m
    public jq.m c(@l MatchResult matchResult, @l String str) {
        l0.p(matchResult, "matchResult");
        l0.p(str, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        tn.l lVar = new tn.l(matcher.start(str), matcher.end(str) - 1, 1);
        if (lVar.f15911a < 0) {
            return null;
        }
        String strGroup = matcher.group(str);
        l0.o(strGroup, "group(...)");
        return new jq.m(strGroup, lVar);
    }

    public final boolean e(int i10) {
        Integer num = C0071a.f1680b;
        return num == null || num.intValue() >= i10;
    }
}
