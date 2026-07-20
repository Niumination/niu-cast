package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p6.n;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadLocalRandom extends Random {
    private static final long addend = 11;
    private static volatile long initialSeedUniquifier = 0;
    private static final long mask = 281474976710655L;
    private static final long multiplier = 25214903917L;
    private static volatile long seedGeneratorEndTime = 0;
    private static final long seedGeneratorStartTime;
    private static final Thread seedGeneratorThread;
    private static final BlockingQueue<Long> seedQueue;
    private static final long serialVersionUID = -5851777807851030925L;
    boolean initialized;
    private long pad0;
    private long pad1;
    private long pad2;
    private long pad3;
    private long pad4;
    private long pad5;
    private long pad6;
    private long pad7;
    private long rnd;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ThreadLocalRandom.class);
    private static final AtomicLong seedUniquifier = new AtomicLong();

    static {
        initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0L);
        if (initialSeedUniquifier != 0) {
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0L;
        } else {
            if (!SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false)) {
                initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
                seedGeneratorThread = null;
                seedQueue = null;
                seedGeneratorStartTime = 0L;
                return;
            }
            seedQueue = new LinkedBlockingQueue();
            seedGeneratorStartTime = System.nanoTime();
            Thread thread = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.internal.ThreadLocalRandom.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    byte[] bArrGenerateSeed = new SecureRandom().generateSeed(8);
                    long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                    ThreadLocalRandom.seedQueue.add(Long.valueOf(((((long) bArrGenerateSeed[0]) & 255) << 56) | ((((long) bArrGenerateSeed[1]) & 255) << 48) | ((((long) bArrGenerateSeed[2]) & 255) << 40) | ((((long) bArrGenerateSeed[3]) & 255) << 32) | ((((long) bArrGenerateSeed[4]) & 255) << 24) | ((((long) bArrGenerateSeed[5]) & 255) << 16) | ((((long) bArrGenerateSeed[6]) & 255) << 8) | (((long) bArrGenerateSeed[7]) & 255)));
                }
            };
            seedGeneratorThread = thread;
            thread.setDaemon(true);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.internal.ThreadLocalRandom.2
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th2) {
                    ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread2.getName(), th2);
                }
            });
            thread.start();
        }
    }

    public ThreadLocalRandom() {
        super(newSeed());
        this.initialized = true;
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    public static long getInitialSeedUniquifier() {
        Long lPoll;
        boolean z10;
        long j10 = initialSeedUniquifier;
        if (j10 != 0) {
            return j10;
        }
        synchronized (ThreadLocalRandom.class) {
            try {
                long jLongValue = initialSeedUniquifier;
                if (jLongValue != 0) {
                    return jLongValue;
                }
                long nanos = seedGeneratorStartTime + TimeUnit.SECONDS.toNanos(3L);
                while (true) {
                    long jNanoTime = nanos - System.nanoTime();
                    if (jNanoTime <= 0) {
                        try {
                            lPoll = seedQueue.poll();
                        } catch (InterruptedException unused) {
                            logger.warn("Failed to generate a seed from SecureRandom due to an InterruptedException.");
                            z10 = true;
                        }
                    } else {
                        lPoll = seedQueue.poll(jNanoTime, TimeUnit.NANOSECONDS);
                    }
                    z10 = false;
                    if (lPoll != null) {
                        jLongValue = lPoll.longValue();
                        break;
                    }
                    if (jNanoTime <= 0) {
                        seedGeneratorThread.interrupt();
                        logger.warn("Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?", (Object) 3L);
                        break;
                    }
                }
                long jReverse = (jLongValue ^ 3627065505421648153L) ^ Long.reverse(System.nanoTime());
                initialSeedUniquifier = jReverse;
                if (z10) {
                    Thread.currentThread().interrupt();
                    seedGeneratorThread.interrupt();
                }
                if (seedGeneratorEndTime == 0) {
                    seedGeneratorEndTime = System.nanoTime();
                }
                return jReverse;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static long mix64(long j10) {
        long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
        long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
        return j12 ^ (j12 >>> 33);
    }

    private static long newSeed() {
        AtomicLong atomicLong;
        long j10;
        long initialSeedUniquifier2;
        long j11;
        do {
            atomicLong = seedUniquifier;
            j10 = atomicLong.get();
            initialSeedUniquifier2 = j10 != 0 ? j10 : getInitialSeedUniquifier();
            j11 = 181783497276652981L * initialSeedUniquifier2;
        } while (!atomicLong.compareAndSet(j10, j11));
        if (j10 == 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                if (seedGeneratorEndTime != 0) {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", Long.valueOf(initialSeedUniquifier2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime))));
                } else {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", Long.valueOf(initialSeedUniquifier2)));
                }
            }
        }
        return System.nanoTime() ^ j11;
    }

    public static void setInitialSeedUniquifier(long j10) {
        initialSeedUniquifier = j10;
    }

    @Override // java.util.Random
    public int next(int i10) {
        long j10 = ((this.rnd * multiplier) + addend) & mask;
        this.rnd = j10;
        return (int) (j10 >>> (48 - i10));
    }

    public double nextDouble(double d10) {
        ObjectUtil.checkPositive(d10, n.f13005a);
        return nextDouble() * d10;
    }

    public int nextInt(int i10, int i11) {
        if (i10 < i11) {
            return nextInt(i11 - i10) + i10;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j10) {
        ObjectUtil.checkPositive(j10, n.f13005a);
        long j11 = 0;
        while (j10 >= 2147483647L) {
            int next = next(2);
            long j12 = j10 >>> 1;
            if ((next & 2) != 0) {
                j12 = j10 - j12;
            }
            if ((next & 1) == 0) {
                j11 = (j10 - j12) + j11;
            }
            j10 = j12;
        }
        return j11 + ((long) nextInt((int) j10));
    }

    @Override // java.util.Random
    public void setSeed(long j10) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
        this.rnd = (j10 ^ multiplier) & mask;
    }

    public double nextDouble(double d10, double d11) {
        if (d10 < d11) {
            return ((d11 - d10) * nextDouble()) + d10;
        }
        throw new IllegalArgumentException();
    }

    public long nextLong(long j10, long j11) {
        if (j10 < j11) {
            return nextLong(j11 - j10) + j10;
        }
        throw new IllegalArgumentException();
    }
}
