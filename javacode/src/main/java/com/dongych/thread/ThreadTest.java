package com.dongych.thread;

public class ThreadTest {

	public static void test0() {
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

	public static void test1() {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		});
		t.start();
	}

	public static void main(String[] args) {
		ThreadTest.test1();
	}

}
