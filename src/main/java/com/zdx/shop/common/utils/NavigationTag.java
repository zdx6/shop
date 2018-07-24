package com.zdx.shop.common.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class NavigationTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String bean = "page";
	private String url = null;
	private int number = 5;

	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		@SuppressWarnings("rawtypes")
		Page page = (Page) request.getAttribute(bean);
		if (page == null)
			return SKIP_BODY;
		url = resolveUrl(url, pageContext);
		try {
			int pageCount = page.getTotal() / page.getSize();
			if (page.getTotal() % page.getSize() > 0) {
				pageCount++;
			}
			writer.print("<nav><ul class=\"pagination\">");
			String homeUrl = append(url, "pageNo", 1);
			String backUrl = append(url, "pageNo", pageCount);
			if (page.getPageNo() > 1) {
				String preUrl = append(url, "pageNo", page.getPageNo() - 1);
				preUrl = append(preUrl, "size", page.getSize());
				writer.print("<li class=''><a href=\"" + homeUrl + "\">"
						+ "首页</a></li>");
				writer.print("<li class=''><a href=\"" + preUrl + "\">"
						+ "上一页</a></li>");
			}
			int indexPage = 1;
			if (pageCount <= number) {
				indexPage = 1;
			} else if (page.getPageNo() - 2 <= 0) {
				indexPage = 1;
			} else if (pageCount - page.getPageNo() <= 2) {
				indexPage = pageCount - 4;
			} else {
				indexPage = page.getPageNo() - 2;
			}
			for (int i = 1; i <= number && indexPage <= pageCount; indexPage++, i++) {
				if (indexPage == page.getPageNo()) {
					writer.print("<li class='active'><a href='#'>" + indexPage
							+ "<span class'sr-only'></span></a></li>");
					continue;
				}
				String pageUrl = append(url, "pageNo", indexPage);
				pageUrl = append(pageUrl, "size", page.getSize());
				writer.print("<li class=''><a href='" + pageUrl + "'>"
						+ indexPage + "</a></li>");
			}
			if (page.getPageNo() < pageCount) {
				String nextUrl = append(url, "pageNo", page.getPageNo() + 1);
				nextUrl = append(nextUrl, "size", page.getSize());
				writer.print("<li class=''><a href='" + nextUrl + "'>"
						+ "下一页</a></li>");
				writer.print("<li class=''><a href='" + backUrl + "'>"
						+ "尾页</a></li>");
			} else {
				writer.print("<li class='disabled'><a href='#'>"
						+ "下一页</a></li>");
				writer.print("<li class='disabled'><a href='#'>"
						+ "尾页</a></li>");
			}
			writer.print("</ul></nav>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String append(String url, String key, int value) {
		return append(url, key, String.valueOf(value));
	}

	private String append(String url, String key, String value) {
		if (url == null || url.trim().length() == 0) {
			return "";
		}
		if (url.indexOf("?") == -1) {
			url = url + "?" + key + "=" + value;
		} else {
			if (url.endsWith("?")) {
				url = url + key + "=" + value;
			} else {
				url = url + "&amp;" + key + "=" + value;
			}
		}
		return url;
	}

	private String resolveUrl(String url, PageContext pageContext)
			throws JspException {
		ServletRequest request = pageContext.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			String[] value = params.get(key);
			if (key.equals("pageNo") || key.equals("size")) {
				continue;
			}
			url=append(url, key, value[0]);
		}
		return url;
	}

	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
