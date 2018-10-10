<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
    function handleEnter(field, event) {
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which
                : event.charCode;
        if (keyCode == 13) {
            var i;
            for (i = 0; i < field.form.elements.length; i++)
                if (field == field.form.elements[i])
                    break;
            i = (i + 1) % field.form.elements.length;
            field.form.elements[i].focus();
            return false;
        } else
            return true;
    }
</script>
</head>
<body>
<form action="1.html" method="post">
1.<input type="text" onkeypress="return handleEnter(this, event)">
2.<input type="text" onkeypress="return handleEnter(this, event)">
3.<input type="text" onkeypress="return handleEnter(this, event)">
4.<input type="text" onkeypress="return handleEnter(this, event)">
5.<input type="text" onkeypress="return handleEnter(this, event)">
6.<input type="text" onkeypress="return handleEnter(this, event)">
<input type="submit" value="提交" >
</form>
</body>
</html>