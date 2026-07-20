package yk;

import fl.h1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.n0;
import lm.l2;
import lm.t0;
import nm.c1;
import nm.d1;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    public static final class a extends n0 implements jn.l<c, l2> {
        final /* synthetic */ ps.a $appLog;
        final /* synthetic */ Map<String, String> $argsMap;
        final /* synthetic */ sj.a $combinedConfig;
        final /* synthetic */ String $developmentModeKey;
        final /* synthetic */ String $hostConfigPath;
        final /* synthetic */ String $hostPortPath;
        final /* synthetic */ String $hostSslKeyAlias;
        final /* synthetic */ String $hostSslKeyStore;
        final /* synthetic */ String $hostSslKeyStorePassword;
        final /* synthetic */ String $hostSslPortPath;
        final /* synthetic */ String $hostSslPrivateKeyPassword;
        final /* synthetic */ String $hostWatchPaths;
        final /* synthetic */ URL $jar;
        final /* synthetic */ String $rootPath;

        /* JADX INFO: renamed from: yk.p$a$a, reason: collision with other inner class name */
        public static final class C0547a extends n0 implements jn.a<char[]> {
            final /* synthetic */ String $sslKeyStorePassword;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0547a(String str) {
                super(0);
                this.$sslKeyStorePassword = str;
            }

            @Override // jn.a
            @os.l
            public final char[] invoke() {
                char[] charArray = this.$sslKeyStorePassword.toCharArray();
                l0.o(charArray, "this as java.lang.String).toCharArray()");
                return charArray;
            }
        }

        public static final class b extends n0 implements jn.a<char[]> {
            final /* synthetic */ String $sslPrivateKeyPassword;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(0);
                this.$sslPrivateKeyPassword = str;
            }

            @Override // jn.a
            @os.l
            public final char[] invoke() {
                char[] charArray = this.$sslPrivateKeyPassword.toCharArray();
                l0.o(charArray, "this as java.lang.String).toCharArray()");
                return charArray;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ps.a aVar, URL url, sj.a aVar2, String str, Map<String, String> map, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            super(1);
            this.$appLog = aVar;
            this.$jar = url;
            this.$combinedConfig = aVar2;
            this.$rootPath = str;
            this.$argsMap = map;
            this.$hostConfigPath = str2;
            this.$hostPortPath = str3;
            this.$hostSslPortPath = str4;
            this.$hostSslKeyStore = str5;
            this.$hostSslKeyStorePassword = str6;
            this.$hostSslPrivateKeyPassword = str7;
            this.$hostSslKeyAlias = str8;
            this.$developmentModeKey = str9;
            this.$hostWatchPaths = str10;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(c cVar) throws IllegalAccessException, IOException, KeyStoreException, InvocationTargetException {
            invoke2(cVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l c cVar) throws IllegalAccessException, IOException, KeyStoreException, InvocationTargetException {
            boolean zBooleanValue;
            l0.p(cVar, "$this$applicationEngineEnvironment");
            ps.a aVar = this.$appLog;
            l0.o(aVar, "appLog");
            cVar.o(aVar);
            URL url = this.$jar;
            ClassLoader uRLClassLoader = url == null ? null : new URLClassLoader(new URL[]{url}, dk.e.class.getClassLoader());
            if (uRLClassLoader == null) {
                uRLClassLoader = dk.e.class.getClassLoader();
                l0.o(uRLClassLoader, "ApplicationEnvironment::class.java.classLoader");
            }
            cVar.l(uRLClassLoader);
            sj.a aVar2 = this.$combinedConfig;
            l0.o(aVar2, "combinedConfig");
            cVar.m(new ek.d(aVar2));
            cVar.q(this.$rootPath);
            sj.x xVarR = tj.m.r("***", "Content hidden");
            if (this.$combinedConfig.hasPath("ktor")) {
                cVar.f21373d.trace(this.$combinedConfig.getObject("ktor").withoutKey("security").withValue("security", xVarR).render());
            } else {
                cVar.f21373d.trace("No configuration provided: neither application.conf nor system properties nor command line options (-config or -P:ktor...=) provided");
            }
            String strA = this.$argsMap.get("-host");
            if (strA == null) {
                sj.a aVar3 = this.$combinedConfig;
                l0.o(aVar3, "combinedConfig");
                strA = ek.e.a(aVar3, this.$hostConfigPath);
                if (strA == null) {
                    strA = "0.0.0.0";
                }
            }
            String strA2 = this.$argsMap.get("-port");
            if (strA2 == null) {
                sj.a aVar4 = this.$combinedConfig;
                l0.o(aVar4, "combinedConfig");
                strA2 = ek.e.a(aVar4, this.$hostPortPath);
            }
            String strA3 = this.$argsMap.get("-sslPort");
            if (strA3 == null) {
                sj.a aVar5 = this.$combinedConfig;
                l0.o(aVar5, "combinedConfig");
                strA3 = ek.e.a(aVar5, this.$hostSslPortPath);
            }
            String strA4 = this.$argsMap.get("-sslKeyStore");
            if (strA4 == null) {
                sj.a aVar6 = this.$combinedConfig;
                l0.o(aVar6, "combinedConfig");
                strA4 = ek.e.a(aVar6, this.$hostSslKeyStore);
            }
            sj.a aVar7 = this.$combinedConfig;
            l0.o(aVar7, "combinedConfig");
            String strA5 = ek.e.a(aVar7, this.$hostSslKeyStorePassword);
            String string = strA5 == null ? null : jq.h0.C5(strA5).toString();
            sj.a aVar8 = this.$combinedConfig;
            l0.o(aVar8, "combinedConfig");
            String strA6 = ek.e.a(aVar8, this.$hostSslPrivateKeyPassword);
            String string2 = strA6 == null ? null : jq.h0.C5(strA6).toString();
            sj.a aVar9 = this.$combinedConfig;
            l0.o(aVar9, "combinedConfig");
            String strA7 = ek.e.a(aVar9, this.$hostSslKeyAlias);
            if (strA7 == null) {
                strA7 = "mykey";
            }
            sj.a aVar10 = this.$combinedConfig;
            l0.o(aVar10, "combinedConfig");
            String strA8 = ek.e.a(aVar10, this.$developmentModeKey);
            Boolean boolValueOf = strA8 == null ? null : Boolean.valueOf(Boolean.parseBoolean(strA8));
            if (boolValueOf == null) {
                h1.f6045a.getClass();
                zBooleanValue = h1.f6050f;
            } else {
                zBooleanValue = boolValueOf.booleanValue();
            }
            cVar.f21378i = zBooleanValue;
            if (strA2 != null) {
                List<x> list = cVar.f21375f;
                w wVar = new w(null, 1, null);
                wVar.h(strA);
                wVar.f21436c = Integer.parseInt(strA2);
                list.add(wVar);
            }
            if (strA3 != null) {
                if (strA4 == null) {
                    throw new IllegalArgumentException(j.c.a(new StringBuilder("SSL requires keystore: use -sslKeyStore=path or "), this.$hostSslKeyStore, " config"));
                }
                if (string == null) {
                    throw new IllegalArgumentException(j.c.a(new StringBuilder("SSL requires keystore password: use "), this.$hostSslKeyStorePassword, " config"));
                }
                if (string2 == null) {
                    throw new IllegalArgumentException(j.c.a(new StringBuilder("SSL requires certificate password: use "), this.$hostSslPrivateKeyPassword, " config"));
                }
                File file = new File(strA4);
                if (!file.exists() && !file.isAbsolute()) {
                    file = new File(".", strA4).getAbsoluteFile();
                }
                KeyStore keyStore = KeyStore.getInstance("JKS");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    char[] charArray = string.toCharArray();
                    l0.o(charArray, "this as java.lang.String).toCharArray()");
                    keyStore.load(fileInputStream, charArray);
                    l2 l2Var = l2.f10208a;
                    dn.c.a(fileInputStream, null);
                    char[] charArray2 = string2.toCharArray();
                    l0.o(charArray2, "this as java.lang.String).toCharArray()");
                    if (keyStore.getKey(strA7, charArray2) == null) {
                        throw new IllegalArgumentException(("The specified key " + strA7 + " doesn't exist in the key store " + ((Object) strA4)).toString());
                    }
                    l0.o(keyStore, "keyStore");
                    C0547a c0547a = new C0547a(string);
                    b bVar = new b(string2);
                    List<x> list2 = cVar.f21375f;
                    b0 b0Var = new b0(keyStore, strA7, c0547a, bVar);
                    b0Var.h(strA);
                    b0Var.f21436c = Integer.parseInt(strA3);
                    b0Var.f21369h = file;
                    list2.add(b0Var);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        dn.c.a(fileInputStream, th2);
                        throw th3;
                    }
                }
            }
            if (strA2 == null && strA3 == null) {
                throw new IllegalArgumentException("Neither port nor sslPort specified. Use command line options -port/-sslPort or configure connectors in application.conf");
            }
            String str = this.$argsMap.get("-watch");
            List<String> listR4 = str != null ? jq.h0.R4(str, new String[]{ks.g.f9491d}, false, 0, 6, null) : null;
            if (listR4 == null) {
                sj.a aVar11 = this.$combinedConfig;
                l0.o(aVar11, "combinedConfig");
                listR4 = ek.e.b(aVar11, this.$hostWatchPaths);
            }
            if (listR4 == null) {
                return;
            }
            cVar.r(listR4);
        }
    }

    @os.l
    public static final b a(@os.l String[] strArr) {
        l0.p(strArr, d6.a.F);
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            t0<String, String> t0VarC = c(str, fl.h.f6043c);
            if (t0VarC != null) {
                arrayList.add(t0VarC);
            }
        }
        Map mapD0 = d1.D0(arrayList);
        String str2 = (String) mapD0.get("-jar");
        URL url = str2 == null ? null : (jq.e0.s2(str2, "file:", false, 2, null) || jq.e0.s2(str2, "jrt:", false, 2, null) || jq.e0.s2(str2, "jar:", false, 2, null)) ? new URI(str2).toURL() : new File(str2).toURI().toURL();
        String str3 = (String) mapD0.get("-config");
        File file = str3 == null ? null : new File(str3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapD0.entrySet()) {
            if (jq.e0.s2((String) entry.getKey(), "-P:", false, 2, null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(c1.j(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(jq.h0.a4((String) entry2.getKey(), "-P:"), entry2.getValue());
        }
        sj.a aVarWithOnlyPath = tj.m.I().withOnlyPath("ktor");
        sj.a aVarI = file != null ? sj.d.I(file) : null;
        if (aVarI == null) {
            aVarI = sj.d.q();
        }
        sj.a aVarResolve = sj.d.N(linkedHashMap2, "Command-line options").withFallback((sj.m) aVarI).withFallback((sj.m) aVarWithOnlyPath).resolve();
        l0.o(aVarResolve, "combinedConfig");
        String strA = ek.e.a(aVarResolve, "ktor.application.id");
        if (strA == null) {
            strA = "Application";
        }
        ps.a aVarJ = ps.b.j(strA);
        if (file != null && !file.exists()) {
            aVarJ.error("Configuration file '" + file + "' specified as command line argument was not found");
            aVarJ.warn("Will attempt to start without loading configuration…");
        }
        String strA2 = (String) mapD0.get("-path");
        if (strA2 == null && (strA2 = ek.e.a(aVarResolve, "ktor.deployment.rootPath")) == null) {
            strA2 = "";
        }
        return d.a(new a(aVarJ, url, aVarResolve, strA2, mapD0, "ktor.deployment.host", "ktor.deployment.port", "ktor.deployment.sslPort", "ktor.security.ssl.keyStore", "ktor.security.ssl.keyStorePassword", "ktor.security.ssl.privateKeyPassword", "ktor.security.ssl.keyAlias", "ktor.development", "ktor.deployment.watch"));
    }

    public static final void b(@os.l i.c cVar, @os.l ek.a aVar) {
        String string;
        String string2;
        String string3;
        l0.p(cVar, "<this>");
        l0.p(aVar, "deploymentConfig");
        ek.b bVarC = aVar.c("callGroupSize");
        if (bVarC != null && (string3 = bVarC.getString()) != null) {
            cVar.f21358d = Integer.parseInt(string3);
        }
        ek.b bVarC2 = aVar.c("connectionGroupSize");
        if (bVarC2 != null && (string2 = bVarC2.getString()) != null) {
            cVar.f21356b = Integer.parseInt(string2);
        }
        ek.b bVarC3 = aVar.c("workerGroupSize");
        if (bVarC3 == null || (string = bVarC3.getString()) == null) {
            return;
        }
        cVar.f21357c = Integer.parseInt(string);
    }

    public static final t0<String, String> c(String str, char c10) {
        int iO3 = jq.h0.o3(str, c10, 0, false, 6, null);
        if (iO3 == -1) {
            return null;
        }
        return new t0<>(jq.j0.V8(str, iO3), jq.j0.y6(str, iO3 + 1));
    }
}
