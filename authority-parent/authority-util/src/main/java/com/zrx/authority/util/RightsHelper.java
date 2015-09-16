/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zrx.authority.util;

import java.math.BigInteger;

/**
 * <p>Description  :</p>
 * <p>Title  :</p>
 * @author 张日雄 <your.name at your.org>
 * @data 2015-9-5,12:53:48
 * @version 1.0
 */
public class RightsHelper {
	/**
	 * 利用BigInteger对权限进行2的权的和计算
	 * 
	 * @param rights int型权限编码数组
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(int[] rights) {
		BigInteger num = new BigInteger("0");
		for (int i = 0; i < rights.length; i++) {
			num = num.setBit(rights[i]);
		}
		return num;
	}

	/**
	 * 利用BigInteger对权限进行2的权的和计算
	 * 
	 * @param rights String型权限编码数组
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(String[] rights) {
		BigInteger num = new BigInteger("0");
		for (int i = 0; i < rights.length; i++) {
			num = num.setBit(Integer.parseInt(rights[i]));
		}
		return num;
	}

	/**
	 * 测试是否具有指定编码的权限
	 * 
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum, int targetRights) {
		return sum.testBit(targetRights);
	}

	/**
	 * 测试是否具有指定编码的权限
	 * 
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum, int targetRights) {
		if (Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum), targetRights);
	}

	/**
	 * 测试是否具有指定编码的权限
	 * 
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum, String targetRights) {
		if (Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum), targetRights);
	}

	/**
	 * 测试是否具有指定编码的权限
	 * 
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum, String targetRights) {
		return testRights(sum, Integer.parseInt(targetRights));
	}
}
