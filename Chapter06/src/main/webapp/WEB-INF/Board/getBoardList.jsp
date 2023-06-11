<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html Public "-//W3C//DTD HTML 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
						
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�۸��</title>
</head>
<body>
<center>�Խñ� ���
<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<th bgcolor="orange" width="100">��ȣ</th>
		<th bgcolor="orange" width="200">����</th>
		<th bgcolor="orange" width="150">�ۼ���</th>
		<th bgcolor="orange" width="150">�����</th>
		<th bgcolor="orange" width="100">��ȸ��</th>
	</tr>
	<c:forEach items="${boardList }" var="board">
	<tr>
		<td>${board.seq}</td>
		<td align="left"><a href="getBoard?seq=${board.seq }">${board.title }</a></td>
		<td>${board.writer }</td>
		<td><fmt:formatDate value="${board.createDate }" 
			pattern="yyyy-MM-dd"></fmt:formatDate></td>
		<td>${board.cnt }</td>	
	</tr>				
	</c:forEach>

</table>
<br>
<a href="insertBoard">���� ���</a>
</center>
</body>
</html>