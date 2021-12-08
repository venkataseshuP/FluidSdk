package com.asolutions.FluidWeb.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DesignerTypeProperties {

	@EmbeddedId
	private TypesrepoPK id;
	private Boolean label;
	private String align;
	private String labelAlign;
	private String name;
	private String width;
	private String placeholder;
	private Boolean readonly;
	private Boolean mandatory;
	private String customcss;
	private String color;
	private int fontSize;
	private int fontWeight;
	private String fontStyle;
	private String fontWeightDesc;
	private Boolean openMenu;
	private String height;
	
	public TypesrepoPK getId() {
		return id;
	}
	public void setId(TypesrepoPK id) {
		this.id = id;
	}
	public Boolean getLabel() {
		return label;
	}
	public void setLabel(Boolean label) {
		this.label = label;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getLabelAlign() {
		return labelAlign;
	}
	public void setLabelAlign(String labelAlign) {
		this.labelAlign = labelAlign;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public Boolean getReadonly() {
		return readonly;
	}
	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}
	public Boolean getMandatory() {
		return mandatory;
	}
	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}
	public String getCustomcss() {
		return customcss;
	}
	public void setCustomcss(String customcss) {
		this.customcss = customcss;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public int getFontWeight() {
		return fontWeight;
	}
	public void setFontWeight(int fontWeight) {
		this.fontWeight = fontWeight;
	}
	public String getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}
	public String getFontWeightDesc() {
		return fontWeightDesc;
	}
	public void setFontWeightDesc(String fontWeightDesc) {
		this.fontWeightDesc = fontWeightDesc;
	}
	public Boolean getOpenMenu() {
		return openMenu;
	}
	public void setOpenMenu(Boolean openMenu) {
		this.openMenu = openMenu;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
}
