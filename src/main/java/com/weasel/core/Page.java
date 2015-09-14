package com.weasel.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.weasel.core.helper.DemonPredict;

/**
 * 在很多应用场景中，我们都需要分页查询，因为数据量原因，或者我们并不关心所有的数据。Page对象用于分布查询场景，里面定义了一些分页查询所需的信息。
 * @author Dylan
 * @time 下午3:55:10
 */
public class Page<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * the number of very page
	 */
	private int pageSize = 20;
	
	/**
	 * which page we hold now
	 */
	private int currentPage = 1;
	
	/**
	 * how many pages we will get
	 */
	private int totalPages = 0;
	
	/**
	 * how many counts we will get
	 */
	private int totalCount=0;
	
	/**
	 * count the total number or not
	 */
	private boolean totalCountAble = true;
	
	/**
	 * the query result,what we want to get
	 */
	private List<T> result = new ArrayList<T>();
	/**
	 * the params for query
	 */
	private Map<String,Object> params = new LinkedHashMap<String, Object>();
	
    private Map<String,Sort> sorts = new LinkedHashMap<String,Sort>();

	public int getPageSize() {
		return pageSize;
	}

	public Page<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public Page<T> setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		return this;
	}

	public int getNextPage() {
		if(hasNextPage())
			return ++currentPage;
		return currentPage;
	}

	public int getPrePage() {
		if(hasPrePage())
			return --currentPage;
		return currentPage;
	}

	
	public int getTotalPages() {
		int pageSize = getPageSize();
		DemonPredict.isTrue(pageSize>0,"pageSize must > 0");
		int totalCount = getTotalCount();
		int totalPages = totalCount/pageSize;
		if((totalCount%pageSize)>0)
			++totalPages;
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public  int getFirstPage(){
		currentPage=1;
		return currentPage;
	}
	public int getFirst() {
		return ((currentPage - 1) * pageSize) + 1;
	}
	
	public int getLastPage(){
		currentPage=getTotalPages();
		return currentPage;
	}
	
	public boolean hasPrePage(){
		return currentPage>1;
	}
	
	public boolean hasNextPage(){
		return totalPages>currentPage;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public Page<T> setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		return this;
	}


	public List<T> getResult() {
		return result;
	}

	public Page<T> setResult(List<T> result) {
		this.result = result;
		return this;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public Page<T> setParams(Map<String, Object> params) {
		this.params = params;
		return this;
	}
	
	public Page<T> addParam(String key,Object value){
		params.put(key, value);
		return this;
	}
	
	public Page<T> addParams(Map<String,Object> params){
		params.putAll(params);
		return this;
	}
	
	/**
	 * @return
	 */
	 public boolean isTotalCountAble() {
		return totalCountAble;
	}
	 /**
	  * @param totalCountAble
	  */
	public void setTotalCountAble(boolean totalCountAble) {
		this.totalCountAble = totalCountAble;
	}
	
	/**
	 * calculate how much result this query
	 * @return
	 */
	public Page<T> calculateTotalNumber(){
		setTotalCountAble(true);
		return this;
	}
	/**
	 * no calculate how much result this query
	 * @return
	 */
	public Page<T> notCalculateTotalNumber(){
		setTotalCountAble(false);
		return this;
	}
	
	/**
	 * @return
	 */
	public static <T> Page<T> newPage(){
		return new Page<T>();
	}

	/**
     * 
     * @return
     */
    public Map<String, Sort> getSorts() {
		return sorts;
	}
	
	  /**
     * @param sorts
     */
	public Page<T> setSorts(Map<String, Sort> sorts) {
		this.sorts = sorts;
		return this;
	}
	
	public Page<T> addSorts(String field,Sort sort){
		this.sorts.put(field, sort);
		return this;
	}

	/**
     * @author Dylan
     *
     */
    public enum Sort{
    	ASC("asc"),DESC("desc");
    	
    	private String sort="desc";
    	
    	private Sort(String sort){
    		this.sort = sort;
    	}
    	
    	public String sort(){
    		return sort;
    	}
    }
	
}
