<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<canvas id="myCanvas" width="200" height="100" style="border:1px solid #000000;">
	</canvas>
	<script type="text/javascript">
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		ctx.fillStyle = "#FF0000";
		ctx.fillRect(0,0,150,75);
		ctx.moveTo(0,0);
		ctx.lineTo(200,100);
		ctx.stroke(); 
	</script>
</html> 