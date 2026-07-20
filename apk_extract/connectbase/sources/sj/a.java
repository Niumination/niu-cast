package sj;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends m {
    a atKey(String str);

    a atPath(String str);

    void checkValid(a aVar, String... strArr);

    Set<Map.Entry<String, x>> entrySet();

    Object getAnyRef(String str);

    List<? extends Object> getAnyRefList(String str);

    boolean getBoolean(String str);

    List<Boolean> getBooleanList(String str);

    Long getBytes(String str);

    List<Long> getBytesList(String str);

    a getConfig(String str);

    List<? extends a> getConfigList(String str);

    double getDouble(String str);

    List<Double> getDoubleList(String str);

    long getDuration(String str, TimeUnit timeUnit);

    Duration getDuration(String str);

    List<Duration> getDurationList(String str);

    List<Long> getDurationList(String str, TimeUnit timeUnit);

    <T extends Enum<T>> T getEnum(Class<T> cls, String str);

    <T extends Enum<T>> List<T> getEnumList(Class<T> cls, String str);

    int getInt(String str);

    List<Integer> getIntList(String str);

    boolean getIsNull(String str);

    j getList(String str);

    long getLong(String str);

    List<Long> getLongList(String str);

    l getMemorySize(String str);

    List<l> getMemorySizeList(String str);

    @Deprecated
    Long getMilliseconds(String str);

    @Deprecated
    List<Long> getMillisecondsList(String str);

    @Deprecated
    Long getNanoseconds(String str);

    @Deprecated
    List<Long> getNanosecondsList(String str);

    Number getNumber(String str);

    List<Number> getNumberList(String str);

    n getObject(String str);

    List<? extends n> getObjectList(String str);

    Period getPeriod(String str);

    String getString(String str);

    List<String> getStringList(String str);

    TemporalAmount getTemporal(String str);

    x getValue(String str);

    boolean hasPath(String str);

    boolean hasPathOrNull(String str);

    boolean isEmpty();

    boolean isResolved();

    o origin();

    a resolve();

    a resolve(t tVar);

    a resolveWith(a aVar);

    a resolveWith(a aVar, t tVar);

    n root();

    @Override // sj.m
    a withFallback(m mVar);

    a withOnlyPath(String str);

    a withValue(String str, x xVar);

    a withoutPath(String str);
}
