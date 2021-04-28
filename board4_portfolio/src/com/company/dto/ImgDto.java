package com.company.dto;

public class ImgDto {
   private String name;
   private String info;
   private int price;
   private String img;
   private String cpu;
   private String gpu;
public ImgDto() {
	super();
	// TODO Auto-generated constructor stub
}
public ImgDto(String name, String info, int price, String img, String cpu, String gpu) {
	super();
	this.name = name;
	this.info = info;
	this.price = price;
	this.img = img;
	this.cpu = cpu;
	this.gpu = gpu;
}


@Override
public String toString() {
	return "ImgDto [name=" + name + ", info=" + info + ", price=" + price + ", img=" + img + ", cpu=" + cpu + ", gpu="
			+ gpu + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getCpu() {
	return cpu;
}
public void setCpu(String cpu) {
	this.cpu = cpu;
}
public String getGpu() {
	return gpu;
}
public void setGpu(String gpu) {
	this.gpu = gpu;
}

   
   
}
