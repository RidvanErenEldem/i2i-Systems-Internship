
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
table.GeneratedTable {
  width: 100%;
  background-color: #ffffff;
  border-collapse: collapse;
  border-width: 2px;
  border-color: #000000;
  border-style: solid;
  color: #000000;
}

table.GeneratedTable td, table.GeneratedTable th {
  border-width: 2px;
  border-color: #000000;
  border-style: solid;
  padding: 3px;
}

table.GeneratedTable thead {
  background-color: #ffffff;
}
</style>
<head>
<meta charset="UTF-8">
<title>eee Şey</title>
</head>
<body>
	<form name = "myFrm" action="Index" method="GET">
	<label for="number1">1. Sayı</label>
	<input type = "text" name="number1">
	<br>
	<label for="number2">2. Sayı</label>
	<input type = "text" name="number2"><br><br>
	<table class="GeneratedTable">
  <tbody>
  <tr>
  	<td>İşlem Seçiniz !</td>
  </tr>
    <tr>
      <td>Toplama<input type="radio" name="operation" value="0"></td>
      <td>Çıkarma<input type="radio" name="operation" value="1"></td>
      <td>Çarpma<input type="radio" name="operation" value="2"></td>
      <td>Bölme<input type="radio" name="operation" value="3"></td>
    </tr>
  </tbody>
</table><br><br>
	
	<input type="submit" value="Gönder" name="submit">
	</form>

</body>
</html>