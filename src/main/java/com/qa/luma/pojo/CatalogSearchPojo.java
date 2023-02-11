package com.qa.luma.pojo;

public class CatalogSearchPojo {

	private String searchItem;

	public CatalogSearchPojo(String searchItem) {
		super();
		this.searchItem = searchItem;
	}

	/**
	 * @return the searchItem
	 */
	public String getSearchItem() {
		return searchItem;
	}

	/**
	 * @param searchItem the searchItem to set
	 */
	public void setSearchItem(String searchItem) {
		this.searchItem = searchItem;
	}
}
