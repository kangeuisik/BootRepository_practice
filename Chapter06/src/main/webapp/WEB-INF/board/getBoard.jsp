<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html Public "-//W3C//DTD HTML 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
						
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>�۸��</title>
</head>
<body>
<center>
<h1>�Խñ� ��</h1>
<hr>
<form action="updateBoard" method="post">
	<input type="hidden" name="seq" value="${board.seq }">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">����</td>
			<td align="left"> <input type="text" name="title" value="${board.title }"> </td>
		</tr>
		<tr>
			<td bgcolor="orange">�ۼ���</td>
			<td align="left">${board.writer }</td>
		</tr>
		<tr>
			<td bgcolor="orange">����</td>
			<td align="left"> <textarea rows="40" cols="10" name="content">${board.content }</textarea> </td>
		</tr>
		<tr>
			<td bgcolor="orange">�����</td>
			<td align="left"> <fmt:formatDate value="${board.createDate }" 
				pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		<tr>
			<td bgcolor="orange">��ȸ��</td>
			<td align="left">${board.cnt }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="�� ����"> </td>
		</tr>	
	</table>
</form>
<hr>
<a href="insertBoardView">�۵��</a>
<a href="deleteBoard?seq=${board.seq }">�ۻ���</a>
<a href="getBoardList">�۸��</a>
</center>
</body>
</html>