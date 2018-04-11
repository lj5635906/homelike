package com.homelike.common.core.util.sequence;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author PERFECT
 * 分布式序列生成器(线程安全)
 *
 */
public class DistributedSequence implements ISequence,Serializable {
	
	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private Long value;
	private Integer dynamicPartLen;
	private String salt;
	
	/**
	 * 构造序列生成器
	 * @param salt 盐(考虑一个应用部署到多台服务器，每个服务器设置一个salt，则只需要保证每台服务器sequence唯一性)
	 * @param dynamicPartLen dynamicNum长度(如：2，动态数字最大聚会范围01~99)
	 * 		id = yyyyMMddHHmmssSSS + salt + dynamicNum
	 */
	public DistributedSequence(String salt, Integer dynamicPartLen) {
		this.salt = salt;
		this.value = new Long(0L);
		this.dynamicPartLen = dynamicPartLen;
	}
	
	private String fill(String str) {
		if (str == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		for (int i = 0; i < (dynamicPartLen - str.length()); i++) {
			sb.insert(0, "0");
		}
		return sb.toString();
	}
	
	/**
	 * 生成下一个序列号
	 */
	@Override
	public synchronized String next() {
		StringBuilder sb = new StringBuilder();
		value++;
		
		String date = dateFormat.format(new Date());
		sb.append(date);
		sb.append(salt);
		sb.append(fill(value.toString()));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ISequence sequence = new DistributedSequence("0", 3);
		System.out.println(sequence.next());
		System.out.println(sequence.next());
		System.out.println(sequence.next());
	}

}
