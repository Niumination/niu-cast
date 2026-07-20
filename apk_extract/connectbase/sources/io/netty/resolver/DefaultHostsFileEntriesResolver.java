package io.netty.resolver;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultHostsFileEntriesResolver implements HostsFileEntriesResolver {
    private static final long DEFAULT_REFRESH_INTERVAL;
    private static final InternalLogger logger;
    private final HostsFileEntriesProvider.Parser hostsFileParser;
    private volatile Map<String, List<InetAddress>> inet4Entries;
    private volatile Map<String, List<InetAddress>> inet6Entries;
    private final AtomicLong lastRefresh;
    private final long refreshInterval;

    /* JADX INFO: renamed from: io.netty.resolver.DefaultHostsFileEntriesResolver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] iArr = new int[ResolvedAddressTypes.values().length];
            $SwitchMap$io$netty$resolver$ResolvedAddressTypes = iArr;
            try {
                iArr[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) DefaultHostsFileEntriesResolver.class);
        logger = internalLoggerFactory;
        long j10 = SystemPropertyUtil.getLong("io.netty.hostsFileRefreshInterval", 0L);
        DEFAULT_REFRESH_INTERVAL = j10;
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("-Dio.netty.hostsFileRefreshInterval: {}", Long.valueOf(j10));
        }
    }

    public DefaultHostsFileEntriesResolver() {
        this(HostsFileEntriesProvider.parser(), DEFAULT_REFRESH_INTERVAL);
    }

    private static List<InetAddress> allAddresses(List<InetAddress> list, List<InetAddress> list2) {
        ArrayList arrayList = new ArrayList(list.size() + (list2 == null ? 0 : list2.size()));
        arrayList.addAll(list);
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    private void ensureHostsFileEntriesAreFresh() {
        long j10 = this.refreshInterval;
        if (j10 == 0) {
            return;
        }
        long j11 = this.lastRefresh.get();
        long jNanoTime = System.nanoTime();
        if (jNanoTime - j11 <= j10 || !this.lastRefresh.compareAndSet(j11, jNanoTime)) {
            return;
        }
        HostsFileEntriesProvider entries = parseEntries(this.hostsFileParser);
        this.inet4Entries = entries.ipv4Entries();
        this.inet6Entries = entries.ipv6Entries();
    }

    private static InetAddress firstAddress(List<InetAddress> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static HostsFileEntriesProvider parseEntries(HostsFileEntriesProvider.Parser parser) {
        return PlatformDependent.isWindows() ? parser.parseSilently(Charset.defaultCharset(), CharsetUtil.UTF_16, CharsetUtil.UTF_8) : parser.parseSilently();
    }

    @Override // io.netty.resolver.HostsFileEntriesResolver
    public InetAddress address(String str, ResolvedAddressTypes resolvedAddressTypes) {
        return firstAddress(addresses(str, resolvedAddressTypes));
    }

    public List<InetAddress> addresses(String str, ResolvedAddressTypes resolvedAddressTypes) {
        String strNormalize = normalize(str);
        ensureHostsFileEntriesAreFresh();
        int i10 = AnonymousClass1.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes.ordinal()];
        if (i10 == 1) {
            return this.inet4Entries.get(strNormalize);
        }
        if (i10 == 2) {
            return this.inet6Entries.get(strNormalize);
        }
        if (i10 == 3) {
            List<InetAddress> list = this.inet4Entries.get(strNormalize);
            Map<String, List<InetAddress>> map = this.inet6Entries;
            return list != null ? allAddresses(list, map.get(strNormalize)) : map.get(strNormalize);
        }
        if (i10 == 4) {
            List<InetAddress> list2 = this.inet6Entries.get(strNormalize);
            Map<String, List<InetAddress>> map2 = this.inet4Entries;
            return list2 != null ? allAddresses(list2, map2.get(strNormalize)) : map2.get(strNormalize);
        }
        throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
    }

    public String normalize(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }

    public DefaultHostsFileEntriesResolver(HostsFileEntriesProvider.Parser parser, long j10) {
        this.lastRefresh = new AtomicLong(System.nanoTime());
        this.hostsFileParser = parser;
        this.refreshInterval = ObjectUtil.checkPositiveOrZero(j10, "refreshInterval");
        HostsFileEntriesProvider entries = parseEntries(parser);
        this.inet4Entries = entries.ipv4Entries();
        this.inet6Entries = entries.ipv6Entries();
    }
}
