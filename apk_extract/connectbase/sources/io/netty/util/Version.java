package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import l.a;
import n1.e;

/* JADX INFO: loaded from: classes3.dex */
public final class Version {
    private static final String PROP_BUILD_DATE = ".buildDate";
    private static final String PROP_COMMIT_DATE = ".commitDate";
    private static final String PROP_LONG_COMMIT_HASH = ".longCommitHash";
    private static final String PROP_REPO_STATUS = ".repoStatus";
    private static final String PROP_SHORT_COMMIT_HASH = ".shortCommitHash";
    private static final String PROP_VERSION = ".version";
    private final String artifactId;
    private final String artifactVersion;
    private final long buildTimeMillis;
    private final long commitTimeMillis;
    private final String longCommitHash;
    private final String repositoryStatus;
    private final String shortCommitHash;

    private Version(String str, String str2, long j10, long j11, String str3, String str4, String str5) {
        this.artifactId = str;
        this.artifactVersion = str2;
        this.buildTimeMillis = j10;
        this.commitTimeMillis = j11;
        this.shortCommitHash = str3;
        this.longCommitHash = str4;
        this.repositoryStatus = str5;
    }

    public static Map<String, Version> identify() {
        return identify(null);
    }

    public static void main(String[] strArr) {
        Iterator<Version> it = identify().values().iterator();
        while (it.hasNext()) {
            System.err.println(it.next());
        }
    }

    private static long parseIso8601(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").parse(str).getTime();
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public String artifactId() {
        return this.artifactId;
    }

    public String artifactVersion() {
        return this.artifactVersion;
    }

    public long buildTimeMillis() {
        return this.buildTimeMillis;
    }

    public long commitTimeMillis() {
        return this.commitTimeMillis;
    }

    public String longCommitHash() {
        return this.longCommitHash;
    }

    public String repositoryStatus() {
        return this.repositoryStatus;
    }

    public String shortCommitHash() {
        return this.shortCommitHash;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.artifactId);
        sb2.append('-');
        sb2.append(this.artifactVersion);
        sb2.append(e.f11183c);
        sb2.append(this.shortCommitHash);
        sb2.append("clean".equals(this.repositoryStatus) ? "" : a.a(new StringBuilder(" (repository: "), this.repositoryStatus, ')'));
        return sb2.toString();
    }

    public static Map<String, Version> identify(ClassLoader classLoader) {
        ClassLoader contextClassLoader = classLoader == null ? PlatformDependent.getContextClassLoader() : classLoader;
        Properties properties = new Properties();
        try {
            Enumeration<URL> resources = contextClassLoader.getResources("META-INF/io.netty.versions.properties");
            while (resources.hasMoreElements()) {
                InputStream inputStreamOpenStream = resources.nextElement().openStream();
                try {
                    properties.load(inputStreamOpenStream);
                    try {
                        inputStreamOpenStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Throwable th2) {
                    try {
                        inputStreamOpenStream.close();
                        throw th2;
                    } catch (Exception unused2) {
                        throw th2;
                    }
                }
            }
        } catch (Exception unused3) {
        }
        HashSet hashSet = new HashSet();
        for (String str : properties.keySet()) {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf > 0) {
                String strSubstring = str.substring(0, iIndexOf);
                if (properties.containsKey(strSubstring + PROP_VERSION)) {
                    if (properties.containsKey(strSubstring + PROP_BUILD_DATE)) {
                        if (properties.containsKey(strSubstring + PROP_COMMIT_DATE)) {
                            if (properties.containsKey(strSubstring + PROP_SHORT_COMMIT_HASH)) {
                                if (properties.containsKey(strSubstring + PROP_LONG_COMMIT_HASH)) {
                                    if (properties.containsKey(strSubstring + PROP_REPO_STATUS)) {
                                        hashSet.add(strSubstring);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        TreeMap treeMap = new TreeMap();
        for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
            String str2 = (String) it.next();
            treeMap.put(str2, new Version(str2, properties.getProperty(str2 + PROP_VERSION), parseIso8601(properties.getProperty(str2 + PROP_BUILD_DATE)), parseIso8601(properties.getProperty(str2 + PROP_COMMIT_DATE)), properties.getProperty(str2 + PROP_SHORT_COMMIT_HASH), properties.getProperty(str2 + PROP_LONG_COMMIT_HASH), properties.getProperty(str2 + PROP_REPO_STATUS)));
        }
        return treeMap;
    }
}
