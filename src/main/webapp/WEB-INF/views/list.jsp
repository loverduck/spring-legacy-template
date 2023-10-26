<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<h1>상품 리스트</h1>
		<table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">제품 코드</th>
                <th scope="col">모델명</th>
                <th scope="col">가격</th>
                <th scope="col">등록인 아이디</th>
              </tr>
            </thead>
            <tbody>    
				<c:forEach var="product" items="${products}">    
	              <tr class="text-center">
	                <th scope="row">${product.code}</th>
	                <td class="text-start">
	                  <a
	                    href="#"
	                    class="article-title link-dark"
	                    data-no="${product.code}"
	                    style="text-decoration: none"
	                  >
	                    ${product.model}
	                  </a>
	                </td>
	                <td>${product.price}</td>
	                <td>${product.id}</td>
	              </tr>            
				</c:forEach>   
            </tbody>
          </table>
	</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>