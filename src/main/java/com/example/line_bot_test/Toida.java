
package com.example.line_bot_test;

import java.util.Arrays;
import java.util.List;

public class Toida{

	public static String toidafy(String target){
		int len = target.length();

		// バリデーション
		if(len == 1){
			return target + "って、これ以上略せないやないか！！";
		}

		List<String> targetList = Arrays.asList(target.split(""));
		String result = "";

		double omitRatio = Math.random();

		for(int i = 0; i < len; i ++){
			result += (Math.random()>omitRatio) ? targetList.get(i) : "";

			// 最後に空白だったら一文字は残す
			if(result.isEmpty() && i == len - 1){
				result = targetList.get((int)Math.random()*len);
			}
		}

		return result;
	}
}