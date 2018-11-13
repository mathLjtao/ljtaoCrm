<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var arrayNation = new Array('汉族','蒙古族','彝族','侗族','哈萨克族');
	var arrayDegree = new Array('小学','初中','高中','中专','大专','本科','硕士','博士');
	
	function createSelect(name, str){
		var _select = document.createElement("select");
		var firstOption = document.createElement("option");
		firstOption.value = "------select------";
		firstOption.text = "------请选择------";
		_select.appendChild(firstOption);
		for ( i = 0; i < str.length; i++){
			var _option = document.createElement("option");
			_option.value = str[i];
			_option.text = str[i];
			if (name == str[i]){
				_option.selected = "true";
			}
			_select.appendChild(_option);
		}
		return _select;
	}
</script>
<body>
	<div id="nation">民族：</div>
	<div id="degree">学历：</div>
	<div id="degree2">学历2：</div>
	<input  type="button" value="添加" id="addBtn" onclick="addClick()">
</body>

<script>
		document.getElementById("nation").appendChild(createSelect('侗族', arrayNation));
		document.getElementById("degree").appendChild(createSelect('初中', arrayDegree));
		function addClick(){
			document.getElementById("degree2").appendChild(createSelect('初中', arrayDegree));
			}
	</script>


</html>