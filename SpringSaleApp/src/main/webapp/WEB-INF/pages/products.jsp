<%-- 
    Document   : products
    Created on : Jul 20, 2024, 1:57:03 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-primary mt-1">QUẢN TRỊ SẢN PHẨM</h1>

<c:url value="/products" var="action"/>
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    
    <form:errors path="*" element="div" cssClass="alert alert-danger"></form:errors>
    
    
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Tên sản phẩm:</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter email" name="name" />
    </div>
    <div class="mb-3 mt-3">
        <label for="price" class="form-label">Giá sản phẩm:</label>
        <form:input path="price" type="number" class="form-control" id="price" placeholder="Giá sản phẩm" name="price" />
    </div>
    <div class="mb-3 mt-3">
        <label for="cate" class="form-label">Danh mục sản phẩm:</label>
        <form:select path="categoryId" id="cate" class="form-select">
            <c:forEach items="${cates}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh sản phẩm:</label>
        <form:input path="price" accept=".png,.jpg" type="file" class="form-control" id="file" placeholder="Ảnh sản phẩm" name="file" />
    </div>
    <div class="mb-3 mt-3">
        <button type="submit" class="btn btn-success">Thêm sản phẩm</button>
    </div>
</form:form>
