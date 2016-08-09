package com.sds.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;




public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("m1", "»ç°ú");
		map.put("m2", "µþ±â");
		map.put("m3", "¿À·»Áö");
		map.put("m4", "¸á·Ð");
		
		String name = map.get("m3");
		System.out.println("name");
		
		Set<String> set = map.keySet();//¸í´Ü¸¸ º¸À¯ÇÑ set
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			String key=it.next();
			String fruit = map.get(key);
			
			System.out.println(fruit);
			
		}
	}

}
