package com.demo.util;

import java.util.Random;

public class CommonUtil {
	
	/**
	 * 获取min-max的随机正整数
	 * @param	min		指定下限值
	 * @param	max		指定上限值
	 * @return
	 */
	public static int getRandomNaturalWithMinAndMax(Integer min, Integer max){
		return new Random().nextInt(max - min + 1) + min;
	}
	
	/**
	 * 获取1-max的随机正整数
	 * @param	max		指定上限值
	 * @return
	 */
	public static int getRandomNaturalWithMax(Integer max){
		return new Random().nextInt(max) + 1;
	}
	
	/**
	 * 生成不重复的随机数
	 * @param length	随机数长度
	 * @return String	随机不重复的数
	 */
	public static String generateRandomNumberWithNoConflict(int length) {
		String no = "";
		
		// 初始化备选数组
		int[] defaultNums = new int[10];

		for (int i = 0; i < defaultNums.length; i++) {
			defaultNums[i] = i;
		}
		Random random = new Random();
		int[] nums = new int[length];
		// 默认数组中可以选择的部分长度
		int canBeUsed = 10;
		// 填充目标数组
		for (int i = 0; i < nums.length; i++) {
			// 将随机选取的数字存入目标数组
			int index = random.nextInt(canBeUsed);
			nums[i] = defaultNums[index];
			// 将已用过的数字扔到备选数组最后，并减小可选区域
			swap(index, canBeUsed - 1, defaultNums);
			canBeUsed--;
		}
		if (nums.length > 0) {
			for (int i = 0; i < nums.length; i++) {
				no += nums[i];
			}
		}
		return no;
	}
	
	/**
	 * 交换方法
	 * @param i 交换位置
	 * @param j 互换的位置
	 * @param nums 数组
	 */
	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
