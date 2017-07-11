package com.dongych.collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class StringLen implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int len = o1.length() - o2.length();
		return len == 0 ? o1.compareTo(o2) : len;
	}
}

public class SetTest {
	public static void test7() {
		// Set<String> set = new TreeSet<String>();
		Set<String> set = new TreeSet<String>(new StringLen());
		set.add("sdf");
		set.add("adf");
		set.add("gsdw");
		set.add("wgssd");
		System.out.println(set); // 默认比较器
	}

	public static void test7_inner() {
		// Set<String> set = new TreeSet<String>();
		Set<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int len = o1.length() - o2.length();
				return len == 0 ? o1.compareTo(o2) : len;
			}
		});
		set.add("sdf");
		set.add("adf");
		set.add("gsdw");
		set.add("wgssd");
		System.out.println(set); // 默认比较器
	}

	public static void test8() {
		Set<String> set = new TreeSet<String>((o1, o2) -> {
			int len = o1.length() - o2.length();
			return len == 0 ? o1.compareTo(o2) : len;
		});
		set.add("sdf");
		set.add("adf");
		set.add("gsdw");
		set.add("wgssd");
		System.out.println(set); //
	}

	public static void main(String[] args) {
		SetTest.test8();
	}

}
