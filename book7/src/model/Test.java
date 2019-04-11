package model;

import model.Products;
public class Test {
	public static void main(String[] args) throws Exception {
		String className="model.Products";
		Class<?> clz = Class.forName(className);
		Object newInstance = clz.newInstance();
		System.out.println(newInstance);
	}
}
