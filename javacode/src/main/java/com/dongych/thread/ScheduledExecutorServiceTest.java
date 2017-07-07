package com.dongych.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledExecutorServiceTest {

	public void testThread() {
		// 初始化ScheculeExecutorService
		ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors(),
				new ThreadFactory() {
					private static final String THREAD_NAME_PATTERN = "%s-%d";
					private final AtomicInteger counter = new AtomicInteger();

					public Thread newThread(Runnable r) {
						final String threadName = String.format(THREAD_NAME_PATTERN, "dongych-loader",
								counter.incrementAndGet());
						Thread t = new Thread(r, threadName);
						return t;
					}
				});
		service.scheduleAtFixedRate(new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}, 3, 1, TimeUnit.SECONDS);
	}

	public static void main(String[] s) {
		new ScheduledExecutorServiceTest().testThread();
	}

}
