package Model;

import annotation.AOP;

public class Flamingo implements Bird{

	@AOP(name = "火烈鸟22")
	private String name;
	
	@AOP(name = "线线果实22")
	private String property;
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setProperty(String property) {
		this.property = property;
	}

	@Override
	public String getProperty() {
		return this.property;
	}

	@Override
	public String fly() {
		System.out.println(this.name + this.property);
		return "---";
	}
}
