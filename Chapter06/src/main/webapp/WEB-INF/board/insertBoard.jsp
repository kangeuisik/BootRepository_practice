<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html Public "-//W3C//DTD HTML 4.01 Transitional//EN"
						"http://www.w3.org/TR/html4/loose.dtd">
						
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<center>
<h3>�� ����ϱ�</h3>
<hr>
<form action="insertBoard" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange" width="70">������</td>
			<td align="left"> <input type="text" name="title"/> </td>
		</tr>
		<tr>
			<td bgcolor="orange">�ۼ���</td>
			<td align="left"> <input type="text" name="writer" size="10"/> </td>
		</tr>
		<tr>
			<td bgcolor="orange">����</td>
			<td align="left"> <textarea rows="40" cols="10" name="content"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">�۾���</td>
			<td align="left"> <input type="submit" value="���� ���"/> </td>
		</tr>
	</table>


</form>
<a href="insertBoard">���� ���</a>
</center>
</body>
</html>